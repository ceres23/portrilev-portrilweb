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
<div id="msgElimina" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="msgEliminaLabel" aria-hidden="true">
	  <div class="modal-body">
		<div class="alert alert-error">
		  <button type="button" class="close" data-dismiss="alert">&times;</button>
		  <p><strong>Attenzione!</strong></p>
		  <p>Stai per eliminare gli elementi selezionati nella pagina corrente: sei sicuro di voler proseguire?</p>
		</div>
	  </div>
	  <div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">no, indietro</button>
		<button class="btn btn-primary" type="button" name ="confermaEliminaRighe"     id ="confermaEliminaRighe">si, prosegui</button>
	  </div>
</div>  
<!--/modale elimina -->

<!-- Modal ConfermaModulo -->
<div id="msgConfermaModulo" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="msgConfermaModuloLabel" aria-hidden="true">
		  <div class="modal-body">
			<div class="alert alert-error">
			  <button type="button" class="close" data-dismiss="alert">&times;</button>				
			  <p><strong>Attenzione!</strong></p>			  
			  <p>Stai per confermare il modulo corrente: sei sicuro di voler proseguire?</p>
			</div>
		  </div>
		  <div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">no, indietro</button>
			<button class="btn btn-primary" type="button" name ="confermaModulo"     id ="confermaModulo">si, prosegui</button>
		  </div>
</div>  
<!--/modale ConfermaModulo -->

