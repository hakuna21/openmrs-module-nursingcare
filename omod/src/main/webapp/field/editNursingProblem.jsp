<openmrs:htmlInclude file="/scripts/calendar/calendar.js" />

<script type="text/javascript">
var numberOfClonedElements = 0;
var originalEncountersCount = ${fn:length(visitEncounters)};

function addProblem() {
	var index = originalEncountersCount+numberOfClonedElements;
	var row = document.getElementById('newProblemRow');
	var newrow = row.cloneNode(true);
	$j(newrow).show();
	newrow.id = '';
	var inputs = newrow.getElementsByTagName("input");
	for (var i = 0; i < inputs.length; i++) {
		var input = inputs[i];
		if(input && input.type == 'text' || input.type == 'hidden') {
			input.id = input.id.replace('[x]', '[' + index + ']');
			if(input.type == 'hidden')
				input.name = 'problemClassificationIds';
		}
	}
	row.parentNode.insertBefore(newrow, row);
	numberOfClonedElements++;
}

function removeProblem(obj){
	obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
}
</script>

	<h2>NURSING PROBLEM</h2>
	<br/>
	<form method="post" action="saveNursingProblem.form" modelAttribute="nursingProblemForm">

	<span>
		Date: 
			<spring:bind path="nursingProblemForm.date">
				<input type="text" id="scheduledDate" name="${status.expression}" size="20" value="${status.value}" onfocus="showCalendar(this)" />
				<c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
			</spring:bind> <br/>
		Shift: 
			<spring:bind path="nursingProblemForm.shift">
				<select name="${status.expression}">
					<option value="AM" <c:if test="${'AM' == status.value}">selected="selected"</c:if>>AM</option>
					<option value="PM" <c:if test="${'PM' == status.value}">selected="selected"</c:if>>PM</option>
					<option value="Night" <c:if test="${'Night' == status.value}">selected="selected"</c:if>>Night</option>
				</select>
				<c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
			</spring:bind>		
		<br/>
		<br/>
		Nursing Problems:<br/> 
			<table id="problemTable" cellpadding="3" cellspacing="3">
				<tr>
					<th>Problem</th>
					<th></th>
				</tr>
				<c:forEach items="${shiftProblems}" var="shift" varStatus="encStatus">
				<tr id="shift-${shift.id}" style='background-color: whitesmoke'>
					<td>${shift.problemClassification.name }</td>
					<td class="removeButtonColumn">
						<input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" onclick="removeProblem(this)" />
						<input type="hidden" name="problemClassificationIds" value="${shift.problemClassification.id}" />
					</td>
				</tr>
				</c:forEach>
				<tr id="newProblemRow" style="display:none;">
					<td colspan="4">
						<%-- make sure the text field is wide enough to show the placeholder message --%>
						<select name="problemClassificationIds">
							<option></option>
							<c:forEach items="${nursingProblems}" var="prob">
					        	<option value="${prob.id}">
					        		${prob.name}
					        	</option>
					        </c:forEach>
						</select>
					</td>
					<td class="removeButtonColumn">
						<input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" onclick="removeProblem(this)" />
					</td>
				</tr>
			</table>
			<input type="button" value='<openmrs:message code="Add Shift Problem"/>' class="smallButton" onclick='addProblem()' />
		<br/>
	</span>
	
	<span>
		<br/><br/>
			<spring:bind path="nursingProblemForm.patientCaseRecordId">
				<input type="hidden" name="patientCaseRecordId" value="<c:out value="${status.value}"/>">
				<c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
			</spring:bind>
			<button type="submit"><i class="fa  fa-floppy-o pghnc_save"></i></button>
			

	</span>
	
	</form>
	
