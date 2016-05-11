package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.NursingCareOrder;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface NursingCareOrderService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<NursingCareOrder> getAllNursingCareOrders();
	
	@Transactional(readOnly = true)
	List<NursingCareOrder> getActiveNursingCareOrders();
	
	@Transactional(readOnly = true)
	List<NursingCareOrder> getActiveNursingCareOrderByPatientCaseOrderId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<NursingCareOrder> getAllNursingCareOrderByPatientCaseOrderId(Integer patientCaseRecordId);
	
	@Transactional(readOnly = true)
	List<NursingCareOrder> getActiveNursingCareOrderByPatientCaseOrderAndOrderType(Integer patientCaseRecordId,
	                                                                               Integer orderTypeId);
	
	@Transactional(readOnly = true)
	List<NursingCareOrder> getActiveNursingCareOrdersByOrderType(Integer orderTypeId);
	
	@Transactional(readOnly = true)
	List<NursingCareOrder> getNursingCareOrdersByEncounter(Integer encounterId);
	
	@Transactional(readOnly = true)
	List<NursingCareOrder> getNursingCareOrdersByEncounterAndOrderType(Integer encounterId, Integer orderTypeId);
	
	@Transactional(readOnly = true)
	List<NursingCareOrder> getNursingCareOrderByEncounterAndConcept(Integer encounterId, Integer conceptId);
	
	@Transactional(readOnly = true)
	NursingCareOrder getNursingCareOrderById(Integer id);
	
	NursingCareOrder saveNursingCareOrder(NursingCareOrder nursingCareOrder);
	
	void deleteNursingCareOrder(NursingCareOrder nursingCareOrder);
	
}
