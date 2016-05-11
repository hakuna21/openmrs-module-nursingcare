package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.ParenteralOrderInfusion;
import org.openmrs.module.nursingkardex.api.db.ParenteralOrderInfusionDAO;

public class HibernateParenteralOrderInfusionDAO implements ParenteralOrderInfusionDAO {
	
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
	public List<ParenteralOrderInfusion> getAllParenteralOrderInfusion() {
		return sessionFactory.getCurrentSession().createCriteria(ParenteralOrderInfusion.class).list();
	}
	
	@Override
	public List<ParenteralOrderInfusion> getParenteralOrderInfusionByPatientCaseRecordId(Integer patientCaseRecordId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(ParenteralOrderInfusion.class);
		cr.createCriteria("patientCaseRecord").add(Restrictions.eq("id", patientCaseRecordId));
		return cr.list();
	}
	
	@Override
	public List<ParenteralOrderInfusion> getParenteralOrderInfusionByEncounter(Integer encounterId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(ParenteralOrderInfusion.class);
		cr.createCriteria("encounter").add(Restrictions.eq("encounterId", encounterId));
		return cr.list();
	}
	
	@Override
	public ParenteralOrderInfusion getParenteralOrderInfusionById(Integer id) {
		return (ParenteralOrderInfusion) sessionFactory.getCurrentSession().get(ParenteralOrderInfusion.class, id);
	}
	
	@Override
	public ParenteralOrderInfusion saveParenteralOrderInfusion(ParenteralOrderInfusion parenteralOrderInfusion) {
		if (parenteralOrderInfusion.getId() != null) {
			sessionFactory.getCurrentSession().merge(parenteralOrderInfusion);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(parenteralOrderInfusion);
			parenteralOrderInfusion = getParenteralOrderInfusionById(id);
		}
		return parenteralOrderInfusion;
	}
	
	@Override
	public void deleteParenteralOrderInfusion(ParenteralOrderInfusion parenteralOrderInfusion) {
		sessionFactory.getCurrentSession().delete(parenteralOrderInfusion);
	}
	
}
