/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.gestioneRisultati;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneReport;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneUtentiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.compilatori.BusinessGestioneModuliCompilatore;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.CellaModuloModel;
import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.GestioneModuliCompilaModuloModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/gestore/compilaModuloXComunicazione")
public class CompilaModuloXComunicazioneController extends ControllerBase {

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
	protected BusinessGestioneUtentiCompilatori businessGestioneUtentiCompilatori;

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
		
		gestioneModuliCompilaModuloModel = initForm(gestioneModuliCompilaModuloModel, model, session);
		
		log.stopMethod(methodName + " vado alla pagina /GestioneRisultati/CompilaModuli/compilaModuli.jsp");
		return "/GestioneRisultati/CompilaModuli/compilaModuli";
	}

	private boolean controlloNumeroCelleXModulo(int numColonne,List<RigaModuloModel> listaRigheModulo) {
		for (RigaModuloModel riga :listaRigheModulo ){
			if(riga.getListaCelleModulo().size()!=numColonne){
				return false;
			}
		}
		return true;
	}

	
	/**
	 * 
	 * @param gestioneModuliCompilaModuloModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "aggiungiRiga",method = {RequestMethod.POST})
	public String aggiungiRiga(@ModelAttribute GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel,Model model,HttpSession session) {
		String methodName = "aggiungiRiga";
		log.startMethod(methodName);

		gestioneModuliCompilaModuloModel = initForm(gestioneModuliCompilaModuloModel,model, session);
		Long idModuloSel         = gestioneModuliCompilaModuloModel.getModulo().getIdModulo();
		Long idUtenteCompilatore = gestioneModuliCompilaModuloModel.getUtentiCompilatori().getIdUtenteCompilatore();
		Long idEnteCompilatore   = super.getIdEnteGestore(session);;

		
		gestioneModuliCompilaModuloModel.setGoToLastPage(true);

		List<List<String>> griglia       = gestioneModuliCompilaModuloModel.getGrigliaValori();
		List<RigaModuloModel> listaRighe = new ArrayList<RigaModuloModel>();
		
		if(griglia!=null){
			listaRighe = businessGestioneModuliCompilatore.estraiRigheDaGriglia(griglia,
																				idModuloSel,
																				idUtenteCompilatore,
																				idEnteCompilatore,
																				Costanti.COMPILATORE.getCostante());		
		}

		RigaModuloModel newRiga =new RigaModuloModel();
		newRiga.setIdModulo(idModuloSel);
		newRiga.setPosizione(listaRighe.size()+1);
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
		
		log.stopMethod(methodName + " vado alla pagina /GestioneRisultati/CompilaModuli/compilaModuli.jsp");
		return "/GestioneRisultati/CompilaModuli/compilaModuli";
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
		
		gestioneModuliCompilaModuloModel = initForm(gestioneModuliCompilaModuloModel,model, session);
		Long idModuloSel         = gestioneModuliCompilaModuloModel.getModulo().getIdModulo();
		Long idUtenteCompilatore = gestioneModuliCompilaModuloModel.getUtentiCompilatori().getIdUtenteCompilatore();
		Long idEnteCompilatore   = super.getIdEnteGestore(session);;

		List<List<String>> grigliaNonCeccati       = gestioneModuliCompilaModuloModel.getGrigliaValori();

		List<RigaModuloModel> listaRigheModulo =  businessGestioneModuliCompilatore.estraiRigheDaGriglia(grigliaNonCeccati,
																										idModuloSel,
																										idUtenteCompilatore,
																										idEnteCompilatore,
																										Costanti.COMPILATORE.getCostante());
		
		log.info(methodName, "listaRigheModulo " + listaRigheModulo.size());
		gestioneModuliCompilaModuloModel.getModulo().setListaRigheModulo(listaRigheModulo);

		log.stopMethod(methodName + " vado alla pagina /GestioneRisultati/CompilaModuli/compilaModuli.jsp");
		return "/GestioneRisultati/CompilaModuli/compilaModuli";
	}

	/**
	 * 
	 * @param gestioneModuliCompilaModuloModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "salva",method = {RequestMethod.POST})
	public String salva(@ModelAttribute GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel,Model model,HttpSession session) {
		String methodName = "salva";
		log.startMethod(methodName);

		gestioneModuliCompilaModuloModel = initForm(gestioneModuliCompilaModuloModel, model, session);
		
		Long idModuloSel         = gestioneModuliCompilaModuloModel.getModulo().getIdModulo();
		Long idUtenteCompilatore = gestioneModuliCompilaModuloModel.getUtentiCompilatori().getIdUtenteCompilatore();
		Long idEnteCompilatore   = super.getIdEnteGestore(session);;
		
		List<List<String>> griglia            = gestioneModuliCompilaModuloModel.getGrigliaValori();
		List<RigaModuloModel> listaRighe      = new ArrayList<RigaModuloModel>();
		
		if(griglia!=null){
			listaRighe = businessGestioneModuliCompilatore.estraiRigheDaGriglia(griglia,
																				idModuloSel,
																				idUtenteCompilatore,
																				idEnteCompilatore,
																				Costanti.COMPILATORE.getCostante());
					
		}else{
			log.info(methodName, "elimino tutto e non aggiungo nulla");
		}	
		
		//bmGestioneReport.aggiornaRighe(idModuloSel,idEnteCompilatore,listaRighe);	
		//addOneMsgSuccess(model,Costanti.LOAD_MODULO_OK.getCostante());	
		bmGestioneReport.aggiornaRigheAsync(idModuloSel,idEnteCompilatore,listaRighe);	
		addOneMsgSuccess(model,Costanti.LOAD_IN_CORSO.getCostante());
		
		gestioneModuliCompilaModuloModel.getModulo().setListaRigheModulo(listaRighe);		
		gestioneModuliCompilaModuloModel.setGrigliaValori(null);
		
		log.stopMethod(methodName + " vado alla pagina /GestioneRisultati/CompilaModuli/compilaModuli.jsp");
		return "/GestioneRisultati/CompilaModuli/compilaModuli";
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
	
	
	private GestioneModuliCompilaModuloModel initForm( GestioneModuliCompilaModuloModel gestioneModuliCompilaModuloModel,Model model, HttpSession session) {
		if(session.getAttribute(Costanti.FORM.getCostante())==null){
			Long idModuloSel                              = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
			Long idEnteGestore                            = super.getIdEnteGestore(session);		
			EntiCompilatoriModel   entiCompilatoriModel   = businessGestioneEntiCompilatori.getEnteCompilatoreFittizioByIdEnteGestore(idEnteGestore);
			UtentiCompilatoriModel utenteCompilatoreModel = businessGestioneUtentiCompilatori.getUtenteCompilatoreFittizioByIdEnteGestore(idEnteGestore);
			
			ModuliModel modulo = bmGestioneModuli.getModuloForId(idModuloSel);
			List<ColonneModuloModel> listaColonne  = bmGestioneModuli.getColonneByIdModulo(idModuloSel,Costanti.COMPILATORE.getCostante() );
			List<RigaModuloModel> listaRigheModulo = bmGestioneModuli.getRigheByIdModuloIdEnteCompilatore( idModuloSel,entiCompilatoriModel.getIdEnteCompilatore() ,Costanti.COMPILATORE.getCostante());

			if(!controlloNumeroCelleXModulo(listaColonne.size(),listaRigheModulo)){
				addOneMsgError(model, CostantiERR.ERR_NUM_CELLE_COLONNE.getCostante());
			}

			modulo.setListaColonneModulo(listaColonne);
			modulo.setListaRigheModulo(listaRigheModulo);					
			gestioneModuliCompilaModuloModel.setModulo(modulo);

			gestioneModuliCompilaModuloModel.setEntiCompilatori(entiCompilatoriModel);
			session.setAttribute(Costanti.FORM.getCostante(),gestioneModuliCompilaModuloModel);

			gestioneModuliCompilaModuloModel.setUtentiCompilatori(utenteCompilatoreModel);
			session.setAttribute(Costanti.FORM.getCostante(),gestioneModuliCompilaModuloModel);

		}else{
			GestioneModuliCompilaModuloModel form =(GestioneModuliCompilaModuloModel)session.getAttribute(Costanti.FORM.getCostante());
			gestioneModuliCompilaModuloModel.setModulo(form.getModulo());
			gestioneModuliCompilaModuloModel.setEntiCompilatori(form.getEntiCompilatori());
			gestioneModuliCompilaModuloModel.setUtentiCompilatori(form.getUtentiCompilatori());
		}
					
		return gestioneModuliCompilaModuloModel;
	}

}