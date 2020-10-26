/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business.interfaces.compilatori;

import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;

import org.springframework.validation.annotation.Validated;

/**
 * 
 * @author 71027
 *
 */

@Validated
public interface BusinessGestioneLoginCompilatore {
	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	UtentiCompilatoriModel getUtenteCompilatoreByUsPW(String login,String password);
		
	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	UtentiCompilatoriModel getUtenteCompilatoreByLogin(String login);

	/**
	 * 
	 * @param login
	 * @param password
	 * @param stato
	 * @return
	 */
	UtentiCompilatoriModel getUtenteCompilatoreByUsPwStato(String login,String password,String stato);

}
