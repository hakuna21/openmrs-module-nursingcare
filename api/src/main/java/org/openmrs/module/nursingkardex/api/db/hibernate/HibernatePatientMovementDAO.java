package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.PatientMovement;
import org.openmrs.module.nursingkardex.api.db.PatientMovementDAO;
import org.openmrs.module.nursingkardex.util.EnumUtils.EncounterTypeEnum;

public class HibernatePatientMovementDAO implements PatientMovementDAO {
	
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
	public List<PatientMovement> getAllPatientMovements() {
		return sessionFactory.getCurrentSession().createCriteria(PatientMovement.class).list();
	}
	
	@Override
	public List<PatientMovement> getPatientMovementsByPatientCaseRecordId(Integer patientCaseRecordId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(PatientMovement.class);
		cr.createCriteria("patientCaseRecord").add(Restrictions.eq("id", patientCaseRecordId));
		return cr.list();
	}
	
	public List<PatientMovement> getPatientMovements(Integer encounterTypeId, Integer locationId, boolean forToday,
	                                                 boolean activeOnly) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(PatientMovement.class);
		if (activeOnly) {
			cr.createCriteria("patientCaseRecord").add(Restrictions.isNull("datetimeDischarged"));
		}
		if (encounterTypeId != null) {
			cr.createCriteria("encounter").createCriteria("encounterType")
			        .add(Restrictions.eq("encounterTypeId", encounterTypeId));
		}
		if (locationId != null) {
			cr.createCriteria("bed").createCriteria("location").add(Restrictions.eq("locationId", locationId));
		}
		if (forToday) {
			// today    
			Calendar date = new GregorianCalendar();
			// reset hour, minutes, seconds and millis
			date.set(Calendar.HOUR_OF_DAY, 0);
			date.set(Calendar.MINUTE, 0);
			date.set(Calendar.SECOND, 0);
			date.set(Calendar.MILLISECOND, 0);
			Date date1 = date.getTime();
			
			// next day
			date.add(Calendar.DAY_OF_MONTH, 1);
			Date date2 = date.getTime();
			
			cr.add(Restrictions.ge("movementDatetime", date1));
			cr.add(Restrictions.lt("movementDatetime", date2));
		}
		return cr.list();
	}
	
	@Override
	public List<PatientMovement> getPatientMovementsByEncounterId(Integer encounterId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(PatientMovement.class);
		cr.createCriteria("encounter").add(Restrictions.eq("encounterId", encounterId));
		cr.addOrder(Order.desc("id"));
		return cr.list();
	}
	
	@Override
	public Long getTotalPatientMovementCountByLocationAndEncounterType(Integer locationId, Integer encouterTypeId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(PatientMovement.class);
		cr.createCriteria("patientCaseRecord").add(Restrictions.isNull("datetimeDischarged"));
		if (locationId != null) {
			cr.createCriteria("bed").createCriteria("location").add(Restrictions.eq("locationId", locationId));
		}
		cr.createCriteria("encounter").createCriteria("encounterType")
		        .add(Restrictions.eq("encounterTypeId", encouterTypeId));
		return (Long) cr.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	@Override
	public PatientMovement getPatientMovementById(Integer id) {
		return (PatientMovement) sessionFactory.getCurrentSession().get(PatientMovement.class, id);
	}
	
	@Override
	public PatientMovement savePatientMovement(PatientMovement patientMovement) {
		if (patientMovement.getId() != null) {
			sessionFactory.getCurrentSession().merge(patientMovement);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(patientMovement);
			patientMovement = getPatientMovementById(id);
		}
		return patientMovement;
	}
	
	@Override
	public void deletePatientMovement(PatientMovement patientMovement) {
		sessionFactory.getCurrentSession().delete(patientMovement);
	}
	
}
