package application.model;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Schedule class represents a schedule containing Entries, and keeps track of active schedule files.
 * 
 * @author Stephanie Bassey, Lucian Williams, Azrah Al Rabeeah
 */
public class Schedule{
	private static ArrayList<Entry> entries;
	private static ArrayList<ToggleableFile> scheduleFiles;

	/**
	 * Initializes the static entries and scheduleFiles variables to new ArrayLists.
	 */
	public static void initialize() {
		entries = new ArrayList<Entry>();
		scheduleFiles = new ArrayList<ToggleableFile>();
	}

	/**
	 * Returns entries.
	 * 
	 * @return entries.
	 */
	public static ArrayList<Entry> getEntries() {
		return entries;
	}

	/**
	 * Sets entries to the provided entries.
	 * 
	 * @param entries The new entries.
	 */
	public static void setEntries(ArrayList<Entry> entries) {
		Schedule.entries = entries;
	}

	/**
	 * Adds an entry to entries.
	 * 
	 * @param entry The new entry.
	 */
	public static void addEntry(Entry entry) {
		entries.add(entry);
	}

	/**
	 * Returns the Entry from entries with the given name or null if not found.
	 * 
	 * @return the matching Entry.
	 */
	public static Entry getEntry(String name) {
		for (int i = 0; i < entries.size(); i++)
			if (entries.get(i).getName().equals(name))
				return entries.get(i);

		return null;
	}

	/**
	 * Removes and returns the Entry from entries with the given name or null if not found.
	 * 
	 * @return the matching Entry.
	 */
	public static Entry removeEntry(String name) {
		for (int i = 0; i < entries.size(); i++)
			if (entries.get(i).getName().equals(name))
				return entries.remove(i);

		return null;
	}

	/**
	 * Removes the provided Entry from entries and returns true if found, and false otherwise.
	 * 
	 * @return whether the Entry was found or not.
	 */
	public static boolean removeEntry(Entry entry) {
		return entries.remove(entry);
	}

	/**
	 * Clears entries.
	 */
	public static void clearEntries() {
		entries = new ArrayList<Entry>();
	}

	/**
	 * Returns scheduleFiles.
	 * 
	 * @return scheduleFiles.
	 */
	public static ArrayList<ToggleableFile> getScheduleFiles() {
		return scheduleFiles;
	}

	/**
	 * Sets scheduleFiles to the provided scheduleFiles.
	 * 
	 * @param scheduleFiles The new scheduleFiles.
	 */
	public static void setScheduleFiles(ArrayList<ToggleableFile> scheduleFiles) {
		Schedule.scheduleFiles = scheduleFiles;
	}

	/**
	 * Adds a scheduleFile to scheduleFiles.
	 * 
	 * @param scheduleFile The new scheduleFile.
	 */
	public static void addScheduleFile(ToggleableFile scheduleFile) {
		scheduleFiles.add(scheduleFile);
	}

	/**
	 * Returns the ToggleableFile from scheduleFiles with the given alias name or null if not found.
	 * 
	 * @return the matching ToggleableFile.
	 */
	public static ToggleableFile getScheduleFile(String aliasName) {
		for (int i = 0; i < scheduleFiles.size(); i++)
			if (scheduleFiles.get(i).getAliasName().equals(aliasName))
				return scheduleFiles.get(i);

		return null;
	}

	/**
	 * Removes and returns the ToggleableFile from scheduleFiles with the given alias name or null if not found.
	 * 
	 * @return the matching ToggleableFile.
	 */
	public static ToggleableFile removeScheduleFile(String aliasName) {
		for (int i = 0; i < scheduleFiles.size(); i++)
			if (scheduleFiles.get(i).getAliasName().equals(aliasName))
				return scheduleFiles.remove(i);

		return null;
	}

	/**
	 * Removes the provided ToggleableFile from scheduleFiles and returns true if found, and false otherwise.
	 * 
	 * @return whether the ToggleableFile was found or not.
	 */
	public static boolean removeScheduleFile(ToggleableFile scheduleFile) {
		return scheduleFiles.remove(scheduleFile);
	}

	/**
	 * Clears scheduleFiles.
	 */
	public static void clearScheduleFiles() {
		scheduleFiles = new ArrayList<ToggleableFile>();
	}

	/**
	 * Loads entries from the files named by scheduleFiles into entries.
	 */
	public static void loadData() {
		entries.clear();
		for (int i = 0; i < scheduleFiles.size(); i++) {
			if (scheduleFiles.get(i).isActive()) {
				File file = new File("data/" + scheduleFiles.get(i).getFileName());
				try {
					Scanner scanner = new Scanner(file);
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();
						String[] words = line.split(",");
						if (words.length > 1) {
							if (words[0].equals("Entry")) {
								Entry entry = new Entry(words[1]);
								entry.addTag("Schedule: " + scheduleFiles.get(i).getAliasName());
								entries.add(entry);
							}
							if (words.length > 2) {
								if (words[0].equals("Field") && getEntry(words[1]) != null) {
									if (words.length > 3)
										getEntry(words[1]).addField(new Field(words[2], words[3]));
									else
										getEntry(words[1]).addField(new Field(words[2]));
								}
								if (words[0].equals("Tag") && getEntry(words[1]) != null) {
									getEntry(words[1]).addTag(words[2]);
								}
							}
						}
					}
					scanner.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Saves entries to the files named by scheduleFiles from entries.
	 */
	public static void saveData() {
		for (int i = 0; i < scheduleFiles.size(); i++) {
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("data/" + scheduleFiles.get(i).getFileName()));
				for (int j = 0; j < entries.size(); j++) {
					if (entries.get(j).getTags().get(0).substring(10).equals(scheduleFiles.get(i).getAliasName())) {
						Entry entry = entries.get(j);
						out.write("Entry," + entry.getName());
						out.newLine();
						for (int k = 0; k < entry.getFields().size(); k++) {
							Field field = entry.getFields().get(k);
							out.write("Field," + entry.getName() + "," + field.getName() + "," + field.getValue());
							out.newLine();
						}
						for (int k = 1; k < entry.getTags().size(); k++) {
							String tag = entry.getTags().get(k);
							out.write("Tag," + entry.getName() + "," + tag);
							out.newLine();
						}
					}
				}
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
