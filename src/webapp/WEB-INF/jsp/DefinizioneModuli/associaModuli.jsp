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
			<li class="active">Risultati ricerca Modulo</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<form:form id="associaModuliEnti" commandName="associaModuliEntiModel" method="post" action="">
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			<form:hidden path="idEnteAssociato"  />
			<form:hidden path="idEnteDisAssociato"  />
		
			<h3>Associa a modulo <c:out value="${associaModuliEntiModel.modulo.nome}" /></h3>
			<h4>Stato: <c:out value="${associaModuliEntiModel.modulo.stato}" /></h4>

			<div class="accordion" id="soggetto2">
				<div class="accordion-group">
					<div class="accordion-heading">    
						<a class="accordion-toggle" data-toggle="collapse" data-parent="#soggetto2" href="#accordionFiltroRicerca">Ricerca enti<span class="icon">&nbsp;</span></a>
					</div>
					<div class="accordion-body in collapse" id="accordionFiltroRicerca">
						<div class="accordion-inner">
							<fieldset class="form-horizontal">
								<div class="control-group">
									<label class="control-label" for="ragioneSociale" >Ragione Sociale</label>
									<div class="controls">
										<form:input path="ragioneSociale" class="span9" maxlength="500" />
									</div>
								</div>
								<%--
								<div class="control-group">
									<label class="control-label" for="classificazione" >Classificazione</label>
									<div class="controls">
										<form:input path="classificazione" class="span6" maxlength="50" />
									</div>
								</div>
								 --%>
								<div class="control-group">
									<label class="control-label" for="comune">Comune</label>
									<div class="controls">
										<form:input path="comune" class="span6" maxlength="50" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="provincia">Provincia</label>
									<div class="controls">
										<form:input path="provincia" class="span1" maxlength="2" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="codiceFiscale">Codice Fiscale</label>
									<div class="controls">
										<form:input path="codiceFiscale" class="span6" maxlength="16" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="partitaIva">Partita Iva</label>
									<div class="controls">
										<form:input path="partitaIva" class="span2" maxlength="11" />
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="partitaIva">Enti compilatori</label>
									<div class="controls">
									<form:radiobutton class="radio inline" path="associato" value="ASSOCIATO" />associati 
									<form:radiobutton class="radio inline" path="associato" value="DISASSOCIATO" />non associati	
									<form:hidden path="ultimaRicercaAssociato" />
									
									</div>								
								</div>
								
							</fieldset>
							<p><button type="button" class="btn btn-primary  pull-right" id ="ricerca" data-action="ricerca.do" >cerca</button> </p>
						</div>
					</div>
				</div>
			</div>
			
								
			<c:if test="${not empty associaModuliEntiModel.listaEntiCompilatoriRicercati}"> 

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
							<%--<th class="tab_Right">&nbsp;</th> --%>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="ente" items="${associaModuliEntiModel.listaEntiCompilatoriRicercati}" >
						<tr>
							<td><input type="checkbox" name="fooCheck"  <c:out value="${ente.checked}" />  id="fooCheck_<c:out value="${ente.idEnteCompilatore}" />" value="<c:out value="${ente.idEnteCompilatore}" />"></td>
							<td><c:out value="${ente.ragioneSociale}" /></td>
							<td><c:out value="${ente.comune}" /></td>
							<td><c:out value="${ente.provincia}" /></td>
							<td><c:out value="${ente.codiceFiscale}" /></td>
							<td><c:out value="${ente.partitaIva}" /></td>
							<%--
							<td class="tab_Right">
								<button type="button" class="btn btn-secondary pulsanteAssocia" data-uid="<c:out value='${ente.idEnteCompilatore}' />">Associa&nbsp;<i class="icon-link icon-1x"></i></button>
							</td>
							--%>
						</tr>	
					</c:forEach>
						
					</tbody>
				</table>
				
					<form:hidden path="listaIdDaAssociare" />
					<form:hidden path="listaIdDaNonAssociare" />
				
				
				</div>
			
			</c:if>									

			<div class="Border_line"></div>
			<p>
				<a href="../ricercaModuli/start.do" class="btn btn-secondary">indietro</a>
				&nbsp;
				<button type="button" class="btn btn-secondary" name ="selezionaTuttiGliEnti" id ="selezionaTuttiGliEnti"  >Seleziona tutti gli enti</button> 
				<button type="button" class="btn btn-secondary pull-right" name ="salvaAssociazione" id ="salvaAssociazione"  >salva</button> 
			</p>       			  
			</form:form>
		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>

<script src="../../js/portril/associaModuli.js" type="text/javascript"></script>

</body>
</html>
