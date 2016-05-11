package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.OxygenationOrder;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OxygenationOrderService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<OxygenationOrder> getAllOxygenationOrder();
	
	@Transactional(readOnly = true)
	List<OxygenationOrder> getOxygenationOrdersByPatientCaseRecordId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<OxygenationOrder> getOxygenationOrdersByEncounter(Integer encounterId);
	
	@Transactional(readOnly = true)
	OxygenationOrder getOxygenationOrderById(Integer id);
	
	OxygenationOrder saveOxygenationOrder(OxygenationOrder oxygenationOrder);
	
	void deleteOxygenationOrder(OxygenationOrder oxygenationOrder);
	
}
