/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {



	var opts = {
		oLanguage: {
			sZeroRecords: 'Nessun Ente trovato',
			sEmptyTable:  'Nessun Ente trovato'
		}
	};

	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);

	$("#tabellaRisultatiEntiCompilatoriModulo").dataTable(optsDaUtilizzare);


	$("#ricerca").click(function(){
		$("form").attr("action", "ricerca.do").submit();
	});

	$("#esporta").click(function(){
		$("form").attr("action", "esporta.do").submit();
	});



});