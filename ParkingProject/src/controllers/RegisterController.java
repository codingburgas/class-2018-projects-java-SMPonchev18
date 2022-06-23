package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import models.RegisterModel;
import views.IndexView;
import views.LoginView;

public class RegisterController {
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField address;
	@FXML
	private PasswordField confirmPassword;
	@FXML
	private TextField phone;
	@FXML
	private TextField parkingName;
	@FXML
	private Label errorBlock;
	@FXML
	private ToolBar navbar;

	public ToolBar getNavbar() {
		return navbar;
	}
	public void home(ActionEvent event) {
		System.out.println("Home");
		new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());

	}

	public void submit(ActionEvent event) {
		System.out.println("submit");

		String tempUsername = username.getText().toString();
		String tempPassword = password.getText().toString();
		String tempFirstName = firstName.getText().toString();
		String tempLastName = lastName.getText().toString();
		String tempAddress = address.getText().toString();
		String tempConfirmPassword = confirmPassword.getText().toString();
		String tempPhone = phone.getText().toString();
		String tempParkingName = parkingName.getText().toString();
		
		String message=new RegisterModel(tempUsername, tempPassword, tempFirstName,tempLastName,
				tempAddress, tempConfirmPassword, tempPhone, tempParkingName).checkData();
		errorBlock.setText(message);
		if(message.equals("All good")) {
			new LoginView((Stage) ((Node) event.getSource()).getScene().getWindow());
		}
	}
}







