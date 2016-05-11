package org.openmrs.module.nursingkardex.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.OrderType;
import org.openmrs.Provider;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.DietOrderRequirement;
import org.openmrs.module.nursingkardex.NursingCareOrder;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.api.DietOrderRequirementService;
import org.openmrs.module.nursingkardex.api.NursingCareOrderService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.util.EnumUtils.DietConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OrderTypeEnum;
import org.openmrs.module.nursingkardex.web.form.DietForm;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaveDietFormController {
	
	@RequestMapping(value = "/module/nursingkardex/saveDiet", method = RequestMethod.POST)
	public String saveDiet(HttpServletRequest request, @ModelAttribute("dietForm") DietForm dietForm, BindingResult result) {
		
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientCaseRecord patientCaseRecord = patientCaseRecordService.getPatientCaseRecordById(dietForm
		        .getPatientCaseRecordId());
		Encounter currentEncounter = patientCaseRecord.getLatestPatientMovement().getEncounter();
		NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
		
		// delete existing Diet Instructions
		List<NursingCareOrder> dietOrders = Context.getService(NursingCareOrderService.class)
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(dietForm.getPatientCaseRecordId(),
		            OrderTypeEnum.DIET_ORDER.getValue());
		//		List<NursingCareOrder> orders = deriveDietOrders(currentEncounter, type, dietOrders);
		if (dietOrders != null && !dietOrders.isEmpty()) {
			for (NursingCareOrder order : dietOrders) {
				nursingCareOrderService.deleteNursingCareOrder(order);
			}
		}
		
		// insert new Diet Instructions
		List<Concept> newDietOrders = new ArrayList<Concept>();
		if (dietForm.getDietTypes() != null)
			newDietOrders.addAll(dietForm.getDietTypes());
		if (dietForm.getDietInstructions() != null)
			newDietOrders.addAll(dietForm.getDietInstructions());
		if (dietForm.getDietRoutes() != null)
			newDietOrders.addAll(dietForm.getDietRoutes());
		
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(), false);
		Provider currentProvider = null;
		if (providers.size() > 1) {
			throw new IllegalStateException("Can't handle users with multiple provider accounts");
		} else if (providers.size() == 1) {
			currentProvider = providers.iterator().next();
		}
		OrderType dietOrderType = Context.getOrderService().getOrderType(OrderTypeEnum.DIET_ORDER.getValue());
		if (newDietOrders != null && !newDietOrders.isEmpty()) {
			NursingCareOrder dietOrder = null;
			for (Concept dietConcept : newDietOrders) {
				dietOrder = new NursingCareOrder();
				dietOrder.setOrderType(dietOrderType);
				dietOrder.setConcept(dietConcept);
				dietOrder.setCreator(currentUser);
				dietOrder.setDateCreated(new Date());
				dietOrder.setEncounter(currentEncounter);
				dietOrder.setPatient(patientCaseRecord.getPatient());
				dietOrder.setOrderer(currentProvider);
				dietOrder.setPatientCaseRecord(patientCaseRecord);
				nursingCareOrderService.saveNursingCareOrder(dietOrder);
			}
		}
		if (dietForm.getDietOrderRequirement() != null) {
			Concept dietConcept = Context.getConceptService().getConceptByUuid(DietConceptEnum.DIET_ORDER.getValue());
			NursingCareOrder dietOrder = new NursingCareOrder();
			dietOrder.setOrderType(dietOrderType);
			dietOrder.setConcept(dietConcept);
			dietOrder.setCreator(currentUser);
			dietOrder.setDateCreated(new Date());
			dietOrder.setEncounter(currentEncounter);
			dietOrder.setPatient(patientCaseRecord.getPatient());
			dietOrder.setOrderer(currentProvider);
			dietOrder.setPatientCaseRecord(patientCaseRecord);
			dietOrder = nursingCareOrderService.saveNursingCareOrder(dietOrder);
			
			DietOrderRequirement dietOrderRequirement = dietForm.getDietOrderRequirement();
			dietOrderRequirement.setPatientCaseRecord(patientCaseRecord);
			dietOrderRequirement.setEncounter(currentEncounter);
			dietOrderRequirement.setOrder(dietOrder);
			Context.getService(DietOrderRequirementService.class).saveDietOrderRequirement(dietOrderRequirement);
		}
		
		if (org.apache.commons.lang.StringUtils.isNotEmpty(dietForm.getOthersInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupDietOrder(dietForm.getOthersId(),
				dietForm.getOthersInstruction(), DietConceptEnum.OTHERS.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(dietForm.getOthersId());
		}
		
		request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Diet Information saved!");
		return "redirect:editKardex.form?patientCaseRecordId=" + dietForm.getPatientCaseRecordId();
	}
	
	private NursingCareOrder setupDietOrder(Integer orderId, String instruction, String conceptUuid,
	                                        Encounter currentEncounter, PatientCaseRecord patientCaseRecord) {
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(), false);
		Provider currentProvider = null;
		if (providers.size() > 1) {
			throw new IllegalStateException("Can't handle users with multiple provider accounts");
		} else if (providers.size() == 1) {
			currentProvider = providers.iterator().next();
		}
		OrderType monitoringOrderType = Context.getOrderService().getOrderType(OrderTypeEnum.DIET_ORDER.getValue());
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
