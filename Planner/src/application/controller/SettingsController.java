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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		refreshSchedules();
	}

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
	
	public void switchToCalendar(MouseEvent event) {
		try {
			Schedule.saveData();
			Schedule.loadData();
			Parent root = FXMLLoader.load(Main.class.getResource("view/Calendar.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	
	public void switchToList(MouseEvent event) {
		try {
			Schedule.saveData();
			Schedule.loadData();
			Parent root = FXMLLoader.load(Main.class.getResource("view/List.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	
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
	
	@FXML
	public void addEntry() {
		Entry entry;
		if (entryName1.getText() != null) {
			entry = new Entry(entryName1.getText());
			entry.addTag("Schedule: " + scheduleName2.getText());
			Schedule.addEntry(entry);
		}
	}
	
	@FXML
	public void removeEntry() {
		if (entryName1.getText() != null)
			Schedule.removeEntry(entryName1.getText());
	}
	
	@FXML
	public void addField() {
		Entry entry = Schedule.getEntry(entryName2.getText());
		if (entry != null)
			entry.addField(new Field(fieldName.getText(), fieldValue.getText()));
	}
	
	@FXML
	public void removeField() {
		Entry entry = Schedule.getEntry(entryName2.getText());
		if (entry != null)
			entry.removeField(fieldName.getText());
	}
	
	@FXML
	public void addSchedule() {
		if (scheduleFile.getText() != null && scheduleName.getText() != null
				&& scheduleFile.getText().length() > 0 && scheduleName.getText().length() > 0)
			Schedule.addScheduleFile(new ToggleableFile(scheduleFile.getText(), scheduleName.getText()));
		Settings.saveSettings();
		refreshSchedules();
	}
	
	@FXML
	public void removeSchedule() {
		Schedule.removeScheduleFile(scheduleName.getText());
		Settings.saveSettings();
		refreshSchedules();
	}
	
	private void refreshSchedules() {
		String temp = "Schedules:\n";
		for (int i = 0; i < Schedule.getScheduleFiles().size(); i++) {
			temp = temp + Schedule.getScheduleFiles().get(i).getAliasName() + "\n";
		}
		schedules.setText(temp);
	}

}
