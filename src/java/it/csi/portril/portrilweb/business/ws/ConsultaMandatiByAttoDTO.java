/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per consultaMandatiByAttoDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="consultaMandatiByAttoDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="anno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceTipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importoEmessi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="importoQuietanziati" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="importoVerificati" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mandati" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}mandato" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "consultaMandatiByAttoDTO", propOrder = {
    "anno",
    "codiceTipo",
    "direzione",
    "importoEmessi",
    "importoQuietanziati",
    "importoVerificati",
    "mandati",
    "numero",
    "pageIndex",
    "pageSize",
    "totaleRisultati"
})
public class ConsultaMandatiByAttoDTO
    extends BaseDTO
{

    protected String anno;
    protected String codiceTipo;
    protected String direzione;
    protected BigDecimal importoEmessi;
    protected BigDecimal importoQuietanziati;
    protected BigDecimal importoVerificati;
    @XmlElement(nillable = true)
    protected List<Mandato> mandati;
    protected String numero;
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
     * Recupera il valore della propriet� codiceTipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceTipo() {
        return codiceTipo;
    }

    /**
     * Imposta il valore della propriet� codiceTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceTipo(String value) {
        this.codiceTipo = value;
    }

    /**
     * Recupera il valore della propriet� direzione.
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
     * Imposta il valore della propriet� direzione.
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
     * Recupera il valore della propriet� importoEmessi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoEmessi() {
        return importoEmessi;
    }

    /**
     * Imposta il valore della propriet� importoEmessi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoEmessi(BigDecimal value) {
        this.importoEmessi = value;
    }

    /**
     * Recupera il valore della propriet� importoQuietanziati.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoQuietanziati() {
        return importoQuietanziati;
    }

    /**
     * Imposta il valore della propriet� importoQuietanziati.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoQuietanziati(BigDecimal value) {
        this.importoQuietanziati = value;
    }

    /**
     * Recupera il valore della propriet� importoVerificati.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoVerificati() {
        return importoVerificati;
    }

    /**
     * Imposta il valore della propriet� importoVerificati.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoVerificati(BigDecimal value) {
        this.importoVerificati = value;
    }

    /**
     * Gets the value of the mandati property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mandati property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMandati().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Mandato }
     * 
     * 
     */
    public List<Mandato> getMandati() {
        if (mandati == null) {
            mandati = new ArrayList<Mandato>();
        }
        return this.mandati;
    }

    /**
     * Recupera il valore della propriet� numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Imposta il valore della propriet� numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
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
