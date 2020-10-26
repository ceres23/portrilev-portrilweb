/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.gestioneUtentiComp;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiCompilatori;
import it.csi.portril.portrilweb.dto.FeedbackError;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.LogUtil;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/gestore/modificaUtentiCompilatoriStep1")
public class ModificaUtentiCompilatoriStep1Controller extends ControllerBase{	
	private  LogUtil log = new LogUtil(getClass());
	@Autowired
	BusinessGestioneUtentiCompilatori businessGestioneUtentiCompilatori;	
	/**
	 * 
	 * @param session
	 * @param model
	 * @param utentiCompilatoriModel
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(HttpSession session,Model model,UtentiCompilatoriModel utentiCompilatoriModel) {
		String methodName="start";
		log.startMethod(methodName);
		Long idUtente = (Long)session.getAttribute(Costanti.ID_UTENTE_COMPILATORE_MOD.getCostante());
		UtentiCompilatoriModel utentiCompilatoriModel1 = businessGestioneUtentiCompilatori.getUtentiCompilatoriById(idUtente);	
		utentiCompilatoriModel1.setIdUtenteCompilatore(idUtente);		
		model.addAttribute("utentiCompilatoriModel",utentiCompilatoriModel1);	
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/modificaUtentiCompilatoriStep1.jsp");
		return "/GestioneUtentiComp/modificaUtentiCompilatoriStep1";
	}
	
	/**
	 * 
	 * @param utentiCompilatoriModel
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="modifica",method = {RequestMethod.POST})	
	public String modifica(@Valid @ModelAttribute UtentiCompilatoriModel utentiCompilatoriModel,BindingResult result,Model model,HttpSession session) {
		String methodName="modifica";
		log.startMethod(methodName);
		//Forzo Nome e cognome dell'utente compilatore a maiuscolo 
		utentiCompilatoriModel.setCodiceFiscale(utentiCompilatoriModel.getCodiceFiscale().toUpperCase());		
		utentiCompilatoriModel.setCognome((utentiCompilatoriModel.getCognome().toUpperCase()));
		utentiCompilatoriModel.setNome(utentiCompilatoriModel.getNome().toUpperCase());
				
		FeedbackError feedback = gestisciSuccessWarningErrors(model,result,"redirect:/gestore/modificaUtentiCompilatoriStep2/start.do","/GestioneUtentiComp/modificaUtentiCompilatoriStep1" );
		if (!feedback.isErrorePresente()){		
			//utentiCompilatoriModel.setIdEnteGestore(super.getIdEnteGestore(session));
			session.setAttribute(Costanti.UTENTE_COMPILATORE.getCostante(),utentiCompilatoriModel);	
			
		}else{	
			log.error(methodName, "Errori di validazione campi");
			log.error(methodName, feedback.toStringErr());
		}
		
		log.stopMethod(methodName+" vado alla pagina " + feedback.getDestinazione());
		return feedback.getDestinazione();		
	}
	
	/**
	 * 
	 * @param session
	 * @param utentiCompilatoriModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value="goToStep1",method = {RequestMethod.GET})	
	public String goToStep1(HttpSession session,@ModelAttribute UtentiCompilatoriModel utentiCompilatoriModel,Model model) {
		String methodName="goToStep1";
		log.startMethod(methodName);
		
		UtentiCompilatoriModel utentiCompilatoriModel1 = (UtentiCompilatoriModel)session.getAttribute(Costanti.UTENTE_COMPILATORE.getCostante());
		model.addAttribute("utentiCompilatoriModel", utentiCompilatoriModel1);
		
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/modificaUtentiCompilatoriStep1.jsp");
		return "/GestioneUtentiComp/modificaUtentiCompilatoriStep1";
	}
	
	/**
	 * 
	 * @param session
	 * @param utentiCompilatoriModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value="goToStep1BySave",method = {RequestMethod.GET})	
	public String goToStep1BySave(HttpSession session,@ModelAttribute UtentiCompilatoriModel utentiCompilatoriModel,Model model) {
		String methodName="goToStep1BySave";
		log.startMethod(methodName);			
		addOneMsgSuccess(model, Costanti.MSG_UTENTE_COMP_OK.getCostante());
		UtentiCompilatoriModel utentiCompilatoriModel1 = (UtentiCompilatoriModel)session.getAttribute(Costanti.UTENTE_COMPILATORE.getCostante());
		model.addAttribute("utentiCompilatoriModel", utentiCompilatoriModel1);	
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/modificaUtentiCompilatoriStep1.jsp");
		return "/GestioneUtentiComp/modificaUtentiCompilatoriStep1";
	}
		
	/**
	 * 
	 * @param utentiCompilatoriModel
	 * @return
	 */
	@ModelAttribute("utentiCompilatoriModel")
	public UtentiCompilatoriModel utentiCompilatoriModel(UtentiCompilatoriModel utentiCompilatoriModel) {
		return utentiCompilatoriModel;
	}
	
	/**
	 * resetta tutti i campi del form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="clean",method = {RequestMethod.POST})	
	public String clean(HttpSession session,Model model,UtentiCompilatoriModel utentiCompilatoriModel) {
		String methodName="clean";
		log.startMethod(methodName);		
		//model.addAttribute("utentiCompilatoriModel", new UtentiCompilatoriModel());
		Long idUtente = (Long)session.getAttribute(Costanti.ID_UTENTE_COMPILATORE_MOD.getCostante());
		UtentiCompilatoriModel utentiCompilatoriModel1 = businessGestioneUtentiCompilatori.getUtentiCompilatoriById(idUtente);	
		utentiCompilatoriModel1.setIdUtenteCompilatore(idUtente);
		model.addAttribute("utentiCompilatoriModel",utentiCompilatoriModel1);
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/modificaUtentiCompilatoriStep1.jsp");
		return "/GestioneUtentiComp/modificaUtentiCompilatoriStep1";
	}
}
