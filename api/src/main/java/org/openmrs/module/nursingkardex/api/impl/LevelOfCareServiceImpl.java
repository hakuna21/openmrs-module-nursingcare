package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.LevelOfCare;
import org.openmrs.module.nursingkardex.api.LevelOfCareService;
import org.openmrs.module.nursingkardex.api.db.LevelOfCareDAO;

public class LevelOfCareServiceImpl extends BaseOpenmrsService implements LevelOfCareService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private LevelOfCareDAO dao;
	
	public LevelOfCareDAO getDao() {
		return dao;
	}
	
	public void setDao(LevelOfCareDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<LevelOfCare> getAllLevelOfCares() {
		return dao.getAllLevelOfCares();
	}
	
	@Override
	public List<LevelOfCare> getLevelOfCaresByPatientCaseRecordId(Integer patientCaseRecordId) {
		return dao.getLevelOfCaresByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@Override
	public List<LevelOfCare> getLevelOfCaresByEncounter(Integer encounterId) {
		return dao.getLevelOfCaresByEncounter(encounterId);
	}
	
	@Override
	public List<LevelOfCare> getLevelOfCaresByLevel(Integer level) {
		return dao.getLevelOfCaresByLevel(level);
	}
	
	@Override
	public LevelOfCare getLevelOfCareById(Integer id) {
		return dao.getLevelOfCareById(id);
	}
	
	@Override
	public LevelOfCare saveLevelOfCare(LevelOfCare levelOfCare) {
		return dao.saveLevelOfCare(levelOfCare);
	}
	
	@Override
	public void deleteLevelofCare(LevelOfCare levelOfCare) {
		dao.deleteLevelofCare(levelOfCare);
	}
	
}
