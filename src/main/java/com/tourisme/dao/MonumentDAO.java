package com.tourisme.dao;

import java.util.List;

import com.tourisme.entity.Monument;

public interface MonumentDAO {

	List<Monument> getAllMonuments();

	Monument saveOrUpdateMonument(Monument m);

	Monument getMonumentById(int id);

	void deleteMonument(int id);

}
