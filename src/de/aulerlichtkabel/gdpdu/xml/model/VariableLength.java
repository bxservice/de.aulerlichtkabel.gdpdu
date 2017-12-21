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
import org.compiere.model.MElementValue;
import org.compiere.model.MFactAcct;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

import de.aulerlichtkabel.gdpdu.model.MPAT_GDPdU_Export_Def;
import de.aulerlichtkabel.gdpdu.model.MPAT_GDPdU_Export_TFields;

@XmlType(propOrder = { "columnDelimiter", "recordDelimiter",
		"textEncapsulator", "variablePrimaryKey", "variableColumnlist",
		"ListForeignKey" })
public class VariableLength {

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

		MPAT_GDPdU_Export_Def export_def = new Query(Env.getCtx(), MPAT_GDPdU_Export_Def.Table_Name,
				"pat_gdpdu_export_def_id=?", null).setParameters(exportDef_id).first();

		for (MPAT_GDPdU_Export_TFields fieldlist : export_def.getFields()) {
			
			String columnName = fieldlist.getAD_Column().getColumnName();

			// System.out.println(columnName+" -
			// "+fieldlist.getAD_Table().getTableName()+"_ID");
			// TODO: Flex Translation
			if(!columnName.equals(fieldlist.getValue()))
				columnName = fieldlist.getValue();
			
			// --> then use value of column
			
			if (columnName.equals(fieldlist.getAD_Table().getTableName() + "_ID")) {

				if (getTranslation(fieldlist.getAD_Column().getAD_Column_ID()) == null) {

					getVariablePrimaryKey().setName(clean(fieldlist.getAD_Column().getName()));

				} else
					getVariablePrimaryKey()
							.setName(clean(getTranslation(fieldlist.getAD_Column().getAD_Column_ID())));

				if(fieldlist.getDescription()!=null)
					getVariablePrimaryKey().setDescription(clean(fieldlist.getDescription()));


			} else {

				// System.out.println(columnName);

				VariableColumn vc = new VariableColumn();

				if (getTranslation(fieldlist.getAD_Column().getAD_Column_ID()) == null)
					vc.setName(clean(fieldlist.getAD_Column().getName()));
				else
					vc.setName(clean(getTranslation(fieldlist.getAD_Column().getAD_Column_ID())));

				// special fact_acct
				// **
				// Coloum c_elementvalue_id is account_id in fact_acct

				if (tableName.equals("Accounting Fact") &&

						(columnName.equals("Account_ID"))) {

					MTable table = new Query(Env.getCtx(), MTable.Table_Name, "tablename=?", null)
							.setParameters(MElementValue.Table_Name).first();

					if (table != null) {

						if (table.get_Translation(MElementValue.COLUMNNAME_C_ElementValue_ID) == null) {
							vc.setName(clean(MElementValue.COLUMNNAME_C_ElementValue_ID));
						} else {
							vc.setName(clean(table.get_Translation(MElementValue.COLUMNNAME_C_ElementValue_ID)));
						}
					}

				}

				// **

				vc.setDescription(fieldlist.getDescription());

				if ((fieldlist.getAD_Column().getAD_Reference().getName().contains("Integer")
						|| fieldlist.getAD_Column().getAD_Reference().getName().contains("Search"))
						&& !fieldlist.getAD_Column().getName().contains(fieldlist.getAD_Table().getName())) {
					vc.setNumeric(0);

				} else if (fieldlist.getAD_Column().getAD_Reference().getName().contains("Quantity")
						|| fieldlist.getAD_Column().getAD_Reference().getName().contains("Number")
						|| (fieldlist.getAD_Column().getAD_Reference().getName().contains("Amount"))) {

					vc.setNumeric(2);

				} else if ((fieldlist.getAD_Column().getAD_Reference().getName()

						.contains("Text") || fieldlist.getAD_Column().getAD_Reference().getName().contains("String")
						|| fieldlist.getAD_Column().getAD_Reference().getName().contains("Button"))
						&& !fieldlist.getAD_Column().getName().contains(fieldlist.getAD_Table().getName())) {
					vc.setAlphaNumeric();
				} else if (fieldlist.getAD_Column().getAD_Reference().getName().contains("Date")
						&& !fieldlist.getAD_Column().getName().contains(fieldlist.getAD_Table().getName())) {
					vc.setDate("DD.MM.YYYY");

				} else if ((fieldlist.getAD_Column().getAD_Reference().getName().contains("ID")
						|| fieldlist.getAD_Column().getAD_Reference().getName().contains("Table")
						|| fieldlist.getAD_Column().getAD_Reference().getName().contains("Table Direct"))
						&& !fieldlist.getAD_Column().getName().contains(fieldlist.getAD_Table().getName())) {
					vc.setNumeric(0);
				} else if (fieldlist.getAD_Column().getAD_Reference().getName().contains("Yes-No")) {

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

				if (fieldlist.getAD_Column().getAD_Reference().getName().contains("ID")
						|| fieldlist.getAD_Column().getAD_Reference().getName().equals("Table")
						|| fieldlist.getAD_Column().getAD_Reference().getName().equals("Table Direct")
						|| fieldlist.getAD_Column().getAD_Reference().getName().equals("Search")) {

					ForeignKey foreignKey = new ForeignKey();

					if (getTranslation(fieldlist.getAD_Column().getAD_Column_ID()) == null) {
						foreignKey.setName(clean(fieldlist.getAD_Column().getName()));
						foreignKey.setReferences(clean(fieldlist.getAD_Column().getName()));
					} else {
						foreignKey
								.setName(clean(getTranslation(fieldlist.getAD_Column().getAD_Column_ID())));
						foreignKey.setReferences(clean(getTranslation(fieldlist.getAD_Column().getAD_Column_ID())));
					}

					// special fact_acct
					// **
					// Coloum c_elementvalue_id is account_id in fact_acct

					if (tableName.equals("Accounting Fact") &&

							(columnName.equals("Account_ID"))) {

						MTable table = new Query(Env.getCtx(), MTable.Table_Name, "tablename=?", null)
								.setParameters(MElementValue.Table_Name).first();

						if (table != null) {

							if (table.get_Translation(MElementValue.COLUMNNAME_C_ElementValue_ID) == null) {
								foreignKey.setName(clean(MElementValue.COLUMNNAME_C_ElementValue_ID));
								foreignKey.setReferences(clean(MElementValue.COLUMNNAME_C_ElementValue_ID));

							} else {
								foreignKey.setName(clean(
										table.get_Translation(MElementValue.COLUMNNAME_C_ElementValue_ID)));
								foreignKey.setReferences(clean(
										table.get_Translation(MElementValue.COLUMNNAME_C_ElementValue_ID)));
							}
						}

					}

					// **

					ListForeignKey.add(foreignKey);

				}

			}
			
			ColumnIDList.addColumn_id(fieldlist.getAD_Column().getAD_Column_ID());

		}

	}

	private String getColumnTableName(int columnId) {

		MColumn column = new Query(Env.getCtx(), MColumn.Table_Name,
				"ad_column_id=?", null).setParameters(columnId).first();
		


		if (column != null) {

			
			if (column.getAD_Table().getName().equals("Accounting Fact")&&

					(column.getColumnName().equals(MFactAcct.COLUMNNAME_Record_ID))
					||(column.getColumnName().equals(MFactAcct.COLUMNNAME_UserElement1_ID))
					||(column.getColumnName().equals(MFactAcct.COLUMNNAME_UserElement2_ID))
					||(column.getColumnName().equals(MFactAcct.COLUMNNAME_User1_ID))
					||(column.getColumnName().equals(MFactAcct.COLUMNNAME_User2_ID))
							) {
				return null;
			}
			
			
			
			String tableName = column.getColumnName().substring(0,
					column.getColumnName().length() - 3);
			
//			System.out.println(tableName);
			
			MTable table = new Query(Env.getCtx(), MTable.Table_Name, "tablename=?",
					null).setParameters(tableName).first();
			
			if (table != null) {

					String tableTrl =  getTableTranslation(table.getAD_Table_ID());
					if(tableTrl != null)
						return clean(tableTrl);
					else
						return clean(tableName);
	
			}

		}
		
		return null;

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
