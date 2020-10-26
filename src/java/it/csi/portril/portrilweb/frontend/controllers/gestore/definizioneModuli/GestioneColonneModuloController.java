/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.definizioneModuli;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.dto.FeedbackError;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.GestioneColonneModuloModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.validator.InserisciColonnaModuloValidator;
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
@RequestMapping("/gestore/gestioneColonneModulo")
public class GestioneColonneModuloController extends ControllerBase{

	private  LogUtil log = new LogUtil(getClass());

	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;
	
	/**
	 * 
	 * @param gestioneColonneModuloModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute GestioneColonneModuloModel gestioneColonneModuloModel,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);				
			
		Long idModulo = (Long) session.getAttribute(Costanti.MODULOSEL.getCostante());
		log.debug(methodName, "idModulo " + idModulo);
		ModuliModel modulo= bmGestioneModuli.getModuloForId(idModulo);
		List<ColonneModuloModel> listaColonneModulo = (List<ColonneModuloModel>) session.getAttribute(Costanti.LISTACOLONNEDACLONARE.getCostante());
		if(listaColonneModulo == null){
			// caso di modulo non proveniente da copia modulo
			listaColonneModulo = modulo.getListaColonneModulo();
			// se e' di tipo comunicazione inposto la prima colonna affinchè sia valorizzata col codice fisc dell'ente compilatore
			if(listaColonneModulo.size()==0 && modulo.getTipo().equalsIgnoreCase(Costanti.TIPO_MODULO_COMUNICAZIONE.getCostante())){
				ColonneModuloModel colonnaModulo = new ColonneModuloModel();
				colonnaModulo.setLabelColonna(Costanti.COD_FIS_ENTE.getCostante());
				colonnaModulo.setPosizione(1);
				colonnaModulo.setEditabilitaProfilo(Costanti.COMPILATORE.getCostante());
				colonnaModulo.setTipo(Costanti.ALFANUMERICO.getCostante());
				colonnaModulo.setDimensioneMin(0);
				colonnaModulo.setDimensione(200);
				colonnaModulo.setFlagObbligatorieta(Costanti.NO.getCostante());
				colonnaModulo.setFlgCtrlContabilita(Costanti.NO.getCostante());	
				//ELIMINO CONCETTO BLOCCANTE E NON 
				//colonnaModulo.setFlgCtrlBloccante(Costanti.NO.getCostante());
				colonnaModulo.setValoreConfrontoOperatoreNumerico(0.0);
				colonnaModulo.setModificabile(Costanti.NO.getCostante());
				listaColonneModulo.add(colonnaModulo);
				
			}
		}else{
			log.debug(methodName, "arrivo da un copia modulo prendo le colonne dalla sessione precaricata con le colonne del modulo di partenza");
			session.removeAttribute(Costanti.LISTACOLONNEDACLONARE.getCostante());
		}
		
		session.setAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante(),listaColonneModulo);	
		gestioneColonneModuloModel.setModulo(modulo);
		gestioneColonneModuloModel.setListaColonneModulo(listaColonneModulo);
			
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/gestioneColonneModulo.jsp");
		return "/DefinizioneModuli/gestioneColonneModulo";
	}


	/**
	 * 
	 * @param gestioneColonneModuloModel
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="inserisciColonnaModulo",method = {RequestMethod.POST})	
	public String inserisciColonnaModulo(@Valid @ModelAttribute GestioneColonneModuloModel gestioneColonneModuloModel,BindingResult result,Model model, HttpSession session) {
		String methodName="inserisciColonnaModulo";
		log.startMethod(methodName);
		Long idModulo = (Long) session.getAttribute(Costanti.MODULOSEL.getCostante());
		
		//ModuliModel modulo=gestioneColonneModuloModel.getModulo();		
		log.debug(methodName, "idModulo " + idModulo);
		ModuliModel modulo= bmGestioneModuli.getModuloForId(idModulo);		
		//validatore 
		InserisciColonnaModuloValidator validatore = new InserisciColonnaModuloValidator(); 
		validatore.validate(gestioneColonneModuloModel, result);
		
		gestioneColonneModuloModel = gestisciVisibilita(gestioneColonneModuloModel,result);
		gestioneColonneModuloModel.setIdModulo(idModulo);				
		List<ColonneModuloModel> listaColonneModulo = (List<ColonneModuloModel>)session.getAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante());	
		FeedbackError feedback = gestisciSuccessWarningErrors(model,result,"/DefinizioneModuli/gestioneColonneModulo" );		
		if (!feedback.isErrorePresente()){		
			ColonneModuloModel nuovaColonna = mapper.map(gestioneColonneModuloModel, ColonneModuloModel.class);	
			nuovaColonna.setTipo(gestioneColonneModuloModel.getTipoValore());
			//Controllo che per i moduli di tipo comunicazione non si possa modificare la colonna in posizione 1
			if(modulo.getTipo().equals(Costanti.TIPO_MODULO_COMUNICAZIONE.getCostante()) && nuovaColonna.getPosizione().equals(1)){
				addOneMsgError(model, CostantiERR.ERR_POS_COLONNA.getCostante(), true);
			}else{
				listaColonneModulo = aggiungiColonna(listaColonneModulo ,nuovaColonna );
			}
			
		}else{	
			log.error(methodName, feedback.toStringErr());
		}		
		//ordino la lista in base alla posizione
		// ArrayList da ordinare
		//Collections.sort(listaColonneModulo, new ColonneModuloComparator());		
		gestioneColonneModuloModel.setListaColonneModulo(listaColonneModulo);
		session.setAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante(),listaColonneModulo);
		gestioneColonneModuloModel.setLabelColonna("");
		gestioneColonneModuloModel.setEditabilitaProfilo(Costanti.COMPILATORE.getCostante());	
		gestioneColonneModuloModel.setFlgCtrlContabilita(Costanti.NO.getCostante());
		//ELIMINO CONCETTO BLOCCANTE E NON 
		//gestioneColonneModuloModel.setFlgCtrlBloccante(Costanti.NO.getCostante());
		gestioneColonneModuloModel.setFlagObbligatorieta(Costanti.NO.getCostante());
		log.stopMethod(methodName+" vado alla pagina "+feedback.getDestinazione());
		return feedback.getDestinazione();   
	}

	
	/**
	 * 
	 * @param gestioneColonneModuloModel
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	//@RequestMapping(value="salvaColonneModulo",method = {RequestMethod.POST})	Non funzionava provare con il GET
	@RequestMapping(value="salvaColonneModulo")	
	public String salvaColonneModulo(@ModelAttribute GestioneColonneModuloModel gestioneColonneModuloModel,BindingResult result,Model model, HttpSession session) {
		String methodName="salvaColonneModulo";
		log.startMethod(methodName);
		Long idModulo = (Long) session.getAttribute(Costanti.MODULOSEL.getCostante());				
		ModuliModel modulo= bmGestioneModuli.getModuloForId(idModulo);		
		log.debug(methodName, "modulo salvato ID  " + modulo.getIdModulo());		
		List<ColonneModuloModel> listaColonneModulo = (List<ColonneModuloModel>) session.getAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante());		//qui ok
		modulo.setListaColonneModulo(listaColonneModulo);		
		log.info(methodName," lista colonne len " + listaColonneModulo.size()); 		
		bmGestioneModuli.salvaModuloEColonne(modulo);	
		log.stopMethod(methodName + " vado alla pagina /gestore/insDefinModuli/goToTestataAfterSave.do");
		return "redirect:/gestore/insDefinModuli/goToTestataAfterSave.do";	
	}

	/**
	 * 
	 * @param gestioneColonneModuloModel
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="annulla",method = {RequestMethod.POST})	
	public String annulla(@Valid @ModelAttribute GestioneColonneModuloModel gestioneColonneModuloModel,BindingResult result,Model model, HttpSession session) {
		String methodName="annulla";
		log.startMethod(methodName);
		model.addAttribute("gestioneColonneModuloModel", new GestioneColonneModuloModel());
		session.setAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante(),new ArrayList<ColonneModuloModel>());
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/gestioneColonneModulo");
		return "/DefinizioneModuli/gestioneColonneModulo";
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
		model.addAttribute("gestioneColonneModuloModel", new GestioneColonneModuloModel());
		session.setAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante(),new ArrayList<ColonneModuloModel>());		
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/gestioneColonneModulo.jsp");
		return "/DefinizioneModuli/gestioneColonneModulo";
	}

	/**
	 * 
	 * @param gestioneColonneModuloModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="cancellaColonnaModulo",method = {RequestMethod.POST})	
	public String cancellaColonnaModulo( @ModelAttribute GestioneColonneModuloModel gestioneColonneModuloModel,Model model,HttpSession session) {
		String methodName="cancellaColonnaModulo";
		log.startMethod(methodName);		
		Integer posizioneDaEliminare = gestioneColonneModuloModel.getIdPosizioneSel();		
		List<ColonneModuloModel> listaColonneModulo = (List<ColonneModuloModel>) session.getAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante());
		for(int i=0;i<listaColonneModulo.size();i++){
			ColonneModuloModel colonna = listaColonneModulo.get(i);
			if(posizioneDaEliminare.equals(colonna.getPosizione())){
				listaColonneModulo.remove(i);
			}
		}
		gestioneColonneModuloModel.setListaColonneModulo(listaColonneModulo);
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/gestioneColonneModulo.jsp");
		return "/DefinizioneModuli/gestioneColonneModulo";
	}
		
	/**
	 * 
	 * @param gestioneColonneModuloModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="modificaColonnaModulo",method = {RequestMethod.POST})	
	public String modificaColonnaModulo(@ModelAttribute GestioneColonneModuloModel gestioneColonneModuloModel,Model model,HttpSession session) {
		String methodName="modificaColonnaModulo";
		log.startMethod(methodName);
		Integer posizioneDaModificare = gestioneColonneModuloModel.getIdPosizioneSel();
		log.debug(methodName, "posizioneDaModificare " + posizioneDaModificare);
		List<ColonneModuloModel> listaColonneModulo = (List<ColonneModuloModel>) session.getAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante());
		for(int i=0;i<listaColonneModulo.size();i++){
			ColonneModuloModel colonna = listaColonneModulo.get(i);			
			if(posizioneDaModificare.equals(colonna.getPosizione())){
				gestioneColonneModuloModel = mapper.map(colonna, GestioneColonneModuloModel.class);
				gestioneColonneModuloModel.setTipoValore(colonna.getTipo());
				gestioneColonneModuloModel.setSelected(colonna.getTipo());
				gestioneColonneModuloModel.setListaColonneModulo(listaColonneModulo);		
				gestioneColonneModuloModel.setPosizioneProposta(posizioneDaModificare);
				listaColonneModulo.remove(i);
				session.setAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante(),listaColonneModulo);
				model.addAttribute("gestioneColonneModuloModel",gestioneColonneModuloModel);
			}
		}		
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/gestioneColonneModulo.jsp");
		return "/DefinizioneModuli/gestioneColonneModulo";
	}
	
	
	/**
	 * 
	 * @param gestioneColonneModuloModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="copiaColonnaModulo",method = {RequestMethod.POST})	
	public String copiaColonnaModulo(@ModelAttribute GestioneColonneModuloModel gestioneColonneModuloModel,Model model,HttpSession session) {
		String methodName="copiaColonnaModulo";
		log.startMethod(methodName);
		
		Integer posizioneDaCopiare = gestioneColonneModuloModel.getIdPosizioneSel();
		List<ColonneModuloModel> listaColonneModulo = (List<ColonneModuloModel>) session.getAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante());
	
		for(int i=0;i<listaColonneModulo.size();i++){
			ColonneModuloModel colonna = listaColonneModulo.get(i);
			if(posizioneDaCopiare.equals(colonna.getPosizione())){

				gestioneColonneModuloModel = mapper.map(colonna, GestioneColonneModuloModel.class);
				gestioneColonneModuloModel.setTipoValore(colonna.getTipo());
				gestioneColonneModuloModel.setSelected(colonna.getTipo());
				
				gestioneColonneModuloModel.setListaColonneModulo(listaColonneModulo);
								
				session.setAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante(),listaColonneModulo);
				model.addAttribute("gestioneColonneModuloModel",gestioneColonneModuloModel);
				
			}
		}
		
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/gestioneColonneModulo.jsp");
		return "/DefinizioneModuli/gestioneColonneModulo";
	}
	
	
	/**
	 * 
	 * @param cm
	 * @param result
	 * @return
	 */
	private GestioneColonneModuloModel  gestisciVisibilita(GestioneColonneModuloModel  cm, BindingResult result) {
		cm.setSelected("");
		if(result.hasErrors()){			
			cm.setSelected(cm.getTipoValore());
		}
		return cm;
	}
	
	
	/**
	 * 
	 * @param listaColonneModulo
	 * @param nuovaColonna
	 * @return
	 */
	private List<ColonneModuloModel> aggiungiColonna(List<ColonneModuloModel> listaColonneModulo,ColonneModuloModel nuovaColonna) {
		
		boolean inserito   = false;
		boolean incrementa = false;
		List<ColonneModuloModel> risultato = new ArrayList<ColonneModuloModel>();
		Integer nuovaPosizione =0;
		String methodName="aggiungiColonna";
		
		if(CollectionUtils.isEmpty(listaColonneModulo)){
			risultato.add(nuovaColonna);
			inserito   = true;
			return risultato;
		}
		
		for(ColonneModuloModel colonna :listaColonneModulo){
			
			if(colonna.getPosizione() < nuovaColonna.getPosizione()){
				risultato.add(colonna);
			}
			
			if(colonna.getPosizione()>nuovaColonna.getPosizione()){
				log.debug(methodName,"passo dal maggiore");
				if(!inserito){
					risultato.add(nuovaColonna);
					inserito   = true;
					incrementa = false;
				}
				
				if(incrementa){
					if(colonna.getPosizione().equals(nuovaPosizione)){
						nuovaPosizione = colonna.getPosizione()+1;
						colonna.setPosizione(nuovaPosizione);
						incrementa= true;
					}else{
						incrementa= false;
					}
								
				}
				risultato.add(colonna);				
			}
		
			if(colonna.getPosizione().equals(nuovaColonna.getPosizione())){
				//inserisco la nuova colonna
				risultato.add(nuovaColonna);
				
				incrementa=true;
				inserito = true;
				
				//traslo la colonna di 1 
				nuovaPosizione = colonna.getPosizione()+1;
				colonna.setPosizione(nuovaPosizione);
				// inserisco la vecchia colonna con la posizione incrementata
				risultato.add(colonna);
			}		
		}		
		if(!inserito){
			risultato.add(nuovaColonna);
		}			
		return risultato;
	}
}