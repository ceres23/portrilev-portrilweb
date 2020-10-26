/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Utility;

import java.io.Serializable;



public class GenericModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4547631198625391855L;
/**
 * 
 * @param obj
 * @return
 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
}
