package controllers;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import models.LoginModel;
import views.IndexView;
import views.LoginView;
import views.RegisterView;

public class LoginController {

	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Label errorMessage;

	@FXML
	private ToolBar navbar;

	public ToolBar getNavbar() {
		return navbar;
	}

	public void home(ActionEvent event) {
		System.out.println("Home");
		new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());

	}


	public void register(ActionEvent event) {
		System.out.println("Register");
		new RegisterView((Stage) ((Node) event.getSource()).getScene().getWindow());
	}

	public void submit(ActionEvent event) {
		System.out.println("submit");
		try {
			String message = new LoginModel(username.getText().toString(), password.getText().toString()).checkData();

			errorMessage.setText(message);
			if (Session.isLoggedIn) {
				new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}