/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/

package it.csi.portril.portrilweb.business.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.7
 * 2014-10-09T15:43:49.781+02:00
 * Generated source version: 2.7.7
 */

@WebFault(name = "CSIException", targetNamespace = "http://cxf.bilancio.interfacecxf.cmpsrvrp.bilsrvrp.csi.it/")
public class CSIException_Exception extends Exception {
    
    private it.csi.portril.portrilweb.business.ws.CSIException csiException;

    public CSIException_Exception() {
        super();
    }
    
    public CSIException_Exception(String message) {
        super(message);
    }
    
    public CSIException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public CSIException_Exception(String message, it.csi.portril.portrilweb.business.ws.CSIException csiException) {
        super(message);
        this.csiException = csiException;
    }

    public CSIException_Exception(String message, it.csi.portril.portrilweb.business.ws.CSIException csiException, Throwable cause) {
        super(message, cause);
        this.csiException = csiException;
    }

    public it.csi.portril.portrilweb.business.ws.CSIException getFaultInfo() {
        return this.csiException;
    }
}
