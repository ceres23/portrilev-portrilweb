/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import it.csi.portril.portrilweb.integration.dao.base.JpaDao;
import it.csi.portril.portrilweb.integration.dao.interfaces.PrTModuloMailInvitiDAO;
import it.csi.portril.portrilweb.integration.entity.PrTModuloMailInviti;
import it.csi.portril.portrilweb.integration.entity.PrVModuliUtentiCoompilatori;
import it.csi.portril.portrilweb.util.LogUtil;

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
public  class PrTModuloMailInvitiImplDAO extends JpaDao<PrTModuloMailInviti, Long> implements PrTModuloMailInvitiDAO {

	private  LogUtil log = new LogUtil(getClass());
	
	@Override
	public PrTModuloMailInviti create(PrTModuloMailInviti entity) {
		entity.setIdModuloMailInvito(null);	
		super.save(entity);
		return entity;
	}

	public PrTModuloMailInviti update(PrTModuloMailInviti entity) {
		Date now = new Date();	
		entity.setDataInvio(now);
		super.update(entity);
		return entity;
	}
	
	public void delete(PrTModuloMailInviti entity) {
		super.delete(entity);
	}

	@Override
	public List<PrVModuliUtentiCoompilatori> getListaMailSollecitiUtentiCompilatoriFromModulo(Long idModuloSel, String gruppoSollecito) {
		String methodName = "getListaMailSollecitiUtentiCompilatoriFromModulo";

		StringBuilder sql = new StringBuilder();
		Map<String, Object> param = new HashMap<String, Object>();
		
		sql.append(" SELECT ");
		sql.append(" DISTINCT ");
		sql.append(" 	 pr_t_moduli.id_modulo");
		sql.append(" 	,pr_t_moduli.nome nome_modulo");
		sql.append(" 	,pr_t_moduli.descrizione ");
		sql.append(" 	,pr_t_moduli.data_inizio_compilazione ");
		sql.append(" 	,pr_t_moduli.data_fine_compilazione ");
		sql.append(" 	,pr_t_moduli.tipo ");
		sql.append(" 	,pr_t_moduli.obblig_conferma ");
		sql.append(" 	,pr_t_utenti_compilatori.codice_fiscale ");
		sql.append(" 	,pr_t_utenti_compilatori.nome nome_utente");
		sql.append(" 	,pr_t_utenti_compilatori.cognome ");
		sql.append(" 	,pr_t_utenti_compilatori.mail ");
		sql.append(" 	,pr_t_utenti_compilatori.telefono  ");
		sql.append(" 	,pr_t_utenti_compilatori.stato");
		sql.append("    ,pr_t_conferme_moduli.modulo_confermato");
		sql.append(" 	,pr_t_conferme_moduli.modulo_validato");
		sql.append(" FROM ");
		sql.append(" 	 pr_t_moduli");
		sql.append(" 	,pr_t_conferme_moduli ");
		sql.append(" 	,pr_r_moduli_enti_compilatori");
		sql.append(" 	,pr_t_enti_compilatori");
		sql.append(" 	,pr_r_enti_utenti_compilatori");
		sql.append(" 	,pr_t_utenti_compilatori");
		sql.append(" WHERE ");
		sql.append("      pr_t_moduli.id_modulo =  pr_r_moduli_enti_compilatori.id_modulo");
		sql.append("  AND pr_r_moduli_enti_compilatori.id_ente_compilatore =  pr_t_enti_compilatori.id_ente_compilatore");
		sql.append("  AND pr_t_enti_compilatori.id_ente_compilatore =  pr_r_enti_utenti_compilatori.id_ente_compilatore");
		sql.append("  AND pr_r_enti_utenti_compilatori.id_utente_compilatore =  pr_t_utenti_compilatori.id_utente_compilatore");
		sql.append("  AND pr_t_moduli.id_modulo =  pr_t_conferme_moduli.id_modulo ");

		sql.append("  AND pr_t_moduli.id_modulo = :idModuloSel");
		param.put("idModuloSel", idModuloSel);
		if(gruppoSollecito!=null)
		if (gruppoSollecito.equals("moduloNonCompilato")){
			sql.append("  AND not exists ( select 1 from pr_t_righe  where pr_t_righe.id_modulo = :idModuloSel ) ");
		}else if(gruppoSollecito.equals("moduloNonConfermato")){
			sql.append("  AND pr_t_conferme_moduli.modulo_confermato != 'SI' ");
		}		
		sql.append(" ORDER BY pr_t_moduli.id_modulo ");
		
		Query query = createNativeQuery(sql.toString(), param);
		
		List<Object[]> resultList = query.getResultList();
		
		List<PrVModuliUtentiCoompilatori> result = new ArrayList<PrVModuliUtentiCoompilatori>();
		for(Object[] obj : resultList) {
			PrVModuliUtentiCoompilatori p = new PrVModuliUtentiCoompilatori();
			p.setIdModulo(((BigDecimal) obj[0]).longValue());		
			p.setNomeModulo((String) obj[1]);
			p.setDescrizione((String) obj[2]);
			p.setDataInizioCompilazione((Date) obj[3]);
			p.setDataFineCompilazione((Date) obj[4]);
			p.setTipo((String) obj[5]);
			p.setObbligConferma((String) obj[6]); 
			p.setCodiceFiscale((String) obj[7]);
			p.setNomeUtente((String) obj[8]);
			p.setCognome((String) obj[9]);
			p.setMail((String) obj[10]);
			p.setTelefono((String) obj[11]); 
			p.setStato((String) obj[12]);
			p.setModuloConfermato((String) obj[13]);
			p.setModuloValidato((String) obj[14]);		
			result.add(p);
		}		
		log.stopMethod(methodName);		
		return result;		
	}
}