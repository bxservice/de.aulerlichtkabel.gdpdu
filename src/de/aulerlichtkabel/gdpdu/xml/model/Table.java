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

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.compiere.model.MColumn;
import org.compiere.model.MFactAcct;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;

@XmlType(propOrder = { "URL", "name", "description", "validity",
		"decimalSymbol", "digitGroupingSymbol", "skipNumBytes", "epoch",
		"variableLength", "fixedLength", "length" })
public class Table {

	private String url = null;
	private String name = null;
	private String description = null;
	private String decimalSymbol = null;
	private String digitGroupingSymbol = null;
	private Integer skipNumBytes = null;
	private Integer epoch = null;

	private Validity validity = new Validity();
	private VariableLength variableLength = null;
	private FixedLength fixedLength = null;
	private Integer length = null;
//	private String range = null;

	private StringBuilder sql = new StringBuilder();

	// Defaults
	final private String DEFAULT_COLUMN_DELIMITER = ";";
	final private String DEFAULT_RECORD_DELIMITER = "\r\n";
	final private String DEFAULT_DECIMAL_SYMBOL = ",";
	final private String DEFAUL_TEXT_ENCAPSULATOR = "\"";
	final private String DEFAULT_DIGIT_GROUPING_SYMBOL = ".";

	// Format
	DecimalFormat numberFormat = DisplayType.getNumberFormat(DisplayType.Amount);
	

	public Table() {
	}

	/**
	 * @return the uRL
	 */
	@XmlElement(name = "URL")
	public String getURL() {
		return url;
	}

	/**
	 * @param uRL
	 *            the uRL to set
	 */
	public void setURL(String uRL) {
		url = uRL;
	}

	/**
	 * @return the name
	 */
	@XmlElement(name = "Name")
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	@XmlElement(name = "Description")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the decimalSymbol
	 */
	@XmlElement(name = "DecimalSymbol")
	public String getDecimalSymbol() {
		return decimalSymbol;
	}

	/**
	 * @param decimalSymbol
	 *            the decimalSymbol to set
	 */
	public void setDecimalSymbol(String decimalSymbol) {
		this.decimalSymbol = decimalSymbol;
	}

	/**
	 * @return the digitGroupingSymbol
	 */
	@XmlElement(name = "DigitGroupingSymbol")
	public String getDigitGroupingSymbol() {
		return digitGroupingSymbol;
	}

	/**
	 * @param digitGroupingSymbol
	 *            the digitGroupingSymbol to set
	 */
	public void setDigitGroupingSymbol(String digitGroupingSymbol) {
		this.digitGroupingSymbol = digitGroupingSymbol;
	}

	/**
	 * @return the validity
	 */
	@XmlElement(name = "Validity")
	public Validity getValidity() {
		return validity;
	}

	/**
	 * @param validity
	 *            the validity to set
	 */
	public void setValidity(Validity validity) {
		this.validity = validity;
	}

	/**
	 * @return the variableLength
	 */
	@XmlElement(name = "VariableLength")
	public VariableLength getVariableLength() {
		return variableLength;
	}

	/**
	 * @param variableLength
	 *            the variableLength to set
	 */
	public void setVariableLength() {
		this.variableLength = new VariableLength();
	}

	/**
	 * @return the variableLength
	 */
	@XmlElement(name = "FixedLength")
	public FixedLength getFixedLength() {
		return fixedLength;
	}

	/**
	 * @param variableLength
	 *            the variableLength to set
	 */
	public void setFixedLength() {
		this.fixedLength = new FixedLength();
	}

	public void fillTable(int exportDef_id, boolean isFixedLength,
			String columnDelimiter, String textEncapsulator,
			String recordDelimiter) {

		if (isFixedLength) {
			setFixedLength();
			fixedLength.fillList(exportDef_id, recordDelimiter);
		} else {
			setVariableLength();
			variableLength.fillList(exportDef_id,getName());
		}

	}

	/**
	 * @return the skipNumBytes
	 */
	@XmlElement(name = "SkipNumBytes")
	public Integer getSkipNumBytes() {

		return skipNumBytes;
		
	}

	/**
	 * @param skipNumBytes
	 *            the skipNumBytes to set
	 */
	public void setSkipNumBytes(Integer skipNumBytes) {

		this.skipNumBytes = skipNumBytes;
	}

	/**
	 * @return the epoch
	 */
	@XmlElement(name = "Epoch")
	public Integer getEpoch() {
		
			return epoch;
	}

	/**
	 * @param epoch
	 *            the epoch to set
	 */
	public void setEpoch(Integer epoch) {

		this.epoch = epoch;
	}


	/**
	 * @return the length
	 */
	@XmlElement(name = "Length")
	public Integer getLength() {
		
			return length;

	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(Integer length) {

			this.length = length;
	}

	public void writeCSVFile(boolean isFixedLength, String tableName, String tableNameTranslation, boolean isUseclientid, int client_Id, int org_Id, String p_PathDictionary) {
		
//		System.out.println(getValidity().getRange().getTo());

		if (!isFixedLength) {
			
			try (Writer csvoutput = new FileWriter(p_PathDictionary + tableNameTranslation + ".csv")) {
				
				MTable table = new Query(Env.getCtx(), MTable.Table_Name,
						"name=?", null).setParameters(tableName).first();

				if (table != null) {

					ArrayList<String> columnlist = new ArrayList<String>();							

					sql.append("SELECT ");

					for (Integer vc_id : ColumnIDList.getColumn_idlist()) {

						MColumn column = new Query(Env.getCtx(),
								MColumn.Table_Name, "ad_column_id=?", null)
								.setParameters(vc_id).first();

						if (column != null){
							sql.append(column.getColumnName()).append(",");
							columnlist.add(column.getColumnName());
						}
						
						// TODO: insert Ademmpiere Exception

					}

					// remove last ,
					sql.setLength(sql.length() - 1);

					sql.append(" from ");
					sql.append(table.getTableName());

					sql.append(" where ");

					if (columnlist.contains("DateAcct")) {

						sql.append("dateacct between '")
								.append(getValidity().getRange().getFrom())
								.append("'");
						sql.append(" and ");
						sql.append("'")
								.append(getValidity().getRange().getTo())
								.append("'");

					} else if (columnlist.contains("DateOrdered")) {

						sql.append("dateordered between '")
								.append(getValidity().getRange().getFrom())
								.append("'");
						sql.append(" and ");
						sql.append("'")
								.append(getValidity().getRange().getTo())
								.append("'");

					} else {

						sql.append("created between '")
								.append(getValidity().getRange().getFrom())
								.append("'");
						sql.append(" and ");
						sql.append("'")
								.append(getValidity().getRange().getTo())
								.append("'");

					}
					
					if (isUseclientid) {
						sql.append(" and ");
						sql.append("ad_client_id=");
						sql.append(client_Id);
					}
					
					if (org_Id != 0) {
						sql.append(" and ");
						sql.append("ad_org_id=");
						sql.append(org_Id);
					}
					
					if (columnlist.contains("Posted")) {
						sql.append(" and ");
						sql.append("posted='Y'");
					}

				}
				
				//System.out.println(sql);
				
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {

					pstmt = DB.prepareStatement(sql.toString(), null);
					rs = pstmt.executeQuery();

					while (rs.next()) {

						int col = 1;

						for (int pos = 0; pos <= getVariableLength()
								.getVariableColumnList().size(); pos++) {
							
							MColumn column = new Query(Env.getCtx(),
									MColumn.Table_Name, "ad_column_id=?", null)
									.setParameters(
											ColumnIDList.getColumn_idlist().get(pos))
									.first();
														
							StringBuilder value = new StringBuilder();

							if (rs.getObject(col) == null) {
								
								if ((column.getAD_Reference().getName()
										.equals("ID"))
										|| (column.getAD_Reference().getName()
												.equals("Table Direct"))
										|| (column.getAD_Reference().getName()
												.equals("Table"))) {								
								value.append("0");
								
								} else if ((column.getAD_Reference().getName()
										.equals("String"))
										|| (column.getAD_Reference().getName()
												.equals("Text"))
										|| (column.getAD_Reference().getName()
												.equals("Text Long"))
										|| (column.getAD_Reference().getName()
												.equals("Button"))) {

									if (getVariableLength()
											.getTextEncapsulator() != null) {
										value.append(getVariableLength()
												.getTextEncapsulator());
									} else {
										value.append(DEFAUL_TEXT_ENCAPSULATOR);
									}

									value.append(" ");

									if (getVariableLength()
											.getTextEncapsulator() != null) {
										value.append(getVariableLength()
												.getTextEncapsulator());
									} else {
										value.append(DEFAUL_TEXT_ENCAPSULATOR);
									}

								} else if ((column.getAD_Reference().getName()
										.equals("Numeric"))
										|| (column.getAD_Reference().getName()
												.equals("Quantity"))
										|| (column.getAD_Reference().getName()
												.equals("Amount"))
										|| (column.getAD_Reference().getName()
												.equals("Integer"))) {

									// TODO: Numberformat
									StringBuilder no = new StringBuilder();
									no.append(numberFormat.format(Env.ZERO));

									// DecimalSymbol
									if ((getDecimalSymbol() != null)
											&& !(no.toString()
													.contains(getDecimalSymbol()))) {
										no.toString().replaceAll(
												DEFAULT_DECIMAL_SYMBOL,
												getDecimalSymbol());
									} else {
										StringBuilder dcs = new StringBuilder();
										dcs.append(numberFormat
												.getDecimalFormatSymbols()
												.getDecimalSeparator());
										no.toString().replaceAll(
												dcs.toString(),
												DEFAULT_DECIMAL_SYMBOL);
									}

									// DigitGroupingSymbol
									if ((getDigitGroupingSymbol() != null)
											&& !(no.toString()
													.contains(getDigitGroupingSymbol()))) {
										no.toString().replaceAll(
												DEFAULT_DIGIT_GROUPING_SYMBOL,
												getDecimalSymbol());
									} else {
										StringBuilder grs = new StringBuilder();
										grs.append(numberFormat
												.getDecimalFormatSymbols()
												.getGroupingSeparator());

										no.toString().replaceAll(
												grs.toString(),
												DEFAULT_DIGIT_GROUPING_SYMBOL);
									}

									value.append(no);

								} else if ((column.getAD_Reference().getName()
										.equals("Date"))
										|| (column.getAD_Reference().getName()
												.equals("Date+Time"))) {

									DateFormat df = new SimpleDateFormat(
											"dd.MM.YYYY");
									value.append("00.00.0000");

								} else {

									value.append(" ");

								}
								
								
								
								csvoutput.write(value.toString());

								if (pos < (getVariableLength()
										.getVariableColumnList().size())) {
									if (getVariableLength()
											.getColumnDelimiter() != null) {
										csvoutput.write(getVariableLength()
												.getColumnDelimiter());
									} else {
										csvoutput
												.write(DEFAULT_COLUMN_DELIMITER);
									}
								}
								
								col++;
								continue;
							}


							if (column != null) {

								if ((column.getAD_Reference().getName()
										.equals("ID"))
										|| (column.getAD_Reference().getName()
												.equals("Table Direct"))
										|| (column.getAD_Reference().getName()
												.equals("Table"))) {

									value.append(rs.getObject(col).toString());

								} else if ((column.getAD_Reference().getName()
										.equals("String"))
										|| (column.getAD_Reference().getName()
												.equals("Text"))
										|| (column.getAD_Reference().getName()
												.equals("Text Long"))
										|| (column.getAD_Reference().getName()
												.equals("Button"))) {

									if (getVariableLength()
											.getTextEncapsulator() != null) {
										value.append(getVariableLength()
												.getTextEncapsulator());
									} else {
										value.append(DEFAUL_TEXT_ENCAPSULATOR);
									}

									value.append(clearText(rs.getObject(col)
											.toString()));

									if (getVariableLength()
											.getTextEncapsulator() != null) {
										value.append(getVariableLength()
												.getTextEncapsulator());
									} else {
										value.append(DEFAUL_TEXT_ENCAPSULATOR);
									}

								} else if ((column.getAD_Reference().getName()
										.equals("Numeric"))
										|| (column.getAD_Reference().getName()
												.equals("Quantity"))
										|| (column.getAD_Reference().getName()
												.equals("Amount"))
										|| (column.getAD_Reference().getName()
												.equals("Integer"))) {

									// TODO: Numberformat
									StringBuilder no = new StringBuilder();
									no.append(numberFormat.format(rs
											.getObject(col)));

									// DecimalSymbol
									if ((getDecimalSymbol() != null)
											&& !(no.toString()
													.contains(getDecimalSymbol()))) {
										no.toString().replaceAll(
												DEFAULT_DECIMAL_SYMBOL,
												getDecimalSymbol());
									} else {
										StringBuilder dcs = new StringBuilder();
										dcs.append(numberFormat
												.getDecimalFormatSymbols()
												.getDecimalSeparator());
										no.toString().replaceAll(
												dcs.toString(),
												DEFAULT_DECIMAL_SYMBOL);
									}

									// DigitGroupingSymbol
									if ((getDigitGroupingSymbol() != null)
											&& !(no.toString()
													.contains(getDigitGroupingSymbol()))) {
										no.toString().replaceAll(
												DEFAULT_DIGIT_GROUPING_SYMBOL,
												getDecimalSymbol());
									} else {
										StringBuilder grs = new StringBuilder();
										grs.append(numberFormat
												.getDecimalFormatSymbols()
												.getGroupingSeparator());

										no.toString().replaceAll(
												grs.toString(),
												DEFAULT_DIGIT_GROUPING_SYMBOL);
									}

									value.append(no);

								} else if ((column.getAD_Reference().getName()
										.equals("Date"))
										|| (column.getAD_Reference().getName()
												.equals("Date+Time"))) {

									DateFormat df = new SimpleDateFormat(
											"dd.MM.YYYY");
									value.append(df.format(rs.getObject(col)));

								} else {

									value.append(rs.getObject(col).toString());

								}

							}

							csvoutput.write(value.toString());

							if (pos < (getVariableLength()
									.getVariableColumnList().size())) {
								if (getVariableLength().getColumnDelimiter() != null) {
									csvoutput.write(getVariableLength()
											.getColumnDelimiter());
								} else {
									csvoutput.write(DEFAULT_COLUMN_DELIMITER);
								}
							}

							col++;

						}

						if (getVariableLength().getRecordDelimiter() != null)
							csvoutput.write(getVariableLength()
									.getRecordDelimiter());
						else
							csvoutput.write(DEFAULT_RECORD_DELIMITER);

					}

					csvoutput.close();

					ColumnIDList.clear();

				} catch (SQLException e) {
					// log.log(Level.SEVERE, sql, e);
				} finally {
					DB.close(rs, pstmt);
					rs = null;
					pstmt = null;
				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}	
	

	private String clearText(Object object) {

		String str = (String) object;
		str = str.replaceAll("\n", "<LineFeed>");
		

		if (getVariableLength().getColumnDelimiter() != null)
			str = str.replaceAll(getVariableLength().getColumnDelimiter(), " ");
		else
			str = str.replaceAll(DEFAULT_COLUMN_DELIMITER, " ");

		if (getVariableLength().getTextEncapsulator() != null)
			str = str.replaceAll(getVariableLength().getTextEncapsulator(), " ");
		else
			str = str.replaceAll(DEFAUL_TEXT_ENCAPSULATOR, " ");

		if (getVariableLength().getRecordDelimiter() != null)
			str = str.replaceAll(getVariableLength().getRecordDelimiter(),
					"<LineFeed>");
		else
			str = str.replaceAll(DEFAULT_RECORD_DELIMITER, "<LineFeed>");

		return str;

	}


}