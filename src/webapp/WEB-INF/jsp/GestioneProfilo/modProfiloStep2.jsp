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
			<li><a href="../modificaProfiloUtenteCompilatoreStep1/start.do">Modifica Dati</a> <span class="divider">></span></li>		
			<li class="active">Associa Ente</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<form:form id="compilatore/modificaProfiloUtenteCompilatoreStep2" modelAttribute="utentiCompilatoriStep2Model" method="post" action="ricerca.do">
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>

			
			<h3>Modifica profilo</h3>
			
			<div id="MyWizard" class="wizard">
				<ul class="steps">
					<li data-target="#insUtentiComp1"><span class="badge badge-success">1</span>Modifica Dati<span class="chevron"></span></li>
					<li data-target="#insUtentiComp2" class="active"><span class="badge">2</span>Associa Ente<span class="chevron"></span></li>
				</ul>
			</div>

			<div class="step-content">
				<div class="step-pane active" id="step1">
					<h4>Enti Accreditati</h4>
					<fieldset class="form-horizontal">
					
						<%@ include file="include/tableEntiAssociati.jsp" %>
						<form:hidden path="idEnteDisAssociato"  />
						
						
						
						
						<div class="accordion" id="associaEnti">
							<div class="accordion-group">
							  <div class="accordion-heading">    
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#associaEnti" href="#associaEntiTAB">
								 Accreditamento Enti<span class="icon">&nbsp;</span>
								</a>
							  </div>
							  <div id="associaEntiTAB" class="accordion-body collapse in">
								<div class="accordion-inner">              
									<fieldset class="form-horizontal">
										<div class="control-group">
											<label class="control-label" for="RagioneSocialeEnte">Ragione Sociale</label>
											<div class="controls">
												<form:input path="ragioneSociale" class="span9" type="text" maxlength="500" />
												<form:hidden path="idUtenteCompilatore" />
												<form:hidden path="idProfiloUtente" />

											</div>
										</div>
										<%--
										<div class="control-group">
											<label class="control-label" for="comune">Classificazione</label>
											<div class="controls">
												<form:input path="classificazione" class="span6" type="text"/>
											</div>
										</div>
										 --%>
										<div class="control-group">
											<label class="control-label" for="comune">Comune</label>
											<div class="controls">
												<!-- <input id="ComuneEnte" class="span6" type="text" value="" name="ComuneEnte"> -->
												<form:input path="comune" class="span6" type="text" maxlength="50" />

											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="codiceFiscale">Codice Fiscale</label>
											<div class="controls">
												<form:input path="codiceFiscale" class="span6" type="text" maxlength="16" />
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="partitaIva">Partita Iva</label>
											<div class="controls">
												<form:input path="partitaIva" class="span2" type="text" maxlength="11"/>
											</div>
										</div>
									</fieldset>
									<p><button type="button" class="btn btn-primary pull-right" id ="ricerca" >cerca</button></p>
									
									
									<div class="clear"></div>
									<br>
									
									<div>
										<fieldset class="form-horizontal" > 									
											<%@ include file="include/tableRisultatiEnti.jsp" %>
										</fieldset>											
									</div>
									
									
								</div>
							  </div>
							</div>
						</div>
					
					</fieldset>
				</div>
			</div>

			<p class="margin-medium">
				<form:hidden path="idEnteAssociato"  />
				<a href="../modificaProfiloUtenteCompilatoreStep1/start.do" class="btn btn-secondary">indietro</a>
				<button type="button" class="btn btn-secondary  pull-right" id ="salvaUtenteCompilatore" >salva</button>
			</p>       
			  
			</form:form>
		</div>
	</div>	 
</div>

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>

<script src="../../js/portril/modProfiloStep2.js" type="text/javascript"></script>
</body>
</html>
