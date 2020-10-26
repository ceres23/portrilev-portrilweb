/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;

import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogUtil {
	private Logger log;
	private String className;

	/**
	 * 
	 * @param clazz
	 */
	public LogUtil(Class clazz) {
		log = LogManager.getLogger(clazz);
		className = clazz.getSimpleName();

	}

	private String buildMsg(String methodName, Object msg) {
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(className).append("|").append(methodName).append("] ").append(msg);
		return sb.toString();
	}


	/**
	 * 
	 * @param methodName
	 */
	public void startMethod(String methodName) {
		log.info(buildMsg(methodName, "BEGIN"));
	}

	/**
	 * 
	 * @param methodName
	 */
	public void startMethodDebug(String methodName) {
		log.debug(buildMsg(methodName, "BEGIN"));
	}

	/**
	 * 
	 * @param methodName
	 * @param msg
	 */
	public void startMethod(String methodName, Object msg) {
		log.info(buildMsg(methodName, "BEGIN " + msg));
	}

	/**
	 * 
	 * @param methodName
	 */
	public void stopMethod(String methodName) {
		log.info(buildMsg(methodName,"END"));
	}

	public void stopMethod(String methodName,String paginaDestinazione) {
		log.info(buildMsg(methodName," vado alla pagina "+paginaDestinazione +" END"));
	}

	/**
	 * 
	 * @param methodName
	 */
	public void stopMethodDebug(String methodName) {
		log.debug(buildMsg(methodName, "END"));
	}
	/**
	 * 
	 * @param methodName
	 * @param msg
	 */
	public void stopMethod(String methodName, Object msg) {
		log.info(buildMsg(methodName, "END " + msg));
	}

	/**
	 * 
	 * @param methodName
	 * @param msg
	 */
	public void debug(String methodName, Object msg) {
		log.debug(buildMsg(methodName, msg));
	}

	/**
	 * 
	 * @param methodName
	 * @param msg
	 */
	public void info(String methodName, Object msg) {
		log.info(buildMsg(methodName, msg));
	}

	/**
	 * 
	 * @param methodName
	 * @param obj
	 */
	public void infoMultiLine(String methodName, Object obj) {
		log.info(buildMsg(methodName, ReflectionToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE)));
	}

	/**
	 * 
	 * @param methodName
	 * @param obj
	 */
	public void debugMultiLine(String methodName, Object obj) {
		log.debug(buildMsg(methodName, ReflectionToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE)));
	}
	
	/**
	 * 
	 * @param methodName
	 * @param msg
	 */
	public void warn(String methodName, Object msg) {
		log.warn(buildMsg(methodName, msg));
	}

	/**
	 * 
	 * @param methodName
	 * @param msg
	 * @param t
	 */
	public void warn(String methodName, Object msg, Throwable t) {
		log.warn(buildMsg(methodName, msg), t);
	}

	/**
	 * 
	 * @param methodName
	 * @param msg
	 */
	public void error(String methodName, Object msg) {
		log.error(buildMsg(methodName, msg));
	}

	/**
	 * 
	 * @param methodName
	 * @param msg
	 * @param t
	 */
	public void error(String methodName, Object msg, Throwable t) {
		log.error(buildMsg(methodName, msg), t);
	}

	/**
	 * 
	 * @param methodName
	 * @param msg
	 */
	public void fatal(String methodName, Object msg) {
		log.fatal(buildMsg(methodName, msg));
	}

	/**
	 * 
	 * @param methodName
	 * @param msg
	 * @param t
	 */
	public void fatal(String methodName, Object msg, Throwable t) {
		log.fatal(buildMsg(methodName, msg), t);
	}

	public static void main(String[] args) {
		new LogUtil(String.class);

	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return log.getName();
	}

	/**
	 * 
	 * @return
	 */
	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	/**
	 * 
	 * @param oggOper
	 * @param operazione
	 * @param utente
	 * @throws SQLException
	 * @throws NamingException
	 * @throws Exception
	 */
	public void audit(String oggOper, String operazione, String utente)
			throws SQLException, NamingException, Exception {
		audit(new Date(), "PORTRIL_PORTRILWEB", null, null, oggOper, operazione,
				utente);
	}

	/**
	 * 
	 * @param dataOra
	 * @param idApp
	 * @param ipAddress
	 * @param keyOper
	 * @param oggOper
	 * @param operazione
	 * @param utente
	 * @throws SQLException
	 * @throws NamingException
	 * @throws Exception
	 */
	public void audit(Date dataOra, String idApp, String ipAddress,
			String keyOper, String oggOper, String operazione, String utente)
			throws SQLException, NamingException, Exception {
		throw new UnsupportedOperationException();
		
	}
}
