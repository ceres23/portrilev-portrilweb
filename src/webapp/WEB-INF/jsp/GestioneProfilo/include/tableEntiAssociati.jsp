<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<!-- c:if test="${empty utentiCompilatoriStep2Model.listaEntiAssociati}" -->
<!-- c:if test="${fn:length(utentiCompilatoriStep2Model.listaEntiAssociati) gt 0}" -->

<c:choose>  
<c:when test="${empty utentiCompilatoriStep2Model.listaEntiAssociati}"> 
	<!-- eventuale condizione di successo -->
</c:when>  
       <c:otherwise>  

		<table class="table table-hover tab_left dataTable"  id="tabellaEntiAssociati">
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
				<c:forEach var="enteAssociato" items="${utentiCompilatoriStep2Model.listaEntiAssociati}" >
				<tr>
					<td><c:out value="${enteAssociato.ragioneSociale}" /></td>
					<td><c:out value="${enteAssociato.comune}" /></td>
					<td><c:out value="${enteAssociato.codiceFiscale}" /></td>
					<td><c:out value="${enteAssociato.partitaIva}" /></td>
					<td class="tab_Right">
					
						<button type="button" class="btn btn-secondary pulsanteDisassocia" data-uid="<c:out value='${enteAssociato.idEnteCompilatore}' />">
							Dissocia &nbsp;
							<!-- <i class="icon-unlink icon-1x"> -->
						</button>
						<!-- <a class="btn btn-secondary" href="">Dissocia &nbsp;<i class="icon-unlink icon-1x"></i></a> -->
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
 
       </c:otherwise>  
</c:choose> 

<!-- /c:if -->
						