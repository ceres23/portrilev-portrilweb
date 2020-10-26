/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business.interfaces;

import it.csi.portril.portrilweb.model.ColonneModuloModel;
import it.csi.portril.portrilweb.model.EntiCompilatoriModel;
import it.csi.portril.portrilweb.model.ModuliModel;
import it.csi.portril.portrilweb.model.RigaModuloModel;
import it.csi.portril.portrilweb.model.ValidaRigheModuliModel;
import it.csi.portril.portrilweb.util.paginazione.ListaPaginata;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.validation.annotation.Validated;
//import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author 71027
 * 
 */

@Validated
public interface BusinessGestioneModuli {
	/**
	 * 
	 * @param nome
	 * @param stato
	 * @return
	 */
	List<ModuliModel> ricercaModuli(String nome, String stato,String tipo,Long idEnteGestore,String codiceGruppo);

	/**
	 * 
	 * @param idModuloSelezionato
	 * @return
	 */
	ModuliModel getModuloForId(Long idModuloSelezionato);

	/**
	 * 
	 * @param moduliModel
	 * @return
	 * @throws IOException 
	 */
	ModuliModel insDefinModuli(ModuliModel moduliModel) throws IOException;

	/**
	 * 
	 * @param listaIdRigaValidanti
	 * @param listaIdRigaInValidanti
	 */
	void validaRighe(List<Long> listaIdRigaValidanti,List<Long> listaIdRigaInValidanti);

	/**
	 * 
	 * @param listaRigheVisibili
	 */
	void modificaValoriCelle(List<List<String>> listaRigheVisibili);

	/**
	 * 
	 * @param idModulo
	 * @return
	 */
	List<ColonneModuloModel> getColonneByIdModulo(Long idModulo,String editabilitaProfilo);

	/**
	 * 
	 * @param idModulo
	 * @return
	 */
	List<ColonneModuloModel> getColonneByIdModulo(Long idModulo);

	/**
	 * 
	 * @param idModulo
	 * @param idEnteCompilatore
	 * @return
	 */
	//
	List<RigaModuloModel> getRigheByIdModuloIdEnteCompilatore(Long idModulo,Long idEnteCompilatore,String editabilitaProfilo);

	/**
	 * 
	 * @param idModulo
	 * @param idEnteCompilatore
	 * @param listFiltri
	 * @param editabilitaProfilo
	 * @param numPagina
	 * @param lenPagina
	 * @return
	 */
	ListaPaginata<RigaModuloModel> getRigheByIdModuloIdEnteCompilatorePaginato(Long idModulo,Long idEnteCompilatore,String editabilitaProfilo,List<String> listFiltri,Integer numPagina,Integer lenPagina);

	/**
	 * 
	 * @param idModulo
	 * @param idEnteCompilatore
	 * @return
	 */
	List<RigaModuloModel> getRigheByIdModuloIdEnteCompilatore(Long idModulo,Long idEnteCompilatore);

	/**
	 * 
	 * @param validaModulStep1Model
	 * @return
	 */
	List<RigaModuloModel> getRigheByModuloEnti(ValidaRigheModuliModel validaModulStep1Model);

	/**
	 * 
	 * @param modulo
	 */
	void salvaModuloEColonne(ModuliModel modulo);

	/**
	 * 
	 * @param idModuloSel
	 * @return
	 */
	String eliminaModulo(Long idModuloSel);

	/**
	 * 
	 * @param moduliModel
	 * @throws IOException 
	 */
	void modificaModuli(ModuliModel moduliModel) throws IOException;

	/**
	 * 
	 * @param idModulo
	 * @param attribute
	 */
	void setListaEntiFromModulo(Long idModulo,List<EntiCompilatoriModel> attribute);

	/**
	 * 
	 * @param idModulo
	 * @param attribute
	 */
	void addListaEntiFromModulo(Long idModulo,List<EntiCompilatoriModel> attribute);

	/**
	 * 
	 * @param idModuloSel
	 * @param mittente
	 * @param oggMailModulo
	 * @param descMailModulo
	 * @param idEnteGest
	 * @param tutti
	 * @throws MessagingException
	 */
	void invioMailInvito(Long idModuloSel, Long idUtenteGestore,String mittente,String oggMailModulo, String descMailModulo, Long idEnteGest,boolean tutti) throws MessagingException;

	/**
	 * 
	 * @param listaId
	 * @return
	 */
	List<EntiCompilatoriModel> getEntiCompilatoriForListId(List<Long> listaId);

	/**
	 * 
	 * @param idModulo
	 * @return
	 */
	boolean isStrutturaModuloModificabile(Long idModulo);

	/**
	 * 
	 * @param nome
	 * @param stato
	 * @return
	 */
	ModuliModel xstModulo(String nome, String stato,String tipo);

	/**
	 * 
	 * @param idModuloSelezionato
	 * @return 
	 */
	List<RigaModuloModel> getRigheByIdModulo(Long idModulo);

	/**
	 * 
	 * @param idModulo
	 * @param codicefiscale
	 * @return
	 */
	List<RigaModuloModel> getRigheByIdModuloCFCompilatore(Long idModulo,String codicefiscale,String ragioneSocialeEnte);

	/**
	 * 
	 * @param idModulo
	 * @param listaEntiCompilatoriAssociati
	 * @param moduloConfermato
	 */
	void settaListaConfermeFromModulo(Long idModulo,List<EntiCompilatoriModel> listaEntiCompilatoriAssociati,String moduloConfermato);
	
	/**
	 * 
	 * @param idModulo
	 * @param listaEntiCompilatoriAssociati
	 * @param moduloValidato
	 */
	void settaListaValidazioniFromModulo(Long idModulo,List<EntiCompilatoriModel> listaEntiCompilatoriAssociati,String moduloValidato);

	/**
	 * 
	 * @param idModulo
	 * @param idEnteCompilatore
	 * @return
	 */
	String presenteModuloConfermato(Long idModulo,Long idEnteCompilatore);
	

	/**
	 * 
	 * @param idModuloSel
	 * @param idEnteCompilatore
	 * @param moduloConfermato
	 */
	void settaConfermaModuloCompilatore(Long idModuloSel, Long idEnteCompilatore,String moduloConfermato);
	
	/**
	 * 
	 * @param idModuloSel
	 * @param idEnteCompilatore
	 * @param moduloValidato
	 */
	void settaValidaModuloCompilatore(Long idModuloSel, Long idEnteCompilatore,String moduloValidato);
	
	/**
	 * 
	 * @param idModuloSel
	 * @param listaEntiId
	 * @param moduloConfermato
	 */
	void settaConfermaListaModuloCompilatore(Long idModuloSel,List<Long> listaEntiId, String moduloConfermato);

	/**
	 * 
	 * @param idModuloSel
	 * @param listaEntiId
	 * @param moduloValidato
	 */
	void settaValidaListaModuloCompilatore(Long idModuloSel,List<Long> listaEntiId, String moduloValidato);

	/**
	 * 
	 * @param idModuloSel
	 * @param idUtenteGestore
	 * @param mittente
	 * @param oggMailModulo
	 * @param descMailModulo
	 * @param idEnteGest
	 * @param gruppoSollecito
	 * @throws MessagingException
	 */
	void invioMailSollecito(Long idModuloSel,
							Long idUtenteGestore,
							String mittente,
							String oggMailModulo,
							String descMailModulo,
							String gruppoSollecito) throws MessagingException;

}
