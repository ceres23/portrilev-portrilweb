<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>

<c:if test="${not  feedbackError.errorePresente}">
	<c:if test="${feedbackSuccess.success}">
	<div class="alert alert-success">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<ul>	
			<c:forEach var="succ" items="${feedbackSuccess.msgSuccess}">
				<li><strong><c:out value="${succ}"/></strong></li>	
			</c:forEach>
		</ul>
	</div> 
	</c:if>
</c:if>

