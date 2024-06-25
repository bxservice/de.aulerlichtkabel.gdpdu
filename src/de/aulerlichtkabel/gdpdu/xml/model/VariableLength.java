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
import javax.xml.bind.annotation.XmlType;

import org.compiere.model.MColumn;
import org.compiere.model.MTable;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;

import de.aulerlichtkabel.gdpdu.model.MPAT_GDPdU_Export_Def;
import de.aulerlichtkabel.gdpdu.model.MPAT_GDPdU_Export_TFields;

@XmlType(propOrder = { "columnDelimiter", "recordDelimiter",
		"textEncapsulator", "variablePrimaryKey", "variableColumnlist",
		"ListForeignKey" })
public class VariableLength {
	
	protected CLogger log = CLogger.getCLogger (VariableLength.class);

	private String columnDelimiter = null;
	private String recordDelimiter = null;
	private String textEncapsulator = null;

	private VariablePrimaryKey variablePrimaryKey = new VariablePrimaryKey();

	@XmlElement(name = "ForeignKey")
	private List<ForeignKey> ListForeignKey = new ArrayList<ForeignKey>();

	@XmlElement(name = "VariableColumn")
	private List<VariableColumn> variableColumnlist = new ArrayList<VariableColumn>();

	// private String filePath = null;

	public VariableLength() {

	}

	/**
	 * @return the variablePrimaryKey
	 */
	@XmlElement(name = "VariablePrimaryKey")
	public VariablePrimaryKey getVariablePrimaryKey() {
		return variablePrimaryKey;
	}

	/**
	 * @param variablePrimaryKey
	 *            the variablePrimaryKey to set
	 */
	public void setVariablePrimaryKey(VariablePrimaryKey variablePrimaryKey) {
		this.variablePrimaryKey = variablePrimaryKey;
	}

	public void fillList(int exportDef_id, String tableName) {

		variableColumnlist.clear();
		ListForeignKey.clear();

		MPAT_GDPdU_Export_Def export_def = new MPAT_GDPdU_Export_Def(Env.getCtx(), exportDef_id, null);

		for (MPAT_GDPdU_Export_TFields fieldlist : export_def.getFields()) {
			
			MColumn column = MColumn.get(Env.getCtx(), fieldlist.getAD_Column_ID());
			if (fieldlist.getAD_Column_ID() <= 0 || column == null || column.getColumnName() == null) {
				log.warning("Column not found " + fieldlist.getValue());
				continue;
			}
			String columnName = column.getColumnName();
			
			Boolean isValueChanged = false;
		
			// Value changed like account_id to c_elementvalue_id in fact_acct
			if(!columnName.equals(fieldlist.getValue())){
				columnName = fieldlist.getValue();
				isValueChanged = true;
			}

			if (column.isKey()) {

				if (getTranslation(column.getAD_Column_ID()) == null) {

					getVariablePrimaryKey().setName(clean(column.getName()));

				} else
					getVariablePrimaryKey()
							.setName(clean(getTranslation(column.getAD_Column_ID())));

				if(fieldlist.getDescription()!=null)
					getVariablePrimaryKey().setDescription(clean(fieldlist.getDescription()));


			} else {

				// System.out.println(columnName);

				VariableColumn vc = new VariableColumn();

				// Value changed like account_id to c_elementvalue_id in fact_acct
				if (isValueChanged) {

					vc.setName(clean(columnName));

				} else if (getTranslation(column.getAD_Column_ID()) == null) {
					vc.setName(clean(column.getName()));
				} else {
					vc.setName(clean(getTranslation(column.getAD_Column_ID())));
				}

				vc.setDescription(fieldlist.getDescription());

				if ((column.getAD_Reference_ID() == DisplayType.Integer)
						&& !column.getName().contains(MTable.getTableName(Env.getCtx(), fieldlist.getAD_Table_ID()))) {
					vc.setNumeric(0);

				} else if (column.getAD_Reference_ID() == DisplayType.Quantity
						|| column.getAD_Reference_ID() == DisplayType.Number
						|| column.getAD_Reference_ID() == DisplayType.Amount) {

					vc.setNumeric(2);

				} else if ((column.getAD_Reference_ID() == DisplayType.Text
						|| column.getAD_Reference_ID() == DisplayType.TextLong
						|| column.getAD_Reference_ID() == DisplayType.String
						|| column.getAD_Reference_ID() == DisplayType.Button)
						&& !column.getName().contains(MTable.getTableName(Env.getCtx(), fieldlist.getAD_Table_ID()))) {
					vc.setAlphaNumeric();
				} else if ((column.getAD_Reference_ID() == DisplayType.Date
						|| column.getAD_Reference_ID() == DisplayType.DateTime)
						&& !column.getName().contains(MTable.getTableName(Env.getCtx(), fieldlist.getAD_Table_ID()))) {
					vc.setDate("DD.MM.YYYY");

				} else if ((column.getAD_Reference_ID() == DisplayType.ID
						|| column.getAD_Reference_ID() == DisplayType.Table
						|| column.getAD_Reference_ID() == DisplayType.TableDir
						|| column.getAD_Reference_ID() == DisplayType.Search)
						&& !column.getName().contains(MTable.getTableName(Env.getCtx(), fieldlist.getAD_Table_ID()))) {
					vc.setNumeric(0);
				} else if (column.getAD_Reference_ID() == DisplayType.YesNo) {

					vc.setAlphaNumeric();
					vc.newMapList();
					Map mapYes = new Map();
					mapYes.setFrom("Y");
					mapYes.setTo("True");
					vc.addToMapList(mapYes);

					Map mapNo = new Map();
					mapNo.setFrom("N");
					mapNo.setTo("False");
					vc.addToMapList(mapNo);
					
					if(!vc.getName().toUpperCase().startsWith("IS")){
						vc.setName("Is"+vc.getName());
					}

				} else {
					vc.setAlphaNumeric();
				}

				variableColumnlist.add(vc);

				if (column.getAD_Reference_ID() == DisplayType.ID
						|| column.getAD_Reference_ID() == DisplayType.Table
						|| column.getAD_Reference_ID() == DisplayType.TableDir
						|| column.getAD_Reference_ID() == DisplayType.Search) {

					ForeignKey foreignKey = new ForeignKey();

					// Value changed like account_id to c_elementvalue_id in fact_acct
					if (isValueChanged) {
						
							foreignKey.setName(clean(columnName));
							foreignKey.setReferences(clean(columnName));

							
					} else if (getTranslation(column.getAD_Column_ID()) == null) {
						foreignKey.setName(clean(column.getName()));
						foreignKey.setReferences(clean(column.getName()));
					} else {
						foreignKey.setName(clean(getTranslation(column.getAD_Column_ID())));
						foreignKey.setReferences(clean(getTranslation(column.getAD_Column_ID())));
					}

					
					ListForeignKey.add(foreignKey);

				}

			}
			
			ColumnIDList.addColumn_id(column.getAD_Column_ID());

		}

	}
		
	
	public String getTableTranslation(int table_Id) {

		String sql = "SELECT name FROM ad_table_trl WHERE ad_table_id=? AND AD_Language=?";

		List<Object> params = new ArrayList<>();
		params.add(table_Id);
		params.add(Env.getAD_Language(Env.getCtx()));

		return DB.getSQLValueString(null, sql, params);

	}

	

	/**
	 * @return the columnDelimiter
	 */
	@XmlElement(name = "ColumnDelimiter")
	public String getColumnDelimiter() {
		return columnDelimiter;
	}

	/**
	 * @param columnDelimiter
	 *            the columnDelimiter to set
	 */
	public void setColumnDelimiter(String columnDelimiter) {
		this.columnDelimiter = columnDelimiter;
	}

	/**
	 * @return the recordDelimiter
	 */
	@XmlElement(name = "RecordDelimiter")
	public String getRecordDelimiter() {
		return recordDelimiter;
	}

	/**
	 * @param recordDelimiter
	 *            the recordDelimiter to set
	 */
	public void setRecordDelimiter(String recordDelimiter) {
		this.recordDelimiter = recordDelimiter;
	}

	/**
	 * @return the textEncapsulator
	 */
	@XmlElement(name = "TextEncapsulator")
	public String getTextEncapsulator() {
		return textEncapsulator;
	}

	/**
	 * @param textEncapsulator
	 *            the textEncapsulator to set
	 */
	public void setTextEncapsulator(String textEncapsulator) {
		this.textEncapsulator = textEncapsulator;
	}

	public List<VariableColumn> getVariableColumnList() {

		return variableColumnlist;

	}

	public String getTranslation(int column_Id) {

		String sql = "SELECT name FROM ad_column_trl WHERE ad_column_id=? AND AD_Language=?";

		List<Object> params = new ArrayList<>();
		params.add(column_Id);
		params.add(Env.getAD_Language(Env.getCtx()));

		if (DB.getSQLValueString(null, sql, params) == null) {

			// try to find a translation in field_trl
			String sqlf = "select name from ad_field_trl where ad_field_id in (select ad_field_id from ad_field where ad_column_id =? and ad_language=?)";

			if (DB.getSQLValueString(null, sqlf, params) == null) {
				return null;
			} else {
				return DB.getSQLValueString(null, sqlf, params);
			}

		} else {

			return DB.getSQLValueString(null, sql, params);
		}
	}

	public String clean(String str) {

		return str.replaceAll("Ü", "Ue").replaceAll("Ä", "Ae")
				.replaceAll("Ö", "Oe").replaceAll("ü", "ue")
				.replaceAll("ä", "ae").replaceAll("ö", "oe")
				.replaceAll(" ", "").replaceAll("ß", "sz")
				.replaceAll("\"", "&quot;").replaceAll("&", "&amp;")
				.replaceAll("<", "&lt;").replaceAll(">", "&gt;");

	}

}
