package application.model;

public class ToggleableFile {
	private String fileName;
	private String aliasName;
	private boolean isActive;

	public ToggleableFile(String fileName, String aliasName) {
		this.fileName = fileName;
		this.aliasName = aliasName;
		this.isActive = true;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
