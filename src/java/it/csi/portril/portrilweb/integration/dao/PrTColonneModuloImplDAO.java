/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao;

import java.util.Date;

import it.csi.portril.portrilweb.integration.dao.base.JpaDao;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTColonneModuloDAO;
import it.csi.portril.portrilweb.integration.entity.PrTColonneModulo;

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
public class PrTColonneModuloImplDAO extends JpaDao<PrTColonneModulo, Long> implements PrTColonneModuloDAO {

	public PrTColonneModulo create(PrTColonneModulo entity) {		
		entity.setIdColonnaModulo(null);
		super.save(entity);
		return entity;
	}

	public PrTColonneModulo update(PrTColonneModulo entity) {
		super.update(entity);
		return entity;
	}
	
	public void delete(PrTColonneModulo entity) {
		super.delete(entity);
	}

}