package org.openmrs.module.nursingkardex.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.Location;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.WardAggregate;
import org.openmrs.module.nursingkardex.api.WardAggregateService;
import org.openmrs.module.nursingkardex.util.EnumUtils.WardAggregateEnum;
import org.openmrs.module.nursingkardex.web.form.WardAggregateForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WardAggregateEntryController {
	
	@RequestMapping(value = "/module/nursingkardex/wardAggregateEntry", method = RequestMethod.GET)
	public void showForm(ModelMap model) {
		
		WardAggregateForm form = new WardAggregateForm();
		WardAggregateService wardAggregateService = Context.getService(WardAggregateService.class);

		model.addAttribute("user", Context.getUserContext().getAuthenticatedUser());
		Nurse nurse = new KardexHelper().deriveNurse();
		Integer locationId = (nurse != null) ? nurse.getLocation().getId() : null;
		form.setLocationId(locationId);
		
		List<WardAggregate> list = wardAggregateService.getWardAggregatesByLocation(locationId);
		if (list != null && !list.isEmpty()) {
			for (WardAggregate wardAggregate : list) {
				String uuid = wardAggregate.getConcept().getUuid();
				if (uuid.equals(WardAggregateEnum.DROPS.getValue())) {
					form.setDrops(wardAggregate);
				} else if (uuid.equals(WardAggregateEnum.ENEMA_IRRIGATION.getValue())) {
					form.setEnemaIrigation(wardAggregate);
				} else if (uuid.equals(WardAggregateEnum.INTRADERMAL.getValue())) {
					form.setIntradermal(wardAggregate);
				} else if (uuid.equals(WardAggregateEnum.INTRAMUSCULAR.getValue())) {
					form.setIntramuscular(wardAggregate);
				} else if (uuid.equals(WardAggregateEnum.INTRAVENOUS.getValue())) {
					form.setIntravenous(wardAggregate);
				} else if (uuid.equals(WardAggregateEnum.LINEN_CHANGE.getValue())) {
					form.setLinenChange(wardAggregate);
				} else if (uuid.equals(WardAggregateEnum.ORAL.getValue())) {
					form.setOral(wardAggregate);
				} else if (uuid.equals(WardAggregateEnum.OTHERS.getValue())) {
					form.setOthers(wardAggregate);
				} else if (uuid.equals(WardAggregateEnum.SUBCUTANEOUS.getValue())) {
					form.setSubcutaneous(wardAggregate);
				} else if (uuid.equals(WardAggregateEnum.SUPPOSITORIES.getValue())) {
					form.setSuppositories(wardAggregate);
				} else if (uuid.equals(WardAggregateEnum.TOPICAL.getValue())) {
					form.setTopical(wardAggregate);
				}
			}
		}
		model.addAttribute("wardAggregateForm", form);
	}
	
	@RequestMapping(value = "/module/nursingkardex/wardAggregateEntry", method = RequestMethod.POST)
	public String saveWardAggregate(HttpServletRequest request,
	                                @ModelAttribute("wardAggregateForm") WardAggregateForm wardAggregateForm,
	                                BindingResult result, ModelMap model) {
		WardAggregateService wardAggregateService = Context.getService(WardAggregateService.class);
		
		Nurse nurse = new KardexHelper().deriveNurse();
		Integer locationId = (nurse != null) ? nurse.getLocation().getId() : null;
		
		wardAggregateService.saveWardAggregate(setupWardAggregateObject(wardAggregateForm.getDrops(),
		    WardAggregateEnum.DROPS.getValue()));
		wardAggregateService.saveWardAggregate(setupWardAggregateObject(wardAggregateForm.getEnemaIrigation(),
		    WardAggregateEnum.ENEMA_IRRIGATION.getValue()));
		wardAggregateService.saveWardAggregate(setupWardAggregateObject(wardAggregateForm.getIntradermal(),
		    WardAggregateEnum.INTRADERMAL.getValue()));
		wardAggregateService.saveWardAggregate(setupWardAggregateObject(wardAggregateForm.getIntramuscular(),
		    WardAggregateEnum.INTRAMUSCULAR.getValue()));
		wardAggregateService.saveWardAggregate(setupWardAggregateObject(wardAggregateForm.getIntravenous(),
		    WardAggregateEnum.INTRAVENOUS.getValue()));
		wardAggregateService.saveWardAggregate(setupWardAggregateObject(wardAggregateForm.getLinenChange(),
		    WardAggregateEnum.LINEN_CHANGE.getValue()));
		wardAggregateService.saveWardAggregate(setupWardAggregateObject(wardAggregateForm.getOral(),
		    WardAggregateEnum.ORAL.getValue()));
		wardAggregateService.saveWardAggregate(setupWardAggregateObject(wardAggregateForm.getOthers(),
		    WardAggregateEnum.OTHERS.getValue()));
		wardAggregateService.saveWardAggregate(setupWardAggregateObject(wardAggregateForm.getSubcutaneous(),
		    WardAggregateEnum.SUBCUTANEOUS.getValue()));
		wardAggregateService.saveWardAggregate(setupWardAggregateObject(wardAggregateForm.getSuppositories(),
		    WardAggregateEnum.SUPPOSITORIES.getValue()));
		wardAggregateService.saveWardAggregate(setupWardAggregateObject(wardAggregateForm.getTopical(),
		    WardAggregateEnum.TOPICAL.getValue()));
		
		return "redirect:wardAggregateEntry.form?locationId=" + wardAggregateForm.getLocationId();
	}
	
	@ModelAttribute("beds")
	public List<Bed> getBeds() {
		KardexHelper kardexHelper = new KardexHelper();
		return kardexHelper.getBeds();
	}
	
	private WardAggregate setupWardAggregateObject(WardAggregate wardAggregate, String conceptUuid) {
		Nurse nurse = new KardexHelper().deriveNurse();
		Integer locationId = (nurse != null) ? nurse.getLocation().getId() : null;
		
//		Location location = new Location();
//		location.setLocationId(locationId);
//		wardAggregate.setLocation(location);
		wardAggregate.setLocation(Context.getLocationService().getLocation(locationId));
		wardAggregate.setCreator(Context.getUserContext().getAuthenticatedUser());
		wardAggregate.setDateCreated(new Date());
		wardAggregate.setConcept(Context.getConceptService().getConceptByUuid(conceptUuid));
		return wardAggregate;
	}
	
//	private WardAggregate setupWardAggregate(Integer id, String conceptUuid, Integer locationId, String remarks,
//	                                         Integer tally) {
//		WardAggregate wardAggregate = new WardAggregate();
//		wardAggregate.setConcept(Context.getConceptService().getConceptByUuid(conceptUuid));
//		wardAggregate.setCreator(Context.getUserContext().getAuthenticatedUser());
//		wardAggregate.setDateCreated(new Date());
//		wardAggregate.setId(id);
//		wardAggregate.setLocation(Context.getLocationService().getLocation(locationId));
//		wardAggregate.setRemarks(remarks);
//		wardAggregate.setTally(tally);
//		return wardAggregate;
//	}
	
}
