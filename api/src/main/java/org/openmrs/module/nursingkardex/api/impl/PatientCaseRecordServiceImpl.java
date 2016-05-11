package org.openmrs.module.nursingkardex.api.impl;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Provider;
import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.api.NurseService;
import org.openmrs.module.nursingkardex.api.PatientCaseRecordService;
import org.openmrs.module.nursingkardex.api.db.PatientCaseRecordDAO;

public class PatientCaseRecordServiceImpl extends BaseOpenmrsService implements PatientCaseRecordService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private PatientCaseRecordDAO dao;
	
	public PatientCaseRecordDAO getDao() {
		return dao;
	}
	
	public void setDao(PatientCaseRecordDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<PatientCaseRecord> getAllPatientCaseRecords() {
		return dao.getAllPatientCaseRecords();
	}
	
	@Override
	public List<PatientCaseRecord> getActivePatientCaseRecords(Integer locationId) {
		return dao.getActivePatientCaseRecordsByLocationId(locationId);
	}
	
	@Override
	public List<PatientCaseRecord> getClosedPatientCaseRecord(boolean forTodayOnly, Integer locationId) {
		return dao.getClosedPatientCaseRecord(forTodayOnly, locationId);
	}
	
	@Override
	public List<PatientCaseRecord> getPatientCaseRecordsByPatientId(Integer patientId) {
		return dao.getPatientCaseRecordsByPatientId(patientId);
	}
	
	@Override
	public List<PatientCaseRecord> getPatientCaseRecordsByPhysicianInChargeId(Integer physicianId) {
		return dao.getPatientCaseRecordsByPhysicianInChargeId(physicianId);
	}
	
	@Override
	public List<PatientCaseRecord> searchPatientCaseRecords(String name, Integer bedId, Integer departmentId,
	                                                        Integer physicianId, Integer locationId) {
		return dao.searchPatientCaseRecords(name, bedId, departmentId, physicianId, locationId);
	}
	
	@Override
	public Long getTotalPatientCaseRecordCountByLocation(Integer locationId) {
		return dao.getTotalPatientCaseRecordCountByLocation(locationId);
	}
	
	@Override
	public PatientCaseRecord getPatientCaseRecordById(Integer id) {
		return dao.getPatientCaseRecordById(id);
	}
	
	@Override
	public PatientCaseRecord getPatientCaseRecordByBedId(Integer bedId) {
		return dao.getPatientCaseRecordByBedId(bedId);
	}
	
	@Override
	public PatientCaseRecord savePatientCaseRecord(PatientCaseRecord patientCaseRecord) {
		patientCaseRecord = dao.savePatientCaseRecord(patientCaseRecord);
		return patientCaseRecord;
	}
	
	@Override
	public void deletePatientCaseRecord(PatientCaseRecord patientCaseRecord) {
		dao.deletePatientCaseRecord(patientCaseRecord);
	}
	
}
