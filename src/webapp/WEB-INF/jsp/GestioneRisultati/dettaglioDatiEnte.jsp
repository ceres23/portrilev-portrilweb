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

 <a name="A-contenuti" title="A-contenuti"></a>
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
			<form:form id="/gestore/dettaglioDatiEnte" commandName="dettaglioDatiEnteModel" method="post" action="esporta">
			<!--#include virtual="../../ris/include/alertErrorSuccess.html" -->
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
			<h3>Visualizzazione Dati Modulo Ente</h3>
			<fieldset class="form-horizontal">
					
					<div class="boxOrSpan2">
						<div class="boxOrInline">
						<p>Dati Ente</p>
							<ul class="htmlelt">
								<li>
									<dfn>Ragione Sociale</dfn> 
									<dl><c:out value="${dettaglioDatiEnteModel.entiCompilatoriModel.ragioneSociale}" /></dl>
								</li>
								<li>
									<dfn>Comune</dfn> 
									<dl><c:out value="${dettaglioDatiEnteModel.entiCompilatoriModel.comune}" /></dl>
								</li>
								<li>
									<dfn>Provincia</dfn> 
									<dl><c:out value="${dettaglioDatiEnteModel.entiCompilatoriModel.provincia}" /></dl>
								</li>
								<li>
									<dfn>Codice Fiscale</dfn> 
									<dl><c:out value="${dettaglioDatiEnteModel.entiCompilatoriModel.codiceFiscale}" /></dl>
								</li>
								<li>
									<dfn>Partita Iva</dfn> 
									<dl><c:out value="${dettaglioDatiEnteModel.entiCompilatoriModel.partitaIva}" /></dl>
								</li>
								<%--
								<li>
									<dfn>Utente compilatore</dfn> 
									<dl>nome - cognome<c:out value="${dettaglioDatiEnteModel.entiCompilatoriModel.nome}" /> - <c:out value="${dettaglioDatiEnteModel.entiCompilatoriModel.cognome}" /></dl>
								</li>
								 --%>
								<li>
									<dfn>Data ultima modifica</dfn> 
									<dl><c:out value="${dettaglioDatiEnteModel.entiCompilatoriModel.dataAggStr}" /></dl>
								</li>
							</ul>					
						</div>

					</div>
					<div class="clear"></div>

					<c:if test="${not empty dettaglioDatiEnteModel.listaRigheModulo}"> 

					<table class="table table-hover tab_left" id="tabellaRisultatiRigheModuloEnte" >
						<thead>
							<tr>
								<c:forEach var="colonna" items="${dettaglioDatiEnteModel.listaColonneModulo}" >
									<th ><c:out value="${colonna.labelColonna}" /></th>
								</c:forEach>
							</tr>
						</thead>
						<tbody>

						<c:forEach var="riga" items="${dettaglioDatiEnteModel.listaRigheModulo}" varStatus="row">
							<tr>                  
								<%--
								<td class="span1"><input type="checkbox" name="fooCheck"  <c:out value="${riga.checked}" />   id="fooCheck_<c:out value="${riga.idRiga}" />" value="<c:out value="${riga.idRiga}" />"></td>
								<td><c:out value="${riga.ragioneSocialeEnte}"/></td>
								 --%>
								
								<c:forEach var="cella" items="${riga.listaCelleModulo}" varStatus="col">		
									<td>
										<c:out value="${cella.valore}" />
									</td>									
								</c:forEach>
							</tr>
						</c:forEach>
						</tbody>  
					</table>

					</c:if> 

			</fieldset>
			
			<div class="Border_line"></div>
			<p>
				<a href="../visualizzaDatiEnte/start.do" class="btn btn-secondary">indietro</a>
				<span class="pull-right">
					<button type="button" class="btn btn-primary" id="esporta" name="esporta" >esporta</button> 
				</span>
			</p>       
			  
			</form:form>
		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>
<script src="../../js/portril/dettaglioDatiEnte.js" type="text/javascript"></script>

</body>
</html>
