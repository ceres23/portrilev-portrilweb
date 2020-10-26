<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
	<fieldset class="form-horizontal">
		<div class="control-group">
			<label class="control-label" for="RagioneSocialeEnte">Ragione Sociale</label>
			<div class="controls">
				<input id="RagioneSocialeEnte" class="span9" type="text" value="" name="RagioneSocialeEnte">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="ComuneEnte">Comune</label>
			<div class="controls">
				<input id="ComuneEnte" class="span6" type="text" value="" name="ComuneEnte">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="ProvinciaEnte">Provincia</label>
			<div class="controls">
				<input id="ProvinciaEnte" class="span6" type="text" value="" name="ProvinciaEnte">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="CodiceFiscaleEnte">Codice Fiscale</label>
			<div class="controls">
				<input id="CodiceFiscaleEnte" class="span6" type="text" value="" name="CodiceFiscaleEnte">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="PartitaIvaEnte">Partita Iva</label>
			<div class="controls">
				<input id="PartitaIvaEnte" class="span6" type="text" value="" name="PartitaIvaEnte">
			</div>
		</div>
	</fieldset>	
	
	<p><a class="btn btn-primary pull-right" data-toggle="collapse" data-target="#TableEntiAssociabili">cerca</a></p>
									
	<div class="clear"></div>
	<br>
	
	<div id="TableEntiAssociabili" class="collapse">
		<div>
			<fieldset class="form-horizontal" > 
				<h4 class="step-pane"><span class="num_result">23</span> Enti trovati</h4>
				<table class="table table-hover tab_left">
					<thead>
						<tr>
							<th><input type="checkbox" onchange="checkAllTableList(this)" name="chkEnti" /></th>
							<th>Ragione sociale</th>
							<th>Comune</th>
							<th>Provincia</th>
							<th>Codice fiscale</th>
							<th>Partita iva</th>
							<th>Stato</th>
						</tr>
					</thead>
					<tbody>
						<tr>                  
							<td><input type="checkbox" name="fooCheck" value="dett1"></td>
							<td>Comune</td>
							<td>Comune di Avigliana</td>
							<td>Torino</td>
							<td>xxxxxxxxx</td>
							<td>105576923</td>
							<td>Attivo</td>
						</tr>
						<tr>                  
							<td><input type="checkbox" name="fooCheck" value="dett2"></td>
							<td>Comune</td>
							<td>Comune di Genola</td>
							<td>Cuneo</td>
							<td>xxxxxxxxx</td>
							<td>1117686923</td>
							<td>Non Attivo</td>
						</tr>
						<tr>                  
							<td><input type="checkbox" name="fooCheck" value="dett3"></td>
							<td>Comune</td>
							<td>Comune di Torino</td>
							<td>Torino</td>
							<td>xxxxxxxxx</td>
							<td>1126549499</td>
							<td>Attivo</td>
						</tr>
						
					</tbody>  
				</table>
				
				<div class="row pagination_conth">
					<div id="risultatiricerca_info2" class="span6">1 - 10 di 28 risultati</div>   
						<div class="span6">                               
						<div id="paginazione2" class="dataTables_paginate paging_bootstrap pagination">
						  <ul>
							<li><a href="#">« inizio</a></li>
							<li><a href="#">« prec</a></li>
							<li><a href="#">1</a></li>
							<li class="active"><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">succ »</a></li>
							<li><a href="#"> fine »</a></li>              
						  </ul>
						</div>         
					</div> 
				</div>

			</fieldset>	
			<p><a class="btn btn-primary pull-right" data-toggle="collapse" data-target="#TableEntiAssociabili">associa</a></p>			
		</div>
	</div>
	
			