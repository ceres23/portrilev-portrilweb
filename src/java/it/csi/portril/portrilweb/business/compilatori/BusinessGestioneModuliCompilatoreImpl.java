/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business.compilatori;

import it.csi.portril.portrilweb.business.BusinessManagerBase;
import it.csi.portril.portrilweb.business.interfaces.compilatori.BusinessGestioneModuliCompilatore;
import it.csi.portril.portrilweb.dto.MsgAllert;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTCellaDAO;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTModuliDAO;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTRigheDAO;
import it.csi.portril.portrilweb.integration.entity.PrTCella;
import it.csi.portril.portrilweb.integration.entity.PrTColonneModulo;
import it.csi.portril.portrilweb.integration.entity.PrTModuli;
import it.csi.portril.portrilweb.integration.entity.PrTRighe;
import it.csi.portril.portrilweb.integration.repository.CellaRepository;
import it.csi.portril.portrilweb.integration.repository.ColonneModuloRepository;
import it.csi.portril.portrilweb.integration.repository.EntiCompilatoriRepository;
import it.csi.portril.portrilweb.integration.repository.ModuliRepository;
import it.csi.portril.portrilweb.integration.repository.RigheRepository;
import it.csi.portril.portrilweb.model.CellaModuloModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.model.exception.ControlloFormaleException;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.Utility;
import it.csi.portril.portrilweb.util.ValidazioniCelle;
import it.csi.portril.portrilweb.util.ValidazioniCelleXSingolaRiga;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
public class BusinessGestioneModuliCompilatoreImpl extends BusinessManagerBase implements BusinessGestioneModuliCompilatore {
	
	
	@Autowired
	private EntiCompilatoriRepository enteCompilatoreRepository;
	
	@Autowired
	private ColonneModuloRepository colonneModuloRepository;
	
	@Autowired
	private PrTRigheDAO prTRigheDAO;

	@Autowired
	private PrTCellaDAO prTCellaDAO;

	@Autowired
	private PrTModuliDAO moduliDAO;
	
	@Autowired
	private ModuliRepository moduliRepository;

	@Autowired
	private RigheRepository righeRepository;
	
	@Autowired
	private CellaRepository cellaRepository;
	
	@Autowired
	private ValidazioniCelle validazioniCelle;

	@Autowired
	private ValidazioniCelleXSingolaRiga validazioniCelleXSingolaRiga;
		
	@Override
	public List<ModuliModel> getModuliByEnteCompilatore(Long idEnteCompilatoreSelezionato, String nome,String stato,String tipo) {
		String methodName = "getModuliByEnteCompilatore";
		log.startMethod(methodName);	
		List<PrTModuli> lista = moduliDAO.getModuliByEnteCompilatore(
																	idEnteCompilatoreSelezionato,
																	nome,
																	stato,
																	tipo);
		
		List<ModuliModel> listaModuli = mapAll(lista, ModuliModel.class);
		log.stopMethod(methodName);
		return listaModuli;
	}
	
	@Override
	public List<ModuliModel> getModuliByValoreCellaContenuta(String nome,String stato,String tipo,String valoreCella,Integer posizioneColonna,Integer posizioneRiga) {
		String methodName = "getModuliByValoreCellaContenuta";
		log.startMethod(methodName);			
		List<PrTModuli> lista = moduliDAO.getModuliByValoreCellaContenuta(	nome,
																			stato,
																			tipo,
																			valoreCella,
																			posizioneColonna,
																			posizioneRiga);
		
		List<ModuliModel> listaModuli = mapAll(lista, ModuliModel.class);
		log.stopMethod(methodName);
		return listaModuli;
	}

	@Override
	public List<ModuliModel> getModulixComunicazione(Long idEnteGestore, String nome){
		String methodName = "getModulixComunicazione";
		log.startMethod(methodName);		
		List<PrTModuli> lista = moduliDAO.getModulixComunicazione(idEnteGestore,nome);
		List<ModuliModel> listaModuli = mapAll(lista, ModuliModel.class);
		log.stopMethod(methodName);
		return listaModuli;
	}

	@Override
	public List<RigaModuloModel> estraiRigheDaGriglia(List<List<String>>griglia, Long idModulo,Long idUtenteCompilatore,Long idEnteCompilatoreSelezionato,String tipo) {
		return estraiRigheDaGriglia(griglia,  idModulo, idUtenteCompilatore, idEnteCompilatoreSelezionato,"ALL",tipo); 
	}
	
	@Override
	public List<RigaModuloModel> estraiRigheDaGriglia(	List<List<String>>griglia,
														Long idModulo,
														Long idUtenteCompilatore,
														Long idEnteCompilatoreSelezionato,
														String editabilitaProfilo,
														String tipo) {
		String methodName = "estraiRigheDaGriglia";
		log.startMethod(methodName);		
		List<RigaModuloModel> elencoRighe = new ArrayList<RigaModuloModel>();
		List<PrTColonneModulo> colonne = colonneModuloRepository.findColonneByIdModulo(idModulo);
		if(CollectionUtils.isEmpty(griglia)){
			log.debug(methodName ,"griglia a 0 elementi");
			return elencoRighe;
		}
		for(int indexRiga=0;indexRiga<griglia.size();indexRiga++){
			List<String> riga = griglia.get(indexRiga);
			if(CollectionUtils.isNotEmpty(riga)) {
				RigaModuloModel newRiga = new RigaModuloModel();
				newRiga.setIdEnteCompilatore(idEnteCompilatoreSelezionato);
				newRiga.setIdModulo(idModulo);
				newRiga.setIdUtenteCompilatore(idUtenteCompilatore);
				newRiga.setFlgValidazione(Costanti.NO.getCostante());
				newRiga.setPosizione(indexRiga+1);
				newRiga.setDataModificaCompilatore(new Date());
				newRiga.setTipo(tipo);
				List<CellaModuloModel> listaCelleModulo = new ArrayList<CellaModuloModel>();			
				int indiceColonnaCompilatore = 0;
				for(int ic=0;ic<colonne.size();ic++){							
					CellaModuloModel newCella = new CellaModuloModel();
					newCella.setIdColonnaModulo(colonne.get(ic).getIdColonnaModulo());					
					if(colonne.get(ic).getEditabilitaProfilo().equalsIgnoreCase(Costanti.COMPILATORE.getCostante())){
						newCella.setValore(riga.get(indiceColonnaCompilatore));
						newCella.setEditabilitaProfilo(Costanti.COMPILATORE.getCostante());
						indiceColonnaCompilatore++;
					}else{
						newCella.setEditabilitaProfilo(Costanti.VALIDATORE.getCostante());
					}					
					newCella.setPosizioneRiga(indexRiga);
					newCella.setPosizioneColonna(ic+1);
					if(editabilitaProfilo.equals(Costanti.ALL.getCostante()) || newCella.getEditabilitaProfilo().equals(editabilitaProfilo)){
						listaCelleModulo.add(newCella);
					}
				}
				newRiga.setListaCelleModulo(listaCelleModulo);
				elencoRighe.add(newRiga);
			}
		}		
		log.debug(methodName,"num righe "  + elencoRighe.size());
		log.stopMethod(methodName);
		return elencoRighe;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MsgAllert> controlloFormaleRighe( Long idModulo,Integer numColonne,List<RigaModuloModel> listaRighe) throws ControlloFormaleException {
		String methodName="controlloFormaleRighe";
		log.startMethod(methodName);	
		List<MsgAllert> ris = new ArrayList<MsgAllert>();
		List<PrTColonneModulo> colonneCompilatore = colonneModuloRepository.findColonneByIdModulo(idModulo, Costanti.COMPILATORE.getCostante());	
		log.debug(methodName, "colonneCompilatore.size() " + colonneCompilatore.size());
		log.debug(methodName, "numColonne " + numColonne);
		if(!numColonne.equals(colonneCompilatore.size())){			
			ris.add(new MsgAllert(Costanti.ERR.getCostante(),CostantiERR.ERR_COLONNE_NON_CONFORMI.getCostante()));
		}		
		for(int iRiga=0;iRiga<listaRighe.size();iRiga++){
			RigaModuloModel riga = listaRighe.get(iRiga);
			List<CellaModuloModel> listaCelle = riga.getListaCelleModulo();				
			for(int iCol=0;iCol<colonneCompilatore.size();iCol++){
				CellaModuloModel cella = listaCelle.get(iCol);				
				PrTColonneModulo colonna = colonneCompilatore.get(iCol);
				Object obj = validazioniCelle;
				String checkMethod = "check"+colonna.getTipo();			
				Method method;				
				try {
					checkMethod = "check"+colonna.getTipo();
					method = ValidazioniCelle.class.getMethod(checkMethod, PrTColonneModulo.class, CellaModuloModel.class,String.class,String.class);
				} catch (SecurityException e) {
					String msg = "Impossibile accedere al metodo "+ checkMethod;
					log.error(methodName, msg, e);
					throw new ControlloFormaleException(msg, e);
				} catch (NoSuchMethodException e) {
					String msg = "Impossibile trovare il metodo "+ checkMethod;
					log.error(methodName, msg, e);
					throw new ControlloFormaleException(msg, e);
				}			
				ArrayList<MsgAllert> lista;
				try {					
					log.debug(methodName, "invoco il controllo " + checkMethod +" con parametro cella: " + cella.getValore());					
					lista = (ArrayList<MsgAllert>) method.invoke(obj, colonna, cella,String.valueOf(iCol+1),String.valueOf(iRiga+1));					
					for(int a=0 ;a<lista.size();a++){
						log.debug(methodName, "metodo invocato checkMethod "+checkMethod +" err descrizione "+ lista.get(a).getMessaggio() );
					}				
				} catch (IllegalArgumentException e) {
					String msg = "Argomenti non validi per il metodo "+ checkMethod;
					log.error(methodName, msg, e);
					throw new ControlloFormaleException(msg, e);
				} catch (IllegalAccessException e) {
					String msg = "Accesso illegale al metodo "+ checkMethod;
					log.error(methodName, msg, e);
					throw new ControlloFormaleException(msg, e);
				} catch (InvocationTargetException e) {
					String msg = "Eccezione durante l'esecuzione del metodo "+ checkMethod + " message: "+e.getTargetException().getMessage();
					log.error(methodName, msg, e);
					throw new ControlloFormaleException(msg, e.getTargetException());
				}			
				for(MsgAllert msg: lista){
					ris.add(msg);
				}				
			}			
		}		
		log.debug(methodName, "lista tutti gli errori  dopo il controllo " + ris.size());
		log.stopMethod(methodName);
		return ris;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MsgAllert> controlloFormaleRiga( Long idModulo,RigaModuloModel riga) throws ControlloFormaleException {
		String methodName="controlloFormaleRiga";
		log.startMethod(methodName);	
		List<MsgAllert> ris = new ArrayList<MsgAllert>();
		List<PrTColonneModulo> colonneCompilatore = colonneModuloRepository.findColonneByIdModulo(idModulo, Costanti.COMPILATORE.getCostante());
			List<CellaModuloModel> listaCelle = riga.getListaCelleModulo();				
			for(int iCol=0;iCol<colonneCompilatore.size();iCol++){
				CellaModuloModel cella = listaCelle.get(iCol);				
				PrTColonneModulo colonna = colonneCompilatore.get(iCol);
				Object obj = validazioniCelleXSingolaRiga;
				String checkMethod = "check"+colonna.getTipo();			
				Method method;			
				try {
					checkMethod = "check"+colonna.getTipo();
					method = ValidazioniCelleXSingolaRiga.class.getMethod(checkMethod, PrTColonneModulo.class, CellaModuloModel.class,String.class,String.class);
				} catch (SecurityException e) {
					String msg = "Impossibile accedere al metodo "+ checkMethod;
					log.error(methodName, msg, e);
					throw new ControlloFormaleException(msg, e);
				} catch (NoSuchMethodException e) {
					String msg = "Impossibile trovare il metodo "+ checkMethod;
					log.error(methodName, msg, e);
					throw new ControlloFormaleException(msg, e);
				}				
				ArrayList<MsgAllert> lista;
				try {					
					log.debug(methodName, "invoco il controllo " + checkMethod +" con parametro cella: " + cella.getValore());				
					lista = (ArrayList<MsgAllert>) method.invoke(obj, colonna, cella,String.valueOf(iCol+1),String.valueOf(riga.getPosizione()));					
					for(int a=0 ;a<lista.size();a++){
						log.info(methodName, "metodo invocato checkMethod "+checkMethod +" err descrizione "+ lista.get(a).getMessaggio() );
					}					
				} catch (IllegalArgumentException e) {
					String msg = "Argomenti non validi per il metodo "+ checkMethod;
					log.error(methodName, msg, e);
					throw new ControlloFormaleException(msg, e);
				} catch (IllegalAccessException e) {
					String msg = "Accesso illegale al metodo "+ checkMethod;
					log.error(methodName, msg, e);
					throw new ControlloFormaleException(msg, e);
				} catch (InvocationTargetException e) {
					String msg = "Eccezione durante l'esecuzione del metodo "+ checkMethod + " message: "+e.getTargetException().getMessage();
					log.error(methodName, msg, e);
					throw new ControlloFormaleException(msg, e.getTargetException());
				}				
				for(MsgAllert msg: lista){
					ris.add(msg);
				}				
			}							
		log.debug(methodName, "lista tutti gli errori  dopo il controllo " + ris.size());
		log.stopMethod(methodName);
		return ris;
	}
	
	@Override
	public void cancellaRigheSelezionate(String[] listaIdDaEliminare) {	
		log.info("cancellaRigheSelezionate", "");		
		List<Long> idl = new Utility().conversioneLista(listaIdDaEliminare);
		List<PrTRighe> listaRighe = prTRigheDAO.getRigheBylistaIdRiga(idl);
		for(PrTRighe riga :listaRighe) {
			prTCellaDAO.deleteCellaFromRiga(riga.getIdRiga()); 				
			prTRigheDAO.delete(riga);
		}		
	}
	
	@Override
	public List<CellaModuloModel> estraiCelleByIdRiga(Long idRiga) {		
		List<CellaModuloModel> ris = new ArrayList<CellaModuloModel>();
		List<PrTCella> prTCelles = cellaRepository.getCelleByIdRiga(idRiga);		
		ris = mapAll(prTCelles, CellaModuloModel.class);		
		return ris;
	}


	@Override
	public RigaModuloModel getRigByIdRiga(Long idRiga) {
		PrTRighe prTRighe = righeRepository.findOne(idRiga);		
		RigaModuloModel riga = mapper.map(prTRighe, RigaModuloModel.class);			
		return riga;
	}

	@Override
	public Integer getMaxPosizioneRigaByIdModuloIdEnteCompilatore(Long idModuloSel, Long idEnteCompilatore) {
		Integer posizioneRiga = righeRepository.getMaxPosizioneRigaByIdModuloIdEnteCompilatore( idModuloSel,  idEnteCompilatore);
		if(	posizioneRiga == null){posizioneRiga = 0;}
		return posizioneRiga;
	}

/*  
  	private String selezionaIlSeparatore(String line) {
		String separatore = Costanti.SEPARATORE_COMMA.getCostante();
		if(line.indexOf("\";\"")>0){
			separatore = Costanti.SEPARATORE_SEMICOLON.getCostante();
		}
		return separatore;
	}


	private List<CellaModuloModel> creaCellePerRiga(Long idModulo,int posizioneRiga, RigaModuloModel riga, String[] celledellaRiga) {
		final String methodName = "creaCellePerRiga";
		log.startMethod(methodName);
		
		List<PrTColonneModulo> colonne = colonneModuloRepository.findColonneByIdModulo(idModulo);
		List<CellaModuloModel> elencoCelle = new ArrayList<CellaModuloModel>();
		int i = 0;
		for(PrTColonneModulo colonna :colonne) {
			CellaModuloModel cella = new CellaModuloModel();	
			cella.setIdColonnaModulo(colonna.getIdColonnaModulo());
			cella.setPosizioneColonna(colonna.getPosizione());
			cella.setPosizioneRiga(posizioneRiga); 
			
			if(colonna.getEditabilitaProfilo().equals(Costanti.COMPILATORE.getCostante())){
				String cel = celledellaRiga[i].replaceAll("\"", "");				
				cella.setValore(cel);
				cella.setEditabilitaProfilo(Costanti.COMPILATORE.getCostante());
				i++;
			}else{
				cella.setEditabilitaProfilo(Costanti.VALIDATORE.getCostante());
			}
			elencoCelle.add(cella);		
		}
		log.stopMethod(methodName);
		return elencoCelle;
	}
	*/

}