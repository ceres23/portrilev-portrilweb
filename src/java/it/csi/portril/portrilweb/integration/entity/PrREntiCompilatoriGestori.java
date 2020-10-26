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
 * The persistent class for the pr_r_enti_compilatori_gestori database table.
 * 
 */
@Entity
@Table(name="pr_r_enti_compilatori_gestori", schema="portalerilevazioni")
@NamedQuery(name="PrREntiCompilatoriGestori.findAll", query="SELECT p FROM PrREntiCompilatoriGestori p")
public class PrREntiCompilatoriGestori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pr_r_enti_compilatori_gestori_id_ente_compilatori_gestori_seq_GENERATOR", sequenceName="portalerilevazioni.pr_r_enti_compilatori_gestori_id_ente_compilatori_gestori_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pr_r_enti_compilatori_gestori_id_ente_compilatori_gestori_seq_GENERATOR")
	
	@Column(name="id_ente_compilatori_gestori")
	private Long idEnteCompilatoriGestori;

	@ManyToOne
	@JoinColumn(name="id_ente_compilatore")
	private PrTEntiCompilatori prTEntiCompilatori;

    @ManyToOne
	@JoinColumn(name="id_ente_gestore")
	private PrTEntiGestori prTEntiGestori;

	/**
	 * @return the idEnteCompilatoriGestori
	 */
	public Long getIdEnteCompilatoriGestori() {
		return idEnteCompilatoriGestori;
	}

	/**
	 * @param idEnteCompilatoriGestori the idEnteCompilatoriGestori to set
	 */
	public void setIdEnteCompilatoriGestori(Long idEnteCompilatoriGestori) {
		this.idEnteCompilatoriGestori = idEnteCompilatoriGestori;
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
	 * @return the prTEnteGestore
	 */
	public PrTEntiGestori getPrTEntiGestori() {
		return prTEntiGestori;
	}

	/**
	 * @param prTEnteGestore the prTEnteGestore to set
	 */
	public void setPrTEnteGestore(PrTEntiGestori prTEntiGestori) {
		this.prTEntiGestori = prTEntiGestori;
	}
    
}