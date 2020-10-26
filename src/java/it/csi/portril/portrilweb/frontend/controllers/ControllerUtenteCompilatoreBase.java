/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers;

import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.List;


public class ControllerUtenteCompilatoreBase extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());

	
	/**
	 * 
	 * @param listaRicercati
	 * @param listaAssociati
	 * @param id
	 * @return
	 */
	protected List<EntiCompilatoriModel> trasferisciElementoDiLista(List<EntiCompilatoriModel> listaRicercati,List<EntiCompilatoriModel> listaAssociati, Long id) {
		String methodName = "trasferisciElementoDiLista";
        boolean isAdd = true;
        // controllo che non sia gia' stato associato
        // se così è non lo associo
		for(EntiCompilatoriModel sel : listaAssociati) {
			if(sel.getIdEnteCompilatore().equals(id)){
				isAdd = false;
				break;
			}
		}		
		if(isAdd){
			for(EntiCompilatoriModel ricercato : listaRicercati) {
				if(ricercato.getIdEnteCompilatore().equals(id)){
					log.info(methodName, "ricercato.getIdEnteCompilatore() " + ricercato.getIdEnteCompilatore());	
					listaAssociati.add(ricercato);
					break;
				}
			}			
		}
		return listaAssociati;
	}

}
