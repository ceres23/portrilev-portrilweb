/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
	// Avendo messo il codice all'interno di questa funzione,
	// viene eseguito solo quando la pagina viene caricata

	// funzione che gestisce il check multiplo
	/*
	function checkAll()
	{
	     var checkboxes = document.getElementsByTagName('input'), val = null;
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



	//gestisce la chiamata al metodo ricerca al clik del pulsante ricerca
	$("#ricerca").click(function(){
		$("form").attr("action", "ricerca.do").submit();
	});

	//gestisce la chiamata al metodo esporta al clik del pulsante esporta
	$("#esporta").click(function(){
		$("form").attr("action", "esporta.do").submit();
	});


	//gestisce la chiamata al salva esporta al clik del pulsante salva
	$("#salva").click(function(){
		var separatore = ",";

		var strDaInserireNelCampoHiddenNonValidante = $("input[name='fooCheck']", "#tabellaRisultatiRigheDaValidare")
		.not(":checked")
		.filter(":visible")
			.map(function() {
				return this.value;
			})
			.get()
			.join(separatore);

	 $("#listaIdDaNonValidare").val(strDaInserireNelCampoHiddenNonValidante);


	 var visibleCheckboxes = $("input[name='fooCheck']", "#tabellaRisultatiRigheDaValidare").filter(":visible");
	 // Valori checkati
	 var strDaInserireNelCampoHidden = visibleCheckboxes.filter(":checked")
				.map(function() {
					return this.value;
				})
				.get()
				.join(separatore);


	 // gestisce i campi input visibili
	 var strGlobale = "";
	 $("input[type='text']", "#tabellaRisultatiRigheDaValidare").filter(":visible")
	 	 	.map(function() {
	 	 		var $this = $(this);
	 	 		return {
	 	 			value: this.id + "-" + this.value,
	 	 			//value: this.value,
	 	 			riga: $this.data("row"),
	 	 			colonna: $this.data("column")
	 	 		};
	 	 	}).each(function(idx, el) {
	 	 		var hidden = "<input type='hidden' value='" + el.value + "' id='id" + idx + "' name='listaRigheVisibili[" + el.riga + "][" + el.colonna + "]'>";
	 	 		strGlobale += hidden;
	 	 	});

	 	$("form").append(strGlobale);
	 	//alert && alert("righe visibili : " + strGlobale);


		$("#listaIdDaValidare").val(strDaInserireNelCampoHidden);
		$("form").attr("action", "salva.do").submit();

	});


	var opts = {
		oLanguage: {
			sZeroRecords: 'Nessuna riga trovata',
			sEmptyTable: 'Nessuna riga trovata'
		}
	};

	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);
	$("#tabellaRisultatiRigheDaValidare").dataTable(optsDaUtilizzare);



});










