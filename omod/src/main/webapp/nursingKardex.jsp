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
<%@ include file="display/bedNumberList.jsp"%>

<div class="pghnc_frame">
   <div>
      <div>      		
      		<c:if test="${kardexView }">
      		
      			Welcome to:
						<h2>${location.name }</h2><br/>
						<br/>
						Census: ${totalPatientCount } + ${totalRoomingInCount } RI<br/>
						Date: <openmrs:formatDate date="${today}" type="long" /><br/>
						<br/>
						<a href="endorsementSheetReport.page" style="color:#E8FBFD"><u>Print an Endorsement</u></a>
						<br/><br/>
						
						<a href="admission.form" style="color:#E8FBFD"><u>Admit Patient to this ward</u></a>
						<br/><br/>
						
						<!-- 
						<img src="${pageContext.request.contextPath}/module/nursingkardex/template/openmrs-with-title-small.png" alt="openmrs" width="100px" height="100px"/>
						<a href="${pageContext.request.contextPath}/module/nursingkardex/template/openmrs-with-title-small.png">dff</a>
						<center><h1 style="font-size:26px">${ ui.message("nursingkardex.title") }</h1>
							<span style="font-size:16px;color:brown">${ ui.message("nursingkardex.kardexSlogan") }</span>
						</center>
						<h4> 4LCB1 - ${ ui.message("nursingkardex.census") }: 32 + 4RI (02/12/35 4:30pm)  </h4>
						-->
					
						<br style="font-size:50px"/>
			
			</c:if>
				
      </div>
   </div>
   <br/>
   <br/>
   <br style="font-size:10px"/>
   <%@ include file="/WEB-INF/template/footer.jsp"%>
</div>   



