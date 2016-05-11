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
			<h2>Add Nurses</h2>
			<span style="padding-left:60px">(from RNPage)</span>
		
		</div>
	</div>			
</div>



<%@ include file="/WEB-INF/template/footer.jsp"%>