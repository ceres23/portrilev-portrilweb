/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.interfaces;
import java.util.List;

import it.csi.portril.portrilweb.integration.entity.PrREntiCompilatoriGestori;

public interface  PrREntiGestoriCompilatoriDAO {

	/**
	 * 
	 * @param PrTCella
	 * @return PrTCella
	 */
	void  save(PrREntiCompilatoriGestori entity);

	/**
	 * 
	 * @param PrTCella
	 * @return PrTCella
	 */
	PrREntiCompilatoriGestori create(PrREntiCompilatoriGestori entity);
	/**
	 * 
	 * @param PrTCella
	 * @return PrTCella
	 */
	PrREntiCompilatoriGestori update(PrREntiCompilatoriGestori entity);
	/**
	 * 
	 * @param PrTCella
	 * @return void
	 */
	void     delete(PrREntiCompilatoriGestori entity);

	/**
	 * 
	 * @param idEnteCompilatore
	 * @param idEnteGestore
	 * @return
	 */
	public  List<PrREntiCompilatoriGestori> xstAssociazioneEnteGestoreCompilatore(Long idEnteCompilatore,Long idEnteGestore);

	/**
	 * 
	 * @param idEnteCompilatoreSel
	 */
	int  deleteFromIdEnteCompilatore(Long idEnteCompilatore);
}
