/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao;

import it.csi.portril.portrilweb.integration.dao.base.JpaDao;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTRigheDAO;
import it.csi.portril.portrilweb.integration.entity.PrTRighe;
import it.csi.portril.portrilweb.util.LogUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.repository.query.Param;
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
public class PrTRigheImplDAO extends JpaDao<PrTRighe, Long> implements PrTRigheDAO {
	private  LogUtil log = new LogUtil(getClass());
	
	@Override
	public PrTRighe create(PrTRighe entity) {
		Date now = new Date();	
		entity.setIdRiga(null);	
		entity.setDataAgg(now);
		entity.setDataModificaCompilatore(now);
		super.save(entity);
		return entity;
	}

	@Override
	public PrTRighe update(PrTRighe entity) {
		Date now = new Date();	
		entity.setDataAgg(now);
		entity.setDataModificaCompilatore(now);
		super.update(entity);
		return entity;
	}

	@Override
	public void delete(PrTRighe entity) {		
		super.delete(entity);
	}

	@Override
	public void deleteRighe(List<PrTRighe> lista) {
		for(PrTRighe riga : lista) {
			delete(riga);
		}
	}
	
	@Override
	public List<PrTRighe> getRigheByIdEnteIdModuloProvvedimento(
																Long idEnteCompilatore,
																Long idModulo,
																String provvedimento,
																String tipo){
		
		final String methodName = "getRigheByIdEnteIdModuloProvvedimento";
		log.startMethod(methodName);

		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select ri FROM PrTRighe ri WHERE ri.prTEntiCompilatori.idEnteCompilatore = :idEnteCompilatore AND  ri.idModulo=:idModulo AND tipo=:tipo");
		param.put("idEnteCompilatore", idEnteCompilatore);
		param.put("idModulo", idModulo);
		param.put("tipo", tipo);
		
		if(StringUtils.isNotEmpty(provvedimento)){
			jpql.append("AND EXISTS (FROM ri.prTCellas ce where ce.valore=:provvedimento) ");	
			param.put("provvedimento", provvedimento);
		}		

		jpql.append(" order by ri.posizione,ri.idRiga ");	
		
		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		TypedQuery<PrTRighe> query = createQuery(jpql.toString(), param, entityClass);
		List<PrTRighe> result = query.getResultList();
		log.stopMethod(methodName);
		
		return result;
	
	}

	

	
	@Override
	public List<PrTRighe> getRigheBylistaIdRiga (List<Long> listaIdRiga){
		
		final String methodName = "getRigheBylistaIdRiga";
		log.startMethod(methodName);

		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select ri FROM PrTRighe ri WHERE  ri.idRiga IN (:listaIdRiga) order by ri.posizione,ri.idRiga ");
		param.put("listaIdRiga", listaIdRiga);

		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		TypedQuery<PrTRighe> query = createQuery(jpql.toString(), param, entityClass);
		List<PrTRighe> result = query.getResultList();
		log.stopMethod(methodName);
		
		return result;
	
	}
	
	
	
	
	@Override
	public Page<PrTRighe> getRigheByIdEnteIdModuloPaginato(Long idEnteCompilatore,Long idModulo,List<String> listFiltri,Pageable pageable){		
		final String methodName = "getRigheByIdEnteIdModuloPaginato";
		log.startMethod(methodName);
		String valoreFiltro = "";
		StringBuilder jpql = new StringBuilder();		
		Map<String, Object> param = new HashMap<String, Object>();
		
		jpql.append(" FROM PrTRighe righe WHERE righe.prTEntiCompilatori.idEnteCompilatore = :idEnteCompilatore AND righe.idModulo=:idModulo ");
		
		if (listFiltri!=null){
			Integer posColonna = 0;
			for(int posizione=0;posizione<listFiltri.size();posizione++){
				valoreFiltro = listFiltri.get(posizione);
				posColonna = posizione+1;
				if(StringUtils.isNotEmpty(valoreFiltro)){
					jpql.append(" AND EXISTS (FROM righe.prTCellas cella where cella.posizioneColonna=:posColonna").append(posizione).append(" AND cella.valore=:valoreFiltro").append(posizione).append(")");
					param.put("posColonna"   + posizione, posColonna);
					param.put("valoreFiltro" + posizione, valoreFiltro);
				}
			}
		}
		
		jpql.append(" order by righe.posizione,righe.idRiga ");

		param.put("idEnteCompilatore", idEnteCompilatore);
		param.put("idModulo", idModulo);
				
		log.info(methodName, "JPQL to execute:   " + jpql.toString());
		log.info(methodName, "param: " + param.toString());
		
		Page<PrTRighe> result = getPagedList(jpql.toString(), param, pageable, entityClass);
		//Page<PrTRighe> result = getNativePagedList(jpql.toString(), param, pageable);
		log.stopMethod(methodName);		
		return result;
	}



}