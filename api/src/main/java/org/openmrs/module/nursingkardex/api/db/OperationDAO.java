package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.Operation;

public interface OperationDAO {
	
	List<Operation> getAllOperations();
	
	List<Operation> getOperationsByPatientCaseRecordId(Integer patientCaseRecordId);
	
	List<Operation> getOperationsByEncounter(Integer encounterId);
	
	Operation getOperationById(Integer id);
	
	Operation saveOperation(Operation operation);
	
	void deleteOperation(Operation operation);
	
}
