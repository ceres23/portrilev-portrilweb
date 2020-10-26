<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<%@ include file="../../../include/head.html"%>

</head>
<body>                       
<!-- NAVIGAZIONE -->

<p class="nascosto"><a  title="A-sommario"></a></p>     
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
			<li class="active">Risultati Modulo da sbloccare</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<form:form id="sbloccaConfermeModuli" commandName="sbloccaConfermeModuliModel" method="post" action="">
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
		    <form:hidden path="listaIdDaSbloccare" />
			<h3>Sblocca/Valida Modulo:  <c:out value="${sbloccaConfermeModuliModel.modulo.nome}" /></h3>
			<hr><hr>
			
			<div class="control-group">
				<div class="controls">
					<form:radiobutton class="radio inline" path="statoConferma" value="SI" />confermati  		
					<form:radiobutton class="radio inline" path="statoConferma" value="NO" />non confermati	
					<form:radiobutton class="radio inline" path="statoConferma" value="ALL" />Tutti 	
				</div>
			</div>



			
			<c:if test="${not empty sbloccaConfermeModuliModel.listaEntiCompilatoriRicercati}"> 		
			<div align="right">
				<p>
					<button type="button" class="btn btn-primary" name ="showSbloccaModuloXEnte"   id ="showSbloccaModuloXEnte" >Sblocca Modulo</button> 
					<button type="button" class="btn btn-primary" name ="showValidaModuloXEnte"    id ="showValidaModuloXEnte"  >Valida Modulo</button> 
					<button type="button" class="btn btn-primary" name ="showSvalidaModuloXEnte"   id ="showSvalidaModuloXEnte" >Elimina Validazione Modulo</button> 
				</p>       			  
			</div>
			<hr><hr>


				<div>
				<table class="table table-hover tab_left dataTable"  id="tabellaEntiRisultati">
					<thead>
						<tr>
						    <th><input type="checkbox" onchange="checkAllTableList(this)" name="chk[]" class="tooltip-test" title="Seleziona tutti" id="checkboxSelezionaTutti" /></th>
							<th>Ragione Sociale</th>
							<th>comune</th>
							<th>Provincia</th>
							<th>Codice Fiscale</th>
							<th>Partita Iva</th>
							<th>Confermato</th>
							<th>Validato</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="ente" items="${sbloccaConfermeModuliModel.listaEntiCompilatoriRicercati}" >
						<tr>
							
							<td>
								<c:if test="${ente.moduloEnteConfermato=='SI'}">
									<input type="checkbox" name="fooCheck"  <c:out value="${ente.checked}" />  id="fooCheck_<c:out value="${ente.idEnteCompilatore}" />" value="<c:out value="${ente.idEnteCompilatore}" />">
								</c:if>
							</td>
							
							<td><c:out value="${ente.ragioneSociale}" /></td>
							<td><c:out value="${ente.comune}" /></td>
							<td><c:out value="${ente.provincia}" /></td>
							<td><c:out value="${ente.codiceFiscale}" /></td>
							<td><c:out value="${ente.partitaIva}" /></td>						
							<td><c:out value="${ente.moduloEnteConfermato}" /></td>						
							<td><c:out value="${ente.moduloEnteValidato}" /></td>
						</tr>	
					</c:forEach>
						
					</tbody>
				</table>				
				</div>		
				
				<div class="Border_line" ></div>
					<div align="right">
					<p>
						<button type="button" class="btn btn-primary" name ="showSbloccaModuloXEnte"   id ="showSbloccaModuloXEnte1" >Sblocca Modulo</button> 
						<button type="button" class="btn btn-primary" name ="showValidaModuloXEnte"    id ="showValidaModuloXEnte1"  >Valida Modulo</button> 
						<button type="button" class="btn btn-primary" name ="showSvalidaModuloXEnte"   id ="showSvalidaModuloXEnte1" >Elimina Validazione Modulo</button> 
					</p>       			  
				</div>
			</c:if>									
				<p>
					<a href="../ricercaRisultati/start.do" class="btn btn-secondary">indietro</a>&nbsp;
				</p>       			  
			</form:form>
		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>
<%@ include file="modaleConfermaSblocca.jsp" %>
<script src="../../js/portril/sbloccaValidaModuli.js" type="text/javascript"></script>
</body>
</html>
