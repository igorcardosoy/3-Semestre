package br.edu.ifsp.arq.arqweb1.conteudo5.model;

import java.util.LinkedList;
import java.util.List;

public class PersonUtil {
	
	public static List<Person> getPersons(String persons){
		
		List<Person> personList = new LinkedList<>();
		
		if(persons.length() > 0) {
			String[] lines = persons.split("\n");
			
			for (String line : lines) {
				String[] data = line.split("\\s*;\\s*");
				
				if (data.length == 3) {
					personList.add(new Person(data[0], data[1], data[2]));
				}
				
			}
		}
		
		return personList;
	}

}
