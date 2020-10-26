/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.gestioneRisultati;

import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiGestori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneReport;
import it.csi.portril.portrilweb.dto.DownloadData;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.GestioneRisultatiModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.CostantiWARN;
import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.util.Utility;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
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
@RequestMapping("/gestore/ricercaRisultati")
public class RicercaRisultatiController extends ControllerBase {

	private LogUtil log = new LogUtil(getClass());

	@Autowired
	protected BusinessGestioneEntiCompilatori bmGestioneEntiCompilatori;
	
	@Autowired
	protected BusinessGestioneReport bmGestioneReport;

	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;

	@Autowired
	protected BusinessGestioneEntiGestori bmGestioneEntiGestori;
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "start",method = {RequestMethod.GET})
	public String start() {
		String methodName = "start";
		log.startMethod(methodName);

		log.stopMethod(methodName + " vado alla pagina " + "/GestioneRisultati/ricercaRisultati.jsp");
		return "/GestioneRisultati/ricercaRisultati";
	}

	/**
	 * 
	 * @param ricercaRisultatiModel
	 * @return
	 */
	@RequestMapping(value = "ricerca",method = {RequestMethod.POST})
	public String ricerca(@ModelAttribute GestioneRisultatiModel ricercaRisultatiModel,HttpSession session) {
		String methodName = "ricerca";
		log.startMethod(methodName);
	
		List<ModuliModel> listaModuli = bmGestioneModuli.ricercaModuli(
				ricercaRisultatiModel.getNome(),
				ricercaRisultatiModel.getStato(),
				Costanti.TIPO_MODULO_RILEVAZIONE.getCostante(),
				super.getIdEnteGestore(session),
				ricercaRisultatiModel.getCodiceGruppo()
				);

		ricercaRisultatiModel.setListaModuli(listaModuli);
		
		log.stopMethod(methodName + " vado alla pagina " + "/GestioneRisultati/ricercaRisultati.jsp");
		return "/GestioneRisultati/ricercaRisultati";
	}

	/**
	 * resetta tutti i campi del form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "clean",method = {RequestMethod.POST})
	public String clean(Model model,HttpSession session) {
		String methodName = "clean";
		log.startMethod(methodName);
		
		model.addAttribute("gestioneRisultatiModel", new GestioneRisultatiModel());
		session.removeAttribute(Costanti.ID_MODULO_SEL.getCostante());
				
		log.stopMethod(methodName + " vado alla pagina " + "/GestioneRisultati/ricercaRisultati.jsp");
		return "/GestioneRisultati/ricercaRisultati";
	}

	@RequestMapping(value = "csvMultiplo",method = {RequestMethod.POST})
	public void csvMultiplo(@ModelAttribute GestioneRisultatiModel ricercaRisultatiModel, HttpServletRequest request,Model model, HttpServletResponse response) {
		String methodName = "csvMultiplo";
		log.startMethod(methodName);
		String listaId = ricercaRisultatiModel.getListaIdXCsv();		
			try {
				int numRighe = bmGestioneReport.contaRigheCsvDiModuliAggregati(listaId);
				if (numRighe <= Integer.parseInt(Costanti.MAX_NUM_CSV.getCostante())){
					String nomeModulo = new Utility().generaNomeModuloCsv("moduliAggregati");		
					DownloadData data = new DownloadData(Costanti.TIPO_FILE_CSV.getCostante(), nomeModulo, null);
					
					response.setHeader("Content-Disposition",
										String.format("%s; filename=%s",
										data.getContentDisposition(),
										Utility.encodeFilenameForDownload(data.getFilename(),
										request.getHeader("user-agent"))));				
					response.setContentType(data.getContentType());				
					// Scrivo sulla response
					ServletOutputStream outputStream = response.getOutputStream();
					bmGestioneReport.creaCsvDiModuliAggregati(listaId,outputStream);
				}else{
					addOneMsgWarning(model,CostantiWARN.TROPPE_RIGHE_CSV.getCostante());
				}
			} catch (IOException e) {
				log.error(methodName, "IOException " + e);
			} catch (Exception e) {
				log.error(methodName, "Exception " + e);
			}
		log.stopMethod(methodName);
	}
		
	/**
	 * 
	 * @param moduliModel
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "scaricaDati",method = {RequestMethod.POST})
	public void scaricaDati(@ModelAttribute ModuliModel moduliModel, HttpServletRequest request, HttpServletResponse response) {
		String methodName = "scaricaDati";
		log.startMethod(methodName);
		Long idModulo = moduliModel.getIdModuloSel();
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
			
			// Scrivo sulla response
			ServletOutputStream outputStream = response.getOutputStream();
			bmGestioneReport.creaRiepilogoDatiByModulo(idModulo,outputStream);
			
		} catch (IOException e) {
			log.error(methodName, "IOException " + e);
		} catch (Exception e) {
			log.error(methodName, "Exception " + e);
		}

	}
	
	/**
	 * 
	 * @param ricercaRisultatiModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "goToValida",method = {RequestMethod.POST})
	public String goTovalida(@ModelAttribute GestioneRisultatiModel ricercaRisultatiModel,HttpSession session,Model model) {
		String methodName = "goToValida";
		log.startMethod(methodName);
		session.setAttribute(Costanti.ID_MODULO_SEL.getCostante(), ricercaRisultatiModel.getIdModuloSel());
		//Long IdUtenteSel = (Long)session.getAttribute(Costanti.ID_UTENTE_COMPILATORE_MOD.getCostante());	
		log.stopMethod(methodName + " vado alla pagina " + "/validaRigheModuli/start.do");
		return "redirect:/gestore/validaRigheModuli/start.do";
	}
	
	/**
	 * 
	 * @param ricercaRisultatiModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "visualizzaDatiEnte",method = {RequestMethod.POST})
	public String visualizzaDatiEnte(@ModelAttribute GestioneRisultatiModel ricercaRisultatiModel,HttpSession session,Model model) {
		String methodName = "visualizzaDatiEnte";
		log.startMethod(methodName);
		session.setAttribute(Costanti.ID_MODULO_SEL.getCostante(), ricercaRisultatiModel.getIdModuloSel());		
		log.stopMethod(methodName + " vado alla pagina " + "/visualizzaDatiEnte/start.do");
		return "redirect:/gestore/visualizzaDatiEnte/start.do";
	}
	
	
	/**
	 * 
	 * @param ricercaRisultatiModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "report",method = {RequestMethod.POST})
	public String report(@ModelAttribute GestioneRisultatiModel ricercaRisultatiModel,HttpSession session) {
		String methodName = "report";
		log.startMethod(methodName);	
		session.setAttribute(Costanti.ID_MODULO_SEL.getCostante(), ricercaRisultatiModel.getIdModuloSel());		
		log.stopMethod(methodName + " vado alla pagina " + "redirect:/gestore/reportEntiCompilatoriFromModulo/start.do");
		return "redirect:/gestore/reportEntiCompilatoriFromModulo/start.do";
	}
		
	/**
	 * 
	 * @param gestioneRisultatiModel
	 * @return
	 */
	@ModelAttribute("gestioneRisultatiModel")
	public GestioneRisultatiModel gestioneRisultatiModel(GestioneRisultatiModel gestioneRisultatiModel) {
		return gestioneRisultatiModel;
	}

	/**
	 * 
	 * @param ricercaModuliModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="gotoSbloccaConferme",method = {RequestMethod.POST})	
	public String gotoSbloccaConferme(@ModelAttribute GestioneRisultatiModel gestioneRisultatiModel,HttpSession session) {
		String methodName="gotoSbloccaConferme";
		log.startMethod(methodName);		
		Long idModuloSel = gestioneRisultatiModel.getIdModuloSel();
		session.setAttribute(Costanti.ID_MODULO_SEL.getCostante(), idModuloSel);		
		log.stopMethod(methodName+" vado alla pagina redirect:/gestore/sbloccaConfermeModuli/start.do ");
		return "redirect:/gestore/sbloccaConfermeModuli/start.do";
	}
	
	/**
	 * 
	 * @param ricercaModuliModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="sollecita",method = {RequestMethod.POST})	
	public String sollecita(@ModelAttribute GestioneRisultatiModel gestioneRisultatiModel,HttpSession session,Model model) {
		String methodName="sollecita";
		log.startMethod(methodName);
		Long idModuloSel = gestioneRisultatiModel.getIdModuloSel();
		session.setAttribute(Costanti.ID_MODULO_SEL.getCostante(), idModuloSel);
		//forzo l'apertura della finestra modale
		gestioneRisultatiModel.setAperturaModale(true);
		gestioneRisultatiModel.setModuloSelezionato(bmGestioneModuli.getModuloForId(idModuloSel));					
		ricerca(gestioneRisultatiModel, session);		
		log.stopMethod(methodName+" vado alla pagina /GestioneRisultati/ricercaRisultati.JSP");
		return "/GestioneRisultati/ricercaRisultati";
	}
	
	/**
	 * 
	 * @param ricercaModuliModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="inviaSollecito",method = {RequestMethod.POST})	
	public String inviaSollecito(@ModelAttribute GestioneRisultatiModel gestioneRisultatiModel,HttpSession session,Model model) {
		String methodName="inviaSollecito";
		log.startMethod(methodName);		
		gestioneRisultatiModel.setAperturaModale(false);
		Long idModuloSel = (Long) session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		log.info(methodName, "gestioneRisultatiModel "+ gestioneRisultatiModel.getGruppoSollecito());
		//EntiGestoriModel eg = bmGestioneEntiGestori.getEnteGestoreById(super.getIdEnteGestore(session));
		log.debug(methodName, "mittente Mail ente Gestore--> " + super.getUtenteGestoreConnesso(session).getMail());
		try {
			bmGestioneModuli.invioMailSollecito(
												idModuloSel,
												super.getUtenteGestoreConnesso(session).getIdUtenteGestore(),
												super.getUtenteGestoreConnesso(session).getMail().trim(),
												gestioneRisultatiModel.getOggMailModulo(),
												gestioneRisultatiModel.getDescMailModulo(),
												gestioneRisultatiModel.getGruppoSollecito()
												);
		
			addOneMsgSuccess(model, Costanti.MAIL_OK.getCostante())	;
		} catch (MessagingException e) {
			addOneMsgError(model, CostantiERR.ERR_MAIL.getCostante());
			log.error(methodName, CostantiERR.ERR_MAIL.getCostante() +"  "+e);
		}

		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/ricercaRisultati.jsp");
		return "/GestioneRisultati/ricercaRisultati";
	}
	
}
