/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business.compilatori;

import java.util.List;

import it.csi.portril.portrilweb.business.BusinessManagerBase;
import it.csi.portril.portrilweb.business.interfaces.compilatori.BusinessGestioneLoginCompilatore;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTUtentiCompilatoriDAO;
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
public class BusinessGestioneLoginCompilatoreImpl extends BusinessManagerBase implements BusinessGestioneLoginCompilatore{

	@Autowired
	private UtentiCompilatoriRepository utentiCompilatoriRepository;
	@Autowired
	private PrTUtentiCompilatoriDAO utentiCompilatoriDAO;

	@Override
	public UtentiCompilatoriModel getUtenteCompilatoreByLogin(String login) {
		String methodName="getUtenteCompilatoreByLogin";
		log.startMethod(methodName);		
		log.debug(methodName, "login" +login);
		PrTUtentiCompilatori prTUtentiCompilatori=  utentiCompilatoriRepository.getUtenteCompilatoreByLogin( login );
		UtentiCompilatoriModel ris = null;
		if(prTUtentiCompilatori!=null){
			 ris = mapper.map(prTUtentiCompilatori, UtentiCompilatoriModel.class);
		}
		log.debugMultiLine(methodName,ris);
		log.stopMethod(methodName);
		return ris ;
	}
	
	@Override
	public UtentiCompilatoriModel getUtenteCompilatoreByUsPW(String login,String password) {
		String methodName="getUtenteCompilatoreByUsPW";
		log.startMethod(methodName);	
		log.debug(methodName, "login" +login);
		List<PrTUtentiCompilatori> listaUtentiCompilatori= utentiCompilatoriDAO.getUtenteCompilatoreByUsPW( login, password);			
		UtentiCompilatoriModel ris = null;
		if(listaUtentiCompilatori!=null && listaUtentiCompilatori.size()==1){ 
			 ris = mapper.map(listaUtentiCompilatori.get(0), UtentiCompilatoriModel.class);
		}
		log.debugMultiLine(methodName,ris);
		log.stopMethod(methodName);
		return ris ;
	}

	@Override
	public UtentiCompilatoriModel getUtenteCompilatoreByUsPwStato(String login,String password,String stato) {
		String methodName="getUtenteCompilatoreByUsPwStato";
		log.startMethod(methodName);				
		List<PrTUtentiCompilatori> listaUtentiCompilatori= utentiCompilatoriDAO.getUtenteCompilatoreByUsPwStato( login, password, stato);					
		UtentiCompilatoriModel ris = null;		
		if(listaUtentiCompilatori!=null && listaUtentiCompilatori.size()==1){ 
			 ris = mapper.map(listaUtentiCompilatori.get(0), UtentiCompilatoriModel.class);
		}		
		log.debugMultiLine(methodName,ris);
		log.stopMethod(methodName);
		return ris ;
	}
}
