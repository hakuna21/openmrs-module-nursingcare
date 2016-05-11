package org.openmrs.module.nursingkardex.web.controller;

import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.openmrs.Encounter;
import org.openmrs.OrderType;
import org.openmrs.Provider;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.NursingCareOrder;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.api.NursingCareOrderService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.util.EnumUtils.MonitoringConceptEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OrderTypeEnum;
import org.openmrs.module.nursingkardex.web.form.MonitoringForm;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaveMonitoringFormController {
	
	@RequestMapping(value = "/module/nursingkardex/saveMonitoring", method = RequestMethod.POST)
	public String saveMonitoring(HttpServletRequest request,
	                             @ModelAttribute("monitoringForm") MonitoringForm monitoringForm, BindingResult result) {
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientCaseRecord patientCaseRecord = patientCaseRecordService.getPatientCaseRecordById(monitoringForm
		        .getPatientCaseRecordId());
		Encounter currentEncounter = patientCaseRecord.getLatestPatientMovement().getEncounter();
		
		NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
		if (StringUtils.isNotEmpty(monitoringForm.getAgInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupMonitoringOrder(monitoringForm.getAgId(),
			    monitoringForm.getAgInstruction(), MonitoringConceptEnum.ABDOMINAL_GIRTH.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(monitoringForm.getAgId());
		}
		if (StringUtils.isNotEmpty(monitoringForm.getCbgInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupMonitoringOrder(monitoringForm.getCbgId(),
			    monitoringForm.getCbgInstruction(), MonitoringConceptEnum.CAPILLARY_BLOOD_GLUCOSE.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(monitoringForm.getCbgId());
		}
		if (StringUtils.isNotEmpty(monitoringForm.getWeightInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupMonitoringOrder(monitoringForm.getWeightId(),
			    monitoringForm.getWeightInstruction(), MonitoringConceptEnum.WEIGHT.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(monitoringForm.getWeightId());
		}
		if (StringUtils.isNotEmpty(monitoringForm.getHcInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupMonitoringOrder(monitoringForm.getHcId(),
			    monitoringForm.getHcInstruction(), MonitoringConceptEnum.HEAD_CIRCUMFERENCE.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(monitoringForm.getHcId());
		}
		if (StringUtils.isNotEmpty(monitoringForm.getNvsInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupMonitoringOrder(monitoringForm.getNvsId(),
			    monitoringForm.getNvsInstruction(), MonitoringConceptEnum.NEUROLOGICAL_VITAL_SIGNS.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(monitoringForm.getNvsId());
		}
		if (StringUtils.isNotEmpty(monitoringForm.getVsInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupMonitoringOrder(monitoringForm.getVsId(),
			    monitoringForm.getVsInstruction(), MonitoringConceptEnum.VITAL_SIGNS.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(monitoringForm.getVsId());
		}
		if (StringUtils.isNotEmpty(monitoringForm.getFeverInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupMonitoringOrder(monitoringForm.getFeverId(),
			    monitoringForm.getFeverInstruction(), MonitoringConceptEnum.FEVER.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(monitoringForm.getFeverId());
		}
		if (StringUtils.isNotEmpty(monitoringForm.getIncIcpInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupMonitoringOrder(monitoringForm.getIncIcpId(),
			    monitoringForm.getIncIcpInstruction(), MonitoringConceptEnum.INCREASED_INTRACRANIAL_PRESSURE.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(monitoringForm.getIncIcpId());
		}
		if (StringUtils.isNotEmpty(monitoringForm.getCongestionInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupMonitoringOrder(monitoringForm.getCongestionId(),
			    monitoringForm.getCongestionInstruction(), MonitoringConceptEnum.CONGESTION.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(monitoringForm.getCongestionId());
		}
		if (StringUtils.isNotEmpty(monitoringForm.getOthersInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupMonitoringOrder(monitoringForm.getOthersId(),
			    monitoringForm.getOthersInstruction(), MonitoringConceptEnum.OTHER_MONITORING_INSTRUCTION.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(monitoringForm.getOthersId());
		}
		
		if (StringUtils.isNotEmpty(monitoringForm.getPainInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupMonitoringOrder(monitoringForm.getPainId(),
			    monitoringForm.getPainInstruction(), MonitoringConceptEnum.PAIN.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(monitoringForm.getPainId());
		}
		
		request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Monitoring Information saved!");
		return "redirect:editKardex.form?patientCaseRecordId=" + monitoringForm.getPatientCaseRecordId();
	}
	
	private NursingCareOrder setupMonitoringOrder(Integer orderId, String instruction, String conceptUuid,
	                                              Encounter currentEncounter, PatientCaseRecord patientCaseRecord) {
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(), false);
		Provider currentProvider = null;
		if (providers.size() > 1) {
			throw new IllegalStateException("Can't handle users with multiple provider accounts");
		} else if (providers.size() == 1) {
			currentProvider = providers.iterator().next();
		}
		OrderType monitoringOrderType = Context.getOrderService().getOrderType(OrderTypeEnum.MONITORING_ORDER.getValue());
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
