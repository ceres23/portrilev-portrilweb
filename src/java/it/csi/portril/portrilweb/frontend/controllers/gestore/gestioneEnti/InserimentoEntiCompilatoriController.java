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
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/gestore/inserimentoEntiCompilatori")
public class InserimentoEntiCompilatoriController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	@Autowired
	protected BusinessGestioneEntiCompilatori bmEntiCompilatori;
	
	@RequestMapping(value="start", method = {RequestMethod.GET})	
	public String start() {
		String methodName="start";
		log.startMethod(methodName);

		log.stopMethod(methodName+" vado alla pagina /GestioneEnti/inserimentoEntiCompilatori.jsp");
		return "/GestioneEnti/inserimentoEntiCompilatori";
	}

	
	/**
	 * 
	 * @param entiCompilatoriModel
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="inserisci",method = {RequestMethod.POST})	
	public String inserisci( @Valid @ModelAttribute EntiCompilatoriModel entiCompilatoriModel,BindingResult result,Model model,HttpSession session) {
		String methodName="inserisci";
		log.startMethod(methodName);

		FeedbackError feedback = gestisciSuccessWarningErrors(model,result,"/GestioneEnti/inserimentoEntiCompilatori" );
		
		if (!feedback.isErrorePresente()){				
			
			List<EntiCompilatoriModel> listaenteComp = new ArrayList<EntiCompilatoriModel>();
			
			// verifico che esista o meno l'ente compilatore già nel sistema
			if (entiCompilatoriModel.getCodiceFiscale()!=null){
				listaenteComp = bmEntiCompilatori.getEntiCompilatori(null,null, null,null, entiCompilatoriModel.getCodiceFiscale(), null);
			}else{
				listaenteComp = bmEntiCompilatori.getEntiCompilatori(null,null, null,null,null,entiCompilatoriModel.getPartitaIva());				
			}
			
			// controllo che l'ente compilatore non sia già stato inserito
			entiCompilatoriModel.setIdEnteCompilatore(null);
			if(CollectionUtils.isNotEmpty(listaenteComp) ){
				entiCompilatoriModel.setIdEnteCompilatore(listaenteComp.get(0).getIdEnteCompilatore());
				//controllo le associazioni al gestore
				boolean xstAss = bmEntiCompilatori.xstAssociazioneEnteGestoreCompilatore(listaenteComp.get(0).getIdEnteCompilatore(),super.getIdEnteGestore(session)) ;
				if(xstAss){
					addOneMsgError(model, CostantiERR.ERR_ENTE_COMP_GIA_ESISTENTE.getCostante(), true);
					log.info(methodName, CostantiERR.ERR_ENTE_COMP_GIA_ESISTENTE.getCostante());
					return feedback.getDestinazione();	
				}				
			}			
			List<Long> listaIdEnteGestore = new ArrayList<Long>();
			listaIdEnteGestore.add(super.getIdEnteGestore(session));
			entiCompilatoriModel.setListaIdEnteGestore(listaIdEnteGestore);	
			//lo stato per un nuovo inserimento è sempre attivo
			//entiCompilatoriModel.setStato(Costanti.ATTIVO.getCostante());
			entiCompilatoriModel = bmEntiCompilatori.insEnteCompilatore(entiCompilatoriModel,listaIdEnteGestore);			
			buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "inserito Ente compilatore con idEnte " +entiCompilatoriModel.getIdEnteCompilatore());

			clean(model);
			new FeedbackSuccess().addMsgSuccess(Costanti.INS_ENTE_COMP_OK.getCostante());
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
	public String clean(Model model) {
		String methodName="clean";
		log.startMethod(methodName);
		
		model.addAttribute("entiCompilatoriModel", new EntiCompilatoriModel());
		
		log.stopMethod(methodName+" vado alla pagina /GestioneEnti/inserimentoEntiCompilatori.jsp");
		return "/GestioneEnti/inserimentoEntiCompilatori";
	}	
	
	
	/**
	 * 
	 * @param entiCompilatoriModel
	 * @return
	 */
	@ModelAttribute("entiCompilatoriModel")
	public EntiCompilatoriModel entiCompilatoriModel(EntiCompilatoriModel entiCompilatoriModel) {
		return entiCompilatoriModel;
	}
	
}
