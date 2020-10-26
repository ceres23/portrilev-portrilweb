<%--
SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
SPDX-License-Identifier: EUPL-1.2
--%>
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    	 <script src="${jspath}/js/jquery.js" type="text/javascript"></script>
   
    <script src="${jspath}/js/bootstrap-transition.js" type="text/javascript"></script>
    <script src="${jspath}/js/bootstrap-alert.js" type="text/javascript"></script>
    <script src="${jspath}/js/bootstrap-modal.js" type="text/javascript"></script>
    <script src="${jspath}/js/bootstrap-dropdown.js" type="text/javascript"></script>
    <script src="${jspath}/js/bootstrap-scrollspy.js" type="text/javascript"></script>
    <script src="${jspath}/js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="${jspath}/js/bootstrap-tooltip.js" type="text/javascript"></script>
    <script src="${jspath}/js/bootstrap-popover.js" type="text/javascript"></script>
    <script src="${jspath}/js/bootstrap-button.js" type="text/javascript"></script>
    <script src="${jspath}/js/bootstrap-collapse.js" type="text/javascript"></script>
    <script src="${jspath}/js/bootstrap-carousel.js" type="text/javascript"></script>
    <script src="${jspath}/js/bootstrap-typeahead.js" type="text/javascript"></script>
    <script src="${jspath}/js/bootstrap-affix.js" type="text/javascript"></script>
    <script src="${jspath}/js/application.js" type="text/javascript"></script>
    <script src="${jspath}/js/google-code-prettify/prettify.js" type="text/javascript"></script>

    <script type="text/javascript" src="${jspath}/js/tree/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="${jspath}/js/tree/jquery.ztree.excheck-3.5.js"></script>
    <script type="text/javascript" src="${jspath}/js/tree/pianodeiconti.js"></script>
    
    <!-- risultati di ricerca   js utilizzato: datatable jquery                     -->     
    <script type="text/javascript" src="${jspath}/js/dataTable/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${jspath}/js/dataTable/bootstrap.dataTables.firstlast.min.js"></script> 
    <script type="text/javascript" src="${jspath}/js/bwizard.min.js"></script> 

	<!--selezione multipla della selct-->
	<script type="text/javascript" src="${jspath}/js/bootstrap-select.js"></script>
    <!--calendario Datepicker for Bootstrap http://www.eyecon.ro/bootstrap-datepicker/-->
  	<script type="text/javascript" src="${jspath}/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="${jspath}/js/bootstrap-datepicker.it.js"></script>
   
	<script type="text/javascript">

			$("#wizard").bwizard();
			$('.datepicker').datepicker({language:'it'});
			$(".selectpicker").selectpicker();
			$(document).ready(function() {
				$('#risultatiricerca').dataTable(
				{	
				"sScrollY": 300,
        		"sDom": "<'row datatableth'r>t<'row datatableth'<'span6'><'span6'>>",
				"sPaginationType": "bootstrap",
				"oLanguage": {
				<!--"sLengthMenu": "Display _MENU_ records per page",-->

				"sProcessing": "Attendere prego...",
				"sZeroRecords": "Non sono presenti risultati di ricerca secondo i parametri inseriti",
            	"sInfo": "_START_ - _END_ di _TOTAL_ risultati",
 				"sInfoEmpty": "0 - 0 di 0 risultati",
				"sInfoFiltered": "(filtrato su _MAX_ risultati)",
				"sInfoPostFix": "",
				"sSearch": "Cerca",
				"sUrl": "",
				"oPaginate": {
					"sFirst":    "Prima",
					"sPrevious": "Prec.",
					"sNext":     "Succ",
					"sLast":     "Ultima"
				}
				}
				}
				);
			} );
			$(document).ready(function() {
				$('table.oggettiTrovati').dataTable(
				{
				
				 "sDom": "<'row datatableth'<'span12'l>r>t<'row datatableth'<'span6'i><'span6'p>>",
				"sPaginationType": "bootstrap",
				"oLanguage": {
				<!--"sLengthMenu": "Display _MENU_ records per page",-->

				"sProcessing": "Attendere prego...",
				"sZeroRecords": "Non sono presenti risultati di ricerca secondo i parametri inseriti",
            	"sInfo": "_START_ - _END_ di _TOTAL_ risultati",
 				"sInfoEmpty": "0 - 0 di 0 risultati",
				"sInfoFiltered": "(filtrato su _MAX_ risultati)",
				"sInfoPostFix": "",
				"sSearch": "Cerca",
				"sUrl": "",
				"oPaginate": {
					"sFirst":    "Prima",
					"sPrevious": "Prec.",
					"sNext":     "Succ",
					"sLast":     "Ultima"
				}
				}
				}
				);
			} );
			
			var setEnte="true";
			var stringURLIndex;
			
			function StartMenu(event){
				if(setEnte == "true"){
					stringURLIndex = event.currentTarget.name;
					var modalSelectEnte = $('#msgSelezionaEnte');
					modalSelectEnte.modal('show');
				}
			};	
			
			
			$(document).on("click", "#confirmSelectEnte", function(e) {  				
					//window.location.href = stringURLIndex;
			});

			/**
			 * Cosa sto facendo?
			 */
			function startMenu(element) {
				var $el = $(element);
				var redirectionURL = $el.data("redirect");
				$("#msgSelezionaEnte").modal("show");
				$("#confirmSelectEnte").off("click").on("click", function(e) {
					var event = $.Event("redirigiVersoPagina");

//					e.preventDefault();
//					e.stopPropagation();
					event.urlPerRedirezione = redirectionURL;
					$(this).trigger(event);
				});
			}

			//tutti i bottoni con attributo data-action eseguono questa porzione di codice
			//setto l'action del form con il valore dell'attributo data-action
			$("button[data-action]").click(function() {	
				$("form").attr("action",$(this).data("action")).submit();
			});
			
			$("#clean").click(function(){
				$("form").attr("action", "clean.do").submit();		
			});

			var checkAllTableList = function (me) {
				$(me).closest("table").find('input[type="checkbox"]').not(me).prop('checked', me.checked);
			}
			 
			// Standard
			var dataTableOptions = {
				iDisplayLength: 50,
				bFilter: false,
				//bAutoWidth: false,
				bDestroy: true,				
				bSort: true,
				aLengthMenu: [50],
				//aLengthMenu: [25, 50],
				oLanguage: {
					sProcessing: 'Elaborazione in corso...',
					sZeroRecords: 'Nessun risultato trovato',
					sInfoFiltered: ' - filtrato da _MAX_ risultati',
					sInfoEmpty: '0 risultati',
					sInfo: '_START_ - _END_ di _TOTAL_ risultati',
					sLengthMenu: '_MENU_ record per pagina',
					sEmptyTable: 'Nessun risultato trovato',
					sSearch: 'Filtro ',
					oPaginate: {
						sFirst: 'Inizio',
						sLast: 'Fine',
						sNext: 'Succ.',
						sPrevious: 'Prec.'
					}
				}
			};
			$("[data-hide]").on("click", function() {
		        var self = $(this);
		        self.closest("." + self.attr("data-hide")).slideUp();
		    });


				
	</script>
        
	