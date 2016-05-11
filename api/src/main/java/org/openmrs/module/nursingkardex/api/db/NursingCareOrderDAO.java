package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.NursingCareOrder;

public interface NursingCareOrderDAO {
	
	List<NursingCareOrder> getAllNursingCareOrders();
	
	List<NursingCareOrder> getActiveNursingCareOrders();
	
	List<NursingCareOrder> getNursingCareOrdersByPatientCaseOrderId(Integer patientCaseRecordId, boolean activeOnly);
	
	List<NursingCareOrder> getActiveNursingCareOrderByPatientCaseOrderAndOrderType(Integer patientCaseRecordId,
	                                                                               Integer orderTypeId);
	
	List<NursingCareOrder> getActiveNursingCareOrdersByOrderType(Integer orderTypeId);
	
	List<NursingCareOrder> getNursingCareOrdersByEncounter(Integer encounterId);
	
	List<NursingCareOrder> getNursingCareOrdersByEncounterAndOrderType(Integer encounterId, Integer orderTypeId);
	
	List<NursingCareOrder> getNursingCareOrderByEncounterAndConcept(Integer encounterId, Integer conceptId);
	
	NursingCareOrder getNursingCareOrderById(Integer id);
	
	NursingCareOrder saveNursingCareOrder(NursingCareOrder nursingCareOrder);
	
	void deleteNursingCareOrder(NursingCareOrder nursingCareOrder);
	
}
