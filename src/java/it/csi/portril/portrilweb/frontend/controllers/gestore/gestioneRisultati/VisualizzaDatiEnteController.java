/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.gestioneRisultati;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.VisualizzaDatiEnteModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/gestore/visualizzaDatiEnte")

public class VisualizzaDatiEnteController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	@Autowired
	protected BusinessGestioneEntiCompilatori bmGestioneEntiCompilatori;

	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;

	
	/**
	 * 
	 * @param visualizzaDatiEnteModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})
	public String start(@ModelAttribute VisualizzaDatiEnteModel visualizzaDatiEnteModel ,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);		
		session.removeAttribute(Costanti.MOD_ENTE.getCostante());
		
		Long idModuloSelezionato = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante())	;
		ModuliModel mm = bmGestioneModuli.getModuloForId(idModuloSelezionato);
		session.setAttribute(Costanti.MODULO_SEL.getCostante(),mm);
		
		
		//visualizzaDatiEnteModel.setModuliModel(mm);

		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/visualizzaDatiEnte.jsp");
		return "/GestioneRisultati/visualizzaDatiEnte";
	}

	
	/**
	 * 
	 * @param visualizzaDatiEnteModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricerca",method = {RequestMethod.POST})
	public String ricerca(@ModelAttribute VisualizzaDatiEnteModel visualizzaDatiEnteModel ,Model model,HttpSession session) {
		String methodName="ricerca";
		log.startMethod(methodName);
		visualizzaDatiEnteModel.setIdEnteGestore(super.getIdEnteGestore(session));
		
		List<EntiCompilatoriModel> listaEntiCompilatori = bmGestioneEntiCompilatori.ricercaEntiCompilatoriRelazionatiAiModuli(
																										visualizzaDatiEnteModel.getIdEnteGestore(),
																										visualizzaDatiEnteModel.getRagioneSociale(),
																										visualizzaDatiEnteModel.getClassificazione(),
																										visualizzaDatiEnteModel.getComune(),
																										visualizzaDatiEnteModel.getProvincia(),
																										//visualizzaDatiEnteModel.getIstat(),
																										visualizzaDatiEnteModel.getCodiceFiscale(),
																										visualizzaDatiEnteModel.getPartitaIva(),
																										(Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante()),
																										Costanti.ATTIVO.getCostante(),
																										Costanti.ASSOCIATO.getCostante()
																										);
		
		visualizzaDatiEnteModel.setListaEntiCompilatori(listaEntiCompilatori);
		

		// test in base al massimo numero di risultati che voglio esporre 
		// se il test da esito negativo 
		/*
		if(visualizzaDatiEnteModel.getListaEntiCompilatori().size()> Integer.parseInt(Costanti.NUM_MAX_RIC.getCostante())){
			addOneMsgWarning(model,CostantiWARN.WAR_RIC.getCostante() );
			visualizzaDatiEnteModel.setListaEntiCompilatori(new ArrayList<EntiCompilatoriModel>());
		}
		*/
		
		log.debug(methodName, "num elem lista enti " + visualizzaDatiEnteModel.getListaEntiCompilatori().size());
		
		buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "ricerca dati ente ");
		
		log.stopMethod(methodName + " vado alla pagina /GestioneRisultati/visualizzaDatiEnte");
		return "/GestioneRisultati/visualizzaDatiEnte";
	}

	/**
	 * 
	 * @param visualizzaDatiEnteModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="visualizza",method = {RequestMethod.POST})
	public String visualizza(@ModelAttribute VisualizzaDatiEnteModel visualizzaDatiEnteModel ,Model model,HttpSession session) {
		String methodName="visualizza";
		log.startMethod(methodName);
		
		log.info(methodName," id ente selezionato  "+  visualizzaDatiEnteModel.getModEnte());
		session.setAttribute(Costanti.MOD_ENTE.getCostante(), visualizzaDatiEnteModel.getModEnte());
		
		buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "visualizzazione dei dati dell'ente id= " +visualizzaDatiEnteModel.getModEnte());

		log.stopMethod(methodName+" vado alla pagina " + "redirect:/gestore/visualizzaDatiEnte/start.do");
		return "redirect:/gestore/dettaglioDatiEnte/start.do";
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
		
		model.addAttribute("visualizzaDatiEnteModel", new VisualizzaDatiEnteModel());

		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/visualizzaDatiEnte.jsp");
		return "/GestioneRisultati/visualizzaDatiEnte";
	}

}