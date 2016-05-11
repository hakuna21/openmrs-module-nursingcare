package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.Nurse;

public interface NurseDAO {
	
	List<Nurse> getAllNurses();
	
	List<Nurse> getNursesByLocation(Integer locationId);
	
	Nurse getById(Integer id);
	
	Nurse getByLicenseNumber(String licenseNumber);
	
	Nurse getByProviderId(Integer providerId);
	
	Nurse saveNurse(Nurse nurse);
	
	void deleteNurse(Nurse nurse);

}
