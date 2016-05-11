package org.openmrs.module.nursingkardex.web.form;

import java.util.List;

import org.openmrs.module.nursingkardex.Operation;
import org.openmrs.module.nursingkardex.Procedure;

public class ProcedureForm {
	
	private Integer patientCaseRecordId;
	
	private Integer otherEndorsementId;
	
	private String otherEndorsementInstruction;
	
	private Integer referralToNewbornScreenerId;

	private String referralToNewbornScreenerInstruction;
	
	private Integer referralToEnterostomalNurseId;
	
	private String referralToEnterostomalNurseInstruction;
	
	private Integer referralToDiabetesMellitusEducatorId;
	
	private String referralToDiabetesMellitusEducatorInstruction;
	
	private Integer referralToSpiritualMinisterId;
	
	private String referralToSpiritualMinisterInstruction;
	
	private Integer referralToPsychologistOrPsychiatristId;
	
	private String referralToPsychologistOrPsychiatristInstruction;
	
	private Integer grievingMeasuresId;
	
	private String grievingMeasuresInstruction;
	
	private Integer codeId;
	
	private String codeInstruction;
	
	private Integer postMortemCareId;
	
	private String postMortemCareInstruction;
	
	private Integer terminalCleaningId;
	
	private String terminalCleaningInstruction;
	
	private Integer fiveSId;
	
	private String fiveSInstruction;
	
	public Integer getReferralToEnterostomalNurseId() {
		return referralToEnterostomalNurseId;
	}

	public void setReferralToEnterostomalNurseId(
			Integer referralToEnterostomalNurseId) {
		this.referralToEnterostomalNurseId = referralToEnterostomalNurseId;
	}

	public String getReferralToEnterostomalNurseInstruction() {
		return referralToEnterostomalNurseInstruction;
	}

	public void setReferralToEnterostomalNurseInstruction(
			String referralToEnterostomalNurseInstruction) {
		this.referralToEnterostomalNurseInstruction = referralToEnterostomalNurseInstruction;
	}

	public Integer getReferralToDiabetesMellitusEducatorId() {
		return referralToDiabetesMellitusEducatorId;
	}

	public void setReferralToDiabetesMellitusEducatorId(
			Integer referralToDiabetesMellitusEducatorId) {
		this.referralToDiabetesMellitusEducatorId = referralToDiabetesMellitusEducatorId;
	}

	public String getReferralToDiabetesMellitusEducatorInstruction() {
		return referralToDiabetesMellitusEducatorInstruction;
	}

	public void setReferralToDiabetesMellitusEducatorInstruction(
			String referralToDiabetesMellitusEducatorInstruction) {
		this.referralToDiabetesMellitusEducatorInstruction = referralToDiabetesMellitusEducatorInstruction;
	}

	public Integer getReferralToSpiritualMinisterId() {
		return referralToSpiritualMinisterId;
	}

	public void setReferralToSpiritualMinisterId(
			Integer referralToSpiritualMinisterId) {
		this.referralToSpiritualMinisterId = referralToSpiritualMinisterId;
	}

	public String getReferralToSpiritualMinisterInstruction() {
		return referralToSpiritualMinisterInstruction;
	}

	public void setReferralToSpiritualMinisterInstruction(
			String referralToSpiritualMinisterInstruction) {
		this.referralToSpiritualMinisterInstruction = referralToSpiritualMinisterInstruction;
	}

	public Integer getReferralToPsychologistOrPsychiatristId() {
		return referralToPsychologistOrPsychiatristId;
	}

	public void setReferralToPsychologistOrPsychiatristId(
			Integer referralToPsychologistOrPsychiatristId) {
		this.referralToPsychologistOrPsychiatristId = referralToPsychologistOrPsychiatristId;
	}

	public String getReferralToPsychologistOrPsychiatristInstruction() {
		return referralToPsychologistOrPsychiatristInstruction;
	}

	public void setReferralToPsychologistOrPsychiatristInstruction(
			String referralToPsychologistOrPsychiatristInstruction) {
		this.referralToPsychologistOrPsychiatristInstruction = referralToPsychologistOrPsychiatristInstruction;
	}

	public Integer getGrievingMeasuresId() {
		return grievingMeasuresId;
	}

	public void setGrievingMeasuresId(Integer grievingMeasuresId) {
		this.grievingMeasuresId = grievingMeasuresId;
	}

	public String getGrievingMeasuresInstruction() {
		return grievingMeasuresInstruction;
	}

	public void setGrievingMeasuresInstruction(String grievingMeasuresInstruction) {
		this.grievingMeasuresInstruction = grievingMeasuresInstruction;
	}

	public Integer getCodeId() {
		return codeId;
	}

	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}

	public String getCodeInstruction() {
		return codeInstruction;
	}

	public void setCodeInstruction(String codeInstruction) {
		this.codeInstruction = codeInstruction;
	}

	public Integer getPostMortemCareId() {
		return postMortemCareId;
	}

	public void setPostMortemCareId(Integer postMortemCareId) {
		this.postMortemCareId = postMortemCareId;
	}

	public String getPostMortemCareInstruction() {
		return postMortemCareInstruction;
	}

	public void setPostMortemCareInstruction(String postMortemCareInstruction) {
		this.postMortemCareInstruction = postMortemCareInstruction;
	}

	public Integer getTerminalCleaningId() {
		return terminalCleaningId;
	}

	public void setTerminalCleaningId(Integer terminalCleaningId) {
		this.terminalCleaningId = terminalCleaningId;
	}

	public String getTerminalCleaningInstruction() {
		return terminalCleaningInstruction;
	}

	public void setTerminalCleaningInstruction(String terminalCleaningInstruction) {
		this.terminalCleaningInstruction = terminalCleaningInstruction;
	}

	public Integer getFiveSId() {
		return fiveSId;
	}

	public void setFiveSId(Integer fiveSId) {
		this.fiveSId = fiveSId;
	}

	public String getFiveSInstruction() {
		return fiveSInstruction;
	}

	public void setFiveSInstruction(String fiveSInstruction) {
		this.fiveSInstruction = fiveSInstruction;
	}

	private boolean delivery;
	
	private List<Procedure> laboratories;
	
	private List<Procedure> procedures;
	
	private List<Procedure> others;
	
	private List<Operation> operations;
	
	private List<Integer> existingLabs;
	
	private List<Integer> existingProcedures;
	
	private List<Integer> existingOthers;
	
	private List<Integer> existingOperations;
	
	public Integer getPatientCaseRecordId() {
		return patientCaseRecordId;
	}
	
	public void setPatientCaseRecordId(Integer patientCaseRecordId) {
		this.patientCaseRecordId = patientCaseRecordId;
	}

	public Integer getReferralToNewbornScreenerId() {
		return referralToNewbornScreenerId;
	}

	public void setReferralToNewbornScreenerId(Integer referralToNewbornScreenerId) {
		this.referralToNewbornScreenerId = referralToNewbornScreenerId;
	}

	public Integer getOtherEndorsementId() {
		return otherEndorsementId;
	}
	
	public void setOtherEndorsementId(Integer otherEndorsementId) {
		this.otherEndorsementId = otherEndorsementId;
	}

	public String getReferralToNewbornScreenerInstruction() {
		return referralToNewbornScreenerInstruction;
	}

	public void setReferralToNewbornScreenerInstruction(
			String referralToNewbornScreenerInstruction) {
		this.referralToNewbornScreenerInstruction = referralToNewbornScreenerInstruction;
	}
	
	public String getOtherEndorsementInstruction() {
		return otherEndorsementInstruction;
	}
	
	public void setOtherEndorsementInstruction(String otherEndorsementInstruction) {
		this.otherEndorsementInstruction = otherEndorsementInstruction;
	}
	
	public boolean isDelivery() {
		return delivery;
	}
	
	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}
	
	public List<Procedure> getLaboratories() {
		return laboratories;
	}
	
	public void setLaboratories(List<Procedure> laboratories) {
		this.laboratories = laboratories;
	}
	
	public List<Procedure> getProcedures() {
		return procedures;
	}
	
	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}
	
	public List<Integer> getExistingLabs() {
		return existingLabs;
	}
	
	public void setExistingLabs(List<Integer> existingLabs) {
		this.existingLabs = existingLabs;
	}
	
	public List<Integer> getExistingProcedures() {
		return existingProcedures;
	}
	
	public void setExistingProcedures(List<Integer> existingProcedures) {
		this.existingProcedures = existingProcedures;
	}
	
	public List<Procedure> getOthers() {
		return others;
	}
	
	public void setOthers(List<Procedure> others) {
		this.others = others;
	}
	
	public List<Operation> getOperations() {
		return operations;
	}
	
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	public List<Integer> getExistingOthers() {
		return existingOthers;
	}
	
	public void setExistingOthers(List<Integer> existingOthers) {
		this.existingOthers = existingOthers;
	}
	
	public List<Integer> getExistingOperations() {
		return existingOperations;
	}

	public void setExistingOperations(List<Integer> existingOperations) {
		this.existingOperations = existingOperations;
	}
}
