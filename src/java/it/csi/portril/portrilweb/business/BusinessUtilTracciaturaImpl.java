/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business;
import it.csi.portril.portrilweb.business.interfaces.BusinessUtilTracciatura;
import it.csi.portril.portrilweb.integration.dao.interfaces.CsiLogAuditDAO;
import it.csi.portril.portrilweb.integration.entity.CsiLogAudit;
import it.csi.portril.portrilweb.model.UtentiGestoriModel;
import it.csi.portril.portrilweb.util.Costanti;

import java.util.Date;

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
public class BusinessUtilTracciaturaImpl extends BusinessManagerBase implements BusinessUtilTracciatura{
	@Autowired
	private CsiLogAuditDAO csiLogAuditDAO;	
	@Override
	public void insertCsiLogAudit(UtentiGestoriModel utentiGestoriModel,String operazione ,String oggettoOperazione) {
		CsiLogAudit entity = new CsiLogAudit();
		entity.setIdApp(Costanti.APPLICATION_CODE.getCostante());
		entity.setIpAddress("");
		entity.setUtente(utentiGestoriModel.getCodiceFiscale());
		entity.setOperazione(operazione);
		entity.setOggOper(oggettoOperazione);
		entity.setDataOra(new Date());
		entity.setKeyOper("");
		csiLogAuditDAO.create(entity);
	}
}
