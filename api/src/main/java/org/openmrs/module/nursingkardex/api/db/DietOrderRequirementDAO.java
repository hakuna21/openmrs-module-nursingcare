package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.DietOrderRequirement;

public interface DietOrderRequirementDAO {
	
	List<DietOrderRequirement> getAllDietOrderRequirements();
	
	List<DietOrderRequirement> getActiveDietOrderRequirements(Integer patientCaseRecordId);
	
	List<DietOrderRequirement> getDietOrderRequirementsByEncounter(Integer encounterId);
	
	DietOrderRequirement getDietOrderRequirementById(Integer id);
	
	DietOrderRequirement saveDietOrderRequirement(DietOrderRequirement dietOrderRequirement);
	
	void deleteDietOrderRequirement(DietOrderRequirement dietOrderRequirement);
	
}
