package org.openmrs.module.nursingkardex.web.controller;

import java.util.Date;
import java.util.List;

import org.openmrs.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Location;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.Physician;
import org.openmrs.module.nursingkardex.api.BedService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.api.PatientMovementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NursingKardexPageController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/module/nursingkardex/nursingKardex", method = RequestMethod.GET)
	public void showForm(ModelMap model) {
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientMovementService patientMovementService = Context.getService(PatientMovementService.class);
		Nurse nurse = new KardexHelper().deriveNurse();
		Physician physician = new KardexHelper().derivePhysician();
		List<PatientCaseRecord> patientCaseRecordsByPhysician = null;

		model.addAttribute("user", Context.getUserContext().getAuthenticatedUser());
		model.addAttribute("nurse", nurse);
		model.addAttribute("physician", physician);
		
		if (physician!=null) { 
			patientCaseRecordsByPhysician = new KardexHelper().derivePatientCaseRecordsByPhysicianInChargeId(physician.getId());
			model.addAttribute("patientCaseRecordsByPhysician",patientCaseRecordsByPhysician);
		}
		
		BedService bedService = Context.getService(BedService.class);
		List<Bed> beds = null;
		Location location = null;
		Integer locationId = null;
		if (nurse != null) {
			beds = bedService.getBedsByLocationId(nurse.getLocation().getLocationId());
			location = nurse.getLocation();
			locationId = location.getId();
		} else {
			beds = bedService.getAllBeds();
			location = beds.get(0).getLocation();
		}
		
		model.addAttribute("location", location);
		model.addAttribute("beds", beds);
		model.addAttribute("today", new Date());
		model.addAttribute("totalPatientCount",
		    patientCaseRecordService.getTotalPatientCaseRecordCountByLocation(locationId));
		model.addAttribute("totalRoomingInCount", patientMovementService.getTotalRoomingInCountByLocation(locationId));
	}
	
}
