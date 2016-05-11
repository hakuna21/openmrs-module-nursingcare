<%
 ui.decorateWith("appui", "standardEmrPage")
%>

<!--<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">-->
<!--<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>-->

<script  type="text/javascript" >
\$(document).ready(function(){
	    \$( "#tabs" ).tabs({
      event: "mouseover"
    });
	

	if ((\$('.firstcol span').length)>1)	{
		((\$('.firstcol span').eq((\$('.firstcol span').length)/2-1)).nextAll()).appendTo('.secondcol');
	}
	
	if ((\$('.firstcolIVT span').length)>1)	{
		((\$('.firstcolIVT span').eq((\$('.firstcolIVT span').length)/2-1)).nextAll()).appendTo('.secondcolIVT');
	}
	
	if ((\$('.firstcolDiet span').length)>1)	{
		((\$('.firstcolDiet span').eq((\$('.firstcolDiet span').length)/2-1)).nextAll()).appendTo('.secondcolDiet');
	}
	
	if ((\$('.firstcolOthers span').length)>1)	{
		((\$('.firstcolOthers span').eq((\$('.firstcolOthers span').length)/2-1)).nextAll()).appendTo('.secondcolOthers');
	}
	
	if ((\$('.firstcolOutput span').length)>1)	{
		((\$('.firstcolOutput span').eq((\$('.firstcolOutput span').length)/2-1)).nextAll()).appendTo('.secondcolOutput');
	}
	
	if ((\$('.firstcolIntervention span').length)>1)	{
		((\$('.firstcolIntervention span').eq((\$('.firstcolIntervention span').length)/2-1)).nextAll()).appendTo('.secondcolIntervention');
	}
 });
</script>



<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
	{ label: "Nursing Kardex", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/nursingKardex.page' },
	{ icon: "icon-file", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/viewKardex.page' },
	{ icon: "icon-pencil" }
	];	
	

</script>


<style type="text/css">
	#basicInfo td{
		background:#efe1ac;
	}
	
	#tabs-1, #tabs-2, #tabs-3, #tabs-4, #tabs-5, #tabs-6 {
	 	font-size:13.5px;background:#F1F8F5;color:#2E4C48;height:400px;
	}
	
	#tabs-7 {
	 	font-size:13.5px;background:#F1F8F5;color:#2E4C48;height:1100px;
	}
</style>

<!-- COLUMN -->

<style>
.firstcol{float:left;padding-left:100px;}
.secondcol{float:left;position:relative;top:-20px;padding-left:150px;}
span{font-size:12px}

.firstcolNursing{float:left;padding-left:100px;}
.secondcolNursing{float:left;position:relative;top:-20px;padding-left:150px;}

.firstcolIVT{float:left;padding-left:100px;}
.secondcolIVT{float:left;position:relative;top:-20px;padding-left:150px;}

.firstcolDiet{float:left;padding-left:100px;}
.secondcolDiet{float:left;position:relative;top:-20px;padding-left:150px;}

.firstcolOthers{float:left;padding-left:100px;}
.secondcolOthers{float:left;position:relative;top:-20px;padding-left:150px;}

.firstcolOutput{float:left;padding-left:100px;}
.secondcolOutput{float:left;position:relative;top:-20px;padding-left:150px;}

.firstcolIntervention{float:left;padding-left:100px;}
.secondcolIntervention{float:left;position:relative;top:-20px;padding-left:150px;}

</style>


<table border="0">
<tr>
	<td>
		${ ui.includeFragment("nursingkardex", "display/patientInfo") }  <br/>


		<!-- Date/Shift-->
		Date/Shift:  2014-01-03   (AM)
				
		<div style="margin-left:790px;margin-top:-28px">
		<a href="${ui.pageLink("nursingkardex", "viewKardex")}" class="button">
			<i class=icon-file></i>
		</a>
		</div>
		
		<div id="tabs" class="nkTable" style="font-size:13px">
		  <ul>
		    <li><a href="#tabs-1">Nursing Problem</a></li>
		    <li><a href="#tabs-2">Parenteral</a></li>
		    <li><a href="#tabs-3">Intake</a></li>
		    <li><a href="#tabs-4">Output</a></li>
		    <li><a href="#tabs-5">Monitoring</a></li>
		    <li><a href="#tabs-6">Nursing Interventions</a></li>
		    <li><a href="#tabs-7">Others</a></li>
		  </ul>
		  <div id="tabs-1" >
		  		<!--Parenteral Therapy -->
					${ ui.includeFragment("nursingkardex", "field/editNursingProblem") }
		  </div>
		  <div id="tabs-2" >
		  		<!--Parenteral Therapy -->
					${ ui.includeFragment("nursingkardex", "field/editIVT") }
		  </div>
		  <div id="tabs-3" >
		    	<!--Intake-->
					${ ui.includeFragment("nursingkardex", "field/editDiet") }
		  </div>
		  <div id="tabs-4">
		    	<!--Output-->
		    		${ ui.includeFragment("nursingkardex", "field/editOutput") }
		  </div>
		  <div id="tabs-5">
		  		<!--Monitoring-->
					${ ui.includeFragment("nursingkardex", "field/editMonitoring") }
		  </div>
		  <div id="tabs-6">
		    	<!-- Nursing Interventions -->
					${ ui.includeFragment("nursingkardex", "field/editIntervention") }
		  </div>
		  <div id="tabs-7">  
		    	<!--Others-->
					${ ui.includeFragment("nursingkardex", "field/editSpecialEndorsement") }
				<br/>
				<div style="width:400px">
		    	<!--Procedure -->
					${ ui.includeFragment("nursingkardex", "field/editProcedure") }
				</div>
		  </div>
		  
		
		</div>
	</td>
	<td  style="width:60px;padding:0px;margin:0px;vertical-align:text-top" >
		<!-- BED NUMBER LIST-->
		${ ui.includeFragment("nursingkardex", "display/bedNumberList") }
		<!-- /BED NUMBER LIST-->
	</td>
</tr>
</table>