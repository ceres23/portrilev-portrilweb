<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<spring:bind path="*">
	<c:if test="${feedbackWarning.warning}">
		<div class="alert alert-warning">
			<button type="button" class="close" data-dismiss="alert">&times;</button>	
			<strong>Attenzione!!</strong><br>
			<ul>
			<c:forEach var="war" items="${feedbackWarning.msgWarning}">
    			<li><c:out value="${war}"/> </li>
			</c:forEach>
			</ul>
		</div>
	</c:if>
</spring:bind>
