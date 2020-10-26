/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.definizioneModuli;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.AssociaModuliEntiModel;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes({"associaModuliEntiModel"})
@RequestMapping("/gestore/associaModuliEnti")
public class AssociaModuliEntiController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;

	@Autowired
	protected BusinessGestioneEntiCompilatori bmEntiCompilatori;
	
	/**
	 * 
	 * @param associaModuliEntiModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute("associaModuliEntiModel") AssociaModuliEntiModel associaModuliEntiModel,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);
		//buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, methodName);		
		Long idModuloSel = (Long) session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		ModuliModel modulo = bmGestioneModuli.getModuloForId(idModuloSel);
		associaModuliEntiModel.setModulo(modulo);
		associaModuliEntiModel.setListaEntiCompilatoriRicercati(new ArrayList<EntiCompilatoriModel>());	
		session.removeAttribute(Costanti.MODULO_SEL.getCostante());
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/associaModuli.jsp");
		return "/DefinizioneModuli/associaModuli";
	}
	
	/**
	 * 
	 * @param associaModuliEntiModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="ricerca",method = {RequestMethod.POST})	
	public String ricerca(@ModelAttribute AssociaModuliEntiModel associaModuliEntiModel,HttpSession session,Model model) {
		String methodName="ricerca";
		log.startMethod(methodName);	
		String stato =Costanti.ATTIVO.getCostante();
		if(associaModuliEntiModel.getAssociato().equalsIgnoreCase(Costanti.ASSOCIATO.getCostante())){
			stato=Costanti.ALL.getCostante();
		}
		List<EntiCompilatoriModel> listaEntiCompilatoriRicercati = bmEntiCompilatori.ricercaEntiCompilatoriRelazionatiAiModuli(
																			super.getIdEnteGestore(session),
																			associaModuliEntiModel.getRagioneSociale(),
																			associaModuliEntiModel.getClassificazione(),
																			associaModuliEntiModel.getComune(),
																			associaModuliEntiModel.getProvincia(),
																			//associaModuliEntiModel.getIstat(),
																			associaModuliEntiModel.getCodiceFiscale(),
																			associaModuliEntiModel.getPartitaIva(),
																			associaModuliEntiModel.getModulo().getIdModulo(),
																			stato,
																			associaModuliEntiModel.getAssociato()
				);
		

		associaModuliEntiModel.setUltimaRicercaAssociato(associaModuliEntiModel.getAssociato());
		associaModuliEntiModel.setListaEntiCompilatoriRicercati(listaEntiCompilatoriRicercati);

		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/associaModuli.jsp");
		return "/DefinizioneModuli/associaModuli";
	}


	/**
	 * 
	 * @param associaModuliEntiModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="salvaAssociazione",method = {RequestMethod.POST})	
	public String salvaAssociazione(@ModelAttribute AssociaModuliEntiModel associaModuliEntiModel,HttpSession session,Model model) {
		String methodName="salvaAssociazione";
		log.startMethod(methodName);
		
		List<Long> listaId = associaModuliEntiModel.getListaIdDaAssociareLong();
		List<EntiCompilatoriModel> listaEntiCompilatoriAssociati = bmGestioneModuli.getEntiCompilatoriForListId(listaId);	
		
		Long idModulo = associaModuliEntiModel.getModulo().getIdModulo();
		
		if(StringUtils.isEmpty(associaModuliEntiModel.getUltimaRicercaAssociato()) || associaModuliEntiModel.getUltimaRicercaAssociato().equalsIgnoreCase(Costanti.ASSOCIATO.getCostante())){
			bmGestioneModuli.setListaEntiFromModulo(idModulo,listaEntiCompilatoriAssociati);
		}else{
			bmGestioneModuli.addListaEntiFromModulo(idModulo,listaEntiCompilatoriAssociati);			
		}
		associaModuliEntiModel.setAssociato(associaModuliEntiModel.getUltimaRicercaAssociato());
		addMsgSuccessDefault(model);
		ricerca(  associaModuliEntiModel, session, model);

		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/associaModuli.jsp");
		return "/DefinizioneModuli/associaModuli";
	}
	
	
	/**
	 * resetta tutti i campi del form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="clean",method = {RequestMethod.POST})	
	public String clean(Model model,SessionStatus status) {
		String methodName="clean";
		log.startMethod(methodName);		
		model.addAttribute("associaModuliEntiModel", new AssociaModuliEntiModel());
		status.setComplete();
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/associaModuli.jsp");
		return "/DefinizioneModuli/associaModuli";
	}
	
	@ModelAttribute("associaModuliEntiModel")
	public AssociaModuliEntiModel associaModuliEntiModel(AssociaModuliEntiModel associaModuliEntiModel) {
		return new AssociaModuliEntiModel();
	}
		
}