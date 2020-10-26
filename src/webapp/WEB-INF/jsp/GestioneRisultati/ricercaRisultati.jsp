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
	
 <a title="A-contenuti"></a>
</div>


<div class="row-fluid">
	<div class="span12">
		<ul class="breadcrumb">
			<li><a href="../menuGestore/start.do">Home</a> <span class="divider"></span></li>	
			<li class="active">Gestione Risultati</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<form:form id="gestore/ricercaRisultati" commandName="gestioneRisultatiModel" method="post" action="ricerca.do">
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			<h3>Gestione Risultati</h3>
			<p>&Egrave; necessario inserire almeno un criterio di ricerca.</p>
			<div class="step-content">
				<div class="step-pane active" id="step1">
					<h4>Dati</h4>
					<fieldset class="form-horizontal">
						<br>
						<div class="control-group">
							<span class="control-label">Stato e valori</span>
							
							
							<div class="controls">
								<label class="radio inline">
									<input type="radio" name="stato" value="ALL" id="optionsStatoValori4" <c:out value="${gestioneRisultatiModel.ckAll}" /> >
									Tutti 
								</label>
								<label class="radio inline">
									<input type="radio" name="stato" value="IN_COMPILAZIONE" id="optionsStatoValori2" <c:out value="${gestioneRisultatiModel.ckCom}" /> >
									In Compilazione
								</label>
								<label class="radio inline">
									<input type="radio" name="stato" value="CHIUSO" id="optionsStatoValori3" <c:out value="${gestioneRisultatiModel.ckCh}" /> >
									Chiusi 
								</label>
							</div>
						</div>
						
						<br>
						
						<div class="control-group">
							<label class="control-label" for="TitoloModulo">Titolo</label>
							<div class="controls">   
								<form:input path="nome" class="span6" maxlength="50" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="codiceGruppo">Codice Gruppo</label>
							<div class="controls">   
								<form:input path="codiceGruppo" class="span6" maxlength="50" />
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
				<form:hidden path="listaIdXCsv" />						
				<if test ="${not empty gestioneRisultatiModel.listaModuli}"> 	                   
					<button type="button" class="btn btn-secondary" name="esportaCsv" id ="esportaCsv" >scarica dati csv</button> 
				</if>
				<button type="button" name="cerca" id ="cerca" class="btn btn-primary pull-right" >cerca</button> 

			</p>       
			  
			<div class="clear"></div>
			<br>
			<div id="TableRisultati">
				<div>
					<fieldset class="form-horizontal" >  
						<%@ include file="risultatiRicercaRisultati.jsp" %>
					</fieldset>											
				</div>
			</div>
			
				<form:hidden path="aperturaModale"/>	
				<form:hidden path="idModuloSel"  />
				<%@ include file="./include/modalInviaSollecito.jsp" %>
			
			</form:form>
		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>
<script src="../../js/portril/risultatiModuli.js" type="text/javascript"></script>

</body>
</html>
