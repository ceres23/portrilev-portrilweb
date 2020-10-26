/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao;

import it.csi.portril.portrilweb.integration.dao.base.JpaDao;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTCellaDAO;
import it.csi.portril.portrilweb.integration.entity.PrTCella;
import it.csi.portril.portrilweb.util.LogUtil;

import java.math.BigInteger;
import java.util.HashMap;
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
public class PrTCellaImplDAO extends JpaDao<PrTCella, Long> implements PrTCellaDAO {

	private  LogUtil log = new LogUtil(getClass());
	
	public PrTCella create(PrTCella entity) {	
		entity.setId(null);	
		super.save(entity);
		return entity;
	}
	
	public PrTCella update(PrTCella entity) {
		super.update(entity);
		return entity;
	}
	
	public void delete(PrTCella entity) {
		super.delete(entity);
	}
	
	public int deleteCellaFromRiga(Long idRiga) {
		final String methodName = "getUtentiCompilatori";
		log.startMethod(methodName);
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();		
		
		jpql.append("DELETE FROM PrTCella ec WHERE ec.prTRighe.idRiga = :idRiga ");
		//jpql.append("DELETE FROM PrTCella ec WHERE ec.id.prTRighe.idRiga IN( :listIdCelle) ");
		param.put("idRiga", idRiga);

		log.info(methodName, "JPQL to execute: " + jpql.toString());		
		Query query = createQuery(jpql.toString(), param);		
		int deletedCount = query.executeUpdate();
		
		log.stopMethod(methodName);
		return deletedCount;
		
	}
		
	public Long getNumCelleByIdModulo(Long idModuloSel) {
		StringBuilder sql = new StringBuilder();
		
		Map<String, Object> param = new HashMap<String, Object>();
		sql.append(" select"); 
		sql.append("  count(pr_t_cella.*) ");
		sql.append(" FROM ");
		sql.append("   pr_t_righe");
		sql.append("  ,pr_t_cella");
		sql.append(" WHERE ");
		sql.append("  pr_t_righe.id_riga =  pr_t_cella.id_riga");
		sql.append("  and pr_t_righe.id_modulo= :idModuloSel ");		
		param.put("idModuloSel", idModuloSel);
		
		Query query = createNativeQuery(sql.toString(), param);
		Long ris = ((Number) query.getSingleResult()).longValue();
		return ris;		
	}
	
}