<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<%@ include file="../../../../include/head.html"%>

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
		<%@ include file="../../../../include/portalheader.html"%>
		<%@ include file="../../navbarLogin.html"%>
		<%@ include file="../../../../include/applicationHeader.html"%>
		<a title="A-contenuti"></a>
	</div>

	<div class="row-fluid">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="../menuGestore/start.do">Home</a> <span class="divider"></span></li>
				<li class="active">Ricerca Compila Modulo Comunicazione</li>
			</ul>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12 contentPage">
				<form:form id="ricercaModuliXComunicazione" modelAttribute="ricercaPerCompilazioneModel" method="post" enctype="multipart/form-data" action="ricerca">
					<%@ include file="../../../../include/alertErrorWarningSuccess.jsp"%>

					<h3>Ricerca Compila Modulo  Comunicazione</h3>
					<div class="step-content">
						<div class="step-pane active" id="step1">
							<h4>Dati</h4>
							<fieldset class="form-horizontal">
								<br>
								<div class="control-group">
									<label class="control-label" for="nome">Titolo</label>
									<div class="controls">
										<form:input path="nome" class="span6" maxlength="50" />
									</div>
								</div>
								<br>
							</fieldset>
						</div>
					</div>

					<div class="clear"></div>
					<br>
					<p>
						<span class="pull-right"> 
							<button type="button"  class="btn btn-primary" id="ricerca" name="ricerca">cerca</button>							
						</span>
					</p>
					<!-- blocco risultati  -->
	
					<div id="risCompModuli" >

							<c:if test="${not empty ricercaPerCompilazioneModel.listaModuli}">
								<table class="table table-hover tab_left" id="tabellaListaRisultatiModuliDaCompilare">
									<thead>
										<tr>
											<th>Modulo</th>
											<th>Descrizione</th>
											<th class="tab_Right span1">&nbsp;</th>											
										</tr>
									</thead>
									<tbody>
										<c:forEach var="moduloSel" items="${ricercaPerCompilazioneModel.listaModuli}">
											<tr>
												<td><c:out value="${moduloSel.nome}" /></td>
												<td><c:out value="${moduloSel.descrizione}" /></td>
												<td class="tab_Right">
													<div class="btn-group">
														<button class="btn dropdown-toggle" data-toggle="dropdown"> Azioni<span class="caret"></span> </button>
														<ul class="dropdown-menu pull-right">
															<!-- <li><a data-azione='<c:out  value="compilaModulo.do" />'  href='#' data-id-modulo='<c:out  value="${moduloSel.idModulo}" />'>compila</a></li> -->
															<li><a data-azione='<c:out  value="scaricaModello.do" />' href='#' data-id-modulo='<c:out  value="${moduloSel.idModulo}" />'>scarica modello</a></li>
															<li>
																<div class="file-upload"> <span>upload</span> 
																	<input class="upload" type="file" data-azione='<c:out  value="uploadModulo.do" />'   data-id-modulo='<c:out  value="${moduloSel.idModulo}" />' > 
																</div>
															</li>
														</ul>
													</div>
												</td>
											</tr>
										</c:forEach>


									</tbody>
								</table>
								<form:hidden path="idModuloSel" />
						</c:if>
					</div>
					<!-- fine blocco risultati  -->
					<p>
						<a href="../menuGestore/start.do" class="btn btn-secondary">indietro</a>
						<button type="button" class="btn btn-secondary" id="clean">pulisci</button>
					</p>

				</form:form>
			</div>
		</div>
	</div>

	<%@ include file="../../../../include/infoRequired.html"%>
	<%@ include file="../../../../include/portalFooter.html"%>
	<%@ include file="../../../../include/javascript.jsp"%>

	<script src="../../js/portril/ricCompModulixComunicazione.js" type="text/javascript"></script>
	
	<div class="modal hide fade" id="modalinoDiAttesa" data-backdrop="static" data-keyboard="false">
		<div class="modal-body">
			<h1>Caricamento in corso</h1>
			<h4>Attendere, prego...</h4>
		</div>
	</div>
</body>
</html>
