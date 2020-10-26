/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.definizioneModuli;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.dto.FeedbackError;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.UtentiGestoriModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.LogUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/gestore/insDefinModuli")
public class InserimentoModuliController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;

	
	/**
	 * 
	 * @param moduliModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute ModuliModel moduliModel,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);

		session.removeAttribute(Costanti.MODULOSEL.getCostante());
		session.removeAttribute(Costanti.LISTACOLONNEDACLONARE.getCostante());
		
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/insDefinModuli.jsp");
		return "/DefinizioneModuli/insDefinModuli";
	}
	
	
	/**
	 * questo metodo e il metodo di ingresso nel caso si acceda alla pagina dal copia modulo della ricerca
	 * @param moduliModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="startDaCopiaModulo",method = {RequestMethod.GET,RequestMethod.POST})	
	public String startDaCopiaModulo(@ModelAttribute ModuliModel moduliModel,HttpSession session,Model model) {
		String methodName="startDaCopiaModulo";
		log.startMethod(methodName);

		Long idModuloDaCopiare = (Long) session.getAttribute(Costanti.IDMODULO_DA_COPIARE.getCostante());
		session.setAttribute(Costanti.MODULOSEL.getCostante(), moduliModel.getIdModulo());
		
		moduliModel = bmGestioneModuli.getModuloForId(idModuloDaCopiare);
		moduliModel.setIdModulo(null);
		moduliModel.setDataInizioCompilazione(null);
		moduliModel.setDataFineCompilazione(null);
		moduliModel.setDataUltimaModifica(new Date());
		model.addAttribute(moduliModel);
		
		List<ColonneModuloModel> nuovaListaColonnePerClonazione = new ArrayList<ColonneModuloModel>();
		for(ColonneModuloModel colonna :moduliModel.getListaColonneModulo()){
			colonna.setIdColonnaModulo(null);
			nuovaListaColonnePerClonazione.add(colonna);
		}
		session.setAttribute(Costanti.LISTACOLONNEDACLONARE.getCostante(), nuovaListaColonnePerClonazione);
		
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/insDefinModuli.jsp");
		return "/DefinizioneModuli/insDefinModuli";
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
	@RequestMapping(value="inserisciModuloTestataProsegui",method = {RequestMethod.POST})	
	public String inserisciModuloTestataProsegui(@Valid @ModelAttribute 		ModuliModel moduliModel,
														BindingResult result,
														Model model,
														HttpSession session) throws IOException {
		
		String methodName="inserisciModuloTestataProsegui";
		log.startMethod(methodName);		

		FeedbackError feedback = new FeedbackError();				
		feedback = gestisciSuccessWarningErrors(model,result,"redirect:/gestore/gestioneColonneModulo/start.do","/DefinizioneModuli/insDefinModuli" );		
		/*
		if(feedback.isErrorePresente() || !validaFile (model,moduliModel.getFile())){
			feedback.setErrorePresente(true);
			feedback.setDestinazione("/DefinizioneModuli/insDefinModuli");
		}
		*/
		if (!feedback.isErrorePresente()){	
			ModuliModel modulo = bmGestioneModuli.xstModulo(moduliModel.getNome().trim().toUpperCase(),null,moduliModel.getTipo());
			
			if(StringUtils.isNotEmpty(modulo.getNome())){
				log.debug(methodName, "modulo estratto presente " +modulo.getNome());
				addOneMsgError(model, CostantiERR.ERR_MODELLO_ESISTENTE.getCostante(), true);
				return "/DefinizioneModuli/insDefinModuli";	
			}
			
			UtentiGestoriModel utenteLoggato =super.getUtenteGestoreConnesso( session) ; 					
			moduliModel.setIdUtenteGestore(utenteLoggato.getIdUtenteGestore());			
			
			// setto l'ente che ho impostato dalla finestra modale
			moduliModel.setIdEnteGestore(super.getIdEnteGestore(session));			
			moduliModel = bmGestioneModuli.insDefinModuli(moduliModel);
			session.setAttribute(Costanti.MODULOSEL.getCostante(), moduliModel.getIdModulo());		
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
	@RequestMapping(value="inserisciModuloTestata",method = {RequestMethod.POST})	
	public String inserisciModuloTestata(
			@Validated @ModelAttribute ModuliModel moduliModel,
			BindingResult result,
			Model model,
			HttpSession session) throws IOException {
		
		
		String methodName="inserisciModuloTestata";
		log.startMethod(methodName);
		Long idEnteGestore = super.getIdEnteGestore(session);		
		FeedbackError feedback = new FeedbackError();				
		feedback = gestisciSuccessWarningErrors(model,result,"redirect:/gestore/gestioneColonneModulo/start.do","/DefinizioneModuli/insDefinModuli" );

		if (!feedback.isErrorePresente()){				
			List<ModuliModel> lista = bmGestioneModuli.ricercaModuli(moduliModel.getNome().trim().toUpperCase(),null,Costanti.TIPO_MODULO_RILEVAZIONE.getCostante(),idEnteGestore,null);
			if(CollectionUtils.isNotEmpty(lista)){
				addOneMsgError(model, CostantiERR.ERR_MODELLO_ESISTENTE.getCostante(), true);
				return "/DefinizioneModuli/insDefinModuli";	
			}

			UtentiGestoriModel utenteLoggato =super.getUtenteGestoreConnesso( session) ; 					
			moduliModel.setIdUtenteGestore(utenteLoggato.getIdUtenteGestore());			
			// setto l'ente che ho impostato dalla finestra modale
			moduliModel.setIdEnteGestore(super.getIdEnteGestore( session));
			moduliModel = bmGestioneModuli.insDefinModuli(moduliModel);			
		}else{	
			log.error(methodName, feedback.toStringErr());
		}

		log.stopMethod(methodName+" vado alla pagina " + feedback.getDestinazione());
		return feedback.getDestinazione();	
	}

	
	/**
	 * 
	 * @param session
	 * @param moduliModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value="goToTestataAfterSave",method = {RequestMethod.GET,RequestMethod.POST})	
	public String goToTestataAfterSave(HttpSession session,@ModelAttribute ModuliModel moduliModel,Model model) {
		String methodName="goToTestataAfterSave";
		log.startMethod(methodName);
				
		addOneMsgSuccess(model, Costanti.MSG_MODULO_OK.getCostante());
		
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/insDefinModuli");
		return "/DefinizioneModuli/insDefinModuli";
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
		
		model.addAttribute("moduliModel", new ModuliModel());

		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/insDefinModuli.jsp");
		return "/DefinizioneModuli/insDefinModuli";
	}

	
}



