/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
	var firstToggle = true;
	var check = true;
	var listaIdDaSbloccare = document.getElementById('listaIdDaSbloccare');
	var opts = {
			oLanguage: {
				sZeroRecords: 'Nessun ente trovato',
				sEmptyTable: 'Nessun ente trovato'
			},
			bFilter: true,
			// con aLengthMenu
			//sDom: "<<'span12'<'span6'><'span6'f>><'span6'l><'span6'p>r>t<<'span6'i><'span6'p>>",
			// senza aLengthMenu
			//sDom: "< <'span12'<'span6'><'span6'f>><'span6'><'span6'p>r>t <<'span6'i><'span6'p>>",
			sDom: "<<<'span12 margin-botton10' <'span6'f><'span6'>>>      <<'span12'<'span6'i><'span6'p>r>>    t    <<'span12'<'span6'i><'span6'p>>>>",
		};

	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);
	var dataTable = $("#tabellaEntiRisultati").dataTable(optsDaUtilizzare);
	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);




	//	 checkAllTableList = function (me) {
	//		$(me).closest("table").find('input[type="checkbox"]').not(me).prop('checked', me.checked);
	//	}

	$("#selezionaTuttiGliEnti").click(function(){
		var $this = $(this);
		var tabella = $("#tabellaEntiRisultati").dataTable(); // Ottengo il datatable gia' con le funzioni di dataTable
		var trs = tabella.$("tr"); // Ottengo tutte le righe e le wrappo in jQuery
		var ckb = $("#checkboxSelezionaTutti");
		// Per ogni tr richiamo una funzione
		trs.each(function(index, el) {
			var checkbox = $(el).find("input[type='checkbox']"); // I checkbox della riga
			checkbox.length && checkbox.prop("checked", firstToggle || check); // Cambio i valori del checkboxs
		});
		ckb.prop("checked", firstToggle || check);

		$this.html((!check ? "Seleziona" : "Deseleziona") + " tutti gli enti");
		firstToggle = false;
		check = !check;
	});



	$("#showSbloccaModuloXEnte, #showSbloccaModuloXEnte1").click(
		// FIXME: da mettere a posto
		function(){
			hiddenIdList   = "";
			var separatore = "";
			var $form = $("#sbloccaConfermeModuli");
			var listaId = "";
			var numerorighe = 0;
			// gestisce i campi input visibili
			var strGlobale = "";
			$("#listaIdDaSbloccare").val('');
			dataTable.$("input[type='checkbox']").filter(":checked").each( // Per ogni elemento dell'oggetto jQuery invoco la funzione
				function() {
					listaId = listaId + separatore + this.value
					separatore = ",";
					numerorighe++;
				}
			);
			$("#listaIdDaSbloccare").val(listaId);
			if (numerorighe>0){
				$("#msgSblocca").modal("show");
			}else{
				alert ("selezionare almeno un ente")
			}
		}
	);

	$("#confermaSbloccaModulo").click(
		// FIXME: da mettere a posto
		function(){
			var $form = $("#sbloccaConfermeModuli");
			$form.attr("action", "sbloccaModulo.do").submit();
		}
	);


	///////////////////////////////
	$("#showValidaModuloXEnte, #showValidaModuloXEnte1").click(
			// FIXME: da mettere a posto
			function(){
				hiddenIdList   = "";
				var separatore = "";
				var $form = $("#sbloccaConfermeModuli");
				var listaId = "";
				var numerorighe = 0;
				// gestisce i campi input visibili
				var strGlobale = "";
				$("#listaIdDaSbloccare").val('');
				dataTable.$("input[type='checkbox']").filter(":checked").each( // Per ogni elemento dell'oggetto jQuery invoco la funzione
					function() {
						listaId = listaId + separatore + this.value
						separatore = ",";
						numerorighe++;
					}
				);
				$("#listaIdDaSbloccare").val(listaId);
				if (numerorighe>0){
					$("#msgValida").modal("show");
				}else{
					alert ("selezionare almeno un ente")
				}
			}
		);

		$("#confermaValidazioneModulo").click(
			// FIXME: da mettere a posto
			function(){
				var $form = $("#sbloccaConfermeModuli");
				$form.attr("action", "validaModulo.do").submit();
			}
		);

		//////////////////////////////////////////////////////////

		$("#showSvalidaModuloXEnte,#showSvalidaModuloXEnte1").click(
				// FIXME: da mettere a posto
				function(){
					hiddenIdList   = "";
					var separatore = "";
					var $form = $("#sbloccaConfermeModuli");
					var listaId = "";
					var numerorighe = 0;
					// gestisce i campi input visibili
					var strGlobale = "";
					$("#listaIdDaSbloccare").val('');
					dataTable.$("input[type='checkbox']").filter(":checked").each( // Per ogni elemento dell'oggetto jQuery invoco la funzione
						function() {
							listaId = listaId + separatore + this.value
							separatore = ",";
							numerorighe++;
						}
					);
					$("#listaIdDaSbloccare").val(listaId);
					if (numerorighe>0){
						$("#msgSvalida").modal("show");
					}else{
						alert ("selezionare almeno un ente")
					}
				}
			);

			$("#confermaSvalidaModulo").click(
				// FIXME: da mettere a posto
				function(){
					var $form = $("#sbloccaConfermeModuli");
					$form.attr("action", "svalidaModulo.do").submit();
				}
			);

			$('input[name="statoConferma"]').change(
				function(){
					var $form = $("#sbloccaConfermeModuli");
					$form.attr("action", "ricerca.do").submit();
				}
			)//.trigger('change');

});