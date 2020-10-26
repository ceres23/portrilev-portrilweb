/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
	$("#salva").click(function(){
		$("form").attr("action", "salva.do").submit();
	});

});