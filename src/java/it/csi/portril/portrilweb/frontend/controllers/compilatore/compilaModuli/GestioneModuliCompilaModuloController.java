/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.compilatore.compilaModuli;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneReport;
import it.csi.portril.portrilweb.business.interfaces.compilatori.BusinessGestioneModuliCompilatore;
import it.csi.portril.portrilweb.dto.MsgAllert;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.CellaModuloModel;
import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.GestioneModuliCompilaModuloModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.model.exception.ControlloFormaleException;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.util.Utility;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/compilatore/gestioneModuliCompilaModulo")
public class GestioneModuliCompilaModuloController extends ControllerBase {

	private LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneModuliCompilatore businessGestioneModuliCompilatore;

	@Autowired
	protected BusinessGestioneReport bmGestioneReport;

	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;
	
	@Autowired
	protected BusinessGestioneEntiCompilatori businessGestioneEntiCompilatori;

	@Autowired
	protected BusinessGestioneModuli businessGestioneModuli;

	/**
	 * 
	 * @param moduliModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "start",method = {RequestMethod.GET})
	public String start(@ModelAttribute GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel,Model model,HttpSession session) {
		String methodName = "start";
		log.startMethod(methodName);		
		session.removeAttribute(Costanti.FORM.getCostante());
		session.removeAttribute("listFiltri");
		gestioneModuliCompilaModuloModel = initForm(gestioneModuliCompilaModuloModel, model, session);		
		log.stopMethod(methodName + " vado alla pagina /CompilaModuli/compilaModuli.jsp");
		return "/CompilaModuli/compilaModuli";
	}

	/**
	 * 
	 * @param moduliModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "filtraRighe", method = {RequestMethod.POST})
	public String filtraRighe(@ModelAttribute GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel,Model model,HttpSession session) {
		String methodName = "filtraRighe";
		log.startMethod(methodName);		
		List<String> listFiltri = gestioneModuliCompilaModuloModel.getCampoFiltro();
		session.setAttribute("listFiltri", listFiltri);		
		gestioneModuliCompilaModuloModel = initForm(gestioneModuliCompilaModuloModel, model, session);	
		gestioneModuliCompilaModuloModel.setCampoFiltro(listFiltri);		
		log.stopMethod(methodName + " vado alla pagina /CompilaModuli/compilaModuli.jsp");
		return "/CompilaModuli/compilaModuli";
	}

	private GestioneModuliCompilaModuloModel initForm( GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel,Model model, HttpSession session) {
		String methodName = "initForm";
		Long idModuloSel = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());			
		Long idEnteCompilatore = super.getIdEnteCompilatoreSelezionato(session);

		if(session.getAttribute(Costanti.FORM.getCostante())==null){
			ModuliModel modulo = bmGestioneModuli.getModuloForId(idModuloSel);
			List<ColonneModuloModel> listaColonne = bmGestioneModuli.getColonneByIdModulo(idModuloSel,Costanti.COMPILATORE.getCostante() );
			modulo.setListaColonneModulo(listaColonne);
			gestioneModuliCompilaModuloModel.setModulo(modulo);
			EntiCompilatoriModel entecomp = businessGestioneEntiCompilatori.getEntiCompilatoriById(idEnteCompilatore);
			gestioneModuliCompilaModuloModel.setEntiCompilatori(entecomp);
			gestioneModuliCompilaModuloModel.setUtentiCompilatori(super.getUtenteCompilatoreConnesso(session));
			session.setAttribute(Costanti.FORM.getCostante(),gestioneModuliCompilaModuloModel);
			session.setAttribute("gestioneModuliCompilaModuloModel",gestioneModuliCompilaModuloModel);		
		}else{
			GestioneModuliCompilaModuloModel form =(GestioneModuliCompilaModuloModel)session.getAttribute(Costanti.FORM.getCostante());
			gestioneModuliCompilaModuloModel.setModulo(form.getModulo());
			gestioneModuliCompilaModuloModel.setEntiCompilatori(form.getEntiCompilatori());
			gestioneModuliCompilaModuloModel.setUtentiCompilatori(super.getUtenteCompilatoreConnesso(session));
		}				

		String muduloConf = businessGestioneModuli.presenteModuloConfermato(idModuloSel, idEnteCompilatore);
		
		if(muduloConf!=null){
			gestioneModuliCompilaModuloModel.setModuloConfermato(muduloConf);			
		}else{
			businessGestioneModuli.settaConfermaModuloCompilatore(idModuloSel,idEnteCompilatore,Costanti.NO.getCostante()); 
			gestioneModuliCompilaModuloModel.setModuloConfermato(Costanti.NO.getCostante());						
			gestioneModuliCompilaModuloModel.setModuloValidato(Costanti.NO.getCostante());						
		}
		if(session.getAttribute("listFiltri")==null){
			gestioneModuliCompilaModuloModel.setCampoFiltro(new ArrayList<String>());
		}
		
		return gestioneModuliCompilaModuloModel;
	}

	/**
	 * 
	 * @param gestioneModuliCompilaModuloModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "eliminaRighe",method = {RequestMethod.POST})
	public String eliminaRighe(@ModelAttribute GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel,Model model,HttpSession session) {
		String methodName = "eliminaRighe";
		log.startMethod(methodName);
		String   listaId = gestioneModuliCompilaModuloModel.getListaIdDaEliminare();
		//String[] sLista = listaId.substring(listaId.length()).split(",");			

		String[] sLista = listaId.split(",");		
		
		if(sLista!=null && sLista.length>0){
			businessGestioneModuliCompilatore.cancellaRigheSelezionate(sLista) ;			
		}
		gestioneModuliCompilaModuloModel = initForm(gestioneModuliCompilaModuloModel, model, session);
		log.stopMethod(methodName + " vado alla pagina /CompilaModuli/compilaModuli.jsp");
		return "/CompilaModuli/compilaModuli";
	}
	
	/**
	 * 
	 * @param gestioneModuliCompilaModuloModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "confermaModulo",method = {RequestMethod.POST})
	public String confermaModulo(@ModelAttribute GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel,Model model,HttpSession session) {
		String methodName = "confermaModulo";
		log.startMethod(methodName);		
		Long idModuloSel = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		Long idEnteCompilatore = getIdEnteCompilatoreSelezionato(session);
		
		businessGestioneModuli.settaConfermaModuloCompilatore(idModuloSel, idEnteCompilatore,Costanti.SI.getCostante());	
		
		gestioneModuliCompilaModuloModel = initForm(gestioneModuliCompilaModuloModel, model, session);	
		gestioneModuliCompilaModuloModel.setModuloConfermato(Costanti.SI.getCostante());
		log.stopMethod(methodName + " vado alla pagina /CompilaModuli/compilaModuli.jsp");
		return "/CompilaModuli/compilaModuli";
	}

	/**
	 * 
	 * @param gestioneModuliCompilaModuloModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "aggiungiRigaOld",method = {RequestMethod.POST})
	public String aggiungiRigaOld(@ModelAttribute GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel,Model model,HttpSession session) {
		String methodName = "aggiungiRigaOld";
		log.startMethod(methodName);
		
		List<String> listaCelleDaInserire 		= gestioneModuliCompilaModuloModel.getCelleDaInserire();
		Long idModuloSel                        = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());	
		Long idUtenteCompilatore                = super.getUtenteCompilatoreConnesso(session).getIdUtenteCompilatore();
		Long idEnteCompilatore                  = super.getIdEnteCompilatoreSelezionato(session);		
		List<ColonneModuloModel> listaColonne   = bmGestioneModuli.getColonneByIdModulo(idModuloSel);

		
		//List<List<String>> griglia            = gestioneModuliCompilaModuloModel.getGrigliaValori();		
		//List<RigaModuloModel> listaRighe      = new ArrayList<RigaModuloModel>();
		List<String> listaErrori              	= new ArrayList<String>();
		List<String> msgWarning               	= new ArrayList<String>();

		RigaModuloModel riga =  inizializzaRiga(
												listaColonne,
												gestioneModuliCompilaModuloModel.getCelleDaInserire(),
												idModuloSel,
												idUtenteCompilatore,
												idEnteCompilatore,
												getNumeroRigheTotaliDelModulo(session)
												);
		
		List<MsgAllert> listMsg=new ArrayList<MsgAllert>();
		try {
			listMsg = businessGestioneModuliCompilatore.controlloFormaleRiga(idModuloSel, riga);
			
		} catch (ControlloFormaleException e) {
			listMsg.add(new MsgAllert(Costanti.ERR.getCostante(),CostantiERR.ERR_INTERNO.getCostante() + e.getMessage()));
			log.error(methodName, e);
		}
	
		log.debug(methodName, "lista elementi da visualizzare a video " + listMsg.size());

		listaErrori = Utility.getlistMsg(listMsg,Costanti.ERR.getCostante());
		msgWarning  = Utility.getlistMsg(listMsg,Costanti.WARN.getCostante());	
			
		if(CollectionUtils.isEmpty(listaErrori)){					
			//TODO inserisci riga
			//bmGestioneReport.aggiornaRighe(idModuloSel,idEnteCompilatore,listaRighe);		
			addOneMsgSuccess(model,Costanti.LOAD_MODULO_OK.getCostante());
			addMsgWarning(model, msgWarning,CollectionUtils.isNotEmpty(msgWarning) );
		}else{			
			addMsgError(model, listaErrori, true);
		}

		gestioneModuliCompilaModuloModel = initForm(gestioneModuliCompilaModuloModel, model, session);
		
		log.stopMethod(methodName + " vado alla pagina /CompilaModuli/compilaModuli.jsp");
		return "/CompilaModuli/compilaModuli";
	}

	private RigaModuloModel inizializzaRiga(
			List<ColonneModuloModel> listaColonne,
			List<String> celleDaInserire, Long idModuloSel,
			Long idUtenteCompilatore, Long idEnteCompilatore,Integer posizioneRiga) {
		
		RigaModuloModel newRiga =new RigaModuloModel();
		newRiga.setIdModulo(idModuloSel);
		newRiga.setIdEnteCompilatore(idEnteCompilatore);
		newRiga.setIdUtenteCompilatore(idUtenteCompilatore);		
		newRiga.setFlgValidazione(Costanti.NO.getCostante());		
		newRiga.setPosizione(posizioneRiga);
		List<CellaModuloModel> listaNewCelleModulo = new ArrayList<CellaModuloModel>();

		
		for(int i = 0; i < listaColonne.size() ;i++){
			ColonneModuloModel colonna =  listaColonne.get(i);			
			//for(ColonneModuloModel colonna: listaColonne){
			if(Costanti.COMPILATORE.getCostante().equals(colonna.getEditabilitaProfilo())){
				CellaModuloModel cella = new CellaModuloModel();
				cella.setIdColonnaModulo(colonna.getIdColonnaModulo());
				cella.setPosizioneColonna(colonna.getPosizione());
				cella.setEditabilitaProfilo(Costanti.COMPILATORE.getCostante());
				cella.setPosizioneRiga(posizioneRiga);
				cella.setValore(celleDaInserire.get(i));
				listaNewCelleModulo.add(cella);
			}	
		}
		newRiga.setListaCelleModulo(listaNewCelleModulo);
		return newRiga;
	}

	/**
	 * 
	 * @param gestioneModuliCompilaModuloModel
	 * @return
	 */
	@ModelAttribute("gestioneModuliCompilaModuloModel")
	public GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel(GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel) {
		return new GestioneModuliCompilaModuloModel();
	}

	@RequestMapping(value = "salva",method = {RequestMethod.POST})
	public String salva(@ModelAttribute GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel,Model model,HttpSession session) {
		String methodName = "salva";
		log.startMethod(methodName);

		gestioneModuliCompilaModuloModel = initForm(gestioneModuliCompilaModuloModel, model, session);
		Long idModuloSel         = gestioneModuliCompilaModuloModel.getModulo().getIdModulo();
		Long idUtenteCompilatore = gestioneModuliCompilaModuloModel.getUtentiCompilatori().getIdUtenteCompilatore();
		Long idEnteCompilatore   = gestioneModuliCompilaModuloModel.getEntiCompilatori().getIdEnteCompilatore();
		
		List<ColonneModuloModel> listaColonne = gestioneModuliCompilaModuloModel.getModulo().getListaColonneModulo();
		List<List<String>> griglia            = gestioneModuliCompilaModuloModel.getGrigliaValori();
		List<RigaModuloModel> listaRighe      = new ArrayList<RigaModuloModel>();
		List<String> listaErrori              = new ArrayList<String>();
		List<String> msgWarning               = new ArrayList<String>();
		
		if(griglia!=null){
			listaRighe = businessGestioneModuliCompilatore.estraiRigheDaGriglia(griglia,
																				idModuloSel,
																				idUtenteCompilatore,
																				idEnteCompilatore,
																				Costanti.ALL.getCostante());
		
			List<MsgAllert> listMsg=new ArrayList<MsgAllert>();
			try {
				listMsg = businessGestioneModuliCompilatore.controlloFormaleRighe(idModuloSel,
																				  listaColonne.size(),
																				  listaRighe);
				
			} catch (ControlloFormaleException e) {
				listMsg.add(new MsgAllert(Costanti.ERR.getCostante(),CostantiERR.ERR_INTERNO.getCostante() + e.getMessage()));
				log.error(methodName, e);
			}
		
			log.debug(methodName, "lista elementi da visualizzare a video " + listMsg.size());

			listaErrori = Utility.getlistMsg(listMsg,Costanti.ERR.getCostante());
			msgWarning  = Utility.getlistMsg(listMsg,Costanti.WARN.getCostante());	
				
		}else{
			log.info(methodName, "elimino tutto e non aggiungo nulla");
		}

		if(CollectionUtils.isEmpty(listaErrori)){					
			bmGestioneReport.aggiornaInserisciRighe(idModuloSel,idEnteCompilatore,listaRighe);
			addOneMsgSuccess(model,Costanti.LOAD_MODULO_OK.getCostante());
			addMsgWarning(model, msgWarning,CollectionUtils.isNotEmpty(msgWarning) );
		}else{			
			addMsgError(model, listaErrori, true);
		}

		listaRighe = businessGestioneModuliCompilatore.estraiRigheDaGriglia(griglia,idModuloSel,idUtenteCompilatore,idEnteCompilatore,Costanti.COMPILATORE.getCostante());			

		gestioneModuliCompilaModuloModel.getModulo().setListaRigheModulo(listaRighe);		
		gestioneModuliCompilaModuloModel.setGrigliaValori(null);
		
		log.stopMethod(methodName + " vado alla pagina /CompilaModuli/compilaModuli.jsp");
		return "/CompilaModuli/compilaModuli";
	}

	
	/*
	 * 
	private boolean controlloNumeroCelleXModulo(int numColonne,List<RigaModuloModel> listaRigheModulo) {
		for (RigaModuloModel riga :listaRigheModulo ){
			if(riga.getListaCelleModulo().size()!=numColonne){
				return false;
			}
		}
		return true;
	}
 
	private void addPrimaRiga(GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel, Long idModuloSel) {	
		String methodName="addPrimaRiga";
		Long idUtenteCompilatore = gestioneModuliCompilaModuloModel.getUtentiCompilatori().getIdUtenteCompilatore();
		Long idEnteCompilatore   = gestioneModuliCompilaModuloModel.getEntiCompilatori().getIdEnteCompilatore();
		List<RigaModuloModel> listaRighe = new ArrayList<RigaModuloModel>();
		RigaModuloModel newRiga =new RigaModuloModel();
		newRiga.setIdModulo(idModuloSel);
		newRiga.setPosizione(1);
		newRiga.setFlgValidazione(Costanti.NO.getCostante());
		newRiga.setIdEnteCompilatore(idEnteCompilatore);
		newRiga.setIdUtenteCompilatore(idUtenteCompilatore);		
		List<CellaModuloModel> listaNewCelleModulo = new ArrayList<CellaModuloModel>();
		for(ColonneModuloModel colonna: gestioneModuliCompilaModuloModel.getModulo().getListaColonneModulo()){
			if(Costanti.COMPILATORE.getCostante().equals(colonna.getEditabilitaProfilo())){
				CellaModuloModel cella = new CellaModuloModel();
				cella.setIdColonnaModulo(colonna.getIdColonnaModulo());
				cella.setPosizioneColonna(colonna.getPosizione());
				cella.setEditabilitaProfilo(Costanti.COMPILATORE.getCostante());
				cella.setPosizioneRiga(listaRighe.size());
				listaNewCelleModulo.add(cella);
			}	
		}
			
		log.debug(methodName, "listaNewCelleModulo " + listaNewCelleModulo.size());
		newRiga.setListaCelleModulo(listaNewCelleModulo);		
		listaRighe.add(newRiga);
		gestioneModuliCompilaModuloModel.getModulo().setListaRigheModulo(listaRighe);
	}
*/

	
}