/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$( function() {
	$('#tipoValore').change(function(){

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

	function resetValue(){
		document.getElementById('TipoAlfanumerico').style.display = 'none';
		document.getElementById('TipoNumerico').style.display = 'none';
		document.getElementById('TipoDetDelibera').style.display = 'none';
		document.getElementById('TipoValoreFisso').style.display = 'none';
	}


	$("#annulla").click(function(){
		$("form").attr("action", "annulla.do").submit();
	});


	$("#aggiungiColonna").click(function(){
		$("form").attr("action", "inserisciColonnaModulo.do").submit();
	});

	$("#salva").click(function(){
		$("form").attr("action", "salvaColonneModulo.do").submit();
	});



	 $('a', '#tabellaListaColonne').click(function (event) {
		 event.preventDefault();
		 //da tener presente
		 //nell'html idUtente scritto id-Posizione
		 var idPosizione = $(this).data("idPosizione");
		 $("#idPosizioneSel").val(idPosizione);

		 var azione = $(this).data("azione");
		 var form = $("form");
		 form.attr("action", azione);
		 form.submit();

	 });


});


