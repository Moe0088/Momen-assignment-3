package com.coderscampus.assignment3;

import java.io.IOException;
import java.util.Scanner;

public class RunnableApplication {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		FileService fileService = new FileService();

		User[] users = fileService.readFile();

		int attempts = 0;
		boolean isValid = false;
		

		while (attempts < 5) {

			System.out.println("Enter username: ");
			String usernameInput = scan.nextLine().toLowerCase();
			System.out.println("Enter password: ");
			String passwordInput = scan.nextLine();
			attempts++;
			isValid = validateUser(users, usernameInput, passwordInput);
			

			if (isValid) {
				attempts = 0;
				break;
			}

			if (attempts == 5) {
				System.out.println("Too many failed login attempts, you are now locked out.");
			

			}

		}
		scan.close();

	}

	private static boolean validateUser(User[] users, String usernameInput, String passwordInput) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(usernameInput) && (user.getPassword().equals(passwordInput))) {

				System.out.println("Welcome, " + user.getName() + "!");
				return true;

			}
		}
		System.out.println("Invalid login, please try again");
		return false;

	}
}
