package org.openmrs.module.nursingkardex.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.lang.String;

import org.apache.commons.lang.StringUtils;
import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.Provider;
import org.openmrs.User;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.DietOrderRequirement;
import org.openmrs.module.nursingkardex.LevelOfCare;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.NursingCareOrder;
import org.openmrs.module.nursingkardex.Operation;
import org.openmrs.module.nursingkardex.OxygenationOrder;
import org.openmrs.module.nursingkardex.ParenteralOrderInfusion;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.Procedure;
import org.openmrs.module.nursingkardex.api.DietOrderRequirementService;
import org.openmrs.module.nursingkardex.api.LevelOfCareService;
import org.openmrs.module.nursingkardex.api.NurseService;
import org.openmrs.module.nursingkardex.api.NursingCareOrderService;
import org.openmrs.module.nursingkardex.api.OperationService;
import org.openmrs.module.nursingkardex.api.OxygenationOrderService;
import org.openmrs.module.nursingkardex.api.ParenteralOrderInfusionService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.api.ProcedureService;
import org.openmrs.module.nursingkardex.report.EndorsementBean;
import org.openmrs.module.nursingkardex.util.EnumUtils.DietConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.MonitoringConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.NursingInterventionEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OrderTypeEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OutputConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OxygenationEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.ParenteralOrderEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.ProcedureConceptEnum;

public class ReportHelper {
	
	private static final String COMMA = ", ";
	private static final String NEXT_LINE = "<br/>";
	private static final String DASH = " - ";
	private ParenteralOrderInfusionService parenteralOrderInfusionService = Context
	        .getService(ParenteralOrderInfusionService.class);
	private NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
	private DietOrderRequirementService dietOrderRequirementService = Context.getService(DietOrderRequirementService.class);
	private OperationService operationService = Context.getService(OperationService.class); 
	
	public List<PatientCaseRecord> getActivePatientCaseRecords() {
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(), false);
		Provider currentProvider = null;
		if (providers.size() > 1) {
			throw new IllegalStateException("Can't handle users with multiple provider accounts");
		} else if (providers.size() == 1) {
			currentProvider = providers.iterator().next();
		}
		
		NurseService nurseService = Context.getService(NurseService.class);
		Nurse nurse = null;
		if (currentProvider != null) {
			nurse = nurseService.getByProviderId(currentProvider.getProviderId());
		}
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		if (nurse != null)
			return patientCaseRecordService.getActivePatientCaseRecords(nurse.getLocation().getLocationId());
		else
			return patientCaseRecordService.getActivePatientCaseRecords(null);
	}
	
	public EndorsementBean setupEndorsementBean(PatientCaseRecord patientCaseRecord) {
		EndorsementBean endorsement = new EndorsementBean();
		String bedNo = patientCaseRecord.getLatestPatientMovement().getBed().getRoomName();
		endorsement.setBedNo(bedNo);
		String name = patientCaseRecord.getLatestPatientMovement().getPatientCaseRecord().getPatient().getPersonName()
		        .getFullName();
		endorsement.setNameOfPatient(name);
		
		String parenteral = deriveParenteral(patientCaseRecord);
		endorsement.setParenteral(parenteral);
		
		String intake = deriveIntake(patientCaseRecord);
		endorsement.setIntake(intake);
		
		String output = deriveOutput(patientCaseRecord);
		endorsement.setOutput(output);
		
		String monitoring = deriveMonitoring(patientCaseRecord);
		endorsement.setMonitoring(monitoring);
		
		String nursingInterventions = deriveNursingInterventions(patientCaseRecord);
		endorsement.setNursingInterventions(nursingInterventions);
		
		String specialEndorsements = deriveSpecialEndorsements(patientCaseRecord);
		endorsement.setSpecialEndorsements(specialEndorsements);
		
		return endorsement;
	}
	
	private String deriveParenteral(PatientCaseRecord patientCaseRecord) {
		String parenteral = "";
		List<ParenteralOrderInfusion> parenteralOrderInfusions = parenteralOrderInfusionService
		        .getParenteralOrderInfusionByPatientCaseRecordId(patientCaseRecord.getId());
		if (parenteralOrderInfusions != null && !parenteralOrderInfusions.isEmpty()) {
			parenteral = parenteral;
			for (ParenteralOrderInfusion parenteralOrder : parenteralOrderInfusions) {
				if (parenteralOrder.getParenteralOrderType() != null) {
					parenteral = parenteral + parenteralOrder.getParenteralOrderType().getIntravenousFluid() + " "
							+ ( (parenteralOrder.getParenteralOrderType().getVolume().trim().equals("1000"))? (" 1L x"): parenteralOrder.getParenteralOrderType().getVolume()  )
					        + parenteralOrder.getParenteralOrderType().getRegulation() + " "
					        + ((parenteralOrder.getAnatomicalSite()!=null)? ("@" + parenteralOrder.getAnatomicalSite()): (""))
					        + ((parenteralOrder.getRemarks()!=null)? (" (" + parenteralOrder.getRemarks() + ")"): (""))
					        + ", " + NEXT_LINE
					        ;
				} else {
					parenteral = parenteral + parenteralOrder.getIntravenousFluid() + " " + parenteralOrder.getVolume()
					        + "ml x" + parenteralOrder.getRegulation() + " "
					        + ((parenteralOrder.getAnatomicalSite()!=null)? ("@" + parenteralOrder.getAnatomicalSite()): (""))
					        + ((parenteralOrder.getRemarks()!=null)? (" (" + parenteralOrder.getRemarks() + ")"): (""))
					        + ", " + NEXT_LINE
					        ;
				}
			}
			parenteral = ((parenteral.trim()!="")?(parenteral.substring(0, parenteral.length()-3)  + NEXT_LINE + NEXT_LINE): ("") );
		}
		List<NursingCareOrder> parenteralOrders = nursingCareOrderService
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecord.getId(),
		            OrderTypeEnum.PARENTERAL_ORDER.getValue());
		if (parenteralOrders != null && !parenteralOrders.isEmpty()) {
			parenteral = parenteral;
			for (NursingCareOrder order : parenteralOrders) {
				if (order.getConcept().getUuid().equals(ParenteralOrderEnum.CHEMOTHERAPY.getValue())) {
					parenteral = parenteral + order.getConcept().getName().getShortestName() + ": "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(ParenteralOrderEnum.INTRAJUGULAR_CATHETER.getValue())) {
					parenteral = parenteral + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(ParenteralOrderEnum.FEMORAL_CATHETER.getValue())) {
					parenteral = parenteral + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(ParenteralOrderEnum.SUBCLAVIAN_CATHETER.getValue())) {
					parenteral = parenteral + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(ParenteralOrderEnum.ARTERIOVENOUS_FISTULA.getValue())) {
					parenteral = parenteral + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(ParenteralOrderEnum.HEPLOCK.getValue())) {
					parenteral = parenteral + order.getConcept().getName().getShortestName() + " " + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(ParenteralOrderEnum.OTHER_PARENTERAL_INSTRUCTION.getValue())) {
					parenteral = (StringUtils.isNotEmpty(order.getInstruction())) ?  parenteral + order.getInstruction().substring(0, 1).toUpperCase() 
							+ order.getInstruction().substring(1) + NEXT_LINE : parenteral;
				}
			}
		}	
		return parenteral;
	}
	
	private String deriveIntake(PatientCaseRecord patientCaseRecord) {
		String intake = "";
		List<NursingCareOrder> dietOrders = nursingCareOrderService.getActiveNursingCareOrderByPatientCaseOrderAndOrderType(
		    patientCaseRecord.getId(), OrderTypeEnum.DIET_ORDER.getValue());
		String fullDiet = deriveOrderFromConcept(dietOrders, DietConceptEnum.FULL_DIET.getValue(), "FD");
		String softDiet = deriveOrderFromConcept(dietOrders, DietConceptEnum.SOFT_DIET.getValue(), "SD");
		String generalLiquid = deriveOrderFromConcept(dietOrders, DietConceptEnum.GENERAL_LIQUID.getValue(), "GL");
		String clearLiquid = deriveOrderFromConcept(dietOrders, DietConceptEnum.CLEAR_LIQUID.getValue(), "CL");
		String npo = deriveOrderFromConcept(dietOrders, DietConceptEnum.NPO.getValue(), "NPO");
		String npoExceptMeds = deriveOrderFromConcept(dietOrders, DietConceptEnum.NPO_EXCEPT_MEDS.getValue(), "NPO except meds");
		String dietAsTolerated = deriveOrderFromConcept(dietOrders, DietConceptEnum.DIET_AS_TOLERATED.getValue(), "DAT");
		String lightMeal = deriveOrderFromConcept(dietOrders, DietConceptEnum.LIGHT_MEAL.getValue(), "LM");
		String breastfeedingPerDemand = deriveOrderFromConcept(dietOrders, DietConceptEnum.BREASTFEEDING_PER_DEMAND.getValue(), "BFD");
		String osteorizedFeeding = deriveOrderFromConcept(dietOrders, DietConceptEnum.OSTEORIZED_FEEDING.getValue(), "OF");
		String milkFormula = deriveOrderFromConcept(dietOrders, DietConceptEnum.MILK_FORMULA.getValue(), "MF");
		String specialDiet = deriveSpecialDiet(dietOrders);
		intake = fullDiet + softDiet + generalLiquid + clearLiquid + npo + 
				npoExceptMeds + dietAsTolerated + lightMeal + breastfeedingPerDemand + osteorizedFeeding + milkFormula +
				specialDiet;
		
		if (dietOrders != null && !dietOrders.isEmpty()) {
			List<Concept> dietInstructions = new ArrayList<Concept>();
			List<Concept> dietRoutes = new ArrayList<Concept>();
			for (NursingCareOrder order : dietOrders) {
				List<Concept> questionConcepts = Context.getConceptService().getConceptsByAnswer(order.getConcept());
				if (questionConcepts != null && !questionConcepts.isEmpty()) {
					Concept dietTypeConcept = Context.getConceptService().getConceptByUuid(
					    DietConceptEnum.DIET_TYPE.getValue());
					Concept dietRouteConcept = Context.getConceptService().getConceptByUuid(
						    DietConceptEnum.DIET_ROUTE.getValue());
					Concept dietaryInstructionConcept = Context.getConceptService().getConceptByUuid(
					    DietConceptEnum.OTHERS.getValue());
					if (questionConcepts.get(0).getConceptId().equals(dietRouteConcept.getConceptId())) {
						dietRoutes.add(order.getConcept());
					}
					if (questionConcepts.get(0).getConceptId().equals(dietaryInstructionConcept.getConceptId())) {
						dietInstructions.add(order.getConcept());
					}
				}
			}
			if (dietRoutes != null && !dietRoutes.isEmpty()) {
				intake = intake + NEXT_LINE;
				for (Concept route : dietRoutes) {
					intake = intake + route.getName().getShortestName() + NEXT_LINE;
				}
				intake = intake + NEXT_LINE;
			}
			if (dietInstructions != null && !dietInstructions.isEmpty()) {
				intake = intake;
				for (Concept instruction : dietInstructions) {
					intake = intake + instruction.getName().getShortestName() + NEXT_LINE;
				}
				intake = intake + NEXT_LINE;
			}
		}	
		
		List<DietOrderRequirement> additionalDietDetails = dietOrderRequirementService
		        .getActiveDietOrderRequirementsByPatientCaseRecordId(patientCaseRecord.getId());
		if (additionalDietDetails != null && !additionalDietDetails.isEmpty()) {
			intake = intake;
			DietOrderRequirement dietOrderRequirement = additionalDietDetails.get(0);
			if (StringUtils.isNotEmpty(dietOrderRequirement.getCalories()))
				intake = intake + "Cal=" + dietOrderRequirement.getCalories() + NEXT_LINE;
			if (StringUtils.isNotEmpty(dietOrderRequirement.getCarbohydrates())) {
				intake = intake + "CHO=" + dietOrderRequirement.getCarbohydrates() + NEXT_LINE;
			}
			if (StringUtils.isNotEmpty(dietOrderRequirement.getProtein())) {
				intake = intake + "CHON=" + dietOrderRequirement.getProtein() + NEXT_LINE;
			}
			if (StringUtils.isNotEmpty(dietOrderRequirement.getFats())) {
				intake = intake + "Fats=" + dietOrderRequirement.getFats() + NEXT_LINE;
			}
			if (StringUtils.isNotEmpty(dietOrderRequirement.getSodium())) {
				intake = intake + "Na=" + dietOrderRequirement.getSodium() + NEXT_LINE;
			}
			if (dietOrderRequirement.getFluidRestrictionMl() != null) {
				intake = intake + NEXT_LINE + "Fluid limit of " + dietOrderRequirement.getFluidRestrictionMl() + "ml";
			}
//			if (dietOrderRequirement.getFluidRequirementMlPerKg() != null) {
//				intake = intake + "Fluid requirement=" + dietOrderRequirement.getFluidRequirementMlPerKg() + "ml/kg/day";
//			}
//			if (dietOrderRequirement.getFluidRestrictionMl() != null) {
//				intake = intake + "Sterile Water=" + dietOrderRequirement.getSterileWaterMl() + "ml";
//			}
//			if (dietOrderRequirement.getSodiumChloride() != null) {
//				intake = intake + NEXT_LINE + "NaCl: " + dietOrderRequirement.getSodiumChloride();
//			}
//			if (dietOrderRequirement.getAminoAcids() != null) {
//				intake = intake + NEXT_LINE + "Amino acids: " + dietOrderRequirement.getAminoAcids();
//			}
//			if (dietOrderRequirement.getDextrose() != null) {
//				intake = intake + NEXT_LINE + "Dextrose: " + dietOrderRequirement.getDextrose();
//			}
//			if (dietOrderRequirement.getCalciumGluconate() != null) {
//				intake = intake + NEXT_LINE + "CalciumGluconate: " + dietOrderRequirement.getCalciumGluconate();
//			}
//			if (dietOrderRequirement.getMagnesiumSulfate() != null) {
//				intake = intake + NEXT_LINE + "MgSO4: " + dietOrderRequirement.getMagnesiumSulfate();
//			}
//			if (dietOrderRequirement.getMultivitamins() != null) {
//				intake = intake + NEXT_LINE + "Multivitamins: " + dietOrderRequirement.getMultivitamins();
//			}
//			if (dietOrderRequirement.getLipids() != null) {
//				intake = intake + NEXT_LINE + "Lipids: " + dietOrderRequirement.getLipids();
//			}
//			if (dietOrderRequirement.getInsulin() != null) {
//				intake = intake + NEXT_LINE + "Insulin: " + dietOrderRequirement.getInsulin();
//			}
//			if (dietOrderRequirement.getTpn() != null) {
//			intake = intake + NEXT_LINE + "TPN: " + dietOrderRequirement.getTpn();
//			}
		}
		
		String others = deriveOtherDiet(dietOrders, DietConceptEnum.OTHERS.getValue());
		if (StringUtils.isNotEmpty(others)) {
			intake = intake + NEXT_LINE + NEXT_LINE + "Others: " + others;
		}
 		return intake;
	}
	
	private String deriveOutput(PatientCaseRecord patientCaseRecord) {
		String output = "";
		List<NursingCareOrder> outputOrders = nursingCareOrderService
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecord.getId(),
		            OrderTypeEnum.MONITORING_ORDER.getValue());
		if (outputOrders != null && !outputOrders.isEmpty()) {
			for (NursingCareOrder order : outputOrders) {
				if (order.getConcept().getUuid().equals(OutputConceptEnum.IO_MONITORING.getValue())) {
					output = output + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.STRICT_IO.getValue())) {
					output = output + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.REFER_FOR_OLIGURIA.getValue())) {
					output = output + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.FC.getValue())) {
					output = output + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.CTT.getValue())) {
					output = output + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.JP_DRAIN.getValue())) {
					output = output + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.COLOSTOMY.getValue())) {
					output = output + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.ILEOSTOMY.getValue())) {
					output = output + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.NEPHROSTOMY.getValue())) {
					output = output + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.TENCKHOFF_CATHETER.getValue())) {
					output = output + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.OTHER_OUTPUT_MONITORING.getValue())) {
					output = output  + order.getInstruction().substring(0, 1).toUpperCase() + order.getInstruction().substring(1) + NEXT_LINE;
				}
			}
		}
		return output;
	}
	
	private String deriveMonitoring(PatientCaseRecord patientCaseRecord) {
		String monitoring = "";
		String monitoring_issue = "";
		List<NursingCareOrder> monitoringOrders = nursingCareOrderService
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecord.getId(),
		            OrderTypeEnum.MONITORING_ORDER.getValue());
		if (monitoringOrders != null && !monitoringOrders.isEmpty()) {
			for (NursingCareOrder order : monitoringOrders) {
				if (order.getConcept().getUuid().equals(MonitoringConceptEnum.VITAL_SIGNS.getValue())) {
					monitoring = monitoring + order.getConcept().getName().getShortestName() + " "  + order.getInstruction()
					        + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.NEUROLOGICAL_VITAL_SIGNS.getValue())) {
					monitoring = monitoring + order.getConcept().getName().getShortestName() + " "  + order.getInstruction()
					        + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.CAPILLARY_BLOOD_GLUCOSE.getValue())) {
					monitoring = monitoring + order.getConcept().getName().getShortestName() + " "  + order.getInstruction()
					        + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.WEIGHT.getValue())) {
					monitoring = monitoring + order.getConcept().getName().getShortestName() + " "  + order.getInstruction()
					        + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.ABDOMINAL_GIRTH.getValue())) {
					monitoring = monitoring + order.getConcept().getName().getShortestName() + " "  + order.getInstruction()
					        + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.HEAD_CIRCUMFERENCE.getValue())) {
					monitoring = monitoring + order.getConcept().getName().getShortestName() + " "  + order.getInstruction()
					        + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.FEVER.getValue())) {
					monitoring_issue = monitoring_issue + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","")
					        + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.PAIN.getValue())) {
					monitoring_issue = monitoring_issue + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","")
					        + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.INCREASED_INTRACRANIAL_PRESSURE.getValue())) {
					monitoring_issue = monitoring_issue + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","")
					        + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.CONGESTION.getValue())) {
					monitoring_issue = monitoring_issue + order.getConcept().getName().getShortestName() + " "  + order.getInstruction().replaceFirst("/","")
					        + NEXT_LINE;
				} else if (order.getConcept().getUuid()
				        .equals(MonitoringConceptEnum.OTHER_MONITORING_INSTRUCTION.getValue())) {
					monitoring = monitoring + (monitoring_issue.trim().equals("")? "": NEXT_LINE + "WOF: " + monitoring_issue)
							+ order.getInstruction().substring(0, 1).toUpperCase() + order.getInstruction().substring(1) + NEXT_LINE;
				}
			}
		}
		return monitoring;
	}
	
	private String deriveNursingInterventions(PatientCaseRecord patientCaseRecord) {
		String nursingInterventions = "";
		String otherInterventions = "";
		List<NursingCareOrder> nursingInterventionOrders = nursingCareOrderService
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecord.getId(),
		            OrderTypeEnum.OTHER_INTERVETION_ORDER.getValue());
		if (nursingInterventionOrders != null && !nursingInterventionOrders.isEmpty()) {
			nursingInterventions = "";
			for (NursingCareOrder order : nursingInterventionOrders) {
				if (order.getConcept().getUuid().equals(NursingInterventionEnum.CHANGE_WOUND_DRESSING.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.STRICT_ASEPSIS.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.KEEP_THERMOREGULATED.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.TEPID_SPONGE_BATH.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.BED_BATH.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.HAIR_SHAMPOO.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.NAIL_CARE.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.PERINEAL_CARE.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.CBR_WITH_TOILET.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.CBR_WITHOUT_TOILET.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.BEDSORE_PRECAUTION.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.UNIVERSAL_PRECAUTION.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.SHEA_PRECAUTION.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.CAST_CARE.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.TRACHEOSTOMY_CARE.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.TRACTION_CARE.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.POSITIONING.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.MASSAGE_BONY_PROMINENCES.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.BURN.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.PRESSURE_ULCER_ACQUIRED_FROM_THIS_HEALTH_FACILITY.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.PRESSURE_ULCER_ACQUIRED_FROM_OTHER_LOCATION.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.RELAXATION_MEASURES.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.RESTRAINING.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.OTHER_INTERVENTION.getValue())) {
					otherInterventions = order.getInstruction().substring(0, 1).toUpperCase() + order.getInstruction().substring(1);
				}
			}
			nursingInterventions = nursingInterventions + NEXT_LINE;
		}
		
		List<NursingCareOrder> oxygenationOrders = nursingCareOrderService
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecord.getId(),
		            OrderTypeEnum.OXYGENATION_ORDER.getValue());
		if (oxygenationOrders != null && !oxygenationOrders.isEmpty()) {
			ConceptService conceptService = Context.getConceptService();
			for (NursingCareOrder order : oxygenationOrders) {
				if (order.getConcept().getUuid().equals(OxygenationEnum.OXYGEN_SUPPORT.getValue())) {
					Concept oxygenSupportConcept = conceptService.getConcept(order.getInstruction()); 
					if (oxygenSupportConcept != null) {
						nursingInterventions = nursingInterventions + " "
						        + oxygenSupportConcept.getName().getShortestName() + COMMA;
					}	
				} 
				if (order.getConcept().getUuid().equals(OxygenationEnum.DESCRIPTION_OF_OXYGEN_SUPPORT.getValue())) {
					Concept descriptionOfoxygenSupportConcept = conceptService.getConcept(order.getInstruction()); 
					if (descriptionOfoxygenSupportConcept != null) {
						nursingInterventions = nursingInterventions + " "
						        + descriptionOfoxygenSupportConcept.getName().getShortestName() + COMMA;
					}	
				} 
			}
			nursingInterventions = nursingInterventions + NEXT_LINE;
		}
		
		
		
		OxygenationOrderService oxygenationOrderService = Context.getService(OxygenationOrderService.class);
		List<OxygenationOrder> additionalOxygenations = oxygenationOrderService
		        .getOxygenationOrdersByPatientCaseRecordId(patientCaseRecord.getId());
		if (additionalOxygenations != null && !additionalOxygenations.isEmpty()) {
			OxygenationOrder oxygenationOrder = additionalOxygenations.get(0);
			if (oxygenationOrder.getFlowRateLiterPerMinute() != null){
				nursingInterventions = nursingInterventions + " @ " 
						+ oxygenationOrder.getFlowRateLiterPerMinute() + " lpm" + NEXT_LINE; 
			}
			if (oxygenationOrder.getHasMechanicalVentilator() != null && 
					oxygenationOrder.getHasMechanicalVentilator() == 1) {
				nursingInterventions = nursingInterventions + "MV: " 
						+ oxygenationOrder.getMechanicalVentilatorType() + "" + NEXT_LINE; 
			}
			if (oxygenationOrder.getMode() != null) {
				nursingInterventions = nursingInterventions + "" + oxygenationOrder.getMode() + " mode" + ", "; 
			}
			if (oxygenationOrder.getTidalVolume() != null) {
				nursingInterventions = nursingInterventions + "TV=" + oxygenationOrder.getTidalVolume() + "ml" + ", "; 
			}
			if (oxygenationOrder.getFio2Percent() != null) {
				nursingInterventions = nursingInterventions + "FiO2=" + oxygenationOrder.getFio2Percent() + "%" + ", "; 
			}
			if (oxygenationOrder.getPip() != null) {
				nursingInterventions = nursingInterventions + "PIP=" + oxygenationOrder.getPip() + ", "; 
			}
			if (oxygenationOrder.getPeep() != null) {
				nursingInterventions = nursingInterventions + "PEEP=" + oxygenationOrder.getPeep() + ", "; 
			}
			if (oxygenationOrder.getIeRatio() != null) {
				nursingInterventions = nursingInterventions + "I:E=" + oxygenationOrder.getIeRatio() + ", "; 
			}
			if (oxygenationOrder.getVentilatorRate() != null) {
				nursingInterventions = nursingInterventions + "VR= " + oxygenationOrder.getVentilatorRate() + NEXT_LINE; 
			}		
		}
		
		
		if (oxygenationOrders != null && !oxygenationOrders.isEmpty()) {
			ConceptService conceptService = Context.getConceptService();
			for (NursingCareOrder order : oxygenationOrders) {
				if (order.getConcept().getUuid().equals(OxygenationEnum.CHEST_PHYSIOTHERAPY.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(OxygenationEnum.SUCTIONING.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} else if (order.getConcept().getUuid().equals(OxygenationEnum.WEANING.getValue())) {
					nursingInterventions = nursingInterventions + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				} 
			}
			nursingInterventions = nursingInterventions + NEXT_LINE;
		}
		
		if (StringUtils.isNotEmpty(otherInterventions)) {
			nursingInterventions = nursingInterventions + otherInterventions + NEXT_LINE;
		}
		
		LevelOfCareService levelOfCareService = Context.getService(LevelOfCareService.class);
		List<LevelOfCare> levelOfCares = levelOfCareService.getLevelOfCaresByPatientCaseRecordId(patientCaseRecord.getId());
		if (levelOfCares != null && !levelOfCares.isEmpty()) {
			nursingInterventions = nursingInterventions + 
					(levelOfCares.get(0).getLevelOfCare()!=null ? "LEVEL OF CARE: " + levelOfCares.get(0).getLevelOfCare(): "");
		}
		return nursingInterventions;
	}
	
	private String deriveSpecialEndorsements(PatientCaseRecord patientCaseRecord) {
		String specialEndorsements = "";
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		ProcedureService procedureService = Context.getService(ProcedureService.class);
		
		List<Procedure> laboratories = procedureService.getLaboratoriesByPatientCaseRecordId(patientCaseRecord.getId());
		if (laboratories != null && !laboratories.isEmpty()) {
			specialEndorsements = specialEndorsements;
			for (Procedure lab : laboratories) {
				
				
				specialEndorsements = specialEndorsements + (lab.getDateSchedule()!=null? lab.getScheduleStatus():"") + " " + lab.getProcedureConcept().getName().getShortestName() + DASH
				        + (lab.getDateSchedule()!=null? df.format(lab.getDateSchedule()):"")
						+ ((lab.getRemarks()!=null)? " ("+ lab.getRemarks()+")" : "")
				        + ";" + NEXT_LINE;
			}
			specialEndorsements = ((specialEndorsements.trim()!="")?(specialEndorsements.substring(0, specialEndorsements.length()-2)  + NEXT_LINE + NEXT_LINE): ("") );
		}
		
		List<Procedure> procedures = procedureService.getProceduresByPatientCaseRecordId(patientCaseRecord.getId());
		if (procedures != null && !procedures.isEmpty()) {
			specialEndorsements = specialEndorsements;
			for (Procedure proc : procedures) {
				specialEndorsements = specialEndorsements + proc.getScheduleStatus() + " " + proc.getProcedureConcept().getName().getShortestName() + DASH
				        + df.format(proc.getDateSchedule())
						+ ((proc.getRemarks()!=null)? " ("+ proc.getRemarks()+")" : "")
				        + "," + NEXT_LINE;
			}
			specialEndorsements = ((specialEndorsements.trim()!="")?(specialEndorsements.substring(0, specialEndorsements.length()-2)  + NEXT_LINE + NEXT_LINE): ("") );
		}
		
		List<Procedure> others = procedureService.getOtherProceduresByPatientCaseRecordId(patientCaseRecord.getId());
		if (others != null && !others.isEmpty()) {
			specialEndorsements = specialEndorsements;
			for (Procedure other : others) {
				specialEndorsements = specialEndorsements + other.getScheduleStatus() + " " + other.getProcedureName() + DASH
				        + df.format(other.getDateSchedule())
						+ ((other.getRemarks()!=null)? " ("+ other.getRemarks()+")" : "")
				        + "," + NEXT_LINE;
			}
			specialEndorsements = ((specialEndorsements.trim()!="")?(specialEndorsements.substring(0, specialEndorsements.length()-2)  + NEXT_LINE + NEXT_LINE): ("") );
		}
		
		List<Operation> operations = operationService.getOperationsByPatientCaseRecordId(patientCaseRecord.getId());
		if (operations != null && !operations.isEmpty()) {
			specialEndorsements = specialEndorsements;
			for (Operation oper : operations) {
				specialEndorsements = specialEndorsements + oper.getScheduleStatus() + " " + oper.getOperationName() 
						+ (oper.getPriority() != null ? oper.getPriority() : "(Non-Emergency)") 
						+ DASH + df.format(oper.getDateSchedule())
						+ ((oper.getRemarks()!=null)? " ("+ oper.getRemarks()+")" : "") 
						+ ",";
			}
			specialEndorsements = ((specialEndorsements.trim()!="")?(specialEndorsements.substring(0, specialEndorsements.length()-2)  + NEXT_LINE + NEXT_LINE): ("") );
		}
		
		List<NursingCareOrder> testOrders = nursingCareOrderService
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecord.getId(),
		            OrderTypeEnum.TEST_ORDER.getValue());
		if (testOrders != null && !testOrders.isEmpty()) {
			for (NursingCareOrder order : testOrders) {
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.SENT_TO_LABOR_ROOM_OR_DELIVERY_ROOM.getValue())) {
					specialEndorsements = specialEndorsements + "Sent to LR or DR  " + NEXT_LINE;
				}
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.REFERRAL_TO_NEWBORN_SCREENER.getValue())) {
					specialEndorsements = specialEndorsements + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				}
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.REFERRAL_TO_ENTEROSTOMAL_NURSE.getValue())) {
					specialEndorsements = specialEndorsements + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				}
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.REFERRAL_TO_DIABETES_MELLITUS_EDUCATOR.getValue())) {
					specialEndorsements = specialEndorsements + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				}
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.REFERRAL_TO_SPIRITUAL_MINISTER.getValue())) {
					specialEndorsements = specialEndorsements + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				}
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.GRIEVING_MEASURES.getValue())) {
					specialEndorsements = specialEndorsements + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				}
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.REFERRAL_TO_PSYCHOLOGIST_OR_PSYCHIATRIST.getValue())) {
					specialEndorsements = specialEndorsements + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				}
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.CODE.getValue())) {
					specialEndorsements = specialEndorsements + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				}
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.POST_MORTEM_CARE.getValue())) {
					specialEndorsements = specialEndorsements + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				}
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.TERMINAL_CLEANING.getValue())) {
					specialEndorsements = specialEndorsements + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				}
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.FIVE_S.getValue())) {
					specialEndorsements = specialEndorsements + order.getConcept().getName().getShortestName() + " "
					        + order.getInstruction().replaceFirst("/","") + NEXT_LINE;
				}
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.OTHER_SPECIAL_ENDORSEMENT.getValue())) {
					specialEndorsements = specialEndorsements
					        + order.getInstruction().substring(0, 1).toUpperCase() + order.getInstruction().substring(1) + NEXT_LINE;;
				}
			}
		}	
		
		specialEndorsements = ((specialEndorsements.trim()!="")?(specialEndorsements.substring(0, specialEndorsements.length()-1)): ("") );
		return specialEndorsements;
		
	}
	
	private String deriveOrderFromConcept(List<NursingCareOrder> dietOrders, String uuid, String dietType) {
		for (NursingCareOrder diet : dietOrders) {
			if (uuid.equals(diet.getConcept().getUuid())) {
				return dietType + "<br/>";
			}
		}
		return "";
	}
	
	private String deriveOtherDiet(List<NursingCareOrder> dietOrders, String uuid) {
		for (NursingCareOrder diet : dietOrders) {
			if (uuid.equals(diet.getConcept().getUuid())) {
				return diet.getInstruction();
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
						specialDiet = specialDiet + diet.getConcept().getName().getShortestName() + "<br/>";
					}
				}
			}
		}
		
		return specialDiet;
	}
	
}
