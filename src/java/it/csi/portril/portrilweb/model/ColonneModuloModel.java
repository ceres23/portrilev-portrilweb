/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.Utility;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class ColonneModuloModel extends GenericModel  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7155892038247126180L;

	private Long idColonnaModulo;
	
	private Long idModulo;
	
	@NotNull
	@Size(min=1)
	private String labelColonna;
	
	@NotNull
	@Size(min=1)
	private String flagObbligatorieta = Costanti.NO.getCostante();;
	
	@NotNull 
	@NumberFormat(style = Style.NUMBER) 
	@Min(1)
	private Integer posizione;
		
	@NotNull
	@Size(min=1)
	private String tipo;
	
	@NumberFormat(style = Style.NUMBER) 
	private Integer dimensioneMin;

	@NumberFormat(style = Style.NUMBER) 
	private Integer dimensione;
	
	private String operatoreNumerico;
	
	private String tipoOperatore; // es ugule maggiore etc etc
	
	private Double valoreConfrontoOperatoreNumerico;
	
	@NotNull
	@Size(min=1)
	private String editabilitaProfilo;

	private String flgCtrlContabilita;
	
	//private String flgCtrlBloccante;

	private String modificabile = Costanti.SI.getCostante();

	private String valoreFisso ;

	/**
	 * @return the modificabile
	 */
	public String getModificabile() {
		return modificabile;
	}

	/**
	 * @param modificabile the modificabile to set
	 */
	public void setModificabile(String modificabile) {
		this.modificabile = modificabile;
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
	public String getLabelColonna() {
		return labelColonna;
	}

	/**
	 * @param labelColonna
	 */
	public void setLabelColonna(String labelColonna) {
		this.labelColonna = labelColonna;
	}

	/**
	 * @return
	 */
	public String getFlagObbligatorieta() {
		return flagObbligatorieta;
	}

	/**
	 * @param flagObbligatorieta
	 */
	public void setFlagObbligatorieta(String flagObbligatorieta) {
		this.flagObbligatorieta = flagObbligatorieta;
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
	 * @return
	 */
	public Integer getDimensione() {
		return dimensione;
	}

	/**
	 * @param dimensione
	 */
	public void setDimensione(Integer dimensione) {
		this.dimensione = dimensione;
	}

	/**
	 * @return
	 */
	public Integer getDimensioneMin() {
		return dimensioneMin;
	}

	/**
	 * @param dimensioneMin
	 */
	public void setDimensioneMin(Integer dimensioneMin) {
		this.dimensioneMin = dimensioneMin;
	}
	/**
	 * @return
	 */
	public String getOperatoreNumerico() {
		return operatoreNumerico;
	}

	/**
	 * @param operatoreNumerico
	 */
	public void setOperatoreNumerico(String operatoreNumerico) {
		this.operatoreNumerico = operatoreNumerico;
	}

	/**
	 * @return
	 */
	public Double getValoreConfrontoOperatoreNumerico() {
		return valoreConfrontoOperatoreNumerico;
	}

	/**
	 * @param valoreConfrontoOperatoreNumerico
	 */
	public void setValoreConfrontoOperatoreNumerico(
			Double valoreConfrontoOperatoreNumerico) {
		this.valoreConfrontoOperatoreNumerico = valoreConfrontoOperatoreNumerico;
	}

	/**
	 * @return
	 */
	public String getEditabilitaProfilo() {
		return editabilitaProfilo;
	}

	/**
	 * @param editabilitaProfilo
	 */
	public void setEditabilitaProfilo(String editabilitaProfilo) {
		this.editabilitaProfilo = editabilitaProfilo;
	}

	/**
	 * @return
	 */
	public String getFlgCtrlContabilita() {
		return flgCtrlContabilita;
	}

	/**
	 * @param flgCtrlContabilita
	 */
	public void setFlgCtrlContabilita(String flgCtrlContabilita) {
		this.flgCtrlContabilita = flgCtrlContabilita;
	}

	/*
	public String getFlgCtrlBloccante() {
		return flgCtrlBloccante;
	}

	public void setFlgCtrlBloccante(String flgCtrlBloccante) {
		this.flgCtrlBloccante = flgCtrlBloccante;
	}
	*/
	
	/**
	 * @return
	 */
	public String getTipoOperatore() {
		return tipoOperatore;
	}

	/**
	 * @param tipoOperatore
	 */
	public void setTipoOperatore(String tipoOperatore) {
		this.tipoOperatore = tipoOperatore;
	}

	
	/**
	 * @return the valoreFisso
	 */
	public String getValoreFisso() {
		return valoreFisso;
	}

	/**
	 * @param valoreFisso the valoreFisso to set
	 */
	public void setValoreFisso(String valoreFisso) {
		this.valoreFisso = valoreFisso;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}

}
