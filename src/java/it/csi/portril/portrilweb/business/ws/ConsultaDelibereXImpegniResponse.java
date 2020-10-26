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
 * <p>Classe Java per consultaDelibereXImpegniResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="consultaDelibereXImpegniResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}consultaDelibereXImpegniDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaDelibereXImpegniResponse", propOrder = {
    "_return"
})
public class ConsultaDelibereXImpegniResponse {

    @XmlElement(name = "return")
    protected ConsultaDelibereXImpegniDTO _return;

    /**
     * Recupera il valore della propriet� return.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaDelibereXImpegniDTO }
     *     
     */
    public ConsultaDelibereXImpegniDTO getReturn() {
        return _return;
    }

    /**
     * Imposta il valore della propriet� return.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaDelibereXImpegniDTO }
     *     
     */
    public void setReturn(ConsultaDelibereXImpegniDTO value) {
        this._return = value;
    }

}
