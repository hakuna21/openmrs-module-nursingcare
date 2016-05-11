	<table border="0" class="inside_table">
	
		<tr>
			<th width="300px" style=""><span>Name:</span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style="text-transform: uppercase;">${patientCaseRecord.patient.personName.fullName }</b> </th>
			<th width="210px"><span>Age:</span>
				 &nbsp;&nbsp;${patientCaseRecord.patient.age } (<openmrs:formatDate date="${patientCaseRecord.patient.birthdate}" type="short" />)</th>
			<th width="130px"><span>Status:</span>
				&nbsp;&nbsp;${patientCaseRecord.patient.attributeMap.get('Civil Status') } </th>
			<th width="190px"><span>Gender:</span>
				&nbsp;&nbsp;${patientCaseRecord.patient.gender } </th>
			<th width="170px"><span>Nationality:</span>
				 &nbsp;&nbsp;${patientCaseRecord.patient.attributeMap.get('Citizenship') } </th>
		</tr>
		<tr>
			<td colspan="2" >
				<span>Address:</span>&nbsp;&nbsp;&nbsp;
					${patientCaseRecord.patient.personAddress.address1 } ${patientCaseRecord.patient.personAddress.address2 }
					${patientCaseRecord.patient.personAddress.cityVillage } 
					${patientCaseRecord.patient.personAddress.stateProvince } 
					${patientCaseRecord.patient.personAddress.country } 
					${patientCaseRecord.patient.personAddress.postalCode } 
			</td>
			<td><span>Religion:</span>&nbsp;&nbsp;&nbsp;
			</td>
			<td><span>Educational Level:</span>&nbsp;&nbsp; 
				${patientCaseRecord.patient.attributeMap.get('Educational Level') }
			</td>
			<td><span>Occupation:</span>&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td><span>Area:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				${patientCaseRecord.latestPatientMovement.bed.location.name }
			</td>
			<td><span>Bed:</span>&nbsp;&nbsp;
			 	${patientCaseRecord.latestPatientMovement.bed.roomName }
			 </td>
			<td colspan="2"><span>Department:</span>&nbsp;&nbsp;
				${patientCaseRecord.physicianInCharge.physicianDepartment.name }
			</td>
			<td>
				<span>Date Admitted:</span>&nbsp;&nbsp;
				<openmrs:formatDate date="${patientCaseRecord.datetimeAdmitted}" type="short" />
			</td> 
		</tr>
		<tr>
			<td colspan="5">
				<span>Diagnosis:</span>&nbsp;
				${patientCaseRecord.admittingDiagnosis }</td>
		</tr>
		<tr>
			<td colspan="5">
				<span>Operation:</span>&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<span>Allergies:</span>&nbsp;&nbsp;<i class="warn">
				
				</i>
			</td>
			<td colspan="2">
				<span>Blood Type:</span>&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
		<tr>
			<td colspan="2"><span>RIC/ Consultant:</span>
			&nbsp;&nbsp;&nbsp; Dr. ${patientCaseRecord.physicianInCharge.provider.name }</td>
			<td><span>Case #:</span>${patientCaseRecord.caseNumber }</td>
			<td><span>MSS Classification:</span>${patientCaseRecord.mssClassification }</td>
			<td><span>MSS Card #:</span>${patientCaseRecord.mssCardNumber }</td>
		</tr>
</table>
			
			
		</tr>
	</table>
	