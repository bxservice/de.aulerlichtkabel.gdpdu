/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package de.aulerlichtkabel.gdpdu.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for PAT_GDPdU_Export_Def
 *  @author iDempiere (generated) 
 *  @version Release 7.1
 */
@SuppressWarnings("all")
public interface I_PAT_GDPdU_Export_Def 
{

    /** TableName=PAT_GDPdU_Export_Def */
    public static final String Table_Name = "PAT_GDPdU_Export_Def";

    /** AD_Table_ID=1000059 */
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

    /** Column name PAT_Command */
    public static final String COLUMNNAME_PAT_Command = "PAT_Command";

	/** Set Command	  */
	public void setPAT_Command (String PAT_Command);

	/** Get Command	  */
	public String getPAT_Command();

    /** Column name PAT_DateColumn_ID */
    public static final String COLUMNNAME_PAT_DateColumn_ID = "PAT_DateColumn_ID";

	/** Set Date Filter.
	  * The corresponding records will be filtered by this date column
	  */
	public void setPAT_DateColumn_ID (int PAT_DateColumn_ID);

	/** Get Date Filter.
	  * The corresponding records will be filtered by this date column
	  */
	public int getPAT_DateColumn_ID();

	public org.compiere.model.I_AD_Column getPAT_DateColumn() throws RuntimeException;

    /** Column name PAT_GDPdU_Export_Def_ID */
    public static final String COLUMNNAME_PAT_GDPdU_Export_Def_ID = "PAT_GDPdU_Export_Def_ID";

	/** Set Export Definition	  */
	public void setPAT_GDPdU_Export_Def_ID (int PAT_GDPdU_Export_Def_ID);

	/** Get Export Definition	  */
	public int getPAT_GDPdU_Export_Def_ID();

    /** Column name PAT_GDPdU_Export_Def_UU */
    public static final String COLUMNNAME_PAT_GDPdU_Export_Def_UU = "PAT_GDPdU_Export_Def_UU";

	/** Set PAT_GDPdU_Export_Def_UU	  */
	public void setPAT_GDPdU_Export_Def_UU (String PAT_GDPdU_Export_Def_UU);

	/** Get PAT_GDPdU_Export_Def_UU	  */
	public String getPAT_GDPdU_Export_Def_UU();

    /** Column name PAT_GDPdU_ID */
    public static final String COLUMNNAME_PAT_GDPdU_ID = "PAT_GDPdU_ID";

	/** Set GDPdU/GoBD Export	  */
	public void setPAT_GDPdU_ID (int PAT_GDPdU_ID);

	/** Get GDPdU/GoBD Export	  */
	public int getPAT_GDPdU_ID();

	public I_PAT_GDPdU getPAT_GDPdU() throws RuntimeException;

    /** Column name PAT_GetColumns */
    public static final String COLUMNNAME_PAT_GetColumns = "PAT_GetColumns";

	/** Set Create Fields to Export	  */
	public void setPAT_GetColumns (String PAT_GetColumns);

	/** Get Create Fields to Export	  */
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
