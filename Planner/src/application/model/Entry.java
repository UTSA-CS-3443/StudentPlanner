package application.model;

import java.util.ArrayList;

/**
 * The Entry class represents entries in a schedule with any kind of attached data, and organization using tags.
 * Each Entry object has a String name, ArrayList of Fields and ArrayList of Tags.
 * 
 * @author Stephanie Bassey, Lucian Williams, Azrah Al Rabeeah
 */
public class Entry {
	private String name;
	private ArrayList<Field> fields;
	private ArrayList<String> tags;

	/**
	 * Initializes a new Entry Object with String name.
	 * 
	 * @param name The name of the Entry.
	 */
	public Entry(String name) {
		this.name = name;
		this.fields = new ArrayList<Field>();
		this.tags = new ArrayList<String>();
	}

	/**
	 * Initializes a new Entry Object with String name, an ArrayList of Fields, and an ArrayList of Tags.
	 * 
	 * @param name The name of the Entry.
	 * @param fields The ArrayList of Fields.
	 * @param tags The ArrayList of Tags.
	 */
	public Entry(String name, ArrayList<Field> fields, ArrayList<String> tags) {
		this.name = name;
		this.fields = fields;
		this.tags = tags;
	}

	/**
	 * Returns the name of the Entry.
	 * 
	 * @return the name of the Entry.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the Entry to the provided name.
	 * 
	 * @param name The new name of the Entry.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the fields of the Entry.
	 * 
	 * @return the fields of the Entry.
	 */
	public ArrayList<Field> getFields() {
		return fields;
	}

	/**
	 * Sets the fields of the Entry to the provided fields.
	 * 
	 * @param fields The new fields of the Entry.
	 */
	public void setFields(ArrayList<Field> fields) {
		this.fields = fields;
	}

	/**
	 * Returns the tags of the Entry.
	 * 
	 * @return the tags of the Entry.
	 */
	public ArrayList<String> getTags() {
		return tags;
	}

	/**
	 * Sets the tags of the Entry to the provided tags.
	 * 
	 * @param tags The new tags of the Entry.
	 */
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	/**
	 * Adds a field to the Entry.
	 * 
	 * @param field The new field.
	 */
	public void addField(Field field) {
		fields.add(field);
	}

	/**
	 * Returns the field of the Entry with the given name or an empty field with the same name if not found.
	 * 
	 * @return the field of the Entry.
	 */
	public Field getField(String name) {
		for (int i = 0; i < fields.size(); i++)
			if (fields.get(i).getName().equals(name))
				return fields.get(i);

		return new Field(name);
	}

	/**
	 * Removes and returns the field of the Entry with the given name or null if not found.
	 * 
	 * @return the field of the Entry.
	 */
	public Field removeField(String name) {
		for (int i = 0; i < fields.size(); i++)
			if (fields.get(i).getName().equals(name))
				return fields.remove(i);

		return null;
	}

	/**
	 * Removes the field from the Entry and returns true if found, and false otherwise.
	 * 
	 * @return whether the field was found or not.
	 */
	public boolean removeField(Field field) {
		return fields.remove(field);
	}

	/**
	 * Adds a tag to the Entry.
	 * 
	 * @param tag The new tag.
	 */
	public void addTag(String tag) {
		tags.add(tag);
	}

	/**
	 * Returns whether or not the Entry has the tag.
	 * 
	 * @param tag The tag to look for.
	 * 
	 * @return whether or not the Entry has the tag.
	 */
	public boolean hasTag(String tag) {
		for (int i = 0; i < tags.size(); i++)
			if (tags.get(i).equals(tag))
				return true;

		return false;
	}

	/**
	 * Removes the tag from the Entry and returns true if found, and false otherwise.
	 * 
	 * @return whether the tag was found or not.
	 */
	public boolean removeTag(String tag) {
		for (int i = 0; i < tags.size(); i++)
			if (tags.get(i).equals(tag)) {
				tags.remove(i);
				return true;
			}

		return false;
	}
}
