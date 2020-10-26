/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.compilatore.compilaModuli;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneReport;
import it.csi.portril.portrilweb.business.interfaces.compilatori.BusinessGestioneModuliCompilatore;
import it.csi.portril.portrilweb.dto.DownloadData;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.CellaModuloModel;
import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RicercaGestioneModuliModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiWARN;
import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.util.Utility;

import java.io.IOException;
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


@Controller
//@SessionAttributes({"ricercaGestioneModuliModel"})
@RequestMapping("/compilatore/gestioneDefinizioneModuliRicerca")
public class GestioneDefinizioneModuliRicercaController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	@Autowired
	protected BusinessGestioneModuliCompilatore businessGestioneModuliCompilatore;

	@Autowired
	protected BusinessGestioneEntiCompilatori businessGestioneEntiCompilatori;

	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;

	@Autowired
	protected BusinessGestioneEntiCompilatori bmGestioneEntiCompilatori;

	@Autowired
	protected BusinessGestioneReport bmGestioneReport;
		
	/**
	 * 
	 * @param ricercaGestioneModuliModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(RicercaGestioneModuliModel ricercaGestioneModuliModel,HttpSession session,Model model) {
		String methodName="start";
		log.startMethod(methodName);
		clean(model);		
		log.stopMethod(methodName,"/CompilaModuli/ricDefinModuli.jsp");
		return "/CompilaModuli/ricDefinModuli";
	}

	/**
	 * 
	 * @param ricercaGestioneModuliModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="goToConsultazione",method = {RequestMethod.GET,RequestMethod.POST})	
	public String goToConsultazione(RicercaGestioneModuliModel ricercaGestioneModuliModel,HttpSession session) {
		String methodName="goToConsultazione";
		log.startMethod(methodName);	
		log.stopMethod(methodName,"/CompilaModuli/ricDefinModuli.jsp");
		return "/CompilaModuli/ricDefinModuli";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="ricerca",method = {RequestMethod.POST})	
	public String ricerca(@ModelAttribute RicercaGestioneModuliModel ricercaGestioneModuliModel ,HttpSession session,Model model) {
		String methodName="ricerca";
		log.startMethod(methodName);
		List<ModuliModel> listaModuliRicercati = new ArrayList<ModuliModel>();		
		//String stato = Costanti.CHIUSO.getCostante();
		if(ricercaGestioneModuliModel.getTipo().equalsIgnoreCase(Costanti.TIPO_MODULO_COMUNICAZIONE.getCostante())){
			/*
			EntiCompilatoriModel enteComp = businessGestioneEntiCompilatori.getEntiCompilatoriById(super.getIdEnteCompilatoreSelezionato(session));
			String valoreCella = enteComp.getCodiceFiscale();	
			log.info(methodName, "valoreCella " + valoreCella);

			listaModuliRicercati = businessGestioneModuliCompilatore.getModuliByValoreCellaContenuta(ricercaGestioneModuliModel.getNome(),
																				"",
																				Costanti.TIPO_MODULO_COMUNICAZIONE.getCostante(),
																				valoreCella,
																				1,
																				null);
																				*/
			listaModuliRicercati = businessGestioneModuliCompilatore.getModuliByEnteCompilatore(				
																									super.getIdEnteCompilatoreSelezionato(session),
																									ricercaGestioneModuliModel.getNome(),
																									null,//Costanti.CHIUSO.getCostante(),
																									ricercaGestioneModuliModel.getTipo()																											
																									);			
		}else{
			listaModuliRicercati = businessGestioneModuliCompilatore.getModuliByEnteCompilatore(				
																								super.getIdEnteCompilatoreSelezionato(session),
																								ricercaGestioneModuliModel.getNome(),
																								Costanti.CHIUSO.getCostante(),
																								ricercaGestioneModuliModel.getTipo()																											
																								);
		}																										

		ricercaGestioneModuliModel.setListaModuli(listaModuliRicercati);
		session.setAttribute(Costanti.LISTA_MODULI_RICERCATI.getCostante(), listaModuliRicercati);	
		if(CollectionUtils.isEmpty(listaModuliRicercati)){
			addOneMsgWarning(model, CostantiWARN.RICERCA0.getCostante());
		}			
		log.stopMethod(methodName+" vado alla pagina /CompilaModuli/ricDefinModuli.jsp");
		return "/CompilaModuli/ricDefinModuli";
	}
	
	/**
	 * 
	 * @param ricercaGestioneModuliModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="scaricaDati",method = {RequestMethod.POST})	
	public void scaricaDati(@ModelAttribute RicercaGestioneModuliModel ricercaGestioneModuliModel ,HttpSession session,Model model,HttpServletRequest request, HttpServletResponse response) {
		String methodName="scaricaDati";
		log.startMethod(methodName);		
		Long idModulo=ricercaGestioneModuliModel.getIdModuloSel();
		ModuliModel modulo = bmGestioneModuli.getModuloForId(idModulo);
		log.info(methodName, "idModulo   " + idModulo);
		Long idEnteCompSelezionato=super.getIdEnteCompilatoreSelezionato(session);		
		try {			
			// Metto gli header
			String nomeModulo = new Utility().generaNomeModuloCsv(modulo.getNome());			
			DownloadData data = new DownloadData(Costanti.TIPO_FILE_CSV.getCostante(), nomeModulo, null);			
			response.setHeader("Content-Disposition",
								String.format("%s; filename=%s",
								data.getContentDisposition(),
								Utility.encodeFilenameForDownload(data.getFilename(),
								request.getHeader("user-agent"))));			
			response.setContentType(data.getContentType());			
			// visualizza righe e colonne solo del compilatore
			List<RigaModuloModel> listarighe = new ArrayList<RigaModuloModel>();			
			log.info(methodName, "modulo.getTipo() " + modulo.getTipo());
			if(modulo.getTipo().equals(Costanti.TIPO_MODULO_RILEVAZIONE.getCostante())){
				listarighe = bmGestioneModuli.getRigheByIdModuloIdEnteCompilatore( idModulo, idEnteCompSelezionato,Costanti.COMPILATORE.getCostante());
			}else{			
				EntiCompilatoriModel enteComp=bmGestioneEntiCompilatori.getEntiCompilatoriById(idEnteCompSelezionato);
				String codicefiscale = enteComp.getCodiceFiscale();
				String ragioneSocialeEnte = enteComp.getRagioneSociale();				
				listarighe = bmGestioneModuli.getRigheByIdModuloCFCompilatore( idModulo,codicefiscale,ragioneSocialeEnte );
			}
			List<ColonneModuloModel> listaColonne  = bmGestioneModuli.getColonneByIdModulo(idModulo,Costanti.COMPILATORE.getCostante());
			listarighe   = arricchisciRighe(listarighe);
			listaColonne = arricchisciColonne(listaColonne) ;					
			// se voglio righe e colonne complete
			//List<RigaModuloModel> listarighe = bmGestioneModuli.getRigheByIdModuloIdEnteCompilatore( idModulo, super.getIdEnteCompilatoreSelezionato(session));
			//List<ColonneModuloModel> listaColonne  = bmGestioneModuli.getColonneByIdModulo(idModulo);
			ServletOutputStream outputStream = response.getOutputStream();
			bmGestioneReport.generaCsV(listarighe,listaColonne,outputStream);		
		} catch (IOException e) {
			log.error(methodName, "IOException " + e);
		} catch (Exception e) {
			log.error(methodName, "Exception " + e);
		}			
		log.stopMethod(methodName);
	}


	/**
	 * 
	 * @param ricercaGestioneModuliModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="consulta",method = {RequestMethod.POST})	
	public String consulta(@ModelAttribute RicercaGestioneModuliModel ricercaGestioneModuliModel ,HttpSession session,Model model) {
		String methodName="consulta";
		log.startMethod(methodName);		
		Long idModuloSel = ricercaGestioneModuliModel.getIdModuloSel();
		session.setAttribute(Costanti.ID_MODULO_SEL.getCostante(), idModuloSel);		
		log.stopMethod(methodName+" vado alla pagina redirect:/compilatore/gestioneModuliConsultaModulo/start.do");
		return "redirect:/compilatore/gestioneModuliConsultaModulo/start.do";
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
		model.addAttribute("ricercaGestioneModuliModel", new RicercaGestioneModuliModel());
		log.stopMethod(methodName+" vado alla pagina /GestioneUtentiComp/ricDefinModuli.jsp");
		return "/CompilaModuli/ricDefinModuli";
	}
		
	private List<RigaModuloModel> arricchisciRighe(List<RigaModuloModel> listarighe) {
		List<RigaModuloModel>  listaRigheArricchite = new ArrayList<RigaModuloModel>();		
		for(RigaModuloModel rigasel:listarighe){
			List<CellaModuloModel> listaCelle = rigasel.getListaCelleModulo();		
			// aggiungo una cella in testa alla riga
			CellaModuloModel cellaSupplementare = new CellaModuloModel();
			cellaSupplementare.setIdColonnaModulo(Long.valueOf(0));
			cellaSupplementare.setIdRiga(Long.valueOf(0));
			cellaSupplementare.setPosizioneColonna(0);
			cellaSupplementare.setPosizioneRiga(rigasel.getPosizione());		
			cellaSupplementare.setValore(rigasel.getRagioneSocialeEnte());			
			List<CellaModuloModel>  listaCelleArricchite = Utility.addElementoAllaLista(listaCelle, cellaSupplementare );
			rigasel.setListaCelleModulo(listaCelleArricchite);				
			listaRigheArricchite.add(rigasel);				
		}
		return listaRigheArricchite;
	}

	private List<ColonneModuloModel> arricchisciColonne(List<ColonneModuloModel> listaColonne) {
		//aggiungo la colonna in posizione 0
		ColonneModuloModel colonneModuloModel = new ColonneModuloModel();
		colonneModuloModel.setLabelColonna("Ente Compilatore");
		colonneModuloModel.setPosizione(0);
		colonneModuloModel.setEditabilitaProfilo("NON EDITABILE");
		List<ColonneModuloModel> listaColonneArricchita = Utility.addElementoAllaLista(listaColonne, colonneModuloModel );
		return listaColonneArricchita;
	}	
}