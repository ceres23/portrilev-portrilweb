/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;
import it.csi.portril.portrilweb.util.Utility;

import java.util.List;

import javax.validation.constraints.Size;



public class MenuGestoreModel extends GenericModel{
	

	private static final long serialVersionUID = 46307428275833736L;

		private Long idUtenteGestore;
	
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
		
		private List<EntiGestoriModel> listaEntiGestori;
		
		private Long idEnteGestoreSel;
		
		private Long idEnteGestoreDaSel;
		
		//private boolean utenteMultiEnte;
		
		private boolean utenteMonoEnte;
		
		/**
		 * @return
		 */
		public Long getIdUtenteGestore() {
			return idUtenteGestore;
		}




		/**
		 * @param idUtenteGestore
		 */
		public void setIdUtenteGestore(Long idUtenteGestore) {
			this.idUtenteGestore = idUtenteGestore;
		}




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




		/**
		 * @return
		 */
		public List<EntiGestoriModel> getListaEntiGestori() {
			return listaEntiGestori;
		}




		/**
		 * @param listaEntiGestori
		 */
		public void setListaEntiGestori(List<EntiGestoriModel> listaEntiGestori) {
			this.listaEntiGestori = listaEntiGestori;
		}



/*
		public boolean isUtenteMultiEnte() {
			return utenteMultiEnte;
		}




		public void setUtenteMultiEnte(boolean utenteMultiEnte) {
			this.utenteMultiEnte = utenteMultiEnte;
		}
*/



		/**
		 * @return
		 */
		public boolean isUtenteMonoEnte() {
			return utenteMonoEnte;
		}




		/**
		 * @param utenteMonoEnte
		 */
		public void setUtenteMonoEnte(boolean utenteMonoEnte) {
			this.utenteMonoEnte = utenteMonoEnte;
		}




		/**
		 * @return
		 */
		public Long getIdEnteGestoreSel() {
			return idEnteGestoreSel;
		}




		/**
		 * @param idEnteGestoreSel
		 */
		public void setIdEnteGestoreSel(Long idEnteGestoreSel) {
			this.idEnteGestoreSel = idEnteGestoreSel;
		}




		/**
		 * @return
		 */
		public Long getIdEnteGestoreDaSel() {
			return idEnteGestoreDaSel;
		}




		/**
		 * @param idEnteGestoreDaSel
		 */
		public void setIdEnteGestoreDaSel(Long idEnteGestoreDaSel) {
			this.idEnteGestoreDaSel = idEnteGestoreDaSel;
		}


		/* (non-Javadoc)
		 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
		 */
		public String toString(Object obj) {
			return Utility.fieldsToString(this);
		}
		
}
