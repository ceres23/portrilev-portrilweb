/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Utility;

import java.util.Date;
import java.util.List;

public class UtentiCompilatoriStep2Model extends GenericModel{

	private static final long serialVersionUID = -5415116393124828508L;

	private String comune;

	private String mail;

	private String partitaIva;

	private String provincia;

	private String codiceFiscale;

	private String ragioneSociale;

	private Date  dataAgg;
	
	private String classificazione;
	
	private String regione;

	private String stato;

	private String collapse="in";
	
	private Long idEnteAssociato;
	
	private Long idEnteDisAssociato;

	private Long idUtenteCompilatore;
	
	private Long  idProfiloUtente;

	private Long idEnteGestore;
	
	private UtentiCompilatoriModel utentiCompilatoriModel = new UtentiCompilatoriModel();
	
	private  List<EntiCompilatoriModel> listaEntiCompilatoriRicercati;
	
	private  List<EntiCompilatoriModel> listaEntiAssociati;
	
	
	/**
	 * @return
	 */
	public Long getIdUtenteCompilatore() {
		return idUtenteCompilatore;
	}

	/**
	 * @param idUtenteCompilatore
	 */
	public void setIdUtenteCompilatore(Long idUtenteCompilatore) {
		this.idUtenteCompilatore = idUtenteCompilatore;
	}

	/**
	 * @return
	 */
	public String getCollapse() {
		return collapse;
	}

	/**
	 * @param collapse
	 */
	public void setCollapse(String collapse) {
		this.collapse = collapse;
	}

	/**
	 * @return
	 */
	public List<EntiCompilatoriModel> getListaEntiCompilatoriRicercati() {
		return listaEntiCompilatoriRicercati;
	}

	/**
	 * @param listaEntiCompilatoriRicercati
	 */
	public void setListaEntiCompilatoriRicercati(List<EntiCompilatoriModel> listaEntiCompilatoriRicercati) {
		this.listaEntiCompilatoriRicercati = listaEntiCompilatoriRicercati;
	}

	/**
	 * @return
	 */
	public List<EntiCompilatoriModel> getListaEntiAssociati() {
		return listaEntiAssociati;
	}

	/**
	 * @param listaEntiAssociati
	 */
	public void setListaEntiAssociati(List<EntiCompilatoriModel> listaEntiAssociati) {
		this.listaEntiAssociati = listaEntiAssociati;
	}

	/**
	 * @return
	 */
	public UtentiCompilatoriModel getUtentiCompilatoriModel() {
		return utentiCompilatoriModel;
	}

	/**
	 * @param utentiCompilatoriModel
	 */
	public void setUtentiCompilatoriModel(
			UtentiCompilatoriModel utentiCompilatoriModel) {
		this.utentiCompilatoriModel = utentiCompilatoriModel;
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
	public String getRegione() {
		return regione;
	}

	/**
	 * @param regione
	 */
	public void setRegione(String regione) {
		this.regione = regione;
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
	public Long getIdEnteAssociato() {
		return idEnteAssociato;
	}

	/**
	 * @param idEnteAssociato
	 */
	public void setIdEnteAssociato(Long idEnteAssociato) {
		this.idEnteAssociato = idEnteAssociato;
	}

	/**
	 * @return
	 */
	public Long getIdEnteDisAssociato() {
		return idEnteDisAssociato;
	}

	/**
	 * @param idEnteDisAssociato
	 */
	public void setIdEnteDisAssociato(Long idEnteDisAssociato) {
		this.idEnteDisAssociato = idEnteDisAssociato;
	}
	
	/**
	 * @return
	 */
	public Long getIdProfiloUtente() {
		return idProfiloUtente;
	}

	/**
	 * @param idProfiloUtente
	 */
	public void setIdProfiloUtente(Long idProfiloUtente) {
		this.idProfiloUtente = idProfiloUtente;
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
	 * @return the classificazione
	 */
	/**
	 * @return
	 */
	public String getClassificazione() {
		return classificazione;
	}

	/**
	 * @param classificazione the classificazione to set
	 */
	/**
	 * @param classificazione
	 */
	public void setClassificazione(String classificazione) {
		this.classificazione = classificazione;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
	
}
