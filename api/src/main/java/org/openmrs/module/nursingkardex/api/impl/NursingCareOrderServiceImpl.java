package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.NursingCareOrder;
import org.openmrs.module.nursingkardex.api.NursingCareOrderService;
import org.openmrs.module.nursingkardex.api.db.NursingCareOrderDAO;
import org.springframework.transaction.annotation.Transactional;

public class NursingCareOrderServiceImpl extends BaseOpenmrsService implements NursingCareOrderService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private NursingCareOrderDAO dao;
	
	public NursingCareOrderDAO getDao() {
		return dao;
	}
	
	public void setDao(NursingCareOrderDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<NursingCareOrder> getAllNursingCareOrders() {
		return dao.getAllNursingCareOrders();
	}
	
	@Override
	public List<NursingCareOrder> getActiveNursingCareOrders() {
		return dao.getActiveNursingCareOrders();
	}
	
	@Override
	public List<NursingCareOrder> getActiveNursingCareOrderByPatientCaseOrderId(Integer patientCaseRecordId) {
		return dao.getNursingCareOrdersByPatientCaseOrderId(patientCaseRecordId, true);
	}
	
	@Override
	public List<NursingCareOrder> getAllNursingCareOrderByPatientCaseOrderId(Integer patientCaseRecordId) {
		return dao.getNursingCareOrdersByPatientCaseOrderId(patientCaseRecordId, false);
	}
	
	@Override
	public List<NursingCareOrder> getActiveNursingCareOrderByPatientCaseOrderAndOrderType(Integer patientCaseRecordId, Integer orderTypeId) {
		return dao.getActiveNursingCareOrderByPatientCaseOrderAndOrderType(patientCaseRecordId, orderTypeId);
	}
	
	@Override
	public List<NursingCareOrder> getActiveNursingCareOrdersByOrderType(Integer orderTypeId) {
		return dao.getActiveNursingCareOrdersByOrderType(orderTypeId);
	}
	
	@Override
	public List<NursingCareOrder> getNursingCareOrdersByEncounter(Integer encounterId) {
		return dao.getNursingCareOrdersByEncounter(encounterId);
	}
	
	@Override
	public List<NursingCareOrder> getNursingCareOrdersByEncounterAndOrderType(Integer encounterId, Integer orderTypeId) {
		return dao.getNursingCareOrdersByEncounterAndOrderType(encounterId, orderTypeId);
	}
	
	@Override
	public List<NursingCareOrder> getNursingCareOrderByEncounterAndConcept(Integer encounterId, Integer conceptId) {
		return dao.getNursingCareOrderByEncounterAndConcept(encounterId, conceptId);
	}
	
	@Override
	public NursingCareOrder getNursingCareOrderById(Integer id) {
		return dao.getNursingCareOrderById(id);
	}
	
	@Override
	public NursingCareOrder saveNursingCareOrder(NursingCareOrder nursingCareOrder) {
		return dao.saveNursingCareOrder(nursingCareOrder);
	}
	
	@Override
	public void deleteNursingCareOrder(NursingCareOrder nursingCareOrder) {
		dao.deleteNursingCareOrder(nursingCareOrder);
	}
	
}
