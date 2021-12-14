package model;

import java.util.HashMap;
import java.util.Map;

public class Attraction {

	private Integer id;
	private String name;
	private Integer cost;
	private Double duration;
	private Integer capacity;
	private String descripcion;
	private String imagen;
	private String type;
	
	private Map<String, String> errors;
	
	public Attraction(Integer id, String name, Integer cost, Double duration, Integer capacity,
			String descripcion, String imagen, String type) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.duration = duration;
		this.capacity = capacity;
		this.descripcion = descripcion;
		this.imagen= imagen;
		this.type = type;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescrpcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (cost <= 0) {
			errors.put("cost", "Debe ser positivo");
		}
		if (duration <= 0) {
			errors.put("duration", "Debe ser positivo");
		}
		if (capacity <= 0) {
			errors.put("capacity", "Debe ser positivo");
		}
		if (descripcion.length()<20) {
			errors.put("descripcion", "Debe ser mayor a 20 caracteres");
		}
		if (imagen.equals("")) {
			errors.put("imagen", "Debe proporcionar imagen");
		}
		if (type.equals("")) {
			errors.put("type", "Debe proporcionar type. Debe ser una sola palabra, no mayor a 15 caracteres alfabéticos.");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	public void reduceCapacity() {
		this.capacity--;
	}
	
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Attraction [id=" + id + ", name=" + name + ", cost=" + cost + ", duration=" + duration + ", capacity="
				+ capacity + "]";
	}

	public boolean canHost(int i) {
		return capacity >= i;
	}

	public void host(int i) {
		this.capacity -= i;
	}

	
	
}
