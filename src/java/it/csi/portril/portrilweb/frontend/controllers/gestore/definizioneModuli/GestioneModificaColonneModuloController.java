/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
/**
 * 
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

/**
 * @author Haitham,Benedetto
 *
 */
@Controller
@RequestMapping("/gestore/gestioneModificaColonneModulo")
public class GestioneModificaColonneModuloController extends ControllerBase{

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
		ModuliModel modulo= bmGestioneModuli.getModuloForId(idModulo);
		
		List<ColonneModuloModel> listaColonneModulo = modulo.getListaColonneModulo();
		
		//nel caso stia gestendo un modulo copia di un'altro 
		//devo preimpostare le colonne uguali a quello di partenza ma con l'idModulo del nuovo modulo
		listaColonneModulo = gestioneColonneCopiaDaModulo(session, idModulo,listaColonneModulo);
		session.setAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante(),listaColonneModulo);	
		
		gestioneColonneModuloModel.setModulo(modulo);
		gestioneColonneModuloModel.setListaColonneModulo(listaColonneModulo);
		gestioneColonneModuloModel.setStrutturaModificabile(bmGestioneModuli.isStrutturaModuloModificabile(idModulo));
		
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/gestioneModificaColonneModulo.jsp");
		return "/DefinizioneModuli/gestioneModificaColonneModulo";
	}

	
	/**
	 * 
	 * @param session
	 * @param idModulo
	 * @param listaColonneModulo
	 * @return
	 */
	private List<ColonneModuloModel> gestioneColonneCopiaDaModulo(HttpSession session,Long idModulo, List<ColonneModuloModel> listaColonneModulo) {
		// se arrivo da una copia devo preimpostare le colonne come quelle del mdulo da cui 
		// voglio copiare
		Long idModuloCopia = (Long)session.getAttribute(Costanti.IDMODULO_DA_COPIARE.getCostante());
		if(idModuloCopia!=null){
			ModuliModel modulo2= bmGestioneModuli.getModuloForId(idModuloCopia);
			listaColonneModulo = modulo2.getListaColonneModulo();
			for(int a=0;a<listaColonneModulo.size();a++){
				listaColonneModulo.get(a).setIdModulo(idModulo);
				listaColonneModulo.get(a).setIdColonnaModulo(null);
			}
		}
		session.removeAttribute(Costanti.IDMODULO_DA_COPIARE.getCostante());
		return listaColonneModulo;
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
		FeedbackError feedback = gestisciSuccessWarningErrors(model,result,"/DefinizioneModuli/gestioneModificaColonneModulo" );
		
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
			
		gestioneColonneModuloModel.setListaColonneModulo(listaColonneModulo);
		session.setAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante(),listaColonneModulo);
		gestioneColonneModuloModel.setLabelColonna("");
		gestioneColonneModuloModel.setEditabilitaProfilo(Costanti.COMPILATORE.getCostante());
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
	@RequestMapping(value="salvaColonneModulo",method = {RequestMethod.POST})	
	public String salvaColonneModulo(@ModelAttribute GestioneColonneModuloModel gestioneColonneModuloModel,BindingResult result,Model model, HttpSession session) {
		String methodName="salvaColonneModulo";
		log.startMethod(methodName);

		Long idModulo = (Long) session.getAttribute(Costanti.MODULOSEL.getCostante());				
		ModuliModel modulo= bmGestioneModuli.getModuloForId(idModulo);		
		log.info(methodName, "modulo salvato ID  " + modulo.getIdModulo());
		
		List<ColonneModuloModel> listaColonneModulo = (List<ColonneModuloModel>) session.getAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante());
		modulo.setListaColonneModulo(listaColonneModulo);		

		log.info(methodName," lista colonne len " + listaColonneModulo.size()); 
		bmGestioneModuli.salvaModuloEColonne(modulo);
	
		addOneMsgSuccess(model, Costanti.MSG_MODULO_OK.getCostante());
		log.stopMethod(methodName + " vado alla pagina redirect:/gestore/modificaModuli/start.do");
		return "redirect:/gestore/modificaModuli/start.do";	
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

		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/gestioneModificaColonneModulo");
		return "/DefinizioneModuli/gestioneModificaColonneModulo";
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
		
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/gestioneModificaColonneModulo.jsp");
		return "/DefinizioneModuli/gestioneModificaColonneModulo";
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
		session.setAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante(), listaColonneModulo);

		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/gestioneModificaColonneModulo.jsp");
		return "/DefinizioneModuli/gestioneModificaColonneModulo";
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
		
		log.info(methodName, "posizioneDaModificare " + posizioneDaModificare);
		List<ColonneModuloModel> listaColonneModulo = (List<ColonneModuloModel>) session.getAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante());
	
		for(int i=0;i<listaColonneModulo.size();i++){
			ColonneModuloModel colonna = listaColonneModulo.get(i);
			
			if(posizioneDaModificare.equals(colonna.getPosizione())){
				gestioneColonneModuloModel = mapper.map(colonna, GestioneColonneModuloModel.class);
				gestioneColonneModuloModel.setTipoValore(colonna.getTipo());
				gestioneColonneModuloModel.setSelected(colonna.getTipo());
				gestioneColonneModuloModel.setListaColonneModulo(listaColonneModulo);	
				gestioneColonneModuloModel.setPosizioneProposta(posizioneDaModificare);
				gestioneColonneModuloModel.setDimensioneMin(colonna.getDimensioneMin());
				gestioneColonneModuloModel.setDimensione(colonna.getDimensione());
				
				listaColonneModulo.remove(i);
				session.setAttribute(Costanti.LISTA_COLONNE_MODULO.getCostante(),listaColonneModulo);
				model.addAttribute("gestioneColonneModuloModel",gestioneColonneModuloModel);
			}
		}
		
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/gestioneModificaColonneModulo.jsp");
		return "/DefinizioneModuli/gestioneModificaColonneModulo";
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
		log.stopMethod(methodName+" vado alla pagina /DefinizioneModuli/gestioneModificaColonneModulo.jsp");
		return "/DefinizioneModuli/gestioneModificaColonneModulo";
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
	 * @param colonneModuloModel
	 * @return
	 */
	private List<ColonneModuloModel> aggiungiColonna(List<ColonneModuloModel> listaColonneModulo,ColonneModuloModel colonneModuloModel) {	
		//String methodName="aggiungiColonna";
		
		boolean inserito   = false;
		boolean incrementa = false;
		List<ColonneModuloModel> risultato = new ArrayList<ColonneModuloModel>();
		Integer nuovaPosizione = 0;

		if(CollectionUtils.isEmpty(listaColonneModulo)){
			risultato.add(colonneModuloModel);
			inserito   = true;
		}
		
		for(ColonneModuloModel colonna :listaColonneModulo){
			
			if(colonna.getPosizione()<colonneModuloModel.getPosizione()){
				risultato.add(colonna);
			}
						
			if(colonna.getPosizione()>colonneModuloModel.getPosizione()){
				if(!inserito){
					risultato.add(colonneModuloModel);
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
		
			if(colonna.getPosizione().equals(colonneModuloModel.getPosizione())){
				//inserisco la nuova colonna
				risultato.add(colonneModuloModel);
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
			risultato.add(colonneModuloModel);
		}	
		return risultato;
	}
	
}

