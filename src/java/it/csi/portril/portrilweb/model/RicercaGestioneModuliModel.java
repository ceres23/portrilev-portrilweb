/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.Utility;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @author 71027
 * 
 */
public class RicercaGestioneModuliModel extends GenericModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1098184462492518351L;

	/**
	 * 
	 */
	public RicercaGestioneModuliModel() {
	}
	
	private String stato = "ALL";
	
	private String nome = null;
	
	private Long  idModuloSel;
	
	private String oggMailModulo;
	
	private String descMailModulo;
	
	private ModuliModel moduloSelezionato;
	
	private List<ModuliModel> listaModuli;
	
	private String tipo = Costanti.TIPO_MODULO_RILEVAZIONE.getCostante();
	
	private boolean aperturaModale=false;	
	
	/**
	 * @return the tipo
	 */
	/**
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	/**
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	/**
	 * @return
	 */
	public String getCkAll() {
		String ris = "";
		if(StringUtils.isBlank(getStato()) ||    getStato().equals("ALL")){
			ris = "checked";
		}
		return ris;
	}


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
	public Long getIdModuloSel() {
		return idModuloSel;
	}


	/**
	 * @param idModuloSel
	 */
	public void setIdModuloSel(Long idModuloSel) {
		this.idModuloSel = idModuloSel;
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
	public ModuliModel getModuloSelezionato() {
		return moduloSelezionato;
	}

	/**
	 * @param moduloSelezionato
	 */
	public void setModuloSelezionato(ModuliModel moduloSelezionato) {
		this.moduloSelezionato = moduloSelezionato;
	}

	/**
	 * @return
	 */
	public String getOggMailModulo() {
		return oggMailModulo;
	}

	/**
	 * @param oggMailModulo
	 */
	public void setOggMailModulo(String oggMailModulo) {
		this.oggMailModulo = oggMailModulo;
	}

	/**
	 * @return
	 */
	public String getDescMailModulo() {
		return descMailModulo;
	}

	/**
	 * @param descMailModulo
	 */
	public void setDescMailModulo(String descMailModulo) {
		this.descMailModulo = descMailModulo;
	}

	/**
	 * @return
	 */
	public boolean isAperturaModale() {
		return aperturaModale;
	}

	/**
	 * @param aperturaModale
	 */
	public void setAperturaModale(boolean aperturaModale) {
		this.aperturaModale = aperturaModale;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
}
