package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import models.AddVehicleModel;
import models.RegisterModel;
import models.UpdateVehicleModel;
import views.AddVehicleView;
import views.IndexView;
import views.LoginView;
import views.RegisterView;
import views.UpdateVehicleView;

public class UpdateVehicleController {
	@FXML
	private TextField category;
	@FXML
	private TextField brand;
	@FXML
	private TextField model;
	@FXML
	private TextField plateNumber;
	@FXML
	private TextField info;
	@FXML
	private TextField age;
	@FXML
	private Label errorBlock;
	@FXML
	private ToolBar navbar;

	public ToolBar getNavbar() {
		return navbar;
	}

	public Label getErrorBlock() {
		return errorBlock;
	}

	public void home(ActionEvent event) {
		System.out.println("Home");
		new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());

	}

	public void register(ActionEvent event) {
		System.out.println("Home");
		new RegisterView((Stage) ((Node) event.getSource()).getScene().getWindow());

	}

	public void submit(ActionEvent event) {
		System.out.println("submit");

		String tempCategory = category.getText().toString();
		String tempBrand = brand.getText().toString();
		String tempModel = model.getText().toString();
		String tempPlateNumber = plateNumber.getText().toString();
		String tempInfo = info.getText().toString();
		String tempAge = age.getText().toString();
String result=new UpdateVehicleModel(
		tempCategory,
		tempBrand,
		tempModel,
		tempPlateNumber,
		tempInfo,
		tempAge).checkData();
		errorBlock.setText(result);
		if(result.contains("Successfully")) {
			Session.vehicleNumber=result;
		new UpdateVehicleView((Stage) ((Node) event.getSource()).getScene().getWindow());
		}
	}
}
