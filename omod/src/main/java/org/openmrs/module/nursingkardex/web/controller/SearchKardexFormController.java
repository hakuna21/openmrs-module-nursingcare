package org.openmrs.module.nursingkardex.web.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.Physician;
import org.openmrs.module.nursingkardex.PhysicianDepartment;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.api.PhysicianDepartmentService;
import org.openmrs.module.nursingkardex.api.PhysicianService;
import org.openmrs.module.nursingkardex.util.SearchKardexObj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.openmrs.User;

@Controller
public class SearchKardexFormController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/module/nursingkardex/search", method = RequestMethod.GET)
	public void showForm(ModelMap model) {
		SearchKardexObj searchKardexObj = new SearchKardexObj();
		model.addAttribute("searchKardexObj", searchKardexObj);
		
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
	
	@RequestMapping(value = "/module/nursingkardex/search", method = RequestMethod.POST)
	public void search(@ModelAttribute("searchKardexObj") SearchKardexObj searchKardexObj, ModelMap model) {
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		Nurse nurse = new KardexHelper().deriveNurse();
		Integer locationId = (nurse != null) ? nurse.getLocation().getId() : null;
		
		List<PatientCaseRecord> results = patientCaseRecordService.searchPatientCaseRecords(searchKardexObj.getName(),
		    searchKardexObj.getBedId(), searchKardexObj.getPhysicianDepartmentId(), searchKardexObj.getPhysicianId(),
		    locationId);
		model.addAttribute("results", results);
		//		return "/module/nursingkardex/search.jsp";
		
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
	
	@ModelAttribute("beds")
	public List<Bed> getBeds() {
		KardexHelper kardexHelper = new KardexHelper();
		return kardexHelper.getBeds();
	}
	
	@ModelAttribute("departments")
	public List<PhysicianDepartment> getPhysicianDepartments() {
		PhysicianDepartmentService physicianDepartmentService = Context.getService(PhysicianDepartmentService.class);
		return physicianDepartmentService.getAllPhysicianDepartments();
	}
	
	@ModelAttribute("physicians")
	public List<Physician> getPhysicians() {
		PhysicianService physicianService = Context.getService(PhysicianService.class);
		return physicianService.getAllPhysicians();
	}
	
}
