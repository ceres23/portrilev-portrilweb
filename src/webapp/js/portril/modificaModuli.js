/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
	$("#salvaProsegui").click(function(){
		$("form").attr("action", "modificaModuloTestataProsegui.do").submit();
	});

	$("#salva").click(function(){
		$("form").attr("action", "modificaModuloTestata.do").submit();
	});


});