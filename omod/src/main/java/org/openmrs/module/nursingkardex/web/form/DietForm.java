package org.openmrs.module.nursingkardex.web.form;

import java.util.List;

import org.openmrs.Concept;
import org.openmrs.module.nursingkardex.DietOrderRequirement;

public class DietForm {
	
	private Integer patientCaseRecordId;
	
	private Integer othersId;
	
	private String othersInstruction;
	
	private List<Concept> dietTypes;
	
	private List<Concept> dietInstructions;
	
	private List<Concept> dietRoutes;
	
	private DietOrderRequirement dietOrderRequirement;
	
	public Integer getPatientCaseRecordId() {
		return patientCaseRecordId;
	}
	
	public void setPatientCaseRecordId(Integer patientCaseRecordId) {
		this.patientCaseRecordId = patientCaseRecordId;
	}
	
	public Integer getOthersId() {
		return othersId;
	}
	
	public void setOthersId(Integer othersId) {
		this.othersId = othersId;
	}
	
	public String getOthersInstruction() {
		return othersInstruction;
	}
	
	public void setOthersInstruction(String othersInstruction) {
		this.othersInstruction = othersInstruction;
	}
	
	public List<Concept> getDietInstructions() {
		return dietInstructions;
	}
	
	public void setDietInstructions(List<Concept> dietInstructions) {
		this.dietInstructions = dietInstructions;
	}
	
	public List<Concept> getDietTypes() {
		return dietTypes;
	}
	
	public void setDietTypes(List<Concept> dietTypes) {
		this.dietTypes = dietTypes;
	}
	
	public List<Concept> getDietRoutes() {
		return dietRoutes;
	}
	
	public void setDietRoutes(List<Concept> dietRoutes) {
		this.dietRoutes = dietRoutes;
	}
	
	public DietOrderRequirement getDietOrderRequirement() {
		return dietOrderRequirement;
	}
	
	public void setDietOrderRequirement(DietOrderRequirement dietOrderRequirement) {
		this.dietOrderRequirement = dietOrderRequirement;
	}
}
