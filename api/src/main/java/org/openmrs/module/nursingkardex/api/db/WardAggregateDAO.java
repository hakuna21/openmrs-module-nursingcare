package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.hibernate.SessionFactory;
import org.openmrs.module.nursingkardex.WardAggregate;

public interface WardAggregateDAO {
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	void setSessionFactory(SessionFactory sessionFactory);
	
	WardAggregate getWardAggregateById(Integer id);
	
	List<WardAggregate> getWardAggregatesByLocation(Integer locationId);
	
	WardAggregate saveWardAggregate(WardAggregate wardAggregate);
	
	void deleteWardAggregate(WardAggregate wardAggregate);
	
}
