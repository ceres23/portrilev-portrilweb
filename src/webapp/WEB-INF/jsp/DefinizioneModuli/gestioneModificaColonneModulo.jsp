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
			<li><a href="../menuGestore/start.do">Home</a> <span class="divider">></span></li>		
			<li><a href="../modificaModuli/start.do	">Modifica Modulo</a> <span class="divider">></span></li>		
			
			<li class="active">Gestione Colonne Modulo</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    
			<form:form id="gestioneModificaColonneModulo" commandName="gestioneColonneModuloModel" method="post" action="">

			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
			<c:if test='${not gestioneColonneModuloModel.strutturaModificabile}' >
				<div class="alert alert-warning">
					<button type="button" class="close" data-dismiss="alert">&times;</button>	
					<strong>Attenzione!!</strong><br>
					<ul>
		    			<li>le colonne di questo modulo non sono modificabili modulo attualmente utilizzato almeno da un compilatore</li>
					</ul>
				</div>
			</c:if>
			<h3>Gestione Colonne Modulo</h3>
			<div id="MyWizard" class="wizard">
				<ul class="steps">
					<li data-target="#insUtentiComp1"><span class="badge badge-success">1</span>Dati testata<span class="chevron"></span></li>
					<li data-target="#insUtentiComp2" class="active"><span class="badge">2</span>Colonne<span class="chevron"></span></li>
				</ul>
			</div>
			<div class="step-content">
				<div class="step-pane active" id="step1">
				
					<h4 class="step-pane">Colonne</h4>
					<fieldset class="form-horizontal">   						
						<%@ include file="tabellaListaColonne.jsp" %>
					    <p/>
						<div class="clear"></div>
							
						<c:if test='${gestioneColonneModuloModel.strutturaModificabile}' >				
						<div class="accordion" id="accordionInserimentoColonna">
							<div class="accordion-group">
								<div class="accordion-heading">
									<a class="accordion-toggle" href="#insColMod" data-parent="#accordionInserimentoColonna" data-toggle="collapse">
										&nbsp;<span class="icon"></span>
									</a>
								</div>
								<div id="insColMod" class="collapse in">
									<div class="accordion-inner">
										<div class="accordion_info"> 
											<div class="step-pane active" id="step1"> 
			
											<fieldset class="form-horizontal">        
												<h4 class="step-pane">Titolo: <c:out value="${gestioneColonneModuloModel.modulo.nome}" /> </h4>									
																							
													<div class="control-group">
														<label class="control-label" >Etichetta Colonna *</label>
														<div class="controls">
															<!-- <input id="labelColonna" name="labelColonna" class="span9" type="text" value="" /> -->
															<form:input path="labelColonna" class="span7" type="text" maxlength="500" />									
											                <form:errors path="labelColonna" class="msgErrorRequired" />								                
														</div>
													</div>
													
													<div class="control-group">
														<label class="control-label" >Posizione *</label>
														<div class="controls">
															<c:set var="posizione" scope="request" value="${gestioneColonneModuloModel.posizioneProposta}"/>			
															<form:input path="posizione" class="span1" type="text" value="${posizione}" maxlength="2" />									
											                <form:errors path="posizione" class="msgErrorRequired" />
														</div>
													</div>
													
													<div class="control-group">
														<span class="control-label">Obbligatorio</span>
														<div class="controls">
										 					 <form:radiobutton class="radio inline" path="flagObbligatorieta" value="SI" />si 
															 <form:radiobutton class="radio inline" path="flagObbligatorieta" value="NO" />no
														</div>
													</div>													
													<%--
													<c:if test="${gestioneColonneModuloModel.modulo.tipo eq 'RILEVAZIONE'}">
													<div class="control-group">
														<span class="control-label">Profilo</span>
														<div class="controls">							
															<form:radiobutton class="radio inline" path="editabilitaProfilo" value="COMPILATORE" />compilatore 
															<form:radiobutton class="radio inline" path="editabilitaProfilo" value="VALIDATORE" />validatore
														</div>
													</div>
													</c:if>																									
													<c:if test="${gestioneColonneModuloModel.modulo.tipo=='COMUNICAZIONE'} ">
														<form:input path="editabilitaProfilo" value="COMPILATORE" />									
													</c:if>
													--%>
													<form:hidden path="editabilitaProfilo" value="COMPILATORE" />													
													<div class="control-group">
														<label class="control-label">tipo</label>
														<div class="controls">													
															<c:if test='tipoValore == "Alfanumerico"'>selected</c:if>													
															<select id="tipoValore" name="tipoValore" class="span6" >
																<%--<option value="">Scegli il tipo</option> --%>
																<option value="Alfanumerico" <c:if test='${gestioneColonneModuloModel.selected == "Alfanumerico"}'>selected</c:if> >Alfanumerico</option>
																<option value="Numerico"     <c:if test='${gestioneColonneModuloModel.selected == "Numerico"}'>selected</c:if> >Numerico</option>
																<option value="Data"         <c:if test='${gestioneColonneModuloModel.selected == "Data"}'>selected</c:if> >Data</option>
																<option value="ValoreFisso"  <c:if test='${gestioneColonneModuloModel.selected == "ValoreFisso"}'>selected</c:if> >ValoreFisso</option>																
																<%--
																<option value="Delibera"     <c:if test='${gestioneColonneModuloModel.selected == "Delibera"}'>selected</c:if> >Delibera</option>
																<option value="Determina"    <c:if test='${gestioneColonneModuloModel.selected == "Determina"}'>selected</c:if> >Determina</option>
																 --%>
															</select>
															<form:errors path="tipoValore" class="msgErrorRequired" />
														</div>
													</div>													
													
													<!-- TipoValoreFisso -->
													<div id="TipoValoreFisso" class="TipoValoreFisso" style="display:none">
														<div class="control-group">
															<label class="control-label" >Valore Fisso</label>
															<div class="controls">
																<form:input path="valoreFisso" class="span3" type="text" maxlength="50" />									
															</div>
														</div>
													</div>
													<!-- /TipoValoreFisso -->
												
													<!-- TipoNumerico -->
													<div id="TipoNumerico" class="TipoNumerico" style="display:none">
														<div class="control-group">
															<label class="control-label">Lista valori per tipo operatore</label>
															<div class="controls">
																<select id="tipoOperatore" name="operatoreNumerico" class="span6" >
																<option value="">Scegli il tipo di operatore</option>
																<option value="DIVERSO">&lt;&gt; (diverso)</option>
																<option value="MINORE">&lt; (minore)</option>
																<option value="MAGGIORE">&gt; (maggiore)</option>
																<option value="UGUALE"> &equals; (uguale)</option>
															</select>
															</div>
														</div>														
														<div class="control-group">
															<label class="control-label">Valore di confronto</label>
															<div class="controls">
																<form:input path="valoreConfrontoOperatoreNumerico" class="span3" type="text" value="0" />									
											                	<form:errors path="valoreConfrontoOperatoreNumerico" class="msgErrorRequired" />
															</div>
														</div>																		
													</div>													
													<!-- TipoAlfanumerico -->
													<div id="TipoAlfanumerico" class="TipoAlfanumerico" style="display:none">
														<div class="control-group">
															<label class="control-label" >Dimensione massima</label>
															<div class="controls">
																<form:input path="dimensione" class="span3" type="text"  />									
											                	<form:errors path="dimensione" class="msgErrorRequired" />
															</div>
														</div>

														<div class="control-group">
															<label class="control-label" >Dimensione minima</label>
															<div class="controls">
																<form:input path="dimensioneMin" class="span3" type="text"  />									
											                	<form:errors path="dimensioneMin" class="msgErrorRequired" />
															</div>
														</div>

													</div>
													<!-- /TipoNumerico -->			
													<!-- determina/delibera -->
													<div id="TipoDetDelibera" class="TipoDetDelibera" style="display:none">
														<div class="control-group">
															<form:hidden path="flgCtrlContabilita"    value="NO" />		
	
															<!-- 
															<label class="control-label" >Attiva Controllo Esistenza Provvedimento</label>
															<div class="controls">
																 <form:radiobutton class="radio inline" path="flgCtrlContabilita" value="SI" />si 
																 <form:radiobutton class="radio inline" path="flgCtrlContabilita" value="NO" />no								 
															</div>
															-->
														</div>
													</div>
													<!-- /determina/delibera -->	
													<%-- 											
													<div class="control-group">
														<span class="control-label">Bloccante</span>
														<div class="controls">
															 <form:radiobutton class="radio inline" path="flgCtrlBloccante" value="SI" />si 
															 <form:radiobutton class="radio inline" path="flgCtrlBloccante" value="NO" />no
														</div>
													</div>
													--%>
													<div class="Border_line"></div>
													<p> 
														<button type="button" class="btn btn-primary pull-right" id="aggiungiColonna"  name="aggiungiColonna"  >aggiungi colonna</button> 																				
													</p>
											</fieldset>									
											</div>
										</div>
									</div>	
								</div>
							</div>
						</div>
						</c:if>
					</fieldset>					
				</div>
			</div>
			<p class="margin-medium">
				<a href="../modificaModuli/start.do" class="btn btn-secondary">indietro</a>
				<c:if test='${gestioneColonneModuloModel.strutturaModificabile}' >
					<button type="button" id="salva"  name="salva"  class="btn btn-primary pull-right" >salva</button> 
				</c:if>
			</p>    			   
			</form:form>
		</div>
	</div>	 
</div>	
<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>
<script src="${jspath}/js/portril/gestioneModificaColonneModulo.js" type="text/javascript"></script>
</body>
</html>
