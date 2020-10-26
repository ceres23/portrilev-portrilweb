/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.gestioneEnti;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.dto.FeedbackError;
import it.csi.portril.portrilweb.dto.FeedbackSuccess;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
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
@RequestMapping("/gestore/modificaEnteCompilatore")
public class ModificaEnteCompilatoreController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneEntiCompilatori bmGestioneEntiCompilatori;
	
	/**
	 * 
	 * @param entiCompilatoriModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute EntiCompilatoriModel entiCompilatoriModel,HttpSession session,Model model) {
		String methodName="start";
		log.startMethod(methodName);
		Long idEnteSel = (Long)session.getAttribute(Costanti.ID_ENTE_COMPILATORE_MOD.getCostante());
		EntiCompilatoriModel entiCompilatoriModel1 = bmGestioneEntiCompilatori.getEntiCompilatoriById(idEnteSel);
		model.addAttribute("entiCompilatoriModel" , entiCompilatoriModel1);
		log.stopMethod(methodName+" vado alla pagina /GestioneEnti/modificaEnteCompilatore.jsp");
		return "/GestioneEnti/modificaEnteCompilatore";
	}

/**
 * 
 * @param entiCompilatoriModel
 * @param session
 * @param result
 * @param model
 * @return
 */
	@RequestMapping(value="modificaEnte",method = {RequestMethod.POST})	
	public String modificaEnteCompilatore( @Valid @ModelAttribute EntiCompilatoriModel entiCompilatoriModel, BindingResult result, Model model, HttpSession session) {
		String methodName="modificaEnteCompilatore";
		log.startMethod(methodName);
		FeedbackError feedback = gestisciSuccessWarningErrors(model,result,"/GestioneEnti/modificaEnteCompilatore" );		
		if (!feedback.isErrorePresente()){		
			Long idEnteCompilatore = (Long)session.getAttribute(Costanti.ID_ENTE_COMPILATORE_MOD.getCostante());
			entiCompilatoriModel.setIdEnteCompilatore(idEnteCompilatore);
			//entiCompilatoriModel.setIdEnteGestore(super.getIdEnteGestore(session));			
			bmGestioneEntiCompilatori.modificaEnteCompilatore(entiCompilatoriModel);			
			buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "modificato  Ente compilatore con idEnte " +entiCompilatoriModel.getIdEnteCompilatore());
			new FeedbackSuccess().addMsgSuccess(Costanti.MODIFICA_ENTE_OK.getCostante());
		}else{	
			log.error(methodName, feedback.toStringErr());
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
	public String clean(@ModelAttribute EntiCompilatoriModel entiCompilatoriModel,HttpSession session,Model model) {
		String methodName="clean";
		log.startMethod(methodName);
		Long idEnteSel = (Long)session.getAttribute(Costanti.ID_ENTE_COMPILATORE_MOD.getCostante());
		EntiCompilatoriModel entiCompilatoriModel1 = bmGestioneEntiCompilatori.getEntiCompilatoriById(idEnteSel);
		model.addAttribute("entiCompilatoriModel",entiCompilatoriModel1);
		log.stopMethod(methodName+" vado alla pagina /GestioneEnti/modificaEnteCompilatore.jsp");
		return "/GestioneEnti/modificaEnteCompilatore";
	}	
	
}
