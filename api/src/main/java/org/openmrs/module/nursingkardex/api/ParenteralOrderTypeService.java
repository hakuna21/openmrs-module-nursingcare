package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.ParenteralOrderType;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ParenteralOrderTypeService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<ParenteralOrderType> getAllParentalOrderTypes();
	
	@Transactional(readOnly = true)
	ParenteralOrderType getParenteralOrderTypeById(Integer id);
	
}
