package org.openmrs.module.nursingkardex.api;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nursingkardex.PhysicianDepartment;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PhysicianDepartmentService extends OpenmrsService {
	
	@Transactional(readOnly = true)  
	List<PhysicianDepartment> getAllPhysicianDepartments();

	@Transactional(readOnly = true)  
	PhysicianDepartment getPhysicianDepartmentById(Integer id);

	@Transactional(readOnly = true)  
	PhysicianDepartment getPhysicianDepartmentByame(String name);

	@Transactional(readOnly = true)  
	PhysicianDepartment savePhysicianDepartment(
			PhysicianDepartment physicianDepartment);

	void deletePhysicianDepartment(PhysicianDepartment physicianDepartment);

}
