package org.openmrs.module.nursingkardex.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.Provider;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.Physician;
import org.openmrs.module.nursingkardex.PhysicianDepartment;
import org.openmrs.module.nursingkardex.api.PhysicianDepartmentService;
import org.openmrs.module.nursingkardex.api.PhysicianService;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhysicianFormController {
	
	@RequestMapping(value = "/module/nursingkardex/physician", method = RequestMethod.GET)
	public void showFrom() {
		
	}
	
	@RequestMapping(value = "/module/nursingkardex/physician", method = RequestMethod.POST)
	public String managePhysician(HttpServletRequest request,
	                              @RequestParam(required = false, value = "action") String action,
	                              @RequestParam(required = false, value = "id") Integer id,
	                              @RequestParam(required = false, value = "providerId") Integer providerId,
	                              @ModelAttribute("physician") Physician physician, ModelMap model) {
		PhysicianService physicianService = Context.getService(PhysicianService.class);
		if (action.equals("Save Physician")) {
			if (providerId != null) {
				physician.setProvider(Context.getProviderService().getProvider(providerId));
			}
			physician = physicianService.savePhysician(physician);
			request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Physician.saved");
			return "redirect:physician.form?nurseId=" + physician.getId();
		}
		if (action.equals("Delete Physician")) {
			Physician physicianToDelete = physicianService.getPhysicianById(id);
			physicianService.deletePhysician(physicianToDelete);
			request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Physician.deleted");
			return "redirect:providers.form";
		}
		return null;
	}
	
	@ModelAttribute("physician")
	public Physician physician(@RequestParam(value = "physicianId", required = false) Integer physicianId, ModelMap model) {
		
		Physician physician = null;
		if (physicianId != null) {
			PhysicianService physicianService = Context.getService(PhysicianService.class);
			physician = physicianService.getPhysicianById(physicianId);
		} else {
			physician = new Physician();
		}
		return physician;
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
	
	@ModelAttribute("providers")
	public List<Provider> getProviders() {
		PhysicianService physicianService = Context.getService(PhysicianService.class);
		return physicianService.getUnassignedProviders();
	}
	
}
