/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {

	var btnSelect = $('input[name=modEnte]');
	$(btnSelect).click(function(){
		$('.btnVisible').show();
	});

	var opts = {
		oLanguage: {
			sZeroRecords: 'Nessun Ente compilatore trovato',
			sEmptyTable:  'Nessun Ente compilatore trovato'
		}
	};

	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);




	 $('a', '#tabellaRisultatiEnteCompilatore').click(function (event) {
		 event.preventDefault();
		 //da tener presente
		 //nell'html idUtente è scritto id-utente
		 var idEnte = $(this).data("idEnte");
		 $("#idEnteSel").val(idEnte);

		 var azione = $(this).data("azione");
		 var form = $("form");
		 form.attr("action", azione);
		 form.submit();


	 });

	 $("#tabellaRisultatiEnteCompilatore").dataTable(optsDaUtilizzare);

		$("#ricerca").click(function(){
			var form = $("form").attr("action", "ricerca.do")
			form.submit();
		});

		$("#visualizza").click(function(){
			$("form").attr("action", "visualizza.do").submit();
		});

});
