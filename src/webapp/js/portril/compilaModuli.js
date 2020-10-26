/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {

	// gestisce la paginazione della tabella
	var opts = {
			oLanguage: {
				sZeroRecords: 'Nessuna riga trovata',
				sEmptyTable: 'Nessuna riga trovata'
			},
			bSort:false
	};

	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);
	var dataTable = $("#TabellaRigheModulo").dataTable(optsDaUtilizzare);
	var goToLastPage = $("#goToLastPage");

	if(goToLastPage.val() === "true") {
		goToLastPage.val("false");
		dataTable.fnPageChange("last");
	}

	// fine gestisce la paginazione della tabella


//	$('input.upload').change(
//			function() {
//				$(this).attr("name", "file");
//				$("#modalinoDiAttesa").modal("show");
//				submitDelForm.call(this);
//			}
//		);


	// gestisce il multicheck
	//	 checkAllTableList = function (me) {
	//		$(me).closest("table").find('input[type="checkbox"]').not(me).prop('checked', me.checked);
	//	}
	// fine gestisce il multicheck


	// gestisce il pulsante aggiungi riga
	$("#aggiungiRiga").click(function(){

		var $form = $("form");
		var separatore = ",";

		// gestisce i campi input visibili
		var strGlobale = "";
		dataTable.$("input[type='text']").map(
				function() {
					var $this = $(this);
					return {
						value: this.value,
						riga: $this.data("row"),
						colonna: $this.data("column")
					};
				}
		).each(
				function(idx, el) {
					var hidden = "<input type='hidden' value='" + escapeHtml(el.value) + "' id='id" + idx + "' name='grigliaValori[" + el.riga + "][" + el.colonna + "]'>";
					strGlobale += hidden;
				}
		);
		//alert && alert("strGlobale: " + strGlobale);
		$form.append(strGlobale);



		$("form").attr("action", "aggiungiRiga.do").submit();
	});
	// Fine gestisce il pulsante aggiungi riga



	// gestisce la chiamata elimina riga
	$("#eliminaRighe").click(
			function(){
				var separatore = ",";
				var $form = $("form");

//				var visibleCheckboxes = $("input[name='fooCheck']", "#TabellaRigheModulo").filter(":visible");
//
//				// Valori checkati
//				var strDaInserireNelCampoHiddenDaCancellare = visibleCheckboxes.filter(":checked")
//				.map(function() {
//					return this.value;
//				})
//				.get()
//				.join(separatore);
//
//				$("#listaIdDaEliminare").val(strDaInserireNelCampoHiddenDaCancellare);


				// gestisce i campi input visibili
				var strGlobale = "";

				var strGlobale = "";
				dataTable.$("input[type='checkbox']") // Prendo i checkbox all'interno del dataTable
					.filter(":not(:checked)") // Prendo solo quelli non checkati
					.map( // Trasformo gli oggetti jQuery in altri oggeti jQuery
						function() {
							var row = $(this).closest("tr"); // Dal checkbox, cerco il piu' vicino <tr> che lo contenga
							var inputs = row.find("input[type='text']"); // Data la riga, prendo gli <input type='text'>
							return inputs; // Restituisco l'oggetto jQuery con tutti gli input della riga
						}
					).each( // Per ogni elemento dell'oggetto jQuery invoco la funzione
						function() {
							// this e' gia' un oggetto jQuery: in particolare, e' l'oggetto 'inputs' di cui sopra
							$(this).each(
								function(idx) {
									var $this = $(this); // Ora ho l'elemento del DOM. Lo wrappo in jQuery
									// Creo l'input hidden
									var hidden = "<input type='hidden' value='" + this.value + "' id='id" + idx + "' name='grigliaValori[" + $this.data("row") + "][" + $this.data("column") + "]'>";
									strGlobale += hidden; // aggiungo l'input alla stringa globale
								}
							);
							// Fine dell'each interno
						}
						// Fine dell'each esterno
					);
				/*
				dataTable.$("input[type='checkbox']") // Prendo i checkbox all'interno del dataTable
					.filter(":not(:checked)") // Prendo solo quelli non checkati
					.map( // Trasformo gli oggetti jQuery in altri oggeti jQuery
						function() {
							var row = $(this).closest("tr"); // Dal checkbox, cerco il piu' vicino <tr> che lo contenga
							var inputs = row.find("input[type='text']"); // Data la riga, prendo gli <input type='text'>
							return inputs;
						}
					).map(
						function() {
							var $this = $(this); // Wrappo l'input in jQuery
							return {
								value: this.value, // Prendo il value dell'oggetto
								riga: $this.data("row"), // Prendo il data-row
								colonna: $this.data("column") // Prendo il data-column
							};
						}
					).each(
						function(idx, el) {
							var hidden = "<input type='hidden' value='" + el.value + "' id='id" + idx + "' name='grigliaValori[" + el.riga + "][" + el.colonna + "]'>";
							strGlobale += hidden;
						}
				);
				//*/
				$form.append(strGlobale);

				//alert && alert("strGlobale: " + strGlobale);

				$form.attr("action", "eliminaRighe.do").submit();

			}
	);


	//  gestisce la chiamata al salva esporta al clik del pulsante salva
	$("#salva").click(
			function(){
				var $form = $("form");
				var separatore = ",";
				var valore ="";
				$("#modalinoDiAttesa").modal("show");

				// gestisce i campi input visibili
				var strGlobale = "";
				dataTable.$("input[type='text']").map(
						function() {
							var $this = $(this);
							return {
								value: this.value,
								riga: $this.data("row"),
								colonna: $this.data("column")
							};
						}
				).each(
						function(idx, el) {
							//valore = el.value;
							//valore = escapeHtml(el.value);
							//alert && alert("valore: " + valore);
							//valore = valore.replace(/'/g, "&#039;");
							var hidden = "<input type='hidden' value='" + escapeHtml(el.value) + "' id='id" + idx + "' name='grigliaValori[" + el.riga + "][" + el.colonna + "]'>";
							strGlobale += hidden;
						}
				);
				//alert && alert("strGlobale" + strGlobale);
				$form.append(strGlobale);
				$form.attr("action", "salva.do").submit();
			}
	);

});

