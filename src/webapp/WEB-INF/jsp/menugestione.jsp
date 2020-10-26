<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<%@ include file="../../include/head.html"%>

</head>
<body>

	<p class="nascosto">
		<a title="A-sommario"></a>
	</p>
	<ul id="sommario" class="nascosto">
		<li><a href="#A-contenuti">Salta ai contenuti</a></li>
	</ul>
	<hr/>

	<div class="container-fluid-banner">
		<%@ include file="../../include/portalheader.html"%>
		<%@ include file="navbarLogin.html"%>
		<%@ include file="../../include/applicationHeader.html"%>
	</div>

	<form:form id="menuGestore" modelAttribute="menuGestoreModel" method="post" action="start.do">
		<p>&nbsp;</p>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12 contentPage">
					<div class="ContainerIndexDefault">				
						<c:if test="${menuGestoreModel.flgGestEntiCompilatori == 'SI'}">
							<div class="btnIndex">
								<div class="iconBoxEnti">
									<div class="TitleBox">gestione enti<br><i>compilatori</i></div>
								</div>
								<div class="txtEnti txtWhite">
									<a data-openModal data-redirect="inserimentoEntiCompilatori.do">
										<p><span class="bullPointEnte"></span><span>inserisci</span></p>
									</a>
									<p class="DivisBoxEnti"></p>
									<a data-openModal data-redirect="ricercaEntiCompilatori.do">
										<p><span class="bullPointEnte"></span><span>ricerca</span></p>
									</a>
								</div>
							</div>
						</c:if>

						<c:if test="${menuGestoreModel.flgGestUtentiCompilatori == 'SI'}">
							<div class="btnIndex">
								<div class="iconBoxUtentiComp">
									<div class="TitleBox">
										gestione utenti<br>
										<i>compilatori</i>
									</div>
								</div>
								<div class="txtUtentiComp txtWhite">
									<a data-openModal data-redirect="inserimentoUtentiCompilatoriStep1.do"><p><span class="bullPointUtentiComp"></span><span>inserisci</span></p></a>
									<p class="DivisBoxUtentiComp"></p>
									<a data-openModal data-redirect="ricercaUtentiCompilatori.do"><p><span class="bullPointUtentiComp"></span><span>ricerca</span></p></a>
								</div>
							</div>
						</c:if>

						<c:if test="${menuGestoreModel.flgGestUtentiGestori == 'SI'}">
							<div class="btnIndex">
								<div class="iconBoxUtentiGest">
									<div class="TitleBox">gestione utenti<br><i>gestore</i></div>
								</div>
								<div class="txtUtenti txtWhite">
									<a data-openModal data-redirect="inserimentoUtentiGestori.do"><p><span class="bullPointUtenti"></span><span>inserisci</span></p></a>
									<p class="DivisBoxUtenti"></p>
									<a data-openModal data-redirect="ricGestioneUtentiGestori.do"><p><span class="bullPointUtenti"></span><span>ricerca</span></p></a>
								</div>
							</div>
						</c:if>

						<c:if test="${menuGestoreModel.flgGestDefinizioneModuli == 'SI'}">
							<div class="btnIndex">
								<div class="iconBoxModuli">
									<div class="TitleBox">
										definizione moduli<br>
										<i>&nbsp;</i>
									</div>
								</div>
								<div class="txtDefModuli txtWhite">
									<a data-openModal data-redirect="insDefinModuli.do"><p><span class="bullPointModuli"></span><span>inserisci</span></p></a>
									<p class="DivisBoxModuli"></p>
									<a data-openModal data-redirect="ricercaModuli.do"><p><span class="bullPointModuli"></span><span>ricerca</span></p></a>
								</div>
							</div>
						</c:if>

						<c:if test="${menuGestoreModel.flgGestRisultati == 'SI'}">
							<div class="btnIndex">
								<div class="iconBoxRisultati">
									<div class="TitleBox">
										gestione moduli<br><i>&nbsp;</i>
									</div>
								</div>
								<div class="txtGestRisultati txtWhite">
									<a data-openModal data-redirect="ricercaModuloXComunicazione.do"><p><span class="bullPointRisultati"></span><span>compila</span></p></a>
									<p class="DivisBoxRisultati"></p>								
									<a data-openModal data-redirect="ricercaRisultati.do"><p><span class="bullPointRisultati"></span><span>ricerca</span></p></a>
								</div>
							</div>
						</c:if>
					</div>

					<!-- Modal -->
					<!-- <div id="msgSelezionaEnte" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="msgSelezionaEnteLabel" aria-hidden="true"> -->
					<div id="msgSelezionaEnte" class="modal hide fade" tabindex="-1" role="dialog"  aria-hidden="true">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="nostep-pane">Seleziona l'Ente gestore</h4>
						</div>
						<div class="modal-body">
							<fieldset class="form-horizontal">
								<p>
									<i>Per proseguire filtra l'ente da visualizzare</i>
								</p>
								<div>
									<div class="ModalIconEnteIndex"></div>
									<div class="ModalFiltraEnteIndex">
										<div class="filtroPerEnte">
											<h4>ENTE GESTORE</h4>
											<form:select path="idEnteGestoreDaSel">
												<form:options items="${menuGestoreModel.listaEntiGestori}" itemValue="idEnteGestore" itemLabel="ragioneSociale" />
											</form:select>
										</div>
									</div>
								</div>
							</fieldset>
						</div>
						<div class="modal-footer">
							<button class="btn" data-dismiss="modal" aria-hidden="true">annulla</button>
							<button id="confirmSelectEnte" class="btn btn-primary" type="button">conferma</button>
						</div>
					</div>
					<!-- Fine Modal -->
					<form:hidden path="utenteMonoEnte" />
					<form:hidden path="idEnteGestoreSel" value="" />
				</div>
			</div>
		</div>
		<br />
		<%@ include file="../../include/portalFooter.html"%>
		<%@ include file="../../include/javascript.jsp"%>
		<script src="../../js/portril/menugestione.js" type="text/javascript"></script>
	</form:form>
</body>
</html>