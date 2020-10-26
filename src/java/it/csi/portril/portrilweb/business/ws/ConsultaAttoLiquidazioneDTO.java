/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per consultaAttoLiquidazioneDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="consultaAttoLiquidazioneDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="attoLiquidazione" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}attoLiquidazione" minOccurs="0"/>
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
@XmlType(name = "consultaAttoLiquidazioneDTO", propOrder = {
    "attoLiquidazione",
    "maxRec"
})
public class ConsultaAttoLiquidazioneDTO
    extends BaseDTO
{

    protected AttoLiquidazione attoLiquidazione;
    protected Integer maxRec;

    /**
     * Recupera il valore della proprietà attoLiquidazione.
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
     * Imposta il valore della proprietà attoLiquidazione.
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
     * Recupera il valore della proprietà maxRec.
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
     * Imposta il valore della proprietà maxRec.
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
