/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.model.validator.CodiceFiscale;
import it.csi.portril.portrilweb.model.validator.EMail;
import it.csi.portril.portrilweb.util.UtilDate;
import it.csi.portril.portrilweb.util.Utility;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class EntiCompilatoriModel extends GenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3133978308040714590L;

	private Long idEnteCompilatore;
	
	private List<Long> listaIdEnteGestore;

	@CodiceFiscale(required=true)
	private String codiceFiscale;

	@NotNull
	@Size(min=1)
	private String comune;

	@EMail(required=true)
	private String mail;

	//private String mail2;
	@NotNull
	@Size(min=11,max=11)
	private String partitaIva;

	private String provincia;
	
	@NotNull
	@Size(min=3)
	private String ragioneSociale;

	private Date  dataAgg;
	
	private String classificazione;

	private String stato;

	private String checked;
	
	private String moduloEnteValidato;

	private String moduloEnteConfermato;

	private UtentiCompilatoriModel ultimoUtenteCompilatore;

	private boolean moduloCompilato=false;

	
	
	/**
	 * @return the listaIdEnteGestore
	 */
	public List<Long> getListaIdEnteGestore() {
		return listaIdEnteGestore;
	}

	/**
	 * @param listaIdEnteGestore the listaIdEnteGestore to set
	 */
	public void setListaIdEnteGestore(List<Long> listaIdEnteGestore) {
		this.listaIdEnteGestore = listaIdEnteGestore;
	}

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
	 * @return the classificazione
	 */
	public String getClassificazione() {
		return classificazione;
	}

	/**
	 * @param classificazione the classificazione to set
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
	public boolean isModuloCompilato() {
		return moduloCompilato;
	}

	/**
	 * @param moduloCompilato
	 */
	public void setModuloCompilato(boolean moduloCompilato) {
		this.moduloCompilato = moduloCompilato;
	}

	/**
	 * @return
	 */
	public UtentiCompilatoriModel getUltimoUtenteCompilatore() {
		return ultimoUtenteCompilatore;
	}

	/**
	 * @param ultimoUtenteCompilatore
	 */
	public void setUltimoUtenteCompilatore(UtentiCompilatoriModel ultimoUtenteCompilatore) {
		this.ultimoUtenteCompilatore = ultimoUtenteCompilatore;
	}

	/**
	 * @return
	 */
	public String getChecked() {
		return checked;
	}

	/**
	 * @param checked
	 */
	public void setChecked(String checked) {
		this.checked = checked;
	}

	
	/**
	 * @return the moduloEnteValidato
	 */
	public String getModuloEnteValidato() {
		return moduloEnteValidato;
	}

	/**
	 * @param moduloEnteValidato the moduloEnteValidato to set
	 */
	public void setModuloEnteValidato(String moduloEnteValidato) {
		this.moduloEnteValidato = moduloEnteValidato;
	}

	
	/**
	 * @return the moduloEnteConfermato
	 */
	public String getModuloEnteConfermato() {
		return moduloEnteConfermato;
	}

	/**
	 * @param moduloEnteConfermato the moduloEnteConfermato to set
	 */
	public void setModuloEnteConfermato(String moduloEnteConfermato) {
		this.moduloEnteConfermato = moduloEnteConfermato;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
	
}
