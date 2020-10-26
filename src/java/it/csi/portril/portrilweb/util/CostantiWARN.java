/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;

public enum CostantiWARN {
	
	
	WAR_RIC ("Il numero di risultati risulta troppo oneroso si prega di raffinare la ricerca"),
	WARN_ENTE_COMP_OBBL("Per salvare l'utente devi necessariamente associare almeno 1 ente compilatore"),
	WARN_ENTE_COMP_MAIL_OBBL("Mail non inviata.. Il modulo selezionato non e' ancora stato associato a nessun ente compilatore "),
	WARN_MAIL_MODULO_DATE_NON_COMPILATE("Le date di inizio e fine modulo devono essere compilate prima dell'invio della mail di invito"),
	RICERCA0("La ricerca non ha prodotto risultati"), 
	TROPPE_RIGHE_CSV("Csv troppo grande si consiglia lo scarico dei singoli moduli"), 
	
	/*
	WAR_RIC ("Il numero di risultati risulta troppo oneroso si prega di raffinare la ricerca"),
	WARN_ENTE_COMP_OBBL("Per salvare l'utente devi necessariamente associare almeno 1 ente compilatore"),
	WARN_ENTE_COMP_MAIL_OBBL("Mail non inviata.. Il modulo selezionato non e' ancora stato associato a nessun ente compilatore "),	
	WARN_MAIL_MODULO_DATE_NON_COMPILATE("Le date di inizio e fine modulo devono essere compilate prima dell'invio della mail di invito"), 
	RICERCA0("La ricerca non ha prodotto risultati"),
	*/
	;
	
	private String costante;
	
	private CostantiWARN(String costante) {
		this.costante = costante;
	}
	
	private CostantiWARN() {
		this.costante = this.name();
	}
	
	public String getCostante() {
		return costante;
	}

	
}
