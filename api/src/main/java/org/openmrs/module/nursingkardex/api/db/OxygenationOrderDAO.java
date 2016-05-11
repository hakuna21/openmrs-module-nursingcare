package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.OxygenationOrder;

public interface OxygenationOrderDAO {
	
	List<OxygenationOrder> getAllOxygenationOrder();
	
	List<OxygenationOrder> getOxygenationOrdersByPatientCaseRecordId(Integer patientCaseRecordId);
	
	List<OxygenationOrder> getOxygenationOrderByEncounters(Integer encounterId);
	
	OxygenationOrder getOxygenationOrderById(Integer id);
	
	OxygenationOrder saveOxygenationOrder(OxygenationOrder oxygenationOrder);
	
	void deleteOxygenationOrder(OxygenationOrder oxygenationOrder);
	
}
