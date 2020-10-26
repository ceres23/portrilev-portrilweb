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

			<li class="active">Gestione Password</li>
		</ul> 
	</div>	
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    

			<form:form id="gesPassword" modelAttribute="gesPasswordModel" method="post" action="salva">
			
			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>
			
				<h3>Gestione Password</h3>
				<div class="step-content">
					<div class="step-pane active" id="step1">
						
						<fieldset class="form-horizontal"> 
							<h4>Cambia password</h4>
							<br>
							<div class="control-group">
								<label class="control-label" for="passwordAttuale">Password attuale*</label>
								<div class="controls">   
									<form:password path="passwordAttuale" placeholder="password Attuale" />								
									<%--<form:input path="passwordAttuale" class="span6" type="text" />		 --%>								
									<form:errors path="passwordAttuale" class="msgErrorRequired" />	
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="passwordNuova">Nuova password*</label>
								<div class="controls">   
	
									<form:password path="passwordNuova" placeholder="password Nuova" />							
									<form:errors path="passwordNuova" class="msgErrorRequired" />		
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="passwordRipetiNuova">Conferma nuova password*</label>
								<div class="controls">   
									<form:password path="passwordRipetiNuova" placeholder="ripeti password Nuova" />									
									<form:errors path="passwordRipetiNuova" class="msgErrorRequired" />									
								</div>
							</div>
							<br>
							
						</fieldset>
					
					</div>
				</div>	
				
				<p class="margin-medium">
					<a href="../menuCompilatore/start.do" class="btn btn-secondary">indietro</a>
					<span class="pull-right">
						<button type="button" class="btn btn-primary" id ="salva" name ="salva" >salva</button> 
					</span>
				</p>       			  
			</form:form>
		</div>
	</div>	 
</div>	
<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>

<script src="../../js/portril/gesPassword.js" type="text/javascript"></script>

</body>
</html>
