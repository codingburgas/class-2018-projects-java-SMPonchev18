
	package views;

	import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import controllers.AddVehicleController;
import controllers.DeleteVehicleController;
import controllers.RegisterController;
	import controllers.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
	import javafx.event.EventHandler;
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


	public class DeleteVehicleView {
		private DeleteVehicleController dpc;
		
		public DeleteVehicleView(Stage stage) {
			try {

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/DeleteVehicle.fxml"));

				Parent root = loader.load();
				dpc = loader.getController();
				stage.setTitle("Parking Management");
				Navbar n=new Navbar();
					n.setButton("Logout",dpc.getNavbar());
					n.setButton("Add Vehicle",dpc.getNavbar());
					n.setButton("View Vehicle",dpc.getNavbar());
					n.setButton("Delete Vehicle",dpc.getNavbar());
					n.setButton("Update Vehicle",dpc.getNavbar());
					dpc.getPane().setCenter(getTableWithData(dpc.getVehicles()));
					if (!Session.vehicleNumber.equals("")) {
						dpc.getErrorBlock().setText(Session.vehicleNumber);
					}

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
			
			
			TableColumn deleteColumn=new TableColumn<>("Delete Vehicle");
			
			Callback<TableColumn<Vehicle,String>, TableCell<Vehicle,String>> cellFactory =new 
					Callback<TableColumn<Vehicle,String>,TableCell<Vehicle,String>>(){
		           @Override
		            public TableCell call(final TableColumn<Vehicle, String> param) {
		                final TableCell<Vehicle, String> cell = new TableCell<Vehicle, String>() {

		                    private final Button btn = new Button("Delete");

		                    @Override
		                    public void updateItem(String item, boolean empty) {
		                    	super.updateItem(item, empty);
		                    	if(empty){
		                    		setGraphic(null);
		                    		setText(null);
		                    	}else {
		                    		btn.setOnAction(event->{
		                    			System.out.println("Delete button is clicked");
		                    			Vehicle v=getTableView().getItems().get(getIndex());
		                    			
		                    			
		                    			dpc.deleteVehicle(v.getVehicleId());
		                    			new DeleteVehicleView((Stage) ((Node)
		                    					event.getSource()).getScene().getWindow());
		                    		});
		                    		setGraphic(btn);
				                       setText(null);
		                    	}
		                    	
		                       
		                    }
		                };
		                return cell;
						}
				
			};
		
			deleteColumn.setCellFactory(cellFactory);
			
			table.setItems(list);
			table.getColumns().addAll(vehicleIdColumn,brandColumn,
					modelColumn,plateNumberColumn,infoColumn,deleteColumn);	

			
			return table;
		}
		
}