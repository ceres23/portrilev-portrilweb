/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiGestori;
import it.csi.portril.portrilweb.integration.entity.PrTEntiGestori;
import it.csi.portril.portrilweb.integration.repository.EntiGestoriRepository;
import it.csi.portril.portrilweb.model.EntiGestoriModel;

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
public class BusinessGestioneEntiGestoriImpl extends BusinessManagerBase implements BusinessGestioneEntiGestori{

	@Autowired
	private EntiGestoriRepository entiGestoriRepository;
	
	@Override
	public EntiGestoriModel getEnteGestoreById(Long idEnteSel) {
		String methodName = "getEnteGestoreById";
		log.startMethod(methodName);		
		log.debug(methodName, "idEnteGestSel "+ idEnteSel);
		PrTEntiGestori entity = entiGestoriRepository.findOne(idEnteSel);
		EntiGestoriModel ris = mapper.map(entity,EntiGestoriModel.class);
		log.stopMethod(methodName);		
		return ris;
	}
}