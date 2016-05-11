package org.openmrs.module.nursingkardex;

import java.io.Serializable;

import org.openmrs.BaseOpenmrsObject;

public class ProblemClassification extends BaseOpenmrsObject implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4157907684534708949L;

	private Integer id;

	private String uuid;

	private String name;

	private String description;

	private String domain;

	private String source;

	private String version;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
