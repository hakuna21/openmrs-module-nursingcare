package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.WardAggregate;
import org.openmrs.module.nursingkardex.api.db.WardAggregateDAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WardAggregateService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	void setDao(WardAggregateDAO dao);
	
	@Transactional(readOnly = true)
	WardAggregate getWardAggregateById(Integer id);
	
	@Transactional(readOnly = true)
	List<WardAggregate> getWardAggregatesByLocation(Integer locationId);
	
	WardAggregate saveWardAggregate(WardAggregate wardAggregate);
	
	void deleteWardAggregate(WardAggregate wardAggregate);
	
}
