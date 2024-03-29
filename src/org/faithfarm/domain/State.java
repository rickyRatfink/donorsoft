package org.faithfarm.domain;

// Generated Sep 19, 2013 1:34:58 PM by Hibernate Tools 3.4.0.CR1

/**
 * State generated by hbm2java
 */
public class State implements java.io.Serializable {

	private Integer id;
	private String label;
	private String value;

	public State() {
	}

	public State(String label, String value) {
		this.label = label;
		this.value = value;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
