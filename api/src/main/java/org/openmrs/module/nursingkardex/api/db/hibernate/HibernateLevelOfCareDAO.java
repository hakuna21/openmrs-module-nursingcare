package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.LevelOfCare;
import org.openmrs.module.nursingkardex.api.db.LevelOfCareDAO;

public class HibernateLevelOfCareDAO implements LevelOfCareDAO {
	
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
	public List<LevelOfCare> getAllLevelOfCares() {
		return sessionFactory.getCurrentSession().createCriteria(LevelOfCare.class).list();
	}
	
	@Override
	public List<LevelOfCare> getLevelOfCaresByPatientCaseRecordId(Integer patientCaseRecordId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(LevelOfCare.class);
		cr.createCriteria("patientCaseRecord").add(Restrictions.eq("id", patientCaseRecordId));
		return cr.list();
	}
	
	@Override
	public List<LevelOfCare> getLevelOfCaresByEncounter(Integer encounterId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(LevelOfCare.class);
		cr.createCriteria("encounter").add(Restrictions.eq("encounterId", encounterId));
		return cr.list();
	}
	
	@Override
	public List<LevelOfCare> getLevelOfCaresByLevel(Integer level) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(LevelOfCare.class);
		cr.add(Restrictions.eq("levelOfCare", level));
		return cr.list();
	}
	
	@Override
	public LevelOfCare getLevelOfCareById(Integer id) {
		return (LevelOfCare) sessionFactory.getCurrentSession().get(LevelOfCare.class, id);
	}
	
	@Override
	public LevelOfCare saveLevelOfCare(LevelOfCare levelOfCare) {
		if (levelOfCare.getId() != null) {
			sessionFactory.getCurrentSession().merge(levelOfCare);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(levelOfCare);
			levelOfCare = getLevelOfCareById(id);
		}
		return levelOfCare;
	}
	
	@Override
	public void deleteLevelofCare(LevelOfCare levelOfCare) {
		sessionFactory.getCurrentSession().delete(levelOfCare);
	}
	
}
