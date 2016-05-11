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

<div class="pghnc_frame">
	<div>
		<div>
			<h2>Nursing Care Indicator Report</h2>
			<br/>	
			<br/>
			<table border="0">
				<tr>
					<td>Period:</td>
					<td><input type="text" size="10" placeholder="start date"/></td>
					<td>-</td>
					<td><input type="text" size="10" placeholder="end date"/></td>
				</tr>
				<tr><td>Area:</td><td><input type="text"/></td>
				</tr>
			</table>
			
			<br/>
			<br/>
		
	<style>
		h3 {font-size:14.5px;
		}
	</style>
	
	<div style="margin-left:50px" >	
	  <h3>1. Monitoring</h3>
	    	<%@ include file="field/indicatorMonitoring.jsp"%>
	    	<br/><br/>
	  <h3>2. Comfort Measures</h3>
	    	<%@ include file="field/indicatorComfort.jsp"%>
	    	<br/><br/>
	  <h3>3. Nutritional Support</h3>
	    	<%@ include file="field/indicatorNutritional.jsp"%>
	    	<br/><br/>
	  <h3>4. Ventilator Support</h3>
	    	<%@ include file="field/indicatorVentilatory.jsp"%>
	    	<br/><br/>
	  <h3>5. Elimination</h3>
	    	<%@ include file="field/indicatorElimination.jsp"%>
	    	<br/><br/>
	  <h3>6. Mobility/Safety</h3>
	    	<%@ include file="field/indicatorMobilitySafety.jsp"%>
	    	<br/><br/>
	  <h3>7. IV Therapy</h3>
	    	<%@ include file="field/indicatorIVTherapy.jsp"%>
	    	<br/><br/>
	  <h3>8. Medication</h3>
	    	<%@ include file="field/indicatorMedication.jsp"%>
	    	<br/><br/>
	  <h3>9. Tube Care</h3>
	    	<%@ include file="field/indicatorTubeCare.jsp"%>
	    	<br/><br/>
	  <h3>10. Wound Care</h3>
	    	<%@ include file="field/indicatorWoundCare.jsp"%>
	    	<br/><br/>
	  <h3>11. Diagnostic Procedure</h3>
	    	<%@ include file="field/indicatorDiagnosticProcedure.jsp"%>
	    	<br/><br/>
	  <h3>12. Preparation for Invasive Procedure</h3>
	    	<%@ include file="field/indicatorInvasiveProcedure.jsp"%>
	    	<br/><br/>
	  <h3>13. Spiritual/ Psychosocial Care</h3>
	    	<%@ include file="field/indicatorSpiritualPsychosocial.jsp"%>
	    	<br/><br/>
	  <h3>14. Code, Post-mortem Care, 5s, Levels of Care</h3>
	    	<%@ include file="field/indicatorCodeLevelsOfCare.jsp"%>
	    	<br/><br/>
	  <h3>15. Others</h3>
	    	<%@ include file="field/indicatorOther.jsp"%>
	    	<br/>
	</div>			
				
				
		</div>
	</div>			
</div>
<br/>
<div align="center"><input type="button" value="Print" /></div>
<br/>