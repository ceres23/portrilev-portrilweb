/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RigaModuloModel extends EntiCompilatoriModel  {

	private static final long serialVersionUID = 2035780098586619319L;

	private Long idRiga;

	private Long idModulo;

	private Date dataModificaCompilatore;

	private String ragioneSocialeEnte;
	
	private Date dataValidazioneGestore;

	private String flgValidazione;

	private Long idEnteCompilatore;

	private Long idUtenteCompilatore;

	private Long idUtenteGestore;
	
	private Integer posizione;

	private String tipo;

	private Date  dataAgg;
	
	private List<CellaModuloModel> listaCelleModulo =new ArrayList<CellaModuloModel>();

	private List<String> celleDaInserire;

	
	/**
	 * @return
	 */
	public Long getIdRiga() {
		return idRiga;
	}

	/**
	 * @param idRiga
	 */
	public void setIdRiga(Long idRiga) {
		this.idRiga = idRiga;
	}

	/**
	 * @return
	 */
	public Long getIdModulo() {
		return idModulo;
	}

	/**
	 * @param idModulo
	 */
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	/**
	 * @return
	 */
	public Date getDataModificaCompilatore() {
		return dataModificaCompilatore;
	}

	/**
	 * @param dataModificaCompilatore
	 */
	public void setDataModificaCompilatore(Date dataModificaCompilatore) {
		this.dataModificaCompilatore = dataModificaCompilatore;
	}

	/**
	 * @return
	 */
	public Date getDataValidazioneGestore() {
		return dataValidazioneGestore;
	}

	/**
	 * @param dataValidazioneGestore
	 */
	public void setDataValidazioneGestore(Date dataValidazioneGestore) {
		this.dataValidazioneGestore = dataValidazioneGestore;
	}

	/**
	 * @return
	 */
	public String getFlgValidazione() {
		return flgValidazione;
	}

	/**
	 * @param flgValidazione
	 */
	public void setFlgValidazione(String flgValidazione) {
		this.flgValidazione = flgValidazione;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.EntiCompilatoriModel#getIdEnteCompilatore()
	 */
	public Long getIdEnteCompilatore() {
		return idEnteCompilatore;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.EntiCompilatoriModel#setIdEnteCompilatore(java.lang.Long)
	 */
	public void setIdEnteCompilatore(Long idEnteCompilatore) {
		this.idEnteCompilatore = idEnteCompilatore;
	}

	/**
	 * @return
	 */
	public Long getIdUtenteCompilatore() {
		return idUtenteCompilatore;
	}

	/**
	 * @param idUtenteCompilatore
	 */
	public void setIdUtenteCompilatore(Long idUtenteCompilatore) {
		this.idUtenteCompilatore = idUtenteCompilatore;
	}

	/**
	 * @return
	 */
	public Long getIdUtenteGestore() {
		return idUtenteGestore;
	}

	/**
	 * @param idUtenteGestore
	 */
	public void setIdUtenteGestore(Long idUtenteGestore) {
		this.idUtenteGestore = idUtenteGestore;
	}

	/**
	 * @return
	 */
	public List<CellaModuloModel> getListaCelleModulo() {
		return listaCelleModulo;
	}

	/**
	 * @param listaCelleModulo
	 */
	public void setListaCelleModulo(List<CellaModuloModel> listaCelleModulo) {
		this.listaCelleModulo = listaCelleModulo;
	}
	
	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.EntiCompilatoriModel#getChecked()
	 */
	public String getChecked() {
		if(dataValidazioneGestore!=null && !dataValidazioneGestore.toString().trim().equals("")){
			return "checked='checked'";
		}
		return "";
	}
	
	/**
	 * @return
	 */
	public boolean isValidato() {
		if(dataValidazioneGestore!=null && !dataValidazioneGestore.toString().trim().equals("")){
			return true;
		}
		return false;
	}
	
	/**
	 * @return
	 */
	public Integer getPosizione() {
		return posizione;
	}

	/**
	 * @param posizione
	 */
	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}

	/**
	 * @return
	 */
	public String getRagioneSocialeEnte() {
		return ragioneSocialeEnte;
	}

	/**
	 * @param ragioneSocialeEnte
	 */
	public void setRagioneSocialeEnte(String ragioneSocialeEnte) {
		this.ragioneSocialeEnte = ragioneSocialeEnte;
	}

	/**
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	/**
	 * @return the dataAgg
	 */
	public Date getDataAgg() {
		return dataAgg;
	}

	/**
	 * @param dataAgg the dataAgg to set
	 */
	public void setDataAgg(Date dataAgg) {
		this.dataAgg = dataAgg;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.EntiCompilatoriModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}

	/**
	 * @return the celleDaInserire
	 */
	public List<String> getCelleDaInserire() {
		return celleDaInserire;
	}

	/**
	 * @param celleDaInserire the celleDaInserire to set
	 */
	public void setCelleDaInserire(List<String> celleDaInserire) {
		this.celleDaInserire = celleDaInserire;
	}

}
