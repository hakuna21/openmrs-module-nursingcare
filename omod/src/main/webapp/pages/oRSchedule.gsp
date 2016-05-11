<%
 ui.decorateWith("appui", "standardEmrPage")
%>

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
	{ label: "Nursing Kardex", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/nursingKardex.page' },
	{ label: "OR Schedule"}
	];	
</script>


<div id="content" class="container" style="font-size:15px;width:160px">
${ ui.includeFragment("nursingkardex", "display/leftPanel") }  <br/><br/>
</div>



<div style="position:relative;margin-top:-610px;margin-left:180px;padding-left:50px;background:#6DBBB6;width:740px;height:auto;font-size:13px">
	
	<table border="0" style="padding:0px;margin:0px;vertical-align:text-top">
		<tr>
			<td>
				<h4>For Operation/Procedure</h4>
			
				<table border="0" style="padding:0px;margin:0px;vertical-align:text-top">
					<tr>
						<td>Bed</td>
						<td>Patient</td>
						<td>Name of Procedure</td>
						<td>Schedule</td>
						<td>Physician</td>
						<td>Notes</td>
					</tr>
					<tr>
						<td>415-1</td>
						<td>Jenny Si</td>
						<td>Hysterectomy (Elective)</td>
						<td>2014-01-31 3pm <br/> @
						LCB OR</td>
						<td><br/> Dr. Jasmine Perez<br/>
						Dr. Agapito Flores</td>
						<td>pls bring down to OR at 2:30pm for ___; </td>
					</tr>
					<tr>
			
						<td>415-2</td>
						<td>Henrietta Si</td>
						<td>THBSO (Elective)</td>
						<td>2014-01-31 3pm <br/> @
						LCB OR</td>
						<td>Dr. Bennet Aga<br/><br/>
						Dr. Agapito Flores</td>
						<td>all needs c/o OR (Dr. Rosal)</td>
					</tr>
				</table>
				<br style="font-size:220px">
			</td>
		</tr>
	</table>
	
</div>
