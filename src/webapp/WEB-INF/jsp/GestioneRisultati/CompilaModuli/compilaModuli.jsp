<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<%@ include file="../../../../include/head.html"%>

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
	<%@ include file="../../../../include/portalheader.html" %>
	<%@ include file="../../navbarLogin.html" %>
	<%@ include file="../../../../include/applicationHeader.html" %>
	<a  title="A-contenuti"></a>
</div>

<div class="row-fluid">
	<div class="span12">
		<ul class="breadcrumb">
			<li><a href="../menuGestore/start.do">Home</a> <span class="divider">></span></li>	
			<li><a href="../ricercaModuliXComunicazione/start.do">Compila Modulo per Comunicazione</a> <span class="divider">></span></li>	
			<li class="active">Compilazione Modulo per comunicazione</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    

			<form:form id="compilaModuloXComunicazione" modelAttribute="gestioneModuliCompilaModuloModel" method="post"  action="">

			<%@ include file="../../../../include/alertErrorWarningSuccess.jsp" %>			
			<h3>Compilazione Modulo: &nbsp;&nbsp;&nbsp; <c:out value="${gestioneModuliCompilaModuloModel.modulo.nome}" /> </h3>

			<fieldset class="form-horizontal">	
			<!--		
					<div class="boxOrSpan2">
						<div class="boxOrInline">
							<p>Dati</p>
							<ul class="htmlelt">
						    <li>
						        <dfn>Titolo:</dfn>
						        <dl><c:out value="${gestioneModuliCompilaModuloModel.modulo.nome}" /></dl>
						    </li>
							 
						   <li>
						        <dfn>Ragione Sociale:</dfn>
						        <dl><c:out value="${gestioneModuliCompilaModuloModel.entiCompilatori.ragioneSociale}" /></dl>
						    </li>
						   <li>
						        <dfn>Utente compilatore:</dfn>
						                                                                                                         
						        <dl><c:out value="${gestioneModuliCompilaModuloModel.utentiCompilatori.nome}" /> <c:out value="${gestioneModuliCompilaModuloModel.utentiCompilatori.cognome}" /></dl>
						    </li>
						    
						   <li>
						        <dfn>Istruzioni compilazione:</dfn>
						        <dl><c:out value="${gestioneModuliCompilaModuloModel.modulo.istruzioniCompilazione}" /> </dl>
						    </li>
						    </ul>
						</div>
					</div>
					-->					
					<div class="clear"></div>
					<br />	
					<table class="table table-hover tab_left" id=TabellaRigheModulo>
					<thead>
						<tr>
							<th class="span2"><input type="checkbox" onchange="checkAllTableList(this)" name="chk[]" class="tooltip-test" title="Seleziona tutti" /></th>
							<c:forEach var="colonna" items="${gestioneModuliCompilaModuloModel.modulo.listaColonneModulo}" >
								<th ><c:out value="${colonna.labelColonna}" /></th>
							</c:forEach>												
						</tr>
					</thead>
					<tbody>						
						<c:forEach var="riga" items="${gestioneModuliCompilaModuloModel.modulo.listaRigheModulo}" varStatus="row">
							<tr>							 
								<td><input type="checkbox" name="fooCheck"    id="fooCheck_<c:out value="${row.index}"/>" value="<c:out value="${row.index}"/>" /> &nbsp;<c:out value="${row.index + 1}"/></td>

								<c:forEach var="cella" items="${riga.listaCelleModulo}" varStatus="col">		
									<td>										
										<input name="campoedit" id='<c:out value="${row.index}"/>-<c:out value="${col.index}"/>' class="span12" type="text" value='<c:out value="${cella.valore}" />' data-row='<c:out value="${row.index}"/>' data-column='<c:out value="${col.index}"/>' >
									</td>
								</c:forEach>
							</tr>
						</c:forEach>	
					</tbody>  
				</table>

			</fieldset>
			<p>
				<button type="button" class="btn btn-primary" name ="aggiungiRiga"   id ="aggiungiRiga" >aggiungi riga</button> &nbsp;
				<button type="button" class="btn btn-primary" name ="eliminaRighe"   id ="eliminaRighe" >elimina righe</button> 
			</p>
			
			<div class="clear"></div>	
			<div class="Border_line"></div>
			<p>
				<a href="../ricercaModuliXComunicazione/start.do" class="btn btn-secondary">indietro</a>
				<span class="pull-right">
					<form:hidden path="listaIdDaEliminare" />
					<form:hidden path="goToLastPage"/>
					<button type="button" class="btn btn-primary" name ="salva"     id ="salva" >salva</button> 
				</span>
			</p>       
			  
			</form:form>
		</div>
	</div>	 
</div>	

<%@ include file="../../../../include/infoRequired.html" %>
<%@ include file="../../../../include/portalFooter.html" %>
<%@ include file="../../../../include/javascript.jsp" %>

<script src="../../js/portril/common.js" type="text/javascript"></script>
<script src="../../js/portril/compilaModulixComunicazione.js" type="text/javascript"></script>

	<div class="modal hide fade" id="modalinoDiAttesa" data-backdrop="static" data-keyboard="false">
		<div class="modal-body">
			<h1>Caricamento in corso</h1>
			<h4>Attendere, prego...</h4>
		</div>
	</div>
</body>
</html>