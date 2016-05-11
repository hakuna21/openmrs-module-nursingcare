package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.ShiftProblem;

public interface ShiftProblemDAO {
	
	List<ShiftProblem> getAllShiftProblems();
	
	List<ShiftProblem> getShiftProblemsByPatientCaseRecordId(Integer patientCaseRecordId);
	
	List<ShiftProblem> getActiveShiftProblemsByPatientCaseRecordId(Integer patientCaseRecordId);
	
	List<ShiftProblem> getShiftProblemsByEncounterId(Integer encounterId);
	
	ShiftProblem getShiftProblemById(Integer id);
	
	ShiftProblem saveShiftProblem(ShiftProblem shiftProblem);
	
	void deleteShiftProblem(ShiftProblem shiftProblem);
	
}
