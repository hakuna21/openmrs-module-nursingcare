package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Provider;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.Physician;
import org.openmrs.module.nursingkardex.api.PhysicianService;
import org.openmrs.module.nursingkardex.api.db.PhysicianDAO;

public class PhysicianServiceImpl extends BaseOpenmrsService implements PhysicianService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	private PhysicianDAO dao;

	public PhysicianDAO getDao() {
		return dao;
	}

	public void setDao(PhysicianDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Physician> getAllPhysicians() {
		return dao.getAllPhysicians();
	}

	@Override
	public Physician getPhysicianById(Integer id) {
		return dao.getPhysicianById(id);
	}

	@Override
	public 	Physician getPhysicianByProviderId(Integer providerId) {
		return dao.getPhysicianByProviderId(providerId);
	}

	@Override
	public Physician getPhysicianByLicenseNumber(String licenseNumber) {
		return dao.getPhysicianByLicenseNumber(licenseNumber);
	}
	
	@Override
	public List<Provider> getUnassignedProviders() {
		return dao.getUnassignedProviders();
	}

	@Override
	public Physician savePhysician(Physician physician) {
		return dao.savePhysician(physician);
	}

	@Override
	public void deletePhysician(Physician physician) {
		dao.deletePhysician(physician);
	}

}
