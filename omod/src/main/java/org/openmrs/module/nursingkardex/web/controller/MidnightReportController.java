package org.openmrs.module.nursingkardex.web.controller;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openmrs.Provider;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.LevelOfCare;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.NursingCareOrder;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.PatientMovement;
import org.openmrs.module.nursingkardex.api.LevelOfCareService;
import org.openmrs.module.nursingkardex.api.NurseService;
import org.openmrs.module.nursingkardex.api.NursingCareOrderService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.api.PatientMovementService;
import org.openmrs.module.nursingkardex.report.MidnightReportBean;
import org.openmrs.module.nursingkardex.util.EnumUtils.EncounterTypeEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OrderTypeEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.ProcedureConceptEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MidnightReportController {
	
	@RequestMapping(value = "/module/nursingkardex/midnightReport", method = RequestMethod.GET)
	public void showFrom(ModelMap model) {
		
		MidnightReportBean reportBean = new MidnightReportBean();
		Nurse nurse = deriveNurseUser();
		Integer locationId = (nurse != null) ? nurse.getLocation().getId() : null;
		
		deriveActivePatientCaseRecordsCount(reportBean, locationId);
		deriveClosedPatientCaseRecordsCount(reportBean, locationId);
		
		model.addAttribute("midnightReportBean", reportBean);
		model.addAttribute("user", Context.getUserContext().getAuthenticatedUser());
	}
	
	private void deriveActivePatientCaseRecordsCount(MidnightReportBean reportBean, Integer locationId) {
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientMovementService patientMovementService = Context.getService(PatientMovementService.class);
		LevelOfCareService levelOfCareService = Context.getService(LevelOfCareService.class);
		String MALE = "M";
		
		// derive all active patient movements
		List<PatientCaseRecord> activePatients = patientCaseRecordService.getActivePatientCaseRecords(locationId);
		if (activePatients != null && !activePatients.isEmpty()) {
			for (PatientCaseRecord patientCaseRecord : activePatients) {
				
				// derive total count
				if (patientCaseRecord.getPatient().getGender().equals(MALE)) {
					reportBean.addTotalLastMale();
				} else {
					reportBean.addTotalLastFemale();
				}
				
				// derive delivery count
				deriveDelivery(reportBean, patientCaseRecord.getId());
				
				// derive close monitoring count
				List<LevelOfCare> levelOfCares = levelOfCareService.getLevelOfCaresByPatientCaseRecordId(patientCaseRecord
				        .getId());
				if (levelOfCares != null && !levelOfCares.isEmpty()) {
					if (levelOfCares.get(0).getLevelOfCare() != null && levelOfCares.get(0).getLevelOfCare().equals(4)) {
						if (patientCaseRecord.getPatient().getGender().equals(MALE)) {
							reportBean.addCloseMonitoringMale();
						} else {
							reportBean.addCloseMonitoringFemale();
						}
					}
				}
				
				List<PatientMovement> patientMovements = patientMovementService
				        .getPatientMovementsByPatientCaseRecordId(patientCaseRecord.getId());
				if (patientMovements != null && !patientMovements.isEmpty()) {
					for (PatientMovement patientMovement : patientMovements) {
						
						// derive rooming in count
						if (patientMovement.getEncounter().getEncounterType().getEncounterTypeId()
						        .equals(EncounterTypeEnum.ROOMING_IN.getValue())) {
							if (patientMovement.getPatientCaseRecord().getPatient().getGender().equals(MALE)) {
								reportBean.addRoomingInMale();
							} else {
								reportBean.addRoomingInFemale();
							}
						}
						
						// for Today's transactions
						if (checkIfDateIsToday(patientMovement.getMovementDatetime())) {
							// derive Admission count
							if (patientMovement.getEncounter().getEncounterType().getEncounterTypeId()
							        .equals(EncounterTypeEnum.ADMISSION.getValue())) {
								if (patientMovement.getPatientCaseRecord().getPatient().getGender().equals(MALE)) {
									reportBean.addAdmissionMale();
								} else {
									reportBean.addAdmissionFemale();
								}
							}
							// TODO manage the transfer in/out properly
							// derive Transfer count
							if (patientMovement.getEncounter().getEncounterType().getEncounterTypeId()
							        .equals(EncounterTypeEnum.TRANSFER.getValue())) {
								if (patientMovement.getPatientCaseRecord().getPatient().getGender().equals(MALE)) {
									reportBean.addTransferInMale();
								} else {
									reportBean.addTransferInFemale();
								}
							}
							// TODO manage the transfer in/out properly count
							if (patientMovement.getEncounter().getEncounterType().getEncounterTypeId()
							        .equals(EncounterTypeEnum.TRANSFER.getValue())) {
								if (patientMovement.getPatientCaseRecord().getPatient().getGender().equals(MALE)) {
									reportBean.addTransferOutMale();
								} else {
									reportBean.addTransferOutFemale();
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void deriveClosedPatientCaseRecordsCount(MidnightReportBean reportBean, Integer locationId) {
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientMovementService patientMovementService = Context.getService(PatientMovementService.class);
		String MALE = "M";
		List<PatientCaseRecord> closedRecords = patientCaseRecordService.getClosedPatientCaseRecord(true, locationId);
		if (closedRecords != null && !closedRecords.isEmpty()) {
			for (PatientCaseRecord closedRecord : closedRecords) {
				
				List<PatientMovement> patientMovements = patientMovementService
				        .getPatientMovementsByPatientCaseRecordId(closedRecord.getId());
				if (patientMovements != null && !patientMovements.isEmpty()) {
					for (PatientMovement patientMovement : patientMovements) {
						// derive Discharged count
						if (patientMovement.getEncounter().getEncounterType().getEncounterTypeId()
						        .equals(EncounterTypeEnum.DISCHARGE.getValue())) {
							if (patientMovement.getPatientCaseRecord().getPatient().getGender().equals(MALE)) {
								reportBean.addDischargedMale();
							} else {
								reportBean.addDischargedFemale();
							}
						}
						// derive Mortality count
						if (patientMovement.getEncounter().getEncounterType().getEncounterTypeId()
						        .equals(EncounterTypeEnum.MORTALITY.getValue())) {
							if (patientMovement.getPatientCaseRecord().getPatient().getGender().equals(MALE)) {
								reportBean.addDeathsMale();
							} else {
								reportBean.addDeathsFemale();
							}
						}
						// derive home against medical advice count
						if (patientMovement.getEncounter().getEncounterType().getEncounterTypeId()
						        .equals(EncounterTypeEnum.HOME_AGAINST_MEDICAL_ADVICE.getValue())) {
							if (patientMovement.getPatientCaseRecord().getPatient().getGender().equals(MALE)) {
								reportBean.addHomeVsAdviceMale();
							} else {
								reportBean.addHomeVsAdviceFemale();
							}
						}
						// derive home per request count
						if (patientMovement.getEncounter().getEncounterType().getEncounterTypeId()
						        .equals(EncounterTypeEnum.HOME_PER_REQUEST.getValue())) {
							if (patientMovement.getPatientCaseRecord().getPatient().getGender().equals(MALE)) {
								reportBean.addHomePerRequestMale();
							} else {
								reportBean.addHomePerRequestFemale();
							}
						}
					}
				}
			}
		}
	}
	
	private void deriveDelivery(MidnightReportBean reportBean, Integer patientCaseRecordId) {
		List<NursingCareOrder> testOrders = Context.getService(NursingCareOrderService.class)
		        .getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecordId,
		            OrderTypeEnum.TEST_ORDER.getValue());
		
		if (testOrders != null && !testOrders.isEmpty()) {
			for (NursingCareOrder order : testOrders) {
				if (order.getConcept().getUuid().equals(ProcedureConceptEnum.SENT_TO_LABOR_ROOM_OR_DELIVERY_ROOM.getValue())) {
					reportBean.addDeliveries();
				}
			}
		}
	}
	
	private Nurse deriveNurseUser() {
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
			nurseService.getByProviderId(currentProvider.getProviderId());
		}
		return nurse;
	}
	
	private boolean checkIfDateIsToday(Date dateToCheck) {
		Calendar date = new GregorianCalendar();
		// reset hour, minutes, seconds and millis
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		Date date1 = date.getTime();
		
		// next day
		date.add(Calendar.DAY_OF_MONTH, 1);
		Date date2 = date.getTime();
		
		return date1.compareTo(dateToCheck) * dateToCheck.compareTo(date2) > 0;
	}
	
}
