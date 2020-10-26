/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business.interfaces;

import it.csi.portril.portrilweb.model.ProfiliUtentiModel;
import it.csi.portril.portrilweb.model.UtentiGestoriModel;

import java.util.List;

import org.springframework.validation.annotation.Validated;

/**
 * 
 * @author 71027
 * 
 */

@Validated
public interface BusinessGestioneUtentiGestori {
	/**
	 * 
	 * @param isProfiloUtente
	 * @return
	 */
	List<ProfiliUtentiModel> getProfiliGestore(Long isProfiloUtente);

	/**
	 * 
	 * @return
	 */
	List<ProfiliUtentiModel> getProfiliGestore();

	/**
	 * 
	 * @param utentiGestoriModel
	 * @return
	 */
	UtentiGestoriModel insUtenteGestore(UtentiGestoriModel utentiGestoriModel);

	/**
	 * 
	 * @param codiceFiscale
	 * @return
	 */
	ProfiliUtentiModel getProfiloGestorebyCodFis(String codiceFiscale);

	/**
	 * 
	 * @param codiceFiscale
	 * @return
	 */
	UtentiGestoriModel getUtenteGestorebyCodFis(String codiceFiscale);

	/**
	 * 
	 * @param idUtenteSel
	 * @return
	 */
	UtentiGestoriModel getUtenteGestorebyId(Long idUtenteSel);

	/**
	 * 
	 * @param cognome
	 * @param nome
	 * @param codiceFiscale
	 * @param idProfiloUtente
	 * @return
	 */
	List<UtentiGestoriModel> getUtentiGestore(String cognome, String nome,String codiceFiscale, String idProfiloUtente,Long idEnteGestore);

	/**
	 * 
	 * @param idUtenteSel
	 * @return
	 */
	String disattivaAttivaUtenteGestore(Long idUtenteSel);

	/**
	 * 
	 * @param idUtenteSel
	 */
	void eliminaUtenteGestore(Long idUtenteSel);

	/**
	 * 
	 * @param utentiGestoriModel
	 * @return
	 */
	UtentiGestoriModel modificaUtenteGestore(UtentiGestoriModel utentiGestoriModel);

}
