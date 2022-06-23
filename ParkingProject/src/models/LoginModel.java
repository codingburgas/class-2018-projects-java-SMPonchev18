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


import controllers.Session;

public class LoginModel {

	private String username;
	private String password;
	private Connection conn;
	public LoginModel(String username,String password) {
		this.password=password;
		this.username=username;
		
		conn=createConnection();
	}
	
	private Connection createConnection() {
		try {
			
Path currentDir = Paths.get("ParkingProject");
			
			//change data in config.properties to run in the right db
			String pathToConfig=currentDir.toAbsolutePath()+"\\src\\resources\\config.properties";
			//System.out.println(pathToConfig);
			
			InputStream input = new FileInputStream(pathToConfig);

			Properties prop = new Properties();
			
			prop.load(input);
			
			String dbName = prop.getProperty("db.name");
			String db=prop.getProperty("db");
			String connectionUrl = "jdbc:sqlserver://"+db+";database=" + dbName+
					";integratedSecurity=true ";

			System.out.println("connecting.. ");
			System.out.println(connectionUrl);
			return  DriverManager.getConnection(connectionUrl);

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error with jdbc");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
		
		return null;
	}

	public String checkData() throws SQLException {
		
		if(username.isBlank()||password.isBlank()) {
			return "Wrong data";
		}
		
		if(UserQuery.isUserInDataBase(username,conn)) {
			if(isPasswordCorrect()) {
				System.out.println("Data is correct. Successful Login");
				
				Session.isLoggedIn=true;
				Session.name=UserQuery.getFirstNameByUsername(username, conn);	
				
				
				Session.parkingName=UserQuery.getParkingNameByUsername(username,conn);
				
				
				System.out.println("Logged in: "+Session.isLoggedIn);
				System.out.println("Vehicle name: "+Session.name);
				System.out.println("Parking Name: "+Session.parkingName);
				
				
				
				conn.close();
				return "all good";
			}
		}
		
		
		return "Not a user";
	}
	
	
	private boolean isPasswordCorrect() {
		String pass="";
		try { 
			String query="EXEC CheckUserPassword @username=? ";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				pass=rs.getNString(1);
			}
			
			if(pass.equals(password)) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when validating password");
		}
		
		return false;
	}
	

}

