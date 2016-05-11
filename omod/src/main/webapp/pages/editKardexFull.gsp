<%
 ui.decorateWith("appui", "standardEmrPage")
%>

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
	{ label: "Nursing Kardex", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/nursingKardex.page' },
	{ icon: "icon-file", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/viewKardex.page' },
	{ icon: "icon-pencil" }
	];	

</script>

${ ui.includeFragment("nursingkardex", "display/basicPatientInfo") }  <br/><br/>

<div id="content" class="container" style="font-size:11px">

<!-- Date/Shift-->
Date/Shift:  2014-01-03   (AM)

<table border="0" id="ooo">
	<tr>
		<td style="background:#efe1ac"><h4>Parenteral Therapy</h4></td>
		<td style="background:#efe1ac"><h4>Intake</h4></td>
		<td style="background:#efe1ac"><h4>Output</h4></td>
		<td style="background:#efe1ac"><h4>Monitoring</h4></td>
		<td style="background:#efe1ac"><h4>Nursing Interventions</h4></td>
		<td style="background:#efe1ac"><h4>Special Endorsements</h4></td>
	</tr>
	<tr>
		<td style="vertical-align:text-top"><!--Parenteral Therapy -->
			${ ui.includeFragment("nursingkardex", "field/editIVT") }
		</td>
		<td style="vertical-align:text-top"><!--Intake-->
			${ ui.includeFragment("nursingkardex", "field/editDiet") }
		</td>
		<td style="vertical-align:text-top"><!--Output-->
			${ ui.includeFragment("nursingkardex", "field/editOutput") }
		</td>
		<td style="vertical-align:text-top"><!--Monitoring-->
			${ ui.includeFragment("nursingkardex", "field/editMonitoring") }
		</td>
		<td style="vertical-align:text-top"><!--Nursing Interventions-->
			${ ui.includeFragment("nursingkardex", "field/editIntervention") }
		</td>
		<td style="vertical-align:text-top"><!--Others-->
			${ ui.includeFragment("nursingkardex", "field/editSpecialEndorsement") }
		</td>
	</tr>
	<tr>
		<td style="vertical-align:text-top" colspan="6"><!--Procedure-->
			${ ui.includeFragment("nursingkardex", "field/editProcedure") }
		</td>
	</tr>
</table>

</div>