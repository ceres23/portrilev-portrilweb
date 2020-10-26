/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business.interfaces;

import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author 71027
 * 
 */

@Validated
public interface BusinessGestioneReport {
	/**
	 * 
	 * @param idModuloSel
	 * @param outputStream
	 * @throws IOException
	 */
	void creaTestataByModulo(Long idModuloSel, OutputStream outputStream)throws IOException;

	/**
	 * 
	 * @param idModuloSel
	 * @param outputStream
	 * @throws IOException
	 */
	void creaRiepilogoDatiByModulo(Long idModuloSel, OutputStream outputStream)throws IOException;

	/**
	 * 
	 * @param idModuloSel
	 * @param outputStream
	 * @throws IOException
	 */
	void creaCsvDiModuliAggregati(String listaIdModuli, OutputStream outputStream)throws IOException;

	/**
	 * genera il csv (righe e colonne) senza le colonne aggiunte
	 * @param listaRighe
	 * @param listaColonne
	 * @param outputStream
	 * @throws IOException
	 */
	void generaCsV(List<RigaModuloModel> listaRighe,List<ColonneModuloModel> listaColonne,ServletOutputStream outputStream) throws IOException;

	/**
	 * 
	 * @param outputStream
	 * @param idModulo
	 * @param idEnteCompilatore
	 * @throws IOException
	 */
	void generaCsV(ServletOutputStream outputStream,Long idModulo , Long idEnteCompilatore)  throws IOException;

	/**
	 * 
	 * @param outputStream
	 * @param idModulo
	 * @param idEnteCompilatore
	 * @throws IOException
	 */
	// TODO gestione con qualche problema 
	//void generaCsVAsync(ServletOutputStream outputStream, Long idModulo,Long idEnteCompilatore) throws IOException;

	/**
	 * 
	 * @param br
	 * @param idModulo
	 * @param idUtenteCompilatore
	 * @return
	 * @throws IOException
	 */
	List<RigaModuloModel> estraiRigheDaCsv(BufferedReader br, Long idModulo,Long idUtenteCompilatore,Long idEnteCompilatoreSelezionato,String tipo) throws IOException;
	
	/**
	 * 
	 * @param br
	 * @param idModulo
	 * @param idUtenteCompilatore
	 * @return
	 * @throws IOException
	 */
	String[] estraiTestataDaCsv(BufferedReader br, Long idModulo,Long idUtenteCompilatore) throws IOException;

	
	/**
	 * 
	 * @param file
	 * @param idModuloSel
	 * @return
	 */
	List<String> validazioneFile(MultipartFile file);

	/**
	 * 
	 * @param idModulo
	 * @param idEnteCompilatore
	 * @param listaRige
	 */
	void aggiornaInserisciRighe(Long idModulo,Long idEnteCompilatore,List<RigaModuloModel> listaRige);

	/**
	 * 
	 * @param idEnteCompilatore
	 * @param riga
	 */
	void aggiornaInserisciRiga(Long idModulo,Long idEnteCompilatore, RigaModuloModel  riga);
	
	/**
	 * 
	 * @param idModulo
	 * @param idEnteCompilatore
	 * @param listaRige
	 * @param append
	 */
	void aggiornaInserisciRighe(Long idModulo,Long idEnteCompilatore,List<RigaModuloModel> listaRige,Boolean append);
	
	/**
	 * 
	 * @param idModulo
	 * @param idEnteCompilatore
	 * @param listaRige
	 */
	void aggiornaRigheAsync(Long idModulo, Long idEnteCompilatore,List<RigaModuloModel> listaRige);
	
	/**
	 * 
	 * @param file
	 * @param idEnteComp
	 * @param idUteComp
	 * @param idModulo
	 * @param model
	 * @param eliminaPrimaRiga serve per eliminare la prima riga es non voglio salvare le intestazioni  
	 * @return
	 * @throws IOException
	 */
	void parserFileAndInsert(MultipartFile file,
			Long idEnteComp, Long idUteComp, Long idModulo, Model model,boolean eliminaPrimaRiga)
			throws IOException;

	/**
	 * 
	 * @param listaIdModuli
	 * @return
	 * @throws IOException
	 */
	int contaRigheCsvDiModuliAggregati(String listaIdModuli) throws IOException;

}
