package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	public User[] readFile() throws IOException {
		BufferedReader fileReader = null;

		User[] users = new User[4];

		int i = 0;

		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			String line;
			while ((line = fileReader.readLine()) != null) {

				String[] parts = line.split(",");
				String username = parts[0];
				String password = parts[1];
				String name = parts[2];
				User user = new User(username, password, name);
				users[i] = user;
				i++;

			}

		} finally {

			fileReader.close();

		}
		return users;

	}

}
