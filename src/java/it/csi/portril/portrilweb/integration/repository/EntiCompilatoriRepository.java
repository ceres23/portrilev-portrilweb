/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.repository;

import it.csi.portril.portrilweb.integration.entity.PrTEntiCompilatori;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EntiCompilatoriRepository extends
		JpaRepository<PrTEntiCompilatori, Long> {

	/**
	 * 
	 * @param ragioneSociale
	 * @param comune
	 * @param codiceFiscale
	 * @param partitaIva
	 * @return
	 */
	@Query(" FROM PrTEntiCompilatori "
			+ " WHERE "
			+ " (:stato =''  OR :stato IS NULL  OR stato =:stato ) AND "
			+ " (:ragioneSociale   =''  OR :ragioneSociale  IS NULL  OR UPPER(ragioneSociale) LIKE CONCAT('%', :ragioneSociale, '%') ) AND "
			+ " (:classificazione  =''  OR :classificazione IS NULL  OR UPPER(classificazione)=:classificazione) AND "
			+ " (:comune           =''  OR :comune          IS NULL  OR UPPER(comune) LIKE CONCAT('%', :comune, '%') ) AND "
			+ " (:codiceFiscale    =''  OR :codiceFiscale   IS NULL  OR UPPER(codiceFiscale)=:codiceFiscale) AND "
			+ " (:partitaIva       =''  OR :partitaIva      IS NULL  OR partitaIva=:partitaIva) "
			+ " ORDER BY ragioneSociale ")
	public List<PrTEntiCompilatori> getEntiCompilatori(
			@Param("stato") String stato,
			@Param("ragioneSociale") String ragioneSociale,
			@Param("classificazione") String classificazione,			
			@Param("comune") String comune,
			@Param("codiceFiscale") String codiceFiscale,
			@Param("partitaIva") String partitaIva
	);

	/**
	 * 
	 * @param listaIdEnteComp
	 * @return
	 */
	@Query(" FROM PrTEntiCompilatori eg WHERE eg.idEnteCompilatore IN( :listaIdEnteComp )")
	List<String> findIndirizziMailEntiComp(@Param("listaIdEnteComp") List<Long> listaIdEnteComp);

	
	/**
	 * 
	 * @param idModulo
	 * @return
	 */
	@Query(" FROM PrTEntiCompilatori ec WHERE EXISTS ( FROM ec.prTModulis mo WHERE mo.idModulo =:idModulo) ")
	public List<PrTEntiCompilatori> getListabyIdModulo(
			@Param("idModulo") Long idModulo);


	/**
	 * 
	 * @param idModulo
	 * @return
	 */
	/*
	@Query(" select ec FROM PrTEntiCompilatori ec ,PrTConfermeModuli cm "
		+ " where "
		+ "     ec.idEnteCompilatore = cm.prTEntiCompilatori.idEnteCompilatore " 
		+ " and cm.prTModuli.idModulo = :idModulo "
		+ " and cm.moduloConfermato = :confermatoSiNo order by ec.ragioneSociale")
	public List<PrTEntiCompilatori> getListaEntiCompilatoriConModuloConfermato(
																				@Param("idModulo") Long idModulo,
																				@Param("confermatoSiNo") String confermatoSiNo
																				);
*/

	/**
	 * 
	 * @param idModulo
	 * @return
	 */
	@Query(" select ec FROM PrTEntiCompilatori ec ,PrTConfermeModuli cm "
		+ " where "
		+ "     ec.idEnteCompilatore = cm.prTEntiCompilatori.idEnteCompilatore " 
		+ " and cm.prTModuli.idModulo = :idModulo "
		+ " and cm.moduloValidato     = :validatoSiNo ")


	public List<PrTEntiCompilatori> getListaEntiCompilatoriConModuloValidato(
																				@Param("idModulo") Long idModulo,
																				@Param("validatoSiNo") String validatoSiNo
																				);

	/**
	 * 
	 * @param idEnteGestore
	 * @return
	 */
	//@Query(" FROM PrTEntiCompilatori ec WHERE ec.idEnteCompilatore = -1 AND idEnteGestore=:idEnteGestore")
	@Query(" FROM PrTEntiCompilatori ec WHERE ec.idEnteCompilatore = -1 ")
	public PrTEntiCompilatori getEnteCompilatoreFittizioByIdEnteGestore();//@Param("idEnteGestore") Long idEnteGestore);

}
