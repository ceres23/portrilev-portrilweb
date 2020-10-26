/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;
import it.csi.portril.portrilweb.model.validator.CodiceFiscale;
import it.csi.portril.portrilweb.model.validator.EMail;
import it.csi.portril.portrilweb.util.Utility;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UtentiGestoriModel  extends GenericModel{

	private static final long serialVersionUID = 4781824687461896457L;

	private Long idUtenteGestore;

	@CodiceFiscale(required=true)
	private String codiceFiscale;

	@NotNull
	@Size(min=3)	
	private String cognome;
	
	@EMail(required=true)
	private String mail;

	@NotNull
	@Size(min=3)
	private String nome;

	@NotNull
	@Size(min=1)
	private String stato="ATTIVO";

	@NotNull
	@Size(min=5)
	private String telefono;
	
	private Date dataAgg;

	private Long  idProfiloUtente;

	private Long  idEnteGestoreAssociato;

	//private List profoliList;
	
	private ProfiliUtentiModel profiliUtentiModel;
	
	private List<EntiGestoriModel> listaEntiGestori;
	
	/**
	 * @return
	 */
	public Long getIdUtenteGestore() {
		return idUtenteGestore;
	}

	/**
	 * @param idUtenteGestore
	 */
	public void setIdUtenteGestore(Long idUtenteGestore) {
		this.idUtenteGestore = idUtenteGestore;
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
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
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
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	public Long getIdProfiloUtente() {
		return idProfiloUtente;
	}

	/**
	 * @param idProfiloUtente
	 */
	public void setIdProfiloUtente(Long idProfiloUtente) {
		this.idProfiloUtente = idProfiloUtente;
	}
/*
	public List getProfoliList() {
		return profoliList;
	}

	public void setProfoliList(List profoliList) {
		this.profoliList = profoliList;
	}
	*/
	/**
	 * @return
	 */
	public List<EntiGestoriModel> getListaEntiGestori() {
		return listaEntiGestori;
	}

	/**
	 * @param listaEntiGestori
	 */
	public void setListaEntiGestori(List<EntiGestoriModel> listaEntiGestori) {
		this.listaEntiGestori = listaEntiGestori;
	}

	/**
	 * @return
	 */
	public ProfiliUtentiModel getProfiliUtentiModel() {
		return profiliUtentiModel;
	}

	/**
	 * @param profiliUtentiModel
	 */
	public void setProfiliUtentiModel(ProfiliUtentiModel profiliUtentiModel) {
		this.profiliUtentiModel = profiliUtentiModel;
	}

	
	/**
	 * @return
	 */
	public Long getIdEnteGestoreAssociato() {
		return idEnteGestoreAssociato;
	}

	/**
	 * @param idEnteGestoreAssociato
	 */
	public void setIdEnteGestoreAssociato(Long idEnteGestoreAssociato) {
		this.idEnteGestoreAssociato = idEnteGestoreAssociato;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
}
