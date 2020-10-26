/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.dto;

import it.csi.portril.portrilweb.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class FeedbackWarning extends GenericDTO{

	private static final long serialVersionUID = -1324809037237938057L;
	private boolean warning=false;
	private boolean msgNotPresent;
	private boolean visuaizzaWarningSpecifici=true;
	private List<String> msgWarning = new ArrayList<String>();
	private String  destinazione;
	
	/**
	 * @return
	 */
	public boolean isWarning() {
		return warning;
	}
	
	/**
	 * @param warning
	 */
	public void setWarning(boolean warning) {
		this.warning = warning;
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
	public List<String> getMsgWarning() {
		return msgWarning;
	}
	
	/**
	 * @param msgWarning
	 */
	public void setMsgWarning(List<String> msgWarning) {
		this.msgWarning = msgWarning;
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
	 * @param msgWarning
	 */
	public void addMsgWarning(String msgWarning) {
		List<String> listaWarning = getMsgWarning();
		listaWarning.add(msgWarning);
		setMsgWarning(listaWarning);
	}
	
	/**
	 * @param msgWarning
	 */
	public void addOneMsgWarning(String msgWarning) {
		List<String> listaWarning = new ArrayList<String>();
		listaWarning.add(msgWarning);
		setMsgWarning(listaWarning);
	}
	
	
	/**
	 * @return the visuaizzaWarningSpecifici
	 */
	public boolean isVisuaizzaWarningSpecifici() {
		return visuaizzaWarningSpecifici;
	}

	/**
	 * @param visuaizzaWarningSpecifici the visuaizzaWarningSpecifici to set
	 */
	public void setVisuaizzaWarningSpecifici(boolean visuaizzaWarningSpecifici) {
		this.visuaizzaWarningSpecifici = visuaizzaWarningSpecifici;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Utility.fieldsToString(this);
	}
	
}
