package project4;

import java.util.ArrayList;
import java.util.HashMap;

public class Info {
	private static ArrayList<Person> persons = new ArrayList<Person>();
	private static HashMap<String, Person> userAndPass;


	public static ArrayList<Person> getPersons() {
		return persons;
	}

	public static void addPerson(Person person) {
		persons.add(person);
	}

	public static HashMap<String, Person> getUserAndPass() {
		return userAndPass;
	}

	public static void setUserAndPass(HashMap<String, Person> map) {
		userAndPass = map;
	}
}
