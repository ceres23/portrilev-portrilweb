/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Utility;


public class CellaModuloModel extends GenericModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2035780098586619319L;


	private Long idRiga;

	private Long idColonnaModulo;
	
	private Integer posizioneRiga;

	private Integer posizioneColonna;

	private Integer posizioneCompilatoreRiga;

	private Integer posizioneCompilatoreColonna;
	
	private String valore;

	private String editabilitaProfilo;

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
	public Long getIdColonnaModulo() {
		return idColonnaModulo;
	}

	/**
	 * @param idColonnaModulo
	 */
	public void setIdColonnaModulo(Long idColonnaModulo) {
		this.idColonnaModulo = idColonnaModulo;
	}

	/**
	 * @return
	 */
	public String getValore() {
		return valore;
	}

	/**
	 * @return
	 */
	public Double getValoreDouble() {
		try{
			return Double.valueOf(valore);
		}catch(Exception e){
			return -1.0;
		}
		
	}
	
	/**
	 * @param valore
	 */
	public void setValore(String valore) {
		this.valore = valore;
	}

	/**
	 * @return
	 */
	public Integer getPosizioneRiga() {
		return posizioneRiga;
	}

	/**
	 * @param posizioneRiga
	 */
	public void setPosizioneRiga(Integer posizioneRiga) {
		this.posizioneRiga = posizioneRiga;
	}

	/**
	 * @return
	 */
	public Integer getPosizioneColonna() {
		return posizioneColonna;
	}

	/**
	 * @param posizioneColonna
	 */
	public void setPosizioneColonna(Integer posizioneColonna) {
		this.posizioneColonna = posizioneColonna;
	}

	/**
	 * @return
	 */
	public String getEditabilitaProfilo() {
		return editabilitaProfilo.trim();
	}

	/**
	 * @param editabilitaProfilo
	 */
	public void setEditabilitaProfilo(String editabilitaProfilo) {
		this.editabilitaProfilo = editabilitaProfilo;
	}


	
	/**
	 * @return the posizioneCompilatoreRiga
	 */
	/**
	 * @return
	 */
	public Integer getPosizioneCompilatoreRiga() {
		return posizioneCompilatoreRiga;
	}

	/**
	 * @param posizioneCompilatoreRiga the posizioneCompilatoreRiga to set
	 */
	/**
	 * @param posizioneCompilatoreRiga
	 */
	public void setPosizioneCompilatoreRiga(Integer posizioneCompilatoreRiga) {
		this.posizioneCompilatoreRiga = posizioneCompilatoreRiga;
	}

	/**
	 * @return the posizioneCompilatoreColonna
	 */
	/**
	 * @return
	 */
	public Integer getPosizioneCompilatoreColonna() {
		return posizioneCompilatoreColonna;
	}

	/**
	 * @param posizioneCompilatoreColonna the posizioneCompilatoreColonna to set
	 */
	/**
	 * @param posizioneCompilatoreColonna
	 */
	public void setPosizioneCompilatoreColonna(Integer posizioneCompilatoreColonna) {
		this.posizioneCompilatoreColonna = posizioneCompilatoreColonna;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
	

	

}
