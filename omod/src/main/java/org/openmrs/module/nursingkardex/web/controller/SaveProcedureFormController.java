package org.openmrs.module.nursingkardex.web.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.OrderType;
import org.openmrs.Provider;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.NursingCareOrder;
import org.openmrs.module.nursingkardex.Operation;
import org.openmrs.module.nursingkardex.ParenteralOrderInfusion;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.Procedure;
import org.openmrs.module.nursingkardex.api.NursingCareOrderService;
import org.openmrs.module.nursingkardex.api.OperationService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.api.ProcedureService;
import org.openmrs.module.nursingkardex.util.EnumUtils.OrderTypeEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.ProcedureConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.ProcedureTypeEnum;
import org.openmrs.module.nursingkardex.web.form.ProcedureForm;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaveProcedureFormController {
	
	@RequestMapping(value = "/module/nursingkardex/saveProcedure", method = RequestMethod.POST)
	public String saveProcedure(@ModelAttribute("procedureForm") ProcedureForm procedureForm, HttpServletRequest request) {
		
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientCaseRecord patientCaseRecord = patientCaseRecordService.getPatientCaseRecordById(procedureForm
		        .getPatientCaseRecordId());
		Encounter currentEncounter = patientCaseRecord.getLatestPatientMovement().getEncounter();
		NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
		ProcedureService procedureService = Context.getService(ProcedureService.class);
		
		// delete Laboratories that have been removed in UI
		List<Procedure> existingLaboratories = procedureService.getLaboratoriesByPatientCaseRecordId(procedureForm
		        .getPatientCaseRecordId());
		if (existingLaboratories != null && !existingLaboratories.isEmpty() && procedureForm.getExistingLabs() != null) {
			for (Procedure laboratory : existingLaboratories) {
				if (!procedureForm.getExistingLabs().contains(laboratory.getId())) {
					if (laboratory.getOrder() != null) {
						nursingCareOrderService.deleteNursingCareOrder(laboratory.getOrder());
					}
					procedureService.deleteProcedure(laboratory);
				}
			}
		}
		// if all entries will be deleted
		if ((procedureForm.getExistingLabs() == null || procedureForm.getExistingLabs().isEmpty()) 
				&& (existingLaboratories != null || existingLaboratories.isEmpty())) {
			for (Procedure laboratory : existingLaboratories) {
				if (laboratory.getOrder() != null) {
					nursingCareOrderService.deleteNursingCareOrder(laboratory.getOrder());
				}
				procedureService.deleteProcedure(laboratory);
			}
		}
		
		// delete existing Procedures that have been removed in UI
		List<Procedure> existingProcedures = procedureService.getProceduresByPatientCaseRecordId(procedureForm
		        .getPatientCaseRecordId());
		if (existingProcedures != null && !existingProcedures.isEmpty() && procedureForm.getExistingProcedures() != null) {
			for (Procedure procedure : existingProcedures) {
				if (!procedureForm.getExistingProcedures().contains(procedure.getId())) {
					if (procedure.getOrder() != null) {
						nursingCareOrderService.deleteNursingCareOrder(procedure.getOrder());
					}
					procedureService.deleteProcedure(procedure);
				}
			}
		}

		// if all entries will be deleted
		if ((procedureForm.getExistingProcedures() == null || procedureForm.getExistingProcedures().isEmpty()) 
				&& (existingProcedures != null || existingProcedures.isEmpty())) {
			for (Procedure procedure : existingProcedures) {
				if (procedure.getOrder() != null) {
					nursingCareOrderService.deleteNursingCareOrder(procedure.getOrder());
				}
				procedureService.deleteProcedure(procedure);
			}
		}
		
		// delete existing Other Procedures that have been removed in UI
		List<Procedure> existingOthersProcedures = procedureService.getOtherProceduresByPatientCaseRecordId(procedureForm
		        .getPatientCaseRecordId());
		if (existingOthersProcedures != null && !existingOthersProcedures.isEmpty()
		        && procedureForm.getExistingOthers() != null) {
			for (Procedure procedure : existingOthersProcedures) {
				if (!procedureForm.getExistingOthers().contains(procedure.getId())) {
					if (procedure.getOrder() != null) {
						nursingCareOrderService.deleteNursingCareOrder(procedure.getOrder());
					}
					procedureService.deleteProcedure(procedure);
				}
			}
		}


		// if all entries will be deleted
		if ((procedureForm.getExistingOthers() == null || procedureForm.getExistingOthers().isEmpty()) 
				&& (existingOthersProcedures != null || existingOthersProcedures.isEmpty())) {
			for (Procedure procedure : existingOthersProcedures) {
				if (procedure.getOrder() != null) {
					nursingCareOrderService.deleteNursingCareOrder(procedure.getOrder());
				}
				procedureService.deleteProcedure(procedure);
			}
		}
		
		// delete existing Operations that have been removed in UI
		OperationService operationService = Context.getService(OperationService.class);
		List<Operation> existingOperations = operationService.getOperationsByPatientCaseRecordId(procedureForm
		        .getPatientCaseRecordId());
		if (existingOperations != null && !existingOperations.isEmpty() && procedureForm.getExistingOperations() != null) {
			for (Operation operation : existingOperations) {
				if (!procedureForm.getExistingOperations().contains(operation.getId())) {
					if (operation.getOrder() != null) {
						nursingCareOrderService.deleteNursingCareOrder(operation.getOrder());
					}
					operationService.deleteOperation(operation);
				}
			}
		}

		// if all entries will be deleted
		if ((procedureForm.getExistingOperations() == null || procedureForm.getExistingOperations().isEmpty()) 
				&& (existingOperations != null || existingOperations.isEmpty())) {
			for (Operation operation : existingOperations) {
				if (operation.getOrder() != null) {
					nursingCareOrderService.deleteNursingCareOrder(operation.getOrder());
				}
				operationService.deleteOperation(operation);
			}
		}
		
		OrderType testOrderType = Context.getOrderService().getOrderType(OrderTypeEnum.TEST_ORDER.getValue());
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(), false);
		Provider currentProvider = null;
		if (providers.size() > 1) {
			throw new IllegalStateException("Can't handle users with multiple provider accounts");
		} else if (providers.size() == 1) {
			currentProvider = providers.iterator().next();
		}
		
		// save new laboratories
		if (procedureForm.getLaboratories() != null) {
			for (Procedure laboratory : procedureForm.getLaboratories()) {
				NursingCareOrder order = new NursingCareOrder();
				order.setOrderType(testOrderType);
				order.setConcept(laboratory.getProcedureConcept());
				order.setCreator(currentUser);
				order.setDateCreated(new Date());
				order.setPatientCaseRecord(patientCaseRecord);
				order.setEncounter(currentEncounter);
				order.setPatient(patientCaseRecord.getPatient());
				order.setOrderer(currentProvider);
				order.setInstruction(null);
				order = nursingCareOrderService.saveNursingCareOrder(order);
				
				laboratory.setPatientCaseRecord(patientCaseRecord);
				laboratory.setEncounter(currentEncounter);
				laboratory.setOrder(order);
				laboratory.setType(ProcedureTypeEnum.LABORATORY.getValue());
				procedureService.saveProcedure(laboratory);
			}
		}
		
		// save new procedures
		if (procedureForm.getProcedures() != null) {
			for (Procedure procedure : procedureForm.getProcedures()) {
				NursingCareOrder order = new NursingCareOrder();
				order.setOrderType(testOrderType);
				order.setConcept(procedure.getProcedureConcept());
				order.setCreator(currentUser);
				order.setDateCreated(new Date());
				order.setEncounter(currentEncounter);
				order.setPatient(patientCaseRecord.getPatient());
				order.setOrderer(currentProvider);
				order.setInstruction(null);
				order = nursingCareOrderService.saveNursingCareOrder(order);
				
				procedure.setPatientCaseRecord(patientCaseRecord);
				procedure.setEncounter(currentEncounter);
				procedure.setOrder(order);
				procedure.setType(ProcedureTypeEnum.PROCEDURE.getValue());
				procedureService.saveProcedure(procedure);
			}
		}
		
		// save new other procedures
		if (procedureForm.getOthers() != null) {
			Concept otherProcedureContext = Context.getConceptService().getConceptByUuid(
			    ProcedureConceptEnum.OTHER_PROCEDURE.getValue());
			for (Procedure otherProcedure : procedureForm.getOthers()) {
				NursingCareOrder order = new NursingCareOrder();
				order.setOrderType(testOrderType);
				order.setConcept(otherProcedureContext);
				order.setCreator(currentUser);
				order.setDateCreated(new Date());
				order.setPatientCaseRecord(patientCaseRecord);
				order.setEncounter(currentEncounter);
				order.setPatient(patientCaseRecord.getPatient());
				order.setOrderer(currentProvider);
				order.setInstruction(null);
				order = nursingCareOrderService.saveNursingCareOrder(order);
				
				otherProcedure.setPatientCaseRecord(patientCaseRecord);
				otherProcedure.setEncounter(currentEncounter);
				otherProcedure.setOrder(order);
				otherProcedure.setType(ProcedureTypeEnum.OTHERS.getValue());
				procedureService.saveProcedure(otherProcedure);
			}
		}
		
		// save new operations
		if (procedureForm.getOperations() != null) {
			Concept operationConcept = Context.getConceptService().getConceptByUuid(
			    ProcedureConceptEnum.OPERATION.getValue());
			for (Operation operation : procedureForm.getOperations()) {
				NursingCareOrder order = new NursingCareOrder();
				order.setOrderType(testOrderType);
				order.setConcept(operationConcept);
				order.setCreator(currentUser);
				order.setDateCreated(new Date());
				order.setPatientCaseRecord(patientCaseRecord);
				order.setEncounter(currentEncounter);
				order.setPatient(patientCaseRecord.getPatient());
				order.setOrderer(currentProvider);
				order.setInstruction(null);
				order = nursingCareOrderService.saveNursingCareOrder(order);
				
				operation.setPatientCaseRecord(patientCaseRecord);
				operation.setEncounter(currentEncounter);
				operation.setOrder(order);
				operation.setPerformingPhysician(patientCaseRecord.getPhysicianInCharge());
				operation.setSchedulerUser(currentUser);
				operationService.saveOperation(operation);
			}
		}
		
		// save delivery/labor room
		Concept sentToLaborConcept = Context.getConceptService().getConceptByUuid(
		    ProcedureConceptEnum.SENT_TO_LABOR_ROOM_OR_DELIVERY_ROOM.getValue());
		List<NursingCareOrder> deliveryOrders = nursingCareOrderService.getNursingCareOrderByEncounterAndConcept(
		    currentEncounter.getEncounterId(), sentToLaborConcept.getConceptId());
		if (procedureForm.isDelivery()) {
			if (deliveryOrders == null || deliveryOrders.isEmpty()) {
				NursingCareOrder order = new NursingCareOrder();
				order.setOrderType(testOrderType);
				order.setConcept(sentToLaborConcept);
				order.setCreator(currentUser);
				order.setDateCreated(new Date());
				order.setPatientCaseRecord(patientCaseRecord);
				order.setEncounter(currentEncounter);
				order.setPatient(patientCaseRecord.getPatient());
				order.setOrderer(currentProvider);
				order.setInstruction(null);
				order = nursingCareOrderService.saveNursingCareOrder(order);
			}
		} else {
			if (deliveryOrders != null && !deliveryOrders.isEmpty()) {
				nursingCareOrderService.deleteNursingCareOrder(deliveryOrders.get(0));
			}
		}
		
		// save other special endorsement
		if (StringUtils.isNotEmpty(procedureForm.getOtherEndorsementInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupTestOrder(procedureForm.getOtherEndorsementId(),
			    procedureForm.getOtherEndorsementInstruction(), ProcedureConceptEnum.OTHER_SPECIAL_ENDORSEMENT.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(procedureForm.getOtherEndorsementId());
		}
		
		// save referral to newborn screener
		if (StringUtils.isNotEmpty(procedureForm.getReferralToNewbornScreenerInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupTestOrder(procedureForm.getReferralToNewbornScreenerId(),
			    procedureForm.getReferralToNewbornScreenerInstruction(), ProcedureConceptEnum.REFERRAL_TO_NEWBORN_SCREENER.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(procedureForm.getReferralToNewbornScreenerId());
		}
		
		if (StringUtils.isNotEmpty(procedureForm.getReferralToEnterostomalNurseInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupTestOrder(procedureForm.getReferralToEnterostomalNurseId(),
			    procedureForm.getReferralToEnterostomalNurseInstruction(), ProcedureConceptEnum.REFERRAL_TO_ENTEROSTOMAL_NURSE.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(procedureForm.getReferralToEnterostomalNurseId());
		}
		
		if (StringUtils.isNotEmpty(procedureForm.getReferralToDiabetesMellitusEducatorInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupTestOrder(procedureForm.getReferralToDiabetesMellitusEducatorId(),
			    procedureForm.getReferralToDiabetesMellitusEducatorInstruction(), ProcedureConceptEnum.REFERRAL_TO_DIABETES_MELLITUS_EDUCATOR.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(procedureForm.getReferralToDiabetesMellitusEducatorId());
		}
		
		if (StringUtils.isNotEmpty(procedureForm.getReferralToSpiritualMinisterInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupTestOrder(procedureForm.getReferralToSpiritualMinisterId(),
			    procedureForm.getReferralToSpiritualMinisterInstruction(), ProcedureConceptEnum.REFERRAL_TO_SPIRITUAL_MINISTER.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(procedureForm.getReferralToSpiritualMinisterId());
		}
		
		if (StringUtils.isNotEmpty(procedureForm.getGrievingMeasuresInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupTestOrder(procedureForm.getGrievingMeasuresId(),
			    procedureForm.getGrievingMeasuresInstruction(), ProcedureConceptEnum.GRIEVING_MEASURES.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(procedureForm.getGrievingMeasuresId());
		}
		
		if (StringUtils.isNotEmpty(procedureForm.getReferralToPsychologistOrPsychiatristInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupTestOrder(procedureForm.getReferralToPsychologistOrPsychiatristId(),
			    procedureForm.getReferralToPsychologistOrPsychiatristInstruction(), ProcedureConceptEnum.REFERRAL_TO_PSYCHOLOGIST_OR_PSYCHIATRIST.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(procedureForm.getReferralToPsychologistOrPsychiatristId());
		}
		
		if (StringUtils.isNotEmpty(procedureForm.getCodeInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupTestOrder(procedureForm.getCodeId(),
			    procedureForm.getCodeInstruction(), ProcedureConceptEnum.CODE.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(procedureForm.getCodeId());
		}
		
		if (StringUtils.isNotEmpty(procedureForm.getPostMortemCareInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupTestOrder(procedureForm.getPostMortemCareId(),
			    procedureForm.getPostMortemCareInstruction(), ProcedureConceptEnum.POST_MORTEM_CARE.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(procedureForm.getPostMortemCareId());
		}
		
		if (StringUtils.isNotEmpty(procedureForm.getTerminalCleaningInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupTestOrder(procedureForm.getTerminalCleaningId(),
			    procedureForm.getTerminalCleaningInstruction(), ProcedureConceptEnum.TERMINAL_CLEANING.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(procedureForm.getTerminalCleaningId());
		}
		
		if (StringUtils.isNotEmpty(procedureForm.getFiveSInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupTestOrder(procedureForm.getFiveSId(),
			    procedureForm.getFiveSInstruction(), ProcedureConceptEnum.FIVE_S.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(procedureForm.getFiveSId());
		}
		
		request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Laboratory and Procedure details saved!");
		return "redirect:editKardex.form?patientCaseRecordId=" + procedureForm.getPatientCaseRecordId();
		
	}
	
	private NursingCareOrder setupTestOrder(Integer orderId, String instruction, String conceptUuid,
	                                        Encounter currentEncounter, PatientCaseRecord patientCaseRecord) {
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(), false);
		Provider currentProvider = null;
		if (providers.size() > 1) {
			throw new IllegalStateException("Can't handle users with multiple provider accounts");
		} else if (providers.size() == 1) {
			currentProvider = providers.iterator().next();
		}
		OrderType monitoringOrderType = Context.getOrderService().getOrderType(OrderTypeEnum.TEST_ORDER.getValue());
		NursingCareOrder monitoringOrder = new NursingCareOrder();
		monitoringOrder.setId(orderId);
		monitoringOrder.setOrderType(monitoringOrderType);
		monitoringOrder.setConcept(Context.getConceptService().getConceptByUuid(conceptUuid));
		monitoringOrder.setCreator(currentUser);
		monitoringOrder.setDateCreated(new Date());
		monitoringOrder.setPatientCaseRecord(patientCaseRecord);
		monitoringOrder.setEncounter(currentEncounter);
		monitoringOrder.setPatient(patientCaseRecord.getPatient());
		monitoringOrder.setOrderer(currentProvider);
		monitoringOrder.setInstruction(instruction);
		return monitoringOrder;
	}
	
	private void deleteNursingCareOrder(Integer orderId) {
		if (orderId != null) {
			NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
			NursingCareOrder nursingCareOrder = nursingCareOrderService.getNursingCareOrderById(orderId);
			nursingCareOrderService.deleteNursingCareOrder(nursingCareOrder);
		}
	}
	
}
