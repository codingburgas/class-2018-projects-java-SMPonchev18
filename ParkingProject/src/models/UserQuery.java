package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controllers.Session;



public class UserQuery {

	public static boolean isUserInDataBase(String username,Connection conn) {
		System.out.println("     isUserInDataBase()");
		String user="";
		try {
			
			String query="SELECT username FROM Users WHERE username=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				user=rs.getString(1);
			}
			if(user.equals(username)) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when validating username");
		}
		
		return false;
	}
	
	public static void updateVehicle(String plateNumber,String category,String brand,String model,String info,String age,Connection conn) {
		try {
			String query="UPDATE Vehicles "
					+ "SET parkingId=? , age=? , category=? , brand=? , model=? , info=? "
					+ "WHERE plateNumber=? ";
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setInt(1, getParkingIdByParkingName(Session.parkingName, conn));
			ps.setInt(2, Integer.parseInt(age));
			ps.setString(3, category);
			ps.setString(4, brand);
			ps.setString(5, model);
			ps.setString(6, info);
			ps.setString(7, plateNumber);
			int rows=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isPlateInDataBase(String plateNum,Connection conn) {
		String plate="";
		try {
			
			String query="SELECT plateNumber FROM Vehicles WHERE plateNumber=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, plateNum);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				plate=rs.getString(1);
			}
			if(plate.equals(plateNum)) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when validating username");
		}
		
		return false;
	}
	
	public static String insertVehicle(String category,String brand,
			String model,String plateNumber, String info, int age, Connection conn) {
		try {
			
			String query="INSERT INTO Vehicles(age, category, plateNumber, brand, model, info, parkingId) "
					+ "VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, age);
			ps.setString(2, category);
			ps.setString(3, plateNumber);
			ps.setString(4, brand);
			ps.setString(5, model);
			ps.setString(6, info);
			ps.setInt(7, getParkingIdByParkingName(Session.parkingName, conn));
			int rows=ps.executeUpdate();
			return plateNumber;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void insertUser(String username, String password, String firstName,
			String lastName, String phone,String address,Connection conn) {
		try { 
			String query="EXEC insertUser @username=? , @password=? "
					+ ", @FirstName=? , @LastName=? , @phone=? , @Address=?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, phone);
			ps.setString(6, address);


			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when validating password");
		}
		
	}
	
	
	public static int getUserIdByUsername(String username,Connection conn) {
		try {
			System.out.println("	 getUserIdFromUsername");
			String query="SELECT userId FROM Users WHERE username=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			
			int id=0;
			while(rs.next()) {
				id=rs.getInt("userId");
			}
			
			
			
			return id;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when validating username");
		}
		return 0;
	}
	
	public static int getParkingIdByParkingName(String parkingName,Connection conn) {
		try { 
			
			String query="SELECT parkingId FROM Parkings WHERE name=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, parkingName);
			ResultSet rs=ps.executeQuery();
			
			
			int id=0;
			while(rs.next()) {
				id=rs.getInt(1);
			}
			System.out.println("ParkingName: "+parkingName);
			System.out.println("ParkingId: "+id);
			return id;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when getting ParkingId");
			return 0;
		}
	}
	
	
	public static String getFirstNameByUsername(String username,Connection conn) {
		try { 
			String query="SELECT FirstName FROM USERS WHERE username=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			String name="";
			while(rs.next()) {
				name=rs.getString(1);
			}
			return name;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when getting firstName");
			return "";
		}
	}
	
	public static int getParkingIdByUserId(int userId,Connection conn) {
		String query="SELECT parkingId FROM SecurityGuards WHERE userId=?";
		
		try { 
			
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			
			int parkingId=0;
			while(rs.next()) {
				parkingId=rs.getInt("parkingId");
			}
			return parkingId;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when getting parkingId");
			
		}
		
		return 0;
	}
	public static String getParkingNameByUsername(String username,Connection conn) {
		
		int parkingId=getParkingIdByUserId(getUserIdByUsername(username,conn), conn);
		
		
		String query="SELECT name FROM Parkings WHERE parkingId=?";
		
		try { 
			
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, parkingId);
			ResultSet rs=ps.executeQuery();
			
			String parkingName="";
			while(rs.next()) {
				parkingName=rs.getNString("name");
			}
			
			return parkingName;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when getting ParkingName");
			
		}
		
		
		
		return "";
	}
	
	
	
	public static int getUserIdByVehicletId(int vehicleId,Connection conn) {
		String query="SELECT userId FROM Vehicles WHERE vehicleId=?";
try { 
			
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, vehicleId);
			ResultSet rs=ps.executeQuery();
			
			int userId=0;
			while(rs.next()) {
				userId=rs.getInt("userId");
			}
			return userId;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when getting userId");
			
		}
return 0;
		
	}
}

