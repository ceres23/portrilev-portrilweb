<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>

<!-- Modal msgInvia -->
<div id="msgInviaMail" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="msgInviaLabel" aria-hidden="true">
		
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
         <h4 class="nostep-pane">Invia Modulo</h4>
	</div>
	<div class="modal-body">
		<fieldset class="form-horizontal">
		<h4>Modulo <c:out value="${ricercaModuliModel.moduloSelezionato.nome}" /></h4>
		<h4>Descrizione: <c:out value="${ricercaModuliModel.moduloSelezionato.descrizione}" /></h4>
		<div class="BordersLine1 colorGreen"></div>
		<br>
		<div class="control-group">
			<label class="control-label" for="oggMailModulo">Oggetto</label>
			<div class="controls">
				<form:input path="oggMailModulo" class="span10"  />									
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="descMailModulo">Testo</label>
			<div class="controls">
				<form:textarea path="descMailModulo" rows="3" cols="15" class="span10" />									

			</div>
		</div>
		</fieldset>
	  
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-secondary">annulla</button>
		<button type="button" id="invia" name="invia" class="btn btn-primary" >invia</button> 
	</div>
</div>  
<!--/modale msgInvia -->




