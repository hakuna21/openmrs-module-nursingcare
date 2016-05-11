package org.openmrs.module.nursingkardex.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WardCensusController {
	
	@RequestMapping(value = "/module/nursingkardex/wardCensus", method = RequestMethod.GET)
	public void showFrom() {

	}

}
