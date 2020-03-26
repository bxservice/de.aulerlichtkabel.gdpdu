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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.compiere.model.MColumn;
import org.compiere.model.MTable;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;

import de.aulerlichtkabel.gdpdu.model.MPAT_GDPdU_Export_Def;
import de.aulerlichtkabel.gdpdu.model.MPAT_GDPdU_Export_TFields;

public class FixedLength {
	

	private String recordDelimiter = null;
	
	private FixedPrimaryKey fixedPrimaryKey = new FixedPrimaryKey();
	
	@XmlElement(name="ForeignKey")
	private List<ForeignKey> ListForeignKey = new ArrayList<ForeignKey>();

	@XmlElement(name="FixedColumn")
	private List<FixedColumn> fixedColumnlist = new ArrayList<FixedColumn>();

	private Integer length = null;
	
	private Integer pos = Integer.valueOf(0);

	
	
	public FixedLength() {

		
	}


	/**
	 * @return the variablePrimaryKey
	 */
	@XmlElement(name="FixedPrimaryKey")
	public FixedPrimaryKey getFixedPrimaryKey() {
		return fixedPrimaryKey;
	}


	/**
	 * @param variablePrimaryKey the variablePrimaryKey to set
	 */
	public void setVariablePrimaryKey() {
		this.fixedPrimaryKey = new FixedPrimaryKey();
	}


	public void fillList(int exportDef_id, String recordDelimiter){
		
		
		fixedColumnlist.clear();
		ListForeignKey.clear();

		MPAT_GDPdU_Export_Def export_def = new MPAT_GDPdU_Export_Def(Env.getCtx(), exportDef_id, null);
		
		for(MPAT_GDPdU_Export_TFields fieldlist : export_def.getFields()){
			
			MColumn column = MColumn.get(Env.getCtx(), fieldlist.getAD_Column_ID());
			
			if (column == null)
				continue;
			
			if (column.getName().contains(MTable.getTableName(Env.getCtx(), fieldlist.getAD_Table_ID()))){
				getFixedPrimaryKey().setName(column.getName());
				getFixedPrimaryKey().setDescription(fieldlist.getDescription());
				
			}
			
			FixedColumn fc = new FixedColumn();
			fc.setRecordDelimiter(recordDelimiter);

			fc.setName(fieldlist.getValue());
			fc.setDescription(fieldlist.getDescription());
			
			
			if ((column.getAD_Reference_ID() == DisplayType.Quantity
					|| column.getAD_Reference_ID() == DisplayType.Number
					|| column.getAD_Reference_ID() == DisplayType.Amount
					|| column.getAD_Reference_ID() == DisplayType.Integer)
					&& !column.getName().contains(MTable.getTableName(Env.getCtx(), fieldlist.getAD_Table_ID()))) {
				fc.setNumeric();
			} else if ((column.getAD_Reference_ID() == DisplayType.Text
					|| column.getAD_Reference_ID() == DisplayType.TextLong
					|| column.getAD_Reference_ID() == DisplayType.String
					|| column.getAD_Reference_ID() == DisplayType.Button)
					&& !column.getName().contains(MTable.getTableName(Env.getCtx(), fieldlist.getAD_Table_ID()))){
				fc.setAlphaNumeric();
			} else if(column.getAD_Reference_ID() == DisplayType.Date
					&& !column.getName().contains(MTable.getTableName(Env.getCtx(), fieldlist.getAD_Table_ID()))) {
				fc.setDate();
			} else if ((column.getAD_Reference_ID() == DisplayType.ID
					|| column.getAD_Reference_ID() == DisplayType.Table
					|| column.getAD_Reference_ID() == DisplayType.TableDir
					|| column.getAD_Reference_ID() == DisplayType.Search)
					&& !column.getName().contains(MTable.getTableName(Env.getCtx(), fieldlist.getAD_Table_ID()))) {
				fc.setNumeric();
			} else if (column.getAD_Reference_ID() == DisplayType.YesNo) {
				fc.setMap();
				fc.getMap().setFrom("Y");
				fc.getMap().setTo("true");
			} else {
				fc.setAlphaNumeric();				
			}
			

			pos+=column.getFieldLength();

			fc.setFixedRange();
			fc.getFixedRange().setFrom(pos);
			fc.getFixedRange().setLength(column.getFieldLength());
			
			fixedColumnlist.add(fc);
				
			
			if ((column.getAD_Reference_ID() == DisplayType.ID
					|| column.getAD_Reference_ID() == DisplayType.Table
					|| column.getAD_Reference_ID() == DisplayType.TableDir
					|| column.getAD_Reference_ID() == DisplayType.Search)
					&& !column.getName().contains(MTable.getTableName(Env.getCtx(), fieldlist.getAD_Table_ID()))) {
				ForeignKey foreignKey = new ForeignKey();
				foreignKey.setName(fieldlist.getAD_Column().getColumnName());
				foreignKey.setReferences(fieldlist.getAD_Column().getAD_Reference().getName());
				ListForeignKey.add(foreignKey);
				
			}
			

		}
		
	}

	
	public void writeListtoCSV(){
		
		//Numbers
		
	}


	/**
	 * @return the recordDelimiter
	 */
	@XmlElement(name="RecordDelimiter")
	public String getRecordDelimiter() {
		return recordDelimiter;
	}


	/**
	 * @param recordDelimiter the recordDelimiter to set
	 */
	public void setRecordDelimiter(String recordDelimiter) {
		this.recordDelimiter = recordDelimiter;
	}

	/**
	 * @return the length
	 */
	@XmlElement(name="Length")
	public Integer getLength() {
		return length;
	}


	/**
	 * @param length the length to set
	 */
	public void setLength(Integer length) {
		this.length = length;
	}
	
	
	public List<FixedColumn> getVariableColumnList(){
		
		return fixedColumnlist;
		
	}
	
}
