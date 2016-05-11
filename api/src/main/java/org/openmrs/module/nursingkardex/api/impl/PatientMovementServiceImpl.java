package org.openmrs.module.nursingkardex.api.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.PatientMovement;
import org.openmrs.module.nursingkardex.api.PatientMovementService;
import org.openmrs.module.nursingkardex.api.db.PatientMovementDAO;
import org.openmrs.module.nursingkardex.util.EnumUtils.EncounterTypeEnum;

public class PatientMovementServiceImpl extends BaseOpenmrsService implements PatientMovementService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private PatientMovementDAO dao;
	
	public PatientMovementDAO getDao() {
		return dao;
	}
	
	public void setDao(PatientMovementDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<PatientMovement> getAllPatientMovements() {
		return dao.getAllPatientMovements();
	}
	
	@Override
	public List<PatientMovement> getActivePatientMovementsByLocationId(Integer locationId) {
		return dao.getPatientMovements(null, locationId, false, true);
	}
	
	@Override
	public List<PatientMovement> getActivePatientMovementsByEncounterType(Integer encounterTypeId) {
		return dao.getPatientMovements(encounterTypeId, null, false, true);
	}
	
	@Override
	public List<PatientMovement> getActivePatientMovementsByEncounterTypeAndLocation(Integer encounterTypeId,
	                                                                                 Integer locationId) {
		return dao.getPatientMovements(encounterTypeId, locationId, false, true);
	}
	
	@Override
	public List<PatientMovement> getActivePatientMovements() {
		return dao.getPatientMovements(null, null, false, true);
	}
	
	public List<PatientMovement> getActivePatientMovements(Integer encounterTypeId, Integer locationId, boolean forToday) {
		return dao.getPatientMovements(encounterTypeId, locationId, forToday, true);
	}
	
	public List<PatientMovement> getDischargedMovements(Integer dischargedEncounterTypeId, Integer locationId) {
		return dao.getPatientMovements(dischargedEncounterTypeId, locationId, true, true);
	}
	
	@Override
	public List<PatientMovement> getPatientMovementsByPatientCaseRecordId(Integer patientCaseRecordId) {
		return dao.getPatientMovementsByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@Override
	public List<PatientMovement> getPatientMovementsByEncounterId(Integer encounterId) {
		return dao.getPatientMovementsByEncounterId(encounterId);
	}
	
	@Override
	public Long getTotalRoomingInCountByLocation(Integer locationId) {
		return dao.getTotalPatientMovementCountByLocationAndEncounterType(locationId,
		    EncounterTypeEnum.ROOMING_IN.getValue());
	}
	
	@Override
	public PatientMovement getPatientMovementById(Integer id) {
		return dao.getPatientMovementById(id);
	}
	
	@Override
	public PatientMovement savePatientMovement(PatientMovement patientMovement) {
		return dao.savePatientMovement(patientMovement);
	}
	
	@Override
	public void deletePatientMovement(PatientMovement patientMovement) {
		dao.deletePatientMovement(patientMovement);
	}
	
}
