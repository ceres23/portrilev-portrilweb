/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.entity;

import java.io.Serializable;
import java.util.Date;


public class PrVModuliUtentiCoompilatori implements Serializable {


	private static final long serialVersionUID = -165945998983662720L;
	private Long    idModulo;
	private String	nomeModulo;
	private String  descrizione;
	private Date	dataInizioCompilazione;
	private Date	dataFineCompilazione;
	private String	tipo;
	private String	obbligConferma; 
	private String	codiceFiscale;
	private String	nomeUtente;
	private String	cognome;
	private String	mail;
	private String	telefono;  
	private String	stato;
	private String	moduloConfermato;
	private String	moduloValidato;
	/**
	 * @return the idModulo
	 */
	public Long getIdModulo() {
		return idModulo;
	}
	/**
	 * @param idModulo the idModulo to set
	 */
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	/**
	 * @return the nomeModulo
	 */
	public String getNomeModulo() {
		return nomeModulo;
	}
	/**
	 * @param nomeModulo the nomeModulo to set
	 */
	public void setNomeModulo(String nomeModulo) {
		this.nomeModulo = nomeModulo;
	}
	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	/**
	 * @return the dataInizioCompilazione
	 */
	public Date getDataInizioCompilazione() {
		return dataInizioCompilazione;
	}
	/**
	 * @param dataInizioCompilazione the dataInizioCompilazione to set
	 */
	public void setDataInizioCompilazione(Date dataInizioCompilazione) {
		this.dataInizioCompilazione = dataInizioCompilazione;
	}
	/**
	 * @return the dataFineCompilazione
	 */
	public Date getDataFineCompilazione() {
		return dataFineCompilazione;
	}
	/**
	 * @param dataFineCompilazione the dataFineCompilazione to set
	 */
	public void setDataFineCompilazione(Date dataFineCompilazione) {
		this.dataFineCompilazione = dataFineCompilazione;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the obbligConferma
	 */
	public String getObbligConferma() {
		return obbligConferma;
	}
	/**
	 * @param obbligConferma the obbligConferma to set
	 */
	public void setObbligConferma(String obbligConferma) {
		this.obbligConferma = obbligConferma;
	}
	/**
	 * @return the codiceFiscale
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	/**
	 * @param codiceFiscale the codiceFiscale to set
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	/**
	 * @return the nomeUtente
	 */
	public String getNomeUtente() {
		return nomeUtente;
	}
	/**
	 * @param nomeUtente the nomeUtente to set
	 */
	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}
	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the stato
	 */
	public String getStato() {
		return stato;
	}
	/**
	 * @param stato the stato to set
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}
	/**
	 * @return the moduloConfermato
	 */
	public String getModuloConfermato() {
		return moduloConfermato;
	}
	/**
	 * @param moduloConfermato the moduloConfermato to set
	 */
	public void setModuloConfermato(String moduloConfermato) {
		this.moduloConfermato = moduloConfermato;
	}
	/**
	 * @return the moduloValidato
	 */
	public String getModuloValidato() {
		return moduloValidato;
	}
	/**
	 * @param moduloValidato the moduloValidato to set
	 */
	public void setModuloValidato(String moduloValidato) {
		this.moduloValidato = moduloValidato;
	}
	
	
}