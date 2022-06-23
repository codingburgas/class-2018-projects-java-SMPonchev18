
package views;

import controllers.Session;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class Navbar {

	public void setButton(String name, ToolBar navbar) {
		Button btn = new Button(name);

		btn.setOnAction(generateEventHandler(name));
		navbar.getItems().add(btn);
	}

	private EventHandler generateEventHandler(String name) {

		if (name.equalsIgnoreCase("logout")) {
			return new EventHandler() {

				@Override
				public void handle(Event event) {
					System.out.println("Logout");
					Session.isLoggedIn = false;
					Session.name = "";
					new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());
				}

			};
		} else if (name.equalsIgnoreCase("Login")) {
			return new EventHandler() {

				@Override
				public void handle(Event event) {
					System.out.println("login");
					new LoginView((Stage) ((Node) event.getSource()).getScene().getWindow());
				}

			};
		}

			if (name.equalsIgnoreCase("Add Vehicle")) {
				return new EventHandler() {

					@Override
					public void handle(Event event) {
						System.out.println("add vehicle");
						new AddVehicleView((Stage) ((Node) event.getSource()).getScene().getWindow());
					}

				};
			} else if (name.equalsIgnoreCase("View Vehicle")) {
				return new EventHandler() {

					@Override
					public void handle(Event event) {
						System.out.println("view vehicle");
						new ViewVehicleView((Stage) ((Node) event.getSource()).getScene().getWindow());
					}

				};
			} else if (name.equalsIgnoreCase("Delete Vehicle")) {
				return new EventHandler() {

					@Override
					public void handle(Event event) {
						System.out.println("delete vehicle");
						new DeleteVehicleView((Stage) ((Node) event.getSource()).getScene().getWindow());
					}

				};
			} else if (name.equalsIgnoreCase("Update Vehicle")) {
				return new EventHandler() {

					@Override
					public void handle(Event event) {
						System.out.println("update vehicle");
						new UpdateVehicleView((Stage) ((Node) event.getSource()).getScene().getWindow());
					}

				};
			}
		

		return null;
	}

}