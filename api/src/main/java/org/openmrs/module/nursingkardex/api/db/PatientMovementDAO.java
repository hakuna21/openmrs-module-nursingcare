package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.PatientMovement;

public interface PatientMovementDAO {
	
	List<PatientMovement> getAllPatientMovements();
	
	List<PatientMovement> getPatientMovementsByPatientCaseRecordId(Integer patientCaseRecordId);
	
	List<PatientMovement> getPatientMovements(Integer encounterTypeId, Integer locationId, boolean forToday,
	                                          boolean activeOnly);
	
	List<PatientMovement> getPatientMovementsByEncounterId(Integer encounterId);
	
	Long getTotalPatientMovementCountByLocationAndEncounterType(Integer locationId, Integer encouterTypeId);
	
	PatientMovement getPatientMovementById(Integer id);
	
	PatientMovement savePatientMovement(PatientMovement patientMovement);
	
	void deletePatientMovement(PatientMovement patientMovement);
	
}
