<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/pgh_nursing.jsp"%>						

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ 			icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + 			'/index.htm' },
	{ 			label: "Nursing Kardex" 			}
	];	
</script>

<%@ include file="display/leftPanel.jsp"%>
<%@ include file="display/bedNumberList.jsp"%>

<form:form method="post" action="wardAggregateEntry.form" modelAttribute="wardAggregateForm">
<div class="pghnc_frame">
	<div>
		<div>		
			<h2>Ward Aggregate Entry</h2>
			<br/>
			<table border="1" class="inside_table">
				<tr>
					<th>Activity</th>
					<th>Count</th>
					<th>Remarks</th>
				</tr>
				<tr>
					<td>Linen change</td>
					<td><form:input size="5" path="linenChange.tally" /></td>
					<td><form:input path="linenChange.remarks" /></td>
					<form:hidden path="linenChange.id" /> 	
				</tr>
				<tr>
					<td colspan="3"><i><b>&nbsp;&nbsp;&nbsp;Medications:</b></i></td>
				</tr>
				<tr>
					<td>Oral</td>
					<td><form:input size="5" path="oral.tally" /></td>
					<td><form:input path="oral.remarks" /></td>
					<form:hidden path="oral.id" /> 	
				</tr>
				<tr>
					<td>Topical</td>
					<td><form:input size="5" path="topical.tally" /></td>
					<td><form:input path="topical.remarks" /></td>
					<form:hidden path="topical.id" /> 	
				</tr>
				<tr>
					<td>Intravenous</td>
					<td><form:input size="5" path="intravenous.tally" /></td>
					<td><form:input path="intravenous.remarks" /></td>
					<form:hidden path="intravenous.id" /> 	
				</tr>
				<tr>
					<td>Intradermal</td>
					<td><form:input size="5" path="intradermal.tally" /></td>
					<td><form:input path="intradermal.remarks" /></td>
					<form:hidden path="intradermal.id" /> 	
				</tr>
				<tr>
					<td>Intramuscular</td>
					<td><form:input size="5" path="intramuscular.tally" /></td>
					<td><form:input path="intramuscular.remarks" /></td>
					<form:hidden path="intramuscular.id" /> 	
				</tr>
				<tr>
					<td>Subcutaneous</td>
					<td><form:input size="5" path="subcutaneous.tally" /></td>
					<td><form:input path="subcutaneous.remarks" /></td>
					<form:hidden path="subcutaneous.id" /> 	
				</tr>
				<tr>
					<td>Drops</td>
					<td><form:input size="5" path="drops.tally" /></td>
					<td><form:input path="drops.remarks" /></td>
					<form:hidden path="drops.id" /> 	
				</tr>
				<tr>
					<td>Suppositories</td>
					<td><form:input size="5" path="suppositories.tally" /></td>
					<td><form:input path="suppositories.remarks" /></td>
					<form:hidden path="suppositories.id" /> 	
				</tr>
				<tr>
					<td>Enema/irrigation</td>
					<td><form:input size="5" path="enemaIrigation.tally" /></td>
					<td><form:input path="enemaIrigation.remarks" /></td>
					<form:hidden path="enemaIrigation.id" /> 	
				</tr>
				<tr>
					<td>Others</td>
					<td><form:input size="5" path="others.tally" /></td>
					<td><form:input path="others.remarks" /></td>
					<form:hidden path="others.id" /> 	
				</tr>
			</table>
			<br/>
			
			<form:hidden path="locationId" />
			<center><input type="submit" value="Save"/></center>
		</div>
	</div>			
</div>
</form:form>

<%@ include file="/WEB-INF/template/footer.jsp"%>