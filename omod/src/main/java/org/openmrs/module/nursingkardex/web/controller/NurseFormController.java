package org.openmrs.module.nursingkardex.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.Location;
import org.openmrs.Provider;
import org.openmrs.api.LocationService;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.api.NurseService;
import org.openmrs.module.nursingkardex.api.PhysicianService;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NurseFormController {
	
	@RequestMapping(value = "/module/nursingkardex/nurse", method = RequestMethod.GET)
	public void showFrom() {
		
	}
	
	@RequestMapping(value = "/module/nursingkardex/nurse", method = RequestMethod.POST)
	public String manageNurse(HttpServletRequest request, @RequestParam(required = false, value = "action") String action,
	                          @RequestParam(required = false, value = "id") Integer id,
	                          @RequestParam(required = false, value = "providerId") Integer providerId,
	                          @ModelAttribute("nurse") Nurse nurse, ModelMap model) {
		NurseService nurseService = Context.getService(NurseService.class);
		if (action.equals("Save Nurse")) {
			if (providerId != null) {
				nurse.setProvider(Context.getProviderService().getProvider(providerId));
			}
			nurse = nurseService.saveNurse(nurse);
			request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Nurse.saved");
			return "redirect:nurse.form?nurseId=" + nurse.getId();
		}
		if (action.equals("Delete Nurse")) {
			Nurse nurseToDelete = nurseService.getById(id);
			nurseService.deleteNurse(nurseToDelete);
			request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Nurse.deleted");
			return "redirect:providers.form";
		}
		return null;
	}
	
	@ModelAttribute("nurse")
	public Nurse nurse(@RequestParam(value = "nurseId", required = false) Integer nurseId, ModelMap model) {
		Nurse nurse = null;
		if (nurseId != null) {
			NurseService nurseService = Context.getService(NurseService.class);
			nurse = nurseService.getById(nurseId);
		} else {
			nurse = new Nurse();
		}
		return nurse;
	}
	
	@ModelAttribute("beds")
	public List<Bed> getBeds() {
		KardexHelper kardexHelper = new KardexHelper();
		return kardexHelper.getBeds();
	}
	
	@ModelAttribute("locations")
	public List<Location> getLocations() {
		LocationService locationService = Context.getLocationService();
		return locationService.getAllLocations(false);
	}
	
	@ModelAttribute("providers")
	public List<Provider> getProviders() {
		PhysicianService physicianService = Context.getService(PhysicianService.class);
		return physicianService.getUnassignedProviders();
	}
	
}
