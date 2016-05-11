package org.openmrs.module.nursingkardex;

import java.io.Serializable;

import org.openmrs.BaseOpenmrsObject;

public class ParenteralOrderType extends BaseOpenmrsObject implements Serializable {
	
	/**
     * 
     */
	private static final long serialVersionUID = -4210767096237577513L;
	
	private Integer id;
	
	private String uuid;
	
	private String intravenousFluid;
	
	private String volume;
	
	private String additive;
	
	private String regulation;
	
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
	}
	
	public String getIntravenousFluid() {
		return intravenousFluid;
	}
	
	public void setIntravenousFluid(String intravenousFluid) {
		this.intravenousFluid = intravenousFluid;
	}
	
	public String getVolume() {
		return volume;
	}
	
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	public String getAdditive() {
		return additive;
	}
	
	public void setAdditive(String additive) {
		this.additive = additive;
	}
	
	public String getRegulation() {
		return regulation;
	}
	
	public void setRegulation(String regulation) {
		this.regulation = regulation;
	}
	
}
