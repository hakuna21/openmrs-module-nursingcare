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
import org.openmrs.module.nursingkardex.ParenteralOrderInfusion;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.api.NursingCareOrderService;
import org.openmrs.module.nursingkardex.api.ParenteralOrderInfusionService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.util.EnumUtils.OrderTypeEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.ParenteralOrderEnum;
import org.openmrs.module.nursingkardex.web.form.ParenteralOrderForm;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaveParenteralOrderFormController {
	
	@RequestMapping(value = "/module/nursingkardex/saveParenteralOrder", method = RequestMethod.POST)
	public String saveParenteralOrder(@ModelAttribute("parenteralOrderForm") ParenteralOrderForm parenteralOrderForm,
	                                  HttpServletRequest request) {
		
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientCaseRecord patientCaseRecord = patientCaseRecordService.getPatientCaseRecordById(parenteralOrderForm
		        .getPatientCaseRecordId());
		Encounter currentEncounter = patientCaseRecord.getLatestPatientMovement().getEncounter();
		NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
		ParenteralOrderInfusionService parenteralOrderInfusionService = Context
		        .getService(ParenteralOrderInfusionService.class);
		
		// delete Parenteral Orders that have been removed in UI
		List<ParenteralOrderInfusion> existingParenteralOrders = parenteralOrderInfusionService
		        .getParenteralOrderInfusionByPatientCaseRecordId(parenteralOrderForm.getPatientCaseRecordId());
		if (existingParenteralOrders != null && !existingParenteralOrders.isEmpty()
		        && parenteralOrderForm.getExistingParenteralOrders() != null) {
			for (ParenteralOrderInfusion parenteralOrder : existingParenteralOrders) {
				if (!parenteralOrderForm.getExistingParenteralOrders().contains(parenteralOrder.getId())) {
					if (parenteralOrder.getOrder() != null) {
						nursingCareOrderService.deleteNursingCareOrder(parenteralOrder.getOrder());
					}
					parenteralOrderInfusionService.deleteParenteralOrderInfusion(parenteralOrder);
				}
			}
		}
		// if all entries will be deleted
		if ((parenteralOrderForm.getExistingParenteralOrders() == null || parenteralOrderForm.getExistingParenteralOrders().isEmpty()) 
				&& (existingParenteralOrders != null || existingParenteralOrders.isEmpty())) {
			for (ParenteralOrderInfusion parenteralOrder : existingParenteralOrders) {
				if (parenteralOrder.getOrder() != null) {
					nursingCareOrderService.deleteNursingCareOrder(parenteralOrder.getOrder());
				}
				parenteralOrderInfusionService.deleteParenteralOrderInfusion(parenteralOrder);
			}
		}
		
		OrderType testOrderType = Context.getOrderService().getOrderType(OrderTypeEnum.PARENTERAL_ORDER.getValue());
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(), false);
		Provider currentProvider = null;
		if (providers.size() > 1) {
			throw new IllegalStateException("Can't handle users with multiple provider accounts");
		} else if (providers.size() == 1) {
			currentProvider = providers.iterator().next();
		}
		
		// save new parenteral orders
		if (parenteralOrderForm.getParenteralOrders() != null) {
			Concept parenteralOrderConcept = Context.getConceptService().getConceptByUuid(
			    ParenteralOrderEnum.PARENTERAL_ORDER.getValue());
			for (ParenteralOrderInfusion parenteralOrder : parenteralOrderForm.getParenteralOrders()) {
				NursingCareOrder order = new NursingCareOrder();
				order.setOrderType(testOrderType);
				order.setConcept(parenteralOrderConcept);
				order.setCreator(currentUser);
				order.setDateCreated(new Date());
				order.setPatientCaseRecord(patientCaseRecord);
				order.setEncounter(currentEncounter);
				order.setPatient(patientCaseRecord.getPatient());
				order.setOrderer(currentProvider);
				order.setInstruction(null);
				order = nursingCareOrderService.saveNursingCareOrder(order);
				
				parenteralOrder.setPatientCaseRecord(patientCaseRecord);
				parenteralOrder.setEncounter(currentEncounter);
				parenteralOrder.setOrder(order);
				parenteralOrderInfusionService.saveParenteralOrderInfusion(parenteralOrder);
			}
		}
		
		// save other parenteral orders
		if (parenteralOrderForm.getOtherParenteralOrders() != null) {
			Concept parenteralOrderConcept = Context.getConceptService().getConceptByUuid(
			    ParenteralOrderEnum.PARENTERAL_ORDER.getValue());
			for (ParenteralOrderInfusion parenteralOrder : parenteralOrderForm.getOtherParenteralOrders()) {
				NursingCareOrder order = new NursingCareOrder();
				order.setOrderType(testOrderType);
				order.setConcept(parenteralOrderConcept);
				order.setCreator(currentUser);
				order.setDateCreated(new Date());
				order.setPatientCaseRecord(patientCaseRecord);
				order.setEncounter(currentEncounter);
				order.setPatient(patientCaseRecord.getPatient());
				order.setOrderer(currentProvider);
				order.setInstruction(null);
				order = nursingCareOrderService.saveNursingCareOrder(order);
				
				parenteralOrder.setPatientCaseRecord(patientCaseRecord);
				parenteralOrder.setEncounter(currentEncounter);
				parenteralOrder.setOrder(order);
				parenteralOrderInfusionService.saveParenteralOrderInfusion(parenteralOrder);
			}
		}
		
		// parenteral devices
		if (StringUtils.isNotEmpty(parenteralOrderForm.getArteriovenousFistulaInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupParenteralOrder(
			    parenteralOrderForm.getArteriovenousFistulaId(), parenteralOrderForm.getArteriovenousFistulaInstruction(),
			    ParenteralOrderEnum.ARTERIOVENOUS_FISTULA.getValue(), currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(parenteralOrderForm.getArteriovenousFistulaId());
		}
		if (StringUtils.isNotEmpty(parenteralOrderForm.getFemoralCatheterInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupParenteralOrder(parenteralOrderForm.getFemoralCatheterId(),
			    parenteralOrderForm.getFemoralCatheterInstruction(), ParenteralOrderEnum.FEMORAL_CATHETER.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(parenteralOrderForm.getFemoralCatheterId());
		}
		if (StringUtils.isNotEmpty(parenteralOrderForm.getHeplockInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupParenteralOrder(parenteralOrderForm.getHeplockId(),
			    parenteralOrderForm.getHeplockInstruction(), ParenteralOrderEnum.HEPLOCK.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(parenteralOrderForm.getHeplockId());
		}
		if (StringUtils.isNotEmpty(parenteralOrderForm.getIntrajugularCatheterInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupParenteralOrder(
			    parenteralOrderForm.getIntrajugularCatheterId(), parenteralOrderForm.getIntrajugularCatheterInstruction(),
			    ParenteralOrderEnum.INTRAJUGULAR_CATHETER.getValue(), currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(parenteralOrderForm.getIntrajugularCatheterId());
		}
		if (StringUtils.isNotEmpty(parenteralOrderForm.getSubclavianCatheterInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupParenteralOrder(parenteralOrderForm.getSubclavianCatheterId(),
			    parenteralOrderForm.getSubclavianCatheterInstruction(), ParenteralOrderEnum.SUBCLAVIAN_CATHETER.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(parenteralOrderForm.getSubclavianCatheterId());
		}
		if (StringUtils.isNotEmpty(parenteralOrderForm.getChemotherapyInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupParenteralOrder(parenteralOrderForm.getChemotherapyId(),
			    parenteralOrderForm.getChemotherapyInstruction(),
			    ParenteralOrderEnum.CHEMOTHERAPY.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(parenteralOrderForm.getChemotherapyId());
		}
		if (StringUtils.isNotEmpty(parenteralOrderForm.getOtherParenteralInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupParenteralOrder(parenteralOrderForm.getOtherParenteralId(),
			    parenteralOrderForm.getOtherParenteralInstruction(),
			    ParenteralOrderEnum.OTHER_PARENTERAL_INSTRUCTION.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(parenteralOrderForm.getOtherParenteralId());
		}
		
		request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Parenteral details saved!");
		return "redirect:editKardex.form?patientCaseRecordId=" + parenteralOrderForm.getPatientCaseRecordId();
		
	}
	
	private NursingCareOrder setupParenteralOrder(Integer orderId, String instruction, String conceptUuid,
	                                              Encounter currentEncounter, PatientCaseRecord patientCaseRecord) {
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(), false);
		Provider currentProvider = null;
		if (providers.size() > 1) {
			throw new IllegalStateException("Can't handle users with multiple provider accounts");
		} else if (providers.size() == 1) {
			currentProvider = providers.iterator().next();
		}
		OrderType monitoringOrderType = Context.getOrderService().getOrderType(OrderTypeEnum.PARENTERAL_ORDER.getValue());
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
