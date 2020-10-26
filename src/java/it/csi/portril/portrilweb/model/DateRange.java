/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model;
import it.csi.portril.portrilweb.util.UtilDate;

import java.util.Date;

public class DateRange extends GenericModel{
	
	private static final long serialVersionUID = -5843151836478894126L;

	private Date dataInizio;

	private Date dataFine;

	/**
	 * @return the dataInizio
	 */
	public Date getDataInizio() {
		return dataInizio;
	}

	/**
	 * @return the dataInizioStr
	 */
	public String getDataInizioStr() {
		return UtilDate.formatDate(dataInizio);
	}
	
	/**
	 * @param dataInizio the dataInizio to set
	 */
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	/**
	 * @return the dataFine
	 */
	public Date getDataFine() {
		return dataFine;
	}

	/**
	 * @param dataFine the dataFine to set
	 */
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

}
