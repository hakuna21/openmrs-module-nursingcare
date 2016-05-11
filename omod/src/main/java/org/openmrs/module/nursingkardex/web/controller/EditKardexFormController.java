package org.openmrs.module.nursingkardex.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.Location;
import org.openmrs.Provider;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.Operation;
import org.openmrs.module.nursingkardex.ParenteralOrderInfusion;
import org.openmrs.module.nursingkardex.ParenteralOrderType;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.Physician;
import org.openmrs.module.nursingkardex.ProblemClassification;
import org.openmrs.module.nursingkardex.Procedure;
import org.openmrs.module.nursingkardex.ShiftProblem;
import org.openmrs.module.nursingkardex.api.BedService;
import org.openmrs.module.nursingkardex.api.NurseService;
import org.openmrs.module.nursingkardex.api.OperationService;
import org.openmrs.module.nursingkardex.api.ParenteralOrderInfusionService;
import org.openmrs.module.nursingkardex.api.ParenteralOrderTypeService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.api.ProblemClassificationService;
import org.openmrs.module.nursingkardex.api.ProcedureService;
import org.openmrs.module.nursingkardex.api.ShiftProblemService;
import org.openmrs.module.nursingkardex.util.EnumUtils.DietConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.NursingInterventionEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OxygenationEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.ProcedureConceptEnum;
import org.openmrs.module.nursingkardex.web.form.DietForm;
import org.openmrs.module.nursingkardex.web.form.MonitoringForm;
import org.openmrs.module.nursingkardex.web.form.NursingInterventionForm;
import org.openmrs.module.nursingkardex.web.form.NursingProblemForm;
import org.openmrs.module.nursingkardex.web.form.OutputForm;
import org.openmrs.module.nursingkardex.web.form.ParenteralOrderForm;
import org.openmrs.module.nursingkardex.web.form.ProcedureForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.openmrs.User;

@Controller
public class EditKardexFormController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/module/nursingkardex/editKardex", method = RequestMethod.GET)
	public void showFrom(@RequestParam(required = false, value = "patientCaseRecordId") Integer patientCaseRecordId,
	                     ModelMap model) throws IllegalAccessException, InstantiationException, InvocationTargetException,
	    NoSuchMethodException {
		

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
		
		// set up encounter if needed
		KardexHelper kardexHelper = new KardexHelper();
		kardexHelper.setupDutyShiftEncounter(patientCaseRecordId);
		
		// setup nursing shift problem
		NursingProblemForm nursingProblemForm = kardexHelper.setupNursingProblemForm(patientCaseRecordId);
		model.addAttribute("nursingProblemForm", nursingProblemForm);
		
		// setup Diet form
		DietForm dietForm = kardexHelper.setupDietForm(patientCaseRecordId);
		model.addAttribute("dietForm", dietForm);
		
		// setup monitoring form
		MonitoringForm monitoringForm = kardexHelper.setupMonitoringForm(patientCaseRecordId);
		model.addAttribute("monitoringForm", monitoringForm);
		
		// setup procedure form
		ProcedureForm procedureForm = kardexHelper.setupProcedureForm(patientCaseRecordId);
		model.addAttribute("procedureForm", procedureForm);
		
		// setup output form
		OutputForm outputForm = kardexHelper.setupOutputForm(patientCaseRecordId);
		model.addAttribute("outputForm", outputForm);
		
		// setup intervention form
		NursingInterventionForm nursingInterventionForm = kardexHelper.setupNursingInterventionForm(patientCaseRecordId);
		model.addAttribute("nursingInterventionForm", nursingInterventionForm);
		
		// setup parenteral order form
		ParenteralOrderForm parenteralOrderForm = kardexHelper.setupParenteralOrderForm(patientCaseRecordId);
		model.addAttribute("parenteralOrderForm", parenteralOrderForm);
		
	}
	
	@ModelAttribute("shiftProblems")
	public List<ShiftProblem> getShiftProblems(@RequestParam(required = false, value = "patientCaseRecordId") Integer patientCaseRecordId) {
		ShiftProblemService shiftProblemService = Context.getService(ShiftProblemService.class);
		return shiftProblemService.getActiveShiftProblemsByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@ModelAttribute("nursingProblems")
	public List<ProblemClassification> getNursingProblems() {
		ProblemClassificationService problemClassificationService = Context.getService(ProblemClassificationService.class);
		return problemClassificationService.getAllProblemClassifications();
	}
	
	@ModelAttribute("patientCaseRecord")
	public PatientCaseRecord viewPatientCaseRecord(@RequestParam(value = "patientCaseRecordId", required = false) Integer patientCaseRecordId) {
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientCaseRecord patientCaseRecord = null;
		if (patientCaseRecordId != null) {
			patientCaseRecord = patientCaseRecordService.getPatientCaseRecordById(patientCaseRecordId);
		}
		return patientCaseRecord;
	}
	
	@ModelAttribute("dietTypeConcepts")
	public List<Concept> getDietTypeConcepts() {
		Concept dietTypeConcept = Context.getConceptService().getConceptByUuid(DietConceptEnum.DIET_TYPE.getValue());
		List<Concept> concepts = new ArrayList<Concept>();
		Collection<ConceptAnswer> conceptAnswers = dietTypeConcept.getAnswers();
		for (ConceptAnswer answer : conceptAnswers) {
			concepts.add(answer.getAnswerConcept());
		}
		return concepts;
	}
	
	@ModelAttribute("dietaryInstructions")
	public List<Concept> getDietaryInstructions() {
		Concept dietaryInstructionConcept = Context.getConceptService().getConceptByUuid(
		    DietConceptEnum.DIETARY_INSTRUCTION.getValue());
		List<Concept> concepts = new ArrayList<Concept>();
		Collection<ConceptAnswer> conceptAnswers = dietaryInstructionConcept.getAnswers();
		for (ConceptAnswer answer : conceptAnswers) {
			concepts.add(answer.getAnswerConcept());
		}
		return concepts;
	}
	
	@ModelAttribute("dietRoutes")
	public List<Concept> getDietRoutes() {
		Concept dietRouteConcept = Context.getConceptService().getConceptByUuid(DietConceptEnum.DIET_ROUTE.getValue());
		List<Concept> concepts = new ArrayList<Concept>();
		Collection<ConceptAnswer> conceptAnswers = dietRouteConcept.getAnswers();
		for (ConceptAnswer answer : conceptAnswers) {
			concepts.add(answer.getAnswerConcept());
		}
		return concepts;
	}
	
	@ModelAttribute("monitoringSelect1")
	public static Map<String, String> monitoringSelect1() {
		LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
		options.put("q shift", "q shift");
		options.put("q 4h", "q 4h");
		options.put("q 2h", "q 2h");
		options.put("q 1h", "q 1h");
		options.put("q 30 min", "q 30 min");
		options.put("q 15 min", "q 15 min");
		options.put("OD", "OD");
		return options;
	}
	
	@ModelAttribute("monitoringSelect2")
	public static Map<String, String> monitoringSelect2() {
		LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
		options.put("q shift", "q 4h");
		options.put("OD", "OD");
		options.put("q 2 days", "q 2 days");
		return options;
	}
	
	@ModelAttribute("procedureStatuses")
	public static Map<String, String> procedureStatuses() {
		LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
		options.put("for", "for");
		options.put("ongoing", "ongoing");
		options.put("ffup", "follow-up");
		options.put("with", "available");
		return options;
	}
	
	@ModelAttribute("laboratoryConcepts")
	public List<Concept> getLaboratories() {
		Concept laboratoryConcept = Context.getConceptService().getConceptByUuid(
		    ProcedureConceptEnum.LABORATORY_TEST.getValue());
		List<Concept> concepts = new ArrayList<Concept>();
		Collection<ConceptAnswer> conceptAnswers = laboratoryConcept.getAnswers();
		for (ConceptAnswer answer : conceptAnswers) {
			concepts.add(answer.getAnswerConcept());
		}
		return concepts;
	}
	
	@ModelAttribute("patientLabs")
	public List<Procedure> getPatientLaboratories(@RequestParam(required = false, value = "patientCaseRecordId") Integer patientCaseRecordId) {
		ProcedureService procedureService = Context.getService(ProcedureService.class);
		return procedureService.getLaboratoriesByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@ModelAttribute("procedures")
	public List<Concept> getProcedures() {
		Concept diagnosticProcedureConcept = Context.getConceptService().getConceptByUuid(
		    ProcedureConceptEnum.DIAGNOSTIC_PROCEDURE.getValue());
		Concept interventionalProcedureConcept = Context.getConceptService().getConceptByUuid(
		    ProcedureConceptEnum.INTERVENTIONAL_PROCEDURE.getValue());
		List<Concept> concepts = new ArrayList<Concept>();
		for (ConceptAnswer answer : diagnosticProcedureConcept.getAnswers()) {
			concepts.add(answer.getAnswerConcept());
		}
		for (ConceptAnswer answer : interventionalProcedureConcept.getAnswers()) {
			concepts.add(answer.getAnswerConcept());
		}
		return concepts;
	}
	
	@ModelAttribute("patientProcedures")
	public List<Procedure> getPatientProcedures(@RequestParam(required = false, value = "patientCaseRecordId") Integer patientCaseRecordId) {
		ProcedureService procedureService = Context.getService(ProcedureService.class);
		return procedureService.getProceduresByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@ModelAttribute("patientOtherProcedures")
	public List<Procedure> getPatientOtherProcedures(@RequestParam(required = false, value = "patientCaseRecordId") Integer patientCaseRecordId) {
		ProcedureService procedureService = Context.getService(ProcedureService.class);
		return procedureService.getOtherProceduresByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@ModelAttribute("patientOperations")
	public List<Operation> getPatientOperations(@RequestParam(required = false, value = "patientCaseRecordId") Integer patientCaseRecordId) {
		OperationService operationService = Context.getService(OperationService.class);
		return operationService.getOperationsByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@ModelAttribute("bedsorePrecautions")
	public List<Concept> getBedsorePrecautionConcepts() {
		Concept dietTypeConcept = Context.getConceptService().getConceptByUuid(
		    NursingInterventionEnum.BEDSORE_PRECAUTION.getValue());
		List<Concept> concepts = new ArrayList<Concept>();
		Collection<ConceptAnswer> conceptAnswers = dietTypeConcept.getAnswers();
		for (ConceptAnswer answer : conceptAnswers) {
			concepts.add(answer.getAnswerConcept());
		}
		return concepts;
	}
	
	@ModelAttribute("oxygenSupports")
	public List<Concept> getOxygenSupportConcepts() {
		Concept oxygenSupportConcept = Context.getConceptService().getConceptByUuid(OxygenationEnum.OXYGEN_SUPPORT.getValue());
		List<Concept> concepts = new ArrayList<Concept>();
		Collection<ConceptAnswer> conceptAnswers = oxygenSupportConcept.getAnswers();
		for (ConceptAnswer answer : conceptAnswers) {
			concepts.add(answer.getAnswerConcept());
		}
		return concepts;
	}
	
	@ModelAttribute("levelOfCareOptions")
	public static Map<String, String> levelOfCareOptions() {
		LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
		options.put("1", "I");
		options.put("2", "II");
		options.put("3", "III");
		options.put("4", "IV");
		return options;
	}
	
	@ModelAttribute("patientParenteralOrders")
	public List<ParenteralOrderInfusion> getPatientParenteralOrders(@RequestParam(required = false, value = "patientCaseRecordId") Integer patientCaseRecordId) {
		ParenteralOrderInfusionService parenteralOrderInfusionService = Context
		        .getService(ParenteralOrderInfusionService.class);
		return parenteralOrderInfusionService.getParenteralOrderInfusionByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@ModelAttribute("parenteralOrderTypes")
	public List<ParenteralOrderType> getParenteralOrderTypes() {
		ParenteralOrderTypeService parenteralOrderTypeService = Context.getService(ParenteralOrderTypeService.class);
		return parenteralOrderTypeService.getAllParentalOrderTypes();
	}

	@ModelAttribute("beds")
	public List<Bed> getBeds() {
		KardexHelper kardexHelper = new KardexHelper();
		return kardexHelper.getBeds();
	}
}
