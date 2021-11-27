package application.model;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;

public class Settings {
	private static String priorityOrdering;
	private static String priorityTopLeft;
	private static String priorityTopRight;
	private static String priorityCenter;
	private static String priorityCenterBottom;
	private static String priorityBottomLeft;
	private static String priorityBottomRight;
	
	public static String getPriorityOrdering() {
		return priorityOrdering;
	}
	
	public static void setPriorityOrdering(String priorityOrdering) {
		Settings.priorityOrdering = priorityOrdering;
	}
	
	public static String getPriorityTopLeft() {
		return priorityTopLeft;
	}
	
	public static void setPriorityTopLeft(String priorityTopLeft) {
		Settings.priorityTopLeft = priorityTopLeft;
	}
	
	public static String getPriorityTopRight() {
		return priorityTopRight;
	}
	
	public static void setPriorityTopRight(String priorityTopRight) {
		Settings.priorityTopRight = priorityTopRight;
	}
	
	public static String getPriorityCenter() {
		return priorityCenter;
	}
	
	public static void setPriorityCenter(String priorityCenter) {
		Settings.priorityCenter = priorityCenter;
	}
	
	public static String getPriorityCenterBottom() {
		return priorityCenterBottom;
	}
	
	public static void setPriorityCenterBottom(String priorityCenterBottom) {
		Settings.priorityCenterBottom = priorityCenterBottom;
	}
	
	public static String getPriorityBottomLeft() {
		return priorityBottomLeft;
	}
	
	public static void setPriorityBottomLeft(String priorityBottomLeft) {
		Settings.priorityBottomLeft = priorityBottomLeft;
	}
	
	public static String getPriorityBottomRight() {
		return priorityBottomRight;
	}
	
	public static void setPriorityBottomRight(String priorityBottomRight) {
		Settings.priorityBottomRight = priorityBottomRight;
	}
	
	public static void loadSettings() {
		File file = new File("data/settings.csv");
		try {
			Scanner scanner = new Scanner(file);
			if (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split(",");
				if (words.length > 0) {
					setPriorityOrdering(words[0]);
				}
				else {
					setPriorityOrdering("");
				}
			}
			if (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split(",");
				if (words.length > 0) {
					setPriorityTopLeft(words[0]);
				}
				else {
					setPriorityTopLeft("");
				}
			}
			if (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split(",");
				if (words.length > 0) {
					setPriorityTopRight(words[0]);
				}
				else {
					setPriorityTopRight("");
				}
			}
			if (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split(",");
				if (words.length > 0) {
					setPriorityCenter(words[0]);
				}
				else {
					setPriorityCenter("");
				}
			}
			if (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split(",");
				if (words.length > 0) {
					setPriorityCenterBottom(words[0]);
				}
				else {
					setPriorityCenterBottom("");
				}
			}
			if (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split(",");
				if (words.length > 0) {
					setPriorityBottomLeft(words[0]);
				}
				else {
					setPriorityBottomLeft("");
				}
			}
			if (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split(",");
				if (words.length > 0) {
					setPriorityBottomRight(words[0]);
				}
				else {
					setPriorityBottomRight("");
				}
			}
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split(",");
				if (words.length > 1) {
					Schedule.addScheduleFile(new ToggleableFile(words[0], words[1]));
				}
			}
			scanner.close();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public static void saveSettings() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("data/settings.csv"));
			out.write(getPriorityOrdering());
			out.newLine();
			out.write(getPriorityTopLeft());
			out.newLine();
			out.write(getPriorityTopRight());
			out.newLine();
			out.write(getPriorityCenter());
			out.newLine();
			out.write(getPriorityCenterBottom());
			out.newLine();
			out.write(getPriorityBottomLeft());
			out.newLine();
			out.write(getPriorityBottomRight());
			out.newLine();
			for (int i = 0; i < Schedule.getScheduleFiles().size(); i++) {
				out.write(Schedule.getScheduleFiles().get(i).getFileName() + ","
						+ Schedule.getScheduleFiles().get(i).getAliasName());
				out.newLine();
			}
			out.close();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
}
