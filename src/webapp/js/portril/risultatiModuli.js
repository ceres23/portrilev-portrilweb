/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
	
	var opts = {
		oLanguage: {
			sZeroRecords: 'Nessun modulo trovato',
			sEmptyTable:  'Nessun modulo trovato',
			sScrollX: "100%",
			sScrollXInner: "110%",
			bScrollCollapse: true	
		}
	};


	$('tr td:nth-child(3)', '#tabellaRisultati').each(function(idx, el) {
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
	
	 $('a', '#tabellaRisultati').click(function (event) {
		 event.preventDefault();
		 //da tener presente
		 //nell'html idUtente scritto id-utente
		 var idModulo = $(this).data("idModulo");
		 $("#idModuloSel").val(idModulo);
		 var azione = $(this).data("azione");
		 var form = $("form");
		 form.attr("action", azione);
		 form.submit();


	 });

	 
	 
		$('#tipoValore').change(function(){

			$('input[name="genderS"]:checked').val();
			
			if($(this).val()== "Alfanumerico"){
				resetValue();
				document.getElementById('TipoAlfanumerico').style.display = 'block';
			}else if($(this).val()== "Numerico"){
				resetValue();
				document.getElementById('TipoNumerico').style.display = 'block';
			}else if($(this).val()== "Delibera" || $(this).val()== "Determina"){
				resetValue();
				document.getElementById('TipoDetDelibera').style.display = 'block';
			}else if($(this).val()== "" || $(this).val()== "Data"){
				resetValue();
			}else if($(this).val()== "" || $(this).val()== "ValoreFisso"){
				resetValue();
				document.getElementById('TipoValoreFisso').style.display = 'block';
			}


		}).trigger('change');

		
// gestisce il multicheck
//	checkAllTableList = function (me) {
//		$(me).closest("table").find('input[type="checkbox"]').not(me).prop('checked', me.checked);
//	}

	$("#esportaCsv").click(
			// FIXME: da mettere a posto
			function(){
				hiddenIdList = "";
				var separatore = "";
				var listaId = "";
				var numerorighe = 0;
				$("#listaIdXCsv").val('');

				dataTable.$("input[type='checkbox']").filter(":checked").each( // Per ogni elemento dell'oggetto jQuery invoco la funzione
					function() {
						listaId = listaId+separatore+this.value;
						separatore = ",";
						numerorighe++ ;
					}
				);
				$("#listaIdXCsv").val(listaId);
				if (numerorighe>0){
					$("form").attr("action", "csvMultiplo.do").submit();

				}else{
					alert ("selezionare almeno un modulo")
				}
			}
		);

	$("#cerca").click(
		function(){
			$("form").attr("action", "ricerca.do").submit();
		}
	);

	
	/*
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
*/


		$("#sollecita").click(function(){
			$("form").attr("action", "sollecita.do").submit();
		});

		var aperturaModale=$("#aperturaModale").val();
		if(aperturaModale==="true"){
			$("#msgInviaMail").modal("show");
		}

		$("#inviaSollecito").click(function(){
			$("form").attr("action", "inviaSollecito.do").submit();
		});

		var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);
		var dataTable = $("#tabellaRisultati").dataTable(optsDaUtilizzare);

});