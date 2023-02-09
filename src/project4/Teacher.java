package project4;

import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends Person{
    String name;
    public Teacher(String name, String password) {
        super(name, password);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        int finalInput;
        do {
            System.out.println("1 - Create a Quiz \n2 - Edit a Quiz");
            int teacherInput = scan.nextInt();
            scan.nextLine();
            ArrayList<Quiz> totalQuiz = new ArrayList<>();
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
                        System.out.println("Please enter the number of desired multiple choice for this question");
                        mcqQuan = scan.nextInt();
                        Choices[] choices = new Choices[mcqQuan];
                        System.out.println("Please enter the question");
                        quiz[i].setQuestionText(scan.nextLine());
                        for (int j = 0; j < mcqQuan; j++) {
                            System.out.println("Please enter the letter of the prompt");
                            String letter = scan.nextLine();
                            System.out.println("Please enter a multiple choice prompt");
                            String prompt = scan.nextLine();
                            System.out.println("Is this answer true or false");
                            boolean answer = scan.hasNextBoolean();
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
    }
}
