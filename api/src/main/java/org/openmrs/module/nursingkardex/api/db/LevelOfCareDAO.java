package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.LevelOfCare;


public interface LevelOfCareDAO {
	
	List<LevelOfCare> getAllLevelOfCares();
	
	List<LevelOfCare> getLevelOfCaresByPatientCaseRecordId(Integer patientCaseRecordId);
	
	List<LevelOfCare> getLevelOfCaresByEncounter(Integer encounterId);
	
	List<LevelOfCare> getLevelOfCaresByLevel(Integer level);
	
	LevelOfCare getLevelOfCareById(Integer id);
	
	LevelOfCare saveLevelOfCare(LevelOfCare levelOfCare);
	
	void deleteLevelofCare(LevelOfCare levelOfCare);
	
}
