package org.openmrs.module.nursingkardex.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.openmrs.api.context.Context;
import org.openmrs.User;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.api.BedService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.api.HospitalReportService;
import org.openmrs.module.nursingkardex.web.form.CensusForm;
import org.openmrs.module.nursingkardex.web.form.NursingProblemForm;

@Controller
public class DailyHospitalCensusReportController {
	
	@RequestMapping(value = "/module/nursingkardex/dailyHospitalCensusReport", method = RequestMethod.GET)
	public void showFrom(ModelMap model)  throws ParseException {
		//endDate = (endDate != null) ? endDate : endDate;
		//endDate = (endDate != null) ? endDate : new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//		endDate = df.parse("03/16/2016");
//		Date startDate = df.parse("01/01/2010");
		CensusForm censusForm = new CensusForm();
		censusForm.setStartDate(DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH));
		censusForm.setEndDate(DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH));
		model.put("censusForm", censusForm);
		model.addAttribute("user", Context.getUserContext().getAuthenticatedUser());
		performSearch(model, censusForm.getStartDate(), censusForm.getEndDate());
	}
	
	@RequestMapping(value = "/module/nursingkardex/dailyHospitalCensusReport", method = RequestMethod.POST)
	public void searchReport(@ModelAttribute("censusForm") CensusForm censusForm, ModelMap model) {
		performSearch(model, censusForm.getStartDate(), censusForm.getEndDate());
	}
	
	private void performSearch(ModelMap model, Date startDate, Date endDate) {
		Nurse nurse = new KardexHelper().deriveNurse();
		Integer locationId = (nurse != null) ? nurse.getLocation().getId() : null;
		HospitalReportService hospitalReportService = Context.getService(HospitalReportService.class);
		
		
		model.put("ward1BedCapacity", hospitalReportService.getBedCapacity(14));
		model.put("ward1TotalLast", hospitalReportService.getTotalLast(14, startDate, endDate));
		model.put("ward1DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(14, startDate, endDate));
		model.put("ward1Overflow", hospitalReportService.getOverflow(14, startDate, endDate));
		model.put("ward1Admission", hospitalReportService.getAdmission(14, startDate, endDate));
		model.put("ward1TransIn", hospitalReportService.getTransIn(14, startDate, endDate));
		model.put("ward1TransOut", hospitalReportService.getTransOut(14, startDate, endDate));
		model.put("ward1Discharged", hospitalReportService.getDischarged(14, startDate, endDate));
		model.put("ward1Deaths", hospitalReportService.getDeaths(14, startDate, endDate));
		model.put("ward1Absconded", hospitalReportService.getAbsconded(14, startDate, endDate));
		model.put("ward1HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(14, startDate, endDate));
		model.put("ward1HomePerRequest", hospitalReportService.getHomePerRequest(14, startDate, endDate));
		model.put("ward1Operations", hospitalReportService.getOperations(14, startDate, endDate));
		model.put("ward1Deliveries", hospitalReportService.getDeliveries(14, startDate, endDate));
		model.put("ward1RoomingIn", hospitalReportService.getRoomingIn(14, startDate, endDate));
		model.put("ward1OutOnPass", hospitalReportService.getOutOnPass(14, startDate, endDate));
		model.put("ward1Remarks", hospitalReportService.getRemarks(14, startDate, endDate));
		
		
		model.put("ward2BedCapacity", hospitalReportService.getBedCapacity(15));
		model.put("ward2TotalLast", hospitalReportService.getTotalLast(15, startDate, endDate));
		model.put("ward2DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(15, startDate, endDate));
		model.put("ward2Overflow", hospitalReportService.getOverflow(15, startDate, endDate));
		model.put("ward2Admission", hospitalReportService.getAdmission(15, startDate, endDate));
		model.put("ward2TransIn", hospitalReportService.getTransIn(15, startDate, endDate));
		model.put("ward2TransOut", hospitalReportService.getTransOut(15, startDate, endDate));
		model.put("ward2Discharged", hospitalReportService.getDischarged(15, startDate, endDate));
		model.put("ward2Deaths", hospitalReportService.getDeaths(15, startDate, endDate));
		model.put("ward2Absconded", hospitalReportService.getAbsconded(15, startDate, endDate));
		model.put("ward2HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(15, startDate, endDate));
		model.put("ward2HomePerRequest", hospitalReportService.getHomePerRequest(15, startDate, endDate));
		model.put("ward2Operations", hospitalReportService.getOperations(15, startDate, endDate));
		model.put("ward2Deliveries", hospitalReportService.getDeliveries(15, startDate, endDate));
		model.put("ward2RoomingIn", hospitalReportService.getRoomingIn(15, startDate, endDate));
		model.put("ward2OutOnPass", hospitalReportService.getOutOnPass(15, startDate, endDate));
		model.put("ward2Remarks", hospitalReportService.getRemarks(15, startDate, endDate));
		
		
		model.put("traumaWardBedCapacity", hospitalReportService.getBedCapacity(28));
		model.put("traumaWardTotalLast", hospitalReportService.getTotalLast(28, startDate, endDate));
		model.put("traumaWardDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(28, startDate, endDate));
		model.put("traumaWardOverflow", hospitalReportService.getOverflow(28, startDate, endDate));
		model.put("traumaWardAdmission", hospitalReportService.getAdmission(28, startDate, endDate));
		model.put("traumaWardTransIn", hospitalReportService.getTransIn(28, startDate, endDate));
		model.put("traumaWardTransOut", hospitalReportService.getTransOut(28, startDate, endDate));
		model.put("traumaWardDischarged", hospitalReportService.getDischarged(28, startDate, endDate));
		model.put("traumaWardDeaths", hospitalReportService.getDeaths(28, startDate, endDate));
		model.put("traumaWardAbsconded", hospitalReportService.getAbsconded(28, startDate, endDate));
		model.put("traumaWardHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(28, startDate, endDate));
		model.put("traumaWardHomePerRequest", hospitalReportService.getHomePerRequest(28, startDate, endDate));
		model.put("traumaWardOperations", hospitalReportService.getOperations(28, startDate, endDate));
		model.put("traumaWardDeliveries", hospitalReportService.getDeliveries(28, startDate, endDate));
		model.put("traumaWardRoomingIn", hospitalReportService.getRoomingIn(28, startDate, endDate));
		model.put("traumaWardOutOnPass", hospitalReportService.getOutOnPass(28, startDate, endDate));
		model.put("traumaWardRemarks", hospitalReportService.getRemarks(28, startDate, endDate));
		
		
		model.put("ward3BedCapacity", hospitalReportService.getBedCapacity(16));
		model.put("ward3TotalLast", hospitalReportService.getTotalLast(16, startDate, endDate));
		model.put("ward3DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(16, startDate, endDate));
		model.put("ward3Overflow", hospitalReportService.getOverflow(16, startDate, endDate));
		model.put("ward3Admission", hospitalReportService.getAdmission(16, startDate, endDate));
		model.put("ward3TransIn", hospitalReportService.getTransIn(16, startDate, endDate));
		model.put("ward3TransOut", hospitalReportService.getTransOut(16, startDate, endDate));
		model.put("ward3Discharged", hospitalReportService.getDischarged(16, startDate, endDate));
		model.put("ward3Deaths", hospitalReportService.getDeaths(16, startDate, endDate));
		model.put("ward3Absconded", hospitalReportService.getAbsconded(16, startDate, endDate));
		model.put("ward3HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(16, startDate, endDate));
		model.put("ward3HomePerRequest", hospitalReportService.getHomePerRequest(16, startDate, endDate));
		model.put("ward3Operations", hospitalReportService.getOperations(16, startDate, endDate));
		model.put("ward3Deliveries", hospitalReportService.getDeliveries(16, startDate, endDate));
		model.put("ward3RoomingIn", hospitalReportService.getRoomingIn(16, startDate, endDate));
		model.put("ward3OutOnPass", hospitalReportService.getOutOnPass(16, startDate, endDate));
		model.put("ward3Remarks", hospitalReportService.getRemarks(16, startDate, endDate));
		
		
		model.put("ward4BedCapacity", hospitalReportService.getBedCapacity(17));
		model.put("ward4TotalLast", hospitalReportService.getTotalLast(17, startDate, endDate));
		model.put("ward4DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(17, startDate, endDate));
		model.put("ward4Overflow", hospitalReportService.getOverflow(17, startDate, endDate));
		model.put("ward4Admission", hospitalReportService.getAdmission(17, startDate, endDate));
		model.put("ward4TransIn", hospitalReportService.getTransIn(17, startDate, endDate));
		model.put("ward4TransOut", hospitalReportService.getTransOut(17, startDate, endDate));
		model.put("ward4Discharged", hospitalReportService.getDischarged(17, startDate, endDate));
		model.put("ward4Deaths", hospitalReportService.getDeaths(17, startDate, endDate));
		model.put("ward4Absconded", hospitalReportService.getAbsconded(17, startDate, endDate));
		model.put("ward4HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(17, startDate, endDate));
		model.put("ward4HomePerRequest", hospitalReportService.getHomePerRequest(17, startDate, endDate));
		model.put("ward4Operations", hospitalReportService.getOperations(17, startDate, endDate));
		model.put("ward4Deliveries", hospitalReportService.getDeliveries(17, startDate, endDate));
		model.put("ward4RoomingIn", hospitalReportService.getRoomingIn(17, startDate, endDate));
		model.put("ward4OutOnPass", hospitalReportService.getOutOnPass(17, startDate, endDate));
		model.put("ward4Remarks", hospitalReportService.getRemarks(17, startDate, endDate));
		
		
		model.put("ward5BedCapacity", hospitalReportService.getBedCapacity(18));
		model.put("ward5TotalLast", hospitalReportService.getTotalLast(18, startDate, endDate));
		model.put("ward5DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(18, startDate, endDate));
		model.put("ward5Overflow", hospitalReportService.getOverflow(18, startDate, endDate));
		model.put("ward5TransIn", hospitalReportService.getTransIn(18, startDate, endDate));
		model.put("ward5TransOut", hospitalReportService.getTransOut(18, startDate, endDate));
		model.put("ward5Discharged", hospitalReportService.getDischarged(18, startDate, endDate));
		model.put("ward5Deaths", hospitalReportService.getDeaths(18, startDate, endDate));
		model.put("ward5Absconded", hospitalReportService.getAbsconded(18, startDate, endDate));
		model.put("ward5HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(18, startDate, endDate));
		model.put("ward5HomePerRequest", hospitalReportService.getHomePerRequest(18, startDate, endDate));
		model.put("ward5Operations", hospitalReportService.getOperations(18, startDate, endDate));
		model.put("ward5Deliveries", hospitalReportService.getDeliveries(18, startDate, endDate));
		model.put("ward5RoomingIn", hospitalReportService.getRoomingIn(18, startDate, endDate));
		model.put("ward5OutOnPass", hospitalReportService.getOutOnPass(18, startDate, endDate));
		model.put("ward5Remarks", hospitalReportService.getRemarks(18, startDate, endDate));
		
		
		model.put("rehabWardBedCapacity", hospitalReportService.getBedCapacity(29));
		model.put("rehabWardTotalLast", hospitalReportService.getTotalLast(29, startDate, endDate));
		model.put("rehabWardDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(29, startDate, endDate));
		model.put("rehabWardOverflow", hospitalReportService.getOverflow(29, startDate, endDate));
		model.put("rehabWardAdmission", hospitalReportService.getAdmission(29, startDate, endDate));
		model.put("rehabWardTransIn", hospitalReportService.getTransIn(29, startDate, endDate));
		model.put("rehabWardTransOut", hospitalReportService.getTransOut(29, startDate, endDate));
		model.put("rehabWardDischarged", hospitalReportService.getDischarged(29, startDate, endDate));
		model.put("rehabWardDeaths", hospitalReportService.getDeaths(29, startDate, endDate));
		model.put("rehabWardAbsconded", hospitalReportService.getAbsconded(29, startDate, endDate));
		model.put("rehabWardHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(29, startDate, endDate));
		model.put("rehabWardHomePerRequest", hospitalReportService.getHomePerRequest(29, startDate, endDate));
		model.put("rehabWardOperations", hospitalReportService.getOperations(29, startDate, endDate));
		model.put("rehabWardDeliveries", hospitalReportService.getDeliveries(29, startDate, endDate));
		model.put("rehabWardRoomingIn", hospitalReportService.getRoomingIn(29, startDate, endDate));
		model.put("rehabWardOutOnPass", hospitalReportService.getOutOnPass(29, startDate, endDate));
		model.put("rehabWardRemarks", hospitalReportService.getRemarks(29, startDate, endDate));
		
		
		model.put("ward6BedCapacity", hospitalReportService.getBedCapacity(19));
		model.put("ward6TotalLast", hospitalReportService.getTotalLast(19, startDate, endDate));
		model.put("ward6DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(19, startDate, endDate));
		model.put("ward6Overflow", hospitalReportService.getOverflow(19, startDate, endDate));
		model.put("ward6Admission", hospitalReportService.getAdmission(19, startDate, endDate));
		model.put("ward6TransIn", hospitalReportService.getTransIn(19, startDate, endDate));
		model.put("ward6TransOut", hospitalReportService.getTransOut(19, startDate, endDate));
		model.put("ward6Discharged", hospitalReportService.getDischarged(19, startDate, endDate));
		model.put("ward6Deaths", hospitalReportService.getDeaths(19, startDate, endDate));
		model.put("ward6Absconded", hospitalReportService.getAbsconded(19, startDate, endDate));
		model.put("ward6HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(19, startDate, endDate));
		model.put("ward6HomePerRequest", hospitalReportService.getHomePerRequest(19, startDate, endDate));
		model.put("ward6Operations", hospitalReportService.getOperations(19, startDate, endDate));
		model.put("ward6Deliveries", hospitalReportService.getDeliveries(19, startDate, endDate));
		model.put("ward6RoomingIn", hospitalReportService.getRoomingIn(19, startDate, endDate));
		model.put("ward6OutOnPass", hospitalReportService.getOutOnPass(19, startDate, endDate));
		model.put("ward6Remarks", hospitalReportService.getRemarks(19, startDate, endDate));
		
		
		model.put("ward7BedCapacity", hospitalReportService.getBedCapacity(20));
		model.put("ward7TotalLast", hospitalReportService.getTotalLast(20, startDate, endDate));
		model.put("ward7DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(20, startDate, endDate));
		model.put("ward7Overflow", hospitalReportService.getOverflow(20, startDate, endDate));
		model.put("ward7Admission", hospitalReportService.getAdmission(20, startDate, endDate));
		model.put("ward7TransIn", hospitalReportService.getTransIn(20, startDate, endDate));
		model.put("ward7TransOut", hospitalReportService.getTransOut(20, startDate, endDate));
		model.put("ward7Discharged", hospitalReportService.getDischarged(20, startDate, endDate));
		model.put("ward7Deaths", hospitalReportService.getDeaths(20, startDate, endDate));
		model.put("ward7Absconded", hospitalReportService.getAbsconded(20, startDate, endDate));
		model.put("ward7HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(20, startDate, endDate));
		model.put("ward7HomePerRequest", hospitalReportService.getHomePerRequest(20, startDate, endDate));
		model.put("ward7Operations", hospitalReportService.getOperations(20, startDate, endDate));
		model.put("ward7Deliveries", hospitalReportService.getDeliveries(20, startDate, endDate));
		model.put("ward7RoomingIn", hospitalReportService.getRoomingIn(20, startDate, endDate));
		model.put("ward7OutOnPass", hospitalReportService.getOutOnPass(20, startDate, endDate));
		model.put("ward7Remarks", hospitalReportService.getRemarks(20, startDate, endDate));

		
		model.put("ward8BedCapacity", hospitalReportService.getBedCapacity(21));
		model.put("ward8TotalLast", hospitalReportService.getTotalLast(21, startDate, endDate));
		model.put("ward8DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(21, startDate, endDate));
		model.put("ward8Overflow", hospitalReportService.getOverflow(21, startDate, endDate));
		model.put("ward8Admission", hospitalReportService.getAdmission(21, startDate, endDate));
		model.put("ward8TransIn", hospitalReportService.getTransIn(21, startDate, endDate));
		model.put("ward8TransOut", hospitalReportService.getTransOut(21, startDate, endDate));
		model.put("ward8Discharged", hospitalReportService.getDischarged(21, startDate, endDate));
		model.put("ward8Deaths", hospitalReportService.getDeaths(21, startDate, endDate));
		model.put("ward8Absconded", hospitalReportService.getAbsconded(21, startDate, endDate));
		model.put("ward8HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(21, startDate, endDate));
		model.put("ward8HomePerRequest", hospitalReportService.getHomePerRequest(21, startDate, endDate));
		model.put("ward8Operations", hospitalReportService.getOperations(21, startDate, endDate));
		model.put("ward8Deliveries", hospitalReportService.getDeliveries(21, startDate, endDate));
		model.put("ward8RoomingIn", hospitalReportService.getRoomingIn(21, startDate, endDate));
		model.put("ward8OutOnPass", hospitalReportService.getOutOnPass(21, startDate, endDate));
		model.put("ward8Remarks", hospitalReportService.getRemarks(21, startDate, endDate));
		
		
		model.put("ward9BedCapacity", hospitalReportService.getBedCapacity(22));
		model.put("ward9TotalLast", hospitalReportService.getTotalLast(22, startDate, endDate));
		model.put("ward9DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(22, startDate, endDate));
		model.put("ward9Overflow", hospitalReportService.getOverflow(22, startDate, endDate));
		model.put("ward9Admission", hospitalReportService.getAdmission(22, startDate, endDate));
		model.put("ward9TransIn", hospitalReportService.getTransIn(22, startDate, endDate));
		model.put("ward9TransOut", hospitalReportService.getTransOut(22, startDate, endDate));
		model.put("ward9Discharged", hospitalReportService.getDischarged(22, startDate, endDate));
		model.put("ward9Deaths", hospitalReportService.getDeaths(22, startDate, endDate));
		model.put("ward9Absconded", hospitalReportService.getAbsconded(22, startDate, endDate));
		model.put("ward9HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(22, startDate, endDate));
		model.put("ward9HomePerRequest", hospitalReportService.getHomePerRequest(22, startDate, endDate));
		model.put("ward9Operations", hospitalReportService.getOperations(22, startDate, endDate));
		model.put("ward9Deliveries", hospitalReportService.getDeliveries(22, startDate, endDate));
		model.put("ward9RoomingIn", hospitalReportService.getRoomingIn(22, startDate, endDate));
		model.put("ward9OutOnPass", hospitalReportService.getOutOnPass(22, startDate, endDate));
		model.put("ward9Remarks", hospitalReportService.getRemarks(22, startDate, endDate));
		
		
		model.put("ward10BedCapacity", hospitalReportService.getBedCapacity(23));
		model.put("ward10TotalLast", hospitalReportService.getTotalLast(23, startDate, endDate));
		model.put("ward10DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(23, startDate, endDate));
		model.put("ward10Overflow", hospitalReportService.getOverflow(23, startDate, endDate));
		model.put("ward10Admission", hospitalReportService.getAdmission(23, startDate, endDate));
		model.put("ward10TransIn", hospitalReportService.getTransIn(23, startDate, endDate));
		model.put("ward10TransOut", hospitalReportService.getTransOut(23, startDate, endDate));
		model.put("ward10Discharged", hospitalReportService.getDischarged(23, startDate, endDate));
		model.put("ward10Deaths", hospitalReportService.getDeaths(23, startDate, endDate));
		model.put("ward10Absconded", hospitalReportService.getAbsconded(23, startDate, endDate));
		model.put("ward10HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(23, startDate, endDate));
		model.put("ward10HomePerRequest", hospitalReportService.getHomePerRequest(23, startDate, endDate));
		model.put("ward10Operations", hospitalReportService.getOperations(23, startDate, endDate));
		model.put("ward10Deliveries", hospitalReportService.getDeliveries(23, startDate, endDate));
		model.put("ward10RoomingIn", hospitalReportService.getRoomingIn(23, startDate, endDate));
		model.put("ward10OutOnPass", hospitalReportService.getOutOnPass(23, startDate, endDate));
		model.put("ward10Remarks", hospitalReportService.getRemarks(23, startDate, endDate));
		
		
		model.put("ward11BedCapacity", hospitalReportService.getBedCapacity(24));
		model.put("ward11TotalLast", hospitalReportService.getTotalLast(24, startDate, endDate));
		model.put("vitalSignsHourly", hospitalReportService.getOutOnPass(24, startDate, endDate));
		model.put("ward11DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(24, startDate, endDate));
		model.put("ward11Overflow", hospitalReportService.getOverflow(24, startDate, endDate));
		model.put("ward11Admission", hospitalReportService.getAdmission(24, startDate, endDate));
		model.put("ward11TransIn", hospitalReportService.getTransIn(24, startDate, endDate));
		model.put("ward11TransOut", hospitalReportService.getTransOut(24, startDate, endDate));
		model.put("ward11Discharged", hospitalReportService.getDischarged(24, startDate, endDate));
		model.put("ward11Deaths", hospitalReportService.getDeaths(24, startDate, endDate));
		model.put("ward11Absconded", hospitalReportService.getAbsconded(24, startDate, endDate));
		model.put("ward11HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(24, startDate, endDate));
		model.put("ward11HomePerRequest", hospitalReportService.getHomePerRequest(24, startDate, endDate));
		model.put("ward11Operations", hospitalReportService.getOperations(24, startDate, endDate));
		model.put("ward11Deliveries", hospitalReportService.getDeliveries(24, startDate, endDate));
		model.put("ward11RoomingIn", hospitalReportService.getRoomingIn(24, startDate, endDate));
		model.put("ward11OutOnPass", hospitalReportService.getOutOnPass(24, startDate, endDate));
		model.put("ward11Remarks", hospitalReportService.getRemarks(24, startDate, endDate));
		
		
		model.put("ward14BBedCapacity", hospitalReportService.getBedCapacity(25));
		model.put("ward14BTotalLast", hospitalReportService.getTotalLast(25, startDate, endDate));
		model.put("ward14BDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(25, startDate, endDate));
		model.put("ward14BOverflow", hospitalReportService.getOverflow(25, startDate, endDate));
		model.put("ward14BAdmission", hospitalReportService.getAdmission(25, startDate, endDate));
		model.put("ward14BTransIn", hospitalReportService.getTransIn(25, startDate, endDate));
		model.put("ward14BTransOut", hospitalReportService.getTransOut(25, startDate, endDate));
		model.put("ward14BDischarged", hospitalReportService.getDischarged(25, startDate, endDate));
		model.put("ward14BDeaths", hospitalReportService.getDeaths(25, startDate, endDate));
		model.put("ward14BAbsconded", hospitalReportService.getAbsconded(25, startDate, endDate));
		model.put("ward14BHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(25, startDate, endDate));
		model.put("ward14BHomePerRequest", hospitalReportService.getHomePerRequest(25, startDate, endDate));
		model.put("ward14BOperations", hospitalReportService.getOperations(25, startDate, endDate));
		model.put("ward14BDeliveries", hospitalReportService.getDeliveries(25, startDate, endDate));
		model.put("ward14BRoomingIn", hospitalReportService.getRoomingIn(25, startDate, endDate));
		model.put("ward14BOutOnPass", hospitalReportService.getOutOnPass(25, startDate, endDate));
		model.put("ward14BRemarks", hospitalReportService.getRemarks(25, startDate, endDate));
		
		
		model.put("ward15BedCapacity", hospitalReportService.getBedCapacity(26));
		model.put("ward15TotalLast", hospitalReportService.getTotalLast(26, startDate, endDate));
		model.put("ward15DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(26, startDate, endDate));
		model.put("ward15Overflow", hospitalReportService.getOverflow(26, startDate, endDate));
		model.put("ward15Admission", hospitalReportService.getAdmission(26, startDate, endDate));
		model.put("ward15TransIn", hospitalReportService.getTransIn(26, startDate, endDate));
		model.put("ward15TransOut", hospitalReportService.getTransOut(26, startDate, endDate));
		model.put("ward15Discharged", hospitalReportService.getDischarged(26, startDate, endDate));
		model.put("ward15Deaths", hospitalReportService.getDeaths(26, startDate, endDate));
		model.put("ward15Absconded", hospitalReportService.getAbsconded(26, startDate, endDate));
		model.put("ward15HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(26, startDate, endDate));
		model.put("ward15HomePerRequest", hospitalReportService.getHomePerRequest(26, startDate, endDate));
		model.put("ward15Operations", hospitalReportService.getOperations(26, startDate, endDate));
		model.put("ward15Deliveries", hospitalReportService.getDeliveries(26, startDate, endDate));
		model.put("ward15RoomingIn", hospitalReportService.getRoomingIn(26, startDate, endDate));
		model.put("ward15OutOnPass", hospitalReportService.getOutOnPass(26, startDate, endDate));
		model.put("ward15Remarks", hospitalReportService.getRemarks(26, startDate, endDate));
		
		
		model.put("ward16BedCapacity", hospitalReportService.getBedCapacity(27));
		model.put("ward16TotalLast", hospitalReportService.getTotalLast(27, startDate, endDate));
		model.put("ward16DailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(27, startDate, endDate));
		model.put("ward16Overflow", hospitalReportService.getOverflow(27, startDate, endDate));
		model.put("ward16Admission", hospitalReportService.getAdmission(27, startDate, endDate));
		model.put("ward16TransIn", hospitalReportService.getTransIn(27, startDate, endDate));
		model.put("ward16TransOut", hospitalReportService.getTransOut(27, startDate, endDate));
		model.put("ward16Discharged", hospitalReportService.getDischarged(27, startDate, endDate));
		model.put("ward16Deaths", hospitalReportService.getDeaths(27, startDate, endDate));
		model.put("ward16Absconded", hospitalReportService.getAbsconded(27, startDate, endDate));
		model.put("ward16HomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(27, startDate, endDate));
		model.put("ward16HomePerRequest", hospitalReportService.getHomePerRequest(27, startDate, endDate));
		model.put("ward16Operations", hospitalReportService.getOperations(27, startDate, endDate));
		model.put("ward16Deliveries", hospitalReportService.getDeliveries(27, startDate, endDate));
		model.put("ward16RoomingIn", hospitalReportService.getRoomingIn(27, startDate, endDate));
		model.put("ward16OutOnPass", hospitalReportService.getOutOnPass(27, startDate, endDate));
		model.put("ward16Remarks", hospitalReportService.getRemarks(27, startDate, endDate));
		

		model.put("rCB14thBedCapacity", hospitalReportService.getBedCapacity(30));
		model.put("rCB14thTotalLast", hospitalReportService.getTotalLast(30, startDate, endDate));
		model.put("rCB14thDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(30, startDate, endDate));
		model.put("rCB14thOverflow", hospitalReportService.getOverflow(30, startDate, endDate));
		model.put("rCB14thAdmission", hospitalReportService.getAdmission(30, startDate, endDate));
		model.put("rCB14thTransIn", hospitalReportService.getTransIn(30, startDate, endDate));
		model.put("rCB14thTransOut", hospitalReportService.getTransOut(30, startDate, endDate));
		model.put("rCB14thDischarged", hospitalReportService.getDischarged(30, startDate, endDate));
		model.put("rCB14thDeaths", hospitalReportService.getDeaths(30, startDate, endDate));
		model.put("rCB14thAbsconded", hospitalReportService.getAbsconded(30, startDate, endDate));
		model.put("rCB14thHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(30, startDate, endDate));
		model.put("rCB14thHomePerRequest", hospitalReportService.getHomePerRequest(30, startDate, endDate));
		model.put("rCB14thOperations", hospitalReportService.getOperations(30, startDate, endDate));
		model.put("rCB14thDeliveries", hospitalReportService.getDeliveries(30, startDate, endDate));
		model.put("rCB14thRoomingIn", hospitalReportService.getRoomingIn(30, startDate, endDate));
		model.put("rCB14thOutOnPass", hospitalReportService.getOutOnPass(30, startDate, endDate));
		model.put("rCB14thRemarks", hospitalReportService.getRemarks(30, startDate, endDate));
		

		model.put("rCB24thBedCapacity", hospitalReportService.getBedCapacity(31));
		model.put("rCB24thTotalLast", hospitalReportService.getTotalLast(31, startDate, endDate));
		model.put("rCB24thDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(31, startDate, endDate));
		model.put("rCB24thOverflow", hospitalReportService.getOverflow(31, startDate, endDate));
		model.put("rCB24thAdmission", hospitalReportService.getAdmission(31, startDate, endDate));
		model.put("rCB24thTransIn", hospitalReportService.getTransIn(31, startDate, endDate));
		model.put("rCB24thTransOut", hospitalReportService.getTransOut(31, startDate, endDate));
		model.put("rCB24thDischarged", hospitalReportService.getDischarged(31, startDate, endDate));
		model.put("rCB24thDeaths", hospitalReportService.getDeaths(31, startDate, endDate));
		model.put("rCB24thAbsconded", hospitalReportService.getAbsconded(31, startDate, endDate));
		model.put("rCB24thHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(31, startDate, endDate));
		model.put("rCB24thHomePerRequest", hospitalReportService.getHomePerRequest(31, startDate, endDate));
		model.put("rCB24thOperations", hospitalReportService.getOperations(31, startDate, endDate));
		model.put("rCB24thDeliveries", hospitalReportService.getDeliveries(31, startDate, endDate));
		model.put("rCB24thRoomingIn", hospitalReportService.getRoomingIn(31, startDate, endDate));
		model.put("rCB24thOutOnPass", hospitalReportService.getOutOnPass(31, startDate, endDate));
		model.put("rCB24thRemarks", hospitalReportService.getRemarks(31, startDate, endDate));
		

		model.put("lCB14thBedCapacity", hospitalReportService.getBedCapacity(32));
		model.put("lCB14thTotalLast", hospitalReportService.getTotalLast(32, startDate, endDate));
		model.put("lCB14thDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(32, startDate, endDate));
		model.put("lCB14thOverflow", hospitalReportService.getOverflow(32, startDate, endDate));
		model.put("lCB14thAdmission", hospitalReportService.getAdmission(32, startDate, endDate));
		model.put("lCB14thTransIn", hospitalReportService.getTransIn(32, startDate, endDate));
		model.put("lCB14thTransOut", hospitalReportService.getTransOut(32, startDate, endDate));
		model.put("lCB14thDischarged", hospitalReportService.getDischarged(32, startDate, endDate));
		model.put("lCB14thDeaths", hospitalReportService.getDeaths(32, startDate, endDate));
		model.put("lCB14thAbsconded", hospitalReportService.getAbsconded(32, startDate, endDate));
		model.put("lCB14thHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(32, startDate, endDate));
		model.put("lCB14thHomePerRequest", hospitalReportService.getHomePerRequest(32, startDate, endDate));
		model.put("lCB14thOperations", hospitalReportService.getOperations(32, startDate, endDate));
		model.put("lCB14thDeliveries", hospitalReportService.getDeliveries(32, startDate, endDate));
		model.put("lCB14thRoomingIn", hospitalReportService.getRoomingIn(32, startDate, endDate));
		model.put("lCB14thOutOnPass", hospitalReportService.getOutOnPass(32, startDate, endDate));
		model.put("lCB14thRemarks", hospitalReportService.getRemarks(32, startDate, endDate));
		

		model.put("lCB24thBedCapacity", hospitalReportService.getBedCapacity(33));
		model.put("lCB24thTotalLast", hospitalReportService.getTotalLast(33, startDate, endDate));
		model.put("lCB24thDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(33, startDate, endDate));
		model.put("lCB24thOverflow", hospitalReportService.getOverflow(33, startDate, endDate));
		model.put("lCB24thAdmission", hospitalReportService.getAdmission(33, startDate, endDate));
		model.put("lCB24thTransIn", hospitalReportService.getTransIn(33, startDate, endDate));
		model.put("lCB24thTransOut", hospitalReportService.getTransOut(33, startDate, endDate));
		model.put("lCB24thDischarged", hospitalReportService.getDischarged(33, startDate, endDate));
		model.put("lCB24thDeaths", hospitalReportService.getDeaths(33, startDate, endDate));
		model.put("lCB24thAbsconded", hospitalReportService.getAbsconded(33, startDate, endDate));
		model.put("lCB24thHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(33, startDate, endDate));
		model.put("lCB24thHomePerRequest", hospitalReportService.getHomePerRequest(33, startDate, endDate));
		model.put("lCB24thOperations", hospitalReportService.getOperations(33, startDate, endDate));
		model.put("lCB24thDeliveries", hospitalReportService.getDeliveries(33, startDate, endDate));
		model.put("lCB24thRoomingIn", hospitalReportService.getRoomingIn(33, startDate, endDate));
		model.put("lCB24thOutOnPass", hospitalReportService.getOutOnPass(33, startDate, endDate));
		model.put("lCB24thRemarks", hospitalReportService.getRemarks(33, startDate, endDate));


		model.put("rCB15thBedCapacity", hospitalReportService.getBedCapacity(34));
		model.put("rCB15thTotalLast", hospitalReportService.getTotalLast(34, startDate, endDate));
		model.put("rCB15thDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(34, startDate, endDate));
		model.put("rCB15thOverflow", hospitalReportService.getOverflow(34, startDate, endDate));
		model.put("rCB15thAdmission", hospitalReportService.getAdmission(34, startDate, endDate));
		model.put("rCB15thTransIn", hospitalReportService.getTransIn(34, startDate, endDate));
		model.put("rCB15thTransOut", hospitalReportService.getTransOut(34, startDate, endDate));
		model.put("rCB15thDischarged", hospitalReportService.getDischarged(34, startDate, endDate));
		model.put("rCB15thDeaths", hospitalReportService.getDeaths(34, startDate, endDate));
		model.put("rCB15thAbsconded", hospitalReportService.getAbsconded(34, startDate, endDate));
		model.put("rCB15thHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(34, startDate, endDate));
		model.put("rCB15thHomePerRequest", hospitalReportService.getHomePerRequest(34, startDate, endDate));
		model.put("rCB15thOperations", hospitalReportService.getOperations(34, startDate, endDate));
		model.put("rCB15thDeliveries", hospitalReportService.getDeliveries(34, startDate, endDate));
		model.put("rCB15thRoomingIn", hospitalReportService.getRoomingIn(34, startDate, endDate));
		model.put("rCB15thOutOnPass", hospitalReportService.getOutOnPass(34, startDate, endDate));
		model.put("rCB15thRemarks", hospitalReportService.getRemarks(34, startDate, endDate));


		model.put("rCB25thBedCapacity", hospitalReportService.getBedCapacity(35));
		model.put("rCB25thTotalLast", hospitalReportService.getTotalLast(35, startDate, endDate));
		model.put("rCB25thDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(35, startDate, endDate));
		model.put("rCB25thOverflow", hospitalReportService.getOverflow(35, startDate, endDate));
		model.put("rCB25thAdmission", hospitalReportService.getAdmission(35, startDate, endDate));
		model.put("rCB25thTransIn", hospitalReportService.getTransIn(35, startDate, endDate));
		model.put("rCB25thTransOut", hospitalReportService.getTransOut(35, startDate, endDate));
		model.put("rCB25thDischarged", hospitalReportService.getDischarged(35, startDate, endDate));
		model.put("rCB25thDeaths", hospitalReportService.getDeaths(35, startDate, endDate));
		model.put("rCB25thAbsconded", hospitalReportService.getAbsconded(35, startDate, endDate));
		model.put("rCB25thHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(35, startDate, endDate));
		model.put("rCB25thHomePerRequest", hospitalReportService.getHomePerRequest(35, startDate, endDate));
		model.put("rCB25thOperations", hospitalReportService.getOperations(35, startDate, endDate));
		model.put("rCB25thDeliveries", hospitalReportService.getDeliveries(35, startDate, endDate));
		model.put("rCB25thRoomingIn", hospitalReportService.getRoomingIn(35, startDate, endDate));
		model.put("rCB25thOutOnPass", hospitalReportService.getOutOnPass(35, startDate, endDate));
		model.put("rCB25thRemarks", hospitalReportService.getRemarks(35, startDate, endDate));


		model.put("lCB15thBedCapacity", hospitalReportService.getBedCapacity(36));
		model.put("lCB15thTotalLast", hospitalReportService.getTotalLast(36, startDate, endDate));
		model.put("lCB15thDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(36, startDate, endDate));
		model.put("lCB15thOverflow", hospitalReportService.getOverflow(36, startDate, endDate));
		model.put("lCB15thAdmission", hospitalReportService.getAdmission(36, startDate, endDate));
		model.put("lCB15thTransIn", hospitalReportService.getTransIn(36, startDate, endDate));
		model.put("lCB15thTransOut", hospitalReportService.getTransOut(36, startDate, endDate));
		model.put("lCB15thDischarged", hospitalReportService.getDischarged(36, startDate, endDate));
		model.put("lCB15thDeaths", hospitalReportService.getDeaths(36, startDate, endDate));
		model.put("lCB15thAbsconded", hospitalReportService.getAbsconded(36, startDate, endDate));
		model.put("lCB15thHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(36, startDate, endDate));
		model.put("lCB15thHomePerRequest", hospitalReportService.getHomePerRequest(36, startDate, endDate));
		model.put("lCB15thOperations", hospitalReportService.getOperations(36, startDate, endDate));
		model.put("lCB15thDeliveries", hospitalReportService.getDeliveries(36, startDate, endDate));
		model.put("lCB15thRoomingIn", hospitalReportService.getRoomingIn(36, startDate, endDate));
		model.put("lCB15thOutOnPass", hospitalReportService.getOutOnPass(36, startDate, endDate));
		model.put("lCB15thRemarks", hospitalReportService.getRemarks(36, startDate, endDate));


		model.put("lCB25thBedCapacity", hospitalReportService.getBedCapacity(37));
		model.put("lCB25thTotalLast", hospitalReportService.getTotalLast(37, startDate, endDate));
		model.put("lCB25thDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(37, startDate, endDate));
		model.put("lCB25thOverflow", hospitalReportService.getOverflow(37, startDate, endDate));
		model.put("lCB25thAdmission", hospitalReportService.getAdmission(37, startDate, endDate));
		model.put("lCB25thTransIn", hospitalReportService.getTransIn(37, startDate, endDate));
		model.put("lCB25thTransOut", hospitalReportService.getTransOut(37, startDate, endDate));
		model.put("lCB25thDischarged", hospitalReportService.getDischarged(37, startDate, endDate));
		model.put("lCB25thDeaths", hospitalReportService.getDeaths(37, startDate, endDate));
		model.put("lCB25thAbsconded", hospitalReportService.getAbsconded(37, startDate, endDate));
		model.put("lCB25thHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(37, startDate, endDate));
		model.put("lCB25thHomePerRequest", hospitalReportService.getHomePerRequest(37, startDate, endDate));
		model.put("lCB25thOperations", hospitalReportService.getOperations(37, startDate, endDate));
		model.put("lCB25thDeliveries", hospitalReportService.getDeliveries(37, startDate, endDate));
		model.put("lCB25thRoomingIn", hospitalReportService.getRoomingIn(37, startDate, endDate));
		model.put("lCB25thOutOnPass", hospitalReportService.getOutOnPass(37, startDate, endDate));
		model.put("lCB25thRemarks", hospitalReportService.getRemarks(37, startDate, endDate));


		model.put("rCB16thBedCapacity", hospitalReportService.getBedCapacity(38));
		model.put("rCB16thTotalLast", hospitalReportService.getTotalLast(38, startDate, endDate));
		model.put("rCB16thDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(38, startDate, endDate));
		model.put("rCB16thOverflow", hospitalReportService.getOverflow(38, startDate, endDate));
		model.put("rCB16thAdmission", hospitalReportService.getAdmission(38, startDate, endDate));
		model.put("rCB16thTransIn", hospitalReportService.getTransIn(38, startDate, endDate));
		model.put("rCB16thTransOut", hospitalReportService.getTransOut(38, startDate, endDate));
		model.put("rCB16thDischarged", hospitalReportService.getDischarged(38, startDate, endDate));
		model.put("rCB16thDeaths", hospitalReportService.getDeaths(38, startDate, endDate));
		model.put("rCB16thAbsconded", hospitalReportService.getAbsconded(38, startDate, endDate));
		model.put("rCB16thHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(38, startDate, endDate));
		model.put("rCB16thHomePerRequest", hospitalReportService.getHomePerRequest(38, startDate, endDate));
		model.put("rCB16thOperations", hospitalReportService.getOperations(38, startDate, endDate));
		model.put("rCB16thDeliveries", hospitalReportService.getDeliveries(38, startDate, endDate));
		model.put("rCB16thRoomingIn", hospitalReportService.getRoomingIn(38, startDate, endDate));
		model.put("rCB16thOutOnPass", hospitalReportService.getOutOnPass(38, startDate, endDate));
		model.put("rCB16thRemarks", hospitalReportService.getRemarks(38, startDate, endDate));


		model.put("rCB26thBedCapacity", hospitalReportService.getBedCapacity(39));
		model.put("rCB26thTotalLast", hospitalReportService.getTotalLast(39, startDate, endDate));
		model.put("rCB26thDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(39, startDate, endDate));
		model.put("rCB26thOverflow", hospitalReportService.getOverflow(39, startDate, endDate));
		model.put("rCB26thAdmission", hospitalReportService.getAdmission(39, startDate, endDate));
		model.put("rCB26thTransIn", hospitalReportService.getTransIn(39, startDate, endDate));
		model.put("rCB26thTransOut", hospitalReportService.getTransOut(39, startDate, endDate));
		model.put("rCB26thDischarged", hospitalReportService.getDischarged(39, startDate, endDate));
		model.put("rCB26thDeaths", hospitalReportService.getDeaths(39, startDate, endDate));
		model.put("rCB26thAbsconded", hospitalReportService.getAbsconded(39, startDate, endDate));
		model.put("rCB26thHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(39, startDate, endDate));
		model.put("rCB26thHomePerRequest", hospitalReportService.getHomePerRequest(39, startDate, endDate));
		model.put("rCB26thOperations", hospitalReportService.getOperations(39, startDate, endDate));
		model.put("rCB26thDeliveries", hospitalReportService.getDeliveries(39, startDate, endDate));
		model.put("rCB26thRoomingIn", hospitalReportService.getRoomingIn(39, startDate, endDate));
		model.put("rCB26thOutOnPass", hospitalReportService.getOutOnPass(39, startDate, endDate));
		model.put("rCB26thRemarks", hospitalReportService.getRemarks(39, startDate, endDate));


		model.put("seventhLCBBedCapacity", hospitalReportService.getBedCapacity(40));
		model.put("seventhLCBTotalLast", hospitalReportService.getTotalLast(40, startDate, endDate));
		model.put("seventhLCBDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(40, startDate, endDate));
		model.put("seventhLCBOverflow", hospitalReportService.getOverflow(40, startDate, endDate));
		model.put("seventhLCBAdmission", hospitalReportService.getAdmission(40, startDate, endDate));
		model.put("seventhLCBTransIn", hospitalReportService.getTransIn(40, startDate, endDate));
		model.put("seventhLCBTransOut", hospitalReportService.getTransOut(40, startDate, endDate));
		model.put("seventhLCBDischarged", hospitalReportService.getDischarged(40, startDate, endDate));
		model.put("seventhLCBDeaths", hospitalReportService.getDeaths(40, startDate, endDate));
		model.put("seventhLCBAbsconded", hospitalReportService.getAbsconded(40, startDate, endDate));
		model.put("seventhLCBHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(40, startDate, endDate));
		model.put("seventhLCBHomePerRequest", hospitalReportService.getHomePerRequest(40, startDate, endDate));
		model.put("seventhLCBOperations", hospitalReportService.getOperations(40, startDate, endDate));
		model.put("seventhLCBDeliveries", hospitalReportService.getDeliveries(40, startDate, endDate));
		model.put("seventhLCBRoomingIn", hospitalReportService.getRoomingIn(40, startDate, endDate));
		model.put("seventhLCBOutOnPass", hospitalReportService.getOutOnPass(40, startDate, endDate));
		model.put("seventhLCBRemarks", hospitalReportService.getRemarks(40, startDate, endDate));


		model.put("seventhRCBBedCapacity", hospitalReportService.getBedCapacity(41));
		model.put("seventhRCBTotalLast", hospitalReportService.getTotalLast(41, startDate, endDate));
		model.put("seventhRCBDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(41, startDate, endDate));
		model.put("seventhRCBOverflow", hospitalReportService.getOverflow(41, startDate, endDate));
		model.put("seventhRCBAdmission", hospitalReportService.getAdmission(41, startDate, endDate));
		model.put("seventhRCBTransIn", hospitalReportService.getTransIn(41, startDate, endDate));
		model.put("seventhRCBTransOut", hospitalReportService.getTransOut(41, startDate, endDate));
		model.put("seventhRCBDischarged", hospitalReportService.getDischarged(41, startDate, endDate));
		model.put("seventhRCBDeaths", hospitalReportService.getDeaths(41, startDate, endDate));
		model.put("seventhRCBAbsconded", hospitalReportService.getAbsconded(41, startDate, endDate));
		model.put("seventhRCBHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(41, startDate, endDate));
		model.put("seventhRCBHomePerRequest", hospitalReportService.getHomePerRequest(41, startDate, endDate));
		model.put("seventhRCBOperations", hospitalReportService.getOperations(41, startDate, endDate));
		model.put("seventhRCBDeliveries", hospitalReportService.getDeliveries(41, startDate, endDate));
		model.put("seventhRCBRoomingIn", hospitalReportService.getRoomingIn(41, startDate, endDate));
		model.put("seventhRCBOutOnPass", hospitalReportService.getOutOnPass(41, startDate, endDate));
		model.put("seventhRCBRemarks", hospitalReportService.getRemarks(41, startDate, endDate));



		model.put("sOJRBedCapacity", hospitalReportService.getBedCapacity(42));
		model.put("sOJRTotalLast", hospitalReportService.getTotalLast(42, startDate, endDate));
		model.put("sOJRDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(42, startDate, endDate));
		model.put("sOJROverflow", hospitalReportService.getOverflow(42, startDate, endDate));
		model.put("sOJRAdmission", hospitalReportService.getAdmission(42, startDate, endDate));
		model.put("sOJRTransIn", hospitalReportService.getTransIn(42, startDate, endDate));
		model.put("sOJRTransOut", hospitalReportService.getTransOut(42, startDate, endDate));
		model.put("sOJRDischarged", hospitalReportService.getDischarged(42, startDate, endDate));
		model.put("sOJRDeaths", hospitalReportService.getDeaths(42, startDate, endDate));
		model.put("sOJRAbsconded", hospitalReportService.getAbsconded(42, startDate, endDate));
		model.put("sOJRHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(42, startDate, endDate));
		model.put("sOJRHomePerRequest", hospitalReportService.getHomePerRequest(42, startDate, endDate));
		model.put("sOJROperations", hospitalReportService.getOperations(42, startDate, endDate));
		model.put("sOJRDeliveries", hospitalReportService.getDeliveries(42, startDate, endDate));
		model.put("sOJRRoomingIn", hospitalReportService.getRoomingIn(42, startDate, endDate));
		model.put("sOJROutOnPass", hospitalReportService.getOutOnPass(42, startDate, endDate));
		model.put("sOJRRemarks", hospitalReportService.getRemarks(42, startDate, endDate));



		model.put("sPINEBedCapacity", hospitalReportService.getBedCapacity(43));
		model.put("sPINETotalLast", hospitalReportService.getTotalLast(43, startDate, endDate));
		model.put("sPINEDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(43, startDate, endDate));
		model.put("sPINEOverflow", hospitalReportService.getOverflow(43, startDate, endDate));
		model.put("sPINEAdmission", hospitalReportService.getAdmission(43, startDate, endDate));
		model.put("sPINETransIn", hospitalReportService.getTransIn(43, startDate, endDate));
		model.put("sPINETransOut", hospitalReportService.getTransOut(43, startDate, endDate));
		model.put("sPINEDischarged", hospitalReportService.getDischarged(43, startDate, endDate));
		model.put("sPINEDeaths", hospitalReportService.getDeaths(43, startDate, endDate));
		model.put("sPINEAbsconded", hospitalReportService.getAbsconded(43, startDate, endDate));
		model.put("sPINEHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(43, startDate, endDate));
		model.put("sPINEHomePerRequest", hospitalReportService.getHomePerRequest(43, startDate, endDate));
		model.put("sPINEOperations", hospitalReportService.getOperations(43, startDate, endDate));
		model.put("sPINEDeliveries", hospitalReportService.getDeliveries(43, startDate, endDate));
		model.put("sPINERoomingIn", hospitalReportService.getRoomingIn(43, startDate, endDate));
		model.put("sPINEOutOnPass", hospitalReportService.getOutOnPass(43, startDate, endDate));
		model.put("sPINERemarks", hospitalReportService.getRemarks(43, startDate, endDate));


		model.put("sTROKEBedCapacity", hospitalReportService.getBedCapacity(44));
		model.put("sTROKETotalLast", hospitalReportService.getTotalLast(44, startDate, endDate));
		model.put("sTROKEDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(44, startDate, endDate));
		model.put("sTROKEOverflow", hospitalReportService.getOverflow(44, startDate, endDate));
		model.put("sTROKEAdmission", hospitalReportService.getAdmission(44, startDate, endDate));
		model.put("sTROKETransIn", hospitalReportService.getTransIn(44, startDate, endDate));
		model.put("sTROKETransOut", hospitalReportService.getTransOut(44, startDate, endDate));
		model.put("sTROKEDischarged", hospitalReportService.getDischarged(44, startDate, endDate));
		model.put("sTROKEDeaths", hospitalReportService.getDeaths(44, startDate, endDate));
		model.put("sTROKEAbsconded", hospitalReportService.getAbsconded(44, startDate, endDate));
		model.put("sTROKEHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(44, startDate, endDate));
		model.put("sTROKEHomePerRequest", hospitalReportService.getHomePerRequest(44, startDate, endDate));
		model.put("sTROKEOperations", hospitalReportService.getOperations(44, startDate, endDate));
		model.put("sTROKEDeliveries", hospitalReportService.getDeliveries(44, startDate, endDate));
		model.put("sTROKERoomingIn", hospitalReportService.getRoomingIn(44, startDate, endDate));
		model.put("sTROKEOutOnPass", hospitalReportService.getOutOnPass(44, startDate, endDate));
		model.put("sTROKERemarks", hospitalReportService.getRemarks(44, startDate, endDate));


		model.put("mICUBedCapacity", hospitalReportService.getBedCapacity(45));
		model.put("mICUTotalLast", hospitalReportService.getTotalLast(45, startDate, endDate));
		model.put("mICUDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(45, startDate, endDate));
		model.put("mICUOverflow", hospitalReportService.getOverflow(45, startDate, endDate));
		model.put("mICUAdmission", hospitalReportService.getAdmission(45, startDate, endDate));
		model.put("mICUTransIn", hospitalReportService.getTransIn(45, startDate, endDate));
		model.put("mICUTransOut", hospitalReportService.getTransOut(45, startDate, endDate));
		model.put("mICUDischarged", hospitalReportService.getDischarged(45, startDate, endDate));
		model.put("mICUDeaths", hospitalReportService.getDeaths(45, startDate, endDate));
		model.put("mICUAbsconded", hospitalReportService.getAbsconded(45, startDate, endDate));
		model.put("mICUHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(45, startDate, endDate));
		model.put("mICUHomePerRequest", hospitalReportService.getHomePerRequest(45, startDate, endDate));
		model.put("mICUOperations", hospitalReportService.getOperations(45, startDate, endDate));
		model.put("mICUDeliveries", hospitalReportService.getDeliveries(45, startDate, endDate));
		model.put("mICURoomingIn", hospitalReportService.getRoomingIn(45, startDate, endDate));
		model.put("mICUOutOnPass", hospitalReportService.getOutOnPass(45, startDate, endDate));
		model.put("mICURemarks", hospitalReportService.getRemarks(45, startDate, endDate));


		model.put("cENICUBedCapacity", hospitalReportService.getBedCapacity(46));
		model.put("cENICUTotalLast", hospitalReportService.getTotalLast(46, startDate, endDate));
		model.put("cENICUDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(46, startDate, endDate));
		model.put("cENICUOverflow", hospitalReportService.getOverflow(46, startDate, endDate));
		model.put("cENICUAdmission", hospitalReportService.getAdmission(46, startDate, endDate));
		model.put("cENICUTransIn", hospitalReportService.getTransIn(46, startDate, endDate));
		model.put("cENICUTransOut", hospitalReportService.getTransOut(46, startDate, endDate));
		model.put("cENICUDischarged", hospitalReportService.getDischarged(46, startDate, endDate));
		model.put("cENICUDeaths", hospitalReportService.getDeaths(46, startDate, endDate));
		model.put("cENICUAbsconded", hospitalReportService.getAbsconded(46, startDate, endDate));
		model.put("cENICUHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(46, startDate, endDate));
		model.put("cENICUHomePerRequest", hospitalReportService.getHomePerRequest(46, startDate, endDate));
		model.put("cENICUOperations", hospitalReportService.getOperations(46, startDate, endDate));
		model.put("cENICUDeliveries", hospitalReportService.getDeliveries(46, startDate, endDate));
		model.put("cENICURoomingIn", hospitalReportService.getRoomingIn(46, startDate, endDate));
		model.put("cENICUOutOnPass", hospitalReportService.getOutOnPass(46, startDate, endDate));
		model.put("cENICURemarks", hospitalReportService.getRemarks(46, startDate, endDate));


		model.put("pICUBedCapacity", hospitalReportService.getBedCapacity(47));
		model.put("pICUTotalLast", hospitalReportService.getTotalLast(47, startDate, endDate));
		model.put("pICUDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(47, startDate, endDate));
		model.put("pICUOverflow", hospitalReportService.getOverflow(47, startDate, endDate));
		model.put("pICUAdmission", hospitalReportService.getAdmission(47, startDate, endDate));
		model.put("pICUTransIn", hospitalReportService.getTransIn(47, startDate, endDate));
		model.put("pICUTransOut", hospitalReportService.getTransOut(47, startDate, endDate));
		model.put("pICUDischarged", hospitalReportService.getDischarged(47, startDate, endDate));
		model.put("pICUDeaths", hospitalReportService.getDeaths(47, startDate, endDate));
		model.put("pICUAbsconded", hospitalReportService.getAbsconded(47, startDate, endDate));
		model.put("pICUHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(47, startDate, endDate));
		model.put("pICUHomePerRequest", hospitalReportService.getHomePerRequest(47, startDate, endDate));
		model.put("pICUOperations", hospitalReportService.getOperations(47, startDate, endDate));
		model.put("pICUDeliveries", hospitalReportService.getDeliveries(47, startDate, endDate));
		model.put("pICURoomingIn", hospitalReportService.getRoomingIn(47, startDate, endDate));
		model.put("pICUOutOnPass", hospitalReportService.getOutOnPass(47, startDate, endDate));
		model.put("pICURemarks", hospitalReportService.getRemarks(47, startDate, endDate));


		model.put("bURNUNITBedCapacity", hospitalReportService.getBedCapacity(48));
		model.put("bURNUNITTotalLast", hospitalReportService.getTotalLast(48, startDate, endDate));
		model.put("bURNUNITDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(48, startDate, endDate));
		model.put("bURNUNITOverflow", hospitalReportService.getOverflow(48, startDate, endDate));
		model.put("bURNUNITAdmission", hospitalReportService.getAdmission(48, startDate, endDate));
		model.put("bURNUNITTransIn", hospitalReportService.getTransIn(48, startDate, endDate));
		model.put("bURNUNITTransOut", hospitalReportService.getTransOut(48, startDate, endDate));
		model.put("bURNUNITDischarged", hospitalReportService.getDischarged(48, startDate, endDate));
		model.put("bURNUNITDeaths", hospitalReportService.getDeaths(48, startDate, endDate));
		model.put("bURNUNITAbsconded", hospitalReportService.getAbsconded(48, startDate, endDate));
		model.put("bURNUNITHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(48, startDate, endDate));
		model.put("bURNUNITHomePerRequest", hospitalReportService.getHomePerRequest(48, startDate, endDate));
		model.put("bURNUNITOperations", hospitalReportService.getOperations(48, startDate, endDate));
		model.put("bURNUNITDeliveries", hospitalReportService.getDeliveries(48, startDate, endDate));
		model.put("bURNUNITRoomingIn", hospitalReportService.getRoomingIn(48, startDate, endDate));
		model.put("bURNUNITOutOnPass", hospitalReportService.getOutOnPass(48, startDate, endDate));
		model.put("bURNUNITRemarks", hospitalReportService.getRemarks(48, startDate, endDate));


		model.put("sICUBedCapacity", hospitalReportService.getBedCapacity(49));
		model.put("sICUTotalLast", hospitalReportService.getTotalLast(49, startDate, endDate));
		model.put("sICUDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(49, startDate, endDate));
		model.put("sICUOverflow", hospitalReportService.getOverflow(49, startDate, endDate));
		model.put("sICUAdmission", hospitalReportService.getAdmission(49, startDate, endDate));
		model.put("sICUTransIn", hospitalReportService.getTransIn(49, startDate, endDate));
		model.put("sICUTransOut", hospitalReportService.getTransOut(49, startDate, endDate));
		model.put("sICUDischarged", hospitalReportService.getDischarged(49, startDate, endDate));
		model.put("sICUDeaths", hospitalReportService.getDeaths(49, startDate, endDate));
		model.put("sICUAbsconded", hospitalReportService.getAbsconded(49, startDate, endDate));
		model.put("sICUHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(49, startDate, endDate));
		model.put("sICUHomePerRequest", hospitalReportService.getHomePerRequest(49, startDate, endDate));
		model.put("sICUOperations", hospitalReportService.getOperations(49, startDate, endDate));
		model.put("sICUDeliveries", hospitalReportService.getDeliveries(49, startDate, endDate));
		model.put("sICURoomingIn", hospitalReportService.getRoomingIn(49, startDate, endDate));
		model.put("sICUOutOnPass", hospitalReportService.getOutOnPass(49, startDate, endDate));
		model.put("sICURemarks", hospitalReportService.getRemarks(49, startDate, endDate));


		model.put("nSSCUBedCapacity", hospitalReportService.getBedCapacity(50));
		model.put("nSSCUTotalLast", hospitalReportService.getTotalLast(50, startDate, endDate));
		model.put("nSSCUDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(50, startDate, endDate));
		model.put("nSSCUOverflow", hospitalReportService.getOverflow(50, startDate, endDate));
		model.put("nSSCUAdmission", hospitalReportService.getAdmission(50, startDate, endDate));
		model.put("nSSCUTransIn", hospitalReportService.getTransIn(50, startDate, endDate));
		model.put("nSSCUTransOut", hospitalReportService.getTransOut(50, startDate, endDate));
		model.put("nSSCUDischarged", hospitalReportService.getDischarged(50, startDate, endDate));
		model.put("nSSCUDeaths", hospitalReportService.getDeaths(50, startDate, endDate));
		model.put("nSSCUAbsconded", hospitalReportService.getAbsconded(50, startDate, endDate));
		model.put("nSSCUHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(50, startDate, endDate));
		model.put("nSSCUHomePerRequest", hospitalReportService.getHomePerRequest(50, startDate, endDate));
		model.put("nSSCUOperations", hospitalReportService.getOperations(50, startDate, endDate));
		model.put("nSSCUDeliveries", hospitalReportService.getDeliveries(50, startDate, endDate));
		model.put("nSSCURoomingIn", hospitalReportService.getRoomingIn(50, startDate, endDate));
		model.put("nSSCUOutOnPass", hospitalReportService.getOutOnPass(50, startDate, endDate));
		model.put("nSSCURemarks", hospitalReportService.getRemarks(50, startDate, endDate));


		model.put("nICUBedCapacity", hospitalReportService.getBedCapacity(51));
		model.put("nICUTotalLast", hospitalReportService.getTotalLast(51, startDate, endDate));
		model.put("nICUDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(51, startDate, endDate));
		model.put("nICUOverflow", hospitalReportService.getOverflow(51, startDate, endDate));
		model.put("nICUAdmission", hospitalReportService.getAdmission(51, startDate, endDate));
		model.put("nICUTransIn", hospitalReportService.getTransIn(51, startDate, endDate));
		model.put("nICUTransOut", hospitalReportService.getTransOut(51, startDate, endDate));
		model.put("nICUDischarged", hospitalReportService.getDischarged(51, startDate, endDate));
		model.put("nICUDeaths", hospitalReportService.getDeaths(51, startDate, endDate));
		model.put("nICUAbsconded", hospitalReportService.getAbsconded(51, startDate, endDate));
		model.put("nICUHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(51, startDate, endDate));
		model.put("nICUHomePerRequest", hospitalReportService.getHomePerRequest(51, startDate, endDate));
		model.put("nICUOperations", hospitalReportService.getOperations(51, startDate, endDate));
		model.put("nICUDeliveries", hospitalReportService.getDeliveries(51, startDate, endDate));
		model.put("nICURoomingIn", hospitalReportService.getRoomingIn(51, startDate, endDate));
		model.put("nICUOutOnPass", hospitalReportService.getOutOnPass(51, startDate, endDate));
		model.put("nICURemarks", hospitalReportService.getRemarks(51, startDate, endDate));


		model.put("nEONATALICUBedCapacity", hospitalReportService.getBedCapacity(52));
		model.put("nEONATALICUTotalLast", hospitalReportService.getTotalLast(52, startDate, endDate));
		model.put("nEONATALICUDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(52, startDate, endDate));
		model.put("nEONATALICUOverflow", hospitalReportService.getOverflow(52, startDate, endDate));
		model.put("nEONATALICUAdmission", hospitalReportService.getAdmission(52, startDate, endDate));
		model.put("nEONATALICUTransIn", hospitalReportService.getTransIn(52, startDate, endDate));
		model.put("nEONATALICUTransOut", hospitalReportService.getTransOut(52, startDate, endDate));
		model.put("nEONATALICUDischarged", hospitalReportService.getDischarged(52, startDate, endDate));
		model.put("nEONATALICUDeaths", hospitalReportService.getDeaths(52, startDate, endDate));
		model.put("nEONATALICUAbsconded", hospitalReportService.getAbsconded(52, startDate, endDate));
		model.put("nEONATALICUHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(52, startDate, endDate));
		model.put("nEONATALICUHomePerRequest", hospitalReportService.getHomePerRequest(52, startDate, endDate));
		model.put("nEONATALICUOperations", hospitalReportService.getOperations(52, startDate, endDate));
		model.put("nEONATALICUDeliveries", hospitalReportService.getDeliveries(52, startDate, endDate));
		model.put("nEONATALICURoomingIn", hospitalReportService.getRoomingIn(52, startDate, endDate));
		model.put("nEONATALICUOutOnPass", hospitalReportService.getOutOnPass(52, startDate, endDate));
		model.put("nEONATALICURemarks", hospitalReportService.getRemarks(52, startDate, endDate));


		model.put("iMURRBedCapacity", hospitalReportService.getBedCapacity(53));
		model.put("iMURRTotalLast", hospitalReportService.getTotalLast(53, startDate, endDate));
		model.put("iMURRDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(53, startDate, endDate));
		model.put("iMURROverflow", hospitalReportService.getOverflow(53, startDate, endDate));
		model.put("iMURRAdmission", hospitalReportService.getAdmission(53, startDate, endDate));
		model.put("iMURRTransIn", hospitalReportService.getTransIn(53, startDate, endDate));
		model.put("iMURRTransOut", hospitalReportService.getTransOut(53, startDate, endDate));
		model.put("iMURRDischarged", hospitalReportService.getDischarged(53, startDate, endDate));
		model.put("iMURRDeaths", hospitalReportService.getDeaths(53, startDate, endDate));
		model.put("iMURRAbsconded", hospitalReportService.getAbsconded(53, startDate, endDate));
		model.put("iMURRHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(53, startDate, endDate));
		model.put("iMURRHomePerRequest", hospitalReportService.getHomePerRequest(53, startDate, endDate));
		model.put("iMURROperations", hospitalReportService.getOperations(53, startDate, endDate));
		model.put("iMURRDeliveries", hospitalReportService.getDeliveries(53, startDate, endDate));
		model.put("iMURRRoomingIn", hospitalReportService.getRoomingIn(53, startDate, endDate));
		model.put("iMURROutOnPass", hospitalReportService.getOutOnPass(53, startDate, endDate));
		model.put("iMURRRemarks", hospitalReportService.getRemarks(53, startDate, endDate));


		model.put("rADIUMBedCapacity", hospitalReportService.getBedCapacity(54));
		model.put("rADIUMTotalLast", hospitalReportService.getTotalLast(54, startDate, endDate));
		model.put("rADIUMDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(54, startDate, endDate));
		model.put("rADIUMOverflow", hospitalReportService.getOverflow(54, startDate, endDate));
		model.put("rADIUMAdmission", hospitalReportService.getAdmission(54, startDate, endDate));
		model.put("rADIUMTransIn", hospitalReportService.getTransIn(54, startDate, endDate));
		model.put("rADIUMTransOut", hospitalReportService.getTransOut(54, startDate, endDate));
		model.put("rADIUMDischarged", hospitalReportService.getDischarged(54, startDate, endDate));
		model.put("rADIUMDeaths", hospitalReportService.getDeaths(54, startDate, endDate));
		model.put("rADIUMAbsconded", hospitalReportService.getAbsconded(54, startDate, endDate));
		model.put("rADIUMHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(54, startDate, endDate));
		model.put("rADIUMHomePerRequest", hospitalReportService.getHomePerRequest(54, startDate, endDate));
		model.put("rADIUMOperations", hospitalReportService.getOperations(54, startDate, endDate));
		model.put("rADIUMDeliveries", hospitalReportService.getDeliveries(54, startDate, endDate));
		model.put("rADIUMRoomingIn", hospitalReportService.getRoomingIn(54, startDate, endDate));
		model.put("rADIUMOutOnPass", hospitalReportService.getOutOnPass(54, startDate, endDate));
		model.put("rADIUMRemarks", hospitalReportService.getRemarks(54, startDate, endDate));


		model.put("cIBedCapacity", hospitalReportService.getBedCapacity(55));
		model.put("cITotalLast", hospitalReportService.getTotalLast(55, startDate, endDate));
		model.put("cIDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(55, startDate, endDate));
		model.put("cIOverflow", hospitalReportService.getOverflow(55, startDate, endDate));
		model.put("cIAdmission", hospitalReportService.getAdmission(55, startDate, endDate));
		model.put("cITransIn", hospitalReportService.getTransIn(55, startDate, endDate));
		model.put("cITransOut", hospitalReportService.getTransOut(55, startDate, endDate));
		model.put("cIDischarged", hospitalReportService.getDischarged(55, startDate, endDate));
		model.put("cIDeaths", hospitalReportService.getDeaths(55, startDate, endDate));
		model.put("cIAbsconded", hospitalReportService.getAbsconded(55, startDate, endDate));
		model.put("cIHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(55, startDate, endDate));
		model.put("cIHomePerRequest", hospitalReportService.getHomePerRequest(55, startDate, endDate));
		model.put("cIOperations", hospitalReportService.getOperations(55, startDate, endDate));
		model.put("cIDeliveries", hospitalReportService.getDeliveries(55, startDate, endDate));
		model.put("cIRoomingIn", hospitalReportService.getRoomingIn(55, startDate, endDate));
		model.put("cIOutOnPass", hospitalReportService.getOutOnPass(55, startDate, endDate));
		model.put("cIRemarks", hospitalReportService.getRemarks(55, startDate, endDate));



		model.put("dEMPERBedCapacity", hospitalReportService.getBedCapacity(56));
		model.put("dEMPERTotalLast", hospitalReportService.getTotalLast(56, startDate, endDate));
		model.put("dEMPERDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(56, startDate, endDate));
		model.put("dEMPEROverflow", hospitalReportService.getOverflow(56, startDate, endDate));
		model.put("dEMPERAdmission", hospitalReportService.getAdmission(56, startDate, endDate));
		model.put("dEMPERTransIn", hospitalReportService.getTransIn(56, startDate, endDate));
		model.put("dEMPERTransOut", hospitalReportService.getTransOut(56, startDate, endDate));
		model.put("dEMPERDischarged", hospitalReportService.getDischarged(56, startDate, endDate));
		model.put("dEMPERDeaths", hospitalReportService.getDeaths(56, startDate, endDate));
		model.put("dEMPERAbsconded", hospitalReportService.getAbsconded(56, startDate, endDate));
		model.put("dEMPERHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(56, startDate, endDate));
		model.put("dEMPERHomePerRequest", hospitalReportService.getHomePerRequest(56, startDate, endDate));
		model.put("dEMPEROperations", hospitalReportService.getOperations(56, startDate, endDate));
		model.put("dEMPERDeliveries", hospitalReportService.getDeliveries(56, startDate, endDate));
		model.put("dEMPERRoomingIn", hospitalReportService.getRoomingIn(56, startDate, endDate));
		model.put("dEMPEROutOnPass", hospitalReportService.getOutOnPass(56, startDate, endDate));
		model.put("dEMPERRemarks", hospitalReportService.getRemarks(56, startDate, endDate));


		model.put("oUBedCapacity", hospitalReportService.getBedCapacity(57));
		model.put("oUTotalLast", hospitalReportService.getTotalLast(57, startDate, endDate));
		model.put("oUDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(57, startDate, endDate));
		model.put("oUOverflow", hospitalReportService.getOverflow(57, startDate, endDate));
		model.put("oUAdmission", hospitalReportService.getAdmission(57, startDate, endDate));
		model.put("oUTransIn", hospitalReportService.getTransIn(57, startDate, endDate));
		model.put("oUTransOut", hospitalReportService.getTransOut(57, startDate, endDate));
		model.put("oUDischarged", hospitalReportService.getDischarged(57, startDate, endDate));
		model.put("oUDeaths", hospitalReportService.getDeaths(57, startDate, endDate));
		model.put("oUAbsconded", hospitalReportService.getAbsconded(57, startDate, endDate));
		model.put("oUHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(57, startDate, endDate));
		model.put("oUHomePerRequest", hospitalReportService.getHomePerRequest(57, startDate, endDate));
		model.put("oUOperations", hospitalReportService.getOperations(57, startDate, endDate));
		model.put("oUDeliveries", hospitalReportService.getDeliveries(57, startDate, endDate));
		model.put("oURoomingIn", hospitalReportService.getRoomingIn(57, startDate, endDate));
		model.put("oUOutOnPass", hospitalReportService.getOutOnPass(57, startDate, endDate));
		model.put("oURemarks", hospitalReportService.getRemarks(57, startDate, endDate));


		model.put("aCUBedCapacity", hospitalReportService.getBedCapacity(58));
		model.put("aCUTotalLast", hospitalReportService.getTotalLast(58, startDate, endDate));
		model.put("aCUDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(58, startDate, endDate));
		model.put("aCUOverflow", hospitalReportService.getOverflow(58, startDate, endDate));
		model.put("aCUAdmission", hospitalReportService.getAdmission(58, startDate, endDate));
		model.put("aCUTransIn", hospitalReportService.getTransIn(58, startDate, endDate));
		model.put("aCUTransOut", hospitalReportService.getTransOut(58, startDate, endDate));
		model.put("aCUDischarged", hospitalReportService.getDischarged(58, startDate, endDate));
		model.put("aCUDeaths", hospitalReportService.getDeaths(58, startDate, endDate));
		model.put("aCUAbsconded", hospitalReportService.getAbsconded(58, startDate, endDate));
		model.put("aCUHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(58, startDate, endDate));
		model.put("aCUHomePerRequest", hospitalReportService.getHomePerRequest(58, startDate, endDate));
		model.put("aCUOperations", hospitalReportService.getOperations(58, startDate, endDate));
		model.put("aCUDeliveries", hospitalReportService.getDeliveries(58, startDate, endDate));
		model.put("aCURoomingIn", hospitalReportService.getRoomingIn(58, startDate, endDate));
		model.put("aCUOutOnPass", hospitalReportService.getOutOnPass(58, startDate, endDate));
		model.put("aCURemarks", hospitalReportService.getRemarks(58, startDate, endDate));



		model.put("aMBUBedCapacity", hospitalReportService.getBedCapacity(59));
		model.put("aMBUTotalLast", hospitalReportService.getTotalLast(59, startDate, endDate));
		model.put("aMBUDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(59, startDate, endDate));
		model.put("aMBUOverflow", hospitalReportService.getOverflow(59, startDate, endDate));
		model.put("aMBUAdmission", hospitalReportService.getAdmission(59, startDate, endDate));
		model.put("aMBUTransIn", hospitalReportService.getTransIn(59, startDate, endDate));
		model.put("aMBUTransOut", hospitalReportService.getTransOut(59, startDate, endDate));
		model.put("aMBUDischarged", hospitalReportService.getDischarged(59, startDate, endDate));
		model.put("aMBUDeaths", hospitalReportService.getDeaths(59, startDate, endDate));
		model.put("aMBUAbsconded", hospitalReportService.getAbsconded(59, startDate, endDate));
		model.put("aMBUHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(59, startDate, endDate));
		model.put("aMBUHomePerRequest", hospitalReportService.getHomePerRequest(59, startDate, endDate));
		model.put("aMBUOperations", hospitalReportService.getOperations(59, startDate, endDate));
		model.put("aMBUDeliveries", hospitalReportService.getDeliveries(59, startDate, endDate));
		model.put("aMBURoomingIn", hospitalReportService.getRoomingIn(59, startDate, endDate));
		model.put("aMBUOutOnPass", hospitalReportService.getOutOnPass(59, startDate, endDate));
		model.put("aMBURemarks", hospitalReportService.getRemarks(59, startDate, endDate));
		


		model.put("rCBORBedCapacity", hospitalReportService.getBedCapacity(60));
		model.put("rCBORTotalLast", hospitalReportService.getTotalLast(60, startDate, endDate));
		model.put("rCBORDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(60, startDate, endDate));
		model.put("rCBOROverflow", hospitalReportService.getOverflow(60, startDate, endDate));
		model.put("rCBORAdmission", hospitalReportService.getAdmission(60, startDate, endDate));
		model.put("rCBORTransIn", hospitalReportService.getTransIn(60, startDate, endDate));
		model.put("rCBORTransOut", hospitalReportService.getTransOut(60, startDate, endDate));
		model.put("rCBORDischarged", hospitalReportService.getDischarged(60, startDate, endDate));
		model.put("rCBORDeaths", hospitalReportService.getDeaths(60, startDate, endDate));
		model.put("rCBORAbsconded", hospitalReportService.getAbsconded(60, startDate, endDate));
		model.put("rCBORHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(60, startDate, endDate));
		model.put("rCBORHomePerRequest", hospitalReportService.getHomePerRequest(60, startDate, endDate));
		model.put("rCBOROperations", hospitalReportService.getOperations(60, startDate, endDate));
		model.put("rCBORDeliveries", hospitalReportService.getDeliveries(60, startDate, endDate));
		model.put("rCBORRoomingIn", hospitalReportService.getRoomingIn(60, startDate, endDate));
		model.put("rCBOROutOnPass", hospitalReportService.getOutOnPass(60, startDate, endDate));
		model.put("rCBORRemarks", hospitalReportService.getRemarks(60, startDate, endDate));


		model.put("lCBORBedCapacity", hospitalReportService.getBedCapacity(61));
		model.put("lCBORTotalLast", hospitalReportService.getTotalLast(61, startDate, endDate));
		model.put("lCBORDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(61, startDate, endDate));
		model.put("lCBOROverflow", hospitalReportService.getOverflow(61, startDate, endDate));
		model.put("lCBORAdmission", hospitalReportService.getAdmission(61, startDate, endDate));
		model.put("lCBORTransIn", hospitalReportService.getTransIn(61, startDate, endDate));
		model.put("lCBORTransOut", hospitalReportService.getTransOut(61, startDate, endDate));
		model.put("lCBORDischarged", hospitalReportService.getDischarged(61, startDate, endDate));
		model.put("lCBORDeaths", hospitalReportService.getDeaths(61, startDate, endDate));
		model.put("lCBORAbsconded", hospitalReportService.getAbsconded(61, startDate, endDate));
		model.put("lCBORHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(61, startDate, endDate));
		model.put("lCBORHomePerRequest", hospitalReportService.getHomePerRequest(61, startDate, endDate));
		model.put("lCBOROperations", hospitalReportService.getOperations(61, startDate, endDate));
		model.put("lCBORDeliveries", hospitalReportService.getDeliveries(61, startDate, endDate));
		model.put("lCBORRoomingIn", hospitalReportService.getRoomingIn(61, startDate, endDate));
		model.put("lCBOROutOnPass", hospitalReportService.getOutOnPass(61, startDate, endDate));
		model.put("lCBORRemarks", hospitalReportService.getRemarks(61, startDate, endDate));


		model.put("pACUBedCapacity", hospitalReportService.getBedCapacity(62));
		model.put("pACUTotalLast", hospitalReportService.getTotalLast(62, startDate, endDate));
		model.put("pACUDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(62, startDate, endDate));
		model.put("pACUOverflow", hospitalReportService.getOverflow(62, startDate, endDate));
		model.put("pACUAdmission", hospitalReportService.getAdmission(62, startDate, endDate));
		model.put("pACUTransIn", hospitalReportService.getTransIn(62, startDate, endDate));
		model.put("pACUTransOut", hospitalReportService.getTransOut(62, startDate, endDate));
		model.put("pACUDischarged", hospitalReportService.getDischarged(62, startDate, endDate));
		model.put("pACUDeaths", hospitalReportService.getDeaths(62, startDate, endDate));
		model.put("pACUAbsconded", hospitalReportService.getAbsconded(62, startDate, endDate));
		model.put("pACUHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(62, startDate, endDate));
		model.put("pACUHomePerRequest", hospitalReportService.getHomePerRequest(62, startDate, endDate));
		model.put("pACUOperations", hospitalReportService.getOperations(62, startDate, endDate));
		model.put("pACUDeliveries", hospitalReportService.getDeliveries(62, startDate, endDate));
		model.put("pACURoomingIn", hospitalReportService.getRoomingIn(62, startDate, endDate));
		model.put("pACUOutOnPass", hospitalReportService.getOutOnPass(62, startDate, endDate));
		model.put("pACURemarks", hospitalReportService.getRemarks(62, startDate, endDate));



		model.put("lCBDIALYSISBedCapacity", hospitalReportService.getBedCapacity(63));
		model.put("lCBDIALYSISTotalLast", hospitalReportService.getTotalLast(63, startDate, endDate));
		model.put("lCBDIALYSISDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(63, startDate, endDate));
		model.put("lCBDIALYSISOverflow", hospitalReportService.getOverflow(63, startDate, endDate));
		model.put("lCBDIALYSISAdmission", hospitalReportService.getAdmission(63, startDate, endDate));
		model.put("lCBDIALYSISTransIn", hospitalReportService.getTransIn(63, startDate, endDate));
		model.put("lCBDIALYSISTransOut", hospitalReportService.getTransOut(63, startDate, endDate));
		model.put("lCBDIALYSISDischarged", hospitalReportService.getDischarged(63, startDate, endDate));
		model.put("lCBDIALYSISDeaths", hospitalReportService.getDeaths(63, startDate, endDate));
		model.put("lCBDIALYSISAbsconded", hospitalReportService.getAbsconded(63, startDate, endDate));
		model.put("lCBDIALYSISHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(63, startDate, endDate));
		model.put("lCBDIALYSISHomePerRequest", hospitalReportService.getHomePerRequest(63, startDate, endDate));
		model.put("lCBDIALYSISOperations", hospitalReportService.getOperations(63, startDate, endDate));
		model.put("lCBDIALYSISDeliveries", hospitalReportService.getDeliveries(63, startDate, endDate));
		model.put("lCBDIALYSISRoomingIn", hospitalReportService.getRoomingIn(63, startDate, endDate));
		model.put("lCBDIALYSISOutOnPass", hospitalReportService.getOutOnPass(63, startDate, endDate));
		model.put("lCBDIALYSISRemarks", hospitalReportService.getRemarks(63, startDate, endDate));



		model.put("cardiacCathLabBedCapacity", hospitalReportService.getBedCapacity(64));
		model.put("cardiacCathLabTotalLast", hospitalReportService.getTotalLast(64, startDate, endDate));
		model.put("cardiacCathLabDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(64, startDate, endDate));
		model.put("cardiacCathLabOverflow", hospitalReportService.getOverflow(64, startDate, endDate));
		model.put("cardiacCathLabAdmission", hospitalReportService.getAdmission(64, startDate, endDate));
		model.put("cardiacCathLabTransIn", hospitalReportService.getTransIn(64, startDate, endDate));
		model.put("cardiacCathLabTransOut", hospitalReportService.getTransOut(64, startDate, endDate));
		model.put("cardiacCathLabDischarged", hospitalReportService.getDischarged(64, startDate, endDate));
		model.put("cardiacCathLabDeaths", hospitalReportService.getDeaths(64, startDate, endDate));
		model.put("cardiacCathLabAbsconded", hospitalReportService.getAbsconded(64, startDate, endDate));
		model.put("cardiacCathLabHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(64, startDate, endDate));
		model.put("cardiacCathLabHomePerRequest", hospitalReportService.getHomePerRequest(64, startDate, endDate));
		model.put("cardiacCathLabOperations", hospitalReportService.getOperations(64, startDate, endDate));
		model.put("cardiacCathLabDeliveries", hospitalReportService.getDeliveries(64, startDate, endDate));
		model.put("cardiacCathLabRoomingIn", hospitalReportService.getRoomingIn(64, startDate, endDate));
		model.put("cardiacCathLabOutOnPass", hospitalReportService.getOutOnPass(64, startDate, endDate));
		model.put("cardiacCathLabRemarks", hospitalReportService.getRemarks(64, startDate, endDate));


		model.put("openHeartTransplantBedCapacity", hospitalReportService.getBedCapacity(65));
		model.put("openHeartTransplantTotalLast", hospitalReportService.getTotalLast(65, startDate, endDate));
		model.put("openHeartTransplantDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(65, startDate, endDate));
		model.put("openHeartTransplantOverflow", hospitalReportService.getOverflow(65, startDate, endDate));
		model.put("openHeartTransplantAdmission", hospitalReportService.getAdmission(65, startDate, endDate));
		model.put("openHeartTransplantTransIn", hospitalReportService.getTransIn(65, startDate, endDate));
		model.put("openHeartTransplantTransOut", hospitalReportService.getTransOut(65, startDate, endDate));
		model.put("openHeartTransplantDischarged", hospitalReportService.getDischarged(65, startDate, endDate));
		model.put("openHeartTransplantDeaths", hospitalReportService.getDeaths(65, startDate, endDate));
		model.put("openHeartTransplantAbsconded", hospitalReportService.getAbsconded(65, startDate, endDate));
		model.put("openHeartTransplantHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(65, startDate, endDate));
		model.put("openHeartTransplantHomePerRequest", hospitalReportService.getHomePerRequest(65, startDate, endDate));
		model.put("openHeartTransplantOperations", hospitalReportService.getOperations(65, startDate, endDate));
		model.put("openHeartTransplantDeliveries", hospitalReportService.getDeliveries(65, startDate, endDate));
		model.put("openHeartTransplantRoomingIn", hospitalReportService.getRoomingIn(65, startDate, endDate));
		model.put("openHeartTransplantOutOnPass", hospitalReportService.getOutOnPass(65, startDate, endDate));
		model.put("openHeartTransplantRemarks", hospitalReportService.getRemarks(65, startDate, endDate));


		model.put("lCBOBORBedCapacity", hospitalReportService.getBedCapacity(66));
		model.put("lCBOBORTotalLast", hospitalReportService.getTotalLast(66, startDate, endDate));
		model.put("lCBOBORDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(66, startDate, endDate));
		model.put("lCBOBOROverflow", hospitalReportService.getOverflow(66, startDate, endDate));
		model.put("lCBOBORAdmission", hospitalReportService.getAdmission(66, startDate, endDate));
		model.put("lCBOBORTransIn", hospitalReportService.getTransIn(66, startDate, endDate));
		model.put("lCBOBORTransOut", hospitalReportService.getTransOut(66, startDate, endDate));
		model.put("lCBOBORDischarged", hospitalReportService.getDischarged(66, startDate, endDate));
		model.put("lCBOBORDeaths", hospitalReportService.getDeaths(66, startDate, endDate));
		model.put("lCBOBORAbsconded", hospitalReportService.getAbsconded(66, startDate, endDate));
		model.put("lCBOBORHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(66, startDate, endDate));
		model.put("lCBOBORHomePerRequest", hospitalReportService.getHomePerRequest(66, startDate, endDate));
		model.put("lCBOBOROperations", hospitalReportService.getOperations(66, startDate, endDate));
		model.put("lCBOBORDeliveries", hospitalReportService.getDeliveries(66, startDate, endDate));
		model.put("lCBOBORRoomingIn", hospitalReportService.getRoomingIn(66, startDate, endDate));
		model.put("lCBOBOROutOnPass", hospitalReportService.getOutOnPass(66, startDate, endDate));
		model.put("lCBOBORRemarks", hospitalReportService.getRemarks(66, startDate, endDate));



		model.put("oBASBedCapacity", hospitalReportService.getBedCapacity(67));
		model.put("oBASTotalLast", hospitalReportService.getTotalLast(67, startDate, endDate));
		model.put("oBASDailyOccupancyRate", hospitalReportService.getDailyOccupancyRate(67, startDate, endDate));
		model.put("oBASOverflow", hospitalReportService.getOverflow(67, startDate, endDate));
		model.put("oBASAdmission", hospitalReportService.getAdmission(67, startDate, endDate));
		model.put("oBASTransIn", hospitalReportService.getTransIn(67, startDate, endDate));
		model.put("oBASTransOut", hospitalReportService.getTransOut(67, startDate, endDate));
		model.put("oBASDischarged", hospitalReportService.getDischarged(67, startDate, endDate));
		model.put("oBASDeaths", hospitalReportService.getDeaths(67, startDate, endDate));
		model.put("oBASAbsconded", hospitalReportService.getAbsconded(67, startDate, endDate));
		model.put("oBASHomeAgainstAdvice", hospitalReportService.getHomeAgainstAdvice(67, startDate, endDate));
		model.put("oBASHomePerRequest", hospitalReportService.getHomePerRequest(67, startDate, endDate));
		model.put("oBASOperations", hospitalReportService.getOperations(67, startDate, endDate));
		model.put("oBASDeliveries", hospitalReportService.getDeliveries(67, startDate, endDate));
		model.put("oBASRoomingIn", hospitalReportService.getRoomingIn(67, startDate, endDate));
		model.put("oBASOutOnPass", hospitalReportService.getOutOnPass(67, startDate, endDate));
		model.put("oBASRemarks", hospitalReportService.getRemarks(67, startDate, endDate));

		model.put("totalHospitalAdmission", hospitalReportService.getAdmission(9, startDate, endDate));
		model.put("totalDischarged", hospitalReportService.getDischarged(9, startDate, endDate));
		
	}
	
}