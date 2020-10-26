/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Utility;

import java.util.List;

public class DettaglioDatiEnteModel extends GenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8975672327603377430L;

	private EntiCompilatoriModel entiCompilatoriModel;
	
	private List<RigaModuloModel> listaRigheModulo;

	private List<ColonneModuloModel> listaColonneModulo;

	/**
	 * @return
	 */
	public EntiCompilatoriModel getEntiCompilatoriModel() {
		return entiCompilatoriModel;
	}

	/**
	 * @param entiCompilatoriModel
	 */
	public void setEntiCompilatoriModel(EntiCompilatoriModel entiCompilatoriModel) {
		this.entiCompilatoriModel = entiCompilatoriModel;
	}

	/**
	 * @return
	 */
	public List<RigaModuloModel> getListaRigheModulo() {
		return listaRigheModulo;
	}

	/**
	 * @param listaRigheModulo
	 */
	public void setListaRigheModulo(List<RigaModuloModel> listaRigheModulo) {
		this.listaRigheModulo = listaRigheModulo;
	}

	/**
	 * @return
	 */
	public List<ColonneModuloModel> getListaColonneModulo() {
		return listaColonneModulo;
	}

	/**
	 * @param listaColonneModulo
	 */
	public void setListaColonneModulo(List<ColonneModuloModel> listaColonneModulo) {
		this.listaColonneModulo = listaColonneModulo;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}

}
