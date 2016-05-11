package org.openmrs.module.nursingkardex.web.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Provider;
import org.openmrs.User;
import org.openmrs.Visit;
import org.openmrs.api.PatientService;
import org.openmrs.api.context.Context;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.PatientMovement;
import org.openmrs.module.nursingkardex.Physician;
import org.openmrs.module.nursingkardex.api.BedService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.api.PatientMovementService;
import org.openmrs.module.nursingkardex.api.PhysicianService;
import org.openmrs.module.nursingkardex.util.EnumUtils.EncounterTypeEnum;
import org.openmrs.module.nursingkardex.web.controller.KardexHelper;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdmissionFormController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/module/nursingkardex/admission", method = RequestMethod.GET)
	public void showForm() {
		
	}
	
	@RequestMapping(value = "/module/nursingkardex/admission", method = RequestMethod.POST)
	public String admitPatient(@ModelAttribute("patientCaseRecord") PatientCaseRecord patientCaseRecord, BindingResult errors) {
		
		PatientCaseRecordService patientCaseRecordService = Context.getService(PatientCaseRecordService.class);
		PatientMovementService patientMovementService = Context.getService(PatientMovementService.class);
		BedService bedService = Context.getService(BedService.class);
		
		if (!Context.isAuthenticated()) {
			errors.reject("nursingkardex.auth.required");
		} else {
			PatientMovement admissionMovement = patientCaseRecord.getLatestPatientMovement();
			Bed bed = bedService.getBedById(admissionMovement.getBed().getId());
			
			patientCaseRecord.setLatestPatientMovement(null);
			patientCaseRecord = patientCaseRecordService.savePatientCaseRecord(patientCaseRecord);
			
			// setup Visit
			Visit visit = setupAdmissionVisit(patientCaseRecord.getPatient(), bed.getLocation());
			
			// setup encounter
			Encounter encounter = setupAdmissionEncounter(patientCaseRecord.getPatient(), bed.getLocation(), visit);
			
			// setup patient movement
			admissionMovement.setPatientCaseRecord(patientCaseRecord);
			admissionMovement.setEncounter(encounter);
			admissionMovement.setMovementDatetime(new Date());
			admissionMovement = patientMovementService.savePatientMovement(admissionMovement);
			patientCaseRecord.setLatestPatientMovement(admissionMovement);
			patientCaseRecord = patientCaseRecordService.savePatientCaseRecord(patientCaseRecord);
			
			// set the chosen bed as occupied
			bed.setIsOccupied(1);
			bedService.saveBed(bed);
		}
		
		return "redirect:viewKardex.page?patientCaseRecordId=" + patientCaseRecord.getId();
	}
	
	@ModelAttribute("patientCaseRecord")
	public PatientCaseRecord getPatientCaseRecord(@RequestParam(required = false, value = "patientId") Integer patientId,
	                                              ModelMap model) {
		
		PatientService ps = Context.getPatientService();
		PatientCaseRecord patientCaseRecord = null;
		
		try {
			if (patientId != null) {
				Patient patient = ps.getPatient(patientId);
				patientCaseRecord = new PatientCaseRecord();
				patientCaseRecord.setPatient(patient);
				patientCaseRecord.setDatetimeAdmitted(new Date());
				
				PatientMovement initialPayPatientMovement = new PatientMovement();
				patientCaseRecord.setLatestPatientMovement(initialPayPatientMovement);
				initialPayPatientMovement.setPatientCaseRecord(patientCaseRecord);
			}
		}
		catch (ObjectRetrievalFailureException noPatientEx) {
			log.warn("There is no patient with id: '" + patientId + "'", noPatientEx);
		}
		
		model.addAttribute("patientId", patientId);
		
		return patientCaseRecord;
	}
	
	private Visit setupAdmissionVisit(Patient patient, Location location) {
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Visit visit = new Visit();
		visit.setPatient(patient);
		visit.setVisitType(Context.getVisitService().getVisitType(1));
		visit.setChangedBy(currentUser);
		visit.setCreator(currentUser);
		visit.setDateChanged(new Date());
		visit.setDateCreated(new Date());
		visit.setLocation(location);
		visit.setStartDatetime(new Date());
		visit = Context.getVisitService().saveVisit(visit);
		return visit;
	}
	
	private Encounter setupAdmissionEncounter(Patient patient, Location location, Visit visit) {
		User currentUser = Context.getUserContext().getAuthenticatedUser();
		Encounter encounter = new Encounter();
		encounter.setPatient(patient);
		encounter.setEncounterDatetime(new Date());
		encounter.setVisit(visit);
		encounter.setEncounterType(Context.getEncounterService().getEncounterType(EncounterTypeEnum.ADMISSION.getValue())); // admission
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
	
	@ModelAttribute("beds")
	public List<Bed> getAvailableBeds() {
		KardexHelper kardexHelper = new KardexHelper();
		return kardexHelper.getAvailableBeds();
	}
	
	@ModelAttribute("physicians")
	public List<Physician> getPhysicians() {
		PhysicianService physicianService = Context.getService(PhysicianService.class);
		return physicianService.getAllPhysicians();
	}
	
}
