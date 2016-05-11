package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.WardAggregate;
import org.openmrs.module.nursingkardex.api.WardAggregateService;
import org.openmrs.module.nursingkardex.api.db.WardAggregateDAO;

public class WardAggregateServiceImpl extends BaseOpenmrsService implements WardAggregateService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private WardAggregateDAO dao;
	
	public WardAggregateDAO getDao() {
		return dao;
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.impl.WardAggregateService#setDao(org.openmrs.module.nursingkardex.api.db.WardAggregateDAO)
	 */
	@Override
    public void setDao(WardAggregateDAO dao) {
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.impl.WardAggregateService#getWardAggregateById(java.lang.Integer)
	 */
	@Override
    public WardAggregate getWardAggregateById(Integer id) {
		return dao.getWardAggregateById(id);
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.impl.WardAggregateService#getWardAggregatesByLocation(java.lang.Integer)
	 */
	@Override
    public List<WardAggregate> getWardAggregatesByLocation(Integer locationId) {
		return dao.getWardAggregatesByLocation(locationId);
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.impl.WardAggregateService#saveWardAggregate(org.openmrs.module.nursingkardex.WardAggregate)
	 */
	@Override
    public WardAggregate saveWardAggregate(WardAggregate wardAggregate) {
		return dao.saveWardAggregate(wardAggregate);
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.impl.WardAggregateService#deleteWardAggregate(org.openmrs.module.nursingkardex.WardAggregate)
	 */
	@Override
    public void deleteWardAggregate(WardAggregate wardAggregate) {
		dao.deleteWardAggregate(wardAggregate);
	}
	
}
