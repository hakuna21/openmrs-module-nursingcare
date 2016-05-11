<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/pgh_nursing.jsp"%>	

<openmrs:htmlInclude file="/scripts/timepicker/timepicker.js" />				

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ 			icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + 			'/index.htm' },
	{ 			label: "Nursing Kardex" 			}
	];	
</script>

<%@ include file="display/leftPanel.jsp"%>
<%@ include file="display/bedNumberList.jsp"%>

<form:form method="post" action="patientMovement.form" modelAttribute="patientMovement">

<div class="pghnc_frame">
	<div>
		<div>		
			<h2>Patient Movement</h2>
			
				<c:if test="${kardexEdit }">
				
					<br/>
					<table border="1" class="indicator">
						<tr><td>Patient:</td>
							<td>
								<form:select path="patientCaseRecord.id">
									<form:option value="" label="--- Select ---" />
									<form:options items="${patientCaseRecords}" itemLabel="patient.personName.fullName" itemValue="id" />
								</form:select> 
							</td>
						</tr>
						<tr><td>Movement type:</td>
							<td><!-- Movement type options -->
								<table>
									<tr>
									<td>
										<form:radiobutton path="encounterType.encounterTypeId" id="outpatient" value="7" /> 
										Transfer to:
											<form:select path="bed.id">
												<form:option value="" label="--- Not Applicable ---" />
												<c:forEach var="bed" items="${beds}">
											        <form:option value="${bed.id}">${bed.location.name} - Room ${bed.roomName}</form:option>
											    </c:forEach>
											</form:select>
										</td>
									</tr>
									
									<tr>
										<td>
											<form:radiobutton path="encounterType.encounterTypeId" id="discharge" value="9"/> Rooming-in 
											<form:select path="bed.id">
												<form:option value="" label="--- Not Applicable ---" />
												<c:forEach var="bed" items="${beds}">
											        <form:option value="${bed.id}">${bed.location.name} - Room ${bed.roomName}</form:option>
											    </c:forEach>
											</form:select>
										</td>
									</tr>
									<tr>
										<td>
											<form:radiobutton path="encounterType.encounterTypeId" id="outOnPass" value="15"/> Out on Pass
										</td>
									</tr>
									<tr>
										<td>
											<form:radiobutton path="encounterType.encounterTypeId" id="discharge" value="3"/>  Discharged
										</td>
									</tr>
									<tr>
										<td>
											<form:radiobutton path="encounterType.encounterTypeId" id="discharge" value="10"/> 
											Transfer to other hospital/health facility 
										</td>
									</tr>
									<tr>
										<td>
											<form:radiobutton path="encounterType.encounterTypeId" id="discharge" value="11"/> Home against Medical Advice
										</td>
									</tr>
									<tr>
										<td>
											<form:radiobutton path="encounterType.encounterTypeId" id="discharge" value="12"/> Absconded
										</td>
									</tr>
									<tr>
										<td>
											<form:radiobutton path="encounterType.encounterTypeId" id="discharge" value="13"/> Mortality
										</td>
									</tr>
									<tr>
										<td>
											<form:radiobutton path="encounterType.encounterTypeId" id="discharge" value="14"/> Home Per Request
										</td>
									</tr>	
								</table>
							</td>
						</tr>
						<tr>
							<td>Remarks:</td>
							<td><form:textarea id="remarks" path="remarks" rows="2" cols="50" /></td>
						</tr>
						<tr>
							<td>Date:</td>
							<td>
								<form:input path="movementDatetime" onfocus="showDateTimePicker(this)" />
							</td>	
						</tr>		
						<tr>
							<td>Shift:</td>
							<td>
								<form:select path="movementShift">
									<form:option value="" label="--- Select ---" />
									<form:options items="${shifts}" />
								</form:select> 
							</td>	
						</tr>		
					</table>
					<br/>
					<center><input type="submit" value="Save" /></center>
					<br/>
				</c:if>
		</div>
	</div>			
</div>

</form:form>

<%@ include file="/WEB-INF/template/footer.jsp"%>