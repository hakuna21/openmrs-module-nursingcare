
<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
	{ label: "Nursing Kardex", link: '/' + OPENMRS_CONTEXT_PATH + '/nursingkardex/nursingKardex.page' },
	{ label: "Patient List"}
	];	
</script>


<%@ include file="/WEB-INF/template/include.jsp" %>
<%@ include file="/WEB-INF/template/header.jsp" %>

<%@ include file="display/leftPanel.jsp"%>
<%@ include file="display/bedNumberList.jsp"%>


<div class="pghnc_frame">
<div>
<div>
	
	<table border="0" style="padding:0px;margin:0px">
		<tr>
			<td style="vertical-align:text-top">
				
				<form method="post" action="nurse.form" modelAttribute="nurse">
				<fieldset>
					<table border="0">
						<tr>
							<td>Available Provider:</td>
							<td>
								<c:choose>
									<c:when test="${not empty nurse.provider }">
										${nurse.provider.name }
									</c:when>
									<c:otherwise>
										<spring:bind path="nurse.provider.providerId">
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
							<td>Location:</td>
							<td>
								<spring:bind path="nurse.location.locationId">
									<select name="${status.expression}">
										<option></option>
										<c:forEach items="${locations}" var="loc">
								        	<option value="${loc.locationId}" <c:if test="${loc.locationId == status.value}">selected="selected"</c:if>>
								        		${loc.name}
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
								<spring:bind path="nurse.licenseNumber">
					                <input type="text" name="licenseNumber" value="${status.value}" size="35" />
					                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
					            </spring:bind>	
							</td>
						</tr>
						<tr>
							<td>Position:</td>
							<td>
								<spring:bind path="nurse.position">
					                <input type="text" name="position" value="${status.value}" size="35" />
					                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
					            </spring:bind>	
							</td>
						</tr>
						<tr>
							<td>Remarks:</td>
							<td>
								<spring:bind path="nurse.remarks">
					                <input type="text" name="remarks" value="${status.value}" size="35" />
					                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
					            </spring:bind>	
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="hidden" name="id" value="${nurse.id}" >
								<c:if test="${not empty nurse.provider }">
									<input type="hidden" name="providerId" value="${nurse.provider.providerId}" >
								</c:if>	
								<input type="submit" name="action" value="Save Nurse"/>
								<c:if test="${not empty nurse.id }">
									<input type="submit" name="action" value="Delete Nurse"/>
								</c:if>
							</td>							
						</tr>
					</table>
				</fieldset>
				</form>
						
			</td>
		</tr>
	</table>
	
	</div>
	</div>
</div>