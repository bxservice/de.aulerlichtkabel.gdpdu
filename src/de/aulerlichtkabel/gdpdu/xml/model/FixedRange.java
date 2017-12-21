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

public class FixedRange {
	
	private Integer from = null;
	private Integer to = null;
	private Integer length = null;

	public FixedRange() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the from
	 */
	@XmlElement(name="From")
	public Integer getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(Integer from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	@XmlElement(name="To")
	public Integer getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(Integer to) {
		this.to = to;
	}

	/**
	 * @return the length
	 */
	@XmlElement(name="Length")
	public Integer getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

}
