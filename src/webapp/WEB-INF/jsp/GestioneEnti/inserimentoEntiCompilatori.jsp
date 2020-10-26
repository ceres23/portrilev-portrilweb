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

<form:form id="gestore/inserimentoEntiCompilatori" commandName="entiCompilatoriModel" method="post" action="inserisci.do">

<div class="row-fluid">
	<div class="span12">
		<ul class="breadcrumb">
			<li><a href="../menuGestore/start.do">Home</a> <span class="divider"></span></li>			
			<li class="active">Inserisci Ente Compilatore</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
			<h3>Inserisci Ente Compilatore</h3>
			<div class="step-content">
				<div class="step-pane active" id="step1">
					<h4 class="step-pane">Dati</h4>
					<fieldset class="form-horizontal">
	
						<div class="control-group">
							<label class="control-label" for="ragioneSociale">Ragione Sociale*</label>
							<div class="controls">
									<!-- <input id="RagioneSocialeEnte" class="span9" type="text" value="" name="RagioneSocialeEnte" /> -->
									<form:input path="ragioneSociale" class="span6" type="text" maxlength="500" />									
									<form:errors path="ragioneSociale" class="msgErrorRequired" />	
							</div>
						</div>
						<%--
						<div class="control-group">
							<label class="control-label" for="classificazione">Classificazione</label>
							<div class="controls">
									<!-- <input id="LocalitaEnte" class="span6" type="text" value="" name="LocalitaEnte" /> -->
									<input id="stato" name="stato" value="ATTIVO" type="hidden" />
									<form:input path="classificazione" class="span6" maxlength="50" type="text" />
							</div>
						</div>
						 --%>
						<div class="control-group">
							<label class="control-label" for="provincia">Provincia</label>
							<div class="controls">
							
									<!-- <input id="ProvinciaEnte" class="span6" type="text" value="" name="ProvinciaEnte" /> -->
									<form:input path="provincia" maxlength="2"  class="span1" type="text" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="comune">Comune*</label>
							<div class="controls">
									<form:input  path="comune" maxlength="50" class="span6" type="text" />									
									<form:errors path="comune" class="msgErrorRequired" type="text"/>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="codiceFiscale">Codice Fiscale*</label>
							<div class="controls">
									<!-- <input id="CodiceFiscaleEnte" class="span6" type="text" value="" name="CodiceFiscaleEnte" /> -->
									<form:input  path="codiceFiscale" maxlength="16" class="span6" type="text" />
									<form:errors path="codiceFiscale" class="msgErrorRequired" type="text" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="partitaIva">Partita Iva*</label>
							<div class="controls">
									<!-- input id="PartitaIvaEnte" class="span6" type="text" value="" name="PartitaIvaEnte" /-->
									<form:input  path="partitaIva" maxlength="11"  class="span2" type="text" />
									<form:errors path="partitaIva" class="msgErrorRequired" type="text" />
									
							</div>
						</div>
						<%--
						<div class="control-group">
							<label class="control-label" for="istat">Istat</label>
							<div class="controls">
									<!-- <input id="ProvinciaEnte" class="span6" type="text" value="" name="ProvinciaEnte" /> -->
									<form:input path="istat" maxlength="15"  class="span1" type="text" />
							</div>
						</div>
						--%>						
						<div class="control-group">
							<label class="control-label" for="mail">Mail*</label>
							<div class="controls">
									<!-- <input id="MailEnte" class="span4" type="text" value="" name="MailEnte" /> -->
									<form:input  path="mail" maxlength="150" class="span6" type="text" />
									<form:errors path="mail" class="msgErrorRequired" type="text" />								
							</div>
						</div>
					
					</fieldset>
				</div>
			</div>
			
			<p class="margin-medium">
				<a href="../menuGestore/start.do" class="btn btn-secondary">indietro</a>
				<!-- <a class="btn btn-secondary" href="javascript:history.go(-1)">indietro</a>-->
				<input id="stato" name="stato" value="ATTIVO" type="hidden" />
				<button type="button" class="btn btn-secondary" id ="clean" >pulisci</button> 
				<button type="submit" class="btn btn-primary pull-right" >salva</button> 
			</p>       
			  

		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>

</form:form>
</body>
</html>

