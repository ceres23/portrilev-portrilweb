/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Utility;



public class GestioneModuliConsultaModuloModel extends GenericModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8819474190149846865L;

	ModuliModel modulo = new ModuliModel();
	EntiCompilatoriModel entiCompilatori = new EntiCompilatoriModel();
	UtentiCompilatoriModel utentiCompilatori = new UtentiCompilatoriModel();
	
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


	/**
	 * @return
	 */
	public EntiCompilatoriModel getEntiCompilatori() {
		return entiCompilatori;
	}


	/**
	 * @param entiCompilatori
	 */
	public void setEntiCompilatori(EntiCompilatoriModel entiCompilatori) {
		this.entiCompilatori = entiCompilatori;
	}


	/**
	 * @return
	 */
	public UtentiCompilatoriModel getUtentiCompilatori() {
		return utentiCompilatori;
	}


	/**
	 * @param utentiCompilatori
	 */
	public void setUtentiCompilatori(UtentiCompilatoriModel utentiCompilatori) {
		this.utentiCompilatori = utentiCompilatori;
	}


	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}

}