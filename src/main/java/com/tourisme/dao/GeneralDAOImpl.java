package com.tourisme.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.graph.Node;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

import com.tourisme.AppConf;
import com.tourisme.Tools;
import com.tourisme.business.MonumentBusiness;
import com.tourisme.business.MonumentBusinessImpl;
import com.tourisme.entity.Monument;
import com.tourisme.entity.SearchItem;

public class GeneralDAOImpl implements GeneralDAO {

	MonumentBusiness monumentBusiness = new MonumentBusinessImpl();
	
	@Override
	public List<Object> getSubjects(String obj, String type) {
		// construction du query
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
				"PREFIX tont: <http://localhost:80/tourism-ontology/1.0#> \n" + 
				"SELECT ?subject\n" + 
				"WHERE { \n" + 
				"		<http://localhost:80/tourism-ontology/1.0#";
		queryString += obj;
		queryString += "> tont:contains ?subject . \n" + 
				"		?subject rdf:type <http://localhost:80/tourism-ontology/1.0#";
		queryString += type;
		queryString += "> .\n" + 
				"}";
		// fin construction du query
		// execution
		// Model model = Tools.executeConstructQuery(queryString);
		ResultSet resultSet = Tools.executeSelectQuery(queryString);
		// Model model = resultSet.getResourceModel();
		List<String> listSubjectsString = this.rs2listString(resultSet);
		List<Object> listSubjects = this.model2list(listSubjectsString, type);
		return listSubjects;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<Object> model2list(List<String> listSubjectsString, String type) {
		switch (type) {
			case "Monument": {
				List<Monument> listMonuments = monumentBusiness.getAllMonuments();
				List<Monument> out = new ArrayList<>();
				if(listMonuments != null && listMonuments.size() > 0) {
					int num = listMonuments.size();
					for(int i=0; i<num - 1; i++) {
						Monument m = listMonuments.get(i);
						String n = AppConf.URI_ONTOLOGY + m.getName().replace(" ", "_");
						if(listSubjectsString.contains(n)) {
							out.add(m);
						}
					}
					
				}
				return (List<Object>) (List) out;
			}
		}
		return null;
	}

	private List<String> rs2listString(ResultSet rs) {
		// StmtIterator result = model.listStatements();
		List<String> listSubjects = new ArrayList<>();
		while (rs.hasNext()) {
			QuerySolution s = rs.nextSolution();
			RDFNode x  = s.get("subject");
	    	String subj = x.toString();
			//Literal c = s.get("subject").asLiteral();
			// Statement st = result.next();
			// Node object = st.asTriple().getObject();
			// listSubjects.add((String) object.getLiteralValue());
	        listSubjects.add(subj);
		}
		return listSubjects;
	}

}
