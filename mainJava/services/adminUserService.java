package services;

import java.util.List;

import model.User;
import model.promotion;
import persistence.PromotionDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class adminUserService {

	
	public List<User> list(){
		return DAOFactory.getUserDAO().findAll();
	}
	
	//User(Integer id, String username, String password, Integer coins, Double time, Boolean admin,String typeAttractions)
	public User create(String username, String password, Integer coins, Double time, Boolean admin,String typeAttractions) {
		
		UserDAO ud = DAOFactory.getUserDAO();
		
		User user = new User(-1, username, password, coins, time, admin, typeAttractions);
		user.setPassword(password);
		
		ud.insert(user);
		User user2 =  ud.findByUsername(username);
		
		
		return user2;
		
	}
	
	public void update(int id, Integer coins, Double time) {
			
		UserDAO ud = DAOFactory.getUserDAO();
		User    user = ud.find(id);
		
		user.setTime(time);
		user.setCoins(coins);
		
		ud.update(user);
		
	}

	public void      delete(int id) {
		User user = new User(id, null, null, null, null, null, null);
		UserDAO ud = DAOFactory.getUserDAO();
		ud.delete(user);
		
	}
	
	public User find(int id) {
		UserDAO ud = DAOFactory.getUserDAO();
		User user = ud.find(id);
		return user;
	}
	
}