package org.openmrs.module.nursingkardex.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nursingkardex.PhysicianDepartment;
import org.openmrs.module.nursingkardex.api.PhysicianDepartmentService;
import org.openmrs.module.nursingkardex.api.db.PhysicianDepartmentDAO;

public class PhysicianDepartmentServiceImpl extends BaseOpenmrsService
		implements PhysicianDepartmentService {

	protected final Log log = LogFactory.getLog(this.getClass());
	private PhysicianDepartmentDAO dao;

	public PhysicianDepartmentDAO getDao() {
		return dao;
	}

	public void setDao(PhysicianDepartmentDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<PhysicianDepartment> getAllPhysicianDepartments() {
		return dao.getAllPhysicianDepartments();
	}

	@Override
	public PhysicianDepartment getPhysicianDepartmentById(Integer id) {
		return dao.getPhysicianDepartmentById(id);
	}

	@Override
	public PhysicianDepartment getPhysicianDepartmentByame(String name) {
		return dao.getPhysicianDepartmentByame(name);
	}

	@Override
	public PhysicianDepartment savePhysicianDepartment(
			PhysicianDepartment physicianDepartment) {
		return dao.savePhysicianDepartment(physicianDepartment);
	}

	@Override
	public void deletePhysicianDepartment(
			PhysicianDepartment physicianDepartment) {
		dao.deletePhysicianDepartment(physicianDepartment);
	}

}
