package model;

import utils.Crypt;

public class User {

	private Integer id;
	private String username, passwordHash;
	private Boolean admin;
	private Integer coins;
	private Double time;

	public User(Integer id, String username, String password, Integer coins, Double time, Boolean admin) {
		super();
		this.id = id;
		this.username = username;
		this.passwordHash = password;
		this.coins = coins;
		this.time = time;
		this.admin = admin;
	}

	public void addToItinerary(Attraction attraction) {
		this.coins -= attraction.getCost();
		this.time -= attraction.getDuration();
		// TODO agregar a su lista
	}

	public boolean canAfford(Attraction attraction) {
		return attraction.getCost() <= this.coins;
	}

	public boolean canAttend(Attraction attraction) {
		return attraction.getDuration() <= this.time;
	}

	public boolean checkPassword(String password) {
		
		return Crypt.match(password, this.passwordHash);
	}

	public Boolean getAdmin() {
		return admin;
	}

	public Integer getCoins() {
		return coins;
	}

	public Integer getId() {
		return id;
	}

	public String getPassword() {
		return passwordHash;
	}

	public Double getTime() {
		return time;
	}

	public String getUsername() {
		return username;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public boolean isNull() {
		return false;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public void setCoins(Integer coins) {
		this.coins = coins;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.passwordHash = Crypt.hash(password);
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + passwordHash + ", admin=" + admin + "]";
	}

}
