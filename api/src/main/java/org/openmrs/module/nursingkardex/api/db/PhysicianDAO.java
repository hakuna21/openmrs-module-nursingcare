package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.Provider;
import org.openmrs.module.nursingkardex.Physician;

public interface PhysicianDAO {
	
	List<Physician> getAllPhysicians();
	
	Physician getPhysicianById(Integer id);
	
	Physician getPhysicianByLicenseNumber(String licenseNumber);
	
	Physician getPhysicianByProviderId(Integer providerId);
	
	List<Provider> getUnassignedProviders();
	
	Physician savePhysician(Physician physician);
	
	void deletePhysician(Physician physician);

}
