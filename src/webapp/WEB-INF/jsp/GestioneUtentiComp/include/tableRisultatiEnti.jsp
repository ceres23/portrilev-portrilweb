<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<c:choose>  
	<c:when test="${empty utentiCompilatoriStep2Model.listaEntiCompilatoriRicercati}"> 
		<!-- eventuale condizione di successo -->
	</c:when>  
	<c:otherwise>     
		<table class="table table-hover tab_left dataTable" summary="...." id="tabellaRisultatiEnti">
			<thead>
				<tr>
					<th>Ragione Sociale</th>
					<th>Comune</th>
					<th>Codice Fiscale</th>
					<th>Partita Iva</th>
					<th class="tab_Right">&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ente" items="${utentiCompilatoriStep2Model.listaEntiCompilatoriRicercati}" >
					<tr>
						<td><c:out value="${ente.ragioneSociale}" /></td>
						<td><c:out value="${ente.comune}" /></td>
						<td><c:out value="${ente.codiceFiscale}" /></td>
						<td><c:out value="${ente.partitaIva}" /></td>
						<td class="tab_Right">
						<!-- <button type="button" class="btn btn-secondary pulsanteAssocia" data-uid="<c:out value='${ente.idEnteCompilatore}' />">Associa&nbsp;<i class="icon-link icon-1x"></button> -->
						<button type="button" class="btn btn-secondary pulsanteAssocia" data-uid="<c:out value='${ente.idEnteCompilatore}' />">Associa&nbsp;</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>  
</c:choose> 		