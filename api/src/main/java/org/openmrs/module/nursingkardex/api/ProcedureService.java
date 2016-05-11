package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.Procedure;
import org.openmrs.module.nursingkardex.util.EnumUtils.ProcedureTypeEnum;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProcedureService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<Procedure> getAllProcedures();
	
	@Transactional(readOnly = true)
	List<Procedure> getAllProceduresByEncounter(Integer encounterId);
	
	@Transactional(readOnly = true)
	List<Procedure> getAllProceduresByPatientCaseRecordId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<Procedure> getProceduresByPatientCaseRecordId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<Procedure> getLaboratoriesByPatientCaseRecordId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<Procedure> getOtherProceduresByPatientCaseRecordId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<Procedure> getProceduresByEncounter(Integer encounterId);
	
	@Transactional(readOnly = true)
	List<Procedure> getLaboratoriesByEncounter(Integer encounterId);
	
	@Transactional(readOnly = true)
	List<Procedure> getOtherProceduresByEncounter(Integer encounterId);
	
	@Transactional(readOnly = true)
	Procedure getProcedureById(Integer id);
	
	Procedure saveProcedure(Procedure procedure);
	
	void deleteProcedure(Procedure procedure);
	
}
