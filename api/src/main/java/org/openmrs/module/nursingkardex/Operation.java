package org.openmrs.module.nursingkardex;

import java.io.Serializable;
import java.util.Date;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Encounter;
import org.openmrs.User;

public class Operation extends BaseOpenmrsObject implements Serializable {
	
	/**
     * 
     */
	private static final long serialVersionUID = -7331239569708531661L;
	
	private Integer id;
	
	private String uuid;
	
	private PatientCaseRecord patientCaseRecord;
	
	private NursingCareOrder order;
	
	private Encounter encounter;
	
	private String operationName;
	
	private String priority;
	
	private Physician performingPhysician;
	
	private Date dateSchedule;
	
	private String scheduleStatus;
	
	private String operationArea;
	
	private User schedulerUser;
	
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
	
	public String getOperationName() {
		return operationName;
	}
	
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public Physician getPerformingPhysician() {
		return performingPhysician;
	}
	
	public void setPerformingPhysician(Physician performingPhysician) {
		this.performingPhysician = performingPhysician;
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
	
	public String getOperationArea() {
		return operationArea;
	}
	
	public void setOperationArea(String operationArea) {
		this.operationArea = operationArea;
	}
	
	public User getSchedulerUser() {
		return schedulerUser;
	}
	
	public void setSchedulerUser(User schedulerUser) {
		this.schedulerUser = schedulerUser;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
