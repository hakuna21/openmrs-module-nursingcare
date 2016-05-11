package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.Provider;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.Physician;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PhysicianService extends OpenmrsService {

	@Transactional(readOnly = true)
	List<Physician> getAllPhysicians();

	@Transactional(readOnly = true)
	Physician getPhysicianById(Integer id);

	@Transactional(readOnly = true)
	Physician getPhysicianByLicenseNumber(String licenseNumber);

	@Transactional(readOnly = true)
	Physician getPhysicianByProviderId(Integer providerId);
	
	List<Provider> getUnassignedProviders();

	Physician savePhysician(Physician physician);

	void deletePhysician(Physician physician);

}
