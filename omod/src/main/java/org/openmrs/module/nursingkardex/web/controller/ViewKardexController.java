package org.openmrs.module.nursingkardex.web.controller;

import java.util.Date;
import java.util.List;

import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.Physician;
import org.openmrs.module.nursingkardex.ShiftProblem;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.api.ShiftProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.openmrs.Provider;
import org.openmrs.Person;

@Controller
public class ViewKardexController {
			
	@RequestMapping(value = "/module/nursingkardex/viewKardex", method = RequestMethod.GET)
	public void showForm(@RequestParam(value = "patientCaseRecordId", required = false) Integer patientCaseRecordId,
	                     @RequestParam(value = "bedId", required = false) Integer bedId, 
	                     ModelMap model) {
		PatientCaseRecord patientCaseRecord = null;
		if (bedId != null) {
			patientCaseRecord = getPatientCaseRecordByBedId(bedId);
			if (patientCaseRecord == null) {
				return;
			}
		} else if (patientCaseRecordId != null) {
			patientCaseRecord = getPatientCaseRecord(patientCaseRecordId);
		}
		model.addAttribute("patientCaseRecord", patientCaseRecord);
		
		//		Encounter currentEncounter = patientCaseRecord.getLatestPatientMovement().getEncounter();
		ShiftProblemService shiftProblemService = Context.getService(ShiftProblemService.class);
		List<ShiftProblem> shiftProblems = shiftProblemService.getActiveShiftProblemsByPatientCaseRecordId(patientCaseRecord
		        .getId());
		model.addAttribute("shiftProblems", shiftProblems);
		if (shiftProblems != null && !shiftProblems.isEmpty()) {
			ShiftProblem shiftProblem = shiftProblems.get(0);
			model.addAttribute("shift", shiftProblem.getShift());
			model.addAttribute("shiftDate", shiftProblem.getDate());
		}
		
		ReportHelper reportHelper = new ReportHelper();
		model.addAttribute("endorsement", reportHelper.setupEndorsementBean(patientCaseRecord));
		
		model.addAttribute("today", new Date());
		
		Nurse nurse = new KardexHelper().deriveNurse();
		Physician physician = new KardexHelper().derivePhysician();
		List<PatientCaseRecord> patientCaseRecordsByPhysician = null;
		
		model.addAttribute("nurse",nurse);
		model.addAttribute("physician",physician);
		model.addAttribute("user", Context.getUserContext().getAuthenticatedUser());
		if (physician!=null) { 
			patientCaseRecordsByPhysician = new KardexHelper().derivePatientCaseRecordsByPhysicianInChargeId(physician.getId());
			model.addAttribute("patientCaseRecordsByPhysician",patientCaseRecordsByPhysician);
		}
		
	}
	
	private PatientCaseRecord getPatientCaseRecord(Integer patientCaseRecordId) {
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientCaseRecord patientCaseRecord = null;
		if (patientCaseRecordId != null) {
			patientCaseRecord = patientCaseRecordService.getPatientCaseRecordById(patientCaseRecordId);
		}
		return patientCaseRecord;
	}
	
	private PatientCaseRecord getPatientCaseRecordByBedId(Integer bedId) {
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientCaseRecord patientCaseRecord = null;
		patientCaseRecord = patientCaseRecordService.getPatientCaseRecordByBedId(bedId);
		return patientCaseRecord;
	}
	
	@ModelAttribute("beds")
	public List<Bed> getBeds() {
		KardexHelper kardexHelper = new KardexHelper();
		return kardexHelper.getBeds();
	}

}
