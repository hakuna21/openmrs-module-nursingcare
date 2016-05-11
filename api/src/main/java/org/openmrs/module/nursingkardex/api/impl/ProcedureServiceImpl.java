package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.Procedure;
import org.openmrs.module.nursingkardex.api.ProcedureService;
import org.openmrs.module.nursingkardex.api.db.ProcedureDAO;
import org.openmrs.module.nursingkardex.util.EnumUtils.ProcedureTypeEnum;

public class ProcedureServiceImpl extends BaseOpenmrsService implements ProcedureService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private ProcedureDAO dao;
	
	public ProcedureDAO getDao() {
		return dao;
	}
	
	public void setDao(ProcedureDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Procedure> getAllProcedures() {
		return dao.getAllProcedures();
	}
	
	@Override
	public List<Procedure> getAllProceduresByPatientCaseRecordId(Integer patientCaseRecordId) {
		return dao.getProceduresByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@Override
	public List<Procedure> getProceduresByPatientCaseRecordId(Integer patientCaseRecordId) {
		return dao.getProceduresByPatientCaseRecordAndType(patientCaseRecordId, ProcedureTypeEnum.PROCEDURE.getValue());
	}
	
	@Override
	public List<Procedure> getLaboratoriesByPatientCaseRecordId(Integer patientCaseRecordId) {
		return dao.getProceduresByPatientCaseRecordAndType(patientCaseRecordId, ProcedureTypeEnum.LABORATORY.getValue());
	}
	
	@Override
	public List<Procedure> getOtherProceduresByPatientCaseRecordId(Integer patientCaseRecordId) {
		return dao.getProceduresByPatientCaseRecordAndType(patientCaseRecordId, ProcedureTypeEnum.OTHERS.getValue());
	}
	
	@Override
	public List<Procedure> getAllProceduresByEncounter(Integer encounterId) {
		return dao.getProceduresByEncounter(encounterId);
	}
	
	@Override
	public List<Procedure> getProceduresByEncounter(Integer encounterId) {
		return dao.getProceduresByEncounterAndType(encounterId, ProcedureTypeEnum.PROCEDURE.getValue());
	}
	
	@Override
	public List<Procedure> getLaboratoriesByEncounter(Integer encounterId) {
		return dao.getProceduresByEncounterAndType(encounterId, ProcedureTypeEnum.LABORATORY.getValue());
	}
	
	@Override
	public List<Procedure> getOtherProceduresByEncounter(Integer encounterId) {
		return dao.getProceduresByEncounterAndType(encounterId, ProcedureTypeEnum.OTHERS.getValue());
	}
	
	@Override
	public Procedure getProcedureById(Integer id) {
		return dao.getProcedureById(id);
	}
	
	@Override
	public Procedure saveProcedure(Procedure procedure) {
		return dao.saveProcedure(procedure);
	}
	
	@Override
	public void deleteProcedure(Procedure procedure) {
		dao.deleteProcedure(procedure);
	}
	
}
