package application.model;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Schedule{
	private static ArrayList<Entry> entries;
	private static ArrayList<ToggleableFile> scheduleFiles;

	public static void initialize() {
		entries = new ArrayList<Entry>();
		scheduleFiles = new ArrayList<ToggleableFile>();
	}

	public static ArrayList<Entry> getEntries() {
		return entries;
	}

	public static void setEntries(ArrayList<Entry> entries) {
		Schedule.entries = entries;
	}

	public static void addEntry(Entry entry) {
		entries.add(entry);
	}

	public static Entry getEntry(String name) {
		for (int i = 0; i < entries.size(); i++)
			if (entries.get(i).getName().equals(name))
				return entries.get(i);

		return null;
	}

	public static Entry removeEntry(String name) {
		for (int i = 0; i < entries.size(); i++)
			if (entries.get(i).getName().equals(name))
				return entries.remove(i);

		return null;
	}

	public static boolean removeEntry(Entry entry) {
		return entries.remove(entry);
	}

	public static void clearEntries() {
		entries = new ArrayList<Entry>();
	}

	public static ArrayList<ToggleableFile> getScheduleFiles() {
		return scheduleFiles;
	}

	public static void setScheduleFiles(ArrayList<ToggleableFile> scheduleFiles) {
		Schedule.scheduleFiles = scheduleFiles;
	}

	public static void addScheduleFile(ToggleableFile scheduleFile) {
		scheduleFiles.add(scheduleFile);
	}

	public static ToggleableFile getScheduleFile(String aliasName) {
		for (int i = 0; i < scheduleFiles.size(); i++)
			if (scheduleFiles.get(i).getAliasName().equals(aliasName))
				return scheduleFiles.get(i);

		return null;
	}

	public static ToggleableFile removeScheduleFile(String aliasName) {
		for (int i = 0; i < scheduleFiles.size(); i++)
			if (scheduleFiles.get(i).getAliasName().equals(aliasName))
				return scheduleFiles.remove(i);

		return null;
	}

	public static boolean removeScheduleFile(ToggleableFile scheduleFile) {
		return scheduleFiles.remove(scheduleFile);
	}

	public static void clearScheduleFiles() {
		scheduleFiles = new ArrayList<ToggleableFile>();
	}

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

	public static void saveData() {
		for (int i = 0; i < entries.size(); i++) {
			ToggleableFile scheduleFile = getScheduleFile(entries.get(i).getTags().get(0).substring(10));
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("data/" + scheduleFile.getFileName()));
				Entry entry = entries.get(i);
				out.write("Entry," + entry.getName());
				out.newLine();
				for (int j = 0; j < entries.get(i).getFields().size(); j++) {
					Field field = entry.getFields().get(j);
					out.write("Field," + entry.getName() + "," + field.getName() + "," + field.getValue());
					out.newLine();
				}
				for (int j = 0; j < entries.get(i).getTags().size(); j++) {
					String tag = entry.getTags().get(j);
					out.write("Tag," + entry.getName() + "," + tag);
					out.newLine();
				}
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
