package persistence;
import model.typeAttraction;
import persistence.commons.GenericDAO;

public interface typeAttractionDAO extends GenericDAO<typeAttraction> {
	
	public typeAttraction findById(String name);
}
