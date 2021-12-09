package model;

import java.util.ArrayList;
import java.util.List;

import persistence.AttractionDAO;
import persistence.commons.DAOFactory;
import utils.Crypt;

public class User {

	private Integer id;
	private String username, passwordHash,typeAttractions;
	private Boolean admin;
	private Integer coins;
	private Double time;
	List<Integer> attractionsOwned = new ArrayList<Integer>();
	List<Integer> promotionsOwned = new ArrayList<Integer>();

	public User(Integer id, String username, String password, Integer coins, Double time, Boolean admin,String typeAttractions) {
		super();
		this.id = id;
		this.username = username;
		this.passwordHash = password;
		this.coins = coins;
		this.time = time;
		this.admin = admin;
		this.typeAttractions = typeAttractions;
	}
	

	public void addToItinerary(Attraction attraction) {
		System.out.println(coins);
		System.out.println(attraction.getCost());
		this.coins -= attraction.getCost();
		
		this.time -= attraction.getDuration();
		attractionsOwned.add(attraction.getId());
		System.out.println(coins);
	}
	public void addToItinerary(promotion promotion) {
		promotionsOwned.add(promotion.getId());
		attractionsOwned.addAll(promotion.getAttractionContained());
		this.coins-=promotion.getCost();
		this.time -=promotion.getDuration();
	}

	public boolean canAfford(Attraction attraction) {
		return attraction.getCost() <= this.coins;
	}
	public boolean canAfford(promotion promotion) {
		return true;
		//return promotion.getCost() <= this.coins;
	}

	public boolean canAttend(Attraction attraction) {
		return attraction.getDuration() <= this.time;
	}
	public boolean canAttend(promotion promotion) {
		return promotion.getDuration() <= this.time;
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
	
	public String getTypeAttractions() {
		return typeAttractions;
	}


	public void setTypeAttractions(String typeAttractions) {
		this.typeAttractions = typeAttractions;
	}


	public List<Integer> getAttractionsOwned() {
		return attractionsOwned;
	}

	public void setAttractionsOwned(List<Integer> attractionsOwned) {
		this.attractionsOwned = attractionsOwned;
	}
	public void addAllAttractionsOwned(List<Integer> attractionsOwned) {
		this.attractionsOwned.addAll(attractionsOwned);
	}
	public void addAttractionsOwned(Integer attractionsOwned) {
		this.attractionsOwned.add(attractionsOwned);
	}

	public List<Integer> getPromotionsOwned() {
		return promotionsOwned;
	}

	public void setPromotionsOwned(List<Integer> promotionsOwned) {
		this.promotionsOwned = promotionsOwned;
	}
	public void addPromotionsOwned(Integer promotionsOwned) {
		this.promotionsOwned.add(promotionsOwned);
	}
	public void addAllPromotionsOwned(List<Integer> promotionsOwned) {
		this.promotionsOwned.addAll(promotionsOwned);
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", typeAttractions="
				+ typeAttractions + ", admin=" + admin + ", coins=" + coins + ", time=" + time + ", attractionsOwned="
				+ attractionsOwned + ", promotionsOwned=" + promotionsOwned + "]";
	}

	
	

}
