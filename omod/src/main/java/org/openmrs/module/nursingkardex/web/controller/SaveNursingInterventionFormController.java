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
import org.openmrs.module.nursingkardex.LevelOfCare;
import org.openmrs.module.nursingkardex.NursingCareOrder;
import org.openmrs.module.nursingkardex.OxygenationOrder;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.api.LevelOfCareService;
import org.openmrs.module.nursingkardex.api.NursingCareOrderService;
import org.openmrs.module.nursingkardex.api.OxygenationOrderService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.util.EnumUtils.NursingInterventionEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OrderTypeEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OxygenationEnum;
import org.openmrs.module.nursingkardex.web.form.NursingInterventionForm;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaveNursingInterventionFormController {
	
	@RequestMapping(value = "/module/nursingkardex/saveNursingIntervention", method = RequestMethod.POST)
	public String saveNursingIntervention(HttpServletRequest request,
	                                      @ModelAttribute("dietForm") NursingInterventionForm nursingInterventionForm,
	                                      BindingResult result) {
		
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientCaseRecord patientCaseRecord = patientCaseRecordService.getPatientCaseRecordById(nursingInterventionForm
		        .getPatientCaseRecordId());
		Encounter currentEncounter = patientCaseRecord.getLatestPatientMovement().getEncounter();
		NursingCareOrderService nursingCareOrderService = Context.getService(NursingCareOrderService.class);
		OrderType otherInterventiontype = Context.getOrderService().getOrderType(
		    OrderTypeEnum.OTHER_INTERVETION_ORDER.getValue());
		OrderType oxygenerationOrderType = Context.getOrderService()
		        .getOrderType(OrderTypeEnum.OXYGENATION_ORDER.getValue());
		
		if (StringUtils.isNotEmpty(nursingInterventionForm.getBedBathInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getBedBathId(), nursingInterventionForm.getBedBathInstruction(),
			    NursingInterventionEnum.BED_BATH.getValue(), currentEncounter, patientCaseRecord, otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getBedBathId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getBedsorePrecautionInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getBedsorePrecautionId(), nursingInterventionForm.getBedsorePrecautionInstruction(),
			    NursingInterventionEnum.BEDSORE_PRECAUTION.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getBedsorePrecautionId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getCastCareInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getCastCareId(), nursingInterventionForm.getCastCareInstruction(),
			    NursingInterventionEnum.CAST_CARE.getValue(), currentEncounter, patientCaseRecord, otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getCastCareId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getCbrWithToiletInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getCbrWithToiletId(), nursingInterventionForm.getCbrWithToiletInstruction(),
			    NursingInterventionEnum.CBR_WITH_TOILET.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getCbrWithToiletId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getCbrWithoutToiletInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getCbrWithoutToiletId(), nursingInterventionForm.getCbrWithoutToiletInstruction(),
			    NursingInterventionEnum.CBR_WITHOUT_TOILET.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getCbrWithoutToiletId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getChangeWoundDressingInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getChangeWoundDressingId(),
			    nursingInterventionForm.getChangeWoundDressingInstruction(),
			    NursingInterventionEnum.CHANGE_WOUND_DRESSING.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getChangeWoundDressingId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getKeepThemoregulatedInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getKeepThemoregulatedId(),
			    nursingInterventionForm.getKeepThemoregulatedInstruction(),
			    NursingInterventionEnum.KEEP_THERMOREGULATED.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getKeepThemoregulatedId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getHairShampooInstruction())) {
			nursingCareOrderService
			        .saveNursingCareOrder(setupNursingInterventionOrder(nursingInterventionForm.getHairShampooId(),
			            nursingInterventionForm.getHairShampooInstruction(),
			            NursingInterventionEnum.HAIR_SHAMPOO.getValue(), currentEncounter, patientCaseRecord,
			            otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getHairShampooId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getNailCareInstruction())) {
			nursingCareOrderService
			        .saveNursingCareOrder(setupNursingInterventionOrder(nursingInterventionForm.getNailCareId(),
			            nursingInterventionForm.getNailCareInstruction(),
			            NursingInterventionEnum.NAIL_CARE.getValue(), currentEncounter, patientCaseRecord,
			            otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getNailCareId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getPerinealCareInstruction())) {
			nursingCareOrderService
			        .saveNursingCareOrder(setupNursingInterventionOrder(nursingInterventionForm.getPerinealCareId(),
			            nursingInterventionForm.getPerinealCareInstruction(),
			            NursingInterventionEnum.PERINEAL_CARE.getValue(), currentEncounter, patientCaseRecord,
			            otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getPerinealCareId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getPositioningInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getPositioningId(), nursingInterventionForm.getPositioningInstruction(),
			    NursingInterventionEnum.POSITIONING.getValue(), currentEncounter, patientCaseRecord, otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getPositioningId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getMassageBodyProminencesInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getMassageBodyProminencesId(), nursingInterventionForm.getMassageBodyProminencesInstruction(),
			    NursingInterventionEnum.MASSAGE_BONY_PROMINENCES.getValue(), currentEncounter, patientCaseRecord, otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getMassageBodyProminencesId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getBurnInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getBurnId(), nursingInterventionForm.getBurnInstruction(),
			    NursingInterventionEnum.BURN.getValue(), currentEncounter, patientCaseRecord, otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getBurnId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getPressureUlcerAcquiredFromThisHealthFacilityInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getPressureUlcerAcquiredFromThisHealthFacilityId(), nursingInterventionForm.getPressureUlcerAcquiredFromThisHealthFacilityInstruction(),
			    NursingInterventionEnum.PRESSURE_ULCER_ACQUIRED_FROM_THIS_HEALTH_FACILITY.getValue(), currentEncounter, patientCaseRecord, otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getPressureUlcerAcquiredFromThisHealthFacilityId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getPressureUlcerAcquiredFromOtherLocationInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getPressureUlcerAcquiredFromOtherLocationId(), nursingInterventionForm.getPressureUlcerAcquiredFromOtherLocationInstruction(),
			    NursingInterventionEnum.PRESSURE_ULCER_ACQUIRED_FROM_OTHER_LOCATION.getValue(), currentEncounter, patientCaseRecord, otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getPressureUlcerAcquiredFromOtherLocationId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getSheaPrecautionInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getSheaPrecautionId(), nursingInterventionForm.getSheaPrecautionInstruction(),
			    NursingInterventionEnum.SHEA_PRECAUTION.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getSheaPrecautionId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getStrictAsepsisInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getStrictAsepsisId(), nursingInterventionForm.getStrictAsepsisInstruction(),
			    NursingInterventionEnum.STRICT_ASEPSIS.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getStrictAsepsisId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getTepidSpongeBathInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getTepidSpongeBathId(), nursingInterventionForm.getTepidSpongeBathInstruction(),
			    NursingInterventionEnum.TEPID_SPONGE_BATH.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getTepidSpongeBathId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getTracheostomyCareInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getTracheostomyCareId(), nursingInterventionForm.getTracheostomyCareInstruction(),
			    NursingInterventionEnum.TRACHEOSTOMY_CARE.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getTracheostomyCareId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getTractionCareInstruction())) {
			nursingCareOrderService
			        .saveNursingCareOrder(setupNursingInterventionOrder(nursingInterventionForm.getTractionCareId(),
			            nursingInterventionForm.getTractionCareInstruction(),
			            NursingInterventionEnum.TRACTION_CARE.getValue(), currentEncounter, patientCaseRecord,
			            otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getTractionCareId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getUniversalPrecautionInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getUniversalPrecautionId(),
			    nursingInterventionForm.getUniversalPrecautionInstruction(),
			    NursingInterventionEnum.UNIVERSAL_PRECAUTION.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getUniversalPrecautionId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getHealthTeachingInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getHealthTeachingId(),
			    nursingInterventionForm.getHealthTeachingInstruction(),
			    NursingInterventionEnum.HEALTH_TEACHING.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getHealthTeachingId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getRelaxationMeasuresInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getRelaxationMeasuresId(),
			    nursingInterventionForm.getRelaxationMeasuresInstruction(),
			    NursingInterventionEnum.RELAXATION_MEASURES.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getRelaxationMeasuresId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getRestrainingInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getRestrainingId(),
			    nursingInterventionForm.getRestrainingInstruction(),
			    NursingInterventionEnum.RESTRAINING.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getRestrainingId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getOtherInterventionInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getOtherInterventionId(), nursingInterventionForm.getOtherInterventionInstruction(),
			    NursingInterventionEnum.OTHER_INTERVENTION.getValue(), currentEncounter, patientCaseRecord,
			    otherInterventiontype));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getOtherInterventionId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getChestPhysiotherapyInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getChestPhysiotherapyId(),
			    nursingInterventionForm.getChestPhysiotherapyInstruction(), OxygenationEnum.CHEST_PHYSIOTHERAPY.getValue(),
			    currentEncounter, patientCaseRecord, oxygenerationOrderType));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getChestPhysiotherapyId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getOxygenationSupportInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getOxygenationSupportId(),
			    nursingInterventionForm.getOxygenationSupportInstruction(), OxygenationEnum.OXYGEN_SUPPORT.getValue(),
			    currentEncounter, patientCaseRecord, oxygenerationOrderType));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getOxygenationSupportId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getDescriptionOfOxygenSupportInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getDescriptionOfOxygenSupportId(),
			    nursingInterventionForm.getDescriptionOfOxygenSupportInstruction(), OxygenationEnum.DESCRIPTION_OF_OXYGEN_SUPPORT.getValue(),
			    currentEncounter, patientCaseRecord, oxygenerationOrderType));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getDescriptionOfOxygenSupportId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getSuctioningInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getSuctioningId(), nursingInterventionForm.getSuctioningInstruction(),
			    OxygenationEnum.SUCTIONING.getValue(), currentEncounter, patientCaseRecord, oxygenerationOrderType));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getSuctioningId());
		}
		if (StringUtils.isNotEmpty(nursingInterventionForm.getWeaningInstruction())) {
			nursingCareOrderService.saveNursingCareOrder(setupNursingInterventionOrder(
			    nursingInterventionForm.getWeaningId(), nursingInterventionForm.getWeaningInstruction(),
			    OxygenationEnum.WEANING.getValue(), currentEncounter, patientCaseRecord, oxygenerationOrderType));
		} else {
			deleteNursingCareOrder(nursingInterventionForm.getWeaningId());
		}
		
		// saving additional Oxgenation Details
		if (nursingInterventionForm.getOxygenationOrder() != null) {
			OxygenationOrder oxygenationOrder = nursingInterventionForm.getOxygenationOrder();
			oxygenationOrder.setPatientCaseRecord(patientCaseRecord);
			oxygenationOrder.setEncounter(currentEncounter);
			Context.getService(OxygenationOrderService.class).saveOxygenationOrder(oxygenationOrder);
		}
		
		// saving level of care
		if (nursingInterventionForm.getLevelOfCare() != null) {
			User currentUser = Context.getUserContext().getAuthenticatedUser();
			LevelOfCare levelOfCare = nursingInterventionForm.getLevelOfCare();
			levelOfCare.setEncounter(currentEncounter);
			levelOfCare.setPatientCaseRecord(patientCaseRecord);
			levelOfCare.setCreator(currentUser);
			levelOfCare.setDateCreated(new Date());
			Context.getService(LevelOfCareService.class).saveLevelOfCare(levelOfCare);
		}
		
		request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Intervention Information saved!");
		return "redirect:editKardex.form?patientCaseRecordId=" + nursingInterventionForm.getPatientCaseRecordId();
	}
	
	private NursingCareOrder setupNursingInterventionOrder(Integer orderId, String instruction, String conceptUuid,
	                                                       Encounter currentEncounter, PatientCaseRecord patientCaseRecord,
	                                                       OrderType orderType) {
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(), false);
		Provider currentProvider = null;
		if (providers.size() > 1) {
			throw new IllegalStateException("Can't handle users with multiple provider accounts");
		} else if (providers.size() == 1) {
			currentProvider = providers.iterator().next();
		}
		NursingCareOrder monitoringOrder = new NursingCareOrder();
		monitoringOrder.setId(orderId);
		monitoringOrder.setOrderType(orderType);
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
