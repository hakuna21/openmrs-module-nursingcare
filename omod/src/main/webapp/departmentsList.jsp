<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>DEPARTMENTS</p>

<form method="post" action="department.form" modelAttribute="department">
	<div class="box">
		<table id="tableInstruments">
			<tr class="header">
				<th></th>
				<th>Name</th>
				<th>Description</th>
			</tr>
			<c:forEach items="${departments}" var="dept" varStatus="loop">
			<tr>
				<td><input type="radio" class="radioBtnSelectInstrument" id="radioBtnSelectInstrument_${dept.departmentId}" name="departmentId" value="${dept.departmentId }"></td>
				<td id="insPropertyTag${loop.index}" ><a href="department.form?departmentId=${dept.departmentId }">${dept.name}</a></td>
				<td id="insManufacturer${loop.index}" >${dept.description}</td>
			</tr>
			</c:forEach>
		</table>
		<a href="department.form"><spring:message code="nursingkardex.department.add" /></a>
		<input type="submit" name="action" value="<spring:message code="nursingkardex.department.delete" />"/>
	</div>
</form>	

<%@ include file="/WEB-INF/template/footer.jsp"%>