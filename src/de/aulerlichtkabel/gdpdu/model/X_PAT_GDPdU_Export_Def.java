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
/** Generated Model - DO NOT CHANGE */
package de.aulerlichtkabel.gdpdu.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for PAT_GDPdU_Export_Def
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_PAT_GDPdU_Export_Def extends PO implements I_PAT_GDPdU_Export_Def, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200414L;

    /** Standard Constructor */
    public X_PAT_GDPdU_Export_Def (Properties ctx, int PAT_GDPdU_Export_Def_ID, String trxName)
    {
      super (ctx, PAT_GDPdU_Export_Def_ID, trxName);
      /** if (PAT_GDPdU_Export_Def_ID == 0)
        {
			setDecimalSymbol (null);
			setDescription (null);
			setDigitGroupingSymbol (null);
			setName (null);
			setPAT_GDPdU_Export_Def_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_PAT_GDPdU_Export_Def (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_PAT_GDPdU_Export_Def[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Table)MTable.get(getCtx(), org.compiere.model.I_AD_Table.Table_Name)
			.getPO(getAD_Table_ID(), get_TrxName());	}

	/** Set Table.
		@param AD_Table_ID 
		Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID)
	{
		if (AD_Table_ID < 1) 
			set_Value (COLUMNNAME_AD_Table_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
	}

	/** Get Table.
		@return Database Table information
	  */
	public int getAD_Table_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ColumnDelimiter.
		@param ColumnDelimiter ColumnDelimiter	  */
	public void setColumnDelimiter (String ColumnDelimiter)
	{
		set_Value (COLUMNNAME_ColumnDelimiter, ColumnDelimiter);
	}

	/** Get ColumnDelimiter.
		@return ColumnDelimiter	  */
	public String getColumnDelimiter () 
	{
		return (String)get_Value(COLUMNNAME_ColumnDelimiter);
	}

	/** Set Date From.
		@param DateFrom 
		Starting date for a range
	  */
	public void setDateFrom (Timestamp DateFrom)
	{
		set_Value (COLUMNNAME_DateFrom, DateFrom);
	}

	/** Get Date From.
		@return Starting date for a range
	  */
	public Timestamp getDateFrom () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateFrom);
	}

	/** Set Date To.
		@param DateTo 
		End date of a date range
	  */
	public void setDateTo (Timestamp DateTo)
	{
		set_Value (COLUMNNAME_DateTo, DateTo);
	}

	/** Get Date To.
		@return End date of a date range
	  */
	public Timestamp getDateTo () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateTo);
	}

	/** Set DecimalSymbol.
		@param DecimalSymbol DecimalSymbol	  */
	public void setDecimalSymbol (String DecimalSymbol)
	{
		set_Value (COLUMNNAME_DecimalSymbol, DecimalSymbol);
	}

	/** Get DecimalSymbol.
		@return DecimalSymbol	  */
	public String getDecimalSymbol () 
	{
		return (String)get_Value(COLUMNNAME_DecimalSymbol);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set DigitGroupingSymbol.
		@param DigitGroupingSymbol DigitGroupingSymbol	  */
	public void setDigitGroupingSymbol (String DigitGroupingSymbol)
	{
		set_Value (COLUMNNAME_DigitGroupingSymbol, DigitGroupingSymbol);
	}

	/** Get DigitGroupingSymbol.
		@return DigitGroupingSymbol	  */
	public String getDigitGroupingSymbol () 
	{
		return (String)get_Value(COLUMNNAME_DigitGroupingSymbol);
	}

	/** Set Epoch.
		@param Epoch Epoch	  */
	public void setEpoch (BigDecimal Epoch)
	{
		set_Value (COLUMNNAME_Epoch, Epoch);
	}

	/** Get Epoch.
		@return Epoch	  */
	public BigDecimal getEpoch () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Epoch);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set FixedLength.
		@param FixedLength FixedLength	  */
	public void setFixedLength (boolean FixedLength)
	{
		set_Value (COLUMNNAME_FixedLength, Boolean.valueOf(FixedLength));
	}

	/** Get FixedLength.
		@return FixedLength	  */
	public boolean isFixedLength () 
	{
		Object oo = get_Value(COLUMNNAME_FixedLength);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Comment/Help.
		@param Help 
		Comment or Hint
	  */
	public void setHelp (String Help)
	{
		set_Value (COLUMNNAME_Help, Help);
	}

	/** Get Comment/Help.
		@return Comment or Hint
	  */
	public String getHelp () 
	{
		return (String)get_Value(COLUMNNAME_Help);
	}

	/** Set Length.
		@param Length Length	  */
	public void setLength (BigDecimal Length)
	{
		set_Value (COLUMNNAME_Length, Length);
	}

	/** Get Length.
		@return Length	  */
	public BigDecimal getLength () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Length);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Command.
		@param PAT_Command Command	  */
	public void setPAT_Command (String PAT_Command)
	{
		set_Value (COLUMNNAME_PAT_Command, PAT_Command);
	}

	/** Get Command.
		@return Command	  */
	public String getPAT_Command () 
	{
		return (String)get_Value(COLUMNNAME_PAT_Command);
	}

	public org.compiere.model.I_AD_Column getPAT_DateColumn() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Column)MTable.get(getCtx(), org.compiere.model.I_AD_Column.Table_Name)
			.getPO(getPAT_DateColumn_ID(), get_TrxName());	}

	/** Set Date Filter.
		@param PAT_DateColumn_ID 
		The corresponding records will be filtered by this date column
	  */
	public void setPAT_DateColumn_ID (int PAT_DateColumn_ID)
	{
		if (PAT_DateColumn_ID < 1) 
			set_Value (COLUMNNAME_PAT_DateColumn_ID, null);
		else 
			set_Value (COLUMNNAME_PAT_DateColumn_ID, Integer.valueOf(PAT_DateColumn_ID));
	}

	/** Get Date Filter.
		@return The corresponding records will be filtered by this date column
	  */
	public int getPAT_DateColumn_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PAT_DateColumn_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Export Definition.
		@param PAT_GDPdU_Export_Def_ID Export Definition	  */
	public void setPAT_GDPdU_Export_Def_ID (int PAT_GDPdU_Export_Def_ID)
	{
		if (PAT_GDPdU_Export_Def_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_Export_Def_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_Export_Def_ID, Integer.valueOf(PAT_GDPdU_Export_Def_ID));
	}

	/** Get Export Definition.
		@return Export Definition	  */
	public int getPAT_GDPdU_Export_Def_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PAT_GDPdU_Export_Def_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PAT_GDPdU_Export_Def_UU.
		@param PAT_GDPdU_Export_Def_UU PAT_GDPdU_Export_Def_UU	  */
	public void setPAT_GDPdU_Export_Def_UU (String PAT_GDPdU_Export_Def_UU)
	{
		set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_Export_Def_UU, PAT_GDPdU_Export_Def_UU);
	}

	/** Get PAT_GDPdU_Export_Def_UU.
		@return PAT_GDPdU_Export_Def_UU	  */
	public String getPAT_GDPdU_Export_Def_UU () 
	{
		return (String)get_Value(COLUMNNAME_PAT_GDPdU_Export_Def_UU);
	}

	public I_PAT_GDPdU getPAT_GDPdU() throws RuntimeException
    {
		return (I_PAT_GDPdU)MTable.get(getCtx(), I_PAT_GDPdU.Table_Name)
			.getPO(getPAT_GDPdU_ID(), get_TrxName());	}

	/** Set GDPdU/GoBD Export.
		@param PAT_GDPdU_ID GDPdU/GoBD Export	  */
	public void setPAT_GDPdU_ID (int PAT_GDPdU_ID)
	{
		if (PAT_GDPdU_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_ID, Integer.valueOf(PAT_GDPdU_ID));
	}

	/** Get GDPdU/GoBD Export.
		@return GDPdU/GoBD Export	  */
	public int getPAT_GDPdU_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PAT_GDPdU_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Create Fields to Export.
		@param PAT_GetColumns Create Fields to Export	  */
	public void setPAT_GetColumns (String PAT_GetColumns)
	{
		set_Value (COLUMNNAME_PAT_GetColumns, PAT_GetColumns);
	}

	/** Get Create Fields to Export.
		@return Create Fields to Export	  */
	public String getPAT_GetColumns () 
	{
		return (String)get_Value(COLUMNNAME_PAT_GetColumns);
	}

	/** Set RecordDelimiter.
		@param RecordDelimiter RecordDelimiter	  */
	public void setRecordDelimiter (String RecordDelimiter)
	{
		set_Value (COLUMNNAME_RecordDelimiter, RecordDelimiter);
	}

	/** Get RecordDelimiter.
		@return RecordDelimiter	  */
	public String getRecordDelimiter () 
	{
		return (String)get_Value(COLUMNNAME_RecordDelimiter);
	}

	/** Set SkipNumBytes.
		@param SkipNumBytes SkipNumBytes	  */
	public void setSkipNumBytes (BigDecimal SkipNumBytes)
	{
		set_Value (COLUMNNAME_SkipNumBytes, SkipNumBytes);
	}

	/** Get SkipNumBytes.
		@return SkipNumBytes	  */
	public BigDecimal getSkipNumBytes () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_SkipNumBytes);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set TextEncapsulator.
		@param TextEncapsulator TextEncapsulator	  */
	public void setTextEncapsulator (String TextEncapsulator)
	{
		set_Value (COLUMNNAME_TextEncapsulator, TextEncapsulator);
	}

	/** Get TextEncapsulator.
		@return TextEncapsulator	  */
	public String getTextEncapsulator () 
	{
		return (String)get_Value(COLUMNNAME_TextEncapsulator);
	}

	/** Set URL.
		@param URL 
		Full URL address - e.g. http://www.idempiere.org
	  */
	public void setURL (String URL)
	{
		set_ValueNoCheck (COLUMNNAME_URL, URL);
	}

	/** Get URL.
		@return Full URL address - e.g. http://www.idempiere.org
	  */
	public String getURL () 
	{
		return (String)get_Value(COLUMNNAME_URL);
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}