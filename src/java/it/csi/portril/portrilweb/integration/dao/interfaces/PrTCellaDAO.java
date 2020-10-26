/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.interfaces;


import java.math.BigDecimal;

import it.csi.portril.portrilweb.integration.entity.PrTCella;

public interface  PrTCellaDAO {
	/**
	 * 
	 * @param PrTCella
	 * @return PrTCella
	 */
	PrTCella create(PrTCella entity);
	/**
	 * 
	 * @param PrTCella
	 * @return PrTCella
	 */
	PrTCella update(PrTCella entity);
	/**
	 * 
	 * @param PrTCella
	 * @return void
	 */
	void     delete(PrTCella entity);
	
	/**
	 * 
	 * @param idRiga
	 * @return
	 */	
	int deleteCellaFromRiga(Long idRiga) ;
	
	/**
	 * 
	 * @param idModulo
	 * @return
	 */
	Long getNumCelleByIdModulo(Long idModulo);
	
}
