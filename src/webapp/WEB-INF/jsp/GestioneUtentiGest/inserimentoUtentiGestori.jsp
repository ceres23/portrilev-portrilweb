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
 <a  title="A-contenuti"></a>
</div>


<div class="row-fluid">
	<div class="span12">
		<ul class="breadcrumb">
			<li><a href="../menuGestore/start.do">Home</a> <span class="divider"></span></li>			
			<li class="active">Inserisci utente gestore</li>
		</ul> 
	</div>	
</div>


<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
		
			<form:form id="gestore/inserimentoUtentiGestori" commandName="utentiGestoriModel" method="post" action="inserisci.do">
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			<h3>Inserisci utente gestore</h3>
			
			<div class="step-content">
				<div class="step-pane active" id="step1">
					<h4>Dati utente</h4>
					<fieldset class="form-horizontal">

						<div class="control-group">
							<label class="control-label" for="nome">Nome*</label>
							<div class="controls">
									<!-- <input id="NomeUtente" class="span6" type="text" value="" name="NomeUtente" />-->
									<form:input path="nome" class="span6" type="text" maxlength="50" />									
									<form:errors path="nome" class="msgErrorRequired" />									
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="cognome">Cognome*</label>
							<div class="controls">
									<!-- <input id="CognomeUtente" class="span6" type="text" value="" name="CognomeUtente" />-->
									<form:input path="cognome" class="span6" type="text" maxlength="50" />									
									<form:errors path="cognome" class="msgErrorRequired" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="codiceFiscale">Codice Fiscale*</label>
							<div class="controls">
									<!-- <input id="CodiceFiscaleUtente" class="span6" type="text" value="" name="CodiceFiscaleUtente" /> -->
									<form:input path="codiceFiscale" class="span6" type="text" maxlength="16" />									
									<form:errors path="codiceFiscale" class="msgErrorRequired" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="mail">Mail*</label>
							<div class="controls">
									<!-- <input id="MailUtente" class="span4" type="text" value="" name="MailUtente" /> -->
									<form:input path="mail" class="span6" type="text" maxlength="150" />									
									<form:errors path="mail" class="msgErrorRequired" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="telefono">Telefono*</label>
							<div class="controls">
									<!-- <input id="TelefonoUtente" class="span3" type="text" value="" name="TelefonoUtente" /> -->
									<form:input path="telefono" class="span6" type="text" maxlength="50" />
									<form:hidden path="stato" />
									<form:errors path="telefono" class="msgErrorRequired" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="profiloUtente">Profilo</label>
							<div class="controls">
							<form:select path="idProfiloUtente" >
								<option value="1">super-amministratore</option>
								<option value="2" selected="selected" >amministratore</option>
								<option value="3">validatore</option>		
								<!--<form:options  items="${LISTA_PROFILI_UTENTI_GESTIONE}"  itemValue="idProfiloUtente" itemLabel="descrizione"  />-->
							</form:select>
			
							</div>
						</div>
						
					</fieldset>
				</div>
			</div>


			  
			<p class="margin-medium">
				<a href="../menuGestore/start.do" class="btn btn-secondary">indietro</a>
				<!-- <a class="btn btn-secondary" href="javascript:history.go(-1)">indietro</a>-->
				<button type="button" class="btn btn-secondary" id ="clean" >pulisci</button> 
				<button type="submit" class="btn btn-primary pull-right" >salva</button> 
			</p>
			</form:form>
		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>

</body>
</html>
