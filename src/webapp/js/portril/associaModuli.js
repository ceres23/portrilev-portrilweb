/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
	var firstToggle = true;
	var check = true;
	// Avendo messo il codice all'interno di questa funzione,
	// viene eseguito solo quando la pagina viene caricata
	/*
	$("#salvaAssociazione").click(function(){
		$("form").attr("action", "salvaAssociazione.do").submit();
	});

	$("#ricerca").click(function(){
		$("form").attr("action", "ricerca.do").submit();
	});
	 */

	//Metodo portato a livello superiore in javascript.html
	//tutti i bottoni con attributo data-action eseguono questa porzione di codice
	//setto l'action del form con il valore dell'attributo data-action
	/*
	$("button[data-action]").click(function() {
		$("form").attr("action",$(this).data("action")).submit();
	});
	*/

	/*
	$(document).on("click", ".pulsanteAssocia", function() {
		var form = $("form");
		// Imposto nel campo hidden il valore che presente nel campo data-uid del bottone cliccato
		$("#idEnteAssociato").val($(this).data("uid"));
		form.attr("action", "associaModuloEnte.do");
		form.submit();
		//console.log($(this).data("uid"))
	});

	$(document).on("click", ".pulsanteDisassocia", function() {
		var form = $("form");
		// Imposto nel campo hidden il valore che  presente nel campo data-uid del bottone cliccato
		$("#idEnteDisAssociato").val($(this).data("uid"));
		form.attr("action", "disassociaModuloEnte.do");
		form.submit();
		//console.log($(this).data("uid"))
	});
	 */


	// funzione che gestisce il check multiplo
	/*
	function checkAll()
	{
	     var checkboxes = document.getElementsByTagName('input'),
	     val = null;
	     for (var i = 0; i < checkboxes.length; i++)
	     {
	         if (checkboxes[i].type == 'checkbox')
	         {
	             if (val === null) val = checkboxes[i].checked;
	             checkboxes[i].checked = val;
	         }
	     }
	 }
	 */

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


	//gestisce la chiamata al salva esporta al clik del pulsante salva
	$("#salvaAssociazione").click(function(){
		var separatore = ",";

		var strDaInserireNelCampoHiddenNonAssociato = $("input[name='fooCheck']", "#tabellaEntiRisultati")
		.not(":checked")
		//.filter(":visible")
			.map(function() {
				return this.value;
			})
			.get()
			.join(separatore);

		$("#listaIdDaNonAssociare").val(strDaInserireNelCampoHiddenNonAssociato);


		var checkboxes = $("input[name='fooCheck']", "#tabellaEntiRisultati")//.filter(":visible");

		// Valori checkati
		var strDaInserireNelCampoHidden = checkboxes.filter(":checked")
				.map(function() {
					return this.value;
				})
				.get()
				.join(separatore);


	 // gestisce i campi input visibili
	 /*
	 var strGlobale = "";
	 $("input[type='text']", "#tabellaEntiRisultati").filter(":visible")
	 	 	.map(function() {
	 	 		var $this = $(this);
	 	 		return {
	 	 			value: this.id + "-" + this.value,
	 	 			//riga: $this.data("row"),
	 	 			//colonna: $this.data("column")
	 	 		};
	 	 	}).each(function(idx, el) {
	 	 		var hidden = "<input type='hidden' value='" + el.value + "' id='id" + idx + "' name='listaRigheVisibili[" + el.riga + "][" + el.colonna + "]'>";
	 	 		strGlobale += hidden;
	 	 	});

	 */
	 	//$("form").append(strGlobale);
		$("#listaIdDaAssociare").val(strDaInserireNelCampoHidden);
		$("form").attr("action", "salvaAssociazione.do").submit();

	});


	var opts = {
		oLanguage: {
			sZeroRecords: 'Nessun ente trovato',
			sEmptyTable: 'Nessun ente trovato'
		},
		iDisplayLength: 50,
		aLengthMenu: [25, 50, 75, 100]

	};

	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);
	$("#tabellaEntiRisultati").dataTable(optsDaUtilizzare);

	//var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);
	//$("#tabellaEntiAssociati").dataTable(dataTableOptions);

});