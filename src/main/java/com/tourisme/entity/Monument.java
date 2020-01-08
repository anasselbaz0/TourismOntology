package com.tourisme.entity;

import java.io.Serializable;


public class Monument implements Serializable {
	
	@Override
	public String toString() {
		return "Monument [id=" + id + ", name=" + name + ", address=" + address + ", location=" + location
				+ ", category=" + category + ", security_classification=" + security_classification
				+ ", tourism_classification=" + tourism_classification + "]";
	}

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String address;
	private String location;
	private String category;
	private Integer security_classification;
	private Integer tourism_classification;
	
	public Monument() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monument(String name, String address, String location, String category, Integer security_classification, Integer tourism_classification) {
		super();
		this.name = name;
		this.address = address;
		this.location = location;
		this.category = category;
		this.security_classification = security_classification;
		this.tourism_classification = tourism_classification;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getSecurity_classification() {
		return security_classification;
	}

	public void setSecurity_classification(Integer security_classification) {
		this.security_classification = security_classification;
	}

	public Integer getTourism_classification() {
		return tourism_classification;
	}

	public void setTourism_classification(Integer tourism_classification) {
		this.tourism_classification = tourism_classification;
	}
	
	

}
