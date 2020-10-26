/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiGestori;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTEntiGestoriDAO;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTUtentiGestoriDAO;
import it.csi.portril.portrilweb.integration.entity.PrTEntiGestori;
import it.csi.portril.portrilweb.integration.entity.PrTProfiliUtenti;
import it.csi.portril.portrilweb.integration.entity.PrTUtentiGestori;
import it.csi.portril.portrilweb.integration.repository.EntiGestoriRepository;
import it.csi.portril.portrilweb.integration.repository.ProfiUtentiRepository;
import it.csi.portril.portrilweb.integration.repository.UtentiGestoriRepository;
import it.csi.portril.portrilweb.model.EntiGestoriModel;
import it.csi.portril.portrilweb.model.ProfiliUtentiModel;
import it.csi.portril.portrilweb.model.UtentiGestoriModel;
import it.csi.portril.portrilweb.util.Costanti;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
public class BusinessGestioneUtentiGestoriImpl extends BusinessManagerBase implements BusinessGestioneUtentiGestori{
	
	@Autowired
	private PrTUtentiGestoriDAO utentiGestoriDAO;
	
	@Autowired
	private PrTEntiGestoriDAO entiGestoriDAO;

	@Autowired
	private UtentiGestoriRepository utentiGestoriRepository;	

	@Autowired
	private ProfiUtentiRepository profiUtentiRepository;
	
	@Autowired
	private EntiGestoriRepository entiGestoriRepository;
	
	
	@Override
	public UtentiGestoriModel getUtenteGestorebyCodFis(String codiceFiscale) {	
		String methodName = "getUtenteGestorebyCodFis";
		log.startMethod(methodName);		
		UtentiGestoriModel utentiGestoriModel= new UtentiGestoriModel();
		log.debug(methodName, "codiceFiscale       " + codiceFiscale);
		PrTUtentiGestori prTUtentiGestori = utentiGestoriRepository.getUtenteGestorebyCodFis(StringUtils.trimToEmpty(codiceFiscale));
		if(prTUtentiGestori!=null){
			mapper.map(prTUtentiGestori, utentiGestoriModel);
			//carico la  lista enti a lui associati (quasi sempre 1 ente solo)
			utentiGestoriModel.setListaEntiGestori(mapAll(prTUtentiGestori.getPrTEntiGestoris(), EntiGestoriModel.class));		
			//carico il profilo associato all'utente 
			utentiGestoriModel.setProfiliUtentiModel(getProfiloGestorebyCodFis(codiceFiscale));
		}		
		log.stopMethod(methodName);
		return utentiGestoriModel;		
	}
		
	@Override
	public ProfiliUtentiModel getProfiloGestorebyCodFis(String codiceFiscale) {
		String methodName = "getProfiloGestorebyCodFis";
		log.startMethod(methodName);
		log.debug(methodName, "codiceFiscale       " + StringUtils.trimToEmpty(codiceFiscale).toUpperCase());
		PrTProfiliUtenti prTProfiliUtenti = profiUtentiRepository.getProfiloGestorebyCodFis(StringUtils.trimToEmpty(codiceFiscale));
		ProfiliUtentiModel profiloUtentiModel = new ProfiliUtentiModel();
		mapper.map(prTProfiliUtenti, profiloUtentiModel);		
		log.stopMethod(methodName);
		return  profiloUtentiModel;
	}
	
	
	@Override
	public UtentiGestoriModel getUtenteGestorebyId(Long idUtenteSel) {	
		String methodName = "getUtenteGestorebyId";
		log.startMethod(methodName);		
		UtentiGestoriModel utentiGestoriModel= new UtentiGestoriModel();		
		log.debug(methodName, "idUtenteSel       " + idUtenteSel);
		PrTUtentiGestori prTUtentiGestori = utentiGestoriRepository.findOne(idUtenteSel);
		mapper.map(prTUtentiGestori, utentiGestoriModel);		
		PrTProfiliUtenti profili = prTUtentiGestori.getPrTProfiliUtenti();
		ProfiliUtentiModel profiliModel = mapper.map(profili, ProfiliUtentiModel.class);	
		//carico il profilo associato all'utente 
		utentiGestoriModel.setProfiliUtentiModel(profiliModel);		
		log.stopMethod(methodName);
		return utentiGestoriModel;		
	}
		
	@Override
	public UtentiGestoriModel insUtenteGestore(UtentiGestoriModel utentiGestoriModel){
		String methodName = "insUtenteGestore";
		log.startMethod(methodName);		
		PrTUtentiGestori prTUtentiGestori = mapper.map(utentiGestoriModel, PrTUtentiGestori.class);
		PrTProfiliUtenti prTProfiliUtenti = new PrTProfiliUtenti();
		prTProfiliUtenti.setIdProfiloUtente(utentiGestoriModel.getIdProfiloUtente());
		prTUtentiGestori.setPrTProfiliUtenti(prTProfiliUtenti );			
		List<PrTEntiGestori> listaPrTEntiGestoris = new ArrayList<PrTEntiGestori>();
		log.info(methodName, "utentiGestoriModel.getIdEnteGestoreAssociato() " + utentiGestoriModel.getIdEnteGestoreAssociato());
		PrTEntiGestori prTEntiGestori = entiGestoriRepository.findOne(utentiGestoriModel.getIdEnteGestoreAssociato());
		listaPrTEntiGestoris.add(prTEntiGestori);		
		prTUtentiGestori.setPrTEntiGestoris(listaPrTEntiGestoris);
		prTUtentiGestori.setDataAgg(new Date());
		utentiGestoriDAO.create(prTUtentiGestori);		
		log.stopMethod(methodName);
		return utentiGestoriModel;
	}
		
	@Override
	public List<UtentiGestoriModel> getUtentiGestore(String cognome,String nome, String codiceFiscale, String idProfiloUtenteStr,Long idEnteGestore) {
		String methodName="getUtentiGestore";
		log.startMethod(methodName);		
		Long idProfiloUtente =0L;
		if(StringUtils.isNotEmpty(idProfiloUtenteStr)){
			idProfiloUtente =Long.valueOf(idProfiloUtenteStr);
		}		
		log.debug(methodName," " + StringUtils.trimToEmpty(cognome).toUpperCase());
		log.debug(methodName," " + StringUtils.trimToEmpty(nome).toUpperCase());
		log.debug(methodName," " + StringUtils.trimToEmpty(codiceFiscale).toUpperCase());  
		log.debug(methodName," " + idProfiloUtente);		
		
		List<PrTUtentiGestori> listaDA= utentiGestoriDAO.getUtentiGestore( 
																				StringUtils.trimToEmpty(cognome).toUpperCase(),
																				StringUtils.trimToEmpty(nome).toUpperCase(),
																				StringUtils.trimToEmpty(codiceFiscale).toUpperCase(),
																				idProfiloUtente,
																				idEnteGestore																
				);			
		List<UtentiGestoriModel> ris = new ArrayList<UtentiGestoriModel>();	
		for(PrTUtentiGestori sel :listaDA){			
			UtentiGestoriModel elemento = mapper.map(sel, UtentiGestoriModel.class);
			//aggiungo l'oggetto profilo al model
			elemento.setProfiliUtentiModel( mapper.map(sel.getPrTProfiliUtenti(), ProfiliUtentiModel.class));		
			ris.add(elemento);
		}		
		log.debug(methodName, "ris len " + ris.size());
		log.stopMethod(methodName);
		return ris;
	}
	
	private void disattivaAttivaUtenteGestore(Long idUtenteSel,String valore,PrTUtentiGestori entityPassato) {
		String methodName="disattivaAttivaUtenteGestore";
		PrTUtentiGestori entity =entityPassato;
		if(entity==null){
			log.debug(methodName," idUtenteSel" + idUtenteSel);
			entity = utentiGestoriRepository.findOne(idUtenteSel);
		}
		entity.setIdUtenteGestore(idUtenteSel);
		entity.setStato(valore);
		utentiGestoriDAO.update(entity);	
	}
	
	@Override
	public void eliminaUtenteGestore(Long idUtenteSel) {
		String methodName="eliminaUtenteGestore";
		log.startMethod(methodName);		
		log.debug(methodName," idUtenteSel" + idUtenteSel);
		PrTUtentiGestori entity = utentiGestoriRepository.findOne(idUtenteSel);
		utentiGestoriDAO.delete(entity);		
		log.stopMethod(methodName);		
	}
	
	@Override
	public UtentiGestoriModel modificaUtenteGestore(UtentiGestoriModel utentiGestoriModel) {
		String methodName = "modificaUtenteGestore";
		log.startMethod(methodName);	

		PrTUtentiGestori ug = utentiGestoriRepository.findOne(utentiGestoriModel.getIdUtenteGestore());
        List<PrTEntiGestori> listaPrTEntiGestoris = ug.getPrTEntiGestoris();
		
		PrTUtentiGestori prTUtentiGestori = mapper.map(utentiGestoriModel, PrTUtentiGestori.class);		
		//aggiungo il profilo utente 
		PrTProfiliUtenti prTProfiliUtenti = new PrTProfiliUtenti();
		prTProfiliUtenti.setIdProfiloUtente(utentiGestoriModel.getIdProfiloUtente());
		prTUtentiGestori.setPrTProfiliUtenti(prTProfiliUtenti );	
		// aggiungo l'ente associato
		//List<PrTEntiGestori> listaPrTEntiGestoris = new ArrayList<PrTEntiGestori>();
		//PrTEntiGestori prTEntiGestori = entiGestoriRepository.findOne(utentiGestoriModel.getIdEnteGestoreAssociato());
		//listaPrTEntiGestoris.add(prTEntiGestori);
		prTUtentiGestori.setPrTEntiGestoris(listaPrTEntiGestoris);
		utentiGestoriDAO.update(prTUtentiGestori);		
		log.stopMethod(methodName);
		return utentiGestoriModel;
	}
		
	@Override
	public String disattivaAttivaUtenteGestore(Long idUtenteSel) {
		String methodName="disattivaAttivaUtenteGestore";
		log.startMethod(methodName);		
		String ris = Costanti.UTE_DISATTIVO.getCostante();
		String valore=Costanti.DISATTIVO.getCostante();	
		PrTUtentiGestori entity = utentiGestoriRepository.findOne(idUtenteSel);
		log.debug(methodName, "stato sul DB" +entity.getStato());	
		if(entity.getStato().equals(Costanti.DISATTIVO.getCostante())){
			ris = Costanti.UTE_ATTIVO.getCostante();
			valore=Costanti.ATTIVO.getCostante();			
		}
		disattivaAttivaUtenteGestore(idUtenteSel, valore,entity);		
		log.stopMethod(methodName);
		return ris;
	}
	
	@Override
	public List<ProfiliUtentiModel> getProfiliGestore(){
		String methodName = "getProfiliGestore";
		log.startMethod(methodName);	
		List<PrTProfiliUtenti> lista = profiUtentiRepository.getProfiliGestoreAll();
		List<ProfiliUtentiModel> ris = mapAll(lista, ProfiliUtentiModel.class);	
		log.stopMethod(methodName);
		return ris;
	}
		
	@Override
	public List<ProfiliUtentiModel> getProfiliGestore(Long idProfiloUtente){
		String methodName = "getProfiliGestore";
		log.startMethod(methodName);		
		log.debug(methodName," IdProfiloUtente" + idProfiloUtente);
		List<PrTProfiliUtenti> lista = new ArrayList<PrTProfiliUtenti>();				
		if(idProfiloUtente==1L){
			lista = profiUtentiRepository.getProfiliGestoreAll();
		}else if (idProfiloUtente==2L){
			lista = profiUtentiRepository.getProfiliGestoreForAdmin();
		}		
		log.stopMethod(methodName);
		return mapAll(lista, ProfiliUtentiModel.class);
	}
}
