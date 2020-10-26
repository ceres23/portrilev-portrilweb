/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.dto;

import it.csi.portril.portrilweb.util.Utility;

import java.io.Serializable;



public class GenericDTO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3886949404175023884L;

	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
}
