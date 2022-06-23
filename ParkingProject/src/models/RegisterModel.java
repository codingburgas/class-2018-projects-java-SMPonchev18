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
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controllers.Session;

public class RegisterModel {

	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String confirmPassword;
	private String phone;
	private String parkingName;
	private Connection conn;
	
	public RegisterModel(String username, String password, String firstName, String lastName, String address,
			String confirmPassword, String phone, String parkingName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.confirmPassword = confirmPassword;
		this.phone = phone;
		this.parkingName = parkingName;
		
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
			String db=prop.getProperty("db");
			String connectionUrl = "jdbc:sqlserver://"+db+";database=" + dbName+
					";integratedSecurity=true ";

			System.out.println("connecting.. "+ connectionUrl);
			return  DriverManager.getConnection(connectionUrl);

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
		Validator v=new Validator();
		if(v.areBlank(new String[] {username,password,confirmPassword,
				firstName,lastName,address,confirmPassword,phone,parkingName})) {
			return "Enter data";
		}

		
		if(!v.validateNumber(phone)) {
			return "Inrecognisable pattern for phone";
		}
		if(!v.isPasswordOk(password,confirmPassword)) {
			return "Password is too small/not equal to confirm password";
		}
		conn=createConnection();
		if(UserQuery.isUserInDataBase(username,conn)) {
			return "The username is already taken";
		}
		
		UserQuery.insertUser(username, password, firstName, lastName, phone, address, conn);
		int userId=UserQuery.getUserIdByUsername(username, conn);
		int parkingId=UserQuery.getParkingIdByParkingName(parkingName, conn);
		
		insertSecurityGuard(userId,parkingId);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "All good";
		
		
	}
	
	private void insertSecurityGuard(int userId,int parkingId) {
		String query="INSERT INTO SecurityGuards(userId,isAuthorised,parkingId) "
				+ "VALUES(?,0,?)";
		
		try { 
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, userId);
			ps.setInt(2, parkingId);
			int rows = ps.executeUpdate();

			System.out.println("Affected Arows: " + rows);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when validating password");
		}
	}	
	

}