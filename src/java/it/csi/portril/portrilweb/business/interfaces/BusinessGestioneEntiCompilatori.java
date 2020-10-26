/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business.interfaces;

import it.csi.portril.portrilweb.model.EntiCompilatoriModel;

import java.util.List;

import org.springframework.validation.annotation.Validated;

/**
 * 
 * @author 71027
 * 
 */

@Validated
public interface BusinessGestioneEntiCompilatori {
	/**
	 * 
	 * @param idEnteSel
	 * @return
	 */
	EntiCompilatoriModel getEntiCompilatoriById(Long idEnteSel);

	/**
	 * 
	 * @param idModuloSel
	 * @return
	 */
	List<EntiCompilatoriModel> getListaEntiCompilatoribyIdModulo(Long idModuloSel);

	/**
	 * 
	 * @param stato
	 * @param ragioneSociale
	 * @param classificazione
	 * @param comune
	 * @param codiceFiscale
	 * @param partitaIva
	 * @return
	 */
	List<EntiCompilatoriModel> getEntiCompilatori(
													String stato,
													String ragioneSociale,
													String classificazione,
													String comune,
													String codiceFiscale, 
													String partitaIva
													);
	/**
	 * 
	 * @param stato
	 * @param ragioneSociale
	 * @param classificazione
	 * @param comune
	 * @param codiceFiscale
	 * @param partitaIva
	 * @param idEnteGestore
	 * @return
	 */
	List<EntiCompilatoriModel> getEntiCompilatoriByIdEnteGestore(
			String stato,
			String ragioneSociale,
			String classificazione,
			String comune,
			String codiceFiscale, 
			String partitaIva,
			Long idEnteGestore
			);
	

	/**
	 * 
	 * @param idEnteGestore
	 * @param ragioneSociale
	 * @param comune
	 * @param partitaIva
	 * @param codiceFiscale
	 * @param provincia
	 * @param idModulo
	 * @param stato
	 * @param associazione
	 * @return
	 */
	List<EntiCompilatoriModel> ricercaEntiCompilatoriRelazionatiAiModuli(
																			Long idEnteGestore,
																			String ragioneSociale,
																			String classificazione,
																			String comune, 
																			String provincia, 
																			//String istat,
																			String codiceFiscale,
																			String partitaIva, 
																			Long idModulo,
																			String stato,
																			String associazione);

	/**
	 * 
	 * @param idEnteGestore
	 * @param ragioneSociale
	 * @param comune
	 * @param provincia
	 * @param codiceFiscale
	 * @param partitaIva
	 * @param stato
	 * @return
	 */
	List<EntiCompilatoriModel> ricercaEntiCompilatori(
														Long idEnteGestore,
														String ragioneSociale,
														String classificazione,
														String comune, 
														String provincia,
														//String istat,
														String codiceFiscale,
														String partitaIva, 
														String stato,
														String associazione);

	/**
	 * 
	 * @param entiCompilatoriModel
	 * @return
	 */
	EntiCompilatoriModel insEnteCompilatore(EntiCompilatoriModel entiCompilatoriModel,List<Long> listaIdEnteGestore);

	/**
	 * 
	 * @param idEnteSel
	 * @return
	 */
	String disattivaAttivaEnteCompilatore(Long idEnteSel);

	/**
	 * 
	 * @param idEnteSel
	 */
	void eliminaEnteCompilatore(Long idEnteSel);

	/**
	 * 
	 * @param entiCompilatoriModel
	 * @return
	 */
	EntiCompilatoriModel modificaEnteCompilatore(EntiCompilatoriModel entiCompilatoriModel);

	/**
	 * 
	 * @param idModuloSel
	 * @param stato
	 * @return
	 */
	List<EntiCompilatoriModel> getListaEntiCompilatoriByIdModuloSel(Long idModuloSel, String stato);

	/**
	 * 
	 * @param idEnteGestore
	 * @return
	 */
	EntiCompilatoriModel getEnteCompilatoreFittizioByIdEnteGestore(Long idEnteGestore);

	/**
	 * 
	 * @param idModuloSel
	 * @return
	 */
	List<EntiCompilatoriModel> getListaEntiCompilatoriConModuloConfermato(Long idModuloSel,String statoConferma);

	/**
	 * 
	 * @param idModuloSel
	 * @return
	 */
	List<EntiCompilatoriModel> getListaEntiCompilatoriConModuloValidato(Long idModuloSel,String confermatoSiNo);

	/**
	 * 
	 * @param idEnteGestore
	 * @param idEnteCompilatore
	 * @return
	 */
	boolean xstAssociazioneEnteGestoreCompilatore(Long idEnteCompilatore,Long idEnteGestore);

}
