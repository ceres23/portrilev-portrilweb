/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.repository;

import it.csi.portril.portrilweb.integration.entity.PrTModuli;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModuliRepository extends JpaRepository<PrTModuli, Long> {

	/**
	 * 
	 * @param titolo
	 * @param stato
	 * @return
	 */
	@Query(" FROM PrTModuli  WHERE tipo =:tipo AND "+
	" (:titolo         =''  OR :titolo            IS NULL  OR  UPPER(titolo) LIKE CONCAT('%', :titolo, '%') ) AND "+
	" (:stato          =''  OR :stato             IS NULL  OR  stato= :stato ) ")
	public List<PrTModuli>  getModuli(@Param("titolo") String titolo,
			                          @Param("stato") String stato,
			                          @Param("tipo") String tipo);
}