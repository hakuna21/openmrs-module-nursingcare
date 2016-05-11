<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/pgh_nursing.jsp"%>						

<openmrs:htmlInclude file="/scripts/calendar/calendar.js" />

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
			<h2>Daily Hospital Census</h2>
			<br/>
			
			<form method="post" action="dailyHospitalCensusReport.form" modelAttribute="censusForm">
			<table border="0">
				<tr>
					<td>Period:</td>
					<td>
						<spring:bind path="censusForm.startDate">
							<input type="text" id="startDate" name="${status.expression}" size="20" value="${status.value}" onfocus="showCalendar(this)" />
							<c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
						</spring:bind> <br/>
					</td>
					<td>&nbsp; - &nbsp;
						<spring:bind path="censusForm.endDate">
							<input type="text" id="endDate" name="${status.expression}" size="20" value="${status.value}" onfocus="showCalendar(this)" />
							<c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
						</spring:bind> 
						<input type="submit" value="Search"/><br/>
					</td>
				</tr>
<!-- 				<tr><td>Area:</td><td><input type="text"/></td> -->
				</tr>
			</table>
			</form>
			
			<br/>
				<table border="1" class="indicator_general">
					<tr>
						<th>CLINICAL AREAS/<br/>UNITS</th>
						<th>BED Capacity</th>
						<th>Total Last</th>
						<th>Daily Occ Rate</th>
						<th>Over-<br/>flow</th>
						<th>Admis-<br/>sion</th>
						<th>Trans-<br/>in</th>
						<th>Trans-<br/>out</th>
						<th>D/C</th>
						<th>Deaths</th>
						<th>Abs-<br/>conded</th>
						<th>HAA</th>
						<th>HPR</th>
						<th>Opera-<br/>tions</th>
						<th>Deli-<br/>veries</th>
						<th>Room-<br/>ing-in</th>
						<th>OOP</th>
						<th>Remarks</th>
					</tr>
					<tr>
						<td>Ward 1</td>
						<td>${ward1BedCapacity }</td>
						<td>${ward1TotalLast }</td>
						<td>${ward1DailyOccupancyRate }</td>
						<td>${ward1Overflow }</td>
						<td>${ward1Admission }</td>
						<td>${ward1TransIn }</td>
						<td>${ward1TransOut }</td>
						<td>${ward1Discharged }</td>
						<td>${ward1Deaths }</td>
						<td>${ward1Absconded }</td>
						<td>${ward1HomeAgainstAdvice }</td>
						<td>${ward1HomePerRequest }</td>
						<td>${ward1Operations }</td>
						<td>${ward1Deliveries }</td>
						<td>${ward1RoomingIn }</td>
						<td>${ward1OutOnPass }</td>
						<td>${ward1Remarks }</td>
					</tr>
					<tr>
						<td>Ward 2</td>
						<td>${ward2BedCapacity }</td>
						<td>${ward2TotalLast }</td>
						<td>${ward2DailyOccupancyRate }</td>
						<td>${ward2Overflow }</td>
						<td>${ward2Admission }</td>
						<td>${ward2TransIn }</td>
						<td>${ward2TransOut }</td>
						<td>${ward2Discharged }</td>
						<td>${ward2Deaths }</td>
						<td>${ward2Absconded }</td>
						<td>${ward2HomeAgainstAdvice }</td>
						<td>${ward2HomePerRequest }</td>
						<td>${ward2Operations }</td>
						<td>${ward2Deliveries }</td>
						<td>${ward2RoomingIn }</td>
						<td>${ward2OutOnPass }</td>
						<td>${ward2Remarks }</td>
					</tr>
					<tr>
						<td>Trauma Ward</td>
						<td>${traumaWardBedCapacity }</td>
						<td>${traumaWardTotalLast }</td>
						<td>${traumaWardDailyOccupancyRate }</td>
						<td>${traumaWardOverflow }</td>
						<td>${traumaWardAdmission }</td>
						<td>${traumaWardTransIn }</td>
						<td>${traumaWardTransOut }</td>
						<td>${traumaWardDischarged }</td>
						<td>${traumaWardDeaths }</td>
						<td>${traumaWardAbsconded }</td>
						<td>${traumaWardHomeAgainstAdvice }</td>
						<td>${traumaWardHomePerRequest }</td>
						<td>${traumaWardOperations }</td>
						<td>${traumaWardDeliveries }</td>
						<td>${traumaWardRoomingIn }</td>
						<td>${traumaWardOutOnPass }</td>
						<td>${traumaWardRemarks }</td>
					</tr>
					<tr>
						<td>Ward 3</td>
						<td>${ward3BedCapacity }</td>
						<td>${ward3TotalLast }</td>
						<td>${ward3DailyOccupancyRate }</td>
						<td>${ward3Overflow }</td>
						<td>${ward3Admission }</td>
						<td>${ward3TransIn }</td>
						<td>${ward3TransOut }</td>
						<td>${ward3Discharged }</td>
						<td>${ward3Deaths }</td>
						<td>${ward3Absconded }</td>
						<td>${ward3HomeAgainstAdvice }</td>
						<td>${ward3HomePerRequest }</td>
						<td>${ward3Operations }</td>
						<td>${ward3Deliveries }</td>
						<td>${ward3RoomingIn }</td>
						<td>${ward3OutOnPass }</td>
						<td>${ward3Remarks }</td>
					</tr>
					<tr>
						<td>Ward 4</td>
						<td>${ward4BedCapacity }</td>
						<td>${ward4TotalLast }</td>
						<td>${ward4DailyOccupancyRate }</td>
						<td>${ward4Overflow }</td>
						<td>${ward4Admission }</td>
						<td>${ward4TransIn }</td>
						<td>${ward4TransOut }</td>
						<td>${ward4Discharged }</td>
						<td>${ward4Deaths }</td>
						<td>${ward4Absconded }</td>
						<td>${ward4HomeAgainstAdvice }</td>
						<td>${ward4HomePerRequest }</td>
						<td>${ward4Operations }</td>
						<td>${ward4Deliveries }</td>
						<td>${ward4RoomingIn }</td>
						<td>${ward4OutOnPass }</td>
						<td>${ward4Remarks }</td>
					</tr>
					<tr>
						<td>Ward 5</td>
						<td>${ward5BedCapacity }</td>
						<td>${ward5TotalLast }</td>
						<td>${ward5DailyOccupancyRate }</td>
						<td>${ward5Overflow }</td>
						<td>${ward5Admission}</td>
						<td>${ward5TransIn }</td>
						<td>${ward5TransOut }</td>
						<td>${ward5Discharged }</td>
						<td>${ward5Deaths }</td>
						<td>${ward5Absconded }</td>
						<td>${ward5HomeAgainstAdvice }</td>
						<td>${ward5HomePerRequest }</td>
						<td>${ward5Operations }</td>
						<td>${ward5Deliveries }</td>
						<td>${ward5RoomingIn }</td>
						<td>${ward5OutOnPass }</td>
						<td>${ward5Remarks }</td>
					</tr>
					<tr>
						<td>Rehab Ward</td>
						<td>${rehabWardBedCapacity }</td>
						<td>${rehabWardTotalLast }</td>
						<td>${rehabWardDailyOccupancyRate }</td>
						<td>${rehabWardOverflow }</td>
						<td>${rehabWardAdmission }</td>
						<td>${rehabWardTransIn }</td>
						<td>${rehabWardTransOut }</td>
						<td>${rehabWardDischarged }</td>
						<td>${rehabWardDeaths }</td>
						<td>${rehabWardAbsconded }</td>
						<td>${rehabWardHomeAgainstAdvice }</td>
						<td>${rehabWardHomePerRequest }</td>
						<td>${rehabWardOperations }</td>
						<td>${rehabWardDeliveries }</td>
						<td>${rehabWardRoomingIn }</td>
						<td>${rehabWardOutOnPass }</td>
						<td>${rehabWardRemarks }</td>
					</tr>
					<tr>
						<td>Ward 6</td>
						<td>${ward6BedCapacity }</td>
						<td>${ward6TotalLast }</td>
						<td>${ward6DailyOccupancyRate }</td>
						<td>${ward6Overflow }</td>
						<td>${ward6Admission }</td>
						<td>${ward6TransIn }</td>
						<td>${ward6TransOut }</td>
						<td>${ward6Discharged }</td>
						<td>${ward6Deaths }</td>
						<td>${ward6Absconded }</td>
						<td>${ward6HomeAgainstAdvice }</td>
						<td>${ward6HomePerRequest }</td>
						<td>${ward6Operations }</td>
						<td>${ward6Deliveries }</td>
						<td>${ward6RoomingIn }</td>
						<td>${ward6OutOnPass }</td>
						<td>${ward6Remarks }</td>
					</tr>
					<tr>
						<td>Ward 7</td>
						<td>${ward7BedCapacity }</td>
						<td>${ward7TotalLast }</td>
						<td>${ward7DailyOccupancyRate }</td>
						<td>${ward7Overflow }</td>
						<td>${ward7Admission }</td>
						<td>${ward7TransIn }</td>
						<td>${ward7TransOut }</td>
						<td>${ward7Discharged }</td>
						<td>${ward7Deaths }</td>
						<td>${ward7Absconded }</td>
						<td>${ward7HomeAgainstAdvice }</td>
						<td>${ward7HomePerRequest }</td>
						<td>${ward7Operations }</td>
						<td>${ward7Deliveries }</td>
						<td>${ward7RoomingIn }</td>
						<td>${ward7OutOnPass }</td>
						<td>${ward7Remarks }</td>
					</tr>
					<tr>
						<td>Ward 8</td>
						<td>${ward8BedCapacity }</td>
						<td>${ward8TotalLast }</td>
						<td>${ward8DailyOccupancyRate }</td>
						<td>${ward8Overflow }</td>
						<td>${ward8Admission }</td>
						<td>${ward8TransIn }</td>
						<td>${ward8TransOut }</td>
						<td>${ward8Discharged }</td>
						<td>${ward8Deaths }</td>
						<td>${ward8Absconded }</td>
						<td>${ward8HomeAgainstAdvice }</td>
						<td>${ward8HomePerRequest }</td>
						<td>${ward8Operations }</td>
						<td>${ward8Deliveries }</td>
						<td>${ward8RoomingIn }</td>
						<td>${ward8OutOnPass }</td>
						<td>${ward8Remarks }</td>
					</tr>
					<tr>
						<td>Ward 9</td>
						<td>${ward9BedCapacity }</td>
						<td>${ward9TotalLast }</td>
						<td>${ward9DailyOccupancyRate }</td>
						<td>${ward9Overflow }</td>
						<td>${ward9Admission }</td>
						<td>${ward9TransIn }</td>
						<td>${ward9TransOut }</td>
						<td>${ward9Discharged }</td>
						<td>${ward9Deaths }</td>
						<td>${ward9Absconded }</td>
						<td>${ward9HomeAgainstAdvice }</td>
						<td>${ward9HomePerRequest }</td>
						<td>${ward9Operations }</td>
						<td>${ward9Deliveries }</td>
						<td>${ward9RoomingIn }</td>
						<td>${ward9OutOnPass }</td>
						<td>${ward9Remarks }</td>
					</tr>
					<tr>
						<td>Ward 10</td>
						<td>${ward10BedCapacity }</td>
						<td>${ward10TotalLast }</td>
						<td>${ward10DailyOccupancyRate }</td>
						<td>${ward10Overflow }</td>
						<td>${ward10Admission }</td>
						<td>${ward10TransIn }</td>
						<td>${ward10TransOut }</td>
						<td>${ward10Discharged }</td>
						<td>${ward10Deaths }</td>
						<td>${ward10Absconded }</td>
						<td>${ward10HomeAgainstAdvice }</td>
						<td>${ward10HomePerRequest }</td>
						<td>${ward10Operations }</td>
						<td>${ward10Deliveries }</td>
						<td>${ward10RoomingIn }</td>
						<td>${ward10OutOnPass }</td>
						<td>${ward10Remarks }</td>
					</tr>
					<tr>
						<td>Ward 11</td>
						<td>${ward11BedCapacity }</td>
						<td>${ward11TotalLast }</td>
						<td>${ward11DailyOccupancyRate }</td>
						<td>${ward11Overflow }</td>
						<td>${ward11Admission }</td>
						<td>${ward11TransIn }</td>
						<td>${ward11TransOut }</td>
						<td>${ward11Discharged }</td>
						<td>${ward11Deaths }</td>
						<td>${ward11Absconded }</td>
						<td>${ward11HomeAgainstAdvice }</td>
						<td>${ward11HomePerRequest }</td>
						<td>${ward11Operations }</td>
						<td>${ward11Deliveries }</td>
						<td>${ward11RoomingIn }</td>
						<td>${ward11OutOnPass }</td>
						<td>${ward11Remarks }</td>
					</tr>
					<tr>
						<td>Ward 14-B</td>
						<td>${ward14BBedCapacity }</td>
						<td>${ward14BTotalLast }</td>
						<td>${ward14BDailyOccupancyRate }</td>
						<td>${ward14BOverflow }</td>
						<td>${ward14BAdmission }</td>
						<td>${ward14BTransIn }</td>
						<td>${ward14BTransOut }</td>
						<td>${ward14BDischarged }</td>
						<td>${ward14BDeaths }</td>
						<td>${ward14BAbsconded }</td>
						<td>${ward14BHomeAgainstAdvice }</td>
						<td>${ward14BHomePerRequest }</td>
						<td>${ward14BOperations }</td>
						<td>${ward14BDeliveries }</td>
						<td>${ward14BRoomingIn }</td>
						<td>${ward14BOutOnPass }</td>
						<td>${ward14BRemarks }</td>
					</tr>
					<tr>
						<td>Ward 15</td>
						<td>${ward15BedCapacity }</td>
						<td>${ward15TotalLast }</td>
						<td>${ward15DailyOccupancyRate }</td>
						<td>${ward15Overflow }</td>
						<td>${ward15Admission }</td>
						<td>${ward15TransIn }</td>
						<td>${ward15TransOut }</td>
						<td>${ward15Discharged }</td>
						<td>${ward15Deaths }</td>
						<td>${ward15Absconded }</td>
						<td>${ward15HomeAgainstAdvice }</td>
						<td>${ward15HomePerRequest }</td>
						<td>${ward15Operations }</td>
						<td>${ward15Deliveries }</td>
						<td>${ward15RoomingIn }</td>
						<td>${ward15OutOnPass }</td>
						<td>${ward15Remarks }</td>
					</tr>
					<tr>
						<td>Ward 16</td>
						<td>${ward16BedCapacity }</td>
						<td>${ward16TotalLast }</td>
						<td>${ward16DailyOccupancyRate }</td>
						<td>${ward16Overflow }</td>
						<td>${ward16Admission }</td>
						<td>${ward16TransIn }</td>
						<td>${ward16TransOut }</td>
						<td>${ward16Discharged }</td>
						<td>${ward16Deaths }</td>
						<td>${ward16Absconded }</td>
						<td>${ward16HomeAgainstAdvice }</td>
						<td>${ward16HomePerRequest }</td>
						<td>${ward16Operations }</td>
						<td>${ward16Deliveries }</td>
						<td>${ward16RoomingIn }</td>
						<td>${ward16OutOnPass }</td>
						<td>${ward16Remarks }</td>
					</tr>
					<tr>
						<td>RCB1 4th</td>
						<td>${rCB14thBedCapacity }</td>
						<td>${rCB14thTotalLast }</td>
						<td>${rCB14thDailyOccupancyRate }</td>
						<td>${rCB14thOverflow }</td>
						<td>${rCB14thAdmission }</td>
						<td>${rCB14thTransIn }</td>
						<td>${rCB14thTransOut }</td>
						<td>${rCB14thDischarged }</td>
						<td>${rCB14thDeaths }</td>
						<td>${rCB14thAbsconded }</td>
						<td>${rCB14thHomeAgainstAdvice }</td>
						<td>${rCB14thHomePerRequest }</td>
						<td>${rCB14thOperations }</td>
						<td>${rCB14thDeliveries }</td>
						<td>${rCB14thRoomingIn }</td>
						<td>${rCB14thOutOnPass }</td>
						<td>${rCB14thRemarks }</td>
					</tr>
					<tr>
						<td>RCB2 4th</td>
						<td>${rCB24thBedCapacity }</td>
						<td>${rCB24thTotalLast }</td>
						<td>${rCB24thDailyOccupancyRate }</td>
						<td>${rCB24thOverflow }</td>
						<td>${rCB24thAdmission }</td>
						<td>${rCB24thTransIn }</td>
						<td>${rCB24thTransOut }</td>
						<td>${rCB24thDischarged }</td>
						<td>${rCB24thDeaths }</td>
						<td>${rCB24thAbsconded }</td>
						<td>${rCB24thHomeAgainstAdvice }</td>
						<td>${rCB24thHomePerRequest }</td>
						<td>${rCB24thOperations }</td>
						<td>${rCB24thDeliveries }</td>
						<td>${rCB24thRoomingIn }</td>
						<td>${rCB24thOutOnPass }</td>
						<td>${rCB24thRemarks }</td>
					</tr>
					<tr>
						<td>LCB1 4th</td>
						<td>${lCB14thBedCapacity }</td>
						<td>${lCB14thTotalLast }</td>
						<td>${lCB14thDailyOccupancyRate }</td>
						<td>${lCB14thOverflow }</td>
						<td>${lCB14thAdmission }</td>
						<td>${lCB14thTransIn }</td>
						<td>${lCB14thTransOut }</td>
						<td>${lCB14thDischarged }</td>
						<td>${lCB14thDeaths }</td>
						<td>${lCB14thAbsconded }</td>
						<td>${lCB14thHomeAgainstAdvice }</td>
						<td>${lCB14thHomePerRequest }</td>
						<td>${lCB14thOperations }</td>
						<td>${lCB14thDeliveries }</td>
						<td>${lCB14thRoomingIn }</td>
						<td>${lCB14thOutOnPass }</td>
						<td>${lCB14thRemarks }</td>
					</tr>
					<tr>
						<td>LCB2 4th</td>
						<td>${lCB24thBedCapacity }</td>
						<td>${lCB24thTotalLast }</td>
						<td>${lCB24thDailyOccupancyRate }</td>
						<td>${lCB24thOverflow }</td>
						<td>${lCB24thAdmission }</td>
						<td>${lCB24thTransIn }</td>
						<td>${lCB24thTransOut }</td>
						<td>${lCB24thDischarged }</td>
						<td>${lCB24thDeaths }</td>
						<td>${lCB24thAbsconded }</td>
						<td>${lCB24thHomeAgainstAdvice }</td>
						<td>${lCB24thHomePerRequest }</td>
						<td>${lCB24thOperations }</td>
						<td>${lCB24thDeliveries }</td>
						<td>${lCB24thRoomingIn }</td>
						<td>${lCB24thOutOnPass }</td>
						<td>${lCB24thRemarks }</td>
					</tr>
					<tr>
						<td>RCB1 5th</td>
						<td>${rCB15thBedCapacity }</td>
						<td>${rCB15thTotalLast }</td>
						<td>${rCB15thDailyOccupancyRate }</td>
						<td>${rCB15thOverflow }</td>
						<td>${rCB15thAdmission }</td>
						<td>${rCB15thTransIn }</td>
						<td>${rCB15thTransOut }</td>
						<td>${rCB15thDischarged }</td>
						<td>${rCB15thDeaths }</td>
						<td>${rCB15thAbsconded }</td>
						<td>${rCB15thHomeAgainstAdvice }</td>
						<td>${rCB15thHomePerRequest }</td>
						<td>${rCB15thOperations }</td>
						<td>${rCB15thDeliveries }</td>
						<td>${rCB15thRoomingIn }</td>
						<td>${rCB15thOutOnPass }</td>
						<td>${rCB15thRemarks }</td>
					</tr>
					<tr>
						<td>RCB2 5th</td>
						<td>${rCB25thBedCapacity }</td>
						<td>${rCB25thTotalLast }</td>
						<td>${rCB25thDailyOccupancyRate }</td>
						<td>${rCB25thOverflow }</td>
						<td>${rCB25thAdmission }</td>
						<td>${rCB25thTransIn }</td>
						<td>${rCB25thTransOut }</td>
						<td>${rCB25thDischarged }</td>
						<td>${rCB25thDeaths }</td>
						<td>${rCB25thAbsconded }</td>
						<td>${rCB25thHomeAgainstAdvice }</td>
						<td>${rCB25thHomePerRequest }</td>
						<td>${rCB25thOperations }</td>
						<td>${rCB25thDeliveries }</td>
						<td>${rCB25thRoomingIn }</td>
						<td>${rCB25thOutOnPass }</td>
						<td>${rCB25thRemarks }</td>
					</tr>
					<tr>
						<td>LCB1 5th</td>
						<td>${lCB15thBedCapacity }</td>
						<td>${lCB15thTotalLast }</td>
						<td>${lCB15thDailyOccupancyRate }</td>
						<td>${lCB15thOverflow }</td>
						<td>${lCB15thAdmission }</td>
						<td>${lCB15thTransIn }</td>
						<td>${lCB15thTransOut }</td>
						<td>${lCB15thDischarged }</td>
						<td>${lCB15thDeaths }</td>
						<td>${lCB15thAbsconded }</td>
						<td>${lCB15thHomeAgainstAdvice }</td>
						<td>${lCB15thHomePerRequest }</td>
						<td>${lCB15thOperations }</td>
						<td>${lCB15thDeliveries }</td>
						<td>${lCB15thRoomingIn }</td>
						<td>${lCB15thOutOnPass }</td>
						<td>${lCB15thRemarks }</td>
					</tr>
					<tr>
						<td>LCB2 5th</td>
						<td>${lCB25thBedCapacity }</td>
						<td>${lCB25thTotalLast }</td>
						<td>${lCB25thDailyOccupancyRate }</td>
						<td>${lCB25thOverflow }</td>
						<td>${lCB25thAdmission }</td>
						<td>${lCB25thTransIn }</td>
						<td>${lCB25thTransOut }</td>
						<td>${lCB25thDischarged }</td>
						<td>${lCB25thDeaths }</td>
						<td>${lCB25thAbsconded }</td>
						<td>${lCB25thHomeAgainstAdvice }</td>
						<td>${lCB25thHomePerRequest }</td>
						<td>${lCB25thOperations }</td>
						<td>${lCB25thDeliveries }</td>
						<td>${lCB25thRoomingIn }</td>
						<td>${lCB25thOutOnPass }</td>
						<td>${lCB25thRemarks }</td>
					</tr>
					<tr>
						<td>RCB1 6th</td>
						<td>${rCB16thBedCapacity }</td>
						<td>${rCB16thTotalLast }</td>
						<td>${rCB16thDailyOccupancyRate }</td>
						<td>${rCB16thOverflow }</td>
						<td>${rCB16thAdmission }</td>
						<td>${rCB16thTransIn }</td>
						<td>${rCB16thTransOut }</td>
						<td>${rCB16thDischarged }</td>
						<td>${rCB16thDeaths }</td>
						<td>${rCB16thAbsconded }</td>
						<td>${rCB16thHomeAgainstAdvice }</td>
						<td>${rCB16thHomePerRequest }</td>
						<td>${rCB16thOperations }</td>
						<td>${rCB16thDeliveries }</td>
						<td>${rCB16thRoomingIn }</td>
						<td>${rCB16thOutOnPass }</td>
						<td>${rCB16thRemarks }</td>
					</tr>
					<tr>
						<td>RCB2 6th</td>
						<td>${rCB26thBedCapacity }</td>
						<td>${rCB26thTotalLast }</td>
						<td>${rCB26thDailyOccupancyRate }</td>
						<td>${rCB26thOverflow }</td>
						<td>${rCB26thAdmission }</td>
						<td>${rCB26thTransIn }</td>
						<td>${rCB26thTransOut }</td>
						<td>${rCB26thDischarged }</td>
						<td>${rCB26thDeaths }</td>
						<td>${rCB26thAbsconded }</td>
						<td>${rCB26thHomeAgainstAdvice }</td>
						<td>${rCB26thHomePerRequest }</td>
						<td>${rCB26thOperations }</td>
						<td>${rCB26thDeliveries }</td>
						<td>${rCB26thRoomingIn }</td>
						<td>${rCB26thOutOnPass }</td>
						<td>${rCB26thRemarks }</td>
					</tr>
					<tr>
						<td>7th LCB</td>
						<td>${seventhLCBBedCapacity }</td>
						<td>${seventhLCBTotalLast }</td>
						<td>${seventhLCBDailyOccupancyRate }</td>
						<td>${seventhLCBOverflow }</td>
						<td>${seventhLCBAdmission }</td>
						<td>${seventhLCBTransIn }</td>
						<td>${seventhLCBTransOut }</td>
						<td>${seventhLCBDischarged }</td>
						<td>${seventhLCBDeaths }</td>
						<td>${seventhLCBAbsconded }</td>
						<td>${seventhLCBHomeAgainstAdvice }</td>
						<td>${seventhLCBHomePerRequest }</td>
						<td>${seventhLCBOperations }</td>
						<td>${seventhLCBDeliveries }</td>
						<td>${seventhLCBRoomingIn }</td>
						<td>${seventhLCBOutOnPass }</td>
						<td>${seventhLCBRemarks }</td>
					</tr>
					<tr>
						<td>7th RCB</td>
						<td>${seventhRCBBedCapacity }</td>
						<td>${seventhRCBTotalLast }</td>
						<td>${seventhRCBDailyOccupancyRate }</td>
						<td>${seventhRCBOverflow }</td>
						<td>${seventhRCBAdmission }</td>
						<td>${seventhRCBTransIn }</td>
						<td>${seventhRCBTransOut }</td>
						<td>${seventhRCBDischarged }</td>
						<td>${seventhRCBDeaths }</td>
						<td>${seventhRCBAbsconded }</td>
						<td>${seventhRCBHomeAgainstAdvice }</td>
						<td>${seventhRCBHomePerRequest }</td>
						<td>${seventhRCBOperations }</td>
						<td>${seventhRCBDeliveries }</td>
						<td>${seventhRCBRoomingIn }</td>
						<td>${seventhRCBOutOnPass }</td>
						<td>${seventhRCBRemarks }</td>
					</tr>
					<tr>
						<td>SOJR</td>
						<td>${sOJRBedCapacity }</td>
						<td>${sOJRTotalLast }</td>
						<td>${sOJRDailyOccupancyRate }</td>
						<td>${sOJROverflow }</td>
						<td>${sOJRAdmission }</td>
						<td>${sOJRTransIn }</td>
						<td>${sOJRTransOut }</td>
						<td>${sOJRDischarged }</td>
						<td>${sOJRDeaths }</td>
						<td>${sOJRAbsconded }</td>
						<td>${sOJRHomeAgainstAdvice }</td>
						<td>${sOJRHomePerRequest }</td>
						<td>${sOJROperations }</td>
						<td>${sOJRDeliveries }</td>
						<td>${sOJRRoomingIn }</td>
						<td>${sOJROutOnPass }</td>
						<td>${sOJRRemarks }</td>
					</tr>
					<tr>
						<td>SPINE</td>
						<td>${sPINEBedCapacity }</td>
						<td>${sPINETotalLast }</td>
						<td>${sPINEDailyOccupancyRate }</td>
						<td>${sPINEOverflow }</td>
						<td>${sPINEAdmission }</td>
						<td>${sPINETransIn }</td>
						<td>${sPINETransOut }</td>
						<td>${sPINEDischarged }</td>
						<td>${sPINEDeaths }</td>
						<td>${sPINEAbsconded }</td>
						<td>${sPINEHomeAgainstAdvice }</td>
						<td>${sPINEHomePerRequest }</td>
						<td>${sPINEOperations }</td>
						<td>${sPINEDeliveries }</td>
						<td>${sPINERoomingIn }</td>
						<td>${sPINEOutOnPass }</td>
						<td>${sPINERemarks }</td>
					</tr>
					<tr>
						<td>STROKE</td>
						<td>${sTROKEBedCapacity }</td>
						<td>${sTROKETotalLast }</td>
						<td>${sTROKEDailyOccupancyRate }</td>
						<td>${sTROKEOverflow }</td>
						<td>${sTROKEAdmission }</td>
						<td>${sTROKETransIn }</td>
						<td>${sTROKETransOut }</td>
						<td>${sTROKEDischarged }</td>
						<td>${sTROKEDeaths }</td>
						<td>${sTROKEAbsconded }</td>
						<td>${sTROKEHomeAgainstAdvice }</td>
						<td>${sTROKEHomePerRequest }</td>
						<td>${sTROKEOperations }</td>
						<td>${sTROKEDeliveries }</td>
						<td>${sTROKERoomingIn }</td>
						<td>${sTROKEOutOnPass }</td>
						<td>${sTROKERemarks }</td>
					</tr>
					<tr>
						<td>MICU</td>
						<td>${mICUBedCapacity }</td>
						<td>${mICUTotalLast }</td>
						<td>${mICUDailyOccupancyRate }</td>
						<td>${mICUOverflow }</td>
						<td>${mICUAdmission }</td>
						<td>${mICUTransIn }</td>
						<td>${mICUTransOut }</td>
						<td>${mICUDischarged }</td>
						<td>${mICUDeaths }</td>
						<td>${mICUAbsconded }</td>
						<td>${mICUHomeAgainstAdvice }</td>
						<td>${mICUHomePerRequest }</td>
						<td>${mICUOperations }</td>
						<td>${mICUDeliveries }</td>
						<td>${mICURoomingIn }</td>
						<td>${mICUOutOnPass }</td>
						<td>${mICURemarks }</td>
					</tr>
					<tr>
						<td>CENICU</td>
						<td>${cENICUBedCapacity }</td>
						<td>${cENICUTotalLast }</td>
						<td>${cENICUDailyOccupancyRate }</td>
						<td>${cENICUOverflow }</td>
						<td>${cENICUAdmission }</td>
						<td>${cENICUTransIn }</td>
						<td>${cENICUTransOut }</td>
						<td>${cENICUDischarged }</td>
						<td>${cENICUDeaths }</td>
						<td>${cENICUAbsconded }</td>
						<td>${cENICUHomeAgainstAdvice }</td>
						<td>${cENICUHomePerRequest }</td>
						<td>${cENICUOperations }</td>
						<td>${cENICUDeliveries }</td>
						<td>${cENICURoomingIn }</td>
						<td>${cENICUOutOnPass }</td>
						<td>${cENICURemarks }</td>
					</tr>
					<tr>
						<td>PICU</td>
						<td>${pICUBedCapacity }</td>
						<td>${pICUTotalLast }</td>
						<td>${pICUDailyOccupancyRate }</td>
						<td>${pICUOverflow }</td>
						<td>${pICUAdmission }</td>
						<td>${pICUTransIn }</td>
						<td>${pICUTransOut }</td>
						<td>${pICUDischarged }</td>
						<td>${pICUDeaths }</td>
						<td>${pICUAbsconded }</td>
						<td>${pICUHomeAgainstAdvice }</td>
						<td>${pICUHomePerRequest }</td>
						<td>${pICUOperations }</td>
						<td>${pICUDeliveries }</td>
						<td>${pICURoomingIn }</td>
						<td>${pICUOutOnPass }</td>
						<td>${pICURemarks }</td>
					</tr>
					<tr>
						<td>BURN UNIT</td>
						<td>${bURNUNITBedCapacity }</td>
						<td>${bURNUNITTotalLast }</td>
						<td>${bURNUNITDailyOccupancyRate }</td>
						<td>${bURNUNITOverflow }</td>
						<td>${bURNUNITAdmission }</td>
						<td>${bURNUNITTransIn }</td>
						<td>${bURNUNITTransOut }</td>
						<td>${bURNUNITDischarged }</td>
						<td>${bURNUNITDeaths }</td>
						<td>${bURNUNITAbsconded }</td>
						<td>${bURNUNITHomeAgainstAdvice }</td>
						<td>${bURNUNITHomePerRequest }</td>
						<td>${bURNUNITOperations }</td>
						<td>${bURNUNITDeliveries }</td>
						<td>${bURNUNITRoomingIn }</td>
						<td>${bURNUNITOutOnPass }</td>
						<td>${bURNUNITRemarks }</td>
					</tr>
					<tr>
						<td>SICU</td>
						<td>${sICUBedCapacity }</td>
						<td>${sICUTotalLast }</td>
						<td>${sICUDailyOccupancyRate }</td>
						<td>${sICUOverflow }</td>
						<td>${sICUAdmission }</td>
						<td>${sICUTransIn }</td>
						<td>${sICUTransOut }</td>
						<td>${sICUDischarged }</td>
						<td>${sICUDeaths }</td>
						<td>${sICUAbsconded }</td>
						<td>${sICUHomeAgainstAdvice }</td>
						<td>${sICUHomePerRequest }</td>
						<td>${sICUOperations }</td>
						<td>${sICUDeliveries }</td>
						<td>${sICURoomingIn }</td>
						<td>${sICUOutOnPass }</td>
						<td>${sICURemarks }</td>
					</tr>
					<tr>
						<td>NSSCU</td>
						<td>${nSSCUBedCapacity }</td>
						<td>${nSSCUTotalLast }</td>
						<td>${nSSCUDailyOccupancyRate }</td>
						<td>${nSSCUOverflow }</td>
						<td>${nSSCUAdmission }</td>
						<td>${nSSCUTransIn }</td>
						<td>${nSSCUTransOut }</td>
						<td>${nSSCUDischarged }</td>
						<td>${nSSCUDeaths }</td>
						<td>${nSSCUAbsconded }</td>
						<td>${nSSCUHomeAgainstAdvice }</td>
						<td>${nSSCUHomePerRequest }</td>
						<td>${nSSCUOperations }</td>
						<td>${nSSCUDeliveries }</td>
						<td>${nSSCURoomingIn }</td>
						<td>${nSSCUOutOnPass }</td>
						<td>${nSSCURemarks }</td>
					</tr>
					<tr>
						<td>NICU</td>
						<td>${nICUBedCapacity }</td>
						<td>${nICUTotalLast }</td>
						<td>${nICUDailyOccupancyRate }</td>
						<td>${nICUOverflow }</td>
						<td>${nICUAdmission }</td>
						<td>${nICUTransIn }</td>
						<td>${nICUTransOut }</td>
						<td>${nICUDischarged }</td>
						<td>${nICUDeaths }</td>
						<td>${nICUAbsconded }</td>
						<td>${nICUHomeAgainstAdvice }</td>
						<td>${nICUHomePerRequest }</td>
						<td>${nICUOperations }</td>
						<td>${nICUDeliveries }</td>
						<td>${nICURoomingIn }</td>
						<td>${nICUOutOnPass }</td>
						<td>${nICURemarks }</td>
					</tr>
					<tr>
						<td>NEONATAL ICU</td>
						<td>${nEONATALICUBedCapacity }</td>
						<td>${nEONATALICUTotalLast }</td>
						<td>${nEONATALICUDailyOccupancyRate }</td>
						<td>${nEONATALICUOverflow }</td>
						<td>${nEONATALICUAdmission }</td>
						<td>${nEONATALICUTransIn }</td>
						<td>${nEONATALICUTransOut }</td>
						<td>${nEONATALICUDischarged }</td>
						<td>${nEONATALICUDeaths }</td>
						<td>${nEONATALICUAbsconded }</td>
						<td>${nEONATALICUHomeAgainstAdvice }</td>
						<td>${nEONATALICUHomePerRequest }</td>
						<td>${nEONATALICUOperations }</td>
						<td>${nEONATALICUDeliveries }</td>
						<td>${nEONATALICURoomingIn }</td>
						<td>${nEONATALICUOutOnPass }</td>
						<td>${nEONATALICURemarks }</td>
					</tr>
					<tr>
						<td>IMU/RR</td>
						<td>${iMURRBedCapacity }</td>
						<td>${iMURRTotalLast }</td>
						<td>${iMURRDailyOccupancyRate }</td>
						<td>${iMURROverflow }</td>
						<td>${iMURRAdmission }</td>
						<td>${iMURRTransIn }</td>
						<td>${iMURRTransOut }</td>
						<td>${iMURRDischarged }</td>
						<td>${iMURRDeaths }</td>
						<td>${iMURRAbsconded }</td>
						<td>${iMURRHomeAgainstAdvice }</td>
						<td>${iMURRHomePerRequest }</td>
						<td>${iMURROperations }</td>
						<td>${iMURRDeliveries }</td>
						<td>${iMURRRoomingIn }</td>
						<td>${iMURROutOnPass }</td>
						<td>${iMURRRemarks }</td>
					</tr>
					<tr>
						<td>RADIUM</td>
						<td>${rADIUMBedCapacity }</td>
						<td>${rADIUMTotalLast }</td>
						<td>${rADIUMDailyOccupancyRate }</td>
						<td>${rADIUMOverflow }</td>
						<td>${rADIUMAdmission }</td>
						<td>${rADIUMTransIn }</td>
						<td>${rADIUMTransOut }</td>
						<td>${rADIUMDischarged }</td>
						<td>${rADIUMDeaths }</td>
						<td>${rADIUMAbsconded }</td>
						<td>${rADIUMHomeAgainstAdvice }</td>
						<td>${rADIUMHomePerRequest }</td>
						<td>${rADIUMOperations }</td>
						<td>${rADIUMDeliveries }</td>
						<td>${rADIUMRoomingIn }</td>
						<td>${rADIUMOutOnPass }</td>
						<td>${rADIUMRemarks }</td>
					</tr>
					<tr>
						<td>CI</td>
						<td>${cIBedCapacity }</td>
						<td>${cITotalLast }</td>
						<td>${cIDailyOccupancyRate }</td>
						<td>${cIOverflow }</td>
						<td>${cIAdmission }</td>
						<td>${cITransIn }</td>
						<td>${cITransOut }</td>
						<td>${cIDischarged }</td>
						<td>${cIDeaths }</td>
						<td>${cIAbsconded }</td>
						<td>${cIHomeAgainstAdvice }</td>
						<td>${cIHomePerRequest }</td>
						<td>${cIOperations }</td>
						<td>${cIDeliveries }</td>
						<td>${cIRoomingIn }</td>
						<td>${cIOutOnPass }</td>
						<td>${cIRemarks }</td>
					</tr>
					<tr>
						<td>DEM/PER</td>
						<td>${dEMPERBedCapacity }</td>
						<td>${dEMPERTotalLast }</td>
						<td>${dEMPERDailyOccupancyRate }</td>
						<td>${dEMPEROverflow }</td>
						<td>${dEMPERAdmission }</td>
						<td>${dEMPERTransIn }</td>
						<td>${dEMPERTransOut }</td>
						<td>${dEMPERDischarged }</td>
						<td>${dEMPERDeaths }</td>
						<td>${dEMPERAbsconded }</td>
						<td>${dEMPERHomeAgainstAdvice }</td>
						<td>${dEMPERHomePerRequest }</td>
						<td>${dEMPEROperations }</td>
						<td>${dEMPERDeliveries }</td>
						<td>${dEMPERRoomingIn }</td>
						<td>${dEMPEROutOnPass }</td>
						<td>${dEMPERRemarks }</td>
					</tr>
					<tr>
						<td>OU</td>
						<td>${oUBedCapacity }</td>
						<td>${oUTotalLast }</td>
						<td>${oUDailyOccupancyRate }</td>
						<td>${oUOverflow }</td>
						<td>${oUAdmission }</td>
						<td>${oUTransIn }</td>
						<td>${oUTransOut }</td>
						<td>${oUDischarged }</td>
						<td>${oUDeaths }</td>
						<td>${oUAbsconded }</td>
						<td>${oUHomeAgainstAdvice }</td>
						<td>${oUHomePerRequest }</td>
						<td>${oUOperations }</td>
						<td>${oUDeliveries }</td>
						<td>${oURoomingIn }</td>
						<td>${oUOutOnPass }</td>
						<td>${oURemarks }</td>
					</tr>
					<tr>
						<td>ACU</td>
						<td>${aCUBedCapacity }</td>
						<td>${aCUTotalLast }</td>
						<td>${aCUDailyOccupancyRate }</td>
						<td>${aCUOverflow }</td>
						<td>${aCUAdmission }</td>
						<td>${aCUTransIn }</td>
						<td>${aCUTransOut }</td>
						<td>${aCUDischarged }</td>
						<td>${aCUDeaths }</td>
						<td>${aCUAbsconded }</td>
						<td>${aCUHomeAgainstAdvice }</td>
						<td>${aCUHomePerRequest }</td>
						<td>${aCUOperations }</td>
						<td>${aCUDeliveries }</td>
						<td>${aCURoomingIn }</td>
						<td>${aCUOutOnPass }</td>
						<td>${aCURemarks }</td>
					</tr>
					<tr>
						<td>AMBU</td>
						<td>${aMBUBedCapacity }</td>
						<td>${aMBUTotalLast }</td>
						<td>${aMBUDailyOccupancyRate }</td>
						<td>${aMBUOverflow }</td>
						<td>${aMBUAdmission }</td>
						<td>${aMBUTransIn }</td>
						<td>${aMBUTransOut }</td>
						<td>${aMBUDischarged }</td>
						<td>${aMBUDeaths }</td>
						<td>${aMBUAbsconded }</td>
						<td>${aMBUHomeAgainstAdvice }</td>
						<td>${aMBUHomePerRequest }</td>
						<td>${aMBUOperations }</td>
						<td>${aMBUDeliveries }</td>
						<td>${aMBURoomingIn }</td>
						<td>${aMBUOutOnPass }</td>
						<td>${aMBURemarks }</td>
					</tr>
					<tr>
						<td>RCB OR</td>
						<td>${rCBORBedCapacity }</td>
						<td>${rCBORTotalLast }</td>
						<td>${rCBORDailyOccupancyRate }</td>
						<td>${rCBOROverflow }</td>
						<td>${rCBORAdmission }</td>
						<td>${rCBORTransIn }</td>
						<td>${rCBORTransOut }</td>
						<td>${rCBORDischarged }</td>
						<td>${rCBORDeaths }</td>
						<td>${rCBORAbsconded }</td>
						<td>${rCBORHomeAgainstAdvice }</td>
						<td>${rCBORHomePerRequest }</td>
						<td>${rCBOROperations }</td>
						<td>${rCBORDeliveries }</td>
						<td>${rCBORRoomingIn }</td>
						<td>${rCBOROutOnPass }</td>
						<td>${rCBORRemarks }</td>
					</tr>
					<tr>
						<td>LCB OR</td>
						<td>${lCBORBedCapacity }</td>
						<td>${lCBORTotalLast }</td>
						<td>${lCBORDailyOccupancyRate }</td>
						<td>${lCBOROverflow }</td>
						<td>${lCBORAdmission }</td>
						<td>${lCBORTransIn }</td>
						<td>${lCBORTransOut }</td>
						<td>${lCBORDischarged }</td>
						<td>${lCBORDeaths }</td>
						<td>${lCBORAbsconded }</td>
						<td>${lCBORHomeAgainstAdvice }</td>
						<td>${lCBORHomePerRequest }</td>
						<td>${lCBOROperations }</td>
						<td>${lCBORDeliveries }</td>
						<td>${lCBORRoomingIn }</td>
						<td>${lCBOROutOnPass }</td>
						<td>${lCBORRemarks }</td>
					</tr>
					<tr>
						<td>PACU</td>
						<td>${pACUBedCapacity }</td>
						<td>${pACUTotalLast }</td>
						<td>${pACUDailyOccupancyRate }</td>
						<td>${pACUOverflow }</td>
						<td>${pACUAdmission }</td>
						<td>${pACUTransIn }</td>
						<td>${pACUTransOut }</td>
						<td>${pACUDischarged }</td>
						<td>${pACUDeaths }</td>
						<td>${pACUAbsconded }</td>
						<td>${pACUHomeAgainstAdvice }</td>
						<td>${pACUHomePerRequest }</td>
						<td>${pACUOperations }</td>
						<td>${pACUDeliveries }</td>
						<td>${pACURoomingIn }</td>
						<td>${pACUOutOnPass }</td>
						<td>${pACURemarks }</td>
					</tr>
					<tr>
						<td>LCB DIALYSIS</td>
						<td>${lCBDIALYSISBedCapacity }</td>
						<td>${lCBDIALYSISTotalLast }</td>
						<td>${lCBDIALYSISDailyOccupancyRate }</td>
						<td>${lCBDIALYSISOverflow }</td>
						<td>${lCBDIALYSISAdmission }</td>
						<td>${lCBDIALYSISTransIn }</td>
						<td>${lCBDIALYSISTransOut }</td>
						<td>${lCBDIALYSISDischarged }</td>
						<td>${lCBDIALYSISDeaths }</td>
						<td>${lCBDIALYSISAbsconded }</td>
						<td>${lCBDIALYSISHomeAgainstAdvice }</td>
						<td>${lCBDIALYSISHomePerRequest }</td>
						<td>${lCBDIALYSISOperations }</td>
						<td>${lCBDIALYSISDeliveries }</td>
						<td>${lCBDIALYSISRoomingIn }</td>
						<td>${lCBDIALYSISOutOnPass }</td>
						<td>${lCBDIALYSISRemarks }</td>
					</tr>
					<tr>
						<td>Cardiac cath lab</td>
						<td>${cardiacCathLabBedCapacity }</td>
						<td>${cardiacCathLabTotalLast }</td>
						<td>${cardiacCathLabDailyOccupancyRate }</td>
						<td>${cardiacCathLabOverflow }</td>
						<td>${cardiacCathLabAdmission }</td>
						<td>${cardiacCathLabTransIn }</td>
						<td>${cardiacCathLabTransOut }</td>
						<td>${cardiacCathLabDischarged }</td>
						<td>${cardiacCathLabDeaths }</td>
						<td>${cardiacCathLabAbsconded }</td>
						<td>${cardiacCathLabHomeAgainstAdvice }</td>
						<td>${cardiacCathLabHomePerRequest }</td>
						<td>${cardiacCathLabOperations }</td>
						<td>${cardiacCathLabDeliveries }</td>
						<td>${cardiacCathLabRoomingIn }</td>
						<td>${cardiacCathLabOutOnPass }</td>
						<td>${cardiacCathLabRemarks }</td>
					</tr>
					<tr>
						<td>Open Heart Transplant</td>
						<td>${openHeartTransplantBedCapacity }</td>
						<td>${openHeartTransplantTotalLast }</td>
						<td>${openHeartTransplantDailyOccupancyRate }</td>
						<td>${openHeartTransplantOverflow }</td>
						<td>${openHeartTransplantAdmission }</td>
						<td>${openHeartTransplantTransIn }</td>
						<td>${openHeartTransplantTransOut }</td>
						<td>${openHeartTransplantDischarged }</td>
						<td>${openHeartTransplantDeaths }</td>
						<td>${openHeartTransplantAbsconded }</td>
						<td>${openHeartTransplantHomeAgainstAdvice }</td>
						<td>${openHeartTransplantHomePerRequest }</td>
						<td>${openHeartTransplantOperations }</td>
						<td>${openHeartTransplantDeliveries }</td>
						<td>${openHeartTransplantRoomingIn }</td>
						<td>${openHeartTransplantOutOnPass }</td>
						<td>${openHeartTransplantRemarks }</td>
					</tr>
					<tr>
						<td>LCB OB OR</td>
						<td>${lCBOBORBedCapacity }</td>
						<td>${lCBOBORTotalLast }</td>
						<td>${lCBOBORDailyOccupancyRate }</td>
						<td>${lCBOBOROverflow }</td>
						<td>${lCBOBORAdmission }</td>
						<td>${lCBOBORTransIn }</td>
						<td>${lCBOBORTransOut }</td>
						<td>${lCBOBORDischarged }</td>
						<td>${lCBOBORDeaths }</td>
						<td>${lCBOBORAbsconded }</td>
						<td>${lCBOBORHomeAgainstAdvice }</td>
						<td>${lCBOBORHomePerRequest }</td>
						<td>${lCBOBOROperations }</td>
						<td>${lCBOBORDeliveries }</td>
						<td>${lCBOBORRoomingIn }</td>
						<td>${lCBOBOROutOnPass }</td>
						<td>${lCBOBORRemarks }</td>
					</tr>
					<tr>
						<td>OBAS</td>
						<td>${oBASBedCapacity }</td>
						<td>${oBASTotalLast }</td>
						<td>${oBASDailyOccupancyRate }</td>
						<td>${oBASOverflow }</td>
						<td>${oBASAdmission }</td>
						<td>${oBASTransIn }</td>
						<td>${oBASTransOut }</td>
						<td>${oBASDischarged }</td>
						<td>${oBASDeaths }</td>
						<td>${oBASAbsconded }</td>
						<td>${oBASHomeAgainstAdvice }</td>
						<td>${oBASHomePerRequest }</td>
						<td>${oBASOperations }</td>
						<td>${oBASDeliveries }</td>
						<td>${oBASRoomingIn }</td>
						<td>${oBASOutOnPass }</td>
						<td>${oBASRemarks }</td>
					</tr>
					<tr>
						<th>CLINICAL AREAS/<br/>UNITS</th>
						<th>BED Capacity</th>
						<th>Total Last</th>
						<th>Daily Occ Rate</th>
						<th>Over-<br/>flow</th>
						<th>Admis-<br/>sion</th>
						<th>Trans-<br/>in</th>
						<th>Trans-<br/>out</th>
						<th>D/C</th>
						<th>Deaths</th>
						<th>Abs-<br/>conded</th>
						<th>HAA</th>
						<th>HPR</th>
						<th>Opera-<br/>tions</th>
						<th>Deli-<br/>veries</th>
						<th>Room-<br/>ing-in</th>
						<th>OOP</th>
						<th>Remarks</th>
					</tr>
				</table>
				<br/>
				Total Hospital Admission: ${totalHospitalAdmission }<br/> 
				Discharges: ${totalDischarged }<br/>
				<br/>
		</div>
	</div>			
</div>
<br/>
<div align="center"><input type="button" value="Print" /></div>
<br/>