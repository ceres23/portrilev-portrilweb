/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Utility;

import java.util.List;

public class MenuCompilatoreModel extends GenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5739073427567194810L;

	//UtentiCompilatoriModel utenteCompilatoreModel = new UtentiCompilatoriModel();
	
	boolean utenteMonoEnteCompilatore;
	Long idEnteCompilatoreSel;
	Long idEnteCompilatoreDaSel;
	List<EntiCompilatoriModel> listaEntiCompilatori;
	private Boolean pwOk = false;
	
	/**
	 * @return
	 */
	public boolean isUtenteMonoEnteCompilatore() {
		return utenteMonoEnteCompilatore;
	}
	/**
	 * @param utenteMonoEnteCompilatore
	 */
	public void setUtenteMonoEnteCompilatore(boolean utenteMonoEnteCompilatore) {
		this.utenteMonoEnteCompilatore = utenteMonoEnteCompilatore;
	}
	/**
	 * @return
	 */
	public Long getIdEnteCompilatoreSel() {
		return idEnteCompilatoreSel;
	}
	/**
	 * @param idEnteCompilatoreSel
	 */
	public void setIdEnteCompilatoreSel(Long idEnteCompilatoreSel) {
		this.idEnteCompilatoreSel = idEnteCompilatoreSel;
	}
	/**
	 * @return
	 */
	public Long getIdEnteCompilatoreDaSel() {
		return idEnteCompilatoreDaSel;
	}
	/**
	 * @param idEnteCompilatoreDaSel
	 */
	public void setIdEnteCompilatoreDaSel(Long idEnteCompilatoreDaSel) {
		this.idEnteCompilatoreDaSel = idEnteCompilatoreDaSel;
	}
	/*
	public UtentiCompilatoriModel getUtenteCompilatoreModel() {
		return utenteCompilatoreModel;
	}
	public void setUtenteCompilatoreModel(
			UtentiCompilatoriModel utenteCompilatoreModel) {
		this.utenteCompilatoreModel = utenteCompilatoreModel;
	}
	*/
	/**
	 * @return
	 */
	public List<EntiCompilatoriModel> getListaEntiCompilatori() {
		return listaEntiCompilatori;
	}
	/**
	 * @param listaEntiCompilatori
	 */
	public void setListaEntiCompilatori(
			List<EntiCompilatoriModel> listaEntiCompilatori) {
		this.listaEntiCompilatori = listaEntiCompilatori;
	}
	
	
	/**
	 * @return the pwOk
	 */
	public Boolean getPwOk() {
		return pwOk;
	}
	/**
	 * @param pwOk the pwOk to set
	 */
	public void setPwOk(Boolean pwOk) {
		this.pwOk = pwOk;
	}
	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
}
