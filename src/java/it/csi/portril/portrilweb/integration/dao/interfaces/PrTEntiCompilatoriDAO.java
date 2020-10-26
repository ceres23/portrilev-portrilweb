/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.interfaces;

import it.csi.portril.portrilweb.integration.entity.PrTConfermeModuli;
import it.csi.portril.portrilweb.integration.entity.PrTEntiCompilatori;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface PrTEntiCompilatoriDAO {

	/**
	 * 
	 * @param PrTEntiCompilatori
	 * @return PrTEntiCompilatori
	 */
	PrTEntiCompilatori 			create(PrTEntiCompilatori entity);
	/**
	 * 
	 * @param PrTEntiCompilatori
	 * @return PrTEntiCompilatori
	 */
	PrTEntiCompilatori 			update(PrTEntiCompilatori entity);
	/**
	 * 
	 * @param PrTEntiCompilatori
	 * @return void
	 */
	void               			delete(PrTEntiCompilatori entity);

	/**
	 * 
	 * @param idEnteGestore
	 * @param ragioneSociale
	 * @param comune
	 * @param provincia
	 * @param codiceFiscale
	 * @param partitaIva
	 * @return List<PrTEntiCompilatori>
	 */
	List<PrTEntiCompilatori> getCompilatori(
											Long   idEnteGestore,
											String ragioneSociale,
											String classificazione,
											String comune,
											String provincia,
											String codiceFiscale,
											String partitaIva,
											String stato,
											String associazione,
											Long idModulo);
	
	/**
	 * 
	 * @param idModulo
	 * @param idEnteGestore
	 * @param ragioneSociale
	 * @param comune
	 * @param provincia
	 * @param codiceFiscale
	 * @param partitaIva
	 * @param provvedimento
	 * @return List<PrTEntiCompilatori>
	 */

	List<PrTEntiCompilatori> getCompilatoriByIdModulo(
			Long   idModulo,
			Long   idEnteGestore,
			String ragioneSociale,
			String classificazione,
			String comune,
			String provincia,
			String codiceFiscale,
			String partitaIva,
			String provvedimento
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

	List<PrTEntiCompilatori> getEntiCompilatoriByIdEnteGestore(String stato, String ragioneSociale,
			String classificazione, String comune, String codiceFiscale,
			String partitaIva, Long idEnteGestore);
	
	/**
	 * 
	 * @param idModuloSel
	 * @param stato
	 * @return
	 */
	List<PrTEntiCompilatori> getEntiCompilatoriByIdModuloSelAndStato(
			Long idModuloSel, String stato);
	
	/**
	 * 
	 * @param idModulo
	 * @param confermatoSiNo
	 * @return
	 */
	List<PrTEntiCompilatori> getListaEntiCompilatoriConModuloConfermato(Long idModulo,String confermatoSiNo);
	
	/**
	 * 
	 * @param idModulo
	 * @param confermatoSiNo
	 * @return
	 */
	public List<PrTConfermeModuli> getListaConfermeEntiCompilatoriConModuloConfermato(Long idModulo,String statoConferma);
	
}