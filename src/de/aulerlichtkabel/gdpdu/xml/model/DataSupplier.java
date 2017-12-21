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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder = {"name","location","comment"})
public class DataSupplier {

	  private String name = null;
	  private String location = null; 
	  private String comment = null;

	
	public DataSupplier() {
		// TODO Auto-generated constructor stub
	}

	

	  @XmlElement(name="Name")
	  public String getName(){
		return this.name;
	}
	  
	@XmlElement(name="Location")
	public String getLocation(){
		return location;
	}
	
	
	@XmlElement(name="Comment")
	public String getComment(){
		return comment;
	}


	
	  public void setName(String name){

		this.name=name;
	}	
	  
	
	public void setLocation(String location){
		
		this.location = location;
		
	}

	
	public void setComment(String comment){
		this.comment = comment;
	}
	

	
	
	
}
