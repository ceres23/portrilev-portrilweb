/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.Utility;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class GestioneRisultatiModel extends GenericModel{

	private static final long serialVersionUID = 7760594931096332352L;
	private String nome;
	private String stato;
	//checked="checked"	
	private ModuliModel moduloSelezionato;	
	private boolean aperturaModale=false;	
	private String oggMailModulo;	
	private String descMailModulo;
	private String gruppoSollecito;
	private String codiceGruppo;
	private String listaIdXCsv;				                   
	private Long idModuloSel;
	
	private List<ModuliModel> listaModuli;
	
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
	public Long getIdModuloSel() {
		return idModuloSel;
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
	public String getCkAll() {
		String ris = "";
		if(StringUtils.isBlank(getStato()) ||    getStato().equals("ALL")){
			ris = "checked='checked'";
		}
		return ris;
	}


	
	/**
	 * @return
	 */
	public String getCkCom() {
		String ris = "";
		if(!StringUtils.isBlank(getStato()) && getStato().equals("IN_COMPILAZIONE")){
			ris = "checked='checked'";
		}
		return ris;
	}



	/**
	 * @return
	 */
	public String getCkCh() {
		String ris = "";
		if(!StringUtils.isBlank(getStato()) && getStato().equals("CHIUSO")){
			ris= "checked='checked'";
		}
		return ris;
	}


	/**
	 * @return
	 */
	public String getCkInDef() {
		String ris = "";
		if(!StringUtils.isBlank(getStato()) && getStato().equals(Costanti.IN_DEFINIZIONE.getCostante())){
			ris= "checked='checked'";
		}
		return ris;
	}
	
	/**
	 * @param idModuloSel
	 */
	public void setIdModuloSel(Long idModuloSel) {
		this.idModuloSel = idModuloSel;
	}

	/**
	 * @return the moduloSelezionato
	 */
	public ModuliModel getModuloSelezionato() {
		return moduloSelezionato;
	}

	/**
	 * @param moduloSelezionato the moduloSelezionato to set
	 */
	public void setModuloSelezionato(ModuliModel moduloSelezionato) {
		this.moduloSelezionato = moduloSelezionato;
	}

	/**
	 * @return the aperturaModale
	 */
	public boolean isAperturaModale() {
		return aperturaModale;
	}

	/**
	 * @param aperturaModale the aperturaModale to set
	 */
	public void setAperturaModale(boolean aperturaModale) {
		this.aperturaModale = aperturaModale;
	}

	/**
	 * @return the oggMailModulo
	 */
	public String getOggMailModulo() {
		return oggMailModulo;
	}

	/**
	 * @param oggMailModulo the oggMailModulo to set
	 */
	public void setOggMailModulo(String oggMailModulo) {
		this.oggMailModulo = oggMailModulo;
	}

	/**
	 * @return the descMailModulo
	 */
	public String getDescMailModulo() {
		return descMailModulo;
	}

	/**
	 * @param descMailModulo the descMailModulo to set
	 */
	public void setDescMailModulo(String descMailModulo) {
		this.descMailModulo = descMailModulo;
	}

	/**
	 * @return the gruppoSollecito
	 */
	public String getGruppoSollecito() {
		return gruppoSollecito;
	}

	/**
	 * @param gruppoSollecito the gruppoSollecito to set
	 */
	public void setGruppoSollecito(String gruppoSollecito) {
		this.gruppoSollecito = gruppoSollecito;
	}

	/**
	 * @return the codiceGruppo
	 */
	public String getCodiceGruppo() {
		return codiceGruppo;
	}

	/**
	 * @param codiceGruppo the codiceGruppo to set
	 */
	public void setCodiceGruppo(String codiceGruppo) {
		this.codiceGruppo = codiceGruppo;
	}

	/**
	 * @return the listaIdXCsv
	 */
	public String getListaIdXCsv() {
		return listaIdXCsv;
	}

	/**
	 * @param listaIdXCsv the listaIdXCsv to set
	 */
	public void setListaIdXCsv(String listaIdXCsv) {
		this.listaIdXCsv = listaIdXCsv;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
}
