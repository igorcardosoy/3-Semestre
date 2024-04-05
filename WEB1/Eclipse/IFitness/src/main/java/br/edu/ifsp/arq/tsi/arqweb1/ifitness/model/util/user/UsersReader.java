package br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.util.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.User;

public final class UsersReader {

	public static final String PATH = "C:\\Users\\igorf\\OneDrive - ifsp.edu.br\\TSI\\3 - Semestre\\WEB1\\Eclipse\\IFitness\\src\\main\\webapp\\database\\users.json";

	private UsersReader() {}

	public static List<User> read() {
		List<User> users = null;
		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();

		try (var buffer = new BufferedReader(new FileReader(PATH))) {

			TypeToken<List<User>> type = new TypeToken<List<User>>() {};
			users = gson.fromJson(buffer, type);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return users;
	}

}
