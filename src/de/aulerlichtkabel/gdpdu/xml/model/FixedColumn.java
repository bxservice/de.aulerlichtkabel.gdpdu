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

public class FixedColumn {
	
	private String name = null;
	private String Description = null;

	private Numeric numeric = null;
	private AlphaNumeric alphaNumeric = null;
	private Date date = null;
	
	private FixedColumn fixedColumn = null;
	private Map map = null;
	
	private String recordDelimiter = null;
	
	private FixedRange fixedRange = null;
	
	public FixedColumn() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the name
	 */
	@XmlElement(name="Name")
	public String getName() {
		return name;
		
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the description
	 */
	@XmlElement(name="Description")
	public String getDescription() {
		return Description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}


	public void setDate(){
		
		date = new Date();
	}
	
	@XmlElement(name="Date")
	public Date getDate(){
		
		return date;
	}

	
	public void setAlphaNumeric(){
		
		alphaNumeric = new AlphaNumeric();
		
	}
	
	@XmlElement(name="AlphaNumeric")
	public AlphaNumeric getAlphaNumeric(){
		
		return alphaNumeric;
		
	}

	
	public void setNumeric(){
		
		numeric = new Numeric();
		
	}
	
	
	@XmlElement(name="Numeric")
	public Numeric getNumeric(){
		
		return numeric;
		
	}


	/**
	 * @return the fixedColumn
	 */
	@XmlElement(name="FixedColumn")
	public FixedColumn getFixedColumn() {
		return fixedColumn;
	}


	/**
	 * @param fixedColumn the fixedColumn to set
	 */
	public void setFixedColumn(FixedColumn fixedColumn) {
		this.fixedColumn = fixedColumn;
	}

	public void setMap(){
		
		map = new Map();
		
	}
	
	
	@XmlElement(name="Map")
	public Map getMap(){
		
		return map;
		
	}


	/**
	 * @return the recordDelimiter
	 */
	public String getRecordDelimiter() {
		return recordDelimiter;
	}


	/**
	 * @param recordDelimiter the recordDelimiter to set
	 */
	public void setRecordDelimiter(String recordDelimiter) {
		this.recordDelimiter = recordDelimiter;
	}



	/**
	 * @return the fixedRange
	 */
	@XmlElement(name="FixedRange")
	public FixedRange getFixedRange() {
		return fixedRange;
	}


	/**
	 * @param fixedRange the fixedRange to set
	 */
	public void setFixedRange() {
		this.fixedRange = new FixedRange();
	}


	
}
