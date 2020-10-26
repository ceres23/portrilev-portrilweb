/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

public class DataTableModel extends GenericModel  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4392319114962267384L;
	private String sEcho;
	private int iDisplayStart;
	private int iDisplayLength;
	
	/**
	 * @return the sEcho
	 */
	public String getsEcho() {
		return sEcho;
	}
	
	/**
	 * @param sEcho the sEcho to set
	 */
	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}
	/**
	 * @return the iDisplayStart
	 */
	public int getiDisplayStart() {
		return iDisplayStart;
	}
	
	/**
	 * @param iDisplayStart the iDisplayStart to set
	 */
	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}
	
	/**
	 * @return the iDisplayLength
	 */
	public int getiDisplayLength() {
		return iDisplayLength;
	}
	
	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	
	public int getNumeroPagina() {
		if(iDisplayLength == 0) {
			return 0;
		}
		return this.iDisplayStart / this.iDisplayLength;
	}
	
}
