/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.model.validator.CodiceFiscale;
import it.csi.portril.portrilweb.util.UtilDate;
import it.csi.portril.portrilweb.util.Utility;

import java.util.Date;
import java.util.List;

public class VisualizzaDatiEnteModel extends GenericModel{

	private static final long serialVersionUID = -113736530164849292L;

	private Long modEnte;
	
	private Long idEnteCompilatore;
	
	private Long idEnteGestore;

	@CodiceFiscale(numChar={16,11},required=false)
	private String codiceFiscale;

	private String comune;

	private String mail;

	private String partitaIva;

	private String provincia;

	//private String istat;

	private String ragioneSociale;
	
	private Date  dataAgg;
	
	private String classificazione;

	private String stato;
	
	private String idEnteSel;
	
	private List<EntiCompilatoriModel> listaEntiCompilatori;
	
	private ModuliModel moduliModel;
	
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
	public String getMail() {
		return mail;
	}


	/**
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
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
	public Date getDataAgg() {
		return dataAgg;
	}


	/**
	 * @param dataAgg
	 */
	public void setDataAgg(Date dataAgg) {
		this.dataAgg = dataAgg;
	}

	/**
	 * @return
	 */
	public String getDataAggStr() {
		return UtilDate.formatDate(getDataAgg());
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
	 * @return
	 */
	public String getStato() {
		return stato;
	}


	/**
	 * @param stato
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}


	/**
	 * @return
	 */
	public String getIdEnteSel() {
		return idEnteSel;
	}


	/**
	 * @param idEnteSel
	 */
	public void setIdEnteSel(String idEnteSel) {
		this.idEnteSel = idEnteSel;
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
	public Long getModEnte() {
		return modEnte;
	}


	/**
	 * @param modEnte
	 */
	public void setModEnte(Long modEnte) {
		this.modEnte = modEnte;
	}


	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}


	/**
	 * @return the moduliModel
	 */
	public ModuliModel getModuliModel() {
		return moduliModel;
	}


	/**
	 * @param moduliModel the moduliModel to set
	 */
	public void setModuliModel(ModuliModel moduliModel) {
		this.moduliModel = moduliModel;
	}

}
