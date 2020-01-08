package com.tourisme.entity;

public class SearchItem {

	private String object;
	private String subjectType;
	
	public SearchItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchItem(String object, String subjectType) {
		super();
		this.object = object;
		this.subjectType = subjectType;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	
	
	
}
