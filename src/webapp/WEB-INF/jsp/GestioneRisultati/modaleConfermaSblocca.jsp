<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<div class="modal hide fade" id="modalinoDiAttesa" data-backdrop="static" data-keyboard="false">
		<div class="modal-body">
			<h1>Caricamento in corso</h1>
			<h4>Attendere, prego...</h4>
		</div>
</div>
	
<!-- Modal elimina -->
<div id="msgSblocca" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="msgSbloccaLabel" aria-hidden="true">
		  <div class="modal-body">
			<div class="alert alert-error">
			  <button type="button" class="close" data-dismiss="alert">&times;</button>
			  <p><strong>Attenzione!</strong></p>
			  <p>Stai per sbloccare gli Enti selezionati : sei sicuro di voler proseguire?</p>
			</div>
		  </div>
		  <div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">no, indietro</button>
			<button class="btn btn-primary" type="button" name ="confermaSbloccaModulo"     id ="confermaSbloccaModulo">si, prosegui</button>
		  </div>
</div>  
<!--/modale sblocco -->

<div id="msgValida" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="msgValidaLabel" aria-hidden="true">
		  <div class="modal-body">
			<div class="alert alert-error">
			  <button type="button" class="close" data-dismiss="alert">&times;</button>
			  <p><strong>Attenzione!</strong></p>
			  <p>Stai per Validare gli Enti selezionati : sei sicuro di voler proseguire?</p>
			</div>
		  </div>
		  <div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">no, indietro</button>
			<button class="btn btn-primary" type="button" name ="confermaValidazioneModulo"     id ="confermaValidazioneModulo">si, prosegui</button>
		  </div>
</div>  


<div id="msgSvalida" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="msgSvalidaLabel" aria-hidden="true">
	  <div class="modal-body">
		<div class="alert alert-error">
		  <button type="button" class="close" data-dismiss="alert">&times;</button>
		  <p><strong>Attenzione!</strong></p>
		  <p>Stai per eliminare la validazione agli Enti selezionati : sei sicuro di voler proseguire?</p>
		</div>
	  </div>
	  <div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">no, indietro</button>
		<button class="btn btn-primary" type="button" name ="confermaSvalidaModulo"     id ="confermaSvalidaModulo">si, prosegui</button>
	  </div>
</div>  

