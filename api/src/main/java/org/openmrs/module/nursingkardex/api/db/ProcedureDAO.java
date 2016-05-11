package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.Procedure;

public interface ProcedureDAO {
	
	List<Procedure> getAllProcedures();
	
	List<Procedure> getProceduresByPatientCaseRecordId(Integer patientCaseRecordId);
	
	List<Procedure> getProceduresByPatientCaseRecordAndType(Integer patientCaseRecordId, String type);
	
	List<Procedure> getProceduresByEncounter(Integer encounterId);
	
	List<Procedure> getProceduresByEncounterAndType(Integer encounterId, String type);
	
	Procedure getProcedureById(Integer id);
	
	Procedure saveProcedure(Procedure procedure);
	
	void deleteProcedure(Procedure procedure);
}
