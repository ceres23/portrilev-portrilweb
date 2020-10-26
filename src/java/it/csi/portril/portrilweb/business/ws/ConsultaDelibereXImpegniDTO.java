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
 * <p>Classe Java per consultaDelibereXImpegniDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="consultaDelibereXImpegniDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="anno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="delibera" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}delibera" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pageIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pageSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totaleRisultati" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaDelibereXImpegniDTO", propOrder = {
    "anno",
    "delibera",
    "pageIndex",
    "pageSize",
    "totaleRisultati"
})
public class ConsultaDelibereXImpegniDTO
    extends BaseDTO
{

    protected String anno;
    @XmlElement(nillable = true)
    protected List<Delibera> delibera;
    protected int pageIndex;
    protected int pageSize;
    protected int totaleRisultati;

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
     * Gets the value of the delibera property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the delibera property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDelibera().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Delibera }
     * 
     * 
     */
    public List<Delibera> getDelibera() {
        if (delibera == null) {
            delibera = new ArrayList<Delibera>();
        }
        return this.delibera;
    }

    /**
     * Recupera il valore della propriet� pageIndex.
     * 
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * Imposta il valore della propriet� pageIndex.
     * 
     */
    public void setPageIndex(int value) {
        this.pageIndex = value;
    }

    /**
     * Recupera il valore della propriet� pageSize.
     * 
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Imposta il valore della propriet� pageSize.
     * 
     */
    public void setPageSize(int value) {
        this.pageSize = value;
    }

    /**
     * Recupera il valore della propriet� totaleRisultati.
     * 
     */
    public int getTotaleRisultati() {
        return totaleRisultati;
    }

    /**
     * Imposta il valore della propriet� totaleRisultati.
     * 
     */
    public void setTotaleRisultati(int value) {
        this.totaleRisultati = value;
    }

}
