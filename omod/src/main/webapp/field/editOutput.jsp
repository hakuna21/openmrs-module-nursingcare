<form:form method="post" action="saveOutput.form"
	modelAttribute="outputForm">

<h2>OUTPUT</h2>

<table border="0" class="tabletop">
	<tr>
		<td width="350px">
			<!-- Output Monitoring -->
			<table border="0">
				<tr>
					<td>I & O Monitoring</td>
					<td>
						<form:select path="ioMonitoringInstruction">
							<form:option value="" label="--- Not Applicable ---" />
							<form:options items="${monitoringSelect1}" />
						</form:select> <form:hidden path="ioMonitoringId" />
					</td>	
				</tr>
				<tr>
					<td>Strict I & O</td>
					<td>
						<form:input id="strictIO" path="strictIOInstruction" />
						<form:hidden path="strictIOId" />
					</td>	
				</tr>
				<tr>
					<td>Refer for: <br/>oliguria</td>
					<td><br/>
						<form:input id="referForOliguria" path="referForOliguriaInstruction" />
						<form:hidden path="referForOliguriaId" />
					</td>
				</tr>
			</table>	
			
			<!--/ Output Monitoring -->
		</td>
		<td>
			<!-- Contraption -->
			<table border="0">
				<tr>
					<td>FC</td>
					<td>
						<form:input id="fc" path="fcInstruction" />
						<form:hidden path="fcId" />
					</td>
				</tr>
				<tr>
					<td>CTT</td>
					<td>
						<form:input id="ctt" path="cttInstruction" />
						<form:hidden path="cttId" />
					</td>
				</tr>	
				<tr>
					<td>JP drain</td>
					<td>
						<form:input id="jpDrain" path="jpDrainInstruction" />
						<form:hidden path="jpDrainId" />
					</td>
				</tr>	
				<tr>
					<td>Colostomy</td>
					<td>
						<form:input id="colostomy" path="colostomyInstruction" />
						<form:hidden path="colostomyId" />
					</td>
				</tr>	
				<tr>
					<td>Ileostomy</td>
					<td>
						<form:input id="ileostomy" path="ileostomyInstruction" />
						<form:hidden path="ileostomyId" />
					</td>
				</tr>
				<tr>
					<td>Nephrostomy</td>
					<td>
						<form:input id="nephrostomy" path="nephrostomyInstruction" />
						<form:hidden path="nephrostomyId" />
					</td>
				</tr>
				<tr>
					<td>Tenckhoff catheter
					</td>
					<td>
						<form:input id="tenckhoffCatheter" path="tenckhoffCatheterInstruction" />
						<form:hidden path="tenckhoffCatheterId" />
					</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>						
				<tr>
					<td>Others:<br/></td>
					<td>
						<form:textarea id="others" path="othersInstruction" rows="1" cols="25" />
						<form:hidden path="othersId" />
						<br/>
						<br/>
						<button type="submit" style="float:right"><i class="fa  fa-floppy-o pghnc_save"></i></button>
						 
					</td>	
				</tr>	
			</table>
			
			<!--/ Contraption -->
		</td>
		
	</tr>
</table>


	<form:hidden path="patientCaseRecordId" />
	
</form:form>