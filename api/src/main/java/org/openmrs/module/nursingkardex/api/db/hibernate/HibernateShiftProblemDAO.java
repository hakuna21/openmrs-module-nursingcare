package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.ShiftProblem;
import org.openmrs.module.nursingkardex.api.db.ShiftProblemDAO;

public class HibernateShiftProblemDAO implements ShiftProblemDAO {
	
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
	public List<ShiftProblem> getAllShiftProblems() {
		return sessionFactory.getCurrentSession().createCriteria(ShiftProblem.class).list();
	}
	
	@Override
	public List<ShiftProblem> getShiftProblemsByPatientCaseRecordId(Integer patientCaseRecordId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(ShiftProblem.class);
		cr.add(Restrictions.isNull("dateStopped"));
		cr.createCriteria("patientCaseRecord").add(Restrictions.eq("id", patientCaseRecordId));
		return cr.list();
	}
	
	@Override
	public List<ShiftProblem> getActiveShiftProblemsByPatientCaseRecordId(Integer patientCaseRecordId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(ShiftProblem.class);
		cr.add(Restrictions.eq("activeProblem", 1));
		cr.createCriteria("patientCaseRecord").add(Restrictions.eq("id", patientCaseRecordId));
		return cr.list();
	}
	
	@Override
	public List<ShiftProblem> getShiftProblemsByEncounterId(Integer encounterId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(ShiftProblem.class);
		cr.createCriteria("encounter").add(Restrictions.eq("encounterId", encounterId));
		return cr.list();
	}
	
	@Override
	public ShiftProblem getShiftProblemById(Integer id) {
		return (ShiftProblem) sessionFactory.getCurrentSession().get(ShiftProblem.class, id);
	}
	
	@Override
	public ShiftProblem saveShiftProblem(ShiftProblem shiftProblem) {
		if (shiftProblem.getId() != null) {
			sessionFactory.getCurrentSession().merge(shiftProblem);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(shiftProblem);
			shiftProblem = getShiftProblemById(id);
		}
		return shiftProblem;
	}
	
	@Override
	public void deleteShiftProblem(ShiftProblem shiftProblem) {
		sessionFactory.getCurrentSession().delete(shiftProblem);
	}
	
}
