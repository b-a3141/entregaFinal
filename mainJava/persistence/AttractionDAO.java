package persistence;

import java.util.List;

import model.Attraction;
import model.User;
import persistence.commons.GenericDAO;

public interface AttractionDAO extends GenericDAO<Attraction> {

	public abstract List<Attraction> getAtraccionesPreferidas(User user);
}
