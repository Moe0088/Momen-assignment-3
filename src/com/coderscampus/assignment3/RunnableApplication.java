package com.coderscampus.assignment3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class RunnableApplication {

	public static void main(String[] args) throws IOException {
//		Scanner scanner = new Scanner(System.in);
//		UserService userService = new UserService();
		

		BufferedReader fileReader = new BufferedReader(new FileReader("data.txt"));
		User[] userData = new User[4];
		String line;
		int i = 0;
		while ((line = fileReader.readLine()) != null) {
			String[] parts = line.split(",");
			userData [i++] = new User (parts[0] , parts[1], parts[2]);
			
//			System.out.println(line);

		}

		fileReader.close();

//		String[] input = { "john.doe@mydomain.net", "Hdk398jf!", "John Doe" };
//		User UserInfo = userService.createUser(input);
//		System.out.println("Welcome {insert user's name here}");

	}

}
