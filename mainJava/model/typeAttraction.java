package model;

public class typeAttraction {
	int id;
	String name;

	public typeAttraction(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean validate() {
		String revisar = this.name;
		return validateNumbers(revisar) || validateSpace(revisar);
	}

	private boolean validateNumbers(String revisar) {
		return revisar.matches(".*\\d.*");

	}

	private boolean validateSpace(String revisar) {
		return revisar.matches(".*\\s.*");
	}



}