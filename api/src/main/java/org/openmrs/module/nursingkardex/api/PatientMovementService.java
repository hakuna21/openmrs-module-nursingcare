package org.openmrs.module.nursingkardex.api;

import java.util.Date;
import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.PatientMovement;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PatientMovementService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<PatientMovement> getAllPatientMovements();
	
	@Transactional(readOnly = true)
	List<PatientMovement> getActivePatientMovementsByLocationId(Integer locationId);
	
	@Transactional(readOnly = true)
	List<PatientMovement> getActivePatientMovementsByEncounterType(Integer encounterTypeId);
	
	@Transactional(readOnly = true)
	List<PatientMovement> getActivePatientMovementsByEncounterTypeAndLocation(Integer encounterTypeId, Integer locationId);
	
	@Transactional(readOnly = true)
	List<PatientMovement> getActivePatientMovements();
	
	@Transactional(readOnly = true)
	List<PatientMovement> getActivePatientMovements(Integer encounterTypeId, Integer locationId, boolean forToday);
	
	@Transactional(readOnly = true)
	List<PatientMovement> getDischargedMovements(Integer dischargedEncounterTypeId, Integer locationId);
	
	@Transactional(readOnly = true)
	List<PatientMovement> getPatientMovementsByPatientCaseRecordId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<PatientMovement> getPatientMovementsByEncounterId(Integer encounterId);
	
	@Transactional(readOnly = true)
	Long getTotalRoomingInCountByLocation(Integer locationId);
	
	@Transactional(readOnly = true)
	PatientMovement getPatientMovementById(Integer id);
	
	PatientMovement savePatientMovement(PatientMovement patientMovement);
	
	void deletePatientMovement(PatientMovement patientMovement);
	
}
