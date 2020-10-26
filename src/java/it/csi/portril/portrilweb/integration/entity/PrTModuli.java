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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the pr_t_moduli database table.
 * 
 */
@Entity
@Table(name="pr_t_moduli", schema="portalerilevazioni")
public class PrTModuli implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PR_T_MODULI_IDMODULO_GENERATOR", sequenceName="portalerilevazioni.PR_T_MODULI_ID_MODULO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PR_T_MODULI_IDMODULO_GENERATOR")
	@Column(name="id_modulo")
	private Long idModulo;

    @Temporal( TemporalType.DATE)
	@Column(name="data_fine_compilazione")
	private Date dataFineCompilazione;

    @Temporal( TemporalType.DATE)
	@Column(name="data_inizio_compilazione")
	private Date dataInizioCompilazione;

	@Column(name="data_ultima_modifica")
	private Date dataUltimaModifica;

	private String descrizione;

	private String tipo;

	@Column(name="istruzioni_compilazione")
	private String istruzioniCompilazione;

	private String nome;

	private String note;

	@Column(name="obblig_conferma")
	private String obbligConferma;
	
	@Column(name="caricamento_da_file")
	private String caricamentoDaFile;
	
	@Column(name="codice_gruppo")
	private String codiceGruppo;
	
	
	/*
	@Column(name="file")
	private byte[] fileByte;

	private String contenttype;

	private String filename;
*/	
	//bi-directional many-to-many association to PrTEntiCompilatori
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})  
	@JoinTable(
		name="portalerilevazioni.pr_r_moduli_enti_compilatori"
		, joinColumns={
			@JoinColumn(name="id_modulo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_ente_compilatore")
			}
		)
	private List<PrTEntiCompilatori> prTEntiCompilatoris;

    
    
	//bi-directional many-to-one association to PrRUtentiModuliCompilatori
	@OneToMany(mappedBy="prTModuli")
	private List<PrRUtentiModuliCompilatori> prRUtentiModuliCompilatoris;

	//bi-directional many-to-one association to PrTColonneModulo
	@OneToMany(mappedBy="prTModuli", cascade=CascadeType.ALL)
	@OrderBy("posizione ASC")
	private List<PrTColonneModulo> prTColonneModulos;

	//bi-directional many-to-one association to PrTConfermeModuli
	@OneToMany(mappedBy="prTModuli", cascade=CascadeType.ALL)
	private List<PrTConfermeModuli> prTConfermeModuli;
	
	//bi-directional many-to-one association to PrTEntiGestori
    @ManyToOne
	@JoinColumn(name="id_ente_gestore")
	private PrTEntiGestori prTEntiGestori;


    @Column(name="id_utente_gestore")
	private Long idUtenteGestore;
    
    
//	//bi-directional many-to-one association to PrTModuloMailInviti
//	@OneToMany(mappedBy="prTModuli")
//	private List<PrTModuloMailInviti> prTModuloMailInvitis;

	
    /**
     * 
     */
    public PrTModuli() {
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
	public Date getDataFineCompilazione() {
		return this.dataFineCompilazione;
	}

	/**
	 * @param dataFineCompilazione
	 */
	public void setDataFineCompilazione(Date dataFineCompilazione) {
		this.dataFineCompilazione = dataFineCompilazione;
	}

	/**
	 * @return
	 */
	public Date getDataInizioCompilazione() {
		return this.dataInizioCompilazione;
	}

	/**
	 * @param dataInizioCompilazione
	 */
	public void setDataInizioCompilazione(Date dataInizioCompilazione) {
		this.dataInizioCompilazione = dataInizioCompilazione;
	}	

	/**
	 * @return
	 */
	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	/**
	 * @param dataUltimaModifica
	 */
	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
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
	public String getIstruzioniCompilazione() {
		return this.istruzioniCompilazione;
	}

	/**
	 * @param istruzioniCompilazione
	 */
	public void setIstruzioniCompilazione(String istruzioniCompilazione) {
		this.istruzioniCompilazione = istruzioniCompilazione;
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
	public String getNote() {
		return this.note;
	}

	/**
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return
	 */
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
	public List<PrTColonneModulo> getPrTColonneModulos() {
		return this.prTColonneModulos;
	}

	/**
	 * @param prTColonneModulos
	 */
	public void setPrTColonneModulos(List<PrTColonneModulo> prTColonneModulos) {
		this.prTColonneModulos = prTColonneModulos;
	}
	
	/**
	 * @return
	 */
	public PrTEntiGestori getPrTEntiGestori() {
		return this.prTEntiGestori;
	}

	/**
	 * @param prTEntiGestori
	 */
	public void setPrTEntiGestori(PrTEntiGestori prTEntiGestori) {
		this.prTEntiGestori = prTEntiGestori;
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
	 * @return
	 */
	public Long getIdUtenteGestore() {
		return idUtenteGestore;
	}

	/**
	 * @param idUtenteGestore
	 */
	public void setIdUtenteGestore(Long idUtenteGestore) {
		this.idUtenteGestore = idUtenteGestore;
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
	 * @return the caricamentoDaFile
	 */
	public String getCaricamentoDaFile() {
		return caricamentoDaFile;
	}

	/**
	 * @param caricamentoDaFile the caricamentoDaFile to set
	 */
	public void setCaricamentoDaFile(String caricamentoDaFile) {
		this.caricamentoDaFile = caricamentoDaFile;
	}

	/**
	 * @return the codiceGruppo
	 */
	public String getCodiceGruppo() {
		return codiceGruppo;
	}

	/**
	 * @param codiceGruppo the codiceGruppo to set
	 */
	public void setCodiceGruppo(String codiceGruppo) {
		this.codiceGruppo = codiceGruppo;
	}

	
//	public List<PrTModuloMailInviti> getPrTModuloMailInvitis() {
//		return this.prTModuloMailInvitis;
//	}
//
//	public void setPrTModuloMailInvitis(List<PrTModuloMailInviti> prTModuloMailInvitis) {
//		this.prTModuloMailInvitis = prTModuloMailInvitis;
//	}
	
}