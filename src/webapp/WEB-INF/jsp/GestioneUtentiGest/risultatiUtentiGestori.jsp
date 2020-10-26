<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<c:choose>  
	<c:when test="${empty ricercaUtentiGestoriModel.listaUtentiGestori}"> 
		<!-- eventuale condizione di successo -->
	</c:when>  
	<c:otherwise>     
		<table class="table table-hover tab_left dataTable"  id="tabellaRisultatiUtentiGest">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Codice Fiscale</th>
					<th>Profilo</th>
					<th>Stato</th>
					<th class="tab_Right span1">&nbsp;</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="uteGest" items="${ricercaUtentiGestoriModel.listaUtentiGestori}" >
				<tr>
					<td><c:out value="${uteGest.nome}" /></td>
					<td><c:out value="${uteGest.cognome}" /></td>
					<td><c:out value="${uteGest.codiceFiscale}" /></td>
					<td><c:out value="${uteGest.profiliUtentiModel.descrizione}" /></td>							
					<td><c:out value="${uteGest.stato}" /></td>
					
					<td class="tab_Right">
						<div class="btn-group">
							<button class="btn dropdown-toggle" data-toggle="dropdown">Azioni<span class="caret"></span></button>
							<ul class="dropdown-menu pull-right">
								<li><a data-azione='<c:out  value="modificaUtenteGestore.do" />'   		href='#'  data-id-utente='<c:out  value="${uteGest.idUtenteGestore}" />' >modifica</a></li>
								<li><a data-azione='<c:out  value="cancellaUtenteGestore.do" />'   		href='#'  data-id-utente='<c:out  value="${uteGest.idUtenteGestore}" />' data-toggle="modal">elimina</a></li>
								<li><a data-azione='<c:out  value="disattivaAttivaUtenteGestore.do" />' href='#'  data-id-utente='<c:out  value="${uteGest.idUtenteGestore}" />' >disattiva/attiva</a></li>
							</ul>
						</div>                               
					</td>
				</tr>	
				</c:forEach>
			</tbody>
		</table>
		<form:hidden path="IdUtenteSel"  />
	</c:otherwise>  
</c:choose>