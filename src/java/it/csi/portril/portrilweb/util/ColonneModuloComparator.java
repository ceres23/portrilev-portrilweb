/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;
import it.csi.portril.portrilweb.model.ColonneModuloModel;

import java.io.Serializable;
import java.util.Comparator;

public class ColonneModuloComparator implements Comparator<ColonneModuloModel>,Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -590725831207464663L;

	public int compare(ColonneModuloModel p1, ColonneModuloModel p2) {
		if (p1.getPosizione().compareTo(p2.getPosizione()) < 0) { 
			return -1;
		} else if (p1.getPosizione().compareTo(p2.getPosizione()) > 0) {
			return 1;
		}
		return 0;
	}


}