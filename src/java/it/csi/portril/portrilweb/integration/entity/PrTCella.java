/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the pr_t_cella database table.
 * 
 */
@Entity
@Table(name="pr_t_cella", schema="portalerilevazioni")
public class PrTCella implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrTCellaPK id;

	private String valore;

	@Column(name="posizione_riga")
	private Integer posizioneRiga;
	
	@Column(name="posizione_Colonna")
	private Integer posizioneColonna;
	
	@Column(name="editabilita_profilo")
	private String editabilitaProfilo;
	
	//bi-directional many-to-one association to PrTColonneModulo
//	@ManyToOne
//	@JoinColumn(name="id_colonna_modulo", insertable=false, updatable=false)
//	private PrTColonneModulo prTColonneModulo;
//
	//bi-directional many-to-one association to PrTRighe
    @ManyToOne
	@JoinColumn(name="id_riga", insertable=false, updatable=false)
	private PrTRighe prTRighe;

    public PrTCella() {
    }

	/**
	 * @return
	 */
	public PrTCellaPK getId() {
		return this.id;
	}

	/**
	 * @param id
	 */
	public void setId(PrTCellaPK id) {
		this.id = id;
	}
	
	/**
	 * @return
	 */
	public String getValore() {
		return this.valore;
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

//	public PrTColonneModulo getPrTColonneModulo() {
//		return this.prTColonneModulo;
//	}
//
//	public void setPrTColonneModulo(PrTColonneModulo prTColonneModulo) {
//		this.prTColonneModulo = prTColonneModulo;
//	}
//	
	public PrTRighe getPrTRighe() {
		return this.prTRighe;
	}

	public void setPrTRighe(PrTRighe prTRighe) {
		this.prTRighe = prTRighe;
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
	
}