package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.api.NurseService;
import org.openmrs.module.nursingkardex.api.db.NurseDAO;

public class NurseServiceImpl extends BaseOpenmrsService implements NurseService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private NurseDAO dao;
	
	public NurseDAO getDao() {
		return dao;
	}
	
	public void setDao(NurseDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Nurse> getAllNurses() {
		return dao.getAllNurses();
	}
	
	@Override
	public List<Nurse> getNursesByLocation(Integer locationId) {
		return dao.getNursesByLocation(locationId);
	}
	
	@Override
	public Nurse getById(Integer id) {
		return dao.getById(id);
	}
	
	@Override
	public Nurse getByLicenseNumber(String licenseNumber) {
		return dao.getByLicenseNumber(licenseNumber);
	}
	
	@Override
	public Nurse getByProviderId(Integer providerId) {
		return dao.getByProviderId(providerId);
	}
	
	@Override
	public Nurse saveNurse(Nurse nurse) {
		return dao.saveNurse(nurse);
	}
	
	@Override
	public void deleteNurse(Nurse nurse) {
		dao.deleteNurse(nurse);
	}
	
}
