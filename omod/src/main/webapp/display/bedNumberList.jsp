<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="../template/pgh_nursing.jsp"%>

<div class="pghnc_rightpanel">

<div class="pghnc_bednumbers">
<br/>
	
<ul>

		
		<c:if test="${!nurse && !physician}" >
		
		<c:forEach items="${beds}" var="bed" varStatus="loop">
				<li style="font-size:10px"><a href="viewKardex.page?bedId=${bed.id }">
					${bed.location.name }-
					${bed.roomName }
				</a>
				</li>
		</c:forEach>
		</c:if>
		
		<c:if test="${nurse}" >
			
		<c:forEach items="${beds}" var="bed" varStatus="loop">
				<li style="font-size:10px"><a href="viewKardex.page?bedId=${bed.id }">
					${bed.roomName }
				</a>
				</li>
		</c:forEach>
		</c:if>
	
	<c:if test="${physician}">
	
		<c:forEach items="${patientCaseRecordsByPhysician}" var="patientCaseRecord" varStatus="loop">
			<li style="font-size:10px">
				<a href="viewKardex.page?bedId=${patientCaseRecord.latestPatientMovement.bed.id }">
					${patientCaseRecord.latestPatientMovement.bed.location.name}-
					${patientCaseRecord.latestPatientMovement.bed.roomName }
				</a>
			</li>
		
		</c:forEach>
				
	</c:if>
	
	
</ul>
</div>

</div>