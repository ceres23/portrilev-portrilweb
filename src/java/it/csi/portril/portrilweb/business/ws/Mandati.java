/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per mandati complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="mandati">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aliqIrpComu" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="annoEsercizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoimp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoparc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cassaEmessi" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="cassaStanz" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="casteEmessi" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="casteStanz" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="causale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="causaleCcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cig" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codIntervClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codNota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codben" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codparc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codstip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codtrib" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contoVincolato" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataagg" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataannu" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataemis" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datapaga" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datapagaRit" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datarid" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datascad" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datastam" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datastorno" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datastornoRit" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datatrasm" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datavaluta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="descri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distinta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="divisaUsata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="impoini" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="impopag" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="impopagRit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="imporid" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="impostorno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="impostornoRit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inpsal" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="inpsaltracassa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inpsassog" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inpsdal" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="inpsdetraz" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inpsente" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inpsimpon" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inpsimpos" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="irapimpon" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="irpSuRitint" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="irpSuSommeint" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="irpammlordo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="irpcontributi" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="irpdetconiuge" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="irpdetlavoro" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="irpgiorni" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="irpimpon" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="irpimpos" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="irpimposlorda" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="irpnonsogg" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ncarta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nimp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nliq" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nmand" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nmandInps" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nquiet" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nquietRit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nriscInps" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nriscos" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroArticolo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroCapitolo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nstorno" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nstornoRit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nsubimp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numDistintaStampa" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="progben" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ragSoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reddDetraz" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="reddNodetraz" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="stamand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="staoper" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statoAc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="superMand" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="utente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="voceSpesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vocecousc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mandati", propOrder = {
    "aliqIrpComu",
    "annoEsercizio",
    "annoimp",
    "annoparc",
    "cassaEmessi",
    "cassaStanz",
    "casteEmessi",
    "casteStanz",
    "causale",
    "causaleCcp",
    "cig",
    "codAttivita",
    "codIntervClass",
    "codNota",
    "codben",
    "codbol",
    "codparc",
    "codstip",
    "codtrib",
    "contoVincolato",
    "cup",
    "dataagg",
    "dataannu",
    "dataemis",
    "datapaga",
    "datapagaRit",
    "datarid",
    "datascad",
    "datastam",
    "datastorno",
    "datastornoRit",
    "datatrasm",
    "datavaluta",
    "descri",
    "distinta",
    "divisaUsata",
    "impoini",
    "impopag",
    "impopagRit",
    "imporid",
    "impostorno",
    "impostornoRit",
    "inpsal",
    "inpsaltracassa",
    "inpsassog",
    "inpsdal",
    "inpsdetraz",
    "inpsente",
    "inpsimpon",
    "inpsimpos",
    "irapimpon",
    "irpSuRitint",
    "irpSuSommeint",
    "irpammlordo",
    "irpcontributi",
    "irpdetconiuge",
    "irpdetlavoro",
    "irpgiorni",
    "irpimpon",
    "irpimpos",
    "irpimposlorda",
    "irpnonsogg",
    "ncarta",
    "nimp",
    "nliq",
    "nmand",
    "nmandInps",
    "nquiet",
    "nquietRit",
    "nriscInps",
    "nriscos",
    "nroArticolo",
    "nroCapitolo",
    "nstorno",
    "nstornoRit",
    "nsubimp",
    "numDistintaStampa",
    "progben",
    "ragSoc",
    "reddDetraz",
    "reddNodetraz",
    "stamand",
    "staoper",
    "statoAc",
    "superMand",
    "utente",
    "voceSpesa",
    "vocecousc"
})
public class Mandati {

    protected Double aliqIrpComu;
    protected String annoEsercizio;
    protected String annoimp;
    protected String annoparc;
    protected Double cassaEmessi;
    protected Double cassaStanz;
    protected Double casteEmessi;
    protected Double casteStanz;
    protected String causale;
    protected String causaleCcp;
    protected String cig;
    protected String codAttivita;
    protected String codIntervClass;
    protected String codNota;
    protected Integer codben;
    protected String codbol;
    protected String codparc;
    protected String codstip;
    protected String codtrib;
    protected Integer contoVincolato;
    protected String cup;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataagg;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataannu;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataemis;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datapaga;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datapagaRit;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datarid;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datascad;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datastam;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datastorno;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datastornoRit;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datatrasm;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datavaluta;
    protected String descri;
    protected String distinta;
    protected String divisaUsata;
    protected Double impoini;
    protected Double impopag;
    protected Double impopagRit;
    protected Double imporid;
    protected Double impostorno;
    protected Double impostornoRit;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar inpsal;
    protected String inpsaltracassa;
    protected String inpsassog;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar inpsdal;
    protected Double inpsdetraz;
    protected Double inpsente;
    protected Double inpsimpon;
    protected Double inpsimpos;
    protected Double irapimpon;
    protected Double irpSuRitint;
    protected Double irpSuSommeint;
    protected Double irpammlordo;
    protected Double irpcontributi;
    protected Double irpdetconiuge;
    protected Double irpdetlavoro;
    protected Double irpgiorni;
    protected Double irpimpon;
    protected Double irpimpos;
    protected Double irpimposlorda;
    protected Double irpnonsogg;
    protected Integer ncarta;
    protected Integer nimp;
    protected Integer nliq;
    protected Integer nmand;
    protected Integer nmandInps;
    protected Integer nquiet;
    protected Integer nquietRit;
    protected Integer nriscInps;
    protected Integer nriscos;
    protected Integer nroArticolo;
    protected Integer nroCapitolo;
    protected Integer nstorno;
    protected Integer nstornoRit;
    protected Integer nsubimp;
    protected Integer numDistintaStampa;
    protected Integer progben;
    protected String ragSoc;
    protected Double reddDetraz;
    protected Double reddNodetraz;
    protected String stamand;
    protected String staoper;
    protected String statoAc;
    protected Integer superMand;
    protected String utente;
    protected String voceSpesa;
    protected String vocecousc;

    /**
     * Recupera il valore della propriet� aliqIrpComu.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAliqIrpComu() {
        return aliqIrpComu;
    }

    /**
     * Imposta il valore della propriet� aliqIrpComu.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAliqIrpComu(Double value) {
        this.aliqIrpComu = value;
    }

    /**
     * Recupera il valore della propriet� annoEsercizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoEsercizio() {
        return annoEsercizio;
    }

    /**
     * Imposta il valore della propriet� annoEsercizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoEsercizio(String value) {
        this.annoEsercizio = value;
    }

    /**
     * Recupera il valore della propriet� annoimp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoimp() {
        return annoimp;
    }

    /**
     * Imposta il valore della propriet� annoimp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoimp(String value) {
        this.annoimp = value;
    }

    /**
     * Recupera il valore della propriet� annoparc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoparc() {
        return annoparc;
    }

    /**
     * Imposta il valore della propriet� annoparc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoparc(String value) {
        this.annoparc = value;
    }

    /**
     * Recupera il valore della propriet� cassaEmessi.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCassaEmessi() {
        return cassaEmessi;
    }

    /**
     * Imposta il valore della propriet� cassaEmessi.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCassaEmessi(Double value) {
        this.cassaEmessi = value;
    }

    /**
     * Recupera il valore della propriet� cassaStanz.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCassaStanz() {
        return cassaStanz;
    }

    /**
     * Imposta il valore della propriet� cassaStanz.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCassaStanz(Double value) {
        this.cassaStanz = value;
    }

    /**
     * Recupera il valore della propriet� casteEmessi.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCasteEmessi() {
        return casteEmessi;
    }

    /**
     * Imposta il valore della propriet� casteEmessi.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCasteEmessi(Double value) {
        this.casteEmessi = value;
    }

    /**
     * Recupera il valore della propriet� casteStanz.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCasteStanz() {
        return casteStanz;
    }

    /**
     * Imposta il valore della propriet� casteStanz.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCasteStanz(Double value) {
        this.casteStanz = value;
    }

    /**
     * Recupera il valore della propriet� causale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCausale() {
        return causale;
    }

    /**
     * Imposta il valore della propriet� causale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCausale(String value) {
        this.causale = value;
    }

    /**
     * Recupera il valore della propriet� causaleCcp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCausaleCcp() {
        return causaleCcp;
    }

    /**
     * Imposta il valore della propriet� causaleCcp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCausaleCcp(String value) {
        this.causaleCcp = value;
    }

    /**
     * Recupera il valore della propriet� cig.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCig() {
        return cig;
    }

    /**
     * Imposta il valore della propriet� cig.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCig(String value) {
        this.cig = value;
    }

    /**
     * Recupera il valore della propriet� codAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAttivita() {
        return codAttivita;
    }

    /**
     * Imposta il valore della propriet� codAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAttivita(String value) {
        this.codAttivita = value;
    }

    /**
     * Recupera il valore della propriet� codIntervClass.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodIntervClass() {
        return codIntervClass;
    }

    /**
     * Imposta il valore della propriet� codIntervClass.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodIntervClass(String value) {
        this.codIntervClass = value;
    }

    /**
     * Recupera il valore della propriet� codNota.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNota() {
        return codNota;
    }

    /**
     * Imposta il valore della propriet� codNota.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNota(String value) {
        this.codNota = value;
    }

    /**
     * Recupera il valore della propriet� codben.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodben() {
        return codben;
    }

    /**
     * Imposta il valore della propriet� codben.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodben(Integer value) {
        this.codben = value;
    }

    /**
     * Recupera il valore della propriet� codbol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodbol() {
        return codbol;
    }

    /**
     * Imposta il valore della propriet� codbol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodbol(String value) {
        this.codbol = value;
    }

    /**
     * Recupera il valore della propriet� codparc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodparc() {
        return codparc;
    }

    /**
     * Imposta il valore della propriet� codparc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodparc(String value) {
        this.codparc = value;
    }

    /**
     * Recupera il valore della propriet� codstip.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodstip() {
        return codstip;
    }

    /**
     * Imposta il valore della propriet� codstip.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodstip(String value) {
        this.codstip = value;
    }

    /**
     * Recupera il valore della propriet� codtrib.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodtrib() {
        return codtrib;
    }

    /**
     * Imposta il valore della propriet� codtrib.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodtrib(String value) {
        this.codtrib = value;
    }

    /**
     * Recupera il valore della propriet� contoVincolato.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getContoVincolato() {
        return contoVincolato;
    }

    /**
     * Imposta il valore della propriet� contoVincolato.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setContoVincolato(Integer value) {
        this.contoVincolato = value;
    }

    /**
     * Recupera il valore della propriet� cup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCup() {
        return cup;
    }

    /**
     * Imposta il valore della propriet� cup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCup(String value) {
        this.cup = value;
    }

    /**
     * Recupera il valore della propriet� dataagg.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataagg() {
        return dataagg;
    }

    /**
     * Imposta il valore della propriet� dataagg.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataagg(XMLGregorianCalendar value) {
        this.dataagg = value;
    }

    /**
     * Recupera il valore della propriet� dataannu.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataannu() {
        return dataannu;
    }

    /**
     * Imposta il valore della propriet� dataannu.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataannu(XMLGregorianCalendar value) {
        this.dataannu = value;
    }

    /**
     * Recupera il valore della propriet� dataemis.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataemis() {
        return dataemis;
    }

    /**
     * Imposta il valore della propriet� dataemis.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataemis(XMLGregorianCalendar value) {
        this.dataemis = value;
    }

    /**
     * Recupera il valore della propriet� datapaga.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatapaga() {
        return datapaga;
    }

    /**
     * Imposta il valore della propriet� datapaga.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatapaga(XMLGregorianCalendar value) {
        this.datapaga = value;
    }

    /**
     * Recupera il valore della propriet� datapagaRit.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatapagaRit() {
        return datapagaRit;
    }

    /**
     * Imposta il valore della propriet� datapagaRit.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatapagaRit(XMLGregorianCalendar value) {
        this.datapagaRit = value;
    }

    /**
     * Recupera il valore della propriet� datarid.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatarid() {
        return datarid;
    }

    /**
     * Imposta il valore della propriet� datarid.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatarid(XMLGregorianCalendar value) {
        this.datarid = value;
    }

    /**
     * Recupera il valore della propriet� datascad.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatascad() {
        return datascad;
    }

    /**
     * Imposta il valore della propriet� datascad.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatascad(XMLGregorianCalendar value) {
        this.datascad = value;
    }

    /**
     * Recupera il valore della propriet� datastam.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatastam() {
        return datastam;
    }

    /**
     * Imposta il valore della propriet� datastam.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatastam(XMLGregorianCalendar value) {
        this.datastam = value;
    }

    /**
     * Recupera il valore della propriet� datastorno.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatastorno() {
        return datastorno;
    }

    /**
     * Imposta il valore della propriet� datastorno.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatastorno(XMLGregorianCalendar value) {
        this.datastorno = value;
    }

    /**
     * Recupera il valore della propriet� datastornoRit.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatastornoRit() {
        return datastornoRit;
    }

    /**
     * Imposta il valore della propriet� datastornoRit.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatastornoRit(XMLGregorianCalendar value) {
        this.datastornoRit = value;
    }

    /**
     * Recupera il valore della propriet� datatrasm.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatatrasm() {
        return datatrasm;
    }

    /**
     * Imposta il valore della propriet� datatrasm.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatatrasm(XMLGregorianCalendar value) {
        this.datatrasm = value;
    }

    /**
     * Recupera il valore della propriet� datavaluta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatavaluta() {
        return datavaluta;
    }

    /**
     * Imposta il valore della propriet� datavaluta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatavaluta(XMLGregorianCalendar value) {
        this.datavaluta = value;
    }

    /**
     * Recupera il valore della propriet� descri.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescri() {
        return descri;
    }

    /**
     * Imposta il valore della propriet� descri.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescri(String value) {
        this.descri = value;
    }

    /**
     * Recupera il valore della propriet� distinta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistinta() {
        return distinta;
    }

    /**
     * Imposta il valore della propriet� distinta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistinta(String value) {
        this.distinta = value;
    }

    /**
     * Recupera il valore della propriet� divisaUsata.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDivisaUsata() {
        return divisaUsata;
    }

    /**
     * Imposta il valore della propriet� divisaUsata.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDivisaUsata(String value) {
        this.divisaUsata = value;
    }

    /**
     * Recupera il valore della propriet� impoini.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImpoini() {
        return impoini;
    }

    /**
     * Imposta il valore della propriet� impoini.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImpoini(Double value) {
        this.impoini = value;
    }

    /**
     * Recupera il valore della propriet� impopag.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImpopag() {
        return impopag;
    }

    /**
     * Imposta il valore della propriet� impopag.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImpopag(Double value) {
        this.impopag = value;
    }

    /**
     * Recupera il valore della propriet� impopagRit.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImpopagRit() {
        return impopagRit;
    }

    /**
     * Imposta il valore della propriet� impopagRit.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImpopagRit(Double value) {
        this.impopagRit = value;
    }

    /**
     * Recupera il valore della propriet� imporid.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImporid() {
        return imporid;
    }

    /**
     * Imposta il valore della propriet� imporid.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImporid(Double value) {
        this.imporid = value;
    }

    /**
     * Recupera il valore della propriet� impostorno.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImpostorno() {
        return impostorno;
    }

    /**
     * Imposta il valore della propriet� impostorno.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImpostorno(Double value) {
        this.impostorno = value;
    }

    /**
     * Recupera il valore della propriet� impostornoRit.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImpostornoRit() {
        return impostornoRit;
    }

    /**
     * Imposta il valore della propriet� impostornoRit.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImpostornoRit(Double value) {
        this.impostornoRit = value;
    }

    /**
     * Recupera il valore della propriet� inpsal.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInpsal() {
        return inpsal;
    }

    /**
     * Imposta il valore della propriet� inpsal.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInpsal(XMLGregorianCalendar value) {
        this.inpsal = value;
    }

    /**
     * Recupera il valore della propriet� inpsaltracassa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInpsaltracassa() {
        return inpsaltracassa;
    }

    /**
     * Imposta il valore della propriet� inpsaltracassa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInpsaltracassa(String value) {
        this.inpsaltracassa = value;
    }

    /**
     * Recupera il valore della propriet� inpsassog.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInpsassog() {
        return inpsassog;
    }

    /**
     * Imposta il valore della propriet� inpsassog.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInpsassog(String value) {
        this.inpsassog = value;
    }

    /**
     * Recupera il valore della propriet� inpsdal.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInpsdal() {
        return inpsdal;
    }

    /**
     * Imposta il valore della propriet� inpsdal.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInpsdal(XMLGregorianCalendar value) {
        this.inpsdal = value;
    }

    /**
     * Recupera il valore della propriet� inpsdetraz.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInpsdetraz() {
        return inpsdetraz;
    }

    /**
     * Imposta il valore della propriet� inpsdetraz.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInpsdetraz(Double value) {
        this.inpsdetraz = value;
    }

    /**
     * Recupera il valore della propriet� inpsente.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInpsente() {
        return inpsente;
    }

    /**
     * Imposta il valore della propriet� inpsente.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInpsente(Double value) {
        this.inpsente = value;
    }

    /**
     * Recupera il valore della propriet� inpsimpon.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInpsimpon() {
        return inpsimpon;
    }

    /**
     * Imposta il valore della propriet� inpsimpon.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInpsimpon(Double value) {
        this.inpsimpon = value;
    }

    /**
     * Recupera il valore della propriet� inpsimpos.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInpsimpos() {
        return inpsimpos;
    }

    /**
     * Imposta il valore della propriet� inpsimpos.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInpsimpos(Double value) {
        this.inpsimpos = value;
    }

    /**
     * Recupera il valore della propriet� irapimpon.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrapimpon() {
        return irapimpon;
    }

    /**
     * Imposta il valore della propriet� irapimpon.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrapimpon(Double value) {
        this.irapimpon = value;
    }

    /**
     * Recupera il valore della propriet� irpSuRitint.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrpSuRitint() {
        return irpSuRitint;
    }

    /**
     * Imposta il valore della propriet� irpSuRitint.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrpSuRitint(Double value) {
        this.irpSuRitint = value;
    }

    /**
     * Recupera il valore della propriet� irpSuSommeint.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrpSuSommeint() {
        return irpSuSommeint;
    }

    /**
     * Imposta il valore della propriet� irpSuSommeint.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrpSuSommeint(Double value) {
        this.irpSuSommeint = value;
    }

    /**
     * Recupera il valore della propriet� irpammlordo.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrpammlordo() {
        return irpammlordo;
    }

    /**
     * Imposta il valore della propriet� irpammlordo.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrpammlordo(Double value) {
        this.irpammlordo = value;
    }

    /**
     * Recupera il valore della propriet� irpcontributi.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrpcontributi() {
        return irpcontributi;
    }

    /**
     * Imposta il valore della propriet� irpcontributi.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrpcontributi(Double value) {
        this.irpcontributi = value;
    }

    /**
     * Recupera il valore della propriet� irpdetconiuge.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrpdetconiuge() {
        return irpdetconiuge;
    }

    /**
     * Imposta il valore della propriet� irpdetconiuge.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrpdetconiuge(Double value) {
        this.irpdetconiuge = value;
    }

    /**
     * Recupera il valore della propriet� irpdetlavoro.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrpdetlavoro() {
        return irpdetlavoro;
    }

    /**
     * Imposta il valore della propriet� irpdetlavoro.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrpdetlavoro(Double value) {
        this.irpdetlavoro = value;
    }

    /**
     * Recupera il valore della propriet� irpgiorni.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrpgiorni() {
        return irpgiorni;
    }

    /**
     * Imposta il valore della propriet� irpgiorni.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrpgiorni(Double value) {
        this.irpgiorni = value;
    }

    /**
     * Recupera il valore della propriet� irpimpon.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrpimpon() {
        return irpimpon;
    }

    /**
     * Imposta il valore della propriet� irpimpon.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrpimpon(Double value) {
        this.irpimpon = value;
    }

    /**
     * Recupera il valore della propriet� irpimpos.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrpimpos() {
        return irpimpos;
    }

    /**
     * Imposta il valore della propriet� irpimpos.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrpimpos(Double value) {
        this.irpimpos = value;
    }

    /**
     * Recupera il valore della propriet� irpimposlorda.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrpimposlorda() {
        return irpimposlorda;
    }

    /**
     * Imposta il valore della propriet� irpimposlorda.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrpimposlorda(Double value) {
        this.irpimposlorda = value;
    }

    /**
     * Recupera il valore della propriet� irpnonsogg.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrpnonsogg() {
        return irpnonsogg;
    }

    /**
     * Imposta il valore della propriet� irpnonsogg.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrpnonsogg(Double value) {
        this.irpnonsogg = value;
    }

    /**
     * Recupera il valore della propriet� ncarta.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNcarta() {
        return ncarta;
    }

    /**
     * Imposta il valore della propriet� ncarta.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNcarta(Integer value) {
        this.ncarta = value;
    }

    /**
     * Recupera il valore della propriet� nimp.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNimp() {
        return nimp;
    }

    /**
     * Imposta il valore della propriet� nimp.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNimp(Integer value) {
        this.nimp = value;
    }

    /**
     * Recupera il valore della propriet� nliq.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNliq() {
        return nliq;
    }

    /**
     * Imposta il valore della propriet� nliq.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNliq(Integer value) {
        this.nliq = value;
    }

    /**
     * Recupera il valore della propriet� nmand.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNmand() {
        return nmand;
    }

    /**
     * Imposta il valore della propriet� nmand.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNmand(Integer value) {
        this.nmand = value;
    }

    /**
     * Recupera il valore della propriet� nmandInps.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNmandInps() {
        return nmandInps;
    }

    /**
     * Imposta il valore della propriet� nmandInps.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNmandInps(Integer value) {
        this.nmandInps = value;
    }

    /**
     * Recupera il valore della propriet� nquiet.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNquiet() {
        return nquiet;
    }

    /**
     * Imposta il valore della propriet� nquiet.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNquiet(Integer value) {
        this.nquiet = value;
    }

    /**
     * Recupera il valore della propriet� nquietRit.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNquietRit() {
        return nquietRit;
    }

    /**
     * Imposta il valore della propriet� nquietRit.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNquietRit(Integer value) {
        this.nquietRit = value;
    }

    /**
     * Recupera il valore della propriet� nriscInps.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNriscInps() {
        return nriscInps;
    }

    /**
     * Imposta il valore della propriet� nriscInps.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNriscInps(Integer value) {
        this.nriscInps = value;
    }

    /**
     * Recupera il valore della propriet� nriscos.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNriscos() {
        return nriscos;
    }

    /**
     * Imposta il valore della propriet� nriscos.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNriscos(Integer value) {
        this.nriscos = value;
    }

    /**
     * Recupera il valore della propriet� nroArticolo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNroArticolo() {
        return nroArticolo;
    }

    /**
     * Imposta il valore della propriet� nroArticolo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNroArticolo(Integer value) {
        this.nroArticolo = value;
    }

    /**
     * Recupera il valore della propriet� nroCapitolo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNroCapitolo() {
        return nroCapitolo;
    }

    /**
     * Imposta il valore della propriet� nroCapitolo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNroCapitolo(Integer value) {
        this.nroCapitolo = value;
    }

    /**
     * Recupera il valore della propriet� nstorno.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNstorno() {
        return nstorno;
    }

    /**
     * Imposta il valore della propriet� nstorno.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNstorno(Integer value) {
        this.nstorno = value;
    }

    /**
     * Recupera il valore della propriet� nstornoRit.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNstornoRit() {
        return nstornoRit;
    }

    /**
     * Imposta il valore della propriet� nstornoRit.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNstornoRit(Integer value) {
        this.nstornoRit = value;
    }

    /**
     * Recupera il valore della propriet� nsubimp.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNsubimp() {
        return nsubimp;
    }

    /**
     * Imposta il valore della propriet� nsubimp.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNsubimp(Integer value) {
        this.nsubimp = value;
    }

    /**
     * Recupera il valore della propriet� numDistintaStampa.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumDistintaStampa() {
        return numDistintaStampa;
    }

    /**
     * Imposta il valore della propriet� numDistintaStampa.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumDistintaStampa(Integer value) {
        this.numDistintaStampa = value;
    }

    /**
     * Recupera il valore della propriet� progben.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProgben() {
        return progben;
    }

    /**
     * Imposta il valore della propriet� progben.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProgben(Integer value) {
        this.progben = value;
    }

    /**
     * Recupera il valore della propriet� ragSoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRagSoc() {
        return ragSoc;
    }

    /**
     * Imposta il valore della propriet� ragSoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRagSoc(String value) {
        this.ragSoc = value;
    }

    /**
     * Recupera il valore della propriet� reddDetraz.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getReddDetraz() {
        return reddDetraz;
    }

    /**
     * Imposta il valore della propriet� reddDetraz.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setReddDetraz(Double value) {
        this.reddDetraz = value;
    }

    /**
     * Recupera il valore della propriet� reddNodetraz.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getReddNodetraz() {
        return reddNodetraz;
    }

    /**
     * Imposta il valore della propriet� reddNodetraz.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setReddNodetraz(Double value) {
        this.reddNodetraz = value;
    }

    /**
     * Recupera il valore della propriet� stamand.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStamand() {
        return stamand;
    }

    /**
     * Imposta il valore della propriet� stamand.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStamand(String value) {
        this.stamand = value;
    }

    /**
     * Recupera il valore della propriet� staoper.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaoper() {
        return staoper;
    }

    /**
     * Imposta il valore della propriet� staoper.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaoper(String value) {
        this.staoper = value;
    }

    /**
     * Recupera il valore della propriet� statoAc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoAc() {
        return statoAc;
    }

    /**
     * Imposta il valore della propriet� statoAc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoAc(String value) {
        this.statoAc = value;
    }

    /**
     * Recupera il valore della propriet� superMand.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSuperMand() {
        return superMand;
    }

    /**
     * Imposta il valore della propriet� superMand.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSuperMand(Integer value) {
        this.superMand = value;
    }

    /**
     * Recupera il valore della propriet� utente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtente() {
        return utente;
    }

    /**
     * Imposta il valore della propriet� utente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtente(String value) {
        this.utente = value;
    }

    /**
     * Recupera il valore della propriet� voceSpesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoceSpesa() {
        return voceSpesa;
    }

    /**
     * Imposta il valore della propriet� voceSpesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoceSpesa(String value) {
        this.voceSpesa = value;
    }

    /**
     * Recupera il valore della propriet� vocecousc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVocecousc() {
        return vocecousc;
    }

    /**
     * Imposta il valore della propriet� vocecousc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVocecousc(String value) {
        this.vocecousc = value;
    }

}
