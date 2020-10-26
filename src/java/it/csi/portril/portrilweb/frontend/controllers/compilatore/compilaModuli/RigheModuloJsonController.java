/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.compilatore.compilaModuli;

import java.util.ArrayList;
import java.util.List;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneReport;
import it.csi.portril.portrilweb.business.interfaces.compilatori.BusinessGestioneModuliCompilatore;
import it.csi.portril.portrilweb.dto.MsgAllert;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.CellaModuloModel;
import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.DataTableModel;
import it.csi.portril.portrilweb.model.GestioneModuliCompilaModuloModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.model.exception.ControlloFormaleException;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.DataTableWrapper;
import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.util.Utility;
import it.csi.portril.portrilweb.util.paginazione.ListaPaginata;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/compilatore/righeModuloJsonController")
public class RigheModuloJsonController extends ControllerBase {

	private LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneModuliCompilatore businessGestioneModuliCompilatore;

	@Autowired
	protected BusinessGestioneReport bmGestioneReport;

	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;
	
	@Autowired
	protected BusinessGestioneEntiCompilatori businessGestioneEntiCompilatori;
		

	@RequestMapping(value = "estraiListaRigheXModulo", produces={MediaType.APPLICATION_JSON_VALUE}, method={RequestMethod.GET})
	public @ResponseBody DataTableWrapper<RigaModuloModel> estraiListaRigheXModulo(HttpSession session , @ModelAttribute DataTableModel dataTableModel) {
		log.info("estraiListaRigheXModulo", "BEGIN");		
		List<String> listFiltri = (List<String>)session.getAttribute("listFiltri");		
		Long idModuloSel = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());		
		ListaPaginata<RigaModuloModel> righe = bmGestioneModuli.getRigheByIdModuloIdEnteCompilatorePaginato(idModuloSel, super.getIdEnteCompilatoreSelezionato(session),Costanti.COMPILATORE.getCostante(),listFiltri, dataTableModel.getNumeroPagina(), dataTableModel.getiDisplayLength());		
		DataTableWrapper<RigaModuloModel> res = new DataTableWrapper<RigaModuloModel>(dataTableModel, righe);
		setNumeroRigheTotaliDelModulo(righe.getTotaleElementi(), session);
		log.info("estraiListaRigheXModulo", "END");
		return res;		
	}

	@RequestMapping(value = "aggiungiRiga", produces={MediaType.APPLICATION_JSON_VALUE}, method={RequestMethod.POST})
	public @ResponseBody List<String> aggiungiRiga(HttpSession session , @ModelAttribute RigaModuloModel rigaModuloModel,Model model) {	
		String methodName = "aggiungiRiga";
		log.startMethod(methodName);				
		List<String> listaErrori  = analizzaSalvaRiga(session, rigaModuloModel,model);
		session.setAttribute("listFiltri",null);		
		return listaErrori;
	}

	private List<String> analizzaSalvaRiga(HttpSession session,RigaModuloModel rigaModuloModel, Model model) {
		String methodName = "analizzaSalvaRiga";	
		List<String> listaErrori = new ArrayList<String>();
		Long idModuloSel                        = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());	
		Long idUtenteCompilatore                = super.getUtenteCompilatoreConnesso(session).getIdUtenteCompilatore();
		Long idEnteCompilatore                  = super.getIdEnteCompilatoreSelezionato(session);		
		List<ColonneModuloModel> listaColonne   = bmGestioneModuli.getColonneByIdModulo(idModuloSel);


		RigaModuloModel riga =  inizializzaRiga(
												listaColonne,
												rigaModuloModel,
												idModuloSel,
												idUtenteCompilatore,
												idEnteCompilatore
												);
				
		List<MsgAllert> listMsg=new ArrayList<MsgAllert>();		
		try {
			listMsg = businessGestioneModuliCompilatore.controlloFormaleRiga(idModuloSel, riga);
		} catch (ControlloFormaleException e) {
			listMsg.add(new MsgAllert(Costanti.ERR.getCostante(),CostantiERR.ERR_INTERNO.getCostante() + e.getMessage()));
			log.error(methodName, e);
		}
	
		log.info(methodName, "lista elementi da visualizzare a video " + listMsg.size());

		listaErrori = Utility.getlistMsg(listMsg);
			
		if(CollectionUtils.isEmpty(listaErrori)){		
			//TODO inserisci riga
			bmGestioneReport.aggiornaInserisciRiga(idModuloSel,idEnteCompilatore,riga);							
			addOneMsgSuccess(model,Costanti.LOAD_MODULO_OK.getCostante());
		}else{			
			addMsgError(model, listaErrori, true);
		}
		return listaErrori;
	}
	
	
	private RigaModuloModel inizializzaRiga(
			List<ColonneModuloModel> listaColonne,
			RigaModuloModel rigaModuloModel,
			Long idModuloSel,
			Long idUtenteCompilatore,
			Long idEnteCompilatore) {
		
		List<String> celleDaInserire = rigaModuloModel.getCelleDaInserire();
		
		RigaModuloModel newRiga =new RigaModuloModel();
		Integer posizioneRiga = 1;

		//caso modifica contenuto cella
		if(rigaModuloModel.getIdRiga()!=null && rigaModuloModel.getIdRiga()!=0){
			newRiga = businessGestioneModuliCompilatore.getRigByIdRiga(rigaModuloModel.getIdRiga()) ;
			posizioneRiga = newRiga.getPosizione(); 
		}else{
			posizioneRiga = businessGestioneModuliCompilatore.getMaxPosizioneRigaByIdModuloIdEnteCompilatore(idModuloSel,idEnteCompilatore);
					
			newRiga.setIdModulo(idModuloSel);
			newRiga.setIdEnteCompilatore(idEnteCompilatore);
			newRiga.setIdUtenteCompilatore(idUtenteCompilatore);		
			newRiga.setFlgValidazione(Costanti.NO.getCostante());		
			newRiga.setPosizione(posizioneRiga+1);
			newRiga.setTipo(Costanti.COMPILATORE.getCostante());
		}
		
		List<CellaModuloModel> listaNewCelleModulo = new ArrayList<CellaModuloModel>();		
		for(int i = 0; i < listaColonne.size() ;i++){
			ColonneModuloModel colonna =  listaColonne.get(i);			
			if(Costanti.COMPILATORE.getCostante().equals(colonna.getEditabilitaProfilo())){
				CellaModuloModel cella = new CellaModuloModel();
				cella.setIdColonnaModulo(colonna.getIdColonnaModulo());
				cella.setPosizioneColonna(colonna.getPosizione());
				cella.setEditabilitaProfilo(Costanti.COMPILATORE.getCostante());
				cella.setPosizioneRiga(posizioneRiga+1);
				cella.setValore(celleDaInserire.get(i));
				listaNewCelleModulo.add(cella);
			}	
		}
		newRiga.setListaCelleModulo(listaNewCelleModulo);
		return newRiga;
	}
		
	@RequestMapping(value = "modificaRiga", produces={MediaType.APPLICATION_JSON_VALUE}, method={RequestMethod.POST})
	public @ResponseBody List<String> modificaRiga(HttpSession session , @ModelAttribute RigaModuloModel rigaModuloModel,Model model) {	
		String methodName = "modificaRiga";
		log.startMethod(methodName);
		List<String> ris = new ArrayList<String>();
		List<CellaModuloModel> listaCelle =businessGestioneModuliCompilatore.estraiCelleByIdRiga(rigaModuloModel.getIdRiga());
		for(CellaModuloModel cella :listaCelle){
			ris.add(cella.getValore());
		}
		return ris;
	}
	
	@RequestMapping(value = "confermaModificaRiga", produces={MediaType.APPLICATION_JSON_VALUE}, method={RequestMethod.POST})
	public @ResponseBody List<String> confermaModificaRiga(HttpSession session , @ModelAttribute RigaModuloModel rigaModuloModel,Model model) {	
		String methodName = "confermaModificaRiga";
		log.startMethod(methodName);
		List<String> listaErrori  = analizzaSalvaRiga(session, rigaModuloModel,model);		
		session.setAttribute("listFiltri",null);		
		return listaErrori;
	}
	
}