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
			<li class="active">Ricerca Ente Compilatore</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<form:form id="gestore/ricercaEntiCompilatori" commandName="ricercaEntiCompilatoriModel" method="post" action="">

			<!--#include virtual="../../ris/include/alertErrorSuccess.html" -->
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
			<h3>Ricerca Ente Compilatore</h3>
			<p>&Egrave; necessario inserire almeno un criterio di ricerca.</p>
			<div class="step-content">
				<div class="step-pane active" id="step1">
					<fieldset class="form-horizontal"> 
					<h4>Dati</h4>
						<div class="control-group">
							<label class="control-label" for="ragioneSociale">Ragione Sociale</label>
							<div class="controls">
								<form:input path="ragioneSociale" maxlength="500"  class="span9" type="text" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="comune">Comune</label>
							<div class="controls">
								<form:input  path="comune" maxlength="50" class="span6" type="text" />	
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="provincia">Provincia</label>
							<div class="controls">
								<form:input path="provincia" maxlength="2" class="span1" type="text" />
							</div>
						</div>
						
						<%--
						<div class="control-group">
							<label class="control-label" for="istat">Istat</label>
							<div class="controls">
								<form:input path="istat" maxlength="15" class="span1" type="text" />
							</div>
						</div>
						--%>
						<div class="control-group">
							<label class="control-label" for="codiceFiscale">Codice Fiscale</label>
							<div class="controls">
								<form:input  path="codiceFiscale" maxlength="16" class="span6" type="text" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="partitaIva">Partita Iva</label>
							<div class="controls">
								<form:input  path="partitaIva" maxlength="11" class="span2" type="text" />
							</div>
						</div>
						
					</fieldset> 
				</div>
			</div>
			  
			<!--#include virtual="include/modal.html" -->  
			<p class="margin-medium">
				<a href="../menuGestore/start.do" class="btn btn-secondary">indietro</a>
				<button type="button" class="btn btn-secondary" id ="clean" >pulisci</button> 
				<button type="button" id="cerca" name="cerca" class="btn btn-primary pull-right" >cerca</button> 
			</p>  
			
			<div class="clear"></div>
			<br>
			<div id="TableEntiCompilatori" >
				<div>
					<fieldset class="form-horizontal" >  
						<%@ include file="risultatiEntiCompilatori.jsp" %>
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
<script src="../../js/portril/ricercaEnti.js" type="text/javascript"></script>

</body>
</html>
