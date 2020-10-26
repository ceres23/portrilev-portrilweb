/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per liquidazione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="liquidazione">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoEsercizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annobilRif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoimp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoprov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cig" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codGest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codIntervClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codben" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codprov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataagg" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="descri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flagFatt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="nimp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nliq" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nliqPrec" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nprov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nroArticolo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroCapitolo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nsubimp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="progben" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="staoper" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="voceSpesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "liquidazione", propOrder = {
    "annoEsercizio",
    "annobilRif",
    "annoimp",
    "annoprov",
    "cig",
    "codGest",
    "codIntervClass",
    "codben",
    "codprov",
    "cup",
    "dataagg",
    "descri",
    "direzione",
    "flagFatt",
    "importo",
    "nimp",
    "nliq",
    "nliqPrec",
    "nprov",
    "nroArticolo",
    "nroCapitolo",
    "nsubimp",
    "progben",
    "staoper",
    "utente",
    "voceSpesa"
})
public class Liquidazione {

    protected String annoEsercizio;
    protected String annobilRif;
    protected String annoimp;
    protected String annoprov;
    protected String cig;
    protected String codGest;
    protected String codIntervClass;
    protected Integer codben;
    protected String codprov;
    protected String cup;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataagg;
    protected String descri;
    protected String direzione;
    protected String flagFatt;
    protected BigDecimal importo;
    protected Integer nimp;
    protected Integer nliq;
    protected Integer nliqPrec;
    protected String nprov;
    protected Integer nroArticolo;
    protected Integer nroCapitolo;
    protected Integer nsubimp;
    protected Integer progben;
    protected String staoper;
    protected String utente;
    protected String voceSpesa;

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
     * Recupera il valore della propriet� annobilRif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnobilRif() {
        return annobilRif;
    }

    /**
     * Imposta il valore della propriet� annobilRif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnobilRif(String value) {
        this.annobilRif = value;
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
     * Recupera il valore della propriet� annoprov.
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
     * Imposta il valore della propriet� annoprov.
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
     * Recupera il valore della propriet� codGest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodGest() {
        return codGest;
    }

    /**
     * Imposta il valore della propriet� codGest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodGest(String value) {
        this.codGest = value;
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
     * Recupera il valore della propriet� codprov.
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
     * Imposta il valore della propriet� codprov.
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
     * Recupera il valore della propriet� direzione.
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
     * Imposta il valore della propriet� direzione.
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
     * Recupera il valore della propriet� flagFatt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagFatt() {
        return flagFatt;
    }

    /**
     * Imposta il valore della propriet� flagFatt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagFatt(String value) {
        this.flagFatt = value;
    }

    /**
     * Recupera il valore della propriet� importo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImporto() {
        return importo;
    }

    /**
     * Imposta il valore della propriet� importo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImporto(BigDecimal value) {
        this.importo = value;
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
     * Recupera il valore della propriet� nliqPrec.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNliqPrec() {
        return nliqPrec;
    }

    /**
     * Imposta il valore della propriet� nliqPrec.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNliqPrec(Integer value) {
        this.nliqPrec = value;
    }

    /**
     * Recupera il valore della propriet� nprov.
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
     * Imposta il valore della propriet� nprov.
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

}
