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

		var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);

		$("#tabellaListaRisultatiModuli").dataTable(optsDaUtilizzare);

		$('a[data-azione]').click(function (event) {
			event.preventDefault();
			//da tener presente
			//nell'html idUtente  scritto id-Modulo
			var idModulo = $(this).data("idModulo");
			$("#idModuloSel").val(idModulo);

			var azione = $(this).data("azione");
			var form = $("form");
			form.attr("action", azione);
			form.submit();

		});


		$("#cerca").click(function(){
			$("form").attr("action", "ricerca.do").submit();
		});


});