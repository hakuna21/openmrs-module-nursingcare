package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.api.db.NurseDAO;

public class HibernateNurseDAO implements NurseDAO {

	protected final Log log = LogFactory.getLog(this.getClass());
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
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
	public List<Nurse> getAllNurses() {
		return sessionFactory.getCurrentSession().createCriteria(Nurse.class)
				.list();
	}

	@Override
	public List<Nurse> getNursesByLocation(Integer locationId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Nurse.class);
		cr.createCriteria("location").add(
				Restrictions.eq("locationId", locationId));
		return null;
	}

	@Override
	public Nurse getById(Integer id) {
		return (Nurse) sessionFactory.getCurrentSession().get(Nurse.class, id);
	}

	@Override
	public Nurse getByLicenseNumber(String licenseNumber) {
		Nurse nurse = null;
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Nurse.class);
		cr.add(Restrictions.eq("licenseNumber", licenseNumber));
		List results = cr.list();
		if (results != null && !results.isEmpty()) {
			nurse = (Nurse) results.get(0);
		}
		return nurse;
	}
	
	@Override
	public Nurse getByProviderId(Integer providerId) {
		Nurse nurse = null;
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Nurse.class);
		cr.createCriteria("provider").add(Restrictions.eq("providerId", providerId));
		List results = cr.list();
		if (results != null && !results.isEmpty()) {
			nurse = (Nurse) results.get(0);
		}
		return nurse;
	}

	@Override
	public Nurse saveNurse(Nurse nurse) {
		if (nurse.getId() != null) {
			sessionFactory.getCurrentSession().merge(nurse);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(
					nurse);
			nurse = getById(id);
		}
		return nurse;
	}

	@Override
	public void deleteNurse(Nurse nurse) {
		sessionFactory.getCurrentSession().delete(nurse);
	}

}
