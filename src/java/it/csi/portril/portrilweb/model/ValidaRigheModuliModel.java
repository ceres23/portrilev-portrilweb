/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.model.validator.CodiceFiscale;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.Utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValidaRigheModuliModel extends GenericModel{

	private static final long serialVersionUID = -5501224897866125041L;

	private Long idModuloSel;
	
	private Long idEnteCompilatore;
	
	private Long idEnteGestore;

	@CodiceFiscale(numChar={16,11},required=false)
	private String codiceFiscale;

	private String comune;

	private String classificazione;

	private String mail;

	private String partitaIva;

	private String provincia;

	//private String istat;

	private String ragioneSociale;

	private Date  dataAgg;
	
	private String regione;

	private String stato;
	
	private String anno;

	private String numero;
	
	private String struttura;
	
	private String listaIdDaValidare;
	
	private String listaIdDaNonValidare;
	
	private String provvedimento;
	
	private String statoRiga=Costanti.TUTTI.getCostante();

	private List<List<String>>listaRigheVisibili = new ArrayList<List<String>>();// = new  String [Integer.parseInt(Costanti.NUM_MAX_RIC.getCostante())][Integer.parseInt(Costanti.NUM_MAX_RIC.getCostante())];

	private List<RigaModuloModel> listaRigheModulo      = new ArrayList<RigaModuloModel>();
	
	private List<ColonneModuloModel> listaColonneModulo = new ArrayList<ColonneModuloModel>();
	
	/**
	 * @return
	 */
	public List<Long> getListaIdDaValidareLong() {
		List<Long> ris = Utility.splittaLong(getListaIdDaValidare(),",");
		return ris;
	}

	/**
	 * @return
	 */
	public Long getIdEnteCompilatore() {
		return idEnteCompilatore;
	}

	/**
	 * @param idEnteCompilatore
	 */
	public void setIdEnteCompilatore(Long idEnteCompilatore) {
		this.idEnteCompilatore = idEnteCompilatore;
	}

	/**
	 * @return
	 */
	public Long getIdEnteGestore() {
		return idEnteGestore;
	}

	/**
	 * @param idEnteGestore
	 */
	public void setIdEnteGestore(Long idEnteGestore) {
		this.idEnteGestore = idEnteGestore;
	}

	/**
	 * @return
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * @param codiceFiscale
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * @return
	 */
	public String getComune() {
		return comune;
	}

	/**
	 * @param comune
	 */
	public void setComune(String comune) {
		this.comune = comune;
	}

	/**
	 * @return
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return
	 */
	public String getPartitaIva() {
		return partitaIva;
	}

	/**
	 * @param partitaIva
	 */
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	/**
	 * @return
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	

	/**
	 * @return
	 */
	public String getRagioneSociale() {
		return ragioneSociale;
	}

	/**
	 * @param ragioneSociale
	 */
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	/**
	 * @return
	 */
	public Date getDataAgg() {
		return dataAgg;
	}

	/**
	 * @param dataAgg
	 */
	public void setDataAgg(Date dataAgg) {
		this.dataAgg = dataAgg;
	}

	/**
	 * @return
	 */
	public String getRegione() {
		return regione;
	}

	/**
	 * @param regione
	 */
	public void setRegione(String regione) {
		this.regione = regione;
	}

	/**
	 * @return
	 */
	public String getStato() {
		return stato;
	}

	/**
	 * @param stato
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/**
	 * @return
	 */
	public Long getIdModuloSel() {
		return idModuloSel;
	}

	/**
	 * @param idModuloSel
	 */
	public void setIdModuloSel(Long idModuloSel) {
		this.idModuloSel = idModuloSel;
	}
	
	/**
	 * @return
	 */
	public List<RigaModuloModel> getListaRigheModulo() {
		return listaRigheModulo;
	}

	/**
	 * @param listaRigheModulo
	 */
	public void setListaRigheModulo(List<RigaModuloModel> listaRigheModulo) {
		this.listaRigheModulo = listaRigheModulo;
	}
	
	/**
	 * @return
	 */
	public String getAnno() {
		return anno;
	}

	/**
	 * @param anno
	 */
	public void setAnno(String anno) {
		this.anno = anno;
	}

	/**
	 * @return
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return
	 */
	public String getStruttura() {
		return struttura;
	}

	/**
	 * @param struttura
	 */
	public void setStruttura(String struttura) {
		this.struttura = struttura;
	}

	
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
	public String getListaIdDaValidare() {
		return listaIdDaValidare;
	}

	/**
	 * @param listaIdDaValidare
	 */
	public void setListaIdDaValidare(String listaIdDaValidare) {
		this.listaIdDaValidare = listaIdDaValidare;
	}

	/**
	 * @return
	 */
	public String getListaIdDaNonValidare() {
		return listaIdDaNonValidare;
	}

	/**
	 * @param listaIdDaNonValidare
	 */
	public void setListaIdDaNonValidare(String listaIdDaNonValidare) {
		this.listaIdDaNonValidare = listaIdDaNonValidare;
	}

	/**
	 * @return
	 */
	public String getProvvedimento() {
		return provvedimento;
	}

	/**
	 * @param provvedimento
	 */
	public void setProvvedimento(String provvedimento) {
		this.provvedimento = provvedimento;
	}

	/**
	 * @return
	 */
	public List<List<String>> getListaRigheVisibili() {
		return listaRigheVisibili;
	}

	/**
	 * @param listaRigheVisibili
	 */
	public void setListaRigheVisibili(List<List<String>> listaRigheVisibili) {
		this.listaRigheVisibili = listaRigheVisibili;
	}

	/**
	 * @return
	 */
	public String getStatoRiga() {
		return statoRiga;
	}

	/**
	 * @param statoRiga
	 */
	public void setStatoRiga(String statoRiga) {
		this.statoRiga = statoRiga;
	}

	/**
	 * @return
	 */
	public String getClassificazione() {
		return classificazione;
	}

	/**
	 * @param classificazione
	 */
	public void setClassificazione(String classificazione) {
		this.classificazione = classificazione;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
	
}
