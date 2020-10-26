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
 * <p>Classe Java per capitoloKey complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="capitoloKey">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoEser" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroArt" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nroCap" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "capitoloKey", propOrder = {
    "annoEser",
    "nroArt",
    "nroCap"
})
@XmlSeeAlso({
    Capitolo.class
})
public class CapitoloKey {

    protected Integer annoEser;
    protected Integer nroArt;
    protected Integer nroCap;

    /**
     * Recupera il valore della proprietà annoEser.
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
     * Imposta il valore della proprietà annoEser.
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
     * Recupera il valore della proprietà nroArt.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNroArt() {
        return nroArt;
    }

    /**
     * Imposta il valore della proprietà nroArt.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNroArt(Integer value) {
        this.nroArt = value;
    }

    /**
     * Recupera il valore della proprietà nroCap.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNroCap() {
        return nroCap;
    }

    /**
     * Imposta il valore della proprietà nroCap.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNroCap(Integer value) {
        this.nroCap = value;
    }

}
