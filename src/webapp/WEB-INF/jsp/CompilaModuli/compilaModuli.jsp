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
			<li><a href="../menuCompilatore/start.do">Home</a> <span class="divider">></span></li>	
			<li><a href="../gestioneModuliRicercaPerCompilazione/start.do">Ricerca Compila Modulo</a> <span class="divider">></span></li>	
			<li class="active">Compilazione Modulo</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    

			<form:form id="gestioneModuliCompilaModulo" modelAttribute="gestioneModuliCompilaModuloModel" method="post"  action="">

			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>			
			<h3>Compilazione Modulo</h3>

			<fieldset class="form-horizontal">			
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
						   <li>
						        <dfn>Descrizione Modulo:</dfn>
						        <dl><c:out value="${gestioneModuliCompilaModuloModel.modulo.descrizione}" /> </dl>
						    </li>
						   <li>
						        <dfn>Note Modulo:</dfn>
						        <dl><c:out value="${gestioneModuliCompilaModuloModel.modulo.note}" /> </dl>
						    </li>
						    </ul>
						</div>
					</div>
					
					<div class="clear">
						<span style="width: 100%;text-align: center" >
							<c:if test="${gestioneModuliCompilaModuloModel.modulo.obbligConferma == 'SI' && gestioneModuliCompilaModuloModel.moduloConfermato == 'SI'}">
								<h4><font color="blue">Modulo confermato e non piu' modificabile per eventuali modifiche rivolgersi al proprio ente gestore</font></h4> 
    						</c:if>    
						</span>
					
					</div>
					
					<div class="clear">
					<span class="pull-right">	
						<c:if test="${gestioneModuliCompilaModuloModel.moduloConfermato != 'SI'}">
							<button type="button" class="btn btn-primary" name ="showAggiungiRiga"   id ="showAggiungiRiga" >aggiungi riga</button>&nbsp;
							<button type="button" class="btn btn-primary" name ="showModificaRighe"  id ="showModificaRiga" >modifica riga</button>&nbsp; 
							<button type="button" class="btn btn-primary" name ="showeliminaRighe"   id ="showeliminaRighe" >elimina righe</button> 
							<c:if test="${gestioneModuliCompilaModuloModel.modulo.obbligConferma == 'SI'}">						
								<button type="button" class="btn btn-primary" name ="showConfermaModulo"   id ="showConfermaModulo" >conferma modulo</button> 							
							</c:if>
						</c:if>
					</span>
					</div>
					
					<table class="table table-hover tab_left" id=TabellaRigheModulo>
					<thead>
						<tr>
							<th class="span2"><input type="checkbox" onchange="checkAllTableList(this)" name="chk[]" class="tooltip-test" title="Seleziona tutti" /></th>
							<c:forEach var="colonna" items="${gestioneModuliCompilaModuloModel.modulo.listaColonneModulo}" >
								<th ><c:out value="${colonna.labelColonna}" /></th>
							</c:forEach>												
						</tr>
						<tr>
							<th><button type="button" class="btn btn-primary" name ="filtraRighe"   id ="filtraRighe" >filtra</button></th>
							<c:forEach items="${gestioneModuliCompilaModuloModel.modulo.listaColonneModulo}" varStatus="col" >
								<th> <input name="campoFiltro[<c:out value="${col.index}"/>]"  id="campoFiltro_<c:out value="${col.index}"/>" class="span12" value='<c:out value="${gestioneModuliCompilaModuloModel.campoFiltro[col.index]}" />'  type="text" data-column='<c:out value="${col.index}"/>'></th>
							</c:forEach>																		
						</tr>
						
					</thead>
					<tbody>	
						<%-- 
						<tr>
							<td>&nbsp;</td>
							<c:forEach items="${gestioneModuliCompilaModuloModel.modulo.listaColonneModulo}" varStatus="col" >
								<td><input name="campoFiltro_<c:out value="${col.index}"/>"  id="campoFiltro_<c:out value="${col.index}"/>" class="span12" type="text" data-column='<c:out value="${col.index}"/>' ></td>
							</c:forEach>																		
						</tr>
					    --%>
						<%--			
						<c:forEach var="riga" items="${gestioneModuliCompilaModuloModel.modulo.listaRigheModulo}" varStatus="row">
							<tr>							 
								<td>
									<input type="checkbox" name="fooCheck"    id="fooCheck_<c:out value="${row.index}"/>" value="<c:out value="${row.index}"/>" /> &nbsp;<c:out value="${row.index + 1}"/>
								</td>

								<c:forEach var="cella" items="${riga.listaCelleModulo}" varStatus="col">		
									<td>										
										<input name="campoedit" id='<c:out value="${row.index}"/>-<c:out value="${col.index}"/>' class="span12" type="text" value='<c:out value="${cella.valore}" />' data-row='<c:out value="${row.index}"/>' data-column='<c:out value="${col.index}"/>' >
									</td>
								</c:forEach>
							</tr>
						</c:forEach>	
						 --%>
					</tbody>  
				</table>
			</fieldset>
			
			<div class="clear"></div>	
			<div class="Border_line"></div>
			<p>
				<a href="../gestioneModuliRicercaPerCompilazione/start.do" class="btn btn-secondary">indietro</a>
				<span class="pull-right">				
					<form:hidden path="listaIdDaEliminare" />					                   
					<form:hidden path="goToLastPage"/>
				</span>
			</p>       

			<form:hidden id="numeroColonne" path="modulo.numeroColonne" /> 			
			
			</form:form>
		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="modali.jsp" %>
<%@ include file="modaleInserisci.jsp" %>
<%@ include file="modaleModifica.jsp" %>
<%@ include file="../../../include/javascript.jsp" %>
<script src="../../js/portril/common.js" type="text/javascript"></script>
<script src="../../js/portril/compilaModuliNew.js" type="text/javascript"></script>


</body>
</html>