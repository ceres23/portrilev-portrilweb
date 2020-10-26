<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<%@ include file="../../../include/head.html"%>

</head>
<body> 
                      
<!-- NAVIGAZIONE -->

<p class="nascosto"><a title="A-sommario"></a></p>     
<ul id="sommario" class="nascosto">
	<li><a href="#A-contenuti">Salta ai contenuti</a></li>
</ul>

<!-- /NAVIGAZIONE -->
	
	
<hr />
<div class="container-fluid-banner">

	<%@ include file="../../../include/portalheader.html" %>
	<%@ include file="../navbarLogin.html" %>
	<%@ include file="../../../include/applicationHeader.html" %>
 <a  title="A-contenuti"></a>
</div>


<div class="row-fluid">
	<div class="span12">
		<ul class="breadcrumb">
			<li><a href="../menuGestore/start.do">Home</a> <span class="divider"></span></li>	
			<li class="active">Ricerca utente gestore</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<form:form id="gestore/ricercaUtentiGestori" commandName="ricercaUtentiGestoriModel" method="post" action="ricerca.do">
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
			<h3>Ricerca utente gestore</h3>
			<p>&Egrave; necessario inserire almeno un criterio di ricerca.</p>
			<div class="step-content">
				<div class="step-pane active" id="step1">
						<fieldset class="form-horizontal"> 
					<h4>Dati</h4>
						<div class="control-group">
							<label class="control-label" for="nome">Nome</label>
							<div class="controls">
								<!--<input id="NomeEnte" class="span6" type="text" value="" name="NomeEnte">-->
								<form:input path="nome" class="span6" type="text" maxlength="50"/>									
								<form:errors path="nome" class="msgErrorRequired" />																
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="cognome">Cognome</label>
							<div class="controls">
								<!--<input id="CognomeEnte" class="span6" type="text" value="" name="CognomeEnte">-->
								<form:input path="cognome" class="span6" type="text" maxlength="50" />									
								<form:errors path="cognome" class="msgErrorRequired" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="codiceFiscale">Codice Fiscale</label>
							<div class="controls">
								<!--<input id="CodiceFiscaleEnte" class="span6" type="text" value="" name="CodiceFiscaleEnte">-->
								<form:input path="codiceFiscale" class="span6" type="text" maxlength="50" />									
								<form:errors path="codiceFiscale" class="msgErrorRequired" />
							</div>
						</div>

						<div class="control-group">
							<span class="control-label">Profilo</span>
							<div class="controls">
							    
							    <c:set var="tutti" value="ok" />				 							
								<c:forEach items="${ricercaUtentiGestoriModel.listaProfili}" var="elSel">

									<c:set var="var1" value="${elSel.idProfiloUtente}" />
									<c:set var="var2" value="${ricercaUtentiGestoriModel.strIdProfiloUtente}" />

								    <label class="radio inline">
								    <c:choose>
										<c:when test="${var1 == var2}">
											<c:set var="tutti" value="ko" />
											<input type="radio" name="strIdProfiloUtente" checked="checked" value='<c:out value="${elSel.idProfiloUtente}" />' id='idProfiloUtente<c:out value="${elSel.idProfiloUtente}" />' ><c:out value="${elSel.descrizione}" />
								    	</c:when>
										<c:otherwise>
											<input type="radio" name="strIdProfiloUtente"  value='<c:out value="${elSel.idProfiloUtente}" />' id='idProfiloUtente<c:out value="${elSel.idProfiloUtente}" />' ><c:out value="${elSel.descrizione}" />
										</c:otherwise>
									</c:choose>
								    </label>
							    
							    	
							    
								</c:forEach>

							    <label class="radio inline">
									<input type="radio" name="strIdProfiloUtente"   <c:if test="${tutti=='ok'}" > checked </c:if> value='0' id='strIdProfiloUtente0'  >
							    	Tutti i Profili
							    </label>

							</div>
						</div>
						
						<br>
					</fieldset> 				
				</div>
			</div>
			  
			
			<p class="margin-medium">
				<a href="../menuGestore/start.do" class="btn btn-secondary">indietro</a>
				<button type="button" class="btn btn-secondary" id ="clean" >pulisci</button> 
				<button type="submit" class="btn btn-primary pull-right" >cerca</button> 
			</p>       
					
			<div class="clear"></div>
			<br>
			<div id="TableUtenti" >
				<div>
					<fieldset class="form-horizontal" >  
						<%@ include file="risultatiUtentiGestori.jsp" %>
					</fieldset>											
				</div>
			</div>
			  				   
		</form:form>
		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>

<script src="../../js/portril/utentiGestori.js" type="text/javascript"></script>

</body>
</html>
