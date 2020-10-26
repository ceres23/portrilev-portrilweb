<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<%@ include file="../../include/head.html"%>

</head>
<body>

<p class="nascosto"><a title="A-sommario"></a></p>     
	<ul id="sommario" class="nascosto">
		<li><a href="#A-contenuti">Salta ai contenuti</a></li>
	</ul>
<hr />

<div class="container-fluid-banner">

	<%@ include file="../../include/portalheader.html" %>
	<%@ include file="navbarCompLogin.html" %>
	<%@ include file="../../include/applicationHeader.html" %>

</div>

<form:form id="accessoCompilatore" modelAttribute="accessoCompilatoreModel" method="post" action="start.do">

<p>&nbsp;</p>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="span12 contentPage">
		<div class="ContainerIndexDefault">

			<div class="btnIndexUser">
				<div class="iconBoxProfile">
					<div class="TitleBox">Gestione Profilo<br><i>&nbsp;</i></div>
				</div>
				<div class="txtGestRisultati txtWhite">
				
					<a data-openModal data-redirect="modProfiloStep1.do"><p><span class="bullPointRisultati"></span><span>compilazione</span></p></a>
					<p class="DivisBoxRisultati"></p>
					<a data-openModal data-redirect="gesPassword.do"><p><span class="bullPointRisultati"></span><span>ricerca</span></p></a>
				
					<%-- 
					<a id="IndexSetUpEnte" href="GestioneProfilo/modProfiloStep1.shtml"><p><span class="bullPointRisultati"></span><span>modifica</span></p></a>
					<p class="DivisBoxRisultati"></p>
					<a id="IndexSetUpEnte" href="GestioneProfilo/gesPassword.shtml"><p><span class="bullPointRisultati"></span><span>cambia password</span></p></a>
					--%>
				</div>
			</div>
			<div class="btnIndexUser">
				<div class="iconBoxModuli">
					<div class="TitleBox">Gestione moduli<br><i>&nbsp;</i></div>
				</div>
				<div class="txtDefModuli txtWhite">

					<a data-openModal data-redirect="ricCompModuli.do"><p><span class="bullPointModuli"></span><span>compilazione</span></p></a>
					<p class="DivisBoxModuli"></p>
					<a data-openModal data-redirect="ricDefinModuli.do"><p><span class="bullPointModuli"></span><span>ricerca</span></p></a>


				<%--
					<a id="IndexSetUpEnte" onclick="StartMenu(event);" name="CompilaModuli/ricCompModuli.shtml" data-toggle="modal"><p><span class="bullPointModuli"></span><span>compilazione</span></p></a>
					<p class="DivisBoxModuli"></p>
					<a id="IndexSetUpEnte" onclick="StartMenu(event);" name="CompilaModuli/ricDefinModuli.shtml" data-toggle="modal"><p><span class="bullPointModuli"></span><span>ricerca</span></p></a>
				--%>
				</div>
			</div>
			
			

		</div>
		
		
		<!-- Modal -->
			<div id="msgSelezionaEnte" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="msgSelezionaEnteLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="nostep-pane">Seleziona l'Ente</h4>	   
				</div>
				<div class="modal-body">
				    <fieldset class="form-horizontal"> 
						<p><i>Per proseguire filtra l'ente da visualizzare</i></p>
						<div>
							<div class="ModalIconEnteIndex"></div>
							<div class="ModalFiltraEnteIndex">
								
								<div class="filtroPerEnte">
								<h4>ENTE Compilatore</h4>
									<%--
									<form:select path="idEnteCompilatoreDaSel">
										<form:options items="${menuGestoreModel.listaEntiGestori}" itemValue="idEnteGestore" itemLabel="ragioneSociale" />
									</form:select>
									--%>
									<select class="span12" name="idEnteCompilatoreDaSel" id="idEnteCompilatoreDaSel" >
										<option value="">Comune</option>
										<option value="">Provincia</option>
										<option value="">Regione</option>
										<option value="">Comunit&agrave; montana</option>
										
									</select>
								</div>
							</div>
						</div>
					</fieldset>
				</div>
					  <div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">annulla</button>
						<button id="confirmSelectEnte" class="btn btn-primary" href="">conferma</button>
					  </div>
			</div>  
		<!--/modale --> 
		
		<form:hidden path="utenteMonoEnteCompilatore"   /> 
		<form:hidden path="idEnteCompilatoreSel" value="" />

		
	</div>
  </div>	 
</div>	
<br/>

<%@ include file="../../include/portalFooter.html" %>
<%@ include file="../../include/javascript.jsp" %>


<script src="../../js/portril/accessoCompilatori.js" type="text/javascript"></script>

<!--#include virtual="../ris/include/portalFooter.html" -->
<!--#include virtual="../ris/include/javascript.jsp" -->
</form:form>
</body>
</html>
