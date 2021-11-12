package application.model;

public class Field {
	private String name;
	private String value;

	public Field(String name) {
		this.name = name;
		this.value = new String();
	}

	public Field(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
