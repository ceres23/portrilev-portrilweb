/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.interfaces;
import java.util.List;

import it.csi.portril.portrilweb.integration.entity.PrTUtentiGestori;

public interface  PrTUtentiGestoriDAO {
	
	/**
	 * 
	 * @param PrTUtentiGestori
	 * @return PrTUtentiGestori
	 */
	PrTUtentiGestori create(PrTUtentiGestori entity);
	/**
	 * 
	 * @param PrTUtentiGestori
	 * @return PrTUtentiGestori
	 */
	PrTUtentiGestori update(PrTUtentiGestori entity);
	 /**
	 * 
	 * @param PrTUtentiGestori
	 * @return void
	 */
	void             delete(PrTUtentiGestori entity);
	
	/**
	 * 
	 * @param cognome
	 * @param nome
	 * @param codFisc
	 * @param idProfiloUtente
	 * @param idEnteGestore
	 * @return
	 */
	List<PrTUtentiGestori> getUtentiGestore(String cognome,
			String nome, String codFisc, Long idProfiloUtente,
			Long idEnteGestore);

}
