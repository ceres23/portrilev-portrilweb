/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.repository;

import it.csi.portril.portrilweb.integration.entity.PrTCella;
import it.csi.portril.portrilweb.integration.entity.PrTCellaPK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CellaRepository extends JpaRepository<PrTCella, PrTCellaPK> {

	/**
	 * 
	 * @param idEnteCompilatore
	 * @param idModulo
	 * @return
	 */
	@Query("FROM PrTCella cell WHERE cell.id.prTColonneModulo.prTModuli.idModulo= :idModulo  AND cell.id.prTRighe.prTEntiCompilatori.idEnteCompilatore = :idEnteCompilatore")	
	public List<PrTCella> getCelleByIdEnteIdModulo(
			@Param("idEnteCompilatore") Long idEnteCompilatore,
			@Param("idModulo") Long idModulo);


	/**
	 * 
	 * @param idEnteCompilatore
	 * @param idModulo
	 * @return
	 */
	@Modifying
	@Query("DELETE FROM PrTCella cell WHERE cell.id.prTColonneModulo.prTModuli.idModulo= :idModulo  AND cell.id.prTRighe.prTEntiCompilatori.idEnteCompilatore = :idEnteCompilatore")
	public int deleteCelleByIdEnteIdModulo(
			@Param("idEnteCompilatore") Long idEnteCompilatore,
			@Param("idModulo") Long idModulo);
	

	@Query("FROM PrTCella cell WHERE cell.prTRighe.idRiga= :idRiga  order by posizioneColonna")	
	public List<PrTCella> getCelleByIdRiga(@Param("idRiga") Long idRiga);

	
	
}
