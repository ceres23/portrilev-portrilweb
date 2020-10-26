/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {



		$("#esporta").click(function(){
			var form = $("form").attr("action", "esporta.do")
			form.submit();
		});


});
