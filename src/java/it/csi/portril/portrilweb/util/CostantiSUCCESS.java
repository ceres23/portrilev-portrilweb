/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;

public enum CostantiSUCCESS {
	 
	;
	
	private String costante;
	
	private CostantiSUCCESS(String costante) {
		this.costante = costante;
	}
	
	private CostantiSUCCESS() {
		this.costante = this.name();
	}
	
	public String getCostante() {
		return costante;
	}

	
}
