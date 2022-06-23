
	package views;

	import java.io.IOException;

import controllers.AddVehicleController;
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


	public class AddVehicleView {
		private AddVehicleController apc;

		public AddVehicleView(Stage stage) {
			try {

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/AddVehicle.fxml"));

				Parent root = loader.load();
				apc = loader.getController();
				stage.setTitle("Parking Management");
				Navbar n=new Navbar();


					n.setButton("Logout",apc.getNavbar());
					n.setButton("Add Vehicle",apc.getNavbar());
					n.setButton("View Vehicle",apc.getNavbar());
					n.setButton("Delete Vehicle",apc.getNavbar());
					n.setButton("Update Vehicle",apc.getNavbar());
					
					if (!Session.vehicleNumber.equals("")) {
						apc.getErrorBlock().setText(Session.vehicleNumber);
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
