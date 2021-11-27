package application.model;

import java.util.ArrayList;

public class Entry {
	private String name;
	private ArrayList<Field> fields;
	private ArrayList<String> tags;

	public Entry(String name) {
		this.name = name;
		this.fields = new ArrayList<Field>();
		this.tags = new ArrayList<String>();
	}

	public Entry(String name, ArrayList<Field> fields, ArrayList<String> tags) {
		this.name = name;
		this.fields = fields;
		this.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Field> getFields() {
		return fields;
	}

	public void setFields(ArrayList<Field> fields) {
		this.fields = fields;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public void addField(Field field) {
		fields.add(field);
	}

	public Field getField(String name) {
		for (int i = 0; i < fields.size(); i++)
			if (fields.get(i).getName().equals(name))
				return fields.get(i);

		return new Field(name);
	}

	public Field removeField(String name) {
		for (int i = 0; i < fields.size(); i++)
			if (fields.get(i).getName().equals(name))
				return fields.remove(i);

		return null;
	}

	public boolean removeField(Field field) {
		return fields.remove(field);
	}

	public void addTag(String tag) {
		tags.add(tag);
	}

	public boolean hasTag(String tag) {
		for (int i = 0; i < tags.size(); i++)
			if (tags.get(i).equals(tag))
				return true;

		return false;
	}

	public boolean removeTag(String tag) {
		for (int i = 0; i < tags.size(); i++)
			if (tags.get(i).equals(tag)) {
				tags.remove(i);
				return true;
			}

		return false;
	}
}
