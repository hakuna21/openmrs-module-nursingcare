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
import org.openmrs.module.nursingkardex.util.EnumUtils.OrderTypeEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OutputConceptEnum;
import org.openmrs.module.nursingkardex.web.form.OutputForm;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaveOutputFormController {
	
	@RequestMapping(value = "/module/nursingkardex/saveOutput", method = RequestMethod.POST)
	public String saveMonitoring(HttpServletRequest request, @ModelAttribute("outputForm") OutputForm outputForm,
	                             BindingResult result) {
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientCaseRecord patientCaseRecord = patientCaseRecordService.getPatientCaseRecordById(outputForm
		        .getPatientCaseRecordId());
		Encounter currentEncounter = patientCaseRecord.getLatestPatientMovement().getEncounter();
		
		NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
		if (StringUtils.isNotEmpty(outputForm.getColostomyInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupOutputOrder(outputForm.getColostomyId(),
			    outputForm.getColostomyInstruction(), OutputConceptEnum.COLOSTOMY.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(outputForm.getColostomyId());
		}
		if (StringUtils.isNotEmpty(outputForm.getCttInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupOutputOrder(outputForm.getCttId(),
			    outputForm.getCttInstruction(), OutputConceptEnum.CTT.getValue(), currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(outputForm.getCttId());
		}
		if (StringUtils.isNotEmpty(outputForm.getFcInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupOutputOrder(outputForm.getFcId(),
			    outputForm.getFcInstruction(), OutputConceptEnum.FC.getValue(), currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(outputForm.getFcId());
		}
		if (StringUtils.isNotEmpty(outputForm.getIleostomyInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupOutputOrder(outputForm.getIleostomyId(),
			    outputForm.getIleostomyInstruction(), OutputConceptEnum.ILEOSTOMY.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(outputForm.getIleostomyId());
		}
		if (StringUtils.isNotEmpty(outputForm.getIoMonitoringInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupOutputOrder(outputForm.getIoMonitoringId(),
			    outputForm.getIoMonitoringInstruction(), OutputConceptEnum.IO_MONITORING.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(outputForm.getIoMonitoringId());
		}
		if (StringUtils.isNotEmpty(outputForm.getJpDrainInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupOutputOrder(outputForm.getJpDrainId(),
			    outputForm.getJpDrainInstruction(), OutputConceptEnum.JP_DRAIN.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(outputForm.getJpDrainId());
		}
		if (StringUtils.isNotEmpty(outputForm.getNephrostomyInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupOutputOrder(outputForm.getNephrostomyId(),
			    outputForm.getNephrostomyInstruction(), OutputConceptEnum.NEPHROSTOMY.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(outputForm.getNephrostomyId());
		}
		if (StringUtils.isNotEmpty(outputForm.getOthersInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupOutputOrder(outputForm.getOthersId(),
			    outputForm.getOthersInstruction(), OutputConceptEnum.OTHER_OUTPUT_MONITORING.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(outputForm.getOthersId());
		}
		if (StringUtils.isNotEmpty(outputForm.getReferForOliguriaInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupOutputOrder(outputForm.getReferForOliguriaId(),
			    outputForm.getReferForOliguriaInstruction(), OutputConceptEnum.REFER_FOR_OLIGURIA.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(outputForm.getReferForOliguriaId());
		}
		if (StringUtils.isNotEmpty(outputForm.getStrictIOInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupOutputOrder(outputForm.getStrictIOId(),
			    outputForm.getStrictIOInstruction(), OutputConceptEnum.STRICT_IO.getValue(), currentEncounter,
			    patientCaseRecord));
		} else {
			deleteNursingCareOrder(outputForm.getStrictIOId());
		}
		if (StringUtils.isNotEmpty(outputForm.getTenckhoffCatheterInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupOutputOrder(outputForm.getTenckhoffCatheterId(),
			    outputForm.getTenckhoffCatheterInstruction(), OutputConceptEnum.TENCKHOFF_CATHETER.getValue(),
			    currentEncounter, patientCaseRecord));
		} else {
			deleteNursingCareOrder(outputForm.getTenckhoffCatheterId());
		}
		
		request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Output Information saved!");
		return "redirect:editKardex.form?patientCaseRecordId=" + outputForm.getPatientCaseRecordId();
	}
	
	private NursingCareOrder setupOutputOrder(Integer orderId, String instruction, String conceptUuid,
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
		NursingCareOrder outputOrder = new NursingCareOrder();
		outputOrder.setId(orderId);
		outputOrder.setOrderType(monitoringOrderType);
		outputOrder.setConcept(Context.getConceptService().getConceptByUuid(conceptUuid));
		outputOrder.setCreator(currentUser);
		outputOrder.setDateCreated(new Date());
		outputOrder.setPatientCaseRecord(patientCaseRecord);
		outputOrder.setEncounter(currentEncounter);
		outputOrder.setPatient(patientCaseRecord.getPatient());
		outputOrder.setOrderer(currentProvider);
		outputOrder.setInstruction(instruction);
		return outputOrder;
	}
	
	private void deleteNursingCareOrder(Integer orderId) {
		if (orderId != null) {
			NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
			NursingCareOrder nursingCareOrder = nursingCareOrderService.getNursingCareOrderById(orderId);
			nursingCareOrderService.deleteNursingCareOrder(nursingCareOrder);
		}
	}
	
}
