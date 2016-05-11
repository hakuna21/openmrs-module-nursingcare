<form:form method="post" action="saveMonitoring.form"
	modelAttribute="monitoringForm">

	<h2>MONITORING</h2>


	<table border="0">
		<tr>
			<td width="350px">
				<!-- Measurement -->
					<table border="0">
						<tr>
							<td>VS</td>
							<td><form:select path="vsInstruction">
									<form:option value="" label="--- Not Applicable ---" />
									<form:options items="${monitoringSelect1}" />
								</form:select> <form:hidden path="vsId" /></td>
						</tr>
						<tr>
							<td>NVS</td>
							<td><form:select path="nvsInstruction">
									<form:option value="" label="--- Not Applicable ---" />
									<form:options items="${monitoringSelect1}" />
								</form:select></td>
							<form:hidden path="nvsId" />
						</tr>
						<tr>
							<td>CBG</td>
							<td><form:select path="cbgInstruction">
									<form:option value="" label="--- Not Applicable ---" />
									<form:options items="${monitoringSelect1}" />
								</form:select> <form:hidden path="cbgId" /></td>
							</td>
						</tr>
						<tr>
							<td>Weight</td>
							<td><form:select path="weightInstruction">
									<form:option value="" label="--- Not Applicable ---" />
									<form:options items="${monitoringSelect2}" />
								</form:select> <form:hidden path="weightId" /></td>
						</tr>
						<tr>
							<td>AG</td>
							<td><form:select path="agInstruction">
									<form:option value="" label="--- Not Applicable ---" />
									<form:options items="${monitoringSelect2}" />
								</form:select> <form:hidden path="agId" /></td>
						</tr>
						<tr>
							<td>HC</td>
							<td><form:select path="hcInstruction">
									<form:option value="" label="--- Not Applicable ---" />
									<form:options items="${monitoringSelect2}" />
								</form:select> <form:hidden path="hcId" /></td>
						</tr>
					</table>
				<!--/ Measurement -->
			</td>
			<td style="vertical-align:top">
				<!-- WOF -->
				<table>
					<tr>
						<td><b>Watch out for:</b><br/><br/>
						Fever</td>
						<td><br/><br/>
							<form:input id="fev" path="feverInstruction" />
							<form:hidden path="feverId" />
						</td>
					</tr>
					<tr>
						<td>Increased ICP</td>
						<td>
							<form:input id="incIcp" path="incIcpInstruction" />
							<form:hidden path="incIcpId" />
						</td>
					</tr>
					<tr>
						<td>Congestion</td>
						<td>
							<form:input id="cong" path="congestionInstruction" />
							<form:hidden path="congestionId" />
						</td>
					</tr>
					<tr>
						<td>Pain</td>
						<td>
							<form:input id="pain" path="painInstruction" />
							<form:hidden path="painId" />
						</td>
					</tr>
					<tr>
						<td style="vertical-align:text-top"><br/>Others:</td>
						<td><br/>
							<form:textarea id="others" path="othersInstruction" rows="1" cols="25" />
							<form:hidden path="othersId" /> 
							
							<br/><br/>
							<button type="submit" style="float:right"><i class="fa  fa-floppy-o pghnc_save"></i></button>
							
						</td>
					</tr>
				</table>
				<!--/ WOF -->
			</td>
		</tr>
	</table>

	<br/><br/>
	<form:hidden path="patientCaseRecordId" />
	

</form:form>