/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ServiceModel extends GenericModel{

	private static final long serialVersionUID = 3111588843630439863L;
	
	@NotNull
	@Size(min=1)
	private String parametro;

	/**
	 * @return
	 */
	public String getParametro() {
		return parametro;
	}

	/**
	 * @param parametro
	 */
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	
}
