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

<div class="pghnc_frame">
	<div>
		<div>		
			<h2>REPORTS</h2>
			<br/>
			
				<ul>
					<!-- hospital-wide -->
						<a href="dailyHospitalCensusReport.page"><li>Daily Hospital Census</li></a>
					<c:if test="${kardexEdit || dietitian }">
						<a href="dietListReport.page"><li>Diet List</li></a>
					</c:if>
					<c:if test="${kardexEdit || pharmacist }">
						<a href="totalParenteralNutritionListReport.page"><li>Total Parenteral Nutrition</li></a>
					</c:if>
					<c:if test="${kardexEdit || nursingAdmin }">
						<a href="nursingIndicatorReport.page"><li>Nursing Indicators</li></a>
						<a href="midnightReport.page"><li>Midnight Report</li></a>
					</c:if>
					<c:if test="${kardexEdit }">
						<a href="endorsementSheetReport.page"><li>Endorsement Sheet</li></a>
						<a href="wardAggregateEntry.page"><li>Ward Aggregate Entry</li></a>
					</c:if>
				</ul>
		</div>
	</div>			
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>