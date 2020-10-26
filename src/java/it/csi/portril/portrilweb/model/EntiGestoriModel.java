/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.model.validator.CodiceFiscale;
import it.csi.portril.portrilweb.model.validator.EMail;
import it.csi.portril.portrilweb.util.Utility;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class EntiGestoriModel extends GenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3133978308040714590L;

	private Long idEnteGestore;

	@CodiceFiscale(numChar={16,11},required=true)
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
	
	private String regione;

	private String stato;


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
	public String getStato() {
		return stato;
	}

	/**
	 * @param stato
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
}
