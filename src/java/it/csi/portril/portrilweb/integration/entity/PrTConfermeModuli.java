/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the pr_t_righe database table.
 * 
 */
@Entity
@Table(name="pr_t_conferme_moduli", schema="portalerilevazioni")
@NamedQuery(name="PrTConfermeModuli.findAll", query="SELECT p FROM PrTConfermeModuli p")
public class PrTConfermeModuli implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pr_t_conferme_moduli_id_conferme_moduli_seq_GENERATOR", sequenceName="portalerilevazioni.pr_t_conferme_moduli_id_conferme_moduli_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pr_t_conferme_moduli_id_conferme_moduli_seq_GENERATOR")
	
	@Column(name="id_conferme_moduli")
	private Long idConfermeModuli;

	@ManyToOne
	@JoinColumn(name="id_ente_compilatore")
	private PrTEntiCompilatori prTEntiCompilatori;

	//bi-directional many-to-one association to PrTRighe
    @ManyToOne
	@JoinColumn(name="id_modulo")
	private PrTModuli prTModuli;

	@Column(name="modulo_confermato")
	private String moduloConfermato;

	@Column(name="modulo_validato")
	private String moduloValidato;

	/**
	 * @return the idConfermeModuli
	 */
	public Long getIdConfermeModuli() {
		return idConfermeModuli;
	}

	/**
	 * @param idConfermeModuli the idConfermeModuli to set
	 */
	public void setIdConfermeModuli(Long idConfermeModuli) {
		this.idConfermeModuli = idConfermeModuli;
	}

	/**
	 * @return the prTEntiCompilatori
	 */
	public PrTEntiCompilatori getPrTEntiCompilatori() {
		return prTEntiCompilatori;
	}

	/**
	 * @param prTEntiCompilatori the prTEntiCompilatori to set
	 */
	public void setPrTEntiCompilatori(PrTEntiCompilatori prTEntiCompilatori) {
		this.prTEntiCompilatori = prTEntiCompilatori;
	}

	/**
	 * @return the prTModuli
	 */
	public PrTModuli getPrTModuli() {
		return prTModuli;
	}

	/**
	 * @param prTModuli the prTModuli to set
	 */
	public void setPrTModuli(PrTModuli prTModuli) {
		this.prTModuli = prTModuli;
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
	
	
}