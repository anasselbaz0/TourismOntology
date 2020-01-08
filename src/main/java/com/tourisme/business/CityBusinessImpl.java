package com.tourisme.business;

import java.util.List;

import com.tourisme.dao.CityDAO;
import com.tourisme.dao.CityDAOImpl;
import com.tourisme.entity.City;

public class CityBusinessImpl implements CityBusiness {

	CityDAO cityDAO = new CityDAOImpl();

	@Override
	public List<City> getAllCities() {
		return cityDAO.getAllCities();
	}

	@Override
	public City saveOrUpdateCity(City city) {
		//cityRepository.save(city);
		return cityDAO.saveOrUpdateCity(city);
	}

	@Override
	public City getCityById(int id) {
		return cityDAO.getCityById(id);
	}

	@Override
	public void deleteCity(int id) {
		cityDAO.deleteCity(id);
	}

}
