package com.tourisme.business;

import java.util.List;

import com.tourisme.dao.GeneralDAO;
import com.tourisme.dao.GeneralDAOImpl;
import com.tourisme.entity.SearchItem;

public class GeneralBusinessImpl implements GeneralBusiness {

	GeneralDAO generalDAO = new GeneralDAOImpl();
	
	@Override
	public List<Object> getSubjects(String obj, String type) {
		return generalDAO.getSubjects(obj, type);
	}


}
