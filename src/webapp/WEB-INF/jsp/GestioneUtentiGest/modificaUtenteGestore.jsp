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
 <a title="A-contenuti"></a>
</div>


<div class="row-fluid">
	<div class="span12">
		<ul class="breadcrumb">
			<li><a href="../menuGestore/start.do">Home</a> <span class="divider"></span></li>			
			<li class="active">Modifica Utente Gestore</li>
		</ul> 
	</div>	
</div>
                                                   
<form:form id="gestore/modificaUtenteGestore" commandName="utentiGestoriModel" method="post" action="modificaUtente.do">

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			<h3>Modifica Utente Gestore</h3>
			
			<div class="step-content">
				<div class="step-pane active" id="step1">
					<h4>Dati utente</h4>
					<fieldset class="form-horizontal">
						<div class="control-group">
							<label class="control-label" for="nome">Nome*</label>
							<div class="controls">
								<c:out value="${utentiGestoriModel.nome}" />
								<form:hidden path="nome" />									
								<form:errors path="nome" class="msgErrorRequired" />									
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="cognome">Cognome*</label>
							<div class="controls">
								<c:out value="${utentiGestoriModel.cognome}" />
								<form:hidden path="cognome" />									
								<form:errors path="cognome" class="msgErrorRequired" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="codiceFiscale">Codice Fiscale*</label>
							<div class="controls">
								<c:out value="${utentiGestoriModel.codiceFiscale}" />
								<form:hidden path="codiceFiscale"  />									
								<form:errors path="codiceFiscale" class="msgErrorRequired" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="mail">Mail*</label>
							<div class="controls">
								<form:input path="mail" class="span6" type="text" maxlength="150" />									
								<form:errors path="mail" class="msgErrorRequired" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="telefono">Telefono*</label>
							<div class="controls">
								<form:input path="telefono" class="span6" type="text" maxlength="50" />
								<form:hidden path="idUtenteGestore" />
								<form:hidden path="stato" />
								<form:errors path="telefono" class="msgErrorRequired" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="idProfiloUtente">Profilo</label>
							<div class="controls">

							
							<select id="idProfiloUtente" name="idProfiloUtente" >
								<c:forEach items="${LISTA_PROFILI_UTENTI_GESTIONE}" var="elSel">

									<c:set var="id1" value="${elSel.idProfiloUtente}" />
									<c:set var="id2" value="${utentiGestoriModel.profiliUtentiModel.idProfiloUtente}" />
									
									<c:choose>
										<c:when test="${ id1 == id2}">
											<option Value="${elSel.idProfiloUtente}"   selected="selected"  >${elSel.descrizione}</option>
										</c:when>
										<c:otherwise>
											<option Value="${elSel.idProfiloUtente}" >${elSel.descrizione}</option>										
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
							
							
							
							
							
							</div>
						</div>						
					</fieldset>
				</div>
			</div>
 
			<p class="margin-medium">
				<a href="../ricercaUtentiGestori/start.do" class="btn btn-secondary">indietro</a>
				<!-- <a class="btn btn-secondary" href="javascript:history.go(-1)">indietro</a>-->
				<button type="button" class="btn btn-secondary" id ="clean" >pulisci</button> 
				<button type="submit" class="btn btn-primary pull-right" >salva</button> 
			</p>
		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>
</form:form>
</body>
</html>
