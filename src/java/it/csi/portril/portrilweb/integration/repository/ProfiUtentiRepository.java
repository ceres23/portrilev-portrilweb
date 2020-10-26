/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.repository;

import it.csi.portril.portrilweb.integration.entity.PrTProfiliUtenti;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfiUtentiRepository extends
		JpaRepository<PrTProfiliUtenti, Long> {

	/**
	 * 
	 * @param codiceFiscale
	 * @return
	 */
	@Query("FROM PrTProfiliUtenti pu  "
			+ " WHERE EXISTS ( "
			+ "		FROM pu.prTUtentiGestoris ug "
			+ "		WHERE UPPER(ug.codiceFiscale) = UPPER(:codiceFiscale)  )")
	public PrTProfiliUtenti getProfiloGestorebyCodFis(
			@Param("codiceFiscale") String codiceFiscale);

	
	/**
	 * 
	 * @return
	 */
	@Query("FROM PrTProfiliUtenti where tipo='gestore' order by idProfiloUtente ")
	public List<PrTProfiliUtenti> getProfiliGestoreAll();

	
	/**
	 * 
	 * @return
	 */
	@Query("FROM PrTProfiliUtenti where tipo='gestore' and idProfiloUtente !=1 order by idProfiloUtente ")
	public List<PrTProfiliUtenti> getProfiliGestoreForAdmin();

	/**
	 * 
	 * @return
	 */
	@Query("FROM PrTProfiliUtenti where tipo='compilatore'")
	public List<PrTProfiliUtenti> getProfiliCompilatore();

}