<openmrs:htmlInclude file="/scripts/calendar/calendar.js" />

<script type="text/javascript">
var numberOfClonedElementsLab = 0;
var numberOfClonedElementsProc = 0;
var numberOfClonedElementsOthers = 0;
var numberOfClonedElementsOperation = 0;

function addLab() {
	var index = numberOfClonedElementsLab;
	var row = document.getElementById('newLabRow');
	var newrow = row.cloneNode(true);
	newrow.style.display = "";		
	newrow.id = 'laboratories[' + index + ']';
	row.parentNode.insertBefore(newrow, row);
	var inputs = newrow.getElementsByTagName("input");
	var selects = newrow.getElementsByTagName("select");
	var textareas = newrow.getElementsByTagName("textarea");
	for (var i in selects) {
		var select = selects[i];
		if (select && select.name == "labConceptId") {					
			select.name = 'laboratories[' + index + '].procedureConcept.id';
		}else if (select && select.name == "labScheduleStatus") {
			select.name = 'laboratories[' + index + '].scheduleStatus';
		}
	}
	
	for (var x = 0; x < inputs.length; x++) {
		var input = inputs[x];
		if (input && input.name == 'labDateSchedule' && input.type == 'text') {
			input.name = 'laboratories[' + index + '].dateSchedule';
		}
		else if (input && input.name == 'existingLabs[x]' && input.type == 'hidden') {
			input.name = input.name.replace('x', index);
		}
	}

	for (var x = 0; x < textareas.length; x++) {
		var textarea = textareas[x];
		if (textarea.name == 'laboratoryRemarks') {
			textarea.name = 'laboratories[' + index + '].remarks';
		}	
	}

	numberOfClonedElementsLab++;
}

function removeLab(obj){
	obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
}

function addProcedure() {
	var index = numberOfClonedElementsProc;
	var row = document.getElementById('newProcedureRow');
	var newrow = row.cloneNode(true);
	newrow.style.display = "";		
	newrow.id = 'procedures[' + index + ']';
	row.parentNode.insertBefore(newrow, row);
	var inputs = newrow.getElementsByTagName("input");
	var selects = newrow.getElementsByTagName("select");
	var textareas = newrow.getElementsByTagName("textarea");
	for (var i in selects) {
		var select = selects[i];
		if (select && select.name == "procedureConceptId") {					
			select.name = 'procedures[' + index + '].procedureConcept.id';
		}else if (select && select.name == "procScheduleStatus") {
			select.name = 'procedures[' + index + '].scheduleStatus';
		}
	}
	
	for (var x = 0; x < inputs.length; x++) {
		var input = inputs[x];
		if (input && input.name == 'procDateSchedule' && input.type == 'text') {
			input.name = 'procedures[' + index + '].dateSchedule';
		}
		else if (input && input.name == 'existingProcedures[x]' && input.type == 'hidden') {
			input.name = input.name.replace('x', index);
		}
	}

	for (var x = 0; x < textareas.length; x++) {
		var textarea = textareas[x];
		if (textarea.name == 'procRemarks') {
			textarea.name = 'procedures[' + index + '].remarks';
		}	
	}

	numberOfClonedElementsProc++;
}

function removeProcedure(obj){
	obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
}

function addOthers() {
	var index = numberOfClonedElementsOthers;
	var row = document.getElementById('newOthersRow');
	var newrow = row.cloneNode(true);
	newrow.style.display = "";		
	newrow.id = 'others[' + index + ']';
	row.parentNode.insertBefore(newrow, row);
	var inputs = newrow.getElementsByTagName("input");
	var selects = newrow.getElementsByTagName("select");
	var textareas = newrow.getElementsByTagName("textarea");

	for (var i in selects) {
		var select = selects[i];
		if (select && select.name == "othersProcScheduleStatus") {
			select.name = 'others[' + index + '].scheduleStatus';
		}
	}
		
	for (var x = 0; x < inputs.length; x++) {
		var input = inputs[x];
		if (input && input.name == 'othersProcDateSchedule' && input.type == 'text') {
			input.name = 'others[' + index + '].dateSchedule';
		} else if (input && input.name == 'procedureName' && input.type == 'text') {
			input.name = 'others[' + index + '].procedureName';
		}
		else if (input && input.name == 'othersProcs[x]' && input.type == 'hidden') {
			input.name = input.name.replace('x', index);
		}
	}

	for (var x = 0; x < textareas.length; x++) {
		var textarea = textareas[x];
		if (textarea.name == 'othersProcRemarks') {
			textarea.name = 'others[' + index + '].remarks';
		}	
	}

	numberOfClonedElementsOthers++;
}

function removeOthers(obj){
	obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
}

function addOperation() {
	var index = numberOfClonedElementsOperation;
	var row = document.getElementById('newOperationRow');
	var newrow = row.cloneNode(true);
	newrow.style.display = "";		
	newrow.id = 'operations[' + index + ']';
	row.parentNode.insertBefore(newrow, row);
	var inputs = newrow.getElementsByTagName("input");
	var selects = newrow.getElementsByTagName("select");
	var textareas = newrow.getElementsByTagName("textarea");
	
	for (var i in selects) {
		var select = selects[i];
		if (select && select.name == "operationScheduleStatus") {
			select.name = 'operations[' + index + '].scheduleStatus';
		}
	}
	
	for (var x = 0; x < inputs.length; x++) {
		var input = inputs[x];
		if (input && input.name == 'operationDateSchedule' && input.type == 'text') {
			input.name = 'operations[' + index + '].dateSchedule';
		}
		else if (input && input.name == 'existingOperations[x]' && input.type == 'hidden') {
			input.name = input.name.replace('x', index);
		} else if (input && input.name == 'priority' && input.type == 'checkbox') {
			input.name = 'operations[' + index + '].priority';
		}
	}

	for (var x = 0; x < textareas.length; x++) {
		var textarea = textareas[x];
		if (textarea.name == 'operationRemarks') {
			textarea.name = 'operations[' + index + '].remarks';
		} else if (textarea.name == 'operationName') {
			textarea.name = 'operations[' + index + '].operationName';
		}
	}

	numberOfClonedElementsOperation++;
}

function removeOperation(obj){
	obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
}
</script>

<h2>OTHER ENDORSEMENTS</h2>

<form:form method="post" action="saveProcedure.form" modelAttribute="procedureForm">

<fieldset style="background:#f0f5f5">
	
<table border="0" class="tabletop">
	<tr>
		<th style="text-align:left;padding-right:50px" width="330px"><h4>NAME</h4></th>
		<th style="text-align:left" width="180px"><h4>SCHEDULE</h4></th>
		<th style="text-align:left" width="100px"><h4>STATUS</h4></th>
		<th style="text-align:left" width="200px"><h4>REMARKS</h4></th>
	</tr>
	<!-- 
	<tr>
		<td colspan="4"><h4>Diagnostic Tests</h4></td>
	</tr>
	 -->
	<!-- LABORATORIES -->
	
	
	<c:forEach items="${patientLabs}" var="lab" varStatus="labStat">
		<tr>
			<td>${lab.procedureConcept.name.name } </td>
			<td><openmrs:formatDate date="${lab.dateSchedule }" type="short" /> </td>
			<td>${lab.scheduleStatus } </td>
			<td>${lab.remarks } </td>
			<td class="removeButtonColumn">
				<input type="hidden" name="existingLabs[${labStat.index }]" value="${lab.id }" />
				<input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" 
					onClick="javascript:this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode)" />
			</td>
		</tr>
	</c:forEach>
	<tr id="newLabRow" style="display:none;">
		<td>
			<select name="labConceptId">
				<option></option>
				<c:forEach items="${laboratoryConcepts}" var="lab">
		        	<option value="${lab.id}">
		        		${lab.name.name}
		        	</option>
		        </c:forEach>
			</select>
		</td>
		<td><input type="text" name="labDateSchedule" onfocus="showCalendar(this)" />
		</td>
		<td>
			<select name="labScheduleStatus">
				<option></option>
				<c:forEach items="${procedureStatuses}" var="stat">
		        	<option value="${stat.key}">
		        		${stat.value}
		        	</option>
		        </c:forEach>
			</select>
		</td>
		<td><textarea name="laboratoryRemarks" rows="1" cols="18"></textarea>
		</td>
		<td class="removeButtonColumn">
			<input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" onclick="removeLab(this)" />
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="Add Laboratory" class="smallButton" onclick='addLab()'/>
			
		</td>
	</tr>
	
	
	<!-- PROCEDURES -->
	<c:forEach items="${patientProcedures}" var="proc" varStatus="procStat">
		<tr>
			<td>${proc.procedureConcept.name.name } </td>
			<td><openmrs:formatDate date="${proc.dateSchedule }" type="short" /> </td>
			<td>${proc.scheduleStatus } </td>
			<td>${proc.remarks } </td>
			<td class="removeButtonColumn">
				<input type="hidden" name="existingProcedures[${procStat.index }]" value="${proc.id }" />
				<input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" 
					onClick="javascript:this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode)" />
			</td>
		</tr>
	</c:forEach>
	<tr id="newProcedureRow" style="display:none;">
		<td><select name="procedureConceptId">
				<option></option>
				<c:forEach items="${procedures}" var="proc">
		        	<option value="${proc.id}">
		        		${proc.name.name}
		        	</option>
		        </c:forEach>
			</select>
		</td>
		<td><input type="text" name="procDateSchedule" onfocus="showCalendar(this)" />
		</td>
		<td>
			<select name="procScheduleStatus">
				<option></option>
				<c:forEach items="${procedureStatuses}" var="stat">
		        	<option value="${stat.key}">
		        		${stat.value}
		        	</option>
		        </c:forEach>
			</select>
		</td>
		<td><textarea name="procRemarks" rows="1" cols="18"></textarea>
		</td>
		<td class="removeButtonColumn">
			<input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" onclick="removeProcedure(this)" />
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="Add Procedure" class="smallButton" onclick='addProcedure()'/>
			
		</td>
	</tr>
	
	<!-- OPERATIONS -->
	<!-- 
	<tr>
		<td colspan="4"><br/>
			<h4>Operation</h4>
		</td>
	</tr>
	 -->
	<c:forEach items="${patientOperations}" var="oper" varStatus="operStat">
		<tr>
			<td>
				${oper.operationName } 
				<c:choose>
					<c:when test="${empty oper.priority}">
						(Non-Emergency)
					</c:when>
					<c:otherwise>
						(${oper.priority })
					</c:otherwise>
				</c:choose>
			</td>
			<td><openmrs:formatDate date="${oper.dateSchedule }" type="short" /> </td>
			<td>${oper.scheduleStatus } </td>
			<td>${oper.remarks } </td>
			<td class="removeButtonColumn">
				<input type="hidden" name="existingOperations[${operStat.index }]" value="${oper.id }" />
				<input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" 
					onClick="javascript:this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode)" />
			</td>
		</tr>
	</c:forEach>
	<tr id="newOperationRow" style="display:none;">
		<td><textarea name="operationName" rows="1" cols="20"></textarea>
			<br/><input type="checkbox" name="priority" value="Emergency"/>Emergency
		</td>
		<td><input type="text" name="operationDateSchedule" onfocus="showCalendar(this)" />
		</td>
		<td>
			<select name="operationScheduleStatus">
				<option></option>
				<c:forEach items="${procedureStatuses}" var="stat">
		        	<option value="${stat.key}">
		        		${stat.value}
		        	</option>
		        </c:forEach>
			</select>
		</td>
		<td><textarea name="operationRemarks" rows="1" cols="18"></textarea>
		</td>
		<td class="removeButtonColumn">
			<input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" onclick="removeOperation(this)" />
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="Add Operation" class="smallButton" onclick='addOperation()'/>
			
		</td>
	</tr>
	
	<!-- OTHER PROCEDURES -->
	<c:forEach items="${patientOtherProcedures}" var="other" varStatus="otherStat">
		<tr>
			<td>${other.procedureName } </td>
			<td><openmrs:formatDate date="${other.dateSchedule }" type="short" /> </td>
			<td>${other.scheduleStatus } </td>
			<td>${other.remarks } </td>
			<td class="removeButtonColumn">
				<input type="hidden" name="existingOthers[${otherStat.index }]" value="${other.id }" />
				<input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" 
					onClick="javascript:this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode)" />
			</td>
		</tr>
	</c:forEach>
	<tr id="newOthersRow" style="display:none;">
		<td><input type="text" name="procedureName" />		
		</td>
		<td><input type="text" name="othersProcDateSchedule" onfocus="showCalendar(this)" />
		</td>
		<td>
			<select name="othersProcScheduleStatus">
				<option></option>
				<c:forEach items="${procedureStatuses}" var="stat">
		        	<option value="${stat.key}">
		        		${stat.value}
		        	</option>
		        </c:forEach>
			</select>
		</td>
		<td><textarea name="othersProcRemarks" rows="1" cols="18"></textarea>
		</td>
		<td class="removeButtonColumn">
			<input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" onclick="removeOthers(this)" />
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="Add Others" class="smallButton" onclick='addOthers()'/>
		
		</td>
	</tr>
	
</table>
</fieldset>
<br/>


<table>
	<tr>
		<td style="padding-right:50px">
			<table class="tabletop">
				<tr>
					<td>Referral to: Newborn Screener</td>
					<td>
						<form:input id="referralToNewbornScreener" path="referralToNewbornScreenerInstruction" />
						<form:hidden path="referralToNewbornScreenerId" />
					</td>
				</tr>
				<tr>
					<td style="padding-left:70px">Enterostomal Nurse</td>
					<td>
						<form:input id="referralToEnterostomalNurse" path="referralToEnterostomalNurseInstruction"/>
						<form:hidden path="referralToEnterostomalNurseId" />
					</td>	
				</tr>
				<tr>
					<td style="padding-left:70px">DM Educator</td>
					<td>
						<form:input id="referralToDiabetesMellitusEducator" path="referralToDiabetesMellitusEducatorInstruction"/>
						<form:hidden path="referralToDiabetesMellitusEducatorId" />
					</td>
				</tr>
				</tr>
				<tr>
					<td style="padding-left:70px">Priest, Pastor, etc.</td>
					<td>
						<form:input id="referralToSpiritualMinister" path="referralToSpiritualMinisterInstruction"/>
						<form:hidden path="referralToSpiritualMinisterId" />
					</td>
				</tr>
				<tr>
					<td style="padding-left:70px">Psychologist/Psychiatrist</td>
					<td>
						<form:input id="referralToPsychologistOrPsychiatrist" path="referralToPsychologistOrPsychiatristInstruction"/>
						<form:hidden path="referralToPsychologistOrPsychiatristId" />
					</td>
				</tr>
				<tr>
					<td>Counseling (grieving measures)</td>
					<td>
						<form:input id="grievingMeasures" path="grievingMeasuresInstruction"/>
						<form:hidden path="grievingMeasuresId" />
					</td>
				</tr>
				<tr>
					<td>Code</td>
					<td>
						<form:input id="code" path="codeInstruction"/>
						<form:hidden path="codeId" />
					</td>
				</tr>
				<tr>
					<td>Post-mortem care</td>
					<td>
						<form:input id="postMortemCare" path="postMortemCareInstruction"/>
						<form:hidden path="postMortemCareId" />
					</td>
				</tr>
				<tr>
					<td>Terminal Cleaning</td>
					<td>					
						<form:input id="terminalCleaning" path="terminalCleaningInstruction"/>
						<form:hidden path="terminalCleaningId" />
					</td>
				</tr>
				<tr>
					<td>5s</td>
					<td>
						<form:input id="fiveS" path="fiveSInstruction"/>
						<form:hidden path="fiveSId" />
					</td>
				</tr>
			</table>
		</td>
		<td>
			
				
			<!-- OTHERS -->
			<form:checkbox path="delivery" id="delivery" /> Sent to labor room or delivery room
			<br/><br/>
			
			Others:<br/>
			<form:textarea id="others" path="otherEndorsementInstruction" rows="2" cols="20" />
			<form:hidden path="otherEndorsementId" /> 
			<br/>
			<br/>
			<button type="submit" style="float:right"><i class="fa  fa-floppy-o pghnc_save"></i></button>		
		</td>
	</tr>
</table>
<br/>
<br/>

<form:hidden path="patientCaseRecordId"/>

</form:form>