/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;
import it.csi.portril.portrilweb.util.Utility;

public class LoginModel extends GenericModel{

	private static final long serialVersionUID = 9080809348104049672L;	
	private String password;
	private String user;
	private String email;
	private String loginReg;
	private String passwordReg;
	private String password2Reg;

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getLoginReg() {
		return loginReg;
	}

	/**
	 * @param loginReg
	 */
	public void setLoginReg(String loginReg) {
		this.loginReg = loginReg;
	}

	/**
	 * @return
	 */
	public String getPasswordReg() {
		return passwordReg;
	}

	/**
	 * @param passwordReg
	 */
	public void setPasswordReg(String passwordReg) {
		this.passwordReg = passwordReg;
	}

	/**
	 * @return
	 */
	public String getPassword2Reg() {
		return password2Reg;
	}

	/**
	 * @param password2Reg
	 */
	public void setPassword2Reg(String password2Reg) {
		this.password2Reg = password2Reg;
	}

	/* (non-Javadoc)
	 * @see it.csi.portril.portrilweb.model.GenericModel#toString(java.lang.Object)
	 */
	public String toString(Object obj) {
		return getClass().getName() + '@' + Integer.toHexString(hashCode());
	}
	
}
