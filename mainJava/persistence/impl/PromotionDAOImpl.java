package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.Attraction;
import model.promotion;
import persistence.PromotionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class PromotionDAOImpl implements PromotionDAO {

	@Override
	public promotion find(Integer id) {
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE id=(?)";
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();
			
			promotion promotion = toPromotion(resultados);
			return promotion;
			
			} catch (Exception e) {
				throw new MissingDataException(e);
			}
	}
	
	@Override
	public promotion findByName(promotion promotion) {
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE name=(?)";
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, promotion.getName());
			
			ResultSet resultados = statement.executeQuery();
			
			promotion promotion2 = toPromotion(resultados);
			return promotion2;
			
			} catch (Exception e) {
				throw new MissingDataException(e);
			}
	}

	@Override
	public List<promotion> findAll() {
		
		try {
			String sql = "SELECT * FROM PROMOTIONS WHERE capacity!='false'";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<promotion> promotions = new LinkedList<promotion>();
			while (resultados.next()) {
				promotions.add(toPromotion(resultados));
			}

			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM promotions";
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

	@Override
	public int insert(promotion promotion) {
		try {
			String sql = "INSERT INTO promotions (name,type,descripcion,imagen,capacity,cost,discount,typeAttraction)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			String capacity;
			if(promotion.getCapacity()) { capacity = "true";} else {capacity = "false";}
			
			statement.setString(i++, promotion.getName());
			statement.setString(i++, promotion.getType());
			statement.setString(i++, promotion.getDescription());
			statement.setString(i++, promotion.getImagen());
			statement.setString(i++, capacity);
			   statement.setInt(i++, promotion.getCost());
			   statement.setInt(i++, promotion.getDiscount());
			statement.setString(i++, promotion.getTypeAttraction());
			
			   int rows = statement.executeUpdate();
			   return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public int insertAttractionContained(int idPromotion, List<Integer> lista) {
		int rows = 0;
		
		try {
			String sql = "INSERT INTO attractionInPromotion (promotionId, attractionId) VALUES(?,?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			System.out.println(lista);
			for (Integer integer : lista) {
				statement.setInt(1, idPromotion);
				System.out.println(integer);
				statement.setInt(2, integer);
				statement.executeUpdate();
			}
			
			return rows;
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(promotion promotions) {
		try {
			String sql = "UPDATE promotions SET NAME = ?, TYPE = ?, DESCRIPCION = ?, imagen = ?, CAPACITY = ?, COST = ?, DISCOUNT = ? WHERE ID = ?";


			Connection conn = ConnectionProvider.getConnection();
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int i = 1;
			String capacity = "false";
			statement.setString(i++,promotions.getName());
			statement.setString(i++,promotions.getType());
			statement.setString(i++,promotions.getDescription());
			statement.setString(i++,promotions.getImagen());
			
			if(promotions.getCapacity()) capacity = "true";
			
			statement.setString(i++,capacity);
			statement.setInt(i++,promotions.getCost());
			statement.setInt(i++,promotions.getDiscount());
			statement.setInt(i++,promotions.getId());
			
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(promotion promotion) {
		try {
			String sql = "DELETE FROM promotions WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, promotion.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public promotion toPromotion(ResultSet promotionRegister) throws SQLException {
		//promotion(int id, String name, String type, String description, String imagen, boolean capacity, int cost,int discount)
		boolean capacity=false;
		
		if(promotionRegister.getString(6).toLowerCase().equals("true")) {capacity=true;};
		
		promotion promotion = new promotion(promotionRegister.getInt(1),
				promotionRegister.getString(2),
				promotionRegister.getString(3),
				promotionRegister.getString(4),
				promotionRegister.getString(5),
				capacity,
				promotionRegister.getInt(7),
				promotionRegister.getInt(8),
				promotionRegister.getString(9));
		List<Integer> attractionList = getAttractionsContained(promotionRegister.getInt(1));
		promotion.setAttractionContained(attractionList);
		return promotion;
	}
	
	private List<Integer> getAttractionsContained(int id) {
		List<Integer> attractionList;
		
		try {
			attractionList = new ArrayList<Integer>();
			String sql = "SELECT * FROM attractionInPromotion WHERE promotionId = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			ResultSet resultados = statement.executeQuery();

			while(resultados.next()) {
				attractionList.add(resultados.getInt(2));
			}

			return attractionList;
			
		} catch (Exception e) {
			
			throw new MissingDataException(e);
		}
	}

	
	public static void main(String[] args) {
		PromotionDAO pr = new PromotionDAOImpl();
		
		for(promotion i : pr.findAll()) {
			i.ac();
		}
		
		
		
	}

}
