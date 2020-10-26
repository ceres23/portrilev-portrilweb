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
 * <p>Classe Java per impegno complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="impegno">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}impegnoKey">
 *       &lt;sequence>
 *         &lt;element name="annoPerente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoprov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="artOrigine" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="capOrigine" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cig" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codIntervClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codben" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codprov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codtitgiu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="corrEntr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="countMand" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataIns" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataagg" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataemis" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataprovv" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="descImpegno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descTipoForn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrCapitolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direzioneCapitolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direzioneDel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dispLiq" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="flagNoProv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="impoatt" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="impoini" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="impoorig" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="nord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nprov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nroArticolo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroCapitolo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroCapitoloOrig" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroPerente" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="partitaIva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plurienn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="provCap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ragSoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="staoper" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoFondo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoProv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoforn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totaleLiq" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="totalePagato" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="trasfTipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trasfVoce" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "impegno", propOrder = {
    "annoPerente",
    "annoprov",
    "artOrigine",
    "capOrigine",
    "cig",
    "codIntervClass",
    "codben",
    "codiceFiscale",
    "codprov",
    "codtitgiu",
    "corrEntr",
    "countMand",
    "cup",
    "dataIns",
    "dataagg",
    "dataemis",
    "dataprovv",
    "descImpegno",
    "descTipoForn",
    "descrCapitolo",
    "descri",
    "direzione",
    "direzioneCapitolo",
    "direzioneDel",
    "dispLiq",
    "flagNoProv",
    "impoatt",
    "impoini",
    "impoorig",
    "nord",
    "nprov",
    "nroArticolo",
    "nroCapitolo",
    "nroCapitoloOrig",
    "nroPerente",
    "partitaIva",
    "personaFisica",
    "plurienn",
    "provCap",
    "ragSoc",
    "staoper",
    "stato",
    "tipoFondo",
    "tipoProv",
    "tipoforn",
    "totaleLiq",
    "totalePagato",
    "trasfTipo",
    "trasfVoce",
    "utente"
})
public class Impegno
    extends ImpegnoKey
{

    protected String annoPerente;
    protected String annoprov;
    protected Integer artOrigine;
    protected Integer capOrigine;
    protected String cig;
    protected String codIntervClass;
    protected Integer codben;
    protected String codiceFiscale;
    protected String codprov;
    protected String codtitgiu;
    protected String corrEntr;
    protected Integer countMand;
    protected String cup;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataIns;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataagg;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataemis;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataprovv;
    protected String descImpegno;
    protected String descTipoForn;
    protected String descrCapitolo;
    protected String descri;
    protected String direzione;
    protected String direzioneCapitolo;
    protected String direzioneDel;
    protected Double dispLiq;
    protected String flagNoProv;
    protected Double impoatt;
    protected Double impoini;
    protected Double impoorig;
    protected String nord;
    protected String nprov;
    protected Integer nroArticolo;
    protected Integer nroCapitolo;
    protected Integer nroCapitoloOrig;
    protected Integer nroPerente;
    protected String partitaIva;
    protected String personaFisica;
    protected Integer plurienn;
    protected String provCap;
    protected String ragSoc;
    protected String staoper;
    protected String stato;
    protected String tipoFondo;
    protected String tipoProv;
    protected String tipoforn;
    protected Double totaleLiq;
    protected Double totalePagato;
    protected String trasfTipo;
    protected String trasfVoce;
    protected String utente;

    /**
     * Recupera il valore della proprietà annoPerente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoPerente() {
        return annoPerente;
    }

    /**
     * Imposta il valore della proprietà annoPerente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoPerente(String value) {
        this.annoPerente = value;
    }

    /**
     * Recupera il valore della proprietà annoprov.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoprov() {
        return annoprov;
    }

    /**
     * Imposta il valore della proprietà annoprov.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoprov(String value) {
        this.annoprov = value;
    }

    /**
     * Recupera il valore della proprietà artOrigine.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getArtOrigine() {
        return artOrigine;
    }

    /**
     * Imposta il valore della proprietà artOrigine.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setArtOrigine(Integer value) {
        this.artOrigine = value;
    }

    /**
     * Recupera il valore della proprietà capOrigine.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCapOrigine() {
        return capOrigine;
    }

    /**
     * Imposta il valore della proprietà capOrigine.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCapOrigine(Integer value) {
        this.capOrigine = value;
    }

    /**
     * Recupera il valore della proprietà cig.
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
     * Imposta il valore della proprietà cig.
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
     * Recupera il valore della proprietà codIntervClass.
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
     * Imposta il valore della proprietà codIntervClass.
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
     * Recupera il valore della proprietà codben.
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
     * Imposta il valore della proprietà codben.
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
     * Recupera il valore della proprietà codiceFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Imposta il valore della proprietà codiceFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscale(String value) {
        this.codiceFiscale = value;
    }

    /**
     * Recupera il valore della proprietà codprov.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodprov() {
        return codprov;
    }

    /**
     * Imposta il valore della proprietà codprov.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodprov(String value) {
        this.codprov = value;
    }

    /**
     * Recupera il valore della proprietà codtitgiu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodtitgiu() {
        return codtitgiu;
    }

    /**
     * Imposta il valore della proprietà codtitgiu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodtitgiu(String value) {
        this.codtitgiu = value;
    }

    /**
     * Recupera il valore della proprietà corrEntr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrEntr() {
        return corrEntr;
    }

    /**
     * Imposta il valore della proprietà corrEntr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrEntr(String value) {
        this.corrEntr = value;
    }

    /**
     * Recupera il valore della proprietà countMand.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCountMand() {
        return countMand;
    }

    /**
     * Imposta il valore della proprietà countMand.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCountMand(Integer value) {
        this.countMand = value;
    }

    /**
     * Recupera il valore della proprietà cup.
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
     * Imposta il valore della proprietà cup.
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
     * Recupera il valore della proprietà dataIns.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataIns() {
        return dataIns;
    }

    /**
     * Imposta il valore della proprietà dataIns.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataIns(XMLGregorianCalendar value) {
        this.dataIns = value;
    }

    /**
     * Recupera il valore della proprietà dataagg.
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
     * Imposta il valore della proprietà dataagg.
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
     * Recupera il valore della proprietà dataemis.
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
     * Imposta il valore della proprietà dataemis.
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
     * Recupera il valore della proprietà dataprovv.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataprovv() {
        return dataprovv;
    }

    /**
     * Imposta il valore della proprietà dataprovv.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataprovv(XMLGregorianCalendar value) {
        this.dataprovv = value;
    }

    /**
     * Recupera il valore della proprietà descImpegno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescImpegno() {
        return descImpegno;
    }

    /**
     * Imposta il valore della proprietà descImpegno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescImpegno(String value) {
        this.descImpegno = value;
    }

    /**
     * Recupera il valore della proprietà descTipoForn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescTipoForn() {
        return descTipoForn;
    }

    /**
     * Imposta il valore della proprietà descTipoForn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescTipoForn(String value) {
        this.descTipoForn = value;
    }

    /**
     * Recupera il valore della proprietà descrCapitolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrCapitolo() {
        return descrCapitolo;
    }

    /**
     * Imposta il valore della proprietà descrCapitolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrCapitolo(String value) {
        this.descrCapitolo = value;
    }

    /**
     * Recupera il valore della proprietà descri.
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
     * Imposta il valore della proprietà descri.
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
     * Recupera il valore della proprietà direzione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirezione() {
        return direzione;
    }

    /**
     * Imposta il valore della proprietà direzione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirezione(String value) {
        this.direzione = value;
    }

    /**
     * Recupera il valore della proprietà direzioneCapitolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirezioneCapitolo() {
        return direzioneCapitolo;
    }

    /**
     * Imposta il valore della proprietà direzioneCapitolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirezioneCapitolo(String value) {
        this.direzioneCapitolo = value;
    }

    /**
     * Recupera il valore della proprietà direzioneDel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirezioneDel() {
        return direzioneDel;
    }

    /**
     * Imposta il valore della proprietà direzioneDel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirezioneDel(String value) {
        this.direzioneDel = value;
    }

    /**
     * Recupera il valore della proprietà dispLiq.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDispLiq() {
        return dispLiq;
    }

    /**
     * Imposta il valore della proprietà dispLiq.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDispLiq(Double value) {
        this.dispLiq = value;
    }

    /**
     * Recupera il valore della proprietà flagNoProv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagNoProv() {
        return flagNoProv;
    }

    /**
     * Imposta il valore della proprietà flagNoProv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagNoProv(String value) {
        this.flagNoProv = value;
    }

    /**
     * Recupera il valore della proprietà impoatt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImpoatt() {
        return impoatt;
    }

    /**
     * Imposta il valore della proprietà impoatt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImpoatt(Double value) {
        this.impoatt = value;
    }

    /**
     * Recupera il valore della proprietà impoini.
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
     * Imposta il valore della proprietà impoini.
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
     * Recupera il valore della proprietà impoorig.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImpoorig() {
        return impoorig;
    }

    /**
     * Imposta il valore della proprietà impoorig.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImpoorig(Double value) {
        this.impoorig = value;
    }

    /**
     * Recupera il valore della proprietà nord.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNord() {
        return nord;
    }

    /**
     * Imposta il valore della proprietà nord.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNord(String value) {
        this.nord = value;
    }

    /**
     * Recupera il valore della proprietà nprov.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNprov() {
        return nprov;
    }

    /**
     * Imposta il valore della proprietà nprov.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNprov(String value) {
        this.nprov = value;
    }

    /**
     * Recupera il valore della proprietà nroArticolo.
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
     * Imposta il valore della proprietà nroArticolo.
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
     * Recupera il valore della proprietà nroCapitolo.
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
     * Imposta il valore della proprietà nroCapitolo.
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
     * Recupera il valore della proprietà nroCapitoloOrig.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNroCapitoloOrig() {
        return nroCapitoloOrig;
    }

    /**
     * Imposta il valore della proprietà nroCapitoloOrig.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNroCapitoloOrig(Integer value) {
        this.nroCapitoloOrig = value;
    }

    /**
     * Recupera il valore della proprietà nroPerente.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNroPerente() {
        return nroPerente;
    }

    /**
     * Imposta il valore della proprietà nroPerente.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNroPerente(Integer value) {
        this.nroPerente = value;
    }

    /**
     * Recupera il valore della proprietà partitaIva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartitaIva() {
        return partitaIva;
    }

    /**
     * Imposta il valore della proprietà partitaIva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartitaIva(String value) {
        this.partitaIva = value;
    }

    /**
     * Recupera il valore della proprietà personaFisica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonaFisica() {
        return personaFisica;
    }

    /**
     * Imposta il valore della proprietà personaFisica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonaFisica(String value) {
        this.personaFisica = value;
    }

    /**
     * Recupera il valore della proprietà plurienn.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPlurienn() {
        return plurienn;
    }

    /**
     * Imposta il valore della proprietà plurienn.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPlurienn(Integer value) {
        this.plurienn = value;
    }

    /**
     * Recupera il valore della proprietà provCap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvCap() {
        return provCap;
    }

    /**
     * Imposta il valore della proprietà provCap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvCap(String value) {
        this.provCap = value;
    }

    /**
     * Recupera il valore della proprietà ragSoc.
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
     * Imposta il valore della proprietà ragSoc.
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
     * Recupera il valore della proprietà staoper.
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
     * Imposta il valore della proprietà staoper.
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
     * Recupera il valore della proprietà stato.
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
     * Imposta il valore della proprietà stato.
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
     * Recupera il valore della proprietà tipoFondo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoFondo() {
        return tipoFondo;
    }

    /**
     * Imposta il valore della proprietà tipoFondo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoFondo(String value) {
        this.tipoFondo = value;
    }

    /**
     * Recupera il valore della proprietà tipoProv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoProv() {
        return tipoProv;
    }

    /**
     * Imposta il valore della proprietà tipoProv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoProv(String value) {
        this.tipoProv = value;
    }

    /**
     * Recupera il valore della proprietà tipoforn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoforn() {
        return tipoforn;
    }

    /**
     * Imposta il valore della proprietà tipoforn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoforn(String value) {
        this.tipoforn = value;
    }

    /**
     * Recupera il valore della proprietà totaleLiq.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotaleLiq() {
        return totaleLiq;
    }

    /**
     * Imposta il valore della proprietà totaleLiq.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotaleLiq(Double value) {
        this.totaleLiq = value;
    }

    /**
     * Recupera il valore della proprietà totalePagato.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalePagato() {
        return totalePagato;
    }

    /**
     * Imposta il valore della proprietà totalePagato.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalePagato(Double value) {
        this.totalePagato = value;
    }

    /**
     * Recupera il valore della proprietà trasfTipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrasfTipo() {
        return trasfTipo;
    }

    /**
     * Imposta il valore della proprietà trasfTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrasfTipo(String value) {
        this.trasfTipo = value;
    }

    /**
     * Recupera il valore della proprietà trasfVoce.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrasfVoce() {
        return trasfVoce;
    }

    /**
     * Imposta il valore della proprietà trasfVoce.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrasfVoce(String value) {
        this.trasfVoce = value;
    }

    /**
     * Recupera il valore della proprietà utente.
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
     * Imposta il valore della proprietà utente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtente(String value) {
        this.utente = value;
    }

}
