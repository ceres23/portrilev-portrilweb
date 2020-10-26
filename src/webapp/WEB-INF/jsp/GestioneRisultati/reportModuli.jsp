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
			<li class="active">Stato compilazione enti</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<form:form id="gestore/reportEntiCompilatoriFromModulo" commandName="reportEntiCompilatoriFromModuloModel" method="post" action="">
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
			<h3>Stato compilazione enti Modulo <c:out value="${reportEntiCompilatoriFromModuloModel.modulo.nome}" /> </h3>
			
			
			<div class="step-content">
				<div class="step-pane active" id="step1">
					<h4>Dati</h4>
					<fieldset class="form-horizontal">
				
					<br>
					<div class="control-group">
						<div class="controls">
							<form:radiobutton class="radio inline" path="stato" value="DA_COMPILARE" />Da Compilare   		
							<form:radiobutton class="radio inline" path="stato" value="COMPILATO" />Gi&agrave; Compilato
							<form:radiobutton class="radio inline" path="stato" value="TUTTI" />Tutti 	
						</div>
					</div>
						<%-- 
						<div class="control-group">
							<span class="control-label">Stato</span>
							<div class="controls">
								<label class="radio inline">
									<input type="radio" name="stato" value="DA_COMPILARE" id="stato1">
									Da Compilare 
								</label>
								<label class="radio inline">
									<input type="radio" name="stato" value="COMPILATO" id="stato2">
									Gi&agrave; Compilato
								</label>
								<label class="radio inline">
									<input type="radio" name="stato" value="TUTTI" id="stato3"  >
									Tutti 
								</label>
							</div>
						</div>		
						--%>
						<br>
					</fieldset>
					
				</div>
			</div>
			
			<div class="clear"></div>
			<br>
						
			<p>
				<a href="../ricercaRisultati/start.do" class="btn btn-secondary">indietro</a>
				<span class="pull-right">
					<button type="button" class="btn btn-primary" id="ricerca" name="ricerca" >cerca</button> 
				</span>
			</p>       
					
			<c:if test="${not empty reportEntiCompilatoriFromModuloModel.listaEntiCompilatori}"> 
			<div id="risModuli" >
					<table class="table table-hover tab_left" id="tabellaRisultatiEntiCompilatoriModulo">
						<thead>
							<tr>
								<th>Ragione Sociale</th>
								<th>Comune</th>
								<th>Provincia</th>
								<th>Stato</th>
								<!--  
								<th>Utente Compilatore</th>
								<th>Data compilazione</th>
								-->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="entiComp" items="${reportEntiCompilatoriFromModuloModel.listaEntiCompilatori}" >
							<tr>
								<td><c:out value="${entiComp.ragioneSociale}" /></td>
								<td><c:out value="${entiComp.comune}" /></td>
								<td><c:out value="${entiComp.provincia}" /></td>
								<td><c:out value="${entiComp.stato}" /></td>
								<%-- 
								<td><c:out value="${entiComp.ultimoUtenteCompilatore.nome}" /> - <c:out value="${entiComp.ultimoUtenteCompilatore.cognome}" /></td>
								<td><c:out value="${entiComp.ultimoUtenteCompilatore.dataUltimoAggRigheModuloStr}" /></td>
								--%>								
							</tr>	
							</c:forEach>
							
						</tbody>  
					</table>
					<br>
				<p>
				<button type="button" class="btn btn-primary" id="esporta" name="esporta" >esporta</button> 
				</p>
				<div class="clear"></div>
				<br>
				<div class="Border_line"></div>					
			</div>	
			</c:if>
			</form:form>
		</div>
	
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>
<script src="../../js/portril/reportModuli.js" type="text/javascript"></script>

</body>
</html>
