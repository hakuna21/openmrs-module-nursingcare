package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.openmrs.module.nursingkardex.ProblemClassification;
import org.openmrs.module.nursingkardex.api.db.ProblemClassificationDAO;

public class HibernateProblemClassificationDAO implements ProblemClassificationDAO {
	
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
	public List<ProblemClassification> getAllProblemClassifications() {
		return sessionFactory.getCurrentSession().createCriteria(ProblemClassification.class).addOrder(Order.asc("name"))
		        .list();
	}
	
	@Override
	public ProblemClassification getProblemClassificationById(Integer id) {
		return (ProblemClassification) sessionFactory.getCurrentSession().get(ProblemClassification.class, id);
	}
	
	@Override
	public ProblemClassification saveProblemClassification(ProblemClassification problemClassification) {
		if (problemClassification.getId() != null) {
			sessionFactory.getCurrentSession().merge(problemClassification);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(problemClassification);
			problemClassification = getProblemClassificationById(id);
		}
		return problemClassification;
	}
	
	@Override
	public void deleteProblemClassification(ProblemClassification problemClassification) {
		sessionFactory.getCurrentSession().delete(problemClassification);
	}
	
}
