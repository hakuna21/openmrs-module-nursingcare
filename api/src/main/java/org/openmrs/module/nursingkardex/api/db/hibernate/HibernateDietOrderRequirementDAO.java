package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.DietOrderRequirement;
import org.openmrs.module.nursingkardex.api.db.DietOrderRequirementDAO;

public class HibernateDietOrderRequirementDAO implements DietOrderRequirementDAO {
	
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
	public List<DietOrderRequirement> getAllDietOrderRequirements() {
		return sessionFactory.getCurrentSession().createCriteria(DietOrderRequirement.class).list();
	}
	
	@Override
	public List<DietOrderRequirement> getActiveDietOrderRequirements(Integer patientCaseRecordId) {
		Criteria cr= sessionFactory.getCurrentSession().createCriteria(DietOrderRequirement.class);
		cr.createCriteria("order").add(Restrictions.isNull("dateStopped"));
		if (patientCaseRecordId != null) {
			cr.createCriteria("patientCaseRecord").add(Restrictions.eq("id", patientCaseRecordId));
		}	
		return cr.list();
	}
	
	@Override
	public List<DietOrderRequirement> getDietOrderRequirementsByEncounter(Integer encounterId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(DietOrderRequirement.class);
		cr.createCriteria("encounter").add(Restrictions.eq("encounterId", encounterId));
		return cr.list();
	}
	
	@Override
	public DietOrderRequirement getDietOrderRequirementById(Integer id) {
		return (DietOrderRequirement) sessionFactory.getCurrentSession().get(DietOrderRequirement.class, id);
	}
	
	@Override
	public DietOrderRequirement saveDietOrderRequirement(DietOrderRequirement dietOrderRequirement) {
		if (dietOrderRequirement.getId() != null) {
			sessionFactory.getCurrentSession().merge(dietOrderRequirement);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(dietOrderRequirement);
			dietOrderRequirement = getDietOrderRequirementById(id);
		}
		return dietOrderRequirement;
	}
	
	@Override
	public void deleteDietOrderRequirement(DietOrderRequirement dietOrderRequirement) {
		sessionFactory.getCurrentSession().delete(dietOrderRequirement);
	}
	
}
