/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.compilatore.gestioneProfilo;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiCompilatori;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.frontend.controllers.ControllerUtenteCompilatoreBase;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriStep2Model;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/compilatore/modificaProfiloUtenteCompilatoreStep2")
public class ModificaProfiloUtenteCompilatoreStep2Controller extends ControllerUtenteCompilatoreBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	BusinessGestioneUtentiCompilatori businessGestioneUtentiCompilatori;
	
	@Autowired
	BusinessGestioneEntiCompilatori bmGestioneEntiCompilatori;
	
	
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute UtentiCompilatoriStep2Model utentiCompilatoriStep2Model,Model model,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);

		Long  idUtente = ((UtentiCompilatoriModel)session.getAttribute(Costanti.UTENTE_COMPILATORE_TMP.getCostante())).getIdUtenteCompilatore();
		session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante(),businessGestioneUtentiCompilatori.getListaEntiUtentiCompilatoriByIdUtente(idUtente));
		
		List<EntiCompilatoriModel> listaEntiAssociati = businessGestioneUtentiCompilatori.getListaEntiUtentiCompilatoriByIdUtente(idUtente);		
		utentiCompilatoriStep2Model.setListaEntiAssociati(listaEntiAssociati);
		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/modProfiloStep2.jsp");
		return "/GestioneProfilo/modProfiloStep2";
	}
	
	
	/**
	 * 
	 * @param utentiCompilatoriStep2Model
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="ricerca",method = {RequestMethod.POST})	
	public String ricerca(@Valid @ModelAttribute UtentiCompilatoriStep2Model utentiCompilatoriStep2Model,BindingResult result,Model model,HttpSession session) {
		String methodName="ricerca";
		log.startMethod(methodName);
		
		String ragioneSociale =utentiCompilatoriStep2Model.getRagioneSociale();
		String comune =utentiCompilatoriStep2Model.getComune();
		String classificazione =utentiCompilatoriStep2Model.getClassificazione();		
		String codiceFiscale =utentiCompilatoriStep2Model.getCodiceFiscale();
		String partitaIva =utentiCompilatoriStep2Model.getPartitaIva();		
		UtentiCompilatoriModel userConnesso = getUtenteCompilatoreConnesso(session);		
		//TODO da capire come fare ad identificare il gestore corretto
		Long idEnteGestore = null;//userConnesso.getIdEnteGestore();	
		List<EntiCompilatoriModel> listaEntiCompilatoriRicercati = bmGestioneEntiCompilatori.getEntiCompilatoriByIdEnteGestore(Costanti.ATTIVO.getCostante(), ragioneSociale,classificazione, comune, codiceFiscale, partitaIva,idEnteGestore);		
		List<EntiCompilatoriModel> listaEntiAssociati = (List<EntiCompilatoriModel>)session.getAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante());
		utentiCompilatoriStep2Model.setListaEntiAssociati(listaEntiAssociati);
		session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_RICERCATI.getCostante(), listaEntiCompilatoriRicercati);		
		utentiCompilatoriStep2Model.setListaEntiCompilatoriRicercati(listaEntiCompilatoriRicercati);		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/modProfiloStep2.jsp" );
		return "/GestioneProfilo/modProfiloStep2";
	}
	
	
	/**
	 * 
	 * @param utentiCompilatoriStep2Model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="associaUtenteEnte",method = {RequestMethod.POST})	
	public String associaUtenteEnte( @ModelAttribute UtentiCompilatoriStep2Model utentiCompilatoriStep2Model,HttpSession session) {
		String methodName="associaUtenteEnte";
		log.startMethod(methodName);
		log.info(methodName, "ente associato selezionato" + utentiCompilatoriStep2Model.getIdEnteAssociato());	
		// lista enti compilatori ricercati
		List<EntiCompilatoriModel> listaRicercati = (List<EntiCompilatoriModel>) session.getAttribute(Costanti.LISTA_ENTI_COMPILATORI_RICERCATI.getCostante());
		List<EntiCompilatoriModel> listaAssociati = (List<EntiCompilatoriModel>) session.getAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante());	
		listaAssociati  = super.trasferisciElementoDiLista(listaRicercati,listaAssociati, utentiCompilatoriStep2Model.getIdEnteAssociato());
		session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante(),listaAssociati);
		utentiCompilatoriStep2Model.setListaEntiAssociati(listaAssociati);
		utentiCompilatoriStep2Model.setListaEntiCompilatoriRicercati(listaRicercati);				
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/modProfiloStep2.jsp" );
		return "/GestioneProfilo/modProfiloStep2";
	}

	
	/**
	 * 
	 * @param utentiCompilatoriStep2Model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="disassociaUtenteEnte",method = {RequestMethod.POST})	
	public String disassociaUtenteEnte( @ModelAttribute UtentiCompilatoriStep2Model utentiCompilatoriStep2Model,HttpSession session) {
		String methodName="disassociaUtenteEnte";
		log.startMethod(methodName);

		List<EntiCompilatoriModel> listaRicercati = (List<EntiCompilatoriModel>) session.getAttribute(Costanti.LISTA_ENTI_COMPILATORI_RICERCATI.getCostante());
		List<EntiCompilatoriModel> listaAssociati = (List<EntiCompilatoriModel>) session.getAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante());

		listaAssociati  = rimuoviElementoDaLista(listaAssociati, utentiCompilatoriStep2Model.getIdEnteDisAssociato());
		session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante(),listaAssociati);
		
		utentiCompilatoriStep2Model.setListaEntiAssociati(listaAssociati);
		utentiCompilatoriStep2Model.setListaEntiCompilatoriRicercati(listaRicercati);
		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/modProfiloStep2.jsp" );
		return "/GestioneProfilo/modProfiloStep2";
	}

	
	/**
	 * 
	 * @param utentiCompilatoriStep2Model
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="salvaUtenteCompilatore",method = {RequestMethod.POST})	
	public String salvaUtenteCompilatore( @ModelAttribute UtentiCompilatoriStep2Model utentiCompilatoriStep2Model,BindingResult result,Model model,HttpSession session) {
		String methodName="salvaUtenteCompilatore";
		log.startMethod(methodName);
		
		List<EntiCompilatoriModel> listaAssociati = (List<EntiCompilatoriModel>) session.getAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante());
		UtentiCompilatoriModel utentiCompilatoriModel =(UtentiCompilatoriModel) session.getAttribute(Costanti.UTENTE_COMPILATORE_TMP.getCostante());	
		
		utentiCompilatoriStep2Model.setUtentiCompilatoriModel(utentiCompilatoriModel);
		utentiCompilatoriStep2Model.setListaEntiAssociati(listaAssociati);
		utentiCompilatoriStep2Model.setIdEnteGestore(super.getIdEnteGestore(session));
		
		if(CollectionUtils.isNotEmpty(listaAssociati)){
			businessGestioneUtentiCompilatori.modificaUtenteCompilatore(utentiCompilatoriStep2Model);	
			
			session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_RICERCATI.getCostante(),new ArrayList<EntiCompilatoriModel>());
			session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante(),new ArrayList<EntiCompilatoriModel>());
			utentiCompilatoriStep2Model.setListaEntiAssociati(new ArrayList<EntiCompilatoriModel>());
			utentiCompilatoriStep2Model.setListaEntiCompilatoriRicercati(new ArrayList<EntiCompilatoriModel>());
			
			UtentiCompilatoriModel utente = (UtentiCompilatoriModel)session.getAttribute(Costanti.UTENTE_COMPILATORE_TMP.getCostante());
			super.setUtenteCompilatoreConnesso(utente,session);
			
			log.stopMethod(methodName+" vado alla pagina redirect:/compilatore/modificaProfiloUtenteCompilatoreStep1/tornaAlloStep1.do" );
			return "redirect:/compilatore/modificaProfiloUtenteCompilatoreStep1/tornaAlloStep1.do";
		}else{
			addOneMsgError(model, CostantiERR.ERR_ASS_ENTE_UTE_OBBL.getCostante());
			return "/GestioneProfilo/modProfiloStep2";
		}
		
	}
	


	private List<EntiCompilatoriModel> rimuoviElementoDaLista(List<EntiCompilatoriModel> lista, Long id) {
		List<EntiCompilatoriModel> ris = new ArrayList<EntiCompilatoriModel>();		
		for(EntiCompilatoriModel sel : lista) {
			if(!sel.getIdEnteCompilatore().equals(id)){
				ris.add(sel);
			}
		}
		return ris;
	}
	 
}