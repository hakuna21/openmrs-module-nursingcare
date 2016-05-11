<table border="1" class="ncp_inside tabletop">
	<tr>
		<th width="100px" style="border-top-left-radius:20px"><b>Date/Shift <br/> <small>(Nursing Problem)</small></b></th>
		<th width="150px"><b>Parenteral Therapy</b></th>
		<th width="100px"><b>Intake</b></th>
		<th width="100px"><b>Output</b></th>
		<th width="100px"><b>Monitoring</b></th>
		<th width="200px"><b>Nursing Interventions</b></th>
		<th width="300px" style="border-top-right-radius:20px"><b>Others</b></th>
	</tr>
	<tr>
		<td style="border-bottom-left-radius:20px"><!--Date/Shift -->
			<!-- Date/Shift-->
				<openmrs:formatDate date="${shiftDate}" type="short" /> <br/> ${shift } 
				<br/>
				<br/>
			<!-- Diagnosis -->
			<c:forEach items="${shiftProblems}" var="shift" varStatus="encStatus">
				${shift.problemClassification.name } <br/>
			</c:forEach>	
		</td>
		<td>${endorsement.parenteral }</td>
		<td>${endorsement.intake }</td>
		<td>${endorsement.output }</td>
		<td>${endorsement.monitoring }</td>
		<td>${endorsement.nursingInterventions }</td>
		<td style="border-bottom-right-radius:20px">${endorsement.specialEndorsements }</td>
	</tr>
</table>

