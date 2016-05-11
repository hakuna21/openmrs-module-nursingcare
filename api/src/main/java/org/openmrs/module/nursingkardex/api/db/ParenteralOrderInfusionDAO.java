package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.ParenteralOrderInfusion;

public interface ParenteralOrderInfusionDAO {
	
	List<ParenteralOrderInfusion> getAllParenteralOrderInfusion();
	
	List<ParenteralOrderInfusion> getParenteralOrderInfusionByPatientCaseRecordId(Integer patientCaseRecordId);
	
	List<ParenteralOrderInfusion> getParenteralOrderInfusionByEncounter(Integer encounterId);
	
	ParenteralOrderInfusion getParenteralOrderInfusionById(Integer id);
	
	ParenteralOrderInfusion saveParenteralOrderInfusion(ParenteralOrderInfusion parenteralOrderInfusion);
	
	void deleteParenteralOrderInfusion(ParenteralOrderInfusion parenteralOrderInfusion);
	
}
