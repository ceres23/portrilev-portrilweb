/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.repository;

import it.csi.portril.portrilweb.integration.entity.PrTModuloMailInviti;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModuliMailInvitiRepository extends JpaRepository<PrTModuloMailInviti, Long> {
	/**
	 * 
	 * @param idModulo
	 * @return
	 */
	@Query(" FROM PrTModuloMailInviti ug WHERE ug.idModulo = :idModulo ")
	public List<PrTModuloMailInviti> getInvitiByIdModulo(@Param("idModulo") Long idModulo);

}