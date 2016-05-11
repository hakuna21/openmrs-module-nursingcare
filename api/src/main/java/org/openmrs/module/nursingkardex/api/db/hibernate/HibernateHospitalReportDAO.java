package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.openmrs.module.nursingkardex.api.db.HospitalReportDAO;
import org.openmrs.module.nursingkardex.util.EnumUtils.MonitoringReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.ComfortReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.NutritionalReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.VentilatoryReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.EliminationReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.MobilityReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.IVTReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.MedicationReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.TubeCareReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.WoundCareReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.DiagnosticProcedureReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.InvasiveProcedureReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.SpiritualPsychosocialReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.CodeLevelsOfCareReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.OtherReportEnum;
import org.openmrs.module.nursingkardex.util.EnumUtils.DailyHospitalCensusReportEnum;

public class HibernateHospitalReportDAO implements HospitalReportDAO {
	
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
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.db.hibernate.NursingIndicatorDAO#getVitalSigns(java.util.Date, java.lang.Integer)
	 */
	@Override
	public Integer getBedCapacity(Integer locationId) {
		String sql = DailyHospitalCensusReportEnum.BED_CAPACITY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	public Integer getTotalLast(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.TOTAL_LAST.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	public BigDecimal getDailyOccupancyRate(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.DAILY_OCCUPANCY_RATE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		BigDecimal result = (BigDecimal) query.uniqueResult();
		if (result == null) {
			return null;
		}
		return result.setScale(2, RoundingMode.CEILING);
	}


	public Integer getOverflow(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.OVERFLOW.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getAdmission(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.ADMISSION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getTransIn(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.TRANS_IN.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getTransOut(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.TRANS_OUT.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getDischarged(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.DISCHARGED.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getDeaths(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.DEATHS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getAbsconded(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.ABSCONDED.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getHomeAgainstAdvice(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.HOME_AGAINST_ADVICE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getHomePerRequest(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.HOME_PER_REQUEST.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getOperations(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.OPERATIONS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getDeliveries(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.DELIVERIES.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getRoomingIn(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.ROOMING_IN.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("startDate", startDate);
		query.setDate("endDate", endDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getOutOnPass(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.OUT_ON_PASS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("startDate", startDate);
		query.setDate("endDate", endDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	public String getRemarks(Integer locationId, Date startDate, Date endDate) {
		/**String sql = DailyHospitalCensusReportEnum.OUT_ON_PASS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("startDate", startDate);
		query.setDate("endDate", endDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();*/
		return "N/A";
	}

}