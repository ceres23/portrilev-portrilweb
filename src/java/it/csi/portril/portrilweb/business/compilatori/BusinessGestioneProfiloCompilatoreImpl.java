/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business.compilatori;

import it.csi.portril.portrilweb.business.BusinessManagerBase;
import it.csi.portril.portrilweb.business.interfaces.compilatori.BusinessGestioneProfiloCompilatore;
import it.csi.portril.portrilweb.integration.entity.PrTUtentiCompilatori;
import it.csi.portril.portrilweb.integration.repository.UtentiCompilatoriRepository;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Implementor dei dafault del servizio di calcolo. 
 */
// L'annotation @Service indica a Spring di inserire 
// un'istanza della classe nel proprio ApplicationContext 
@Service
// L'annotation @Transactional a livello di classe indica a Spring 
// di eseguire tutti i metodi del servizio in un contesto transazionale
@Transactional
public class BusinessGestioneProfiloCompilatoreImpl extends BusinessManagerBase implements BusinessGestioneProfiloCompilatore{

	@Autowired
	private UtentiCompilatoriRepository utentiCompilatoriRepository;
	
	@Override
	public UtentiCompilatoriModel resettaPwCompilatore(UtentiCompilatoriModel utente,String password) {
		String methodName="risettaPwCompilatore";
		log.startMethod(methodName);		
		log.debug(methodName, "utente.getIdUtenteCompilatore() " + utente.getIdUtenteCompilatore());
		PrTUtentiCompilatori prTUtentiCompilatori = utentiCompilatoriRepository.findOne(utente.getIdUtenteCompilatore());
		prTUtentiCompilatori.setPassword(password);
		UtentiCompilatoriModel ris = mapper.map(prTUtentiCompilatori, UtentiCompilatoriModel.class);		 		
		log.stopMethod(methodName);
		return ris;
	}
}