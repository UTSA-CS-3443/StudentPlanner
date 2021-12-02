package application.model;

/**
 * The Field class represents fields to an entry, and can have any name, along with a String value.
 * 
 * @author Stephanie Bassey, Lucian Williams, Azrah Al Rabeeah
 */
public class Field {
	private String name;
	private String value;

	/**
	 * Initializes a new Field Object with String name.
	 * 
	 * @param name The name of the Field.
	 */
	public Field(String name) {
		this.name = name;
		this.value = new String();
	}

	/**
	 * Initializes a new Field Object with String name and String value.
	 * 
	 * @param name The name of the Field.
	 * @param value The value of the Field.
	 */
	public Field(String name, String value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Returns the name of the Field.
	 * 
	 * @return the name of the Field.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the Field to the provided name.
	 * 
	 * @param name The new name of the Field.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the value of the Field.
	 * 
	 * @return the value of the Field.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value of the Field to the provided value.
	 * 
	 * @param value The new value of the Field.
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
