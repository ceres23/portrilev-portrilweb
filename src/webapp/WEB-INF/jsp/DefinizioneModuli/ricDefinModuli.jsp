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
			<li class="active">Ricerca Modulo</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<form:form id="ricercaModuli" commandName="ricercaModuliModel" method="post" action="ricerca.do">
 			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
			<h3>Ricerca Modulo</h3>
			<p>&Egrave; necessario inserire almeno un criterio di ricerca</p>
			<div class="step-content">
				<div class="step-pane active" id="step1">
						<h4>Dati</h4>
						<fieldset class="form-horizontal">
							<br>
							
							<div id="TipoRilevazione">
								<div class="control-group">
									<span class="control-label">Stato e valori</span>
									<div class="controls">
										<form:radiobutton class="radio inline" path="stato" value="ALL" />Tutti 	
										<form:radiobutton class="radio inline" path="stato" value="IN_DEFINIZIONE" />in Definizione  		
										<form:radiobutton class="radio inline" path="stato" value="IN_COMPILAZIONE" />In Compilazione 	
										<form:radiobutton class="radio inline" path="stato" value="CHIUSO" />Chiusi 								 
									</div>
								</div>
							</div>
							
							<br>
							
							<div class="control-group">
								<label class="control-label" for="nome">Titolo</label>
								<div class="controls">   
									<form:input path="nome" class="span6" maxlength="50" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="nome">Codice Gruppo</label>
								<div class="controls">   
									<form:input path="codiceGruppo" class="span6" maxlength="50" />
								</div>
							</div>
							<br>
							<div class="control-group">
								<span class="control-label">Tipo Modulo*</span>
								<div class="controls">
									<form:radiobutton class="radio inline" path="tipo" value="RILEVAZIONE" />RILEVAZIONE	
									<form:radiobutton class="radio inline" path="tipo" value="COMUNICAZIONE" />COMUNICAZIONE 								 
								</div>
							</div>
							
						</fieldset>
						<br>
						<br>
				</div>
			</div>
			  
			<p class="margin-medium">
				<a href="../menuGestore/start.do" class="btn btn-secondary">indietro</a>
				<button type="button" class="btn btn-secondary" id ="clean" >pulisci</button> 
				<button type="button" id="cerca" name="cerca" class="btn btn-primary pull-right" >cerca</button> 
			</p>       
			<div class="clear"></div>
			<br>
			<div id="TablerisultatiModuli" >
				<div>
					<fieldset class="form-horizontal" >  
						<%@ include file="risultatiModuli.jsp" %>
					</fieldset>											
				</div>
			</div>
			<%@ include file="./include/modalInvia.jsp" %>
			<form:hidden path="aperturaModale"/>
			</form:form>
		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>

<script src="../../js/portril/ricercaModuli.js" type="text/javascript"></script>
</body>
</html>
