package com.tourisme.dao;

import java.util.List;

import com.tourisme.entity.SearchItem;

public interface GeneralDAO {

	List<Object> getSubjects(String obj, String type);

}
