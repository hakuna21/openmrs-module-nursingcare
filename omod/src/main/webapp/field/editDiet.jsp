<!-- DIET -->

<form:form method="post" action="saveDiet.form" modelAttribute="dietForm">

<table border="0" class="tabletop">
	<tr>
		<td width="380px">
			<!-- Diet Type -->
				<h2>DIET</h2>
				<form:radiobuttons items="${dietTypeConcepts}" path="dietTypes" itemLabel="name.name" itemValue="id" delimiter="<br/>"/>
				<br/>
				<br/>
				<table>
					<tr>
						<td colspan="5"><h4>Requirement:</h4></td>
					</tr>
					<tr>
						<td>Cal</td><td>CHO</td><td>CHON</td><td>Fats</td><td>Na</td>
					</tr>
					<tr>
						<td><form:input size="5" id="cal" path="dietOrderRequirement.calories" /></td>
						<td><form:input size="5" id="carb" path="dietOrderRequirement.carbohydrates" /></td>
						<td><form:input size="5" id="prot" path="dietOrderRequirement.protein" /></td>
						<td><form:input size="5" id="fat" path="dietOrderRequirement.fats" /></td>
						<td><form:input size="5" id="sod" path="dietOrderRequirement.sodium" /></td>
					</tr>
					<tr>
						<td colspan="5"><h4>TPN Preparation:</h4></td>
					</tr>	
					<tr>
						&nbsp;<td colspan="5"><form:textarea id="tpn" path="dietOrderRequirement.tpn" rows="1" cols="34" />
						</td>
					</tr>	
					<tr>
						<td>H20 (ml)</td><td>Dextrose</td><td>Amino A.</td><td>Lipids</td><td>NaCl</td>
					</tr>
					<tr>
						<td><form:input size="5" id="sterileWaterMl" path="dietOrderRequirement.sterileWaterMl" /></td>
						<td><form:input size="5" id="dextrose" path="dietOrderRequirement.dextrose" /></td>
						<td><form:input size="5" id="aminoAcids" path="dietOrderRequirement.aminoAcids" /></td>
						<td><form:input size="5" id="lipids" path="dietOrderRequirement.lipids" /></td>
						<td><form:input size="5" id="sodiumChloride" path="dietOrderRequirement.sodiumChloride" /></td>
					</tr>
					<tr>
						<td>Ca Gluc.</td><td>Mg SO4</td><td>MVT</td><td>Insulin</td><td>Fluid Req.(ml/kg)</td>
					</tr>
					<tr>
						<td><form:input size="5" id="calciumGluconate" path="dietOrderRequirement.calciumGluconate" /></td>
						<td><form:input size="5" id="magnesiumSulfate" path="dietOrderRequirement.magnesiumSulfate" /></td>
						<td><form:input size="5" id="multivitamins" path="dietOrderRequirement.multivitamins" /></td>
						<td><form:input size="5" id="insulin" path="dietOrderRequirement.insulin" /></td>
						<td><form:input size="5" id="fluidRequirementMlPerKg" path="dietOrderRequirement.fluidRequirementMlPerKg" /></td>
					</tr><tr>
						<td>Total Vol.</td><td>Order</td><td>Indication</td><td>Duration</td><td>Requested by</td>
					</tr>
					<tr>
						<td><form:input size="5" id="totalVolume" path="dietOrderRequirement.totalVolume" /></td>
						<td><form:input size="5" id="orderType" path="dietOrderRequirement.orderType" /></td>
						<td><form:input size="5" id="indication" path="dietOrderRequirement.indication" /></td>
						<td><form:input size="5" id="duration" path="dietOrderRequirement.duration" /></td>
						<td><form:input size="5" id="requestedBy" path="dietOrderRequirement.requestedBy" /></td>
					</tr>
				</table>
				
				
			<!--/ Diet Type -->
		</td>
		<td width="380px">
			<!-- Diet Instruction -->
			
				<h4>Route:</h4>
				<form:checkboxes items="${dietRoutes}" path="dietRoutes" itemLabel="name.name" itemValue="id" delimiter="<br/>"/>
				
				<br/>
				<br/>
				<h4>Instruction</h4>
				<form:checkboxes items="${dietaryInstructions}" path="dietInstructions" itemLabel="name.name" itemValue="id" delimiter="<br/>"/>
				<br/>
				Fluid Restriction (ml): 
							<form:input id="fluid" path="dietOrderRequirement.fluidRestrictionMl" />					
				<br/>
				Others:<br/>
				<form:textarea id="others" path="othersInstruction" rows="1" cols="25" />
				<form:hidden path="othersId" /> 			
			<!--/ Diet Instruction -->			
				<br/>
				<button type="submit" style="float:right"><i class="fa  fa-floppy-o pghnc_save"></i></button>
				
		</td>
	</tr>
</table>







<!-- <br/><br/> -->
<!-- Instruction: -->
<!-- <textarea name="dietInstruction" rows="1" cols="10"></textarea> -->

<spring:bind path="dietForm.patientCaseRecordId">
	<input type="hidden" name="patientCaseRecordId" value="<c:out value="${status.value}"/>">
	<c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
</spring:bind>
<form:hidden path="dietOrderRequirement.id"/>

	
</form:form>