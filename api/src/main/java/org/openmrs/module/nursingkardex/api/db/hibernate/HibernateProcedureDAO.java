package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.Procedure;
import org.openmrs.module.nursingkardex.api.db.ProcedureDAO;

public class HibernateProcedureDAO implements ProcedureDAO {
	
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
	public List<Procedure> getAllProcedures() {
		return sessionFactory.getCurrentSession().createCriteria(Procedure.class).list();
	}
	
	@Override
	public List<Procedure> getProceduresByPatientCaseRecordId(Integer patientCaseRecordId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Procedure.class);
		cr.createCriteria("patientCaseRecord").add(Restrictions.eq("id", patientCaseRecordId));
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	@Override
	public List<Procedure> getProceduresByPatientCaseRecordAndType(Integer patientCaseRecordId, String type) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Procedure.class);
		cr.createCriteria("patientCaseRecord").add(Restrictions.eq("id", patientCaseRecordId));
		cr.add(Restrictions.eq("type", type));
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	@Override
	public List<Procedure> getProceduresByEncounter(Integer encounterId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Procedure.class);
		cr.createCriteria("encounter").add(Restrictions.eq("encounterId", encounterId));
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	@Override
	public List<Procedure> getProceduresByEncounterAndType(Integer encounterId, String type) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Procedure.class);
		cr.createCriteria("encounter").add(Restrictions.eq("encounterId", encounterId));
		cr.add(Restrictions.eq("type", type));
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	@Override
	public Procedure getProcedureById(Integer id) {
		return (Procedure) sessionFactory.getCurrentSession().get(Procedure.class, id);
	}
	
	@Override
	public Procedure saveProcedure(Procedure procedure) {
		if (procedure.getId() != null) {
			sessionFactory.getCurrentSession().merge(procedure);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(procedure);
			procedure = getProcedureById(id);
		}
		return procedure;
	}
	
	@Override
	public void deleteProcedure(Procedure procedure) {
		sessionFactory.getCurrentSession().delete(procedure);
	}
	
}
