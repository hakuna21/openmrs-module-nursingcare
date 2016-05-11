package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.Nurse;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface NurseService extends OpenmrsService {

	@Transactional(readOnly = true)
	List<Nurse> getAllNurses();

	@Transactional(readOnly = true)
	List<Nurse> getNursesByLocation(Integer locationId);

	@Transactional(readOnly = true)
	Nurse getById(Integer id);

	@Transactional(readOnly = true)
	Nurse getByLicenseNumber(String licenseNumber);
	
	@Transactional(readOnly = true)
	Nurse getByProviderId(Integer providerId);

	Nurse saveNurse(Nurse nurse);

	void deleteNurse(Nurse nurse);

}
