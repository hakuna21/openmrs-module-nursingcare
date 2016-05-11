package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.DietOrderRequirement;
import org.openmrs.module.nursingkardex.OxygenationOrder;
import org.openmrs.module.nursingkardex.api.OxygenationOrderService;
import org.openmrs.module.nursingkardex.api.db.OxygenationOrderDAO;

public class OxygenationOrderServiceImpl extends BaseOpenmrsService implements OxygenationOrderService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private OxygenationOrderDAO dao;
	
	public OxygenationOrderDAO getDao() {
		return dao;
	}
	
	public void setDao(OxygenationOrderDAO dao) {
		this.dao = dao;
	}

	@Override
    public List<OxygenationOrder> getAllOxygenationOrder() {
	    return dao.getAllOxygenationOrder();
    }
	
	@Override
	public List<OxygenationOrder> getOxygenationOrdersByPatientCaseRecordId(Integer patientCaseRecordId) {
		return dao.getOxygenationOrdersByPatientCaseRecordId(patientCaseRecordId);
	}

	@Override
    public List<OxygenationOrder> getOxygenationOrdersByEncounter(Integer encounterId) {
	    return dao.getOxygenationOrderByEncounters(encounterId);
    }

	@Override
    public OxygenationOrder getOxygenationOrderById(Integer id) {
	    return dao.getOxygenationOrderById(id);
    }

	@Override
    public OxygenationOrder saveOxygenationOrder(OxygenationOrder oxygenationOrder) {
	    return dao.saveOxygenationOrder(oxygenationOrder);
    }

	@Override
    public void deleteOxygenationOrder(OxygenationOrder oxygenationOrder) {
	    dao.deleteOxygenationOrder(oxygenationOrder);
    }
	
	
}
