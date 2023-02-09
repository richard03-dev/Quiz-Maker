package project4;

import java.util.ArrayList;
import java.util.*;

public class Quiz {
    String quizNum;
    String course;
    int numQuestions;
    int mcqOption;
    Question[] quizzes;

    public Quiz(String quizNum, String course, int numQuestions, int mcqOption, Question[] quizzes) {
        this.quizNum = quizNum;
        this.course = course;
        this.numQuestions = numQuestions;
        this.mcqOption = mcqOption;
        this.quizzes = quizzes;

    }

    public String getQuizNum() {
        return quizNum;
    }

    public void setQuizNum(String quizNum) {
        this.quizNum = quizNum;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    public int getMcqOption() {
        return mcqOption;
    }

    public void setMcqOption(int mcqOption) {
        this.mcqOption = mcqOption;
    }

    public Question[] getQuizzes() {
        return quizzes;
    }

    public void setQuestion(Question[] quizzes) {
        this.quizzes = quizzes;
    }
    
    public ArrayList<Choices> quizList(Scanner scan) {
    	Question[] finalQuiz = getQuizzes();
    	ArrayList<Choices> responses = new ArrayList<Choices>();
        String output = "";
        for (int i = 0; i < numQuestions; i++) {
        	System.out.println("Please select an answer");
        	finalQuiz[i].toString();
            output = output + "Question: " + finalQuiz[i].getQuestionText() + "\n";
            System.out.println(output);
            String response = scan.nextLine();
            for (int j = 0; j < finalQuiz[i].getText().length; j++) {
            	 if (finalQuiz[i].getText()[j].getLetter().equalsIgnoreCase(response)) {
                 	responses.add(finalQuiz[i].getText()[j]);
                 }
            }
           
        }
        return responses;
    }
    
    public String toString(ArrayList<Choices> studentResponses) {
    	String output = "";
    	int counter = 0;
    	int total = studentResponses.size();
    	for (int i = 0; i < studentResponses.size(); i++) {
    		if(studentResponses.get(i).isCorrect()) {
    			counter++;
    		}
    	}
    	double answer = ((counter * 1.0) / (total * 1.0)) * 100;
		double answer2 = Math.round(answer);
		int score = (int)answer2;
    	output += "You got " + counter + "/" + total + " correct.\n";
    	output += "Your score is " + score + ";";
    	return output;
    }
    
    /*public String toString() {
        Question[] finalQuiz = getQuizzes();
        String output = "";
        for (int i = 0; i < numQuestions; i++) {
            output = output + "Question: " + finalQuiz[i].getQuestionText() + "\n";
            for (int j = 0; j < mcqOption; j++) {
                output = finalQuiz[i].getText()[j] + "\n";
                }
            }
        return output;
    }*/
}