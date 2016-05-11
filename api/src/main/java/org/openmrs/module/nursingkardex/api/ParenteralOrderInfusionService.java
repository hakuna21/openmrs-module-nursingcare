package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.ParenteralOrderInfusion;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ParenteralOrderInfusionService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<ParenteralOrderInfusion> getAllParenteralOrderInfusion();
	
	@Transactional(readOnly = true)
	List<ParenteralOrderInfusion> getParenteralOrderInfusionByPatientCaseRecordId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<ParenteralOrderInfusion> getParenteralOrderInfusionByEncounter(Integer encounterId);
	
	@Transactional(readOnly = true)
	ParenteralOrderInfusion getParenteralOrderInfusionById(Integer id);
	
	ParenteralOrderInfusion saveParenteralOrderInfusion(ParenteralOrderInfusion parenteralOrderInfusion);
	
	void deleteParenteralOrderInfusion(ParenteralOrderInfusion parenteralOrderInfusion);
	
}
