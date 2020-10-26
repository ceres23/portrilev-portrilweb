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
 * <p>Classe Java per inserisciAttoLiquidazioneDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="inserisciAttoLiquidazioneDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="attoLiquidazione" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}attoLiquidazione" minOccurs="0"/>
 *         &lt;element name="impegni" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}impegno" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="maxRec" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inserisciAttoLiquidazioneDTO", propOrder = {
    "attoLiquidazione",
    "impegni",
    "maxRec"
})
public class InserisciAttoLiquidazioneDTO
    extends BaseDTO
{

    protected AttoLiquidazione attoLiquidazione;
    @XmlElement(nillable = true)
    protected List<Impegno> impegni;
    protected Integer maxRec;

    /**
     * Recupera il valore della propriet� attoLiquidazione.
     * 
     * @return
     *     possible object is
     *     {@link AttoLiquidazione }
     *     
     */
    public AttoLiquidazione getAttoLiquidazione() {
        return attoLiquidazione;
    }

    /**
     * Imposta il valore della propriet� attoLiquidazione.
     * 
     * @param value
     *     allowed object is
     *     {@link AttoLiquidazione }
     *     
     */
    public void setAttoLiquidazione(AttoLiquidazione value) {
        this.attoLiquidazione = value;
    }

    /**
     * Gets the value of the impegni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the impegni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImpegni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Impegno }
     * 
     * 
     */
    public List<Impegno> getImpegni() {
        if (impegni == null) {
            impegni = new ArrayList<Impegno>();
        }
        return this.impegni;
    }

    /**
     * Recupera il valore della propriet� maxRec.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxRec() {
        return maxRec;
    }

    /**
     * Imposta il valore della propriet� maxRec.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxRec(Integer value) {
        this.maxRec = value;
    }

}
