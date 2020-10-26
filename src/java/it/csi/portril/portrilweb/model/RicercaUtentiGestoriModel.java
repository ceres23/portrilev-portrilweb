/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.model.validator.CodiceFiscale;
import it.csi.portril.portrilweb.util.Utility;

import java.util.List;

import javax.validation.constraints.Size;

/**
 * @author 71027
 *
 */
public class RicercaUtentiGestoriModel  extends GenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1098184462492518351L;

	/**
	 * 
	 */
	public RicercaUtentiGestoriModel(){
	}
	
	/**
	 * @param lista
	 */
	public RicercaUtentiGestoriModel(List<ProfiliUtentiModel> lista){
		setListaProfili(lista);
	}
	//@EMail(required=false)
	//private String mail;

	//private String stato;

	//private String telefono;
	
	//private Date dataAgg;
	
	
	private Long idUtenteGestore;

	private Long  idUtenteSel;
	
	private String strIdProfiloUtente="0";

	@CodiceFiscale(required=false)
	private String codiceFiscale;

	@Size(min=3)
	private String cognome;
	
	@Size(min=3)
	private String nome;

	private String idProfiloUtente;

	private List<ProfiliUtentiModel> listaProfili;
	
	private ProfiliUtentiModel profiliUtentiModel;
	
	private List<UtentiGestoriModel> listaUtentiGestori;
	
	
	
	/**
	 * @return
	 */
	public Long getIdUtenteSel() {
		return idUtenteSel;
	}

	/**
	 * @param idUtenteSel
	 */
	public void setIdUtenteSel(Long idUtenteSel) {
		this.idUtenteSel = idUtenteSel;
	}

	/**
	 * @return
	 */
	public List<UtentiGestoriModel> getListaUtentiGestori() {
		return listaUtentiGestori;
	}

	/**
	 * @param listaUtentiGestori
	 */
	public void setListaUtentiGestori(List<UtentiGestoriModel> listaUtentiGestori) {
		this.listaUtentiGestori = listaUtentiGestori;
	}

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
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

/*	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	

	public Date getDataAgg() {
		return dataAgg;
	}

	public void setDataAgg(Date dataAgg) {
		this.dataAgg = dataAgg;
	}*/

	/**
	 * @return
	 */
	public String getIdProfiloUtente() {
		return idProfiloUtente;
	}

	/**
	 * @param idProfiloUtente
	 */
	public void setIdProfiloUtente(String idProfiloUtente) {
		this.idProfiloUtente = idProfiloUtente;
	}

	/**
	 * @return
	 */
	public List<ProfiliUtentiModel> getListaProfili() {
		return listaProfili;
	}

	/**
	 * @param listaProfili
	 */
	public void setListaProfili(List<ProfiliUtentiModel> listaProfili) {
		this.listaProfili = listaProfili;
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
	public String getStrIdProfiloUtente() {
		return strIdProfiloUtente;
	}

	/**
	 * @param strIdProfiloUtente
	 */
	public void setStrIdProfiloUtente(String strIdProfiloUtente) {
		this.strIdProfiloUtente = strIdProfiloUtente;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
}
