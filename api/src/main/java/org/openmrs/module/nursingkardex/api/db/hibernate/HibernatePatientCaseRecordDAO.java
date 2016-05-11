package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.nursingkardex.PatientCaseRecord;
import org.openmrs.module.nursingkardex.api.db.PatientCaseRecordDAO;

public class HibernatePatientCaseRecordDAO implements PatientCaseRecordDAO {
	
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
	public List<PatientCaseRecord> getAllPatientCaseRecords() {
		return sessionFactory.getCurrentSession().createCriteria(PatientCaseRecord.class).list();
	}
	
	@Override
	public List<PatientCaseRecord> getActivePatientCaseRecords() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(PatientCaseRecord.class);
		cr.add(Restrictions.isNull("datetimeDischarged"));
		return cr.list();
	}
	
	@Override
	public List<PatientCaseRecord> getActivePatientCaseRecordsByLocationId(Integer locationId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(PatientCaseRecord.class);
		cr.add(Restrictions.isNull("datetimeDischarged"));
		if (locationId != null) {
			cr.createCriteria("latestPatientMovement").createCriteria("bed").createCriteria("location")
			        .add(Restrictions.eq("locationId", locationId));
		}
		return cr.list();
	}
	
	public List<PatientCaseRecord> getClosedPatientCaseRecord(boolean forTodayOnly, Integer locationId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(PatientCaseRecord.class);
		cr.add(Restrictions.isNotNull("datetimeDischarged"));
		if (forTodayOnly) {
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
			
			cr.add(Restrictions.ge("datetimeDischarged", date1));
			cr.add(Restrictions.lt("datetimeDischarged", date2));
		}
		if (locationId != null) {
			cr.createCriteria("latestPatientMovement").createCriteria("bed").createCriteria("location")
			        .add(Restrictions.eq("locationId", locationId));
		}
		return cr.list();
	}
	
	@Override
	public List<PatientCaseRecord> getPatientCaseRecordsByPatientId(Integer patientId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(PatientCaseRecord.class);
		
		cr.createAlias("patient", "patient").add(Restrictions.eq("patientId", patientId));
		return cr.list();
	}

	@Override
	public List<PatientCaseRecord> getPatientCaseRecordsByPhysicianInChargeId(Integer physicianId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(PatientCaseRecord.class);
		if (physicianId != null) {
			cr.createAlias("physicianInCharge", "physicianInCharge").add(Restrictions.eq("id", physicianId));
		}
		return cr.list();
	}
	
	@Override
	public List<PatientCaseRecord> searchPatientCaseRecords(String name, Integer bedId, Integer departmentId,
	                                                        Integer physicianId, Integer locationId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(PatientCaseRecord.class);
		// DetachedCriteria cr =
		// DetachedCriteria.forClass(PatientCaseRecord.class);
		
		if (StringUtils.isNotEmpty(name)) {
//			cr = new PatientSearchCriteria(sessionFactory, cr).prepareCriteria(name, null,
//			    new ArrayList<PatientIdentifierType>(), false, true, false);
//			cr = new PatientSearchCriteria(sessionFactory, cr).prepareCriteria(name, null, null, false, true, false);
//			 cr.createCriteria("patient").createCriteria("names");//.add(Restrictions.like("givenName", name))
//			 		.add(Restrictions.like("familyName", name));
			 

				//match on location.name, encounterType.name, form.name
				//provider.name, provider.identifier, provider.person.names
				MatchMode mode = MatchMode.ANYWHERE;
				
				Disjunction or = Restrictions.disjunction();
				
				String[] splitNames = name.split(" ");
				Disjunction nameOr = Restrictions.disjunction();
				for (String splitName : splitNames) {
					nameOr.add(Restrictions.ilike("givenName", splitName, mode));
					nameOr.add(Restrictions.ilike("middleName", splitName, mode));
					nameOr.add(Restrictions.ilike("familyName", splitName, mode));
					nameOr.add(Restrictions.ilike("familyName2", splitName, mode));
				}
				//OUTPUT for provider criteria: 
				//prov.name like '%query%' OR prov.identifier like '%query%'
				//OR ( personName.voided = false 
				//		 AND (  personName.givenName like '%query%' 
				//			OR personName.middleName like '%query%' 
				//			OR personName.familyName like '%query%'
				//			OR personName.familyName2 like '%query%'
				//			)
				//	 )
				Conjunction personNameConjuction = Restrictions.conjunction();
				personNameConjuction.add(nameOr);
				
				or.add(personNameConjuction);
				cr.createCriteria("patient").createCriteria("names").add(or);
//				cr.add(or);
			
			 
		}
		Criteria bedCriteria = null;
		if (bedId != null || locationId != null) {
			bedCriteria = cr.createCriteria("latestPatientMovement").createCriteria("bed");
		}
		if (bedId != null) {
			bedCriteria.add(Restrictions.eq("id", bedId));
		}
		if (locationId != null) {
			bedCriteria.createCriteria("location").add(Restrictions.eq("locationId", locationId));
		}
		Criteria physicianCriteria = null;
		if (departmentId != null || physicianId != null) {
			physicianCriteria = cr.createCriteria("physicianInCharge");
		}
		if (departmentId != null) {
			physicianCriteria.createCriteria("physicianDepartment").add(Restrictions.eq("id", departmentId));
		}
		if (physicianId != null) {
			physicianCriteria.add(Restrictions.eq("id", physicianId));
		}
		cr.add(Restrictions.isNull("datetimeDischarged"));
		return cr.list();
	}
	
	@Override
	public Long getTotalPatientCaseRecordCountByLocation(Integer locationId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(PatientCaseRecord.class);
		cr.add(Restrictions.isNull("datetimeDischarged"));
		if (locationId != null) {
			cr.createCriteria("latestPatientMovement").createCriteria("bed").createCriteria("location")
			        .add(Restrictions.eq("locationId", locationId));
		}
		return (Long) cr.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	@Override
	public PatientCaseRecord getPatientCaseRecordById(Integer id) {
		return (PatientCaseRecord) sessionFactory.getCurrentSession().get(PatientCaseRecord.class, id);
	}
	
	@Override
	public PatientCaseRecord getPatientCaseRecordByBedId(Integer bedId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(PatientCaseRecord.class);
		cr.add(Restrictions.isNull("datetimeDischarged"));
		cr.createCriteria("latestPatientMovement").createCriteria("bed").add(Restrictions.eq("id", bedId));
		List<PatientCaseRecord> list = cr.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public PatientCaseRecord savePatientCaseRecord(PatientCaseRecord patientCaseRecord) {
		if (patientCaseRecord.getId() != null) {
			patientCaseRecord = (PatientCaseRecord) sessionFactory.getCurrentSession().merge(patientCaseRecord);
		} else {
			Integer id = (Integer) sessionFactory.getCurrentSession().save(patientCaseRecord);
			patientCaseRecord = getPatientCaseRecordById(id);
		}
		return patientCaseRecord;
	}
	
	@Override
	public void deletePatientCaseRecord(PatientCaseRecord patientCaseRecord) {
		sessionFactory.getCurrentSession().delete(patientCaseRecord);
	}
	
}
