package com.tourisme.business;

import java.util.List;

import com.tourisme.dao.MonumentDAO;
import com.tourisme.dao.MonumentDAOImpl;
import com.tourisme.entity.Monument;

public class MonumentBusinessImpl implements MonumentBusiness {

	MonumentDAO monumentDAO = new MonumentDAOImpl();
	
	@Override
	public List<Monument> getAllMonuments() {
		return monumentDAO.getAllMonuments();
	}

	@Override
	public Monument saveOrUpdateMonument(Monument m) {
		return monumentDAO.saveOrUpdateMonument(m);
	}

	@Override
	public Monument getMonumentById(int id) {
		return monumentDAO.getMonumentById(id);
	}

	@Override
	public void deleteMonument(int id) {
		monumentDAO.deleteMonument(id);
	}

}
