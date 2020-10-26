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
	<%@ include file="../navbarCompLogin.html" %>
	<%@ include file="../../../include/applicationHeader.html" %>

 <a  title="A-contenuti"></a>
</div>


<div class="row-fluid">
	<div class="span12">
		<ul class="breadcrumb">
			<li><a href="../menuCompilatore/start.do">Home</a> <span class="divider"></span>></li>	
			<li><a href="../gestioneDefinizioneModuliRicerca/goToConsultazione.do">Ricerca Modulo</a> <span class="divider"></span>></li>	
			<li class="active">Consultazione Modulo</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<form:form id="gestioneModuliConsultaModulo" modelAttribute="gestioneModuliConsultaModuloModel" method="post" action="">

			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
			<h3>Consultazione Modulo <c:out value="${gestioneModuliConsultaModuloModel.modulo.tipo}" /></h3>

			<fieldset class="form-horizontal">
	
					<div class="boxOrSpan2">
						<div class="boxOrInline">
							<p>Dati</p>
							<ul class="htmlelt">
								<li>
									<dfn>Titolo</dfn> 
									<dl><c:out value="${gestioneModuliConsultaModuloModel.modulo.nome}" /></dl>
								</li>
								
								<li>
									<dfn>Ragione Sociale</dfn> 
									<dl><c:out value="${gestioneModuliConsultaModuloModel.entiCompilatori.ragioneSociale}" /></dl>
								</li>
								
								<li>
									<dfn>Utente compilatore</dfn> 
									<dl><c:out value="${gestioneModuliConsultaModuloModel.utentiCompilatori.nome}" /> <c:out value="${gestioneModuliConsultaModuloModel.utentiCompilatori.cognome}" /></dl>
								</li>
							</ul>					
						</div>

					</div>
					<div class="clear"></div>
					
					<c:if test="${not empty gestioneModuliConsultaModuloModel.modulo.listaColonneModulo}">
					<table class="table table-hover tab_left" id="tabellaRigheColonneModulo" >
						<thead>
							<tr>
								<c:forEach var="colonna" items="${gestioneModuliConsultaModuloModel.modulo.listaColonneModulo}" >
									<th ><c:out value="${colonna.labelColonna}" /></th>
								</c:forEach>
							</tr>
						</thead>
						<tbody>
						
						<c:forEach var="riga" items="${gestioneModuliConsultaModuloModel.modulo.listaRigheModulo}" varStatus="row">
							<tr>                  								 
								<c:forEach var="cella" items="${riga.listaCelleModulo}" varStatus="col">		
									<td><c:out value="${cella.valore}" /></td>
								</c:forEach>
							</tr>
						</c:forEach>	
															
						</tbody>  
					</table>
					</c:if>
			</fieldset>

			<p>
				<a href="../gestioneDefinizioneModuliRicerca/goToConsultazione.do" class="btn btn-secondary">indietro</a>
			</p>       
			  
			</form:form>
		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>

<script src="../../js/portril/consultaModuli.js" type="text/javascript"></script>
</body>
</html>
