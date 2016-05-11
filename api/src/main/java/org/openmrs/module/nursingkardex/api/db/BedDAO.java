package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.Bed;

public interface BedDAO {

	List<Bed> getAllBeds();
	
	List<Bed> getOccupiedBeds();
	
	List<Bed> getBedsByLocationId(Integer locationId);
	
	List<Bed> getAvailableBeds();
	
	List<Bed> getAvailableBedsByLocationId(Integer locationId);
	
	Bed getBedById(Integer id);
	
	Bed saveBed(Bed bed);
	
	void deleteBed(Bed bed);
	
}
