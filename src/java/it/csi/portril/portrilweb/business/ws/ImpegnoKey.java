/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per impegnoKey complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="impegnoKey">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoEsercizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annoimp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nimp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "impegnoKey", propOrder = {
    "annoEsercizio",
    "annoimp",
    "nimp"
})
@XmlSeeAlso({
    Impegno.class
})
public class ImpegnoKey {

    protected String annoEsercizio;
    protected String annoimp;
    protected Integer nimp;

    /**
     * Recupera il valore della proprietà annoEsercizio.
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
     * Imposta il valore della proprietà annoEsercizio.
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
     * Recupera il valore della proprietà annoimp.
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
     * Imposta il valore della proprietà annoimp.
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
     * Recupera il valore della proprietà nimp.
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
     * Imposta il valore della proprietà nimp.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNimp(Integer value) {
        this.nimp = value;
    }

}
