package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.ParenteralOrderType;


public interface ParenteralOrderTypeDAO {
	
	List<ParenteralOrderType> getAllParentalOrderTypes();
	
	ParenteralOrderType getParenteralOrderTypeById(Integer id);
	
}
