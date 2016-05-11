package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.api.BedService;
import org.openmrs.module.nursingkardex.api.db.BedDAO;

public class BedServiceImpl extends BaseOpenmrsService implements BedService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	private BedDAO dao;

	public BedDAO getDao() {
		return dao;
	}

	public void setDao(BedDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Bed> getAllBeds() {
		return dao.getAllBeds();
	}

	@Override
	public List<Bed> getOccupiedBeds() {
		return dao.getOccupiedBeds();
	}
	
	@Override
	public List<Bed> getAvailableBeds() {
		return dao.getAvailableBeds();
	}
	
	@Override
	public List<Bed> getAvailableBedsByLocationId(Integer locationId) {
		return dao.getAvailableBedsByLocationId(locationId);
	}

	@Override
	public List<Bed> getBedsByLocationId(Integer locationId) {
		return dao.getBedsByLocationId(locationId);
	}

	@Override
	public Bed getBedById(Integer id) {
		return dao.getBedById(id);
	}

	@Override
	public Bed saveBed(Bed bed) {
		return dao.saveBed(bed);
	}

	@Override
	public void deleteBed(Bed bed) {
		dao.deleteBed(bed);
	}

}
