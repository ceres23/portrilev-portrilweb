/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao;

import it.csi.portril.portrilweb.integration.dao.base.JpaDao;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTConfermeModuliDAO;
import it.csi.portril.portrilweb.integration.entity.PrTConfermeModuli;

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
public class PrTConfermeModuliImplDAO extends JpaDao<PrTConfermeModuli, Long> implements PrTConfermeModuliDAO {

	public void save(PrTConfermeModuli entity) {	
		super.save(entity);
	}

	public PrTConfermeModuli create(PrTConfermeModuli entity) {	
		entity.setIdConfermeModuli(null);	
		super.save(entity);
		return entity;
	}
	
	public PrTConfermeModuli update(PrTConfermeModuli entity) {
		super.update(entity);
		return entity;
	}
	
	public void delete(PrTConfermeModuli entity) {
		super.delete(entity);
	}
	
}