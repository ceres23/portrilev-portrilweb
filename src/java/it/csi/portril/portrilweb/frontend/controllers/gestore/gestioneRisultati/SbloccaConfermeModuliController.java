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
import it.csi.portril.portrilweb.model.SbloccaConfermeModuliModel;
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
//@SessionAttributes({"sbloccaConfermeModuli"})
@RequestMapping("/gestore/sbloccaConfermeModuli")
public class SbloccaConfermeModuliController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;

	@Autowired
	protected BusinessGestioneEntiCompilatori bmEntiCompilatori;
	
	@Autowired
	protected BusinessGestioneModuli businessGestioneModuli;

	/**
	 * 
	 * @param associaModuliEntiModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute("sbloccaConfermeModuliModel") SbloccaConfermeModuliModel sbloccaConfermeModuliModel,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);
		init(sbloccaConfermeModuliModel, session);	
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/sbloccaConfermeModuli.jsp");
		return "/GestioneRisultati/sbloccaConfermeModuli";
	}

	/**
	 * 
	 * @param associaModuliEntiModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricerca",method = {RequestMethod.POST})	
	public String ricerca(@ModelAttribute("sbloccaConfermeModuliModel") SbloccaConfermeModuliModel sbloccaConfermeModuliModel,HttpSession session) {
		String methodName="ricerca";
		log.startMethod(methodName);
		
		init(sbloccaConfermeModuliModel, session);	
		
		
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/sbloccaConfermeModuli.jsp");
		return "/GestioneRisultati/sbloccaConfermeModuli";
	}

	
	private void init(SbloccaConfermeModuliModel sbloccaConfermeModuliModel,HttpSession session) {
		Long idModuloSel = (Long) session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		ModuliModel modulo = bmGestioneModuli.getModuloForId(idModuloSel);
		sbloccaConfermeModuliModel.setModulo(modulo);		
		List<EntiCompilatoriModel> lista = bmEntiCompilatori.getListaEntiCompilatoriConModuloConfermato(idModuloSel,sbloccaConfermeModuliModel.getStatoConferma());		
		sbloccaConfermeModuliModel.setListaEntiCompilatoriRicercati(lista);
	}
	
	/**
	 * 
	 * @param gestioneModuliCompilaModuloModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "validaModulo",method = {RequestMethod.POST})
	public String validaModulo(@ModelAttribute SbloccaConfermeModuliModel sbloccaConfermeModuliModel,Model model,HttpSession session) {
		String methodName = "validaModulo";
		log.startMethod(methodName);
		Long idModuloSel = (Long) session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		List<Long> listaId = sbloccaConfermeModuliModel.getListaIdDaSbloccareLong();		
		businessGestioneModuli.settaValidaListaModuloCompilatore(idModuloSel, listaId,Costanti.SI.getCostante());			
		init( sbloccaConfermeModuliModel, session);	
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/sbloccaConfermeModuli.jsp");
		return "/GestioneRisultati/sbloccaConfermeModuli";
	}

	/**
	 * 
	 * @param gestioneModuliCompilaModuloModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "svalidaModulo",method = {RequestMethod.POST})
	public String svalidaModulo(@ModelAttribute SbloccaConfermeModuliModel sbloccaConfermeModuliModel,Model model,HttpSession session) {
		String methodName = "validaModulo";
		log.startMethod(methodName);
		Long idModuloSel = (Long) session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		List<Long> listaId = sbloccaConfermeModuliModel.getListaIdDaSbloccareLong();		
		businessGestioneModuli.settaValidaListaModuloCompilatore(idModuloSel, listaId,Costanti.NO.getCostante());			
		init( sbloccaConfermeModuliModel, session);
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/sbloccaConfermeModuli.jsp");
		return "/GestioneRisultati/sbloccaConfermeModuli";
	}

	
	/**
	 * 
	 * @param gestioneModuliCompilaModuloModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "sbloccaModulo",method = {RequestMethod.POST})
	public String sbloccaModulo(@ModelAttribute SbloccaConfermeModuliModel sbloccaConfermeModuliModel,Model model,HttpSession session) {
		String methodName = "sbloccaModulo";
		log.startMethod(methodName);
		Long idModuloSel = (Long) session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		List<Long> listaId = sbloccaConfermeModuliModel.getListaIdDaSbloccareLong();
		businessGestioneModuli.settaConfermaListaModuloCompilatore(idModuloSel, listaId,Costanti.NO.getCostante());	
		//se sblocco il modulo automaticamente lo invalido
		businessGestioneModuli.settaValidaListaModuloCompilatore(idModuloSel, listaId,Costanti.NO.getCostante());	
		
		init( sbloccaConfermeModuliModel, session);			
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/sbloccaConfermeModuli.jsp");
		return "/GestioneRisultati/sbloccaConfermeModuli";
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
		model.addAttribute("sbloccaConfermeModuliModel", new SbloccaConfermeModuliModel());
		//status.setComplete();
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/sbloccaConfermeModuli.jsp");
		return "/GestioneRisultati/sbloccaConfermeModuli";
	}

	/**
	 * 
	 * @param sbloccaConfermeModuliModel
	 * @return
	 */
	@ModelAttribute("associaModuliEntiModel")
	public SbloccaConfermeModuliModel sbloccaConfermeModuliModel(SbloccaConfermeModuliModel sbloccaConfermeModuliModel) {
		return new SbloccaConfermeModuliModel();
	}
		
}