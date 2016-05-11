package org.openmrs.module.nursingkardex;

import java.io.Serializable;
import java.util.Date;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Encounter;

public class ParenteralOrderInfusion extends BaseOpenmrsObject implements Serializable {
	
	/**
     * 
     */
	private static final long serialVersionUID = -7936999206991927225L;
	
	private Integer id;
	
	private String uuid;
	
	private PatientCaseRecord patientCaseRecord;
	
	private NursingCareOrder order;
	
	private Encounter encounter;
	
	private ParenteralOrderType parenteralOrderType;
	
	private String intravenousFluid;
	
	private String volume;
	
	private String additive;
	
	private String regulation;
	
	private String anatomicalSite;
	
	private Date datetimeStarted;
	
	private Date datetimeStopped;
	
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
	
	public ParenteralOrderType getParenteralOrderType() {
		return parenteralOrderType;
	}
	
	public void setParenteralOrderType(ParenteralOrderType parenteralOrderType) {
		this.parenteralOrderType = parenteralOrderType;
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
	
	public String getAnatomicalSite() {
		return anatomicalSite;
	}
	
	public void setAnatomicalSite(String anatomicalSite) {
		this.anatomicalSite = anatomicalSite;
	}
	
	public Date getDatetimeStarted() {
		return datetimeStarted;
	}
	
	public void setDatetimeStarted(Date datetimeStarted) {
		this.datetimeStarted = datetimeStarted;
	}
	
	public Date getDatetimeStopped() {
		return datetimeStopped;
	}
	
	public void setDatetimeStopped(Date datetimeStopped) {
		this.datetimeStopped = datetimeStopped;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
