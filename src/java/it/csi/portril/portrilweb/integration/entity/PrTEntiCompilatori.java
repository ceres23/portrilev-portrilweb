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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the pr_t_enti_compilatori database table.
 * 
 */
@Entity
@Table(name="pr_t_enti_compilatori", schema="portalerilevazioni")
@NamedQuery(name="PrTEntiCompilatori.findAll", query="SELECT p FROM PrTEntiCompilatori p")
public class PrTEntiCompilatori implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7362937950675883295L;

	@Id
	@SequenceGenerator(name="PR_T_ENTI_COMPILATORI_IDENTECOMPILATORE_GENERATOR", sequenceName="portalerilevazioni.PR_T_ENTI_COMPILATORI_ID_ENTE_COMPILATORE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PR_T_ENTI_COMPILATORI_IDENTECOMPILATORE_GENERATOR")
	@Column(name="id_ente_compilatore")
	private Long idEnteCompilatore;

	@Column(name="codice_fiscale")
	private String codiceFiscale;

	private String comune;

	@Temporal(TemporalType.DATE)
	@Column(name="data_agg")
	private Date dataAgg;

//	@Column(name="id_ente_gestore")
//	private Long idEnteGestore;

	private String mail;

	@Column(name="partita_iva")
	private String partitaIva;

	private String provincia;

	//private String istat;

	@Column(name="ragione_sociale")
	private String ragioneSociale;

	private String classificazione;

	private String stato;

	
	//bi-directional many-to-one association to PrTRighe
	@OrderBy("posizione ASC")
	@OneToMany(mappedBy="prTEntiCompilatori")
	private List<PrTRighe> prTRighes;


	//bi-directional many-to-many association to PrTUtentiCompilatori
	@ManyToMany(mappedBy="prTEntiCompilatoris")
	private List<PrTUtentiCompilatori> prTUtentiCompilatoris;

	
	//bi-directional many-to-many association to PrTModuli
	@ManyToMany(mappedBy="prTEntiCompilatoris", cascade=CascadeType.ALL)
	private List<PrTModuli> prTModulis;
	
	
	//bi-directional many-to-one association to PrTConfermeModuli
	@OneToMany(mappedBy="prTEntiCompilatori", cascade=CascadeType.ALL)
	private List<PrTConfermeModuli> prTConfermeModuli;
	
	
	//bi-directional many-to-one association to PrTConfermeModuli
	//@OneToMany(mappedBy="prTEntiCompilatori", cascade=CascadeType.ALL)
	@OneToMany(mappedBy="prTEntiCompilatori")
	private List<PrREntiCompilatoriGestori> prREntiCompilatoriGestori;
	

	
	/**
	 * 
	 */
	public PrTEntiCompilatori() {
	}

	/**
	 * @return
	 */
	public Long getIdEnteCompilatore() {
		return this.idEnteCompilatore;
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
/*
	public Long getIdEnteGestore() {
		return this.idEnteGestore;
	}

	public void setIdEnteGestore(Long idEnteGestore) {
		this.idEnteGestore = idEnteGestore;
	}
*/
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
	public String getClassificazione() {
		return this.classificazione;
	}

	/**
	 * @param classificazione
	 */
	public void setClassificazione(String classificazione) {
		this.classificazione = classificazione;
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
	public List<PrTRighe> getPrTRighes() {
		return this.prTRighes;
	}

	/**
	 * @param prTRighes
	 */
	public void setPrTRighes(List<PrTRighe> prTRighes) {
		this.prTRighes = prTRighes;
	}
/*
	public PrTRighe addPrTRighe(PrTRighe prTRighe) {
		getPrTRighes().add(prTRighe);
		prTRighe.setPrTEntiCompilatori(this);

		return prTRighe;
	}

	public PrTRighe removePrTRighe(PrTRighe prTRighe) {
		getPrTRighes().remove(prTRighe);
		prTRighe.setPrTEntiCompilatori(null);

		return prTRighe;
	}
*/
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
	public List<PrTModuli> getPrTModulis() {
		return this.prTModulis;
	}

	/**
	 * @param prTModulis
	 */
	public void setPrTModulis(List<PrTModuli> prTModulis) {
		this.prTModulis = prTModulis;
	}

	/**
	 * @return the prTConfermeModuli
	 */
	public List<PrTConfermeModuli> getPrTConfermeModuli() {
		return prTConfermeModuli;
	}

	/**
	 * @param prTConfermeModuli the prTConfermeModuli to set
	 */
	public void setPrTConfermeModuli(List<PrTConfermeModuli> prTConfermeModuli) {
		this.prTConfermeModuli = prTConfermeModuli;
	}

	/**
	 * @return the prREntiCompilatoriGestori
	 */
	public List<PrREntiCompilatoriGestori> getPrREntiCompilatoriGestori() {
		return prREntiCompilatoriGestori;
	}

	/**
	 * @param prREntiCompilatoriGestori the prREntiCompilatoriGestori to set
	 */
	public void setPrREntiCompilatoriGestori(
			List<PrREntiCompilatoriGestori> prREntiCompilatoriGestori) {
		this.prREntiCompilatoriGestori = prREntiCompilatoriGestori;
	}


}