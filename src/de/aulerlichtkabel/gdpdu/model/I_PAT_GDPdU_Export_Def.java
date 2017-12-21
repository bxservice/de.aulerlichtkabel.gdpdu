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


package de.aulerlichtkabel.gdpdu.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for PAT_GDPdU_Export_Def
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_PAT_GDPdU_Export_Def 
{

    /** TableName=PAT_GDPdU_Export_Def */
    public static final String Table_Name = "PAT_GDPdU_Export_Def";

    /** AD_Table_ID=1000038 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name AD_Table_ID */
    public static final String COLUMNNAME_AD_Table_ID = "AD_Table_ID";

	/** Set Table.
	  * Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID);

	/** Get Table.
	  * Database Table information
	  */
	public int getAD_Table_ID();

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException;

    /** Column name ColumnDelimiter */
    public static final String COLUMNNAME_ColumnDelimiter = "ColumnDelimiter";

	/** Set ColumnDelimiter	  */
	public void setColumnDelimiter (String ColumnDelimiter);

	/** Get ColumnDelimiter	  */
	public String getColumnDelimiter();

    /** Column name Command */
    public static final String COLUMNNAME_Command = "Command";

	/** Set Command	  */
	public void setCommand (String Command);

	/** Get Command	  */
	public String getCommand();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name DateFrom */
    public static final String COLUMNNAME_DateFrom = "DateFrom";

	/** Set Date From.
	  * Starting date for a range
	  */
	public void setDateFrom (Timestamp DateFrom);

	/** Get Date From.
	  * Starting date for a range
	  */
	public Timestamp getDateFrom();

    /** Column name DateTo */
    public static final String COLUMNNAME_DateTo = "DateTo";

	/** Set Date To.
	  * End date of a date range
	  */
	public void setDateTo (Timestamp DateTo);

	/** Get Date To.
	  * End date of a date range
	  */
	public Timestamp getDateTo();

    /** Column name DecimalSymbol */
    public static final String COLUMNNAME_DecimalSymbol = "DecimalSymbol";

	/** Set DecimalSymbol	  */
	public void setDecimalSymbol (String DecimalSymbol);

	/** Get DecimalSymbol	  */
	public String getDecimalSymbol();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name DigitGroupingSymbol */
    public static final String COLUMNNAME_DigitGroupingSymbol = "DigitGroupingSymbol";

	/** Set DigitGroupingSymbol	  */
	public void setDigitGroupingSymbol (String DigitGroupingSymbol);

	/** Get DigitGroupingSymbol	  */
	public String getDigitGroupingSymbol();

    /** Column name Epoch */
    public static final String COLUMNNAME_Epoch = "Epoch";

	/** Set Epoch	  */
	public void setEpoch (BigDecimal Epoch);

	/** Get Epoch	  */
	public BigDecimal getEpoch();

    /** Column name FixedLength */
    public static final String COLUMNNAME_FixedLength = "FixedLength";

	/** Set FixedLength	  */
	public void setFixedLength (boolean FixedLength);

	/** Get FixedLength	  */
	public boolean isFixedLength();

    /** Column name Help */
    public static final String COLUMNNAME_Help = "Help";

	/** Set Comment/Help.
	  * Comment or Hint
	  */
	public void setHelp (String Help);

	/** Get Comment/Help.
	  * Comment or Hint
	  */
	public String getHelp();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Length */
    public static final String COLUMNNAME_Length = "Length";

	/** Set Length	  */
	public void setLength (BigDecimal Length);

	/** Get Length	  */
	public BigDecimal getLength();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name PAT_GDPdU_Export_Def_ID */
    public static final String COLUMNNAME_PAT_GDPdU_Export_Def_ID = "PAT_GDPdU_Export_Def_ID";

	/** Set PAT_GDPdU_Export_Def_ID	  */
	public void setPAT_GDPdU_Export_Def_ID (int PAT_GDPdU_Export_Def_ID);

	/** Get PAT_GDPdU_Export_Def_ID	  */
	public int getPAT_GDPdU_Export_Def_ID();

    /** Column name PAT_GDPdU_Export_Def_UU */
    public static final String COLUMNNAME_PAT_GDPdU_Export_Def_UU = "PAT_GDPdU_Export_Def_UU";

	/** Set PAT_GDPdU_Export_Def_UU	  */
	public void setPAT_GDPdU_Export_Def_UU (String PAT_GDPdU_Export_Def_UU);

	/** Get PAT_GDPdU_Export_Def_UU	  */
	public String getPAT_GDPdU_Export_Def_UU();

    /** Column name PAT_GDPdU_ID */
    public static final String COLUMNNAME_PAT_GDPdU_ID = "PAT_GDPdU_ID";

	/** Set PAT_GDPdU_ID	  */
	public void setPAT_GDPdU_ID (int PAT_GDPdU_ID);

	/** Get PAT_GDPdU_ID	  */
	public int getPAT_GDPdU_ID();

	public I_PAT_GDPdU getPAT_GDPdU() throws RuntimeException;

    /** Column name PAT_GetColumns */
    public static final String COLUMNNAME_PAT_GetColumns = "PAT_GetColumns";

	/** Set PAT_GetColumns	  */
	public void setPAT_GetColumns (String PAT_GetColumns);

	/** Get PAT_GetColumns	  */
	public String getPAT_GetColumns();

    /** Column name RecordDelimiter */
    public static final String COLUMNNAME_RecordDelimiter = "RecordDelimiter";

	/** Set RecordDelimiter	  */
	public void setRecordDelimiter (String RecordDelimiter);

	/** Get RecordDelimiter	  */
	public String getRecordDelimiter();

    /** Column name SkipNumBytes */
    public static final String COLUMNNAME_SkipNumBytes = "SkipNumBytes";

	/** Set SkipNumBytes	  */
	public void setSkipNumBytes (BigDecimal SkipNumBytes);

	/** Get SkipNumBytes	  */
	public BigDecimal getSkipNumBytes();

    /** Column name TextEncapsulator */
    public static final String COLUMNNAME_TextEncapsulator = "TextEncapsulator";

	/** Set TextEncapsulator	  */
	public void setTextEncapsulator (String TextEncapsulator);

	/** Get TextEncapsulator	  */
	public String getTextEncapsulator();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name URL */
    public static final String COLUMNNAME_URL = "URL";

	/** Set URL.
	  * Full URL address - e.g. http://www.idempiere.org
	  */
	public void setURL (String URL);

	/** Get URL.
	  * Full URL address - e.g. http://www.idempiere.org
	  */
	public String getURL();

    /** Column name Use_AD_Client_ID */
    public static final String COLUMNNAME_Use_AD_Client_ID = "Use_AD_Client_ID";

	/** Set Use_AD_Client_ID.
	  * Filter the information for the selected client
	  */
	public void setUse_AD_Client_ID (boolean Use_AD_Client_ID);

	/** Get Use_AD_Client_ID.
	  * Filter the information for the selected client
	  */
	public boolean isUse_AD_Client_ID();

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();
}
