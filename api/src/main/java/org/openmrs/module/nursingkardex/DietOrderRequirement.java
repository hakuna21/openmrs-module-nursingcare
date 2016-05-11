package org.openmrs.module.nursingkardex;

import java.io.Serializable;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Encounter;

public class DietOrderRequirement extends BaseOpenmrsObject implements Serializable {
	
	/**
     * 
     */
	private static final long serialVersionUID = -1579382993884323721L;
	
	private Integer id;
	
	private String uuid;
	
	private PatientCaseRecord patientCaseRecord;
	
	private NursingCareOrder order;
	
	private Encounter encounter;
	
	private String calories;
	
	private String carbohydrates;
	
	private String protein;
	
	private String fats;
	
	private String sodium;
	
	private Integer fluidRestrictionMl;
	
	private String route;

	private Integer fluidRequirementMlPerKg;
	
	private Integer sterileWaterMl;
	
	private String sodiumChloride;
	
	private String aminoAcids;
	
	private String dextrose;
	
	private String calciumGluconate;
	
	private String magnesiumSulfate;
	
	private String multivitamins;
	
	private String lipids;
	
	private String insulin;

	private String tpn;
	
	private Integer totalVolume;

	private String requestedBy;

	private String orderType;

	private String indication;

	private String duration;

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
	
	public NursingCareOrder getOrder() {
		return order;
	}
	
	public void setOrder(NursingCareOrder order) {
		this.order = order;
	}
	
	public Encounter getEncounter() {
		return encounter;
	}
	
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	
	public String getCalories() {
		return calories;
	}
	
	public void setCalories(String calories) {
		this.calories = calories;
	}
	
	public String getCarbohydrates() {
		return carbohydrates;
	}
	
	public void setCarbohydrates(String carbohydrates) {
		this.carbohydrates = carbohydrates;
	}
	
	public String getProtein() {
		return protein;
	}
	
	public void setProtein(String protein) {
		this.protein = protein;
	}
	
	public String getFats() {
		return fats;
	}
	
	public void setFats(String fats) {
		this.fats = fats;
	}
	
	public String getSodium() {
		return sodium;
	}
	
	public void setSodium(String sodium) {
		this.sodium = sodium;
	}
	
	public Integer getFluidRestrictionMl() {
		return fluidRestrictionMl;
	}
	
	public void setFluidRestrictionMl(Integer fluidRestrictionMl) {
		this.fluidRestrictionMl = fluidRestrictionMl;
	}
	
	public String getRoute() {
		return route;
	}
	
	public void setRoute(String route) {
		this.route = route;
	}

	public Integer getFluidRequirementMlPerKg() {
		return fluidRequirementMlPerKg;
	}

	public void setFluidRequirementMlPerKg(Integer fluidRequirementMlPerKg) {
		this.fluidRequirementMlPerKg = fluidRequirementMlPerKg;
	}

	public Integer getSterileWaterMl() {
		return sterileWaterMl;
	}

	public void setSterileWaterMl(Integer sterileWaterMl) {
		this.sterileWaterMl = sterileWaterMl;
	}

	public String getSodiumChloride() {
		return sodiumChloride;
	}

	public void setSodiumChloride(String sodiumChloride) {
		this.sodiumChloride = sodiumChloride;
	}

	public String getAminoAcids() {
		return aminoAcids;
	}

	public void setAminoAcids(String aminoAcids) {
		this.aminoAcids = aminoAcids;
	}

	public String getDextrose() {
		return dextrose;
	}

	public void setDextrose(String dextrose) {
		this.dextrose = dextrose;
	}

	public String getCalciumGluconate() {
		return calciumGluconate;
	}

	public void setCalciumGluconate(String calciumGluconate) {
		this.calciumGluconate = calciumGluconate;
	}

	public String getMagnesiumSulfate() {
		return magnesiumSulfate;
	}

	public void setMagnesiumSulfate(String magnesiumSulfate) {
		this.magnesiumSulfate = magnesiumSulfate;
	}

	public String getMultivitamins() {
		return multivitamins;
	}

	public void setMultivitamins(String multivitamins) {
		this.multivitamins = multivitamins;
	}

	public String getLipids() {
		return lipids;
	}

	public void setLipids(String lipids) {
		this.lipids = lipids;
	}

	public String getInsulin() {
		return insulin;
	}

	public void setInsulin(String insulin) {
		this.insulin = insulin;
	}
	
	public String getTpn() {
		return tpn;
	}

	public void setTpn(String tpn) {
		this.tpn = tpn;
	}

	public Integer getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(Integer totalVolume) {
		this.totalVolume = totalVolume;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
