package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.openmrs.module.nursingkardex.ParenteralOrderType;
import org.openmrs.module.nursingkardex.api.db.ParenteralOrderTypeDAO;

public class HibernateParenteralOrderTypeDAO implements ParenteralOrderTypeDAO {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Override
	public List<ParenteralOrderType> getAllParentalOrderTypes() {
		return sessionFactory.getCurrentSession().createCriteria(ParenteralOrderType.class).list();
	}
	
	@Override
	public ParenteralOrderType getParenteralOrderTypeById(Integer id) {
		return (ParenteralOrderType) sessionFactory.getCurrentSession().get(ParenteralOrderType.class, id);
	}
	
}
