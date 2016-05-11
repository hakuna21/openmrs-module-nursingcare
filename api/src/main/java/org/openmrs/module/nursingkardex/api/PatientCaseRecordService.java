package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PatientCaseRecordService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<PatientCaseRecord> getAllPatientCaseRecords();
	
	@Transactional(readOnly = true)
	List<PatientCaseRecord> getActivePatientCaseRecords(Integer locationId);
	
	@Transactional(readOnly = true)
	List<PatientCaseRecord> getClosedPatientCaseRecord(boolean forTodayOnly, Integer locationId);
	
	@Transactional(readOnly = true)
	List<PatientCaseRecord> getPatientCaseRecordsByPatientId(Integer patientId);

	@Transactional(readOnly = true)
	List<PatientCaseRecord> getPatientCaseRecordsByPhysicianInChargeId(Integer physicianId);
	
	@Transactional(readOnly = true)
	List<PatientCaseRecord> searchPatientCaseRecords(String name, Integer bedId, Integer departmentId, Integer physicianId,
	                                                 Integer locationId);
	
	@Transactional(readOnly = true)
	Long getTotalPatientCaseRecordCountByLocation(Integer locationId);
	
	@Transactional(readOnly = true)
	PatientCaseRecord getPatientCaseRecordById(Integer id);
	
	@Transactional(readOnly = true)
	PatientCaseRecord getPatientCaseRecordByBedId(Integer bedId);
	
	PatientCaseRecord savePatientCaseRecord(PatientCaseRecord patientCaseRecord);
	
	void deletePatientCaseRecord(PatientCaseRecord patientCaseRecord);
	
}
