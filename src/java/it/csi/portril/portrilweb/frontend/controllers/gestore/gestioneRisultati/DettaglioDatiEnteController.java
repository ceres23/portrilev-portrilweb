/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.gestioneRisultati;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneReport;
import it.csi.portril.portrilweb.dto.DownloadData;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.CellaModuloModel;
import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.DettaglioDatiEnteModel;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.util.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/gestore/dettaglioDatiEnte")

public class DettaglioDatiEnteController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	@Autowired
	protected BusinessGestioneEntiCompilatori bmGestioneEntiCompilatori;
	
	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;
	
	@Autowired
	protected BusinessGestioneReport bmGestioneReport;
	
	/**
	 * 
	 * @param dettaglioDatiEnteModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})
	public String start(@ModelAttribute DettaglioDatiEnteModel dettaglioDatiEnteModel ,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);
		session.removeAttribute(Costanti.DETTAGLIODATIENTE.getCostante());			
		Long idEnteCompilatore =(Long)session.getAttribute(Costanti.MOD_ENTE.getCostante());
		Long idModulo = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());		
		EntiCompilatoriModel entiCompilatoriModel     = bmGestioneEntiCompilatori.getEntiCompilatoriById(idEnteCompilatore);		
		List<ColonneModuloModel> listaColonneModulo   = bmGestioneModuli.getColonneByIdModulo(idModulo);	
		List<RigaModuloModel>    listaRigheModulo     = bmGestioneModuli.getRigheByIdModuloIdEnteCompilatore(idModulo,idEnteCompilatore);		
		log.debug(methodName, "listaRigheModulo   " + listaRigheModulo.size());
		log.debug(methodName, "listaColonneModulo " + listaColonneModulo.size());		
		dettaglioDatiEnteModel.setEntiCompilatoriModel(entiCompilatoriModel);
		dettaglioDatiEnteModel.setListaRigheModulo(listaRigheModulo);
		dettaglioDatiEnteModel.setListaColonneModulo(listaColonneModulo);
		buUtilTracciatura.insertCsiLogAudit(super.getUtenteGestoreConnesso(session), methodName, "visualizzazione dei dati dell'ente id= " +dettaglioDatiEnteModel.getEntiCompilatoriModel().getIdEnteCompilatore());
		session.setAttribute(Costanti.DETTAGLIODATIENTE.getCostante(), dettaglioDatiEnteModel);
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/dettaglioDatiEnte.jsp");
		return "/GestioneRisultati/dettaglioDatiEnte";
	}

/**
 * 	
 * @param dettaglioDatiEnteModel
 * @param session
 * @param request
 * @param response
 */
	@RequestMapping(value="esporta",method = {RequestMethod.POST})
	public void esporta(@ModelAttribute DettaglioDatiEnteModel dettaglioDatiEnteModel ,HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		String methodName="esporta";
		log.startMethod(methodName);
		//dettaglioDatiEnteModel= (DettaglioDatiEnteModel)session.getAttribute(Costanti.DETTAGLIODATIENTE.getCostante());		
		Long idModulo = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		ModuliModel modulo = bmGestioneModuli.getModuloForId(idModulo);
		try {
			String nomeModulo = new Utility().generaNomeModuloCsv(modulo.getNome());			
			DownloadData data = new DownloadData(Costanti.TIPO_FILE_CSV.getCostante(), nomeModulo, null);

			response.setHeader("Content-Disposition", 
								String.format("%s; filename=%s",
								data.getContentDisposition(),
								Utility.encodeFilenameForDownload(data.getFilename(),
								request.getHeader("user-agent"))));
			
			response.setContentType(data.getContentType());			
			//session.setAttribute(Costanti.COLONNEMODULO.getCostante(), listaColonneModulo);
			String ragioneSociale = dettaglioDatiEnteModel.getEntiCompilatoriModel().getRagioneSociale();			
			List<RigaModuloModel>    listarighe    = dettaglioDatiEnteModel.getListaRigheModulo();
			List<ColonneModuloModel> listaColonne  = dettaglioDatiEnteModel.getListaColonneModulo();		
			listarighe = arricchisciRighe(listarighe,ragioneSociale);
			listaColonne = arricchisciColonne(listaColonne);		
			ServletOutputStream outputStream = response.getOutputStream();
			bmGestioneReport.generaCsV(listarighe,listaColonne,outputStream);					
		} catch (IOException e) {
			log.error(methodName, "IOException " + e);
		} catch (Exception e) {
			log.error(methodName, "Exception " + e);
		}
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
		model.addAttribute("dettaglioDatiEnteModel", new DettaglioDatiEnteModel ());
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/dettaglioDatiEnte.jsp");
		return "/GestioneRisultati/dettaglioDatiEnte";
	}

	
	private List<ColonneModuloModel> arricchisciColonne(List<ColonneModuloModel> listaColonne) {
		//aggiungo la colonna in posizione 0
		ColonneModuloModel colonneModuloModel = new ColonneModuloModel();
		colonneModuloModel.setLabelColonna("Ente Compilatore");
		colonneModuloModel.setPosizione(0);
		//colonneModuloModel.setDimensione(new Long(200));
		colonneModuloModel.setEditabilitaProfilo("NON EDITABILE");
		List<ColonneModuloModel> listaColonneArricchita = Utility.addElementoAllaLista(listaColonne, colonneModuloModel );
		return listaColonneArricchita;
	}
	
	
	private List<RigaModuloModel> arricchisciRighe(List<RigaModuloModel> listarighe,String ragioneSociale) {
		List<RigaModuloModel>  listaRigheArricchite = new ArrayList<RigaModuloModel>();		
		for(RigaModuloModel rigasel:listarighe){
			//List<CellaModuloModel> listaCelleArricchite = new ArrayList<CellaModuloModel>();
			List<CellaModuloModel> listaCelle = rigasel.getListaCelleModulo();		
			// aggiungo una cella in testa alla riga
			CellaModuloModel cellaSupplementare = new CellaModuloModel();
			cellaSupplementare.setIdColonnaModulo(Long.valueOf(0));
			cellaSupplementare.setIdRiga(Long.valueOf(0));
			cellaSupplementare.setPosizioneColonna(0);
			cellaSupplementare.setPosizioneRiga(rigasel.getPosizione());
			cellaSupplementare.setValore(ragioneSociale);			
			List<CellaModuloModel> listaCelleArricchite = Utility.addElementoAllaLista(listaCelle, cellaSupplementare );
			rigasel.setListaCelleModulo(listaCelleArricchite);					
			listaRigheArricchite.add(rigasel);					
		}
		return listaRigheArricchite;
	}
	
}