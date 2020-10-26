/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class AssociaModuliEntiModel extends GenericModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2371301945681296707L;
	
	ModuliModel modulo;
	
	List<EntiCompilatoriModel> listaEntiCompilatoriRicercati = new ArrayList<EntiCompilatoriModel>();
	
	private String codiceFiscale;

	private String ragioneSociale;

	private String comune;

	private String provincia;

	//private String istat;
	
	private String classificazione;
	
	private String partitaIva;
	
	private Long idEnteAssociato;
	
	private Long idEnteDisAssociato;

	private String listaIdDaAssociare;

	private String listaIdDaNonAssociare;

	private String associato =Costanti.DISASSOCIATO.getCostante();

	private String ultimaRicercaAssociato;

	/**
	 * @return
	 */
	public List<Long> getListaIdDaAssociareLong() {
		List<Long> ris = Utility.splittaLong(getListaIdDaAssociare(),",");
		return ris;
	}

	
	/**
	 * @return the classificazione
	 */
	/**
	 * @return
	 */
	public String getClassificazione() {
		return classificazione;
	}


	/**
	 * @param classificazione the classificazione to set
	 */
	/**
	 * @param classificazione
	 */
	public void setClassificazione(String classificazione) {
		this.classificazione = classificazione;
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
	public String getListaIdDaNonAssociare() {
		return listaIdDaNonAssociare;
	}

	/**
	 * @param listaIdDaNonAssociare
	 */
	public void setListaIdDaNonAssociare(String listaIdDaNonAssociare) {
		this.listaIdDaNonAssociare = listaIdDaNonAssociare;
	}

	/**
	 * @return
	 */
	public String getListaIdDaAssociare() {
		return listaIdDaAssociare;
	}

	/**
	 * @param listaIdDaAssociare
	 */
	public void setListaIdDaAssociare(String listaIdDaAssociare) {
		this.listaIdDaAssociare = listaIdDaAssociare;
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
	 * @return
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * @param codiceFiscale
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * @return
	 */
	public String getRagioneSociale() {
		return ragioneSociale;
	}

	/**
	 * @param ragioneSociale
	 */
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	/**
	 * @return
	 */
	public String getComune() {
		return comune;
	}

	/**
	 * @param comune
	 */
	public void setComune(String comune) {
		this.comune = comune;
	}

	/**
	 * @return
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	



	/**
	 * @return
	 */
	public String getPartitaIva() {
		return partitaIva;
	}

	/**
	 * @param partitaIva
	 */
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	/**
	 * @return
	 */
	public Long getIdEnteAssociato() {
		return idEnteAssociato;
	}

	/**
	 * @param idEnteAssociato
	 */
	public void setIdEnteAssociato(Long idEnteAssociato) {
		this.idEnteAssociato = idEnteAssociato;
	}

	/**
	 * @return
	 */
	public Long getIdEnteDisAssociato() {
		return idEnteDisAssociato;
	}

	/**
	 * @param idEnteDisAssociato
	 */
	public void setIdEnteDisAssociato(Long idEnteDisAssociato) {
		this.idEnteDisAssociato = idEnteDisAssociato;
	}	

}
