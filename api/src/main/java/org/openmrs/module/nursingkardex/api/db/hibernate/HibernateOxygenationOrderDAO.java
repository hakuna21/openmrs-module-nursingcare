package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.OxygenationOrder;
import org.openmrs.module.nursingkardex.api.db.OxygenationOrderDAO;

public class HibernateOxygenationOrderDAO implements OxygenationOrderDAO {
	
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
	public List<OxygenationOrder> getAllOxygenationOrder() {
		return sessionFactory.getCurrentSession().createCriteria(OxygenationOrder.class).list();
	}
	
	@Override
	public List<OxygenationOrder> getOxygenationOrdersByPatientCaseRecordId(Integer patientCaseRecordId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(OxygenationOrder.class);
		cr.createCriteria("patientCaseRecord").add(Restrictions.eq("id", patientCaseRecordId));
		return cr.list();
	}
	
	@Override
	public List<OxygenationOrder> getOxygenationOrderByEncounters(Integer encounterId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(OxygenationOrder.class);
		cr.createCriteria("encounter").add(Restrictions.eq("encounterId", encounterId));
		return cr.list();
	}
	
	@Override
	public OxygenationOrder getOxygenationOrderById(Integer id) {
		return (OxygenationOrder) sessionFactory.getCurrentSession().get(OxygenationOrder.class, id);
	}
	
	@Override
	public OxygenationOrder saveOxygenationOrder(OxygenationOrder oxygenationOrder) {
		if (oxygenationOrder.getId() != null) {
			sessionFactory.getCurrentSession().merge(oxygenationOrder);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(oxygenationOrder);
			oxygenationOrder = getOxygenationOrderById(id);
		}
		return oxygenationOrder;
	}
	
	@Override
	public void deleteOxygenationOrder(OxygenationOrder oxygenationOrder) {
		sessionFactory.getCurrentSession().delete(oxygenationOrder);
	}
	
}
