/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;
import it.csi.portril.portrilweb.util.Utility;

import java.util.Date;
import java.util.List;


public class RicercaUtentiCompilatoriModel extends GenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1526095920349336729L;
	
	private Long idUtenteCompilatore;

	private Long idUtenteSel;

	private String codiceFiscale;
	
	
	private String cognome;
	
	private String mail;
	
	private String nome;

	private String stato;
	
	private String telefono;

	private String login;

	private String password;
	
	private Date  dataAgg;
	
	private Long  idProfiloUtente;

	private Long idEnteGestore;
	
	private List<UtentiCompilatoriModel> listaUtentiCompilatori;



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
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
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
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
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

	
	/**
	 * @return
	 */
	public List<UtentiCompilatoriModel> getListaUtentiCompilatori() {
		return listaUtentiCompilatori;
	}

	/**
	 * @param listaUtentiCompilatori
	 */
	public void setListaUtentiCompilatori(
			List<UtentiCompilatoriModel> listaUtentiCompilatori) {
		this.listaUtentiCompilatori = listaUtentiCompilatori;
	}

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

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return getClass().getName() + '@' + Integer.toHexString(hashCode());
	}
}
