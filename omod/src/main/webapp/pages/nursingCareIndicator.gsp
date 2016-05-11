<%
 ui.decorateWith("appui", "standardEmrPage")
%>

<!--<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">-->  
<!--<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>-->

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
	{ label: "Nursing Kardex", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/nursingKardex.page' },
	{ label: "Nursing Indicator"}
	];	

  \$(function() {
    \$( "#accordion" ).accordion({
      heightStyle: "content"
    });
  });

</script>

<style type="text/css">
	#accordion{
		font-size:13px;
	}
</style>

  

<div id="content" class="container" style="font-size:15px;width:160px">
${ ui.includeFragment("nursingkardex", "display/leftPanel") }  <br/><br/>
</div>



<div style="position:relative;margin-top:-610px;margin-left:180px;padding-left:50px;background:#6DBBB6;width:740px;height:auto;font-size:13px">
		
	<table border="0" style="padding:10px;margin:0px;vertical-align:text-top;font-size:13px">
		<!-- NURSING CARE INDICATOR -->
		<tr>
			<td  style="background-image:url('/${ ui.contextPath() }/images/left_green.jpg');background-size:100%">
				<div style="padding-left:10px">
					<h4 style="color:#293131">Nursing Quality Indicators</h4>
	
						Date: <input type="text" /><br/>
						Area: 4 LCB 1
						
						<div id="accordion" style="width:630px">
						
						  <h5>Movement</h5>
						  <div>
							 ${ ui.includeFragment("nursingkardex", "report/indicatorMovement") }
						  </div>
						
						  <h5>1. Monitoring</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorMonitoring") }
						  </div>
						
						  <h5>2. Comfort Measures</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorComfort") }
						  </div>
						
						  <h5>3. Nutritional Support</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorNutritional") }
						  </div>
						
						  <h5>4. Ventilatory Support</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorVentilatory") }
						  </div>
						
						  <h5>5. Elimination</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorElimination") }
						  </div>
						
						  <h5>6. Mobility/ Safety</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorMobility") }
						  </div>
						
						  <h5>7. IV Therapy</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorIVT") }
						  </div>
						
						  <h5>8. Medication</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorMedication") }
						  </div>
						
						  <h5>9. Tube Care</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorTubeCare") }
						  </div>
						
						  <h5>10. Wound Care</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorVentilatory") }
						  </div>
						
						  <h5>11. Diagnostic Procedures</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorDiagnosticProcedures") }
						  </div>
						
						  <h5>12. Prep for Invasive Procedures</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorInvasiveProcedures") }
						  </div>
						
						  <h5>13. Spiritual and Psychosocial</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorSpiritual") }
						  </div>
						
						  <h5>14. Code, Post-mortem, Terminal Cleaning, 5S, and Levels of Care</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorCode") }
						  </div>
						
						  <h5>Others</h5>
						  <div>
							${ ui.includeFragment("nursingkardex", "report/indicatorCode") }
						  </div>
					</div>
				</div><!--/padding-->
			</td>
			<!-- BED NUMBER LIST -->
			<td  style="width:60px;padding:0px;margin:0px;vertical-align:text-top">
				${ ui.includeFragment("nursingkardex", "display/areaList") }
			</td>
		</tr>
	</table>
	
</div>