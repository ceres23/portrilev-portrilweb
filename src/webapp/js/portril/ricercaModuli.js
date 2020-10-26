/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {

	var opts = {
		oLanguage: {
			sZeroRecords: 'Nessun Modulo trovato',
			sEmptyTable:  'Nessun Modulo trovato',
			sScrollX: "100%",
			sScrollXInner: "110%",
			bScrollCollapse: true	
		},
		// Dovrebbe salvare la pagina attuale (e le condizioni di filtro) in un cookie
		// per ricaricare la stessa videata (se non usi i cookie ti fotti)
		bStateSave: true
	};
	
	
	$('tr td:nth-child(2)', '#tabellaRisultatiModuli').each(function(idx, el) {
		var $el = $(el);
		var innerHtml = $el.html();
		console.log(innerHtml);
		innerHtml = innerHtml.split(/\s+/).map(function(el) {			
			var matches = el.match(/(.{1,40})/g);
			if(matches) {
				return matches.join('<wbr/>');
			}
			return el;
		}).join(' ');
		$el.html(innerHtml);
	});


	

	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);

	$('a[data-azione]').click(function (event) {
		event.preventDefault();
		//da tener presente
		//nell'html idUtente scritto id-Modulo
		var idModulo = $(this).data("idModulo");
		$("#idModuloSel").val(idModulo);

		var azione = $(this).data("azione");
		var form = $("form");
		form.attr("action", azione);
		form.submit();

	});
	$("#tabellaRisultatiModuli").dataTable(optsDaUtilizzare);

	$("#cerca").click(function(){
		//visualizzaDate();
		$("form").attr("action", "ricerca.do").submit();
	});

	$("#invia").click(function(){
		$("form").attr("action", "invia.do").submit();
	});

	var aperturaModale=$("#aperturaModale").val();
	if(aperturaModale==="true"){
		$("#msgInviaMail").modal("show");
	}

	$('input[name="tipo"]').change(visualizzaDate);

	function visualizzaDate() {

		if($("input[name='tipo']:checked").val() === "RILEVAZIONE"){
			$("#TipoRilevazione").removeClass("hide");
		}else{
			$("input[name='stato'][value='ALL']").prop("checked", true);
			$("#TipoRilevazione").addClass("hide");
		}
	}
	//viene eseguito alla coda di funzioni eseguite al caricamento della pagina
	visualizzaDate();

});

