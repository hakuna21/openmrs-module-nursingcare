<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/pgh_nursing.jsp"%>
<!-- tag include file="template/font-awesome/try.jsp"%> -->
						

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ 			icon: "icon-home", link: '/openmrs/index.htm' },
	{ 			label: "Nursing Kardex" 			}
	];	
</script>

<%@ include file="display/leftPanel.jsp"%>

<div class="pghnc_frame">
   <div>
      <div>
	
	<h2>Care Plan</h2>

 		<c:if test="${kardexEdit }">


			<!-- PATIENT INFO -->
					<%@ include file="display/patientInfo.jsp"%>
				<br/>
				<br/>
			<a href="viewKardex.form?patientCaseRecordId=${patientCaseRecord.id }" >
			<i class="fa fa-file-o pghnc_edit"></i>
			</a>
		
		
	
  <!-- <link rel="stylesheet" href="template/jquery-ui_1_11_4.css">-->
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  
  <!--<script src="template/jquery-ui_1_11_4.js"></script>
  <script src="template/jquery-1.10.2.js"></script>-->
  <script>
  $(function() {
    $( "#tabs" ).tabs({
    });
  });
  </script>
		
		<div id="tabs" style="margin-left:30px;margin-right:130px;font-size:11px">
  <ul>
  	
    <li><a href="#tabs-1">Nursing Problem</a></li>
    <li><a href="#tabs-2">Parenteral</a></li>
    <li><a href="#tabs-3">Intake</a></li>
    <li><a href="#tabs-4">Output</a></li>
    <li><a href="#tabs-5">Monitoring</a></li>
    <li><a href="#tabs-6">Intervention</a></li>
    <li><a href="#tabs-7">Special Endorsement</a></li>
    <li>
	</li>
  </ul>
  <div id="tabs-1">
    	<%@ include file="field/editNursingProblem.jsp"%> 
  </div>
  <div id="tabs-2">
    	<%@ include file="field/editIVT.jsp"%>
  </div>
  <div id="tabs-3">
    	<%@ include file="field/editDiet.jsp"%>
  </div>
  <div id="tabs-4">
    	<%@ include file="field/editOutput.jsp"%>
  </div>
  <div id="tabs-5">
    	<%@ include file="field/editMonitoring.jsp"%>
  </div>
    <div id="tabs-6">
    	<%@ include file="field/editIntervention.jsp"%>
  </div>
  <div id="tabs-7">
    	<%@ include file="field/editProcedure.jsp"%> 
  </div>
  
</div>
		<br/>
		
		</c:if>
		
		</div>
	</div>
</div>


<div style="position:absolute;top:95px;right:10px;margin-right:0px">
	<%@ include file="display/bedNumberList.jsp"%>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>