<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<%@ include file="include/head.html"%>
</head>
<body>

<p class="nascosto"><a name="A-sommario" title="A-sommario"></a></p>     
	<ul id="sommario" class="nascosto">
		<li><a href="#A-contenuti">Salta ai contenuti</a></li>
	</ul>
<hr />

<div class="container-fluid-banner">
	<%@ include file="include/portalheader.html" %>
	<%@ include file="include/applicationHeader.html" %>
</div>

<p>&nbsp;</p>
<div class="container-fluid">
  <div class="row-fluid">
    <div id="noPad" class="span12 contentPage">		
		<div class="alert-generic">	
			<div class="icon-msgError">
				<div class="txt-msgError">&num;ERROR</div>
			</div>
			<div class="center">
				<div class="format-icon"><i class="icon-pushpin"></i></div>
			</div>
			<div class="text-generalError">
				<p>Ci scusiamo, si &egrave; verificato un'errore imprevisto!<br>L'utente non &egrave; abilitato alla procedura</p>				
				</div>
			
			</div>
		</div>		
	</div>
  </div>	 
</div>	
<br/>
<%@ include file="include/portalFooter.html" %>
<%@ include file="include/javascript.jsp" %>
</body>
</html>
