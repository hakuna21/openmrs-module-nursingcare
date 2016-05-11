package org.openmrs.module.nursingkardex.report;

public class EndorsementBean {
	
	private String bedNo;
	
	private String nameOfPatient;
	
	private String parenteral;
	
	private String intake;
	
	private String output;
	
	private String monitoring;
	
	private String nursingInterventions;
	
	private String specialEndorsements;
	
	public String getBedNo() {
		return bedNo;
	}
	
	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}
	
	public String getNameOfPatient() {
		return nameOfPatient;
	}
	
	public void setNameOfPatient(String nameOfPatient) {
		this.nameOfPatient = nameOfPatient;
	}
	
	public String getParenteral() {
		return parenteral;
	}
	
	public void setParenteral(String parenteral) {
		this.parenteral = parenteral;
	}
	
	public String getIntake() {
		return intake;
	}
	
	public void setIntake(String intake) {
		this.intake = intake;
	}
	
	public String getOutput() {
		return output;
	}
	
	public void setOutput(String output) {
		this.output = output;
	}
	
	public String getMonitoring() {
		return monitoring;
	}
	
	public void setMonitoring(String monitoring) {
		this.monitoring = monitoring;
	}
	
	public String getNursingInterventions() {
		return nursingInterventions;
	}
	
	public void setNursingInterventions(String nursingInterventions) {
		this.nursingInterventions = nursingInterventions;
	}
	
	public String getSpecialEndorsements() {
		return specialEndorsements;
	}
	
	public void setSpecialEndorsements(String specialEndorsements) {
		this.specialEndorsements = specialEndorsements;
	}
	
}
