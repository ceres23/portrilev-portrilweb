/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore.gestioneRisultati;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneReport;
import it.csi.portril.portrilweb.dto.DownloadData;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.CellaModuloModel;
import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.model.ValidaRigheModuliModel;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/gestore/validaRigheModuli")

public class ValidaRigheModuliController extends ControllerBase{
	
	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;

	@Autowired
	protected BusinessGestioneReport bmGestioneReport;
	
	private  LogUtil log = new LogUtil(getClass());

	/**
	 * 
	 * @param validaRigheModuliModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute ValidaRigheModuliModel validaRigheModuliModel ,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);

		session.removeAttribute(Costanti.COLONNEMODULO.getCostante());
		session.removeAttribute(Costanti.RIGHEMODULO_RICERCATE.getCostante());
		
		Long idModuloSel = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		log.info(methodName, "IdModuloSel " +idModuloSel);
		validaRigheModuliModel.setIdModuloSel(idModuloSel);
		
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/validaRigheModuli.jsp");
		return "/GestioneRisultati/validaRigheModuli";
	}

	/**
	 * 
	 * @param validaRigheModuliModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="ricerca",method = {RequestMethod.POST})	
	public String ricerca(@ModelAttribute ValidaRigheModuliModel validaRigheModuliModel ,HttpSession session,Model model) {
		String methodName="ricerca";
		log.startMethod(methodName);
		
		Long idModuloSel = (Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		
		validaRigheModuliModel.setIdModuloSel(idModuloSel);
		validaRigheModuliModel.setIdEnteGestore(super.getIdEnteGestore(session));
						
		List<RigaModuloModel>    listaRigheModulo   = bmGestioneModuli.getRigheByModuloEnti(validaRigheModuliModel);

//		log.info(methodName, "listaRigheModulo " + listaRigheModulo.size());	
//		for(RigaModuloModel riga:listaRigheModulo){	
//			for(CellaModuloModel cella : riga.getListaCelleModulo()){
//				log.info(methodName, "************************************************");				
//				log.info(methodName, "idriga    ="+ cella.getEditabilitaProfilo());
//				log.info(methodName, "idriga    ="+ cella.getIdRiga());
//				log.info(methodName, "idcolonna ="+ cella.getIdColonnaModulo());
//				log.info(methodName, "************************************************");
//			}			
//		}
		
		if(listaRigheModulo.size() > Integer.parseInt(Costanti.NUM_MAX_RIC.getCostante())){
			addOneMsgWarning(model,CostantiWARN.WAR_RIC.getCostante() );
		}else{
			List<ColonneModuloModel> listaColonneModulo = bmGestioneModuli.getColonneByIdModulo(validaRigheModuliModel.getIdModuloSel());
			session.setAttribute(Costanti.COLONNEMODULO.getCostante(), listaColonneModulo);
			session.setAttribute(Costanti.RIGHEMODULO_RICERCATE.getCostante(), listaRigheModulo);
			
			validaRigheModuliModel.setListaColonneModulo(listaColonneModulo);
			validaRigheModuliModel.setListaRigheModulo(listaRigheModulo);
		}
		
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/validaRigheModuli.jsp");
		return "/GestioneRisultati/validaRigheModuli";
	}
	
	/**
	 * 
	 * @param validaRigheModuliModel
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="salva",method = {RequestMethod.POST})	
	public String salva(@ModelAttribute ValidaRigheModuliModel validaRigheModuliModel ,HttpSession session,Model model) {
		String methodName="salva";
		log.startMethod(methodName);

		List<Long> listaIdRigaValidante   = Utility.splittaLong(validaRigheModuliModel.getListaIdDaValidare(), ",");
		List<Long> listaIdRigaInValidante = Utility.splittaLong(validaRigheModuliModel.getListaIdDaNonValidare(), ",");
		
		List<List<String>> listaRigheVisibili = validaRigheModuliModel.getListaRigheVisibili();
		
		// valido le righe visibili in pagina
		bmGestioneModuli.validaRighe(listaIdRigaValidante,listaIdRigaInValidante);
		
		// faccio gli update sui valori delle celle modificabili
		bmGestioneModuli.modificaValoriCelle(listaRigheVisibili);
		
		// riestraggo le righe appena modificate
		List<RigaModuloModel>    listaRigheModulo   = bmGestioneModuli.getRigheByModuloEnti(validaRigheModuliModel);
		validaRigheModuliModel.setListaRigheModulo(listaRigheModulo);
		
		// riestraggo le colonne
		List<ColonneModuloModel> listaColonneModulo = bmGestioneModuli.getColonneByIdModulo(validaRigheModuliModel.getIdModuloSel());
		validaRigheModuliModel.setListaColonneModulo(listaColonneModulo);
		
		log.debug(methodName, "listaRigheModulo " + listaRigheModulo.size());

		addOneMsgSuccess(model,"Righe moduli validate Correttamente");
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/validaRigheModuli.jsp");
		return "/GestioneRisultati/validaRigheModuli";
	}
	
	/**
	 * 
	 * @param validaRigheModuliModel
	 * @param session
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "esporta",method = {RequestMethod.POST})
	public void esporta(@ModelAttribute ValidaRigheModuliModel validaRigheModuliModel,HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		String methodName = "esporta";
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

			List<RigaModuloModel>    listarighe    = (List<RigaModuloModel>) session.getAttribute(Costanti.RIGHEMODULO_RICERCATE.getCostante());
			List<ColonneModuloModel> listaColonne  = (List<ColonneModuloModel>)session.getAttribute(Costanti.COLONNEMODULO.getCostante());

			listaColonne = arricchisciColonne(listaColonne);
			listarighe   = arricchisciRighe(listarighe);
			
			ServletOutputStream outputStream = response.getOutputStream();
			bmGestioneReport.generaCsV(listarighe,listaColonne,outputStream);
			
		} catch (IOException e) {
			log.error(methodName, "IOException " + e);
		} catch (Exception e) {
			log.error(methodName, "Exception " + e);
		}

	}
	
	
	private List<RigaModuloModel> arricchisciRighe(List<RigaModuloModel> listarighe) {
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
			cellaSupplementare.setValore(rigasel.getRagioneSocialeEnte());
			
			List<CellaModuloModel> listaCelleArricchite = Utility.addElementoAllaLista(listaCelle, cellaSupplementare );
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

	/**
	 * resetta tutti i campi del form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="clean",method = {RequestMethod.POST})	
	public String clean(Model model) {
		String methodName="clean";
		log.startMethod(methodName);	
		model.addAttribute("validaRigheModuliModel", new ValidaRigheModuliModel());
		log.stopMethod(methodName+" vado alla pagina " + "/GestioneRisultati/validaRigheModuli.jsp");
		return "/GestioneRisultati/validaRigheModuli";
	}
}