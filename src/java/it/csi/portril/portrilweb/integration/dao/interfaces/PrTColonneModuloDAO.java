/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.interfaces;

import it.csi.portril.portrilweb.integration.entity.PrTColonneModulo;

public interface  PrTColonneModuloDAO {
	/**
	 * 
	 * @param PrTColonneModulo
	 * @return PrTColonneModulo
	 */
	PrTColonneModulo create(PrTColonneModulo entity);
	/**
	 * 
	 * @param PrTColonneModulo
	 * @return PrTColonneModulo
	 */
	PrTColonneModulo update(PrTColonneModulo entity);
	/**
	 * 
	 * @param PrTColonneModulo
	 * @return PrTColonneModulo
	 */
	 void             delete(PrTColonneModulo entity);

}
