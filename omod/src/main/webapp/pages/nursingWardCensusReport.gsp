<%
 ui.decorateWith("appui", "standardEmrPage")
%>

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
	{ label: "Nursing Kardex", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/nursingKardex.page' },
	{ label: "Ward Census"}
	];	
</script>

<div id="content" class="container" style="font-size:15px;width:160px">
${ ui.includeFragment("nursingkardex", "display/leftPanel") }  <br/><br/>
</div>


<div style="position:relative;margin-top:-610px;margin-left:180px;padding-left:50px;background:#3C7E8F;width:740px;height:auto;font-size:13.5px">
	
	<table border="0" style="padding:0px;margin:0px;vertical-align:text-top">
		<tr>
			<!-- MONITORING REPORT -->
			<td>
				<h4>Rotating Chief Nurse Monitoring Form</h4>
				
			</td>
			<!-- BED NUMBER LIST -->
			<td  style="width:60px;padding:0px;margin:0px;vertical-align:text-top">
				${ ui.includeFragment("nursingkardex", "display/reportList") }
			</td>
		</tr>
	</table>
	
</div>