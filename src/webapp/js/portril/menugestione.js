/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
	var utenteMonoEnte = $("#utenteMonoEnte").val();
	$("a[data-openModal]").on("click", function() {
		var url;
		if(utenteMonoEnte === "true") {
			url = $(this).data("redirect");
			$("form").attr("action", url).submit();
		} else {
			startMenu(this);
		}

	});

	$("#confirmSelectEnte").on("redirigiVersoPagina", function(event) {
		var idEnteGestoreDaSel = $("#idEnteGestoreDaSel").val();
		$("#idEnteGestoreSel").val(idEnteGestoreDaSel);
		$("form").attr("action", event.urlPerRedirezione).submit();
	});
})