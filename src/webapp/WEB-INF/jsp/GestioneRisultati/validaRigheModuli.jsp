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
			<li class="active">Valida Righe moduli</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">  
		  
			<form:form id="gestore/validaRigheModuli" commandName="validaRigheModuliModel" method="post" action="">
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
			<h3>Valida moduli</h3>
			<p>&Egrave; necessario inserire almeno un criterio di ricerca.</p>
			<div class="step-content">
				<div class="step-pane active" id="step1">
					<h4>Dati</h4>
					<fieldset class="form-horizontal">
						<br>
						<div class="control-group">
							<span class="control-label">Stato</span>
								
							<div class="controls">				
								<form:radiobutton class="radio inline" path="statoRiga" value="DAVALIDARE" />da validare  
								<form:radiobutton class="radio inline" path="statoRiga" value="VALIDATI" />validati
							    <form:radiobutton class="radio inline" path="statoRiga" value="TUTTI" />Tutti
							</div>
						</div>
						
						<br>
						
						<div class="control-group">
							<label class="control-label">Ragione Sociale</label>
							<div class="controls">
									<form:hidden path="idEnteGestore" />	
									<form:hidden path="idModuloSel"  />								
									<form:input  path="ragioneSociale" class="span6" type="text" maxlength="250"  />									
									<form:errors path="ragioneSociale" class="msgErrorRequired" />	
							</div>
						</div>
						
						<%--
						<div class="control-group">
							<label class="control-label" >Classificazione</label>
							<div class="controls">
									<form:input  path="classificazione" class="span6" type="text" maxlength="50" />									
									<form:errors path="classificazione" class="msgErrorRequired" type="text"/>
							</div>
						</div>
						 --%>
						<div class="control-group">
							<label class="control-label" >Comune</label>
							<div class="controls">
									<form:input  path="comune" class="span6" type="text" maxlength="50" />									
									<form:errors path="comune" class="msgErrorRequired" type="text"/>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" >Provincia</label>
							<div class="controls">
									<form:input path="provincia" class="span1" type="text" maxlength="2" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label">Codice Fiscale</label>
							<div class="controls">
									<form:input  path="codiceFiscale" class="span6" type="text" maxlength="16" />
									<form:errors path="codiceFiscale" class="msgErrorRequired" type="text" />							
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label">Partita Iva</label>
							<div class="controls">
									<form:input  path="partitaIva" class="span2" type="text" maxlength="11" />
									<form:errors path="partitaIva" class="msgErrorRequired" type="text" />
							</div>
						</div>
						
						<h4>Provvedimento</h4>
						<%--
							<div class="control-group">
								<label class="control-label" >Anno</label>
								<div class="controls">   
										<form:input  path="anno" class="span1" type="text" />
									<span class="al">
										<label class="radio inline">Numero</label>
									</span>
										<form:input  path="numero" class="span2" type="text" />
										
								</div>
							</div>
							--%>
							<div class="control-group">
								<label class="control-label">Codice Provvedimento </label>
								<div class="controls">   
									<form:input  path="provvedimento" class="span2" type="text" />(anno-numero-struttura)
								</div>
							</div>
					</fieldset>
					<br>
					<br>
				</div>
			</div>
			
			<p class="margin-medium">
				<a href="../ricercaRisultati/start.do" class="btn btn-secondary">indietro</a>
				<button type="button" class="btn btn-secondary" id ="clean" >pulisci</button> 
				<button type="button" class="btn btn-primary pull-right" id ="ricerca" >cerca</button> 
				<%-- 
				<c:if test="${ not empty validaRigheModuliModel.listaRigheModulo}"> 
					<button type="button" class="btn btn-secondary" id ="clean" >pulisci</button> 
					<button type="button" class="btn btn-primary pull-right" id ="ricerca" >cerca</button> 
				</c:if>  
				--%>
			</p>       
			
			<div class="clear"></div>
			<br>
			<div id="TableigheDaValidare" >
				<div>
					<fieldset class="form-horizontal" >  
						<%@ include file="risultatiValidaRigheModuli.jsp" %>
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
<script src="../../js/portril/validaRigheModuli.js" type="text/javascript"></script>

</body>
</html>
