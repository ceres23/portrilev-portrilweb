<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<table class="table table-hover tab_left dataTable"  id="tabellaListaColonne">
<thead>
	<tr>
		<th>Ordine</th>
		<th>Etichetta</th>
		<th>Dimensione</th>
		<th>Tipo</th>
		<th>Obbligatorio</th>
		<th class="tab_Right span1">&nbsp;</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="colonneMod" items="${gestioneColonneModuloModel.listaColonneModulo}" >
		<tr>
			<td><c:out value="${colonneMod.posizione }" /></td>
			<td><c:out value="${colonneMod.labelColonna}" /></td>
			<td><c:out value="${colonneMod.dimensione}" /></td>
			<td><c:out value="${colonneMod.tipo}" /></td>							
			<td><c:out value="${colonneMod.flagObbligatorieta}" /></td>
			
			
			<td class="tab_Right">
				<div class="btn-group">
					<c:if test='${gestioneColonneModuloModel.strutturaModificabile}' >
						<c:if test="${colonneMod.modificabile=='SI'}" >
						<button class="btn dropdown-toggle" data-toggle="dropdown">Azioni<span class="caret"></span></button>
						<ul class="dropdown-menu pull-right">
							<li><a data-azione='<c:out  value="modificaColonnaModulo.do" />'   href='#'  data-id-posizione='<c:out  value="${colonneMod.posizione}" />'    >Modifica Colonna</a></li>
							<li><a data-azione='<c:out  value="cancellaColonnaModulo.do" />'   href='#'  data-id-posizione='<c:out  value="${colonneMod.posizione}" />'    >Elimina Colonna</a></li>												
						</ul>
						</c:if>
					</c:if>
				</div>                               
			</td>
		</tr>	
		</c:forEach>
		
	</tbody>								
</table>
<form:hidden path="idPosizioneSel"  />
