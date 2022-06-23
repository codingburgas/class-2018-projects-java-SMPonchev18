
package views;

import java.io.IOException;
import java.util.Map;

import controllers.DeleteVehicleController;
import controllers.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.Vehicle;

public class ViewVehicleView {
	private DeleteVehicleController vpc;

	public ViewVehicleView(Stage stage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/DeleteVehicle.fxml"));

			Parent root = loader.load();
			vpc = loader.getController();
			stage.setTitle("Parking Management");
			Navbar n = new Navbar();
				n.setButton("Logout", vpc.getNavbar());
				n.setButton("Add Vehicle", vpc.getNavbar());
				n.setButton("View Vehicle", vpc.getNavbar());
				n.setButton("Delete Vehicle", vpc.getNavbar());
				n.setButton("Update Vehicle", vpc.getNavbar());
				vpc.getPane().setCenter(getTableWithData(vpc.getVehicles()));


			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/main/application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private TableView getTableWithData(Map<Integer,Vehicle> vehicles) {
		
		
		
		ObservableList<Vehicle> list=FXCollections.observableArrayList();
		
		for(Integer key:vehicles.keySet()) {
			list.add(vehicles.get(key));
		}	
		
		TableView<Vehicle> table=new TableView<Vehicle>();
		
		TableColumn vehicleIdColumn=new TableColumn<Vehicle,String>("vehicleId");
		vehicleIdColumn.setCellValueFactory(new PropertyValueFactory<Vehicle,Integer>("vehicleId"));
		
		
		TableColumn brandColumn=new TableColumn<Vehicle,String>("Brand");
		brandColumn.setCellValueFactory(new PropertyValueFactory<Vehicle,String>("brand"));
		
		TableColumn modelColumn=new TableColumn<Vehicle,String>("Model");
		modelColumn.setCellValueFactory(new PropertyValueFactory<Vehicle,String>("model"));
		
		TableColumn plateNumberColumn=new TableColumn<Vehicle,String>("Plate Number");
		plateNumberColumn.setCellValueFactory(new PropertyValueFactory<Vehicle,Integer>("plateNumber"));
		
		TableColumn infoColumn=new TableColumn<Vehicle,String>("Info");
		infoColumn.setCellValueFactory(new PropertyValueFactory<Vehicle,Integer>("info"));
		
		

		
		table.setItems(list);
		table.getColumns().addAll(vehicleIdColumn,brandColumn,
				modelColumn,plateNumberColumn,infoColumn);	

		
		return table;
	}
}