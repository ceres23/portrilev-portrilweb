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
 * <p>Classe Java per consultaAttiLiquidazioneDTO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="consultaAttiLiquidazioneDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="consultaAtto" type="{http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/}consultaAttoLiquidazioneDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaAttiLiquidazioneDTO", propOrder = {
    "consultaAtto"
})
public class ConsultaAttiLiquidazioneDTO
    extends BaseDTO
{

    @XmlElement(nillable = true)
    protected List<ConsultaAttoLiquidazioneDTO> consultaAtto;

    /**
     * Gets the value of the consultaAtto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consultaAtto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsultaAtto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsultaAttoLiquidazioneDTO }
     * 
     * 
     */
    public List<ConsultaAttoLiquidazioneDTO> getConsultaAtto() {
        if (consultaAtto == null) {
            consultaAtto = new ArrayList<ConsultaAttoLiquidazioneDTO>();
        }
        return this.consultaAtto;
    }

}
