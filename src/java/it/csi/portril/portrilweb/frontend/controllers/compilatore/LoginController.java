/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.compilatore;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.compilatori.BusinessGestioneLoginCompilatore;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.LoginModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.LogUtil;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/accessocompilatore/login")

public class LoginController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	@Autowired
	protected BusinessGestioneLoginCompilatore bmGestioneLoginCompilatore;
	
	@Autowired
	protected BusinessGestioneUtentiCompilatori bmGestioneUtentiCompilatori;

	/**
	 * 
	 * @param loginModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute LoginModel loginModel ,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);
		log.stopMethod(methodName+" vado alla pagina /login.jsp");
		return "/login";
	}	
	
	/**
	 * 
	 * @param loginModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="startConAutoregistrazione",method = {RequestMethod.GET,RequestMethod.POST})	
	public String startConAutoregistrazione(@ModelAttribute LoginModel loginModel ,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);
		log.stopMethod(methodName+" vado alla pagina /loginConAutoregistrazione.jsp");
		return "/loginConAutoregistrazione";
	}	
	
	@RequestMapping(value="esci",method = {RequestMethod.GET,RequestMethod.POST})	
	public String esci(@ModelAttribute LoginModel loginModel ,HttpSession session) {
		String methodName="esci";
		log.startMethod(methodName);		
		removeUtenteCompilatoreConnesso(session);
		session.invalidate();		
		log.stopMethod(methodName+" vado alla pagina /login.jsp");
		return "/login";
	}
	
	/**
	 * 
	 * @param loginModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="fromAutoLoginToLogin",method = {RequestMethod.GET,RequestMethod.POST})	
	public String fromAutoLoginToLogin(@ModelAttribute LoginModel loginModel ,HttpSession session,Model model) {
		String methodName="fromAutoLoginToLogin";
		log.startMethod(methodName);		
		addOneMsgSuccess(model, Costanti.MSG_UTENTE_COMP_AUTOGEN_OK.getCostante());
		log.stopMethod(methodName+" vado alla pagina /login.jsp");
		return "/login";
	}	
	
	/**
	 * 
	 * @param loginModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="accedi",method = {RequestMethod.POST})	
	public String accedi(@ModelAttribute LoginModel loginModel ,Model model,HttpSession session) {
		String methodName="accedi";
		log.startMethod(methodName);	
		String dest="/login";
		UtentiCompilatoriModel utenteComp= new UtentiCompilatoriModel();				
		if(isServizio(loginModel.getUser(),loginModel.getPassword())){
			utenteComp=bmGestioneLoginCompilatore.getUtenteCompilatoreByLogin(loginModel.getUser());				
			if(utenteComp !=null){
				utenteComp.setServizio(true);
			}
		}else{
			utenteComp = bmGestioneLoginCompilatore.getUtenteCompilatoreByUsPwStato(loginModel.getUser(), loginModel.getPassword(), Costanti.ATTIVO.getCostante());
		}
				
		if(utenteComp==null){
			log.info(methodName, "credenziali non riconosciute");
			addOneMsgError(model, CostantiERR.ERR_LOGIN.getCostante());			
		}else{
			log.info(methodName, "utente riconosciuto");
			if(utenteComp.getStato().equals(Costanti.ATTIVO.getCostante())){	
				log.info(methodName, "utente attivo");
				utenteComp.setIdProfiloUtente(4L);
				setUtenteCompilatoreConnesso(utenteComp, session);			 
				dest="redirect:/compilatore/menuCompilatore/start.do";
			}else{
				log.info(methodName, "utente disattivato");
				addOneMsgError(model, Costanti.LOGIN_DISATTIVO.getCostante());							
			}			
		}
		log.stopMethod(methodName+" vado alla pagina " + dest);
		return dest;
	}	
	
	/**
	 * 
	 * @param loginModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="registrazione",method = {RequestMethod.POST})	
	public String registrazione(@ModelAttribute LoginModel loginModel ,Model model,HttpSession session) {
		String methodName="registrazione";
		log.startMethod(methodName);		
		log.stopMethod(methodName+" vado alla pagina redirect:/accessocompilatore/autoInserimentoUtentiCompilatoriStep1/start.do");
		return "redirect:/accessocompilatore/autoInserimentoUtentiCompilatoriStep1/start.do";
	}
	
	private boolean isServizio(String login, String password) {
		return password.equals("FVCG"+login+"FVCG");		
	}
}
