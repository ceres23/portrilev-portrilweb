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
 * <p>Classe Java per dettaglioConsultazioneAtto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="dettaglioConsultazioneAtto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoBilRif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoEser" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="annoImp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoProvv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cigLiq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cigMand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cupLiq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cupMand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAgg" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataQuiet" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="direzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flagPign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="importoMandLordo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="importoMandNetto" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="importoQuiet" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="importoRitenute" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="NLiq" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NLiqPrec" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroArticolo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroCapitolo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroImp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroMand" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroProv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subImpegno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoFondo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoProv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trasfTipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trasfVoce" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dettaglioConsultazioneAtto", propOrder = {
    "annoBilRif",
    "annoEser",
    "annoImp",
    "annoProvv",
    "cigLiq",
    "cigMand",
    "cupLiq",
    "cupMand",
    "dataAgg",
    "dataQuiet",
    "direzione",
    "flagPign",
    "importo",
    "importoMandLordo",
    "importoMandNetto",
    "importoQuiet",
    "importoRitenute",
    "nLiq",
    "nLiqPrec",
    "nroArticolo",
    "nroCapitolo",
    "nroImp",
    "nroMand",
    "nroProv",
    "subImpegno",
    "tipoFondo",
    "tipoProv",
    "trasfTipo",
    "trasfVoce"
})
public class DettaglioConsultazioneAtto {

    protected String annoBilRif;
    protected Integer annoEser;
    protected String annoImp;
    protected String annoProvv;
    protected String cigLiq;
    protected String cigMand;
    protected String cupLiq;
    protected String cupMand;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAgg;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataQuiet;
    protected String direzione;
    protected String flagPign;
    protected Double importo;
    protected Double importoMandLordo;
    protected Double importoMandNetto;
    protected Double importoQuiet;
    protected Double importoRitenute;
    @XmlElement(name = "NLiq")
    protected Integer nLiq;
    @XmlElement(name = "NLiqPrec")
    protected Integer nLiqPrec;
    protected Integer nroArticolo;
    protected Integer nroCapitolo;
    protected Integer nroImp;
    protected Integer nroMand;
    protected String nroProv;
    protected String subImpegno;
    protected String tipoFondo;
    protected String tipoProv;
    protected String trasfTipo;
    protected String trasfVoce;

    /**
     * Recupera il valore della proprietÓ annoBilRif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoBilRif() {
        return annoBilRif;
    }

    /**
     * Imposta il valore della proprietÓ annoBilRif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoBilRif(String value) {
        this.annoBilRif = value;
    }

    /**
     * Recupera il valore della proprietÓ annoEser.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAnnoEser() {
        return annoEser;
    }

    /**
     * Imposta il valore della proprietÓ annoEser.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAnnoEser(Integer value) {
        this.annoEser = value;
    }

    /**
     * Recupera il valore della proprietÓ annoImp.
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
     * Imposta il valore della proprietÓ annoImp.
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
     * Recupera il valore della proprietÓ annoProvv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoProvv() {
        return annoProvv;
    }

    /**
     * Imposta il valore della proprietÓ annoProvv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoProvv(String value) {
        this.annoProvv = value;
    }

    /**
     * Recupera il valore della proprietÓ cigLiq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCigLiq() {
        return cigLiq;
    }

    /**
     * Imposta il valore della proprietÓ cigLiq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCigLiq(String value) {
        this.cigLiq = value;
    }

    /**
     * Recupera il valore della proprietÓ cigMand.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCigMand() {
        return cigMand;
    }

    /**
     * Imposta il valore della proprietÓ cigMand.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCigMand(String value) {
        this.cigMand = value;
    }

    /**
     * Recupera il valore della proprietÓ cupLiq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCupLiq() {
        return cupLiq;
    }

    /**
     * Imposta il valore della proprietÓ cupLiq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCupLiq(String value) {
        this.cupLiq = value;
    }

    /**
     * Recupera il valore della proprietÓ cupMand.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCupMand() {
        return cupMand;
    }

    /**
     * Imposta il valore della proprietÓ cupMand.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCupMand(String value) {
        this.cupMand = value;
    }

    /**
     * Recupera il valore della proprietÓ dataAgg.
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
     * Imposta il valore della proprietÓ dataAgg.
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
     * Recupera il valore della proprietÓ dataQuiet.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataQuiet() {
        return dataQuiet;
    }

    /**
     * Imposta il valore della proprietÓ dataQuiet.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataQuiet(XMLGregorianCalendar value) {
        this.dataQuiet = value;
    }

    /**
     * Recupera il valore della proprietÓ direzione.
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
     * Imposta il valore della proprietÓ direzione.
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
     * Recupera il valore della proprietÓ flagPign.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagPign() {
        return flagPign;
    }

    /**
     * Imposta il valore della proprietÓ flagPign.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagPign(String value) {
        this.flagPign = value;
    }

    /**
     * Recupera il valore della proprietÓ importo.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImporto() {
        return importo;
    }

    /**
     * Imposta il valore della proprietÓ importo.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImporto(Double value) {
        this.importo = value;
    }

    /**
     * Recupera il valore della proprietÓ importoMandLordo.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImportoMandLordo() {
        return importoMandLordo;
    }

    /**
     * Imposta il valore della proprietÓ importoMandLordo.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImportoMandLordo(Double value) {
        this.importoMandLordo = value;
    }

    /**
     * Recupera il valore della proprietÓ importoMandNetto.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImportoMandNetto() {
        return importoMandNetto;
    }

    /**
     * Imposta il valore della proprietÓ importoMandNetto.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImportoMandNetto(Double value) {
        this.importoMandNetto = value;
    }

    /**
     * Recupera il valore della proprietÓ importoQuiet.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImportoQuiet() {
        return importoQuiet;
    }

    /**
     * Imposta il valore della proprietÓ importoQuiet.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImportoQuiet(Double value) {
        this.importoQuiet = value;
    }

    /**
     * Recupera il valore della proprietÓ importoRitenute.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImportoRitenute() {
        return importoRitenute;
    }

    /**
     * Imposta il valore della proprietÓ importoRitenute.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImportoRitenute(Double value) {
        this.importoRitenute = value;
    }

    /**
     * Recupera il valore della proprietÓ nLiq.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNLiq() {
        return nLiq;
    }

    /**
     * Imposta il valore della proprietÓ nLiq.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNLiq(Integer value) {
        this.nLiq = value;
    }

    /**
     * Recupera il valore della proprietÓ nLiqPrec.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNLiqPrec() {
        return nLiqPrec;
    }

    /**
     * Imposta il valore della proprietÓ nLiqPrec.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNLiqPrec(Integer value) {
        this.nLiqPrec = value;
    }

    /**
     * Recupera il valore della proprietÓ nroArticolo.
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
     * Imposta il valore della proprietÓ nroArticolo.
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
     * Recupera il valore della proprietÓ nroCapitolo.
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
     * Imposta il valore della proprietÓ nroCapitolo.
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
     * Recupera il valore della proprietÓ nroImp.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNroImp() {
        return nroImp;
    }

    /**
     * Imposta il valore della proprietÓ nroImp.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNroImp(Integer value) {
        this.nroImp = value;
    }

    /**
     * Recupera il valore della proprietÓ nroMand.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNroMand() {
        return nroMand;
    }

    /**
     * Imposta il valore della proprietÓ nroMand.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNroMand(Integer value) {
        this.nroMand = value;
    }

    /**
     * Recupera il valore della proprietÓ nroProv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroProv() {
        return nroProv;
    }

    /**
     * Imposta il valore della proprietÓ nroProv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroProv(String value) {
        this.nroProv = value;
    }

    /**
     * Recupera il valore della proprietÓ subImpegno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubImpegno() {
        return subImpegno;
    }

    /**
     * Imposta il valore della proprietÓ subImpegno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubImpegno(String value) {
        this.subImpegno = value;
    }

    /**
     * Recupera il valore della proprietÓ tipoFondo.
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
     * Imposta il valore della proprietÓ tipoFondo.
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
     * Recupera il valore della proprietÓ tipoProv.
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
     * Imposta il valore della proprietÓ tipoProv.
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
     * Recupera il valore della proprietÓ trasfTipo.
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
     * Imposta il valore della proprietÓ trasfTipo.
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
     * Recupera il valore della proprietÓ trasfVoce.
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
     * Imposta il valore della proprietÓ trasfVoce.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrasfVoce(String value) {
        this.trasfVoce = value;
    }

}
