/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the pr_t_modulo_mail_inviti database table.
 * 
 */
@Entity
@Table(name="pr_t_modulo_mail_inviti", schema="portalerilevazioni")
public class PrTModuloMailInviti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PR_T_MODULO_MAIL_INVITI_IDMODULOMAILINVITO_GENERATOR", sequenceName="portalerilevazioni.PR_T_MODULO_MAIL_INVITI_ID_MODULO_MAIL_INVITO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PR_T_MODULO_MAIL_INVITI_IDMODULOMAILINVITO_GENERATOR")
	@Column(name="id_modulo_mail_invito")
	private Long idModuloMailInvito;

    @Temporal( TemporalType.DATE)
	@Column(name="data_invio")
	private Date dataInvio;

	@Column(name="id_utente_gestore")
	private Long idUtenteGestore;

	@Column(name="id_ente_gestore")
	private Long idEnteGestore;

	@Column(name="id_utente_compilatore")
	private Long idUtenteCompilatore;
	
	@Column(name="id_ente_compilatore")
	private Long idEnteCompilatore;
	
	@Column(name="id_modulo")
	private Long idModulo;
	
	private String oggetto;

	private String mailMittente;
	
	private String mailDestinatario;
	
	private String mailCC;
	
	private String testo;

    /**
     * 
     */
    public PrTModuloMailInviti() {
    }

	/**
	 * @return
	 */
	public Long getIdModuloMailInvito() {
		return this.idModuloMailInvito;
	}

	/**
	 * @param idModuloMailInvito
	 */
	public void setIdModuloMailInvito(Long idModuloMailInvito) {
		this.idModuloMailInvito = idModuloMailInvito;
	}

	/**
	 * @return
	 */
	public Date getDataInvio() {
		return this.dataInvio;
	}

	/**
	 * @param dataInvio
	 */
	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	/**
	 * @return
	 */
	public Long getIdUtenteGestore() {
		return this.idUtenteGestore;
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
	public String getOggetto() {
		return this.oggetto;
	}

	/**
	 * @param oggetto
	 */
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	/**
	 * @return
	 */
	public String getTesto() {
		return this.testo;
	}

	/**
	 * @param testo
	 */
	public void setTesto(String testo) {
		this.testo = testo;
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
	public Long getIdModulo() {
		return this.idModulo;
	}

	/**
	 * @param idModulo
	 */
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	/**
	 * @return the mailMittente
	 */
	/**
	 * @return
	 */
	public String getMailMittente() {
		return mailMittente;
	}

	/**
	 * @param mailMittente the mailMittente to set
	 */
	/**
	 * @param mailMittente
	 */
	public void setMailMittente(String mailMittente) {
		this.mailMittente = mailMittente;
	}

	/**
	 * @return the mailDestinatario
	 */
	/**
	 * @return
	 */
	public String getMailDestinatario() {
		return mailDestinatario;
	}

	/**
	 * @param mailDestinatario the mailDestinatario to set
	 */
	/**
	 * @param mailDestinatario
	 */
	public void setMailDestinatario(String mailDestinatario) {
		this.mailDestinatario = mailDestinatario;
	}

	/**
	 * @return the mailCC
	 */
	/**
	 * @return
	 */
	public String getMailCC() {
		return mailCC;
	}

	/**
	 * @param mailCC the mailCC to set
	 */
	/**
	 * @param mailCC
	 */
	public void setMailCC(String mailCC) {
		this.mailCC = mailCC;
	}

	
	/**
	 * @return the idEnteGestore
	 */
	/**
	 * @return
	 */
	public Long getIdEnteGestore() {
		return idEnteGestore;
	}

	/**
	 * @param idEnteGestore the idEnteGestore to set
	 */
	/**
	 * @param idEnteGestore
	 */
	public void setIdEnteGestore(Long idEnteGestore) {
		this.idEnteGestore = idEnteGestore;
	}


	
}