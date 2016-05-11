package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.PatientMovement;
import org.openmrs.module.nursingkardex.PhysicianDepartment;
import org.openmrs.module.nursingkardex.api.db.PhysicianDepartmentDAO;

public class HibernatePhysicianDepartmentDAO implements PhysicianDepartmentDAO {

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
	public List<PhysicianDepartment> getAllPhysicianDepartments() {
		return sessionFactory.getCurrentSession()
				.createCriteria(PhysicianDepartment.class).list();
	}

	@Override
	public PhysicianDepartment getPhysicianDepartmentById(Integer id) {
		return (PhysicianDepartment) sessionFactory.getCurrentSession().get(
				PhysicianDepartment.class, id);
	}

	@Override
	public PhysicianDepartment getPhysicianDepartmentByame(String name) {
		PhysicianDepartment physicianDepartment = null;
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				PatientCaseRecord.class);
		cr.add(Restrictions.isNull("datetimeDischarged"));
		List results = cr.list();
		if (results != null && !results.isEmpty()) {
			physicianDepartment = (PhysicianDepartment) results.get(0);
		}
		return physicianDepartment;
	}

	@Override
	public PhysicianDepartment savePhysicianDepartment(
			PhysicianDepartment physicianDepartment) {
		if (physicianDepartment.getId() != null) {
			sessionFactory.getCurrentSession().merge(physicianDepartment);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(
					physicianDepartment);
			physicianDepartment = getPhysicianDepartmentById(id);
		}
		return physicianDepartment;
	}

	@Override
	public void deletePhysicianDepartment(
			PhysicianDepartment physicianDepartment) {
		sessionFactory.getCurrentSession().delete(physicianDepartment);
	}

}
