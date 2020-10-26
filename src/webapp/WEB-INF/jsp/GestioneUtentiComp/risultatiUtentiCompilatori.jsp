<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<c:choose>  
	<c:when test="${empty ricercaUtentiCompilatoriModel.listaUtentiCompilatori}"> 
		<!-- eventuale condizione di successo -->
	</c:when>  
	<c:otherwise>  
	<table class="table table-hover tab_left dataTable"  id="tabellaRisultatiUtentiCompilatori" >
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Codice Fiscale</th>
				<th>Stato</th>
				<th class="tab_Right span1">&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="uteComp" items="${ricercaUtentiCompilatoriModel.listaUtentiCompilatori}" >
			<tr>
				<td><c:out value="${uteComp.nome}" /></td>
				<td><c:out value="${uteComp.cognome}" /></td>
				<td><c:out value="${uteComp.codiceFiscale}" /></td>
				<td><c:out value="${uteComp.stato}" /></td>
				<td class="tab_Right">
					<div class="btn-group">
						<button class="btn dropdown-toggle" data-toggle="dropdown">Azioni<span class="caret"></span></button>
						<ul class="dropdown-menu pull-right">
							<li><a data-azione='<c:out  value="modificaUtenteCompilatore.do" />'   		    href='#'  data-id-utente='<c:out  value="${uteComp.idUtenteCompilatore}" />'    >modifica</a></li>
							<li><a data-azione='<c:out  value="cancellaUtenteCompilatore.do" />'   		    href='#'  data-id-utente='<c:out  value="${uteComp.idUtenteCompilatore}" />'    >elimina</a></li>
							<li><a data-azione='<c:out  value="disattivaAttivaUtenteCompilatore.do" />'  	href='#'  data-id-utente='<c:out  value="${uteComp.idUtenteCompilatore}" />'    >disattiva/attiva</a></li>
						</ul>
					</div>                               
				</td>
			</tr>	
			</c:forEach>		
		</tbody>
	</table>
	<form:hidden path="idUtenteSel"  />
	</c:otherwise>  
</c:choose> 
