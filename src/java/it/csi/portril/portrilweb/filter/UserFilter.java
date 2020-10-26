/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.filter;


import it.csi.portril.portrilweb.model.UtentiCompilatoriModel;
import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.LogUtil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import org.apache.log4j.Logger;

public class UserFilter implements Filter{
	
	//Logger log = Logger.getLogger(UserFilter.class);
	private  LogUtil log = new LogUtil(getClass());
	
	FilterConfig filterConfig;
	String loginCompilatoreUrl;//url alla quale rimandare l'applicativo se manca l'oggetto Utente		


	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(   ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		String nomeMetodo="doFilter";
		String path = (String)((HttpServletRequest) request).getServletPath();

		log.debug(nomeMetodo,"[UserFilter::doFilter] START SERVLET FILTER: " + path);
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		// leggo lo userContainer
		
		UtentiCompilatoriModel user = (UtentiCompilatoriModel) session.getAttribute(Costanti.UTENTE_COMP_LOGGATO.getCostante());
		
		
		if(user==null){
			log.info(nomeMetodo,"[UserFilter::doFilter] utente non presente in sessione. Redirect alla Login di autenticazione del Compilatore");
			
			((HttpServletResponse)response).sendRedirect(loginCompilatoreUrl);
			return;
		}
		chain.doFilter(request, response);

	    log.debug(nomeMetodo,"[UserFilter::doFilter] END SERVLET FILTER: " + path);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		String nomeMetodo="init";
		log.info(nomeMetodo,"[UserFilter::init] init filtro per portale rilevazione");
		
		this.filterConfig = filterConfig;
		
		loginCompilatoreUrl = this.filterConfig.getInitParameter("loginCompilatoreUrl");
		
		log.debug(nomeMetodo,"[UserFilter::init] init filtro per incarichi per portale rilevazione");
	}

}
