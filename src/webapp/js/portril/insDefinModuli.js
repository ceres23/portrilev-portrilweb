/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
	$("#salvaProsegui").click(function(){
		$("form").attr("action", "inserisciModuloTestataProsegui.do").submit();
	});

	$("#salva").click(function(){
		$("form").attr("action", "inserisciModuloTestata.do").submit();
	});

	$('input[name="tipo"]').change(visualizzaDate);

	function visualizzaDate() {

		if($("input[name='tipo']:checked").val() === "RILEVAZIONE"){
			$("#TipoRilevazione").removeClass("hide");
		}else{
			$("#TipoRilevazione").addClass("hide");
			//$("input[name='stato'][value='ALL']").prop("checked", true);
			$("#rangeCompilazione.dataFine").val("");
			$("#rangeCompilazione.dataInizio").val("");
		}
	}
	//viene eseguito alla coda di funzioni eseguite al caricamento della pagina
	visualizzaDate();
});