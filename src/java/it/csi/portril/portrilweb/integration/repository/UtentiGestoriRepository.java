/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.repository;

import it.csi.portril.portrilweb.integration.entity.PrTUtentiGestori;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtentiGestoriRepository extends
		JpaRepository<PrTUtentiGestori, Long> {

	/**
	 * 
	 * @param codiceFiscale
	 * @return
	 */
	@Query(" FROM PrTUtentiGestori ug WHERE UPPER(ug.codiceFiscale) = UPPER(:codiceFiscale) ")
	public PrTUtentiGestori getUtenteGestorebyCodFis(
			@Param("codiceFiscale") String codiceFiscale);

	/**
	 * 
	 * @param cognome
	 * @param nome
	 * @param codiceFiscale
	 * @param idProfiloUtente
	 * @return
	 */
/*
	@Query(" FROM PrTUtentiGestori ug "
			+ " WHERE "
			+ " (:cognome         =''  OR :cognome            IS NULL  OR  UPPER(ug.cognome) LIKE CONCAT('%', :cognome, '%') ) AND "
			+ " (:nome         	  =''  OR :nome               IS NULL  OR  UPPER(ug.nome) LIKE CONCAT('%', :nome, '%') ) AND "
			+ " (:codiceFiscale	  =''  OR :codiceFiscale  	  IS NULL  OR  UPPER(ug.codiceFiscale)=:codiceFiscale) AND  "
			+ " (:idEnteGestore	  =''  OR :idEnteGestore  	  IS NULL  OR  UPPER(ug.prTEntiGestoris.idEnteGestore)=:idEnteGestore) AND  "

			+
			// "\n (coalesce(:idProfiloUtente,0)=0 OR ug.prTProfiliUtenti.idProfiloUtente=:idProfiloUtente ) ")
			" (:idProfiloUtente=0L OR ug.prTProfiliUtenti.idProfiloUtente=:idProfiloUtente ) ")
	public List<PrTUtentiGestori> getUtentiGestore(
			@Param("cognome") String cognome, 
			@Param("nome") String nome,
			@Param("codiceFiscale") String codiceFiscale,
			@Param("idProfiloUtente") Long idProfiloUtente,
			@Param("idEnteGestore") Long idEnteGestore
			);
*/

}