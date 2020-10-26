/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.interfaces;

import it.csi.portril.portrilweb.integration.entity.PrTUtentiCompilatori;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

public interface PrTUtentiCompilatoriDAO {

	/**
	 * 
	 * @param PrTUtentiCompilatori
	 * @return PrTUtentiCompilatori
	 */
	PrTUtentiCompilatori create(PrTUtentiCompilatori entity);
	/**
	 * 
	 * @param PrTUtentiCompilatori
	 * @return PrTUtentiCompilatori
	 */
	PrTUtentiCompilatori update(PrTUtentiCompilatori entity);
	/**
	 * 
	 * @param PrTUtentiCompilatori
	 * @return void
	 */
	void                 delete(PrTUtentiCompilatori entity);
	/**
	 * 
	 * @param idEnteGestore
	 * @param nome
	 * @param cognome
	 * @param codiceFiscale
	 * @return List<PrTUtentiCompilatori>
	 */
	List<PrTUtentiCompilatori> getUtentiCompilatori(Long idEnteGestore,String nome, String cognome, String codiceFiscale);
	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	List<PrTUtentiCompilatori>  getUtenteCompilatoreByUsPW(String login,String password);
	/**
	 * 
	 * @param login
	 * @param password
	 * @param stato
	 * @return
	 */
	List<PrTUtentiCompilatori>  getUtenteCompilatoreByUsPwStato(String login,String password,String stato);

	
}
