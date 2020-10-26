/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
$(function() {
//	'use strict';
	// TODO: leggere questo dato!!
	var numeroColonne = $('#numeroColonne').val();
	var i;
	var incrementoRiga=0;
	var tabellaRigheModulo =$("#TabellaRigheModulo").DataTable();
	var inserisciRiga = document.getElementById('inserisciRiga');
	var modificaRiga = document.getElementById('modificaRiga');
	var hiddenIdList = "";


	// gestisce la paginazione della tabella
	var opts = {
		////////////
		//	iDisplayLength: 5,
           // Configurazione per il processing server-side dei dati
        "bServerSide" : true,
        // Sorgente Json dei dati
        "sAjaxSource" : "../righeModuloJsonController/estraiListaRigheXModulo.do",
        // Metodo HTTP per la chiamata
        "sServerMethod" : "GET",
        // Gestione della paginazione
        "bPaginate" : true,
        // Impostazione del numero di righe
        "bLengthChange" : true,
        // Sorting delle colonne
        "bSort" : false,
        // Display delle informazioni
        "bInfo" : true,

        // Display delle informazioni
        "bDestroy" : true,

        // Calcolo automatico della larghezza delle colonne
        "bAutoWidth" : true,
        // Abilita la visualizzazione di 'Processing'
        "bProcessing" : true,
        "aoColumnDefs": [
            { aTargets: [0], mData: function(el) {
            	return "<input type='checkbox' name='fooCheck' id='" + el.idRiga + "' value='" + el.idRiga + "' />&nbsp;<span></span>";
            }}
        ],
        "fnCreatedRow": function(tr, data, idx) {
        	var $tr = $(tr)
        	var $checkboxTd = $tr.find('td:first');
        	var startingPoint = 1;
        	if(dataTable && dataTable.fnSettings()) {
        		startingPoint += dataTable.fnSettings()._iDisplayStart;
        	}

        	$checkboxTd.find('span').html(idx + startingPoint);

        	//$tr.find('input[name="campoedit"]').each(function(id, el) {
            $tr.find('span[data-column]').each(function(id, el) {
        		var $el = $(el);
        		$el.attr('data-row', idx);
        		$el.attr('id', idx + '-' + $el.data('column'));
        	});
        }
	};

	
	function creaCella(colonnaSel) {
		opts.aoColumnDefs.push({
			aTargets: [colonnaSel + 1],
			mData: function(el) {
				//return "<input name='campoedit' class='span12' type='text' value='" + el.listaCelleModulo[colonnaSel].valore + "' data-column='" + colonnaSel + "' />";
				//return "<label for='grigliaValori[" + el.riga + "][" + el.colonna + "]' >"+ escapeHtml(el.value) +"</label>";
				return "<span data-column='" + colonnaSel + "' >"+ escapeHtml(el.listaCelleModulo[colonnaSel] ? el.listaCelleModulo[colonnaSel].valore : '') +"</span>";
			}
		});
	}
	
	for(i = 0; i < numeroColonne; i++) {		
		creaCella(i);
	}

	
	
	var optsDaUtilizzare = $.extend(true, {}, dataTableOptions, opts);
	var dataTable = $("#TabellaRigheModulo").dataTable(optsDaUtilizzare);
	var goToLastPage = $("#goToLastPage");

	if(goToLastPage.val() === "true") {
		goToLastPage.val("false");
		dataTable.fnPageChange("last");
	}
	// fine gestisce la paginazione della tabella

	// gestisce il multicheck
	//	 checkAllTableList = function (me) {
	//		$(me).closest("table").find('input[type="checkbox"]').not(me).prop('checked', me.checked);
	//	}
	// fine gestisce il multicheck


	// gestisce la chiamata aggiungi riga
	$("#showAggiungiRiga").click(
		// FIXME: da mettere a posto
		function(){
			//resetto i campi del form inserisciRiga
			inserisciRiga.reset();
			//reset eventuali id precedenti
			$("#idRiga").val('');
			//nascondo la sezione dedicata agli errori
			$("#erroreCelleInserimenti").slideUp();
			// prendo tutti gli elementi text thead
			$("input[type='text']", 'thead').each( // Per ogni elemento dell'oggetto jQuery invoco la funzione
				function() {
					this.value="";
				}
			);
    	    //mostro la modale
			$("#modalInserisci").modal("show");
		}
	);

	$("#confermaAggiungiRiga").click(aggiungiRiga);

	function aggiungiRiga(){
		var $form = $("#inserisciRiga");
		var listaErrori = [];
	    var erroreCelleInserimenti = $("#erroreCelleInserimenti");
        var modale = $("#modalInserisci");

	    $.post('../righeModuloJsonController/aggiungiRiga.do', $form.serialize())
	    .then(function(data) {
	    	var split;
	    	//console.log(data)
	    	// se la chiamata mi restituisce errori  li concateno e mostro la sezione errori
	    	if (data && data.length>0){

	    		for ( var i=0 ; i<data.length ; i++ ) {
	    			str   = data[i];
	    			split = str.split('__');
	    			listaErrori.push('<tr><td><strong>' + split[0] + '</strong></td><td style="padding-left: 10px; text-align:left;" >' + split[1] + '</td></tr>');
	    		}

	    		erroreCelleInserimenti.find('tbody').html(listaErrori.join(''));
	    	    erroreCelleInserimenti.slideDown();
		    	//console.log(listaErrori);
		    	return $.Deferred().reject().promise();
	    	}else{
	      		 //inserisciRiga.reset();
	    		 erroreCelleInserimenti.hide();
	    	}

	    }).then(function() {
	    	modale.modal("hide");
	    	tabellaRigheModulo  && tabellaRigheModulo.fnDraw();
	    	incrementoRiga =  incrementoRiga + 1;
	    	gotoLastPage(incrementoRiga);

	    });
	}

	///////////////////////////////////////////////////////// DA FARE
	$("#confermaAggiungiENuovo").click(aggiungiRigaENuovo);

	function aggiungiRigaENuovo(){
		var $form = $("#inserisciRiga");
		var listaErrori = [];
	    var erroreCelleInserimenti = $("#erroreCelleInserimenti");
        var modale = $("#modalInserisci");

	    $.post('../righeModuloJsonController/aggiungiRiga.do', $form.serialize())
	    .then(function(data) {
	    	var split;
	    	//console.log(data)
	    	// se la chiamata mi restituisce errori  li concateno e mostro la sezione errori
	    	if (data && data.length>0){

	    		for ( var i=0 ; i<data.length ; i++ ) {
	    			str   = data[i];
	    			split = str.split('__');
	    			listaErrori.push('<tr><td><strong>' + split[0] + '</strong></td><td style="padding-left: 10px; text-align:left;" >' + split[1] + '</td></tr>');
	    		}

	    		erroreCelleInserimenti.find('tbody').html(listaErrori.join(''));
	    	    erroreCelleInserimenti.slideDown();
		    	//console.log(listaErrori);
		    	return $.Deferred().reject().promise();
	    	}else{
	    		 inserisciRiga.reset();
	    		 erroreCelleInserimenti.hide();
	    	}

	    }).then(function() {
	    	incrementoRiga++;
	    });
	}

	////////////////////////



	// gestisce la chiamata al modifica riga
	$("#showModificaRiga").click(
		function(){
			var idSelezionati = 0;
			//var $form = $("#modificaRiga");
			var idRiga;
			//resetto i campi del form inserisciRiga
			modificaRiga.reset();
			//nascondo la sezione dedicata agli errori
			$("#erroreCelleModifica").slideUp();
			// prendo tutti gli elementi text thead
			$("input[type='text']", 'thead').each( // Per ogni elemento dell'oggetto jQuery invoco la funzione
				function() {
					this.value="";
				}
			);
			
			dataTable.$("input[type='checkbox']").filter(":checked").each( // Per ogni elemento dell'oggetto jQuery invoco la funzione
				function() {
					idSelezionati++;
					idRiga = this.value;
					$("#idRiga").val(idRiga);
				}
			);

			if (idSelezionati == 0){
				alert ("selezionare almeno una riga da modificare")
				return;
			}

			if (idSelezionati>1){
				alert ("selezionare una sola riga da modificare")
				return;
			}

		    $.post('../righeModuloJsonController/modificaRiga.do', {idRiga: idRiga})
		    .then(function(data) {
		    	var split;
		    	var $inputs = $('#TabellaModificaRigaModulo').find('tbody :input');
		    	//console.log(data)
		    	// se la chiamata mi restituisce errori  li concateno e mostro la sezione errori
		    	if (data && data.length>0){
		    		for ( var i=0 ; i<data.length ; i++ ) {
		    			str   = data[i];
		    			$inputs.eq(i).val(str);
		    		}
		    	} else {
		    		return $.Deferred().reject().promise();
		    	}
		    }).always(function() {
				$("#modalModifica").modal("show");
		    });
		}
	);

	// gestisce la chiamata elimina riga
	$("#showeliminaRighe").click(
		// FIXME: da mettere a posto
		function(){
			hiddenIdList = "";
			var separatore = "";
			var listaId = "";
			var numerorighe = 0;
			// gestisce i campi input visibili
			var strGlobale = "";
			//$('input[listaIdDaEliminare]').remove();
			$("#listaIdDaEliminare").val('');

			dataTable.$("input[type='checkbox']").filter(":checked").each( // Per ogni elemento dell'oggetto jQuery invoco la funzione
				function() {
					listaId = listaId+separatore+this.value;
					//listaId.push(this.value);
					separatore = ",";
					numerorighe++ ;
				}
			);
			$("#listaIdDaEliminare").val(listaId);

			if (numerorighe>0){
				$("#msgElimina").modal("show");
			}else{
				alert ("selezionare almeno una riga da cancellare")
			}
		}
	);

	$("#confermaEliminaRighe").click(
		function(){
			var $form = $("#gestioneModuliCompilaModulo");
			$form.attr("action", "eliminaRighe.do").submit();
		}
	);

	$("#filtraRighe").click(
		function(){
			var $form = $("#gestioneModuliCompilaModulo");
			$form.attr("action", "filtraRighe.do").submit();
		}
	);
	
	
	/////////////////////////////

	// gestisce la chiamata elimina riga
	$("#showConfermaModulo").click(
		function(){
			$("#msgConfermaModulo").modal("show");
		}
	);

	$("#confermaModulo").click(
		function(){
			var $form = $("#gestioneModuliCompilaModulo");
			$form.attr("action", "confermaModulo.do").submit();
		}
	);

	////////////////////////////

	function gotoLastPage(delta) {
		var settings = dataTable.fnSettings();
		dataTable.fnPageChange(Math.floor((settings._iRecordsTotal + delta - 1) / settings._iDisplayLength));
	}


	$("#confermaModificaRiga").off('click').click(eseguiModificaRiga);
	function eseguiModificaRiga(){
		var $form = $("#modificaRiga");
		var listaErrori = [];
	    var erroreCelleModifica = $("#erroreCelleModifica");
        var modale = $("#modalModifica");

	    $.post('../righeModuloJsonController/confermaModificaRiga.do', $form.serialize())
	    .then(function(data) {
	    	var split;
	    	//console.log(data)
	    	// se la chiamata mi restituisce errori  li concateno e mostro la sezione errori
	    	if (data && data.length>0){
	    		for ( var i=0 ; i<data.length ; i++ ) {
	    			str   = data[i];
	    			split = str.split('__');
	    			listaErrori.push('<tr><td><strong>' + split[0] + '</strong></td><td style="padding-left: 10px; text-align:left;" >' + split[1] + '</td></tr>');
	    		}

	    		erroreCelleModifica.find('tbody').html(listaErrori.join(''));
	    		erroreCelleModifica.slideDown();
		    	return $.Deferred().reject().promise();
	    	}else{
	    		erroreCelleModifica.hide();
	    	}

	    }).then(function() {
	    	$("#idRiga").val('');
	    	modale.modal("hide");
	    	tabellaRigheModulo  && tabellaRigheModulo.fnDraw();
	    });
	}


});

