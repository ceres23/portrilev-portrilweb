/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
	// Avendo messo il codice all'interno di questa funzione,
	// viene eseguito solo quando la pagina viene caricata
	/*
	$("#salvaUtenteCompilatore").click(function(){
		$("form").attr("action", "salvaUtenteCompilatore.do").submit();
	});

	$("#cerca").click(function(){
		$("form").attr("action", "cercaEnte.do").submit();
	});
	 */


	var opts = {
		oLanguage: {
			sZeroRecords: 'Nessun utente gestore trovato',
			sEmptyTable:  'Nessun utente gestore trovato'
		}
	};

	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);



	 $('a', '#tabellaRisultatiUtentiGest').click(function (event) {
		 event.preventDefault();
		 //da tener presente
		 //nell'html idUtente è scritto id-utente
		 var idUtenteSel = $(this).data("idUtente");
		 $("#IdUtenteSel").val(idUtenteSel);

		 var azione = $(this).data("azione");

		 var form = $("form");
		 form.attr("action", azione);
		 form.submit();


	 });

	 $("#tabellaRisultatiUtentiGest").dataTable(optsDaUtilizzare);


});