package models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import controllers.Session;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateVehicleModel {

	private String category;
	private String brand;
	private String model;
	private String plateNumber;
	private String info;
	private String age;
	private Connection conn;



	public UpdateVehicleModel(String category, String brand, String model, String plateNumber, String info, String age) {
		this.category = category;
		this.brand = brand;
		this.model = model;
		this.plateNumber = plateNumber;
		this.info = info;
		this.age = age;
		this.conn = createConnection();
	}

	private Connection createConnection() {
		try {

Path currentDir = Paths.get("ParkingProject");
			
			//change data in config.properties to run in the right db
			String pathToConfig=currentDir.toAbsolutePath()+"\\src\\resources\\config.properties";

			InputStream input = new FileInputStream(pathToConfig);

			Properties prop = new Properties();

			prop.load(input);

			String dbName = prop.getProperty("db.name");
			String db = prop.getProperty("db");
			String connectionUrl = "jdbc:sqlserver://" + db + ";database=" + dbName + ";integratedSecurity=true ";

			System.out.println("connecting.. " + connectionUrl);
			return DriverManager.getConnection(connectionUrl);

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error with jdbc");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}

		return null;
	}

	public String checkData() {
		Validator v = new Validator();
		if (v.areBlank(new String[] { category, brand, model, plateNumber, info, age })) {
			return "Enter data";
		}
		if(!v.isAgeTypedCorrectly(age)) {
			return "Age is in incorrect format";
		}
		conn = createConnection();
		if (!UserQuery.isPlateInDataBase(plateNumber, conn)) {
			return "no vehicle with this plate num";
		}
		
		UserQuery.updateVehicle(plateNumber,category,brand,model,info,age,conn);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Successfully update a vehicle with plate num: "+plateNumber;
	}
	
}