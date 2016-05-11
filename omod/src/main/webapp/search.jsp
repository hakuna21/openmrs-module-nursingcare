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
	<form method="post" action="search.form" modelAttribute="searchKardexObj">
					<h2>Patient Search</h2>
					
					
					<br/>
					<table border="0">
						<tr>
							<td>Name:</td>
							<td>
								<spring:bind path="searchKardexObj.name">
					                <input type="text" name="name" value="${status.value}" size="25" />
					                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
					            </spring:bind>
							</td>
						</tr>
						<tr>
							<td>Bed:</td>
							<td>
								<spring:bind path="searchKardexObj.bedId">
									<select name="${status.expression}">
										<option></option>
										<c:forEach items="${beds}" var="bed">
								        	<option value="${bed.id}" <c:if test="${bed.id == status.value}">selected="selected"</c:if>>
								        		${bed.location.name} - ${bed.roomName }
								        	</option>
								        </c:forEach>
									</select>
									<c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
								</spring:bind>	
							</td>
						</tr>
						<tr>
							<td>Department:</td>
							<td>
								<spring:bind path="searchKardexObj.physicianDepartmentId">
									<select name="${status.expression}">
										<option></option>
										<c:forEach items="${departments}" var="dept">
								        	<option value="${dept.id}" <c:if test="${dept.id == status.value}">selected="selected"</c:if>>
								        		${dept.name}
								        	</option>
								        </c:forEach>
									</select>
									<c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
								</spring:bind>		
							</td>
						</tr>
						<tr>
							<td>Physician:</td>
							<td>
								<spring:bind path="searchKardexObj.physicianId">
									<select name="${status.expression}">
										<option></option>
										<c:forEach items="${physicians}" var="phys">
								        	<option value="${phys.id}" <c:if test="${phys.id == status.value}">selected="selected"</c:if>>
								        		${phys.provider.name}
								        	</option>
								        </c:forEach>
									</select>
									<c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
								</spring:bind>	
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Submit"/></td>
						</tr>
					</table>
				
					<c:if test="${not empty results }">
						<table id="results">
							<tr class="header">
								<th>Name</th>
								<th>Bed</th>
								<th>Department</th>
								<th>Physician</th>
							</tr>
							<c:forEach items="${results}" var="res" varStatus="loop">
							<tr>
								<td><a href="viewKardex.page?patientCaseRecordId=${res.id }">${res.patient.personName.fullName }</a></td>
								<td>${res.latestPatientMovement.bed.roomName }</a></td>
								<td>${res.physicianInCharge.physicianDepartment.name }</td>
								<td>Dr. ${res.physicianInCharge.provider.name }</td>
							</tr>
							</c:forEach>
						</table>
					</c:if>	
				
				
	</form>
		
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>