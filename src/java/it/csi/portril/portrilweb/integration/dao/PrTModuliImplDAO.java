/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao;

import it.csi.portril.portrilweb.integration.dao.base.JpaDao;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTModuliDAO;
import it.csi.portril.portrilweb.integration.entity.PrTModuli;
import it.csi.portril.portrilweb.util.Costanti;
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
public class PrTModuliImplDAO extends JpaDao<PrTModuli, Long> implements PrTModuliDAO {

	private  LogUtil log = new LogUtil(getClass());
	
	
	public PrTModuli create(PrTModuli entity) {			
		Date now = new Date();	
		entity.setIdModulo(null);	
		entity.setDataUltimaModifica(now);
		super.save(entity);
		return entity;
	}

	public PrTModuli update(PrTModuli entity) {
		Date now = new Date();	
		entity.setDataUltimaModifica(now);
		super.update(entity);
		return entity;
	}
	
	public void delete(PrTModuli entity) {
		super.delete(entity);
	}
	
	@Override
	public List<PrTModuli> getModuli(String nome, String stato,String tipo,Long idEnteGestore,String codiceGruppo) {
		
		final String methodName = "getModuli";
		log.startMethod(methodName);
		
		Date now = new Date();
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select mo FROM PrTModuli mo WHERE tipo = :tipo ");
		param.put("tipo", tipo);
		
		
		if(StringUtils.isNotEmpty(nome)){
			jpql.append(" AND (UPPER(mo.nome) LIKE CONCAT('%', :nome, '%')) ");
			param.put("nome", StringUtils.trimToEmpty(nome).toUpperCase());
		}	
		
		if(idEnteGestore!= null){
			jpql.append(" AND mo.prTEntiGestori.idEnteGestore = :idEnteGestore  ");
			param.put("idEnteGestore", idEnteGestore);
		}	
		
		if(StringUtils.isNotEmpty(codiceGruppo)){
			jpql.append(" AND (UPPER(mo.codiceGruppo) LIKE CONCAT('%', :codiceGruppo, '%')) ");
			param.put("codiceGruppo", StringUtils.trimToEmpty(codiceGruppo).toUpperCase());
		}	
	
		if(StringUtils.isNotEmpty(stato) ){
			if(stato.equals(Costanti.CHIUSO.getCostante())){
				jpql.append(" AND mo.dataFineCompilazione < :now ");
				param.put("now", now);			
			} else if(stato.equals(Costanti.IN_COMPILAZIONE.getCostante())){
				jpql.append(" AND mo.dataInizioCompilazione <= :now AND mo.dataFineCompilazione >= :now ");
				param.put("now", now);
	
			}else if(stato.equals(Costanti.IN_COMPILAZIONE_OR_CHIUSO.getCostante())){
				jpql.append(" AND mo.dataInizioCompilazione <= :now AND mo.dataFineCompilazione IS NOT NULL ");
				param.put("now", now);
			}else if(stato.equals(Costanti.IN_DEFINIZIONE.getCostante())){
				jpql.append(" AND (mo.dataInizioCompilazione > :now OR mo.dataInizioCompilazione IS NULL)");
				param.put("now", now);
			}
		}
		
		jpql.append(" ORDER BY mo.nome ");
		

		log.debug(methodName, "stato analizzato " + stato );
		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);
		
		return (List<PrTModuli>) query.getResultList();
		 
	}
	
	@Override
	public List<PrTModuli> getModuliByValoreCellaContenuta(String nome,String stato,String tipo,String valoreCella,Integer posizioneColonna,Integer posizioneRiga) {
		
		final String methodName = "getModuliByValoreCellaContenuta";
		log.startMethod(methodName);
		
		Date now = new Date();
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select mo FROM PrTModuli mo WHERE tipo=:tipo  ");
		param.put("tipo", tipo);
		
		jpql.append(" AND EXISTS (");
		jpql.append( "FROM mo.prTColonneModulos col WHERE mo.idModulo=col.prTModuli.idModulo ");
			
			jpql.append(" AND EXISTS (");
			jpql.append(" FROM col.prTCellas cella WHERE col.idColonnaModulo=cella.id.prTColonneModulo.idColonnaModulo AND cella.valore=:valoreCella");
			param.put("valoreCella", valoreCella);
			
			if(posizioneColonna!=null){
				jpql.append(" AND cella.posizioneColonna=:posizioneColonna");
				param.put("posizioneColonna", posizioneColonna);
			}

			if(posizioneRiga!=null){
				jpql.append(" AND cella.posizioneRiga=:posizioneRiga");
				param.put("posizioneRiga", posizioneRiga);
			}

			
			jpql.append( ")  ");
			
		jpql.append( ")  ");

		

//		jpql.append(" AND EXISTS (");
//		jpql.append( "FROM mo.prTEntiCompilatoris ec WHERE ec.idEnteCompilatore = :idEnteCompilatore ");
//		param.put("idEnteCompilatore", idEnteCompilatore);
//		jpql.append( ")  ");
		
		if(!stato.isEmpty()){
			if(stato.equals(Costanti.CHIUSO.getCostante())){
				jpql.append(" AND mo.dataFineCompilazione < :now ");
				param.put("now", now);
				
			} else if(stato.equals(Costanti.IN_COMPILAZIONE.getCostante())){
				jpql.append(" AND mo.dataInizioCompilazione <= :now AND mo.dataFineCompilazione >= :now ");
				param.put("now", now);
	
			}else if(stato.equals(Costanti.IN_COMPILAZIONE_OR_CHIUSO.getCostante())){
				jpql.append(" AND mo.dataInizioCompilazione <= :now AND mo.dataFineCompilazione IS NOT NULL ");
				param.put("now", now);
			} 
		}
		
		if(StringUtils.isNotEmpty(nome)){
			jpql.append(" AND (UPPER(mo.nome) LIKE CONCAT('%', :nome, '%')) ");
			param.put("nome", StringUtils.trimToEmpty(nome).toUpperCase());
		}	
		
		jpql.append(" ORDER BY mo.nome ");
		
		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);
		
		return (List<PrTModuli>) query.getResultList();
		 
	}
	
	@Override
	public List<PrTModuli> getModuliByEnteCompilatore(Long idEnteCompilatore,String nome,String stato,String tipo) {
		
		final String methodName = "getModuliByEnteCompilatore";
		log.startMethod(methodName);
		
		Date now = new Date();
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select mo FROM PrTModuli mo WHERE tipo=:tipo  ");
		param.put("tipo", tipo);
		
		jpql.append(" AND EXISTS (");
		jpql.append( "FROM mo.prTEntiCompilatoris ec WHERE ec.idEnteCompilatore = :idEnteCompilatore ");
		param.put("idEnteCompilatore", idEnteCompilatore);
		jpql.append( ")  ");
		
		if(stato!=null){
			if(stato.equals(Costanti.CHIUSO.getCostante())){
				jpql.append(" AND mo.dataFineCompilazione < :now ");
				param.put("now", now);
				
			} else if(stato.equals(Costanti.IN_COMPILAZIONE.getCostante())){
				jpql.append(" AND mo.dataInizioCompilazione <= :now AND mo.dataFineCompilazione >= :now ");
				param.put("now", now);
	
			}else if(stato.equals(Costanti.IN_COMPILAZIONE_OR_CHIUSO.getCostante())){
				jpql.append(" AND mo.dataInizioCompilazione <= :now AND mo.dataFineCompilazione IS NOT NULL ");
				param.put("now", now);
			} 
		}
		
		if(StringUtils.isNotEmpty(nome)){
			jpql.append(" AND (UPPER(mo.nome) LIKE CONCAT('%', :nome, '%')) ");
			param.put("nome", StringUtils.trimToEmpty(nome).toUpperCase());
		}	
		
		jpql.append(" ORDER BY mo.prTEntiGestori.idEnteGestore, mo.nome ");
		
		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);
		
		return (List<PrTModuli>) query.getResultList();
		 
	}
	
	/*
	@Override
	public PrTModuli getCompilatoriByIdModuloSel(Long idModuloSel,String titolo) {
		final String methodName = "getModuli";
		log.startMethod(methodName);
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select mo FROM PrTModuli mo WHERE mo.idModulo= :idModuloSel ");
		param.put("idModuloSel", idModuloSel);
		
		if(!StringUtils.isEmpty(titolo)){
			jpql.append(" AND (UPPER(mo.nome) LIKE CONCAT('%', :titolo, '%')) ");
			param.put("titolo", titolo);
		}	
		
		jpql.append(" ORDER BY mo.nome ");
		
		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);
		
		return (PrTModuli) query.getSingleResult();
		
	}
*/
	
	@Override
	public List<PrTModuli> xstModulo(String nome, String stato,String tipo) {
		final String methodName = "xstModulo";
		log.startMethod(methodName);
		
		Date now = new Date();
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select mo FROM PrTModuli mo WHERE tipo = :tipo ");
		param.put("tipo", tipo);
		
		if(StringUtils.isNotEmpty(nome)){
			jpql.append(" AND UPPER(mo.nome) = :nome");
			param.put("nome", nome);
		}	
		
		if(StringUtils.isNotEmpty(stato) ){
			if(stato.equals(Costanti.CHIUSO.getCostante())){
				jpql.append(" AND mo.dataFineCompilazione < :now ");
				param.put("now", now);			
			} else if(stato.equals(Costanti.IN_COMPILAZIONE.getCostante())){
				jpql.append(" AND mo.dataInizioCompilazione <= :now AND mo.dataFineCompilazione >= :now ");
				param.put("now", now);
	
			}else if(stato.equals(Costanti.IN_COMPILAZIONE_OR_CHIUSO.getCostante())){
				jpql.append(" AND mo.dataInizioCompilazione <= :now AND mo.dataFineCompilazione IS NOT NULL ");
				param.put("now", now);
			}else if(stato.equals(Costanti.IN_DEFINIZIONE.getCostante())){
				jpql.append(" AND (mo.dataInizioCompilazione > :now OR mo.dataInizioCompilazione IS NULL)");
				param.put("now", now);
			}
		}
		
		jpql.append(" ORDER BY mo.nome ");
		

		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);
		
		return (List<PrTModuli>) query.getResultList();
	}

	@Override
	public List<PrTModuli> getModulixComunicazione(Long idEnteGestore,String nome) {
		final String methodName = "getModuliByEnteCompilatore";
		log.startMethod(methodName);
		
		Date now = new Date();
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select mo FROM PrTModuli mo WHERE mo.prTEntiGestori.idEnteGestore=:idEnteGestore AND tipo='"+Costanti.TIPO_MODULO_COMUNICAZIONE.getCostante()+"' ");
		param.put("idEnteGestore", idEnteGestore);
		

		if(StringUtils.isNotEmpty(nome)){
			jpql.append(" AND (UPPER(mo.nome) LIKE CONCAT('%', :nome, '%')) ");
			param.put("nome", nome.trim().toUpperCase());
		}	
		
		jpql.append(" ORDER BY mo.nome ");
		
		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);
		
		return (List<PrTModuli>) query.getResultList();
		 
	}

	@Override
	public String getModuloEnteValidato(Long idModuloSel, Long idEnteCompilatore) {
		final String methodName = "getModuloEnteValidato";
		log.startMethod(methodName);
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select mo.moduloValidato FROM PrTConfermeModuli mo WHERE mo.prTModuli.idModulo= :idModuloSel AND mo.prTEntiCompilatori.idEnteCompilatore = :idEnteCompilatore");
		param.put("idModuloSel", idModuloSel);
		param.put("idEnteCompilatore", idEnteCompilatore);
				
		
		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);
		
		return (String) query.getSingleResult();
	}
	
	
}