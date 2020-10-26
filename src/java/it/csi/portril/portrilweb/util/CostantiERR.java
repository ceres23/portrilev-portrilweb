/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;


public enum CostantiERR {
/*
	ERR_MAIL("Errore in invio Mail si prega di riprovare se il problema dovesse persistere si prega di contattare l'assistenza"), 
	ERR_MAIL_NON_PRESENTE("La mail non corrisponde a nessun utente compilatore"),
	ERR_LOGIN_NOT_PRESENT("Valorizzare il campo login"),
	ERR_PW_NOT_PRESENT("Valorizzare il campo password"),
	ERR_PW2_NOT_PRESENT("Valorizzare il campo ripeti password"),
	ERR_PW_PW2("le password non coincidono"),
	ERR_PW_NON_COERENTE("password utente non coerente"),	
	ERR_PW_COINCIDENTI("la nuova password coincide con quella vecchia"),
	ERR_PW_CONTROLLO("la password non coincidono"),
	ERR_ASS_ENTE_UTE_OBBL("L'utente deve essere associato almeno ad un Ente Compilatore"),
	ERR_ESTENSIONE_NON_CSV("il file deve essere con estensione .csv es(nomefile.csv)"),
	ERR_TIPOLOGIA_CSV("il file deve essere un csv"),
	ERR_FILE_VUOTO("Il file risulta essere vuoto o inconsistente"),
	ERR_COLONNE_NON_CONFORMI("Il numero di colonne non e' conforme al numero del modulo selezionato"), 	
	ERR_NUM_CELLE_COLONNE("Una o piu' righe contengono un numero valori non uguale al numero di colonnne modulo contattare l'assistenza "), 	
	ERR_INTERNO("Errore generico applicativo si prega di riprovare , se l'errore dovesse persistere chiamare l'assistenza \n"),
	ERR_UTENTE_INSERITO("codice fiscale gia' censito sul sistema"), 
	ERR_ENTE_COMP_GIA_ESISTENTE("Inserimento non avvenuto il codice fiscale dell'ente e' gia' censito sul sistema"), 
	ERR_UTENTE_GEST_GIA_ESISTENTE("L'utente gestore e'  gia' censito sul sistema"), 
	ERR_DATA_INIZIO_NOW("Data incorretta la data Inizio deve essere superiore o uguale alla data odierna"), 
	ERR_LOGIN("Login/password inesistente o errata "), 
	ERR_MODELLO_ESISTENTE("Modello esistente se lo si vuole variare accedere alla sezione ricerca/modifica "), 

	
	*/
	
  ERR_MAIL("Errore invio mail. Si prega di riprovare. Se il problema persiste contattare l'assistenza."),
  ERR_MAIL_NON_PRESENTE("Mail non presente in archivio."),
  ERR_LOGIN_NOT_PRESENT("Login obbligatoria."),
  ERR_PW_NOT_PRESENT("Password obbligatoria."),
  ERR_PW2_NOT_PRESENT("Ripeti Password obbligatoria."),
  ERR_PW_PW2("Le password indicate non sono uguali."),
  ERR_PW_NON_COERENTE("Password attuale incorretta."),
  ERR_PW_COINCIDENTI("La nuova password non puo' essere uguale a quella precedente."),
  ERR_PW_CONTROLLO("Le password indicate non sono uguali."),
  ERR_ASS_ENTE_UTE_OBBL("L'utente deve essere associato almeno ad un Ente Compilatore."),
  ERR_ESTENSIONE_NON_CSV("L'estenzione del file e' .csv (es nomefile.csv)"),
  ERR_TIPOLOGIA_CSV("Formato file  errato. Deve essere csv."),
  ERR_FILE_VUOTO("Il file risulta essere vuoto o inconsistente."),
  ERR_COLONNE_NON_CONFORMI("Il numero di colonne presente nel file differisce dal numero di colonne presenti nel modulo."),
  ERR_NUM_CELLE_COLONNE("Una o piu' righe contengono un numero di valore diverso dal numero di colonne presenti nel modulo."),
  ERR_INTERNO("Errore generico. Si prega di riprovare. Se l'errore persiste chiamare l'assistenza."),
  ERR_UTENTE_INSERITO("Codice Fiscale gia' presente nel sistema."),
  ERR_ENTE_COMP_GIA_ESISTENTE("Inserimento non avventuo. Ente gia' presente nel sistema."),
  ERR_UTENTE_GEST_GIA_ESISTENTE("Inserimento non avventuo. Utente gestore gia' presente nel sistema."),
  ERR_DATA_INIZIO_NOW("Data non valida. La data di inizio validita' deve essere superiore o uguale alla data odierna."),
  ERR_LOGIN("Login/Password inesistente o errata."),
  ERR_MODELLO_ESISTENTE("Modulo gia' presente (Il Titolo modulo deve essere univoco). Per  modificare o integrare i suoi dati accedere in modifica del modulo."), 
  ERR_POS_COLONNA("Per i moduli di Comunicazione la prima colonna in posizione 1 e' riservata al " + Costanti.COD_FIS_ENTE.getCostante()), 
  ERR_DATI_PERS("Per l'autoregistrazione al portale dei pagamenti devi necessariamente dare il tuo consenso al trattamento dei dati personali"),
  ERR_FILE_MAX("File allegato troppo grande: dimensione massima consentita 3 MB "),
  ERR_FILE_NONGESTITO("Il File allegato e' di un formato non gestito: i formati validi sono PDF XLS DOC TXT"), 
  ERR_PW_NON_SICURA("La password attuale non soddisfa i criteri di sicurezza , prima di proseguire se ne richiede il cambio con una che abbia i seguenti criteri: lunghezza minima di 8 caratteri, presenza di caratteri numerici, presenza di caratteri alfanumerici sia maiuscoli che minuscoli"), 
  ERR_PW_NUOVA_NON_SICURA("La nuova password non soddisfa i criteri di sicurezza ,si richiede che sia almeno lunga 8 caratteri e contenga caratteri numerici , alfanumerici sia maiuscoli che minuscoli"),
  ERR_CAMPI_OBBLIGATORI_PW("I 3 campi Password attuale* Nuova password* e Conferma  Nuova password* sono Obbligatori"),
	;
	
	private String costante;
	
	private CostantiERR(String costante) {
		this.costante = costante;
	}
	
	private CostantiERR() {
		this.costante = this.name();
	}
	
	public String getCostante() {
		return costante;
	}
	
	
	
}
