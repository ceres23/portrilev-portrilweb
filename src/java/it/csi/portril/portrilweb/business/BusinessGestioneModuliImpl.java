/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTCellaDAO;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTConfermeModuliDAO;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTEntiCompilatoriDAO;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTModuliDAO;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTModuloMailInvitiDAO;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTRigheDAO;
import it.csi.portril.portrilweb.integration.entity.PrTCella;
import it.csi.portril.portrilweb.integration.entity.PrTCellaPK;
import it.csi.portril.portrilweb.integration.entity.PrTColonneModulo;
import it.csi.portril.portrilweb.integration.entity.PrTConfermeModuli;
import it.csi.portril.portrilweb.integration.entity.PrTEntiCompilatori;
import it.csi.portril.portrilweb.integration.entity.PrTEntiGestori;
import it.csi.portril.portrilweb.integration.entity.PrTModuli;
import it.csi.portril.portrilweb.integration.entity.PrTModuloMailInviti;
import it.csi.portril.portrilweb.integration.entity.PrTRighe;
import it.csi.portril.portrilweb.integration.entity.PrTUtentiCompilatori;
import it.csi.portril.portrilweb.integration.entity.PrVModuliUtentiCoompilatori;
import it.csi.portril.portrilweb.integration.repository.CellaRepository;
import it.csi.portril.portrilweb.integration.repository.ColonneModuloRepository;
import it.csi.portril.portrilweb.integration.repository.ConfermeModuliRepository;
import it.csi.portril.portrilweb.integration.repository.EntiCompilatoriRepository;
import it.csi.portril.portrilweb.integration.repository.EntiGestoriRepository;
import it.csi.portril.portrilweb.integration.repository.ModuliMailInvitiRepository;
import it.csi.portril.portrilweb.integration.repository.ModuliRepository;
import it.csi.portril.portrilweb.integration.repository.RigheRepository;
import it.csi.portril.portrilweb.model.CellaModuloModel;
import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.model.ValidaRigheModuliModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.Utility;
import it.csi.portril.portrilweb.util.mail.MailSender;
import it.csi.portril.portrilweb.util.paginazione.ListaPaginata;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
/**
 * Implementor dei dafault del servizio di calcolo. 
 */
// L'annotation @Service indica a Spring di inserire 
// un'istanza della classe nel proprio ApplicationContext 
@Service
// L'annotation @Transactional a livello di classe indica a Spring 
// di eseguire tutti i metodi del servizio in un contesto transazionale
@Transactional
public class BusinessGestioneModuliImpl extends BusinessManagerBase implements BusinessGestioneModuli{
	@Autowired
	private PrTModuliDAO moduliDAO;

	@Autowired
	private PrTConfermeModuliDAO confermeModuliDAO;

	@Autowired
	private PrTRigheDAO righeDAO;
	
	@Autowired
	private PrTCellaDAO prTCellaDAO;

	@Autowired
	private ModuliRepository moduliRepository;

	@Autowired
	private EntiCompilatoriRepository entiCompilatoriRepository;

	@Autowired
	private ColonneModuloRepository colonneModuloRepository;
	
	@Autowired
	private RigheRepository righeRepository;
	
	@Autowired
	private CellaRepository cellaRepository;
	
	@Autowired
	private EntiGestoriRepository enteGestoreRepository;

	@Autowired
	private ModuliMailInvitiRepository moduliMailInvitiRepository;

	@Autowired
	private EntiCompilatoriRepository enteCompilatoreRepository;
	
	@Autowired
	private PrTEntiCompilatoriDAO entiCompilatoriDAO;
	
	@Autowired
	private PrTModuloMailInvitiDAO prTModuloMailInvitiDAO;
	
	@Autowired
	private ConfermeModuliRepository confermeModuliRepository;

	public ModuliModel insDefinModuli(ModuliModel moduliModel ) throws IOException{
		String methodName="insDefinModuli";
		log.startMethod(methodName);	
		PrTModuli prTmoduli = mapper.map(moduliModel, PrTModuli.class);
		log.debug(methodName, "id ente gestore " + moduliModel.getIdEnteGestore());
		PrTEntiGestori prTEntigestori = enteGestoreRepository.findOne(moduliModel.getIdEnteGestore());
		prTmoduli.setPrTEntiGestori(prTEntigestori);
		prTmoduli.setNome(prTmoduli.getNome().trim().toUpperCase());
		prTmoduli.setDataUltimaModifica(new Date());		
		PrTModuli modulo = moduliDAO.create(prTmoduli);
		mapper.map(modulo, moduliModel);		
		log.stopMethod(methodName);
		return moduliModel;
	}

	@Override
	public void modificaModuli(ModuliModel moduliModel ) throws IOException{
		String methodName="insDefinModuli";
		log.startMethod(methodName);	
		Date now = new Date();
		log.debug(methodName, "getIdModulo " + moduliModel.getIdModulo());
		PrTModuli prTmoduli = moduliRepository.findOne(moduliModel.getIdModulo());
		mapper.map(moduliModel, prTmoduli);
		prTmoduli.setDataUltimaModifica(now);

		log.stopMethod(methodName);
	}
	
	@Override
	public List<ModuliModel> ricercaModuli(String nome,String stato,String tipo,Long idEnteGestore,String codiceGruppo) {
		String methodName = "ricercaModuli";
		log.startMethod(methodName);	
		log.debug(methodName, "nome  " + nome);
		log.debug(methodName, "stato " + stato);
		log.debug(methodName, "tipo  " + tipo);
		log.debug(methodName, "idEnteGestore " + idEnteGestore);	
		List<PrTModuli> lista = moduliDAO.getModuli(nome,stato,tipo, idEnteGestore,codiceGruppo);				
		List<ModuliModel> listaModuli = mapAll(lista, ModuliModel.class);	
		log.stopMethod(methodName);
		return listaModuli;
	}
	
	@Override
	public ModuliModel getModuloForId(Long idModuloSelezionato){
		String methodName = "getModuloForId";
		log.startMethod(methodName);		
		log.debug(methodName, "idModuloSelezionato  " + idModuloSelezionato);
		PrTModuli prTModuli = moduliRepository.findOne(idModuloSelezionato);
		// valorizzo i dati di testata 
		ModuliModel modulo = mapper.map(prTModuli,ModuliModel.class);
		modulo.setIdEnteGestore(prTModuli.getPrTEntiGestori().getIdEnteGestore());		
		// valorizzo i dati di colonna
		List<PrTColonneModulo> listaDA = prTModuli.getPrTColonneModulos();
		List<ColonneModuloModel> listaA = mapAll(listaDA, ColonneModuloModel.class);		
		modulo.setListaColonneModulo(listaA);	
		log.stopMethod(methodName);
		return modulo;
	}

	@Override
	public List<RigaModuloModel> getRigheByModuloEnti(ValidaRigheModuliModel validaModulStep1Model) {
		String methodName = "getRigheByModuloEnti";
		log.startMethod(methodName);
/*		log.debug(methodName," "+validaModulStep1Model.getIdModuloSel());
		log.debug(methodName," "+validaModulStep1Model.getIdEnteGestore());
		log.debug(methodName," "+StringUtils.trimToEmpty(validaModulStep1Model.getRagioneSociale()).toUpperCase());
		log.debug(methodName," "+StringUtils.trimToEmpty(validaModulStep1Model.getClassificazione()).toUpperCase());
		log.debug(methodName," "+StringUtils.trimToEmpty(validaModulStep1Model.getComune()).toUpperCase());
		log.debug(methodName," "+StringUtils.trimToEmpty(validaModulStep1Model.getProvincia()).toUpperCase());
		log.debug(methodName," "+StringUtils.trimToEmpty(validaModulStep1Model.getCodiceFiscale()).toUpperCase());
		log.debug(methodName," "+StringUtils.trimToEmpty(validaModulStep1Model.getPartitaIva()).toUpperCase());
		log.debug(methodName," "+StringUtils.trimToEmpty(validaModulStep1Model.getProvvedimento()));*/		
		List<PrTEntiCompilatori> lista = entiCompilatoriDAO.getCompilatoriByIdModulo(
																						validaModulStep1Model.getIdModuloSel(),
																						validaModulStep1Model.getIdEnteGestore(),
																						validaModulStep1Model.getRagioneSociale(),
																						validaModulStep1Model.getClassificazione(),
																						validaModulStep1Model.getComune(),
																						validaModulStep1Model.getProvincia(),
																						//validaModulStep1Model.getIstat(),
																						validaModulStep1Model.getCodiceFiscale(),
																						validaModulStep1Model.getPartitaIva(),
																						validaModulStep1Model.getProvvedimento()
																						);				
	
		List<RigaModuloModel> listaRigaModuloModel = new ArrayList<RigaModuloModel>();
		String statoRigaDaRicercare = StringUtils.trimToEmpty(validaModulStep1Model.getStatoRiga());		
		//ciclo gli enti compilatori trovati
		for(PrTEntiCompilatori prTEntiCompilatoriSel: lista){
			
			List<PrTRighe> listaRighe = righeDAO.getRigheByIdEnteIdModuloProvvedimento( prTEntiCompilatoriSel.getIdEnteCompilatore(),
																						validaModulStep1Model.getIdModuloSel(),
																						validaModulStep1Model.getProvvedimento(),
																						Costanti.TIPO_MODULO_RILEVAZIONE.getCostante());			
			for(PrTRighe riga :listaRighe){
				RigaModuloModel rigaModel = mapper.map(riga, RigaModuloModel.class);				
				List<CellaModuloModel> listaCelleXRiga = new ArrayList<CellaModuloModel>();				
				for(PrTCella cella :riga.getPrTCellas()){
					CellaModuloModel cellaModel = mapper.map(cella, CellaModuloModel.class);
					cellaModel.setIdRiga(cella.getId().getPrTRighe().getIdRiga());
					cellaModel.setIdColonnaModulo(cella.getId().getPrTColonneModulo().getIdColonnaModulo());
					listaCelleXRiga.add(cellaModel);
				}				
				rigaModel.setListaCelleModulo(listaCelleXRiga);		
				rigaModel.setRagioneSocialeEnte(prTEntiCompilatoriSel.getRagioneSociale());				
//				log.info(methodName, "statoRigaDaRicercare " + statoRigaDaRicercare);
//				log.info(methodName, "rigaModel.isValidato() " + rigaModel.isValidato());
//				log.info(methodName, "rigaModel.getDataValidazioneGestore() " + rigaModel.getDataValidazioneGestore());
				if(statoRigaDaRicercare.equals(Costanti.TUTTI.getCostante()) || statoRigaDaRicercare.isEmpty()){
					listaRigaModuloModel.add(rigaModel);
				}
				if(statoRigaDaRicercare.equals(Costanti.DAVALIDARE.getCostante()) && !rigaModel.isValidato()){
					listaRigaModuloModel.add(rigaModel);
				}
				if(statoRigaDaRicercare.equals(Costanti.VALIDATI.getCostante()) && rigaModel.isValidato()){
					listaRigaModuloModel.add(rigaModel);
				}					
			}
		}		
		log.stopMethod(methodName);
		return listaRigaModuloModel;
	}
	
	@Override
	public void validaRighe(List<Long> listaIdRigaValidanti,List<Long> listaIdRigaInValidanti) {
		String methodName="validaRighe";
		log.startMethod(methodName);
		Date now = new Date();			
		for(Long id: listaIdRigaValidanti){
			PrTRighe modulo = righeRepository.findOne(id);
			modulo.setDataModificaCompilatore(now);
			modulo.setDataAgg(now);
			modulo.setDataValidazioneGestore(now);
		}
		for(Long id: listaIdRigaInValidanti){
			PrTRighe modulo = righeRepository.findOne(id);
			modulo.setDataModificaCompilatore(now);
			modulo.setDataAgg(now);
			modulo.setDataValidazioneGestore(null);
		}		
	}
	
	@Override
	public void modificaValoriCelle(List<List<String>> listaRigheVisibili) {
		String methodName="modificaValoriCelle";
		log.startMethod(methodName);
		log.debug(methodName, "listaRigheVisibili " + listaRigheVisibili.size());
		for(List<String> riga:listaRigheVisibili){
			for(String cella :riga){			
				if(cella!=null){
					log.debug(methodName, "cella " + cella);
					List<String> el = Utility.splittaString(cella ,Costanti.SEPARATORE_PROV.getCostante());					
					//questa porzione di codice gestisce l'eventuale valore nullo della cella
					String valore    = "";
					if(el.size()>2){
						valore = el.get(2);
					}					
					// estraggo la cella da modificare 
					Long idRiga = Long.valueOf(el.get(0));
					Long idColonna = Long.valueOf(el.get(1));
					PrTCellaPK id = new PrTCellaPK();
					PrTRighe prTRighe                 = righeRepository.findOne(idRiga); 
					PrTColonneModulo prTColonneModulo = colonneModuloRepository.findOne(idColonna); 
					id.setPrTRighe(prTRighe);
					id.setPrTColonneModulo(prTColonneModulo);
					PrTCella entity = cellaRepository.findOne(id);
					// FINE estraggo la cella da modificare					
					// ne risetto il valore
					entity.setValore(valore);					
				}				
			}		
		}	
		log.stopMethod(methodName);
	}

	@Override
	public List<ColonneModuloModel> getColonneByIdModulo(Long idModulo) {
		String methodName="getColonneByIdModulo";
		log.startMethod(methodName);
		log.debug(methodName,"idModulo "+idModulo);
		List<PrTColonneModulo> lista = colonneModuloRepository.findColonneByIdModulo(idModulo);
		List<ColonneModuloModel> ris = mapAll(lista,ColonneModuloModel.class);		
		log.stopMethod(methodName);
		return ris;
	}

	@Override
	public List<ColonneModuloModel> getColonneByIdModulo(Long idModulo,String editabilitaProfilo) {
		String methodName="getColonneByIdModulo";
		log.startMethod(methodName);
		log.debug(methodName,"idModulo "+idModulo);
		log.debug(methodName,"editabilitaProfilo "+editabilitaProfilo);
		List<PrTColonneModulo> lista = colonneModuloRepository.findColonneByIdModulo(idModulo,editabilitaProfilo);
		List<ColonneModuloModel> ris = mapAll(lista,ColonneModuloModel.class);		
		log.stopMethod(methodName);
		return ris;

	}

	@Override
	public void salvaModuloEColonne(ModuliModel modulo) {
		String methodName="salvaModuloEColonne";
		log.startMethod(methodName);
		List<ColonneModuloModel> lista = modulo.getListaColonneModulo();// ok
		log.debug(methodName," lista colonne len " + lista.size()); 
		Long idModulo = modulo.getIdModulo();
		log.debug(methodName,"idModulo "+idModulo);
		List<PrTColonneModulo> lcmdb = colonneModuloRepository.findColonneByIdModulo(idModulo);
		colonneModuloRepository.delete(lcmdb);
		PrTModuli prTModuli = moduliRepository.findOne(idModulo);
		for(ColonneModuloModel colonna : lista){
			PrTColonneModulo colonnaEntity = mapper.map(colonna, PrTColonneModulo.class);
			colonnaEntity.setPrTModuli(prTModuli);
			colonneModuloRepository.save(colonnaEntity);
		}	 
		log.stopMethod(methodName);
	}
	
	@Override
	public String eliminaModulo(Long idModuloSel) {
		String methodName="eliminaModulo";
		log.startMethod(methodName);		
		PrTModuli modulo = moduliRepository.findOne(idModuloSel);			
		List<PrTModuloMailInviti> mailInviate = moduliMailInvitiRepository.getInvitiByIdModulo(idModuloSel);
		int numMailInviate = mailInviate.size();	
		List<PrTRighe> righeModulo = righeRepository.getRigheByIdModulo(idModuloSel);			
		if(numMailInviate>0){
			log.info(methodName, "mail inviate numMailInviate " + numMailInviate);
			return Costanti.MAIL_GIA_INVIATE.getCostante();	
		}
		if(CollectionUtils.isNotEmpty(righeModulo)){
			log.info(methodName, "righe presenti righeModulob " + righeModulo.size());
			return Costanti.RIGHE_PRESENTI.getCostante();	
		}	
		moduliRepository.delete(modulo);
		log.stopMethod(methodName);		
		return "";
	}
	
	@Override
	public void setListaEntiFromModulo(Long idModulo,List<EntiCompilatoriModel> listaEnti) {
		String methodName="setListaEntiFromModulo";
		log.startMethod(methodName);		
		log.debug(methodName,"idModulo "+idModulo);
		PrTModuli prTmoduli = moduliRepository.findOne(idModulo);
		List<PrTEntiCompilatori> listaPrTEntiCompilatori = new ArrayList<PrTEntiCompilatori>();		
		for(EntiCompilatoriModel ecm : listaEnti) {
			PrTEntiCompilatori ptec = enteCompilatoreRepository.findOne(ecm.getIdEnteCompilatore());
			listaPrTEntiCompilatori.add(ptec);
		}
		log.debug(methodName, "Size of listaPrTEntiCompilatori: " + listaPrTEntiCompilatori.size());
		prTmoduli.setPrTEntiCompilatoris(listaPrTEntiCompilatori);
		settaListaConfermeFromModulo(idModulo, listaEnti,Costanti.NO.getCostante());
		log.stopMethod(methodName);
	}
	
	@Override
	public void addListaEntiFromModulo(Long idModulo,List<EntiCompilatoriModel> listaEnti) {
		String methodName="addListaEntiFromModulo";
		log.startMethod(methodName);		
		log.debug(methodName,"idModulo "+idModulo);
		PrTModuli prTmoduli = moduliRepository.findOne(idModulo);		
		List<PrTEntiCompilatori> listaPrTEntiCompilatori =  prTmoduli.getPrTEntiCompilatoris();		
		for(EntiCompilatoriModel ecm : listaEnti) {
			PrTEntiCompilatori ptec = enteCompilatoreRepository.findOne(ecm.getIdEnteCompilatore());
			listaPrTEntiCompilatori.add(ptec);
		}
		prTmoduli.setPrTEntiCompilatoris(listaPrTEntiCompilatori);			
		settaListaConfermeFromModulo(idModulo, listaEnti,Costanti.NO.getCostante());
		log.stopMethod(methodName);
	}
	
	@Override
	public void settaListaConfermeFromModulo(Long idModulo,List<EntiCompilatoriModel> listaEnti,String moduloConfermato) {
		String methodName="addListaEntiFromModulo";
		log.startMethod(methodName);
		PrTModuli prTmoduli = moduliRepository.findOne(idModulo);		
		for(EntiCompilatoriModel ecm : listaEnti) {
			PrTConfermeModuli r = confermeModuliRepository.getConfermeModuliByIdEnteIdModulo(ecm.getIdEnteCompilatore(), idModulo);
			if(r == null){
				PrTEntiCompilatori ptec = enteCompilatoreRepository.findOne(ecm.getIdEnteCompilatore());				
				PrTConfermeModuli entity = new PrTConfermeModuli();
				entity.setModuloConfermato(moduloConfermato);
				entity.setPrTEntiCompilatori(ptec);
				entity.setPrTModuli(prTmoduli);
				confermeModuliDAO.create(entity);
			}
		}
		log.stopMethod(methodName);
	}
	
	@Override
	public List<EntiCompilatoriModel> getEntiCompilatoriForListId(List<Long> listaId) {
		String methodName="getEntiCompilatoriForListId";
		log.startMethod(methodName);
		List<EntiCompilatoriModel> ris = new ArrayList<EntiCompilatoriModel>();		
		if(CollectionUtils.isNotEmpty(listaId)){
			Iterable<PrTEntiCompilatori> lista = enteCompilatoreRepository.findAll(listaId);			
			for(PrTEntiCompilatori prTEntiCompilatori : lista){		
				ris.add(mapper.map(prTEntiCompilatori, EntiCompilatoriModel.class));
			}
		}		
		log.stopMethod(methodName);
		return ris;
	}	
		
	@Override
	public boolean isStrutturaModuloModificabile(Long idModulo) {
		String methodName="isStrutturaModuloModificabile";
		log.startMethod(methodName); 		
		log.debug(methodName, "idModulo " + idModulo);

		Long numCelle = prTCellaDAO.getNumCelleByIdModulo(idModulo);
		
		boolean ris = !(numCelle > 0) ;	
		log.stopMethod(methodName); 
		return ris;
	}
	
	@Override
	public ModuliModel xstModulo(String nome, String stato,String tipo) {
		String methodName = "xstModulo";
		log.startMethod(methodName);		
		ModuliModel modModel = new ModuliModel();
		log.debug(methodName, "nome " + nome);
		log.debug(methodName, "stato " + stato);
		log.debug(methodName, "tipo " + tipo);
		List<PrTModuli> mod = moduliDAO.xstModulo(nome,stato,tipo);		
		if(CollectionUtils.isNotEmpty(mod)){
			modModel = mapper.map(mod.get(0), ModuliModel.class); 
		}		
		log.stopMethod(methodName); 
		return modModel;
	}

	@Override
	/**
	 * il parametro tutti  forza la mail a tutti gli enti associati al modulo 
	 * se parametro tutti  manda la mail solo ai nuovi enti aggiunti
	 */
	public void invioMailInvito(Long idModuloSel,
								Long idUtenteGestore,
								String mittente,
								String oggMailModulo,
								String descMailModulo,
								Long idEnteGest,
								boolean tutti)throws MessagingException {
		
		String methodName="invioMailInvito";
		log.startMethod(methodName);		
		log.debug(methodName, "idModuloSel     " + idModuloSel);
		log.debug(methodName, "idUtenteGestore " + idUtenteGestore);		
		log.debug(methodName, "mittente        " + mittente);
		log.debug(methodName, "oggMailModulo   " + oggMailModulo);
		log.debug(methodName, "descMailModulo  " + descMailModulo);
		log.debug(methodName, "idEnteGest      " + idEnteGest);
		log.debug(methodName, "tutti           " + tutti);
		
		PrTModuli modulo = moduliRepository.findOne(idModuloSel);	
		List<PrTModuloMailInviti> listaMailGiaInviate = moduliMailInvitiRepository.getInvitiByIdModulo(idModuloSel);
		List<PrTModuloMailInviti> listaMailDaInviareTotali = new ArrayList<PrTModuloMailInviti>();
		List<PrTModuloMailInviti> listaMailDaInviare = new ArrayList<PrTModuloMailInviti>();	
		List<PrTEntiCompilatori> listaEntiAssociatiAlModulo = modulo.getPrTEntiCompilatoris();		
		//serve per ricavare la mail da mettere in cc
		String indirizzoEmailEnteGest = enteGestoreRepository.findOne(idEnteGest).getMail();	
		log.debug(methodName, "indirizzoEmailEnteGest " + indirizzoEmailEnteGest);
		// lista mail eventualmente da inviare
		for(PrTEntiCompilatori prTEntiCompilatori: listaEntiAssociatiAlModulo){		
			PrTModuloMailInviti nuovoMailInvitiEnteComp = new PrTModuloMailInviti();
			nuovoMailInvitiEnteComp.setIdModuloMailInvito(null);
			nuovoMailInvitiEnteComp.setIdModulo(idModuloSel);
			nuovoMailInvitiEnteComp.setIdEnteGestore(idEnteGest);
			nuovoMailInvitiEnteComp.setIdUtenteGestore(idUtenteGestore);
			nuovoMailInvitiEnteComp.setIdUtenteCompilatore(0L);
			nuovoMailInvitiEnteComp.setIdEnteCompilatore(prTEntiCompilatori.getIdEnteCompilatore());
			nuovoMailInvitiEnteComp.setDataInvio(new Date());
			nuovoMailInvitiEnteComp.setIdEnteGestore(idEnteGest);
			nuovoMailInvitiEnteComp.setMailMittente(mittente);
			nuovoMailInvitiEnteComp.setMailDestinatario(prTEntiCompilatori.getMail());
			nuovoMailInvitiEnteComp.setMailCC(indirizzoEmailEnteGest);
			nuovoMailInvitiEnteComp.setOggetto(oggMailModulo);
			nuovoMailInvitiEnteComp.setTesto(descMailModulo);			
			listaMailDaInviareTotali.add(nuovoMailInvitiEnteComp);			 
			//aggiungo le mail degli utenti compilatori associati a quel''ente
			for(PrTUtentiCompilatori utenteComp:prTEntiCompilatori.getPrTUtentiCompilatoris()){			
				PrTModuloMailInviti nuovoMailInvitiUtenteComp = new PrTModuloMailInviti();
				nuovoMailInvitiUtenteComp.setIdModuloMailInvito(null);
				nuovoMailInvitiUtenteComp.setIdModulo(idModuloSel);
				nuovoMailInvitiUtenteComp.setIdEnteGestore(idEnteGest);
				nuovoMailInvitiUtenteComp.setIdUtenteGestore(idUtenteGestore);
				nuovoMailInvitiUtenteComp.setIdUtenteCompilatore(utenteComp.getIdUtenteCompilatore());
				nuovoMailInvitiUtenteComp.setIdEnteCompilatore(prTEntiCompilatori.getIdEnteCompilatore());
				nuovoMailInvitiUtenteComp.setDataInvio(new Date());
				nuovoMailInvitiUtenteComp.setIdEnteGestore(idEnteGest);
				nuovoMailInvitiUtenteComp.setMailMittente(mittente);
				nuovoMailInvitiUtenteComp.setMailDestinatario(utenteComp.getMail());
				nuovoMailInvitiUtenteComp.setMailCC(indirizzoEmailEnteGest);
				nuovoMailInvitiUtenteComp.setOggetto(oggMailModulo);
				nuovoMailInvitiUtenteComp.setTesto(descMailModulo);
				listaMailDaInviareTotali.add(nuovoMailInvitiUtenteComp);
			}
		}	
		listaMailDaInviare = listaMailDaInviareTotali;
		// se voglio mandare solo le mail non ancora inviate
		if(!tutti){
			listaMailDaInviare = sottraiInvitiGiaInviati(listaMailGiaInviate,listaMailDaInviareTotali);			
		}
		invioMail( mittente,listaMailDaInviare,oggMailModulo,descMailModulo,indirizzoEmailEnteGest,idModuloSel,idUtenteGestore);        
		log.stopMethod(methodName);
	}
	
	@Override
	/**
	 * il parametro tutti  forza la mail a tutti gli enti associati al modulo 
	 * se parametro tutti  manda la mail solo ai nuovi enti aggiunti
	 */
	public void invioMailSollecito(Long idModuloSel,
								Long idUtenteGestore,
								String mittente,
								String oggMailModulo,
								String descMailModulo,
								String gruppoSollecito
								)throws MessagingException {
		
		String methodName="invioMailSollecito";
		log.startMethod(methodName);		
		log.debug(methodName, "idModuloSel     " + idModuloSel);
		log.debug(methodName, "idUtenteGestore " + idUtenteGestore);		
		log.debug(methodName, "mittente        " + mittente);
		log.debug(methodName, "oggMailModulo   " + oggMailModulo);
		log.debug(methodName, "descMailModulo  " + descMailModulo);
		
		List<String> listaMailDaInviare = new ArrayList<String>();		
		
		List<PrVModuliUtentiCoompilatori> lista = prTModuloMailInvitiDAO.getListaMailSollecitiUtentiCompilatoriFromModulo(idModuloSel,gruppoSollecito);
		for(PrVModuliUtentiCoompilatori e :lista){
			listaMailDaInviare.add(e.getMail());
		}
		if(listaMailDaInviare.size()>0){
			int contatoreTotale=listaMailDaInviare.size();		 
			 int step = Integer.parseInt(Costanti.STEP_NUM_MAIL.getCostante());		 
			 if(contatoreTotale<step){
				 step = contatoreTotale;
			 }	 
			 String indirizzoEmailTo = "";
			 String separatore = "";		
			 List<PrTModuloMailInviti> listaInviti = new ArrayList<PrTModuloMailInviti>();		 
			 for(String sollecito : listaMailDaInviare){
				 indirizzoEmailTo = sollecito + separatore + indirizzoEmailTo ;				
				 separatore = Costanti.SEPARATORE_COMMA.getCostante();		
				if(step==1){
					//la prima mail ha in cc la mail dell'ente gestore			
					MailSender mailSender = new MailSender();				
					try{
						mailSender.inviaMail(mittente,
											oggMailModulo,
											StringUtils.abbreviate(descMailModulo.trim(),9999),
											indirizzoEmailTo,
											new ArrayList<String>());

						
						listaInviti = new ArrayList<PrTModuloMailInviti>();
					}catch( MessagingException  e){
						log.error(methodName, "ERRORE INVIO MAIL" ,e);
						throw e;
					}
					contatoreTotale=contatoreTotale-step;	 
					if(contatoreTotale<Integer.parseInt(Costanti.STEP_NUM_MAIL.getCostante())){
						step = contatoreTotale;
					}else{
						step = Integer.parseInt(Costanti.STEP_NUM_MAIL.getCostante());
					}			
					indirizzoEmailTo = "";
					separatore       = "";
				}
				step--;
			}	
			
			
		}
		log.stopMethod(methodName);
	}

	//TODO da realizzare con la differenza fra le liste
	private List<PrTModuloMailInviti> sottraiInvitiGiaInviati(List<PrTModuloMailInviti> listaMailGiaInviate,List<PrTModuloMailInviti> listaMailDaInviareTotali) {
		return listaMailDaInviareTotali;
	}

	private void invioMail(String mittente,
								List<PrTModuloMailInviti> listaMailDaInviare,
								String oggMailModulo,
								String descMailModulo,
								String indirizzoEmailCC,
								Long idModuloSel,
								//Long idEnteGest,
								Long idUtenteGestore) throws MessagingException{
		
		 String methodName="invioMail";
		 log.startMethod(methodName);		 

		 int contatoreTotale=listaMailDaInviare.size();		 
		 int step = Integer.parseInt(Costanti.STEP_NUM_MAIL.getCostante());		 
		 if(contatoreTotale<step){
			 step = contatoreTotale;
		 }	 
		 String indirizzoEmailTo = "";
		 String separatore = "";		
		 List<PrTModuloMailInviti> listaInviti = new ArrayList<PrTModuloMailInviti>();		 
		 for(PrTModuloMailInviti invito : listaMailDaInviare){
			listaInviti.add(invito);
			indirizzoEmailTo = invito.getMailDestinatario() + separatore + indirizzoEmailTo ;
			separatore = Costanti.SEPARATORE_COMMA.getCostante();		
			if(step==1){
				//la prima mail ha in cc la mail dell'ente gestore			
				MailSender mailSender = new MailSender();				
				//log.debug(methodName, "mittente  " + mittente);
				//log.debug(methodName, "ricercaModuliModel.getOggMailModulo()  " + oggMailModulo);
				//log.debug(methodName, "ricercaModuliModel.getDescMailModulo() " + descMailModulo);
				//log.debug(methodName, "indirizzoEmailTo " +indirizzoEmailTo);
				//log.debug(methodName, "indirizzoEmailCC " +indirizzoEmailCC);
				try{
					mailSender.inviaMail(mittente,
										oggMailModulo,
										StringUtils.abbreviate(descMailModulo.trim(),9999),
										indirizzoEmailTo,
										indirizzoEmailCC);

					salvaStoricoMailInviti(listaInviti);
					
					listaInviti = new ArrayList<PrTModuloMailInviti>();
				}catch( MessagingException  e){
					log.error(methodName, "ERRORE INVIO MAIL" ,e);
					throw e;
				}
				contatoreTotale=contatoreTotale-step;	 
				if(contatoreTotale<Integer.parseInt(Costanti.STEP_NUM_MAIL.getCostante())){
					step = contatoreTotale;
				}else{
					step = Integer.parseInt(Costanti.STEP_NUM_MAIL.getCostante());
				}			
				indirizzoEmailCC = "";
				indirizzoEmailTo = "";
				separatore       = "";
			}
			step--;
		}	
		 
		log.stopMethod(methodName); 
	}
	
	/**
	 * 
	 * @param listaInviti
	 */
	private void salvaStoricoMailInviti(List<PrTModuloMailInviti> listaInviti) {
		for(PrTModuloMailInviti entity : listaInviti){
			prTModuloMailInvitiDAO.create(entity);
		}
	}

	@Override
	public List<RigaModuloModel> getRigheByIdModulo(Long idModulo) {
		String methodName="getRigheByIdModulo";
		log.startMethod(methodName); 		
		List<RigaModuloModel> ris = new ArrayList<RigaModuloModel>();	
		List<PrTRighe> listaPrTRighe = righeRepository.getRigheByIdModulo(idModulo);
		for(PrTRighe prTRighe: listaPrTRighe){
			RigaModuloModel riga = mapper.map(prTRighe, RigaModuloModel.class);		
			List<CellaModuloModel> listaCelleRiga = mapAll(prTRighe.getPrTCellas(), CellaModuloModel.class);
			riga.setListaCelleModulo(listaCelleRiga);		
			ris.add(riga);
		}
		log.stopMethod(methodName); 
		return ris;
	}

	@Override
	public List<RigaModuloModel> getRigheByIdModuloCFCompilatore(Long idModulo,String codicefiscale,String ragioneSocialeEnte) {
		String methodName="getRigheByIdModuloCFCompilatore";
		log.startMethod(methodName);		
		log.debug(methodName,"codicefiscale "+codicefiscale);
		log.debug(methodName,"idModulo "+idModulo);
		List<PrTRighe> listaPrTRighe = righeRepository.getRigheByIdModuloCFCompilatore(codicefiscale,idModulo);
		List<RigaModuloModel> ris = new ArrayList<RigaModuloModel>();		
		for(PrTRighe riga : listaPrTRighe){
			RigaModuloModel rigaModuloModel =mapper.map(riga, RigaModuloModel.class);
			rigaModuloModel.setRagioneSocialeEnte(ragioneSocialeEnte);			
			List<PrTCella> listaCelle = riga.getPrTCellas();
			List<CellaModuloModel> listaCelleModel = mapAll(listaCelle,CellaModuloModel.class);
			rigaModuloModel.setListaCelleModulo(listaCelleModel);
			ris.add(rigaModuloModel);
		}		
		log.stopMethod(methodName);
		return ris;
	}

	@Override
	public List<RigaModuloModel> getRigheByIdModuloIdEnteCompilatore(Long idModulo, Long idEnteCompilatore) {
		String methodName="getRigheByIdModuloIdEnteCompilatore";
		log.startMethod(methodName);		
		log.info(methodName,"idEnteCompilatore "+idEnteCompilatore);
		log.info(methodName,"idModulo "+idModulo);		
		List<PrTRighe> listaPrTRighe = righeRepository.getRigheByIdEnteIdModulo(idEnteCompilatore,idModulo);
		List<RigaModuloModel> ris = new ArrayList<RigaModuloModel>();		
		for(PrTRighe riga : listaPrTRighe){
			RigaModuloModel rigaModuloModel =mapper.map(riga, RigaModuloModel.class);
			List<PrTCella> listaCelle = riga.getPrTCellas();
			List<CellaModuloModel> listaCelleModel = mapAll(listaCelle,CellaModuloModel.class);
			rigaModuloModel.setListaCelleModulo(listaCelleModel);
			ris.add(rigaModuloModel);
		}	
		log.stopMethod(methodName);
		return ris;
	}

	@Override
	public List<RigaModuloModel> getRigheByIdModuloIdEnteCompilatore(Long idModulo, Long idEnteCompilatore,String editabilitaProfilo) {
		String methodName="getRigheByIdModuloIdEnteCompilatore";
		log.startMethod(methodName);		
		log.info(methodName,"idEnteCompilatore "+idEnteCompilatore);
		log.info(methodName,"idModulo "+idModulo);		
		List<PrTRighe> listaPrTRighe = righeRepository.getRigheByIdEnteIdModulo(idEnteCompilatore,idModulo);
		log.info(methodName, "Numero di righe fornite dal DB: " + listaPrTRighe.size());
		List<RigaModuloModel> ris = new ArrayList<RigaModuloModel>();		
		for(PrTRighe riga : listaPrTRighe){
			RigaModuloModel rigaModuloModel =mapper.map(riga, RigaModuloModel.class);
			rigaModuloModel.setRagioneSocialeEnte(riga.getPrTEntiCompilatori().getRagioneSociale());
			List<CellaModuloModel> listaCelleModel = new ArrayList<CellaModuloModel>();
			List<PrTCella> listaCelle = riga.getPrTCellas();
			for(PrTCella cella:listaCelle){
				if(Costanti.COMPILATORE.getCostante().equals(cella.getEditabilitaProfilo())){
					listaCelleModel.add(mapper.map(cella, CellaModuloModel.class));
				}
			}
			rigaModuloModel.setListaCelleModulo(listaCelleModel);
			ris.add(rigaModuloModel);
		}		
		log.stopMethod(methodName);
		return ris;
	}
	
	@Override
	public ListaPaginata<RigaModuloModel> getRigheByIdModuloIdEnteCompilatorePaginato(Long idModulo, Long idEnteCompilatore, String editabilitaProfilo,List<String> listFiltri,Integer numPagina, Integer lenPagina) {
		List<RigaModuloModel> ris = new ArrayList<RigaModuloModel>();
		Page<PrTRighe> listaPrTRighe = righeDAO.getRigheByIdEnteIdModuloPaginato(idEnteCompilatore, idModulo,listFiltri, toPageable(numPagina, lenPagina));	
		
		for(PrTRighe riga : listaPrTRighe){
			RigaModuloModel rigaModuloModel =mapper.map(riga, RigaModuloModel.class);
			rigaModuloModel.setRagioneSocialeEnte(riga.getPrTEntiCompilatori().getRagioneSociale());
			List<CellaModuloModel> listaCelleModel = new ArrayList<CellaModuloModel>();
			List<PrTCella> listaCelle = riga.getPrTCellas();
			for(PrTCella cella:listaCelle){
				if(Costanti.COMPILATORE.getCostante().equals(cella.getEditabilitaProfilo())){
					listaCelleModel.add(mapper.map(cella, CellaModuloModel.class));
				}
			}			
			rigaModuloModel.setListaCelleModulo(listaCelleModel);
			ris.add(rigaModuloModel);
		}		
		return toListaPaginata(ris, listaPrTRighe.getTotalElements() , listaPrTRighe.getTotalPages() , numPagina);
	}

	@Override
	public 	String presenteModuloConfermato(Long idModulo,Long idEnteCompilatore) {	
		PrTConfermeModuli r = confermeModuliRepository.getConfermeModuliByIdEnteIdModulo(idEnteCompilatore, idModulo);
		//TODO soluzione tampone da eliminare quando si sara' capito perche talvolta manca la riga in tabella tconfermeModuli
		if(r == null){
			r = creaConferma(idModulo, idEnteCompilatore);
		}		
		return r.getModuloConfermato();
	}

	//TODO soluzione tampone da eliminare quando si sara' capito perche talvolta manca la riga in tabella tconfermeModuli
	private PrTConfermeModuli creaConferma(Long idModulo,Long idEnteCompilatore) {
		PrTConfermeModuli r;
		PrTConfermeModuli tcm = new PrTConfermeModuli();
		tcm.setModuloConfermato(Costanti.NO.getCostante());
		tcm.setModuloValidato(Costanti.NO.getCostante());
		PrTEntiCompilatori prTEntiCompilatori  = entiCompilatoriRepository.findOne(idEnteCompilatore);
		tcm.setPrTEntiCompilatori(prTEntiCompilatori);			
		PrTModuli prTModuli = moduliRepository.findOne(idModulo);
		tcm.setPrTModuli(prTModuli);			
		r = confermeModuliDAO.create(tcm);
		return r;
	}
	
	@Override
	public void settaConfermaListaModuloCompilatore(Long idModuloSel,List<Long> listaEntiId,String moduloConfermato) {		
		PrTConfermeModuli r;
		for (Long idEnteCompilatore: listaEntiId){
			r = confermeModuliRepository.getConfermeModuliByIdEnteIdModulo(idEnteCompilatore, idModuloSel);	
			r.setModuloConfermato(moduloConfermato);	
		}			
	}

	@Override
	public void settaConfermaModuloCompilatore(Long idModuloSel,Long idEnteCompilatore,String moduloConfermato) {		
		PrTConfermeModuli r = confermeModuliRepository.getConfermeModuliByIdEnteIdModulo(idEnteCompilatore, idModuloSel);	
		r.setModuloConfermato(moduloConfermato);		
	}

	@Override
	public void settaListaValidazioniFromModulo(Long idModulo,List<EntiCompilatoriModel> listaEntiCompilatoriAssociati,String moduloValidato) {
		String methodName="addListaEntiFromModulo";
		log.startMethod(methodName);
		PrTModuli prTmoduli = moduliRepository.findOne(idModulo);		
		for(EntiCompilatoriModel ecm : listaEntiCompilatoriAssociati) {
			PrTConfermeModuli r = confermeModuliRepository.getConfermeModuliByIdEnteIdModulo(ecm.getIdEnteCompilatore(), idModulo);
			if(r == null){
				PrTEntiCompilatori ptec = enteCompilatoreRepository.findOne(ecm.getIdEnteCompilatore());				
				PrTConfermeModuli entity = new PrTConfermeModuli();
				entity.setModuloConfermato(moduloValidato);
				entity.setPrTEntiCompilatori(ptec);
				entity.setPrTModuli(prTmoduli);
				confermeModuliDAO.create(entity);
			}
		}
		log.stopMethod(methodName);
	}

	@Override
	public void settaValidaModuloCompilatore(Long idModuloSel,Long idEnteCompilatore, String moduloValidato) {
		PrTConfermeModuli r = confermeModuliRepository.getConfermeModuliByIdEnteIdModulo(idEnteCompilatore, idModuloSel);	
		r.setModuloConfermato(moduloValidato);		
	}

	@Override
	public void settaValidaListaModuloCompilatore(Long idModuloSel,List<Long> listaEntiId, String moduloValidato) {
		PrTConfermeModuli r;
		for (Long idEnteCompilatore: listaEntiId){
			r = confermeModuliRepository.getConfermeModuliByIdEnteIdModulo(idEnteCompilatore, idModuloSel);	
			r.setModuloValidato(moduloValidato);		
		}
	}
}