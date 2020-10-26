/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.gestioneUtentiComp;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiCompilatori;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.RicercaUtentiCompilatoriModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
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
@RequestMapping("/gestore/ricercaUtentiCompilatori")
public class RicercaUtentiCompilatoriController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	@Autowired
	protected BusinessGestioneUtentiCompilatori bmGestioneUtentiCompilatori;
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start() {
		String methodName="start";
		log.startMethod(methodName);

		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/ricercaUtentiCompilatori.jsp");
		return "/GestioneUtentiComp/ricercaUtentiCompilatori";
	}

	        
	/**
	 * 
	 * @param ricercaUtentiCompilatoriModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricerca",method = {RequestMethod.POST})	
	public String ricercaUtentiCompilatori(@ModelAttribute RicercaUtentiCompilatoriModel ricercaUtentiCompilatoriModel,HttpSession session,Model model) {
		String methodName="ricercaUtentiCompilatori";
		log.startMethod(methodName);
		
		ricercaUtentiCompilatoriModel.setIdEnteGestore(super.getIdEnteGestore(session));
		List<UtentiCompilatoriModel> listaUtentiCompilatori = bmGestioneUtentiCompilatori.getUtentiCompilatori(ricercaUtentiCompilatoriModel);
		
		if(listaUtentiCompilatori.size()==0){
			addOneMsgWarning(model,CostantiWARN.RICERCA0.getCostante() );
			ricercaUtentiCompilatoriModel.setListaUtentiCompilatori(new ArrayList<UtentiCompilatoriModel>());
		}else{
			ricercaUtentiCompilatoriModel.setListaUtentiCompilatori(listaUtentiCompilatori);
		}
		buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "ricerca Utenti Compilatori ");
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/ricercaUtentiCompilatori.jsp");
		return "/GestioneUtentiComp/ricercaUtentiCompilatori";
	}

	
	/**
	 * 
	 * @param ricercaUtentiCompilatoriModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="cancellaUtenteCompilatore",method = {RequestMethod.POST})	
	public String cancellaUtenteCompilatore(@ModelAttribute RicercaUtentiCompilatoriModel ricercaUtentiCompilatoriModel,Model model,HttpSession session) {
		String methodName="cancellaUtenteCompilatore";
		log.startMethod(methodName);
		log.info(methodName, "selezionato " + ricercaUtentiCompilatoriModel.getIdUtenteSel());

		try {
			bmGestioneUtentiCompilatori.eliminaUtenteCompilatore(ricercaUtentiCompilatoriModel.getIdUtenteSel());
			buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "cancella Utenti Compilatori con id="+ricercaUtentiCompilatoriModel.getIdUtenteSel());

			addOneMsgSuccess(model, Costanti.CANCELLAZIONE_OK.getCostante());
		} catch(RuntimeException re) {
			super.gestisciEccezioneEliminaRecordConFigli(re, model,Costanti.UTENTE_COMPILATORE_NODEL.getCostante());
		}
				
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/ricercaUtentiCompilatori.jsp");
		return ricercaUtentiCompilatori(ricercaUtentiCompilatoriModel,session,model);
	}
	

	/**
	 * 
	 * @param ricercaUtentiCompilatoriModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="disattivaAttivaUtenteCompilatore",method = {RequestMethod.POST})	
	public String disattivaAttivaUtenteCompilatore(@ModelAttribute RicercaUtentiCompilatoriModel ricercaUtentiCompilatoriModel,Model model,HttpSession session) {
		String methodName="disattivaAttivaUtenteCompilatore";
		log.startMethod(methodName);

		log.debug(methodName, "selezionato " + ricercaUtentiCompilatoriModel.getIdUtenteSel());			
		String msg = bmGestioneUtentiCompilatori.disattivaAttivaUtenteCompilatore(ricercaUtentiCompilatoriModel.getIdUtenteSel());
		
		buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "disattiva/Attiva Utenti Compilatori con id="+ricercaUtentiCompilatoriModel.getIdUtenteSel());

		addOneMsgSuccess(model,msg);
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/ricercaUtentiCompilatori.jsp");
			
		return ricercaUtentiCompilatori(ricercaUtentiCompilatoriModel,session,model);
	}
	
	
	/**
	 * 
	 * @param ricercaUtentiCompilatoriModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="modificaUtenteCompilatore",method = {RequestMethod.POST})	
	public String modificaUtenteCompilatore(@ModelAttribute RicercaUtentiCompilatoriModel ricercaUtentiCompilatoriModel,Model model,HttpSession session) {
		String methodName="modificaUtenteCompilatore";
		log.startMethod(methodName);

		log.info(methodName, "selezionato " + ricercaUtentiCompilatoriModel.getIdUtenteSel());	
		session.setAttribute(Costanti.ID_UTENTE_COMPILATORE_MOD.getCostante(), ricercaUtentiCompilatoriModel.getIdUtenteSel());
		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/modificaUtentiCompilatoriStep1/start.do");
		return "redirect:/gestore/modificaUtentiCompilatoriStep1/start.do";
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
		
		model.addAttribute("ricercaUtentiCompilatoriModel", new RicercaUtentiCompilatoriModel());
		
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/ricercaUtentiCompilatori.jsp");
		return "/GestioneUtentiComp/ricercaUtentiCompilatori";
	}
	
	/**
	 * 
	 * @param ricercaUtentiCompilatoriModel
	 * @return
	 */
	@ModelAttribute("ricercaUtentiCompilatoriModel")
	public RicercaUtentiCompilatoriModel ricercaUtentiCompilatoriModel(RicercaUtentiCompilatoriModel ricercaUtentiCompilatoriModel) {
		return ricercaUtentiCompilatoriModel;
	}

}
