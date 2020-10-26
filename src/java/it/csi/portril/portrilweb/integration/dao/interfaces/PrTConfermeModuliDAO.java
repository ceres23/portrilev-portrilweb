/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.interfaces;
import it.csi.portril.portrilweb.integration.entity.PrTConfermeModuli;

public interface  PrTConfermeModuliDAO {

	/**
	 * 
	 * @param PrTCella
	 * @return PrTCella
	 */
	void  save(PrTConfermeModuli entity);

	/**
	 * 
	 * @param PrTCella
	 * @return PrTCella
	 */
	PrTConfermeModuli create(PrTConfermeModuli entity);
	/**
	 * 
	 * @param PrTCella
	 * @return PrTCella
	 */
	PrTConfermeModuli update(PrTConfermeModuli entity);
	/**
	 * 
	 * @param PrTCella
	 * @return void
	 */
	void     delete(PrTConfermeModuli entity);
	
}
