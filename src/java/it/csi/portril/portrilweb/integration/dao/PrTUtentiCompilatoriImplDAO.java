/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao;

import it.csi.portril.portrilweb.integration.dao.base.JpaDao;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTUtentiCompilatoriDAO;
import it.csi.portril.portrilweb.integration.entity.PrTUtentiCompilatori;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
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
public class PrTUtentiCompilatoriImplDAO extends JpaDao<PrTUtentiCompilatori, Long> implements PrTUtentiCompilatoriDAO {
	private  LogUtil log = new LogUtil(getClass());

	public PrTUtentiCompilatori create(PrTUtentiCompilatori entity) {
		Date now = new Date();	
		String methodName = "create";
		log.info(methodName , "oggi " + now);
		entity.setIdUtenteCompilatore(null);	
		entity.setDataAgg(now);
		super.save(entity);
		return entity;
	}

	public PrTUtentiCompilatori update(PrTUtentiCompilatori entity) {
		Date now = new Date();	
		String methodName = "update";
		//log.info(methodName , "oggi " + now);
		entity.setDataAgg(now);
		super.update(entity);
		return entity;
	}
	
	public void delete(PrTUtentiCompilatori entity) {
		super.delete(entity);
	}

	public List<PrTUtentiCompilatori> getUtentiCompilatori(Long idEnteGestore,String nome,String cognome, String codiceFiscale) {
		final String methodName = "getUtentiCompilatori";
		log.startMethod(methodName);
		
		//String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		//Date now = new Date();
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select ec FROM PrTUtentiCompilatori ec WHERE 1 = 1 ");

		if(idEnteGestore !=null){
			jpql.append("AND  EXISTS (FROM ec.prTEntiCompilatoris ptec, PrREntiCompilatoriGestori precg WHERE precg.prTEntiCompilatori = ptec AND precg.prTEntiGestori.idEnteGestore = :idEnteGestore) ");
			param.put("idEnteGestore", idEnteGestore);
		}

		if(StringUtils.isNotEmpty(nome)){
			jpql.append(" AND (UPPER(ec.nome) LIKE CONCAT('%', :nome, '%')) ");
			param.put("nome", StringUtils.trimToEmpty(nome).toUpperCase());
		}		

		if(StringUtils.isNotEmpty( cognome)){
			jpql.append(" AND (UPPER(ec.cognome) LIKE CONCAT('%', :cognome, '%')) ");
			param.put("cognome", StringUtils.trimToEmpty(cognome).toUpperCase());
		}
		
		if(StringUtils.isNotEmpty( codiceFiscale)){
			jpql.append(" AND UPPER(ec.codiceFiscale) = :codiceFiscale  ");
			param.put("codiceFiscale", StringUtils.trimToEmpty(codiceFiscale).toUpperCase());
		}
		
		jpql.append(" ORDER BY ec.nome,ec.cognome ");	
		
		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);
		
		return (List<PrTUtentiCompilatori>) query.getResultList();
	}
	
	public List<PrTUtentiCompilatori> getUtentiCompilatoriNativa(Long idEnteGestore,String nome,String cognome, String codiceFiscale) {
		final String methodName = "getUtentiCompilatori";
		log.startMethod(methodName);
		//String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		//Date now = new Date();
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select ec FROM PrTUtentiCompilatori ec WHERE 1 = 1 ");
//		param.put("idEnteGestore", idEnteGestore);

		if(idEnteGestore !=null){
			//jpql.append("AND  EXISTS (FROM ec.prTEntiCompilatoris ptec WHERE ptec.prTEntiCompilatoris.idEnteGestore = :idEnteGestore) ");			
			jpql.append("AND  EXISTS (FROM ec.prTEntiCompilatoris ptec, PrREntiCompilatoriGestori precg WHERE precg.prTEntiCompilatori = ptec AND precg.idEnteGestore = :idEnteGestore) ");
			param.put("idEnteGestore", idEnteGestore);
		}

		if(StringUtils.isNotEmpty(nome)){
			jpql.append(" AND (UPPER(ec.nome) LIKE CONCAT('%', :nome, '%')) ");
			param.put("nome", StringUtils.trimToEmpty(nome).toUpperCase());
		}		

		if(StringUtils.isNotEmpty( cognome)){
			jpql.append(" AND (UPPER(ec.cognome) LIKE CONCAT('%', :cognome, '%')) ");
			param.put("cognome", StringUtils.trimToEmpty(cognome).toUpperCase());
		}
		
		if(StringUtils.isNotEmpty( codiceFiscale)){
			jpql.append(" AND UPPER(ec.codiceFiscale) = :codiceFiscale  ");
			param.put("codiceFiscale", StringUtils.trimToEmpty(codiceFiscale).toUpperCase());
		}
		
		jpql.append(" ORDER BY ec.nome,ec.cognome ");	
		
		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);
		
		return (List<PrTUtentiCompilatori>) query.getResultList();
	}
	
	public List<PrTUtentiCompilatori> getUtenteCompilatoreByUsPW(String login,String password) {
		final String methodName = "getUtenteCompilatoreByUsPW";
		log.startMethod(methodName);
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		jpql.append("select ec FROM PrTUtentiCompilatori ec WHERE login = :login AND  password=:password  ");
		param.put("login", login);
		param.put("password", password);		
		log.info(methodName, "JPQL to execute: " + jpql.toString());		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);		
		return (List<PrTUtentiCompilatori>) query.getResultList();
	}

	public List<PrTUtentiCompilatori> getUtenteCompilatoreByUsPwStato(String login,String password,String stato) {
		final String methodName = "getUtenteCompilatoreByUsPW";
		log.startMethod(methodName);
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		jpql.append("select ec FROM PrTUtentiCompilatori ec WHERE login = :login AND  password=:password AND stato=:stato ");
		param.put("login", login);
		param.put("password", password);		
		param.put("stato", stato);		
		log.info(methodName, "JPQL to execute: " + jpql.toString());		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);		
		return (List<PrTUtentiCompilatori>) query.getResultList();
	}
/*
	private String decrypt(String value) {
		//TODO da fare in futuro
		String ris = value;
		return ris;
	}
*/
}