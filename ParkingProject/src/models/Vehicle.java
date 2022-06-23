package models;

import controllers.Session;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import views.IndexView;

public class Vehicle {
	//data to display
	private String category;
	private String plateNumber;
	private int age;
	private int vehicleId;
	private String brand;
	private String model;
	private String info;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	public Vehicle(String category, String plateNumber, int age, int vehicleId, String brand, String model,
			String info) {
		this.category = category;
		this.plateNumber = plateNumber;
		this.age = age;
		this.vehicleId = vehicleId;
		this.brand = brand;
		this.model = model;
		this.info = info;
	}
	@Override
	public String toString() {
		return "Vehicle [category=" + category + ", plateNumber=" + plateNumber + ", age=" + age + ", vehicleId="
				+ vehicleId + ", brand=" + brand + ", model=" + model + ", info=" + info + "]";
	}

	
}
