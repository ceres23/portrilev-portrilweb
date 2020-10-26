/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.definizioneModuli;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiGestori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RicercaModuliModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.CostantiWARN;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *  Questo controller gestisce l'inserimento del Modulo
 */
@Controller
@SessionAttributes({"ricercaModuliModel"})
@RequestMapping("/gestore/ricercaModuli")
public class RicercaModuliController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;

	@Autowired
	protected BusinessGestioneEntiCompilatori businessGestioneEntiCompilatori;

	@Autowired
	protected BusinessGestioneEntiGestori bmGestioneEntiGestori;
	
	/**
	 * 
	 * @param ricercaModuliModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute RicercaModuliModel ricercaModuliModel,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);
		
		session.removeAttribute(Costanti.LISTA_MODULI_RICERCATI.getCostante());
		ricercaModuliModel.setListaModuli(new ArrayList<ModuliModel>());
		ricercaModuliModel.setAperturaModale(false);
		
		log.stopMethod(methodName+" vado alla pagina " + "/DefinizioneModuli/ricDefinModuli.jsp");
		return "/DefinizioneModuli/ricDefinModuli";
	}

	/**
	 * 
	 * @param ricercaModuliModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricerca",method = {RequestMethod.POST})	
	public String ricerca(@ModelAttribute RicercaModuliModel ricercaModuliModel,Model model,HttpSession session) {
		String methodName="ricerca";
		log.startMethod(methodName);
		ricercaModuliModel.setAperturaModale(false);
		Long idEnteGestore = super.getIdEnteGestore(session);
		
		//log.info(methodName, "idEnteGestore " + idEnteGestore);
		
		List<ModuliModel> listaModuliRicercati = bmGestioneModuli.ricercaModuli(
			ricercaModuliModel.getNome(),
			ricercaModuliModel.getStato(),
			ricercaModuliModel.getTipo(),
			idEnteGestore,
			ricercaModuliModel.getCodiceGruppo()
		);

		if(CollectionUtils.isEmpty(listaModuliRicercati)){
			addOneMsgWarning(model, CostantiWARN.RICERCA0.getCostante());
		}
		ricercaModuliModel.setListaModuli(listaModuliRicercati);
		session.setAttribute(Costanti.LISTA_MODULI_RICERCATI.getCostante(), listaModuliRicercati);
		
		log.debug(methodName,"listaModulo size " + listaModuliRicercati);
		
		log.stopMethod(methodName+" vado alla pagina " + "/DefinizioneModuli/ricDefinModuli.jsp");
		return "/DefinizioneModuli/ricDefinModuli";
	}

	/**
	 * 
	 * @param ricercaModuliModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="modifica",method = {RequestMethod.POST})	
	public String modifica(@ModelAttribute RicercaModuliModel ricercaModuliModel,HttpSession session) {
		String methodName="modifica";
		log.startMethod(methodName);
		ricercaModuliModel.setAperturaModale(false);
		
		Long idModuloSel = ricercaModuliModel.getIdModuloSel();
		session.setAttribute(Costanti.ID_MODULO_SEL.getCostante(), idModuloSel);
		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/modificaModuli/start.do ");
		return "redirect:/gestore/modificaModuli/start.do";
	}
	
	/**
	 * 
	 * @param ricercaModuliModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="elimina",method = {RequestMethod.POST})	
	public String elimina(@ModelAttribute RicercaModuliModel ricercaModuliModel,Model model,HttpSession session) {
		String methodName="elimina";
		log.startMethod(methodName);
		ricercaModuliModel.setAperturaModale(false);
		
		Long idModuloSel = ricercaModuliModel.getIdModuloSel();
		String msgUpd = bmGestioneModuli.eliminaModulo(idModuloSel);
		
		List<ModuliModel> listaModuliRicercati = (List<ModuliModel>)session.getAttribute(Costanti.LISTA_MODULI_RICERCATI.getCostante());
		
		//gestisco l'errore in pagina		
		if(StringUtils.isNotEmpty(msgUpd)){
			addOneMsgWarning(model,msgUpd);
		}else{
			listaModuliRicercati=rimuoviElementoDaLista(listaModuliRicercati,idModuloSel);
			addOneMsgSuccess(model, Costanti.MODULO_DEL_OK.getCostante());

		}
		ricercaModuliModel.setListaModuli(listaModuliRicercati);
		session.setAttribute(Costanti.LISTA_MODULI_RICERCATI.getCostante(), listaModuliRicercati);

		log.stopMethod(methodName+" vado alla pagina " + "/DefinizioneModuli/ricDefinModuli.jsp");
		return "/DefinizioneModuli/ricDefinModuli";
	}
	
	/**
	 * 
	 * @param ricercaModuliModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="copia",method = {RequestMethod.POST})	
	public String copia(@ModelAttribute RicercaModuliModel ricercaModuliModel,HttpSession session) {
		String methodName="copia";
		log.startMethod(methodName);
		ricercaModuliModel.setAperturaModale(false);
		
		// vado alla pagina di inserimento preimpostando i valori
		Long idModuloSel = ricercaModuliModel.getIdModuloSel();
		session.setAttribute(Costanti.IDMODULO_DA_COPIARE.getCostante(), idModuloSel);

		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/insDefinModuli/startDaCopiaModulo.do");
		return "redirect:/gestore/insDefinModuli/startDaCopiaModulo.do";
	}
	
	/**
	 * 
	 * @param ricercaModuliModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="associa",method = {RequestMethod.POST})	
	public String associa(@ModelAttribute RicercaModuliModel ricercaModuliModel,HttpSession session) {
		String methodName="associa";
		log.startMethod(methodName);
		ricercaModuliModel.setAperturaModale(false);
		
		Long idModuloSel = ricercaModuliModel.getIdModuloSel();
		session.setAttribute(Costanti.ID_MODULO_SEL.getCostante(), idModuloSel);
		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/associaModuliEnti/start.do");
		return "redirect:/gestore/associaModuliEnti/start.do";
	}
	
	
	/**
	 * 
	 * @param ricercaModuliModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="apriFinestraMail",method = {RequestMethod.POST})	
	public String apriFinestraMail(@ModelAttribute RicercaModuliModel ricercaModuliModel,HttpSession session,Model model) {
		String methodName="apriFinestraMail";
		log.startMethod(methodName);
		
		Long idModuloSel = ricercaModuliModel.getIdModuloSel();
		session.setAttribute(Costanti.ID_MODULO_SEL.getCostante(), idModuloSel);
		
		ModuliModel modulo = bmGestioneModuli.getModuloForId(idModuloSel);
		
		if(modulo.getTipo().equalsIgnoreCase(Costanti.TIPO_MODULO_RILEVAZIONE.getCostante()) && (modulo.getDataInizioCompilazione()==null || modulo.getDataFineCompilazione()==null)){
			addOneMsgWarning(model, CostantiWARN.WARN_MAIL_MODULO_DATE_NON_COMPILATE.getCostante());
			return "/DefinizioneModuli/ricDefinModuli";
		}
				
		//controllo che abbia almeno un 'ente compilatore associato
		if(CollectionUtils.isEmpty(businessGestioneEntiCompilatori.getListaEntiCompilatoribyIdModulo(idModuloSel))){
			addOneMsgWarning(model, CostantiWARN.WARN_ENTE_COMP_MAIL_OBBL.getCostante());
			return "/DefinizioneModuli/ricDefinModuli";
		}

		//forzo l'apertura della finestra modale
		ricercaModuliModel.setAperturaModale(true);
		ricercaModuliModel.setModuloSelezionato(bmGestioneModuli.getModuloForId(idModuloSel));	
		
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/ricDefinModuli");
		return "/DefinizioneModuli/ricDefinModuli";
	}
	
	
	/**
	 * 
	 * @param ricercaModuliModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="invia",method = {RequestMethod.POST})	
	public String invia(@ModelAttribute RicercaModuliModel ricercaModuliModel,HttpSession session,Model model) {
		String methodName="invia";
		log.startMethod(methodName);
		
		ricercaModuliModel.setAperturaModale(false);
		Long idModuloSel = (Long) session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
	
//		EntiGestoriModel eg = bmGestioneEntiGestori.getEnteGestoreById(super.getIdEnteGestore(session));
//		log.debug(methodName, "mittente Mail ente Gestore--> " + super.getUtenteGestoreConnesso(session).getMail());
		try {
			bmGestioneModuli.invioMailInvito(
											idModuloSel,
											super.getUtenteGestoreConnesso(session).getIdUtenteGestore(),
											super.getUtenteGestoreConnesso(session).getMail().trim(),
											ricercaModuliModel.getOggMailModulo(),
											ricercaModuliModel.getDescMailModulo(),
											super.getIdEnteGestore(session),
											true);
		
			addOneMsgSuccess(model, Costanti.MAIL_OK.getCostante())	;
		} catch (MessagingException e) {
			addOneMsgError(model, CostantiERR.ERR_MAIL.getCostante());
			log.error(methodName, CostantiERR.ERR_MAIL.getCostante() +"  "+e);
		}
		
		log.stopMethod(methodName+" vado alla pagina " + "/DefinizioneModuli/ricDefinModuli.jsp");
		return "/DefinizioneModuli/ricDefinModuli";
	}
	

	/**
	 * 
	 * @param listaRisultati
	 * @param idModuloSel
	 * @return
	 */
	private List<ModuliModel> rimuoviElementoDaLista(List<ModuliModel> listaRisultati,Long idModuloSel) {	
		List<ModuliModel> listaRisultatiRisultanti = new ArrayList<ModuliModel>();
		for(int i=0;i<listaRisultati.size();i++){
			ModuliModel sel = listaRisultati.get(i);
			if(!sel.getIdModulo().equals(idModuloSel)){
				listaRisultatiRisultanti.add(sel);
			}
		}
		return listaRisultatiRisultanti;
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
		model.addAttribute("ricercaModuliModel", new RicercaModuliModel());
		status.setComplete();
		log.stopMethod(methodName+" vado alla pagina " + "/DefinizioneModuli/ricDefinModuli.jsp");
		return "/DefinizioneModuli/ricDefinModuli";
	}
	
	@ModelAttribute("ricercaModuliModel")
	public RicercaModuliModel ricercaModuliModel(RicercaModuliModel ricercaModuliModel) {
		return new RicercaModuliModel();
	}
	
}
