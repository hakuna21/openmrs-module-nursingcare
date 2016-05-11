package org.openmrs.module.nursingkardex.web.form;

import java.util.Date;

public class NursingProblemForm {
	
	private Date date;
	
	private String shift;
	
	private Integer patientCaseRecordId;
	
	private Integer problemOne;
	
	private Integer problemTwo;
	
	private Integer problemThree;
	
	private Integer problemFour;
	
	private String others;
	
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
	
	public Integer getPatientCaseRecordId() {
		return patientCaseRecordId;
	}
	
	public void setPatientCaseRecordId(Integer patientCaseRecordId) {
		this.patientCaseRecordId = patientCaseRecordId;
	}
	
	public Integer getProblemOne() {
		return problemOne;
	}
	
	public void setProblemOne(Integer problemOne) {
		this.problemOne = problemOne;
	}
	
	public Integer getProblemTwo() {
		return problemTwo;
	}
	
	public void setProblemTwo(Integer problemTwo) {
		this.problemTwo = problemTwo;
	}
	
	public Integer getProblemThree() {
		return problemThree;
	}
	
	public void setProblemThree(Integer problemThree) {
		this.problemThree = problemThree;
	}
	
	public Integer getProblemFour() {
		return problemFour;
	}
	
	public void setProblemFour(Integer problemFour) {
		this.problemFour = problemFour;
	}
	
	public String getOthers() {
		return others;
	}
	
	public void setOthers(String others) {
		this.others = others;
	}
	
}
