/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per direzioni complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="direzioni">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoEsercizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codDir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="delegata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flValidoBil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flValidoRag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "direzioni", propOrder = {
    "annoEsercizio",
    "codDir",
    "delegata",
    "descri",
    "direzione",
    "flValidoBil",
    "flValidoRag"
})
public class Direzioni {

    protected String annoEsercizio;
    protected String codDir;
    protected String delegata;
    protected String descri;
    protected String direzione;
    protected String flValidoBil;
    protected String flValidoRag;

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
     * Recupera il valore della proprietà codDir.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDir() {
        return codDir;
    }

    /**
     * Imposta il valore della proprietà codDir.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDir(String value) {
        this.codDir = value;
    }

    /**
     * Recupera il valore della proprietà delegata.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelegata() {
        return delegata;
    }

    /**
     * Imposta il valore della proprietà delegata.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelegata(String value) {
        this.delegata = value;
    }

    /**
     * Recupera il valore della proprietà descri.
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
     * Imposta il valore della proprietà descri.
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
     * Recupera il valore della proprietà flValidoBil.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlValidoBil() {
        return flValidoBil;
    }

    /**
     * Imposta il valore della proprietà flValidoBil.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlValidoBil(String value) {
        this.flValidoBil = value;
    }

    /**
     * Recupera il valore della proprietà flValidoRag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlValidoRag() {
        return flValidoRag;
    }

    /**
     * Imposta il valore della proprietà flValidoRag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlValidoRag(String value) {
        this.flValidoRag = value;
    }

}
