<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="../template/pgh_nursing.jsp"%>

<div class="pghnc_rightpanel">

<div class="pghnc_bednumbers">
<ul >
	<c:forEach items="${beds}" var="bed" varStatus="loop">
		<li><a href="#">${bed.roomName }</a></li>
	</c:forEach>
</ul>
</div>

</div>