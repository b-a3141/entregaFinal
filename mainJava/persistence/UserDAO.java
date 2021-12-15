package persistence;

import java.util.List;

import model.User;
import persistence.commons.GenericDAO;

public interface UserDAO extends GenericDAO<User> {

	public abstract User findByUsername(String username);
	public List<Integer> attractionObtained(int userId);
	public List<Integer> promotionObtained(int id);
}
