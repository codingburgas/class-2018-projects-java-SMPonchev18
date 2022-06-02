package repositories;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.User;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;

//DESKTOP-9QDD8UG
//SCHOOL: SD2309
public class UserRepository {
	private String url = "jdbc:sqlserver://DESKTOP-9QDD8UG\\SQLExpress;encrypt=false;databaseName=Parkinglot;integratedSecurity=true";
	private Connection conn;

	public UserRepository() throws SQLException {

		System.out.println("Connecting...");
		conn = DriverManager.getConnection(url);
		System.out.println("Connected!");

	}

	public void CloseConnection() throws SQLException {
		conn.close();
	}

	public void ShowUsers() throws SQLException {
		String query1 = "SELECT * FROM [User]";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %s %s %s %s %d", rs.getInt("UserId"), rs.getString("FirstName"),
					rs.getString("LastName"), rs.getString("Email"), rs.getString("Email"), rs.getString("Username"),
					rs.getString("Password"), rs.getInt("Role"));
			System.out.println(cstFmt);
		}
	}

	public void insertUser(String firstName, String lastName, String email, String username, String password, int role,
			int parkingId) throws SQLException {
		String query1 = "INSERT INTO [User](FirstName,LastName,Email,Username,Password,Role,ParkingId) "
				+ "VALUES(?,?,?,?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setString(1, firstName);
		stmt.setString(2, lastName);
		stmt.setString(3, email);
		stmt.setString(4, username);
		stmt.setString(5, password);
		stmt.setInt(6, role);
		stmt.setInt(7, parkingId);

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));
	}

	// shows first name of the customer by id
	public void showUserById(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "SELECT * FROM [User] " + "WHERE UserId = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %s %s", rs.getInt("UserId"), rs.getString("FirstName"),
					rs.getString("LastName"), rs.getString("Email"), rs.getString("Username"), rs.getInt("Role"),
					rs.getInt("ParkingId"));

			System.out.println(cstFmt);
		}
	}

// Updates the customers first name by id
	public void updateUser(int id, String Fname, String Lname) throws SQLException {
		String query1 = "UPDATE [User] " + "SET FirstName = ?, LastName = ? " + "WHERE UserId = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setString(1, Fname);
		stmt.setString(2, Lname);
		stmt.setInt(3, id);

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));
	}

	public void deleteUser(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "DELETE FROM [User] " + "WHERE UserId = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setInt(1, id);

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));

	}

	public List<User> getUser() throws SQLException {

		List<User> customers = new ArrayList<User>();
		String query1 = "SELECT TOP 9 * FROM [User]";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %s %d %d", rs.getInt("UserId"), rs.getString("FirstName"),
					rs.getString("LastName"), rs.getString("Email"), rs.getInt("Role"), rs.getInt("ParkingId"));
			System.out.println(cstFmt);
		}
		return customers;
	}

	public List<User> getUsers() {
// TODO Auto-generated method stub
		return null;
	}
}