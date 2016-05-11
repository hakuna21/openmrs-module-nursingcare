<form:form method="post" action="saveNursingIntervention.form"
	modelAttribute="nursingInterventionForm">


<table border ="0">
	<tr>
		<td  width="400px" style="vertical-align:top;padding-right:40px">
		
		<h2>INTERVENTION</h2>
		
			<!-- TYPICAL NURSING INTERVENTION -->
			
			<table border="0">
				
				<tr>
					<td>Strict asepsis</td>
					<td>
						<form:input size="15" path="strictAsepsisInstruction" />
						<form:hidden path="strictAsepsisId" />
					</td>
				</tr>	
				<tr>
					<td>Keep thermoregulated</td>
					<td>
						<form:input size="15" path="keepThemoregulatedInstruction" />
						<form:hidden path="keepThemoregulatedId" />
					</td>
				</tr>	
				<tr>
					<td>TSB</td>
					<td>
						<form:input size="15" path="tepidSpongeBathInstruction" />
						<form:hidden path="tepidSpongeBathId" />
					</td>
				</tr>	
				<tr>
					<td>Bed bath</td>
					<td>
						<form:input size="15" path="bedBathInstruction" />
						<form:hidden path="bedBathId" />
					</td>
				</tr>
				<tr>
					<td>Hair shampoo</td>
					<td>
						<form:input size="15" path="hairShampooInstruction" />
						<form:hidden path="hairShampooId" />
					</td>
				</tr>
				<tr>
					<td>Nail care</td>
					<td>
						<form:input size="15" path="nailCareInstruction" />
						<form:hidden path="nailCareId" />
					</td>
				</tr>
				<tr>
					<td>Perineal care</td>
					<td>
						<form:input size="15" path="perinealCareInstruction" />
						<form:hidden path="perinealCareId" />
					</td>
				</tr>
				<tr>
					<td>Universal precaution</td>
					<td>
						<form:input size="15" path="universalPrecautionInstruction" />
						<form:hidden path="universalPrecautionId" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>CBR c TP</td>
					<td>
						<form:input size="15" path="cbrWithToiletInstruction" />
						<form:hidden path="cbrWithToiletId" />
					</td>
				</tr>
				<tr>
					<td>CBR s TP</td>
					<td>
						<form:input size="15" path="cbrWithoutToiletInstruction" />
						<form:hidden path="cbrWithoutToiletId" />
					</td>
				</tr>
				<tr>
					<td>
						Positioning
					</td>
					<td>
						<form:input size="15" path="positioningInstruction" />
						<form:hidden path="positioningId" />
					</td>	
				</tr>
				<tr>
					<td>Massage (bony prominences)</td>
					<td>
						<form:input size="15" path="massageBodyProminencesInstruction" />
						<form:hidden path="massageBodyProminencesId" />
					</td>
				</tr>
				<tr>
					<td>Cast care</td>
					<td>
						<form:input size="15" path="castCareInstruction" />
						<form:hidden path="castCareId" />
					</td>
				</tr>
				<tr>
					<td>Traction care</td>
					<td>
						<form:input size="15" path="tractionCareInstruction" />
						<form:hidden path="tractionCareId" />
					</td>
				</tr>
				<tr>
					<td>CDW</td>
					<td>
						<form:input size="15" path="changeWoundDressingInstruction" />
						<form:hidden path="changeWoundDressingId" />
					</td>
				</tr>
				<tr>
					<td>Burn (wound care) grade</td>
					<td>
						<form:input size="15" path="burnInstruction" />
						<form:hidden path="burnId" />
					</td>
				</tr>
				<tr>
					<td>Bedsore precaution <br/>
						<span style="font-size:8px">(+ turning, ROM, fall prevention)</span>
					</td>
					<td>
						<form:input size="15" path="bedsorePrecautionInstruction" />
						<form:hidden path="bedsorePrecautionId" />
					</td>
				</tr>
				<tr>
					<td>Pressure ulcer from: PGH</td>
					<td>
						<form:input size="15" path="pressureUlcerAcquiredFromThisHealthFacilityInstruction" />
						<form:hidden path="pressureUlcerAcquiredFromThisHealthFacilityId" /><br/> 
						
						
					</td>
				</tr>
				<tr>
					<td>&nbsp; &nbsp; &nbsp; other location</td>
					<td><form:input size="15" path="pressureUlcerAcquiredFromOtherLocationInstruction" />
						<form:hidden path="pressureUlcerAcquiredFromOtherLocationId" /></td>
				</tr>
			</table>
			
			<!--/ TYPICAL NURSING INTERVENTION -->
		</td>
		<td width="100px" style="vertical-align:text-top">
			<!-- O2 SUPPORT -->
			
			<br/><br/>
			<form:hidden path="oxygenationOrder.id" />
			<fieldset style="background:#f0f5f5">
			<table width="400px" border="0">
				<tr>
					<td style="vertical-align:text-top">O2: </td>
					<td>
						<form:select path="oxygenationSupportInstruction">
							<form:option value="" label="--- Not Applicable ---" />
							<form:options items="${oxygenSupports}" itemLabel="name.name" itemValue="id" /> &nbsp;&nbsp; @ <form:input size="2" path="oxygenationOrder.flowRateLiterPerMinute" />Lpm
						</form:select> <form:hidden path="oxygenationSupportId" /><br/>
						&nbsp; &nbsp; &nbsp;
							<form:input size="30" path="descriptionOfOxygenSupportInstruction" />
							<form:hidden path="descriptionOfOxygenSupportId" /> <br/>
						<form:checkbox path="oxygenationOrder.hasMechanicalVentilator" value="1"/>Mechanical Ventilator
					</td>
				</tr>
				<tr>
					<td colspan="2">	
					<table border="0">
							<tr>	
							<td width="75px">&nbsp;</td>
								<td>
						Type:</td>
								<td>
									<form:input size="8" path="oxygenationOrder.mechanicalVentilatorType" />
								</td>
								<td>Mode: </td>
								<td> <form:input size="8" path="oxygenationOrder.mode" /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>	
								<td>FiO2 (%):</td>
								<td><form:input size ="8" path="oxygenationOrder.fio2Percent" /></td>
								<td>TV(ml): </td>
								<td><form:input size="8" path="oxygenationOrder.tidalVolume" /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>PIP: </td>
								<td><form:input size="8" path="oxygenationOrder.pip" /></td>
								<td>PEEP</td>
								<td><form:input size="8" path="oxygenationOrder.peep" /></td>	
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>V.R.</td>
								<td><form:input  size="8" path="oxygenationOrder.ventilatorRate" /></td>
								<td>I:E</td>
								<td><form:input  size="8" path="oxygenationOrder.ieRatio" /></td>	
							</tr>
						</table>
						<table>
							<tr>
								<td><br/>Weaning</td>
								<td><br/>
									<form:input path="weaningInstruction" />
									<form:hidden path="weaningId" />
								</td>
							</tr>
							<tr>
								<td>Suctioning</td>
								<td>
									<form:input path="suctioningInstruction" />
									<form:hidden path="suctioningId" />
								</td>
							</tr>
							<tr>
								<td>Chest Physiotherapy</td>
								<td>
									<form:input path="chestPhysiotherapyInstruction" />
									<form:hidden path="chestPhysiotherapyId" />
								</td>
							</tr>
							<tr>
								<td>Tracheostomy Care</td>
								<td>
									<form:input path="tracheostomyCareInstruction" />
									<form:hidden path="tracheostomyCareId" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				
			</table>
			</fieldset>	
			<br/>
			<table border="0">
				<tr>
					<td>Health teaching</td>
					<td>
						<form:input size="15" path="healthTeachingInstruction" />
						<form:hidden path="healthTeachingId" />
					</td>
				</tr>
				<tr>
					<td>Relaxation measures</td>
					<td>
						<form:input size="15" path="relaxationMeasuresInstruction" />
						<form:hidden path="relaxationMeasuresId" />
					</td>
				</tr>
				<tr>
					<td>Restraining</td>
					<td>
						<form:input size="15" path="restrainingInstruction" />
						<form:hidden path="restrainingId" />
					</td>
				</tr>
				<tr>
					<td>SHEA precaution</td>
					<td>
						<form:input size="15" path="sheaPrecautionInstruction" />
						<form:hidden path="sheaPrecautionId" />
					</td>
				</tr>
				<tr>
					<td style="text-align:vertical-top">Others:</td>
					<td>
						<form:textarea id="others" path="otherInterventionInstruction" rows="1" cols="20" />
							<form:hidden path="otherInterventionId" />
							
					</td>
				</tr>
				<tr>
					<td>Level of Care:</td>
					<td><form:radiobuttons items="${levelOfCareOptions}" path="levelOfCare.levelOfCare" delimiter="     "/>
					<form:hidden path="levelOfCare.id" /></td>
				</tr>
			</table>
			<!--/ O2 SUPPORT -->
			<button type="submit" style="float:right"><i class="fa  fa-floppy-o pghnc_save"></i></button>
			 
		</td>
	</tr>
</table>
			

<form:hidden path="patientCaseRecordId"/>


</form:form>