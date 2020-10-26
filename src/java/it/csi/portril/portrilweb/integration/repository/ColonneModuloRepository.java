/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.repository;

import it.csi.portril.portrilweb.integration.entity.PrTColonneModulo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ColonneModuloRepository extends
		JpaRepository<PrTColonneModulo, Long> {

	/**
	 * 
	 * @param idModulo
	 * @return
	 */
	@Query(" FROM PrTColonneModulo cm WHERE cm.prTModuli.idModulo = :idModulo ORDER BY cm.posizione")
	List<PrTColonneModulo> findColonneByIdModulo(
			@Param("idModulo") Long idModulo);
	
	/**
	 * 
	 * @param idModulo
	 * @param editabilitaProfilo
	 * @return
	 */
	@Query(" FROM PrTColonneModulo cm WHERE cm.prTModuli.idModulo = :idModulo AND editabilitaProfilo = :editabilitaProfilo ORDER BY cm.posizione")
	List<PrTColonneModulo> findColonneByIdModulo(
			@Param("idModulo") Long idModulo,
			@Param("editabilitaProfilo") String editabilitaProfilo
			);


}