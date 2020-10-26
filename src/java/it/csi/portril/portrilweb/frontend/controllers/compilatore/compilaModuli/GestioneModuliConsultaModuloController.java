/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.compilatore.compilaModuli;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.business.interfaces.compilatori.BusinessGestioneModuliCompilatore;
import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.GestioneModuliConsultaModuloModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.util.Costanti;
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
@RequestMapping("/compilatore/gestioneModuliConsultaModulo")

public class GestioneModuliConsultaModuloController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	@Autowired
	protected BusinessGestioneModuliCompilatore businessGestioneModuliCompilatore;
	
	@Autowired
	protected BusinessGestioneEntiCompilatori businessGestioneEntiCompilatori;
	
	@Autowired
	protected BusinessGestioneModuli bmGestioneModuli;

	/**
	 * 
	 * @param ricercaGestioneModuliModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="start",method = {RequestMethod.GET})	
	public String start(@ModelAttribute GestioneModuliConsultaModuloModel gestioneModuliConsultaModuloModel ,Model model,HttpSession session) {
		String methodName="start";
		log.startMethod(methodName);		
		Long idModuloSelezionato =(Long)session.getAttribute(Costanti.ID_MODULO_SEL.getCostante());
		log.debug(methodName, "idModuloSelezionato " + idModuloSelezionato);		
		ModuliModel modulo = bmGestioneModuli.getModuloForId(idModuloSelezionato);		
		List<ColonneModuloModel> listaColonne = bmGestioneModuli.getColonneByIdModulo(idModuloSelezionato,Costanti.COMPILATORE.getCostante() );
		modulo.setListaColonneModulo(listaColonne);
		log.debug(methodName, "listaColonne size " + listaColonne.size());		
		Long idEnteCompilatore = super.getIdEnteCompilatoreSelezionato(session);
		EntiCompilatoriModel entecomp = businessGestioneEntiCompilatori.getEntiCompilatoriById(idEnteCompilatore);
		log.debug(methodName, "idEnteCompilatore" + super.getIdEnteCompilatoreSelezionato(session));
		gestioneModuliConsultaModuloModel.setEntiCompilatori(entecomp);		
		// le righe nel caso sia di tipo consultazione sono identiche per tutti gli enti associati
		List<RigaModuloModel> listaRighe =  new ArrayList<RigaModuloModel>();
		if(modulo.getTipo().equals(Costanti.TIPO_MODULO_COMUNICAZIONE.getCostante())){
			String codicefiscale      = entecomp.getCodiceFiscale();			
			String ragioneSocialeEnte = entecomp.getRagioneSociale();
			listaRighe = bmGestioneModuli.getRigheByIdModuloCFCompilatore( idModuloSelezionato,codicefiscale,ragioneSocialeEnte );
			//listaRighe = bmGestioneModuli.getRigheByIdModulo(idModuloSelezionato);
		}else{
			listaRighe = bmGestioneModuli.getRigheByIdModuloIdEnteCompilatore(idModuloSelezionato, idEnteCompilatore,Costanti.COMPILATORE.getCostante());
		}		
		log.info(methodName, "listaRighe " + listaRighe.size());
		modulo.setListaRigheModulo(listaRighe);		
		gestioneModuliConsultaModuloModel.setModulo(modulo);
		gestioneModuliConsultaModuloModel.setUtentiCompilatori(super.getUtenteCompilatoreConnesso(session));		
		model.addAttribute("gestioneModuliConsultaModuloModel", gestioneModuliConsultaModuloModel);		
		log.stopMethod(methodName+" vado alla pagina /CompilaModuli/consultaModuli.jsp");
		return "/CompilaModuli/consultaModuli";
	}
			
}