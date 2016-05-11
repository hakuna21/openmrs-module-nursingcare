<%
 ui.decorateWith("appui", "standardEmrPage")
%>

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
	{ label: "Nursing Kardex", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/nursingKardex.page' },
	{ label: "Search"}
	];	
</script>


<div id="content" class="container" style="font-size:15px;width:160px">
${ ui.includeFragment("nursingkardex", "display/leftPanel") }  <br/><br/>
</div>



<div style="position:relative;margin-top:-610px;margin-left:180px;padding-left:50px;background:#6DBBB6;width:740px;height:auto;font-size:13px">
	
	<table border="0" style="padding:0px;margin:0px;vertical-align:text-top">
		<!-- PATIENT SEARCH -->
		<tr>
			<td  style="background-image:url('/${ ui.contextPath() }/images/left_green.jpg');background-size:100%">
				<br/>
					<h4 style="color:#293131">Patient Search</h4>
					<table border="0">
						<tr>
							<td>Name:</td>
							<td><input type="text" size="50"/></td>
						</tr>
						<tr>
							<td>Bed:</td>
							<td><input type="text" size="50"/></td>
						</tr>
						<tr>
							<td>Service:</td>
							<td><input type="text" size="50"/></td>
						</tr>
						<tr>
							<td>Physician:</td>
							<td><input type="text" size="50"/></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Submit"/></td>
						</tr>
					</table>
				
				<br/><br/><br/>
				<br/><br/><br/><br/>
				
				<br/>		
			</td>
				<!-- BED NUMBER LIST -->
			<td style="width:60px;padding:0px;margin:0px;vertical-align:text-top">
				${ ui.includeFragment("nursingkardex", "display/bedNumberList") }
			</td>
		</tr>
	</table>
	
</div>