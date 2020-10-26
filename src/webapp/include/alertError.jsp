<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<spring:bind path="*">
	<c:if test="${feedbackError.errorePresente}">		
		<div class="alert alert-error">
			<button type="button" class="close" data-dismiss="alert">&times;</button>			
			<strong>Attenzione!  </strong> 
			<c:if test="${not feedbackError.visuaizzaErroriSpecifici}">
				<strong> errori nella compilazione del form</strong>
			</c:if>
			
			<c:if test="${feedbackError.visuaizzaErroriSpecifici}">
			<ul>
			<c:forEach var="err" items="${feedbackError.listaMsgErrori}">
				<li><c:out value="${err}"/></li>
			</c:forEach>
			</ul>
			</c:if>
		</div>
	</c:if>
</spring:bind>