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

import java.util.List;
import java.util.logging.Level;

import org.compiere.model.MColumn;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

import de.aulerlichtkabel.gdpdu.model.X_PAT_GDPdU_Export_Def;
import de.aulerlichtkabel.gdpdu.model.X_PAT_GDPdU_Export_TFields;

public class CreateColoumns extends SvrProcess {


	private int p_AD_Table_ID = 0;
	
	private int p_PAT_GDPdU_Export_Def_ID = 0;
	
	final private int  KEYSEQ = 10;

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

			else if (name.equals("PAT_GDPdU_Export_Def_ID"))
				p_PAT_GDPdU_Export_Def_ID = para[i].getParameterAsInt();
			else if (name.equals("AD_Table_ID"))
				p_AD_Table_ID = para[i].getParameterAsInt();

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

		X_PAT_GDPdU_Export_Def gdpdu_Export_Def = new Query(getCtx(),
				X_PAT_GDPdU_Export_Def.Table_Name, "PAT_GDPdU_Export_Def_ID=?", get_TrxName())
				.setParameters(p_PAT_GDPdU_Export_Def_ID).setClient_ID().first();

		if (gdpdu_Export_Def != null) {

			MTable table = new MTable(getCtx(),
					gdpdu_Export_Def.getAD_Table_ID(), get_TrxName());

			if (table != null) {
				
				int seq = 20;

				for (MColumn column : table.getColumns(true)) {

					X_PAT_GDPdU_Export_TFields gdpdu_Export_TFields = new X_PAT_GDPdU_Export_TFields(
							getCtx(), null, get_TrxName());
					
//					System.out.println(Msg.getMsg(getCtx(), column.getColumnName()));
					
					gdpdu_Export_TFields.setValue(column.getColumnName());
					gdpdu_Export_TFields.setAD_Table_ID(gdpdu_Export_Def
							.getAD_Table_ID());
					gdpdu_Export_TFields
							.setPAT_GDPdU_Export_Def_ID(gdpdu_Export_Def
									.getPAT_GDPdU_Export_Def_ID());
					gdpdu_Export_TFields.setAD_Column_ID(column
							.getAD_Column_ID());
					gdpdu_Export_TFields.setPAT_GDPdU_Export_Def_ID(gdpdu_Export_Def.getPAT_GDPdU_Export_Def_ID()); 

					if(column.getColumnName().equals(table.getTableName()+"_ID"))
						gdpdu_Export_TFields.setSequence(KEYSEQ);
					else{
						gdpdu_Export_TFields.setSequence(seq);
						seq+=10;
					}
					
					gdpdu_Export_TFields.save(get_TrxName());	
					
				}
			}
		}
		
		//
		StringBuilder msgreturn = new StringBuilder("");
		return msgreturn.toString();

	} // doIt

	public MColumn[] getLines(int ad_Table_ID) {
		String whereClause = "ad_reference_id in (select ad_reference_id from ad_reference where name "
				+ "in ('Amount','Integer','Quantity','Number','Text','String',"
				+ "'Date', 'Date+Time', 'ID','Table','Table Direct','Yes-No','Search','Button')) and columnsql is null and ad_table_id=? ";

		List<MColumn> list = new Query(getCtx(), MColumn.Table_Name,
				whereClause, get_TrxName()).setParameters(ad_Table_ID).list();

		return list.toArray(new MColumn[list.size()]);

	} // getShipments

}
