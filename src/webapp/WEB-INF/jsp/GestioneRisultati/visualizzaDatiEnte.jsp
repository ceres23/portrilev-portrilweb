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
			<li class="active">Visualizzazione Dati Ente</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<form:form id="gestore/visualizzaDatiEnte" commandName="visualizzaDatiEnteModel" method="post" action="">

			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
			<h3>Visualizzazione Dati Modulo Ente</h3>
			<h4>Modulo: <c:out value="${MODULO_SEL.nome}"     /></h4>
			<hr>			
			Visualizzazione Dati Modulo Ente
			<div class="step-content">
				<div class="step-pane active" id="step1">
					<h4>Dati</h4>
					<fieldset class="form-horizontal">

						<div class="control-group">
							<label class="control-label" for="RagioneSocialeEnte">Ragione Sociale</label>
							<div class="controls">
								<form:input path="ragioneSociale" class="span9" type="text" maxlength="500" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="comune">Comune</label>
							<div class="controls">
								<form:input  path="comune" class="span6" type="text" maxlength="50" />	
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="provincia">Provincia</label>
							<div class="controls">
								<form:input path="provincia" class="span1" type="text" maxlength="2" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="codiceFiscale">Codice Fiscale</label>
							<div class="controls">
								<form:input  path="codiceFiscale" class="span6" type="text" maxlength="16" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="partitaIva">Partita Iva</label>
							<div class="controls">
								<form:input  path="partitaIva" class="span2" type="text" maxlength="11" />
							</div>
						</div>

					
					</fieldset>
				</div>
			</div>
			
			<p class="margin-medium">
				
				<a href="../ricercaRisultati/start.do" class="btn btn-secondary">indietro</a>
				<button type="button" class="btn btn-secondary" id ="clean" >pulisci</button> 
				<button type="button" class="btn btn-primary pull-right" id="ricerca" name="ricerca" >cerca</button> 
			</p>       
			  
			<c:choose>  
				<c:when test="${empty visualizzaDatiEnteModel.listaEntiCompilatori}"> 
					<!-- eventuale condizione di successo -->
				</c:when>  
				<c:otherwise>  

			
			<div id="risModuli" >
				<br/>	
					<table class="table table-hover tab_left" id="tabellaRisultatiEnteCompilatore" >
						<thead>
							<tr>
								<th>&nbsp;</th>
								<th>Ragione sociale</th>
								<th>Comune</th>
								<th>Provincia</th>
								<th>Codice fiscale</th>
								<th>Partita iva</th>
								<th>Data ultima modifica</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="entiComp" varStatus="row" items="${visualizzaDatiEnteModel.listaEntiCompilatori}" >
							<tr>                  
								<td><input type="radio" name="modEnte" id='modEnte<c:out value="${row.index}"/>' value="<c:out value="${entiComp.idEnteCompilatore}" />" ></td>
								<td><c:out value="${entiComp.ragioneSociale}" /></td>
								<td><c:out value="${entiComp.comune}" /></td>
								<td><c:out value="${entiComp.provincia}" /></td>
								<td><c:out value="${entiComp.codiceFiscale}" /></td>
								<td><c:out value="${entiComp.partitaIva}" /></td>
								<td><c:out value="${entiComp.dataAggStr}" /></td>
							</tr>
						</c:forEach>	

						</tbody>  
					</table>
					
					<br>
				<p class="btnVisible" style="display:none">
				
					<button type="button" class="btn btn-primary" id="visualizza" name="visualizza" >visualizza</button> 

				</p>			
			</div>
				
				
				<form:hidden path="idEnteSel"  />
				</c:otherwise>  
			</c:choose> 	
			
			</form:form>
		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>
<script src="../../js/portril/visualizzaDatiEnti.js" type="text/javascript"></script>



</body>
</html>
