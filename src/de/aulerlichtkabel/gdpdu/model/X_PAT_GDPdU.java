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

/** Generated Model for PAT_GDPdU
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_PAT_GDPdU extends PO implements I_PAT_GDPdU, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20161208L;

    /** Standard Constructor */
    public X_PAT_GDPdU (Properties ctx, int PAT_GDPdU_ID, String trxName)
    {
      super (ctx, PAT_GDPdU_ID, trxName);
      /** if (PAT_GDPdU_ID == 0)
        {
			setPAT_GDPdU_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_PAT_GDPdU (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_PAT_GDPdU[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_C_Location getC_Location() throws RuntimeException
    {
		return (I_C_Location)MTable.get(getCtx(), I_C_Location.Table_Name)
			.getPO(getC_Location_ID(), get_TrxName());	}

	/** Set Address.
		@param C_Location_ID 
		Location or Address
	  */
	public void setC_Location_ID (int C_Location_ID)
	{
		if (C_Location_ID < 1) 
			set_Value (COLUMNNAME_C_Location_ID, null);
		else 
			set_Value (COLUMNNAME_C_Location_ID, Integer.valueOf(C_Location_ID));
	}

	/** Get Address.
		@return Location or Address
	  */
	public int getC_Location_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Location_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Command.
		@param Command Command	  */
	public void setCommand (String Command)
	{
		set_Value (COLUMNNAME_Command, Command);
	}

	/** Get Command.
		@return Command	  */
	public String getCommand () 
	{
		return (String)get_Value(COLUMNNAME_Command);
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

	/** Set PAT_GDPdU_ID.
		@param PAT_GDPdU_ID PAT_GDPdU_ID	  */
	public void setPAT_GDPdU_ID (int PAT_GDPdU_ID)
	{
		if (PAT_GDPdU_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_ID, Integer.valueOf(PAT_GDPdU_ID));
	}

	/** Get PAT_GDPdU_ID.
		@return PAT_GDPdU_ID	  */
	public int getPAT_GDPdU_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PAT_GDPdU_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PAT_GDPdU_UU.
		@param PAT_GDPdU_UU PAT_GDPdU_UU	  */
	public void setPAT_GDPdU_UU (String PAT_GDPdU_UU)
	{
		set_ValueNoCheck (COLUMNNAME_PAT_GDPdU_UU, PAT_GDPdU_UU);
	}

	/** Get PAT_GDPdU_UU.
		@return PAT_GDPdU_UU	  */
	public String getPAT_GDPdU_UU () 
	{
		return (String)get_Value(COLUMNNAME_PAT_GDPdU_UU);
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

	/** Set Version.
		@param Version 
		Version of the table definition
	  */
	public void setVersion (String Version)
	{
		set_Value (COLUMNNAME_Version, Version);
	}

	/** Get Version.
		@return Version of the table definition
	  */
	public String getVersion () 
	{
		return (String)get_Value(COLUMNNAME_Version);
	}
}