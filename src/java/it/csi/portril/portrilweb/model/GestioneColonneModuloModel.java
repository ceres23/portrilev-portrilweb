/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.Utility;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class GestioneColonneModuloModel extends GenericModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2035780098586619319L;

	private ModuliModel modulo;

	private Long idColonnaModulo;
	
	private Long idModulo;
	
	private Integer idPosizioneSel;

	private Integer posizioneProposta=null;

	private String  modificabile = Costanti.SI.getCostante();

	private boolean strutturaModificabile=true;
	
	@NotNull
	@Size(min=1)
	private String editabilitaProfilo=Costanti.COMPILATORE.getCostante();

	private String flagObbligatorieta=Costanti.NO.getCostante();

	private String flgCtrlContabilita=Costanti.NO.getCostante();
	               
	//private String flgCtrlBloccante=Costanti.NO.getCostante();
	
	private String selected="";
	
	private List<ColonneModuloModel> listaColonneModulo =new ArrayList<ColonneModuloModel>();	
	
	@NotNull
	@Size(min=1)
	private String labelColonna;
	
	@NotNull 
	@NumberFormat(style = Style.NUMBER) 
	@Min(1)
	private Integer posizione;
		
	@NotNull
	@Size(min=1)
	private String tipoValore;
	
	@NumberFormat(style = Style.NUMBER) 
	private Integer dimensione = 100;
	
	@NumberFormat(style = Style.NUMBER) 
	private Integer dimensioneMin = 0;

	private String operatoreNumerico;
	
	private String tipoOperatore; // es ugule maggiore etc etc
	
	@NumberFormat(style = Style.NUMBER) 	
	private Long valoreConfrontoOperatoreNumerico=0L;
	
	private String valoreFisso; // es ugule maggiore etc etc
	
	
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
	public String getTipoValore() {
		return tipoValore;
	}

	/**
	 * @param tipoValore
	 */
	public void setTipoValore(String tipoValore) {
		this.tipoValore = tipoValore;
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
	 * @param dimensione
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
	public Long getValoreConfrontoOperatoreNumerico() {
		return valoreConfrontoOperatoreNumerico;
	}

	/**
	 * @param valoreConfrontoOperatoreNumerico
	 */
	public void setValoreConfrontoOperatoreNumerico(
			Long valoreConfrontoOperatoreNumerico) {
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
	public List<ColonneModuloModel> getListaColonneModulo() {
		return listaColonneModulo;
	}

	/**
	 * @param listaColonneModulo
	 */
	public void setListaColonneModulo(List<ColonneModuloModel> listaColonneModulo) {
		this.listaColonneModulo = listaColonneModulo;
	}
	
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
	 * @return
	 */
	public Integer getPosizioneProposta(){
		if(this.posizioneProposta==null){
			return getListaColonneModulo().size()+1;
		}else{
			return posizioneProposta;
		}
	}

	/**
	 * @param value
	 */
	public void setPosizioneProposta(Integer value){
		this.posizioneProposta = value;
	}

	/**
	 * @return
	 */
	public String getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 */
	public void setSelected(String selected) {
		this.selected = selected;
	}

	/**
	 * @return
	 */
	public Integer getIdPosizioneSel() {
		return idPosizioneSel;
	}


	/**
	 * @param idPosizioneSel
	 */
	public void setIdPosizioneSel(Integer idPosizioneSel) {
		this.idPosizioneSel = idPosizioneSel;
	}

	
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
	 * @return the strutturaModificabile
	 */
	public boolean isStrutturaModificabile() {
		return strutturaModificabile;
	}

	/**
	 * @param strutturaModificabile the strutturaModificabile to set
	 */
	public void setStrutturaModificabile(boolean strutturaModificabile) {
		this.strutturaModificabile = strutturaModificabile;
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
