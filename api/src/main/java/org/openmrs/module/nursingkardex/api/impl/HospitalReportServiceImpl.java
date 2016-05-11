package org.openmrs.module.nursingkardex.api.impl;

import java.util.Date;
import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.api.HospitalReportService;
import org.openmrs.module.nursingkardex.api.db.HospitalReportDAO;

public class HospitalReportServiceImpl extends BaseOpenmrsService implements HospitalReportService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private HospitalReportDAO dao;
	
	public HospitalReportDAO getDao() {
		return dao;
	}
	
	public void setDao(HospitalReportDAO dao) {
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.nursingkardex.api.impl.NursingCareIndicatorService#getVitalSignsHourly(java.lang.Integer)
	 */
	@Override
	public Integer getBedCapacity(Integer locationId) {
		return dao.getBedCapacity(locationId);
	}

	public Integer getTotalLast(Integer locationId, Date startDate, Date endDate) {
		return dao.getTotalLast(locationId, startDate, endDate);
	}

	public BigDecimal getDailyOccupancyRate(Integer locationId, Date startDate, Date endDate) {
		return dao.getDailyOccupancyRate(locationId, startDate, endDate);
	}

	public Integer getOverflow(Integer locationId, Date startDate, Date endDate) {
		return dao.getOverflow(locationId, startDate, endDate);
	}

	public Integer getAdmission(Integer locationId, Date startDate, Date endDate) {
		return dao.getAdmission(locationId, startDate, endDate);
	}

	public Integer getTransIn(Integer locationId, Date startDate, Date endDate) {
		return dao.getTransIn(locationId, startDate, endDate);
	}

	public Integer getTransOut(Integer locationId, Date startDate, Date endDate) {
		return dao.getTransOut(locationId, startDate, endDate);
	}

	public Integer getDischarged(Integer locationId, Date startDate, Date endDate) {
		return dao.getDischarged(locationId, startDate, endDate);
	}

	public Integer getDeaths(Integer locationId, Date startDate, Date endDate) {
		return dao.getDeaths(locationId, startDate, endDate);
	}

	public Integer getAbsconded(Integer locationId, Date startDate, Date endDate) {
		return dao.getAbsconded(locationId, startDate, endDate);
	}

	public Integer getHomeAgainstAdvice(Integer locationId, Date startDate, Date endDate) {
		return dao.getHomeAgainstAdvice(locationId, startDate, endDate);
	}

	public Integer getHomePerRequest(Integer locationId, Date startDate, Date endDate) {
		return dao.getHomePerRequest(locationId, startDate, endDate);
	}

	public Integer getOperations(Integer locationId, Date startDate, Date endDate) {
		return dao.getOperations(locationId, startDate, endDate);
	}

	public Integer getDeliveries(Integer locationId, Date startDate, Date endDate) {
		return dao.getDeliveries(locationId, startDate, endDate);
	}

	public Integer getRoomingIn(Integer locationId, Date startDate, Date endDate) {
		return dao.getRoomingIn(locationId, startDate, endDate);
	}

	public Integer getOutOnPass(Integer locationId, Date startDate, Date endDate) {
		return dao.getOutOnPass(locationId, startDate, endDate);
	}

	public String getRemarks(Integer locationId, Date startDate, Date endDate) {
		return dao.getRemarks(locationId, startDate, endDate);
	}
}
