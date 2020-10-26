/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {



	var opts = {
		oLanguage: {
			sZeroRecords: 'Nessun Ente compilatore trovato',
			sEmptyTable:  'Nessun Ente compilatore trovato'
		}
	};

	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);

	 $("#tabellaRisultatiEntiCompilatori").dataTable(optsDaUtilizzare);


	 $('#tabellaRisultatiEntiCompilatori').on('click', 'a', function (event) {
		 event.preventDefault();
		 //da tener presente
		 //nell'html idUtente scritto id-utente
		 var idEnte = $(this).data("idEnte");
		 $("#idEnteSel").val(idEnte);

		 var azione = $(this).data("azione");
		 var form = $("form");
		 form.attr("action", azione);
		 form.submit();


	 });



		$("#cerca").click(function(){
			$("form").attr("action", "ricerca.do").submit();
		});


});