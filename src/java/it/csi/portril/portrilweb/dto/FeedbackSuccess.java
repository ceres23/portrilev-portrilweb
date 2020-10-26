/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.dto;

import it.csi.portril.portrilweb.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class FeedbackSuccess extends GenericDTO{

	private static final long serialVersionUID = -1324809037237938057L;
	private boolean success=false;
	private boolean msgNotPresent=true;
	private boolean visuaizzaWarningSpecifici=false;
	
	private List<String> msgSuccess = new ArrayList<String>();
	
	private String  destinazione;
	

	/**
	 * @return
	 */
	public boolean isSuccess() {
		return success;
	}
	
	/**
	 * @param success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
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
	public List<String> getMsgSuccess() {
		return msgSuccess;
	}
	
	/**
	 * @param msgSuccess
	 */
	public void setMsgSuccess(List<String> msgSuccess) {
		this.msgSuccess = msgSuccess;
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
	 * @param msgSuccess
	 */
	public void addMsgSuccess(String msgSuccess) {
		List<String> listaMsgSuccess = getMsgSuccess();
		listaMsgSuccess.add(msgSuccess);
		setMsgSuccess(listaMsgSuccess);
	}
	
	/**
	 * @param msgSuccess
	 */
	public void addOneMsgSuccess(String msgSuccess) {
		List<String> listaMsgSuccess = new ArrayList<String>();
		listaMsgSuccess.add(msgSuccess);
		setMsgSuccess(listaMsgSuccess);
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
