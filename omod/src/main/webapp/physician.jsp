<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/pgh_nursing.jsp"%>

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
	{ label: "Nursing Kardex", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/nursingKardex.page' },
	{ label: "Patient List"}
	];	
</script>

<%@ include file="display/leftPanel.jsp"%>
<%@ include file="display/bedNumberList.jsp"%>

<div class="pghnc_frame">
   <div>
      <div>
				<form method="post" action="physician.form" modelAttribute="physician">
				<fieldset>
					<table border="0">
						<tr>
							<td>Available Provider:</td>
							<td>
								<c:choose>
									<c:when test="${not empty physician.provider }">
										${physician.provider.name }
									</c:when>
									<c:otherwise>
										<spring:bind path="physician.provider.providerId">
											<select name="${status.expression}">
												<option></option>
												<c:forEach items="${providers}" var="provider">
										        	<option value="${provider.providerId}" <c:if test="${provider.providerId == status.value}">selected="selected"</c:if>>
										        		${provider.name}
										        	</option>
										        </c:forEach>
											</select>
											<c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
										</spring:bind>		
									</c:otherwise>
								</c:choose>
								
							</td>
						</tr>
						<tr>
							<td>Department:</td>
							<td>
								<spring:bind path="physician.physicianDepartment.id">
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
							<td>License Number:</td>
							<td>
								<spring:bind path="physician.licenseNumber">
					                <input type="text" name="licenseNumber" value="${status.value}" size="35" />
					                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
					            </spring:bind>	
							</td>
						</tr>
						<tr>
							<td>Position:</td>
							<td>
								<spring:bind path="physician.position">
					                <input type="text" name="position" value="${status.value}" size="35" />
					                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
					            </spring:bind>	
							</td>
						</tr>
						<tr>
							<td>Remarks:</td>
							<td>
								<spring:bind path="physician.remarks">
					                <input type="text" name="remarks" value="${status.value}" size="35" />
					                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
					            </spring:bind>	
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="hidden" name="id" value="${physician.id}" >
								<c:if test="${not empty physician.provider }">
									<input type="hidden" name="providerId" value="${physician.provider.providerId}" >
								</c:if>	
								<input type="submit" name="action" value="Save Physician"/>
								<c:if test="${not empty physician.id }">
									<input type="submit" name="action" value="Delete Physician"/>
								</c:if>
							</td>							
						</tr>
					</table>
				</fieldset>
				</form>
		
      </div>
   </div>
</div>   

<%@ include file="/WEB-INF/template/footer.jsp"%>