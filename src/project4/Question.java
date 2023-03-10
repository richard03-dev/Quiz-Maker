package project4;

public class Question {
	
	private String questionText;
	private Choices[] choice;
		
	public Question(String questionText, Choices[] choice) {
		this.questionText = questionText;
		this.choice = choice;
	}
	
	public String getQuestionText() {
		return this.questionText;
	}
	
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	public Choices[] getText() {
		return this.choice;
	}
	
	public void setText(Choices[] choice) {
		this.choice = choice;
	}
	
	public String toString() {
		String question = "";
		question = this.getQuestionText() + "\n";
		for (int i = 0; i < choice.length; i++) {
			question += choice[i].toString() + "\n";
		}
		return question;
	}
	
	public boolean checkQuestion(Choices response) {
		for (int i = 0; i < choice.length; i++) {
			if (choice[i].isCorrect()) {
				if (choice[i].getLetter().equals(response.getLetter())) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

}
