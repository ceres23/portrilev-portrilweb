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
import it.csi.portril.portrilweb.dto.DownloadData;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RicercaPerCompilazioneModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiWARN;
import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.util.Utility;

import java.io.IOException;
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
@RequestMapping("/gestore/ricercaModuliXComunicazione")
public class RicercaModuliXComunicazioneController extends ControllerBase {

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
		log.stopMethod(methodName + " vado alla pagina "+ "/GestioneRisultati/CompilaModuli/ricCompModuli.jsp");
		return "/GestioneRisultati/CompilaModuli/ricCompModuli";
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
		List<ModuliModel> listaModuliRicercati = businessGestioneModuliCompilatore.getModulixComunicazione (super.getIdEnteGestore(session),ricercaPerCompilazioneModel.getNome());
		log.debug(methodName, "num listaModuliRicercati " + listaModuliRicercati.size());		
		if(CollectionUtils.isEmpty(listaModuliRicercati)){
			addOneMsgWarning(model, CostantiWARN.RICERCA0.getCostante());
		}			
		ricercaPerCompilazioneModel.setListaModuli(listaModuliRicercati);
		session.setAttribute(Costanti.LISTA_MODULI_RICERCATI.getCostante(), listaModuliRicercati);		
		log.stopMethod(methodName + " vado alla pagina "+ "/GestioneRisultati/CompilaModuli/ricCompModuli.jsp");
		return "/GestioneRisultati/CompilaModuli/ricCompModuli";
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
		log.stopMethod(methodName+" vado alla pagina " + "/redirect:/gestore/compilaModuloXComunicazione/start.do");
		return "redirect:/gestore/compilaModuloXComunicazione/start.do";
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
		EntiCompilatoriModel   entiCompilatoriModel   = businessGestioneEntiCompilatori.getEnteCompilatoreFittizioByIdEnteGestore(super.getIdEnteGestore(session));
		Long idModulo=ricercaPerCompilazioneModel.getIdModuloSel();
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
			bmGestioneReport.generaCsV(outputStream,idModulo,entiCompilatoriModel.getIdEnteCompilatore());			
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
		//NB. Necessitiamo di un ente compilatore fittizio in tabella pt_t_utenti_compilatori con id  -1		
		//UtentiCompilatoriModel utenteCompilatoreModel = businessGestioneUtentiCompilatori.getUtenteCompilatoreFittizioByIdEnteGestore(super.getIdEnteGestore(session));
		//Long idUteComp  = utenteCompilatoreModel.getIdUtenteCompilatore();
		//log.info(methodName,"idUteComp " + idUteComp);		
		EntiCompilatoriModel   entiCompilatoriModel   = businessGestioneEntiCompilatori.getEnteCompilatoreFittizioByIdEnteGestore(super.getIdEnteGestore(session));    	
		Long idEnteComp = entiCompilatoriModel.getIdEnteCompilatore();
		log.info(methodName,"idEnteComp " + idEnteComp);

		List<ModuliModel> lista = (List<ModuliModel>)session.getAttribute(Costanti.LISTA_MODULI_RICERCATI.getCostante());
		log.info(methodName, "lista size " + lista.size());
		ricercaPerCompilazioneModel.setListaModuli(lista);
		log.info(methodName,"idModulo " + idModuloSel);
		Long idModulo = Long.valueOf(idModuloSel);   	
    	log.info(methodName,"nome: "+ file.getName());
    	log.info(methodName,"originalFileName: "+ file.getOriginalFilename());
    	log.info(methodName,"contentType: "+ file.getContentType());    	
    	//controllo il file che sia un csv  e che non sia vuoto
    	List<String> listaErrori = bmGestioneReport.validazioneFile(file);
    	//se ho non e' un csv esco subito
    	if(CollectionUtils.isNotEmpty(listaErrori) ){
    		addMsgError(model, listaErrori, true);
    		return "/GestioneRisultati/CompilaModuli/ricCompModuli";
    	}   		   
		//NB. Necessitiamo di un ente compilatore fittizio in tabella pt_t_utenti_compilatori con id  -1
    	bmGestioneReport.parserFileAndInsert(file, idEnteComp, new Long(-1), idModulo,model,true);
    	//bmGestioneReport.parserFileAndInsert(file, idEnteComp, idUteComp, idModulo,model,true);
		addOneMsgSuccess(model,Costanti.LOAD_IN_CORSO.getCostante());
		log.stopMethod(methodName+ " vado alla pagina "+ "/GestioneRisultati/CompilaModuli/ricCompModuli.jsp");
		return "/GestioneRisultati/CompilaModuli/ricCompModuli";
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
		log.stopMethod(methodName + " vado alla pagina "+ "/GestioneRisultati/CompilaModuli/ricCompModuli.jsp");
		return "/GestioneRisultati/CompilaModuli/ricCompModuli";
	}	
}