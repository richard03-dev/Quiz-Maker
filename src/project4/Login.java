package project4;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Login {

	private static String filename;

	public Login(String filename) throws IOException{
		Info.setUserAndPass(readPassFile(filename));
		this.filename = filename;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		Login login = new Login("logins.txt");

		runLogin(in);

		/*
		System.out.println("Usernames and Passwords:");
		System.out.println(userAndPass);
		System.out.println(createLogin("Aaron", "123"));
		System.out.println(createLogin("Aaron", "12"));
		System.out.println(checkLogin("Aaron", "123"));
		*/
		writePassFile(filename);
		int finalInput;
		ArrayList<Quiz> totalQuiz = new ArrayList<>();
        do {
            System.out.println("1 - Create a Quiz \n2 - Edit a Quiz");
            int teacherInput = scan.nextInt();
            scan.nextLine();
            if (teacherInput == 1) {
                System.out.println("How Many Quizzes Would you like to create?");
                int numQuiz = scan.nextInt();
                scan.nextLine();
                for (int x = 0; x < numQuiz; x++) {
                    System.out.println("Please enter the course name");
                    String course = scan.nextLine();
                    System.out.println("Please enter the name of the Quiz");
                    String quizName = scan.nextLine();
                    System.out.println("Please enter the number of questions");
                    int questNum = scan.nextInt();
                    scan.nextLine();
                    Question[] quiz = new Question[questNum];
                    int mcqQuan = 0;
                    for (int i = 0; i < questNum; i++) {
                        System.out.println("Please enter the number of multiple choice answers for Question " + (i + 1));
                        mcqQuan = scan.nextInt();
                        scan.nextLine();
                        Choices[] choices = new Choices[mcqQuan];
                        quiz[i] = new Question("", choices);
                        System.out.println("Please enter the question");
                        quiz[i].setQuestionText(scan.nextLine());
                        for (int j = 0; j < mcqQuan; j++) {
                            System.out.println("Please enter the letter of the prompt for choice " + (j + 1));
                            String letter = scan.nextLine();
                            System.out.println("Please enter a multiple choice promp tfor choice " + (j + 1));
                            String prompt = scan.nextLine();
                            System.out.println("Is this answer correct?\n1. Yes\n2. No");
                            int correct = scan.nextInt();
                            scan.nextLine();
                            boolean answer = false;
                            if (correct == 1) {
                            	answer = true;
                            }
                            
                            choices[j] = new Choices(letter, prompt, answer);
                        }
                        quiz[i].setText(choices);
                    }
                    totalQuiz.add(new Quiz(quizName, course, questNum, mcqQuan, quiz));
                }
            } else if (teacherInput == 2) {
                String editResponse;
                do {
                    System.out.println("Please enter the name of the quiz you would like to edit: ");
                    String nameQuiz = scan.nextLine();
                    for (Quiz quiz : totalQuiz) {
                        if (nameQuiz.equals(quiz)) {
                            System.out.println("Which part of the exam would you like to change? ");
                            //String quizNum, String course, int numQuestions, int mcqOption, String[][] quiz
                            System.out.println("1. Quiz Name \n2. Course \n3. Question \n4. Multiple Choice Responses");
                            String userSelect = scan.nextLine();
                            switch (userSelect) {
                                case "1" -> {
                                    System.out.println("New name for the quiz: ");
                                    String newName = scan.nextLine();
                                    quiz.setQuizNum(newName);
                                }
                                case "2" -> {
                                    System.out.println("New name for the course: ");
                                    String newCourse = scan.nextLine();
                                    quiz.setCourse(newCourse);
                                }
                                case "3" -> {
                                    System.out.println("What question number do you want to change: ");
                                    int questionNum = scan.nextInt();
                                    scan.nextLine();
                                    System.out.println("What do you want to change the question to");
                                    String newResponse = scan.nextLine();
                                    Question[] finalQuiz = quiz.getQuizzes();
                                    finalQuiz[questionNum].setQuestionText(newResponse);
                                }
                                case "4" -> {
                                    System.out.println("What question number do you want to change: ");
                                    int questionNum = scan.nextInt();
                                    scan.nextLine();
                                    System.out.println("What multiple choice option would you like to change");
                                    int mcqOption = scan.nextInt();
                                    scan.nextLine();
                                    System.out.println("What would you like the new response to be");
                                    String newResponse = scan.nextLine();
                                    Question[] finalQuiz = quiz.getQuizzes();
                                    Choices[] choices = finalQuiz[questionNum].getText();
                                    choices[mcqOption].setText(newResponse);
                                }
                                default -> System.out.println("Please enter a valid number");
                            }
                        }
                    }
                    System.out.println("Would you like to edit another quiz \n 1-Yes \n 2-No");
                    editResponse = scan.nextLine();
                } while (editResponse.equals("1"));
            }
                System.out.println("Would you like to add or edit another quiz \n 1-Yes \n 2-No");
                finalInput = scan.nextInt();
        } while (finalInput == 1);
        
        do {
        	System.out.println("What course are you trying to take a quiz in?");
    		String course = scan.nextLine();
    		System.out.println("What quiz would you like to take?");
    		String quiz = scan.nextLine();
    		ArrayList<Choices> studentResponses = new ArrayList<Choices>(); 
    		for (int i = 0; i < totalQuiz.size(); i++) {
    			if (totalQuiz.get(i).getCourse().equals(course) 
    					&& totalQuiz.get(i).getQuizNum().equals(quiz)) {
    				studentResponses = totalQuiz.get(i).quizList(scan);
    				totalQuiz.get(i).toString(studentResponses);
    			}
    		}
    		System.out.println("Quiz done");
    		System.out.println("Would you like to take another quiz \n 1-Yes \n 2-No");
            finalInput = scan.nextInt();
        } while (finalInput == 1);
	}
	
	

	public static void runLogin(Scanner in) {

		do {
			System.out.println("----------------------------------");
			System.out.println("1. Login\n2. Signup\n3. Quit");
			
			int choice = in.nextInt();
			in.nextLine();

			if (choice == 1) {
				loginMenu(in);
				break;
			} else if (choice == 2) {
				signupMenu(in);
			} else if (choice == 3) {
				break;
			}
		} while (true);
	}

	public static void loginMenu(Scanner in) {
		do {
			System.out.println("----------------------------------\n");
			System.out.println("Enter Username: ");
			String username = in.nextLine();
			System.out.println("Enter Password: ");
			String password = in.nextLine();

			if (checkLogin(username, password)) {
				break;
			}
			System.out.println("Username and Password do not match");
		} while (true);
	}

	public static void signupMenu(Scanner in) {
		do {
			System.out.println("----------------------------------\n");
			System.out.println("Enter Username: ");
			String username = in.nextLine();
			System.out.println("Enter Password: ");
			String password = in.nextLine();
			String teacherOrStudent;
			do {
				System.out.println("Are you a Teacher? y/n");
				teacherOrStudent = in.nextLine();

				if(teacherOrStudent.equalsIgnoreCase("y") || teacherOrStudent.equalsIgnoreCase("n"))
					break;
				System.out.println("Please enter a valid answer");
			} while (true);

			if (createLogin(username, password, teacherOrStudent)) {
				System.out.println("Account Created");
				break;
			}
			System.out.println("Username Taken");
		} while (true);
	}

	public static boolean createLogin(String username, String password, String teacher) {
		if (Info.getUserAndPass().get(username) != null && username != null) {
			return false;
		}
			
		if (teacher.equalsIgnoreCase("y")) {
			Teacher teach = new Teacher(username, password);
			Info.addPerson(teach);
			Info.getUserAndPass().put(username, teach);
		}
		if (teacher.equalsIgnoreCase("n")) {
			Student stu = new Student(username, password);
			Info.addPerson(stu);
			Info.getUserAndPass().put(username, stu);
		}
		return true;
	}

	public static boolean checkLogin(String username, String password) {
		return password.equals(Info.getUserAndPass().get(username));
	}

	public static void writePassFile(String file) throws IOException {

		// Creates a BufferedWriter
		BufferedWriter output = new BufferedWriter(new FileWriter(file));

		for (String name: Info.getUserAndPass().keySet()) {
		    output.write(name.toString() + "," + Info.getUserAndPass().get(name).toString() + "\n");
		}
		output.flush();
		output.close();
	}

	public static HashMap<String, Person> readPassFile(String file) throws IOException {
		try {
			Path userAndPassFile = Path.of(file);
			String[] userAndPassArray = Files.readString(userAndPassFile).replace("\r", "").split("\n");

			HashMap<String, Person> userAndPass = new HashMap<String, Person>();

			for (int j = 0; j < userAndPassArray.length; j++) {
				String[] temp = userAndPassArray[j].trim().split(",");
				if(temp[3].equalsIgnoreCase("y")) {
					Teacher tempTeach = new Teacher(temp[0], temp[1]);
					userAndPass.put(temp[0], tempTeach);
				} else if(temp[3].equalsIgnoreCase("n")) {
					Student tempTeach = new Student(temp[0], temp[1]);
					userAndPass.put(temp[0], tempTeach);
				}
			}
			return userAndPass;
		} catch (Exception e) {
			System.out.println("No File found. Creating new file with file name: " + file);
			File output = new File(file);
			return new HashMap<String, Person>();
		}
	}
}