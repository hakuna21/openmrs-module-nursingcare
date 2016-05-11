package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.DietOrderRequirement;
import org.openmrs.module.nursingkardex.api.DietOrderRequirementService;
import org.openmrs.module.nursingkardex.api.db.DietOrderRequirementDAO;

public class DietOrderRequirementServiceImpl extends BaseOpenmrsService implements DietOrderRequirementService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private DietOrderRequirementDAO dao;
	
	public DietOrderRequirementDAO getDao() {
		return dao;
	}
	
	public void setDao(DietOrderRequirementDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<DietOrderRequirement> getAllDietOrderRequirements() {
		return dao.getAllDietOrderRequirements();
	}
	
	@Override
	public List<DietOrderRequirement> getActiveDietOrderRequirements() {
		return dao.getActiveDietOrderRequirements(null);
	}
	
	@Override
	public List<DietOrderRequirement> getActiveDietOrderRequirementsByPatientCaseRecordId(Integer patientCaseRecordId) {
		return dao.getActiveDietOrderRequirements(patientCaseRecordId);
	}
	
	@Override
	public List<DietOrderRequirement> getDietOrderRequirementsByEncounter(Integer encounterId) {
		return dao.getDietOrderRequirementsByEncounter(encounterId);
	}
	
	@Override
	public DietOrderRequirement getDietOrderRequirementById(Integer id) {
		return dao.getDietOrderRequirementById(id);
	}
	
	@Override
	public DietOrderRequirement saveDietOrderRequirement(DietOrderRequirement dietOrderRequirement) {
		return dao.saveDietOrderRequirement(dietOrderRequirement);
	}
	
	@Override
	public void deleteDietOrderRequirement(DietOrderRequirement dietOrderRequirement) {
		dao.deleteDietOrderRequirement(dietOrderRequirement);
	}
	
}
