<%
 ui.decorateWith("appui", "standardEmrPage")
%>

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ 			icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + 			'/index.htm' },
	{ 			label: "Nursing Kardex" 			}
	];	
</script>

<div id="content" class="container" style="font-size:15px;width:160px">
${ ui.includeFragment("nursingkardex", "display/leftPanel") }  <br/><br/>
</div>


<div style="position:relative;margin-top:-610px;margin-left:180px;padding-left:50px;background:#689B98;width:740px;height:auto;">
	
	<table border="0" style="padding:0px;margin:0px;vertical-align:text-top">
		<!-- NURSING KARDEX COVER -->
		<tr>
			<td style="background-image:url('/${ ui.contextPath() }/images/left_green.jpg');background-size:100%">
				<br/>
				
				<div style="font-size:13px;margin-left:20px;width:170px">
					Area: 4LCB1 <br/>
					${ ui.message("nursingkardex.census") }: 32 + 4RI  <br/>
					Date: 2014-01-01  &nbsp;&nbsp; 4:30 pm<br/>
					<br/>
					<a href="#" style="color:#E8FBFD"><u>Print an Endorsement</u></a>
					<!--<h4> 4LCB1 - ${ ui.message("nursingkardex.census") }: 32 + 4RI (02/12/35 4:30pm)  </h4>-->
				</div>	
				<br/><br/>
				
				<center><h1 style="font-size:26px">${ ui.message("nursingkardex.title") }</h1>
				<span style="font-size:16px;color:brown">${ ui.message("nursingkardex.kardexSlogan") }</span>
				</center>
				<br style="font-size:50px"/>
				
				<div style="font-size:13px;margin-left:320px">
					<a href="/${ ui.contextPath() }/images/endorsement_smaller.png" > <img src="/${ ui.contextPath() }/images/endorsement_smaller.png" width=""250px" height"170px" alt="nurse1" /></a><br/>
				</div>
				
				
			</td>
				<!-- BED NUMBER LIST -->
			<td style="width:60px;padding:0px;margin:0px;vertical-align:text-top">
				${ ui.includeFragment("nursingkardex", "display/bedNumberList") }
			</td>
		</tr>
	</table>
		
	
</div>

