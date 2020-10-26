/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.compilatore.gestioneProfilo;

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
@RequestMapping("/compilatore/modificaProfiloUtenteCompilatoreStep1")
public class ModificaProfiloUtenteCompilatoreStep1Controller extends ControllerBase{
	
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
	@RequestMapping(value="start",method = {RequestMethod.GET,RequestMethod.POST})	
	//@RequestMapping(value="start")	
	public String start(HttpSession session,Model model,UtentiCompilatoriModel utentiCompilatoriModel) {
		String methodName="start";
		log.startMethod(methodName);
		model.addAttribute(super.getUtenteCompilatoreConnesso(session));	
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/modProfiloStep1.jsp");
		return "/GestioneProfilo/modProfiloStep1";
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

		//Forzo Nome e cognome dell'utente compilatore maiuscolo 
		utentiCompilatoriModel.setCodiceFiscale(utentiCompilatoriModel.getCodiceFiscale().toUpperCase());		
		utentiCompilatoriModel.setCognome((utentiCompilatoriModel.getCognome().toUpperCase()));
		utentiCompilatoriModel.setNome(utentiCompilatoriModel.getNome().toUpperCase());
				
		FeedbackError feedback = gestisciSuccessWarningErrors(model,result,"redirect:/compilatore/modificaProfiloUtenteCompilatoreStep2/start.do","/GestioneProfilo/modProfiloStep1" );
		if (!feedback.isErrorePresente()){				
			session.setAttribute(Costanti.UTENTE_COMPILATORE_TMP.getCostante(),utentiCompilatoriModel);	
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
	@RequestMapping(value="accessoDiRitornodaStep2",method = {RequestMethod.POST})	
	public String accessoDiRitornodaStep2(HttpSession session,@ModelAttribute UtentiCompilatoriModel utentiCompilatoriModel,Model model) {
		String methodName="accessoDiRitornodaStep2";
		log.startMethod(methodName);		
		UtentiCompilatoriModel utentiCompilatoriModel1 = (UtentiCompilatoriModel)session.getAttribute(Costanti.UTENTE_COMPILATORE.getCostante());
		model.addAttribute("utentiCompilatoriModel", utentiCompilatoriModel1);		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/modProfiloStep1.jsp");
		return "/GestioneProfilo/modProfiloStep1";
	}

	
	/**
	 * 
	 * @param session
	 * @param utentiCompilatoriModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value="tornaAlloStep1",method = {RequestMethod.GET,RequestMethod.POST})	
	public String tornaAlloStep1(HttpSession session,@ModelAttribute UtentiCompilatoriModel utentiCompilatoriModel,Model model) {
		String methodName="tornaAlloStep1";
		log.startMethod(methodName);
				
		addOneMsgSuccess(model, Costanti.MSG_UTENTE_COMP_OK.getCostante());
		model.addAttribute(super.getUtenteCompilatoreConnesso(session));
		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/modProfiloStep1.jsp");
		return "/GestioneProfilo/modProfiloStep1";
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
	 * resetta i campidel form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="clean",method = {RequestMethod.POST})	
	public String clean(HttpSession session,Model model) {
		String methodName="clean";
		log.startMethod(methodName);
		
		model.addAttribute(super.getUtenteCompilatoreConnesso(session));

		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/modProfiloStep1.jsp");
		return "/GestioneProfilo/modProfiloStep1";
	}
	
}
