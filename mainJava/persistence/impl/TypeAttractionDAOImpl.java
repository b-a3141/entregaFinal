package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.typeAttraction;
import persistence.typeAttractionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class TypeAttractionDAOImpl implements typeAttractionDAO {

	@Override
	public typeAttraction find(Integer id) {

		try {
			String sql = "SELECT * FROM typeAttractions WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			typeAttraction typeAttraction = toTypeAttraction(resultados);

			return typeAttraction;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<typeAttraction> findAll() {
		try {
			String sql = "SELECT * FROM typeAttractions";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<typeAttraction> typeAttractions = new ArrayList<typeAttraction>();
			while (resultados.next()) {
				typeAttractions.add(toTypeAttraction(resultados));
			}

			return typeAttractions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM typeAttractions";
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
	public int insert(typeAttraction t) {
		try {
			String sql = "INSERT INTO typeAttractions(typeAttractions) VALUES (?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, t.getName());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(typeAttraction t) {
		try {
			String sql = "UPDATE typeAttractions SET typeAttractions = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, t.getName());
			statement.setInt(2, t.getId());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(typeAttraction t) {
		try {
			String sql = "DELETE FROM typeAttractions WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, t.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public typeAttraction findById(String name) {

		try {
			String sql = "SELECT * FROM typeAttractions WHERE typeAttractions = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);

			ResultSet resultados = statement.executeQuery();

			typeAttraction typeAttraction = toTypeAttraction(resultados);

			return typeAttraction;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}


	private typeAttraction toTypeAttraction(ResultSet resulset) throws SQLException {
		return new typeAttraction(resulset.getInt(1), resulset.getString(2));
	}

}