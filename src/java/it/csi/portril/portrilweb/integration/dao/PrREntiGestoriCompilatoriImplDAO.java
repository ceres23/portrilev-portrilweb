/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao;

import it.csi.portril.portrilweb.integration.dao.base.JpaDao;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrREntiGestoriCompilatoriDAO;
import it.csi.portril.portrilweb.integration.entity.PrREntiCompilatoriGestori;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

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
public class PrREntiGestoriCompilatoriImplDAO extends JpaDao<PrREntiCompilatoriGestori, Long> implements PrREntiGestoriCompilatoriDAO {

	private  LogUtil log = new LogUtil(getClass());
	
	public void save(PrREntiCompilatoriGestori entity) {	
		super.save(entity);
	}

	public PrREntiCompilatoriGestori create(PrREntiCompilatoriGestori entity) {	
		entity.setIdEnteCompilatoriGestori(null);	
		super.save(entity);
		return entity;
	}
	
	public PrREntiCompilatoriGestori update(PrREntiCompilatoriGestori entity) {
		super.update(entity);
		return entity;
	}
	
	public void delete(PrREntiCompilatoriGestori entity) {
		super.delete(entity);
	}
	
	
	public List<PrREntiCompilatoriGestori> xstAssociazioneEnteGestoreCompilatore(Long idEnteCompilatore,Long idEnteGestore) {
		final String methodName = "getUtentiCompilatori";
		log.startMethod(methodName);
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();		
		jpql.append("select ec FROM PrREntiCompilatoriGestori ec WHERE ec.prTEntiCompilatori.idEnteCompilatore = :idEnteCompilatore AND ec.prTEntiGestori.idEnteGestore = :idEnteGestore ");
		param.put("idEnteCompilatore", idEnteCompilatore);
		param.put("idEnteGestore", idEnteGestore);
		log.info(methodName, "JPQL to execute: " + jpql.toString());
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);
		return (List<PrREntiCompilatoriGestori>) query.getResultList();
	}

	@Override
	public int deleteFromIdEnteCompilatore(Long idEnteCompilatore) {
		final String methodName = "getUtentiCompilatori";
		log.startMethod(methodName);
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();		
		
		jpql.append("DELETE FROM PrREntiCompilatoriGestori ec WHERE ec.prTEntiCompilatori.idEnteCompilatore = :idEnteCompilatore ");
		param.put("idEnteCompilatore", idEnteCompilatore);

		log.info(methodName, "JPQL to execute: " + jpql.toString());		
		Query query = createQuery(jpql.toString(), param);		
		int deletedCount = query.executeUpdate();
		
		log.stopMethod(methodName);
		return deletedCount;
	}
	
	
}