package org.openmrs.module.nursingkardex;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Patient;

public class PatientCaseRecord extends BaseOpenmrsObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 561510170357210719L;

	private Integer id;
	
	private String uuid;
	
	private Set<PatientMovement> patientMovements;
	
	private PatientMovement latestPatientMovement;

	private String caseNumber;
	
	private Patient patient;
	
	private Physician physicianInCharge;
	
	private Date datetimeAdmitted;
	
	private String admittingDiagnosis;
	
	private String workingImpression;
	
	private String operationRemarks;
	
	private String finalDiagnosis;
	
	private String mssClassification;
	
	private String mssCardNumber;
	
	private Date datetimeDischarged;
	
	public void addPatientMovement(PatientMovement patientMovement) {
		if (patientMovements == null) {
			patientMovements = new HashSet<PatientMovement>();
		}
		patientMovements.add(patientMovement);
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
	
	public Set<PatientMovement> getPatientMovements() {
		return patientMovements;
	}

	public void setPatientMovements(Set<PatientMovement> patientMovements) {
		this.patientMovements = patientMovements;
	}
	
	public PatientMovement getLatestPatientMovement() {
		return latestPatientMovement;
	}

	public void setLatestPatientMovement(PatientMovement latestPatientMovement) {
		this.latestPatientMovement = latestPatientMovement;
	}
	
	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Physician getPhysicianInCharge() {
		return physicianInCharge;
	}

	public void setPhysicianInCharge(Physician physicianInCharge) {
		this.physicianInCharge = physicianInCharge;
	}

	public Date getDatetimeAdmitted() {
		return datetimeAdmitted;
	}

	public void setDatetimeAdmitted(Date datetimeAdmitted) {
		this.datetimeAdmitted = datetimeAdmitted;
	}

	public String getAdmittingDiagnosis() {
		return admittingDiagnosis;
	}

	public void setAdmittingDiagnosis(String admittingDiagnosis) {
		this.admittingDiagnosis = admittingDiagnosis;
	}

	public String getWorkingImpression() {
		return workingImpression;
	}

	public void setWorkingImpression(String workingImpression) {
		this.workingImpression = workingImpression;
	}

	public String getOperationRemarks() {
		return operationRemarks;
	}

	public void setOperationRemarks(String operationRemarks) {
		this.operationRemarks = operationRemarks;
	}

	public String getFinalDiagnosis() {
		return finalDiagnosis;
	}

	public void setFinalDiagnosis(String finalDiagnosis) {
		this.finalDiagnosis = finalDiagnosis;
	}
	
	public String getMssClassification() {
		return mssClassification;
	}

	public void setMssClassification(String mssClassification) {
		this.mssClassification = mssClassification;
	}

	public String getMssCardNumber() {
		return mssCardNumber;
	}

	public void setMssCardNumber(String mssCardNumber) {
		this.mssCardNumber = mssCardNumber;
	}

	public Date getDatetimeDischarged() {
		return datetimeDischarged;
	}

	public void setDatetimeDischarged(Date datetimeDischarged) {
		this.datetimeDischarged = datetimeDischarged;
	}
	
}
