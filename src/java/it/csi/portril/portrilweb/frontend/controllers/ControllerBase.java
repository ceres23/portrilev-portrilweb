/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers;

import it.csi.portril.portrilweb.business.interfaces.BusinessUtilTracciatura;
import it.csi.portril.portrilweb.dto.FeedbackError;
import it.csi.portril.portrilweb.dto.FeedbackSuccess;
import it.csi.portril.portrilweb.dto.FeedbackWarning;
import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
import it.csi.portril.portrilweb.model.UtentiGestoriModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.util.TipiFile;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;

public class ControllerBase {
	
	private  LogUtil log = new LogUtil(getClass());
	@Autowired
	protected Mapper mapper;
	
	@Autowired
	protected BusinessUtilTracciatura buUtilTracciatura;
		
	List<String>       errori  = new ArrayList<String>();
	List<String>       success = new ArrayList<String>();
	List<String>       warning = new ArrayList<String>();

	
	public List<String> getErrori() {
		return errori;
	}
	
	
	public List<String> getSuccess() {
		return success;
	}

	
	public List<String> getWarning() {
		return warning;
	}


	
	/**
	 * 
	 * @param model
	 * @param result
	 * @param destinazioneOk
	 * @return
	 */
	public FeedbackError gestisciSuccessWarningErrors(Model model, BindingResult result,String destinazioneOk){
		return gestisciSuccessWarningErrors(model,result,null,null,null, destinazioneOk, destinazioneOk);
	}

	
	/**
	 * 
	 * @param model
	 * @param result
	 * @param destinazioneOk
	 * @param destinazioneKo
	 * @return
	 */
	public FeedbackError gestisciSuccessWarningErrors(Model model,BindingResult result,String destinazioneOk,String destinazioneKo){
		return gestisciSuccessWarningErrors( model, result,null,null,null, destinazioneOk, destinazioneKo);
	}
	
	
	/**
	 * 
	 * @param model
	 * @param result
	 * @param msgErrors
	 * @param msgWarning
	 * @param msgSuccess
	 * @param destinazioneOk
	 * @param destinazioneKO
	 * @return
	 */
	private FeedbackError gestisciSuccessWarningErrors(Model model,BindingResult result,String msgErrors,String msgWarning,String msgSuccess,String destinazioneOk,String destinazioneKO){
		String methodName="gestisciSuccessWarningErrors";
		log.startMethod(methodName);
		FeedbackWarning feedbackWarningModel = new FeedbackWarning();		
		FeedbackSuccess feedbackSuccessModel = new FeedbackSuccess();		
		FeedbackError   feedbackErrorModel   = new FeedbackError();		

		feedbackErrorModel.setDestinazione(destinazioneOk);
		feedbackSuccessModel.setDestinazione(destinazioneOk);
		feedbackWarningModel.setDestinazione(destinazioneOk);
		
		if(result.hasErrors()) {			
			log.error(methodName,"errore di validazione Campi");			
			feedbackErrorModel.setErrorePresente(true);
			feedbackErrorModel.setDestinazione(destinazioneKO);			
			if(StringUtils.isNotBlank(msgErrors)){
				feedbackErrorModel.addMsgErrore(msgErrors);
			}
			feedbackErrorModel.addMsgErrori(result.getAllErrors());						
		}else{
			
			if(!StringUtils.isBlank(msgWarning)){
				feedbackWarningModel.addOneMsgWarning(msgWarning);
				feedbackWarningModel.setWarning(true);
			}
			
			if(!StringUtils.isBlank(msgSuccess)){
				feedbackSuccessModel.addOneMsgSuccess(msgSuccess);
				feedbackSuccessModel.setSuccess(true);
			}else{
				feedbackSuccessModel.addOneMsgSuccess(Costanti.MSG_OK.getCostante());
				feedbackSuccessModel.setSuccess(true);
			}
			
		}	
		model.addAttribute(Costanti.FEEDBACKERROR.getCostante(),feedbackErrorModel);
		model.addAttribute(Costanti.FEEDBACKWARNING.getCostante(),feedbackWarningModel);
		model.addAttribute(Costanti.FEEDBACKSUCCESS.getCostante(),feedbackSuccessModel);
		log.stopMethod(methodName);
		return feedbackErrorModel;
	}


	/**
	 * 
	 * @param model
	 * @param msgSuccess
	 * @return
	 */
	public FeedbackSuccess addOneMsgSuccess(Model model,String msgSuccess){
		FeedbackSuccess feedbackModel = new FeedbackSuccess();		
		feedbackModel.setMsgSuccess(success);
		feedbackModel.setSuccess(true);
		if(StringUtils.isBlank(msgSuccess)){
			msgSuccess = Costanti.MSG_OK.getCostante();
		}

		feedbackModel.addOneMsgSuccess(msgSuccess);
		model.addAttribute(Costanti.FEEDBACKSUCCESS.getCostante(),feedbackModel);
		return feedbackModel;
	}

	
	/**
	 * 
	 * @param model
	 * @param msgSuccess
	 * @return
	 */
	public FeedbackSuccess addMsgSuccessDefault(Model model){
		return addOneMsgSuccess( model,"");
	}
	
	
//	/**
//	 * 
//	 * @param model
//	 * @param msgWarning
//	 * @return
//	 */
//	public FeedbackWarning addMsgOneWarning(Model model,String msgWarning){
//		FeedbackWarning feedbackModel = new FeedbackWarning();		
//		feedbackModel.setMsgWarning(warning);
//		feedbackModel.setWarning(true);
//		feedbackModel.addMsgWarning(msgWarning);
//		model.addAttribute(Costanti.FEEDBACKWARNING.getCostante(),feedbackModel);
//		return feedbackModel;
//	}


	/**
	 * forza il messaggio di warning aggiungendo un array di messaggi
	 * @param model
	 * @param msgWarning
	 * @return
	 */
	public FeedbackWarning addOneMsgWarning(Model model,String msgWarning){
		FeedbackWarning feedbackModel = new FeedbackWarning();		
		feedbackModel.setMsgWarning(warning);
		feedbackModel.setWarning(true);
		feedbackModel.addOneMsgWarning(msgWarning);
		model.addAttribute(Costanti.FEEDBACKWARNING.getCostante(),feedbackModel);		
		return feedbackModel;
	}
	
	
	/**
	 * forza il messaggio di Warning aggiungendo un array di messaggi
	 * @param model
	 * @param msgWarning
	 * @return
	 */
	public FeedbackWarning addMsgWarning(Model model,List<String> msgWarning){
		return addMsgWarning(model,msgWarning,true);
	}
	
	
	/**
	 * forza il messaggio di Warning aggiungendo un array di messaggi
	 * @param model
	 * @param msgWarning
	 * @return
	 */
	public FeedbackWarning addMsgWarning(Model model,List<String> msgWarning,boolean isPresent){
		FeedbackWarning feedbackModel = new FeedbackWarning();	
		feedbackModel.setWarning(isPresent);
		feedbackModel.setMsgWarning(msgWarning);		
		model.addAttribute(Costanti.FEEDBACKWARNING.getCostante(),feedbackModel);
		return feedbackModel;
	}

	
	/**
	 * forza il messaggio di error aggiungendo un array di messaggi
	 * @param model
	 * @param msgError
	 * @param visuaizzaErroriSpecifici
	 * @return
	 */
	public FeedbackError addMsgError(Model model,List<String> msgError,boolean visuaizzaErroriSpecifici){
		FeedbackError feedbackModel = new FeedbackError();	
		feedbackModel.setErrorePresente(true);
		feedbackModel.setListaMsgErrori(msgError);
		feedbackModel.setVisuaizzaErroriSpecifici(visuaizzaErroriSpecifici);		
		model.addAttribute(Costanti.FEEDBACKERROR.getCostante(),feedbackModel);
		return feedbackModel;
	}
	
	
	/**
	 * forza il messaggio di error aggiungendo un errore singolo
	 * @param model
	 * @param msgError
	 * @param visuaizzaErroriSpecifici
	 * @return
	 */
	public FeedbackError addOneMsgError(Model model,String msgError,boolean visuaizzaErroriSpecifici){
		List<String> listamsgError = new ArrayList<String>();
		listamsgError.add(msgError);
		return addMsgError( model,listamsgError, visuaizzaErroriSpecifici);
	}
	
	
	/**
	 * forza il messaggio di error aggiungendo un array di messaggi
	 * @param model
	 * @param msgError
	 * @return
	 */
	public FeedbackError addOneMsgError(Model model,String msgError){
		List<String> listmsgError = new ArrayList<String> ();
		listmsgError.add(msgError);
		return addMsgError( model, listmsgError,true);
	}
	
	
	/**
	 * 
	 * @param idEnteGestoreSel
	 * @param session
	 */
	public void setIdEnteGestore(Long idEnteGestoreSel,HttpSession session) {
		session.setAttribute(Costanti.ID_ENTE_GESTORE_SEL.getCostante(),idEnteGestoreSel);
	}
	
	/**
	 * 
	 * @param idEnteGestoreSel
	 * @param session
	 */
	public void setDescEnteGestore(String descEnteGestoreSel,HttpSession session) {
		session.setAttribute(Costanti.DESC_ENTE_GESTORE_SEL.getCostante(),descEnteGestoreSel);
	}

	/**
	 * 
	 * @param idEnteCompilatoreSel
	 * @param session
	 */
	public void setIdEnteCompilatoreSelezionato(Long idEnteCompilatoreSel,HttpSession session) {
		String methodName="setIdEnteCompilatoreSelezionato";
		session.setAttribute(Costanti.ID_ENTE_COMPILATORE_SEL.getCostante(),idEnteCompilatoreSel);
	}
	
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	public Integer getNumeroRigheTotaliDelModulo(HttpSession session) {
		return (Integer)session.getAttribute(Costanti.NUM_TOTAL_RECORDS.getCostante());
	}
	
	
	/**
	 * 
	 * @param idEnteCompilatoreSel
	 * @param session
	 */
	public void setNumeroRigheTotaliDelModulo(Integer numTotalRecords,HttpSession session) {
		session.setAttribute(Costanti.NUM_TOTAL_RECORDS.getCostante(),numTotalRecords);
	}
	
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	public Long getIdEnteCompilatoreSelezionato(HttpSession session) {
		return (Long)session.getAttribute(Costanti.ID_ENTE_COMPILATORE_SEL.getCostante());
	}


	
	/**
	 * 
	 * @param session
	 * @return
	 */
	public Long getIdEnteGestore(HttpSession session) {
		return (Long)session.getAttribute(Costanti.ID_ENTE_GESTORE_SEL.getCostante());
	}

	
	/**
	 * 
	 * @param session
	 * @return
	 */
	public UtentiCompilatoriModel getUtenteCompilatoreConnesso(HttpSession session) {
		return (UtentiCompilatoriModel) session.getAttribute(Costanti.UTENTE_COMP_LOGGATO.getCostante());
	}
	
	
	/**
	 * 
	 * @param utente
	 * @param session
	 */
	public void  setUtenteCompilatoreConnesso(UtentiCompilatoriModel utente,HttpSession session) {
		session.setAttribute(Costanti.UTENTE_COMP_LOGGATO.getCostante(),utente);
	}
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	public Boolean isNotSecurePassword(HttpSession session) {
		return (Boolean) session.getAttribute(Costanti.PW_NOT_SECURE.getCostante());
	}
	
	
	/**
	 * 
	 * @param utente
	 * @param session
	 */
	public void  setNotSecurePassword(Boolean pw,HttpSession session) {
		session.setAttribute(Costanti.PW_NOT_SECURE.getCostante(),pw);
	}
	
	/**
	 * 
	 * @param utente
	 * @param session
	 */
	public void  removeUtenteCompilatoreConnesso(HttpSession session) {
		session.removeAttribute(Costanti.UTENTE_COMP_LOGGATO.getCostante());
	}
	
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	public UtentiGestoriModel getUtenteGestoreConnesso(HttpSession session) {
		return (UtentiGestoriModel)session.getAttribute(Costanti.UTENTE_GESTORE_CONNESSO.getCostante());
	}
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	public UtentiGestoriModel getEnteGestoreSelezionato(HttpSession session) {
		return (UtentiGestoriModel)session.getAttribute(Costanti.DESC_ENTE_GESTORE_SEL.getCostante());
	}
	
	/**
	 * 
	 * @param listaDa
	 * @param listaA
	 * @return
	 */
	protected <DA, A> List<A> mapAll(List<DA> listaDa, List<A> listaA) {
		List<A> listA  = new ArrayList<A>();

		for(DA da : listaDa) {
			A a = (A)new Object();
			mapper.map(da, a);
			listA.add(a);
		}
		return listA;
	}

	
	/**
	 * metodo che si occupa della conversione delle date in spring mvc 
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	/**
	 * 
	 * @param re
	 * @param model
	 * @param msgWarning
	 */
	public void gestisciEccezioneEliminaRecordConFigli(RuntimeException re,Model model,String msgWarning) {
		String methodName="gestisciEccezioneEliminaRecordConFigli";
		Throwable e = re;
		while(e != null) {
			e = e.getCause();
			if(e instanceof SQLException) {
				SQLException sql = (SQLException)e;				
				log.error(methodName, "SQLState: " + ((SQLException)sql).getSQLState());
				if(((SQLException)sql).getSQLState().equals("23503")){					
					addOneMsgWarning(model, msgWarning);
				}else{
					log.error(methodName, "SQLState: 23503 " + re);
					throw new RuntimeException(re);
				}					
				break;
			}
		}		
	}

	protected boolean validaFile(Model model,MultipartFile file) {
		String methodName = "validaFile";
		boolean ris = true;
		if(file==null || file.getOriginalFilename().isEmpty()){
			ris = true;
		}else{
	    	if(file.getSize()>3000000){
	    		log.warn(methodName ,"il file: "+ file.getOriginalFilename() + " e' troppo grosso ");
	        	addOneMsgError(model,CostantiERR.ERR_FILE_MAX.getCostante());    	
	        	ris = false;
	    	}
	    	
	    	if(!TipiFile.fromCodice(file.getContentType())){
	    		log.warn(methodName ,"il file: "+ file.getOriginalFilename() + " non e' un tipo censito ");    	
	        	addOneMsgError(model,CostantiERR.ERR_FILE_NONGESTITO.getCostante());    		    		
	        	ris = false;
	    	}    	
		}    	
		return ris;
	}

}
