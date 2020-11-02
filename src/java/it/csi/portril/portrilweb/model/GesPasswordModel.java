/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import it.csi.portril.portrilweb.util.Utility;

import javax.validation.constraints.Size;

public class GesPasswordModel extends GenericModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2799959502511299606L;
	
	@Size(min=1)
	private String passwordAttuale;
	
	@Size(min=1)
	private String passwordNuova;
	
	@Size(min=1)
	private String passwordRipetiNuova;
	
	
	/**
	 * @return
	 */
	public String getPasswordAttuale() {
		return passwordAttuale;
	}
	/**
	 * @param passwordAttuale
	 */
	public void setPasswordAttuale(String passwordAttuale) {
		this.passwordAttuale = passwordAttuale;
	}
	/**
	 * @return
	 */
	public String getPasswordNuova() {
		return passwordNuova;
	}
	/**
	 * @param passwordNuova
	 */
	public void setPasswordNuova(String passwordNuova) {
		this.passwordNuova = passwordNuova;
	}
	/**
	 * @return
	 */
	public String getPasswordRipetiNuova() {
		return passwordRipetiNuova;
	}
	/**
	 * @param passwordRipetiNuova
	 */
	public void setPasswordRipetiNuova(String passwordRipetiNuova) {
		this.passwordRipetiNuova = passwordRipetiNuova;
	}
	
	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return getClass().getName() + '@' + Integer.toHexString(hashCode());
	}
}
