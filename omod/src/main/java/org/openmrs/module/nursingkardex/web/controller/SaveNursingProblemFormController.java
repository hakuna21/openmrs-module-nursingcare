package org.openmrs.module.nursingkardex.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.openmrs.Encounter;
import org.openmrs.OrderType;
import org.openmrs.Provider;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.NursingCareOrder;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.ShiftProblem;
import org.openmrs.module.nursingkardex.api.NursingCareOrderService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.api.ProblemClassificationService;
import org.openmrs.module.nursingkardex.api.ShiftProblemService;
import org.openmrs.module.nursingkardex.util.EnumUtils.DietConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.MonitoringConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OrderTypeEnum;
import org.openmrs.module.nursingkardex.web.form.NursingProblemForm;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaveNursingProblemFormController {
	
	@RequestMapping(value = "/module/nursingkardex/saveNursingProblem", method = RequestMethod.POST)
	public String saveNursingProblem(@ModelAttribute("nursingProblemForm") NursingProblemForm nursingProblemForm,
	                                 HttpServletRequest request) throws IllegalAccessException, InstantiationException,
	    InvocationTargetException, NoSuchMethodException {
		
		NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientCaseRecord patientCaseRecord = patientCaseRecordService.getPatientCaseRecordById(nursingProblemForm
		        .getPatientCaseRecordId());
		Encounter currentEncounter = patientCaseRecord.getLatestPatientMovement().getEncounter();
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		
		String[] ids = ServletRequestUtils.getStringParameters(request, "problemClassificationIds");
		List<Integer> problemClassificationIds = new ArrayList<Integer>();
		if (!ArrayUtils.isEmpty(ids)) {
			for (String id : ids) {
				if (StringUtils.hasText(id))
					problemClassificationIds.add(Integer.valueOf(id));
			}
		}
		
		ProblemClassificationService problemClassificationService = Context.getService(ProblemClassificationService.class);
		ShiftProblemService shiftProblemService = Context.getService(ShiftProblemService.class);
		List<ShiftProblem> existingShiftProblems = shiftProblemService
		        .getShiftProblemsByPatientCaseRecordId(nursingProblemForm.getPatientCaseRecordId());
		
		if (existingShiftProblems != null && !existingShiftProblems.isEmpty()) {
			for (ShiftProblem shiftProblem : existingShiftProblems) {
				if (!problemClassificationIds.contains(shiftProblem.getProblemClassification().getId())) {
					//this probem was removed in the UI, delete it in the backend too
					shiftProblem.setActiveProblem(0);
					shiftProblem.setDateStopped(new Date());
					shiftProblem.setCreator(currentUser);
					shiftProblemService.saveShiftProblem(shiftProblem);
				} else {
					//this is an already added Problem
					problemClassificationIds.remove(shiftProblem.getProblemClassification().getId());
				}
			}
		}
		
		//the remaining problemClassificationIds are for the newly added ones, save them in the backend
		for (Integer id : problemClassificationIds) {
			ShiftProblem shiftProblem = new ShiftProblem();
			shiftProblem.setDate(nursingProblemForm.getDate());
			shiftProblem.setEncounter(currentEncounter);
			shiftProblem.setProblemClassification(problemClassificationService.getProblemClassificationById(id));
			shiftProblem.setShift(nursingProblemForm.getShift());
			shiftProblem.setPatientCaseRecord(patientCaseRecord);
			shiftProblem.setCreator(currentUser);
			shiftProblem.setActiveProblem(1);
			shiftProblem.setDateCreated(new Date());
			shiftProblemService.saveShiftProblem(shiftProblem);
		}
		
		request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Nursing Shift Problem saved!");
		return "redirect:editKardex.form?patientCaseRecordId=" + nursingProblemForm.getPatientCaseRecordId();
		
	}
	
}
