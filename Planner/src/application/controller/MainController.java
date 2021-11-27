package application.controller;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class MainController implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("view/Settings.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public void switchToCalendar(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("view/Calendar.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	
	public void switchToList(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("view/List.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	
	public void switchToPriority(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("view/Priority.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}

	
	

}
