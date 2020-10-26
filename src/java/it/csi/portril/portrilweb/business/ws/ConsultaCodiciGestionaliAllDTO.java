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
 * <p>Classe Java per consultaCodiciGestionaliAllDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="consultaCodiciGestionaliAllDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="anno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiciGestionali" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}codiciGestionali" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listacodGest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totaleRisultati" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaCodiciGestionaliAllDTO", propOrder = {
    "anno",
    "codiciGestionali",
    "listacodGest",
    "totaleRisultati"
})
public class ConsultaCodiciGestionaliAllDTO
    extends BaseDTO
{

    protected String anno;
    @XmlElement(nillable = true)
    protected List<CodiciGestionali> codiciGestionali;
    protected String listacodGest;
    protected Integer totaleRisultati;

    /**
     * Recupera il valore della propriet� anno.
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
     * Imposta il valore della propriet� anno.
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
     * Gets the value of the codiciGestionali property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the codiciGestionali property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCodiciGestionali().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodiciGestionali }
     * 
     * 
     */
    public List<CodiciGestionali> getCodiciGestionali() {
        if (codiciGestionali == null) {
            codiciGestionali = new ArrayList<CodiciGestionali>();
        }
        return this.codiciGestionali;
    }

    /**
     * Recupera il valore della propriet� listacodGest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListacodGest() {
        return listacodGest;
    }

    /**
     * Imposta il valore della propriet� listacodGest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListacodGest(String value) {
        this.listacodGest = value;
    }

    /**
     * Recupera il valore della propriet� totaleRisultati.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotaleRisultati() {
        return totaleRisultati;
    }

    /**
     * Imposta il valore della propriet� totaleRisultati.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotaleRisultati(Integer value) {
        this.totaleRisultati = value;
    }

}
