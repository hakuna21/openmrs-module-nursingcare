package org.openmrs.module.nursingkardex.web.form;

import java.util.List;

import org.openmrs.module.nursingkardex.ParenteralOrderInfusion;

public class ParenteralOrderForm {
	
	private Integer patientCaseRecordId;
	
	private ParenteralOrderInfusion parenteralOrder;
	
	private List<ParenteralOrderInfusion> parenteralOrders;
	
	private List<ParenteralOrderInfusion> otherParenteralOrders;
	
	private List<Integer> existingParenteralOrders;
	
	private Integer heplockId;
	
	private Integer intrajugularCatheterId;
	
	private Integer femoralCatheterId;
	
	private Integer subclavianCatheterId;
	
	private Integer arteriovenousFistulaId;
	
	private Integer otherParenteralId;
	
	private Integer chemotherapyId;
	
	public Integer getChemotherapyId() {
		return chemotherapyId;
	}

	public void setChemotherapyId(Integer chemotherapyId) {
		this.chemotherapyId = chemotherapyId;
	}

	public String getChemotherapyInstruction() {
		return chemotherapyInstruction;
	}

	public void setChemotherapyInstruction(String chemotherapyInstruction) {
		this.chemotherapyInstruction = chemotherapyInstruction;
	}

	private String heplockInstruction;
	
	private String intrajugularCatheterInstruction;
	
	private String femoralCatheterInstruction;
	
	private String subclavianCatheterInstruction;
	
	private String arteriovenousFistulaInstruction;
	
	private String chemotherapyInstruction;
	
	private String otherParenteralInstruction;
	
	public Integer getPatientCaseRecordId() {
		return patientCaseRecordId;
	}
	
	public void setPatientCaseRecordId(Integer patientCaseRecordId) {
		this.patientCaseRecordId = patientCaseRecordId;
	}
	
	public ParenteralOrderInfusion getParenteralOrder() {
		return parenteralOrder;
	}
	
	public void setParenteralOrder(ParenteralOrderInfusion parenteralOrder) {
		this.parenteralOrder = parenteralOrder;
	}
	
	public List<ParenteralOrderInfusion> getParenteralOrders() {
		return parenteralOrders;
	}
	
	public void setParenteralOrders(List<ParenteralOrderInfusion> parenteralOrders) {
		this.parenteralOrders = parenteralOrders;
	}
	
	public List<ParenteralOrderInfusion> getOtherParenteralOrders() {
		return otherParenteralOrders;
	}
	
	public void setOtherParenteralOrders(List<ParenteralOrderInfusion> otherParenteralOrders) {
		this.otherParenteralOrders = otherParenteralOrders;
	}
	
	public List<Integer> getExistingParenteralOrders() {
		return existingParenteralOrders;
	}
	
	public void setExistingParenteralOrders(List<Integer> existingParenteralOrders) {
		this.existingParenteralOrders = existingParenteralOrders;
	}
	
	public Integer getHeplockId() {
		return heplockId;
	}
	
	public void setHeplockId(Integer heplockId) {
		this.heplockId = heplockId;
	}
	
	public Integer getIntrajugularCatheterId() {
		return intrajugularCatheterId;
	}
	
	public void setIntrajugularCatheterId(Integer intrajugularCatheterId) {
		this.intrajugularCatheterId = intrajugularCatheterId;
	}
	
	public Integer getFemoralCatheterId() {
		return femoralCatheterId;
	}
	
	public void setFemoralCatheterId(Integer femoralCatheterId) {
		this.femoralCatheterId = femoralCatheterId;
	}
	
	public Integer getSubclavianCatheterId() {
		return subclavianCatheterId;
	}
	
	public void setSubclavianCatheterId(Integer subclavianCatheterId) {
		this.subclavianCatheterId = subclavianCatheterId;
	}
	
	public Integer getArteriovenousFistulaId() {
		return arteriovenousFistulaId;
	}
	
	public void setArteriovenousFistulaId(Integer arteriovenousFistulaId) {
		this.arteriovenousFistulaId = arteriovenousFistulaId;
	}
	
	public String getHeplockInstruction() {
		return heplockInstruction;
	}
	
	public void setHeplockInstruction(String heplockInstruction) {
		this.heplockInstruction = heplockInstruction;
	}
	
	public String getIntrajugularCatheterInstruction() {
		return intrajugularCatheterInstruction;
	}
	
	public void setIntrajugularCatheterInstruction(String intrajugularCatheterInstruction) {
		this.intrajugularCatheterInstruction = intrajugularCatheterInstruction;
	}
	
	public String getFemoralCatheterInstruction() {
		return femoralCatheterInstruction;
	}
	
	public void setFemoralCatheterInstruction(String femoralCatheterInstruction) {
		this.femoralCatheterInstruction = femoralCatheterInstruction;
	}
	
	public String getSubclavianCatheterInstruction() {
		return subclavianCatheterInstruction;
	}
	
	public void setSubclavianCatheterInstruction(String subclavianCatheterInstruction) {
		this.subclavianCatheterInstruction = subclavianCatheterInstruction;
	}
	
	public String getArteriovenousFistulaInstruction() {
		return arteriovenousFistulaInstruction;
	}
	
	public void setArteriovenousFistulaInstruction(String arteriovenousFistulaInstruction) {
		this.arteriovenousFistulaInstruction = arteriovenousFistulaInstruction;
	}
	
	public Integer getOtherParenteralId() {
		return otherParenteralId;
	}
	
	public void setOtherParenteralId(Integer otherParenteralId) {
		this.otherParenteralId = otherParenteralId;
	}
	
	public String getOtherParenteralInstruction() {
		return otherParenteralInstruction;
	}
	
	public void setOtherParenteralInstruction(String otherParenteralInstruction) {
		this.otherParenteralInstruction = otherParenteralInstruction;
	}
}
