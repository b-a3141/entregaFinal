package services;

import java.util.List;

import model.typeAttraction;
import persistence.typeAttractionDAO;
import persistence.commons.DAOFactory;

public class typeAttractionService {


	public List<typeAttraction> List(){
		return DAOFactory.getTypeAttraction().findAll();
	}

	public typeAttraction create(String name) {
		typeAttractionDAO typeAttractionDAO = DAOFactory.getTypeAttraction();

		typeAttraction typeAttraction = new typeAttraction(-1, name);
		if(!typeAttraction.validate()) {
			typeAttractionDAO.insert(typeAttraction);
			typeAttraction typeAttraction2= typeAttractionDAO.findById(name);
			return typeAttraction2;
		}

		return new typeAttraction((Integer) null, null);
	}

	public typeAttraction update(int id, String name) {
		typeAttractionDAO typeAttractionDAO = DAOFactory.getTypeAttraction();
		typeAttraction    typeAttraction    = typeAttractionDAO.find(id);
		typeAttraction.setName(name);
		typeAttractionDAO.update(typeAttraction);
		typeAttraction    typeAttraction2   = typeAttractionDAO.find(id);
		return typeAttraction2;
	}

	public void delete(int id) {
		typeAttractionDAO typeAttractionDAO = DAOFactory.getTypeAttraction();
		typeAttraction typeAttraction = typeAttractionDAO.find(id);
		typeAttractionDAO.delete(typeAttraction);
	}

	public typeAttraction find(int id) {
		typeAttractionDAO typeAttractionDAO = DAOFactory.getTypeAttraction();
		return typeAttractionDAO.find(id);
	}


}