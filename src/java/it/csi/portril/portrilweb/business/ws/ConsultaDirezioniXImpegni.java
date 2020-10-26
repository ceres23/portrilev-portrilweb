/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per consultaDirezioniXImpegni complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="consultaDirezioniXImpegni">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}consultaDirezioniXImpegniDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaDirezioniXImpegni", propOrder = {
    "arg0"
})
public class ConsultaDirezioniXImpegni {

    protected ConsultaDirezioniXImpegniDTO arg0;

    /**
     * Recupera il valore della proprietÓ arg0.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaDirezioniXImpegniDTO }
     *     
     */
    public ConsultaDirezioniXImpegniDTO getArg0() {
        return arg0;
    }

    /**
     * Imposta il valore della proprietÓ arg0.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaDirezioniXImpegniDTO }
     *     
     */
    public void setArg0(ConsultaDirezioniXImpegniDTO value) {
        this.arg0 = value;
    }

}
