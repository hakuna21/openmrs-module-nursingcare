package org.openmrs.module.nursingkardex.web.form;

import org.openmrs.module.nursingkardex.WardAggregate;

public class WardAggregateForm {
	
	private Integer locationId;
	
	private WardAggregate linenChange;
	
	private WardAggregate oral;
	
	private WardAggregate topical;
	
	private WardAggregate intravenous;
	
	private WardAggregate intradermal;
	
	private WardAggregate intramuscular;
	
	private WardAggregate subcutaneous;
	
	private WardAggregate drops;
	
	private WardAggregate suppositories;
	
	private WardAggregate enemaIrigation;
	
	private WardAggregate others;
	
	public Integer getLocationId() {
		return locationId;
	}
	
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	
	public WardAggregate getLinenChange() {
		return linenChange;
	}
	
	public void setLinenChange(WardAggregate linenChange) {
		this.linenChange = linenChange;
	}
	
	public WardAggregate getOral() {
		return oral;
	}
	
	public void setOral(WardAggregate oral) {
		this.oral = oral;
	}
	
	public WardAggregate getTopical() {
		return topical;
	}
	
	public void setTopical(WardAggregate topical) {
		this.topical = topical;
	}
	
	public WardAggregate getIntravenous() {
		return intravenous;
	}
	
	public void setIntravenous(WardAggregate intravenous) {
		this.intravenous = intravenous;
	}
	
	public WardAggregate getIntradermal() {
		return intradermal;
	}
	
	public void setIntradermal(WardAggregate intradermal) {
		this.intradermal = intradermal;
	}
	
	public WardAggregate getIntramuscular() {
		return intramuscular;
	}
	
	public void setIntramuscular(WardAggregate intramuscular) {
		this.intramuscular = intramuscular;
	}
	
	public WardAggregate getSubcutaneous() {
		return subcutaneous;
	}
	
	public void setSubcutaneous(WardAggregate subcutaneous) {
		this.subcutaneous = subcutaneous;
	}
	
	public WardAggregate getDrops() {
		return drops;
	}
	
	public void setDrops(WardAggregate drops) {
		this.drops = drops;
	}
	
	public WardAggregate getSuppositories() {
		return suppositories;
	}
	
	public void setSuppositories(WardAggregate suppositories) {
		this.suppositories = suppositories;
	}
	
	public WardAggregate getEnemaIrigation() {
		return enemaIrigation;
	}
	
	public void setEnemaIrigation(WardAggregate enemaIrigation) {
		this.enemaIrigation = enemaIrigation;
	}
	
	public WardAggregate getOthers() {
		return others;
	}
	
	public void setOthers(WardAggregate others) {
		this.others = others;
	}
	
}
