package org.openmrs.module.nursingkardex;

import java.io.Serializable;
import java.util.Date;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Encounter;
import org.openmrs.EncounterType;

public class PatientMovement extends BaseOpenmrsObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9172496423536809203L;
	
	private Integer id;
	
	private String uuid;
	
	private PatientCaseRecord patientCaseRecord;
	
	private Encounter encounter;
	
	private Bed bed;
	
	private Bed previousBed;
	
	private Date movementDatetime;
	
	private String movementShift;
	
	private String remarks;
	
	private EncounterType encounterType;
	
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
	
	public Bed getBed() {
		return bed;
	}
	
	public void setBed(Bed bed) {
		this.bed = bed;
	}
	
	public Bed getPreviousBed() {
    	return previousBed;
    }

    public void setPreviousBed(Bed previousBed) {
    	this.previousBed = previousBed;
    }
	
	public Date getMovementDatetime() {
		return movementDatetime;
	}
	
	public void setMovementDatetime(Date movementDatetime) {
		this.movementDatetime = movementDatetime;
	}
	
	public String getMovementShift() {
		return movementShift;
	}
	
	public void setMovementShift(String movementShift) {
		this.movementShift = movementShift;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public EncounterType getEncounterType() {
		return encounterType;
	}
	
	public void setEncounterType(EncounterType encounterType) {
		this.encounterType = encounterType;
	}
}
