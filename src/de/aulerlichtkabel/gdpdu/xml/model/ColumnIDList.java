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

public class ColumnIDList {
	
	private static List<Integer> Column_idlist = new ArrayList<Integer>();

	public ColumnIDList() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the column_idlist
	 */
	public static List<Integer> getColumn_idlist() {
		return Column_idlist;
	}

	/**
	 * @param column_idlist the column_idlist to set
	 */
	public static void setColumn_idlist(List<Integer> column_idlist) {
		Column_idlist = column_idlist;
	}
	
	public static void addColumn_id(Integer column_id) {
		Column_idlist.add(column_id);
	}

	public static void clear() {
		Column_idlist.clear();
	}
	
}
