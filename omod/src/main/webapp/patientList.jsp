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
<%@ include file="display/bedNumberList.jsp"%>

<div class="pghnc_frame">
	<div>
		<div>		
			<h2>Patient List</h2>
			
				<c:if test="${kardexView || nursingAdmin }">
				
					<br/>
					<table border="1" class="indicator">
						<tr class="header">
							<th width="200px">Patient Name</th>
							<th width="50px">Bed Number</th>
							<th width="150px">Department</th>
							<th width="200px">Physician</th>
						</tr>
						<c:forEach items="${patientCaseRecords}" var="res" varStatus="loop">
						<tr>
							<td><a href="viewKardex.page?patientCaseRecordId=${res.id }">${res.patient.personName.fullName }</a></td>
							<td>${res.latestPatientMovement.bed.roomName }</a></td>
							<td>${res.physicianInCharge.physicianDepartment.name }</td>
							<td>Dr. ${res.physicianInCharge.provider.name }</td>
						</tr>
						</c:forEach>
					</table>
				</c:if>
		</div>
	</div>			
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>