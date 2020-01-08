package com.tourisme.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

import com.tourisme.AppConf;
import com.tourisme.Tools;
import com.tourisme.business.CityBusiness;
import com.tourisme.business.CityBusinessImpl;
import com.tourisme.entity.City;
import com.tourisme.entity.Monument;

public class MonumentDAOImpl implements MonumentDAO {

	CityBusiness cityBusiness = new CityBusinessImpl();
	
	@Override
	public List<Monument> getAllMonuments() {
		String queryS = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
				"PREFIX tont: <http://localhost:80/tourism-ontology/1.0#> \n" + 
				"CONSTRUCT {\n" + 
				"		?m tont:name ?name . \n" + 
				"		?m tont:address ?address . \n" + 
				"		?m tont:security_classification ?sec . \n" + 
				"		?m tont:tourism_classification ?tour . \n" + 
				"		?m tont:location ?location . \n" + 
				"		?m tont:category ?category . \n" + 
				"}\n" + 
				"WHERE { \n" + 
				"		?m tont:name ?name . \n" + 
				"		?m tont:address ?address . \n" + 
				"		?m tont:security_classification ?sec . \n" + 
				"		?m tont:tourism_classification ?tour . \n" + 
				"		?m tont:location ?location . \n" + 
				"		?m tont:category ?category .\n" + 
				"}\n";
		Model model = Tools.executeConstructQuery(queryS);
		List<Monument> listMonuments = this.model2list(model);
//		for (City city : listCities) {
//			cityRepo.save(city);
//		}
		return listMonuments;
	}

	private List<Monument> model2list(Model model) {
		StmtIterator result = model.listStatements();
		List<Monument> listMonuments = new ArrayList<>();
		String name = "";
		String address = "";
		Integer sec = 0;
		Integer tou = 0;
		String location = "";
		String category = "";
		int count = 0;
		while (result.hasNext()) {
			Statement st = result.next();
			Node predicate = st.asTriple().getPredicate();
			Node object = st.asTriple().getObject();
			//System.out.println("---->>  " + predicate.toString() + "  " + object.toString());	
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_NAME)) 		{name=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_ADDRESS)) {address=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_SECURITY_C)) {sec=(Integer) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_TOURISM_C)) 	{tou=(Integer) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_LOCATION)) 	{location=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_CATEGORY)) 	{category=(String) object.getLiteralValue(); count++;}
			if(count == 6) { // the 6 args in Monument class are all not empty
				listMonuments.add(new Monument(name,address,location,category,sec,tou));
				count = 0;
			}
		}
		return listMonuments;
	}

	@Override
	public Monument saveOrUpdateMonument(Monument m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Monument getMonumentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMonument(int id) {
		// TODO Auto-generated method stub
		
	}

}
