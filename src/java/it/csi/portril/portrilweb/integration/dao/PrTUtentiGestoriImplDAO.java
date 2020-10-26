/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao;

import it.csi.portril.portrilweb.integration.dao.base.JpaDao;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTUtentiGestoriDAO;
import it.csi.portril.portrilweb.integration.entity.PrTEntiCompilatori;
import it.csi.portril.portrilweb.integration.entity.PrTUtentiGestori;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
public class PrTUtentiGestoriImplDAO extends JpaDao<PrTUtentiGestori, Long> implements PrTUtentiGestoriDAO {
	
	private  LogUtil log = new LogUtil(getClass());
	
	@Override
	public PrTUtentiGestori create(PrTUtentiGestori entity) {			
		Date now = new Date();	
		entity.setIdUtenteGestore(null);	
		entity.setDataAgg(now);
		super.save(entity);
		return entity;
	}

	public PrTUtentiGestori update(PrTUtentiGestori entity) {
		Date now = new Date();	
		entity.setDataAgg(now);
		super.update(entity);
		return entity;
	}
	
	public void delete(PrTUtentiGestori entity) {
		super.delete(entity);
	}
	
	
	
	public  List<PrTUtentiGestori> getUtentiGestore(String cognome,String nome,String codiceFiscale,Long idProfiloUtente,Long idEnteGestore) {

				final String methodName = "getUtentiGestore";
				log.startMethod(methodName);
							
				Map<String, Object> param = new HashMap<String, Object>();
				StringBuilder jpql = new StringBuilder();		
				jpql.append("select ug FROM PrTUtentiGestori ug WHERE 1 = 1 ");
				
				if(idEnteGestore!=null){			
					jpql.append(" AND EXISTS (FROM ug.prTEntiGestoris ecg where ecg.idEnteGestore =:idEnteGestore) ");
					param.put("idEnteGestore", idEnteGestore);		
				}	
							
				if(StringUtils.isNotEmpty(cognome)){
					jpql.append(" AND (UPPER(ug.cognome) LIKE CONCAT('%', :cognome ,'%')) ");
					param.put("cognome", StringUtils.trimToEmpty(cognome).toUpperCase());
				}		

				if(StringUtils.isNotEmpty(nome)){
					jpql.append(" AND (UPPER(ug.nome) LIKE CONCAT('%', :nome ,'%')) ");
					param.put("nome", StringUtils.trimToEmpty(nome).toUpperCase());
				}		

				if(StringUtils.isNotEmpty(codiceFiscale)){
					jpql.append(" AND (UPPER(ug.codiceFiscale) = :codiceFiscale ) ");
					param.put("codiceFiscale", StringUtils.trimToEmpty(codiceFiscale).toUpperCase());
				}		

				if(idProfiloUtente!=null && idProfiloUtente !=0){
					jpql.append(" AND ug.prTProfiliUtenti.idProfiloUtente = :idProfiloUtente ) ");
					param.put("idProfiloUtente", idProfiloUtente);
				}		
				
				jpql.append(" ORDER BY ug.nome,ug.cognome ");			
				log.info(methodName, "JPQL to execute: " + jpql.toString());
				
				TypedQuery<PrTUtentiGestori> query = createQuery(jpql.toString(), param, PrTUtentiGestori.class);		
				log.stopMethod(methodName);		
				return query.getResultList();		 
		}
	
	
	
}