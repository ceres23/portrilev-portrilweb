<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
 <c:if test="${not empty ricercaModuliModel.listaModuli}"> 
 <div class="table-responsive">
	<table class="table table-hover tab_left" id="tabellaRisultatiModuli" >
		<thead>
			<tr>
				<th>Modulo</th>
				<th>Descrizione</th>
				<th>Codice Gruppo</th>				
				<c:if test="${ricercaModuliModel.tipo=='RILEVAZIONE'}" >
					<th>Stato</th>
					<th>Data Inizio</th>
					<th>Data Fine</th>
				</c:if>
				<th class="tab_Right span1">&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="modulo" items="${ricercaModuliModel.listaModuli}" >
			<tr>                  
				<td><c:out value="${modulo.nome}" /></td>
				<td><c:out value="${modulo.descrizione}" /></td>
				<td><c:out value="${modulo.codiceGruppo}" /></td>
				<c:if test="${modulo.tipo=='RILEVAZIONE'}" >
					<td><c:out value="${modulo.stato}" /></td>
					<td><c:out value="${modulo.dataInizioCompilazioneStr}" /></td>
					<td><c:out value="${modulo.dataFineCompilazioneStr}" /></td>
				</c:if>
				<td class="tab_Right">
					<div class="btn-group">
						<button class="btn dropdown-toggle" data-toggle="dropdown">Azioni<span class="caret"></span></button>
						<ul class="dropdown-menu pull-right">
							<li><a data-azione='<c:out  value="elimina.do" />'  		data-id-modulo='<c:out  value="${modulo.idModulo}" />' href='#'>elimina</a></li>
							<li><a data-azione='<c:out  value="copia.do" />'   			data-id-modulo='<c:out  value="${modulo.idModulo}" />' href='#'>copia</a></li>
							<li><a data-azione='<c:out  value="modifica.do" />' 		data-id-modulo='<c:out  value="${modulo.idModulo}" />' href='#'>modifica</a></li>
							<c:if test="${modulo.stato!='chiusi' ||  ricercaModuliModel.tipo!='RILEVAZIONE'}" >
								<li><a data-azione='<c:out  value="associa.do" />'  		data-id-modulo='<c:out  value="${modulo.idModulo}" />' href='#'>associa</a></li>
								<li><a data-azione='<c:out  value="apriFinestraMail.do" />' data-id-modulo='<c:out  value="${modulo.idModulo}" />' href='#'>invia</a></li>		
							</c:if>
						</ul>
					</div>                               
				</td>
			</tr>
			</c:forEach>
		</tbody>  
	</table>
	<form:hidden path="idModuloSel"  />
	</div>
</c:if> 

