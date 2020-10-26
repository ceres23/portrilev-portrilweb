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
 * <p>Classe Java per consultaImpegniDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="consultaImpegniDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="annoEser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capitoliKeys" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}capitoloKey" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="impegni" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}impegno" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="impegniKeys" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}impegnoKey" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="maxRec" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="provvedimentiKeys" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}provvedimentoKey" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaImpegniDTO", propOrder = {
    "annoEser",
    "capitoliKeys",
    "impegni",
    "impegniKeys",
    "maxRec",
    "provvedimentiKeys"
})
public class ConsultaImpegniDTO
    extends BaseDTO
{

    protected String annoEser;
    @XmlElement(nillable = true)
    protected List<CapitoloKey> capitoliKeys;
    @XmlElement(nillable = true)
    protected List<Impegno> impegni;
    @XmlElement(nillable = true)
    protected List<ImpegnoKey> impegniKeys;
    protected Integer maxRec;
    @XmlElement(nillable = true)
    protected List<ProvvedimentoKey> provvedimentiKeys;

    /**
     * Recupera il valore della propriet� annoEser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoEser() {
        return annoEser;
    }

    /**
     * Imposta il valore della propriet� annoEser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoEser(String value) {
        this.annoEser = value;
    }

    /**
     * Gets the value of the capitoliKeys property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the capitoliKeys property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCapitoliKeys().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CapitoloKey }
     * 
     * 
     */
    public List<CapitoloKey> getCapitoliKeys() {
        if (capitoliKeys == null) {
            capitoliKeys = new ArrayList<CapitoloKey>();
        }
        return this.capitoliKeys;
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
     * Gets the value of the impegniKeys property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the impegniKeys property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImpegniKeys().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImpegnoKey }
     * 
     * 
     */
    public List<ImpegnoKey> getImpegniKeys() {
        if (impegniKeys == null) {
            impegniKeys = new ArrayList<ImpegnoKey>();
        }
        return this.impegniKeys;
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

    /**
     * Gets the value of the provvedimentiKeys property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the provvedimentiKeys property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProvvedimentiKeys().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProvvedimentoKey }
     * 
     * 
     */
    public List<ProvvedimentoKey> getProvvedimentiKeys() {
        if (provvedimentiKeys == null) {
            provvedimentiKeys = new ArrayList<ProvvedimentoKey>();
        }
        return this.provvedimentiKeys;
    }

}
