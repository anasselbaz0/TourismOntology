package com.tourisme.business;

import java.util.List;

import com.tourisme.entity.Country;

public interface CountryBusiness {

	public List<Country> getAllCountries();
	public Country saveOrUpdateCountry(Country country);
	public Country getCountryById(int id);
	public void deleteCountry(int id);
	
	
}
