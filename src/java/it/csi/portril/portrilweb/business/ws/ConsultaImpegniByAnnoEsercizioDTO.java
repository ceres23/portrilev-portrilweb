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
 * <p>Classe Java per consultaImpegniByAnnoEsercizioDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="consultaImpegniByAnnoEsercizioDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="anno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataEmiss" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="impegni" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}impegno" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listaCodGest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pageIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pageSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totaleRisultati" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nImp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaImpegniByAnnoEsercizioDTO", propOrder = {
    "anno",
    "dataEmiss",
    "impegni",
    "listaCodGest",
    "pageIndex",
    "pageSize",
    "totaleRisultati",
    "nImp"
})
public class ConsultaImpegniByAnnoEsercizioDTO
    extends BaseDTO
{

    protected String anno;
    protected String dataEmiss;
    @XmlElement(nillable = true)
    protected List<Impegno> impegni;
    protected String listaCodGest;
    protected int pageIndex;
    protected int pageSize;
    protected int totaleRisultati;
    protected Integer nImp;

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
     * Recupera il valore della propriet� dataEmiss.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataEmiss() {
        return dataEmiss;
    }

    /**
     * Imposta il valore della propriet� dataEmiss.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataEmiss(String value) {
        this.dataEmiss = value;
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
     * Recupera il valore della propriet� listaCodGest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListaCodGest() {
        return listaCodGest;
    }

    /**
     * Imposta il valore della propriet� listaCodGest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListaCodGest(String value) {
        this.listaCodGest = value;
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

    /**
     * Recupera il valore della propriet� nImp.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNImp() {
        return nImp;
    }

    /**
     * Imposta il valore della propriet� nImp.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNImp(Integer value) {
        this.nImp = value;
    }

}
