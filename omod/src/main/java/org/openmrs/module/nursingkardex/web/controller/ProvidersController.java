package org.openmrs.module.nursingkardex.web.controller;

import java.util.List;

import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.Physician;
import org.openmrs.module.nursingkardex.api.NurseService;
import org.openmrs.module.nursingkardex.api.PhysicianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProvidersController {
	
	@RequestMapping(value = "/module/nursingkardex/providers", method = RequestMethod.GET)
	public void showFrom(ModelMap model) {
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

	}
	
	@ModelAttribute("physicians")
	public List<Physician> getPhysicians() {
		PhysicianService physicianService = Context.getService(PhysicianService.class);
		return physicianService.getAllPhysicians();
	}
	
	@ModelAttribute("nurses")
	public List<Nurse> getNurses() {
		NurseService nurseService = Context.getService(NurseService.class);
		return nurseService.getAllNurses();
	}
	
	@ModelAttribute("beds")
	public List<Bed> getBeds() {
		KardexHelper kardexHelper = new KardexHelper();
		return kardexHelper.getBeds();
	}
	
}
