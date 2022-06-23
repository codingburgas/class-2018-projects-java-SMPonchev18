package controllers;

import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.DeleteVehicleModel;
import models.Vehicle;
import views.IndexView;
import views.RegisterView;

public class DeleteVehicleController {
	@FXML
	private ToolBar navbar;
	@FXML
	private Label errorBlock;
	@FXML
	private BorderPane pane;
	
	private Map<Integer,Vehicle> vehicles;
	
	public void deleteVehicle(int id) {
		new DeleteVehicleModel().deleteVehicleById(id);
	}
	
	public ToolBar getNavbar() {
		return navbar;
	}
	public Label getErrorBlock() {
		return errorBlock;
	}
	public Map<Integer,Vehicle> getVehicles(){
		return vehicles;
	}
	public BorderPane getPane() {
		return pane;
	}
	public DeleteVehicleController(){
		vehicles= new DeleteVehicleModel().getVehiclesByParkingId();
		
	}
	public void home(ActionEvent event) {
		System.out.println("Home");
		new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());

	}
	public void register(ActionEvent event) {
		System.out.println("Home");
		new RegisterView((Stage) ((Node) event.getSource()).getScene().getWindow());

	}
	
}