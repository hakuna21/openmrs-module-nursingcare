package org.openmrs.module.nursingkardex.web.controller;

import java.util.List;

import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.api.BedService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MigrateNursesController {
	
	@RequestMapping(value = "/module/nursingkardex/migrateNurses", method = RequestMethod.GET)
	public void showFrom(ModelMap model) {
		
	}
	
	@ModelAttribute("beds")
	public List<Bed> getBeds() {
		KardexHelper kardexHelper = new KardexHelper();
		return kardexHelper.getBeds();
	}
}