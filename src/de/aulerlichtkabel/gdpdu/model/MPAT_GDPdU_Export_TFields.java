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

import java.sql.ResultSet;
import java.util.Properties;

public class MPAT_GDPdU_Export_TFields extends X_PAT_GDPdU_Export_TFields {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8407031934491326445L;

	public MPAT_GDPdU_Export_TFields(Properties ctx,
			int GDPdU_Export_TFields_ID, String trxName) {
		super(ctx, GDPdU_Export_TFields_ID, trxName);

	}

	public MPAT_GDPdU_Export_TFields(Properties ctx, ResultSet rs,
			String trxName) {
		super(ctx, rs, trxName);

	}
	

}
