/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.gestioneEnti;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.RicercaEntiCompilatoriModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiWARN;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/gestore/ricercaEntiCompilatori")
public class RicercaEntiCompilatoriController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneEntiCompilatori bmGestioneEntiCompilatori;
		
	/**
	 * 
	 * @param ricercaEntiCompilatoriModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute RicercaEntiCompilatoriModel ricercaEntiCompilatoriModel,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);
		log.stopMethod(methodName+" vado alla pagina /GestioneEnti/ricercaEntiCompilatori.jsp");
		return "/GestioneEnti/ricercaEntiCompilatori";
	}

	
	/**
	 * 
	 * @param ricercaEntiCompilatoriModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricerca",method = {RequestMethod.POST})	
	public String ricerca(@ModelAttribute RicercaEntiCompilatoriModel ricercaEntiCompilatoriModel,Model model,HttpSession session) {
		String methodName="ricerca";
		log.startMethod(methodName);
		ricercaEntiCompilatoriModel.setIdEnteGestore(super.getIdEnteGestore(session));
		
		List<EntiCompilatoriModel> listaEntiCompilatori = bmGestioneEntiCompilatori.ricercaEntiCompilatori(
																											super.getIdEnteGestore(session),
																											ricercaEntiCompilatoriModel.getRagioneSociale(),
																											ricercaEntiCompilatoriModel.getClassificazione(),
																											ricercaEntiCompilatoriModel.getComune(),
																											ricercaEntiCompilatoriModel.getProvincia(),
																											ricercaEntiCompilatoriModel.getCodiceFiscale(),
																											ricercaEntiCompilatoriModel.getPartitaIva(),
																											null,
																											null
																											);
			
		ricercaEntiCompilatoriModel.setListaEntiCompilatori(listaEntiCompilatori);

		// test in base al massimo numero di risultati che voglio esporre 
		// se il test da esito negativo 
		/*
		if(ricercaEntiCompilatoriModel.getListaEntiCompilatori().size()> Integer.parseInt(Costanti.NUM_MAX_RIC.getCostante())){
			addOneMsgWarning(model,CostantiWARN.WAR_RIC.getCostante() );
			ricercaEntiCompilatoriModel.setListaEntiCompilatori(new ArrayList<EntiCompilatoriModel>());
		}
		*/
		if(ricercaEntiCompilatoriModel.getListaEntiCompilatori().size()==0 && !ricercaEntiCompilatoriModel.isNoMsg()){
			addOneMsgWarning(model,CostantiWARN.RICERCA0.getCostante() );
			ricercaEntiCompilatoriModel.setListaEntiCompilatori(new ArrayList<EntiCompilatoriModel>());
		}
		ricercaEntiCompilatoriModel.setNoMsg(false);
		buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "ricerca enti compilatori");
		log.debug(methodName, "num elem lista enti " + ricercaEntiCompilatoriModel.getListaEntiCompilatori().size());
		log.stopMethod(methodName+" vado alla pagina /GestioneEnti/ricercaEntiCompilatori.jsp");
		return "/GestioneEnti/ricercaEntiCompilatori";
	}

	/**
	 * 
	 * @param ricercaEntiCompilatoriModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="cancellaEnteCompilatore",method = {RequestMethod.POST})	
	public String cancellaEnteCompilatore(@ModelAttribute RicercaEntiCompilatoriModel ricercaEntiCompilatoriModel,Model model,HttpSession session) {
		String methodName="cancellaEnteCompilatore";
		log.startMethod(methodName);
		log.info(methodName, "selezionato " + ricercaEntiCompilatoriModel.getIdEnteSel());

		try {
			bmGestioneEntiCompilatori.eliminaEnteCompilatore(ricercaEntiCompilatoriModel.getIdEnteSel());
			addOneMsgSuccess(model, Costanti.CANCELLAZIONE_OK.getCostante());			
			buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "cancellato ente compilatore con idEnte " +ricercaEntiCompilatoriModel.getIdEnteSel());

		} catch(RuntimeException re) {
			log.error(methodName, re);
			super.gestisciEccezioneEliminaRecordConFigli(re, model,Costanti.ENTE_COMPILATORE_NODEL.getCostante());
		}			
		ricercaEntiCompilatoriModel.setNoMsg(true);
		log.stopMethod(methodName+" vado alla pagina /GestioneEnti/ricercaEntiCompilatori.jsp");
		return ricerca(ricercaEntiCompilatoriModel, model, session);
	}
		
	/**
	 * 
	 * @param ricercaEntiCompilatoriModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="disattivaAttivaEnteCompilatore",method = {RequestMethod.POST})	
	public String disattivaAttivaEnteCompilatore(@ModelAttribute RicercaEntiCompilatoriModel ricercaEntiCompilatoriModel,Model model,HttpSession session) {
		String methodName="disattivaAttivaEnteCompilatore";
		log.startMethod(methodName);
		log.debug(methodName, "selezionato " + ricercaEntiCompilatoriModel.getIdEnteSel());			
		String msg = bmGestioneEntiCompilatori.disattivaAttivaEnteCompilatore(ricercaEntiCompilatoriModel.getIdEnteSel());		
		buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "disattivato Ente  con idEnte " +ricercaEntiCompilatoriModel.getIdEnteSel());
		addOneMsgSuccess(model,msg);
		log.stopMethod(methodName+" vado alla pagina /GestioneEnti/ricercaEntiCompilatori.jsp");			
		return ricerca(ricercaEntiCompilatoriModel, model, session);
	}
		
	/**
	 * 
	 * @param modificaEnteCompilatore
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="modificaEnteCompilatore",method = {RequestMethod.POST})	
	public String modificaEnteCompilatore(@ModelAttribute RicercaEntiCompilatoriModel ricercaEntiCompilatoriModel,Model model,HttpSession session) {
		String methodName="modificaEnteCompilatore";
		log.startMethod(methodName);
		log.debug(methodName, "selezionato " + ricercaEntiCompilatoriModel.getIdEnteSel());	
		session.setAttribute(Costanti.ID_ENTE_COMPILATORE_MOD.getCostante(), ricercaEntiCompilatoriModel.getIdEnteSel());		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/modificaEnteCompilatore/start.do");
		return "redirect:/gestore/modificaEnteCompilatore/start.do";
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
		model.addAttribute("ricercaEntiCompilatoriModel", new RicercaEntiCompilatoriModel());		
		log.stopMethod(methodName+" vado alla pagina /GestioneEnti/ricercaEntiCompilatori.jsp");
		return "/GestioneEnti/ricercaEntiCompilatori";
	}	
}