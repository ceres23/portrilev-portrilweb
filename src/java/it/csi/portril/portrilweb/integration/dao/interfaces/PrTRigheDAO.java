/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.interfaces;

import it.csi.portril.portrilweb.integration.entity.PrTRighe;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface  PrTRigheDAO {

	/**
	 * 
	 * @param entity
	 * @return PrTRighe
	 */
	PrTRighe create(PrTRighe entity);
	
	/**
	 * 
	 * @param entity
	 * @return PrTRighe
	 */
	PrTRighe update(PrTRighe entity);
	
	/**
	 * 
	 * @param entity
	 * @return void
	 */
	void     delete(PrTRighe entity);
	
	/**
	 * 
	 * @param entity
	 * @return void
	 */
	//void     delete(List<PrTRighe> listEntity);


	/**
	 * 
	 * @param idModulo
	 * @param idEnteCompilatore
	 */
	void deleteRighe(List<PrTRighe> lista);

	/**
	 * 
	 * @param idEnteCompilatore
	 * @param idModuloSel
	 * @param provvedimento
	 * @return
	 */
	List<PrTRighe> getRigheByIdEnteIdModuloProvvedimento(Long idEnteCompilatore,
														Long idModulo,
														String provvedimento,
														String tipo);
	/**
	 * 
	 * @param idEnteCompilatore
	 * @param idModulo
	 * @param pageable
	 * @return
	 */
	Page<PrTRighe> getRigheByIdEnteIdModuloPaginato(Long idEnteCompilatore,Long idModulo,List<String> listFiltri,Pageable pageable);

	/**
	 * 
	 * @param listaIdRiga
	 * @return
	 */
	List<PrTRighe> getRigheBylistaIdRiga (List<Long> listaIdRiga);
	
}
