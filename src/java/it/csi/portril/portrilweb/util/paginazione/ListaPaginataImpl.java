/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util.paginazione;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

//@XmlType(namespace = CORSvcDictionary.NAMESPACE)
public class ListaPaginataImpl<T> extends ArrayList<T> implements ListaPaginata<T> {
	private static final long serialVersionUID = -2196317924251371579L;

	private int paginaCorrente;
	private int totalePagine;
	private int totaleElementi;
	private int numeroElementoInizio;
	private int numeroElementoFine;
	private boolean hasPaginaPrecedente;
	private boolean hasPaginaSuccessiva;

	public ListaPaginataImpl(List<T> list) {
		super(list);
	}

	public ListaPaginataImpl() {
		super();
	}

	public int getPaginaCorrente() {
		return paginaCorrente;
	}

	public void setPaginaCorrente(int paginaCorrente) {
		this.paginaCorrente = paginaCorrente;
	}

	public int getTotalePagine() {
		return totalePagine;
	}

	public void setTotalePagine(int totalePagine) {
		this.totalePagine = totalePagine;
	}

	public int getTotaleElementi() {
		return totaleElementi;
	}

	public void setTotaleElementi(int totaleElementi) {
		this.totaleElementi = totaleElementi;
	}

	public int getNumeroElementoInizio() {
		return numeroElementoInizio;
	}

	public void setNumeroElementoInizio(int numeroElementoInizio) {
		this.numeroElementoInizio = numeroElementoInizio;
	}

	public int getNumeroElementoFine() {
		return numeroElementoFine;
	}

	public void setNumeroElementoFine(int numeroElementoFine) {
		this.numeroElementoFine = numeroElementoFine;
	}

	public boolean getHasPaginaPrecedente() {
		return hasPaginaPrecedente;
	}

	public void setHasPaginaPrecedente(boolean hasPaginaPrecedente) {
		this.hasPaginaPrecedente = hasPaginaPrecedente;
	}

	public boolean getHasPaginaSuccessiva() {
		return hasPaginaSuccessiva;
	}

	public void setHasPaginaSuccessiva(boolean hasPaginaSuccessiva) {
		this.hasPaginaSuccessiva = hasPaginaSuccessiva;
	}

	public boolean isPrimaPagina() {
		return paginaCorrente == 0;
	}

	public boolean isUltimaPagina() {
		return paginaCorrente == totalePagine - 1;
	}

	
}
