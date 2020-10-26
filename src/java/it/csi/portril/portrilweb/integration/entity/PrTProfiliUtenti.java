/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the pr_t_profili_utenti database table.
 * 
 */
@Entity
@Table(name="pr_t_profili_utenti", schema="portalerilevazioni")
public class PrTProfiliUtenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PR_T_PROFILI_UTENTI_IDPROFILOUTENTE_GENERATOR", sequenceName="portalerilevazioni.PR_T_PROFILI_UTENTI_ID_PROFILO_UTENTE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PR_T_PROFILI_UTENTI_IDPROFILOUTENTE_GENERATOR")
	@Column(name="id_profilo_utente")

	private Long idProfiloUtente;
	
	private String descrizione;

	@Column(name="flg_gest_compilazione_moduli")
	private String flgGestCompilazioneModuli;

	@Column(name="flg_gest_definizione_moduli")
	private String flgGestDefinizioneModuli;

	@Column(name="flg_gest_enti_compilatori")
	private String flgGestEntiCompilatori;

	@Column(name="flg_gest_profilo_compilatore")
	private String flgGestProfiloCompilatore;

	@Column(name="flg_gest_risultati")
	private String flgGestRisultati;

	@Column(name="flg_gest_utenti_compilatori")
	private String flgGestUtentiCompilatori;

	@Column(name="flg_gest_utenti_gestori")
	private String flgGestUtentiGestori;

	private String tipo;

	//bi-directional many-to-one association to PrTUtentiCompilatori
	@OneToMany(mappedBy="prTProfiliUtenti")
	private List<PrTUtentiCompilatori> prTUtentiCompilatoris;

	//bi-directional many-to-one association to PrTUtentiGestori
	@OneToMany(mappedBy="prTProfiliUtenti")
	private List<PrTUtentiGestori> prTUtentiGestoris;

    /**
     * 
     */
    public PrTProfiliUtenti() {
    }

	/**
	 * @return
	 */
	public Long getIdProfiloUtente() {
		return this.idProfiloUtente;
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
	public String getDescrizione() {
		return this.descrizione;
	}

	/**
	 * @param descrizione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return
	 */
	public String getFlgGestCompilazioneModuli() {
		return this.flgGestCompilazioneModuli;
	}

	/**
	 * @param flgGestCompilazioneModuli
	 */
	public void setFlgGestCompilazioneModuli(String flgGestCompilazioneModuli) {
		this.flgGestCompilazioneModuli = flgGestCompilazioneModuli;
	}

	/**
	 * @return
	 */
	public String getFlgGestDefinizioneModuli() {
		return this.flgGestDefinizioneModuli;
	}

	/**
	 * @param flgGestDefinizioneModuli
	 */
	public void setFlgGestDefinizioneModuli(String flgGestDefinizioneModuli) {
		this.flgGestDefinizioneModuli = flgGestDefinizioneModuli;
	}

	/**
	 * @return
	 */
	public String getFlgGestEntiCompilatori() {
		return this.flgGestEntiCompilatori;
	}

	/**
	 * @param flgGestEntiCompilatori
	 */
	public void setFlgGestEntiCompilatori(String flgGestEntiCompilatori) {
		this.flgGestEntiCompilatori = flgGestEntiCompilatori;
	}

	/**
	 * @return
	 */
	public String getFlgGestProfiloCompilatore() {
		return this.flgGestProfiloCompilatore;
	}

	/**
	 * @param flgGestProfiloCompilatore
	 */
	public void setFlgGestProfiloCompilatore(String flgGestProfiloCompilatore) {
		this.flgGestProfiloCompilatore = flgGestProfiloCompilatore;
	}

	/**
	 * @return
	 */
	public String getFlgGestRisultati() {
		return this.flgGestRisultati;
	}

	/**
	 * @param flgGestRisultati
	 */
	public void setFlgGestRisultati(String flgGestRisultati) {
		this.flgGestRisultati = flgGestRisultati;
	}

	/**
	 * @return
	 */
	public String getFlgGestUtentiCompilatori() {
		return this.flgGestUtentiCompilatori;
	}

	/**
	 * @param flgGestUtentiCompilatori
	 */
	public void setFlgGestUtentiCompilatori(String flgGestUtentiCompilatori) {
		this.flgGestUtentiCompilatori = flgGestUtentiCompilatori;
	}

	/**
	 * @return
	 */
	public String getFlgGestUtentiGestori() {
		return this.flgGestUtentiGestori;
	}

	/**
	 * @param flgGestUtentiGestori
	 */
	public void setFlgGestUtentiGestori(String flgGestUtentiGestori) {
		this.flgGestUtentiGestori = flgGestUtentiGestori;
	}

	/**
	 * @return
	 */
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return
	 */
	public List<PrTUtentiCompilatori> getPrTUtentiCompilatoris() {
		return this.prTUtentiCompilatoris;
	}

	/**
	 * @param prTUtentiCompilatoris
	 */
	public void setPrTUtentiCompilatoris(List<PrTUtentiCompilatori> prTUtentiCompilatoris) {
		this.prTUtentiCompilatoris = prTUtentiCompilatoris;
	}
	
	/**
	 * @return
	 */
	public List<PrTUtentiGestori> getPrTUtentiGestoris() {
		return this.prTUtentiGestoris;
	}

	/**
	 * @param prTUtentiGestoris
	 */
	public void setPrTUtentiGestoris(List<PrTUtentiGestori> prTUtentiGestoris) {
		this.prTUtentiGestoris = prTUtentiGestoris;
	}
	
}