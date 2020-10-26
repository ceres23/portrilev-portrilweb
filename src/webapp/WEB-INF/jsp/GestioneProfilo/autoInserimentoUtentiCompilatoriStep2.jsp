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
	
 <a title="A-contenuti"></a>
</div>

<form:form id="accessocompilatore/autoInsGestioneUtentiCompilatoriStep2" modelAttribute="utentiCompilatoriStep2Model" method="post" action="cercaEnte.do">

<div class="row-fluid">
	<div class="span12">
		<ul class="breadcrumb">

			<li><a href="../autoInserimentoUtentiCompilatoriStep1/goToStep1.do">Inserimento Dati</a> <span class="divider">></span></li>				
			<li class="active">Inserisci utente compilatore</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			<h3>Inserisci utente compilatore</h3>
			
			<div id="MyWizard" class="wizard">
				<ul class="steps">
					<li data-target="#insUtentiComp1"><span class="badge badge-success">1</span>Inserimento Dati<span class="chevron"></span></li>
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
								<a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#associaEnti" href="#associaEntiTAB">
								 Accreditamento Enti<span class="icon">&nbsp;</span>
								</a>
							  </div>
							  <div id="associaEntiTAB" class="accordion-body collapse <c:out value='${utentiCompilatoriStep2Model.collapse}' />">
								<div class="accordion-inner">              
									<fieldset class="form-horizontal">
										<div class="control-group">
											<label class="control-label" for="ragioneSociale">Ragione Sociale</label>
											<div class="controls">
												<!-- <input id="RagioneSocialeEnte" class="span9" type="text" value="" name="RagioneSocialeEnte"> -->
												<form:input path="ragioneSociale" class="span9" type="text" maxlength="500" />
												
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
												<form:input path="comune" class="span6" type="text"/>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="codiceFiscale">Codice Fiscale</label>
											<div class="controls">
												<!-- <input id="CodiceFiscaleEnte" class="span6" type="text" value="" name="CodiceFiscaleEnte"> -->
												<form:input path="codiceFiscale" class="span6" type="text" maxlength="16" />
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="partitaIva">Partita Iva</label>
											<div class="controls">
												<!-- <input id="PartitaIvaEnte" class="span6" type="text" value="" name="PartitaIvaEnte"> -->
												<form:input path="partitaIva" class="span2" type="text" maxlength="11" />
											</div>
										</div>
									</fieldset>
									<p>
									
									<button type="button" class="btn btn-secondary pull-right" id ="cerca" >cerca</button> 
									<!-- <a class="btn btn-primary pull-right" data-toggle="collapse" data-target="#TableEnti">cerca</a> -->
									</p>
									
									<div class="clear"></div>
									<br>

									<div id="TableEnti" class="collapse <c:out value='${utentiCompilatoriStep2Model.collapse}' /> ">
										<div>
											<fieldset class="form-horizontal" >  
											
												<%@ include file="include/tableRisultatiEnti.jsp" %>
												
												<form:hidden path="idEnteAssociato"  />
											</fieldset>											
										</div>
									</div>
									
									
								</div>
							  </div>
							</div>
						</div>
					
					</fieldset>
				</div>
			</div>
			  
			
			<p class="margin-medium">
				<a href="../autoInserimentoUtentiCompilatoriStep1/goToStep1.do" class="btn btn-secondary">indietro</a>
				<button type="button" class="btn btn-secondary  pull-right" id ="salvaUtenteCompilatore" >salva</button> 				
			</p>       
			  
		</div>
	</div>	 
</div>
	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>

<script src="../../js/portril/autoInserimentoUtentiCompilatori.js" type="text/javascript"></script>

</form:form>
</body>
</html>
