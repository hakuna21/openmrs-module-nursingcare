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
        var mywindow = window.open('', 'Print Endorsement Sheet Report', 'height=400,width=600');
        mywindow.document.write('<html><head><title>Print Endorsement Sheet Report</title>');
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
			<h2>Endorsement Sheet</h2>
			<br/>
			<table border="0">
				<tr>
					<td>Date/Period:</td><td></td>
				</tr>
				<tr><td>Area:</td><td></td>
				</tr>
			</table>
			<br/>
					<table border="1" class="indicator">
						<tr class="header">
							<th>BED NO.</th>
							<th>NAME OF PATIENT</th>
							<th width="100px">PARENTERAL</th>
							<th width="100px">INTAKE</th>
							<th width="70px">OUTPUT</th>
							<th width="70px">MONITORING</th>
							<th width="120px">NURSING INTERVENTIONS</th>
							<th width="120px">SPECIAL ENDORSEMENTS</th>
						</tr>
						<c:forEach items="${endorsementList}" var="endorsement" varStatus="endStat">
						<tr>
							<td>${endorsement.bedNo }</td>
							<td>${endorsement.nameOfPatient }</td>
							<td>${endorsement.parenteral }</td>
							<td>${endorsement.intake }</td>
							<td>${endorsement.output }</td>
							<td>${endorsement.monitoring }</td>
							<td>${endorsement.nursingInterventions }</td>
							<td>${endorsement.specialEndorsements }</td>
						</tr>
						</c:forEach>
					</table>
		</div>
	</div>			
</div>
<br/>
<div align="center"><input type="button" value="Print" onclick="PrintElem('#forPrintDiv')" /></div>
<br/>