package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import persistence.AttractionDAO;
import persistence.PromotionDAO;
import persistence.commons.DAOFactory;

public class promotion {

	private int id;
	private String name;
	private String type,typeAttraction;
	private String description;
	private String imagen;
	private boolean capacity;
	private int cost;
	private int discount;
	private List<Integer> attractionContained = new ArrayList<Integer>();

	public promotion(int id, String name, String type, String description, String imagen, boolean capacity, int cost,
			int discount, String typeAttraction) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.imagen = imagen;
		this.capacity = capacity;
		this.cost = cost;
		this.typeAttraction = typeAttraction;
		this.calculateCost();
	}
	
	
 	public boolean isValid() {
		boolean isValid = true;
		
		if(getCost()<0) isValid = false;
		if(getDiscount()<0) isValid = false;
		
		return isValid;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getTypeAttraction() {
		return typeAttraction;
	}


	public void setTypeAttraction(String typeAttraction) {
		this.typeAttraction = typeAttraction;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean getCapacity() {
		hasCapacity();
		return capacity;
	}

	public void setCapacity(boolean capacity) {
		this.capacity = capacity;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public List<Integer> getAttractionContained() {
		return attractionContained;
	}

	public void setAttractionContained(List<Integer> attractionContained) {
		this.attractionContained.addAll(attractionContained);
		calculateCost();
	}

	public boolean hasCapacity() {
		boolean hascapacity = true;
		
		AttractionDAO ad = DAOFactory.getAttractionDAO();
		for(Integer i: attractionContained) {
			Attraction attraction = ad.find(i);
			if (attraction.getCapacity()<=0) {
				hascapacity=false;
			}
		}
		setCapacity(hascapacity);
		return hascapacity;
	}
	
	public void discountCapacity() {
		
		AttractionDAO ad = DAOFactory.getAttractionDAO();
		for(int i : getAttractionContained()) {
			Attraction attraction = ad.find(i);
			attraction.reduceCapacity();
			ad.update(attraction);
		}
		
	}

	public void calculateCost() {

		AttractionDAO aDAO = DAOFactory.getAttractionDAO();
		int cost = 0;
		if (type.toLowerCase().equals("axb")) {

			for (int i = 0; i < attractionContained.size() - 1; i++) {
				Attraction a = aDAO.find(attractionContained.get(i));
				cost += a.getCost();
				this.cost = cost;
			}
		}

		if (type.toLowerCase().equals("porcentual")) {

			for (int i = 0; i < attractionContained.size(); i++) {
				Attraction a = aDAO.find(attractionContained.get(i));
				cost += a.getCost();
				
			}
			cost = cost * (1 - this.discount / 100);
			this.cost = cost;
		}
		
	}

	@Override
	public String toString() {
		return "promotion [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description
				+ ", imagen=" + imagen + ", capacity=" + capacity + ", cost=" + cost + ", discount=" + discount
				+ ", attractionContained=" + attractionContained + "]";
	}
	
	public void ac() {
		
		AttractionDAO aDAO = DAOFactory.getAttractionDAO();
		
		for(Integer i : attractionContained) {
			Attraction a = aDAO.find(i);
		}
	}
	
	public Double getDuration() {
		Double duration = (double) 0;
		AttractionDAO ad = DAOFactory.getAttractionDAO();
		for (int i = 0; i < attractionContained.size(); i++) {
			Attraction a = ad.find(attractionContained.get(i));
			duration += a.getDuration();
		}
		return duration;
	}

}
