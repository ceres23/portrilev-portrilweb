/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class SbloccaConfermeModuliModel extends GenericModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2371301945681296707L;	
	ModuliModel modulo;	
	List<EntiCompilatoriModel> listaEntiCompilatoriRicercati = new ArrayList<EntiCompilatoriModel>();	
	private String listaIdDaSbloccare;
	private String associato =Costanti.DISASSOCIATO.getCostante();
	private String ultimaRicercaAssociato;
	private String statoConferma=Costanti.SI.getCostante();

	/**
	 * @return
	 */
	public List<Long> getListaIdDaSbloccareLong() {
		List<Long> ris = Utility.splittaLong(getListaIdDaSbloccare(),",");
		return ris;
	}

	/**
	 * @return the ultimaRicercaAssociato
	 */
	/**
	 * @return
	 */
	public String getUltimaRicercaAssociato() {
		return ultimaRicercaAssociato;
	}


	/**
	 * @param ultimaRicercaAssociato the ultimaRicercaAssociato to set
	 */
	/**
	 * @param ultimaRicercaAssociato
	 */
	public void setUltimaRicercaAssociato(String ultimaRicercaAssociato) {
		this.ultimaRicercaAssociato = ultimaRicercaAssociato;
	}


	/**
	 * @return
	 */
	public String getListaIdDaSbloccare() {
		return listaIdDaSbloccare;
	}

	/**
	 * @param listaIdDaNonAssociare
	 */
	public void setListaIdDaSbloccare(String listaIdDaSbloccare) {
		this.listaIdDaSbloccare = listaIdDaSbloccare;
	}

	
	/**
	 * @return
	 */
	public List<EntiCompilatoriModel> getListaEntiCompilatoriRicercati() {
		return listaEntiCompilatoriRicercati;
	}

	/**
	 * @param listaEntiCompilatoriRicercati
	 */
	public void setListaEntiCompilatoriRicercati(
			List<EntiCompilatoriModel> listaEntiCompilatoriRicercati) {
		this.listaEntiCompilatoriRicercati = listaEntiCompilatoriRicercati;
	}
	
	/*
	 
	public List<EntiCompilatoriModel> getListaEntiCompilatoriAssociati() {
		return listaEntiCompilatoriAssociati;
	}

	public void setListaEntiCompilatoriAssociati(
			List<EntiCompilatoriModel> listaEntiCompilatoriAssociati) {
		this.listaEntiCompilatoriAssociati = listaEntiCompilatoriAssociati;
	}
	
 	*/
	
	/**
	 * @return
	 */
	public ModuliModel getModulo() {
		return modulo;
	}

	/**
	 * @return the associato
	 */
	/**
	 * @return
	 */
	public String getAssociato() {
		return associato;
	}

	/**
	 * @param associato the associato to set
	 */
	/**
	 * @param associato
	 */
	public void setAssociato(String associato) {
		this.associato = associato;
	}

	/**
	 * @param modulo
	 */
	public void setModulo(ModuliModel modulo) {
		this.modulo = modulo;
	}

	/**
	 * @return the statoConferma
	 */
	public String getStatoConferma() {
		return statoConferma;
	}

	/**
	 * @param statoConferma the statoConferma to set
	 */
	public void setStatoConferma(String statoConferma) {
		this.statoConferma = statoConferma;
	}
	
	
}
