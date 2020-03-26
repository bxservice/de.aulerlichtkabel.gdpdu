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

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipException;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.Env;

import de.aulerlichtkabel.gdpdu.model.MPAT_GDPdU;
import de.aulerlichtkabel.gdpdu.model.MPAT_GDPdU_Export_Def;

@XmlType(propOrder = { "name", "command", "tableList"})
public class Media {

	private String name = null;

	@XmlElement(name = "Table")
	private List<Table> tableList = new ArrayList<Table>();

	private String command = null;
	


	public Media() {

	}

	@XmlElement(name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public void fillList(int pat_GDPdU_ID, String p_PathDictionary) throws ZipException, IOException {

		MPAT_GDPdU pat_gdpdu = new Query(Env.getCtx(), MPAT_GDPdU.Table_Name, "pat_gdpdu_id=?",
				null).setParameters(pat_GDPdU_ID).first();

		
		if (pat_gdpdu != null) {
			

				for (MPAT_GDPdU_Export_Def tableDef : pat_gdpdu
						.getGDPdU_Export_DefLines(pat_GDPdU_ID)) {

					Table table = new Table();

					MTable tbl = MTable.get(Env.getCtx(), tableDef.getAD_Table_ID());

					StringBuilder tableNameTranslation = new StringBuilder();

					if (tbl != null) {

						if (tbl.get_Translation(MTable.COLUMNNAME_Name) != null) {

							table.setName(cleanTranslation(tbl
									.get_Translation(MTable.COLUMNNAME_Name)));
							table.setURL(cleanTranslation(tbl
									.get_Translation(MTable.COLUMNNAME_Name)
									+ ".csv"));
							tableNameTranslation.append(cleanTranslation(tbl
									.get_Translation(MTable.COLUMNNAME_Name)));

						} else {

							table.setName(tableDef.getAD_Table().getName());
							table.setURL(tableDef.getAD_Table().getName()
									+ ".csv");
							tableNameTranslation.append(tableDef.getAD_Table()
									.getName());
						}

					}

					table.setDescription(tableDef.getDescription());
					table.setDecimalSymbol(tableDef.getDecimalSymbol());
					table.setDigitGroupingSymbol(tableDef
							.getDigitGroupingSymbol());
					if(tableDef.getEpoch().intValue() != 0)
						table.setEpoch(tableDef.getEpoch().intValue());
					if(tableDef.getSkipNumBytes().intValue() != 0)
						table.setSkipNumBytes(tableDef.getSkipNumBytes().intValue());					
					table.getValidity().setFormat("DD.MM.YYYY");
					DateFormat dfFrom;
					dfFrom = DateFormat.getDateInstance(DateFormat.MEDIUM);
					java.util.Date dateFrom = new java.util.Date(tableDef.getDateFrom().getTime());
					table.getValidity().getRange()
							.setFrom(dfFrom.format(dateFrom));					
					DateFormat dfTo;
					dfTo = DateFormat.getDateInstance(DateFormat.MEDIUM);
					java.util.Date dateTo = new java.util.Date(tableDef.getDateTo().getTime());
					table.getValidity().getRange()
							.setTo(dfTo.format(dateTo));
					table.setDecimalSymbol(tableDef.getDecimalSymbol());
					table.setDigitGroupingSymbol(tableDef
							.getDigitGroupingSymbol());
					if(tableDef.isFixedLength())
						table.setLength(tableDef.getLength().intValue());
					
					// TODO: Fixed or Variable Length
					// At the moment only Variable Length 
					// Fixed Length prepared
					table.fillTable(tableDef.getPAT_GDPdU_Export_Def_ID(),
							false, tableDef.getColumnDelimiter(),
							tableDef.getTextEncapsulator(),
							tableDef.getRecordDelimiter());

					tableList.add(table);

				table.writeCSVFile(false, tbl.getTableName(),
						tableNameTranslation.toString(),
						tableDef.isUse_AD_Client_ID(),
						tableDef.getAD_Client_ID(), tableDef.getAD_Org_ID(),
						p_PathDictionary);

				}

				
			}
		
	}
	
	
	public String cleanTranslation(String translation) {

		return translation.replaceAll("Ü", "Ue").replaceAll("Ä", "Ae")
				.replaceAll("Ö", "Oe").replaceAll("ü", "ue")
				.replaceAll("ä", "ae").replaceAll("ö", "oe")
				.replaceAll(" ", "").replaceAll("ß", "sz")
				.replaceAll("\"", "&quot;").replaceAll("&", "&amp;")
				.replaceAll("<", "&lt;").replaceAll(">", "&gt;");

	}	
	
	/**
	 * @return the command
	 */
	@XmlElement(name = "Command")
	public String getCommand() {
		return command;
	}

	/**
	 * @param command
	 *            the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}


}
