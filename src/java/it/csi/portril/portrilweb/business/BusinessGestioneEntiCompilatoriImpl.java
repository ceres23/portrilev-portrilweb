/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneEntiCompilatori;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrREntiGestoriCompilatoriDAO;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTEntiCompilatoriDAO;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTModuliDAO;
import it.csi.portril.portrilweb.integration.entity.PrREntiCompilatoriGestori;
import it.csi.portril.portrilweb.integration.entity.PrTConfermeModuli;
import it.csi.portril.portrilweb.integration.entity.PrTEntiCompilatori;
import it.csi.portril.portrilweb.integration.entity.PrTEntiGestori;
import it.csi.portril.portrilweb.integration.entity.PrTModuli;
import it.csi.portril.portrilweb.integration.repository.EntiCompilatoriRepository;
import it.csi.portril.portrilweb.integration.repository.EntiGestoriRepository;
import it.csi.portril.portrilweb.integration.repository.RigheRepository;
import it.csi.portril.portrilweb.integration.repository.UtentiCompilatoriRepository;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.util.Costanti;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Implementor dei dafault del servizio di calcolo. 
 */
// L'annotation @Service indica a Spring di inserire 
// un'istanza della classe nel proprio ApplicationContext 
@Service
// L'annotation @Transactional a livello di classe indica a Spring 
// di eseguire tutti i metodi del servizio in un contesto transazionale
@Transactional
public class BusinessGestioneEntiCompilatoriImpl extends BusinessManagerBase implements BusinessGestioneEntiCompilatori{

	@Autowired
	private PrTEntiCompilatoriDAO entiCompilatoriDAO;

	@Autowired
	private PrTModuliDAO prTModuliDAO;
	
	@Autowired
	private PrREntiGestoriCompilatoriDAO prREntiGestoriCompilatoriDAO;
	
	@Autowired
	private RigheRepository righeRepository;
	
	@Autowired
	private EntiCompilatoriRepository entiCompilatoriRepository;

	@Autowired
	private EntiGestoriRepository entiGestoriRepository;

	@Autowired
	private UtentiCompilatoriRepository utentiCompilatoriRepository;
	
	@Override
	public EntiCompilatoriModel insEnteCompilatore(EntiCompilatoriModel entiCompilatoriModel,List<Long> listaIdEnteGestore){
		String methodName = "insEnteCompilatore";
		log.startMethod(methodName);	
		Long idEnteComp = entiCompilatoriModel.getIdEnteCompilatore();
		if (idEnteComp==null){
			PrTEntiCompilatori prTEntiCompilatori = mapper.map(entiCompilatoriModel, PrTEntiCompilatori.class);		
			//salvo l'ente in lettere maiuscole
			prTEntiCompilatori.setRagioneSociale(prTEntiCompilatori.getRagioneSociale().toUpperCase());
			prTEntiCompilatori.setDataAgg(new Date());
			PrTEntiCompilatori ecNew = entiCompilatoriDAO.create(prTEntiCompilatori);
			idEnteComp = ecNew.getIdEnteCompilatore();
		}		
		PrREntiCompilatoriGestori entity = new PrREntiCompilatoriGestori();		
		PrTEntiCompilatori prTEntiCompilator = entiCompilatoriRepository.findOne(idEnteComp);
		entity.setPrTEntiCompilatori(prTEntiCompilator );
		for(Long id :listaIdEnteGestore){
			PrTEntiGestori prTEntiGestori = entiGestoriRepository.findOne(id);
			entity.setPrTEnteGestore(prTEntiGestori);
			log.info(methodName, "prima di create");
			prREntiGestoriCompilatoriDAO.create(entity );
			log.info(methodName, "dopo create");		
		}
		log.stopMethod(methodName);
		return entiCompilatoriModel;
	}
	
	@Override
	public List<EntiCompilatoriModel> getEntiCompilatori(String stato , String ragioneSociale,String classificazione,String comune,String codiceFiscale,String partitaIva) {
		String methodName="getEntiCompilatori";
		log.startMethod(methodName);		
		List<PrTEntiCompilatori> listaDA = entiCompilatoriRepository.getEntiCompilatori( 
																StringUtils.trimToEmpty(stato).toUpperCase(),
																StringUtils.trimToEmpty(ragioneSociale).toUpperCase(),
																StringUtils.trimToEmpty(classificazione).toUpperCase(),
																StringUtils.trimToEmpty(comune).toUpperCase(),
																StringUtils.trimToEmpty(codiceFiscale).toUpperCase(),
																partitaIva
				);
		List<EntiCompilatoriModel> listaA = mapAll(listaDA, EntiCompilatoriModel.class);		
		log.stopMethod(methodName);	
		return listaA;
	}
	
	@Override
	public List<EntiCompilatoriModel> getEntiCompilatoriByIdEnteGestore(String stato , String ragioneSociale,String classificazione,String comune,String codiceFiscale,String partitaIva,Long idEnteGestore) {
		String methodName="getEntiCompilatori";
		log.startMethod(methodName);		
		List<PrTEntiCompilatori> listaDA =entiCompilatoriDAO.getEntiCompilatoriByIdEnteGestore( 
																								StringUtils.trimToEmpty(stato).toUpperCase(),
																								StringUtils.trimToEmpty(ragioneSociale).toUpperCase(),
																								StringUtils.trimToEmpty(classificazione).toUpperCase(),
																								StringUtils.trimToEmpty(comune).toUpperCase(),
																								StringUtils.trimToEmpty(codiceFiscale).toUpperCase(),
																								StringUtils.trimToEmpty(partitaIva),
																								idEnteGestore
		);
		List<EntiCompilatoriModel> listaA = mapAll(listaDA, EntiCompilatoriModel.class);		
		log.stopMethod(methodName);	
		return listaA;
	}
	
	@Override
	public List<EntiCompilatoriModel> ricercaEntiCompilatoriRelazionatiAiModuli(Long idEnteGestore,
															String ragioneSociale,
															String classificazione,
															String comune,
															String provincia,
															String codiceFiscale,
															String partitaIva,
															Long   idModulo,
															String stato,
															String associazione
															) {

		String methodName="ricercaEntiCompilatori";
		log.startMethod(methodName);
		List<PrTEntiCompilatori> lista = entiCompilatoriDAO.getCompilatori(
																			idEnteGestore,
																			ragioneSociale,
																			classificazione,
																			comune,
																			provincia,
																			codiceFiscale,
																			partitaIva,
																			stato,
																			associazione,
																			idModulo
																			);		
		
		List<EntiCompilatoriModel> listaEntiCompilatori = new ArrayList<EntiCompilatoriModel>();
		for(PrTEntiCompilatori prTEntiCompilatori:lista){						
			EntiCompilatoriModel enteComp = mapper.map(prTEntiCompilatori, EntiCompilatoriModel.class);
			if(StringUtils.isEmpty(associazione)){
				String isCh= "";
				for(PrTModuli mod:prTEntiCompilatori.getPrTModulis()){
					if(mod.getIdModulo().equals(idModulo)){
						isCh="checked";
					}
				}
				enteComp.setChecked(isCh);
			}else{						
				if(associazione.equals(Costanti.ASSOCIATO.getCostante())){
					enteComp.setChecked("checked");
				}
			}
			listaEntiCompilatori.add(enteComp);
		}
		
		log.stopMethod(methodName);
		return listaEntiCompilatori;
	}

	@Override
	public List<EntiCompilatoriModel> ricercaEntiCompilatori(Long idEnteGestore,
															String ragioneSociale,
															String classificazione,
															String comune,
															String provincia,
															String codiceFiscale,
															String partitaIva,
															String stato,
															String associazioneAlModulo) {

		String methodName="ricercaEntiCompilatori";
		log.startMethod(methodName);
		List<PrTEntiCompilatori> lista = entiCompilatoriDAO.getCompilatori(
																			idEnteGestore,
																			ragioneSociale,
																			classificazione,	
																			comune,
																			provincia,
																			codiceFiscale,
																			partitaIva,
																			stato,
																			associazioneAlModulo,
																			null
																			);		
		
		List<EntiCompilatoriModel> listaEntiCompilatori = mapAll(lista, EntiCompilatoriModel.class);			
		log.stopMethod(methodName);
		return listaEntiCompilatori;
	}
		
	@Override
	public void eliminaEnteCompilatore(Long idEnteCompilatoreSel) {
		String methodName="eliminaEnteCompilatore";
		log.startMethod(methodName);
		log.debug(methodName,"idEnteCompilatoreSel "+ idEnteCompilatoreSel);	
		prREntiGestoriCompilatoriDAO.deleteFromIdEnteCompilatore(idEnteCompilatoreSel);		
		PrTEntiCompilatori entity = entiCompilatoriRepository.findOne(idEnteCompilatoreSel);
		entiCompilatoriDAO.delete(entity);		
		log.stopMethod(methodName);		
	}
		
	@Override	
	public String disattivaAttivaEnteCompilatore(Long idEnteSel) {
		String methodName="disattivaAttivaEnteCompilatore";
		log.startMethod(methodName);		
		String ris    = Costanti.UTE_DISATTIVO.getCostante();
		String valore = Costanti.DISATTIVO.getCostante();		
		log.debug(methodName,"idEnteSel "+ idEnteSel);
		PrTEntiCompilatori entity = entiCompilatoriRepository.findOne(idEnteSel);
		log.debug(methodName, "stato sul DB" +entity.getStato());		
		if(entity.getStato().equals(Costanti.DISATTIVO.getCostante())){
			ris = Costanti.UTE_ATTIVO.getCostante();
			valore=Costanti.ATTIVO.getCostante();			
		}		
		disattivaAttivaEnteCompilatore(idEnteSel, valore,entity);		
		log.stopMethod(methodName);
		return ris;
	}
		
	private void disattivaAttivaEnteCompilatore(Long idEnteSel,String valore,PrTEntiCompilatori entityPassato) {
		PrTEntiCompilatori entity =entityPassato;
		if(entity==null){
			entity = entiCompilatoriRepository.findOne(idEnteSel);
		}
		log.debug("disattivaAttivaEnteCompilatore ","idEnteSel " + idEnteSel);
		log.debug("disattivaAttivaEnteCompilatore ","stato " + valore);
		entity.setIdEnteCompilatore(idEnteSel);
		entity.setStato(valore);
		entiCompilatoriDAO.update(entity);		
	}
		
	@Override
	public EntiCompilatoriModel modificaEnteCompilatore(EntiCompilatoriModel entiCompilatoriModel) {
		String methodName = "modificaEnteCompilatore";
		log.startMethod(methodName);	
		PrTEntiCompilatori prTEntiCompilatori = mapper.map(entiCompilatoriModel, PrTEntiCompilatori.class);		
		entiCompilatoriDAO.update(prTEntiCompilatori);		
		log.stopMethod(methodName);
		return entiCompilatoriModel;
	}
	
	@Override
	public EntiCompilatoriModel getEntiCompilatoriById(Long idEnteSel) {
		String methodName = "getEntiCompilatoriById";
		log.startMethod(methodName);	
		//log.info(methodName, "idEnteSel "+ idEnteSel);	
		PrTEntiCompilatori entity = entiCompilatoriRepository.findOne(idEnteSel);
		EntiCompilatoriModel ris = mapper.map(entity,EntiCompilatoriModel.class);	
		log.stopMethod(methodName);
		return ris;
	}

	@Override
	public EntiCompilatoriModel getEnteCompilatoreFittizioByIdEnteGestore(Long idEnteGestore) {
		String methodName = "getEnteCompilatoreFittizioByIdEnteGestore";
		log.startMethod(methodName);
		log.info(methodName, "idEnteGestore "+ idEnteGestore);	
		PrTEntiCompilatori entity = entiCompilatoriRepository.getEnteCompilatoreFittizioByIdEnteGestore();//idEnteGestore);
		log.info(methodName, "entity "+ entity.getIdEnteCompilatore());			
		EntiCompilatoriModel ris = mapper.map(entity,EntiCompilatoriModel.class);
		log.stopMethod(methodName);
		return ris;
	}
	
	@Override
	public List<EntiCompilatoriModel> getListaEntiCompilatoribyIdModulo(Long idModuloSel){
		String methodName = "getListaEntiCompilatoribyIdModulo";
		log.startMethod(methodName);		
		log.debug(methodName , " idModuloSel   " +idModuloSel );
		List<PrTEntiCompilatori> listaDa = entiCompilatoriRepository.getListabyIdModulo(idModuloSel);
		List<EntiCompilatoriModel> ris = mapAll(listaDa,EntiCompilatoriModel.class);
		log.stopMethod(methodName);
		return ris;		 
	}
		
	@Override
	public List<EntiCompilatoriModel> getListaEntiCompilatoriByIdModuloSel(Long idModuloSel,String stato) {
		String methodName="getEntiCompilatoriByIdModuloSel";
		log.startMethod(methodName);
		log.debug(methodName, "idModuloSel " + idModuloSel);
		List<PrTEntiCompilatori> listaPrTEntiCompilatori = entiCompilatoriDAO.getEntiCompilatoriByIdModuloSelAndStato(idModuloSel,stato);		
		List<EntiCompilatoriModel> ris = mapAll(listaPrTEntiCompilatori,EntiCompilatoriModel.class);	
		log.stopMethod(methodName);
		return ris;
	}
	
	@Override
	public List<EntiCompilatoriModel> getListaEntiCompilatoriConModuloConfermato(Long idModuloSel,String statoConferma) {
		String methodName = "getListaEntiCompilatoriConModuloConfermato";
		log.startMethod(methodName);		
		log.debug(methodName , " idModuloSel   " +idModuloSel );
		//List<PrTEntiCompilatori> listaentiConfermatiSiNo = entiCompilatoriDAO.getListaEntiCompilatoriConModuloConfermato(idModuloSel,confermatoSiNo);
		List<PrTConfermeModuli> listaConferme = entiCompilatoriDAO.getListaConfermeEntiCompilatoriConModuloConfermato(idModuloSel, statoConferma);
		List<EntiCompilatoriModel> listaRis = new ArrayList<EntiCompilatoriModel>();				
		for(PrTConfermeModuli tcm : listaConferme){		
			EntiCompilatoriModel ecm = map(tcm.getPrTEntiCompilatori(),EntiCompilatoriModel.class);
			
			ecm.setModuloEnteValidato(tcm.getModuloValidato());
			ecm.setModuloEnteConfermato(tcm.getModuloConfermato());
			listaRis.add(ecm);
		}		
		log.stopMethod(methodName);
		return listaRis;		 	
	}

	@Override
	public boolean xstAssociazioneEnteGestoreCompilatore(Long idEnteCompilatore,Long idEnteGestore) {
		String methodName = "xstAssociazioneEnteGestoreCompilatore";
		log.startMethod(methodName);
		List<PrREntiCompilatoriGestori> ecg = prREntiGestoriCompilatoriDAO.xstAssociazioneEnteGestoreCompilatore(idEnteCompilatore,idEnteGestore);
		if(ecg!=null && ecg.size()>0){
			return true;
		}		 
		return false;		 	
	}
	
	@Override
	public List<EntiCompilatoriModel> getListaEntiCompilatoriConModuloValidato(Long idModuloSel,String validatoSiNo) {
		String methodName = "getListaEntiCompilatoriConModuloValidato";
		log.startMethod(methodName);		
		log.debug(methodName , " idModuloSel   " +idModuloSel );
		List<PrTEntiCompilatori> listaentiValidatiSiNo = entiCompilatoriRepository.getListaEntiCompilatoriConModuloValidato(idModuloSel,validatoSiNo);
		List<EntiCompilatoriModel> ris = mapAll(listaentiValidatiSiNo,EntiCompilatoriModel.class);
		log.stopMethod(methodName);
		return ris;		 	
	}
	
	/**
 	private EntiCompilatoriModel estraiInformazioniUltimaCompilazione(Long idModuloSel,
																		String stato,  
																		EntiCompilatoriModel entiCompilatoriModel) {
		
		String methodName="estraiInformazioniUltimaCompilazione";
		log.startMethod(methodName);
		
		//determino il fatto che l'ente abbia almeno redatto qualche riga 
		//del modulo inviato o meno
		List<PrTRighe> righe =  righeRepository.getRigheByIdEnteIdModulo(entiCompilatoriModel.getIdEnteCompilatore(), idModuloSel);
		Date dataultimaModifica = null;
		Long idUtenteCompilatoreUltimo=null;
		
		if(CollectionUtils.isNotEmpty(righe)){
			// se ha almeno 1 riga il modulo per quell'ente e da considerarsi compilato
			entiCompilatoriModel.setModuloCompilato(true);
			
			// detemimo l'ultimo utente che ha agito sulle righe di quel modulo 
			// per quell'ente
			Date ultimaModificaPrec = UtilDate.getDate(1970, 1, 1);
			Date ultimaModifica;
			
			Long idUtenteCompilatore;
			
			// determino l'ultimo utente che ha compilato qualcosa
			// scorrendomi le righe del modulo
			//log.info(methodName, "ultimaModificaPrec " + ultimaModificaPrec);
			
			for(PrTRighe riga : righe){
			
				 ultimaModifica = riga.getDataModificaCompilatore();
				 idUtenteCompilatore = riga.getIdUtenteCompilatore();
				 
				 if(ultimaModifica.compareTo(ultimaModificaPrec)>0){		 
					 dataultimaModifica = ultimaModifica;
					 idUtenteCompilatoreUltimo = idUtenteCompilatore;
				 }
				 ultimaModificaPrec =ultimaModifica;					 
			}
			// estraggo l'ultimo utente che ha redatto righe
			PrTUtentiCompilatori prTUtentiCompilatori = utentiCompilatoriRepository.findOne(idUtenteCompilatoreUltimo);				
			UtentiCompilatoriModel ultimoUtenteCompilatore = mapper.map(prTUtentiCompilatori, UtentiCompilatoriModel.class);		
			entiCompilatoriModel.setUltimoUtenteCompilatore(ultimoUtenteCompilatore);
			ultimoUtenteCompilatore.setDataUltimoAggRigheModulo(dataultimaModifica);
		}else{
			// se non ho righe associate a quel modulo per quell'ente 
			// assumo che il modulo  ancora da compilare
			entiCompilatoriModel.setUltimoUtenteCompilatore(new UtentiCompilatoriModel());
			entiCompilatoriModel.setModuloCompilato(false);
		}	

		//controllo lo stato
		log.debug(methodName, "stato " + stato);
		log.debug(methodName, "entiCompilatoriModel.isModuloCompilato() " + entiCompilatoriModel.isModuloCompilato());
		
		log.stopMethod(methodName);
		return entiCompilatoriModel;
	}
*/
}
