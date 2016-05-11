package org.openmrs.module.nursingkardex;

import java.io.Serializable;
import java.util.Date;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Concept;
import org.openmrs.Encounter;

public class Procedure extends BaseOpenmrsObject implements Serializable {
	
	/**
     * 
     */
	private static final long serialVersionUID = -7331239569708531661L;
	
	private Integer id;
	
	private String uuid;
	
	private PatientCaseRecord patientCaseRecord;
	
	private NursingCareOrder order;
	
	private Encounter encounter;
	
	private Concept procedureConcept;
	
	private String procedureName;
	
	private Date dateSchedule;
	
	private String scheduleStatus;
	
	private String remarks;
	
	private String type;
	
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
	
	public Concept getProcedureConcept() {
		return procedureConcept;
	}
	
	public void setProcedureConcept(Concept procedureConcept) {
		this.procedureConcept = procedureConcept;
	}
	
	public String getProcedureName() {
		return procedureName;
	}
	
	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	
	public Date getDateSchedule() {
		return dateSchedule;
	}
	
	public void setDateSchedule(Date dateSchedule) {
		this.dateSchedule = dateSchedule;
	}
	
	public String getScheduleStatus() {
		return scheduleStatus;
	}
	
	public void setScheduleStatus(String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
