/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model.exception;

public class ControlloFormaleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6203218996294285028L;

	/**
	 * 
	 */
	public ControlloFormaleException() {
	}

	/**
	 * @param message
	 */
	public ControlloFormaleException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ControlloFormaleException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ControlloFormaleException(String message, Throwable cause) {
		super(message, cause);
	}

}
