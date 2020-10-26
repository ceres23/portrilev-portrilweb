/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.interfaces;

import it.csi.portril.portrilweb.integration.entity.PrTModuli;

import java.util.List;

public interface  PrTModuliDAO {

	/**
	 * 
	 * @param PrTModuli
	 * @return PrTModuli
	 */
	PrTModuli create(PrTModuli entity);
	/**
	 * 
	 * @param PrTModuli
	 * @return PrTModuli
	 */
	PrTModuli update(PrTModuli entity);
	/**
	 * 
	 * @param PrTModuli
	 * @return void
	 */
	void      delete(PrTModuli entity);
	
	/**
	 * 
	 * @param titolo
	 * @param stato
	 * @return List<PrTModuli>
	 */
	 List<PrTModuli> getModuli(String titolo, String stato,String tipo,Long idEnteGestore,String codiceGruppo);
	
	/**
	 *
	 * @param idEnteCompilatoreSelezionato
	 * @param titolo
	 * @return List<PrTModuli>
	 */
	 List<PrTModuli> getModuliByEnteCompilatore(Long idEnteCompilatoreSelezionato,String titolo,String stato,String tipo);
	
	/**
	 * 
	 * @param idModuloSel
	 * @param titolo
	 * @return
	 */
//	PrTModuli getCompilatoriByIdModuloSel(
//			Long idModuloSel,
//			String titolo);
	
	/**
	 * 
	 * @param nome
	 * @param stato
	 * @return
	 */
	List<PrTModuli> xstModulo(String nome,
			String stato,
			String tipo);
	
	/**
	 * 
	 * @param idEnteGestore
	 * @param nome
	 * @return
	 */
	List<PrTModuli> getModulixComunicazione(Long idEnteGestore, String nome);
	
	/**
	 * 
	 * @param nome
	 * @param stato
	 * @param tipo
	 * @param valoreCella
	 * @param posizioneColonna
	 * @param posizioneRiga
	 * @return
	 */
	List<PrTModuli> getModuliByValoreCellaContenuta(String nome, String stato,
			String tipo, String valoreCella, Integer posizioneColonna,
			Integer posizioneRiga);
	/**
	 * 
	 * @param idModuloSel
	 * @param idEnteCompilatore
	 * @return
	 */
	String getModuloEnteValidato(Long idModuloSel, Long idEnteCompilatore);
	


		
}
