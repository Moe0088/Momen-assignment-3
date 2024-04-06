package com.coderscampus.assignment3;

import java.io.IOException;
import java.util.Scanner;

public class RunnableApplication {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		FileService fileService = new FileService();
		User user = User();
		fileService.readFile();

		int attempts = 0;
		boolean found = false;
		while (!found) {
			System.out.println("Enter username: ");
			String usernameInput = scanner.nextLine().toLowerCase();
			System.out.println("Enter password: ");
			String passwordInput = scanner.nextLine();

			if (user.getUsername().equalsIgnoreCase(usernameInput) && (user.getPassword().equals(passwordInput))) {

				System.out.println("Welcome, " + user.getName() + "!");
				found = true;

			} else if ((user.getUsername() != usernameInput) && (user.getPassword() != passwordInput)) {

				System.out.println("Invalid login, please try again");
				attempts++;

			}

			{

				if (attempts == 5) {
					System.out.println("Too many failed login attempts, you are now locked out.");

					break;
				}

			}

		}

		scanner.close();

	}

	private static User User() {

		return new User("username", "password", "name");
	}
}
