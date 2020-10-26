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
public interface BusinessGestioneProfiloCompilatore {

	/**
	 * 
	 * @param utente
	 * @param password
	 * @return
	 */
	UtentiCompilatoriModel resettaPwCompilatore(UtentiCompilatoriModel utente,String password);

}