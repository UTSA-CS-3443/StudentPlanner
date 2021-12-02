package application.model;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;

/**
 * The Settings class represents all of the settings of the Student Planner, keeping track of all schedule files that
 * the user had loaded in the previous session, as well as keeping track of which fields should be presented in the
 * main view of the app.
 * 
 * @author Stephanie Bassey, Lucian Williams, Azrah Al Rabeeah
 */
public class Settings {
	private static String priorityOrdering;
	private static String priorityTopLeft;
	private static String priorityTopRight;
	private static String priorityCenter;
	private static String priorityCenterBottom;
	private static String priorityBottomLeft;
	private static String priorityBottomRight;

	/**
	 * Returns priorityOrdering.
	 * 
	 * @return priorityOrdering.
	 */
	public static String getPriorityOrdering() {
		return priorityOrdering;
	}

	/**
	 * Sets priorityOrdering to the provided priorityOrdering.
	 * 
	 * @param priorityOrdering The new priorityOrdering.
	 */
	public static void setPriorityOrdering(String priorityOrdering) {
		Settings.priorityOrdering = priorityOrdering;
	}

	/**
	 * Returns priorityTopLeft.
	 * 
	 * @return priorityTopLeft.
	 */
	public static String getPriorityTopLeft() {
		return priorityTopLeft;
	}

	/**
	 * Sets priorityTopLeft to the provided priorityTopLeft.
	 * 
	 * @param priorityTopLeft The new priorityTopLeft.
	 */
	public static void setPriorityTopLeft(String priorityTopLeft) {
		Settings.priorityTopLeft = priorityTopLeft;
	}

	/**
	 * Returns priorityTopRight.
	 * 
	 * @return priorityTopRight.
	 */
	public static String getPriorityTopRight() {
		return priorityTopRight;
	}

	/**
	 * Sets priorityTopRight to the provided priorityTopRight.
	 * 
	 * @param priorityTopRight The new priorityTopRight.
	 */
	public static void setPriorityTopRight(String priorityTopRight) {
		Settings.priorityTopRight = priorityTopRight;
	}

	/**
	 * Returns priorityCenter.
	 * 
	 * @return priorityCenter.
	 */
	public static String getPriorityCenter() {
		return priorityCenter;
	}

	/**
	 * Sets priorityCenter to the provided priorityCenter.
	 * 
	 * @param priorityCenter The new priorityCenter.
	 */
	public static void setPriorityCenter(String priorityCenter) {
		Settings.priorityCenter = priorityCenter;
	}

	/**
	 * Returns priorityCenterBottom.
	 * 
	 * @return priorityCenterBottom.
	 */
	public static String getPriorityCenterBottom() {
		return priorityCenterBottom;
	}

	/**
	 * Sets priorityCenterBottom to the provided priorityCenterBottom.
	 * 
	 * @param priorityCenterBottom The new priorityCenterBottom.
	 */
	public static void setPriorityCenterBottom(String priorityCenterBottom) {
		Settings.priorityCenterBottom = priorityCenterBottom;
	}

	/**
	 * Returns priorityBottomLeft.
	 * 
	 * @return priorityBottomLeft.
	 */
	public static String getPriorityBottomLeft() {
		return priorityBottomLeft;
	}

	/**
	 * Sets priorityBottomLeft to the provided priorityBottomLeft.
	 * 
	 * @param priorityBottomLeft The new priorityBottomLeft.
	 */
	public static void setPriorityBottomLeft(String priorityBottomLeft) {
		Settings.priorityBottomLeft = priorityBottomLeft;
	}

	/**
	 * Returns priorityBottomRight.
	 * 
	 * @return priorityBottomRight.
	 */
	public static String getPriorityBottomRight() {
		return priorityBottomRight;
	}

	/**
	 * Sets priorityBottomRight to the provided priorityBottomRight.
	 * 
	 * @param priorityBottomRight The new priorityBottomRight.
	 */
	public static void setPriorityBottomRight(String priorityBottomRight) {
		Settings.priorityBottomRight = priorityBottomRight;
	}

	/**
	 * Loads the Settings variables and Schedule.scheduleFiles from data/settings.csv
	 */
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

	/**
	 * Saves the Settings variables and Schedule.scheduleFiles to data/settings.csv
	 */
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
