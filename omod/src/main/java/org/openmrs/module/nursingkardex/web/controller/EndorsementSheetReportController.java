package org.openmrs.module.nursingkardex.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.openmrs.api.context.Context;
import org.openmrs.User;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.report.EndorsementBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EndorsementSheetReportController {
	
	@RequestMapping(value = "/module/nursingkardex/endorsementSheetReport", method = RequestMethod.GET)
	public void showFrom(ModelMap model) {
		ReportHelper reportHelper = new ReportHelper();
		List<PatientCaseRecord> activeRecords = reportHelper.getActivePatientCaseRecords();
		
		model.addAttribute("user", Context.getUserContext().getAuthenticatedUser());

		if (activeRecords != null && !activeRecords.isEmpty()) {
			List<EndorsementBean> endorsementList = new ArrayList<EndorsementBean>();
			
			for (PatientCaseRecord patientCaseRecord : activeRecords) {
				EndorsementBean endorsement = reportHelper.setupEndorsementBean(patientCaseRecord);
				endorsementList.add(endorsement);
			}
			model.addAttribute("endorsementList", endorsementList);
		}
	}
	
}
