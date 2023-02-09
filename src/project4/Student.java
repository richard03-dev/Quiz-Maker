package project4;

import java.util.*;

public class Student extends Person {
	
	private String name;
	private String password;
		
	public Student(String name, String password) {
		super(name, password);
	}
	
	public String toString(Quiz quiz) {
		String results = "";
		
		return results;
	}

	public String toFile() {
		
		return "" + name + "," + password + ",n";
	}
	
	//toString for correct responses from student
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What course are you trying to take a quiz in?");
		String course = scan.nextLine();
		System.out.println("What quiz would you like to take?");
		String quiz = scan.nextLine(); 
		
		
		
	}

}
