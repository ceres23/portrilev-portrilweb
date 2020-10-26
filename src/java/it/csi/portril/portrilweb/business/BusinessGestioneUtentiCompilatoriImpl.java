/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiCompilatori;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTModuloMailInvitiDAO;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTUtentiCompilatoriDAO;
import it.csi.portril.portrilweb.integration.entity.PrTEntiCompilatori;
import it.csi.portril.portrilweb.integration.entity.PrTProfiliUtenti;
import it.csi.portril.portrilweb.integration.entity.PrTUtentiCompilatori;
import it.csi.portril.portrilweb.integration.repository.EntiCompilatoriRepository;
import it.csi.portril.portrilweb.integration.repository.ProfiUtentiRepository;
import it.csi.portril.portrilweb.integration.repository.UtentiCompilatoriRepository;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.RicercaUtentiCompilatoriModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriStep2Model;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.mail.MailSender;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;

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
public class BusinessGestioneUtentiCompilatoriImpl extends BusinessManagerBase implements BusinessGestioneUtentiCompilatori{

	@Autowired
	PrTModuloMailInvitiDAO prTModuloMailInvitiDAO;
	
	@Autowired
	private PrTUtentiCompilatoriDAO utentiCompilatoriDAO;

	@Autowired
	private UtentiCompilatoriRepository utentiCompilatoriRepository;
	
	@Autowired
	private EntiCompilatoriRepository entiCompilatoriRepository;
	
	@Autowired
	private ProfiUtentiRepository profiliRepository;

	public final static String PROP = "/parametriMail.properties";

	
	@Override
	public UtentiCompilatoriModel insUtenteCompilatore(UtentiCompilatoriModel utentiCompilatoriModel,List<EntiCompilatoriModel> listaEntiAssociati,Integer prog){
		String methodName="insUtenteCompilatore";
		log.startMethod(methodName);
		PrTUtentiCompilatori prTUtentiCompilatori = new PrTUtentiCompilatori();		
		// aggiungo all'utente la sua login composta dai suoi primi 2 caratteri del nome 2 del cognome piu' una costante ed eventualmente un progressivo
		String login = utentiCompilatoriModel.getNome().substring(0,2).toUpperCase() + utentiCompilatoriModel.getCognome().substring(0,2).toUpperCase() + "_" + prog;
		utentiCompilatoriModel.setLogin(login);
		utentiCompilatoriModel.setPassword(login);
		mapper.map(utentiCompilatoriModel, prTUtentiCompilatori);
		prTUtentiCompilatori.setLogin(login);
		prTUtentiCompilatori.setPassword(login);
		// aggiungo all'utente il suo profilo da compilatore
		PrTProfiliUtenti prTProfiliUtenti = new PrTProfiliUtenti();
		prTProfiliUtenti.setIdProfiloUtente(utentiCompilatoriModel.getIdProfiloUtente());
		prTUtentiCompilatori.setPrTProfiliUtenti(prTProfiliUtenti );		
		if(listaEntiAssociati!=null){
			List<PrTEntiCompilatori> lista = mapAll(listaEntiAssociati, PrTEntiCompilatori.class);
			prTUtentiCompilatori.setPrTEntiCompilatoris(lista);
		}
		prTUtentiCompilatori.setDataAgg(new Date());
		utentiCompilatoriDAO.create(prTUtentiCompilatori);
		log.stopMethod(methodName);
		return utentiCompilatoriModel;
	}

	@Override
	public List<UtentiCompilatoriModel> getUtentiCompilatori(RicercaUtentiCompilatoriModel ricercaUtentiCompilatoriModel) {
		String methodName="getUtentiCompilatori";
		log.startMethod(methodName);		
		log.debug(methodName, " " +ricercaUtentiCompilatoriModel.getIdEnteGestore());
		log.debug(methodName, " " +StringUtils.trimToEmpty(ricercaUtentiCompilatoriModel.getNome()).toUpperCase());
		log.debug(methodName, " " +StringUtils.trimToEmpty(ricercaUtentiCompilatoriModel.getCognome()).toUpperCase());
		log.debug(methodName, " " +StringUtils.trimToEmpty(ricercaUtentiCompilatoriModel.getCodiceFiscale()).toUpperCase());		
		List<PrTUtentiCompilatori> listaDa = utentiCompilatoriDAO.getUtentiCompilatori(
																ricercaUtentiCompilatoriModel.getIdEnteGestore(),
																ricercaUtentiCompilatoriModel.getNome().toUpperCase(),
																ricercaUtentiCompilatoriModel.getCognome().toUpperCase(),
																ricercaUtentiCompilatoriModel.getCodiceFiscale().toUpperCase()												);
		List<UtentiCompilatoriModel> ris = mapAll(listaDa, UtentiCompilatoriModel.class);	
		log.stopMethod(methodName);
		return ris;
	}
	
	@Override
	public String disattivaAttivaUtenteCompilatore(Long idUtenteSel) {
		String methodName="disattivaAttivaUtenteCompilatore";
		log.startMethod(methodName);		
		String ris = Costanti.UTE_DISATTIVO.getCostante();
		String valore=Costanti.DISATTIVO.getCostante();
		log.debug(methodName, "idUtenteSel " +idUtenteSel);
		PrTUtentiCompilatori entity = utentiCompilatoriRepository.findOne(idUtenteSel);
		log.debug(methodName, "stato sul DB" +entity.getStato());	
		if(entity.getStato().equals(Costanti.DISATTIVO.getCostante())){
			ris = Costanti.UTE_ATTIVO.getCostante();
			valore=Costanti.ATTIVO.getCostante();			
		}		
		disattivaAttivaUtenteCompilatore(idUtenteSel, valore,entity);		
		log.stopMethod(methodName);
		return ris;
	}
	
	private void disattivaAttivaUtenteCompilatore(Long idUtenteSel,String valore,PrTUtentiCompilatori entityPassato) {
		PrTUtentiCompilatori entity =entityPassato;
		if(entity==null){
			log.debug("disattivaAttivaUtenteCompilatore", "idUtenteSel " +idUtenteSel);
			entity = utentiCompilatoriRepository.findOne(idUtenteSel);
		}
		entity.setIdUtenteCompilatore(idUtenteSel);
		entity.setStato(valore);
		utentiCompilatoriDAO.update(entity);		
	}
		
	@Override
	public UtentiCompilatoriModel modificaUtenteCompilatore(UtentiCompilatoriStep2Model utentiCompilatoriStep2Model) {
		String methodName = "modificaUtenteCompilatore";
		log.startMethod(methodName);
		UtentiCompilatoriModel utentiCompilatoriModel = utentiCompilatoriStep2Model.getUtentiCompilatoriModel();		
		log.debug("disattivaAttivaUtenteCompilatore", "utentiCompilatoriModel.getIdUtenteCompilatore() " +utentiCompilatoriModel.getIdUtenteCompilatore());
		PrTUtentiCompilatori entity = utentiCompilatoriRepository.findOne(utentiCompilatoriModel.getIdUtenteCompilatore());
		// ho usato questa soluzione per non rimappare i campi nulli
		mapper.map(utentiCompilatoriModel, entity,"UtentiCompilatoriModel_PrTUtentiCompilatori_UPDATE");			
		//aggiungo la lista enti collegati
		List<EntiCompilatoriModel> listaEntiAssociati = utentiCompilatoriStep2Model.getListaEntiAssociati();			
		List<PrTEntiCompilatori> listaprTEntiCompilatoris = mapAll(listaEntiAssociati,PrTEntiCompilatori.class);	
		entity.setPrTEntiCompilatoris(listaprTEntiCompilatoris);
		// aggiungo all'utente il suo profilo da compilatore		
		log.debug(methodName, "utentiCompilatoriStep2Model.getUtentiCompilatoriModel().getIdProfiloUtente()  " + utentiCompilatoriStep2Model.getUtentiCompilatoriModel().getIdProfiloUtente());
		PrTProfiliUtenti prTProfiliUtenti =profiliRepository.findOne(utentiCompilatoriStep2Model.getUtentiCompilatoriModel().getIdProfiloUtente());
		entity.setPrTProfiliUtenti(prTProfiliUtenti );	
		log.stopMethod(methodName);
		return utentiCompilatoriModel;
	}

	@Override
	public UtentiCompilatoriModel getUtentiCompilatoriById(Long idUtenteSel) {
		String methodName="getUtentiCompilatoriById";
		log.startMethod(methodName);
		log.debug(methodName, "idUtenteSel " +idUtenteSel);
		PrTUtentiCompilatori entity = utentiCompilatoriRepository.findOne(idUtenteSel);
		UtentiCompilatoriModel ris = mapper.map(entity,UtentiCompilatoriModel.class);
		ris.setIdProfiloUtente(entity.getPrTProfiliUtenti().getIdProfiloUtente());		
		log.stopMethod(methodName);
		return ris;
	}

	@Override
	public List<EntiCompilatoriModel> getListaEntiUtentiCompilatoriByIdUtente(Long idUtenteSel) {
		String methodName="getListaEntiUtentiCompilatoriByIdUtente";
		log.startMethod(methodName);		
		log.debug(methodName, "idUtenteSel " +idUtenteSel);
		PrTUtentiCompilatori entity = utentiCompilatoriRepository.findOne(idUtenteSel);
		List<PrTEntiCompilatori> listaEnti = entity.getPrTEntiCompilatoris();
		List<EntiCompilatoriModel> ris = mapAll(listaEnti, EntiCompilatoriModel.class);	
		log.stopMethod(methodName);
		return ris;
	}
	
	@Override
	public void eliminaUtenteCompilatore(Long idUtenteSel) {
		String methodName="eliminaUtenteCompilatore";
		log.startMethod(methodName);
		log.debug(methodName, "idUtenteSel " +idUtenteSel);
		PrTUtentiCompilatori entity = utentiCompilatoriRepository.findOne(idUtenteSel);
		utentiCompilatoriDAO.delete(entity);		
		log.stopMethod(methodName);				
	}

	@Override
	public String setCredenziali(String email, String loginReg,String passwordReg) {
		String methodName="setCredenziali";
		log.startMethod(methodName);	
		String ris="";
		log.debug(methodName, "email       " + email);
		log.debug(methodName, "loginReg    " + loginReg);
		log.debug(methodName, "passwordReg " + passwordReg);		
		PrTUtentiCompilatori uten = utentiCompilatoriRepository.getUtenteCompilatoreByEmail(email);
		if(uten==null){
			ris = CostantiERR.ERR_MAIL_NON_PRESENTE.getCostante();
		}else{
			uten.setLogin(loginReg);
			uten.setPassword(passwordReg);
		}		
		log.stopMethod(methodName);
		return ris;
	}

	@Override
	public List<EntiCompilatoriModel> getListaEntiCompilatoriByUtente(Long idUtenteCompilatoreConnesso) {
		PrTUtentiCompilatori ute = utentiCompilatoriRepository.findOne(idUtenteCompilatoreConnesso);
		List<PrTEntiCompilatori> listEnti = ute.getPrTEntiCompilatoris();
		return mapAll(listEnti,EntiCompilatoriModel.class);
	}

	@Override
	public UtentiCompilatoriModel getUtenteCompilatoriByCodiceFiscale(String codiceFiscale) {
		String methodName="getUtentiCompilatoriById";
		log.startMethod(methodName);		
		UtentiCompilatoriModel ris = null;
		log.debug(methodName, "codiceFiscale       " + codiceFiscale);
		PrTUtentiCompilatori entity = utentiCompilatoriRepository.getUtenteCompilatoriByCodiceFiscale(codiceFiscale.toUpperCase());	
		if(entity!=null){
			ris = mapper.map(entity,UtentiCompilatoriModel.class);
			ris.setIdProfiloUtente(entity.getPrTProfiliUtenti().getIdProfiloUtente());
		}		
		log.stopMethod(methodName);
		return ris;
	}

	@Override
	public void invioMailDaInserimentoUtenteCompilatore (   String mailDest,String Nome ,String cognome,String login,
															String password)
															throws MessagingException {
		String methodName="invioMailDaInserimentoUtenteCompilatore";
		log.startMethod(methodName);		
		Properties props = new Properties();
		try {
			props.load(this.getClass().getResourceAsStream(PROP));
		} catch (IOException e) {
			log.error(methodName,e);
		}	 	
		String mailTo         = props.getProperty("MAILTO");	
		String oggMail        = props.getProperty("OGGETTO_AUTOREGISTRAZIONE");		
		String descMailModulo = props.getProperty("TESTO_AUTOREGISTRAZIONE");
		descMailModulo = descMailModulo.replace("@USER@",login);
		descMailModulo = descMailModulo.replace("@PW@", password);
		MailSender mailSender = new MailSender();
		mailSender.inviaMail(mailTo,oggMail, descMailModulo, mailDest);		
		log.stopMethod(methodName);	
	}
	
	@Override
	public UtentiCompilatoriModel getUtenteCompilatoreFittizioByIdEnteGestore(Long idEnteGestore) {
		String methodName="getUtenteCompilatoreFittizioByIdEnteGestore";
		log.startMethod(methodName);
		log.info(methodName, "idEnteGestore " + idEnteGestore);
		PrTUtentiCompilatori prTUtentiCompilatori = utentiCompilatoriRepository.getUtenteCompilatoreFittizioByIdEnteGestore();
		log.info(methodName, "dopo prTUtentiCompilatori ");
		log.info(methodName, "prTUtentiCompilatori " + prTUtentiCompilatori.getIdUtenteCompilatore());
		UtentiCompilatoriModel ris = mapper.map(prTUtentiCompilatori, UtentiCompilatoriModel.class); 		
		log.stopMethod(methodName);	
		return ris;
	}
	/*
	@Override
	public void invioMailDaInserimentoUtenteCompilatore (
															String mailTo,String mailDest,String Nome ,String cognome,String login,
															String password, List<EntiCompilatoriModel> listaEntiComp)
															throws MessagingException {
		String methodName="invioMailDaInserimentoUtenteCompilatore";
		log.startMethod(methodName);
		
		Properties props = new Properties();
		try {
			props.load(this.getClass().getResourceAsStream(PROP));
		} catch (IOException e) {
			log.error(methodName,e);
		}	 	
		String oggMail        = props.getProperty("OGGETTO_AUTOREGISTRAZIONE");		
		String descMailModulo = props.getProperty("TESTO_AUTOREGISTRAZIONE");
		descMailModulo = descMailModulo.replace("@USER@",login);
		descMailModulo = descMailModulo.replace("@PW@", password);	
		MailSender mailSender = new MailSender();
		mailSender.inviaMail(mailTo,oggMail, descMailModulo, mailDest);		
		log.stopMethod(methodName);	
	}
	*/
}
