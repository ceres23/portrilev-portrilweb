/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the pr_t_utenti_gestori database table.
 * 
 */
@Entity
@Table(name="csi_log_audit", schema="portalerilevazioni")
public class CsiLogAudit implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	 data_ora date NOT NULL,
	  id_app character varying(100) NOT NULL,
	  ip_address character varying(40),
	  utente character varying(100) NOT NULL,
	  operazione character varying(50) NOT NULL,
	  ogg_oper character varying(1500) NOT NULL,
	  key_oper character varying(500) NOT NULL
	*/
	
	@Id
	@Column(name="data_ora")
	private Date dataOra;

	@Column(name="id_app")
	private String idApp;

	@Column(name="ip_address")
	private String ipAddress;

	private String utente;

	private String operazione;

	@Column(name="ogg_oper")
	private String oggOper;

	@Column(name="key_oper")
	private String keyOper;


    /**
     * 
     */
    public CsiLogAudit() {
    }


	/**
	 * @return the dataOra
	 */
	public Date getDataOra() {
		return dataOra;
	}


	/**
	 * @param dataOra the dataOra to set
	 */
	public void setDataOra(Date dataOra) {
		this.dataOra = dataOra;
	}


	/**
	 * @return the idApp
	 */
	public String getIdApp() {
		return idApp;
	}


	/**
	 * @param idApp the idApp to set
	 */
	public void setIdApp(String idApp) {
		this.idApp = idApp;
	}


	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}


	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}


	/**
	 * @return the utente
	 */
	public String getUtente() {
		return utente;
	}


	/**
	 * @param utente the utente to set
	 */
	public void setUtente(String utente) {
		this.utente = utente;
	}


	/**
	 * @return the operazione
	 */
	public String getOperazione() {
		return operazione;
	}


	/**
	 * @param operazione the operazione to set
	 */
	public void setOperazione(String operazione) {
		this.operazione = operazione;
	}


	/**
	 * @return the oggOper
	 */
	public String getOggOper() {
		return oggOper;
	}


	/**
	 * @param oggOper the oggOper to set
	 */
	public void setOggOper(String oggOper) {
		this.oggOper = oggOper;
	}


	/**
	 * @return the key_oper
	 */
	public String getKeyOper() {
		return keyOper;
	}


	/**
	 * @param key_oper the key_oper to set
	 */
	public void setKeyOper(String keyOper) {
		this.keyOper = keyOper;
	}


	
}