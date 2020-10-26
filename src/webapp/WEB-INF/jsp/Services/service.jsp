<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>

<%@ include file="../../../include/head.html"%>
</head>
<body> 
                      
<!-- NAVIGAZIONE -->

<p class="nascosto"><a name="A-sommario" title="A-sommario"></a></p>     
<ul id="sommario" class="nascosto">
	<li><a href="#A-contenuti">Salta ai contenuti</a></li>
</ul>

<!-- /NAVIGAZIONE -->
	
	
<hr />
<div class="container-fluid-banner">

<%@ include file="../../../include/portalheader.html" %>
<%@ include file="../navbarLogin.html" %>
<%@ include file="../../../include/applicationHeader.html" %>
<!--#include virtual="../../ris/include/portalheader.html" -->
<!--#include virtual="../../ris/include/navbarLogin.html" -->
<!--#include virtual="../../ris/include/applicationHeader.html" -->

 <a name="A-contenuti" title="A-contenuti"></a>
</div>


<div class="row-fluid">
	<div class="span12">
		<ul class="breadcrumb">
			 <!-- <li><a href="../index.shtml">Home</a> <span class="divider">></span></li> -->
			<li><a href="../menuGestore/start.do">Home</a> <span class="divider"></span></li>			
			<li class="active">Invoca WS</li>
		</ul> 
	</div>	
</div>

<form:form id="service" modelAttribute="serviceModel" method="post" action="invoca.do">
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    

			<%@ include file="../../../include/alertErrorWarningSuccess.jsp" %>

			<h3>Invoca Servizio</h3>

			<div class="step-content">
				<div class="step-pane active" id="step1">
					<h4>Dati utente</h4>
					<fieldset class="form-horizontal">
							
						<div class="control-group">
							<div class="controls">
								<form:input path="parametro" class="span9" type="text"/>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
			  
			<!--#include virtual="include/modal.html" -->  
			<p class="margin-medium"> 
				<button type="submit" class="btn btn-primary pull-right" >invoca</button> 
			</p>       

		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>

</form:form>
</body>
</html>
