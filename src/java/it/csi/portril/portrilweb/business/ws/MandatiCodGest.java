/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per mandatiCodGest complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="mandatiCodGest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoEsercizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codGest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="nmand" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mandatiCodGest", propOrder = {
    "annoEsercizio",
    "codGest",
    "importo",
    "nmand"
})
public class MandatiCodGest {

    protected String annoEsercizio;
    protected String codGest;
    protected Double importo;
    protected Integer nmand;

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
     * Recupera il valore della proprietà codGest.
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
     * Imposta il valore della proprietà codGest.
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
     * Recupera il valore della proprietà importo.
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
     * Imposta il valore della proprietà importo.
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
     * Recupera il valore della proprietà nmand.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNmand() {
        return nmand;
    }

    /**
     * Imposta il valore della proprietà nmand.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNmand(Integer value) {
        this.nmand = value;
    }

}
