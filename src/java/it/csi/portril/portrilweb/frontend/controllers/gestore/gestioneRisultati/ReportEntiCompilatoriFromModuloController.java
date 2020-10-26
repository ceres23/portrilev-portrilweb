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
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.ReportEntiCompilatoriFromModuloModel;
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
@RequestMapping("/gestore/reportEntiCompilatoriFromModulo")
public class ReportEntiCompilatoriFromModuloController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected BusinessGestioneEntiCompilatori bmGestioneEntiCompilatori;
	
	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;
	
	@Autowired
	protected BusinessGestioneReport bmGestioneReport;
	
	
	/**
	 * 
	 * @param reportEntiCompilatoriFromModuloModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute ReportEntiCompilatoriFromModuloModel reportEntiCompilatoriFromModuloModel,HttpSession session,Model model) {
		String methodName="start";
		log.startMethod(methodName);
		session.removeAttribute("reportEntiCompilatoriFromModuloModel");
		Long idModuloSel = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		ModuliModel modulo = bmGestioneModuli.getModuloForId(idModuloSel);
		reportEntiCompilatoriFromModuloModel.setModulo(modulo);		
		session.setAttribute(Costanti.MODULO_SEL.getCostante(), modulo);	
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/reportModuli.jsp");
		return "/GestioneRisultati/reportModuli";
	}


/**
 * 
 * @param reportEntiCompilatoriFromModuloModel
 * @param session
 * @param model
 * @return
 */
	@RequestMapping(value="ricerca",method = {RequestMethod.POST})	
	public String ricerca(@ModelAttribute ReportEntiCompilatoriFromModuloModel reportEntiCompilatoriFromModuloModel,HttpSession session,Model model) {
		String methodName="ricerca";
		log.startMethod(methodName);		
		Long idModuloSel = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		String stato = reportEntiCompilatoriFromModuloModel.getStato();		
		List<EntiCompilatoriModel> listaEntiCompilatori = bmGestioneEntiCompilatori.getListaEntiCompilatoriByIdModuloSel(idModuloSel,stato);	
		reportEntiCompilatoriFromModuloModel.setListaEntiCompilatori(listaEntiCompilatori);
		reportEntiCompilatoriFromModuloModel.setModulo((ModuliModel)session.getAttribute(Costanti.MODULO_SEL.getCostante()));		
		session.setAttribute("reportEntiCompilatoriFromModuloModel", reportEntiCompilatoriFromModuloModel);		
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/reportModuli.jsp");
		return "/GestioneRisultati/reportModuli";
	}	
	
	/**
	 * 
	 * @param reportEntiCompilatoriFromModuloModel
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="esporta",method = {RequestMethod.POST})	
	public void esporta(@ModelAttribute ReportEntiCompilatoriFromModuloModel reportEntiCompilatoriFromModuloModel,
								Model model,
								HttpSession session,
								HttpServletRequest request,
								HttpServletResponse response) {
		String methodName="esporta";
		log.startMethod(methodName);
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
			//reportEntiCompilatoriFromModuloModel = (ReportEntiCompilatoriFromModuloModel) session.getAttribute("reportEntiCompilatoriFromModuloModel");			
			List<EntiCompilatoriModel> listaEntiCompilatori = reportEntiCompilatoriFromModuloModel.getListaEntiCompilatori();
			List<ColonneModuloModel> listaColonne  = getListaColonneEnti();
			log.debug(methodName, "listaColonne " + listaColonne.size());		
			List<RigaModuloModel>    listarighe    = getListaRigheEnti(listaEntiCompilatori); 		
			log.debug(methodName, "listarighe " + listarighe.size());
			ServletOutputStream outputStream = response.getOutputStream();
			bmGestioneReport.generaCsV(listarighe,listaColonne,outputStream);					
		} catch (IOException e) {
			log.error(methodName, "IOException " + e);
		} catch (Exception e) {
			log.error(methodName, "Exception " + e);
		}				
		log.stopMethod(methodName);
	}
		
	private List<ColonneModuloModel> getListaColonneEnti() {
		List<ColonneModuloModel> ris = new ArrayList<ColonneModuloModel>();
		ColonneModuloModel col = new ColonneModuloModel();
		col.setLabelColonna("Ragione Sociale");
		col.setPosizione(0);
		ris.add(col);

		col = new ColonneModuloModel();
		col.setLabelColonna("Comune");
		col.setPosizione(0);
		ris.add(col);
		
		col = new ColonneModuloModel();
		col.setLabelColonna("Provincia");
		col.setPosizione(0);
		ris.add(col);
		
		col = new ColonneModuloModel();
		col.setLabelColonna("Stato");
		col.setPosizione(0);
		ris.add(col);
		
		col = new ColonneModuloModel();
		col.setLabelColonna("Utente Compilatore");
		col.setPosizione(0);
		ris.add(col);
		
		col = new ColonneModuloModel();
		col.setLabelColonna("Data compilazione");
		col.setPosizione(0);
		ris.add(col);
				
		return ris;
	}


	private List<RigaModuloModel> getListaRigheEnti(List<EntiCompilatoriModel> listaEntiCompilatori) {
		//String methodName = "getListaRigheEnti";		
		List<RigaModuloModel> ret = new ArrayList<RigaModuloModel>();
		
		for(int posizione=0; posizione < listaEntiCompilatori.size();posizione++){
			EntiCompilatoriModel rigaSel = listaEntiCompilatori.get(posizione);
			
			RigaModuloModel rigaModuloModel = new RigaModuloModel();
			rigaModuloModel.setPosizione(posizione);
			
			List<CellaModuloModel> listaCelleModulo = new ArrayList<CellaModuloModel>();
			
			CellaModuloModel cella = new CellaModuloModel();
			cella.setPosizioneColonna(0);
			cella.setPosizioneRiga(posizione);
			cella.setValore(rigaSel.getRagioneSociale());
			listaCelleModulo.add(cella);
			
			cella = new CellaModuloModel();
			cella.setPosizioneColonna(0);
			cella.setPosizioneRiga(posizione);
			cella.setValore(rigaSel.getComune());
			listaCelleModulo.add(cella);

			cella = new CellaModuloModel();
			cella.setPosizioneColonna(0);
			cella.setPosizioneRiga(posizione);
			cella.setValore(rigaSel.getProvincia());
			listaCelleModulo.add(cella);

			cella = new CellaModuloModel();
			cella.setPosizioneColonna(0);
			cella.setPosizioneRiga(posizione);
			cella.setValore(rigaSel.getStato());
			listaCelleModulo.add(cella);

			cella = new CellaModuloModel();
			cella.setPosizioneColonna(0);
			cella.setPosizioneRiga(posizione);
			cella.setValore(rigaSel.getUltimoUtenteCompilatore().getNome()+" - "+rigaSel.getUltimoUtenteCompilatore().getCognome());
			listaCelleModulo.add(cella);

			cella = new CellaModuloModel();
			cella.setPosizioneColonna(0);
			cella.setPosizioneRiga(posizione);
			cella.setValore(rigaSel.getUltimoUtenteCompilatore().getDataUltimoAggRigheModuloStr());
			listaCelleModulo.add(cella);
			
			rigaModuloModel.setListaCelleModulo(listaCelleModulo);
			ret.add(rigaModuloModel);
		}
		
		return ret;
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
		
		model.addAttribute("reportEntiCompilatoriFromModuloModel", new ReportEntiCompilatoriFromModuloModel());
		
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/reportModuli.jsp");
		return "/GestioneRisultati/reportModuli";
	}
	
}