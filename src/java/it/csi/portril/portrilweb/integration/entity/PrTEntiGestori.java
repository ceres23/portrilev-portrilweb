/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the pr_t_enti_gestori database table.
 * 
 */
@Entity
@Table(name="pr_t_enti_gestori", schema="portalerilevazioni")
public class PrTEntiGestori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PR_T_ENTI_GESTORI_IDENTEGESTORE_GENERATOR", sequenceName="portalerilevazioni.PR_T_ENTI_GESTORI_ID_ENTE_GESTORE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PR_T_ENTI_GESTORI_IDENTEGESTORE_GENERATOR")
	@Column(name="id_ente_gestore")
	private Long idEnteGestore;

	@Column(name="codice_fiscale")
	private String codiceFiscale;

	private String comune;

	@Column(name="data_agg")
	private Date dataAgg;

	private String mail;

	@Column(name="partita_iva")
	private String partitaIva;

	private String provincia;

	@Column(name="ragione_sociale")
	private String ragioneSociale;

	private String regione;

	private String stato;

	//bi-directional many-to-many association to PrTUtentiGestori
	@ManyToMany(mappedBy="prTEntiGestoris")
	private List<PrTUtentiGestori> prTUtentiGestoris;

	//bi-directional many-to-one association to PrTModuli
	@OneToMany(mappedBy="prTEntiGestori")
	private List<PrTModuli> prTModulis;

	//bi-directional many-to-one association to PrTConfermeModuli
	@OneToMany(mappedBy="prTEntiGestori")
	private List<PrREntiCompilatoriGestori> prREntiCompilatoriGestori;
    /**
     * 
     */
    public PrTEntiGestori() {
    }

	/**
	 * @return
	 */
	public Long getIdEnteGestore() {
		return this.idEnteGestore;
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
	public String getComune() {
		return this.comune;
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
	public String getPartitaIva() {
		return this.partitaIva;
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
		return this.provincia;
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
		return this.ragioneSociale;
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
	public String getRegione() {
		return this.regione;
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
	public List<PrTUtentiGestori> getPrTUtentiGestoris() {
		return this.prTUtentiGestoris;
	}

	/**
	 * @param prTUtentiGestoris
	 */
	public void setPrTUtentiGestoris(List<PrTUtentiGestori> prTUtentiGestoris) {
		this.prTUtentiGestoris = prTUtentiGestoris;
	}
	
	/**
	 * @return
	 */
	public List<PrTModuli> getPrTModulis() {
		return this.prTModulis;
	}

	/**
	 * @param prTModulis
	 */
	public void setPrTModulis(List<PrTModuli> prTModulis) {
		this.prTModulis = prTModulis;
	}
	
}