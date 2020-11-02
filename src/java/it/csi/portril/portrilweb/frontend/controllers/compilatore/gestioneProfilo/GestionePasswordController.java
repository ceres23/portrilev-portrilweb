/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.compilatore.gestioneProfilo;
import it.csi.portril.portrilweb.business.interfaces.compilatori.BusinessGestioneProfiloCompilatore;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.GesPasswordModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.util.Validazioni;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/compilatore/gesPassword")

public class GestionePasswordController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneProfiloCompilatore businessGestioneProfiloCompilatore;
	
	
	/**
	 * 
	 * @param gesPasswordModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute GesPasswordModel gesPasswordModel ,Model model,HttpSession session,HttpServletRequest request) {
		String methodName="start";
		log.startMethod(methodName);
		
		UtentiCompilatoriModel utenteComp = getUtenteCompilatoreConnesso( session);
		if (utenteComp.getPwNotSecure()){
			addOneMsgError(model,CostantiERR.ERR_PW_NON_SICURA.getCostante(),true);
		}
		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/gesPassword.jsp");
		return "/GestioneProfilo/gesPassword";
	}

	
	/**
	 * 
	 * @param gesPasswordModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="salva",method = {RequestMethod.POST})	
	public String salva(@ModelAttribute GesPasswordModel gesPasswordModel ,Model model,HttpSession session) {
		String methodName="salva";
		log.startMethod(methodName);
		
		List<String> listaErrori = validaDatiPw(
			session,
			gesPasswordModel.getPasswordAttuale(),
			gesPasswordModel.getPasswordNuova(),
			gesPasswordModel.getPasswordRipetiNuova()
		);

		if(CollectionUtils.isNotEmpty(listaErrori)){
			addMsgError(model, listaErrori,true);	
		}else{
			UtentiCompilatoriModel utente = super.getUtenteCompilatoreConnesso(session);
			utente = businessGestioneProfiloCompilatore.resettaPwCompilatore(utente,gesPasswordModel.getPasswordNuova());
			super.setUtenteCompilatoreConnesso(utente,session);
			clean(session, model) ;
			super.addOneMsgSuccess(model, Costanti.PW_OK.getCostante());
			//Salvo il fatto che l'utente loggato non necessita di cambio pw
			UtentiCompilatoriModel utenteComp = getUtenteCompilatoreConnesso( session);
			utenteComp.setPwNotSecure(false);
			setUtenteCompilatoreConnesso(utenteComp, session);
			
		}
		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/gesPassword.jsp");
		return "/GestioneProfilo/gesPassword";
	}
	
	
	private List<String> validaDatiPw(HttpSession session,String passwordAttuale, String passwordNuova,String passwordRipetiNuova) {
		String methodName="validaDatiPw";

		List<String> ris=new ArrayList<String>();
		UtentiCompilatoriModel utenteCompilatore = super.getUtenteCompilatoreConnesso(session);
		
		if(StringUtils.isBlank(passwordAttuale) || StringUtils.isBlank(passwordNuova) || StringUtils.isBlank(passwordRipetiNuova)){
			ris.add(CostantiERR.ERR_CAMPI_OBBLIGATORI_PW.getCostante());		
			log.info(methodName, "campi pw non valorizzati");
			return ris;
		}

		
		if(!passwordAttuale.equals(utenteCompilatore.getPassword())){
			ris.add(CostantiERR.ERR_PW_NON_COERENTE.getCostante());		
			log.info(methodName, "pw utente non coerente");
		}else{

			if(passwordAttuale.equals(passwordNuova)){
				ris.add(CostantiERR.ERR_PW_COINCIDENTI.getCostante());
				log.info(methodName, "la nuova pw coincide con quella vecchia");
			}
	
			
			if(!passwordNuova.equals(passwordRipetiNuova)){
				ris.add(CostantiERR.ERR_PW_CONTROLLO.getCostante());
				log.info(methodName, "la pw non coincidono");
			}
			
			if(! new Validazioni().controlloSicurezzaPw(passwordNuova)){
				ris.add(CostantiERR.ERR_PW_NUOVA_NON_SICURA.getCostante());
				log.info(methodName, "pw non sicura");
			}
		}
		
		return ris;
	}


	/**
	 * resetta tutti i campi del form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="clean",method = {RequestMethod.POST})	
	public String clean(HttpSession session,Model model) {
		String methodName="clean";
		log.startMethod(methodName);
		model.addAttribute("gesPasswordModel", new GesPasswordModel());		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/gesPassword.jsp");
		return "/GestioneProfilo/gesPassword";
	}
}