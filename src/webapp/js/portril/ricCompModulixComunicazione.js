/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
	
	var opts = {
			oLanguage : {
				sZeroRecords : 'Nessun Modulo trovato',
				sEmptyTable : 'Nessun Modulo trovato',
				sScrollX: "100%",
				sScrollXInner: "110%",
				bScrollCollapse: true	
			}
		};
	
	/*
	$('tr td:nth-child(2)', '#tabellaListaRisultatiModuliDaCompilare').each(function(idx, el) {
		var $el = $(el);
		var innerHtml = $el.html();
		innerHtml = innerHtml.split(/\s+/).map(function(el) {
			return el.match(/(.{1,40})/g).join('<wbr/>');
		}).join(' ');
		$el.html(innerHtml);
	});
	*/
	
	
	$('tr td:nth-child(2)', '#tabellaListaRisultatiModuliDaCompilare').each(function(idx, el) {
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
	
	
	$("#ricerca").click(
			function() {$("form").attr("action", "ricerca.do").submit();}
	);



	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);
	$("#tabellaListaRisultatiModuliDaCompilare").dataTable(optsDaUtilizzare);

    // permette di delegare la gestione dei click
	$(document).on('click', 'a[data-azione]',
		function(e) {
			e.preventDefault();
			submitDelForm.call(this);
		}
	);

	$(document).on('change', 'input.upload',
		function() {
			$(this).attr("name", "file");
			$("#modalinoDiAttesa").modal("show");
			submitDelForm.call(this);
		}
	);

	function submitDelForm () {
		//da tener presente
		//nell'html idUtente e' scritto id-modulo
		var idModulo = $(this).data("idModulo");
		$("#idModuloSel").val(idModulo);

		var azione = $(this).data("azione");
		var form = $("form");
		form.attr("action", azione);
		form.submit();

	}
});