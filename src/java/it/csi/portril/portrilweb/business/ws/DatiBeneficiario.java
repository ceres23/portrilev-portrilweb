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
 * <p>Classe Java per datiBeneficiario complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="datiBeneficiario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beneficiario" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}beneficiario" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "datiBeneficiario", propOrder = {
    "beneficiario",
    "fornitore"
})
public class DatiBeneficiario {

    @XmlElement(nillable = true)
    protected List<Beneficiario> beneficiario;
    protected Fornitore fornitore;

    /**
     * Gets the value of the beneficiario property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the beneficiario property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBeneficiario().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Beneficiario }
     * 
     * 
     */
    public List<Beneficiario> getBeneficiario() {
        if (beneficiario == null) {
            beneficiario = new ArrayList<Beneficiario>();
        }
        return this.beneficiario;
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
