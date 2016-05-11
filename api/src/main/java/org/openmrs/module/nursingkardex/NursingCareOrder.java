package org.openmrs.module.nursingkardex;

import java.io.Serializable;
import java.util.Date;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Order.Action;
import org.openmrs.Order.Urgency;
import org.openmrs.OrderType;
import org.openmrs.Patient;
import org.openmrs.Provider;
import org.openmrs.User;

public class NursingCareOrder extends BaseOpenmrsObject implements Serializable {
	
	/**
     * 
     */
	private static final long serialVersionUID = -3358503371041537844L;
	
	private Integer orderId;
	
	private String uuid;
	
	private OrderType orderType;
	
	private Concept concept;
	
	private PatientCaseRecord patientCaseRecord;
	
	private Encounter encounter;
	
	private Provider orderer;
	
	private User creator;
	
	private Date dateCreated;
	
	private Patient patient;
	
	private String careSetting;
	
	private Urgency urgency;
	
	private Action action;
	
	private String instruction;
	
	private Date dateStopped;
	
	public Integer getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public OrderType getOrderType() {
		return orderType;
	}
	
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	public Concept getConcept() {
		return concept;
	}
	
	public void setConcept(Concept concept) {
		this.concept = concept;
	}
	
	public PatientCaseRecord getPatientCaseRecord() {
		return patientCaseRecord;
	}
	
	public void setPatientCaseRecord(PatientCaseRecord patientCaseRecord) {
		this.patientCaseRecord = patientCaseRecord;
	}
	
	public Encounter getEncounter() {
		return encounter;
	}
	
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	
	public Provider getOrderer() {
		return orderer;
	}
	
	public void setOrderer(Provider orderer) {
		this.orderer = orderer;
	}
	
	public User getCreator() {
		return creator;
	}
	
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public String getCareSetting() {
		return careSetting;
	}
	
	public void setCareSetting(String careSetting) {
		this.careSetting = careSetting;
	}
	
	public Urgency getUrgency() {
		return urgency;
	}
	
	public void setUrgency(Urgency urgency) {
		this.urgency = urgency;
	}
	
	public Action getAction() {
		return action;
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	
	@Override
	public Integer getId() {
		return orderId;
	}
	
	@Override
	public void setId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public String getInstruction() {
		return instruction;
	}
	
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	public Date getDateStopped() {
		return dateStopped;
	}
	
	public void setDateStopped(Date dateStopped) {
		this.dateStopped = dateStopped;
	}
}
