
package views;

import java.io.IOException;

import controllers.IndexController;
import controllers.Session;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IndexView {
	private IndexController ic;

	public IndexView(Stage stage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Index.fxml"));

			Parent root = loader.load();
			ic = loader.getController();
			stage.setTitle("Parking Management");
			Navbar n = new Navbar();
			if (Session.isLoggedIn) {

				ic.setText(", " + Session.name);

				n.setButton("Logout", ic.getNavbar());
				n.setButton("Add Vehicle", ic.getNavbar());
				n.setButton("View Vehicle", ic.getNavbar());
				n.setButton("Delete Vehicle", ic.getNavbar());
				n.setButton("Update Vehicle", ic.getNavbar());

			} else {
				n.setButton("Login", ic.getNavbar());
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


