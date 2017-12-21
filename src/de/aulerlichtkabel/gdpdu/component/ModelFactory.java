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


package de.aulerlichtkabel.gdpdu.component;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;

import de.aulerlichtkabel.gdpdu.model.MPAT_GDPdU;
import de.aulerlichtkabel.gdpdu.model.MPAT_GDPdU_Export_Def;
import de.aulerlichtkabel.gdpdu.model.MPAT_GDPdU_Export_TFields;


public class ModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		
		if (tableName.equals(MPAT_GDPdU_Export_Def.Table_Name)) {
			return MPAT_GDPdU_Export_Def.class;
		} else if (tableName.equals(MPAT_GDPdU_Export_TFields.Table_Name)) {
			return MPAT_GDPdU_Export_TFields.class;
		} else if (tableName.equals(MPAT_GDPdU.Table_Name)) {
			return MPAT_GDPdU.class;
		}

		//

		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		
		if (tableName.equals(MPAT_GDPdU_Export_Def.Table_Name)) {
			return new MPAT_GDPdU_Export_Def(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equals(MPAT_GDPdU_Export_TFields.Table_Name)) {
			return new MPAT_GDPdU_Export_TFields(Env.getCtx(), Record_ID, trxName);
		} else if (tableName.equals(MPAT_GDPdU.Table_Name)) {
			return new MPAT_GDPdU(Env.getCtx(), Record_ID, trxName);
		}		
		//
		
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		
		if (tableName.equals(MPAT_GDPdU_Export_Def.Table_Name)) {
			return new MPAT_GDPdU_Export_Def(Env.getCtx(), rs, trxName);
		} else if (tableName.equals(MPAT_GDPdU_Export_TFields.Table_Name)) {
			return new MPAT_GDPdU_Export_TFields(Env.getCtx(), rs, trxName);
		} else if (tableName.equals(MPAT_GDPdU.Table_Name)) {
			return new MPAT_GDPdU(Env.getCtx(), rs, trxName);
		}
		
		//	

		return null;
	}

}
