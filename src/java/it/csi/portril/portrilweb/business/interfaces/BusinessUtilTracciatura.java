/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business.interfaces;

import it.csi.portril.portrilweb.model.UtentiGestoriModel;

import org.springframework.validation.annotation.Validated;

/**
 * 
 * @author 71027
 * 
 */

@Validated
public interface BusinessUtilTracciatura {

	/**
	 * 
	 * @param utentiGestoriModel
	 * @return
	 */
	void insertCsiLogAudit(UtentiGestoriModel utentiGestoriModel,String operazione ,String oggettoOperazione);

}
