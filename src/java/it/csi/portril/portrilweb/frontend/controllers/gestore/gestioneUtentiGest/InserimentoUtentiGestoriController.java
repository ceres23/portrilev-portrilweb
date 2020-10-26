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
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/gestore/inserimentoUtentiGestori")
public class InserimentoUtentiGestoriController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneUtentiGestori bmGestioneUtentiGestori;
	
	
	/**
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(HttpSession session,Model model) {
		String methodName="start";
		log.startMethod(methodName);
		UtentiGestoriModel utenteConnesso = super.getUtenteGestoreConnesso( session) ;
		
		// carico la lista dei profili possibili per l'utente gestore 
		// se non presente viene calcolata e salvata in sessione
		List<ProfiliUtentiModel> lista = (List<ProfiliUtentiModel>)session.getAttribute(Costanti.LISTA_PROFILI_UTENTI_GESTIONE.getCostante());

		if(lista==null){
			lista = bmGestioneUtentiGestori.getProfiliGestore(utenteConnesso.getProfiliUtentiModel().getIdProfiloUtente());
			log.debug(methodName, "lista len " + lista.size());
			session.setAttribute(Costanti.LISTA_PROFILI_UTENTI_GESTIONE.getCostante(),lista);			
			model.addAttribute(Costanti.LISTA_PROFILI_UTENTI_GESTIONE.getCostante(),lista);
		}
		
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiGest/inserimentoUtentiGestori.jsp");
		return "/GestioneUtentiGest/inserimentoUtentiGestori";
	}


	/**
	 * 
	 * @param utentiGestoriModel
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="inserisci",method = {RequestMethod.POST})	
	public String inserisci(@Valid @ModelAttribute UtentiGestoriModel utentiGestoriModel, BindingResult result,Model model,HttpSession session) {
		String methodName="inserisci";
		log.startMethod(methodName);			
						
        FeedbackError feedback = gestisciSuccessWarningErrors(model,result,"/GestioneUtentiGest/inserimentoUtentiGestori" );		
		if (!feedback.isErrorePresente()){	

			UtentiGestoriModel uteGest = bmGestioneUtentiGestori.getUtenteGestorebyCodFis(utentiGestoriModel.getCodiceFiscale());
			if(StringUtils.isEmpty(uteGest.getCodiceFiscale())){
				utentiGestoriModel.setIdEnteGestoreAssociato(super.getIdEnteGestore(session));
				bmGestioneUtentiGestori.insUtenteGestore(utentiGestoriModel);
				buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "inserisci  utente gestore con idutente " +utentiGestoriModel.getIdUtenteGestore());

				clean(model);
			}else{
				addOneMsgError(model, CostantiERR.ERR_UTENTE_GEST_GIA_ESISTENTE.getCostante());
			}
			
			
		}else{	
			log.error(methodName, feedback.toStringErr());
		}					
		
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiGest/inserimentoUtentiGestori.jsp");
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
		model.addAttribute("utentiGestoriModel", new UtentiGestoriModel());
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiGest/inserimentoUtentiGestori.jsp");
		return "/GestioneUtentiGest/inserimentoUtentiGestori";
	}
	
	
	/**
	 * 
	 * @param utentiGestoriModel
	 * @return
	 */
	@ModelAttribute("utentiGestoriModel")
	public UtentiGestoriModel utentiGestoriModel(UtentiGestoriModel utentiGestoriModel) {
		return utentiGestoriModel;
	}

}	