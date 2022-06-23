

package views;

import java.io.IOException;

import controllers.RegisterController;
import controllers.Session;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class RegisterView {
	private RegisterController rc;

	public RegisterView(Stage stage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Register.fxml"));

			Parent root = loader.load();
			rc = loader.getController();
			stage.setTitle("Parking Management");
			Navbar n=new Navbar();
			if (Session.name.equals("SecurityGuard")) {

				n.setButton("Logout",rc.getNavbar());
				n.setButton("Add Vehicle",rc.getNavbar());
				n.setButton("View Vehicle",rc.getNavbar());
				n.setButton("Delete Vehicle",rc.getNavbar());
				n.setButton("Update Vehicle",rc.getNavbar());
				
			}else {
				n.setButton("Login",rc.getNavbar());
			}

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/main/application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
