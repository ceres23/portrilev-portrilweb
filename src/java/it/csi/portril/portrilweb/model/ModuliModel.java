/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.model.validator.FileValid;
import it.csi.portril.portrilweb.model.validator.XorDate;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.util.UtilDate;
import it.csi.portril.portrilweb.util.Utility;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

//@FileValid( fieldName = "file" )
public class ModuliModel extends GenericModel{

	private static final long serialVersionUID = 1335058750540319096L;
	
	protected  LogUtil log = new LogUtil(getClass());
	
	private Long idModulo;	
	private Long  idModuloSel;	
	@NotNull
	@Size(min=1)
	private String nome;
	private String note;
	@NotNull
	@Size(min=1,max=250)
	private String descrizione;
	private Long idUtenteGestore;
	private Long idEnteGestore;
	private String istruzioniCompilazione;
	@NotNull
	private String tipo =Costanti.TIPO_MODULO_RILEVAZIONE.getCostante();
	@SuppressWarnings("unused")
	private Date dataFineCompilazione;
	@SuppressWarnings("unused")
	private Date dataInizioCompilazione;

//	private MultipartFile file;

//	private String contenttype;

//	private String filename;
	
	private Date dataUltimaModifica;
	private String obbligConferma = Costanti.NO.getCostante();
	private String caricamentoDaFile = Costanti.NO.getCostante();
	private String codiceGruppo;
	
	@XorDate(
	    	data1 = "dataInizio", 
	        data2 = "dataFine",
	        message="Le date vanno o compilate entrambi o non compilate, se compilate la data inizio deve essere minore della data fine")
	
	private DateRange rangeCompilazione = new DateRange();
	
	private List<ColonneModuloModel> listaColonneModulo = new ArrayList<ColonneModuloModel>();
	private List<RigaModuloModel> listaRigheModulo = new ArrayList<RigaModuloModel>();

	private String numeroColonne;
	/**
	 * @return
	 */
	public Long getIdModulo() {
		return idModulo;
	}
	
	/**
	 * @param idModulo
	 */
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	
	/**
	 * @return
	 */
	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}
	
	/**
	 * @return
	 */
	public String getDataUltimaModificaStr() {
		return UtilDate.formatDate(getDataUltimaModifica());
	}
	
	/**
	 * @param dataUltimaModifica
	 */
	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
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
	public String getIstruzioniCompilazione() {
		return istruzioniCompilazione;
	}
	
	/**
	 * @param istruzioniCompilazione
	 */
	public void setIstruzioniCompilazione(String istruzioniCompilazione) {
		this.istruzioniCompilazione = istruzioniCompilazione;
	}
	
	/**
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return
	 */
	public String getNote() {
		return note;
	}
	
	/**
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
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
	public List<ColonneModuloModel> getListaColonneModulo() {
		return listaColonneModulo;
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
	 * @param listaColonneModulo
	 */
	public void setListaColonneModulo(List<ColonneModuloModel> listaColonneModulo) {
		this.listaColonneModulo = listaColonneModulo;
	}
	
	/**
	 * @return
	 */
	public String getDataInizioCompilazioneStr() {
		return UtilDate.formatDate(getDataInizioCompilazione());
	}

	/**
	 * @return
	 */
	public String getDataFineCompilazioneStr() {
		return UtilDate.formatDate(getDataFineCompilazione());
	}
	
	
	/**
	 * @return
	 */
	public Long getIdModuloSel() {
		return idModuloSel;
	}

	/**
	 * @return the dataFineCompilazione
	 */
	/**
	 * @return
	 */
	public Date getDataFineCompilazione() {
		return  getRangeCompilazione().getDataFine();
	}

	/**
	 * @param dataFineCompilazione the dataFineCompilazione to set
	 */
	/**
	 * @param dataFineCompilazione
	 */
	public void setDataFineCompilazione(Date dataFineCompilazione) {
		getRangeCompilazione().setDataFine(dataFineCompilazione);
	}

	/**
	 * @return the dataInizioCompilazione
	 */
	/**
	 * @return
	 */
	public Date getDataInizioCompilazione() {
		return  getRangeCompilazione().getDataInizio();
	}

	/**
	 * @param dataInizioCompilazione the dataInizioCompilazione to set
	 */
	/**
	 * @param dataInizioCompilazione
	 */
	public void setDataInizioCompilazione(Date dataInizioCompilazione) {
		getRangeCompilazione().setDataInizio(dataInizioCompilazione);
		//this.dataInizioCompilazione = dataInizioCompilazione;
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
	public String getStato(){
		String stato="in definizione";
		
		Date now = new Date();
		
		Date dataInizio = getRangeCompilazione().getDataInizio();
		Date dataFine   = getRangeCompilazione().getDataFine();

		
		
		
		
		if(!(dataInizio==null || dataFine==null || now.before(dataInizio))){	
			// serve affiche' si possa considerare fino alla mezzanotte del giorno
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dataFine);
			calendar.add(Calendar.HOUR, 23);
			calendar.add(Calendar.MINUTE, 59);
			calendar.add(Calendar.SECOND, 59);
			Date dataFine2 = calendar.getTime();

			if(now.after(dataFine2)){
				stato="chiusi";
			}
			
			if(now.equals(dataInizio)  || (now.after(dataInizio) && now.before(dataFine2))){
				stato="in compilazione";
			}
		}
		return stato;
	}
	
	
	/**
	 * @return
	 */
	public boolean getDataCompilabile(){
		if(getStato().equals("in definizione")){
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return Utility.fieldsToString(this);
	}

	/**
	 * @return
	 */
	public String getTipo() {
		return tipo;
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
	public DateRange getRangeCompilazione() {
		return rangeCompilazione;
	}

	/**
	 * @param rangeCompilazione
	 */
	public void setRangeCompilazione(DateRange rangeCompilazione) {
		this.rangeCompilazione = rangeCompilazione;
	}
	
	public String getNumeroColonne() {
		return getListaColonneModulo() !=null?   String.valueOf(getListaColonneModulo().size()) : "0" ;
	}

	/**
	 * @param numeroColonne the numeroColonne to set
	 */
	public void setNumeroColonne(String numeroColonne) {
		this.numeroColonne = numeroColonne;
	}
	/**
	 * @return the obbligConferma
	 */
	public String getObbligConferma() {
		return obbligConferma;
	}

	/**
	 * @param obbligConferma the obbligConferma to set
	 */
	public void setObbligConferma(String obbligConferma) {
		this.obbligConferma = obbligConferma;
	}

	/**
	 * @return the caricamentoDaFile
	 */
	public String getCaricamentoDaFile() {
		return caricamentoDaFile;
	}

	/**
	 * @param caricamentoDaFile the caricamentoDaFile to set
	 */
	public void setCaricamentoDaFile(String caricamentoDaFile) {
		this.caricamentoDaFile = caricamentoDaFile;
	}

	/**
	 * @return the codiceGruppo
	 */
	public String getCodiceGruppo() {
		return codiceGruppo;
	}

	/**
	 * @param codiceGruppo the codiceGruppo to set
	 */
	public void setCodiceGruppo(String codiceGruppo) {
		this.codiceGruppo = codiceGruppo;
	}

	
	
/**
		public MultipartFile getFile() {
			return file;
		}

		public void setFile(MultipartFile file) {
			this.file = file;
		}

	public String getContenttype() {
		return contenttype;
	}

	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
*/

}
