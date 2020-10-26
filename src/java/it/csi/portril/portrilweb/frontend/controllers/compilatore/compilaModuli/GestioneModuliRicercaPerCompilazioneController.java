/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.compilatore.compilaModuli;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneReport;
import it.csi.portril.portrilweb.business.interfaces.compilatori.BusinessGestioneModuliCompilatore;
import it.csi.portril.portrilweb.dto.DownloadData;
import it.csi.portril.portrilweb.dto.MsgAllert;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RicercaPerCompilazioneModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.model.exception.ControlloFormaleException;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.CostantiWARN;
import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.util.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/compilatore/gestioneModuliRicercaPerCompilazione")
public class GestioneModuliRicercaPerCompilazioneController extends ControllerBase {

	private LogUtil log = new LogUtil(getClass());
	@Autowired
	protected BusinessGestioneModuliCompilatore businessGestioneModuliCompilatore;

	@Autowired
	protected BusinessGestioneReport bmGestioneReport;

	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;
	
	/**
	 * 
	 * @param ricercaPerCompilazioneModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "start",method = {RequestMethod.GET})
	public String start(@ModelAttribute RicercaPerCompilazioneModel ricercaPerCompilazioneModel,HttpSession session) {
		String methodName = "start";
		log.startMethod(methodName);

		session.removeAttribute(Costanti.ID_MODULO_SEL.getCostante());
		session.removeAttribute(Costanti.LISTA_MODULI_RICERCATI.getCostante());

		log.stopMethod(methodName + " vado alla pagina /CompilaModuli/ricCompModuli.jsp");
		return "/CompilaModuli/ricCompModuli";
	}

	/**
	 * 
	 * @param ricercaPerCompilazioneModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "ricerca",method = {RequestMethod.POST})
	public String ricerca(@ModelAttribute RicercaPerCompilazioneModel ricercaPerCompilazioneModel,Model model, HttpSession session) {
		String methodName = "ricerca";
		log.startMethod(methodName);

		super.getIdEnteCompilatoreSelezionato(session);
		ricercaPerCompilazioneModel.getNome();

		List<ModuliModel> listaModuliRicercati = businessGestioneModuliCompilatore.getModuliByEnteCompilatore(
				super.getIdEnteCompilatoreSelezionato(session),
				ricercaPerCompilazioneModel.getNome(),
				Costanti.IN_COMPILAZIONE.getCostante(),
				Costanti.TIPO_MODULO_RILEVAZIONE.getCostante());
		
		log.debug(methodName, "num listaModuliRicercati " + listaModuliRicercati.size());
		
		if(CollectionUtils.isEmpty(listaModuliRicercati)){
			addOneMsgWarning(model, CostantiWARN.RICERCA0.getCostante());
		}	
		
		ricercaPerCompilazioneModel.setListaModuli(listaModuliRicercati);
		session.setAttribute(Costanti.LISTA_MODULI_RICERCATI.getCostante(), listaModuliRicercati);
		
		log.stopMethod(methodName + " vado alla pagina /CompilaModuli/ricCompModuli.jsp");
		return "/CompilaModuli/ricCompModuli";
	}

	
	/**
	 * 
	 * @param ricercaPerCompilazioneModel
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "compilaModulo",method = {RequestMethod.POST})
	public String compilaModulo(@ModelAttribute RicercaPerCompilazioneModel ricercaPerCompilazioneModel,Model model, HttpSession session) {
		String methodName = "compilaModulo";
		log.startMethod(methodName);
		
		Long idModulo=ricercaPerCompilazioneModel.getIdModuloSel();
		log.debug(methodName, "idModulo " + idModulo);
		session.setAttribute(Costanti.ID_MODULO_SEL.getCostante(), idModulo);
		
		log.stopMethod(methodName+" vado alla pagina /redirect:/compilatore/gestioneModuliCompilaModulo/start.do");
		return "redirect:/compilatore/gestioneModuliCompilaModulo/start.do";

	}

	
	/**
	 * 
	 * @param ricercaPerCompilazioneModel
	 * @param model
	 * @param session
	 */
	@RequestMapping(value = "scaricaModello",method = {RequestMethod.POST})
	public void scaricaModello(@ModelAttribute RicercaPerCompilazioneModel ricercaPerCompilazioneModel,Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		String methodName = "scaricaModello";
		log.startMethod(methodName);
			
		Long idModulo=(Long)ricercaPerCompilazioneModel.getIdModuloSel();
		log.debug(methodName, "idModulo   " + idModulo);
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
			

			ServletOutputStream outputStream = response.getOutputStream();
			
			List<RigaModuloModel> listarighe       = bmGestioneModuli.getRigheByIdModuloIdEnteCompilatore(idModulo,super.getIdEnteCompilatoreSelezionato(session),Costanti.COMPILATORE.getCostante());
			List<ColonneModuloModel> listaColonne  = bmGestioneModuli.getColonneByIdModulo(idModulo,Costanti.COMPILATORE.getCostante());
			bmGestioneReport.generaCsV(listarighe,listaColonne,outputStream);
			
			//TODO da capire perche' non funziona l'asincrono
			//bmGestioneReport.generaCsVAsync(outputStream, idModulo, super.getIdEnteCompilatoreSelezionato(session));
			
		} catch (IOException e) {
			log.error(methodName, "IOException ",e);
		} catch (Exception e) {
			log.error(methodName, "Exception " ,e);
		}
		
		log.stopMethod(methodName);
	}
	
	
	/**
	 * 
	 * @param ricercaPerCompilazioneModel
	 * @param model
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value = "uploadModulo",method = {RequestMethod.POST})
	public String uploadModulo(
								@ModelAttribute RicercaPerCompilazioneModel ricercaPerCompilazioneModel,
								@RequestParam("file")        MultipartFile file,
								@RequestParam("idModuloSel") String idModuloSel,
								Model model,
								HttpSession session) throws NumberFormatException, IOException {
		
		String methodName = "uploadModulo";
		log.startMethod(methodName);

		ricercaPerCompilazioneModel.setListaModuli((List<ModuliModel>)session.getAttribute(Costanti.LISTA_MODULI_RICERCATI.getCostante()));
		
		Long idModulo = Long.valueOf(idModuloSel);
		InputStream inputStream = null;
    	BufferedReader bufferedReader = null;
    	String[] colonnedaCsv;
    	
    	Long idEnteComp = super.getIdEnteCompilatoreSelezionato(session);
    	List<RigaModuloModel> listaRigeDaCsv = new ArrayList<RigaModuloModel>();
    	
    	log.debug(methodName,"nome: "+ file.getName());
    	log.debug(methodName,"originalFileName: "+ file.getOriginalFilename());
    	log.debug(methodName,"contentType: "+ file.getContentType());
    	
    	//controllo il file che sia un csv  e che non sia vuoto
    	List<String> listaErrori = bmGestioneReport.validazioneFile(file);

    	//se ho non e' un csv esco subito
    	if(CollectionUtils.isNotEmpty(listaErrori) ){
    		addMsgError(model, listaErrori, true);
    		return "/CompilaModuli/ricCompModuli";
    	}
    	
		try {
			inputStream = file.getInputStream();
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
	    	colonnedaCsv = bmGestioneReport.estraiTestataDaCsv(bufferedReader,
												    			idModulo,
												    			super.getUtenteCompilatoreConnesso(session).getIdUtenteCompilatore());	

			listaRigeDaCsv = bmGestioneReport.estraiRigheDaCsv(bufferedReader,
																	idModulo,
																	super.getUtenteCompilatoreConnesso(session).getIdUtenteCompilatore(),
																	idEnteComp,
																	Costanti.TIPO_MODULO_RILEVAZIONE.getCostante());
		} finally {
			if(bufferedReader != null) {
				bufferedReader.close();
			}
			if(inputStream != null) {
				inputStream.close();
			}
		}
		
    	//controllo nel merito delle righe del file
		List<MsgAllert> listEr = new ArrayList<MsgAllert>();

		try {
			listEr = businessGestioneModuliCompilatore.controlloFormaleRighe(idModulo,colonnedaCsv.length,listaRigeDaCsv);
		} catch (ControlloFormaleException e) {
			listEr.add(new MsgAllert(Costanti.ERR.getCostante(),CostantiERR.ERR_INTERNO.getCostante() + e.getMessage()));
			log.error(methodName, e);
		}
		
		listaErrori = Utility.getlistMsg(listEr,Costanti.ERR.getCostante());
		List<String> msgWarning = Utility.getlistMsg(listEr,Costanti.WARN.getCostante());
	
		if(CollectionUtils.isEmpty(listaErrori)){		
			bmGestioneReport.aggiornaInserisciRighe(idModulo,idEnteComp,listaRigeDaCsv);
			addMsgWarning(model, msgWarning,CollectionUtils.isNotEmpty(msgWarning));
			addOneMsgSuccess(model,Costanti.LOAD_MODULO_OK.getCostante());
		}else{
			addMsgError(model, listaErrori, true);	
		}

		log.stopMethod(methodName+ " vado alla pagina /CompilaModuli/ricCompModuli.jsp");
		return "/CompilaModuli/ricCompModuli";
	}

	
	/**
	 * 
	 * @param ricercaPerCompilazioneModel
	 * @param model
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value = "uploadModuloAppend",method = {RequestMethod.POST})
	public String uploadModuloAppend(
								@ModelAttribute RicercaPerCompilazioneModel ricercaPerCompilazioneModel,
								@RequestParam("file")        MultipartFile file,
								@RequestParam("idModuloSel") String idModuloSel,
								Model model,
								HttpSession session) throws NumberFormatException, IOException {
		
		String methodName = "uploadModuloAppend";
		log.startMethod(methodName);

		ricercaPerCompilazioneModel.setListaModuli((List<ModuliModel>)session.getAttribute(Costanti.LISTA_MODULI_RICERCATI.getCostante()));
		
		Long idModulo = Long.valueOf(idModuloSel);
		InputStream inputStream = null;
    	BufferedReader bufferedReader = null;
    	String[] colonnedaCsv;
    	
    	Long idEnteComp = super.getIdEnteCompilatoreSelezionato(session);
    	List<RigaModuloModel> listaRigeDaCsv = new ArrayList<RigaModuloModel>();
    	
    	log.debug(methodName,"nome: "+ file.getName());
    	log.debug(methodName,"originalFileName: "+ file.getOriginalFilename());
    	log.debug(methodName,"contentType: "+ file.getContentType());
    	
    	//controllo il file che sia un csv  e che non sia vuoto
    	List<String> listaErrori = bmGestioneReport.validazioneFile(file);

    	//se ho non e' un csv esco subito
    	if(CollectionUtils.isNotEmpty(listaErrori) ){
    		addMsgError(model, listaErrori, true);
    		return "/CompilaModuli/ricCompModuli";
    	}
    	
		try {
			inputStream = file.getInputStream();
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
	    	colonnedaCsv = bmGestioneReport.estraiTestataDaCsv(bufferedReader,
												    			idModulo,
												    			super.getUtenteCompilatoreConnesso(session).getIdUtenteCompilatore());	

			listaRigeDaCsv = bmGestioneReport.estraiRigheDaCsv(bufferedReader,
																	idModulo,
																	super.getUtenteCompilatoreConnesso(session).getIdUtenteCompilatore(),
																	idEnteComp,
																	Costanti.TIPO_MODULO_RILEVAZIONE.getCostante());
		} finally {
			if(bufferedReader != null) {
				bufferedReader.close();
			}
			if(inputStream != null) {
				inputStream.close();
			}
		}
		
    	//controllo nel merito delle righe del file
		List<MsgAllert> listEr = new ArrayList<MsgAllert>();

		try {
			listEr = businessGestioneModuliCompilatore.controlloFormaleRighe(idModulo,colonnedaCsv.length,listaRigeDaCsv);
		} catch (ControlloFormaleException e) {
			listEr.add(new MsgAllert(Costanti.ERR.getCostante(),CostantiERR.ERR_INTERNO.getCostante() + e.getMessage()));
			log.error(methodName, e);
		}
		
		listaErrori = Utility.getlistMsg(listEr,Costanti.ERR.getCostante());
		List<String> msgWarning = Utility.getlistMsg(listEr,Costanti.WARN.getCostante());
	
		if(CollectionUtils.isEmpty(listaErrori)){		
			bmGestioneReport.aggiornaInserisciRighe(idModulo,idEnteComp,listaRigeDaCsv,true);
			addMsgWarning(model, msgWarning,CollectionUtils.isNotEmpty(msgWarning));
			addOneMsgSuccess(model,Costanti.LOAD_MODULO_OK.getCostante());
		}else{
			addMsgError(model, listaErrori, true);	
		}

		log.stopMethod(methodName+ " vado alla pagina /CompilaModuli/ricCompModuli.jsp");
		return "/CompilaModuli/ricCompModuli";
	}
	
	/**
	 * resetta tutti i campi del form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "clean",method = {RequestMethod.POST})
	public String clean(Model model) {
		String methodName = "clean";
		log.startMethod(methodName);

		model.addAttribute("ricercaPerCompilazioneModel",new RicercaPerCompilazioneModel());

		log.stopMethod(methodName + " vado alla pagina /CompilaModuli/ricCompModuli.jsp");
		return "/CompilaModuli/ricCompModuli";
	}
	
}