/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.gestioneUtentiGest;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiGestori;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.ProfiliUtentiModel;
import it.csi.portril.portrilweb.model.RicercaUtentiGestoriModel;
import it.csi.portril.portrilweb.model.UtentiGestoriModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiWARN;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/gestore/ricercaUtentiGestori")
public class RicercaUtentiGestoriController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneUtentiGestori bmGestioneUtentiGestori;
	
	
	/**
	 * 
	 * @param ricercaUtentiGestoriModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(RicercaUtentiGestoriModel ricercaUtentiGestoriModel, HttpSession session,Model model) {
		String methodName="start";
		log.startMethod(methodName);
		
		List<ProfiliUtentiModel> listaProfili = (List<ProfiliUtentiModel>)session.getAttribute(Costanti.LISTA_PROFILI_UTENTI_GESTORI_ALL.getCostante());

		if(CollectionUtils.isEmpty(listaProfili)){
			listaProfili = bmGestioneUtentiGestori.getProfiliGestore();
			log.info(methodName, "lista len " + listaProfili.size());
			session.setAttribute(Costanti.LISTA_PROFILI_UTENTI_GESTORI_ALL.getCostante(),listaProfili);					
		}
		
		ricercaUtentiGestoriModel.setListaProfili(listaProfili);
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiGest/ricercaUtentiGestori.jsp");
		return "/GestioneUtentiGest/ricercaUtentiGestori";
	}


	/**
	 * 
	 * @param ricercaUtentiGestoriModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricerca",method = {RequestMethod.POST})	
	public String ricerca(@ModelAttribute RicercaUtentiGestoriModel ricercaUtentiGestoriModel,Model model,HttpSession session) {
		String methodName="ricerca";
		log.startMethod(methodName);
		
		Long idEnteGestore = getIdEnteGestore(session);
		//carico la lista dei profili dalla sessione 
		ricercaUtentiGestoriModel.setListaProfili( (List<ProfiliUtentiModel>)session.getAttribute(Costanti.LISTA_PROFILI_UTENTI_GESTORI_ALL.getCostante()));	
		
		List<UtentiGestoriModel> listaUtentiGestori = bmGestioneUtentiGestori.getUtentiGestore(ricercaUtentiGestoriModel.getCognome(),ricercaUtentiGestoriModel.getNome(),ricercaUtentiGestoriModel.getCodiceFiscale(),ricercaUtentiGestoriModel.getStrIdProfiloUtente(),idEnteGestore);		

		List<ProfiliUtentiModel> listaProfili = (List<ProfiliUtentiModel>)session.getAttribute(Costanti.LISTA_PROFILI_UTENTI_GESTORI_ALL.getCostante());
		ricercaUtentiGestoriModel.setListaProfili(listaProfili);

		if(CollectionUtils.isEmpty(listaUtentiGestori)){
			addOneMsgWarning(model,CostantiWARN.RICERCA0.getCostante() );			
		}
		// test in base al massimo numero di risultati che voglio esporre 
		// se il test da esito negativo 
		if(listaUtentiGestori.size()> Integer.parseInt(Costanti.NUM_MAX_RIC.getCostante())){
			addOneMsgWarning(model,CostantiWARN.WAR_RIC.getCostante() );
		}else{
			ricercaUtentiGestoriModel.setListaUtentiGestori(listaUtentiGestori);		
		}
		
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiGest/ricercaUtentiGestori.jsp");
		return "/GestioneUtentiGest/ricercaUtentiGestori";
	}
	

	/**
	 * 
	 * @param ricercaUtentiGestoriModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="cancellaUtenteGestore",method = {RequestMethod.POST})	
	public String cancellaUtenteGestore(@ModelAttribute RicercaUtentiGestoriModel ricercaUtentiGestoriModel,Model model,HttpSession session) {
		String methodName="cancellaUtenteGestore";
		log.startMethod(methodName);
		log.info(methodName, "selezionato " + ricercaUtentiGestoriModel.getIdUtenteSel());
		
		try{
			bmGestioneUtentiGestori.eliminaUtenteGestore(ricercaUtentiGestoriModel.getIdUtenteSel());
			buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "cancella  utente gestore con idutente " +ricercaUtentiGestoriModel.getIdUtenteSel());

		} catch(RuntimeException re) {
			super.gestisciEccezioneEliminaRecordConFigli(re, model,Costanti.UTENTE_GESTORE_NODEL.getCostante());
		}
		
		addOneMsgSuccess(model, Costanti.CANCELLAZIONE_OK.getCostante());
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiGest/ricercaUtentiGestori.jsp");
		return ricerca(ricercaUtentiGestoriModel, model, session);
	}

	
	/**
	 * 
	 * @param ricercaUtentiGestoriModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="disattivaAttivaUtenteGestore",method = {RequestMethod.POST})	
	public String disattivaAttivaUtenteGestore(@ModelAttribute RicercaUtentiGestoriModel ricercaUtentiGestoriModel,Model model,HttpSession session) {
		String methodName="disattivaAttivaUtenteGestore";
		log.startMethod(methodName);

		log.debug(methodName, "selezionato " + ricercaUtentiGestoriModel.getIdUtenteSel());			
		String msg = bmGestioneUtentiGestori.disattivaAttivaUtenteGestore(ricercaUtentiGestoriModel.getIdUtenteSel());
		
		addOneMsgSuccess(model,msg);
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiGest/ricercaUtentiGestori.jsp");
			
		return ricerca(ricercaUtentiGestoriModel, model, session);
	}
	

	/**
	 * 
	 * @param ricercaUtentiGestoriModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="modificaUtenteGestore",method = {RequestMethod.POST})	
	public String modificaUtenteGestore(@ModelAttribute RicercaUtentiGestoriModel ricercaUtentiGestoriModel,Model model,HttpSession session) {
		String methodName="modificaUtenteGestore";
		log.startMethod(methodName);

		log.info(methodName, "selezionato " + ricercaUtentiGestoriModel.getIdUtenteSel());	
		session.setAttribute(Costanti.ID_UTENTE_GESTORE_MOD.getCostante(), ricercaUtentiGestoriModel.getIdUtenteSel());
		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/modificaUtenteGestore/start.do");
		return "redirect:/gestore/modificaUtenteGestore/start.do";
	}

	/**
	 * resetta tutti i campi del form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="clean",method = {RequestMethod.POST})	
	public String clean(Model model,HttpSession session) {
		String methodName="clean";
		log.startMethod(methodName);
		
		RicercaUtentiGestoriModel ricercaUtentiGestoriModel = new RicercaUtentiGestoriModel((List<ProfiliUtentiModel>)session.getAttribute(Costanti.LISTA_PROFILI_UTENTI_GESTORI_ALL.getCostante()));
		model.addAttribute("ricercaUtentiGestoriModel", ricercaUtentiGestoriModel);
		
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiGest/ricercaUtentiGestori.jsp");
		return "/GestioneUtentiGest/ricercaUtentiGestori";
	}

}

