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
			<li class="active">Inserisci Modulo</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<%-- <form:form id="insDefinModuli" commandName="moduliModel" method="post" action="" enctype="multipart/form-data" > --%>
 			<form:form id="insDefinModuli" commandName="moduliModel" method="post" action="">
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
			<h3>Inserimento Modulo</h3>
			<div id="MyWizard" class="wizard">
				<ul class="steps">
					<li data-target="#insUtentiComp1" class="active"><span class="badge">1</span>Dati testata<span class="chevron"></span></li>
					<li data-target="#insUtentiComp2"><span class="badge">2</span>Colonne<span class="chevron"></span></li>
				</ul>
			</div>
			
			<div class="step-content">
				<div class="step-pane active" id="step1">
				<h4 class="step-pane">Dati</h4>
					<fieldset class="form-horizontal">						
						<div class="control-group">
							<label class="control-label" for="nome">Titolo*</label>
							<div class="controls">
								<!-- input id="titoloModulo" class="span9" type="text" value="" name="titoloModulo" /-->
								<form:input  path="nome" class="span6" type="text" maxlength="50" />									
								<form:errors path="nome" class="msgErrorRequired" />									
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="codiceGruppo">Codice Gruppo</label>
							<div class="controls">
								<form:input  path="codiceGruppo" class="span6" type="text" maxlength="50" />									
								<form:errors path="codiceGruppo" class="msgErrorRequired" />	
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="descrizione">Descrizione*</label>
							<div class="controls">
								<form:textarea path="descrizione" rows="1" cols="15" class="span8"  type="text" maxlength="250"  />									
								<form:errors path="descrizione" class="msgErrorRequired" />	
							</div>
						</div>
						
						<div class="control-group">
							<span class="control-label">Tipo Modulo*</span>
							<div class="controls">
								<form:radiobutton class="radio inline" path="tipo" value="RILEVAZIONE" />RILEVAZIONE	
								<form:radiobutton class="radio inline" path="tipo" value="COMUNICAZIONE" />COMUNICAZIONE 								 
							</div>
						</div>

						<div id="TipoRilevazione">					
							<div class="control-group">
								<span class="control-label">Modulo soggetto a conferma</span>
								<div class="controls">
									<form:radiobutton class="radio inline" path="obbligConferma" value="NO" />NO	
									<form:radiobutton class="radio inline" path="obbligConferma" value="SI" />SI 								 
								</div>
							</div>
							
							<div class="control-group">
								<span class="control-label">Modulo caricabile con csv</span>
								<div class="controls">
									<form:radiobutton class="radio inline" path="caricamentoDaFile" value="NO" />NO	
									<form:radiobutton class="radio inline" path="caricamentoDaFile" value="SI" />SI 								 
								</div>
							</div>
						
							<div class="control-group">							
								<label class="control-label" for="dataInizioCompilazione">Data Inizio Compilazione</label>
								<div class="controls">
										<!--<form:input path="dataInizioCompilazione" class="span2 datepicker" type="text" />-->											
										<form:input path="rangeCompilazione.dataInizio" class="span2 datepicker" type="text" />							
										<form:errors path="rangeCompilazione" class="msgErrorRequired" />		
								</div>
							</div>
	 					
							<div class="control-group">							
								<label class="control-label" for="dataFineCompilazione">Data Fine Compilazione</label>
								<div class="controls">
										<!--<form:input path="dataFineCompilazione" class="span2 datepicker" type="text" />	-->									
										<form:input path="rangeCompilazione.dataFine" class="span2 datepicker" type="text" />								
										<form:errors path="rangeCompilazione" class="msgErrorRequired" />																							
								</div>
							</div>
						</div>
						<%--
						<div class="control-group">
							<label class="control-label" for="fileAllegato">File Allegato</label>
							<div class="controls"> 							
								<form:input path="file" type="file" id="file" /> 
							</div>
						</div>
						--%>
						<div class="control-group">
							<label class="control-label" for="note">Note</label>
							<div class="controls">
								<form:textarea path="note" rows="2" cols="15" class="span9" type="text" maxlength="4000" />									
								<form:errors path="note" class="msgErrorRequired" />
							</div>
						</div>
						
						<div class="accordion" id="istruzioniCompilatore">
							<div class="accordion-group">
							  <div class="accordion-heading">    
								<a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#istruzioniCompilatore" href="#istruzioniCompilatoreTAB">
								 Istruzioni compilazione<span class="icon">&nbsp;</span>
								</a>
							  </div>
							  <div id="istruzioniCompilatoreTAB" class="accordion-body collapse">
								<div class="accordion-inner">              
									<br>
									<div class="control-group">
										<!-- textarea id="IstruzioniModulo" rows="8" cols="15" class="span12" type="text" value="" name="IstruzioniModulo">Istruzioni......</textarea -->
										<form:textarea path="istruzioniCompilazione" rows="8" cols="15" class="span10" type="text" maxlength="4000" />									
										<form:errors path="istruzioniCompilazione" class="msgErrorRequired" />
									</div>
								
								</div>
							  </div>
							</div>
						</div>
					</fieldset>				  
				</div>
			</div>			
			<p class="margin-medium">
				<a href="../menuGestore/start.do" class="btn btn-secondary">indietro</a>
				<button type="button" class="btn btn-secondary" id ="clean" >pulisci</button> 
				<span class="pull-right">
					  <button type="button" id="salvaProsegui" name="salvaProsegui" class="btn btn-primary pull-right" >salva e prosegui</button>
				</span>
			</p>       			  
			</form:form>
		</div>
	</div>	 
</div>	
<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>
<script src="../../js/portril/insDefinModuli.js" type="text/javascript"></script>
</body>
</html>
