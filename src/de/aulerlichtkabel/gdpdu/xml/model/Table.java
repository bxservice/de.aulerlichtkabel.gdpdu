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

import java.io.BufferedWriter;
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
import java.util.List;
import java.util.logging.Level;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.compiere.model.MColumn;
import org.compiere.model.MTable;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;

@XmlType(propOrder = { "URL", "name", "description", "validity",
		"decimalSymbol", "digitGroupingSymbol", "skipNumBytes", "epoch",
		"variableLength", "fixedLength", "length" })
public class Table {
	
	protected CLogger			log = CLogger.getCLogger (getClass());

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

	public void writeCSVFile(boolean isFixedLength, String tableName,
			String tableNameTranslation, boolean isUseclientid, int client_Id,
			int org_Id, String p_PathDictionary) {

		if (!isFixedLength) {
			
			Writer csvoutput = null;
			BufferedWriter bufferedCsvoutput = null;
			
				try {
					csvoutput = new FileWriter(p_PathDictionary
							+ tableNameTranslation + ".csv");
				} catch (IOException e1) {

					e1.printStackTrace();
				}
				bufferedCsvoutput = new BufferedWriter(
						csvoutput);
				
				List<String> rfl = getRefList();

				PreparedStatement pstmt = null;
				ResultSet rs = null;

				String sql = sqlStatement(tableName, isUseclientid, client_Id, org_Id);
				try {

					pstmt = DB.prepareStatement(sql, null);
					rs = pstmt.executeQuery();

					while (rs.next())
						try {
							bufferedCsvoutput.write(buildRecord(rs, rfl));
						} catch (IOException e) {

							e.printStackTrace();
						}
					
					
					try {
						csvoutput.close();
					} catch (IOException e) {

						e.printStackTrace();
					}


				} catch (SQLException e) {
					log.log(Level.SEVERE, sql, e);
				} finally {
					DB.close(rs, pstmt);
					rs = null;
					pstmt = null;
				}

			
			ColumnIDList.clear();
		
		}

	}	

	private List<MColumn> getColumnList() {

		List<MColumn> cl = new ArrayList<MColumn>();

		for (Integer vc_id : ColumnIDList.getColumn_idlist()) {

			MColumn column = MColumn.get(Env.getCtx(), vc_id);

			if (column != null)
				cl.add(column);

		}

		return cl;

	}	
	
	private List<String> getRefList(){
		
		List<String> rfl = new ArrayList<String>();
		
		for (Integer vc_id : ColumnIDList.getColumn_idlist()) {

			MColumn column =  MColumn.get(Env.getCtx(), vc_id);

			if (column != null)
				rfl.add(column.getAD_Reference().getName());
			
			
		}
		
		return rfl;
		
	}

	
	private String sqlStatement(String tableName, boolean isUseclientid,
			int client_Id, int org_Id) {

		StringBuilder sql = new StringBuilder();

		ArrayList<String> columnlist = new ArrayList<String>();

		MTable table = MTable.get(Env.getCtx(), tableName);

		if (table != null) {

			sql.append("SELECT ");

			for (Integer vc_id : ColumnIDList.getColumn_idlist()) {

				MColumn column =  MColumn.get(Env.getCtx(), vc_id);

				if (column != null) {
					sql.append(column.getColumnName()).append(",");
					columnlist.add(column.getColumnName());
				}


			}

			// remove last ,
			sql.setLength(sql.length() - 1);

			sql.append(" from ");
			sql.append(table.getTableName());

			sql.append(" where ");

			if (columnlist.contains("DateAcct")) {

				sql.append("dateacct between '")
						.append(getValidity().getRange().getFrom()).append("'");
				sql.append(" and ");
				sql.append("'").append(getValidity().getRange().getTo())
						.append("'");

			} else if (columnlist.contains("DateOrdered")) {

				sql.append("dateordered between '")
						.append(getValidity().getRange().getFrom()).append("'");
				sql.append(" and ");
				sql.append("'").append(getValidity().getRange().getTo())
						.append("'");

			} else {

				sql.append("created between '")
						.append(getValidity().getRange().getFrom()).append("'");
				sql.append(" and ");
				sql.append("'").append(getValidity().getRange().getTo())
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
				sql.append("posted in ('b','p','Y')");
			}

		}

		return sql.toString();

	}	
	

	private String buildRecord(ResultSet rs, List<String> rfl) {

		StringBuilder record = new StringBuilder();

		try {

			int col = 1;

			for (String ref : rfl) {

				if (ref != null) {

					if ((ref.equals("ID")) || (ref.equals("Table Direct"))
							|| (ref.equals("Table"))
							|| (ref.equals("Search"))) {

						if (rs.getObject(col) == null)
							record.append("0");
						else
							record.append(rs.getObject(col).toString());

					} else if ((ref.equals("String")) || (ref.equals("Text"))
							|| (ref.equals("Text Long"))
							|| (ref.equals("Button"))) {

						if (getVariableLength().getTextEncapsulator() != null) {
							record.append(getVariableLength()
									.getTextEncapsulator());
						} else {
							record.append(DEFAUL_TEXT_ENCAPSULATOR);
						}

						if (rs.getObject(col) == null)
							record.append("");
						else
							record.append(clearText(rs.getObject(col)
									.toString()));

						if (getVariableLength().getTextEncapsulator() != null) {
							record.append(getVariableLength()
									.getTextEncapsulator());
						} else {
							record.append(DEFAUL_TEXT_ENCAPSULATOR);
						}

					} else if ((ref.equals("Numeric"))
							|| (ref.equals("Quantity"))
							|| (ref.equals("Amount"))
							|| (ref.equals("Integer"))) {

						// Numberformat
						StringBuilder no = new StringBuilder();
						Object number = rs.getObject(col);
						if (number != null)
							no.append(numberFormat.format(rs.getObject(col)));

						// DecimalSymbol
						if ((getDecimalSymbol() != null)
								&& !(no.toString().contains(getDecimalSymbol()))) {
							no.toString().replaceAll(DEFAULT_DECIMAL_SYMBOL,
									getDecimalSymbol());
						} else {
							StringBuilder dcs = new StringBuilder();
							dcs.append(numberFormat.getDecimalFormatSymbols()
									.getDecimalSeparator());
							no.toString().replaceAll(dcs.toString(),
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
							grs.append(numberFormat.getDecimalFormatSymbols()
									.getGroupingSeparator());

							no.toString().replaceAll(grs.toString(),
									DEFAULT_DIGIT_GROUPING_SYMBOL);
						}

						if (rs.getObject(col) == null)
							record.append("0");
						else
							record.append(no);

					} else if ((ref.equals("Date"))
							|| (ref.equals("Date+Time"))) {

						DateFormat df = new SimpleDateFormat("dd.MM.YYYY");

						if (rs.getObject(col) == null)
							record.append("00.00.0000");
						else
							record.append(df.format(rs.getObject(col)));

					} else {

						if (rs.getObject(col) == null)
							record.append("");
						else
							record.append(rs.getObject(col).toString());

					}

				}

				if (col < getColumnList().size()) {
					if (getVariableLength().getColumnDelimiter() != null) {
						record.append(getVariableLength().getColumnDelimiter());
					} else {
						record.append(DEFAULT_COLUMN_DELIMITER);
					}
				}

				col++;

			}

			if (getVariableLength().getRecordDelimiter() != null)
				record.append(getVariableLength().getRecordDelimiter());
			else
				record.append(DEFAULT_RECORD_DELIMITER);

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}

		return record.toString();

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