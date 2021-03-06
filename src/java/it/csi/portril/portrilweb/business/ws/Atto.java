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
 * <p>Classe Java per atto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="atto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allAltro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoEsercizioAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoTitolario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chiaveUtente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTitolario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAggAtto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataAnnullAtto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataComplAtto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataEmisAtto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataRicAtto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataRichMod" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataRifiuto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataScadenza" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datavaluta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="descAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dirAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distinta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="divisaUsata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fatture" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flAltro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flDatiSens" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flDichiaraz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flDocGiustif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flEstrCopiaProv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flFatture" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importoAtto" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ncarta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nomeDir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomeLiq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notaRifiuto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nroAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nroElencoAtto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroTelLiq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numPratica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ritenuta" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}ritenutaAtto" minOccurs="0"/>
 *         &lt;element name="settoreAtto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stato" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="testoRichMod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoPagamAutom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "atto", propOrder = {
    "allAltro",
    "annoAtto",
    "annoEsercizioAtto",
    "annoTitolario",
    "chiaveUtente",
    "codTitolario",
    "dataAggAtto",
    "dataAnnullAtto",
    "dataComplAtto",
    "dataEmisAtto",
    "dataRicAtto",
    "dataRichMod",
    "dataRifiuto",
    "dataScadenza",
    "datavaluta",
    "descAttivita",
    "descri",
    "dirAtto",
    "distinta",
    "divisaUsata",
    "fatture",
    "flAltro",
    "flDatiSens",
    "flDichiaraz",
    "flDocGiustif",
    "flEstrCopiaProv",
    "flFatture",
    "importoAtto",
    "ncarta",
    "nomeDir",
    "nomeLiq",
    "notaRifiuto",
    "note",
    "nroAtto",
    "nroElencoAtto",
    "nroTelLiq",
    "numPratica",
    "ritenuta",
    "settoreAtto",
    "stato",
    "testoRichMod",
    "tipoPagamAutom",
    "utente"
})
public class Atto {

    protected String allAltro;
    protected String annoAtto;
    protected String annoEsercizioAtto;
    protected String annoTitolario;
    protected String chiaveUtente;
    protected String codTitolario;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAggAtto;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAnnullAtto;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataComplAtto;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataEmisAtto;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataRicAtto;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataRichMod;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataRifiuto;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataScadenza;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datavaluta;
    protected String descAttivita;
    protected String descri;
    protected String dirAtto;
    protected String distinta;
    protected String divisaUsata;
    protected String fatture;
    protected String flAltro;
    protected String flDatiSens;
    protected String flDichiaraz;
    protected String flDocGiustif;
    protected String flEstrCopiaProv;
    protected String flFatture;
    protected Double importoAtto;
    protected Integer ncarta;
    protected String nomeDir;
    protected String nomeLiq;
    protected String notaRifiuto;
    protected String note;
    protected String nroAtto;
    protected Integer nroElencoAtto;
    protected String nroTelLiq;
    protected String numPratica;
    protected RitenutaAtto ritenuta;
    protected String settoreAtto;
    protected Integer stato;
    protected String testoRichMod;
    protected String tipoPagamAutom;
    protected String utente;

    /**
     * Recupera il valore della proprietÓ allAltro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllAltro() {
        return allAltro;
    }

    /**
     * Imposta il valore della proprietÓ allAltro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllAltro(String value) {
        this.allAltro = value;
    }

    /**
     * Recupera il valore della proprietÓ annoAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoAtto() {
        return annoAtto;
    }

    /**
     * Imposta il valore della proprietÓ annoAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoAtto(String value) {
        this.annoAtto = value;
    }

    /**
     * Recupera il valore della proprietÓ annoEsercizioAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoEsercizioAtto() {
        return annoEsercizioAtto;
    }

    /**
     * Imposta il valore della proprietÓ annoEsercizioAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoEsercizioAtto(String value) {
        this.annoEsercizioAtto = value;
    }

    /**
     * Recupera il valore della proprietÓ annoTitolario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoTitolario() {
        return annoTitolario;
    }

    /**
     * Imposta il valore della proprietÓ annoTitolario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoTitolario(String value) {
        this.annoTitolario = value;
    }

    /**
     * Recupera il valore della proprietÓ chiaveUtente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChiaveUtente() {
        return chiaveUtente;
    }

    /**
     * Imposta il valore della proprietÓ chiaveUtente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChiaveUtente(String value) {
        this.chiaveUtente = value;
    }

    /**
     * Recupera il valore della proprietÓ codTitolario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTitolario() {
        return codTitolario;
    }

    /**
     * Imposta il valore della proprietÓ codTitolario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTitolario(String value) {
        this.codTitolario = value;
    }

    /**
     * Recupera il valore della proprietÓ dataAggAtto.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataAggAtto() {
        return dataAggAtto;
    }

    /**
     * Imposta il valore della proprietÓ dataAggAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataAggAtto(XMLGregorianCalendar value) {
        this.dataAggAtto = value;
    }

    /**
     * Recupera il valore della proprietÓ dataAnnullAtto.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataAnnullAtto() {
        return dataAnnullAtto;
    }

    /**
     * Imposta il valore della proprietÓ dataAnnullAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataAnnullAtto(XMLGregorianCalendar value) {
        this.dataAnnullAtto = value;
    }

    /**
     * Recupera il valore della proprietÓ dataComplAtto.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataComplAtto() {
        return dataComplAtto;
    }

    /**
     * Imposta il valore della proprietÓ dataComplAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataComplAtto(XMLGregorianCalendar value) {
        this.dataComplAtto = value;
    }

    /**
     * Recupera il valore della proprietÓ dataEmisAtto.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataEmisAtto() {
        return dataEmisAtto;
    }

    /**
     * Imposta il valore della proprietÓ dataEmisAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataEmisAtto(XMLGregorianCalendar value) {
        this.dataEmisAtto = value;
    }

    /**
     * Recupera il valore della proprietÓ dataRicAtto.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataRicAtto() {
        return dataRicAtto;
    }

    /**
     * Imposta il valore della proprietÓ dataRicAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataRicAtto(XMLGregorianCalendar value) {
        this.dataRicAtto = value;
    }

    /**
     * Recupera il valore della proprietÓ dataRichMod.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataRichMod() {
        return dataRichMod;
    }

    /**
     * Imposta il valore della proprietÓ dataRichMod.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataRichMod(XMLGregorianCalendar value) {
        this.dataRichMod = value;
    }

    /**
     * Recupera il valore della proprietÓ dataRifiuto.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataRifiuto() {
        return dataRifiuto;
    }

    /**
     * Imposta il valore della proprietÓ dataRifiuto.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataRifiuto(XMLGregorianCalendar value) {
        this.dataRifiuto = value;
    }

    /**
     * Recupera il valore della proprietÓ dataScadenza.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataScadenza() {
        return dataScadenza;
    }

    /**
     * Imposta il valore della proprietÓ dataScadenza.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataScadenza(XMLGregorianCalendar value) {
        this.dataScadenza = value;
    }

    /**
     * Recupera il valore della proprietÓ datavaluta.
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
     * Imposta il valore della proprietÓ datavaluta.
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
     * Recupera il valore della proprietÓ descAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescAttivita() {
        return descAttivita;
    }

    /**
     * Imposta il valore della proprietÓ descAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescAttivita(String value) {
        this.descAttivita = value;
    }

    /**
     * Recupera il valore della proprietÓ descri.
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
     * Imposta il valore della proprietÓ descri.
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
     * Recupera il valore della proprietÓ dirAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirAtto() {
        return dirAtto;
    }

    /**
     * Imposta il valore della proprietÓ dirAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirAtto(String value) {
        this.dirAtto = value;
    }

    /**
     * Recupera il valore della proprietÓ distinta.
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
     * Imposta il valore della proprietÓ distinta.
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
     * Recupera il valore della proprietÓ divisaUsata.
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
     * Imposta il valore della proprietÓ divisaUsata.
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
     * Recupera il valore della proprietÓ fatture.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatture() {
        return fatture;
    }

    /**
     * Imposta il valore della proprietÓ fatture.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatture(String value) {
        this.fatture = value;
    }

    /**
     * Recupera il valore della proprietÓ flAltro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlAltro() {
        return flAltro;
    }

    /**
     * Imposta il valore della proprietÓ flAltro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlAltro(String value) {
        this.flAltro = value;
    }

    /**
     * Recupera il valore della proprietÓ flDatiSens.
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
     * Imposta il valore della proprietÓ flDatiSens.
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
     * Recupera il valore della proprietÓ flDichiaraz.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlDichiaraz() {
        return flDichiaraz;
    }

    /**
     * Imposta il valore della proprietÓ flDichiaraz.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlDichiaraz(String value) {
        this.flDichiaraz = value;
    }

    /**
     * Recupera il valore della proprietÓ flDocGiustif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlDocGiustif() {
        return flDocGiustif;
    }

    /**
     * Imposta il valore della proprietÓ flDocGiustif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlDocGiustif(String value) {
        this.flDocGiustif = value;
    }

    /**
     * Recupera il valore della proprietÓ flEstrCopiaProv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlEstrCopiaProv() {
        return flEstrCopiaProv;
    }

    /**
     * Imposta il valore della proprietÓ flEstrCopiaProv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlEstrCopiaProv(String value) {
        this.flEstrCopiaProv = value;
    }

    /**
     * Recupera il valore della proprietÓ flFatture.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlFatture() {
        return flFatture;
    }

    /**
     * Imposta il valore della proprietÓ flFatture.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlFatture(String value) {
        this.flFatture = value;
    }

    /**
     * Recupera il valore della proprietÓ importoAtto.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImportoAtto() {
        return importoAtto;
    }

    /**
     * Imposta il valore della proprietÓ importoAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImportoAtto(Double value) {
        this.importoAtto = value;
    }

    /**
     * Recupera il valore della proprietÓ ncarta.
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
     * Imposta il valore della proprietÓ ncarta.
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
     * Recupera il valore della proprietÓ nomeDir.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeDir() {
        return nomeDir;
    }

    /**
     * Imposta il valore della proprietÓ nomeDir.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeDir(String value) {
        this.nomeDir = value;
    }

    /**
     * Recupera il valore della proprietÓ nomeLiq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeLiq() {
        return nomeLiq;
    }

    /**
     * Imposta il valore della proprietÓ nomeLiq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeLiq(String value) {
        this.nomeLiq = value;
    }

    /**
     * Recupera il valore della proprietÓ notaRifiuto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotaRifiuto() {
        return notaRifiuto;
    }

    /**
     * Imposta il valore della proprietÓ notaRifiuto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotaRifiuto(String value) {
        this.notaRifiuto = value;
    }

    /**
     * Recupera il valore della proprietÓ note.
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
     * Imposta il valore della proprietÓ note.
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
     * Recupera il valore della proprietÓ nroAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroAtto() {
        return nroAtto;
    }

    /**
     * Imposta il valore della proprietÓ nroAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroAtto(String value) {
        this.nroAtto = value;
    }

    /**
     * Recupera il valore della proprietÓ nroElencoAtto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNroElencoAtto() {
        return nroElencoAtto;
    }

    /**
     * Imposta il valore della proprietÓ nroElencoAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNroElencoAtto(Integer value) {
        this.nroElencoAtto = value;
    }

    /**
     * Recupera il valore della proprietÓ nroTelLiq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroTelLiq() {
        return nroTelLiq;
    }

    /**
     * Imposta il valore della proprietÓ nroTelLiq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroTelLiq(String value) {
        this.nroTelLiq = value;
    }

    /**
     * Recupera il valore della proprietÓ numPratica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumPratica() {
        return numPratica;
    }

    /**
     * Imposta il valore della proprietÓ numPratica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumPratica(String value) {
        this.numPratica = value;
    }

    /**
     * Recupera il valore della proprietÓ ritenuta.
     * 
     * @return
     *     possible object is
     *     {@link RitenutaAtto }
     *     
     */
    public RitenutaAtto getRitenuta() {
        return ritenuta;
    }

    /**
     * Imposta il valore della proprietÓ ritenuta.
     * 
     * @param value
     *     allowed object is
     *     {@link RitenutaAtto }
     *     
     */
    public void setRitenuta(RitenutaAtto value) {
        this.ritenuta = value;
    }

    /**
     * Recupera il valore della proprietÓ settoreAtto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettoreAtto() {
        return settoreAtto;
    }

    /**
     * Imposta il valore della proprietÓ settoreAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettoreAtto(String value) {
        this.settoreAtto = value;
    }

    /**
     * Recupera il valore della proprietÓ stato.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStato() {
        return stato;
    }

    /**
     * Imposta il valore della proprietÓ stato.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStato(Integer value) {
        this.stato = value;
    }

    /**
     * Recupera il valore della proprietÓ testoRichMod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestoRichMod() {
        return testoRichMod;
    }

    /**
     * Imposta il valore della proprietÓ testoRichMod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestoRichMod(String value) {
        this.testoRichMod = value;
    }

    /**
     * Recupera il valore della proprietÓ tipoPagamAutom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPagamAutom() {
        return tipoPagamAutom;
    }

    /**
     * Imposta il valore della proprietÓ tipoPagamAutom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPagamAutom(String value) {
        this.tipoPagamAutom = value;
    }

    /**
     * Recupera il valore della proprietÓ utente.
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
     * Imposta il valore della proprietÓ utente.
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
