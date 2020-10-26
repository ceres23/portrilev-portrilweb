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
 * <p>Classe Java per ritenutaAtto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ritenutaAtto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aliqIrpef" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="codAltraCassa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datoInps" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="inpsAl" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="inpsAltraCassa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inpsDal" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="irpNonSoggette" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="rischioInail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoRitenuta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoSoggetto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ritenutaAtto", propOrder = {
    "aliqIrpef",
    "codAltraCassa",
    "codAttivita",
    "datoInps",
    "inpsAl",
    "inpsAltraCassa",
    "inpsDal",
    "irpNonSoggette",
    "rischioInail",
    "tipoRitenuta",
    "tipoSoggetto"
})
public class RitenutaAtto {

    protected Double aliqIrpef;
    protected String codAltraCassa;
    protected String codAttivita;
    protected Integer datoInps;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar inpsAl;
    protected String inpsAltraCassa;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar inpsDal;
    protected Double irpNonSoggette;
    protected String rischioInail;
    protected String tipoRitenuta;
    protected String tipoSoggetto;

    /**
     * Recupera il valore della proprietà aliqIrpef.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAliqIrpef() {
        return aliqIrpef;
    }

    /**
     * Imposta il valore della proprietà aliqIrpef.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAliqIrpef(Double value) {
        this.aliqIrpef = value;
    }

    /**
     * Recupera il valore della proprietà codAltraCassa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAltraCassa() {
        return codAltraCassa;
    }

    /**
     * Imposta il valore della proprietà codAltraCassa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAltraCassa(String value) {
        this.codAltraCassa = value;
    }

    /**
     * Recupera il valore della proprietà codAttivita.
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
     * Imposta il valore della proprietà codAttivita.
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
     * Recupera il valore della proprietà datoInps.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDatoInps() {
        return datoInps;
    }

    /**
     * Imposta il valore della proprietà datoInps.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDatoInps(Integer value) {
        this.datoInps = value;
    }

    /**
     * Recupera il valore della proprietà inpsAl.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInpsAl() {
        return inpsAl;
    }

    /**
     * Imposta il valore della proprietà inpsAl.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInpsAl(XMLGregorianCalendar value) {
        this.inpsAl = value;
    }

    /**
     * Recupera il valore della proprietà inpsAltraCassa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInpsAltraCassa() {
        return inpsAltraCassa;
    }

    /**
     * Imposta il valore della proprietà inpsAltraCassa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInpsAltraCassa(String value) {
        this.inpsAltraCassa = value;
    }

    /**
     * Recupera il valore della proprietà inpsDal.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInpsDal() {
        return inpsDal;
    }

    /**
     * Imposta il valore della proprietà inpsDal.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInpsDal(XMLGregorianCalendar value) {
        this.inpsDal = value;
    }

    /**
     * Recupera il valore della proprietà irpNonSoggette.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIrpNonSoggette() {
        return irpNonSoggette;
    }

    /**
     * Imposta il valore della proprietà irpNonSoggette.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIrpNonSoggette(Double value) {
        this.irpNonSoggette = value;
    }

    /**
     * Recupera il valore della proprietà rischioInail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRischioInail() {
        return rischioInail;
    }

    /**
     * Imposta il valore della proprietà rischioInail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRischioInail(String value) {
        this.rischioInail = value;
    }

    /**
     * Recupera il valore della proprietà tipoRitenuta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRitenuta() {
        return tipoRitenuta;
    }

    /**
     * Imposta il valore della proprietà tipoRitenuta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRitenuta(String value) {
        this.tipoRitenuta = value;
    }

    /**
     * Recupera il valore della proprietà tipoSoggetto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSoggetto() {
        return tipoSoggetto;
    }

    /**
     * Imposta il valore della proprietà tipoSoggetto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSoggetto(String value) {
        this.tipoSoggetto = value;
    }

}
