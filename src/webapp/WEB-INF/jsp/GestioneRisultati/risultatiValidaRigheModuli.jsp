<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<c:choose>  
	<c:when test="${empty validaRigheModuliModel.listaRigheModulo}"> 
		<!-- eventuale condizione di successo -->
	</c:when>  
	<c:otherwise>  

<table class="table table-hover tab_left" id="tabellaRisultatiRigheDaValidare">

	<thead>
		<tr>
		<th class="span1"><input type="checkbox" onchange="checkAllTableList(this)" name="chk[]" class="tooltip-test" title="Seleziona tutti" /></th>
				
		<th >Ente Compilatore</th>			
		<c:forEach var="colonna" items="${validaRigheModuliModel.listaColonneModulo}" >
			<th ><c:out value="${colonna.labelColonna}" /></th>
		</c:forEach>
		</tr>
	</thead>
 
	<tbody>

	<c:forEach var="riga" items="${validaRigheModuliModel.listaRigheModulo}" varStatus="row">

		<tr>                  
			
			<td class="span1"><input type="checkbox" name="fooCheck"  <c:out value="${riga.checked}" />   id="fooCheck_<c:out value="${riga.idRiga}" />" value="<c:out value="${riga.idRiga}" />"></td>
			<td><c:out value="${riga.ragioneSocialeEnte}"/></td>
			
			
			<c:forEach var="cella" items="${riga.listaCelleModulo}" varStatus="col">		
				
				<td>
				
				<c:choose>  
					<c:when test="${cella.editabilitaProfilo == 'VALIDATORE'}"> 
						<input name="campoedit" id='<c:out value="${cella.idRiga}"/>-<c:out value="${cella.idColonnaModulo}"/>' class="span12" type="text" value='<c:out value="${cella.valore}" />' data-row='<c:out value="${row.index}"/>' data-column='<c:out value="${col.index}"/>' >
					</c:when>  
					<c:otherwise>   				
						<c:out value="${cella.valore}" />
					</c:otherwise>  
				</c:choose> 
				</td>
			</c:forEach>
		</tr>
	</c:forEach>

	</tbody>  
</table>
	<br>
	<p>
	    
		<span class="pull-right">
			<button type="button" class="btn btn-primary" name ="esporta" id ="esporta" >scarica dati</button> 
			<button type="button" class="btn btn-primary" name ="salva"   id ="salva" >salva</button> 
		</span>
	</p>       

	<form:hidden path="listaIdDaValidare" />
	<form:hidden path="listaIdDaNonValidare" />
	</c:otherwise>  
</c:choose> 


