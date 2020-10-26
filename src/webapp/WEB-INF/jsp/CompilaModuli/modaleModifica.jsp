<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--/modale modifica -->


	<div id="modalModifica" class="modal hide " tabindex="-1" role="dialog" aria-labelledby="modalModificaLabel" aria-hidden="true">
		<div class="modal-body" style="max-height: 80vh">
			<form:form id="modificaRiga" modelAttribute="rigaModuloModel" method="post" action="">			

			<div id="erroreCelleModifica" class="alert alert-error hide">
				<button type="button" class="close" data-hide="alert">&times;</button>
				<strong>Attenzione! Errori in compilazione </strong><br/><br/>
				
				<table>
					<thead></thead>
					<tbody></tbody>
				</table>
				
			</div>
			
			<table class="table table-hover tab_left" id=TabellaModificaRigaModulo>
				<thead>
					<tr>
						<td><h3><strong>Modifica</strong></h3></td>
						<td><h3>Riga</h3></td>
					</tr>
					<tr>
					</tr>

				</thead>
				<tbody>
					<c:forEach var="colonna" items="${gestioneModuliCompilaModuloModel.modulo.listaColonneModulo}" varStatus="col">
						<tr>
							<td bgcolor="CCEEDD" class="span5">
								<strong><c:out value="${colonna.labelColonna}" /></strong>
							</td>
							<td>
							<c:choose>
    							<c:when test="${colonna.tipo=='ValoreFisso'}">    							    
									<input class="span7" name="celleDaInserire[<c:out value="${col.index}"/>]" id='celleDaInserire_<c:out value="${col.index}"/>' type='text' readonly value='' data-column='<c:out value="${col.index}"/>' />
    							</c:when>    
    							<c:otherwise>									
									<input class="span7" name="celleDaInserire[<c:out value="${col.index}"/>]" id='celleDaInserire_<c:out value="${col.index}"/>' type='text'   value='' data-column='<c:out value="${col.index}"/>' />
						    	</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="hidden" name='idRiga' id='idRiga' value=''>
			</form:form>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">indietro</button>
			<button class="btn btn-primary" type="button" name="confermaModificaRiga" id="confermaModificaRiga">salva riga</button>
		</div>
	</div>
