package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.Bed;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BedService extends OpenmrsService {

	@Transactional(readOnly = true)
	List<Bed> getAllBeds();

	@Transactional(readOnly = true)
	List<Bed> getOccupiedBeds();
	
	@Transactional(readOnly = true)
	List<Bed> getAvailableBeds();
	
	@Transactional(readOnly = true)
	List<Bed> getAvailableBedsByLocationId(Integer locationId);

	@Transactional(readOnly = true)
	List<Bed> getBedsByLocationId(Integer wardId);

	@Transactional(readOnly = true)
	Bed getBedById(Integer id);

	Bed saveBed(Bed bed);

	void deleteBed(Bed bed);

}
