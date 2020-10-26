/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business.interfaces;

import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.RicercaUtentiCompilatoriModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriStep2Model;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.validation.annotation.Validated;

/**
 * 
 * @author 71027
 * 
 */

@Validated
public interface BusinessGestioneUtentiCompilatori {


	/**
	 * 
	 * @param utentiCompilatoriModel
	 * @param listaEntiAssociati
	 * @return
	 */
	UtentiCompilatoriModel insUtenteCompilatore(UtentiCompilatoriModel utentiCompilatoriModel,List<EntiCompilatoriModel> listaEntiAssociati,Integer prog);

	/**
	 * 
	 * @param ricercaUtentiCompilatoriModel
	 * @return
	 */
	List<UtentiCompilatoriModel> getUtentiCompilatori(RicercaUtentiCompilatoriModel ricercaUtentiCompilatoriModel);

	/**
	 * 
	 * @param idUtenteSel
	 * @return
	 */
	String disattivaAttivaUtenteCompilatore(Long idUtenteSel);

	/**
	 * 
	 * @param idUtenteSel
	 */
	void eliminaUtenteCompilatore(Long idUtenteSel);

	/**
	 * 
	 * @param idUtente
	 * @return
	 */
	UtentiCompilatoriModel getUtentiCompilatoriById(Long idUtente);

	/**
	 * 
	 * @param utentiCompilatoriStep2Model
	 * @return
	 */
	UtentiCompilatoriModel modificaUtenteCompilatore(UtentiCompilatoriStep2Model utentiCompilatoriStep2Model);

	/**
	 * 
	 * @param idUtente
	 * @return
	 */
	List<EntiCompilatoriModel> getListaEntiUtentiCompilatoriByIdUtente(Long idUtente);

	/**
	 * 
	 * @param email
	 * @param loginReg
	 * @param passwordReg
	 * @return
	 */
	String setCredenziali(String email, String loginReg, String passwordReg);

	/**
	 * 
	 * @param idUtenteCompilatoreConnesso
	 * @return
	 */
	List<EntiCompilatoriModel> getListaEntiCompilatoriByUtente(Long idUtenteCompilatoreConnesso);
	
	/**
	 * 
	 * @param codiceFiscale
	 * @return
	 */
	UtentiCompilatoriModel getUtenteCompilatoriByCodiceFiscale(String codiceFiscale);


	/**
	 * 
	 * @param mailTo
	 * @param mailDest
	 * @param Nome
	 * @param cognome
	 * @param Login
	 * @param Password
	 * @param listaEntiComp
	 * @throws MessagingException
	 */
	//void invioMailDaInserimentoUtenteCompilatore(String mailTo,String mailDest, String nome,
	//		String cognome, String login, String password,
	//		List<EntiCompilatoriModel> listaEntiComp) throws MessagingException;

	/**
	 * 
	 * @param idEnteGestore
	 * @return
	 */
	UtentiCompilatoriModel getUtenteCompilatoreFittizioByIdEnteGestore(Long idEnteGestore);

	void invioMailDaInserimentoUtenteCompilatore(String mailDest, String Nome,
			String cognome, String login, String password)
			throws MessagingException;

}
