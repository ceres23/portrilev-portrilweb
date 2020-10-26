/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2014-10-09T15:43:49.832+02:00
 * Generated source version: 2.7.7
 * 
 */
@WebService(targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", name = "BilancioWsInterface")
@XmlSeeAlso({ObjectFactory.class})
public interface BilancioWsInterface {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaLiquidazioniByAtto", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaLiquidazioniByAtto")
    @WebMethod
    @ResponseWrapper(localName = "consultaLiquidazioniByAttoResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaLiquidazioniByAttoResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaLiquidazioniByAttoDTO consultaLiquidazioniByAtto(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaLiquidazioniByAttoDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaCapitoliXImpegni", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaCapitoliXImpegni")
    @WebMethod
    @ResponseWrapper(localName = "consultaCapitoliXImpegniResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaCapitoliXImpegniResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaCapitoliXImpegniDTO consultaCapitoliXImpegni(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaCapitoliXImpegniDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaDirezioniAll", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaDirezioniAll")
    @WebMethod
    @ResponseWrapper(localName = "consultaDirezioniAllResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaDirezioniAllResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaDirezioniAllDTO consultaDirezioniAll(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaDirezioniAllDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaCodiciGestionaliAll", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaCodiciGestionaliAll")
    @WebMethod
    @ResponseWrapper(localName = "consultaCodiciGestionaliAllResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaCodiciGestionaliAllResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaCodiciGestionaliAllDTO consultaCodiciGestionaliAll(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaCodiciGestionaliAllDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaFornitoriAll", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaFornitoriAll")
    @WebMethod
    @ResponseWrapper(localName = "consultaFornitoriAllResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaFornitoriAllResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaFornitoriAllDTO consultaFornitoriAll(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaFornitoriAllDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "determinaByCodice", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.DeterminaByCodice")
    @WebMethod
    @ResponseWrapper(localName = "determinaByCodiceResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.DeterminaByCodiceResponse")
    public it.csi.portril.portrilweb.business.ws.DeterminaByCodiceDTO determinaByCodice(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.DeterminaByCodiceDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaMandatiCodGestAll", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaMandatiCodGestAll")
    @WebMethod
    @ResponseWrapper(localName = "consultaMandatiCodGestAllResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaMandatiCodGestAllResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaMandatiCodGestAllDTO consultaMandatiCodGestAll(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaMandatiCodGestAllDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaImpegniAmmAperta", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaImpegniAmmAperta")
    @WebMethod
    @ResponseWrapper(localName = "consultaImpegniAmmApertaResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaImpegniAmmApertaResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaImpegniAmmApertaDTO consultaImpegniAmmAperta(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaImpegniAmmApertaDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaCapitoliAll", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaCapitoliAll")
    @WebMethod
    @ResponseWrapper(localName = "consultaCapitoliAllResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaCapitoliAllResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaCapitoliAllDTO consultaCapitoliAll(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaCapitoliAllDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaAttoLiquidazione", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaAttoLiquidazione")
    @WebMethod
    @ResponseWrapper(localName = "consultaAttoLiquidazioneResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaAttoLiquidazioneResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaAttoLiquidazioneDTO consultaAttoLiquidazione(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaAttoLiquidazioneDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaMandatiByAtto", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaMandatiByAtto")
    @WebMethod
    @ResponseWrapper(localName = "consultaMandatiByAttoResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaMandatiByAttoResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaMandatiByAttoDTO consultaMandatiByAtto(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaMandatiByAttoDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaDetermineXImpegni", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaDetermineXImpegni")
    @WebMethod
    @ResponseWrapper(localName = "consultaDetermineXImpegniResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaDetermineXImpegniResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaDetermineXImpegniDTO consultaDetermineXImpegni(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaDetermineXImpegniDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaImpegniByAnnoEsercizio", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaImpegniByAnnoEsercizio")
    @WebMethod
    @ResponseWrapper(localName = "consultaImpegniByAnnoEsercizioResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaImpegniByAnnoEsercizioResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaImpegniByAnnoEsercizioDTO consultaImpegniByAnnoEsercizio(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaImpegniByAnnoEsercizioDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaDelibereXImpegni", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaDelibereXImpegni")
    @WebMethod
    @ResponseWrapper(localName = "consultaDelibereXImpegniResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaDelibereXImpegniResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaDelibereXImpegniDTO consultaDelibereXImpegni(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaDelibereXImpegniDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaAttiLiquidazione", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaAttiLiquidazione")
    @WebMethod
    @ResponseWrapper(localName = "consultaAttiLiquidazioneResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaAttiLiquidazioneResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaAttiLiquidazioneDTO consultaAttiLiquidazione(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaAttiLiquidazioneDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaMandatiAll", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaMandatiAll")
    @WebMethod
    @ResponseWrapper(localName = "consultaMandatiAllResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaMandatiAllResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaMandatiAllDTO consultaMandatiAll(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaMandatiAllDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "verificaMandatiByAtto", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.VerificaMandatiByAtto")
    @WebMethod
    @ResponseWrapper(localName = "verificaMandatiByAttoResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.VerificaMandatiByAttoResponse")
    public it.csi.portril.portrilweb.business.ws.VerificaMandatiByAttoDTO verificaMandatiByAtto(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.VerificaMandatiByAttoDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaFornitoriXImpegni", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaFornitoriXImpegni")
    @WebMethod
    @ResponseWrapper(localName = "consultaFornitoriXImpegniResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaFornitoriXImpegniResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaFornitoriXImpegniDTO consultaFornitoriXImpegni(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaFornitoriXImpegniDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "deliberaByCodice", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.DeliberaByCodice")
    @WebMethod
    @ResponseWrapper(localName = "deliberaByCodiceResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.DeliberaByCodiceResponse")
    public it.csi.portril.portrilweb.business.ws.DeliberaByCodiceDTO deliberaByCodice(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.DeliberaByCodiceDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaDirezioniXImpegni", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaDirezioniXImpegni")
    @WebMethod
    @ResponseWrapper(localName = "consultaDirezioniXImpegniResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaDirezioniXImpegniResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaDirezioniXImpegniDTO consultaDirezioniXImpegni(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaDirezioniXImpegniDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "inserisciAttoLiquidazione", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.InserisciAttoLiquidazione")
    @WebMethod
    @ResponseWrapper(localName = "inserisciAttoLiquidazioneResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.InserisciAttoLiquidazioneResponse")
    public it.csi.portril.portrilweb.business.ws.InserisciAttoLiquidazioneDTO inserisciAttoLiquidazione(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.InserisciAttoLiquidazioneDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaImpegniAll", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaImpegniAll")
    @WebMethod
    @ResponseWrapper(localName = "consultaImpegniAllResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaImpegniAllResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaImpegniAllDTO consultaImpegniAll(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaImpegniAllDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaLiquidazioniAll", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaLiquidazioniAll")
    @WebMethod
    @ResponseWrapper(localName = "consultaLiquidazioniAllResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaLiquidazioniAllResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaLiquidazioniAllDTO consultaLiquidazioniAll(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaLiquidazioniAllDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaImpegni", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaImpegni")
    @WebMethod
    @ResponseWrapper(localName = "consultaImpegniResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaImpegniResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaImpegniDTO consultaImpegni(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaImpegniDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaMandatiXImpegni", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaMandatiXImpegni")
    @WebMethod
    @ResponseWrapper(localName = "consultaMandatiXImpegniResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaMandatiXImpegniResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaMandatiXImpegniDTO consultaMandatiXImpegni(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaMandatiXImpegniDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "verificaMandati", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.VerificaMandati")
    @WebMethod
    @ResponseWrapper(localName = "verificaMandatiResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.VerificaMandatiResponse")
    public it.csi.portril.portrilweb.business.ws.VerificaMandatiDTO verificaMandati(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.VerificaMandatiDTO arg0
    ) throws CSIException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultaBeneficiari", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaBeneficiari")
    @WebMethod
    @ResponseWrapper(localName = "consultaBeneficiariResponse", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/", className = "it.csi.portril.portrilweb.business.ws.ConsultaBeneficiariResponse")
    public it.csi.portril.portrilweb.business.ws.ConsultaBeneficiariDTO consultaBeneficiari(
        @WebParam(name = "arg0", targetNamespace = "")
        it.csi.portril.portrilweb.business.ws.ConsultaBeneficiariDTO arg0
    ) throws CSIException_Exception;
}
