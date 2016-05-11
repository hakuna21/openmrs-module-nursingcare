package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.Operation;
import org.openmrs.module.nursingkardex.api.OperationService;
import org.openmrs.module.nursingkardex.api.db.OperationDAO;

public class OperationServiceImpl extends BaseOpenmrsService implements OperationService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private OperationDAO dao;
	
	public OperationDAO getDao() {
		return dao;
	}
	
	public void setDao(OperationDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Operation> getAllOperations() {
		return dao.getAllOperations();
	}
	
	@Override
	public List<Operation> getOperationsByPatientCaseRecordId(Integer patientCaseRecordId) {
		return dao.getOperationsByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@Override
	public List<Operation> getOperationsByEncounter(Integer encounterId) {
		return dao.getOperationsByEncounter(encounterId);
	}
	
	@Override
	public Operation getOperationById(Integer id) {
		return dao.getOperationById(id);
	}
	
	@Override
	public Operation saveOperation(Operation operation) {
		return dao.saveOperation(operation);
	}
	
	@Override
	public void deleteOperation(Operation operation) {
		dao.deleteOperation(operation);
	}
	
}
