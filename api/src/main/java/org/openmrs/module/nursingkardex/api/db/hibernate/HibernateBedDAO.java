package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.Bed;
import org.openmrs.module.nursingkardex.api.db.BedDAO;

public class HibernateBedDAO implements BedDAO {

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
	public List<Bed> getAllBeds() {
		return sessionFactory.getCurrentSession().createCriteria(Bed.class)
				.list();
	}

	@Override
	public List<Bed> getOccupiedBeds() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Bed.class);
		cr.add(Restrictions.eq("isOccupied", 1));
		return cr.list();
	}

	@Override
	public List<Bed> getBedsByLocationId(Integer locationId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Bed.class);
		cr.createCriteria("location").add(Restrictions.eq("locationId", locationId));
		return cr.list();
	}
	
	@Override
	public List<Bed> getAvailableBeds() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Bed.class);
		cr.add(Restrictions.eq("isOccupied", 0));
		return cr.list();
	}
	
	@Override
	public List<Bed> getAvailableBedsByLocationId(Integer locationId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Bed.class);
		cr.add(Restrictions.eq("isOccupied", 0));
		cr.createCriteria("location").add(Restrictions.eq("locationId", locationId));
		return cr.list();
	}

	@Override
	public Bed getBedById(Integer id) {
		return (Bed) sessionFactory.getCurrentSession().get(Bed.class, id);
	}

	@Override
	public Bed saveBed(Bed bed) {
		if (bed.getId() != null) {
			sessionFactory.getCurrentSession().merge(bed);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(bed);
			bed = getBedById(id);
		}
		return bed;
	}

	@Override
	public void deleteBed(Bed bed) {
		sessionFactory.getCurrentSession().delete(bed);
	}

}
