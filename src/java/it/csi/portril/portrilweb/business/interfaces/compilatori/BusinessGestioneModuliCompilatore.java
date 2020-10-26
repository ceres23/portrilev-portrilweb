/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business.interfaces.compilatori;

import it.csi.portril.portrilweb.dto.MsgAllert;
import it.csi.portril.portrilweb.model.CellaModuloModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.model.exception.ControlloFormaleException;

import java.util.List;

import org.springframework.validation.annotation.Validated;

/**
 * 
 * @author 71027
 *
 */

@Validated
public interface BusinessGestioneModuliCompilatore {
	/**
	 * 
	 * @param idEnteCompilatoreSelezionato
	 * @param nome
	 * @return
	 */
	List<ModuliModel> getModuliByEnteCompilatore(Long idEnteCompilatoreSelezionato,String nome,String statoModulo,String tipo);

	/**
	 * 
	 * @param br
	 * @param idModulo
	 * @param idUtenteCompilatore
	 * @return
	 * @throws IOException
	 */
	//List<RigaModuloModel> estraiRigheDaCsv(BufferedReader br, Long idModulo,Long idUtenteCompilatore,Long idEnteCompilatoreSelezionato,String tipo) throws IOException;

	/**
	 * 
	 * @param griglia
	 * @param idModulo
	 * @param idUtenteCompilatore
	 * @param idEnteCompilatoreSelezionato
	 * @return
	 */
	List<RigaModuloModel> estraiRigheDaGriglia(List<List<String>> griglia,
			Long idModulo, Long idUtenteCompilatore,
			Long idEnteCompilatoreSelezionato,String tipo) ;

	/**
	 * 
	 * @param griglia
	 * @param idModulo
	 * @param idUtenteCompilatore
	 * @param idEnteCompilatoreSelezionato
	 * @param editabilitaProfilo
	 * @param tipo
	 * @return
	 */
	List<RigaModuloModel> estraiRigheDaGriglia(List<List<String>> griglia,
			Long idModulo, Long idUtenteCompilatore,
			Long idEnteCompilatoreSelezionato, String editabilitaProfilo,String tipo);
	
	/**
	 * 
	 * @param br
	 * @param idModulo
	 * @param idUtenteCompilatore
	 * @return
	 * @throws IOException
	 */
	//String[] estraiTestataDaCsv(BufferedReader br, Long idModulo,Long idUtenteCompilatore) throws IOException;

	
	/**
	 * 
	 * @param file
	 * @param idModuloSel
	 * @return
	 */
	//List<String> validazioneFile(MultipartFile file);

	/**
	 * 
	 * @param idModulo
	 * @param listaColonne
	 * @param list
	 * @return
	 * @throws NoSuchMethodException 
	 */
	List<MsgAllert> controlloFormaleRiga(Long idModulo,RigaModuloModel riga) throws ControlloFormaleException;
	
	/**
	 * 
	 * @param idModulo
	 * @param listaColonne
	 * @param list
	 * @return
	 * @throws NoSuchMethodException 
	 */
	List<MsgAllert> controlloFormaleRighe(Long idModulo,Integer numColonne,List<RigaModuloModel> listaRige) throws ControlloFormaleException;
	/**
	 * 
	 * @param idModulo
	 * @param idEnteCompilatore
	 * @param listaRige
	 */
	//void aggiornaRighe(Long idModulo,Long idEnteCompilatore,List<RigaModuloModel> listaRige);

	/**
	 * 
	 * @param idEnteGestore
	 * @param nome
	 * @return
	 */
	List<ModuliModel> getModulixComunicazione(Long idEnteGestore, String nome);

	/**
	 * 
	 * @param nome
	 * @param stato
	 * @param tipo
	 * @param valoreCella
	 * @param posizioneColonna
	 * @param posizioneRiga
	 * @return
	 */
	List<ModuliModel> getModuliByValoreCellaContenuta(String nome,
			String stato, String tipo, String valoreCella,
			Integer posizioneColonna, Integer posizioneRiga);

	void cancellaRigheSelezionate(String[] listaIdDaEliminare );

	/**
	 * 
	 * @param idRiga
	 * @return
	 */
	List<CellaModuloModel> estraiCelleByIdRiga(Long idRiga);

	/**
	 * 
	 * @param idRiga
	 * @return
	 */
	RigaModuloModel getRigByIdRiga(Long idRiga);
	
	/**
	 * 
	 * @param idModuloSel
	 * @param idEnteCompilatore
	 * @return
	 */
	Integer getMaxPosizioneRigaByIdModuloIdEnteCompilatore(Long idModuloSel,Long idEnteCompilatore);


}
