package org.openmrs.module.nursingkardex.web.controller;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.Encounter;
import org.openmrs.EncounterType;
import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Provider;
import org.openmrs.User;
import org.openmrs.Visit;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.PatientMovement;
import org.openmrs.module.nursingkardex.Physician;
import org.openmrs.module.nursingkardex.api.BedService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.api.PatientMovementService;
import org.openmrs.module.nursingkardex.util.EnumUtils.EncounterTypeEnum;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.openmrs.User;

@Controller
public class PatientMovementFormController {
	
	@RequestMapping(value = "/module/nursingkardex/patientMovement", method = RequestMethod.GET)
	public void showForm(ModelMap model) {
		
		EncounterType encounterType = Context.getEncounterService().getEncounterType(EncounterTypeEnum.TRANSFER.getValue());
		Encounter encounter = new Encounter();
		encounter.setEncounterType(encounterType);
		PatientMovement patientMovement = new PatientMovement();
		patientMovement.setEncounter(encounter);
		patientMovement.setEncounterType(encounterType);
		model.addAttribute("patientMovement", patientMovement);
		
		ReportHelper reportHelper = new ReportHelper();
		Nurse nurse = new KardexHelper().deriveNurse();
		Physician physician = new KardexHelper().derivePhysician();
		List<PatientCaseRecord> patientCaseRecordsByPhysician = null;
		model.addAttribute("patientCaseRecords", reportHelper.getActivePatientCaseRecords());
		model.addAttribute("user", Context.getUserContext().getAuthenticatedUser());
		model.addAttribute("nurse", nurse);
		model.addAttribute("physician", physician);
		if (physician!=null) { 
			patientCaseRecordsByPhysician = new KardexHelper().derivePatientCaseRecordsByPhysicianInChargeId(physician.getId());
			model.addAttribute("patientCaseRecordsByPhysician",patientCaseRecordsByPhysician);
		}
		
	}
	
	@RequestMapping(value = "/module/nursingkardex/patientMovement", method = RequestMethod.POST)
	public String savePatientMovement(@ModelAttribute("patientMovement") PatientMovement patientMovement,
	                                  BindingResult errors, HttpServletRequest request) {
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		BedService bedService = Context.getService(BedService.class);
		PatientMovementService patientMovementService = Context.getService(PatientMovementService.class);
		
		PatientCaseRecord patientCaseRecord = patientCaseRecordService.getPatientCaseRecordById(patientMovement
		        .getPatientCaseRecord().getId());
		
		List<Visit> activeVisits = Context.getVisitService().getActiveVisitsByPatient(patientCaseRecord.getPatient());
		Visit visit = null;
		if (activeVisits != null && !activeVisits.isEmpty()) {
			visit = activeVisits.get(0);
		}
		
		Location location = null;
		if (patientMovement.getBed() != null && patientMovement.getBed().getId() != null) {
			Bed bed = bedService.getBedById(patientMovement.getBed().getId());
			location = bed.getLocation();
		}
		
		Bed oldBed = bedService.getBedById(patientCaseRecord.getLatestPatientMovement().getBed().getId());
		oldBed.setIsOccupied(0);
		bedService.saveBed(oldBed);
		patientMovement.setPreviousBed(oldBed);
		
		Encounter encounter = setupEncounter(patientCaseRecord.getPatient(), location, visit,
		    patientMovement.getEncounterType());
		patientMovement.setEncounter(encounter);
		patientMovement.setPatientCaseRecord(patientCaseRecord);
		if (!patientMovement.getEncounter().getEncounterType().getId().equals(EncounterTypeEnum.TRANSFER.getValue())
		        && !patientMovement.getEncounter().getEncounterType().getId()
		                .equals(EncounterTypeEnum.ROOMING_IN.getValue())) {
			patientMovement.setBed(null);
		}
		
		if (patientMovement.getEncounter().getEncounterType().getId().equals(EncounterTypeEnum.TRANSFER.getValue())) {
//			List<PatientMovement> patientMovements = patientMovementService
//			        .getPatientMovementsByPatientCaseRecordId(patientCaseRecord.getId());
			//			for (PatientMovement movement : patientMovements) {
			//				movement.setPreviousBed(oldBed);
			//				patientMovementService.savePatientMovement(movement);
			//			}
			//			patientMovement.setPreviousBed(oldBed);
			
			Bed newBed = bedService.getBedById(patientMovement.getBed().getId());
			newBed.setIsOccupied(1);
			bedService.saveBed(newBed);
		}
		if (patientMovement.getEncounter().getEncounterType().getId().equals(EncounterTypeEnum.DISCHARGE.getValue())
		        || patientMovement.getEncounter().getEncounterType().getId()
		                .equals(EncounterTypeEnum.TRANSFER_TO_OTHER_HEALTH_FACILITY.getValue())
		        || patientMovement.getEncounter().getEncounterType().getId()
		                .equals(EncounterTypeEnum.HOME_AGAINST_MEDICAL_ADVICE.getValue())
		        || patientMovement.getEncounter().getEncounterType().getId().equals(EncounterTypeEnum.ABSCONDED.getValue())
		        || patientMovement.getEncounter().getEncounterType().getId().equals(EncounterTypeEnum.MORTALITY.getValue())
		        || patientMovement.getEncounter().getEncounterType().getId()
		                .equals(EncounterTypeEnum.HOME_PER_REQUEST.getValue())
//		        || patientMovement.getEncounter().getEncounterType().getId()
//		                .equals(EncounterTypeEnum.OUT_ON_PASS.getValue())
		                ) {
			patientCaseRecord.setDatetimeDischarged(new Date());
			//			patientCaseRecordService.savePatientCaseRecord(patientCaseRecord);
		}
		
		Date movementDatetime = (patientMovement.getMovementDatetime() != null ? patientMovement.getMovementDatetime()
		        : new Date());
		patientMovement.setMovementDatetime(movementDatetime);
		patientMovementService.savePatientMovement(patientMovement);
		
		patientCaseRecord.setLatestPatientMovement(patientMovement);
		patientCaseRecordService.savePatientCaseRecord(patientCaseRecord);
		
		request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Patient Movement has been saved!");
		return "redirect:patientMovement.form";
	}
	
	@ModelAttribute("beds")
	public List<Bed> getBeds() {
		KardexHelper kardexHelper = new KardexHelper();
		return kardexHelper.getAvailableBeds();
	}
	
	@ModelAttribute("shifts")
	public static Map<String, String> setupShifts() {
		LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
		options.put("AM", "AM");
		options.put("PM", "PM");
		options.put("Night", "Night");
		return options;
	}
	
	private Encounter setupEncounter(Patient patient, Location location, Visit visit, EncounterType encounterType) {
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Encounter encounter = new Encounter();
		encounter.setPatient(patient);
		encounter.setEncounterDatetime(new Date());
		encounter.setVisit(visit);
		encounter.setEncounterType(encounterType);
		encounter.setChangedBy(currentUser);
		encounter.setCreator(currentUser);
		encounter.setDateChanged(new Date());
		encounter.setDateCreated(new Date());
		encounter.setLocation(location);
		
		Collection<Provider> providers = Context.getProviderService().getProvidersByPerson(currentUser.getPerson(), false);
		Provider currentProvider = null;
		if (providers.size() > 1) {
			throw new IllegalStateException("Can't handle users with multiple provider accounts");
		} else if (providers.size() == 1) {
			currentProvider = providers.iterator().next();
		}
		encounter.addProvider(Context.getEncounterService().getEncounterRole(2), currentProvider);
		encounter = Context.getEncounterService().saveEncounter(encounter);
		return encounter;
	}
}
