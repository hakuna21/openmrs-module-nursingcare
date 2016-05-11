package org.openmrs.module.nursingkardex.api.db;

import java.util.Date;
import java.math.BigDecimal;

public interface HospitalReportDAO {
	
	Integer getBedCapacity(Integer locationId);
	
	Integer getTotalLast(Integer locationId, Date startDate, Date endDate);
	
	BigDecimal getDailyOccupancyRate(Integer locationId, Date startDate, Date endDate);
	
	Integer getOverflow(Integer locationId, Date startDate, Date endDate);
	
	Integer getAdmission(Integer locationId, Date startDate, Date endDate);
	
	Integer getTransIn(Integer locationId, Date startDate, Date endDate);
	
	Integer getTransOut(Integer locationId, Date startDate, Date endDate);
	
	Integer getDischarged(Integer locationId, Date startDate, Date endDate);
	
	Integer getDeaths(Integer locationId, Date startDate, Date endDate);
	
	Integer getAbsconded(Integer locationId, Date startDate, Date endDate);
	
	Integer getHomeAgainstAdvice(Integer locationId, Date startDate, Date endDate);
	
	Integer getHomePerRequest(Integer locationId, Date startDate, Date endDate);
	
	Integer getOperations(Integer locationId, Date startDate, Date endDate);
	
	Integer getDeliveries(Integer locationId, Date startDate, Date endDate);
	
	Integer getRoomingIn(Integer locationId, Date startDate, Date endDate);
	
	Integer getOutOnPass(Integer locationId, Date startDate, Date endDate);

	String getRemarks(Integer locationId, Date startDate, Date endDate);
}
