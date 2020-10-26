/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.entity;

import it.csi.portril.portrilweb.util.Costanti;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the pr_t_colonne_modulo database table.
 * 
 */
@Entity
@Table(name="pr_t_colonne_modulo", schema="portalerilevazioni")
public class PrTColonneModulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@SequenceGenerator(name="PR_T_COLONNE_MODULO_IDCOLONNAMODULO_GENERATOR", sequenceName="portalerilevazioni.PR_T_COLONNE_MODULO_ID_COLONNA_MODULO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PR_T_COLONNE_MODULO_IDCOLONNAMODULO_GENERATOR")

	@Column(name="id_colonna_modulo")
	private Long idColonnaModulo;

	@Column(name="dimensione")
	private Integer dimensione;

	@Column(name="dimensione_min")
	private Integer dimensioneMin;

	@Column(name="editabilita_profilo")
	private String editabilitaProfilo;

	@Column(name="flag_obbligatorieta")
	private String flagObbligatorieta;

	//ELIMINO CONCETTO BLOCCANTE E NON 
	//@Column(name="flg_ctrl_bloccante")
	//private String flgCtrlBloccante;

	@Column(name="flg_ctrl_contabilita")
	private String flgCtrlContabilita;

	@Column(name="label_colonna")
	private String labelColonna;

	@Column(name="operatore_numerico")
	private String operatoreNumerico;

	private String modificabile;

	private Integer posizione;

	private String tipo;
	
	@Column(name="valore_fisso")
	private String valoreFisso;


	@Column(name="valore_confronto_operatore_numerico")
	private Double valoreConfrontoOperatoreNumerico;

	//bi-directional many-to-one association to PrTCella
	@OneToMany(mappedBy="id.prTColonneModulo")
	private List<PrTCella> prTCellas;

	//bi-directional many-to-one association to PrTModuli
    @ManyToOne
	@JoinColumn(name="id_modulo")
	private PrTModuli prTModuli;

    /**
     * 
     */
    public PrTColonneModulo() {
    }

	/**
	 * @return
	 */
	public Long getIdColonnaModulo() {
		return this.idColonnaModulo;
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
	public Integer getDimensione() {
		return this.dimensione;
	}

	/**
	 * @param dimensione
	 */
	public void setDimensione(Integer dimensione) {
		this.dimensione = dimensione;
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
	public Integer getDimensioneMin() {
		return this.dimensioneMin;
	}

	
	/**
	 * @return
	 */
	public String getEditabilitaProfilo() {
		return this.editabilitaProfilo;
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
	public String getFlagObbligatorieta() {
		return this.flagObbligatorieta;
	}

	/**
	 * @param flagObbligatorieta
	 */
	public void setFlagObbligatorieta(String flagObbligatorieta) {
		this.flagObbligatorieta = flagObbligatorieta;
	}

	/**
	public String getFlgCtrlBloccante() {
		return this.flgCtrlBloccante;
	}

	public void setFlgCtrlBloccante(String flgCtrlBloccante) {
		this.flgCtrlBloccante = flgCtrlBloccante;
	}
	 */
	
	/**
	 * @return
	 */
	public String getFlgCtrlContabilita() {
		return this.flgCtrlContabilita;
	}

	/**
	 * @param flgCtrlContabilita
	 */
	public void setFlgCtrlContabilita(String flgCtrlContabilita) {
		this.flgCtrlContabilita = flgCtrlContabilita;
	}

	/**
	 * @return
	 */
	public String getLabelColonna() {
		return this.labelColonna;
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
	public String getOperatoreNumerico() {
		return this.operatoreNumerico;
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
	public Integer getPosizione() {
		return this.posizione;
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
		return this.tipo;
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
	public Double getValoreConfrontoOperatoreNumerico() {
		return this.valoreConfrontoOperatoreNumerico;
	}

	/**
	 * @param valoreConfrontoOperatoreNumerico
	 */
	public void setValoreConfrontoOperatoreNumerico(Double valoreConfrontoOperatoreNumerico) {
		this.valoreConfrontoOperatoreNumerico = valoreConfrontoOperatoreNumerico;
	}

	/**
	 * @return
	 */
	public List<PrTCella> getPrTCellas() {
		return this.prTCellas;
	}

	/**
	 * @param prTCellas
	 */
	public void setPrTCellas(List<PrTCella> prTCellas) {
		this.prTCellas = prTCellas;
	}
	
	/**
	 * @return
	 */
	public PrTModuli getPrTModuli() {
		return this.prTModuli;
	}

	/**
	 * @param prTModuli
	 */
	public void setPrTModuli(PrTModuli prTModuli) {
		this.prTModuli = prTModuli;
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
	 * @return
	 */
	public String getTipoErrore() {
		//if(getFlgCtrlBloccante().equals(Costanti.SI.getCostante())){
			return Costanti.ERR.getCostante();
		//}
		//return Costanti.WARN.getCostante();
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

	
}