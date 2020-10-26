/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {

	var opts = {
		oLanguage: {
			sZeroRecords: 'Nessun Utente compilatore trovato',
			sEmptyTable:  'Nessun Utente compilatore trovato'
		}
	};

	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);




	 $('a', '#tabellaRisultatiUtentiCompilatori').click(function (event) {
		 event.preventDefault();
		 //da tener presente
		 //nell'html idUtente è scritto id-utente
		 var idUtente = $(this).data("idUtente");
		 $("#idUtenteSel").val(idUtente);

		 var azione = $(this).data("azione");
		 var form = $("form");
		 form.attr("action", azione);
		 form.submit();


	 });

	 $("#tabellaRisultatiUtentiCompilatori").dataTable(optsDaUtilizzare);

	$("#ricerca").click(function(){
		$("form").attr("action", "ricerca.do").submit();
	});


});