<script type="text/javascript">
var numberOfClonedElementsLab = 0;

function addParenteralOrder() {
	var index = numberOfClonedElementsLab;
	var row = document.getElementById('newParenteralOrderRow');
	var newrow = row.cloneNode(true);
	newrow.style.display = "";		
	newrow.id = 'parenteralOrders[' + index + ']';
	row.parentNode.insertBefore(newrow, row);
	var inputs = newrow.getElementsByTagName("input");
	var selects = newrow.getElementsByTagName("select");
	var textareas = newrow.getElementsByTagName("textarea");
	for (var i in selects) {
		var select = selects[i];
		if (select && select.name == "orderTypeId") {					
			select.name = 'parenteralOrders[' + index + '].parenteralOrderType.id';
		}
	}
	
	for (var x = 0; x < inputs.length; x++) {
		var input = inputs[x];
		if (input && input.name == 'anatomicalSite' && input.type == 'text') {
			input.name = 'parenteralOrders[' + index + '].anatomicalSite';
		} else if (input && input.name == 'remarks' && input.type == 'text') {
			input.name = 'parenteralOrders[' + index + '].remarks';
		}
		else if (input && input.name == 'existingParenteralOrders[x]' && input.type == 'hidden') {
			input.name = input.name.replace('x', index);
		}
	}

	numberOfClonedElementsLab++;
}

function removeParenteralOrder(obj){
	obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
}

function addOtherParenteralOrder() {
	var index = numberOfClonedElementsLab;
	var row = document.getElementById('newOtherParenteralOrderRow');
	var newrow = row.cloneNode(true);
	newrow.style.display = "";		
	newrow.id = 'otherParenteralOrders[' + index + ']';
	row.parentNode.insertBefore(newrow, row);
	var inputs = newrow.getElementsByTagName("input");
	var selects = newrow.getElementsByTagName("select");
	var textareas = newrow.getElementsByTagName("textarea");
	for (var i in selects) {
		var select = selects[i];
		if (select && select.name == "orderTypeId") {					
			select.name = 'parenteralOrders[' + index + '].parenteralOrderType.id';
		}
	}
	
	for (var x = 0; x < inputs.length; x++) {
		var input = inputs[x];
		if (input && input.name == 'parenteralIntravenousFluid' && input.type == 'text') {
			input.name = 'otherParenteralOrders[' + index + '].intravenousFluid';
		} else if (input && input.name == 'parenteralVolume' && input.type == 'text') {
			input.name = 'otherParenteralOrders[' + index + '].volume';
		} else if (input && input.name == 'parenteralAdditive' && input.type == 'text') {
			input.name = 'otherParenteralOrders[' + index + '].additive';
		} else if (input && input.name == 'parenteralRegulation' && input.type == 'text') {
			input.name = 'otherParenteralOrders[' + index + '].regulation';
		} else if (input && input.name == 'otherAnatomicalSite' && input.type == 'text') {
			input.name = 'otherParenteralOrders[' + index + '].anatomicalSite';
		} else if (input && input.name == 'otherRemarks' && input.type == 'text') {
			input.name = 'otherParenteralOrders[' + index + '].remarks';
		}
	}

	numberOfClonedElementsLab++;
}

function removeOtherParenteralOrder(obj){
	obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
}

</script>

<h2>PARENTERAL</h2>

<form:form method="post" action="saveParenteralOrder.form" modelAttribute="parenteralOrderForm">

<table border="0">
	<tr>
		<td>
			<!-- IVF -->
			<table border="1" class="content_table">
				<tr>
					<th >IVF or Blood Component</th>
					<th >Anatomical Site</th>
					<th >Remarks</th>
					<th></th>
				</tr>
				<c:forEach items="${patientParenteralOrders}" var="ord" varStatus="ordStat">
					<tr>
						<td>
							<c:choose>
								<c:when test="${not empty ord.parenteralOrderType}">
									${ord.parenteralOrderType.intravenousFluid} ${ord.parenteralOrderType.volume } ml x ${ord.parenteralOrderType.regulation }
								</c:when>
								<c:otherwise>
									${ord.intravenousFluid} ${ord.volume } ml x ${ord.regulation }
								</c:otherwise>
							</c:choose>
						</td>
						<td>${ord.anatomicalSite }</td>
						<td>${ord.remarks }</td>
						<td class="removeButtonColumn">
							<input type="hidden" name="existingParenteralOrders[${ordStat.index }]" value="${ord.id }" />
							<input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" 
								onClick="javascript:this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode)" />
						</td>
					</tr>
				</c:forEach>
				<tr id="newParenteralOrderRow" style="display:none;">
					<td>
						<select name="orderTypeId">
							<option></option>
							<c:forEach items="${parenteralOrderTypes}" var="ord">
					        	<option value="${ord.id}">
					        		${ord.intravenousFluid} ${ord.volume } ml x ${ord.regulation }
					        	</option>
					        </c:forEach>
						</select>
					</td>
					<td><input type="text" name="anatomicalSite" />
					</td>
					<td><input type="text" name="remarks" />
					</td>	
					<td class="removeButtonColumn">
						<input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" onclick="removeParenteralOrder(this)" />
					</td>
				</tr>
				<tr>
					<td  colspan="4"><input type="button" value="Add" onclick="addParenteralOrder()"/><br/><br/>&nbsp;
					</td>		
				</tr>
				<tr id="newOtherParenteralOrderRow" style="display:none;">
					<td>
					<br/>Other IVF
						<input type="text" name="parenteralIntravenousFluid" placeholder="IVF"/><br/>
						<input type="text" name="parenteralVolume" placeholder="volume (cc)"/><br/>
						<input type="text" name="parenteralAdditive" placeholder="additive"/><br/>
						<input type="text" name="parenteralRegulation" placeholder="regulation (i.e. 8h)"/>
					</td>
					<td><br/><input type="text" name="otherAnatomicalSite" />
					</td>
					<td><br/><input type="text" name="otherRemarks" />
					</td>	
					<td class="removeButtonColumn">
						<br/><input type="button" value='<openmrs:message code="general.remove"/>' class="smallButton" onclick="removeOtherParenteralOrder(this)" />
					</td>
				</tr>
				<tr>
					<td colspan="4"><input type="button" value="Add Other IVF or regulation" onclick="addOtherParenteralOrder()"/><br/><br/>&nbsp;
					</td>		
				</tr>
				<tr>
					<td colspan="4">Chemotherapy:<br/>
						<form:textarea id="others" path="chemotherapyInstruction" rows="2" cols="40" />
						<form:hidden path="chemotherapyId" /> 
					</td>
				</tr>
			</table>
			
			
			<!--/ IVF -->
		</td>
	</tr>
	<tr>
					<td>
						<h4>Contraptions</h4>
						<!-- Contraptions -->
						<table border="0">
							<tr>
								<td>
									<table border="0">
										<tr>
											<td>Heplock</td>
											<td>
												<form:input id="helplock" path="heplockInstruction" />
												<form:hidden path="heplockId" />
											</td>
										</tr>
										<tr>
											<td>IJ catheter</td>
											<td>
												<form:input id="intrajugularCatheter" path="intrajugularCatheterInstruction" />
												<form:hidden path="intrajugularCatheterId" />
											</td>
										</tr>	
										<tr>
											<td>Femoral catheter</td>
											<td>
												<form:input id="femoralCatheter" path="femoralCatheterInstruction" />
												<form:hidden path="femoralCatheterId" />
											</td>
										</tr>	
										<tr>
											<td>Subclavian catheter</td>
											<td>
												<form:input id="subclavianCatheter" path="subclavianCatheterInstruction" />
												<form:hidden path="subclavianCatheterId" />
											</td>
										</tr>	
										<tr>
											<td>AV fistula</td>
											<td>
												<form:input id="arteriovenousFistula" path="arteriovenousFistulaInstruction" />
												<form:hidden path="arteriovenousFistulaId" />
											</td>
										</tr>
									</table>
								</td>
								<td style="vertical-align:bottom;padding-left:100px">
									<table border="0">
										
										<tr>
											<td>Others:<br/>
												<form:textarea id="otherParenteral" path="otherParenteralInstruction" rows="4" cols="25" />
												<form:hidden path="otherParenteralId" /> 
											</td>
										</tr>						
									</table>
								</td>
							</tr>
						</table>
						
						
						<!--/ Contraptions -->
						
						<form:hidden path="patientCaseRecordId"/>
<button type="submit" style="float: right"><i class="fa  fa-floppy-o pghnc_save"></i></button>
						
					</td>
			
				</tr>
</table>

	

</form:form>