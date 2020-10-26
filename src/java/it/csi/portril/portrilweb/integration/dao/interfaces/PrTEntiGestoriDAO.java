/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.interfaces;

import it.csi.portril.portrilweb.integration.entity.PrTEntiGestori;

public interface PrTEntiGestoriDAO {
	/**
	 * 
	 * @param PrTEntiGestori
	 * @return PrTEntiGestori
	 */
	PrTEntiGestori create(PrTEntiGestori entity);
	/**
	 * 
	 * @param PrTEntiGestori
	 * @return PrTEntiGestori
	 */
	PrTEntiGestori update(PrTEntiGestori entity);
	/**
	 * 
	 * @param PrTEntiGestori
	 * @return void
	 */
	void           delete(PrTEntiGestori entity);
}
