/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per baseDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="baseDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="result" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}result" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseDTO", propOrder = {
    "result"
})
@XmlSeeAlso({
    ConsultaMandatiAllDTO.class,
    ConsultaMandatiByAttoDTO.class,
    ConsultaFornitoriAllDTO.class,
    ConsultaCodiciGestionaliAllDTO.class,
    ConsultaDirezioniXImpegniDTO.class,
    ConsultaCapitoliXImpegniDTO.class,
    ConsultaFornitoriXImpegniDTO.class,
    ConsultaLiquidazioniAllDTO.class,
    InserisciAttoLiquidazioneDTO.class,
    DeterminaByCodiceDTO.class,
    ConsultaMandatiXImpegniDTO.class,
    VerificaMandatiDTO.class,
    ConsultaLiquidazioniByAttoDTO.class,
    ConsultaCapitoliAllDTO.class,
    ConsultaAttoLiquidazioneDTO.class,
    ConsultaAttiLiquidazioneDTO.class,
    ConsultaImpegniDTO.class,
    ConsultaDelibereXImpegniDTO.class,
    ConsultaDetermineXImpegniDTO.class,
    VerificaMandatiByAttoDTO.class,
    ConsultaImpegniAllDTO.class,
    ConsultaImpegniByAnnoEsercizioDTO.class,
    ConsultaBeneficiariDTO.class,
    DeliberaByCodiceDTO.class,
    ConsultaDirezioniAllDTO.class,
    ConsultaImpegniAmmApertaDTO.class,
    ConsultaMandatiCodGestAllDTO.class
})
public abstract class BaseDTO {

    protected Result result;

    /**
     * Recupera il valore della proprietà result.
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getResult() {
        return result;
    }

    /**
     * Imposta il valore della proprietà result.
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setResult(Result value) {
        this.result = value;
    }

}
