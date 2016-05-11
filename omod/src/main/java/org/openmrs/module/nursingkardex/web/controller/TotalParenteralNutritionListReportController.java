package org.openmrs.module.nursingkardex.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openmrs.User;
import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.Encounter;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.DietOrderRequirement;
import org.openmrs.module.nursingkardex.NursingCareOrder;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.api.DietOrderRequirementService;
import org.openmrs.module.nursingkardex.api.NursingCareOrderService;
import org.openmrs.module.nursingkardex.report.DietBean;
import org.openmrs.module.nursingkardex.util.EnumUtils.DietConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OrderTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TotalParenteralNutritionListReportController {
	
	@RequestMapping(value = "/module/nursingkardex/totalParenteralNutritionListReport", method = RequestMethod.GET)
	public void showReport(ModelMap model) {
		NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
		DietOrderRequirementService dietOrderRequirementService = Context.getService(DietOrderRequirementService.class);

		model.addAttribute("user", Context.getUserContext().getAuthenticatedUser());
		
		ReportHelper reportHelper = new ReportHelper();
		List<PatientCaseRecord> activeRecords = reportHelper.getActivePatientCaseRecords();
		if (activeRecords != null && !activeRecords.isEmpty()) {
			List<DietBean> dietList = new ArrayList<DietBean>();
			
			for (PatientCaseRecord patientCaseRecord : activeRecords) {
				Encounter encounter = Context.getEncounterService().getEncounter(
				    patientCaseRecord.getLatestPatientMovement().getEncounter().getEncounterId());
				List<NursingCareOrder> dietOrders = nursingCareOrderService
				        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecord.getId(),
				            OrderTypeEnum.DIET_ORDER.getValue());
				
				String bedNo = patientCaseRecord.getLatestPatientMovement().getBed().getRoomName();
				String name = patientCaseRecord.getLatestPatientMovement().getPatientCaseRecord().getPatient()
				        .getPersonName().getFullName();
				String admittingDiagnosis = patientCaseRecord.getLatestPatientMovement().getPatientCaseRecord().getAdmittingDiagnosis();
				String workingImpression = patientCaseRecord.getLatestPatientMovement().getPatientCaseRecord().getWorkingImpression();
				String finalDiagnosis = patientCaseRecord.getLatestPatientMovement().getPatientCaseRecord().getFinalDiagnosis();
				String operationRemarks = patientCaseRecord.getLatestPatientMovement().getPatientCaseRecord().getOperationRemarks();
						
				String specialDiet = deriveSpecialDiet(dietOrders);
				
				DietBean dietBean = new DietBean();
				dietBean.setBedNo(bedNo);
				dietBean.setNameOfPatient(name);
				
				List<DietOrderRequirement> dietOrderRequirements = dietOrderRequirementService
				        .getDietOrderRequirementsByEncounter(encounter.getEncounterId());
				if (dietOrderRequirements != null && !dietOrderRequirements.isEmpty()) {
					DietOrderRequirement diet = dietOrderRequirements.get(0);
					if(diet.getCalories()!=null){
						dietBean.setCal(diet.getCalories());
					}
					dietBean.setCho(diet.getCarbohydrates());
					dietBean.setChon(diet.getProtein());
					dietBean.setFat(diet.getFats());
					dietBean.setNa(diet.getSodium());
					dietBean.setFluidRequirementMlPerKg(diet.getFluidRequirementMlPerKg());
					dietBean.setSterileWaterMl(diet.getSterileWaterMl());
					dietBean.setSodiumChloride(diet.getSodiumChloride());
					dietBean.setAminoAcids(diet.getAminoAcids());
					dietBean.setDextrose(diet.getDextrose());
					dietBean.setCalciumGluconate(diet.getCalciumGluconate());
					dietBean.setMagnesiumSulfate(diet.getMagnesiumSulfate());
					dietBean.setMultivitamins(diet.getMultivitamins());
					dietBean.setLipids(diet.getLipids());
					dietBean.setInsulin(diet.getInsulin());
					dietBean.setTpn(diet.getTpn());
					dietBean.setTotalVolume(diet.getTotalVolume());
					dietBean.setRequestedBy(diet.getRequestedBy());
					dietBean.setOrderType(diet.getOrderType());
					dietBean.setIndication(diet.getIndication());
					dietBean.setDuration(diet.getDuration());
				}
				dietList.add(dietBean);
			}
			
			model.addAttribute("dietList", dietList);
		}
		
	}
	
	private String deriveOrderFromConcept(List<NursingCareOrder> dietOrders, String uuid) {
		for (NursingCareOrder diet : dietOrders) {
			if (uuid.equals(diet.getConcept().getUuid())) {
				return "/";
			}
		}
		return "";
	}
	
	private String deriveSpecialDiet(List<NursingCareOrder> dietOrders) {
		String specialDiet = "";
		Concept dietaryInstructionConcept = Context.getConceptService().getConceptByUuid(
		    DietConceptEnum.DIETARY_INSTRUCTION.getValue());
		Collection<ConceptAnswer> conceptAnswers = dietaryInstructionConcept.getAnswers();
		for (ConceptAnswer answer : conceptAnswers) {
			String instructionUuid = answer.getAnswerConcept().getUuid();
			if (dietOrders != null && !dietOrders.isEmpty()) {
				for (NursingCareOrder diet : dietOrders) {
					if (instructionUuid.equals(diet.getConcept().getUuid())) {
						specialDiet = specialDiet + diet.getConcept().getName().getName() + "<br/>";
					}
				}
			}
		}
		
		return specialDiet;
	}
	
}
