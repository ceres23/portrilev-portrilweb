/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.repository;

import it.csi.portril.portrilweb.integration.entity.PrTRighe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RigheRepository extends JpaRepository<PrTRighe, Long> {

	
	/**
	 * 
	 * @param idEnteCompilatore
	 * @param idModulo
	 * @return
	 */
	@Query(" FROM PrTRighe WHERE prTEntiCompilatori.idEnteCompilatore = :idEnteCompilatore AND idModulo=:idModulo order by posizione")
	public List<PrTRighe> getRigheByIdEnteIdModulo(
			@Param("idEnteCompilatore") Long idEnteCompilatore,
			@Param("idModulo") Long idModulo
			);
	
	/**
	 * 
	 * @param idEnteCompilatore
	 * @param idModulo
	 * @return
	 */
	@Query(" SELECT MAX(posizione) FROM PrTRighe WHERE prTEntiCompilatori.idEnteCompilatore = :idEnteCompilatore AND idModulo=:idModulo ")
	public Integer getMaxPosRigheByIdEnteIdModulo(
			@Param("idEnteCompilatore") Long idEnteCompilatore,
			@Param("idModulo") Long idModulo
			);

	
	/**
	 * 
	 * @param codiceFiscale
	 * @param idModulo
	 * @return
	 */
	@Query(" FROM PrTRighe ri WHERE ri.idModulo=:idModulo "
			+ " AND EXISTS (FROM ri.prTCellas ce WHERE ce.valore = :codiceFiscale AND ce.posizioneColonna=1 ) "
			+ " order by ri.posizione,ri.idRiga")
	public List<PrTRighe> getRigheByIdModuloCFCompilatore(
														@Param("codiceFiscale") String codiceFiscale,
														@Param("idModulo") Long idModulo);
	
	/**
	 * @param idModulo
	 * @return
	 */
	@Query(" FROM PrTRighe WHERE idModulo=:idModulo order by posizione")
	public List<PrTRighe> getRigheByIdModulo(@Param("idModulo") Long idModulo);

	/**
	 * @param idModulo
	 * @return
	 */
	@Query(" FROM PrTRighe WHERE idModulo IN( :listIdModulo ) order by idModulo,posizione")
	public List<PrTRighe> getRigheByListaIdModulo(@Param("listIdModulo") List<Long> listIdModulo);
	
	/**
	 * 
	 * @param idEnteCompilatore
	 * @param idModulo
	 * @return
	 */
	@Modifying
	@Query("DELETE FROM PrTRighe r WHERE r.prTEntiCompilatori.idEnteCompilatore = :idEnteCompilatore AND r.idModulo=:idModulo ")
	public int deleteRigheByIdEnteIdModulo(
											@Param("idEnteCompilatore") Long idEnteCompilatore,
											@Param("idModulo") Long idModulo);

	
	
	
	
	
	/**
	 * @param idModulo
	 * @return
	 */
	@Query(" SELECT max(posizione) FROM PrTRighe WHERE prTEntiCompilatori.idEnteCompilatore = :idEnteCompilatore AND idModulo=:idModulo")
	public Integer getMaxPosizioneRigaByIdModuloIdEnteCompilatore(@Param("idModulo") Long idModulo,@Param("idEnteCompilatore") Long idEnteCompilatore);
	


	
	
	
}