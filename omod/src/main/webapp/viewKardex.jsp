<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/pgh_nursing.jsp"%>
<!-- tag include file="template/font-awesome/try.jsp"%> -->
						

<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ 			icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + 			'/index.htm' },
	{ 			label: "Nursing Kardex" 			}
	];	
</script>
<%@ include file="display/leftPanel.jsp"%>

<div class="pghnc_frame">
   <div>
      <div>
      <h2>Care Plan</h2>
      	
    	
      	<c:if test="${ (kardexView) || (not true) }">
      		
				<!-- PATIENT INFO -->
				<%@ include file="display/patientInfo.jsp"%>
				<br/>
				<br/>
		
				<!-- EDIT ICON -->
				<c:if test="${ kardexEdit }">
					<c:if test="${!(empty user) }">
						<a href="editKardex.form?patientCaseRecordId=${patientCaseRecord.id }">
							<i class="fa fa-pencil pghnc_edit"></i>
						</a>
					</c:if>
				</c:if>
				<!-- NCP -->
						<%@ include file="display/nursingCarePlan.jsp"%>		
						<br/>
		</c:if>		
		<c:if test="${!(kardexView) }">
      		<br/><br/>
      		<blockquote>
      			Sorry. You have no privilege to perform this operation.
      		</blockquote>
      	</c:if>	
		</div>
	</div>
		
</div>

<div style="position:absolute;top:95px;right:10px;margin-right:0px">
	<%@ include file="display/bedNumberList.jsp"%>
</div>

	
<%@ include file="/WEB-INF/template/footer.jsp"%>