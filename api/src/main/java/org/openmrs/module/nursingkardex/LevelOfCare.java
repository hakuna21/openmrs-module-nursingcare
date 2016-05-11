package org.openmrs.module.nursingkardex;

import java.io.Serializable;
import java.util.Date;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Encounter;
import org.openmrs.User;

public class LevelOfCare extends BaseOpenmrsObject implements Serializable {
	
	/**
     * 
     */
	private static final long serialVersionUID = 6341022278682463681L;
	
	private Integer id;
	
	private String uuid;
	
	private PatientCaseRecord patientCaseRecord;
	
	private Encounter encounter;
	
	private Integer levelOfCare;
	
	private User creator;
	
	private Date dateCreated;
	
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

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
	
	public Encounter getEncounter() {
		return encounter;
	}
	
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	
	public Integer getLevelOfCare() {
		return levelOfCare;
	}
	
	public void setLevelOfCare(Integer levelOfCare) {
		this.levelOfCare = levelOfCare;
	}
	
}
