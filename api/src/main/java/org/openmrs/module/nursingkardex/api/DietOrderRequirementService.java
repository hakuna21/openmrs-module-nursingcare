package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.DietOrderRequirement;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DietOrderRequirementService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<DietOrderRequirement> getAllDietOrderRequirements();
	
	@Transactional(readOnly = true)
	List<DietOrderRequirement> getActiveDietOrderRequirements();
	
	@Transactional(readOnly = true)
	List<DietOrderRequirement> getActiveDietOrderRequirementsByPatientCaseRecordId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<DietOrderRequirement> getDietOrderRequirementsByEncounter(Integer encounterId);
	
	@Transactional(readOnly = true)
	DietOrderRequirement getDietOrderRequirementById(Integer id);
	
	DietOrderRequirement saveDietOrderRequirement(DietOrderRequirement dietOrderRequirement);
	
	void deleteDietOrderRequirement(DietOrderRequirement dietOrderRequirement);
	
}
