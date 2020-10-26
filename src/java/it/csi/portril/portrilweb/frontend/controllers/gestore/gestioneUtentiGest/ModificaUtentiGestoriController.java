/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.gestioneUtentiGest;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiGestori;
import it.csi.portril.portrilweb.dto.FeedbackError;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.ProfiliUtentiModel;
import it.csi.portril.portrilweb.model.UtentiGestoriModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.List;

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
@RequestMapping("/gestore/modificaUtenteGestore")
public class ModificaUtentiGestoriController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneUtentiGestori bmGestioneUtentiGestori;
	
	
	/**
	 * 
	 * @param utentiGestoriModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute UtentiGestoriModel utentiGestoriModel,HttpSession session,Model model) {
		String methodName="start";
		log.startMethod(methodName);
		UtentiGestoriModel utenteConnesso =super.getUtenteGestoreConnesso( session) ;
		Long idUtenteSel = (Long)session.getAttribute(Costanti.ID_UTENTE_GESTORE_MOD.getCostante());
		log.debug(methodName, "selezionato IdUtenteSel" + idUtenteSel);		
		utentiGestoriModel = bmGestioneUtentiGestori.getUtenteGestorebyId(idUtenteSel);
		log.debug(methodName, "selezionato profilo utente " + utentiGestoriModel.getIdProfiloUtente());	
		model.addAttribute(utentiGestoriModel);	
		// carico la lista dei profili possibili per l'utente gestore 
		// se non presente viene calcolata e salvata in sessione
		List<ProfiliUtentiModel> lista = (List<ProfiliUtentiModel>)session.getAttribute(Costanti.LISTA_PROFILI_UTENTI_GESTIONE.getCostante());
		if(lista==null){
			lista = bmGestioneUtentiGestori.getProfiliGestore(utenteConnesso.getProfiliUtentiModel().getIdProfiloUtente());
			session.setAttribute(Costanti.LISTA_PROFILI_UTENTI_GESTIONE.getCostante(),lista);			
			model.addAttribute(Costanti.LISTA_PROFILI_UTENTI_GESTIONE.getCostante(),lista);
		}				
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiGest/modificaUtenteGestore.jsp");
		return "/GestioneUtentiGest/modificaUtenteGestore";
	}

	/**
	 * 
	 * @param utentiGestoriModel
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="modificaUtente",method = {RequestMethod.POST})	
	public  String modificaUtenteGestore(@Valid @ModelAttribute UtentiGestoriModel utentiGestoriModel, BindingResult result,Model model,HttpSession session) {
		String methodName="modificaUtenteGestore";
		log.startMethod(methodName);									
        FeedbackError feedback = gestisciSuccessWarningErrors(model,result,"/GestioneUtentiGest/modificaUtenteGestore" );		
		if (!feedback.isErrorePresente()){								
			utentiGestoriModel.setIdEnteGestoreAssociato(super.getIdEnteGestore(session));
			bmGestioneUtentiGestori.modificaUtenteGestore(utentiGestoriModel);
			buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "modifica utente gestore con idutente " +utentiGestoriModel.getIdUtenteGestore());

		}else{	
			log.error(methodName, feedback.toStringErr());
		}							
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiGest/modificaUtenteGestore.jsp");
		return "/GestioneUtentiGest/modificaUtenteGestore";
	}

	
	/**
	 * resetta tutti i campi del form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="clean",method = RequestMethod.POST)	
	public String clean(@ModelAttribute UtentiGestoriModel utentiGestoriModel,Model model,HttpSession session) {
		String methodName="clean";
		log.startMethod(methodName);		
		Long idUtenteSel = (Long)session.getAttribute(Costanti.ID_UTENTE_GESTORE_MOD.getCostante());
		log.debug(methodName, "selezionato IdUtenteSel" + idUtenteSel);			
		UtentiGestoriModel utentiGestoriModel1 = bmGestioneUtentiGestori.getUtenteGestorebyId(idUtenteSel);
		log.debug(methodName, "selezionato profilo utente " + utentiGestoriModel1.getIdProfiloUtente());	
		model.addAttribute("utentiGestoriModel" , utentiGestoriModel1);
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiGest/modificaUtenteGestore.jsp");
		return "/GestioneUtentiGest/modificaUtenteGestore";
	}
	
	/**
	 * 
	 * @param utentiGestoriModel
	 * @return
	 */
	@ModelAttribute("utentiGestoriModel")
	public UtentiGestoriModel utentiGestoriModel(UtentiGestoriModel utentiGestoriModel) {
		return  utentiGestoriModel;
	}

}	