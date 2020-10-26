/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.Utility;

import java.util.ArrayList;
import java.util.List;


public class ReportEntiCompilatoriFromModuloModel extends GenericModel{

	
	private static final long serialVersionUID = 472869084570583613L;
	
	private String stato = Costanti.TUTTI.getCostante();
	
	private String nomeModulo;
	
	private ModuliModel modulo;
	
	private List<EntiCompilatoriModel> listaEntiCompilatori = new ArrayList<EntiCompilatoriModel>();
	
	/**
	 * @return
	 */
	public String getStato() {
		return stato;
	}

	/**
	 * @param stato
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/**
	 * @return
	 */
	public String getNomeModulo() {
		return nomeModulo;
	}

	/**
	 * @param nomeModulo
	 */
	public void setNomeModulo(String nomeModulo) {
		this.nomeModulo = nomeModulo;
	}

	/**
	 * @return
	 */
	public List<EntiCompilatoriModel> getListaEntiCompilatori() {
		return listaEntiCompilatori;
	}

	/**
	 * @param listaEntiCompilatori
	 */
	public void setListaEntiCompilatori(List<EntiCompilatoriModel> listaEntiCompilatori) {
		this.listaEntiCompilatori = listaEntiCompilatori;
	}

	/**
	 * @return
	 */
	public ModuliModel getModulo() {
		return modulo;
	}

	/**
	 * @param modulo
	 */
	public void setModulo(ModuliModel modulo) {
		this.modulo = modulo;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
}
