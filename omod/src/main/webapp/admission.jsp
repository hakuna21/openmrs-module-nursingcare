<%@ include file="/WEB-INF/template/include.jsp" %>
<%@ include file="/WEB-INF/template/header.jsp" %>

<openmrs:htmlInclude file="/scripts/calendar/calendar.js" />

Admission Page <br/>

<c:choose>
	<c:when test="${empty patientCaseRecord }">
		<openmrs:portlet id="findPatient" url="findPatient" parameters="size=full|postURL=admission.form|showIncludeVoided=false|viewType=shortEdit" />
		<openmrs:extensionPoint pointId="org.openmrs.findPatient" type="html" />
	</c:when>
	<c:otherwise>
		<form method="post" action="admission.form" modelAttribute="patientCaseRecord">
		<fieldset>
			<table>
				<tr>
					<td>Name</td>
					<td>${patientCaseRecord.patient.personName.fullName} (${patientCaseRecord.patient.patientIdentifier})</td>
				</tr>
				<tr>
					<td>Birthdate</td>
					<td><openmrs:formatDate date="${patient.birthdate}" type="short" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>${patientCaseRecord.patient.gender }</td>
				</tr>
				<tr>
					<td>Status</td>
					<td>${patientCaseRecord.patient.attributeMap.get('Civil Status') }</td>
				</tr>
				<tr>
					<td>Nationality</td>
					<td>${patientCaseRecord.patient.attributeMap.get('Citizenship') }</td>
				</tr>
				<tr>
					<td>Address</td>
					<td>${patientCaseRecord.patient.personAddress.address1 } ${patientCaseRecord.patient.personAddress.address2 }
							${patientCaseRecord.patient.personAddress.cityVillage } 
							${patientCaseRecord.patient.personAddress.stateProvince } 
							${patientCaseRecord.patient.personAddress.country } 
							${patientCaseRecord.patient.personAddress.postalCode }</td>
				</tr>
				<%--
				<tr>
					<td>Educational Level</td>
					<td>${patientCaseRecord.patient.attributeMap.get('Educational Level') }</td>
				</tr>
				<tr>
					<td>Allergies</td>
					<td>????????????Will Trace?????????</td>
				</tr>
				<tr>
					<td>Blood Type</td>
					<td>????????????Wala ko makita?????????</td>
				</tr>
				 --%>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Case No</td>
					<td>
						<spring:bind path="patientCaseRecord.caseNumber">
			                <input type="text" name="caseNumber" value="${status.value}" size="35" />
			                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
			            </spring:bind>
					</td>
				</tr>
				<tr>
					<td>MSS Classification</td>
					<td>
						<spring:bind path="patientCaseRecord.mssClassification">
			                <input type="text" name="mssClassification" value="${status.value}" size="35" />
			                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
			            </spring:bind>
					</td>
				</tr>
				<tr>
					<td>MSS Card No</td>
					<td>
						<spring:bind path="patientCaseRecord.mssCardNumber">
			                <input type="text" name="mssCardNumber" value="${status.value}" size="35" />
			                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
			            </spring:bind>
					</td>
				</tr>
				<tr>
					<td>Location - Bed</td>
					<td>
						<spring:bind path="patientCaseRecord.latestPatientMovement.bed.id">
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
					<td>Diagnosis</td>
					<td>
						<spring:bind path="patientCaseRecord.admittingDiagnosis">
			                <input type="text" name="admittingDiagnosis" value="${status.value}" size="35" />
			                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
			            </spring:bind>
					</td>
				</tr>
				<tr>
					<td>Operation Remarks</td>
					<td>
						<spring:bind path="patientCaseRecord.operationRemarks">
			                <input type="text" name="operationRemarks" value="${status.value}" size="35" />
			                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
			            </spring:bind>
					</td>
				</tr>
				<tr>
					<td>Physician-in-charge</td>
					<td>
						<spring:bind path="patientCaseRecord.physicianInCharge.id">
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
			</table>
		
			<input type="submit" value="Save" name="save">
			<input type="hidden" name="patientId" value="${patientId }" />
		
		</fieldset>
		</form>
		
	</c:otherwise>
</c:choose>

<%@ include file="/WEB-INF/template/footer.jsp" %>