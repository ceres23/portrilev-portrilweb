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
 * <p>Classe Java per delibera complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="delibera">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="data_bu" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_estrazione" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_odg" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_proposta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="data_visto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="esito_giunta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identificativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nro_def" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nro_provv" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="num_legisl" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="num_odg" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numero_bu" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="oggetto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segreteria_giunta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo_esecutivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trasmissione_assessorati" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "delibera", propOrder = {
    "anno",
    "dataBu",
    "dataEstrazione",
    "dataOdg",
    "dataProposta",
    "dataVisto",
    "esitoGiunta",
    "identificativo",
    "nroDef",
    "nroProvv",
    "numLegisl",
    "numOdg",
    "numeroBu",
    "oggetto",
    "segreteriaGiunta",
    "tipoEsecutivita",
    "trasmissioneAssessorati"
})
public class Delibera {

    protected String anno;
    @XmlElement(name = "data_bu")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataBu;
    @XmlElement(name = "data_estrazione")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataEstrazione;
    @XmlElement(name = "data_odg")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataOdg;
    @XmlElement(name = "data_proposta")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataProposta;
    @XmlElement(name = "data_visto")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataVisto;
    @XmlElement(name = "esito_giunta")
    protected String esitoGiunta;
    protected String identificativo;
    @XmlElement(name = "nro_def")
    protected Integer nroDef;
    @XmlElement(name = "nro_provv")
    protected Integer nroProvv;
    @XmlElement(name = "num_legisl")
    protected Integer numLegisl;
    @XmlElement(name = "num_odg")
    protected Integer numOdg;
    @XmlElement(name = "numero_bu")
    protected Integer numeroBu;
    protected String oggetto;
    @XmlElement(name = "segreteria_giunta")
    protected String segreteriaGiunta;
    @XmlElement(name = "tipo_esecutivita")
    protected String tipoEsecutivita;
    @XmlElement(name = "trasmissione_assessorati")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar trasmissioneAssessorati;

    /**
     * Recupera il valore della proprietà anno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnno() {
        return anno;
    }

    /**
     * Imposta il valore della proprietà anno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnno(String value) {
        this.anno = value;
    }

    /**
     * Recupera il valore della proprietà dataBu.
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
     * Imposta il valore della proprietà dataBu.
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
     * Recupera il valore della proprietà dataEstrazione.
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
     * Imposta il valore della proprietà dataEstrazione.
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
     * Recupera il valore della proprietà dataOdg.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataOdg() {
        return dataOdg;
    }

    /**
     * Imposta il valore della proprietà dataOdg.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataOdg(XMLGregorianCalendar value) {
        this.dataOdg = value;
    }

    /**
     * Recupera il valore della proprietà dataProposta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataProposta() {
        return dataProposta;
    }

    /**
     * Imposta il valore della proprietà dataProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataProposta(XMLGregorianCalendar value) {
        this.dataProposta = value;
    }

    /**
     * Recupera il valore della proprietà dataVisto.
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
     * Imposta il valore della proprietà dataVisto.
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
     * Recupera il valore della proprietà esitoGiunta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitoGiunta() {
        return esitoGiunta;
    }

    /**
     * Imposta il valore della proprietà esitoGiunta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitoGiunta(String value) {
        this.esitoGiunta = value;
    }

    /**
     * Recupera il valore della proprietà identificativo.
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
     * Imposta il valore della proprietà identificativo.
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
     * Recupera il valore della proprietà nroDef.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNroDef() {
        return nroDef;
    }

    /**
     * Imposta il valore della proprietà nroDef.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNroDef(Integer value) {
        this.nroDef = value;
    }

    /**
     * Recupera il valore della proprietà nroProvv.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNroProvv() {
        return nroProvv;
    }

    /**
     * Imposta il valore della proprietà nroProvv.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNroProvv(Integer value) {
        this.nroProvv = value;
    }

    /**
     * Recupera il valore della proprietà numLegisl.
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
     * Imposta il valore della proprietà numLegisl.
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
     * Recupera il valore della proprietà numOdg.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumOdg() {
        return numOdg;
    }

    /**
     * Imposta il valore della proprietà numOdg.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumOdg(Integer value) {
        this.numOdg = value;
    }

    /**
     * Recupera il valore della proprietà numeroBu.
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
     * Imposta il valore della proprietà numeroBu.
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
     * Recupera il valore della proprietà oggetto.
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
     * Imposta il valore della proprietà oggetto.
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
     * Recupera il valore della proprietà segreteriaGiunta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegreteriaGiunta() {
        return segreteriaGiunta;
    }

    /**
     * Imposta il valore della proprietà segreteriaGiunta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegreteriaGiunta(String value) {
        this.segreteriaGiunta = value;
    }

    /**
     * Recupera il valore della proprietà tipoEsecutivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoEsecutivita() {
        return tipoEsecutivita;
    }

    /**
     * Imposta il valore della proprietà tipoEsecutivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoEsecutivita(String value) {
        this.tipoEsecutivita = value;
    }

    /**
     * Recupera il valore della proprietà trasmissioneAssessorati.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTrasmissioneAssessorati() {
        return trasmissioneAssessorati;
    }

    /**
     * Imposta il valore della proprietà trasmissioneAssessorati.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTrasmissioneAssessorati(XMLGregorianCalendar value) {
        this.trasmissioneAssessorati = value;
    }

}
