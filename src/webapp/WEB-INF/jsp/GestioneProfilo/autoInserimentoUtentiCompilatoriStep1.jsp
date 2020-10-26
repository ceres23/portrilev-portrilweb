<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<%@ include file="../../../include/head.html"%>
</head>
<body> 
                      
<!-- NAVIGAZIONE -->

<p class="nascosto"><a title="A-sommario"></a></p>     
<ul id="sommario" class="nascosto">
	<li><a href="#A-contenuti">Salta ai contenuti</a></li>
</ul>

<!-- /NAVIGAZIONE -->
	
	
<hr />
<div class="container-fluid-banner">

<%@ include file="../../../include/portalheader.html" %>
<%@ include file="../navbarCompLogin.html" %>
<%@ include file="../../../include/applicationHeader.html" %>

 <a title="A-contenuti"></a>
</div>


<div class="row-fluid">
	<div class="span12">
		<ul class="breadcrumb">
			<li class="active">Inserisci utente compilatore</li>
		</ul> 
	</div>	
</div>

<form:form id="accessocompilatore/autoInserimentoUtentiCompilatoriStep1" modelAttribute="utentiCompilatoriModel" method="post" action="inserisciStep1.do">
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12 contentPage">    

			<%@ include file="../../../include/alertError.jsp" %>

			<h3>Inserisci utente compilatore</h3>
			
			<div id="MyWizard" class="wizard">
				<ul class="steps">
					<li data-target="#insUtentiComp1" class="active"><span class="badge">1</span>Inserimento Dati<span class="chevron"></span></li>
					<li data-target="#insUtentiComp2"><span class="badge">2</span>Associa Ente<span class="chevron"></span></li>
				</ul>
			</div>

			<div class="step-content">
				<div class="step-pane active" id="step1">
					<h4>Dati utente</h4>
					<fieldset class="form-horizontal">
						<!-- 
						<div class="control-group">
							<label class="control-label" for="LoginUtente">Login</label>
							<div class="controls">
									<input id="LoginUtente" class="span6" type="text" value="" name="LoginUtente" disabled="disabled" />
							</div>
						</div>
						 -->
						<div class="control-group">
							<label class="control-label" for="nome">Nome*</label>
							<div class="controls">
									<!-- <input id="NomeUtente" class="span6" type="text" value="" name="NomeUtente" />-->
									<form:input path="nome" class="span6" type="text" maxlength="50" style="text-transform: uppercase;" />
									<form:errors path="nome" class="msgErrorRequired" type="text" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="cognome">Cognome*</label>
							<div class="controls">
									<!-- <input id="CognomeUtente" class="span6" type="text" value="" name="CognomeUtente" /> -->
									<form:input path="cognome"  class="span6" type="text" style="text-transform: uppercase;" />
									<form:errors path="cognome" class="msgErrorRequired" type="text" maxlength="50" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="codiceFiscale">Codice Fiscale*</label>
							<div class="controls">
									<!-- <input id="CodiceFiscaleUtente" class="span6" type="text" value="" name="CodiceFiscaleUtente" /> -->
									<form:input path="codiceFiscale"  class="span6" type="text" maxlength="16" style="text-transform: uppercase;" />
									<form:errors path="codiceFiscale" class="msgErrorRequired" type="text" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="mail">Mail*</label>
							<div class="controls">
									<!-- <input id="MailUtente" class="span4" type="text" value="" name="MailUtente" />-->
									<form:input path="mail"  class="span6" type="text" maxlength="150" />
									<form:errors path="mail" class="msgErrorRequired" type="text" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="telefono">Telefono*</label>
							<div class="controls">
									<!-- <input id="TelefonoUtente" class="span3" type="text" value="" name="TelefonoUtente" /> -->
									<form:input path="telefono"  class="span6" type="text" maxlength="50" />
									<form:errors path="telefono" class="msgErrorRequired" type="text" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="telefono">Presa Visione*</label>
							<div class="controls">
								<form:checkbox path="trattamentoDati" value="OK" /><form:errors path="trattamentoDati" class="msgErrorRequired" type="text" />	<br>

									<b>Informativa sulla privacy - iniziative di comunicazione</b>
									<br><br><br>						
									La informiamo che i suoi dati personali sono trattati secondo quanto previsto dal "Regolamento 2016/679 relativo alla protezione delle persone fisiche con riguardo al trattamento dei dati personali, nonch&egrave alla libera circolazione di tali dati e che abroga la direttiva 95/46/CE (Regolamento Generale sulla Protezione dei dati, di seguito GDPR)".<br>
									Ai sensi dell'art.13 del GDPR, le forniamo, pertanto, le seguenti informazioni:<br>
									<br>
									il Titolare del trattamento di dati personali &egrave il CSI Piemonte, con sede in Torino, Corso Unione Sovietica 216 nella persona del suo Legale Rappresentante (protocollo@cert.csi.it, privacy@csi.it). I dati di contatto del Responsabile della Protezione dei dati (RPD o DPO) sono: rpd.privacy@csi.it;<br>
									<br>
									i suoi dati personali vengono raccolti e comunque trattati, nel rispetto dei principi di correttezza, liceit&agrave, minimizzazione dei dati e tutela della riservatezza, in modalit&agrave elettronica, per poterla informare sulle attivit&agrave e le iniziative organizzate dal CSI Piemonte e consentire la sua partecipazione alle stesse, nonch&egrave, in considerazione della relazione esistente tra l'Interessato e il Titolare del trattamento, per il perseguimento del legittimo interesse del Titolare stesso. Il perseguimento di tale legittimo interesse costituisce, ai sensi dell'art. 6, comma 1, lettera f del GDPR  e anche in conformit&agrave a quanto espressamente disposto al Considerando n. 47 del GDPR e all'Opinion n. 6/2014 Article 29 Data Protection Working Party, par. III.3.1 - la base giuridica del trattamento dei suoi dati personali;<br>
									<br>
									il trattamento dei suoi dati &egrave necessario in relazione alle finalit&agrave sopradescritte; ne consegue che l'eventuale richiesta di cancellazione determiner&agrave l'impossibilit&agrave da parte sua di ricevere informazioni sulle iniziative del CSI Piemonte, compresa la ricezione di comunicati stampa e di inviti agli eventi organizzati;<br>
									<br>
									i suoi dati sono trattati esclusivamente da persone autorizzate e istruite in tal senso o da soggetti nominati Responsabili del trattamento, adottando tutte quelle misure tecniche e organizzative adeguate per tutelare i diritti, le libert&agrave e i legittimi interessi che le sono riconosciuti per legge in qualit&agrave di Interessato;<br>
									<br>
									i suoi dati personali sono trattati fino all'eventuale sua richiesta di cancellazione e sono conservati per un periodo di sei mesi successivo a tale richiesta e gestiti su server ubicati nelle sedi del CSI Piemonte;<br>
									<br>
									i suoi dati personali non saranno in alcun modo oggetto di trasferimento in un Paese terzo extra europeo, n&egrave di comunicazione a terzi fuori dai casi previsti dalla normativa in vigore, n&egrave di processi decisionali automatizzati, compresa la profilazione.<br>
									<br>
									<br>
									Potr&agrave esercitare i diritti previsti dagli artt. da 15 a 22 del GDPR (tra cui quelli di ottenere la conferma dell'esistenza o meno dei suoi Dati personali e la loro messa a disposizione in forma intellegibile; di avere conoscenza della logica e delle finalit&agrave su cui si basa il trattamento; di ottenere la cancellazione, la trasformazione in forma anonima o la limitazione o il blocco dei Dati trattati in violazione di legge, nonch&egrave l'aggiornamento, la rettifica o, se vi &egrave interesse, l'integrazione dei dati; di opporsi per motivi legittimi al trattamento stesso) rivolgendosi al Titolare o al Responsabile della Protezione dei dati, ai dati di contatto indicati sopra.<br>
									Potr&agrave anche esercitare il diritto di proporre reclamo all'Autorit&agrave di controllo o di ricorrere alle autorit&agrave giurisdizionali competenti qualora il trattamento dei suoi dati personali avvenga in violazione di quanto previsto dal GDPR, in conformit&agrave agli artt. 77 e 79 del GDPR.<br>
									<br>
									<b>Cancellazione</b><br>
									<br>
									Se desidera che i suoi dati vengano cancellati, le chiediamo di mandare una email a questo indirizzo comunicazione@csi.it, specificando nell'oggetto "Richiesta di cancellazione dei miei dati personali".<br>
						
							</div>
						</div>

						<div class="control-group">
							<div class="controls">
								<input id="stato" name="stato" value="ATTIVO" type="hidden" />
								<input id="idProfiloUtente" name="idProfiloUtente" value="4" type="hidden" />
								<%--form:hidden path="idProfiloUtente" value="4"  / --%>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
			  
			<p class="margin-medium">
				<button type="submit" class="btn btn-primary pull-right" >prosegui</button> 
			</p>       

		</div>
	</div>	 
</div>	

<%@ include file="../../../include/infoRequired.html" %>
<%@ include file="../../../include/portalFooter.html" %>
<%@ include file="../../../include/javascript.jsp" %>
<%--@ include file="../../../js/portril/utentiCompilatoriAutoregistrazione.js" --%>

</form:form>


</body>
</html>
