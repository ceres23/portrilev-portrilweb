/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
	// Avendo messo il codice all'interno di questa funzione,
	// viene eseguito solo quando la pagina viene caricata

	$("#autoregistrazione").click(function(){
		$("form").attr("action", "registrazione.do").submit();
	});

	$("#accedi").click(function(){
		$("form").attr("action", "accedi.do").submit();
	});


});