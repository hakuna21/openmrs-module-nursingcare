package org.openmrs.module.nursingkardex.util;

import java.io.Serializable;

public class SearchKardexObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2045328757785871631L;

	private String name;

	private Integer bedId;

	private Integer physicianDepartmentId;

	private Integer physicianId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBedId() {
		return bedId;
	}

	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}

	public Integer getPhysicianDepartmentId() {
		return physicianDepartmentId;
	}

	public void setPhysicianDepartmentId(Integer physicianDepartmentId) {
		this.physicianDepartmentId = physicianDepartmentId;
	}

	public Integer getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(Integer physicianId) {
		this.physicianId = physicianId;
	}
	
}
