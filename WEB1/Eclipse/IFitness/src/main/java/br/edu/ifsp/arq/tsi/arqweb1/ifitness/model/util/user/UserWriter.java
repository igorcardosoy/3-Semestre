package br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.util.user;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.User;

public final class UserWriter {

	private UserWriter() {

	}

	public static final Boolean write(User user) {
		List<User> users = UsersReader.read();
		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
		String path = UsersReader.PATH;

		if (users == null) {
			users = new ArrayList<User>();
			user.setId(1L);
		} else {
			for (User u : users) {
				if (u.getEmail().equals(user.getEmail())) {
					return false;
				}
			}
			
			user.setId(users.get(users.size() - 1).getId() + 1L);
		}

		users.add(user);
		
		String json = gson.toJson(users);
		
		try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(json);
            fileWriter.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
		
		return true;
		
	}
}
