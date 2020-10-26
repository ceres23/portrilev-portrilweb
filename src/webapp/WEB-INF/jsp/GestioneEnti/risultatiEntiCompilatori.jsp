<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<c:choose>  
	<c:when test="${empty ricercaEntiCompilatoriModel.listaEntiCompilatori}"> 
		<!-- eventuale condizione di successo -->
	</c:when>  
<c:otherwise>  
	<table class="table table-hover tab_left dataTable"  id="tabellaRisultatiEntiCompilatori" >
		<thead>
			<tr>
				<th>Ragione Sociale</th>
				<th>Comune</th>
				<th>Provincia</th>
				<!--<th>Istat</th>-->
				<th>Codice Fiscale</th>
				<th>Partita Iva</th>
				<th>Stato</th>
				<th class="tab_Right span1">&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entiComp" items="${ricercaEntiCompilatoriModel.listaEntiCompilatori}" >
			<tr>
				<td><c:out value="${entiComp.ragioneSociale}" /></td>
				<td><c:out value="${entiComp.comune}" /></td>
				<td><c:out value="${entiComp.provincia}" /></td>
				<%--<td><c:out value="${entiComp.istat}" /></td>--%>				
				<td><c:out value="${entiComp.codiceFiscale}" /></td>
				<td><c:out value="${entiComp.partitaIva}" /></td>
				<td><c:out value="${entiComp.stato}" /></td>
				<td class="tab_Right">
					<div class="btn-group">
						<button class="btn dropdown-toggle" data-toggle="dropdown">Azioni<span class="caret"></span></button>
						<ul class="dropdown-menu pull-right">
						
						<li><a data-azione='<c:out  value="modificaEnteCompilatore.do" />'   		href='#'  data-id-ente='<c:out  value="${entiComp.idEnteCompilatore}" />'    >modifica</a></li>
						<li><a data-azione='<c:out  value="cancellaEnteCompilatore.do" />'   		href='#'  data-id-ente='<c:out  value="${entiComp.idEnteCompilatore}" />'    >elimina</a></li>
						<li><a data-azione='<c:out  value="disattivaAttivaEnteCompilatore.do" />'  	href='#'  data-id-ente='<c:out  value="${entiComp.idEnteCompilatore}" />'    >disattiva/attiva</a></li>
		
						</ul>
					</div>                               
				</td>
			</tr>	
			</c:forEach>
		</tbody>
	</table>
	<form:hidden path="idEnteSel"  />
	</c:otherwise>  
</c:choose> 
