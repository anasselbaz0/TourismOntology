package com.tourisme.business;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.tourisme.entity.SearchItem;

public interface GeneralBusiness {
	
	public List<Object> getSubjects(String obj, String type);

}
