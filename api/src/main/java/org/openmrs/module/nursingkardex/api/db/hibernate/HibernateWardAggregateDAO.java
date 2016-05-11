package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.WardAggregate;
import org.openmrs.module.nursingkardex.api.db.WardAggregateDAO;

public class HibernateWardAggregateDAO implements WardAggregateDAO {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.db.hibernate.WardAggregateDAO#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.db.hibernate.WardAggregateDAO#getWardAggregateById(java.lang.Integer)
	 */
	@Override
    public WardAggregate getWardAggregateById(Integer id) {
		return (WardAggregate) sessionFactory.getCurrentSession().get(WardAggregate.class, id);
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.db.hibernate.WardAggregateDAO#getWardAggregatesByLocation(java.lang.Integer)
	 */
	@Override
    public List<WardAggregate> getWardAggregatesByLocation(Integer locationId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(WardAggregate.class);
		cr.createCriteria("location").add(Restrictions.eq("id", locationId));
		return cr.list();
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.db.hibernate.WardAggregateDAO#saveWardAggregate(org.openmrs.module.nursingkardex.WardAggregate)
	 */
	@Override
    public WardAggregate saveWardAggregate(WardAggregate wardAggregate) {
		if (wardAggregate.getId() != null) {
			sessionFactory.getCurrentSession().merge(wardAggregate);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(wardAggregate);
			wardAggregate = getWardAggregateById(id);
		}
 		return wardAggregate;
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.db.hibernate.WardAggregateDAO#deleteWardAggregate(org.openmrs.module.nursingkardex.WardAggregate)
	 */
	@Override
    public void deleteWardAggregate(WardAggregate wardAggregate) {
		sessionFactory.getCurrentSession().delete(wardAggregate);
	}
	
}
