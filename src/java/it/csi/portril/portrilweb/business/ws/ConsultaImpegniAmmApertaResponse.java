/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per consultaImpegniAmmApertaResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="consultaImpegniAmmApertaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}consultaImpegniAmmApertaDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaImpegniAmmApertaResponse", propOrder = {
    "_return"
})
public class ConsultaImpegniAmmApertaResponse {

    @XmlElement(name = "return")
    protected ConsultaImpegniAmmApertaDTO _return;

    /**
     * Recupera il valore della proprietÓ return.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaImpegniAmmApertaDTO }
     *     
     */
    public ConsultaImpegniAmmApertaDTO getReturn() {
        return _return;
    }

    /**
     * Imposta il valore della proprietÓ return.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaImpegniAmmApertaDTO }
     *     
     */
    public void setReturn(ConsultaImpegniAmmApertaDTO value) {
        this._return = value;
    }

}
