/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilDate {

	private static LogUtil log = new LogUtil(Utility.class);


	
	private UtilDate() {
		
	}

	/**
	 * 
	 * @param anno
	 * @param mese
	 * @param giorno
	 * @return
	 */
	public static Date getDate(Integer anno,Integer mese ,Integer giorno) {
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, anno);
	    cal.set(Calendar.MONTH, mese);
	    cal.set(Calendar.DAY_OF_MONTH, giorno);
	    Date dateRepresentation = cal.getTime();

		return dateRepresentation;
	}
	/**
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String date, String pattern) {
		String methodName = "parseDate";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		if (date == null){
			return null;
		}
		try {
			return sdf.parse(date);
		} catch (Exception e) { 
			log.error(methodName,e);
		}
		return null;
	}


	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		return formatDate(date, Costanti.FORMATO_DATASTR.getCostante(), "");
	}


	/**
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		return formatDate(date, pattern, null);
	}

	/**
	 * 
	 * @param date
	 * @param pattern
	 * @param nulldate
	 * @return
	 */
	public static String formatDate(Date date, String pattern, String nulldate) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (date == null) {
			return nulldate;
		}
		return sdf.format(date);
	}

	/**
	 * 
	 * @param date
	 * @param patternOrigin
	 * @param patternDest
	 * @return
	 */
	public static String formatDateByString(String date, String patternOrigin,
			String patternDest) {
		return formatDate(parseDate(date, patternOrigin), patternDest);
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateByString(String date) {
		return formatDate(parseDate(date, "yyyy-MM-dd"), "dd/MM/yyyy");
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateByString(Date date) {
		if (date != null) {
			return formatDate(parseDate(date.toString(), "yyyy-MM-dd"),"dd/MM/yyyy");
		}
		return null;
	}

	/**
	 * 
	 * @param dateToValidate
	 * @param dateFromat
	 * @return
	 */
	public static boolean isDateValid(String dateToValidate, String dateFromat){
		 
		if(dateToValidate == null || dateToValidate.trim().length()<10){
			return false;
		}
 
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
 
		try {
			sdf.parse(dateToValidate);
		} catch (ParseException e) {
			return false;
		}
 
		return true;
	}
	
	private static final ThreadLocal<SimpleDateFormat> TL_SDF = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("dd/MM/yyyy");
		}
	};

	/**
	 * 
	 * @return
	 */
	public static Integer getAnnoCorrente() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

}
