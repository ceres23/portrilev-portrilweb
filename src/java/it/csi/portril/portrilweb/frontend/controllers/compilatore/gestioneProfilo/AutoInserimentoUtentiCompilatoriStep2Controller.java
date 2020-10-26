/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.compilatore.gestioneProfilo;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiGestori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiCompilatori;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.frontend.controllers.ControllerUtenteCompilatoreBase;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.EntiGestoriModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriStep2Model;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiWARN;
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
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/accessocompilatore/autoInserimentoUtentiCompilatoriStep2")
public class AutoInserimentoUtentiCompilatoriStep2Controller extends ControllerUtenteCompilatoreBase{
	
	private  LogUtil log = new LogUtil(getClass());
	@Autowired
	protected BusinessGestioneEntiCompilatori bmGestioneEntiCompilatori;
	
	@Autowired
	protected BusinessGestioneUtentiCompilatori bmGestioneUtentiCompilatori;

	@Autowired
	protected BusinessGestioneEntiGestori bmGestioneEntiGestori;

	/**
	 * 
	 * @param utentiCompilatoriStep2Model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute UtentiCompilatoriStep2Model utentiCompilatoriStep2Model,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);		
		//inizializzo le liste e le metto in sessione
		session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_RICERCATI.getCostante(),new ArrayList<EntiCompilatoriModel>());
		session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante(),new ArrayList<EntiCompilatoriModel>());
		utentiCompilatoriStep2Model.setCollapse("");
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/autoInsGestioneUtentiCompStep2.jsp");
		return "/GestioneProfilo/autoInserimentoUtentiCompilatoriStep2";
	}
	
	/**
	 * 
	 * @param utentiCompilatoriStep2Model
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="cercaEnte",method = {RequestMethod.POST})	
	public String cercaEnte(@Valid @ModelAttribute UtentiCompilatoriStep2Model utentiCompilatoriStep2Model,BindingResult result,Model model,HttpSession session) {
		String methodName="cercaEnte";
		log.startMethod(methodName);
		
		String ragioneSociale =utentiCompilatoriStep2Model.getRagioneSociale();
		String classificazione =utentiCompilatoriStep2Model.getClassificazione();
		String comune =utentiCompilatoriStep2Model.getComune();
		String codiceFiscale =utentiCompilatoriStep2Model.getCodiceFiscale();
		String partitaIva =utentiCompilatoriStep2Model.getPartitaIva();			
		//TODO da capire come fare ad identificare il gestore corretto
		Long idEnteGestore = null;//getUtenteCompilatoreConnesso(session).getIdEnteGestore();	
		
		List<EntiCompilatoriModel> listaEntiCompilatoriRicercati = bmGestioneEntiCompilatori.getEntiCompilatoriByIdEnteGestore(Costanti.ATTIVO.getCostante(), ragioneSociale,classificazione, comune, codiceFiscale, partitaIva,idEnteGestore);
		session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_RICERCATI.getCostante(), listaEntiCompilatoriRicercati);
		
		utentiCompilatoriStep2Model.setListaEntiCompilatoriRicercati(listaEntiCompilatoriRicercati);
		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/autoInserimentoUtentiCompilatoriStep2" );
		return "/GestioneProfilo/autoInserimentoUtentiCompilatoriStep2";
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

		log.debug(methodName, "ente associato selezionato" + utentiCompilatoriStep2Model.getIdEnteAssociato());
	
		// lista enti compilatori ricercati
		List<EntiCompilatoriModel> listaRicercati = (List<EntiCompilatoriModel>) session.getAttribute(Costanti.LISTA_ENTI_COMPILATORI_RICERCATI.getCostante());
		List<EntiCompilatoriModel> listaAssociati = (List<EntiCompilatoriModel>) session.getAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante());
		
		listaAssociati  = trasferisciElementoDiLista(listaRicercati,listaAssociati, utentiCompilatoriStep2Model.getIdEnteAssociato());

		session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante(),listaAssociati);
		
		utentiCompilatoriStep2Model.setListaEntiAssociati(listaAssociati);
		utentiCompilatoriStep2Model.setListaEntiCompilatoriRicercati(listaRicercati);
				
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/autoInserimentoUtentiCompilatoriStep2" );
		return "/GestioneProfilo/autoInserimentoUtentiCompilatoriStep2";
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
		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/autoInserimentoUtentiCompilatoriStep2" );
		return "/GestioneProfilo/autoInserimentoUtentiCompilatoriStep2";
	}

	
	/**
	 * 
	 * @param utentiCompilatoriStep2Model
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="salvaUtenteCompilatore",method = {RequestMethod.GET,RequestMethod.POST})	
	public String salvaUtenteCompilatore( @ModelAttribute UtentiCompilatoriStep2Model utentiCompilatoriStep2Model,BindingResult result,Model model,HttpSession session) {
		String methodName="salvaUtenteCompilatore";
		log.startMethod(methodName);
		
		UtentiCompilatoriModel utente            = (UtentiCompilatoriModel)session.getAttribute(Costanti.UTENTE_COMPILATORE.getCostante()) ;
		List<EntiCompilatoriModel> listaEntiComp = (List<EntiCompilatoriModel>)session.getAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante());
			
		if(CollectionUtils.isEmpty(listaEntiComp)){
			addOneMsgWarning(model, CostantiWARN.WARN_ENTE_COMP_OBBL.getCostante());			
			log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/autoInserimentoUtentiCompilatoriStep2" );
			return "/GestioneProfilo/autoInserimentoUtentiCompilatoriStep2";
		}
		
		//N.B. deduco l'ente gestore del nuovo utente dal gestore del'ente compilatore selezionato
		//per fare le cose per bene andrebbe gestita questa cosa in maschera
		//utente.setIdEnteGestore(listaEntiComp.get(0).getIdEnteGestore());		
		//EntiGestoriModel entegest = bmGestioneEntiGestori.getEnteGestoreById(listaEntiComp.get(0).getIdEnteGestore());
		int tentativi=1;
		
		
		utente = inserisciUtenteCompilatore(utente, listaEntiComp,tentativi);
		if(utente.getErrore()!=null && !utente.getErrore().equals("")){
			addOneMsgError(model, utente.getErrore());
		}else{			
			session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_RICERCATI.getCostante(),new ArrayList<EntiCompilatoriModel>());
			session.setAttribute(Costanti.LISTA_ENTI_COMPILATORI_ASSOCIATI.getCostante(),new ArrayList<EntiCompilatoriModel>());
	
			utentiCompilatoriStep2Model.setListaEntiAssociati(new ArrayList<EntiCompilatoriModel>());
			utentiCompilatoriStep2Model.setListaEntiCompilatoriRicercati(new ArrayList<EntiCompilatoriModel>());
			try {
				
				bmGestioneUtentiCompilatori.invioMailDaInserimentoUtenteCompilatore(
																											
																					utente.getMail(),
																					StringUtils.capitalize(utente.getNome().toLowerCase()),
																					StringUtils.capitalize(utente.getCognome().toLowerCase()),
																					utente.getLogin(),
																					utente.getPassword());
			} catch (MessagingException e) {
				log.error(methodName,e);
			}
		}
		log.stopMethod(methodName+" vado alla pagina /accessocompilatore/login/fromAutoLoginToLogin.do" );
		return "redirect:/accessocompilatore/login/fromAutoLoginToLogin.do";
	}


	private UtentiCompilatoriModel inserisciUtenteCompilatore(UtentiCompilatoriModel utente,List<EntiCompilatoriModel> listaEntiComp,int tentativi) {
		String methodName="inserisciUtenteCompilatore";
		try{
			utente = bmGestioneUtentiCompilatori.insUtenteCompilatore(utente,listaEntiComp,tentativi);	
			utente.setErrore("");
		}catch(Exception e){
			tentativi++;
			if(tentativi<=50){
				log.warn(methodName, "tentativo di login N°  " +  tentativi);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					log.error(methodName, "InterruptedException ",e1 );
					Thread.currentThread().interrupt();
				}
				inserisciUtenteCompilatore(utente,listaEntiComp,tentativi);	
				
			}else{
				String strErr = "Inserimento utente fallito (probabile problema temporaneo) si consiglia di riprovare piu' tardi se il problema dovesse persistere contattare l'assistenza ";
				if (e!=null){
					strErr = strErr+ e.getMessage();
				}
				utente.setErrore(strErr);
				log.error(methodName, "************************************************************** " );
				log.error(methodName, "** superati i 98 tentativi per la login gestire da servizio ** " );
				log.error(methodName, "************************************************************** " );
			}
			log.error(methodName, "riprovo un nuovo login " + e);
		}
		return utente;
	}
		
	/*
	private List<EntiCompilatoriModel> trasferisciElementoDiLista(List<EntiCompilatoriModel> listaRicercati,List<EntiCompilatoriModel> listaAssociati, Long id) {
		String listaidAss="-";
		
		StringBuffer buf = new StringBuffer();
		for(EntiCompilatoriModel selAss : listaAssociati) {
			buf.append(selAss.getIdEnteCompilatore()+"-");
		}
		listaidAss = buf.toString();
		
		for(EntiCompilatoriModel sel : listaRicercati) {
			Long idEnteCompSelez = sel.getIdEnteCompilatore();			
			if(listaidAss.indexOf(("-"+idEnteCompSelez.toString()+"-"))==-1){
				if(sel.getIdEnteCompilatore().equals(id)){
					listaAssociati.add(sel);
				}			
			}
		}
		return listaAssociati;
	}
	*/
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
	public String clean(Model model) {
		String methodName="clean";
		log.startMethod(methodName);
		
		model.addAttribute("utentiCompilatoriStep2Model", new UtentiCompilatoriStep2Model());
		
		log.stopMethod(methodName+" vado alla pagina /GestioneProfilo/autoInserimentoUtentiCompilatoriStep1.jsp");		
		return "/GestioneProfilo/autoInserimentoUtentiCompilatoriStep1";
	}

//	public static void main(String[] args){
//		System.out.println(StringUtils.capitalize("sdfsdTTTT".toLowerCase()));
//		
//	}
}


