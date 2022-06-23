package models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import controllers.Session;

public class DeleteVehicleModel {

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

	public void deleteVehicleById(int vehicleId) {
		String query = "DELETE FROM Vehicles WHERE vehicleId=?";
		Connection conn = createConnection();
		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement(query);
			ps.setInt(1,vehicleId);
			int rows=ps.executeUpdate();
			System.out.println("Rows deleted : "+rows);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Map<Integer, Vehicle> getVehiclesByParkingId() {

		String query = "SELECT "
				+ " category, "
				+ " plateNumber,"
				+ " age,"
				+ " vehicleId,"
				+ " brand,"
				+ " model, "
				+ " info "
				+ " FROM Vehicles "
				+ " INNER JOIN Parkings ON [name]=? AND Parkings.parkingId=Vehicles.parkingId";
		Map<Integer, Vehicle> vehicles = new HashMap<>();
		try {

			Connection conn = createConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setNString(1, Session.parkingName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("vehicleId");
				vehicles.put(
						id, new Vehicle(
						rs.getNString("category"),
						rs.getNString("plateNumber"),
						rs.getInt("age"),
						id,
						rs.getNString("brand"),
						rs.getNString("model"),
						rs.getNString("info")));
			}
			return vehicles;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
