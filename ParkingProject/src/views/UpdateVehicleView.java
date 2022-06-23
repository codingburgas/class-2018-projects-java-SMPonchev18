
	package views;

	import java.io.IOException;

import controllers.AddVehicleController;
import controllers.RegisterController;
	import controllers.Session;
import controllers.UpdateVehicleController;
import javafx.event.Event;
	import javafx.event.EventHandler;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Node;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.stage.Stage;


	public class UpdateVehicleView {
		private UpdateVehicleController upc;

		public UpdateVehicleView(Stage stage) {
			try {

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/UpdateVehicle.fxml"));

				Parent root = loader.load();
				upc = loader.getController();
				stage.setTitle("Parking Management");
				Navbar n=new Navbar();


					n.setButton("Logout",upc.getNavbar());
					n.setButton("Add Vehicle",upc.getNavbar());
					n.setButton("View Vehicle",upc.getNavbar());
					n.setButton("Delete Vehicle",upc.getNavbar());
					n.setButton("Update Vehicle",upc.getNavbar());
					
					if (!Session.vehicleNumber.equals("")) {
						upc.getErrorBlock().setText(Session.vehicleNumber);
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
