<%
 ui.decorateWith("appui", "standardEmrPage")
%>

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
	{ label: "Nursing Kardex", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/nursingKardex.page' },
	{ icon: "icon-file", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/viewKardex.page' }
	];	
	

</script>



<table border="0">
<tr>
	<!--<td style="padding:0px;margin:0px;vertical-align:text-top">-->
	<td>
		<!-- PATIENT SERVICE IDENTIFIER -->
			${ ui.includeFragment("nursingkardex", "display/patientServiceIdentifier") } 
		<br/>
		<!-- PATIENT INFO -->
			${ ui.includeFragment("nursingkardex", "display/patientInfo") }  
		<!-- /PATIENT INFO -->
		<br/><br/>
	
		<!-- NCP -->
			${ ui.includeFragment("nursingkardex", "display/nursingCarePlan") }  <br/><br/>
		<!-- /NCP -->
	</td>
	<td  style="width:60px;padding:0px;margin:0px;vertical-align:text-top" >
		<!-- BED NUMBER LIST-->
		${ ui.includeFragment("nursingkardex", "display/bedNumberList") }
		<!-- /BED NUMBER LIST-->
	</td>
</tr>
</table>