/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.gestioneUtentiComp;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiGestori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiCompilatori;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.EntiGestoriModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriStep2Model;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
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
@RequestMapping("/gestore/modificaUtentiCompilatoriStep2")
public class ModificaUtentiCompilatoriStep2Controller extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneUtentiCompilatori bmGestioneUtentiCompilatori;
	
	@Autowired
	BusinessGestioneEntiCompilatori bmGestioneEntiCompilatori;

	@Autowired
	protected BusinessGestioneEntiGestori bmGestioneEntiGestori;


	/**
	 * 
	 * @param utentiCompilatoriStep2Model
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute UtentiCompilatoriStep2Model utentiCompilatoriStep2Model,Model model,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);
		Long idUtente = (Long)session.getAttribute(Costanti.ID_UTENTE_COMPILATORE_MOD.getCostante());
		List<EntiCompilatoriModel> listaEntiAssociati = bmGestioneUtentiCompilatori.getListaEntiUtentiCompilatoriByIdUtente(idUtente);		

		session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante(),listaEntiAssociati);
		utentiCompilatoriStep2Model.setListaEntiAssociati(listaEntiAssociati);
		
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/modificaUtentiCompilatoriStep2.jsp");
		return "/GestioneUtentiComp/modificaUtentiCompilatoriStep2";
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
		String classificazione=utentiCompilatoriStep2Model.getClassificazione();
		String comune =utentiCompilatoriStep2Model.getComune();
		String codiceFiscale =utentiCompilatoriStep2Model.getCodiceFiscale();
		String partitaIva =utentiCompilatoriStep2Model.getPartitaIva();

		//List<EntiCompilatoriModel> listaEntiCompilatoriRicercati = bmGestioneEntiCompilatori.getEntiCompilatori               (Costanti.ATTIVO.getCostante(), ragioneSociale,classificazione, comune, codiceFiscale, partitaIva);
		List<EntiCompilatoriModel> listaEntiCompilatoriRicercati = bmGestioneEntiCompilatori.getEntiCompilatoriByIdEnteGestore(Costanti.ATTIVO.getCostante(), ragioneSociale,classificazione, comune, codiceFiscale, partitaIva,super.getIdEnteGestore(session));
		List<EntiCompilatoriModel> listaEntiAssociati = (List<EntiCompilatoriModel>)session.getAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante());
		utentiCompilatoriStep2Model.setListaEntiAssociati(listaEntiAssociati);
		session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_RICERCATI.getCostante(), listaEntiCompilatoriRicercati);
		
		utentiCompilatoriStep2Model.setListaEntiCompilatoriRicercati(listaEntiCompilatoriRicercati);
		
		buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "ricerca utenti compilatori");

		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/modificaUtentiCompilatoriStep2.jsp" );
		return "/GestioneUtentiComp/modificaUtentiCompilatoriStep2";
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
		
		
		
		listaAssociati  = trasferisciElementoDiLista(listaRicercati,listaAssociati, utentiCompilatoriStep2Model.getIdEnteAssociato());
		session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante(),listaAssociati);
		
		utentiCompilatoriStep2Model.setListaEntiAssociati(listaAssociati);
		utentiCompilatoriStep2Model.setListaEntiCompilatoriRicercati(listaRicercati);
				
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/modificaUtentiCompilatoriStep2.jsp" );
		return "/GestioneUtentiComp/modificaUtentiCompilatoriStep2";
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
		
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/modificaUtentiCompilatoriStep2.jsp" );
		return "/GestioneUtentiComp/modificaUtentiCompilatoriStep2";
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
		UtentiCompilatoriModel utentiCompilatoriModel =(UtentiCompilatoriModel) session.getAttribute(Costanti.UTENTE_COMPILATORE.getCostante());	

		utentiCompilatoriStep2Model.setUtentiCompilatoriModel(utentiCompilatoriModel);
		utentiCompilatoriStep2Model.setListaEntiAssociati(listaAssociati);
		utentiCompilatoriStep2Model.setIdEnteGestore(super.getIdEnteGestore(session));
		
		if(CollectionUtils.isNotEmpty(listaAssociati)){
			
			bmGestioneUtentiCompilatori.modificaUtenteCompilatore(utentiCompilatoriStep2Model);	
			
			session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_RICERCATI.getCostante(),new ArrayList<EntiCompilatoriModel>());
			session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante(),new ArrayList<EntiCompilatoriModel>());
			utentiCompilatoriStep2Model.setListaEntiAssociati(new ArrayList<EntiCompilatoriModel>());
			utentiCompilatoriStep2Model.setListaEntiCompilatoriRicercati(new ArrayList<EntiCompilatoriModel>());
			
			
			// manda la mail che gestisce la comunicazione dell'avvenuta associazione utente ente
			try {
				EntiGestoriModel eg = bmGestioneEntiGestori.getEnteGestoreById(super.getIdEnteGestore(session));

				bmGestioneUtentiCompilatori.invioMailDaInserimentoUtenteCompilatore(
						utentiCompilatoriModel.getMail(),
						utentiCompilatoriModel.getNome(),    
						utentiCompilatoriModel.getCognome(),
						utentiCompilatoriModel.getLogin(),
						utentiCompilatoriModel.getPassword());
				
				buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "riassociazione di utente compilatore con lista enti  utente con id= " +utentiCompilatoriModel.getIdUtenteCompilatore());

			} catch (MessagingException e) {
				log.error(methodName,e);
			}

			
		}else{
			addOneMsgError(model, CostantiERR.ERR_ASS_ENTE_UTE_OBBL.getCostante());
			return "/GestioneUtentiComp/modificaUtentiCompilatoriStep2";
		}
		
		
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/modificaUtentiCompilatoriStep1" );
		return "redirect:/gestore/modificaUtentiCompilatoriStep1/goToStep1BySave.do";
	}
	
	private List<EntiCompilatoriModel> trasferisciElementoDiLista(List<EntiCompilatoriModel> listaRicercati,List<EntiCompilatoriModel> listaAssociati, Long id) {
		String methodName="trasferisciElementoDiLista";
		String listaidAss="";
		
		StringBuffer buf = new StringBuffer();
		for(EntiCompilatoriModel selAss : listaAssociati) {
			buf.append(selAss.getIdEnteCompilatore()+Costanti.SEPARATORE_PROV.getCostante());
		}
		listaidAss = Costanti.SEPARATORE_PROV.getCostante() +  buf.toString();

		
		for(EntiCompilatoriModel sel : listaRicercati) {
			Long idEnteCompSelez = sel.getIdEnteCompilatore();	

			log.info(methodName, "listaidAss " + listaidAss);
			log.info(methodName, "indexOf di -->  " + (Costanti.SEPARATORE_PROV.getCostante()+idEnteCompSelez.toString()+Costanti.SEPARATORE_PROV.getCostante()));
			log.info(methodName,"condizione "+  (listaidAss.indexOf((Costanti.SEPARATORE_PROV.getCostante()+idEnteCompSelez.toString()+Costanti.SEPARATORE_PROV.getCostante()))==-1));
			
			if(listaidAss.indexOf((Costanti.SEPARATORE_PROV.getCostante()+idEnteCompSelez.toString()+Costanti.SEPARATORE_PROV.getCostante()))==-1){
				if(idEnteCompSelez.equals(id)){
					listaAssociati.add(sel);
				}			
			}
		}
		return listaAssociati;
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
	
	/**
	 * resetta tutti i campi del form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="clean",method = {RequestMethod.POST})	
	public String clean(@ModelAttribute UtentiCompilatoriStep2Model utentiCompilatoriStep2Model,Model model,HttpSession session) {
		String methodName="clean";
		log.startMethod(methodName);		
		utentiCompilatoriStep2Model.setListaEntiCompilatoriRicercati((ArrayList)session.getAttribute(Costanti.LISTA_ENTI_COMPILATORI_RICERCATI.getCostante()));
		utentiCompilatoriStep2Model.setListaEntiAssociati((ArrayList)session.getAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante()));
		utentiCompilatoriStep2Model.setRagioneSociale("");
		utentiCompilatoriStep2Model.setComune("");
		utentiCompilatoriStep2Model.setCodiceFiscale("");
		utentiCompilatoriStep2Model.setPartitaIva("");
		model.addAttribute("utentiCompilatoriStep2Model", utentiCompilatoriStep2Model);		
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/modificaUtentiCompilatoriStep2.jsp");		
		return "/GestioneUtentiComp/modificaUtentiCompilatoriStep2";
	}
}


