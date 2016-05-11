package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.ShiftProblem;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ShiftProblemService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<ShiftProblem> getAllShiftProblems();
	
	@Transactional(readOnly = true)
	List<ShiftProblem> getShiftProblemsByPatientCaseRecordId(Integer patientCaseRecordId);
	
	@Transactional
	List<ShiftProblem> getActiveShiftProblemsByPatientCaseRecordId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<ShiftProblem> getShiftProblemsByEncounterId(Integer encounterId);
	
	@Transactional(readOnly = true)
	ShiftProblem getShiftProblemById(Integer id);
	
	ShiftProblem saveShiftProblem(ShiftProblem shiftProblem);
	
	void deleteShiftProblem(ShiftProblem shiftProblem);
	
}
