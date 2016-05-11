package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Provider;
import org.openmrs.module.nursingkardex.Nurse;
import org.openmrs.module.nursingkardex.Physician;
import org.openmrs.module.nursingkardex.api.NurseService;
import org.openmrs.module.nursingkardex.api.PhysicianService;
import org.openmrs.module.nursingkardex.api.db.PhysicianDAO;
import org.openmrs.User;
import org.openmrs.Person;

public class HibernatePhysicianDAO implements PhysicianDAO {

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
	public List<Physician> getAllPhysicians() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Physician.class).list();
	}

	@Override
	public Physician getPhysicianById(Integer id) {
		return (Physician) sessionFactory.getCurrentSession().get(
				Physician.class, id);

	}

	@Override
	public Physician getPhysicianByLicenseNumber(String licenseNumber) {
		Physician physician = null;
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Physician.class);
		cr.add(Restrictions.eq("licenseNumber", licenseNumber));
		List results = cr.list();
		if (results != null && !results.isEmpty()) {
			physician = (Physician) results.get(0);
		}
		return physician;
	}

	@Override
	public Physician getPhysicianByProviderId(Integer providerId) {
		Physician physician = null;
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Physician.class);				
		cr.createCriteria("provider").add(Restrictions.eq("providerId", providerId));
		List results = cr.list();
		if (results != null && !results.isEmpty()) {
			physician = (Physician) results.get(0);
		}
		return physician;
	}
	
	@Override
	public List<Provider> getUnassignedProviders() {
		List<Provider> providers = sessionFactory.getCurrentSession().createQuery(
		        "from Provider where providerId not in (select provider.providerId from Physician)"
		        + " and providerId not in (select provider.providerId from Nurse)"
		    ).list();
		return providers;
	}
	
	@Override
	public Physician savePhysician(Physician physician) {
		if (physician.getId() != null) {
			sessionFactory.getCurrentSession().merge(physician);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(physician);
			physician = getPhysicianById(id);
		}
		return physician;
	}

	@Override
	public void deletePhysician(Physician physician) {
		sessionFactory.getCurrentSession().delete(physician);
	}

}
