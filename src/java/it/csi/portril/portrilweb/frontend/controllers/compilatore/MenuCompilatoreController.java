/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.compilatore;

import java.util.List;
import javax.servlet.http.HttpSession;
import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiCompilatori;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.MenuCompilatoreModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/compilatore/menuCompilatore")

public class MenuCompilatoreController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());	
	@Autowired
	protected BusinessGestioneUtentiCompilatori bmGestioneUtentiCompilatori;
		
	/**
	 * 
	 * @param menuCompilatoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute MenuCompilatoreModel menuCompilatoreModel ,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);		
		UtentiCompilatoriModel utenteComp = getUtenteCompilatoreConnesso(session);
		//Controllo Pw nel caso l'utente che si stia loggando e NON sia del servizio
		utenteComp.setPwNotSecure(false);
		if (utenteComp.getLogin()!= null && utenteComp.getLogin().equals(utenteComp.getPassword()) && !utenteComp.getServizio()){			
			log.info(methodName, "pw di default necessitiamo di forzare il cambio pw al compilatore");
			utenteComp.setPwNotSecure(true);
			setUtenteCompilatoreConnesso(utenteComp, session);
			log.stopMethod(methodName+" vado alla pagina redirect:/compilatore/gesPassword/start.do");
			return "redirect:/compilatore/gesPassword/start.do";

		}		
		List<EntiCompilatoriModel> listaEntiCompilatori = bmGestioneUtentiCompilatori.getListaEntiCompilatoriByUtente(super.getUtenteCompilatoreConnesso(session).getIdUtenteCompilatore()); 		
		// inizializzo la lista dei compilatori  associato all'utente connesso
		menuCompilatoreModel.setListaEntiCompilatori(listaEntiCompilatori);		
		// setto la variabile che identifica se l'utente connesso ha 1 solo ente associato (scenario base)
		menuCompilatoreModel.setUtenteMonoEnteCompilatore(menuCompilatoreModel.getListaEntiCompilatori().size()<2);	
		// inizializzo il valore ente associato all'utente connesso
		menuCompilatoreModel.setIdEnteCompilatoreSel(menuCompilatoreModel.getListaEntiCompilatori().get(0).getIdEnteCompilatore());
		log.stopMethod(methodName+" vado alla pagina /menuCompilatori.jsp");
		return "/menuCompilatori";
	}
	
	
	/**
	 * accesso alla pagina di gestione  per la modifica profilo dell'utente compilatore connesso
	 * @param menuCompilatoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="modProfiloStep1",method = {RequestMethod.GET,RequestMethod.POST})	
	public String modProfiloStep1(@ModelAttribute MenuCompilatoreModel menuCompilatoreModel ,HttpSession session) {
		String methodName="modProfiloStep1";
		log.startMethod(methodName);		
		log.stopMethod(methodName+" vado alla pagina /redirect:/compilatore/modificaProfiloUtenteCompilatoreStep1/start.do");
		return "redirect:/compilatore/modificaProfiloUtenteCompilatoreStep1/start.do";
	}
	
	
	/**
	 * accesso alla pagina di gestione utente compilatore per la modific della PW
	 * @param menuCompilatoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="gesPassword",method = {RequestMethod.GET,RequestMethod.POST})	
	public String gesPassword(@ModelAttribute MenuCompilatoreModel menuCompilatoreModel ,HttpSession session) {
		String methodName="gesPassword";
		log.startMethod(methodName);		
		//setIdEnteCompilatoreSelezionato(menuCompilatoreModel.getIdEnteCompilatoreSel(), session);
		log.stopMethod(methodName+" vado alla pagina redirect:/compilatore/gesPassword/start.do");
		return "redirect:/compilatore/gesPassword/start.do";
	}
		
	/**
	 * accesso alla pagina di ricerca per compilazione dei moduli associati all'utente connesso
	 * @param menuCompilatoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricCompModuli",method = {RequestMethod.POST})	
	public String ricCompModuli(@ModelAttribute MenuCompilatoreModel menuCompilatoreModel ,HttpSession session) {
		String methodName="ricCompModuli";
		log.startMethod(methodName);		
		setIdEnteCompilatoreSelezionato(menuCompilatoreModel.getIdEnteCompilatoreSel(), session);
		log.stopMethod(methodName+" vado alla pagina redirect:/compilatore/gestioneModuliRicercaPerCompilazione/start.do");
		return "redirect:/compilatore/gestioneModuliRicercaPerCompilazione/start.do";
	}
		
	/**
	 * 
	 * @param menuCompilatoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricDefinModuli",method = {RequestMethod.POST})	
	public String ricDefinModuli(@ModelAttribute MenuCompilatoreModel menuCompilatoreModel ,HttpSession session) {
		String methodName="ricDefinModuli";
		log.startMethod(methodName);		
		setIdEnteCompilatoreSelezionato(menuCompilatoreModel.getIdEnteCompilatoreSel(), session);		
		log.stopMethod(methodName+" vado alla pagina redirect:/compilatore/gestioneDefinizioneModuliRicerca/start.do");
		return "redirect:/compilatore/gestioneDefinizioneModuliRicerca/start.do";
	}
}