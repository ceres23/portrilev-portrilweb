/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class Validazioni {
	// private static LogUtil log = new LogUtil(Validazioni.class);

	/**
	 * 
	 * @param value
	 * @param numlen
	 * @return
	 */
	public boolean isValidCodiceFiscale(String value, int numlen) {
		if (value.length() == numlen) {
			return true;
		}

		return StringUtils.isBlank(value)
				|| isValidMask(
						value,
						"^[A-Z]{6}[0-9LMNPQRSTUV]{2}[A-Z][0-9LMNPQRSTUV]{2}[A-Z][0-9LMNPQRSTUV]{3}[A-Z]$",
						Pattern.CASE_INSENSITIVE)
				&& isValidControlCharCodiceFiscale(value);
	}

	private boolean isValidControlCharCodiceFiscale(String codiceFiscale) {
		return codiceFiscale.charAt(15) == calcControlCharCodiceFiscale(StringUtils.substring(codiceFiscale, 0, 15));
	}

	private char calcControlCharCodiceFiscale(String string) {
		int sum = 0;

		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);

			int x = (Character.isDigit(c) ? Character.getNumericValue(c)
					: new String(new char[] { c }).getBytes()[0] - 65);

			sum += ((i + 1) % 2 == 0 ? x : new int[] { 1, 0, 5, 7, 9, 13, 15,
					17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22,
					25, 24, 23 }[x]);
		}

		return (char) ((sum % 26) + 65);
	}

	/**
	 * 
	 * @param value
	 * @param mask
	 * @return
	 */
	public boolean isValidMask(String value, String mask) {
		// regexp:
		// http://articles.sitepoint.com/article/java-regex-api-explained

		if (StringUtils.isNotEmpty(value)) {
			Pattern pattern = Pattern.compile(mask);
			Matcher matcher = pattern.matcher(value);
			return matcher.find();
		}

		return true;
	}

	private boolean isValidMask(String value, String mask, int flags) {
		// regexp:
		// http://articles.sitepoint.com/article/java-regex-api-explained

		if (StringUtils.isNotEmpty(value)) {
			Pattern pattern = Pattern.compile(mask, flags);
			Matcher matcher = pattern.matcher(value);
			return matcher.find();
		}

		return true;
	}
	
	private static final Pattern[] CONTROLLO_SICUREZZA_PW_PATTERN = new Pattern[] {
		Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$"),
//		Pattern.compile("^(?=.*[\\.,\\-_\\*\\!\\?#@\\$\\%\\&]).*$")     // caratteri speciali 
	};

	public boolean controlloSicurezzaPw(String passwordNuova) {
		
		for (Pattern pattern : CONTROLLO_SICUREZZA_PW_PATTERN) {
			if (!pattern.matcher(passwordNuova).matches()) {
				return false;
			}
		}
		
		return true;
	}

	
}
