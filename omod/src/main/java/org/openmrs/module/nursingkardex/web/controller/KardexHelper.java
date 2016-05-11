package org.openmrs.module.nursingkardex.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import org.apache.commons.lang.time.DateUtils;
import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Provider;
import org.openmrs.User;
import org.openmrs.Person;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.DietOrderRequirement;
import org.openmrs.module.nursingkardex.LevelOfCare;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.Physician;
import org.openmrs.module.nursingkardex.NursingCareOrder;
import org.openmrs.module.nursingkardex.OxygenationOrder;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.PatientMovement;
import org.openmrs.module.nursingkardex.ShiftProblem;
import org.openmrs.module.nursingkardex.api.BedService;
import org.openmrs.module.nursingkardex.api.DietOrderRequirementService;
import org.openmrs.module.nursingkardex.api.LevelOfCareService;
import org.openmrs.module.nursingkardex.api.NurseService;
import org.openmrs.module.nursingkardex.api.PhysicianService;
import org.openmrs.module.nursingkardex.api.NursingCareOrderService;
import org.openmrs.module.nursingkardex.api.OxygenationOrderService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.api.PatientMovementService;
import org.openmrs.module.nursingkardex.api.ShiftProblemService;
import org.openmrs.module.nursingkardex.util.EnumUtils.DietConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.MonitoringConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.NursingInterventionEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OrderTypeEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OutputConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OxygenationEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.ParenteralOrderEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.ProcedureConceptEnum;
import org.openmrs.module.nursingkardex.web.form.DietForm;
import org.openmrs.module.nursingkardex.web.form.MonitoringForm;
import org.openmrs.module.nursingkardex.web.form.NursingInterventionForm;
import org.openmrs.module.nursingkardex.web.form.NursingProblemForm;
import org.openmrs.module.nursingkardex.web.form.OutputForm;
import org.openmrs.module.nursingkardex.web.form.ParenteralOrderForm;
import org.openmrs.module.nursingkardex.web.form.ProcedureForm;

public class KardexHelper {
	
	public void setupDutyShiftEncounter(Integer patientCaseRecordId) {
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientMovementService patientMovementService = Context.getService(PatientMovementService.class);
		PatientCaseRecord patientCaseRecord = patientCaseRecordService.getPatientCaseRecordById(patientCaseRecordId);
		List<PatientMovement> movements = patientMovementService
		        .getPatientMovementsByPatientCaseRecordId(patientCaseRecordId);
		
		Encounter encounter = new Encounter();
		
		if (movements != null && movements.size() == 1) {
			PatientMovement patientMovement = movements.get(0); // admission
			Encounter admissionEncounter = Context.getEncounterService().getEncounter(
			    patientMovement.getEncounter().getEncounterId());
			if (admissionEncounter.getEncounterType().getName().equals("Admission")) {
				User currentUser = Context.getUserContext().getAuthenticatedUser();
				encounter.setPatient(patientCaseRecord.getPatient());
				encounter.setEncounterDatetime(new Date());
				encounter.setVisit(admissionEncounter.getVisit());
				encounter.setEncounterType(Context.getEncounterService().getEncounterType(
				    OrderTypeEnum.OTHER_INTERVETION_ORDER.getValue())); // duty shift
				encounter.setChangedBy(currentUser);
				encounter.setCreator(currentUser);
				encounter.setDateChanged(new Date());
				encounter.setDateCreated(new Date());
				
				encounter.setLocation(patientMovement.getBed().getLocation());
				
				Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(),
				    false);
				Provider currentProvider = null;
				if (providers.size() > 1) {
					throw new IllegalStateException("Can't handle users with multiple provider accounts");
				} else if (providers.size() == 1) {
					currentProvider = providers.iterator().next();
				}
				encounter.addProvider(Context.getEncounterService().getEncounterRole(2), currentProvider);
				encounter = Context.getEncounterService().saveEncounter(encounter);
				
				// set the patient movement's encounter to the new one (e.g. Duty Shift)
				PatientMovement dutyShift = new PatientMovement();
				dutyShift.setBed(patientMovement.getBed());
				dutyShift.setEncounter(encounter);
				dutyShift.setMovementDatetime(new Date());
				dutyShift.setPatientCaseRecord(patientCaseRecord);
				dutyShift = patientMovementService.savePatientMovement(dutyShift);
				
				patientCaseRecord.setLatestPatientMovement(dutyShift);
				patientCaseRecordService.savePatientCaseRecord(patientCaseRecord);
			}
		}
	}
	
	public NursingProblemForm setupNursingProblemForm(Integer patientCaseRecordId) {
		NursingProblemForm nursingProblemForm = new NursingProblemForm();
		nursingProblemForm.setPatientCaseRecordId(patientCaseRecordId);
		
//		ShiftProblemService shiftProblemService = Context.getService(ShiftProblemService.class);
		nursingProblemForm.setDate(DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH));
		
//		List<ShiftProblem> shiftProblems = shiftProblemService.getShiftProblemsByPatientCaseRecordId(patientCaseRecordId);
//		if (shiftProblems != null && !shiftProblems.isEmpty()) {
//			ShiftProblem shiftProblem = shiftProblems.get(0);
//			nursingProblemForm.setDate(shiftProblem.getDate());
//			nursingProblemForm.setShift(shiftProblem.getShift());
//		}
		return nursingProblemForm;
	}
	
	public ProcedureForm setupProcedureForm(Integer patientCaseRecordId) {
		ProcedureForm procedureForm = new ProcedureForm();
		procedureForm.setPatientCaseRecordId(patientCaseRecordId);
		
		List<NursingCareOrder> testOrders = Context.getService(NursingCareOrderService.class)
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecordId,
		            OrderTypeEnum.TEST_ORDER.getValue());
		
		if (testOrders != null && !testOrders.isEmpty()) {
			for (NursingCareOrder order : testOrders) {
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.OTHER_SPECIAL_ENDORSEMENT.getValue())) {
					procedureForm.setOtherEndorsementId(order.getId());
					procedureForm.setOtherEndorsementInstruction(order.getInstruction());
				}if (order.getConcept().getUuid().equals(ProcedureConceptEnum.REFERRAL_TO_NEWBORN_SCREENER.getValue())) {
					procedureForm.setReferralToNewbornScreenerId(order.getId());
					procedureForm.setReferralToNewbornScreenerInstruction(order.getInstruction());
				}if (order.getConcept().getUuid().equals(ProcedureConceptEnum.REFERRAL_TO_ENTEROSTOMAL_NURSE.getValue())) {
					procedureForm.setReferralToEnterostomalNurseId(order.getId());
					procedureForm.setReferralToEnterostomalNurseInstruction(order.getInstruction());
				}if (order.getConcept().getUuid().equals(ProcedureConceptEnum.REFERRAL_TO_DIABETES_MELLITUS_EDUCATOR.getValue())) {
					procedureForm.setReferralToDiabetesMellitusEducatorId(order.getId());
					procedureForm.setReferralToDiabetesMellitusEducatorInstruction(order.getInstruction());
				}if (order.getConcept().getUuid().equals(ProcedureConceptEnum.REFERRAL_TO_SPIRITUAL_MINISTER.getValue())) {
					procedureForm.setReferralToSpiritualMinisterId(order.getId());
					procedureForm.setReferralToSpiritualMinisterInstruction(order.getInstruction());
				}if (order.getConcept().getUuid().equals(ProcedureConceptEnum.GRIEVING_MEASURES.getValue())) {
					procedureForm.setGrievingMeasuresId(order.getId());
					procedureForm.setGrievingMeasuresInstruction(order.getInstruction());
				}if (order.getConcept().getUuid().equals(ProcedureConceptEnum.REFERRAL_TO_PSYCHOLOGIST_OR_PSYCHIATRIST.getValue())) {
					procedureForm.setReferralToPsychologistOrPsychiatristId(order.getId());
					procedureForm.setReferralToPsychologistOrPsychiatristInstruction(order.getInstruction());
				}if (order.getConcept().getUuid().equals(ProcedureConceptEnum.CODE.getValue())) {
					procedureForm.setCodeId(order.getId());
					procedureForm.setCodeInstruction(order.getInstruction());
				}if (order.getConcept().getUuid().equals(ProcedureConceptEnum.POST_MORTEM_CARE.getValue())) {
					procedureForm.setPostMortemCareId(order.getId());
					procedureForm.setPostMortemCareInstruction(order.getInstruction());
				}if (order.getConcept().getUuid().equals(ProcedureConceptEnum.TERMINAL_CLEANING.getValue())) {
					procedureForm.setTerminalCleaningId(order.getId());
					procedureForm.setTerminalCleaningInstruction(order.getInstruction());
				}if (order.getConcept().getUuid().equals(ProcedureConceptEnum.FIVE_S.getValue())) {
					procedureForm.setFiveSId(order.getId());
					procedureForm.setFiveSInstruction(order.getInstruction());
				}
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.SENT_TO_LABOR_ROOM_OR_DELIVERY_ROOM.getValue())) {
					procedureForm.setDelivery(true);
				}
			}
		}
		
		return procedureForm;
	}
	
	public DietForm setupDietForm(Integer patientCaseRecordId) {
		List<Concept> dietTypes = new ArrayList<Concept>();
		List<Concept> dietRoutes = new ArrayList<Concept>();
		List<Concept> dietInstructions = new ArrayList<Concept>();
		DietForm dietForm = new DietForm();
		dietForm.setPatientCaseRecordId(patientCaseRecordId);
		List<NursingCareOrder> dietOrders = Context.getService(NursingCareOrderService.class)
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecordId,
		            OrderTypeEnum.DIET_ORDER.getValue());
		if (dietOrders != null && !dietOrders.isEmpty()) {
			for (NursingCareOrder order : dietOrders) {
				List<Concept> questionConcepts = Context.getConceptService().getConceptsByAnswer(order.getConcept());
				if (questionConcepts != null && !questionConcepts.isEmpty()) {
					Concept dietTypeConcept = Context.getConceptService().getConceptByUuid(
					    DietConceptEnum.DIET_TYPE.getValue());
					Concept dietRouteConcept = Context.getConceptService().getConceptByUuid(
						    DietConceptEnum.DIET_ROUTE.getValue());
					Concept dietaryInstructionConcept = Context.getConceptService().getConceptByUuid(
					    DietConceptEnum.DIETARY_INSTRUCTION.getValue());
					if (questionConcepts.get(0).getConceptId().equals(dietTypeConcept.getConceptId())) {
						dietTypes.add(order.getConcept());
					}
					if (questionConcepts.get(0).getConceptId().equals(dietRouteConcept.getConceptId())) {
						dietRoutes.add(order.getConcept());
					}
					if (questionConcepts.get(0).getConceptId().equals(dietaryInstructionConcept.getConceptId())) {
						dietInstructions.add(order.getConcept());
					}
				}
				// others
				if (order.getConcept().getUuid().equals(DietConceptEnum.OTHERS.getValue())) {
					dietForm.setOthersId(order.getId());
					dietForm.setOthersInstruction(order.getInstruction());
				}
			}
			dietForm.setDietTypes(dietTypes);
			dietForm.setDietRoutes(dietRoutes);
			dietForm.setDietInstructions(dietInstructions);
		}
		DietOrderRequirementService dietOrderRequirementService = Context.getService(DietOrderRequirementService.class);
		List<DietOrderRequirement> additionalDietDetails = dietOrderRequirementService
		        .getActiveDietOrderRequirementsByPatientCaseRecordId(patientCaseRecordId);
		if (additionalDietDetails != null && !additionalDietDetails.isEmpty()) {
			dietForm.setDietOrderRequirement(additionalDietDetails.get(0));
		} else {
			dietForm.setDietOrderRequirement(new DietOrderRequirement());
		}
		return dietForm;
	}
	
	public OutputForm setupOutputForm(Integer patientCaseRecordId) {
		OutputForm outputForm = new OutputForm();
		outputForm.setPatientCaseRecordId(patientCaseRecordId);
		NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
		List<NursingCareOrder> outputOrders = nursingCareOrderService
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecordId,
		            OrderTypeEnum.MONITORING_ORDER.getValue());
		if (outputOrders != null && !outputOrders.isEmpty()) {
			for (NursingCareOrder order : outputOrders) {
				if (order.getConcept().getUuid().equals(OutputConceptEnum.COLOSTOMY.getValue())) {
					outputForm.setColostomyId(order.getId());
					outputForm.setColostomyInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.CTT.getValue())) {
					outputForm.setCttId(order.getId());
					outputForm.setCttInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.FC.getValue())) {
					outputForm.setFcId(order.getId());
					outputForm.setFcInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.ILEOSTOMY.getValue())) {
					outputForm.setIleostomyId(order.getId());
					outputForm.setIleostomyInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.IO_MONITORING.getValue())) {
					outputForm.setIoMonitoringId(order.getId());
					outputForm.setIoMonitoringInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.JP_DRAIN.getValue())) {
					outputForm.setJpDrainId(order.getId());
					outputForm.setJpDrainInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.NEPHROSTOMY.getValue())) {
					outputForm.setNephrostomyId(order.getId());
					outputForm.setNephrostomyInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.OTHER_OUTPUT_MONITORING.getValue())) {
					outputForm.setOthersId(order.getId());
					outputForm.setOthersInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.REFER_FOR_OLIGURIA.getValue())) {
					outputForm.setReferForOliguriaId(order.getId());
					outputForm.setReferForOliguriaInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.STRICT_IO.getValue())) {
					outputForm.setStrictIOId(order.getId());
					outputForm.setStrictIOInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OutputConceptEnum.TENCKHOFF_CATHETER.getValue())) {
					outputForm.setTenckhoffCatheterId(order.getId());
					outputForm.setTenckhoffCatheterInstruction(order.getInstruction());
				}
			}
		}
		
		return outputForm;
	}
	
	public NursingInterventionForm setupNursingInterventionForm(Integer patientCaseRecordId) {
		NursingInterventionForm nursingInterventionForm = new NursingInterventionForm();
		nursingInterventionForm.setPatientCaseRecordId(patientCaseRecordId);
		NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
		
		// Nursing Intervention Orders
		List<NursingCareOrder> nursingInterventions = nursingCareOrderService
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecordId,
		            OrderTypeEnum.OTHER_INTERVETION_ORDER.getValue());
		if (nursingInterventions != null && !nursingInterventions.isEmpty()) {
			for (NursingCareOrder order : nursingInterventions) {
				if (order.getConcept().getUuid().equals(NursingInterventionEnum.BED_BATH.getValue())) {
					nursingInterventionForm.setBedBathId(order.getId());
					nursingInterventionForm.setBedBathInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.BEDSORE_PRECAUTION.getValue())) {
					nursingInterventionForm.setBedsorePrecautionId(order.getId());
					nursingInterventionForm.setBedsorePrecautionInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.CAST_CARE.getValue())) {
					nursingInterventionForm.setCastCareId(order.getId());
					nursingInterventionForm.setCastCareInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.CBR_WITH_TOILET.getValue())) {
					nursingInterventionForm.setCbrWithToiletId(order.getId());
					nursingInterventionForm.setCbrWithToiletInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.CBR_WITHOUT_TOILET.getValue())) {
					nursingInterventionForm.setCbrWithoutToiletId(order.getId());
					nursingInterventionForm.setCbrWithoutToiletInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.CHANGE_WOUND_DRESSING.getValue())) {
					nursingInterventionForm.setChangeWoundDressingId(order.getId());
					nursingInterventionForm.setChangeWoundDressingInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.KEEP_THERMOREGULATED.getValue())) {
					nursingInterventionForm.setKeepThemoregulatedId(order.getId());
					nursingInterventionForm.setKeepThemoregulatedInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.PERINEAL_CARE.getValue())) {
					nursingInterventionForm.setPerinealCareId(order.getId());
					nursingInterventionForm.setPerinealCareInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.POSITIONING.getValue())) {
					nursingInterventionForm.setPositioningId(order.getId());
					nursingInterventionForm.setPositioningInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.SHEA_PRECAUTION.getValue())) {
					nursingInterventionForm.setSheaPrecautionId(order.getId());
					nursingInterventionForm.setSheaPrecautionInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.STRICT_ASEPSIS.getValue())) {
					nursingInterventionForm.setStrictAsepsisId(order.getId());
					nursingInterventionForm.setStrictAsepsisInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.TEPID_SPONGE_BATH.getValue())) {
					nursingInterventionForm.setTepidSpongeBathId(order.getId());
					nursingInterventionForm.setTepidSpongeBathInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.TRACHEOSTOMY_CARE.getValue())) {
					nursingInterventionForm.setTracheostomyCareId(order.getId());
					nursingInterventionForm.setTracheostomyCareInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.TRACTION_CARE.getValue())) {
					nursingInterventionForm.setTractionCareId(order.getId());
					nursingInterventionForm.setTractionCareInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.UNIVERSAL_PRECAUTION.getValue())) {
					nursingInterventionForm.setUniversalPrecautionId(order.getId());
					nursingInterventionForm.setUniversalPrecautionInstruction(order.getInstruction());
				}else if (order.getConcept().getUuid().equals(NursingInterventionEnum.HAIR_SHAMPOO.getValue())) {
					nursingInterventionForm.setHairShampooId(order.getId());
					nursingInterventionForm.setHairShampooInstruction(order.getInstruction());
				}else if (order.getConcept().getUuid().equals(NursingInterventionEnum.NAIL_CARE.getValue())) {
					nursingInterventionForm.setNailCareId(order.getId());
					nursingInterventionForm.setNailCareInstruction(order.getInstruction());
				}else if (order.getConcept().getUuid().equals(NursingInterventionEnum.MASSAGE_BONY_PROMINENCES.getValue())) {
					nursingInterventionForm.setMassageBodyProminencesId(order.getId());
					nursingInterventionForm.setMassageBodyProminencesInstruction(order.getInstruction());
				}else if (order.getConcept().getUuid().equals(NursingInterventionEnum.BURN.getValue())) {
					nursingInterventionForm.setBurnId(order.getId());
					nursingInterventionForm.setBurnInstruction(order.getInstruction());
				}else if (order.getConcept().getUuid().equals(NursingInterventionEnum.PRESSURE_ULCER_ACQUIRED_FROM_THIS_HEALTH_FACILITY.getValue())) {
					nursingInterventionForm.setPressureUlcerAcquiredFromThisHealthFacilityId(order.getId());
					nursingInterventionForm.setPressureUlcerAcquiredFromThisHealthFacilityInstruction(order.getInstruction());
				}else if (order.getConcept().getUuid().equals(NursingInterventionEnum.PRESSURE_ULCER_ACQUIRED_FROM_OTHER_LOCATION.getValue())) {
					nursingInterventionForm.setPressureUlcerAcquiredFromOtherLocationId(order.getId());
					nursingInterventionForm.setPressureUlcerAcquiredFromOtherLocationInstruction(order.getInstruction());
				}else if (order.getConcept().getUuid().equals(NursingInterventionEnum.HEALTH_TEACHING.getValue())) {
					nursingInterventionForm.setHealthTeachingId(order.getId());
					nursingInterventionForm.setHealthTeachingInstruction(order.getInstruction());
				}else if (order.getConcept().getUuid().equals(NursingInterventionEnum.RESTRAINING.getValue())) {
					nursingInterventionForm.setRestrainingId(order.getId());
					nursingInterventionForm.setRestrainingInstruction(order.getInstruction());
				}else if (order.getConcept().getUuid().equals(NursingInterventionEnum.RELAXATION_MEASURES.getValue())) {
					nursingInterventionForm.setRelaxationMeasuresId(order.getId());
					nursingInterventionForm.setRelaxationMeasuresInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(NursingInterventionEnum.OTHER_INTERVENTION.getValue())) {
					nursingInterventionForm.setOtherInterventionId(order.getId());
					nursingInterventionForm.setOtherInterventionInstruction(order.getInstruction());
				}
			}
		}
		
		// Oxygenation Orders
		List<NursingCareOrder> oxygenationOrders = nursingCareOrderService
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecordId,
		            OrderTypeEnum.OXYGENATION_ORDER.getValue());
		if (oxygenationOrders != null && !oxygenationOrders.isEmpty()) {
			for (NursingCareOrder order : oxygenationOrders) {
				if (order.getConcept().getUuid().equals(OxygenationEnum.CHEST_PHYSIOTHERAPY.getValue())) {
					nursingInterventionForm.setChestPhysiotherapyId(order.getId());
					nursingInterventionForm.setChestPhysiotherapyInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OxygenationEnum.SUCTIONING.getValue())) {
					nursingInterventionForm.setSuctioningId(order.getId());
					nursingInterventionForm.setSuctioningInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OxygenationEnum.WEANING.getValue())) {
					nursingInterventionForm.setWeaningId(order.getId());
					nursingInterventionForm.setWeaningInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OxygenationEnum.OXYGEN_SUPPORT.getValue())) {
					nursingInterventionForm.setOxygenationSupportId(order.getId());
					nursingInterventionForm.setOxygenationSupportInstruction(order.getInstruction());
				} else if (order.getConcept().getUuid().equals(OxygenationEnum.DESCRIPTION_OF_OXYGEN_SUPPORT.getValue())) {
					nursingInterventionForm.setDescriptionOfOxygenSupportId(order.getId());
					nursingInterventionForm.setDescriptionOfOxygenSupportInstruction(order.getInstruction());
				}
			}
		}
		
		// Oxygenation additional details
		OxygenationOrderService oxygenationOrderService = Context.getService(OxygenationOrderService.class);
		List<OxygenationOrder> additionalOxygenations = oxygenationOrderService
		        .getOxygenationOrdersByPatientCaseRecordId(patientCaseRecordId);
		if (additionalOxygenations != null && !additionalOxygenations.isEmpty()) {
			nursingInterventionForm.setOxygenationOrder(additionalOxygenations.get(0));
		} else {
			nursingInterventionForm.setOxygenationOrder(new OxygenationOrder());
		}
		
		// Level of Care
		LevelOfCareService levelOfCareService = Context.getService(LevelOfCareService.class);
		List<LevelOfCare> levelOfCares = levelOfCareService.getLevelOfCaresByPatientCaseRecordId(patientCaseRecordId);
		if (levelOfCares != null && !levelOfCares.isEmpty()) {
			nursingInterventionForm.setLevelOfCare(levelOfCares.get(0));
		} else {
			nursingInterventionForm.setLevelOfCare(new LevelOfCare());
		}
		
		return nursingInterventionForm;
	}
	
	public MonitoringForm setupMonitoringForm(Integer patientCaseRecordId) {
		MonitoringForm monitoringForm = new MonitoringForm();
		monitoringForm.setPatientCaseRecordId(patientCaseRecordId);
		NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
		List<NursingCareOrder> monitoringOrders = nursingCareOrderService
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecordId,
		            OrderTypeEnum.MONITORING_ORDER.getValue());
		if (monitoringOrders != null && !monitoringOrders.isEmpty()) {
			for (NursingCareOrder order : monitoringOrders) {
				if (order.getConcept().getUuid().equals(MonitoringConceptEnum.ABDOMINAL_GIRTH.getValue())) {
					monitoringForm.setAgInstruction(order.getInstruction());
					monitoringForm.setAgId(order.getId());
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.CAPILLARY_BLOOD_GLUCOSE.getValue())) {
					monitoringForm.setCbgInstruction(order.getInstruction());
					monitoringForm.setCbgId(order.getId());
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.WEIGHT.getValue())) {
					monitoringForm.setWeightInstruction(order.getInstruction());
					monitoringForm.setWeightId(order.getId());
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.HEAD_CIRCUMFERENCE.getValue())) {
					monitoringForm.setHcInstruction(order.getInstruction());
					monitoringForm.setHcId(order.getId());
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.NEUROLOGICAL_VITAL_SIGNS.getValue())) {
					monitoringForm.setNvsInstruction(order.getInstruction());
					monitoringForm.setNvsId(order.getId());
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.VITAL_SIGNS.getValue())) {
					monitoringForm.setVsInstruction(order.getInstruction());
					monitoringForm.setVsId(order.getId());
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.FEVER.getValue())) {
					monitoringForm.setFeverInstruction(order.getInstruction());
					monitoringForm.setFeverId(order.getId());
				} else if (order.getConcept().getUuid()
				        .equals(MonitoringConceptEnum.PAIN.getValue())) {
					monitoringForm.setPainInstruction(order.getInstruction());
					monitoringForm.setPainId(order.getId());
				} else if (order.getConcept().getUuid()
				        .equals(MonitoringConceptEnum.INCREASED_INTRACRANIAL_PRESSURE.getValue())) {
					monitoringForm.setIncIcpInstruction(order.getInstruction());
					monitoringForm.setIncIcpId(order.getId());
				} else if (order.getConcept().getUuid().equals(MonitoringConceptEnum.CONGESTION.getValue())) {
					monitoringForm.setCongestionInstruction(order.getInstruction());
					monitoringForm.setCongestionId(order.getId());
				} else if (order.getConcept().getUuid()
				        .equals(MonitoringConceptEnum.OTHER_MONITORING_INSTRUCTION.getValue())) {
					monitoringForm.setOthersInstruction(order.getInstruction());
					monitoringForm.setOthersId(order.getId());
				} 
			}
		}
		return monitoringForm;
	}
	
	public ParenteralOrderForm setupParenteralOrderForm(Integer patientCaseRecordId) {
		ParenteralOrderForm parenteralOrderForm = new ParenteralOrderForm();
		parenteralOrderForm.setPatientCaseRecordId(patientCaseRecordId);
		
		NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
		List<NursingCareOrder> parenteralOrders = nursingCareOrderService
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecordId,
		            OrderTypeEnum.PARENTERAL_ORDER.getValue());
		if (parenteralOrders != null && !parenteralOrders.isEmpty()) {
			for (NursingCareOrder order : parenteralOrders) {
				if (order.getConcept().getUuid().equals(ParenteralOrderEnum.ARTERIOVENOUS_FISTULA.getValue())) {
					parenteralOrderForm.setArteriovenousFistulaInstruction(order.getInstruction());
					parenteralOrderForm.setArteriovenousFistulaId(order.getId());
				} else if (order.getConcept().getUuid().equals(ParenteralOrderEnum.FEMORAL_CATHETER.getValue())) {
					parenteralOrderForm.setFemoralCatheterInstruction(order.getInstruction());
					parenteralOrderForm.setFemoralCatheterId(order.getId());
				} else if (order.getConcept().getUuid().equals(ParenteralOrderEnum.HEPLOCK.getValue())) {
					parenteralOrderForm.setHeplockInstruction(order.getInstruction());
					parenteralOrderForm.setHeplockId(order.getId());
				} else if (order.getConcept().getUuid().equals(ParenteralOrderEnum.INTRAJUGULAR_CATHETER.getValue())) {
					parenteralOrderForm.setIntrajugularCatheterInstruction(order.getInstruction());
					parenteralOrderForm.setIntrajugularCatheterId(order.getId());
				} else if (order.getConcept().getUuid().equals(ParenteralOrderEnum.SUBCLAVIAN_CATHETER.getValue())) {
					parenteralOrderForm.setSubclavianCatheterInstruction(order.getInstruction());
					parenteralOrderForm.setSubclavianCatheterId(order.getId());
				} else if (order.getConcept().getUuid().equals(ParenteralOrderEnum.CHEMOTHERAPY.getValue())) {
					parenteralOrderForm.setChemotherapyInstruction(order.getInstruction());
					parenteralOrderForm.setChemotherapyId(order.getId());
				} else if (order.getConcept().getUuid().equals(ParenteralOrderEnum.OTHER_PARENTERAL_INSTRUCTION.getValue())) {
					parenteralOrderForm.setOtherParenteralInstruction(order.getInstruction());
					parenteralOrderForm.setOtherParenteralId(order.getId());
				}
			}
		}
		
		return parenteralOrderForm;
	}
	
	public List<Bed> getBeds() {
		Nurse nurse = deriveNurse();
		Physician physician = derivePhysician();

		BedService bedService = Context.getService(BedService.class);
		List<Bed> beds = null;
		if (nurse != null) {
			beds = bedService.getBedsByLocationId(nurse.getLocation().getLocationId());
		} else if (physician != null) {
			beds = bedService.getAllBeds();
		} else {
			beds = bedService.getAllBeds();
		}
		return beds;
	}
	
	public List<Bed> getAvailableBeds() {
		Nurse nurse = deriveNurse();
		
		BedService bedService = Context.getService(BedService.class);
		List<Bed> beds = null;
		if (nurse != null) {
			beds = bedService.getAvailableBedsByLocationId(nurse.getLocation().getLocationId());
		} else {
			beds = bedService.getAvailableBeds();
		}
		return beds;
	}
	
	public Nurse deriveNurse() {
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
		return nurse;
	}

	public Physician derivePhysician() {
	
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		
		Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(), false);
		Provider currentProvider = null;
		if (providers.size() > 1) {
			throw new IllegalStateException("Can't handle users with multiple provider accounts");
		} else if (providers.size() == 1) {
			currentProvider = providers.iterator().next();
		}
		
		PhysicianService physicianService = Context.getService(PhysicianService.class);
		Physician physician = null;
		if (currentProvider != null) {
			physician = physicianService.getPhysicianByProviderId(currentProvider.getProviderId());
		}
		return physician;	
	}

	public Provider derivePhysicianProvider() {
	
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		
		Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(), false);
		Provider currentProvider = null;
		if (providers.size() > 1) {
			throw new IllegalStateException("Can't handle users with multiple provider accounts");
		} else if (providers.size() == 1) {
			currentProvider = providers.iterator().next();
		}
		
		return currentProvider;
	}

	public Person derivePhysicianPerson() {
	
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Person currentPerson = currentUser.getPerson();
		
		return currentPerson;
	}
	
	public List<PatientCaseRecord> derivePatientCaseRecordsByPhysicianInChargeId(Integer physicianId) {
		
		List<PatientCaseRecord> patientCaseRecords = null;
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		patientCaseRecords = patientCaseRecordService.getPatientCaseRecordsByPhysicianInChargeId(physicianId);
		
		return patientCaseRecords;
		
	}
	
}
