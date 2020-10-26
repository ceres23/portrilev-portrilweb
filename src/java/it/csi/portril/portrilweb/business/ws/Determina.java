/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per determina complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="determina">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anno" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="avvenuto_impegno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cod_dir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cod_materia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cod_pubblicazione" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cod_pubblicazione_dir" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cod_sett" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="data_bu" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_cancellazione" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_determ" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_estrazione" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_ini_dir" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_ini_sett" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_invio_trasmissione" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_notiziario" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_pres_carico" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_validazione" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_visto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="det_vecchia_burp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="flag_estratto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="flag_pubb_all" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="flag_spesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flag_trasm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_bollettino" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="identificativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="impegni_multipli" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="impegno_delegato" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="matr_ute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modifica_di_impegno" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="note_notiziario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="note_pubblicazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="num_determ" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="num_legisl" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numero_bu" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numero_notiziario" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="oggetto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pubbl_notiziario" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ragioneria" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="referente_notiziario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sensibile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supplemento" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="urgenza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valutazioni_conc_persone" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "determina", propOrder = {
    "anno",
    "avvenutoImpegno",
    "codDir",
    "codMateria",
    "codPubblicazione",
    "codPubblicazioneDir",
    "codSett",
    "dataBu",
    "dataCancellazione",
    "dataDeterm",
    "dataEstrazione",
    "dataIniDir",
    "dataIniSett",
    "dataInvioTrasmissione",
    "dataNotiziario",
    "dataPresCarico",
    "dataValidazione",
    "dataVisto",
    "detVecchiaBurp",
    "flagEstratto",
    "flagPubbAll",
    "flagSpesa",
    "flagTrasm",
    "idBollettino",
    "identificativo",
    "impegniMultipli",
    "impegnoDelegato",
    "matrUte",
    "modificaDiImpegno",
    "noteNotiziario",
    "notePubblicazione",
    "numDeterm",
    "numLegisl",
    "numeroBu",
    "numeroNotiziario",
    "oggetto",
    "personale",
    "pubblNotiziario",
    "ragioneria",
    "referenteNotiziario",
    "sensibile",
    "stato",
    "supplemento",
    "urgenza",
    "valutazioniConcPersone"
})
public class Determina {

    protected Integer anno;
    @XmlElement(name = "avvenuto_impegno")
    protected String avvenutoImpegno;
    @XmlElement(name = "cod_dir")
    protected String codDir;
    @XmlElement(name = "cod_materia")
    protected String codMateria;
    @XmlElement(name = "cod_pubblicazione")
    protected Integer codPubblicazione;
    @XmlElement(name = "cod_pubblicazione_dir")
    protected Integer codPubblicazioneDir;
    @XmlElement(name = "cod_sett")
    protected String codSett;
    @XmlElement(name = "data_bu")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataBu;
    @XmlElement(name = "data_cancellazione")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataCancellazione;
    @XmlElement(name = "data_determ")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataDeterm;
    @XmlElement(name = "data_estrazione")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataEstrazione;
    @XmlElement(name = "data_ini_dir")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataIniDir;
    @XmlElement(name = "data_ini_sett")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataIniSett;
    @XmlElement(name = "data_invio_trasmissione")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInvioTrasmissione;
    @XmlElement(name = "data_notiziario")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataNotiziario;
    @XmlElement(name = "data_pres_carico")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataPresCarico;
    @XmlElement(name = "data_validazione")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataValidazione;
    @XmlElement(name = "data_visto")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataVisto;
    @XmlElement(name = "det_vecchia_burp")
    protected Integer detVecchiaBurp;
    @XmlElement(name = "flag_estratto")
    protected Integer flagEstratto;
    @XmlElement(name = "flag_pubb_all")
    protected Integer flagPubbAll;
    @XmlElement(name = "flag_spesa")
    protected String flagSpesa;
    @XmlElement(name = "flag_trasm")
    protected String flagTrasm;
    @XmlElement(name = "id_bollettino")
    protected Integer idBollettino;
    protected String identificativo;
    @XmlElement(name = "impegni_multipli")
    protected Integer impegniMultipli;
    @XmlElement(name = "impegno_delegato")
    protected Integer impegnoDelegato;
    @XmlElement(name = "matr_ute")
    protected String matrUte;
    @XmlElement(name = "modifica_di_impegno")
    protected Integer modificaDiImpegno;
    @XmlElement(name = "note_notiziario")
    protected String noteNotiziario;
    @XmlElement(name = "note_pubblicazione")
    protected String notePubblicazione;
    @XmlElement(name = "num_determ")
    protected Integer numDeterm;
    @XmlElement(name = "num_legisl")
    protected Integer numLegisl;
    @XmlElement(name = "numero_bu")
    protected Integer numeroBu;
    @XmlElement(name = "numero_notiziario")
    protected Integer numeroNotiziario;
    protected String oggetto;
    protected String personale;
    @XmlElement(name = "pubbl_notiziario")
    protected Integer pubblNotiziario;
    protected Integer ragioneria;
    @XmlElement(name = "referente_notiziario")
    protected String referenteNotiziario;
    protected String sensibile;
    protected String stato;
    protected Integer supplemento;
    protected String urgenza;
    @XmlElement(name = "valutazioni_conc_persone")
    protected Integer valutazioniConcPersone;

    /**
     * Recupera il valore della propriet� anno.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAnno() {
        return anno;
    }

    /**
     * Imposta il valore della propriet� anno.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAnno(Integer value) {
        this.anno = value;
    }

    /**
     * Recupera il valore della propriet� avvenutoImpegno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvvenutoImpegno() {
        return avvenutoImpegno;
    }

    /**
     * Imposta il valore della propriet� avvenutoImpegno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvvenutoImpegno(String value) {
        this.avvenutoImpegno = value;
    }

    /**
     * Recupera il valore della propriet� codDir.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDir() {
        return codDir;
    }

    /**
     * Imposta il valore della propriet� codDir.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDir(String value) {
        this.codDir = value;
    }

    /**
     * Recupera il valore della propriet� codMateria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMateria() {
        return codMateria;
    }

    /**
     * Imposta il valore della propriet� codMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMateria(String value) {
        this.codMateria = value;
    }

    /**
     * Recupera il valore della propriet� codPubblicazione.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodPubblicazione() {
        return codPubblicazione;
    }

    /**
     * Imposta il valore della propriet� codPubblicazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodPubblicazione(Integer value) {
        this.codPubblicazione = value;
    }

    /**
     * Recupera il valore della propriet� codPubblicazioneDir.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodPubblicazioneDir() {
        return codPubblicazioneDir;
    }

    /**
     * Imposta il valore della propriet� codPubblicazioneDir.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodPubblicazioneDir(Integer value) {
        this.codPubblicazioneDir = value;
    }

    /**
     * Recupera il valore della propriet� codSett.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSett() {
        return codSett;
    }

    /**
     * Imposta il valore della propriet� codSett.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSett(String value) {
        this.codSett = value;
    }

    /**
     * Recupera il valore della propriet� dataBu.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataBu() {
        return dataBu;
    }

    /**
     * Imposta il valore della propriet� dataBu.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataBu(XMLGregorianCalendar value) {
        this.dataBu = value;
    }

    /**
     * Recupera il valore della propriet� dataCancellazione.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataCancellazione() {
        return dataCancellazione;
    }

    /**
     * Imposta il valore della propriet� dataCancellazione.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataCancellazione(XMLGregorianCalendar value) {
        this.dataCancellazione = value;
    }

    /**
     * Recupera il valore della propriet� dataDeterm.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataDeterm() {
        return dataDeterm;
    }

    /**
     * Imposta il valore della propriet� dataDeterm.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataDeterm(XMLGregorianCalendar value) {
        this.dataDeterm = value;
    }

    /**
     * Recupera il valore della propriet� dataEstrazione.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataEstrazione() {
        return dataEstrazione;
    }

    /**
     * Imposta il valore della propriet� dataEstrazione.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataEstrazione(XMLGregorianCalendar value) {
        this.dataEstrazione = value;
    }

    /**
     * Recupera il valore della propriet� dataIniDir.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataIniDir() {
        return dataIniDir;
    }

    /**
     * Imposta il valore della propriet� dataIniDir.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataIniDir(XMLGregorianCalendar value) {
        this.dataIniDir = value;
    }

    /**
     * Recupera il valore della propriet� dataIniSett.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataIniSett() {
        return dataIniSett;
    }

    /**
     * Imposta il valore della propriet� dataIniSett.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataIniSett(XMLGregorianCalendar value) {
        this.dataIniSett = value;
    }

    /**
     * Recupera il valore della propriet� dataInvioTrasmissione.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInvioTrasmissione() {
        return dataInvioTrasmissione;
    }

    /**
     * Imposta il valore della propriet� dataInvioTrasmissione.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInvioTrasmissione(XMLGregorianCalendar value) {
        this.dataInvioTrasmissione = value;
    }

    /**
     * Recupera il valore della propriet� dataNotiziario.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataNotiziario() {
        return dataNotiziario;
    }

    /**
     * Imposta il valore della propriet� dataNotiziario.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataNotiziario(XMLGregorianCalendar value) {
        this.dataNotiziario = value;
    }

    /**
     * Recupera il valore della propriet� dataPresCarico.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataPresCarico() {
        return dataPresCarico;
    }

    /**
     * Imposta il valore della propriet� dataPresCarico.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataPresCarico(XMLGregorianCalendar value) {
        this.dataPresCarico = value;
    }

    /**
     * Recupera il valore della propriet� dataValidazione.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataValidazione() {
        return dataValidazione;
    }

    /**
     * Imposta il valore della propriet� dataValidazione.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataValidazione(XMLGregorianCalendar value) {
        this.dataValidazione = value;
    }

    /**
     * Recupera il valore della propriet� dataVisto.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataVisto() {
        return dataVisto;
    }

    /**
     * Imposta il valore della propriet� dataVisto.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataVisto(XMLGregorianCalendar value) {
        this.dataVisto = value;
    }

    /**
     * Recupera il valore della propriet� detVecchiaBurp.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDetVecchiaBurp() {
        return detVecchiaBurp;
    }

    /**
     * Imposta il valore della propriet� detVecchiaBurp.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDetVecchiaBurp(Integer value) {
        this.detVecchiaBurp = value;
    }

    /**
     * Recupera il valore della propriet� flagEstratto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFlagEstratto() {
        return flagEstratto;
    }

    /**
     * Imposta il valore della propriet� flagEstratto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFlagEstratto(Integer value) {
        this.flagEstratto = value;
    }

    /**
     * Recupera il valore della propriet� flagPubbAll.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFlagPubbAll() {
        return flagPubbAll;
    }

    /**
     * Imposta il valore della propriet� flagPubbAll.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFlagPubbAll(Integer value) {
        this.flagPubbAll = value;
    }

    /**
     * Recupera il valore della propriet� flagSpesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagSpesa() {
        return flagSpesa;
    }

    /**
     * Imposta il valore della propriet� flagSpesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagSpesa(String value) {
        this.flagSpesa = value;
    }

    /**
     * Recupera il valore della propriet� flagTrasm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagTrasm() {
        return flagTrasm;
    }

    /**
     * Imposta il valore della propriet� flagTrasm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagTrasm(String value) {
        this.flagTrasm = value;
    }

    /**
     * Recupera il valore della propriet� idBollettino.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdBollettino() {
        return idBollettino;
    }

    /**
     * Imposta il valore della propriet� idBollettino.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdBollettino(Integer value) {
        this.idBollettino = value;
    }

    /**
     * Recupera il valore della propriet� identificativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificativo() {
        return identificativo;
    }

    /**
     * Imposta il valore della propriet� identificativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificativo(String value) {
        this.identificativo = value;
    }

    /**
     * Recupera il valore della propriet� impegniMultipli.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getImpegniMultipli() {
        return impegniMultipli;
    }

    /**
     * Imposta il valore della propriet� impegniMultipli.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setImpegniMultipli(Integer value) {
        this.impegniMultipli = value;
    }

    /**
     * Recupera il valore della propriet� impegnoDelegato.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getImpegnoDelegato() {
        return impegnoDelegato;
    }

    /**
     * Imposta il valore della propriet� impegnoDelegato.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setImpegnoDelegato(Integer value) {
        this.impegnoDelegato = value;
    }

    /**
     * Recupera il valore della propriet� matrUte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatrUte() {
        return matrUte;
    }

    /**
     * Imposta il valore della propriet� matrUte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatrUte(String value) {
        this.matrUte = value;
    }

    /**
     * Recupera il valore della propriet� modificaDiImpegno.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getModificaDiImpegno() {
        return modificaDiImpegno;
    }

    /**
     * Imposta il valore della propriet� modificaDiImpegno.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setModificaDiImpegno(Integer value) {
        this.modificaDiImpegno = value;
    }

    /**
     * Recupera il valore della propriet� noteNotiziario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteNotiziario() {
        return noteNotiziario;
    }

    /**
     * Imposta il valore della propriet� noteNotiziario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteNotiziario(String value) {
        this.noteNotiziario = value;
    }

    /**
     * Recupera il valore della propriet� notePubblicazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotePubblicazione() {
        return notePubblicazione;
    }

    /**
     * Imposta il valore della propriet� notePubblicazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotePubblicazione(String value) {
        this.notePubblicazione = value;
    }

    /**
     * Recupera il valore della propriet� numDeterm.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumDeterm() {
        return numDeterm;
    }

    /**
     * Imposta il valore della propriet� numDeterm.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumDeterm(Integer value) {
        this.numDeterm = value;
    }

    /**
     * Recupera il valore della propriet� numLegisl.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumLegisl() {
        return numLegisl;
    }

    /**
     * Imposta il valore della propriet� numLegisl.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumLegisl(Integer value) {
        this.numLegisl = value;
    }

    /**
     * Recupera il valore della propriet� numeroBu.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroBu() {
        return numeroBu;
    }

    /**
     * Imposta il valore della propriet� numeroBu.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroBu(Integer value) {
        this.numeroBu = value;
    }

    /**
     * Recupera il valore della propriet� numeroNotiziario.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroNotiziario() {
        return numeroNotiziario;
    }

    /**
     * Imposta il valore della propriet� numeroNotiziario.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroNotiziario(Integer value) {
        this.numeroNotiziario = value;
    }

    /**
     * Recupera il valore della propriet� oggetto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOggetto() {
        return oggetto;
    }

    /**
     * Imposta il valore della propriet� oggetto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOggetto(String value) {
        this.oggetto = value;
    }

    /**
     * Recupera il valore della propriet� personale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonale() {
        return personale;
    }

    /**
     * Imposta il valore della propriet� personale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonale(String value) {
        this.personale = value;
    }

    /**
     * Recupera il valore della propriet� pubblNotiziario.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPubblNotiziario() {
        return pubblNotiziario;
    }

    /**
     * Imposta il valore della propriet� pubblNotiziario.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPubblNotiziario(Integer value) {
        this.pubblNotiziario = value;
    }

    /**
     * Recupera il valore della propriet� ragioneria.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRagioneria() {
        return ragioneria;
    }

    /**
     * Imposta il valore della propriet� ragioneria.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRagioneria(Integer value) {
        this.ragioneria = value;
    }

    /**
     * Recupera il valore della propriet� referenteNotiziario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenteNotiziario() {
        return referenteNotiziario;
    }

    /**
     * Imposta il valore della propriet� referenteNotiziario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenteNotiziario(String value) {
        this.referenteNotiziario = value;
    }

    /**
     * Recupera il valore della propriet� sensibile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSensibile() {
        return sensibile;
    }

    /**
     * Imposta il valore della propriet� sensibile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSensibile(String value) {
        this.sensibile = value;
    }

    /**
     * Recupera il valore della propriet� stato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStato() {
        return stato;
    }

    /**
     * Imposta il valore della propriet� stato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStato(String value) {
        this.stato = value;
    }

    /**
     * Recupera il valore della propriet� supplemento.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSupplemento() {
        return supplemento;
    }

    /**
     * Imposta il valore della propriet� supplemento.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSupplemento(Integer value) {
        this.supplemento = value;
    }

    /**
     * Recupera il valore della propriet� urgenza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrgenza() {
        return urgenza;
    }

    /**
     * Imposta il valore della propriet� urgenza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrgenza(String value) {
        this.urgenza = value;
    }

    /**
     * Recupera il valore della propriet� valutazioniConcPersone.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getValutazioniConcPersone() {
        return valutazioniConcPersone;
    }

    /**
     * Imposta il valore della propriet� valutazioniConcPersone.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setValutazioniConcPersone(Integer value) {
        this.valutazioniConcPersone = value;
    }

}
