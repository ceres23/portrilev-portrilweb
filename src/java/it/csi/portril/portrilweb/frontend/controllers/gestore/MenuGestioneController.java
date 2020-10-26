/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiGestori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiGestori;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.EntiGestoriModel;
import it.csi.portril.portrilweb.model.MenuGestoreModel;
import it.csi.portril.portrilweb.model.UtentiGestoriModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.LogUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *  Controller di accesso al menu del Gestore subito dopo l'autenticazione dello stesso 
 */
@Controller
@RequestMapping("/gestore/menuGestore")

public class MenuGestioneController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Value("${url.logout}")
	private String strlogout;

	@Value("${nome.ambiente}")
	private String nomeAmbiente;

	@Autowired
	protected BusinessGestioneUtentiGestori bmGestioneUtentiGestori;
	
	@Autowired
	protected BusinessGestioneEntiGestori bmGestioneEntiGestori;
	
	/**
	 * 
	 * @param menuGestoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start" , method = {RequestMethod.GET})	
	public String start(@ModelAttribute MenuGestoreModel menuGestoreModel ,HttpSession session,HttpServletRequest request ) {
		String methodName="start";
		log.startMethod(methodName);		
		UtentiGestoriModel utenteGestoreModel = super.getUtenteGestoreConnesso(session);
		if(utenteGestoreModel  == null) {
			String codiceFiscale="";			
			if(nomeAmbiente.equals(Costanti.SVILUPPO.getCostante()) || nomeAmbiente.equals(Costanti.LOCALE.getCostante())){
				log.info(methodName, "NON passo da autenticazione Shib codiceFiscale di test --> " + codiceFiscale);
				codiceFiscale="AAAAAA00A11C000K";
			}else{
				codiceFiscale  = request.getHeader("Shib-Identita-CodiceFiscale") ;
				log.info(methodName, "passo da autenticazione Shib codiceFiscale --> " + codiceFiscale);				
			}			
			utenteGestoreModel = bmGestioneUtentiGestori.getUtenteGestorebyCodFis(codiceFiscale);			
			if(utenteGestoreModel.getIdUtenteGestore()==null ||utenteGestoreModel.getIdUtenteGestore()<1){
				log.error(methodName, "Utente non abilitato con cod fisc  --> " + codiceFiscale);
				return "/utenteNonAbilitatoAllaProcedura";
			}else{
				session.setAttribute(Costanti.UTENTE_GESTORE_CONNESSO.getCostante()  ,utenteGestoreModel); 	
				session.setAttribute(Costanti.ID_ENTE_GESTORE_SEL.getCostante() ,utenteGestoreModel.getListaEntiGestori().get(0).getIdEnteGestore());	
				session.setAttribute(Costanti.DESC_ENTE_GESTORE_SEL.getCostante() ,"");	
				if(utenteGestoreModel.getListaEntiGestori().size()==1){
					session.setAttribute(Costanti.DESC_ENTE_GESTORE_SEL.getCostante() ,utenteGestoreModel.getListaEntiGestori().get(0).getRagioneSociale());				
				}
			}
		}		
		session.setAttribute("urlLogout",strlogout);
		log.info(methodName, "num lista enti " + utenteGestoreModel.getListaEntiGestori().size());		
		// carico il model della pagina menuGestore
		mapper.map(utenteGestoreModel.getProfiliUtentiModel(),menuGestoreModel);	
		// inizializzo la lista dei gestori associato all'utente connesso
		menuGestoreModel.setListaEntiGestori(utenteGestoreModel.getListaEntiGestori());				
		// inizializzo il valore ente associato all'utente connesso
		menuGestoreModel.setIdEnteGestoreSel(utenteGestoreModel.getListaEntiGestori().get(0).getIdEnteGestore());	
		// setto la variabile che identifica se l'utente connesso ha 1 solo ente associato (scenario base)
		menuGestoreModel.setUtenteMonoEnte(utenteGestoreModel.getListaEntiGestori().size()<2);	
		log.stopMethod(methodName+" vado alla pagina /menugestione.jsp");
		return "/menugestione";
	}
	
	/**
	 * primo blocco
	 *  vai alla pagina che inserisce il nuovo Ente compilatore 
	 *  passando dal controller insGestioneEntiCompilatoriController invocando il metodo start
	 * @param menuGestoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="inserimentoEntiCompilatori", method = {RequestMethod.POST})
	public String inserimentoEntiCompilatori(MenuGestoreModel menuGestoreModel,HttpSession session) {
		String methodName="inserimentoEntiCompilatori";
		log.startMethod(methodName);		
		salvaIdEnteSelezionato(menuGestoreModel, session);		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/inserimentoEntiCompilatori/start.do");
		return "redirect:/gestore/inserimentoEntiCompilatori/start.do";
	}
		
	/**
	 * 
	 * @param menuGestoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricercaEntiCompilatori", method = {RequestMethod.POST})
	public String ricercaEntiCompilatori(MenuGestoreModel menuGestoreModel,HttpSession session) {
		String methodName="ricercaEntiCompilatori";
		log.startMethod(methodName);		
		salvaIdEnteSelezionato(menuGestoreModel, session);		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/ricercaEntiCompilatori/start.do");
		return "redirect:/gestore/ricercaEntiCompilatori/start.do";
	}
	
	/**
	 *  secondo blocco
	 *  vai alla pagina che inserisce il nuovo utente compilatore 
	 *  passando dal controller insGestioneUtentiCompilatoriController invocando il metodo start
	 * @param menuGestoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="inserimentoUtentiCompilatoriStep1", method = {RequestMethod.POST})
	public String inserimentoUtentiCompilatoriStep1(MenuGestoreModel menuGestoreModel,HttpSession session) {
		String methodName="inserimentoUtentiCompilatoriStep1";
		log.startMethod(methodName);		
		salvaIdEnteSelezionato(menuGestoreModel, session);		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/inserimentoUtentiCompilatoriStep1/start.do");		
		return "redirect:/gestore/inserimentoUtentiCompilatoriStep1/start.do";
	}
	
	/**
	 * 
	 * @param menuGestoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricercaUtentiCompilatori", method = {RequestMethod.POST})
	public String ricercaUtentiCompilatori(MenuGestoreModel menuGestoreModel,HttpSession session) {
		String methodName="ricercaUtentiCompilatori";
		log.startMethod(methodName);		
		salvaIdEnteSelezionato(menuGestoreModel, session);		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/ricercaUtentiCompilatori/start.do");
		return "redirect:/gestore/ricercaUtentiCompilatori/start.do";
	}

	/**
	 * terzo blocco
	 * @param menuGestoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="inserimentoUtentiGestori", method = {RequestMethod.POST})
	public String inserimentoUtentiGestori(MenuGestoreModel menuGestoreModel,HttpSession session) {
		String methodName="inserimentoUtentiGestori";
		log.startMethod(methodName);		
		salvaIdEnteSelezionato(menuGestoreModel, session);		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/inserimentoUtentiGestori/start.do");
		return "redirect:/gestore/inserimentoUtentiGestori/start.do";
	}
	
	/**
	 * 
	 * @param menuGestoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricGestioneUtentiGestori", method = {RequestMethod.POST})
	public String ricGestioneUtentiGestori(MenuGestoreModel menuGestoreModel,HttpSession session) {
		String methodName="ricGestioneUtentiGestori";
		log.startMethod(methodName);		
		salvaIdEnteSelezionato(menuGestoreModel, session);		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/ricercaUtentiGestori/start.do");
		return "redirect:/gestore/ricercaUtentiGestori/start.do";
	}
	
	/**
	 * quarto blocco
	 * @param menuGestoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="insDefinModuli", method = {RequestMethod.POST})
	public String insDefinModuli(MenuGestoreModel menuGestoreModel,HttpSession session) {
		String methodName="insDefinModuli";
		log.startMethod(methodName);		
		salvaIdEnteSelezionato(menuGestoreModel, session);		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/insDefinModuli/start.do");
		return "redirect:/gestore/insDefinModuli/start.do";
	}
	
	/**
	 * 
	 * @param menuGestoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricercaModuli", method = {RequestMethod.POST})
	public String ricercaModuli(MenuGestoreModel menuGestoreModel,HttpSession session) {
		String methodName="ricercaModuli";
		log.startMethod(methodName);		
		salvaIdEnteSelezionato(menuGestoreModel, session);		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/ricercaModuli/start.do");
		return "redirect:/gestore/ricercaModuli/start.do";
	}
		
	/**
	 * quinto blocco
	 * @param menuGestoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricercaModuloXComunicazione", method = {RequestMethod.POST})
	public String RicercaModuloXComunicazione(MenuGestoreModel menuGestoreModel,HttpSession session) {
		String methodName="ricercaModuloXComunicazione";
		log.startMethod(methodName);		
		salvaIdEnteSelezionato(menuGestoreModel, session);		
		log.stopMethod(methodName+" vado alla pagina /gestore/ricercaModuliXComunicazione/start.do");
		return "redirect:/gestore/ricercaModuliXComunicazione/start.do";
	}

	/**
	 * 
	 * @param menuGestoreModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricercaRisultati", method = {RequestMethod.POST})
	public String ricercaRisultati(MenuGestoreModel menuGestoreModel,HttpSession session) {
		String methodName="ricercaRisultati";
		log.startMethod(methodName);		
		salvaIdEnteSelezionato(menuGestoreModel, session);		
		log.stopMethod(methodName+" vado alla pagina /gestore/ricercaRisultati/start.do");
		return "redirect:/gestore/ricercaRisultati/start.do";
	}
	
	/**
	 * 
	 * @param menuGestoreModel
	 * @param session
	 */
	private void salvaIdEnteSelezionato(MenuGestoreModel menuGestoreModel,HttpSession session) {
		EntiGestoriModel enteGestore = bmGestioneEntiGestori.getEnteGestoreById(menuGestoreModel.getIdEnteGestoreSel());
		super.setIdEnteGestore(menuGestoreModel.getIdEnteGestoreSel(), session);	
		super.setDescEnteGestore(enteGestore.getRagioneSociale(), session);			
	}
}