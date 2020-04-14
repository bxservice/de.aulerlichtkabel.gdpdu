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


package de.aulerlichtkabel.gdpdu.xml.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAttachment;
import org.compiere.model.MAttachmentEntry;
import org.compiere.model.MClient;
import org.compiere.util.Env;

import de.aulerlichtkabel.gdpdu.model.MPAT_GDPdU;


@XmlRootElement(name="DataSet")
@XmlType( propOrder = {"version", "dataSupplier", "media"})
public class DataSet {


	
	private int pat_GDPdU_ID;
	private String trxName;
	
	
	@XmlElement(name="Version")
	private String version = null;

	@XmlElement(name="DataSupplier")
	DataSupplier dataSupplier = new DataSupplier();
	

	private Media media = null;
	

	Integer mediaNo = Integer.valueOf(1);
	
	
	public DataSet(Properties ctx, int pat_GDPdU_ID, String trxName) {

		this.pat_GDPdU_ID = pat_GDPdU_ID;
		
	}

	public DataSet(){
		
		
	}

	/**
	 * @return the media
	 */
	@XmlElement(name="Media")
	public Media getMedia() {
		return media;
	}

	/**
	 * @param media the media to set
	 */
	public void setMedia() {
		this.media = new Media();
	}
	
	public void fillMedia(String p_PathDictionary, int AD_Org_ID) {

		MPAT_GDPdU pat_gdpdu = new MPAT_GDPdU(Env.getCtx(),pat_GDPdU_ID,null);
		
		MAttachment attachment = pat_gdpdu.getAttachment();

		if(attachment == null)
			throw new AdempiereException("DTD-File not found! Please attach the DTD-File.");
		
		MAttachmentEntry attachmentEntry = attachment.getEntry(0);
		
		File dtdFile = attachmentEntry.getFile();
		
		try {

			File destFile = new File(p_PathDictionary+ dtdFile.getName());
			Files.move(dtdFile.toPath(), destFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		MClient client = new MClient(Env.getCtx(), pat_gdpdu.getAD_Client_ID(), trxName);
		dataSupplier.setName(cleanTranslation(client.getName()));		
		
		dataSupplier.setLocation(cleanTranslation(pat_gdpdu.getC_Location().getCity()));
		
		dataSupplier.setComment(cleanTranslation(pat_gdpdu.getDescription()));

		version = pat_gdpdu.getVersion();


		setMedia();
		media.setName(pat_gdpdu.getDescription()+mediaNo.toString());

		try {
			media.fillList(pat_GDPdU_ID, AD_Org_ID, p_PathDictionary);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	
	public String cleanTranslation(String translation) {

		return translation.replaceAll("Ü", "Ue").replaceAll("Ä", "Ae")
				.replaceAll("Ö", "Oe").replaceAll("ü", "ue")
				.replaceAll("ä", "ae").replaceAll("ö", "oe")
				.replaceAll("ß", "ss").replaceAll("\"", "&quot;")
				.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");

	}
	

}
