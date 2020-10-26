/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.repository;

import it.csi.portril.portrilweb.integration.entity.PrTConfermeModuli;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConfermeModuliRepository extends JpaRepository<PrTConfermeModuli, Long> {

	/**
	 * @param idEnteCompilatore
	 * @param idModulo
	 * @return
	 */
	@Query("FROM PrTConfermeModuli  WHERE prTModuli.idModulo= :idModulo  AND prTEntiCompilatori.idEnteCompilatore = :idEnteCompilatore")	
	public PrTConfermeModuli getConfermeModuliByIdEnteIdModulo(
			@Param("idEnteCompilatore") Long idEnteCompilatore,
			@Param("idModulo") Long idModulo);


	
}
