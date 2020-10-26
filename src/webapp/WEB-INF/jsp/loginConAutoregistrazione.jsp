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
	<hr />

	<div class="container-fluid-banner">
		<%@ include file="../../include/portalheader.html"%>
		<%@ include file="../../include/applicationHeader.html"%>
	</div>

	<p>&nbsp;</p>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12 contentPage">
				<form:form id="login" modelAttribute="loginModel" method="post" action="">
					<%@ include file="../../include/alertErrorWarningSuccess.jsp"%>

					<div class="ContainerIndexDefault containerLogin">
						<section>
							<div>
								<div class="LineLogin"></div>
								<div>
									<button type="button" class="btnInvioReg" id="autoregistrazione" name="autoregistrazione">Registrati</button>
								</div>
								<!-- morph-button -->
							</div>
							<!-- /form-mockup -->
						</section>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<br />


	<%@ include file="../../include/infoRequired.html"%>
	<%@ include file="../../include/portalFooter.html"%>
	<%@ include file="../../include/javascript.jsp"%>

	<!-- js per la pagina di login-->

	<script src="../../js/login.js" type="text/javascript"></script>
	<script src="../../js/portril/login.js" type="text/javascript"></script>

</body>
</html>
