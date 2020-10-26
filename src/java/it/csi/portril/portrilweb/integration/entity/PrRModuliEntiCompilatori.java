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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the pr_r_utenti_moduli_compilatori database table.
 * 
 */
@Entity
@Table(name="pr_r_moduli_enti_compilatori", schema="portalerilevazioni")
public class PrRModuliEntiCompilatori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pr_r_moduli_enti_compilatori_id_utenti_moduli_compilatori_seq_GENERATOR", allocationSize=1, sequenceName="pr_r_moduli_enti_compilatori_id_utenti_moduli_compilatori_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pr_r_moduli_enti_compilatori_id_utenti_moduli_compilatori_seq_GENERATOR")
	@Column(name="id_utenti_moduli_compilatori")
	private Long idUtentiModuliCompilatori;
	
	//bi-directional many-to-one association to PrTModuli
    @ManyToOne
	@JoinColumn(name="id_modulo", insertable=false, updatable=false)
	private PrTModuli prTModuli;

	//bi-directional many-to-one association to PrTUtentiCompilatori
    @ManyToOne
	@JoinColumn(name="id_ente_compilatore", insertable=false, updatable=false)
	private PrTEntiCompilatori prTEntiCompilatori;
    

    /**
     * 
     */
    public PrRModuliEntiCompilatori() {
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
	 * @return
	 */
	public PrTEntiCompilatori getPrTEntiCompilatori() {
		return this.prTEntiCompilatori;
	}

	/**
	 * @param prTUtentiCompilatori
	 */
	public void setPrTEntiCompilatori(PrTEntiCompilatori prTEntiCompilatori) {
		this.prTEntiCompilatori = prTEntiCompilatori;
	}

	/**
	 * @return the idUtentiModuliCompilatori
	 */
	public Long getIdUtentiModuliCompilatori() {
		return idUtentiModuliCompilatori;
	}

	/**
	 * @param idUtentiModuliCompilatori the idUtentiModuliCompilatori to set
	 */
	public void setIdUtentiModuliCompilatori(Long idUtentiModuliCompilatori) {
		this.idUtentiModuliCompilatori = idUtentiModuliCompilatori;
	}
	
	
}