/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per attoLiquidazione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="attoLiquidazione">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="atto" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}atto" minOccurs="0"/>
 *         &lt;element name="beneficiario" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}beneficiario" minOccurs="0"/>
 *         &lt;element name="dettagliAtto" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}dettaglioConsultazioneAtto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fornitore" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}fornitore" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attoLiquidazione", propOrder = {
    "atto",
    "beneficiario",
    "dettagliAtto",
    "fornitore"
})
public class AttoLiquidazione {

    protected Atto atto;
    protected Beneficiario beneficiario;
    @XmlElement(nillable = true)
    protected List<DettaglioConsultazioneAtto> dettagliAtto;
    protected Fornitore fornitore;

    /**
     * Recupera il valore della propriet� atto.
     * 
     * @return
     *     possible object is
     *     {@link Atto }
     *     
     */
    public Atto getAtto() {
        return atto;
    }

    /**
     * Imposta il valore della propriet� atto.
     * 
     * @param value
     *     allowed object is
     *     {@link Atto }
     *     
     */
    public void setAtto(Atto value) {
        this.atto = value;
    }

    /**
     * Recupera il valore della propriet� beneficiario.
     * 
     * @return
     *     possible object is
     *     {@link Beneficiario }
     *     
     */
    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    /**
     * Imposta il valore della propriet� beneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link Beneficiario }
     *     
     */
    public void setBeneficiario(Beneficiario value) {
        this.beneficiario = value;
    }

    /**
     * Gets the value of the dettagliAtto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dettagliAtto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDettagliAtto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DettaglioConsultazioneAtto }
     * 
     * 
     */
    public List<DettaglioConsultazioneAtto> getDettagliAtto() {
        if (dettagliAtto == null) {
            dettagliAtto = new ArrayList<DettaglioConsultazioneAtto>();
        }
        return this.dettagliAtto;
    }

    /**
     * Recupera il valore della propriet� fornitore.
     * 
     * @return
     *     possible object is
     *     {@link Fornitore }
     *     
     */
    public Fornitore getFornitore() {
        return fornitore;
    }

    /**
     * Imposta il valore della propriet� fornitore.
     * 
     * @param value
     *     allowed object is
     *     {@link Fornitore }
     *     
     */
    public void setFornitore(Fornitore value) {
        this.fornitore = value;
    }

}
