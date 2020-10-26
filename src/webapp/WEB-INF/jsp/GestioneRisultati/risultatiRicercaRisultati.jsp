<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<c:choose>  
	<c:when test="${empty gestioneRisultatiModel.listaModuli}"> 
		<!-- eventuale condizione di successo -->
	</c:when>  
	<c:otherwise>   
	
	<table class="table table-hover tab_left"  id="tabellaRisultati" >
		<thead>
			<tr>
				<th class="span2"><input type="checkbox" onchange="checkAllTableList(this)" name="chk[]" class="tooltip-test" title="Seleziona tutti" /></th>
				<th>Modulo</th>
				<th>Descrizione</th>
				<th>Codice Gruppo</th>
				<th>Stato</th>
				<th>Data Inizio</th>
				<th>Data Fine</th>
				<th class="tab_Right span1">&nbsp;</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="moduloSel" items="${gestioneRisultatiModel.listaModuli}" >
			<tr>        
				<td><input type="checkbox" name="fooCheck"  id="fooCheck_<c:out value='${moduloSel.idModulo}'/>" value="<c:out value='${moduloSel.idModulo}' />" /> &nbsp;</td>
			          
				<td><c:out value="${moduloSel.nome}" /></td>
				<td><c:out value="${moduloSel.descrizione}" /> </td>
				<td><c:out value="${moduloSel.codiceGruppo}" /></td>
				<td><c:out value="${moduloSel.stato}" /></td>
				<td><c:out value="${moduloSel.dataInizioCompilazioneStr}" /></td>
				<td><c:out value="${moduloSel.dataFineCompilazioneStr}" /></td>
				<td class="tab_Right">
					<div class="btn-group">
						<button class="btn dropdown-toggle" data-toggle="dropdown">Azioni<span class="caret"></span></button>
						<ul class="dropdown-menu pull-right">
							<%--
							<li><a data-azione='<c:out  value="goToValida.do" />'          href='#'  data-id-modulo='<c:out  value="${moduloSel.idModulo}" />'    >valida</a></li>
							--%>
							<li><a data-azione='<c:out  value="visualizzaDatiEnte.do" />'  href='#'  data-id-modulo='<c:out  value="${moduloSel.idModulo}" />'    >Visualizza dati ente</a></li>
							<li><a data-azione='<c:out  value="scaricaDati.do" />'         href='#'  data-id-modulo='<c:out  value="${moduloSel.idModulo}" />'    >Scarica dati csv</a></li>
							<li><a data-azione='<c:out  value="report.do" />'              href='#'  data-id-modulo='<c:out  value="${moduloSel.idModulo}" />'    >Stato compilazione enti</a></li>						
							<c:if test="${moduloSel.stato!='chiusi' && moduloSel.obbligConferma !='NO'}" >
								<li><a data-azione='<c:out  value="gotoSbloccaConferme.do" />' href='#'  data-id-modulo='<c:out  value="${moduloSel.idModulo}" />' 	  >Valida/Sblocca</a></li>
								<li><a data-azione='<c:out  value="sollecita.do" />'           href='#'  data-id-modulo='<c:out  value="${moduloSel.idModulo}" />'    >Sollecita</a></li>
							</c:if>
						</ul>
					</div>                               
				</td>
			</tr>
			</c:forEach>
		</tbody>  
	</table>
	</c:otherwise>  
</c:choose>   