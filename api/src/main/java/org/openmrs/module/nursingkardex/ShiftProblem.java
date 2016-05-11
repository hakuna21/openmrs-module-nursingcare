package org.openmrs.module.nursingkardex;

import java.io.Serializable;
import java.util.Date;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Encounter;
import org.openmrs.User;

public class ShiftProblem extends BaseOpenmrsObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7441244277685917097L;
	
	private Integer id;
	
	private String uuid;
	
	private PatientCaseRecord patientCaseRecord;
	
	private Encounter encounter;
	
	private ProblemClassification problemClassification;
	
	private Date date;
	
	private String shift;
	
	private String problemText;
	
	private Integer activeProblem;
	
	private User creator;
	
	private Date dateCreated;
	
	private Date dateStopped;
	
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
	
	public ProblemClassification getProblemClassification() {
		return problemClassification;
	}
	
	public void setProblemClassification(ProblemClassification problemClassification) {
		this.problemClassification = problemClassification;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getShift() {
		return shift;
	}
	
	public void setShift(String shift) {
		this.shift = shift;
	}
	
	public String getProblemText() {
		return problemText;
	}
	
	public void setProblemText(String problemText) {
		this.problemText = problemText;
	}
	
	public Integer getActiveProblem() {
		return activeProblem;
	}
	
	public void setActiveProblem(Integer activeProblem) {
		this.activeProblem = activeProblem;
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
	
	public Date getDateStopped() {
		return dateStopped;
	}
	
	public void setDateStopped(Date dateStopped) {
		this.dateStopped = dateStopped;
	}
}
