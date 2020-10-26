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
 * <p>Classe Java per consultaBeneficiariDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="consultaBeneficiariDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="beneficiario" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}datiBeneficiario" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="beneficiarioKeys" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}beneficiarioKey" minOccurs="0"/>
 *         &lt;element name="codFisc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxRec" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="partIva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ragSoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaBeneficiariDTO", propOrder = {
    "beneficiario",
    "beneficiarioKeys",
    "codFisc",
    "maxRec",
    "partIva",
    "ragSoc"
})
public class ConsultaBeneficiariDTO
    extends BaseDTO
{

    @XmlElement(nillable = true)
    protected List<DatiBeneficiario> beneficiario;
    protected BeneficiarioKey beneficiarioKeys;
    protected String codFisc;
    protected Integer maxRec;
    protected String partIva;
    protected String ragSoc;

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
     * {@link DatiBeneficiario }
     * 
     * 
     */
    public List<DatiBeneficiario> getBeneficiario() {
        if (beneficiario == null) {
            beneficiario = new ArrayList<DatiBeneficiario>();
        }
        return this.beneficiario;
    }

    /**
     * Recupera il valore della propriet� beneficiarioKeys.
     * 
     * @return
     *     possible object is
     *     {@link BeneficiarioKey }
     *     
     */
    public BeneficiarioKey getBeneficiarioKeys() {
        return beneficiarioKeys;
    }

    /**
     * Imposta il valore della propriet� beneficiarioKeys.
     * 
     * @param value
     *     allowed object is
     *     {@link BeneficiarioKey }
     *     
     */
    public void setBeneficiarioKeys(BeneficiarioKey value) {
        this.beneficiarioKeys = value;
    }

    /**
     * Recupera il valore della propriet� codFisc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFisc() {
        return codFisc;
    }

    /**
     * Imposta il valore della propriet� codFisc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFisc(String value) {
        this.codFisc = value;
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
     * Recupera il valore della propriet� partIva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartIva() {
        return partIva;
    }

    /**
     * Imposta il valore della propriet� partIva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartIva(String value) {
        this.partIva = value;
    }

    /**
     * Recupera il valore della propriet� ragSoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRagSoc() {
        return ragSoc;
    }

    /**
     * Imposta il valore della propriet� ragSoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRagSoc(String value) {
        this.ragSoc = value;
    }

}
