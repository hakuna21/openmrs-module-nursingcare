<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/pgh_nursing.jsp"%>						

<script type="text/javascript" src="http://jqueryjs.googlecode.com/files/jquery-1.3.1.min.js" > </script> 
<script type="text/javascript">

    function PrintElem(elem)
    {
        Popup($(elem).html());
    }

    function Popup(data) 
    {
        var mywindow = window.open('', 'Print Midnight Report', 'height=400,width=600');
        mywindow.document.write('<html><head><title>Print Midnight Report</title>');
        /*optional stylesheet*/ //mywindow.document.write('<link rel="stylesheet" href="main.css" type="text/css" />');
        mywindow.document.write('</head><body >');
        mywindow.document.write(data);
        mywindow.document.write('</body></html>');

        mywindow.document.close(); // necessary for IE >= 10
        mywindow.focus(); // necessary for IE >= 10

        mywindow.print();
        mywindow.close();

        return true;
    }

</script>


<script 	type="text/javascript">	
	var 		breadcrumbs = [ 
	{ 			icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + 			'/index.htm' },
	{ 			label: "Nursing Kardex" 			}
	];	
</script>

<%@ include file="display/leftPanel.jsp"%>

<div class="pghnc_frame" id="forPrintDiv">
	<div>
		<div>		
			<h2>12 Midnight Report</h2>
			<br/>
			<table border="0">
				<tr>
					<td>Date/Period:</td><td></td>
				</tr>
				<tr><td>Area:</td><td></td>
				</tr>
			</table>
			
					<table border="1" class="indicator">
						<tr class="header">
							<th width="250px">WARD/UNIT</th>
							<th width="100px">MALE</th>
							<th width="100px">FEMALE</th>
							<th width="100px">TOTAL</th>
						</tr>
						<tr>
							<td>TOTAL LAST</td>
							<td>${midnightReportBean.totalLastMale }</td>
							<td>${midnightReportBean.totalLastFemale }</td>
							<td>${midnightReportBean.totalLastMale + midnightReportBean.totalLastFemale }</td>
						</tr>
						<tr>
							<td>ADMISSION</td>
							<td>${midnightReportBean.admissionMale }</td>
							<td>${midnightReportBean.admissionFemale }</td>
							<td>${midnightReportBean.admissionMale + midnightReportBean.admissionFemale }</td>
						</tr>
						<tr>
							<td>TRANSFER-IN</td>
							<td>${midnightReportBean.transferInMale }</td>
							<td>${midnightReportBean.transferInFemale }</td>
							<td>${midnightReportBean.transferInMale + midnightReportBean.transferInFemale }</td>
						</tr>
						<tr>
							<td>TRANSFER-OUT</td>
							<td>${midnightReportBean.transferOutMale }</td>
							<td>${midnightReportBean.transferOutFemale }</td>
							<td>${midnightReportBean.transferOutMale + midnightReportBean.transferOutFemale }</td>
						</tr>
						<tr>
							<td>DISCHARGED</td>
							<td>${midnightReportBean.dischargedMale }</td>
							<td>${midnightReportBean.dischargedFemale }</td>
							<td>${midnightReportBean.dischargedMale + midnightReportBean.dischargedFemale }</td>
						</tr>
						<tr>
							<td>DEATHS</td>
							<td>${midnightReportBean.deathsMale }</td>
							<td>${midnightReportBean.deathsFemale }</td>
							<td>${midnightReportBean.deathsMale + midnightReportBean.deathsFemale }</td>
						</tr>
						<tr>
							<td>HOME VS ADVICE</td>
							<td>${midnightReportBean.homeVsAdviceMale }</td>
							<td>${midnightReportBean.homeVsAdviceFemale }</td>
							<td>${midnightReportBean.homeVsAdviceMale + midnightReportBean.homeVsAdviceFemale }</td>
						</tr>
						<tr>
							<td>HOME PER REQUEST</td>
							<td>${midnightReportBean.homePerRequestMale }</td>
							<td>${midnightReportBean.homePerRequestFemale }</td>
							<td>${midnightReportBean.homePerRequestMale + midnightReportBean.homePerRequestFemale }</td>
						</tr>
						<tr>
							<td>DELIVERIES</td>
							<td>&nbsp;</td>
							<td>${midnightReportBean.deliveries }</td>
							<td>${midnightReportBean.deliveries }</td>
						</tr>
						<tr>
							<td>ROOMING-IN</td>
							<td>${midnightReportBean.roomingInMale }</td>
							<td>${midnightReportBean.roomingInFemale }</td>
							<td>${midnightReportBean.roomingInMale + midnightReportBean.roomingInFemale }</td>
						</tr>
						<tr>
							<td>CLOSE MONITORING</td>
							<td>${midnightReportBean.closeMonitoringMale }</td>
							<td>${midnightReportBean.closeMonitoringFemale }</td>
							<td>${midnightReportBean.closeMonitoringMale + midnightReportBean.closeMonitoringFemale }</td>	
						</tr>
					</table>
			
		</div>
	</div>			
</div>
<br/>
<div align="center"><input type="button" value="Print" onclick="PrintElem('#forPrintDiv')" /></div>
<br/>