package org.openmrs.module.nursingkardex.api.db.hibernate;

import java.util.Date;
import java.math.BigInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.openmrs.module.nursingkardex.api.db.NursingIndicatorCareDAO;
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

public class HibernateNursingCareIndicatorDAO implements NursingIndicatorCareDAO {
	
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
	public Integer getVitalSignsHourly(Integer locationId, Date startDate, Date endDate) {
		String sql = MonitoringReportEnum.VITAL_SIGNS_HOURLY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	
	public Integer getVitalSignsShift(Integer locationId, Date startDate, Date endDate) {
		String sql = MonitoringReportEnum.VITAL_SIGNS_SHIFT.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	
	public Integer getIOHourly(Integer locationId, Date startDate, Date endDate) {
		String sql = MonitoringReportEnum.IO_HOURLY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	
	public Integer getIOShift(Integer locationId, Date startDate, Date endDate) {
		String sql = MonitoringReportEnum.IO_SHIFT.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	
	public Integer getThermoRegulation(Integer locationId, Date startDate, Date endDate) {
		String sql = MonitoringReportEnum.THERMOREGULATION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	
	public Integer getPainAssessment(Integer locationId, Date startDate, Date endDate) {
		String sql = MonitoringReportEnum.PAIN_ASSESSMENT.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	
	public Integer getCbg(Integer locationId, Date startDate, Date endDate) {
		String sql = MonitoringReportEnum.CBG.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	
	public Integer getOtherMonitoring(Integer locationId, Date startDate, Date endDate) {
		String sql = MonitoringReportEnum.OTHERS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getBedBath(Integer locationId, Date startDate, Date endDate) {
		String sql = ComfortReportEnum.BED_BATH.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	public Integer getTSB(Integer locationId, Date startDate, Date endDate) {
		String sql = ComfortReportEnum.TSB.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getHairShampoo(Integer locationId, Date startDate, Date endDate) {
		String sql = ComfortReportEnum.HAIR_SHAMPOO.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getOrificeCare(Integer locationId, Date startDate, Date endDate) {
		String sql = ComfortReportEnum.ORIFICE_CARE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getOralCare(Integer locationId, Date startDate, Date endDate) {
		String sql = ComfortReportEnum.ORAL_CARE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	public Integer getNailCare(Integer locationId, Date startDate, Date endDate) {
		String sql = ComfortReportEnum.NAIL_CARE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	public Integer getPerinealCare(Integer locationId, Date startDate, Date endDate) {
		String sql = ComfortReportEnum.PERINEAL_CARE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	public Integer getMassageBackBonyProminences(Integer locationId, Date startDate, Date endDate) {
		String sql = ComfortReportEnum.MASSAGE_BACK_BONY_PROMINENCES.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	public Integer getLinenChange(Integer locationId, Date startDate, Date endDate) {
		String sql = ComfortReportEnum.LINEN_CHANGE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	public Integer getOtherComfort(Integer locationId, Date startDate, Date endDate) {
		String sql = ComfortReportEnum.OTHER_COMFORT.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	public Integer getOral(Integer locationId, Date startDate, Date endDate) {
		String sql = NutritionalReportEnum.ORAL.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getNGT(Integer locationId, Date startDate, Date endDate) {
		String sql = NutritionalReportEnum.NGT.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getParenteral(Integer locationId, Date startDate, Date endDate) {
		String sql = NutritionalReportEnum.PARENTERAL.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOtherNutritional(Integer locationId, Date startDate, Date endDate) {
		String sql = NutritionalReportEnum.OTHER_NUTRITIONAL.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOxygenTherapy(Integer locationId, Date startDate, Date endDate) {
		String sql = VentilatoryReportEnum.OXYGEN_THERAPY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getMechanicalVentilator(Integer locationId, Date startDate, Date endDate) {
		String sql = VentilatoryReportEnum.MECHANICAL_VENTILATOR.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getSuctioning(Integer locationId, Date startDate, Date endDate) {
		String sql = VentilatoryReportEnum.SUCTIONING.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getAmbubagging(Integer locationId, Date startDate, Date endDate) {
		String sql = VentilatoryReportEnum.AMBUBAGGING.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getNebulization(Integer locationId, Date startDate, Date endDate) {
		String sql = VentilatoryReportEnum.NEBULIZATION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getPulmonaryPhysiotherapy(Integer locationId, Date startDate, Date endDate) {
		String sql = VentilatoryReportEnum.PULMONARY_PHYSIOTHERAPY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getIntubation(Integer locationId, Date startDate, Date endDate) {
		String sql = VentilatoryReportEnum.INTUBATION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOtherVentilator(Integer locationId, Date startDate, Date endDate) {
		String sql = VentilatoryReportEnum.OTHER_VENTILATOR.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getBowelColostomy(Integer locationId, Date startDate, Date endDate) {
		String sql = EliminationReportEnum.BOWEL_COLOSTOMY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getIleostomy(Integer locationId, Date startDate, Date endDate) {
		String sql = EliminationReportEnum.ILEOSTOMY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getFoleyCatheter(Integer locationId, Date startDate, Date endDate) {
		String sql = EliminationReportEnum.FOLEY_CATHETER.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getPeritonealDialysis(Integer locationId, Date startDate, Date endDate) {
		String sql = EliminationReportEnum.PERITONEAL_DIALYSIS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getHemodialysis(Integer locationId, Date startDate, Date endDate) {
		String sql = EliminationReportEnum.HEMODIALYSIS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOtherElimination(Integer locationId, Date startDate, Date endDate) {
		String sql = EliminationReportEnum.OTHER_ELIMINATION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}



	public Integer getPositioning(Integer locationId, Date startDate, Date endDate) {
		String sql = MobilityReportEnum.POSITIONING.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getTransporting(Integer locationId, Date startDate, Date endDate) {
		String sql = MobilityReportEnum.TRANSPORTING.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getTurningEveryTwoHours(Integer locationId, Date startDate, Date endDate) {
		String sql = MobilityReportEnum.TURNING_EVERY_TWO_HOURS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getFallPrevention(Integer locationId, Date startDate, Date endDate) {
		String sql = MobilityReportEnum.FALL_PREVENTION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getRestraining(Integer locationId, Date startDate, Date endDate) {
		String sql = MobilityReportEnum.RESTRAINING.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getPassiveROM(Integer locationId, Date startDate, Date endDate) {
		String sql = MobilityReportEnum.PASSIVE_ROM.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getCastCare(Integer locationId, Date startDate, Date endDate) {
		String sql = MobilityReportEnum.CAST_CARE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getTractionCare(Integer locationId, Date startDate, Date endDate) {
		String sql = MobilityReportEnum.TRACTION_CARE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}



	public Integer getOtherMobility(Integer locationId, Date startDate, Date endDate) {
		String sql = MobilityReportEnum.OTHER_MOBILITY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	
	public Integer getIVF(Integer locationId, Date startDate, Date endDate) {
		String sql = IVTReportEnum.IVF.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getBloodTransfusion(Integer locationId, Date startDate, Date endDate) {
		String sql = IVTReportEnum.BLOOD_TRANSFUSION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getFreshWholeBlood(Integer locationId, Date startDate, Date endDate) {
		String sql = IVTReportEnum.FRESH_WHOLE_BLOOD.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getPackedRBC(Integer locationId, Date startDate, Date endDate) {
		String sql = IVTReportEnum.PACKED_RBC.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getChemotherapy(Integer locationId, Date startDate, Date endDate) {
		String sql = IVTReportEnum.CHEMOTHERAPY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOtherIVT(Integer locationId, Date startDate, Date endDate) {
		String sql = IVTReportEnum.OTHER_IVT.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	public Integer getPerOrem(Integer locationId, Date startDate, Date endDate) {
		String sql = MedicationReportEnum.PER_OREM.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getTopical(Integer locationId, Date startDate, Date endDate) {
		String sql = MedicationReportEnum.TOPICAL.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getIntravenous(Integer locationId, Date startDate, Date endDate) {
		String sql = MedicationReportEnum.INTRAVENOUS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getIntradermal(Integer locationId, Date startDate, Date endDate) {
		String sql = MedicationReportEnum.INTRADERMAL.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getIntramuscular(Integer locationId, Date startDate, Date endDate) {
		String sql = MedicationReportEnum.INTRAMUSCULAR.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getSubcutaneous(Integer locationId, Date startDate, Date endDate) {
		String sql = MedicationReportEnum.SUBCUTANEOUS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getDrops(Integer locationId, Date startDate, Date endDate) {
		String sql = MedicationReportEnum.DROPS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getSuppositories(Integer locationId, Date startDate, Date endDate) {
		String sql = MedicationReportEnum.SUPPOSITORIES.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getEnemaIrrigation(Integer locationId, Date startDate, Date endDate) {
		String sql = MedicationReportEnum.ENEMA_IRRIGATION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOtherMedication(Integer locationId, Date startDate, Date endDate) {
		String sql = MedicationReportEnum.OTHER_MEDICATION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getNGTPEG(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.NGT_PEG.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getNasalCannula(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.NASAL_CANNULA.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getTracheostomy(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.TRACHEOSTOMY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getChestTube(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.CHEST_TUBE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getFoleyCatheterCare(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.FOLEY_CATHETER.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getJacksonPratt(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.JACKSON_PRATT.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getIJCatheter(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.IJ_CATHETER.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getFemoralCatheter(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.FEMORAL_CATHETER.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getNephrostomyTube(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.NEPHROSTOMY_TUBE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getAVFistula(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.AV_FISTULA.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getSubclavianCatheter(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.SUBCLAVIAN_CATHETER.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getTenckhoffCatheter(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.TENCKHOFF_CATHETER.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getColostomyIleostomy(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.COLOSTOMY_ILEOSTOMY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getJejunostomy(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.JEJUNOSTOMY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOtherTube(Integer locationId, Date startDate, Date endDate) {
		String sql = TubeCareReportEnum.OTHER_TUBE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOperativeSite(Integer locationId, Date startDate, Date endDate) {
		String sql = WoundCareReportEnum.OPERATIVE_SITE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getPressureSore(Integer locationId, Date startDate, Date endDate) {
		String sql = WoundCareReportEnum.PRESSURE_SORE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getBurn(Integer locationId, Date startDate, Date endDate) {
		String sql = WoundCareReportEnum.BURN.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOtherWound(Integer locationId, Date startDate, Date endDate) {
		String sql = WoundCareReportEnum.OTHER_WOUND.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getXray(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.XRAY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getCTScan(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.CT_SCAN.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getUltrasound(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.ULTRASOUND.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getMRI(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.MRI.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getECG(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.ECG.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getEEG(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.EEG.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getTwoDEcho(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.TWOD_ECHO.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getSpecimenCollection(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.SPECIMEN_COLLECTION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getBlood(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.BLOOD.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getUrine(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.URINE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getSputum(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.SPUTUM.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getCSF(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.CSF.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOtherDiagnostic(Integer locationId, Date startDate, Date endDate) {
		String sql = DiagnosticProcedureReportEnum.OTHER_DIAGNOSTIC.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getPeritonealDialysisProcedure(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.PERITONEAL_DIALYSIS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getHemodialysisProcedure(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.HEMODIALYSIS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getBronchoscopy(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.BRONCHOSCOPY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getThoracentesis(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.THORACENTESIS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getEndoscopy(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.ENDOSCOPY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getParacentesis(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.PARACENTESIS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getCoronaryAngiography(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.CORONARY_ANGIOGRAPHY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getBoneMarrowAspiration(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.BONE_MARROW_ASPIRATION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getBiopsy(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.BIOPSY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getPerioperativeCare(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.PERIOPERATIVE_CARE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getLumbarTap(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.LUMBAR_TAP.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getElectroconvulsiveTherapy(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.ELECTROCONVULSIVE_THERAPY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOtherInvasiveProcedure(Integer locationId, Date startDate, Date endDate) {
		String sql = InvasiveProcedureReportEnum.OTHER_INVASIVE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getReferralToReligiousMinister(Integer locationId, Date startDate, Date endDate) {
		String sql = SpiritualPsychosocialReportEnum.REFERRAL_TO_RELIGIOUS_MINISTER.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOtherSpiritualCare(Integer locationId, Date startDate, Date endDate) {
		String sql = SpiritualPsychosocialReportEnum.OTHER_SPIRITUAL_CARE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getCounselingGrievingMeasures(Integer locationId, Date startDate, Date endDate) {
		String sql = SpiritualPsychosocialReportEnum.COUNSELING_GRIEVING_MEASURES.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getAnxietyReductionTechniques(Integer locationId, Date startDate, Date endDate) {
		String sql = SpiritualPsychosocialReportEnum.ANXIETY_REDUCTION_TECHNIQUES.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getRelaxationMeasures(Integer locationId, Date startDate, Date endDate) {
		String sql = SpiritualPsychosocialReportEnum.RELAXATION_MEASURES.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getProvisionOfStructuredActivities(Integer locationId, Date startDate, Date endDate) {
		String sql = SpiritualPsychosocialReportEnum.PROVISION_OF_STRUCTURED_ACTIVITIES.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getHomicidalSuicidalAndEscapePrecautions(Integer locationId, Date startDate, Date endDate) {
		String sql = SpiritualPsychosocialReportEnum.HOMICIDAL_SUICIDAL_AND_ESCAPE_PRECAUTIONS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getHealthTeaching(Integer locationId, Date startDate, Date endDate) {
		String sql = SpiritualPsychosocialReportEnum.HEALTH_TEACHING.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOtherPsychosocial(Integer locationId, Date startDate, Date endDate) {
		String sql = SpiritualPsychosocialReportEnum.OTHER_PSYCHOSOCIAL.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getCode(Integer locationId, Date startDate, Date endDate) {
		String sql = CodeLevelsOfCareReportEnum.CODE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getPostMortemCare(Integer locationId, Date startDate, Date endDate) {
		String sql = CodeLevelsOfCareReportEnum.POST_MORTEM_CARE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getTerminalCleaning(Integer locationId, Date startDate, Date endDate) {
		String sql = CodeLevelsOfCareReportEnum.TERMINAL_CLEANING.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getFiveS(Integer locationId, Date startDate, Date endDate) {
		String sql = CodeLevelsOfCareReportEnum.FIVE_S.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getLevelOne(Integer locationId, Date startDate, Date endDate) {
		String sql = CodeLevelsOfCareReportEnum.LEVEL_ONE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getLevelTwo(Integer locationId, Date startDate, Date endDate) {
		String sql = CodeLevelsOfCareReportEnum.LEVEL_TWO.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getLevelThree(Integer locationId, Date startDate, Date endDate) {
		String sql = CodeLevelsOfCareReportEnum.LEVEL_THREE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getLevelFour(Integer locationId, Date startDate, Date endDate) {
		String sql = CodeLevelsOfCareReportEnum.LEVEL_FOUR.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getHCAI(Integer locationId, Date startDate, Date endDate) {
		String sql = OtherReportEnum.HCAI.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getWithBedsores(Integer locationId, Date startDate, Date endDate) {
		String sql = OtherReportEnum.WITH_BEDSORES.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getWithBedsoresAcquiredInTheHospital(Integer locationId, Date startDate, Date endDate) {
		String sql = OtherReportEnum.WITH_BEDSORES_ACQUIRED_IN_THE_HOSPITAL.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getOROnCall(Integer locationId, Date startDate, Date endDate) {
		String sql = OtherReportEnum.OR_ON_CALL.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getForOperation(Integer locationId, Date startDate, Date endDate) {
		String sql = OtherReportEnum.FOR_OPERATION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getAdverseSentinelEvents(Integer locationId, Date startDate, Date endDate) {
		String sql = OtherReportEnum.ADVERSE_SENTINEL_EVENTS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}


	public Integer getDocumentation(Integer locationId, Date startDate, Date endDate) {
		String sql = OtherReportEnum.DOCUMENTATION.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}

	
	public Integer getBedCapacity(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.BED_CAPACITY.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
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

	public Integer getDailyOccupancyRate(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.DAILY_OCCUPANCY_RATE.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
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
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

	public Integer getOutOnPass(Integer locationId, Date startDate, Date endDate) {
		String sql = DailyHospitalCensusReportEnum.OUT_ON_PASS.getValue();
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setDate("endDate", endDate);
		query.setDate("startDate", startDate);
		if (locationId != null) {
			query.setInteger("locationId", locationId);
		}
		return ((BigInteger) query.uniqueResult()).intValue();
	}
	

}
