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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UtentiCompilatoriModel extends GenericModel{

	private static final long serialVersionUID = 1526095920349336729L;
	
	private Long idUtenteCompilatore;
	
	@CodiceFiscale(required=true)
	private String codiceFiscale;
	
	private String trattamentoDati;
	
	@NotNull
	@Size(min=2)
	private String cognome;
	
	@EMail(required=true)
	private String mail;
	
	//@EMail(required=true)
	private String mail2;
	
	@NotNull
	@Size(min=2)
	private String nome;

	@NotNull
	@Size(min=1)
	private String stato;
	
	@NotNull
	@Size(min=5)
	private String telefono;

	private String login;

	private String password;
	
	private Date  dataAgg;
	
	private Long  idProfiloUtente;

	private Date dataUltimoAggRigheModulo;

	//private Long  idEnteGestore;
	
	private String errore;
	
	private Boolean pwNotSecure = false;
	
	private Boolean servizio = false;
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
	public String getMail2() {
		return mail2;
	}

	/**
	 * @param mail2
	 */
	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}

	/**
	 * @return
	 */
	public Date getDataUltimoAggRigheModulo() {
		return dataUltimoAggRigheModulo;
	}

	/**
	 * @return
	 */
	public String getDataUltimoAggRigheModuloStr() {
		return UtilDate.formatDate(dataUltimoAggRigheModulo);
	}
	
	/**
	 * @param dataUltimoAggRigheModulo
	 */
	public void setDataUltimoAggRigheModulo(Date dataUltimoAggRigheModulo) {
		this.dataUltimoAggRigheModulo = dataUltimoAggRigheModulo;
	}

	/*
	public Long getIdEnteGestore() {
		return idEnteGestore;
	}

	public void setIdEnteGestore(Long idEnteGestore) {
		this.idEnteGestore = idEnteGestore;
	}
	*/
	
	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return getClass().getName() + '@' + Integer.toHexString(hashCode());
	}

	/**
	 * @return the trattamentoDati
	 */
	public String getTrattamentoDati() {
		return trattamentoDati;
	}

	/**
	 * @param trattamentoDati the trattamentoDati to set
	 */
	public void setTrattamentoDati(String trattamentoDati) {
		this.trattamentoDati = trattamentoDati;
	}

	/**
	 * @return the errore
	 */
	public String getErrore() {
		return errore;
	}

	/**
	 * @param errore the errore to set
	 */
	public void setErrore(String errore) {
		this.errore = errore;
	}

	/**
	 * @return the pwNotSecure
	 */
	public Boolean getPwNotSecure() {
		return pwNotSecure;
	}

	/**
	 * @param pwNotSecure the pwNotSecure to set
	 */
	public void setPwNotSecure(Boolean pwNotSecure) {
		this.pwNotSecure = pwNotSecure;
	}

	/**
	 * @return the servizio
	 */
	public Boolean getServizio() {
		return servizio;
	}

	/**
	 * @param servizio the servizio to set
	 */
	public void setServizio(Boolean servizio) {
		this.servizio = servizio;
	}
}
