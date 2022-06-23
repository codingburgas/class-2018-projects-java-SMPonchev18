
package views;

import java.io.IOException;

import controllers.LoginController;
import controllers.Session;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginView  {
private LoginController lc;
	public LoginView(Stage stage){
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Login.fxml"));
			Parent root = loader.load();
			
			stage.setTitle("Parking Management");
			
			lc=loader.getController();
			Navbar n=new Navbar();
			if (Session.name.equals("SecurityGuard")) {
				
				n.setButton("Logout",lc.getNavbar());
				n.setButton("Add Vehicle",lc.getNavbar());
				n.setButton("View Vehicle",lc.getNavbar());
				n.setButton("Delete Vehicle",lc.getNavbar());
				n.setButton("Update Vehicle",lc.getNavbar());
				
				
			}else {
				n.setButton("Login",lc.getNavbar());
			}
			
			Scene scene=new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/main/application.css").toExternalForm());
			
			stage.setScene(scene);
			stage.show();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


}


