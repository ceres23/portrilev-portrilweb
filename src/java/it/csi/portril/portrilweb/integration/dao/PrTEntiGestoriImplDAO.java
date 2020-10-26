/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao;

import it.csi.portril.portrilweb.integration.dao.base.JpaDao;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTEntiGestoriDAO;
import it.csi.portril.portrilweb.integration.entity.PrTEntiGestori;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Implementazione del DAO 
 * 
 * @author Antonino Benedetto
 * @version 1.0.0 - 16/05/2014
 *
 */
@Component
@Scope("prototype")
public class PrTEntiGestoriImplDAO extends JpaDao<PrTEntiGestori, Long> implements PrTEntiGestoriDAO {

	
	public PrTEntiGestori create(PrTEntiGestori entity) {
		Date now = new Date();	
		entity.setIdEnteGestore(null);	
		entity.setDataAgg(now);
		super.save(entity);
		return entity;
	}

	public PrTEntiGestori update(PrTEntiGestori entity) {
		Date now = new Date();	
		entity.setDataAgg(now);
		super.update(entity);
		return entity;
	}
	
	public void delete(PrTEntiGestori entity) {
		super.delete(entity);
	}
}