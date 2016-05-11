package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.ParenteralOrderInfusion;
import org.openmrs.module.nursingkardex.api.ParenteralOrderInfusionService;
import org.openmrs.module.nursingkardex.api.db.ParenteralOrderInfusionDAO;

public class ParenteralOrderInfusionServiceImpl extends BaseOpenmrsService implements ParenteralOrderInfusionService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private ParenteralOrderInfusionDAO dao;
	
	public ParenteralOrderInfusionDAO getDao() {
		return dao;
	}
	
	public void setDao(ParenteralOrderInfusionDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<ParenteralOrderInfusion> getAllParenteralOrderInfusion() {
		return dao.getAllParenteralOrderInfusion();
	}
	
	@Override
	public List<ParenteralOrderInfusion> getParenteralOrderInfusionByPatientCaseRecordId(Integer patientCaseRecordId) {
		return dao.getParenteralOrderInfusionByPatientCaseRecordId(patientCaseRecordId);
	}
	
	@Override
	public List<ParenteralOrderInfusion> getParenteralOrderInfusionByEncounter(Integer encounterId) {
		return dao.getParenteralOrderInfusionByEncounter(encounterId);
	}
	
	@Override
	public ParenteralOrderInfusion getParenteralOrderInfusionById(Integer id) {
		return dao.getParenteralOrderInfusionById(id);
	}
	
	@Override
	public ParenteralOrderInfusion saveParenteralOrderInfusion(ParenteralOrderInfusion parenteralOrderInfusion) {
		return dao.saveParenteralOrderInfusion(parenteralOrderInfusion);
	}
	
	@Override
	public void deleteParenteralOrderInfusion(ParenteralOrderInfusion parenteralOrderInfusion) {
		dao.deleteParenteralOrderInfusion(parenteralOrderInfusion);
	}
	
}
