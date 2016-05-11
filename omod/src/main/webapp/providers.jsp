<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/pgh_nursing.jsp"%>						

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ 			icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + 			'/index.htm' },
	{ 			label: "Nursing Kardex" 			}
	];	
</script>

<%@ include file="display/leftPanel.jsp"%>

<div class="pghnc_frame">
	<div>
		<div>		
		
		<h2>Providers</h2>
		
		<c:if test="${kardexEdit || nursingAdmin }">
		
					<br/>
				<script src="//code.jquery.com/jquery-1.10.2.js"></script>
			  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
			  <script>
			  $(function() {
			    $( "#tabs" ).tabs({
			    });
			  });
			  </script>										
				<div id="tabs"  style="margin-left:30px;margin-right:130px;font-size:11px">
			 
			 	<ul>
			 	<c:if test="${empty nurse }">
			    	<li><a href="#tabs-1">Nurses</a></li>
			    </c:if>
			    <li><a href="#tabs-2">Physicians</a></li>
			  </ul>
			  
					  <c:if test="${empty nurse }">
					  <div id="tabs-1" style="width:400px">
					  	<br/>
								<table border="1" class="indicator">
									<tr class="header">
										<th width="200px">Name of Nurse</th>
										<th width="150px">Location</th>
										<th width="150px">License Number</th>
										<th width="100px">Position</th>
										<th width="100px">Remarks</th>
									</tr>
									<c:forEach items="${nurses}" var="nurse" varStatus="loop">
									<tr>
										<td><a href="nurse.form?nurseId=${nurse.id }">${nurse.provider.name }</a></td>
										<td>${nurse.location.name }</td>
										<td>${nurse.licenseNumber }</td>
										<td>${nurse.position }</td>
										<td>${nurse.remarks }</td>
									</tr>
									</c:forEach>
									<tr>
										<td colspan="5" align="center">
											<b>Add New Nurse(s):</b><br/>
											<a href="nurse.form">from OpenMRS provider</a>
										</td>
									</tr>
									<tr>
										<td colspan="5" align="center" width="300px" style="overflow:scroll">
											<a href="migrateNurses.form">from RNPage (migration)</a><br/>
										</td>
									</tr>
								</table>
						  	</div>
						  	</c:if>
							  <div id="tabs-2">
							  <br/>
								<table border="1" class="indicator">
									<tr class="header">
										<th width="200px">Name of Physician</th>
										<th width="150px">Department</th>
										<th width="150px">License Number</th>
										<th width="100px">Position</th>
										<th width="100px">Remarks</th>
									</tr>
									<c:forEach items="${physicians}" var="phys" varStatus="loop">
									<tr>
										<td><a href="physician.form?physicianId=${phys.id }">Dr. ${phys.provider.name }</a></td>
										<td>${phys.physicianDepartment.name }</td>
										<td>${phys.licenseNumber }</td>
										<td>${phys.position }</td>
										<td>${phys.remarks }</td>
									</tr>
									</c:forEach>
									<tr>
										<td colspan="5" align="center">
											<a href="physician.form"><b>Add New Physician</b></a>
										</td>
									</tr>
								</table>
								<br/>
				 			 </div>
						 
    				</div>				
		
			</c:if>
		
		</div>
	</div>
</div>

<div style="position:absolute;top:95px;right:10px;margin-right:0px">
	<%@ include file="display/bedNumberList.jsp"%>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>