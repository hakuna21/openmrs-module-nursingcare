<%
 ui.decorateWith("appui", "standardEmrPage")
%>

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
	{ label: "Nursing Kardex", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/nursingKardex.page' },
	{ label: "Patient List"}
	];	
</script>


<div id="content" class="container" style="font-size:15px;width:160px">
${ ui.includeFragment("nursingkardex", "display/leftPanel") }  <br/><br/>
</div>



<div style="position:relative;margin-top:-610px;margin-left:180px;padding-left:50px;background:#6DBBB6;width:740px;height:auto;font-size:13px">
	
	<table border="0" style="padding:0px;margin:0px">
		<!-- PATIENT LIST -->
		<tr>
			<td style="vertical-align:text-top">
				<br/>
					<h4>Patient List</h4>
					<table border="0">
						<tr>
							<th>Bed Number</th>
							<th>Patient Name</th>
							<th>Service</th>
							<th>Physician</th>
						</tr>
						<tr>
							<td>410-A</td>
							<td>Maria Cristina Kuh</td>
							<td>Neuro</td>
							<td>Dr. Paul Cruz</td>
						</tr>
						<tr>
							<td>410-B</td>
							<td>Angela Pagkatotohan</td>
							<td>GS1</td>
							<td>Dr. Ontario Panganiban</td>
						</tr>
						<tr>
							<td>410</td>
							<td>Gregorio Macario</td>
							<td>Neuro</td>
							<td>Dr. Agnes Rosario</td>
						</tr>
						<tr>
							<td>411</td>
							<td>Jose Sta. Maria</td>
							<td>Pedia</td>
							<td>Dr. Riza Abad</td>
						</tr>
						<tr>
							<td>412</td>
							<td>Jimmie Macali</td>
							<td>Pedia Surg</td>
							<td>Dr. Randy Evangelista</td>
						</tr>
						<tr>
							<td>413</td>
							<td>Lisa Esteban</td>
							<td>Pulmo</td>
							<td>Dr. Vicky Cruz</td>
						</tr>
						<tr>
							<td>414-1</td>
							<td>Mia Amoroso</td>
							<td>Uro</td>
							<td>Dr. Wendel Mapa</td>
						</tr>
						<tr>
							<td>414-2</td>
							<td>Julie Elias</td>
							<td>GS3</td>
							<td>Dr. Rose Sia</td>
						</tr>
						<tr>
							<td>415-1</td>
							<td>Jenny Si</td>
							<td>OB Onco</td>
							<td>Dr. Jasmine Perez</td>
						</tr>
						<tr>
							<td>415-2</td>
							<td>Henrietta Si</td>
							<td>OB Onco</td>
							<td>Dr. Bennet Aga</td>
						</tr>
						<tr>
							<td>415-3</td>
							<td>Wendy Si</td>
							<td>OB Onco</td>
							<td>Dr. Larry Osorio</td>
						</tr>
						<tr>
							<td>415-3</td>
							<td>Janine Sakay</td>
							<td>OB Onco</td>
							<td>Dr. Willie Farrell</td>
						</tr>
						<tr>
							<td>416-1</td>
							<td>Arnel Lacbay</td>
							<td>GS1</td>
							<td>Dr. Eve Misa</td>
						</tr>
						<tr>
							<td>416-2</td>
							<td>Jano Marasigan</td>
							<td>GS2</td>
							<td>Dr. Michael Smith</td>
						</tr>
					</table>
						
			</td>
				<!-- BED NUMBER LIST -->
			<td style="width:60px;padding:0px;margin:0px;vertical-align:text-top">
				${ ui.includeFragment("nursingkardex", "display/bedNumberList") }
			</td>
		</tr>
	</table>
	
</div>