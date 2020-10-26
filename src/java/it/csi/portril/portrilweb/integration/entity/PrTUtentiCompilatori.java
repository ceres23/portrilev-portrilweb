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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the pr_t_utenti_compilatori database table.
 * 
 */
@Entity
@Table(name="pr_t_utenti_compilatori", schema="portalerilevazioni")
public class PrTUtentiCompilatori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PR_T_UTENTI_COMPILATORI_IDUTENTECOMPILATORE_GENERATOR", sequenceName="portalerilevazioni.PR_T_UTENTI_COMPILATORI_ID_UTENTE_COMPILATORE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PR_T_UTENTI_COMPILATORI_IDUTENTECOMPILATORE_GENERATOR")
	@Column(name="id_utente_compilatore")
	private Long idUtenteCompilatore;

	@Column(name="codice_fiscale")
	private String codiceFiscale;

	private String cognome;

	@Column(name="data_agg")
	private Date dataAgg;

	@Column(updatable=false)
	private String login;

	private String mail;

	private String nome;

	private String password;

	private String stato;

	private String telefono;

	//@Column(name="id_ente_gestore")
	//private Long idEnteGestore;
	
	//bi-directional many-to-many association to PrTEntiCompilatori
    @ManyToMany
	@JoinTable(
		name="portalerilevazioni.pr_r_enti_utenti_compilatori"
		, joinColumns={
			@JoinColumn(name="id_utente_compilatore")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_ente_compilatore")
			}
		)
	private List<PrTEntiCompilatori> prTEntiCompilatoris;

	
	
	//bi-directional many-to-one association to PrRUtentiModuliCompilatori
	@OneToMany(mappedBy="prTUtentiCompilatori")
	private List<PrRUtentiModuliCompilatori> prRUtentiModuliCompilatoris;

	//bi-directional many-to-one association to PrTProfiliUtenti
    @ManyToOne
	@JoinColumn(name="id_profilo_utente")
	private PrTProfiliUtenti prTProfiliUtenti;

    /**
     * 
     */
    public PrTUtentiCompilatori() {
    }

	/**
	 * @return
	 */
	public Long getIdUtenteCompilatore() {
		return this.idUtenteCompilatore;
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
	public String getLogin() {
		return this.login;
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
	public String getPassword() {
		return this.password;
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

	
/*
	public Long getIdEnteGestore() {
		return idEnteGestore;
	}

	public void setIdEnteGestore(Long idEnteGestore) {
		this.idEnteGestore = idEnteGestore;
	}
*/
	
	/**
	 * @return
	 */
	@OrderBy("ragioneSociale ASC")
	public List<PrTEntiCompilatori> getPrTEntiCompilatoris() {
		return this.prTEntiCompilatoris;
	}

	/**
	 * @param prTEntiCompilatoris
	 */
	public void setPrTEntiCompilatoris(List<PrTEntiCompilatori> prTEntiCompilatoris) {
		this.prTEntiCompilatoris = prTEntiCompilatoris;
	}
	
	/**
	 * @return
	 */
	public List<PrRUtentiModuliCompilatori> getPrRUtentiModuliCompilatoris() {
		return this.prRUtentiModuliCompilatoris;
	}

	/**
	 * @param prRUtentiModuliCompilatoris
	 */
	public void setPrRUtentiModuliCompilatoris(List<PrRUtentiModuliCompilatori> prRUtentiModuliCompilatoris) {
		this.prRUtentiModuliCompilatoris = prRUtentiModuliCompilatoris;
	}
	
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