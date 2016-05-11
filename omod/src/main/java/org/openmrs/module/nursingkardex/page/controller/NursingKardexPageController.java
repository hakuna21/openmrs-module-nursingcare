package org.openmrs.module.nursingkardex.page.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.api.BedService;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

public class NursingKardexPageController {

	public void controller(FragmentModel model,
			@SpringBean("bedService") BedService bedService) {
//		model.addAttribute("beds", bedService.getAllBeds());
	}

}
