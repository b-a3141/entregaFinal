package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.oracle.wls.shaded.org.apache.bcel.generic.RETURN;

import model.User;
import model.nullobjects.NullUser;
import persistence.UserDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;

public class UserDAOImpl implements UserDAO {

	public int insert(User user) {
		try {
			String sql = "INSERT INTO USERS (USERNAME, PASSWORD,ADMIN,COINS,TIME,typeAttractions) VALUES (?, ?, ?, ?, ?,?)";
			Connection conn = ConnectionProvider.getConnection();

			int isadmin = (user.getAdmin()) ? 1 : 0;
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setInt(3, isadmin);
			statement.setInt(4, user.getCoins());
			statement.setDouble(5, user.getTime());
			statement.setString(6, user.getTypeAttractions());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(User user) {
		try {
			String sql = "UPDATE USERS SET USERNAME = ?, COINS = ?, TIME = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			System.out.println(user.getCoins());
			int i = 1;
			System.out.println(user.getUsername());
			statement.setString(i++, user.getUsername());
			statement.setInt(i++, user.getCoins());
			statement.setDouble(i++, user.getTime());
			statement.setDouble(i++, user.getId());
			
			int rows = statement.executeUpdate();
			updateBuys(user);
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(User user) {
		try {
			String sql = "DELETE FROM USERS WHERE USERNAME = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public User findByUsername(String username) {
		try {
			String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet resultados = statement.executeQuery();

			User user = NullUser.build();

			if (resultados.next()) {
				user = toUser(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public User find(Integer id) {
		try {
			String sql = "SELECT * FROM USERS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			User user = NullUser.build();

			if (resultados.next()) {
				user = toUser(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM USERS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<User> findAll() {
		try {
			String sql = "SELECT * FROM USERS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<User> usuarios = new LinkedList<User>();
			while (resultados.next()) {
				usuarios.add(toUser(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private User toUser(ResultSet userRegister) throws SQLException {
		User User = new User(userRegister.getInt(1), userRegister.getString(2), userRegister.getString(3),
				userRegister.getInt(5), userRegister.getDouble(6), userRegister.getBoolean(4),
				userRegister.getString(7));

		User.addAllAttractionsOwned(attractionObtained(userRegister.getInt(1)));
		User.addAllPromotionsOwned(promotionObtained(userRegister.getInt(1)));

		return User;

	}
/*
	public List<Integer> attractionObtained(int id) {
		List<Integer> attractionList;

		try {
			attractionList = new ArrayList<Integer>();
			String sql = "SELECT * FROM attractionsObtained WHERE userId = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			while (resultados.next()) {
				
				attractionList.add(resultados.getInt(2));
			}

			return attractionList;

		} catch (Exception e) {

			throw new MissingDataException(e);
		}
	}

	public List<Integer> promotionObtained(int id) {
		List<Integer> promotionList;

		try {
			promotionList = new ArrayList<Integer>();
			String sql = "SELECT * FROM promotionsObtained WHERE userId = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			while (resultados.next()) {
				
				promotionList.add(resultados.getInt(2));
			}

			return promotionList;

		} catch (Exception e) {

			throw new MissingDataException(e);
		}
	}
	
	*/
	
	public void updateBuys(User user) {
		List<Integer> attractionListRegistered;
		List<Integer> promotionListRegistered;
		
		List<Integer> attractionList;
		List<Integer> promotionList;

		try {
			attractionList = user.getAttractionsOwned();
			
			for(Integer i : attractionList) {
				attractionListRegistered = attractionObtained(user.getId());
				if(!attractionListRegistered.contains(i)) {
					String sql = "INSERT INTO attractionsObtained (userId,attractionsId) VALUES(?,?)";
					Connection conn = ConnectionProvider.getConnection();
					PreparedStatement statement = conn.prepareStatement(sql);

					statement.setInt(1, user.getId());
					statement.setInt(2, i);

					int rows = statement.executeUpdate();
				}
				
			}


		} catch (Exception e) {

			throw new MissingDataException(e);
		}
		
		try {
			promotionList = user.getPromotionsOwned();
			
			for(Integer i : promotionList) {
				promotionListRegistered = promotionObtained(user.getId());
				
				if(!promotionListRegistered.contains(i)) {
					
					String sql = "INSERT INTO promotionsObtained (userId,promotionId) VALUES(?,?)";
					Connection conn = ConnectionProvider.getConnection();
					PreparedStatement statement = conn.prepareStatement(sql);

					statement.setInt(1, user.getId());
					statement.setInt(2, i);

					int rows = statement.executeUpdate();
				}
				
			}


		} catch (Exception e) {

			throw new MissingDataException(e);
		}
		
		
	}

	
	@Override
	public List<Integer> attractionObtained(int userId) {
		List<Integer> attractionList;

		try {
			attractionList = new ArrayList<Integer>();
			String sql = "SELECT attractionsId  "
					+ " FROM attractionsObtained "
					+ " WHERE userId = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userId);

			ResultSet resultados = statement.executeQuery();

			while (resultados.next()) {
				attractionList.add(resultados.getInt(1));
			}

			return attractionList;

		} catch (Exception e) {

			throw new MissingDataException(e);
		}
	}
	@Override
	public List<Integer> promotionObtained(int id) {
		List<Integer> promotionList;

		try {
			promotionList = new ArrayList<Integer>();
			String sql = "SELECT * FROM promotionsObtained WHERE userId = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			while (resultados.next()) {
				promotionList.add(resultados.getInt(2));
			}

			return promotionList;

		} catch (Exception e) {

			throw new MissingDataException(e);
		}
	}

	
	
	public static void main(String[] args) {
		UserDAO ud = DAOFactory.getUserDAO();
		System.out.println(ud.find(4));
		/*
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		List<Integer> b = new ArrayList<Integer>();
		b.add(2);
		for(Integer i: a) {
			System.out.println(b.contains(i));
		} */
		
	}

}
