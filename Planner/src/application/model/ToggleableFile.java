package application.model;

/**
 * The ToggleableFile class represents files with alias names, along with the ability to be activated and deactivated.
 * 
 * @author Stephanie Bassey, Lucian Williams, Azrah Al Rabeeah
 */
public class ToggleableFile {
	private String fileName;
	private String aliasName;
	private boolean isActive;

	/**
	 * Initializes a new ToggleableFile Object with String fileName and String aliasName.
	 * 
	 * @param fileName The file name of the ToggleableFile.
	 * @param aliasName The alias name of the ToggleableFile.
	 */
	public ToggleableFile(String fileName, String aliasName) {
		this.fileName = fileName;
		this.aliasName = aliasName;
		this.isActive = true;
	}

	/**
	 * Returns the file name of the ToggleableFile.
	 * 
	 * @return the file name of the ToggleableFile.
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name of the ToggleableFile to the provided fileName.
	 * 
	 * @param fileName The new file name of the ToggleableFile.
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Returns the alias name of the ToggleableFile.
	 * 
	 * @return the alias name of the ToggleableFile.
	 */
	public String getAliasName() {
		return aliasName;
	}

	/**
	 * Sets the alias name of the ToggleableFile to the provided aliasName.
	 * 
	 * @param aliasName The new alias name of the ToggleableFile.
	 */
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	/**
	 * Returns whether or not the ToggleableFile is active.
	 * 
	 * @return whether or not the ToggleableFile is active.
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Sets whether or not the ToggleableFile is active using the provided boolean.
	 * 
	 * @param isActive The new isActive value of the ToggleableFile.
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
