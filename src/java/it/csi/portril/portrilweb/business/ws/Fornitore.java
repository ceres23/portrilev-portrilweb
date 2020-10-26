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
 * <p>Classe Java per fornitore complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="fornitore">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aliquo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloccoPag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="causaleBlocco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="classben" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codComune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codben" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codfisc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codnatgiu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comuneNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAgg" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataNascita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datlavCap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datlavComune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datlavProv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datlavRagsoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datlavVia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="divisaUsata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flAvviso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flFd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="generico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldCodben" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldUtente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partiva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pref" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ragsoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sesso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tel1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tel2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="via" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fornitore", propOrder = {
    "aliquo",
    "bloccoPag",
    "cap",
    "causaleBlocco",
    "cfe",
    "classben",
    "codComune",
    "codben",
    "codfisc",
    "codnatgiu",
    "comune",
    "comuneNascita",
    "dataAgg",
    "dataNascita",
    "datlavCap",
    "datlavComune",
    "datlavProv",
    "datlavRagsoc",
    "datlavVia",
    "divisaUsata",
    "email",
    "fax",
    "flAvviso",
    "flFd",
    "generico",
    "note",
    "oldCodben",
    "oldUtente",
    "partiva",
    "personaFisica",
    "pref",
    "prov",
    "provNascita",
    "ragsoc",
    "sesso",
    "tel1",
    "tel2",
    "utente",
    "via"
})
public class Fornitore {

    protected Double aliquo;
    protected String bloccoPag;
    protected String cap;
    protected String causaleBlocco;
    protected String cfe;
    protected String classben;
    protected String codComune;
    protected Integer codben;
    protected String codfisc;
    protected String codnatgiu;
    protected String comune;
    protected String comuneNascita;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAgg;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataNascita;
    protected String datlavCap;
    protected String datlavComune;
    protected String datlavProv;
    protected String datlavRagsoc;
    protected String datlavVia;
    protected String divisaUsata;
    protected String email;
    protected String fax;
    protected String flAvviso;
    protected String flFd;
    protected String generico;
    protected String note;
    protected String oldCodben;
    protected String oldUtente;
    protected String partiva;
    protected String personaFisica;
    protected String pref;
    protected String prov;
    protected String provNascita;
    protected String ragsoc;
    protected String sesso;
    protected String tel1;
    protected String tel2;
    protected String utente;
    protected String via;

    /**
     * Recupera il valore della propriet� aliquo.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAliquo() {
        return aliquo;
    }

    /**
     * Imposta il valore della propriet� aliquo.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAliquo(Double value) {
        this.aliquo = value;
    }

    /**
     * Recupera il valore della propriet� bloccoPag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBloccoPag() {
        return bloccoPag;
    }

    /**
     * Imposta il valore della propriet� bloccoPag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBloccoPag(String value) {
        this.bloccoPag = value;
    }

    /**
     * Recupera il valore della propriet� cap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCap() {
        return cap;
    }

    /**
     * Imposta il valore della propriet� cap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCap(String value) {
        this.cap = value;
    }

    /**
     * Recupera il valore della propriet� causaleBlocco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCausaleBlocco() {
        return causaleBlocco;
    }

    /**
     * Imposta il valore della propriet� causaleBlocco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCausaleBlocco(String value) {
        this.causaleBlocco = value;
    }

    /**
     * Recupera il valore della propriet� cfe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfe() {
        return cfe;
    }

    /**
     * Imposta il valore della propriet� cfe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfe(String value) {
        this.cfe = value;
    }

    /**
     * Recupera il valore della propriet� classben.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassben() {
        return classben;
    }

    /**
     * Imposta il valore della propriet� classben.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassben(String value) {
        this.classben = value;
    }

    /**
     * Recupera il valore della propriet� codComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodComune() {
        return codComune;
    }

    /**
     * Imposta il valore della propriet� codComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodComune(String value) {
        this.codComune = value;
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
     * Recupera il valore della propriet� codfisc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodfisc() {
        return codfisc;
    }

    /**
     * Imposta il valore della propriet� codfisc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodfisc(String value) {
        this.codfisc = value;
    }

    /**
     * Recupera il valore della propriet� codnatgiu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodnatgiu() {
        return codnatgiu;
    }

    /**
     * Imposta il valore della propriet� codnatgiu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodnatgiu(String value) {
        this.codnatgiu = value;
    }

    /**
     * Recupera il valore della propriet� comune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComune() {
        return comune;
    }

    /**
     * Imposta il valore della propriet� comune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComune(String value) {
        this.comune = value;
    }

    /**
     * Recupera il valore della propriet� comuneNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComuneNascita() {
        return comuneNascita;
    }

    /**
     * Imposta il valore della propriet� comuneNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComuneNascita(String value) {
        this.comuneNascita = value;
    }

    /**
     * Recupera il valore della propriet� dataAgg.
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
     * Imposta il valore della propriet� dataAgg.
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
     * Recupera il valore della propriet� dataNascita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataNascita() {
        return dataNascita;
    }

    /**
     * Imposta il valore della propriet� dataNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataNascita(XMLGregorianCalendar value) {
        this.dataNascita = value;
    }

    /**
     * Recupera il valore della propriet� datlavCap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatlavCap() {
        return datlavCap;
    }

    /**
     * Imposta il valore della propriet� datlavCap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatlavCap(String value) {
        this.datlavCap = value;
    }

    /**
     * Recupera il valore della propriet� datlavComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatlavComune() {
        return datlavComune;
    }

    /**
     * Imposta il valore della propriet� datlavComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatlavComune(String value) {
        this.datlavComune = value;
    }

    /**
     * Recupera il valore della propriet� datlavProv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatlavProv() {
        return datlavProv;
    }

    /**
     * Imposta il valore della propriet� datlavProv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatlavProv(String value) {
        this.datlavProv = value;
    }

    /**
     * Recupera il valore della propriet� datlavRagsoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatlavRagsoc() {
        return datlavRagsoc;
    }

    /**
     * Imposta il valore della propriet� datlavRagsoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatlavRagsoc(String value) {
        this.datlavRagsoc = value;
    }

    /**
     * Recupera il valore della propriet� datlavVia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatlavVia() {
        return datlavVia;
    }

    /**
     * Imposta il valore della propriet� datlavVia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatlavVia(String value) {
        this.datlavVia = value;
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
     * Recupera il valore della propriet� email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta il valore della propriet� email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Recupera il valore della propriet� fax.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Imposta il valore della propriet� fax.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Recupera il valore della propriet� flAvviso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlAvviso() {
        return flAvviso;
    }

    /**
     * Imposta il valore della propriet� flAvviso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlAvviso(String value) {
        this.flAvviso = value;
    }

    /**
     * Recupera il valore della propriet� flFd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlFd() {
        return flFd;
    }

    /**
     * Imposta il valore della propriet� flFd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlFd(String value) {
        this.flFd = value;
    }

    /**
     * Recupera il valore della propriet� generico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenerico() {
        return generico;
    }

    /**
     * Imposta il valore della propriet� generico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenerico(String value) {
        this.generico = value;
    }

    /**
     * Recupera il valore della propriet� note.
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
     * Imposta il valore della propriet� note.
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
     * Recupera il valore della propriet� oldCodben.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldCodben() {
        return oldCodben;
    }

    /**
     * Imposta il valore della propriet� oldCodben.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldCodben(String value) {
        this.oldCodben = value;
    }

    /**
     * Recupera il valore della propriet� oldUtente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldUtente() {
        return oldUtente;
    }

    /**
     * Imposta il valore della propriet� oldUtente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldUtente(String value) {
        this.oldUtente = value;
    }

    /**
     * Recupera il valore della propriet� partiva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartiva() {
        return partiva;
    }

    /**
     * Imposta il valore della propriet� partiva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartiva(String value) {
        this.partiva = value;
    }

    /**
     * Recupera il valore della propriet� personaFisica.
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
     * Imposta il valore della propriet� personaFisica.
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
     * Recupera il valore della propriet� pref.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPref() {
        return pref;
    }

    /**
     * Imposta il valore della propriet� pref.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPref(String value) {
        this.pref = value;
    }

    /**
     * Recupera il valore della propriet� prov.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProv() {
        return prov;
    }

    /**
     * Imposta il valore della propriet� prov.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProv(String value) {
        this.prov = value;
    }

    /**
     * Recupera il valore della propriet� provNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvNascita() {
        return provNascita;
    }

    /**
     * Imposta il valore della propriet� provNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvNascita(String value) {
        this.provNascita = value;
    }

    /**
     * Recupera il valore della propriet� ragsoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRagsoc() {
        return ragsoc;
    }

    /**
     * Imposta il valore della propriet� ragsoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRagsoc(String value) {
        this.ragsoc = value;
    }

    /**
     * Recupera il valore della propriet� sesso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSesso() {
        return sesso;
    }

    /**
     * Imposta il valore della propriet� sesso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSesso(String value) {
        this.sesso = value;
    }

    /**
     * Recupera il valore della propriet� tel1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTel1() {
        return tel1;
    }

    /**
     * Imposta il valore della propriet� tel1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTel1(String value) {
        this.tel1 = value;
    }

    /**
     * Recupera il valore della propriet� tel2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTel2() {
        return tel2;
    }

    /**
     * Imposta il valore della propriet� tel2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTel2(String value) {
        this.tel2 = value;
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
     * Recupera il valore della propriet� via.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVia() {
        return via;
    }

    /**
     * Imposta il valore della propriet� via.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVia(String value) {
        this.via = value;
    }

}
