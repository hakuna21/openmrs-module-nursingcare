package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.NursingCareOrder;
import org.openmrs.module.nursingkardex.api.db.NursingCareOrderDAO;

public class HibernateNursingCareOrderDAO implements NursingCareOrderDAO {
	
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
	public List<NursingCareOrder> getAllNursingCareOrders() {
		return sessionFactory.getCurrentSession().createCriteria(NursingCareOrder.class).list();
	}
	
	@Override
	public List<NursingCareOrder> getActiveNursingCareOrders() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(NursingCareOrder.class);
		cr.add(Restrictions.isNull("dateStopped"));
		return cr.list();
	}
	
	public List<NursingCareOrder> getNursingCareOrdersByPatientCaseOrderId(Integer patientCaseRecordId, boolean activeOnly) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(NursingCareOrder.class);
		if (activeOnly) {
			cr.add(Restrictions.isNull("dateStopped"));
		}
		cr.createCriteria("patientCaseRecord").add(Restrictions.eq("id", patientCaseRecordId));
		return cr.list();
	}
	
	@Override
	public List<NursingCareOrder> getActiveNursingCareOrderByPatientCaseOrderAndOrderType(Integer patientCaseRecordId,
	                                                                                      Integer orderTypeId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(NursingCareOrder.class);
		cr.createCriteria("patientCaseRecord").add(Restrictions.eq("id", patientCaseRecordId));
		cr.createCriteria("orderType").add(Restrictions.eq("orderTypeId", orderTypeId));
		return cr.list();
	}
	
	@Override
	public List<NursingCareOrder> getActiveNursingCareOrdersByOrderType(Integer orderTypeId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(NursingCareOrder.class);
		cr.add(Restrictions.isNull("dateStopped"));
		cr.createCriteria("orderType").add(Restrictions.eq("orderTypeId", orderTypeId));
		return cr.list();
	}
	
	@Override
	public List<NursingCareOrder> getNursingCareOrdersByEncounter(Integer encounterId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(NursingCareOrder.class);
		cr.createCriteria("encounter").add(Restrictions.eq("encounterId", encounterId));
		return cr.list();
	}
	
	@Override
	public List<NursingCareOrder> getNursingCareOrdersByEncounterAndOrderType(Integer encounterId, Integer orderTypeId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(NursingCareOrder.class);
		
		cr.createCriteria("encounter").add(Restrictions.eq("encounterId", encounterId));
		cr.createCriteria("orderType").add(Restrictions.eq("orderTypeId", orderTypeId));
		return cr.list();
	}
	
	@Override
	public List<NursingCareOrder> getNursingCareOrderByEncounterAndConcept(Integer encounterId, Integer conceptId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(NursingCareOrder.class);
		cr.createCriteria("encounter").add(Restrictions.eq("encounterId", encounterId));
		cr.createCriteria("concept").add(Restrictions.eq("conceptId", conceptId));
		cr.addOrder(Order.desc("dateCreated"));
		return cr.list();
	}
	
	@Override
	public NursingCareOrder getNursingCareOrderById(Integer id) {
		return (NursingCareOrder) sessionFactory.getCurrentSession().get(NursingCareOrder.class, id);
	}
	
	@Override
	public NursingCareOrder saveNursingCareOrder(NursingCareOrder nursingCareOrder) {
		if (nursingCareOrder.getId() != null) {
			sessionFactory.getCurrentSession().merge(nursingCareOrder);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(nursingCareOrder);
			nursingCareOrder = getNursingCareOrderById(id);
		}
		return nursingCareOrder;
	}
	
	@Override
	public void deleteNursingCareOrder(NursingCareOrder nursingCareOrder) {
		sessionFactory.getCurrentSession().delete(nursingCareOrder);
	}
	
}
