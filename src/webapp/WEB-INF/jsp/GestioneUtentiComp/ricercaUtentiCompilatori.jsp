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
			<li class="active">Ricerca utente compilatore</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<form:form id="gestore/ricercaUtentiCompilatori" modelAttribute="ricercaUtentiCompilatoriModel" method="post" action="">

			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
			<h3>Ricerca utente compilatore</h3>
			<p>&Egrave; necessario inserire almeno un criterio di ricerca.</p>
			<div class="step-content">
				<div class="step-pane active" id="step1">
						<fieldset class="form-horizontal"> 
					<h4>Dati</h4>
						<div class="control-group">
							<label class="control-label">Nome</label>
							<div class="controls">

								<form:input path="nome" class="span6" type="text" maxlength="50" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" >Cognome</label>
							<div class="controls">
								<form:input path="cognome" class="span6" type="text" maxlength="50" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" >Codice Fiscale</label>
							<div class="controls">
								<form:input path="codiceFiscale" class="span6" type="text" maxlength="16" />
							</div>
						</div>
	
					</fieldset> 
				
				</div>
			</div>

			<p class="margin-medium">
				<a href="../menuGestore/start.do" class="btn btn-secondary">indietro</a>
				<button type="button" class="btn btn-secondary" id ="clean" >pulisci</button> 
				<button type="button" id="ricerca" name="ricerca" class="btn btn-primary pull-right" >cerca</button> 
			</p>       
			  
			<div class="clear"></div>
			<br>
			<div id="TableUtenti" >
				<div>
					<fieldset class="form-horizontal" >  
						<%@ include file="risultatiUtentiCompilatori.jsp" %>
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
<script src="../../js/portril/ricercaUtentiCompilatori.js" type="text/javascript"></script>
</body>
</html>