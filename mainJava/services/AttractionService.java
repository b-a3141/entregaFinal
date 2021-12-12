package services;

import java.util.List;

import model.Attraction;
import model.User;
import persistence.AttractionDAO;
import persistence.commons.DAOFactory;

public class AttractionService {

	public List<Attraction> list() {
		return DAOFactory.getAttractionDAO().findAll();
	}

	public List<Attraction> getPreferidas(User user) {
		return DAOFactory.getAttractionDAO().findPreferidas(user);
	}
	
	public List<Attraction> getNotPreferidas(User user) {
		return DAOFactory.getAttractionDAO().findNotPreferidas(user);
	}
	
	
	public Attraction create(String name, Integer cost, Double duration, 
			Integer capacity, String descripcion, String imagen,String type) {

		Attraction attraction = new Attraction(-1, name, cost, duration, capacity, descripcion, imagen, type);

		if (attraction.isValid()) {
			AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
			attractionDAO.insert(attraction);

		}

		return attraction;
	}

	public Attraction update(Integer id, String name, Integer cost, Double duration, 
			Integer capacity, String descripcion, String imagen) {

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		Attraction attraction = attractionDAO.find(id);

		attraction.setName(name);
		attraction.setCost(cost);
		attraction.setDuration(duration);
		attraction.setCapacity(capacity);
		attraction.setDescrpcion(descripcion);
		attraction.setImagen(imagen);

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public void delete(Integer id) {
		Attraction attraction = new Attraction(id, null, null, null, null, null, null, null);

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.delete(attraction);
	}

	public Attraction find(Integer id) {
		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		return attractionDAO.find(id);
	}

}
