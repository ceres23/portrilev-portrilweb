/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.dto;

import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.util.Utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.ObjectError;

/**
 * @author 71027
 *
 */

public class FeedbackError extends GenericDTO{

	private static final long serialVersionUID = -7311313600679334352L;
	private boolean errorePresente=false;
	private boolean msgNotPresent=true;
	private boolean visuaizzaErroriSpecifici=false;
	private String  destinazione;
	
	private  LogUtil log = new LogUtil(getClass());
	
	private List<String> listaMsgErrori  = new ArrayList<String>();
	
	
	/**
	 * @return
	 */
	public boolean isErrorePresente() {
		return errorePresente;
	}
	
	/**
	 * @param errorePresente
	 */
	public void setErrorePresente(boolean errorePresente) {
		this.errorePresente = errorePresente;
	}
	
	/**
	 * @return
	 */
	public boolean isMsgNotPresent() {
		return msgNotPresent;
	}
	
	/**
	 * @param msgNotPresent
	 */
	public void setMsgNotPresent(boolean msgNotPresent) {
		this.msgNotPresent = msgNotPresent;
	}
	
	/**
	 * @return
	 */
	public String getDestinazione() {
		return destinazione;
	}
	
	/**
	 * @param destinazione
	 */
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	
	/**
	 * @param msgErrori
	 */
	public void addMsgErrore(String msgErrori) {
		listaMsgErrori.add(msgErrori);
	}
	
	/**
	 * @param allErrors
	 */
	public void addMsgErrori(List<ObjectError> allErrors) {
		log.info("addMsgErrori " ,"start");

		for(int i=0; i<allErrors.size();i++){
			log.info("addMsgErrori " ,"add err "+ allErrors.get(i).toString());
			listaMsgErrori.add(allErrors.get(i).getDefaultMessage());
		}	
	}
	
	
	/**
	 * @return the listaMsgErrori
	 */
	public List<String> getListaMsgErrori() {
		return listaMsgErrori;
	}

	/**
	 * @param listaMsgErrori
	 */
	public void setListaMsgErrori(List<String> listaMsgErrori) {
		this.listaMsgErrori = listaMsgErrori;
	}

	/**
	 * @return
	 */
	public boolean isVisuaizzaErroriSpecifici() {
		return visuaizzaErroriSpecifici;
	}
	
	/**
	 * @param visuaizzaErroriSpecifici
	 */
	public void setVisuaizzaErroriSpecifici(boolean visuaizzaErroriSpecifici) {
		this.visuaizzaErroriSpecifici = visuaizzaErroriSpecifici;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Utility.fieldsToString(this);
	}
	
	/**
	 * @return String
	 */
	public String toStringErr() {
		return Utility.fieldsToString(listaMsgErrori);
	}

}




