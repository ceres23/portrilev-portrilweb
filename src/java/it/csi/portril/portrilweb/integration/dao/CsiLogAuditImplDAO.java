/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao;

import it.csi.portril.portrilweb.integration.dao.base.JpaDao;
import it.csi.portril.portrilweb.integration.dao.interfaces.CsiLogAuditDAO;
import it.csi.portril.portrilweb.integration.entity.CsiLogAudit;

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
public class CsiLogAuditImplDAO extends JpaDao<CsiLogAudit,Date> implements CsiLogAuditDAO {
		

	public CsiLogAudit create(CsiLogAudit entity) {	
		super.save(entity);
		return entity;
	}
	
	public CsiLogAudit update(CsiLogAudit entity) {
		super.update(entity);
		return entity;
	}
	
	public void delete(CsiLogAudit entity) {
		super.delete(entity);
	}
	
}