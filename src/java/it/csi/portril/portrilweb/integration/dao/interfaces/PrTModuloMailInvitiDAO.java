/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.interfaces;

import java.util.List;

import it.csi.portril.portrilweb.integration.entity.PrTModuloMailInviti;
import it.csi.portril.portrilweb.integration.entity.PrVModuliUtentiCoompilatori;

public interface  PrTModuloMailInvitiDAO {
	/**
	 * 
	 * @param entity
	 * @return PrTModuloMailInviti
	 */
	PrTModuloMailInviti create(PrTModuloMailInviti entity);
	/**
	 * 
	 * @param entity
	 * @return PrTModuloMailInviti
	 */
	PrTModuloMailInviti update(PrTModuloMailInviti entity);
	/**
	 * 
	 * @param entity
	 * @return void
	 */
	void                delete(PrTModuloMailInviti entity);
	/**
	 * 
	 * @param idModuloSel
	 * @param gruppoSollecito
	 * @return
	 */
	List<PrVModuliUtentiCoompilatori> getListaMailSollecitiUtentiCompilatoriFromModulo(Long idModuloSel,String gruppoSollecito);

}
