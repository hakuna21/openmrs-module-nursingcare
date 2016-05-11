package org.openmrs.module.nursingkardex;

import java.io.Serializable;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Provider;

public class Physician extends BaseOpenmrsObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4848704544782557017L;
	
	private Integer id;
	
	private String uuid;
	
	private Provider provider;
	
	private PhysicianDepartment physicianDepartment;
	
	private String licenseNumber;
	
	private String position;
	
	private String remarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}public PhysicianDepartment getPhysicianDepartment() {
		return physicianDepartment;
	}

	public void setPhysicianDepartment(PhysicianDepartment physicianDepartment) {
		this.physicianDepartment = physicianDepartment;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
