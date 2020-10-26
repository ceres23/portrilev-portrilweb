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
								<!-- box login -->
								<div class="boxFormLogin">
									<h4>Sei gi&agrave; registrato:</h4>
									<div class="LineLogin"></div>
									<!--<h3>Login</h3>-->
									<p class="dataUser">
										<form:input path="user" placeholder="utente" />
									</p>
									<p class="dataPw">
										<form:password path="password" placeholder="password" />
									</p>
									<p>
										<button type="button" class="btnLogin" id="accedi" name="accedi">Accedi</button>
									</p>
								</div>
								<!-- /box login -->
								<br>

								<div class="LineLogin"></div>

								<p class="joiner"><b>Autoregistrazione</b></p>								
								<div>
									<b>Per effettuare la registrazione della propria utenza e' necessario contattare il proprio ente gestore.</b>
								</div>
								<%--
								<p class="joiner">Oppure</p>
								
								<div>
									<button type="button" class="btnInvioReg" id="autoregistrazione" name="autoregistrazione">Registrati</button>
								</div>
 								--%>
								
								<!-- 	 
								<div class="morph-button morph-button-modal morph-button-modal-2 morph-button-fixed">
									
									
									<div class="morph-content">
										<div class="content-style-form content-style-form-2">
											<p>
												<button type="button" class="close icon-close">&times;</button>
											</p>
											<h3>Non sei registrato:</h3>
											<div class="LineLogin"></div>
											<p>
												<label>Email</label>
												<form:input path="loginReg" placeholder="Email" />
											</p>
											<p>
												<label>Password</label>
												<form:password path="passwordReg" placeholder="password" />
											</p>
											<p>
												<label>Ripeti Password</label>
												<form:password path="password2Reg" placeholder="password" />
											</p>
											<br>
											<div class="LineLogin"></div>
											<br>
											<p>
												<button type="button" class="btnInvioReg" id="registrazione" name="registrazione">Registrati</button>
											 	
											</p>
										</div>

									</div>
								</div>
							 	-->
								
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
