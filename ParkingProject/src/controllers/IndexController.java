package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import views.IndexView;
import views.LoginView;
import views.RegisterView;

public class IndexController  {
	@FXML
	private Label welcome;
	@FXML
	private ToolBar navbar;

	public void setText(String text) {
		welcome.setText("Welcome "+text);
	}
	
	public ToolBar getNavbar() {
		return navbar;
	}
	
	
	public void logIn(ActionEvent event) {
		System.out.println("logIn");
		new LoginView((Stage) ((Node) event.getSource()).getScene().getWindow());
		
	}

	public void register(ActionEvent event) {
		System.out.println("Register");
		new RegisterView((Stage) ((Node) event.getSource()).getScene().getWindow());
	}
}