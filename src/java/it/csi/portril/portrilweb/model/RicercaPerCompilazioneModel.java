/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 71027
 * 
 */
public class RicercaPerCompilazioneModel extends GenericModel {

	private static final long serialVersionUID = -8121766146694176078L;
	private String nome;
	private List<ModuliModel> listaModuli = new ArrayList<ModuliModel>();
	private Long idModuloSel;
	
	/**
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return
	 */
	public List<ModuliModel> getListaModuli() {
		return listaModuli;
	}

	/**
	 * @param listaModuli
	 */
	public void setListaModuli(List<ModuliModel> listaModuli) {
		this.listaModuli = listaModuli;
	}

	/**
	 * @return
	 */
	public Long getIdModuloSel() {
		return idModuloSel;
	}

	/**
	 * @param idModuloSel
	 */
	public void setIdModuloSel(Long idModuloSel) {
		this.idModuloSel = idModuloSel;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
}