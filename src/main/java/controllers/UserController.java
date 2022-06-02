package controllers;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import repositories.UserRepository;

public class UserController {

	public void optionMenu() throws SQLException {
		UserRepository dataBase = new UserRepository();

		Scanner x = new Scanner(System.in);

		while (true) {
			System.out.println("\r\nWelcome!");
			System.out.println("1. Customers");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");

			try {
				int choice = x.nextInt();
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
			System.out.println("1. Show user's  details");
			System.out.println("9. Return to main menu");
			System.out.print("Enter your choice: ");

			try {
				int choice = x.nextInt();
				switch (choice) {
				case 1:
					dataBase.ShowUsers();

					break;
				case 2:
					// dataBase.UpdateUser();
					break;
				case 3:
					// dataBase.InsertUser();
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