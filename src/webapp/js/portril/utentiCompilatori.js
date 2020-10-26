/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
	// Avendo messo il codice all'interno di questa funzione,
	// viene eseguito solo quando la pagina viene caricata

	$("#salvaUtenteCompilatore").click(function(){
		$("form").attr("action", "salvaUtenteCompilatore.do").submit();
	});

	$("#cerca").click(function(){
		$("form").attr("action", "cercaEnte.do").submit();
	});

	$(document).on("click", ".pulsanteAssocia", function() {
		var form = $("form");
		// Imposto nel campo hidden il valore che è presente nel campo data-uid del bottone cliccato
		$("#idEnteAssociato").val($(this).data("uid"));
		form.attr("action", "associaUtenteEnte.do");
		form.submit();
		//console.log($(this).data("uid"))
	});

	$(document).on("click", ".pulsanteDisassocia", function() {
		var form = $("form");
		// Imposto nel campo hidden il valore che è presente nel campo data-uid del bottone cliccato
		$("#idEnteDisAssociato").val($(this).data("uid"));
		form.attr("action", "disassociaUtenteEnte.do");
		form.submit();
		//console.log($(this).data("uid"))
	});

	/*var opts = {
		oLanguage: {
			sZeroRecords: 'Nessun ente trovato',
			sEmptyTable: 'Nessun ente trovato'
		}
	};

	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);
	*/
	$("#tabellaRisultatiEnti").dataTable(dataTableOptions);

	//$("#tabellaEntiAssociati").dataTable(dataTableOptions);


});