package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.ShiftProblem;
import org.openmrs.module.nursingkardex.api.ShiftProblemService;
import org.openmrs.module.nursingkardex.api.db.ShiftProblemDAO;

public class ShiftProblemServiceImpl extends BaseOpenmrsService implements ShiftProblemService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private ShiftProblemDAO dao;
	
	public ShiftProblemDAO getDao() {
		return dao;
	}
	
	public void setDao(ShiftProblemDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<ShiftProblem> getAllShiftProblems() {
		return dao.getAllShiftProblems();
	}
	
	@Override
	public List<ShiftProblem> getShiftProblemsByPatientCaseRecordId(Integer patientCaseRecordId) {
		return dao.getShiftProblemsByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@Override
	public List<ShiftProblem> getActiveShiftProblemsByPatientCaseRecordId(Integer patientCaseRecordId) {
		return dao.getActiveShiftProblemsByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@Override
	public List<ShiftProblem> getShiftProblemsByEncounterId(Integer encounterId) {
		return dao.getShiftProblemsByEncounterId(encounterId);
	}
	
	@Override
	public ShiftProblem getShiftProblemById(Integer id) {
		return dao.getShiftProblemById(id);
	}
	
	@Override
	public ShiftProblem saveShiftProblem(ShiftProblem shiftProblem) {
		return dao.saveShiftProblem(shiftProblem);
	}
	
	@Override
	public void deleteShiftProblem(ShiftProblem shiftProblem) {
		dao.deleteShiftProblem(shiftProblem);
	}
	
}
