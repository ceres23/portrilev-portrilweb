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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the pr_t_righe database table.
 * 
 */
@Entity
@Table(name="pr_t_righe", schema="portalerilevazioni")
@NamedQuery(name="PrTRighe.findAll", query="SELECT p FROM PrTRighe p")
public class PrTRighe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PR_T_RIGHE_IDRIGA_GENERATOR", sequenceName="portalerilevazioni.PR_T_RIGHE_ID_RIGA_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PR_T_RIGHE_IDRIGA_GENERATOR")
	
	@Column(name="id_riga")
	private Long idRiga;

	@Temporal(TemporalType.DATE)
	@Column(name="data_modifica_compilatore")
	private Date dataModificaCompilatore;

	@Temporal(TemporalType.DATE)
	@Column(name="data_validazione_gestore")
	private Date dataValidazioneGestore;

	@Column(name="flg_validazione")
	private String flgValidazione;

	@Column(name="id_modulo")
	private Long idModulo;

	@Column(name="id_utente_compilatore")
	private Long idUtenteCompilatore;

	@Column(name="id_utente_gestore")
	private Long idUtenteGestore;

	private Integer posizione;

	@Column(name="tipo")
	private String tipo;

	@Column(name="data_agg")
	private Date  dataAgg;
	
	//bi-directional many-to-one association to PrTEntiCompilatori
	@ManyToOne
	@JoinColumn(name="id_ente_compilatore")
	private PrTEntiCompilatori prTEntiCompilatori;

	//@OneToMany(mappedBy="prTRighe", cascade = {CascadeType.REMOVE})
	@OneToMany(mappedBy="id.prTRighe")//, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@OrderBy("posizioneColonna ASC")
	private List<PrTCella> prTCellas;
	
	
	/**
	 * 
	 */
	public PrTRighe() {
	}

	/**
	 * @return
	 */
	public Long getIdRiga() {
		return this.idRiga;
	}

	/**
	 * @param idRiga
	 */
	public void setIdRiga(Long idRiga) {
		this.idRiga = idRiga;
	}

	/**
	 * @return
	 */
	public Date getDataModificaCompilatore() {
		return this.dataModificaCompilatore;
	}

	/**
	 * @param dataModificaCompilatore
	 */
	public void setDataModificaCompilatore(Date dataModificaCompilatore) {
		this.dataModificaCompilatore = dataModificaCompilatore;
	}

	/**
	 * @return
	 */
	public Date getDataValidazioneGestore() {
		return this.dataValidazioneGestore;
	}

	/**
	 * @param dataValidazioneGestore
	 */
	public void setDataValidazioneGestore(Date dataValidazioneGestore) {
		this.dataValidazioneGestore = dataValidazioneGestore;
	}

	/**
	 * @return
	 */
	public String getFlgValidazione() {
		return this.flgValidazione;
	}

	/**
	 * @param flgValidazione
	 */
	public void setFlgValidazione(String flgValidazione) {
		this.flgValidazione = flgValidazione;
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
	public Integer getPosizione() {
		return this.posizione;
	}

	/**
	 * @param posizione
	 */
	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}

	/**
	 * @return
	 */
	public PrTEntiCompilatori getPrTEntiCompilatori() {
		return this.prTEntiCompilatori;
	}

	/**
	 * @param prTEntiCompilatori
	 */
	public void setPrTEntiCompilatori(PrTEntiCompilatori prTEntiCompilatori) {
		this.prTEntiCompilatori = prTEntiCompilatori;
	}
	
	/**
	 * @return
	 */
	public List<PrTCella> getPrTCellas() {
		return this.prTCellas;
	}

	/**
	 * @param prTCellas
	 */
	public void setPrTCellas(List<PrTCella> prTCellas) {
		this.prTCellas = prTCellas;
	}

	/**
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the dataAgg
	 */
	public Date getDataAgg() {
		return dataAgg;
	}

	/**
	 * @param dataAgg the dataAgg to set
	 */
	public void setDataAgg(Date dataAgg) {
		this.dataAgg = dataAgg;
	}

	
}