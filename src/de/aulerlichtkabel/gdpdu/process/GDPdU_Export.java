/*****************************************************************************
 * Plug-in GdPdU-Export for iDempiere ERP & CRM Smart Business Solution      *
 * Copyright (C) 2016  Patric Maßing (Hans Auler GmbH)                       *
 *                                                                           *
 * This plug-in is free software; you can redistribute it and/or modify      *
 * it under the terms of the GNU General Public License as published by      *
 * the Free Software Foundation; either version 2 of the License, or         *
 * (at your option) any later version.                                       *
 *                                                                           *
 * This plug-in is distributed in the hope that it will be useful,           *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of            *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the             *
 * GNU General Public License for more details.                              *
 *                                                                           *
 * You should have received a copy of the GNU General Public License along   *
 * with this plug-in; If not, see <http://www.gnu.org/licenses/>.            *
 ****************************************************************************/
 
 /**
  * @author Patric Maßing (Hans Auler GmbH)
  * 2016
 */


package de.aulerlichtkabel.gdpdu.process;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import de.aulerlichtkabel.gdpdu.xml.model.DataSet;



public class GDPdU_Export extends SvrProcess {

	/** Org Parameter */
	private int p_AD_Org_ID = 0;
	
	private int p_AD_Client_ID = 0;
	
	private int p_PAT_GDPdU_ID = 0;
	
	private String FOLDER = "gdpdu_export";

	private DataSet dataset = null;
	
	/**
	 * Prepare - e.g., get Parameters.
	 */
	protected void prepare() {

		// Prepare Process

		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("AD_Client_ID"))
				p_AD_Client_ID = para[i].getParameterAsInt();
			else if (name.equals("AD_Org_ID"))
				p_AD_Org_ID = para[i].getParameterAsInt();
			else if (name.equals("PAT_GDPdU_ID"))
				p_PAT_GDPdU_ID = para[i].getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}

	} // prepare

	/**
	 * Process
	 *
	 * @return message
	 * @throws Exception
	 */
	protected String doIt() throws Exception {

		if (log.isLoggable(Level.INFO))
			log.info("");

		dataset = new DataSet(getCtx(), p_PAT_GDPdU_ID, get_TrxName());

		StringBuilder foldername = new StringBuilder();

		if (!(foldername.append(createTempFolder(FOLDER)).equals("")))
			dataset.fillMedia(foldername.toString());

		try (OutputStream xmloutput = new FileOutputStream(new File(
				foldername.toString() + "index.xml"))) {

			JAXBContext context = JAXBContext.newInstance(DataSet.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.setProperty("jaxb.fragment", true);
			m.setProperty("com.sun.xml.bind.xmlHeaders",
					"﻿<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+ "\n"
					+ "<!DOCTYPE DataSet SYSTEM \"gdpdu-01-09-2004.dtd\">");
			
			m.marshal(dataset, xmloutput);

		}

		createZipFile(foldername.toString());
		File file = new File(
				foldername.delete(foldername.lastIndexOf(FOLDER),
						foldername.capacity()) + "gdpdu.zip");
		if (file.exists() && file.isFile() && file.canRead()) {
			if (processUI != null)
				;
			processUI.download(file);
		}else{
			throw new AdempiereException("Export could not been saved!");			
		}
			
		//
		StringBuilder msgreturn = new StringBuilder(Msg.translate(Env.getCtx(), "Export finished") + "\n");
		msgreturn.append(Msg.translate(Env.getCtx(), "Filesize") + ": ");
		msgreturn.append(file.getTotalSpace());
		return msgreturn.toString();

	} // doIt

	
	public String createTempFolder(String foldername){
		
	    File tempfolder;
	    Boolean isCreated = false;
		try {
			tempfolder = File.createTempFile(foldername, "_");
		    tempfolder.delete();
		    isCreated = tempfolder.mkdir();
		} catch (IOException ioe) {
			throw new AdempiereException("error on creating the temporary folder", ioe);
		}
		
		return isCreated ? tempfolder.getPath()+File.separator : "";
		
	}
	
	
	public void createZipFile(String foldername){

		try {

			File folder = new File(foldername);

			File zipFile = new File(folder.getParent() + File.separator
					+ "gdpdu.zip");

			zipFile.createNewFile();

			ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(
					zipFile));
			zipOut.setMethod(ZipOutputStream.DEFLATED);
			zipOut.setLevel(Deflater.BEST_COMPRESSION);
			zipOut.setComment("GDPdU-Export");

			for (File file : folder.listFiles()) {

				ZipEntry zipEntry = new ZipEntry(file.getName());
				zipEntry.setMethod(ZipEntry.DEFLATED);
				zipOut.putNextEntry(zipEntry);
				InputStream in = new FileInputStream(file);

				byte[] buffer = new byte[1];

				while (in.read(buffer) != -1)
					zipOut.write(buffer, 0, buffer.length);

				in.close();

				zipOut.closeEntry();

			}

			zipOut.flush();
			zipOut.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}		

}
