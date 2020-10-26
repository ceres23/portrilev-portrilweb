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
			 <!-- <li><a href="../index.shtml">Home</a> <span class="divider">></span></li> -->
			<li><a href="../menuGestore/start.do">Home</a> <span class="divider"></span></li>			
			<li class="active">Modifica utente compilatore</li>
		</ul> 
	</div>	
</div>

<form:form id="gestore/modificaUtentiCompilatoriStep1" modelAttribute="utentiCompilatoriModel" method="post" action="modifica.do">
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    

			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>

			<h3>Modifica utente compilatore</h3>
			
			<div id="MyWizard" class="wizard">
				<ul class="steps">
					<li data-target="#insUtentiComp1" class="active"><span class="badge">1</span>Modifica Dati<span class="chevron"></span></li>
					<li data-target="#insUtentiComp2"><span class="badge">2</span>Associa Ente<span class="chevron"></span></li>
				</ul>
			</div>

			<div class="step-content">
				<div class="step-pane active" id="step1">
					<h4>Dati utente</h4>
					<fieldset class="form-horizontal">
						<!-- 
						<div class="control-group">
							<label class="control-label" for="LoginUtente">Login</label>
							<div class="controls">
									<input id="LoginUtente" class="span6" type="text" value="" name="LoginUtente" disabled="disabled" />
							</div>
						</div>
						 -->
						<div class="control-group">
							<label class="control-label" for="nome">Nome*</label>
							<div class="controls">
									<c:out value="${utentiCompilatoriModel.nome}" />
									<form:hidden path="nome"  />
									<form:hidden path="login" />
									<form:hidden path="password" />
									<form:errors path="nome" class="msgErrorRequired" type="text" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="cognome">Cognome*</label>
							<div class="controls">
									<c:out value="${utentiCompilatoriModel.cognome}" />
									<form:hidden path="cognome"/>
									<form:errors path="cognome" class="msgErrorRequired" type="text" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="codiceFiscale">Codice Fiscale*</label>
							<div class="controls">
									<c:out value="${utentiCompilatoriModel.codiceFiscale}" />
									<form:hidden path="codiceFiscale" />
									<form:errors path="codiceFiscale" class="msgErrorRequired" type="text" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="mail">Mail*</label>
							<div class="controls">
									<!-- <input id="MailUtente" class="span4" type="text" value="" name="MailUtente" />-->
									<form:input path="mail"  class="span6" type="text" maxlength="150" />
									<form:errors path="mail" class="msgErrorRequired" type="text" />
							</div>
						</div>
						<%-- 
						<div class="control-group">
							<label class="control-label" for="ripMailUtente">Ripeti Mail*</label>
							<div class="controls">
									<form:input path="mail2"  class="span6" type="text" />
									<form:errors path="mail2" class="msgErrorRequired" type="text" />
									<!-- <input id="ripMailUtente" class="span4" type="text" value="" name="ripMailUtente" />-->
							</div>
						</div>
						 --%>
						<div class="control-group">
							<label class="control-label" for="telefono">Telefono*</label>
							<div class="controls">
									<!-- <input id="TelefonoUtente" class="span3" type="text" value="" name="TelefonoUtente" /> -->
									<form:input path="telefono"  class="span6" type="text" maxlength="50" />
									<form:errors path="telefono" class="msgErrorRequired" type="text" />
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<form:hidden path="stato"  />
								<form:hidden path="idProfiloUtente"  />
								<form:hidden path="idUtenteCompilatore"  />
								
							</div>
						</div>
					</fieldset>
				</div>
			</div>
			  
			<p class="margin-medium">
				<a href="../ricercaUtentiCompilatori/start.do" class="btn btn-secondary">indietro</a>
				<!-- <a class="btn btn-secondary" href="javascript:history.go(-1)">indietro</a>-->
				<button type="button" class="btn btn-secondary" id ="clean" >pulisci</button> 
				<button type="submit" class="btn btn-primary pull-right" >prosegui</button> 
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
