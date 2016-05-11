package org.openmrs.module.nursingkardex;

import java.io.Serializable;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Encounter;
import org.openmrs.Order;

public class OxygenationOrder extends BaseOpenmrsObject implements Serializable {
	
	/**
     * 
     */
	private static final long serialVersionUID = 8307190635426628892L;
	
	private Integer id;
	
	private String uuid;
	
	private PatientCaseRecord patientCaseRecord;
	
	private NursingCareOrder order;
	
	private Encounter encounter;
	
	private Integer hasMechanicalVentilator;
	
	private String mechanicalVentilatorType;
	
	private Integer flowRateLiterPerMinute;
	
	private String mode;
	
	private Integer tidalVolume;
	
	private Integer fio2Percent;
	
	private Integer pip;
	
	private Integer peep;
	
	private String ieRatio;
	
	private Integer ventilatorRate;
	
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
	
	public PatientCaseRecord getPatientCaseRecord() {
		return patientCaseRecord;
	}
	
	public void setPatientCaseRecord(PatientCaseRecord patientCaseRecord) {
		this.patientCaseRecord = patientCaseRecord;
	}
	
	public NursingCareOrder getOrder() {
		return order;
	}
	
	public void setOrder(NursingCareOrder order) {
		this.order = order;
	}
	
	public Encounter getEncounter() {
		return encounter;
	}
	
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	
	public Integer getHasMechanicalVentilator() {
		return hasMechanicalVentilator;
	}
	
	public void setHasMechanicalVentilator(Integer hasMechanicalVentilator) {
		this.hasMechanicalVentilator = hasMechanicalVentilator;
	}
	
	public String getMechanicalVentilatorType() {
		return mechanicalVentilatorType;
	}
	
	public void setMechanicalVentilatorType(String mechanicalVentilatorType) {
		this.mechanicalVentilatorType = mechanicalVentilatorType;
	}
	
	public Integer getFlowRateLiterPerMinute() {
		return flowRateLiterPerMinute;
	}
	
	public void setFlowRateLiterPerMinute(Integer flowRateLiterPerMinute) {
		this.flowRateLiterPerMinute = flowRateLiterPerMinute;
	}
	
	public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public Integer getTidalVolume() {
		return tidalVolume;
	}
	
	public void setTidalVolume(Integer tidalVolume) {
		this.tidalVolume = tidalVolume;
	}
	
	public Integer getFio2Percent() {
		return fio2Percent;
	}
	
	public void setFio2Percent(Integer fio2Percent) {
		this.fio2Percent = fio2Percent;
	}
	
	public Integer getPip() {
		return pip;
	}
	
	public void setPip(Integer pip) {
		this.pip = pip;
	}
	
	public Integer getPeep() {
		return peep;
	}
	
	public void setPeep(Integer peep) {
		this.peep = peep;
	}
	
	public String getIeRatio() {
		return ieRatio;
	}
	
	public void setIeRatio(String ieRatio) {
		this.ieRatio = ieRatio;
	}
	
	public Integer getVentilatorRate() {
		return ventilatorRate;
	}
	
	public void setVentilatorRate(Integer ventilatorRate) {
		this.ventilatorRate = ventilatorRate;
	}
	
}
