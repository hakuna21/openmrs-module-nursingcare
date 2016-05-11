package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.ParenteralOrderType;
import org.openmrs.module.nursingkardex.api.ParenteralOrderTypeService;
import org.openmrs.module.nursingkardex.api.db.ParenteralOrderTypeDAO;

public class ParenteralOrderTypeServiceImpl extends BaseOpenmrsService implements ParenteralOrderTypeService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private ParenteralOrderTypeDAO dao;
	
	public ParenteralOrderTypeDAO getDao() {
		return dao;
	}
	
	public void setDao(ParenteralOrderTypeDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<ParenteralOrderType> getAllParentalOrderTypes() {
		return dao.getAllParentalOrderTypes();
	}
	
	@Override
	public ParenteralOrderType getParenteralOrderTypeById(Integer id) {
		return dao.getParenteralOrderTypeById(id);
	}
	
}
