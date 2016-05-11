package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.Operation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OperationService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<Operation> getAllOperations();
	
	@Transactional(readOnly = true)
	List<Operation> getOperationsByPatientCaseRecordId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<Operation> getOperationsByEncounter(Integer encounterId);
	
	@Transactional(readOnly = true)
	Operation getOperationById(Integer id);
	
	Operation saveOperation(Operation operation);
	
	void deleteOperation(Operation operation);
	
}
