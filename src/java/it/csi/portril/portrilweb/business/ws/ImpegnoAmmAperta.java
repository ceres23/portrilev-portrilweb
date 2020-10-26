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
 * <p>Classe Java per impegnoAmmAperta complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="impegnoAmmAperta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoImp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAgg" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataIns" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="descriModIndivBbenef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descriUfficio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flDatiSens" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flsospenspub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funzDirigResp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linkCapitolato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linkContratto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linkCurriculum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linkProgetto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modIndivBenef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oggettoProvvedim" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="settore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uteIns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uteagg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nImp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "impegnoAmmAperta", propOrder = {
    "annoImp",
    "dataAgg",
    "dataIns",
    "descriModIndivBbenef",
    "descriUfficio",
    "direzione",
    "filone",
    "flDatiSens",
    "flsospenspub",
    "funzDirigResp",
    "linkCapitolato",
    "linkContratto",
    "linkCurriculum",
    "linkProgetto",
    "modIndivBenef",
    "note",
    "oggettoProvvedim",
    "settore",
    "uteIns",
    "uteagg",
    "nImp"
})
public class ImpegnoAmmAperta {

    protected String annoImp;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAgg;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataIns;
    protected String descriModIndivBbenef;
    protected String descriUfficio;
    protected String direzione;
    protected String filone;
    protected String flDatiSens;
    protected String flsospenspub;
    protected String funzDirigResp;
    protected String linkCapitolato;
    protected String linkContratto;
    protected String linkCurriculum;
    protected String linkProgetto;
    protected String modIndivBenef;
    protected String note;
    protected String oggettoProvvedim;
    protected String settore;
    protected String uteIns;
    protected String uteagg;
    protected Integer nImp;

    /**
     * Recupera il valore della proprietà annoImp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoImp() {
        return annoImp;
    }

    /**
     * Imposta il valore della proprietà annoImp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoImp(String value) {
        this.annoImp = value;
    }

    /**
     * Recupera il valore della proprietà dataAgg.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataAgg() {
        return dataAgg;
    }

    /**
     * Imposta il valore della proprietà dataAgg.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataAgg(XMLGregorianCalendar value) {
        this.dataAgg = value;
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
     * Recupera il valore della proprietà descriModIndivBbenef.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriModIndivBbenef() {
        return descriModIndivBbenef;
    }

    /**
     * Imposta il valore della proprietà descriModIndivBbenef.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriModIndivBbenef(String value) {
        this.descriModIndivBbenef = value;
    }

    /**
     * Recupera il valore della proprietà descriUfficio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriUfficio() {
        return descriUfficio;
    }

    /**
     * Imposta il valore della proprietà descriUfficio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriUfficio(String value) {
        this.descriUfficio = value;
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
     * Recupera il valore della proprietà filone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilone() {
        return filone;
    }

    /**
     * Imposta il valore della proprietà filone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilone(String value) {
        this.filone = value;
    }

    /**
     * Recupera il valore della proprietà flDatiSens.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlDatiSens() {
        return flDatiSens;
    }

    /**
     * Imposta il valore della proprietà flDatiSens.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlDatiSens(String value) {
        this.flDatiSens = value;
    }

    /**
     * Recupera il valore della proprietà flsospenspub.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlsospenspub() {
        return flsospenspub;
    }

    /**
     * Imposta il valore della proprietà flsospenspub.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlsospenspub(String value) {
        this.flsospenspub = value;
    }

    /**
     * Recupera il valore della proprietà funzDirigResp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunzDirigResp() {
        return funzDirigResp;
    }

    /**
     * Imposta il valore della proprietà funzDirigResp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunzDirigResp(String value) {
        this.funzDirigResp = value;
    }

    /**
     * Recupera il valore della proprietà linkCapitolato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkCapitolato() {
        return linkCapitolato;
    }

    /**
     * Imposta il valore della proprietà linkCapitolato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkCapitolato(String value) {
        this.linkCapitolato = value;
    }

    /**
     * Recupera il valore della proprietà linkContratto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkContratto() {
        return linkContratto;
    }

    /**
     * Imposta il valore della proprietà linkContratto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkContratto(String value) {
        this.linkContratto = value;
    }

    /**
     * Recupera il valore della proprietà linkCurriculum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkCurriculum() {
        return linkCurriculum;
    }

    /**
     * Imposta il valore della proprietà linkCurriculum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkCurriculum(String value) {
        this.linkCurriculum = value;
    }

    /**
     * Recupera il valore della proprietà linkProgetto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkProgetto() {
        return linkProgetto;
    }

    /**
     * Imposta il valore della proprietà linkProgetto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkProgetto(String value) {
        this.linkProgetto = value;
    }

    /**
     * Recupera il valore della proprietà modIndivBenef.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModIndivBenef() {
        return modIndivBenef;
    }

    /**
     * Imposta il valore della proprietà modIndivBenef.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModIndivBenef(String value) {
        this.modIndivBenef = value;
    }

    /**
     * Recupera il valore della proprietà note.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Imposta il valore della proprietà note.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Recupera il valore della proprietà oggettoProvvedim.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOggettoProvvedim() {
        return oggettoProvvedim;
    }

    /**
     * Imposta il valore della proprietà oggettoProvvedim.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOggettoProvvedim(String value) {
        this.oggettoProvvedim = value;
    }

    /**
     * Recupera il valore della proprietà settore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettore() {
        return settore;
    }

    /**
     * Imposta il valore della proprietà settore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettore(String value) {
        this.settore = value;
    }

    /**
     * Recupera il valore della proprietà uteIns.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUteIns() {
        return uteIns;
    }

    /**
     * Imposta il valore della proprietà uteIns.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUteIns(String value) {
        this.uteIns = value;
    }

    /**
     * Recupera il valore della proprietà uteagg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUteagg() {
        return uteagg;
    }

    /**
     * Imposta il valore della proprietà uteagg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUteagg(String value) {
        this.uteagg = value;
    }

    /**
     * Recupera il valore della proprietà nImp.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNImp() {
        return nImp;
    }

    /**
     * Imposta il valore della proprietà nImp.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNImp(Integer value) {
        this.nImp = value;
    }

}
