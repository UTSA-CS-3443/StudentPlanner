package application.controller;

import application.Main;
import application.model.Schedule;
import application.model.Entry;
import application.model.Field;
import application.model.Settings;
import application.model.ToggleableFile;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The SettingsController class is the controller for the Settings view. Any changes to what's displayed in the settings 
 * of the app is managed by this view.
 * 
 * @author Stephanie Bassey, Lucian Williams, Azra Al Rabeeah
 */
public class SettingsController implements EventHandler<MouseEvent>, Initializable {
	
	@FXML
	private TextField scheduleFile;
	
	@FXML
	private TextField scheduleName;
	
	@FXML
	private TextField scheduleName2;
	
	@FXML
	private TextField entryName1;
	
	@FXML
	private TextField entryName2;
	
	@FXML
	private TextField fieldName;
	
	@FXML
	private TextField fieldValue;
	
	@FXML
	private Label schedules;
	
	/**
	 * This method loads the Settings view and any changes by calling on a method from 
	 * one of the model classes.
	 * 
	 * @param location (URL), resources (ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		refreshSchedules();
	}

	/**
	 * Method responsible for switching the user back to the main/welcome screen
	 * 
	 * @param event (MouseEvent)
	 */
	@Override
	public void handle(MouseEvent event) {
		try {
			Schedule.saveData();
			Parent root = FXMLLoader.load(Main.class.getResource("view/Main.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
		
	}
	
	/**
	 * Method responisble for switching the user back to the view with the schedule entries
	 * 
	 * @param event
	 */
	public void switchToPriority(MouseEvent event) {
		try {
			Schedule.saveData();
			Schedule.loadData();
			Parent root = FXMLLoader.load(Main.class.getResource("view/Priority.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
		
	}
	
	/**
	 * This method adds an entry to the schedule file basedd on the user's input
	 */
	@FXML
	public void addEntry() {
		Entry entry;
		if (entryName1.getText() != null) {
			entry = new Entry(entryName1.getText());
			entry.addTag("Schedule: " + scheduleName2.getText());
			Schedule.addEntry(entry);
		}
	}
	
	/**
	 * This method removes the user specified entry from a schedule
	 */
	@FXML
	public void removeEntry() {
		if (entryName1.getText() != null)
			Schedule.removeEntry(entryName1.getText());
	}
	
	
	/**
	 * This method grabs the user's input and then adds the field to the schedule entry
	 */
	@FXML
	public void addField() {
		Entry entry = Schedule.getEntry(entryName2.getText());
		if (entry != null)
			entry.addField(new Field(fieldName.getText(), fieldValue.getText()));
	}
	
	/**
	 * This method deletes the user specified field from the schedule entry. This does not delete any other
	 * fields that may also be on the entry, just the specified one.
	 */
	@FXML
	public void removeField() {
		Entry entry = Schedule.getEntry(entryName2.getText());
		if (entry != null)
			entry.removeField(fieldName.getText());
	}
	
	/**
	 * This method adds a schedule file which is what is used to populate the data in the Priority view.
	 * All schedule files are in csv format
	 */
	@FXML
	public void addSchedule() {
		if (scheduleFile.getText() != null && scheduleName.getText() != null
				&& scheduleFile.getText().length() > 0 && scheduleName.getText().length() > 0)
			Schedule.addScheduleFile(new ToggleableFile(scheduleFile.getText(), scheduleName.getText()));
		Settings.saveSettings();
		refreshSchedules();
	}
	
	/**
	 * This method calls on the Schedule and Settings classes in the model to delete a schedule specified
	 * by the user's input. This completely the deletes the schedules csv file.
	 */
	@FXML
	public void removeSchedule() {
		Schedule.removeScheduleFile(scheduleName.getText());
		Settings.saveSettings();
		refreshSchedules();
	}
	
	/**
	 * This method refreshes any changes to the list of schedules on the Settings screen.
	 * If a schedule is deleted, then it will no longer show off to the side in the view and if one is added, it will be
	 * shown on the view in a list format.
	 */
	private void refreshSchedules() {
		String temp = "Schedules:\n";
		for (int i = 0; i < Schedule.getScheduleFiles().size(); i++) {
			temp = temp + Schedule.getScheduleFiles().get(i).getAliasName() + "\n";
		}
		schedules.setText(temp);
	}

}
