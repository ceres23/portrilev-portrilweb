/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneModuli;
import it.csi.portril.portrilweb.business.interfaces.BusinessGestioneReport;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTModuliDAO;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTRigheDAO;
import it.csi.portril.portrilweb.integration.entity.PrTCella;
import it.csi.portril.portrilweb.integration.entity.PrTCellaPK;
import it.csi.portril.portrilweb.integration.entity.PrTColonneModulo;
import it.csi.portril.portrilweb.integration.entity.PrTEntiCompilatori;
import it.csi.portril.portrilweb.integration.entity.PrTModuli;
import it.csi.portril.portrilweb.integration.entity.PrTRighe;
import it.csi.portril.portrilweb.integration.repository.CellaRepository;
import it.csi.portril.portrilweb.integration.repository.ColonneModuloRepository;
import it.csi.portril.portrilweb.integration.repository.EntiCompilatoriRepository;
import it.csi.portril.portrilweb.integration.repository.ModuliRepository;
import it.csi.portril.portrilweb.integration.repository.RigheRepository;
import it.csi.portril.portrilweb.model.CellaModuloModel;
import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.Utility;
import it.csi.portril.portrilweb.util.ValidazioniCelle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
/**
 * Implementor dei dafault del servizio di calcolo. 
 */
// L'annotation @Service indica a Spring di inserire 
// un'istanza della classe nel proprio ApplicationContext 
@Service
// L'annotation @Transactional a livello di classe indica a Spring 
// di eseguire tutti i metodi del servizio in un contesto transazionale
@Transactional
public class BusinessGestioneReportImpl extends BusinessManagerBase implements BusinessGestioneReport{

	@Autowired
	private ModuliRepository moduliRepository;
	
	@Autowired
	private RigheRepository righeRepository;

	@Autowired
	private ColonneModuloRepository colonneModuloRepository;

	@Autowired
	private CellaRepository cellaRepository;

	@Autowired
	private EntiCompilatoriRepository entiCompilatoriRepository;
	
	@Autowired
	private PrTRigheDAO prTRigheDAO;
	
	@Autowired
	private PrTModuliDAO moduliDAO;
		
	@Autowired
	private BusinessGestioneModuli bmGestioneModuli;
	
	@Autowired
	private ValidazioniCelle validazioniCelle;
	
	private static final String SEPARATORE = "\",\"";
	@Override
	public void creaTestataByModulo(Long idModuloSel ,OutputStream outputStream) throws IOException {
		String methodName="creaTestataByModulo"; 
		log.startMethod(methodName);	
		PrTModuli prTModuli = moduliRepository.findOne(idModuloSel);
		List<PrTColonneModulo> colonne = prTModuli.getPrTColonneModulos();
		List<ColonneModuloModel> listaColonne = mapAll(colonne,ColonneModuloModel.class);		
		PrintStream out = new PrintStream(outputStream);
		scriviTestataModuloCvs(listaColonne,out);		
		log.stopMethod(methodName);
	}

	@SuppressWarnings("resource")
	@Override
	public void generaCsV( List<RigaModuloModel>listaRighe,List<ColonneModuloModel>listaColonne,ServletOutputStream outputStream)throws IOException {
		String methodName="generaCsV"; 
		log.startMethod(methodName);	
		PrintStream out = new PrintStream(outputStream);
		out = scriviTestataModuloCvs( listaColonne,out);	
		scriviRigheCvs(listaRighe,out);	
		out.close();		
		log.stopMethod(methodName);
	}

//	@Override
//	@Async
//	public void generaCsVAsync(ServletOutputStream outputStream,Long idModulo , Long idEnteCompilatore) throws IOException {
//		String methodName="generaCsVAsync"; 
//		log.startMethod(methodName);
//		
//		generaCsV( outputStream, idModulo ,  idEnteCompilatore);
//		
//		log.stopMethod(methodName);
//	}
	
	@SuppressWarnings("resource")
	@Override
	public void generaCsV(ServletOutputStream outputStream,Long idModulo , Long idEnteCompilatore) throws IOException {
		String methodName="generaCsV"; 
		log.startMethod(methodName);		
		List<RigaModuloModel> listaRighe       = bmGestioneModuli.getRigheByIdModuloIdEnteCompilatore(idModulo,idEnteCompilatore,Costanti.COMPILATORE.getCostante());
		List<ColonneModuloModel> listaColonne  = bmGestioneModuli.getColonneByIdModulo(idModulo,Costanti.COMPILATORE.getCostante());
		PrintStream out = new PrintStream(outputStream);
		out = scriviTestataModuloCvs( listaColonne,out);			
		scriviRigheCvs(listaRighe,out);	
		out.close();	
		log.stopMethod(methodName);
	}	
	
	@Override
	public void creaRiepilogoDatiByModulo(Long idModuloSel, OutputStream outputStream) throws IOException {
		String methodName="creaRiepilogoDatiByModulo"; 
		log.startMethod(methodName);	
		// estraggo il modulo selezionato
		log.debug(methodName, "idModuloSel " + idModuloSel);
		PrTModuli prTModuli = moduliRepository.findOne(idModuloSel);			
		// estraggo la lista degli enti compilatori che lo hanno utilizzato
		List<PrTEntiCompilatori> listaEntiCompilatori = entiCompilatoriRepository.getListabyIdModulo(idModuloSel);	
		PrintStream out = new PrintStream(outputStream);		
		//estraggo le colonne
		List<PrTColonneModulo> colonne = prTModuli.getPrTColonneModulos();
		List<ColonneModuloModel> listaColonne = mapAll(colonne,ColonneModuloModel.class);		
		//aggiungo le colonne 
		List<ColonneModuloModel> listaColonneArricchita = listaColonne;	
		//aggiungo la colonna in posizione 0
		ColonneModuloModel colonneModuloModel = new ColonneModuloModel();
		colonneModuloModel.setLabelColonna("Ente Compilatore");
		colonneModuloModel.setPosizione(0);
		colonneModuloModel.setEditabilitaProfilo(Costanti.NON_EDITABILE.getCostante());
		listaColonneArricchita = Utility.addElementoAllaLista(listaColonneArricchita, colonneModuloModel,0 );		
		//aggiungo la colonna in posizione 1
		colonneModuloModel = new ColonneModuloModel();
		colonneModuloModel.setLabelColonna(Costanti.COD_FIS_ENTE.getCostante());
		colonneModuloModel.setPosizione(1);
		colonneModuloModel.setEditabilitaProfilo(Costanti.NON_EDITABILE.getCostante());
		listaColonneArricchita = Utility.addElementoAllaLista(listaColonneArricchita, colonneModuloModel,1 );
		//aggiungo la colonna in posizione 2
		colonneModuloModel = new ColonneModuloModel();
		colonneModuloModel.setLabelColonna("Partita Iva Ente");
		colonneModuloModel.setPosizione(2);
		colonneModuloModel.setEditabilitaProfilo(Costanti.NON_EDITABILE.getCostante());
		listaColonneArricchita = Utility.addElementoAllaLista(listaColonneArricchita, colonneModuloModel,2 );		
		// scrivo la testata
		out = scriviTestataModuloCvs(listaColonneArricchita,out);			
		for(PrTEntiCompilatori sel: listaEntiCompilatori ){
			//estraggo le righe
			List<PrTRighe> righe= righeRepository.getRigheByIdEnteIdModulo(sel.getIdEnteCompilatore(),idModuloSel);
			List<RigaModuloModel> listarighe = new ArrayList<RigaModuloModel>();
			CellaModuloModel cellaSupplementare;
			for(PrTRighe prTRiga : righe){
				RigaModuloModel rigaModulo = mapper.map(prTRiga,RigaModuloModel.class)	;
				List<CellaModuloModel> listaCelle = mapAll(prTRiga.getPrTCellas(),CellaModuloModel.class);			
				// aggiungo una cella in posizione 0 
				cellaSupplementare = new CellaModuloModel();
				cellaSupplementare.setIdColonnaModulo(Long.valueOf(0));
				cellaSupplementare.setIdRiga(Long.valueOf(0));
				cellaSupplementare.setPosizioneColonna(0);
				cellaSupplementare.setPosizioneRiga(prTRiga.getPosizione());
				cellaSupplementare.setValore(sel.getRagioneSociale());
				listaCelle = Utility.addElementoAllaLista(listaCelle, cellaSupplementare,0 );
				// aggiungo una cella in posizione 1 
				cellaSupplementare = new CellaModuloModel();
				cellaSupplementare.setIdColonnaModulo(Long.valueOf(0));
				cellaSupplementare.setIdRiga(Long.valueOf(0));
				cellaSupplementare.setPosizioneColonna(1);
				cellaSupplementare.setPosizioneRiga(prTRiga.getPosizione());
				cellaSupplementare.setValore(sel.getCodiceFiscale());
				listaCelle = Utility.addElementoAllaLista(listaCelle, cellaSupplementare,1 );
				// aggiungo una cella in posizione 2 
				cellaSupplementare = new CellaModuloModel();
				cellaSupplementare.setIdColonnaModulo(Long.valueOf(0));
				cellaSupplementare.setIdRiga(Long.valueOf(0));
				cellaSupplementare.setPosizioneColonna(2);
				cellaSupplementare.setPosizioneRiga(prTRiga.getPosizione());
				cellaSupplementare.setValore(sel.getPartitaIva());
				listaCelle = Utility.addElementoAllaLista(listaCelle, cellaSupplementare,2 );
				rigaModulo.setListaCelleModulo(listaCelle);
				listarighe.add(rigaModulo);
			}
			scriviRigheCvs(listarighe,out);				
		}
		out.close();		
		log.stopMethod(methodName);
	}

	private PrintStream  scriviRigaBianca(List<ColonneModuloModel>listaColonne, PrintStream out) throws IOException {		
		String methodName="scriviTestataModuloCvs";
		log.startMethod(methodName);		
		String separatore ="";
		out.print("\"");	
		for(ColonneModuloModel  cm:  listaColonne){
			out.print(separatore + "");
			if(StringUtils.isEmpty(separatore)) {
				separatore =SEPARATORE;
			}
		}
		out.println("\"");   
	   //Flush the output to the file
	   out.flush();		       
	   //Close the Print Writer
	   //out.close();	
	   log.stopMethod(methodName);
	   return out;
	}
	
	private PrintStream  scriviTestataModuloCvs(List<ColonneModuloModel>listaColonne, PrintStream out) throws IOException {		
		String methodName="scriviTestataModuloCvs";
		log.startMethod(methodName);
		
		String separatore ="";
		out.print("\"");	
		for(ColonneModuloModel  cm:  listaColonne){
			out.print(separatore + cm.getLabelColonna());
			if(StringUtils.isEmpty(separatore)) {
				separatore =SEPARATORE;
			}
		}
		out.println("\"");   
	   //Flush the output to the file
	   out.flush();		       
	   //Close the Print Writer
	   //out.close();	
	   log.stopMethod(methodName);
	   return out;
	}
	
	private PrintStream scriviRigheCvs(List<RigaModuloModel>listarighe, PrintStream out) throws IOException {		
		String methodName="scriviRigheCvs";
		//log.startMethod(methodName);		
		String separatore ="";
		if(CollectionUtils.isEmpty(listarighe))	{
			return out;
		}		
		for(RigaModuloModel  riga:  listarighe){
			out.print("\"");
			List<CellaModuloModel> listaCelle = riga.getListaCelleModulo();
			//log.info(methodName, "listaCelle.size " + listaCelle.size());			
			for(CellaModuloModel  cella:  listaCelle){
				out.print(separatore + cella.getValore());
				if(StringUtils.isEmpty(separatore)) {
					separatore =SEPARATORE;
				}
			}
			out.println("\"");  
			separatore ="";
		   //Flush the output to the file
		   out.flush();		       
		}		
	   //Close the Print Writer
	   //out.close();			
	   //log.stopMethod(methodName);
	   return out;
	}

	@Override
	public List<RigaModuloModel> estraiRigheDaCsv(BufferedReader br, Long idModulo,Long idUtenteCompilatore,Long idEnteCompilatoreSelezionato,String tipo) throws IOException {
		String methodName = "estraiRigheDaCsv";
		log.startMethod(methodName);		
		List<RigaModuloModel> elencoRighe = new ArrayList<RigaModuloModel>();
		String line = "";		
		PrTEntiCompilatori enteCompilatore = entiCompilatoriRepository.findOne(idEnteCompilatoreSelezionato);
		log.debug(methodName, "idEnteCompilatoreSelezionato "+ idEnteCompilatoreSelezionato);		
		String separatore ="";	
		List<PrTColonneModulo> colonne = colonneModuloRepository.findColonneByIdModulo(idModulo,Costanti.COMPILATORE.getCostante());
		log.debug(methodName, "colonne complessive : " + colonne.size());
		int posizioneRigaDB = 1;
		for (int posizioneRiga = 1; (line = br.readLine()) != null; posizioneRiga++) {
			log.debug(methodName, line);		
			// caso in cui il csv e' generato da un excelle che usa il ; anzichè la ,
			// non dovrebbe capitare perche' un csv è un csv ma mai 
			// sottovalutare l'utente e le richieste che ne derivano
			separatore = selezionaIlSeparatore(line);
			//log.info(methodName, "separatore utilizzato " + separatore);			
			String[] celledellaRiga = line.split(separatore);
			
			//			log.info(methodName, "colonne.size() " + colonne.size());
			//			log.info(methodName, "celledellaRiga " + celledellaRiga.length);
			//			log.info(methodName, "test  " + (colonne.size()==celledellaRiga.length));
			
			//if(colonne.size()==celledellaRiga.length){
			if(colonne.size()>=celledellaRiga.length && celledellaRiga.length >0){
				RigaModuloModel rigaModel = creaRiga(idModulo,
													idUtenteCompilatore,
													posizioneRigaDB,
													celledellaRiga,
													tipo);
				
				rigaModel.setIdEnteCompilatore(enteCompilatore.getIdEnteCompilatore());		
				elencoRighe.add(rigaModel);				
				posizioneRigaDB++;
			}else{
				log.warn(methodName,"CSV MAL FORMATTATO PRESENTA RIGHE VUOTE o con troppe di celle ");
				log.warn(methodName,"riga del CSV non caricata posizioneRiga  " + posizioneRiga);
			}
		} 		
		log.stopMethod(methodName);
		return elencoRighe;
	}
	
	private RigaModuloModel creaRiga(Long idModulo,
									Long idUtenteCompilatore,
									int posizioneRiga,
									String[] celledellaRiga,
									String tipo
									) {
		String methodName="creaRiga";
		log.startMethodDebug(methodName);		
		RigaModuloModel riga = new RigaModuloModel();
		riga.setDataModificaCompilatore(new Date()); 
		riga.setIdModulo(idModulo);
		riga.setIdUtenteCompilatore(idUtenteCompilatore); 
		riga.setPosizione(posizioneRiga); 
		riga.setFlgValidazione("NO");
		riga.setTipo(tipo);
		//riga.setPrTEntiCompilatori(enteCompilatore);		
		List<CellaModuloModel> listacelleriga = creaCellePerRiga(idModulo,posizioneRiga, riga, celledellaRiga ) ;
		riga.setListaCelleModulo(listacelleriga);		
		log.debug(methodName, "riga getPrTCellas: " + riga.getListaCelleModulo().size());
		log.stopMethodDebug(methodName);
		return riga;
	}

	private List<CellaModuloModel> creaCellePerRiga(Long idModulo,int posizioneRiga, RigaModuloModel riga, String[] celledellaRiga) {
		final String methodName = "creaCellePerRiga";
		log.startMethodDebug(methodName);		
		List<PrTColonneModulo> colonne = colonneModuloRepository.findColonneByIdModulo(idModulo);
		List<CellaModuloModel> elencoCelle = new ArrayList<CellaModuloModel>();
		Integer numeroCelleRiga = celledellaRiga.length;
		Integer i = 0;
		for(PrTColonneModulo colonna :colonne) {
			CellaModuloModel cella = new CellaModuloModel();	
			cella.setIdColonnaModulo(colonna.getIdColonnaModulo());
			cella.setPosizioneColonna(colonna.getPosizione());
			cella.setPosizioneRiga(posizioneRiga); 
			String cel ="";
			if(colonna.getEditabilitaProfilo().equals(Costanti.COMPILATORE.getCostante())){
				if((i+1)<=numeroCelleRiga){
					cel = celledellaRiga[i];									
					cel = cel.replaceAll("\"", "");				
				}
				cella.setValore(cel);
				cella.setEditabilitaProfilo(Costanti.COMPILATORE.getCostante());
				i++;
			}else{
				cella.setEditabilitaProfilo(Costanti.VALIDATORE.getCostante());
			}
			elencoCelle.add(cella);
		}
		log.stopMethodDebug(methodName);
		return elencoCelle;
	}
	
	@Override
	public String[]  estraiTestataDaCsv(BufferedReader br, Long idModulo,Long idUtenteCompilatore) throws IOException {
		String methodName = "estraiTestataDaCsv";
		log.startMethod(methodName);
		String[] ris = null;		
		String line = br.readLine();

		if(line!=null){
			String separatore = selezionaIlSeparatore(line);
			ris = line.split(separatore);
		}
		return ris;
	}
	
	private String selezionaIlSeparatore(String line) {
		String methodName="selezionaIlSeparatore";
		String separatore = Costanti.SEPARATORE_SEMICOLON.getCostante();
		if(line.indexOf(SEPARATORE)>=0 || line.indexOf(",")>=0){
			separatore = Costanti.SEPARATORE_COMMA.getCostante();
		}
		log.debug(methodName, "separatore " + separatore);
		return separatore;
	}

	@Override
	@Async
	public void aggiornaRigheAsync(Long idModulo,Long idEnteCompilatore,List<RigaModuloModel> listaRige) {
		String methodName="aggiornaRigheAsync";
		log.startMethod(methodName);		
		aggiornaInserisciRighe( idModulo, idEnteCompilatore,listaRige);		
		log.stopMethod(methodName);
	}
	
	@Override
	public void aggiornaInserisciRighe(Long idModulo,Long idEnteCompilatore,List<RigaModuloModel> listaRige) {
		aggiornaInserisciRighe(idModulo,idEnteCompilatore,listaRige,false);
	}
	
	@Override
	public void aggiornaInserisciRighe(Long idModulo,Long idEnteCompilatore,List<RigaModuloModel> listaRige,Boolean append) {
		String methodName="aggiornaRighe";
		log.startMethod(methodName);
		List<PrTCella> listaCelle = cellaRepository.getCelleByIdEnteIdModulo(idEnteCompilatore, idModulo);
		Integer delta = 0;
		int batchSize = 50;

		if(!append){
			batchDelete(listaCelle, cellaRepository, batchSize);
			List<PrTRighe> righeDaCancellare = righeRepository.getRigheByIdEnteIdModulo(idEnteCompilatore, idModulo);
			batchDelete(righeDaCancellare, righeRepository, batchSize);	
		}else{
			delta= righeRepository.getMaxPosRigheByIdEnteIdModulo(idEnteCompilatore, idModulo);
			if(delta==null){delta = 0;}			
		}
		
		PrTEntiCompilatori prTEntiCompilatori = entiCompilatoriRepository.findOne(idEnteCompilatore);
		for(RigaModuloModel riga: listaRige ){			
			PrTRighe entity = mapper.map(riga, PrTRighe.class);			
			entity.setPrTEntiCompilatori(prTEntiCompilatori);
			entity.setDataModificaCompilatore(new Date());
			entity.setDataAgg(new Date());			
			
			entity.setPosizione(riga.getPosizione()+delta);
			righeRepository.save(entity);
			righeRepository.flush();			
			List<PrTCella> prTCellas = new ArrayList<PrTCella>();
			for(CellaModuloModel cella : riga.getListaCelleModulo()) {		
				PrTCella prTCella = mapper.map(cella, PrTCella.class);			
				PrTCellaPK id = new PrTCellaPK();
				id.setPrTRighe(entity);
				PrTColonneModulo prTColonneModulo = new PrTColonneModulo();
				prTColonneModulo.setIdColonnaModulo(cella.getIdColonnaModulo());
				id.setPrTColonneModulo(prTColonneModulo );
				prTCella.setId(id);
				prTCellas.add(prTCella);
			}

			for(PrTCella cella :prTCellas){	
				cella.setPrTRighe(entity);
				cellaRepository.saveAndFlush(cella);
			}
			
		}
		log.stopMethod(methodName);
	}

	private <T> void batchDelete(List<T> list, JpaRepository<T, ? extends Serializable> repository, int batchSize) {
		final String methodName = "batchDelete";
		int size = list.size();		
		for(int i = 0; i * batchSize < size; i++) {
			List<T> subList = new ArrayList<T>();
			int j;
			for(j = 0; j < batchSize && j < size - i * batchSize; j++) {
				subList.add(list.get(i * batchSize + j));
			}
			log.info(methodName, "Cancellazione righe 1-" + j + " del blocco " + (i + 1) + " (total rows: " + subList.size() + ")");
			repository.deleteInBatch(subList);
		}
	}

	@Override
	@Async
	//public Future<List<RigaModuloModel>> parserFileAndInsert(MultipartFile file,Long idEnteComp, Long idUteComp, Long idModulo,Model model) throws IOException {
	public void parserFileAndInsert(MultipartFile file,Long idEnteComp, Long idUteComp, Long idModulo,Model model,boolean eliminaPrimaRiga) throws IOException {
		InputStream inputStream       = null;
    	BufferedReader bufferedReader = null;
		List<RigaModuloModel> listaRigeDaCsv;
		try {
			inputStream = file.getInputStream();
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			listaRigeDaCsv = estraiRigheDaCsv(bufferedReader,idModulo,idUteComp,idEnteComp,Costanti.TIPO_MODULO_COMUNICAZIONE.getCostante());
			//rimuovo l'intestazione
			if(eliminaPrimaRiga){
				listaRigeDaCsv.remove(0);
			}			
			aggiornaInserisciRighe(idModulo,idEnteComp,listaRigeDaCsv);
		} finally {
			if(bufferedReader != null) {
				bufferedReader.close();
			}
			if(inputStream != null) {
				inputStream.close();
			}
		}
		  //return new AsyncResult<List<RigaModuloModel>>(listaRigeDaCsv);
	}
	
	@Override
	public List<String> validazioneFile(MultipartFile file) {
		String methodName="validazioneFile";
		log.startMethod(methodName);		
		List<String> ris = new ArrayList<String>();		
		String nomeFile = file.getOriginalFilename();
		String tipoFile = file.getContentType();
		log.debug(methodName, "nomeFile "+nomeFile);
		log.info(methodName, "tipoFile "+tipoFile);
		//controllo estensioneFile
		if(nomeFile.indexOf(".csv")<0){
			ris.add(CostantiERR.ERR_ESTENSIONE_NON_CSV.getCostante());
		}

//		if(!tipoFile.equals(Costanti.TIPO_FILE_CSV.getCostante())){
//			ris.add(CostantiERR.ERR_TIPOLOGIA_CSV.getCostante());
//		}

//		if(tipoFile.toLowerCase().indexOf(Costanti.EXT_CSV.getCostante())<0){
//			ris.add(CostantiERR.ERR_TIPOLOGIA_CSV.getCostante());
//		}		
		if(file.isEmpty()){
			ris.add(CostantiERR.ERR_FILE_VUOTO.getCostante());
		}		
		log.stopMethod(methodName);
		return ris;
	}

	@Override
	public void aggiornaInserisciRiga(Long idModulo, Long idEnteCompilatore, RigaModuloModel riga) {
		String methodName="inserisciRiga";
		log.startMethod(methodName);
		PrTEntiCompilatori prTEntiCompilatori = entiCompilatoriRepository.findOne(idEnteCompilatore);
		PrTRighe entity = mapper.map(riga, PrTRighe.class);			
		entity.setPrTEntiCompilatori(prTEntiCompilatori);
		entity.setDataModificaCompilatore(new Date());
		entity.setDataAgg(new Date());
		righeRepository.save(entity);
		righeRepository.flush();
		List<PrTCella> prTCellas = new ArrayList<PrTCella>();
		for(CellaModuloModel cella : riga.getListaCelleModulo()) {		
			PrTCella prTCella = mapper.map(cella, PrTCella.class);			
			PrTCellaPK id = new PrTCellaPK();
			id.setPrTRighe(entity);
			PrTColonneModulo prTColonneModulo = new PrTColonneModulo();
			prTColonneModulo.setIdColonnaModulo(cella.getIdColonnaModulo());
			id.setPrTColonneModulo(prTColonneModulo );
			prTCella.setId(id);
			prTCellas.add(prTCella);
		}
		for(PrTCella cella :prTCellas){	
			cella.setPrTRighe(entity);
			cellaRepository.saveAndFlush(cella);
		}		
		log.stopMethod(methodName);		
	}

	@Override
	public int contaRigheCsvDiModuliAggregati(String listaIdModuli) throws IOException {
		String methodName="contaRigheCsvDiModuliAggregati"; 
		log.startMethod(methodName);
		String[] sListaId = listaIdModuli.split(",");					
		int ris = getNumRigheByListaIdModulo(new Utility().conversioneLista(sListaId));
		return ris;
	}
	
	@Override
	public void creaCsvDiModuliAggregati(String listaIdModuli,OutputStream outputStream) throws IOException {
		String methodName="creaCsvDiModuliAggregati"; 
		log.startMethod(methodName);
		Long idModuloSel;
		String[] sListaId = listaIdModuli.split(",");					
		PrintStream out = new PrintStream(outputStream);
		boolean primaRiga = true;
		for(String id : sListaId){
			idModuloSel = Long.parseLong(id);				
			// estraggo il modulo selezionato
			log.debug(methodName, "idModuloSel " + idModuloSel);
			PrTModuli prTModuli = moduliRepository.findOne(idModuloSel);				
			// estraggo la lista degli enti compilatori che lo hanno utilizzato
			List<PrTEntiCompilatori> listaEntiCompilatori = entiCompilatoriRepository.getListabyIdModulo(idModuloSel);
			//estraggo le colonne
			List<PrTColonneModulo> colonne = prTModuli.getPrTColonneModulos();
			List<ColonneModuloModel> listaColonne = mapAll(colonne,ColonneModuloModel.class);						
			//aggiungo le colonne 
			List<ColonneModuloModel> listaColonneArricchita = listaColonne;			
			//aggiungo la colonna in posizione 0
			ColonneModuloModel colonneModuloModel = new ColonneModuloModel();
			colonneModuloModel.setLabelColonna("Ente Compilatore");
			colonneModuloModel.setPosizione(0);
			colonneModuloModel.setEditabilitaProfilo(Costanti.NON_EDITABILE.getCostante());
			listaColonneArricchita = Utility.addElementoAllaLista(listaColonneArricchita, colonneModuloModel,0 );			
			//aggiungo la colonna in posizione 1
			colonneModuloModel = new ColonneModuloModel();
			colonneModuloModel.setLabelColonna(Costanti.COD_FIS_ENTE.getCostante());
			colonneModuloModel.setPosizione(1);
			colonneModuloModel.setEditabilitaProfilo(Costanti.NON_EDITABILE.getCostante());
			listaColonneArricchita = Utility.addElementoAllaLista(listaColonneArricchita, colonneModuloModel,1 );	
			//aggiungo la colonna in posizione 2
			colonneModuloModel = new ColonneModuloModel();
			colonneModuloModel.setLabelColonna("Partita Iva Ente");
			colonneModuloModel.setPosizione(2);
			colonneModuloModel.setEditabilitaProfilo(Costanti.NON_EDITABILE.getCostante());
			listaColonneArricchita = Utility.addElementoAllaLista(listaColonneArricchita, colonneModuloModel,2 );			
			// scrivo la testata
			if(!primaRiga){
				out = scriviRigaBianca(listaColonneArricchita,out);	
			}
			primaRiga = false;			
			out = scriviTestataModuloCvs(listaColonneArricchita,out);				
			for(PrTEntiCompilatori sel: listaEntiCompilatori ){
				//estraggo le righe
				List<PrTRighe> righe= righeRepository.getRigheByIdEnteIdModulo(sel.getIdEnteCompilatore(),idModuloSel);
				List<RigaModuloModel> listarighe = new ArrayList<RigaModuloModel>();
				CellaModuloModel cellaSupplementare;
				for(PrTRighe prTRiga : righe){
					RigaModuloModel rigaModulo = mapper.map(prTRiga,RigaModuloModel.class)	;
					List<CellaModuloModel> listaCelle = mapAll(prTRiga.getPrTCellas(),CellaModuloModel.class);
					// aggiungo una cella in posizione 0 
					cellaSupplementare = new CellaModuloModel();
					cellaSupplementare.setIdColonnaModulo(Long.valueOf(0));
					cellaSupplementare.setIdRiga(Long.valueOf(0));
					cellaSupplementare.setPosizioneColonna(0);
					cellaSupplementare.setPosizioneRiga(prTRiga.getPosizione());
					cellaSupplementare.setValore(sel.getRagioneSociale());
					listaCelle = Utility.addElementoAllaLista(listaCelle, cellaSupplementare,0 );	
					// aggiungo una cella in posizione 1 
					cellaSupplementare = new CellaModuloModel();
					cellaSupplementare.setIdColonnaModulo(Long.valueOf(0));
					cellaSupplementare.setIdRiga(Long.valueOf(0));
					cellaSupplementare.setPosizioneColonna(1);
					cellaSupplementare.setPosizioneRiga(prTRiga.getPosizione());
					cellaSupplementare.setValore(sel.getCodiceFiscale());
					listaCelle = Utility.addElementoAllaLista(listaCelle, cellaSupplementare,1 );	
					// aggiungo una cella in posizione 2 
					cellaSupplementare = new CellaModuloModel();
					cellaSupplementare.setIdColonnaModulo(Long.valueOf(0));
					cellaSupplementare.setIdRiga(Long.valueOf(0));
					cellaSupplementare.setPosizioneColonna(2);
					cellaSupplementare.setPosizioneRiga(prTRiga.getPosizione());
					cellaSupplementare.setValore(sel.getPartitaIva());
					listaCelle = Utility.addElementoAllaLista(listaCelle, cellaSupplementare,2 );	
					rigaModulo.setListaCelleModulo(listaCelle);
					listarighe.add(rigaModulo);
				}
				scriviRigheCvs(listarighe,out);				
			}
		}		
		out.close();
		log.stopMethod(methodName);
	}

	private int getNumRigheByListaIdModulo(List<Long> listIdModulo) {
		String methodName="getNumRigheByListaIdModulo";
		log.startMethod(methodName); 		
		List<PrTRighe> listaPrTRighe = righeRepository.getRigheByListaIdModulo(listIdModulo);
		log.stopMethod(methodName); 
		return listaPrTRighe.size();
	}	
}
