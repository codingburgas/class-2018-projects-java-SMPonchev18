package controllers;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

//import jdk.internal.misc.FileSystemOption;
import models.User;
import repositories.UserRepository;

public class UserController {

	public void optionMenu() throws SQLException {
		UserRepository dataBase = new UserRepository();
		User user;
		Scanner x = new Scanner(System.in);

		while (true) {

			System.out.print("Please enter your username:");
			String username = x.nextLine();
			System.out.print("Please enter your password:");
			String pass = x.nextLine();

			user = dataBase.login(username, pass);

			System.out.println("\r\nWelcome!");
			System.out.println("1. Customers");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");

			try {
				int choice = Integer.parseInt(x.nextLine());
				switch (choice) {
					case 1:
						subMenu(dataBase, x);
						break;
					case 9:
						System.exit(0);
						break;
					default:
						System.out.println("Wrong input! Please enter valid value\r\n");
						break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Enter a numerical value!");
				x.nextLine();
			}
		}
	}

	void subMenu(UserRepository dataBase, Scanner x) throws SQLException {

		while (true) {
			System.out.println("\r\nShow info menu");
			System.out.println("1. Show user's details");
			System.out.println("2. Register user");
			System.out.println("3. Delete user by Id");

			System.out.println("9. Return to main menu");
			System.out.print("Enter your choice: ");

			try {
				int choice = Integer.parseInt(x.nextLine());

				switch (choice) {
					case 1:
						dataBase.ShowUsers();

						break;
					case 2:
						System.out.print("First Name -> ");
						String firstName = x.nextLine();
						System.out.print("LastName -> ");
						String lastName = x.nextLine();
						System.out.print("Email -> ");
						String email = x.nextLine();
						System.out.print("Username -> ");
						String username = x.nextLine();
						System.out.print("Password -> ");
						String password = x.nextLine();
						System.out.print("Role -> ");
						int role = Integer.parseInt(x.nextLine());
						System.out.print("Parking Id -> ");
						int parkingId = Integer.parseInt(x.nextLine());

						dataBase.insertUser(firstName, lastName, email, username, password, role, parkingId);
						break;
					case 3:

						String userName = x.nextLine();
						User deleteUser = dataBase.selectUser(userName);
						dataBase.deleteUser(Integer.parseInt(deleteUser.getUserId()));
						break;
					case 4:

						// dataBase.updateUser();
						break;

					case 9:
						return;

					default:
						System.out.println("Wrong input! Please enter valid value\r\n");
						break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter a numerical value!");
				x.nextLine();
			}
		}
	}

}