/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Utility;

import java.util.List;


public class RicercaEntiCompilatoriModel extends GenericModel{

	
	private static final long serialVersionUID = 472869084570583613L;
	
	private Long idEnteSel;
	
	private Long idEnteGestore;
	
	private Long idEnteCompilatore;

	private String classificazione;

	private String comune;

	private String partitaIva;

	private String provincia;

	//private String istat;

	private String ragioneSociale;

	private String codiceFiscale;

	private boolean noMsg = false;

	private List<EntiCompilatoriModel> listaEntiCompilatori;
	
	/**
	 * @return
	 */
	public Long getIdEnteCompilatore() {
		return idEnteCompilatore;
	}

	/**
	 * @param idEnteCompilatore
	 */
	public void setIdEnteCompilatore(Long idEnteCompilatore) {
		this.idEnteCompilatore = idEnteCompilatore;
	}

	/**
	 * @return
	 */
	public Long getIdEnteSel() {
		return idEnteSel;
	}

	/**
	 * @param idEnteSel
	 */
	public void setIdEnteSel(Long idEnteSel) {
		this.idEnteSel = idEnteSel;
	}

	/**
	 * @return
	 */
	public String getComune() {
		return comune;
	}

	/**
	 * @param comune
	 */
	public void setComune(String comune) {
		this.comune = comune;
	}

	/**
	 * @return
	 */
	public String getPartitaIva() {
		return partitaIva;
	}

	/**
	 * @param partitaIva
	 */
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	/**
	 * @return
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	/**
	 * @return
	 */
	public String getRagioneSociale() {
		return ragioneSociale;
	}

	/**
	 * @param ragioneSociale
	 */
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	/**
	 * @return
	 */
	public List<EntiCompilatoriModel> getListaEntiCompilatori() {
		return listaEntiCompilatori;
	}

	/**
	 * @param listaEntiCompilatori
	 */
	public void setListaEntiCompilatori(List<EntiCompilatoriModel> listaEntiCompilatori) {
		this.listaEntiCompilatori = listaEntiCompilatori;
	}

	/**
	 * @return
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * @param codiceFiscale
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * @return
	 */
	public Long getIdEnteGestore() {
		return idEnteGestore;
	}

	/**
	 * @param idEnteGestore
	 */
	public void setIdEnteGestore(Long idEnteGestore) {
		this.idEnteGestore = idEnteGestore;
	}

	/**
	 * @return
	 */
	public String getClassificazione() {
		return classificazione;
	}

	/**
	 * @param classificazione
	 */
	public void setClassificazione(String classificazione) {
		this.classificazione = classificazione;
	}

	
	/**
	 * @return the noMsg
	 */
	public boolean isNoMsg() {
		return noMsg;
	}

	/**
	 * @param noMsg the noMsg to set
	 */
	public void setNoMsg(boolean noMsg) {
		this.noMsg = noMsg;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
}
