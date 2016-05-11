<%@ include file="../template/pgh_nursing.jsp"%>

<div class="pghnc_leftpanel">

<div id="navcontainer">

	<c:forEach items="${authenticatedUser.roles}" var="role">
	
	  	<c:if test="${(role eq 'Application: Administers System') || (role eq 'System Developer') ||(role eq 'Organizational: Nurse') }">
	  		<c:set var="kardexEdit" value="true" />
	  		<c:set var="kardexView" value="true" />
	  	</c:if>
	  	<c:if test="${(role eq 'Organizational: Nurse') }">	
	  		<c:set var="nurse" value="true" />
	  	</c:if>
	  	<c:if test="${(role eq 'Organizational: Doctor') }">
	  		<c:set var="kardexEdit" value="false" />
	  		<c:set var="kardexView" value="true" />
	  		<c:set var="physician" value="true" />
	  	</c:if>
	  	<c:if test="${(role eq 'Organizational: Dietitian') }">
	  		<c:set var="dietitian" value="true" />
	  	</c:if>
	  	<c:if test="${(role eq 'Organizational: Pharmacist') }">
	  		<c:set var="pharmacist" value="true" />
	  	</c:if>
	  	<c:if test="${(role eq 'Organizational: Nursing Administrator') }">
	  		<c:set var="nursingAdmin" value="true" />
	  	</c:if>
	</c:forEach>
		
<ul id="navlist">
	<br/>
	
	<c:if test="${(kardexView)}">
		<li id="active" ><a href="nursingKardex.page" id="current" title="Kardex">
			<i class="fa fa-pencil-square-o pghnc_menu"></i>
			</a></li>
	</c:if>
	<c:if test="${(kardexView) || (nursingAdmin) }">
		<li><a href="search.form" title="Search">
			<i class="fa fa-search pghnc_menu"></i></a></li>
	</c:if>
	<c:if test="${(kardexView) || (nursingAdmin) }">
		<li><a href="patientList.page" title="Patient List">
			<i class="fa fa-users pghnc_menu"></i></a></li>
	</c:if>
	<c:if test="${(kardexEdit) }">
		<li><a href="patientMovement.form" title="Patient Movement">
			<i class="fa fa-wheelchair pghnc_menu"></i></a></li>
	</c:if>
	<c:if test="${kardexEdit  || (nursingAdmin)}">
		<li><a href="providers.form">
			<i class="fa fa-user-md pghnc_menu" title="Providers"></i></a></li>
	</c:if>
		<li><a href="reportList.page" title="Report List">
			<i class="fa fa-th-list pghnc_menu"></i></a></li>
		
</ul>
<br/>
</div>

</div>
<br/>