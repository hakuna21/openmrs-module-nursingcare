package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.PatientCaseRecord;

public interface PatientCaseRecordDAO {
	
	List<PatientCaseRecord> getAllPatientCaseRecords();
	
	List<PatientCaseRecord> getActivePatientCaseRecords();
	
	List<PatientCaseRecord> getActivePatientCaseRecordsByLocationId(Integer locationId);
	
	List<PatientCaseRecord> getClosedPatientCaseRecord(boolean forTodayOnly, Integer locationId);
	
	List<PatientCaseRecord> getPatientCaseRecordsByPatientId(Integer patientId);
	
	List<PatientCaseRecord> getPatientCaseRecordsByPhysicianInChargeId(Integer physicianId);
	
	List<PatientCaseRecord> searchPatientCaseRecords(String name, Integer bedId, Integer departmentId, Integer physicianId,
	                                                 Integer locationId);
	
	PatientCaseRecord getPatientCaseRecordById(Integer id);
	
	PatientCaseRecord getPatientCaseRecordByBedId(Integer bedId);
	
	Long getTotalPatientCaseRecordCountByLocation(Integer locationId);
	
	PatientCaseRecord savePatientCaseRecord(PatientCaseRecord patientCaseRecord);
	
	void deletePatientCaseRecord(PatientCaseRecord patientCaseRecord);
	
}
