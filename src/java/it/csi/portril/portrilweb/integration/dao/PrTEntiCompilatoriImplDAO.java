/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao;

import it.csi.portril.portrilweb.integration.dao.base.JpaDao;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTEntiCompilatoriDAO;
import it.csi.portril.portrilweb.integration.entity.PrTConfermeModuli;
import it.csi.portril.portrilweb.integration.entity.PrTEntiCompilatori;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.LogUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
public class PrTEntiCompilatoriImplDAO extends JpaDao<PrTEntiCompilatori, Long> implements PrTEntiCompilatoriDAO {
	private  LogUtil log = new LogUtil(getClass());
	
	
	@Override
	public PrTEntiCompilatori create(PrTEntiCompilatori entity) {
		Date now = new Date();		
		entity.setDataAgg(now);
		super.save(entity);
		return entity;
	}

	public PrTEntiCompilatori update(PrTEntiCompilatori entity) {
		Date now = new Date();	
		entity.setDataAgg(now);
		super.update(entity);
		return entity;
	}
	
	public void delete(PrTEntiCompilatori entity) {
		try {
			super.delete(entity);
		} catch(RuntimeException re) {
			
		}
	}
	

	public List<PrTEntiCompilatori> getCompilatori(
													Long   idEnteGestore,
													String ragioneSociale,
													String classificazione,
													String comune,
													String provincia,
													//String istat,
													String codiceFiscale,
													String partitaIva,
													String stato,
													String associazione,
													Long   idModulo
													) {
		
		final String methodName = "getCompilatori";
		log.startMethod(methodName);

		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();		
		jpql.append("select ec FROM PrTEntiCompilatori ec WHERE 1 = 1 ");
		
		if(idEnteGestore!=null){			
			jpql.append(" AND EXISTS (FROM ec.prREntiCompilatoriGestori ecg where ecg.prTEntiGestori.idEnteGestore =:idEnteGestore) ");
			param.put("idEnteGestore", idEnteGestore);		
		}		
		if(StringUtils.isNotEmpty(ragioneSociale)){
			jpql.append(" AND (UPPER(ec.ragioneSociale) LIKE CONCAT('%', :ragioneSociale ,'%')) ");
			param.put("ragioneSociale", StringUtils.trimToEmpty(ragioneSociale).toUpperCase());
		}		
		if(StringUtils.isNotEmpty( classificazione)){
			jpql.append(" AND (UPPER(ec.classificazione) LIKE UPPER(CONCAT('%', :classificazione, '%'))) ");
			param.put("classificazione", StringUtils.trimToEmpty(classificazione).toUpperCase());
		}
		if(StringUtils.isNotEmpty( comune)){
			jpql.append(" AND (UPPER(ec.comune) LIKE CONCAT('%', :comune, '%')) ");
			param.put("comune", StringUtils.trimToEmpty(comune).toUpperCase());
		}
		if(StringUtils.isNotEmpty( provincia)){
			jpql.append(" AND (UPPER(ec.provincia) LIKE CONCAT('%', :provincia ,'%')) ");
			param.put("provincia", StringUtils.trimToEmpty(provincia).toUpperCase());
		}
		if(StringUtils.isNotEmpty( codiceFiscale)){
			jpql.append(" AND (UPPER(ec.codiceFiscale) = :codiceFiscale ) ");
			param.put("codiceFiscale", StringUtils.trimToEmpty(codiceFiscale).toUpperCase());
		}
		
		if(StringUtils.isNotEmpty( partitaIva)){
			jpql.append(" AND (ec.partitaIva = :partitaIva ) ");
			param.put("partitaIva", StringUtils.trimToEmpty(partitaIva).toUpperCase());
		}
		
		if(StringUtils.isNotEmpty(stato) && !Costanti.ALL.getCostante().equalsIgnoreCase(stato)){
			jpql.append(" AND (ec.stato = :stato ) ");
			param.put("stato", stato);
		}
		
		if(StringUtils.isNotEmpty( associazione) ){
			if(associazione.equalsIgnoreCase(Costanti.ASSOCIATO.getCostante())){
				jpql.append(" AND EXISTS (FROM ec.prTModulis mo where mo.idModulo =:idModulo) ");
			}else{
				jpql.append(" AND NOT EXISTS (FROM ec.prTModulis mo where mo.idModulo =:idModulo ) ");
			}
			param.put("idModulo", idModulo);
		}		
		jpql.append(" ORDER BY ec.ragioneSociale,ec.comune ");			
		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		TypedQuery<PrTEntiCompilatori> query = createQuery(jpql.toString(), param, PrTEntiCompilatori.class);		
		log.stopMethod(methodName);		
		return query.getResultList();		 
	}

	@Override
	public List<PrTEntiCompilatori> getCompilatoriByIdModulo(Long idModulo,
			Long   idEnteGestore,
			String ragioneSociale,
			String classificazione,
			String comune,
			String provincia,
			//String istat,
			String codiceFiscale,
			String partitaIva,
			String provvedimento
			) {

		final String methodName = "getCompilatoriByIdModulo";
		log.startMethod(methodName);
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select ec FROM PrTEntiCompilatori ec WHERE ec.prREntiCompilatoriGestori.idEnteGestore= :idEnteGestore ");
		param.put("idEnteGestore", idEnteGestore);
		log.info(methodName, "idEnteGestore --> " + idEnteGestore);
		
		if(!StringUtils.isEmpty(ragioneSociale)){
			jpql.append(" AND (UPPER(ec.ragioneSociale) LIKE CONCAT('%', :ragioneSociale ,'%')) ");
			param.put("ragioneSociale", StringUtils.trimToEmpty(ragioneSociale).toUpperCase());
		}		

		if(!StringUtils.isEmpty( classificazione)){
			jpql.append(" AND (UPPER(ec.classificazione) LIKE CONCAT('%', :classificazione ,'%')) ");
			param.put("classificazione", StringUtils.trimToEmpty(classificazione).toUpperCase());
		}

		if(!StringUtils.isEmpty( comune)){
			jpql.append(" AND (UPPER(ec.comune) LIKE CONCAT('%', :comune ,'%')) ");
			param.put("comune", StringUtils.trimToEmpty(comune).toUpperCase());
		}
		
		if(!StringUtils.isEmpty( provincia)){
			jpql.append(" AND (UPPER(ec.provincia) LIKE CONCAT('%', :provincia ,'%')) ");
			param.put("provincia", StringUtils.trimToEmpty(provincia).toUpperCase());
		}

		if(!StringUtils.isEmpty( codiceFiscale)){
			jpql.append(" AND (UPPER(ec.codiceFiscale) = :codiceFiscale ) ");
			param.put("codiceFiscale", StringUtils.trimToEmpty(codiceFiscale).toUpperCase());
		}
		
		if(!StringUtils.isEmpty( partitaIva)){
			jpql.append(" AND (ec.partitaIva = :partitaIva ) ");
			param.put("partitaIva", StringUtils.trimToEmpty(partitaIva).toUpperCase());
		}
		
		// DA NON CANCELLARE
//		jpql.append(" AND EXISTS (");
//			jpql.append( "FROM ec.prTRighes ptri WHERE ptri.idModulo = :idModulo ");
//			log.info(methodName, "idModulo --> " + idModulo);
//			
//			if(!StringUtils.isEmpty( provvedimento)){
//
//				jpql.append( " AND EXISTS ( FROM ptri.prTCellas cella where TRIM(cella.valore) = :provvedimento)");
//				
//				log.debug(methodName, "provvedimento --> " + provvedimento);
//				param.put("provvedimento", provvedimento);
//
//			}
//		
//			jpql.append( ")  ");
//		param.put("idModulo", idModulo);
		
		
		jpql.append(" ORDER BY ec.ragioneSociale ");	
		
		log.info(methodName, "JPQL to execute: " + jpql.toString());
		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);
		
		return (List<PrTEntiCompilatori>) query.getResultList();

	}


	@Override
	public List<PrTEntiCompilatori> getEntiCompilatoriByIdEnteGestore(String stato,
			String ragioneSociale, String classificazione, String comune,
			String codiceFiscale, String partitaIva, Long idEnteGestore) {
		final String methodName = "getEntiCompilatoriByIdEnteGestore";
		log.startMethod(methodName);
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("select ec FROM PrTEntiCompilatori ec WHERE 1=1 ");

		if(idEnteGestore!=null){
			
			jpql.append(" AND EXISTS (FROM PrREntiCompilatoriGestori rec where ec.idEnteCompilatore = rec.prTEntiCompilatori.idEnteCompilatore AND  rec.prTEntiGestori.idEnteGestore = :idEnteGestore )");
			
			//jpql.append(" AND ec.prREntiCompilatoriGestori.idEnteGestore= :idEnteGestore");
			param.put("idEnteGestore", idEnteGestore);
		}		

		if(!StringUtils.isEmpty(ragioneSociale)){
			jpql.append(" AND (UPPER(ec.ragioneSociale) LIKE CONCAT('%', :ragioneSociale ,'%')) ");
			param.put("ragioneSociale", StringUtils.trimToEmpty(ragioneSociale).toUpperCase());
		}		

		if(!StringUtils.isEmpty( classificazione)){
			jpql.append(" AND (UPPER(ec.classificazione) LIKE CONCAT('%', :classificazione ,'%')) ");
			param.put("classificazione", StringUtils.trimToEmpty(classificazione).toUpperCase());
		}

		if(!StringUtils.isEmpty( comune)){
			jpql.append(" AND (UPPER(ec.comune) LIKE CONCAT('%', :comune ,'%')) ");
			param.put("comune", StringUtils.trimToEmpty(comune).toUpperCase());
		}
		
		if(!StringUtils.isEmpty( codiceFiscale)){
			jpql.append(" AND (UPPER(ec.codiceFiscale) = :codiceFiscale ) ");
			param.put("codiceFiscale", StringUtils.trimToEmpty(codiceFiscale).toUpperCase());
		}
		
		if(!StringUtils.isEmpty( partitaIva)){
			jpql.append(" AND (ec.partitaIva = :partitaIva ) ");
			param.put("partitaIva", StringUtils.trimToEmpty(partitaIva).toUpperCase());
		}
		
		if(!StringUtils.isEmpty( stato)){
			jpql.append(" AND (ec.stato = :stato ) ");
			param.put("stato", stato);
		}		
		jpql.append(" ORDER BY ec.ragioneSociale ");			
		log.info(methodName, "JPQL to execute: " + jpql.toString());		
		Query query = createQuery(jpql.toString(), param);		
		log.stopMethod(methodName);		
		return (List<PrTEntiCompilatori>) query.getResultList();
	}

	@Override
	public List<PrTEntiCompilatori> getEntiCompilatoriByIdModuloSelAndStato(Long idModuloSel, String stato) {
		StringBuilder sql = new StringBuilder();
		Map<String, Object> param = new HashMap<String, Object>();

		sql.append(" SELECT "); 
		sql.append("   ec.id_ente_compilatore ");
		sql.append("  ,ec.codice_fiscale ");
		sql.append("  ,ec.comune ");
		sql.append("  ,ec.data_agg ");
		sql.append("  ,ec.mail ");
		sql.append("  ,ec.partita_iva ");
		sql.append("  ,ec.provincia ");
		sql.append("  ,ec.ragione_sociale ");
		sql.append("  ,ec.classificazione ");
		sql.append("  ,ec.stato ");		
		sql.append(" FROM  ");
		sql.append(" pr_t_enti_compilatori ec ");
		sql.append(" ,pr_r_moduli_enti_compilatori rmec ");
		sql.append(" ,pr_t_moduli mo ");
		sql.append(" WHERE  ");
		sql.append("     ec.id_ente_compilatore= rmec.id_ente_compilatore ");
		sql.append(" and rmec.id_modulo =  mo.id_modulo ");
		sql.append(" and mo.id_modulo   =  :idModuloSel ");
		
		if(stato.equalsIgnoreCase(Costanti.DA_COMPILARE.getCostante())){
			sql.append(" and not exists ( select 1 from pr_t_righe where id_modulo = mo.id_modulo) ");
		}else if(stato.equalsIgnoreCase(Costanti.COMPILATO.getCostante())){
			sql.append(" and exists ( select 1 from pr_t_righe where id_modulo = mo.id_modulo) ");
		}
		
		param.put("idModuloSel", idModuloSel);

		Query query = createNativeQuery(sql.toString(), param);
		List<Object[]> resultList = query.getResultList();
		
		List<PrTEntiCompilatori> result = new ArrayList<PrTEntiCompilatori>();
		for(Object[] obj : resultList) {
			PrTEntiCompilatori ec = new PrTEntiCompilatori();

			ec.setIdEnteCompilatore(((BigDecimal) obj[0]).longValue());
			ec.setCodiceFiscale((String) obj[1]);
			ec.setComune((String) obj[2]);
			ec.setDataAgg((Date) obj[3]);
			ec.setMail((String) obj[4]);
			ec.setPartitaIva((String) obj[5]);
			ec.setProvincia((String) obj[6]);
			ec.setRagioneSociale((String) obj[7]);
			ec.setClassificazione((String) obj[8]);
			ec.setStato((String) obj[9]);

			result.add(ec);
		}		
		return result;
	}

	@Override
	public List<PrTEntiCompilatori> getListaEntiCompilatoriConModuloConfermato(Long idModulo,String confermatoSiNo) {
		final String methodName = "getListaEntiCompilatoriConModuloConfermato";
		log.startMethod(methodName);
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append(" select cm.prTEntiCompilatori FROM PrTConfermeModuli cm ");
		jpql.append(" WHERE ");
		jpql.append("     cm.prTModuli.idModulo = :idModulo ");
		param.put("idModulo", idModulo);
		
		if (StringUtils.isNotEmpty(confermatoSiNo) && (confermatoSiNo.equals(Costanti.SI.getCostante()) || confermatoSiNo.equals(Costanti.NO.getCostante()))){
			jpql.append(" and cm.moduloConfermato = :confermatoSiNo ");
			param.put("confermatoSiNo", confermatoSiNo);
		}
		jpql.append(" order by cm.prTEntiCompilatori.ragioneSociale ");
		
		log.info(methodName, "JPQL to execute: " + jpql.toString());		
		//Query query = createQuery(jpql.toString(), param);		
		TypedQuery<PrTEntiCompilatori> query = createQuery(jpql.toString(), param, PrTEntiCompilatori.class);			
		log.stopMethod(methodName);
		return query.getResultList();

	}
	
	@Override
	public List<PrTConfermeModuli> getListaConfermeEntiCompilatoriConModuloConfermato(Long idModulo,String statoConferma) {
		final String methodName = "getListaConfermeEntiCompilatoriConModuloConfermato";
		log.startMethod(methodName);
		
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		
		jpql.append(" select cm FROM PrTConfermeModuli cm ");
		jpql.append(" WHERE ");
		jpql.append("     cm.prTModuli.idModulo = :idModulo ");
		param.put("idModulo", idModulo);
		
		if (StringUtils.isNotEmpty(statoConferma) && (statoConferma.equals(Costanti.SI.getCostante()) || statoConferma.equals(Costanti.NO.getCostante()))){
			jpql.append(" and cm.moduloConfermato = :statoConferma ");
			param.put("statoConferma", statoConferma);
		}
		jpql.append(" order by cm.prTEntiCompilatori.ragioneSociale ");
		
		log.info(methodName, "JPQL to execute: " + jpql.toString());		
		//Query query = createQuery(jpql.toString(), param);		
		TypedQuery<PrTConfermeModuli> query = createQuery(jpql.toString(), param, PrTConfermeModuli.class);			
		log.stopMethod(methodName);
		return query.getResultList();

	}
}