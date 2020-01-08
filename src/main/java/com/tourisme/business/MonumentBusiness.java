package com.tourisme.business;

import java.util.List;

import com.tourisme.entity.Monument;

public interface MonumentBusiness {

	List<Monument> getAllMonuments();

	Monument saveOrUpdateMonument(Monument m);

	Monument getMonumentById(int id);

	void deleteMonument(int id);

}
