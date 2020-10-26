/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.repository;

import it.csi.portril.portrilweb.integration.entity.PrTUtentiCompilatori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtentiCompilatoriRepository extends JpaRepository<PrTUtentiCompilatori, Long> {
	
	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	@Query(" FROM PrTUtentiCompilatori ug WHERE login = :login AND  password=:password ")
	public PrTUtentiCompilatori getUtenteCompilatoreByUsPW(
			@Param("login") String login,
			@Param("password") String password);

	*/
	/**
	 * 
	 * @param login
	 * @param password
	 * @param stato
	 * @return
	@Query(" FROM PrTUtentiCompilatori ug WHERE login = :login AND  password=:password AND stato=:stato ")
	public PrTUtentiCompilatori getUtenteCompilatoreByUsPwStato(
			@Param("login") String login,
			@Param("password") String password,			
			@Param("stato") String stato);
	*/

	/**
	 * 
	 * @param login
	 * @param password
	 * @param stato
	 * @return
	 */
	@Query(" FROM PrTUtentiCompilatori ug WHERE login = :login ")
	public PrTUtentiCompilatori getUtenteCompilatoreByLogin(@Param("login") String login);
	
	/**
	 * 
	 * @param mail
	 * @return
	 */
	@Query(" FROM PrTUtentiCompilatori ug WHERE mail = :mail ")
	public PrTUtentiCompilatori getUtenteCompilatoreByEmail(@Param("mail") String mail);

	/**
	 * 
	 * @param codiceFiscale
	 * @return
	 */
	@Query(" FROM PrTUtentiCompilatori ug WHERE UPPER(codiceFiscale) = :codiceFiscale ")
	public PrTUtentiCompilatori getUtenteCompilatoriByCodiceFiscale(@Param("codiceFiscale") String codiceFiscale);

	/**
	 * 
	 * @param idEnteGestore
	 * @return
	 */
	@Query(" FROM PrTUtentiCompilatori  WHERE idUtenteCompilatore = -1 ")
	public PrTUtentiCompilatori getUtenteCompilatoreFittizioByIdEnteGestore();
			//@Param("idEnteGestore") Long idEnteGestore);
	
}