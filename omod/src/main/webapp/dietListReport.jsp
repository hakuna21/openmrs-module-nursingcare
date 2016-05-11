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
        var mywindow = window.open('', 'Print Diet List Report', 'height=400,width=600');
        mywindow.document.write('<html><head><title>Print Diet List Report</title>');
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


<script type="text/javascript">
	var breadcrumbs = [ {
		icon : "icon-home",
		link : '/' + OPENMRS_CONTEXT_PATH + '/index.htm'
	}, {
		label : "Nursing Kardex"
	} ];
</script>

<%@ include file="display/leftPanel.jsp"%>

<div class="pghnc_frame" id="forPrintDiv">
	<div>
		<div>
			<h2>Diet List</h2>
			<br/>
			<table border="0">
				<tr>
					<td>Date/Period:</td><td></td>
				</tr>
				<tr><td>Area:</td><td></td>
				</tr>
			</table>
			
			<br/>
			<table border="1" class="inside_table">
				<tr class="header">
					<th>BED NO.</th>
					<th>NAME OF PATIENT</th>
					<th>FULL</th>
					<th>SOFT</th>
					<th>GL</th>
					<th>CL</th>
					<th>NPO</th>
					<th width="140px">SPECIAL DIET</th>
					<th>CAL</th>
					<th>CHO</th>
					<th>CHON</th>
					<th>FAT</th>
					<th>Na</th>
				</tr>
				<c:forEach items="${dietList}" var="diet" varStatus="dietStat">
					<tr>
						<td>${diet.bedNo }</td>
						<td>${diet.nameOfPatient }</td>
						<td>${diet.full }</td>
						<td>${diet.soft }</td>
						<td>${diet.gl }</td>
						<td>${diet.cl }</td>
						<td>${diet.npo }</td>
						<td>${diet.specialDiet }</td>
						<td>${diet.cal }</td>
						<td>${diet.cho }</td>
						<td>${diet.chon }</td>
						<td>${diet.fat }</td>
						<td>${diet.na }</td>
					</tr>
				</c:forEach>	
			</table>
			<br/>
		</div>
	</div>
</div>
<br/>
			<center><input type="button" value="Print" onclick="PrintElem('#forPrintDiv')" /></center>
			<br/>