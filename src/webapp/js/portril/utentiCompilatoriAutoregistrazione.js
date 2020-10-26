/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
	  function forceKeyPressUppercase(e)
	  {
	    var charInput = e.keyCode;
	    if((charInput >= 97) && (charInput <= 122)) { // lowercase
	      if(!e.ctrlKey && !e.metaKey && !e.altKey) { // no modifier key
	        var newChar = charInput - 32;
	        var start = e.target.selectionStart;
	        var end = e.target.selectionEnd;
	        e.target.value = e.target.value.substring(0, start) + String.fromCharCode(newChar) + e.target.value.substring(end);
	        e.target.setSelectionRange(start+1, start+1);
	        e.preventDefault();
	      }
	    }
	  }


	  document.getElementById("nome").addEventListener("keypress", forceKeyPressUppercase, false);
	  document.getElementById("cognome").addEventListener("keypress", forceKeyPressUppercase, false);


$(function() {


});