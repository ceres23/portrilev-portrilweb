<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<%@ include file="../../../include/head.html"%>
</head>
<body>

	<!-- NAVIGAZIONE -->

	<p class="nascosto">
		<a title="A-sommario"></a>
	</p>
	<ul id="sommario" class="nascosto">
		<li><a href="#A-contenuti">Salta ai contenuti</a></li>
	</ul>

	<!-- /NAVIGAZIONE -->

	<hr />
	<div class="container-fluid-banner">

		<%@ include file="../../../include/portalheader.html"%>
		<%@ include file="../navbarCompLogin.html"%>
		<%@ include file="../../../include/applicationHeader.html"%>

		<a title="A-contenuti"></a>
	</div>

	<div class="row-fluid">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="../menuCompilatore/start.do">Home</a> <span class="divider">></span></li>
				<li class="active">Ricerca Modulo</li>
			</ul>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12 contentPage">
				<form:form id="gestioneDefinizioneModuliRicerca" modelAttribute="ricercaGestioneModuliModel" method="post" action="ricerca.do">
					<%@ include file="../../../include/alertErrorWarningSuccess.jsp"%>

					<h3>Ricerca Modulo</h3>
					<div class="step-content">
						<div class="step-pane active" id="step1">
							<h4>Dati</h4>
							<fieldset class="form-horizontal">
							<br>
							<div class="control-group">
								<label class="control-label" for="nome">Titolo</label>
								<div class="controls">
									<form:input path="nome" class="span6" maxlength="50" />
									<input type="hidden" id="stato" name="stato"  value="IN_COMPILAZIONE_OR_CHIUSO" />
								</div>
							</div>
							<br>

							<div class="control-group">
								<span class="control-label">Tipo Modulo*</span>
								<div class="controls">
									<form:radiobutton class="radio inline" path="tipo" value="RILEVAZIONE" />RILEVAZIONE	
									<form:radiobutton class="radio inline" path="tipo" value="COMUNICAZIONE" />COMUNICAZIONE 								 
								</div>
							</div>

							</fieldset>
						</div>
					</div>
					<br>
					<p>
						<a href="../menuCompilatore/start.do" class="btn btn-secondary">indietro</a>&nbsp;
						<button type="button" class="btn btn-secondary" id="clean">pulisci</button>
						<span class="pull-right">	
							<button type="button" id="cerca" name="cerca" class="btn btn-primary pull-right">cerca</button>
						</span>
					</p>

					<div class="clear"></div>
					<br>

					<div id="risModuli">

						<c:if test="${not empty ricercaGestioneModuliModel.listaModuli}">

							<table class="table table-hover tab_left"
								id="tabellaListaRisultatiModuli">
								<thead>
									<tr>
										<th>Modulo</th>
										<th>Descrizione</th>
										<c:if test="${ricercaGestioneModuliModel.tipo=='RILEVAZIONE'}">
											<th>Stato</th>
											<th>Data Inizio</th>
											<th>Data Fine</th>
										</c:if>
										<th class="tab_Right span1">&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="modulo" items="${ricercaGestioneModuliModel.listaModuli}">
										<tr>
											<td><c:out value="${modulo.nome}" /></td>
											<td><c:out value="${modulo.descrizione}" /></td>
											<c:if test="${ricercaGestioneModuliModel.tipo=='RILEVAZIONE'}">
												<td><c:out value="${modulo.stato}" /></td>
												<td><c:out value="${modulo.dataInizioCompilazioneStr}" /></td>
												<td><c:out value="${modulo.dataFineCompilazioneStr}" /></td>
											</c:if>
											<td class="tab_Right">
												<div class="btn-group">
													<button class="btn dropdown-toggle" data-toggle="dropdown">
														Azioni<span class="caret"></span>
													</button>
													
													<ul class="dropdown-menu pull-right">
														<li><a data-azione='<c:out  value="scaricaDati.do" />' data-id-modulo='<c:out  value="${modulo.idModulo}" />' href='#'>scarica dati</a></li>
														<li><a data-azione='<c:out  value="consulta.do" />' data-id-modulo='<c:out  value="${modulo.idModulo}" />' href='#'>consulta</a></li>
													</ul>
												</div>
											</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
							<form:hidden path="idModuloSel" />
						</c:if>

						<br>
					</div>
					
				</form:form>
			</div>
		</div>
	</div>

	<%@ include file="../../../include/infoRequired.html"%>
	<%@ include file="../../../include/portalFooter.html"%>
	<%@ include file="../../../include/javascript.jsp"%>

	<script src="../../js/portril/ricDefinModuli.js" type="text/javascript"></script>

</body>
</html>
