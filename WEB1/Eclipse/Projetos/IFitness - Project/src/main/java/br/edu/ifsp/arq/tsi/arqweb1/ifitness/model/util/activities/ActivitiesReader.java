package br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.util.activities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.Activity;
import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.User;
import br.edu.ifsp.arq.tsi.arqweb1.ifitness.model.util.LocalDateTypeAdapter;

public class ActivitiesReader {

	public static List<Activity> read(){
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(LocalDate.class, 
						new LocalDateTypeAdapter())
				.create();
		List<Activity> activities = null;
		String path = "/media/Documentos/Fernando/ARQWEB1/WorkspaceEclipse/activities.json";
		try {
			File file = new File(path);
			if(file.exists()) {
				BufferedReader buffer = new BufferedReader(
						new FileReader(path));
				TypeToken<List<Activity>> type = 
						new TypeToken<List<Activity>>() {};
				activities = gson.fromJson(buffer, type);
				buffer.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return activities;
	}
	
	public static List<Activity> readByUser(User user){
		List<Activity> activities = read();
		if(activities != null) {
			List<Activity> userActivities = new ArrayList<>();
			for(Activity a: activities) {
				if(a.getUser().getId() == user.getId()) {
					userActivities.add(a);
				}
			}
			return userActivities;
		}
		return null;
	}

	public static Activity findById(Long id) {
		List<Activity> activities = read();
		for(Activity a: activities) {
			if(a.getId() == id) {
				return a;
			}
		}
		return null;
	}
}





