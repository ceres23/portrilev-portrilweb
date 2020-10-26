/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Utility;

import java.util.List;



public class GestioneModuliCompilaModuloModel extends GenericModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8819474190149846865L;

	private String listaIdDaEliminare; 
	
	private String moduloConfermato;

	private String moduloValidato;

	private ModuliModel modulo = new ModuliModel();
	
	private EntiCompilatoriModel entiCompilatori = new EntiCompilatoriModel();
	
	private UtentiCompilatoriModel utentiCompilatori = new UtentiCompilatoriModel();
	
	private List<List<String>>grigliaValori;

	private List<String> celleDaInserire;

	private List<String> campoFiltro;
	

	private boolean goToLastPage = false;
	
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

	
	/**
	 * @return the grigliaValori
	 */
	/**
	 * @return
	 */
	public List<List<String>> getGrigliaValori() {
		return grigliaValori;
	}


	/**
	 * @param grigliaValori the grigliaValori to set
	 */
	/**
	 * @param grigliaValori
	 */
	public void setGrigliaValori(List<List<String>> grigliaValori) {
		this.grigliaValori = grigliaValori;
	}


	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}


	/**
	 * @return the goToLastPage
	 */
	/**
	 * @return
	 */
	public boolean isGoToLastPage() {
		return goToLastPage;
	}


	/**
	 * @param goToLastPage the goToLastPage to set
	 */
	/**
	 * @param goToLastPage
	 */
	public void setGoToLastPage(boolean goToLastPage) {
		this.goToLastPage = goToLastPage;
	}


	/**
	 * @return the listaIdDaEliminare
	 */
	public String getListaIdDaEliminare() {
		return listaIdDaEliminare;
	}


	/**
	 * @param listaIdDaEliminare the listaIdDaEliminare to set
	 */
	public void setListaIdDaEliminare(String listaIdDaEliminare) {
		this.listaIdDaEliminare = listaIdDaEliminare;
	}


	/**
	 * @return the campoinserimento
	 */
	public List<String> getCelleDaInserire() {
		return celleDaInserire;
	}


	/**
	 * @param campoinserimento the campoinserimento to set
	 */
	public void setCelleDaInserire(List<String> celleDaInserire) {
		this.celleDaInserire = celleDaInserire;
	}


	/**
	 * @return the moduloConfermato
	 */
	public String getModuloConfermato() {
		return moduloConfermato;
	}


	/**
	 * @param moduloConfermato the moduloConfermato to set
	 */
	public void setModuloConfermato(String moduloConfermato) {
		this.moduloConfermato = moduloConfermato;
	}


	/**
	 * @return the moduloValidato
	 */
	public String getModuloValidato() {
		return moduloValidato;
	}


	/**
	 * @param moduloValidato the moduloValidato to set
	 */
	public void setModuloValidato(String moduloValidato) {
		this.moduloValidato = moduloValidato;
	}


	/**
	 * @return the campoFiltro
	 */
	public List<String> getCampoFiltro() {
		return campoFiltro;
	}


	/**
	 * @param campoFiltro the campoFiltro to set
	 */
	public void setCampoFiltro(List<String> campoFiltro) {
		this.campoFiltro = campoFiltro;
	}


}