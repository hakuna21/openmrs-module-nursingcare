package org.openmrs.module.nursingkardex.api.db;

import java.util.List;

import org.openmrs.module.nursingkardex.PhysicianDepartment;

public interface PhysicianDepartmentDAO {

	List<PhysicianDepartment> getAllPhysicianDepartments();

	PhysicianDepartment getPhysicianDepartmentById(Integer id);

	PhysicianDepartment getPhysicianDepartmentByame(String name);

	PhysicianDepartment savePhysicianDepartment(
			PhysicianDepartment physicianDepartment);

	void deletePhysicianDepartment(PhysicianDepartment physicianDepartment);

}
