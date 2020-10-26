/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the pr_t_utenti_gestori database table.
 * 
 */
@Entity
@Table(name="pr_t_utenti_gestori", schema="portalerilevazioni")
public class PrTUtentiGestori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PR_T_UTENTI_GESTORI_IDUTENTEGESTORE_GENERATOR", sequenceName="portalerilevazioni.PR_T_UTENTI_GESTORI_ID_UTENTE_GESTORE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PR_T_UTENTI_GESTORI_IDUTENTEGESTORE_GENERATOR")
	@Column(name="id_utente_gestore")
	private Long idUtenteGestore;

	@Column(name="codice_fiscale")
	private String codiceFiscale;

	private String cognome;

	@Column(name="data_agg")
	private Date dataAgg;

	private String mail;

	private String nome;

	private String stato;

	private String telefono;

	//bi-directional many-to-many association to PrTEntiGestori
    @ManyToMany
	@JoinTable(
		name="portalerilevazioni.pr_r_enti_utenti_gestori"
		, joinColumns={
			@JoinColumn(name="id_utente_gestore")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_ente_gestore")
			}
		)
	private List<PrTEntiGestori> prTEntiGestoris;

    
    /**
	//bi-directional many-to-one association to PrTModuli
	@OneToMany(mappedBy="prTUtentiGestori")
	private List<PrTModuli> prTModulis;
	*/

	//bi-directional many-to-one association to PrTProfiliUtenti
    @ManyToOne
	@JoinColumn(name="id_profilo_utente")
	private PrTProfiliUtenti prTProfiliUtenti;

    /**
     * 
     */
    public PrTUtentiGestori() {
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
	public String getCodiceFiscale() {
		return this.codiceFiscale;
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
		return this.cognome;
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
	public Date getDataAgg() {
		return this.dataAgg;
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
	public String getMail() {
		return this.mail;
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
		return this.nome;
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
		return this.stato;
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
		return this.telefono;
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
	public List<PrTEntiGestori> getPrTEntiGestoris() {
		return this.prTEntiGestoris;
	}

	/**
	 * @param prTEntiGestoris
	 */
	public void setPrTEntiGestoris(List<PrTEntiGestori> prTEntiGestoris) {
		this.prTEntiGestoris = prTEntiGestoris;
	}
	/*
	public List<PrTModuli> getPrTModulis() {
		return this.prTModulis;
	}

	public void setPrTModulis(List<PrTModuli> prTModulis) {
		this.prTModulis = prTModulis;
	}
	*/
	/**
	 * @return
	 */
	public PrTProfiliUtenti getPrTProfiliUtenti() {
		return this.prTProfiliUtenti;
	}

	/**
	 * @param prTProfiliUtenti
	 */
	public void setPrTProfiliUtenti(PrTProfiliUtenti prTProfiliUtenti) {
		this.prTProfiliUtenti = prTProfiliUtenti;
	}
	
}