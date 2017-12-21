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

/** Generated Model - DO NOT CHANGE */
package de.aulerlichtkabel.gdpdu.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for PAT_GDPdU_Export_TFields
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_PAT_GDPdU_Export_TFields extends PO implements I_PAT_GDPdU_Export_TFields, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20171215L;

    /** Standard Constructor */
    public X_PAT_GDPdU_Export_TFields (Properties ctx, int PAT_GDPdU_Export_TFields_ID, String trxName)
    {
      super (ctx, PAT_GDPdU_Export_TFields_ID, trxName);
      /** if (PAT_GDPdU_Export_TFields_ID == 0)
        {
			setPAT_GDPdU_Export_TFields_ID (0);
			setSequence (0);
// 10
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_PAT_GDPdU_Export_TFields (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_PAT_GDPdU_Export_TFields[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Column getAD_Column() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Column)MTable.get(getCtx(), org.compiere.model.I_AD_Column.Table_Name)
			.getPO(getAD_Column_ID(), get_TrxName());	}

	/** Set Column.
		@param AD_Column_ID 
		Column in the table
	  */
	public void setAD_Column_ID (int AD_Column_ID)
	{
		if (AD_Column_ID < 1) 
			set_Value (COLUMNNAME_AD_Column_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Column_ID, Integer.valueOf(AD_Column_ID));
	}

	/** Get Column.
		@return Column in the table
	  */
	public int getAD_Column_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Column_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set MapTo.
		@param MapTo MapTo	  */
	public void setMapTo (String MapTo)
	{
		set_Value (COLUMNNAME_MapTo, MapTo);
	}

	/** Get MapTo.
		@return MapTo	  */
	public String getMapTo () 
	{
		return (String)get_Value(COLUMNNAME_MapTo);
	}

	public I_PAT_GDPdU_Export_Def getPAT_GDPdU_Export_Def() throws RuntimeException
    {
		return (I_PAT_GDPdU_Export_Def)MTable.get(getCtx(), I_PAT_GDPdU_Export_Def.Table_Name)
			.getPO(getPAT_GDPdU_Export_Def_ID(), get_TrxName());	}

	/** Set PAT_GDPdU_Export_Def_ID.
		@param PAT_GDPdU_Export_Def_ID PAT_GDPdU_Export_Def_ID	  */
	public void setPAT_GDPdU_Export_Def_ID (int PAT_GDPdU_Export_Def_ID)
	{
		if (PAT_GDPdU_Export_Def_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_Export_Def_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_Export_Def_ID, Integer.valueOf(PAT_GDPdU_Export_Def_ID));
	}

	/** Get PAT_GDPdU_Export_Def_ID.
		@return PAT_GDPdU_Export_Def_ID	  */
	public int getPAT_GDPdU_Export_Def_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PAT_GDPdU_Export_Def_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PAT_GDPdU_Export_TFields_ID.
		@param PAT_GDPdU_Export_TFields_ID PAT_GDPdU_Export_TFields_ID	  */
	public void setPAT_GDPdU_Export_TFields_ID (int PAT_GDPdU_Export_TFields_ID)
	{
		if (PAT_GDPdU_Export_TFields_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_Export_TFields_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_Export_TFields_ID, Integer.valueOf(PAT_GDPdU_Export_TFields_ID));
	}

	/** Get PAT_GDPdU_Export_TFields_ID.
		@return PAT_GDPdU_Export_TFields_ID	  */
	public int getPAT_GDPdU_Export_TFields_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PAT_GDPdU_Export_TFields_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PAT_GDPdU_Export_TFields_UU.
		@param PAT_GDPdU_Export_TFields_UU PAT_GDPdU_Export_TFields_UU	  */
	public void setPAT_GDPdU_Export_TFields_UU (String PAT_GDPdU_Export_TFields_UU)
	{
		set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_Export_TFields_UU, PAT_GDPdU_Export_TFields_UU);
	}

	/** Get PAT_GDPdU_Export_TFields_UU.
		@return PAT_GDPdU_Export_TFields_UU	  */
	public String getPAT_GDPdU_Export_TFields_UU () 
	{
		return (String)get_Value(COLUMNNAME_PAT_GDPdU_Export_TFields_UU);
	}

	/** Set Sequence.
		@param Sequence Sequence	  */
	public void setSequence (int Sequence)
	{
		set_Value (COLUMNNAME_Sequence, Integer.valueOf(Sequence));
	}

	/** Get Sequence.
		@return Sequence	  */
	public int getSequence () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Sequence);
		if (ii == null)
			 return 0;
		return ii.intValue();
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