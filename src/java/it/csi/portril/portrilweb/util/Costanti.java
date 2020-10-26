/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;

public enum Costanti {
	/*
	public static final String APPLICATION_CODE = "portril";
	public static final Integer ANNO_START = 2006;

	public static final String SEPARATORE_DATA = "/";
	public static final String SEPARATORE_MINUTI_SECONDI = ":";
	public static final String APP_CODE = "CPEC";
	public static final String SI = "S";
	public static final String NO = "N";

	public static final String PATTERN_ORE_MINUTI = "%s ore %s minuti";
	public static final String PATTERN_ORE  = "%s ore";
	public static final String PATTERN_EURO = "%s euro";
	public static final Integer NUMREC = 50;
	public static final Integer requiredPageNumber = 1;
	public static final Integer numberOfItemsPerPage = 50;
	public static final Integer numberOfNumbers = 5;
	public static final String FORMATO_DATASTR  = "dd/MM/yyyy";
	public static final String FORMATO_DATADB   = "yyyy-MM-dd";
	public static final String ASTERISCO = "********";
	public static final String MAXITEMAMAP = "500";
	public static final String MAXITEMCPEC = "500";
	public static final String SEPARATORE = "***";
	
	public static final String UTENTE_COMPILATORE            = "utenteCompilatore";
	public static final String UTENTE_GESTORE                = "utenteGestore";
	public static final String LISTAENTICOMPILATORIRICERCATI = "listaEntiCompilatoriRicercati";
	public static final String LISTAENTICOMPILATORIASSOCIATI = "listaEntiCompilatoriAssociati";
	public static final String LISTAPROFILIUTENTIGESTIONE    = "listaprofiliutentiGestione";*/
	
	UTENTE_COMPILATORE ,
	UTENTE_GESTORE_CONNESSO,
	LISTA_ENTI_COMPILATORI_RICERCATI,
	LISTA_ENTI_COMPILATORI_ASSOCIATI,
	LISTA_PROFILI_UTENTI_GESTIONE,
	LISTA_PROFILI_UTENTI_GESTORI_ALL, 
	ID_UTENTE_GESTORE_MOD, 
	LISTA_COLONNE_MODULO, 
	ID_ENTE_GESTORE_SEL, 
	ID_ENTE_COMPILATORE_SEL, 
	DISATTIVO, 
	ATTIVO, 
	ASSOCIATO,
    DISASSOCIATO,
	MODULOSEL, 
	CHIUSO, 
	IN_COMPILAZIONE, 
	IN_DEFINIZIONE,
	IN_COMPILAZIONE_OR_CHIUSO, 
	ID_ENTE_COMPILATORE_MOD, 
	ID_UTENTE_COMPILATORE_MOD, 
	ID_MODULO_SEL, 
	RIGHEMODULO_RICERCATE,
	COLONNEMODULO, 
	MOD_ENTE, DETTAGLIODATIENTE, 
	MODULO_SEL, 
	LISTA_MODULI_RICERCATI, 
	IDMODULO_DA_COPIARE, 
	COLONNEMODULO_DA_COPIARE, 
	UTENTE_COMP_LOGGATO, 
	UTENTE_COMPILATORE_TMP, 
	COMPILATORE,
	GESTORE,
	VALIDATORE, 
	ERR,
	WARN,
	SI,
	NO,
	DIVERSO,
	MINORE,
	MAGGIORE,
	MINOREUGUALE, 
	MAGGIOREUGUALE, 
	UGUALE, 
	ALL, 
	FORM, 
	MODIFICABILE, 
	TUTTI,
	DA_COMPILARE,
	COMPILATO, 
    LISTACOLONNEDACLONARE,  
    DESC_ENTE_GESTORE_SEL, 
    
	ALFANUMERICO ("Alfanumerico"),
	NUMERICO ("Numerico"),
	DATA ("Data"),
	DELIBERA ("Delibera"),
	DETERMINA ("Determina"),
	DAVALIDARE,
	VALIDATI, 
	PW_NOT_SECURE,
	
	FEEDBACKERROR ("feedbackError"),
	FEEDBACKWARNING ("feedbackWarning"),
	FEEDBACKSUCCESS ("feedbackSuccess"),	
	APPLICATION_CODE ("portril"),
	FORMATO_DATASTR ("dd/MM/yyyy"),
	FORMATO_DATADB ("yyyy-MM-dd"),
	NUM_MAX_RIC ("200"),
	SEPARATORE_COMMA(","),
	SEPARATORE_SEMICOLON(";"),
	SEPARATORE_PROV("-"),
	STEP_NUM_MAIL("50"),
	SVILUPPO,
	LOCALE,
	MAX_NUM_CSV("5000"),
	TIPO_FILE_CSV("text/csv"), 
	EXT_CSV("csv"), 
	
	
	
	/*
	UTE_DISATTIVO("Utente disattivato con successo"),
	UTE_ATTIVO("Utente attivato con successo"),
	MSG_OK("Operazione avvenuta Correttamente"),
	CANCELLAZIONE_OK("Cancellazione avvenuta con successo"),
	MSG_UTENTE_COMP_OK ("Utente compilatore inserito con successo"), 
	MSG_UTENTE_COMP_AUTOGEN_OK ("Utente inserito con successo, controlla la tua casella di posta per ottenere le tue credenziali d'accesso"), 
	MSG_MODULO_OK ("Modulo aggiornato con successo"), 
	UTENTE_GESTORE_NODEL("L'utente gestore selezionato non puo' essere cancellato "),
	ENTE_COMPILATORE_NODEL("L'ente compilatore selezionato non puo' essere cancellato "),
	UTENTE_COMPILATORE_NODEL("L'utente compilatore selezionato non puo' essere cancellato "),
	MODIFICA_ENTE_OK("L'ente compilatore e' stato modificato correttamente "),
	MODIFICA_UTENTE_COMP_OK("L'utente compilatore e' stato modificato correttamente "),
	MAIL_GIA_INVIATE ("non si puo' eliminare il Modulo dato che sono state gia' inviate le mail di invito"),
	RIGHE_PRESENTI("non si puo' eliminare il Modulo dato che sono state gia' redatte delle righe da parte dei compilatori"),
	MODULO_DEL_OK("Modulo eliminato correttamente"),
	INS_ENTE_COMP_OK("Ente compilatore inserito correttamente"),
	MAIL_OK("Mail inviata carrettamente"),
	PW_OK("Password aggiornata con successo"),
	UPLOAD_OK("Caricamento file avvenuto correttamente"),
	LOAD_MODULO_OK("Caricamento modulo avvenuto correttamente"), 
	LOGIN_DISATTIVO("Utente disattivato"), 
	*/
	         UTE_DISATTIVO("Utente disattivato con successo"),
	         UTE_ATTIVO("Utente attivato con successo"),
	         MSG_OK("Operazione avvenuta Correttamente"),
	         CANCELLAZIONE_OK("Cancellazione avvenuta con successo"),
	         MSG_UTENTE_COMP_OK ("Utente compilatore inserito con successo"),
	         MSG_UTENTE_COMP_AUTOGEN_OK ("Utente inserito con successo, controlla la tua casella di posta per ottenere le tue credenziali d'accesso"),
	         MSG_MODULO_OK ("Modulo aggiornato con successo"),    
	         UTENTE_GESTORE_NODEL("L'utente gestore selezionato non puo' essere cancellato "),
	         ENTE_COMPILATORE_NODEL("L'ente compilatore selezionato non puo' essere cancellato "),
	         UTENTE_COMPILATORE_NODEL("L'utente compilatore selezionato non puo' essere cancellato "),
	         MODIFICA_ENTE_OK("Ente compilatore modificato con successo. "),
	         MODIFICA_UTENTE_COMP_OK("Utente compilatore modificato con successo."), 
	         MAIL_GIA_INVIATE ("Impossibile eliminare il  modulo. Mail di invito gia' inviata."),
	         RIGHE_PRESENTI("Impossibile eliminare il modulo. Sono gia' stati inseriti dei dati"), 
	         MODULO_DEL_OK("Modulo eliminato con successo"),
	         INS_ENTE_COMP_OK("EnteCompilatore eliminato con successo"),
	         MAIL_OK("Mail inviata con successo"),
	         PW_OK("Password aggiornata con successo"),

	         LOAD_MODULO_OK("Caricamento modulo avvenuto correttamente"),
	         LOGIN_DISATTIVO("Utente disattivato"), 
	         LOAD_CSV_IN_CORSO("Caricamento dei del csv in corso... si prega di attendere qualche minuto"), 
	         LOAD_IN_CORSO("Caricamento dei dai in corso...  i dati saranno disponibili fra non meno di 10 minuti"), 
	         TIPO_MODULO_RILEVAZIONE("RILEVAZIONE"),
	         TIPO_MODULO_COMUNICAZIONE("COMUNICAZIONE"), 
	         COD_FIS_ENTE("Codice Fiscale Ente"), NUM_TOTAL_RECORDS,
	         NON_EDITABILE("NON EDITABILE"), 
	         
	;
	
	private String costante;
	
	private Costanti(String costante) {
		this.costante = costante;
	}
	
	private Costanti() {
		this.costante = this.name();
	}
	
	public String getCostante() {
		return costante;
	}

	
}
