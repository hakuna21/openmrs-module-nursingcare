package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.Operation;
import org.openmrs.module.nursingkardex.api.db.OperationDAO;

public class HibernateOperationDAO implements OperationDAO {
	
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
	public List<Operation> getAllOperations() {
		return sessionFactory.getCurrentSession().createCriteria(Operation.class).list();
	}
	
	@Override
	public List<Operation> getOperationsByPatientCaseRecordId(Integer patientCaseRecordId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Operation.class);
		cr.createCriteria("patientCaseRecord").add(Restrictions.eq("id", patientCaseRecordId));
		return cr.list();
	}
	
	@Override
	public List<Operation> getOperationsByEncounter(Integer encounterId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Operation.class);
		cr.createCriteria("encounter").add(Restrictions.eq("encounterId", encounterId));
		return cr.list();
	}
	
	@Override
	public Operation getOperationById(Integer id) {
		return (Operation) sessionFactory.getCurrentSession().get(Operation.class, id);
	}
	
	@Override
	public Operation saveOperation(Operation operation) {
		if (operation.getId() != null) {
			sessionFactory.getCurrentSession().merge(operation);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(operation);
			operation = getOperationById(id);
		}
		return operation;
	}
	
	@Override
	public void deleteOperation(Operation operation) {
		sessionFactory.getCurrentSession().delete(operation);
	}
	
}
