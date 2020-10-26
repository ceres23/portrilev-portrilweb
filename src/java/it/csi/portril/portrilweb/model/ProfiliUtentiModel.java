/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Utility;

import javax.validation.constraints.Size;

public class ProfiliUtentiModel extends GenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5320880492134440793L;

	private Long idProfiloUtente;

	@Size(max=255)
	private String descrizione;

	private String flgGestCompilazioneModuli;

	private String flgGestDefinizioneModuli;

	private String flgGestEntiCompilatori;

	private String flgGestProfiloCompilatore;

	private String flgGestRisultati;

	private String flgGestUtentiCompilatori;

	private String flgGestUtentiGestori;

	
	
	
	
	/**
	 * @return
	 */
	public Long getIdProfiloUtente() {
		return idProfiloUtente;
	}





	/**
	 * @param idProfiloUtente
	 */
	public void setIdProfiloUtente(Long idProfiloUtente) {
		this.idProfiloUtente = idProfiloUtente;
	}





	/**
	 * @return
	 */
	public String getDescrizione() {
		return descrizione;
	}





	/**
	 * @param descrizione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}





	/**
	 * @return
	 */
	public String getFlgGestCompilazioneModuli() {
		return flgGestCompilazioneModuli;
	}





	/**
	 * @param flgGestCompilazioneModuli
	 */
	public void setFlgGestCompilazioneModuli(String flgGestCompilazioneModuli) {
		this.flgGestCompilazioneModuli = flgGestCompilazioneModuli;
	}





	/**
	 * @return
	 */
	public String getFlgGestDefinizioneModuli() {
		return flgGestDefinizioneModuli;
	}





	/**
	 * @param flgGestDefinizioneModuli
	 */
	public void setFlgGestDefinizioneModuli(String flgGestDefinizioneModuli) {
		this.flgGestDefinizioneModuli = flgGestDefinizioneModuli;
	}





	/**
	 * @return
	 */
	public String getFlgGestEntiCompilatori() {
		return flgGestEntiCompilatori;
	}





	/**
	 * @param flgGestEntiCompilatori
	 */
	public void setFlgGestEntiCompilatori(String flgGestEntiCompilatori) {
		this.flgGestEntiCompilatori = flgGestEntiCompilatori;
	}





	/**
	 * @return
	 */
	public String getFlgGestProfiloCompilatore() {
		return flgGestProfiloCompilatore;
	}





	/**
	 * @param flgGestProfiloCompilatore
	 */
	public void setFlgGestProfiloCompilatore(String flgGestProfiloCompilatore) {
		this.flgGestProfiloCompilatore = flgGestProfiloCompilatore;
	}





	/**
	 * @return
	 */
	public String getFlgGestRisultati() {
		return flgGestRisultati;
	}





	/**
	 * @param flgGestRisultati
	 */
	public void setFlgGestRisultati(String flgGestRisultati) {
		this.flgGestRisultati = flgGestRisultati;
	}





	/**
	 * @return
	 */
	public String getFlgGestUtentiCompilatori() {
		return flgGestUtentiCompilatori;
	}





	/**
	 * @param flgGestUtentiCompilatori
	 */
	public void setFlgGestUtentiCompilatori(String flgGestUtentiCompilatori) {
		this.flgGestUtentiCompilatori = flgGestUtentiCompilatori;
	}





	/**
	 * @return
	 */
	public String getFlgGestUtentiGestori() {
		return flgGestUtentiGestori;
	}





	/**
	 * @param flgGestUtentiGestori
	 */
	public void setFlgGestUtentiGestori(String flgGestUtentiGestori) {
		this.flgGestUtentiGestori = flgGestUtentiGestori;
	}





	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}
}
