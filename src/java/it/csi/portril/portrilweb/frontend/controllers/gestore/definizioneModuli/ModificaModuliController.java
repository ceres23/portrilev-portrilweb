/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.definizioneModuli;

import java.io.IOException;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.dto.FeedbackError;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.UtentiGestoriModel;
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
@RequestMapping("/gestore/modificaModuli")
public class ModificaModuliController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;

	@Autowired
	protected BusinessGestioneEntiCompilatori businessGestioneEntiCompilatori;
	
	/**
	 * 
	 * @param moduliModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute ModuliModel moduliModel,Model model,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);		
		session.removeAttribute(Costanti.MODIFICABILE.getCostante());			
		Long idModuloSel = (Long) session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		moduliModel = bmGestioneModuli.getModuloForId(idModuloSel);		
		log.debugMultiLine(methodName,moduliModel);
		model.addAttribute(moduliModel);	
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/modificaModuli.jsp");
		return "/DefinizioneModuli/modificaModuli";
	}

	/**
	 * 
	 * @param moduliModel
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="modificaModuloTestataProsegui",method = {RequestMethod.POST})	
	public String modificaModuloTestataProsegui(@Valid @ModelAttribute ModuliModel moduliModel,BindingResult result,Model model, HttpSession session) throws IOException {
		String methodName="modificaModuloTestataProsegui";
		log.startMethod(methodName);		
		
		FeedbackError feedback = gestisciSuccessWarningErrors(model,result,"redirect:/gestore/gestioneModificaColonneModulo/start.do","/DefinizioneModuli/modificaModuli" );
		/*
		if(feedback.isErrorePresente() || !validaFile (model,moduliModel.getFile())){
			feedback.setErrorePresente(true);
			feedback.setDestinazione("/DefinizioneModuli/insDefinModuli");
		}
		*/
		if (!feedback.isErrorePresente()){	
			UtentiGestoriModel utenteLoggato =super.getUtenteGestoreConnesso( session) ; 					
			moduliModel.setIdUtenteGestore(utenteLoggato.getIdUtenteGestore());	
			
			// setto l'ente che ho impostato dalla finestra modale
			moduliModel.setIdEnteGestore(super.getIdEnteGestore(session));
			Long idModuloSel = (Long) session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
			
			bmGestioneModuli.modificaModuli(moduliModel);
			session.setAttribute(Costanti.MODULOSEL.getCostante(), idModuloSel);
		}else{	
			log.error(methodName, feedback.toStringErr());
		}
		
		log.stopMethod(methodName+" vado alla pagina " + feedback.getDestinazione());
		return feedback.getDestinazione();	
	}
	
	
	/**
	 * 
	 * @param moduliModel
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="modificaModuloTestata",method = {RequestMethod.POST})	
	public String modificaModuloTestata(@Valid @ModelAttribute ModuliModel moduliModel,BindingResult result,Model model, HttpSession session) throws IOException {
		String methodName="modificaModuloTestata";
		log.startMethod(methodName);
		
		FeedbackError feedback = gestisciSuccessWarningErrors(model,result,"/DefinizioneModuli/modificaModuli" );
		/*
		if(feedback.isErrorePresente() || !validaFile (model,moduliModel.getFile())){
			feedback.setErrorePresente(true);
			feedback.setDestinazione("/DefinizioneModuli/insDefinModuli");
		}
		*/
		
		if (!feedback.isErrorePresente()){	
			UtentiGestoriModel utenteLoggato =super.getUtenteGestoreConnesso( session) ; 					
			moduliModel.setIdUtenteGestore(utenteLoggato.getIdUtenteGestore());			
			// setto l'ente che ho impostato dalla finestra modale
			moduliModel.setIdEnteGestore(super.getIdEnteGestore( session));
			//log.info(methodName, ReflectionToStringBuilder.reflectionToString(moduliModel, ToStringStyle.MULTI_LINE_STYLE));
			bmGestioneModuli.modificaModuli(moduliModel);	
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
	public String clean(@ModelAttribute ModuliModel moduliModel,Model model,HttpSession session) {
		String methodName="clean";
		log.startMethod(methodName);
		
		//model.addAttribute("moduliModel", new ModuliModel());
		Long idModuloSel = (Long) session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		moduliModel = bmGestioneModuli.getModuloForId(idModuloSel);		
		log.debugMultiLine(methodName,moduliModel);
		model.addAttribute(moduliModel);	

		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/modificaModuli.jsp");
		return "/DefinizioneModuli/modificaModuli";
	}

	
	@ModelAttribute("moduliModel")
	public ModuliModel moduliModel(ModuliModel moduliModel) {
		return moduliModel;
	}
	
}
