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
import it.csi.portril.portrilweb.util.CostantiERR;
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
@RequestMapping("/accessocompilatore/autoInserimentoUtentiCompilatoriStep1")
public class AutoInserimentoUtentiCompilatoriStep1Controller extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());	
	@Autowired
	protected BusinessGestioneUtentiCompilatori bmGestioneUtentiCompilatori;

	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);		
		session.setAttribute(Costanti.UTENTE_COMPILATORE.getCostante(),new UtentiCompilatoriModel());		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/autoInserimentoUtentiCompilatoriStep1.jsp");
		return "/GestioneProfilo/autoInserimentoUtentiCompilatoriStep1";
	}

	/**
	 * 
	 * @param session
	 * @param utentiCompilatoriModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value="goToStep1BySave",method = {RequestMethod.POST})	
	public String goToStep1BySave(HttpSession session,@ModelAttribute UtentiCompilatoriModel utentiCompilatoriModel,Model model) {
		String methodName="goToStep1BySave";
		log.startMethod(methodName);				
		addOneMsgSuccess(model, Costanti.MSG_UTENTE_COMP_OK.getCostante());		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/autoInserimentoUtentiCompilatoriStep1.jsp");
		return "/GestioneProfilo/autoInserimentoUtentiCompilatoriStep1";
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
		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/autoInserimentoUtentiCompilatoriStep1.jsp");
		return "/GestioneProfilo/autoInserimentoUtentiCompilatoriStep1";
	}
	
	/**
	 * 
	 * @param utentiCompilatoriModel
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="inserisciStep1",method = {RequestMethod.POST})	
	public String inserisci(@Valid @ModelAttribute UtentiCompilatoriModel utentiCompilatoriModel,BindingResult result,Model model,HttpSession session) {
		String methodName="inserisciStep1";
		log.startMethod(methodName);		
		FeedbackError feedback = gestisciSuccessWarningErrors(model,result,"redirect:/accessocompilatore/autoInserimentoUtentiCompilatoriStep2/start.do","/GestioneProfilo/autoInserimentoUtentiCompilatoriStep1" );
		log.error(methodName, "trattamento dati obbligatorio " + utentiCompilatoriModel.getTrattamentoDati());
		//Forzo Nome e cognome dell'utente compilatore a maiuscolo 
		utentiCompilatoriModel.setCodiceFiscale(utentiCompilatoriModel.getCodiceFiscale().toUpperCase());		
		utentiCompilatoriModel.setCognome((utentiCompilatoriModel.getCognome().toUpperCase()));
		utentiCompilatoriModel.setNome(utentiCompilatoriModel.getNome().toUpperCase());	
		if(utentiCompilatoriModel.getTrattamentoDati()!=null && utentiCompilatoriModel.getTrattamentoDati().equals("OK")){
			if (!feedback.isErrorePresente()){	
				UtentiCompilatoriModel ute = bmGestioneUtentiCompilatori.getUtenteCompilatoriByCodiceFiscale(utentiCompilatoriModel.getCodiceFiscale().toUpperCase());
				//controllo che l'utente sia esistente o meno
				if(ute==null){
					//utentiCompilatoriModel.setIdEnteGestore(super.getIdEnteGestore(session));
					session.setAttribute(Costanti.UTENTE_COMPILATORE.getCostante(),utentiCompilatoriModel);	
				}else{
					log.error(methodName, "Utente gia mappato " + ute.getCodiceFiscale());
					addOneMsgError(model, CostantiERR.ERR_UTENTE_INSERITO.getCostante());
					feedback.setDestinazione("/GestioneProfilo/autoInserimentoUtentiCompilatoriStep1");						
				}
			}else{	
				log.error(methodName, "Errori di validazione campi");
				log.error(methodName, feedback.toStringErr());
			}
		}else{
			log.error(methodName, "Trattamento dati obbligatorio");
			addOneMsgError(model, CostantiERR.ERR_DATI_PERS.getCostante());
			feedback.setDestinazione("/GestioneProfilo/autoInserimentoUtentiCompilatoriStep1");			
		}		
		log.stopMethod(methodName+" vado alla pagina " + feedback.getDestinazione());
		return feedback.getDestinazione();		
	}
		
	/**
	 * resetta tutti i campi del form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="clean",method = {RequestMethod.POST})	
	public String clean(Model model) {
		String methodName="clean";
		log.startMethod(methodName);		
		model.addAttribute("utentiCompilatoriModel", new UtentiCompilatoriModel());	
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/autoInserimentoUtentiCompilatoriStep1.jsp");
		return "/GestioneProfilo/autoInserimentoUtentiCompilatoriStep1";
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
}
