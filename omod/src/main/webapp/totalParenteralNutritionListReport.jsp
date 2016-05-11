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
			<h2>Total Parenteral Nutrition</h2>
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
					<th>PATIENT INFO</th>
					<th>NUTRITIONAL NEED</th>
					<th>TPN PREPARATION</th>
					<th>REQUEST</th>
				</tr>
				<c:forEach items="${dietList}" var="diet" varStatus="dietStat">
				
				<tr>
					<td>${diet.bedNo }
						
					</td>
					<td>Name: <u> &nbsp; ${diet.nameOfPatient }  &nbsp; </u><br/><br/>
						Diagnosis: <u> &nbsp; ${diagnosis }  &nbsp; </u><br/>
							<!--  Wt: <br/>
							Ht: 					
							Vein Access: Peripheral/Central<br/>
							Adverse Reactions:<br/>
							 -->
							Others:<br/> ${diet.tpn }
					</td>
					<td>
						Total Fluid Req.: <u> &nbsp; ${diet.fluidRequirementMlPerKg } &nbsp; ml/kg </u><br/>
						Calories: <u> &nbsp; ${diet.cal }  &nbsp; kcal/day </u><br/>
						CHO: <u> &nbsp; ${diet.cho }  &nbsp; kcal/day </u><br/>
						CHON: <u> &nbsp; ${diet.chon }  &nbsp; g/kg/day </u><br/>
						Fats: <u> &nbsp; ${diet.fat }  &nbsp; kcal/day </u><br/>
					</td>
					<td>
						Sterile H20: <u> &nbsp; ${diet.sterileWaterMl }  &nbsp; </u><br/>
						NaCl: <u> &nbsp; ${diet.sodiumChloride }  &nbsp; </u><br/>	
						Amino Acids: <u> &nbsp; ${diet.aminoAcids }  &nbsp; </u><br/>
						Dextrose: <u> &nbsp; ${diet.dextrose }  &nbsp; </u><br/>
						Ca Gluconate: <u> &nbsp; ${diet.calciumGluconate }  &nbsp; </u><br/>
						Mg Sulfate: <u> &nbsp; ${diet.magnesiumSulfate }  &nbsp; </u><br/>
						MVT: <u> &nbsp; ${diet.multivitamins }  &nbsp; </u><br/>
						Lipids: <u> &nbsp; ${diet.lipids }  &nbsp; </u><br/>
						Insulin: <u> &nbsp; ${diet.insulin }  &nbsp; </u><br/>
						Total Volume: <u> &nbsp; ${diet.totalVolume }  &nbsp; </u><br/>
					</td>
					<td>
						Requested by: <u> &nbsp; ${diet.requestedBy }  &nbsp; </u><br/>
						Order: <u> &nbsp; ${diet.orderType }  &nbsp; </u><br/>
						Indication: <u> &nbsp; ${diet.indication }  &nbsp; </u><br/>
						Estimated Duration: <u> &nbsp; ${diet.duration }  &nbsp; </u><br/>
						
					</td>
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