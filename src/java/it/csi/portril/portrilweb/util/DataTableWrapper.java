/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;


import it.csi.portril.portrilweb.model.DataTableModel;
import it.csi.portril.portrilweb.util.paginazione.ListaPaginata;

import java.util.ArrayList;
import java.util.List;


public class DataTableWrapper<T> {

	public String sEcho;
	public int iDisplayStart;
	public int iDisplayLength;
	
	public int iTotalRecords;
	public int iTotalDisplayRecords;
	public List<T> aaData = new ArrayList<T>();

	public int numTotalPage;
	
	
	public DataTableWrapper() {
	}
	
	public DataTableWrapper(DataTableModel dataTableModel, ListaPaginata<T> listaPaginata) {
		this(
				dataTableModel.getsEcho(),
				dataTableModel.getiDisplayStart(),
				dataTableModel.getiDisplayLength(),
				listaPaginata.getTotaleElementi(),
				listaPaginata.getTotaleElementi(),
				listaPaginata);
	}
	
	public DataTableWrapper(String sEcho, int iDisplayStart,
			int iDisplayLength, int iTotalRecords, int iTotalDisplayRecords,
			List<T> aaData) {
		super();
		this.sEcho = sEcho;
		this.iDisplayStart = iDisplayStart;
		this.iDisplayLength = iDisplayLength;
		this.iTotalRecords = iTotalRecords;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.aaData = aaData;
	}

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
	 * @return the iTotalRecords
	 */
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	
	/**
	 * @param iTotalRecords the iTotalRecords to set
	 */
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	
	/**
	 * @return the iTotalDisplayRecords
	 */
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	
	/**
	 * @param iTotalDisplayRecords the iTotalDisplayRecords to set
	 */
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
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
	
	/**
	 * @param iDisplayLength the iDisplayLength to set
	 */
	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	
	/**
	 * @return the aaData
	 */
	public List<T> getAaData() {
		return aaData;
	}
	
	/**
	 * @param aaData the aaData to set
	 */
	public void setAaData(List<T> aaData) {
		this.aaData = aaData != null ? aaData : new ArrayList<T>();
	}

	/**
	 * @return the numTotalPage
	 */
	public int getNumTotalPage() {
		if(iTotalRecords ==0){
			return 0;
		}
		return (iTotalRecords / iDisplayLength)+1;
	}
	
}
