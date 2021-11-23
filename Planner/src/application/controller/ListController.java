package application.controller;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class ListController implements EventHandler<MouseEvent> {
	@Override
	public void handle(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Settings.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public void switchToCalendar(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Calendar.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public void switchToPriority(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Priority.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public void switchToHome(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}


}
