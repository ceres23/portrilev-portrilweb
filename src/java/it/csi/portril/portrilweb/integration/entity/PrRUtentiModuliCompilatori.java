/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the pr_r_utenti_moduli_compilatori database table.
 * 
 */
@Entity
@Table(name="pr_r_utenti_moduli_compilatori", schema="portalerilevazioni")
public class PrRUtentiModuliCompilatori implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrRUtentiModuliCompilatoriPK id;

    @Temporal( TemporalType.DATE)
	@Column(name="data_inserimento")
	private Date dataInserimento;

    @Temporal( TemporalType.DATE)
	@Column(name="data_modifica")
	private Date dataModifica;

	//bi-directional many-to-one association to PrTModuli
    @ManyToOne
	@JoinColumn(name="id_modulo", insertable=false, updatable=false)
	private PrTModuli prTModuli;

	//bi-directional many-to-one association to PrTUtentiCompilatori
    @ManyToOne
	@JoinColumn(name="id_utente_compilatore", insertable=false, updatable=false)
	private PrTUtentiCompilatori prTUtentiCompilatori;

    /**
     * 
     */
    public PrRUtentiModuliCompilatori() {
    }

	/**
	 * @return
	 */
	public PrRUtentiModuliCompilatoriPK getId() {
		return this.id;
	}

	/**
	 * @param id
	 */
	public void setId(PrRUtentiModuliCompilatoriPK id) {
		this.id = id;
	}
	
	/**
	 * @return
	 */
	public Date getDataInserimento() {
		return this.dataInserimento;
	}

	/**
	 * @param dataInserimento
	 */
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	/**
	 * @return
	 */
	public Date getDataModifica() {
		return this.dataModifica;
	}

	/**
	 * @param dataModifica
	 */
	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
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
	public PrTUtentiCompilatori getPrTUtentiCompilatori() {
		return this.prTUtentiCompilatori;
	}

	/**
	 * @param prTUtentiCompilatori
	 */
	public void setPrTUtentiCompilatori(PrTUtentiCompilatori prTUtentiCompilatori) {
		this.prTUtentiCompilatori = prTUtentiCompilatori;
	}
	
}