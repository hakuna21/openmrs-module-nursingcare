package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.LevelOfCare;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LevelOfCareService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<LevelOfCare> getAllLevelOfCares();
	
	@Transactional(readOnly = true)
	List<LevelOfCare> getLevelOfCaresByPatientCaseRecordId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<LevelOfCare> getLevelOfCaresByEncounter(Integer encounterId);
	
	@Transactional(readOnly = true)
	List<LevelOfCare> getLevelOfCaresByLevel(Integer level);
	
	@Transactional(readOnly = true)
	LevelOfCare getLevelOfCareById(Integer id);
	
	LevelOfCare saveLevelOfCare(LevelOfCare levelOfCare);
	
	void deleteLevelofCare(LevelOfCare levelOfCare);
}
